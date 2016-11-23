package com.opensymphony.forums.chat;

import com.jivesoftware.base.*;
import com.jivesoftware.forum.Forum;
import com.jivesoftware.forum.ForumFactory;
import com.jivesoftware.forum.ForumThread;
import com.jivesoftware.forum.ForumMessage;
import com.jivesoftware.forum.database.DbForumMessage;
import com.jivesoftware.forum.event.*;
import org.apache.commons.collections.map.HashedMap;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.muc.MultiUserChat;

import java.util.*;
import java.text.SimpleDateFormat;

/**
 * User: patrick
 * Date: Jul 27, 2005
 * Time: 11:36:28 AM
 */
public class ChatMonitor implements MessageListener, ThreadListener {
    private static ChatMonitor monitor = new ChatMonitor();

    XMPPConnection connection = null;
    Map roomUsernames = new HashMap();
    Map mucs = new HashedMap();
    Map msgQueue = new HashMap();
    Map transcriptLog = new HashMap();
    Map transcriptLogDates = new HashMap();
    Map transcriptLogActivityDates = new HashMap();

    public static ChatMonitor getMonitor() {
        return monitor;
    }

    public ChatMonitor() {
        loginIfRequired();
        Thread monitor = new Thread(new MonitorRunnable());
        monitor.setDaemon(true);
        monitor.start();

        Thread persist = new Thread(new TranscriptPersister());
        persist.setDaemon(true);
        persist.start();

        MessageEventDispatcher.getInstance().addListener(this);
        ThreadEventDispatcher.getInstance().addListener(this);
    }

    private void loginIfRequired() {
        try {
            if (connection == null || !connection.isConnected() || !connection.isAuthenticated()) {
                String server = JiveGlobals.getJiveProperty("chat.server");
                connection = new XMPPConnection(server);
                connection.login(getUserName(), getPassword());
            }
        } catch (XMPPException e) {
            e.printStackTrace();
            connection = null;
            mucs.clear();
            roomUsernames.clear();
        }
    }

    public void messageAdded(MessageEvent event) {
        ForumMessage message = event.getMessage();

        // this event is for replies only!
        if (message.getForumThread().getRootMessage().getID() == message.getID()) {
            return;
        }

        Forum forum = message.getForum();
        String chatroom = forum.getProperty("chatroom");
        if (chatroom != null) {
            String msg = "New reply by " + getFrom(message) + ": " + message.getSubject();
            msg = msg + " (" + JiveGlobals.getJiveProperty("jiveURL") + "/thread.jspa?messageID=" + message.getID() + ")";
            addMessage(chatroom, msg);
        }
    }

    private String getFrom(ForumMessage message) {
        User user = message.getUser();
        if (user == null) {
            return message.getProperty(DbForumMessage.PROP_EMAIL);
        } else {
            return user.getName();
        }
    }

    public void messageDeleted(MessageEvent event) {
    }

    public void messageMoved(MessageEvent event) {
    }

    public void messageModified(MessageEvent event) {
    }

    public void messageModerationModified(MessageEvent event) {
    }

    public void messageRated(MessageEvent event) {
    }

    public void threadAdded(ThreadEvent event) {
        ForumThread thread = event.getThread();
        Forum forum = thread.getForum();
        String chatroom = forum.getProperty("chatroom");
        if (chatroom != null) {
            ForumMessage message = thread.getRootMessage();
            if (getUserName().equals(message.getUser().getUsername())) {
                return;
            }

            String msg = "New thread by " + getFrom(message) + ": " + thread.getRootMessage().getSubject();
            msg = msg + " (" + JiveGlobals.getJiveProperty("jiveURL") + "/thread.jspa?threadID=" + thread.getID() + ")";
            addMessage(chatroom, msg);
        }
    }

    private void addMessage(String chatroom, String msg) {
        List queue = getMessageQueue(chatroom);
        synchronized (queue) {
            queue.add(msg);
        }
    }

    public void threadDeleted(ThreadEvent event) {
    }

    public void threadMoved(ThreadEvent event) {
    }

    public void threadModerationModified(ThreadEvent event) {
    }

    public void threadRated(ThreadEvent event) {
    }

    private String getPassword() {
        return JiveGlobals.getJiveProperty("chat.password", "admin");
    }

    private String getUserName() {
        return JiveGlobals.getJiveProperty("chat.username", "admin");
    }

    private AuthToken getAuthFactory() {
        try {
            return AuthFactory.getAuthToken(getUserName(), getPassword());
        } catch (UnauthorizedException e) {
            throw new RuntimeException("Could not authenticate with jive properties chat.username and chat.password", e);
        }
    }

    public List getUsersInRoom(String chatroom) {
        ForumFactory ff = getForumFactory();
        List usernames;

        synchronized (roomUsernames) {
            usernames = (List) roomUsernames.get(chatroom);
        }

        if (usernames == null) {
            return Collections.EMPTY_LIST;
        }

        List users = new ArrayList(usernames.size());

        for (Iterator iterator = usernames.iterator(); iterator.hasNext();) {
            String username = (String) iterator.next();
            if (username.equals(getUserName())) {
                continue;
            }

            users.add(username);
        }

        return users;
    }

    private List getMessageQueue(String chatroom) {
        List queue;
        synchronized (msgQueue) {
            queue = (List) msgQueue.get(chatroom);
            if (queue == null) {
                queue = new ArrayList();
                msgQueue.put(chatroom, queue);
            }
        }
        return queue;
    }

    private ForumFactory getForumFactory() {
        AuthToken authFactory = getAuthFactory();
        try {
            return ForumFactory.getInstance(authFactory);
        } catch (Exception e) {
            throw new RuntimeException("Could not get forum factory", e);
        }
    }

    class MonitorRunnable implements Runnable {
        public void run() {
            while (true) {
                try {
                    loginIfRequired();
                    ForumFactory ff = getForumFactory();
                    for (Iterator iterator = ff.getForums(); iterator.hasNext();) {
                        Forum forum = (Forum) iterator.next();
                        final String chatroom = forum.getProperty("chatroom");
                        if (chatroom != null) {
                            String fullRoom = chatroom + "@conference." + JiveGlobals.getJiveProperty("chat.server");
                            MultiUserChat chat = (MultiUserChat) mucs.get(fullRoom);
                            if (chat == null) {
                                chat = new MultiUserChat(connection, fullRoom);
                                mucs.put(fullRoom, chat);
                            }

                            // join the chatroom, if needed
                            if (!chat.isJoined()) {
                                try {
                                    chat.join(getUserName());

                                } catch (XMPPException e) {
                                    e.printStackTrace();
                                    System.out.println("Couldn't join chat room " + fullRoom + " as " + getUserName());
                                }
                                chat.addMessageListener(new PacketListener() {
                                    public void processPacket(Packet packet) {
                                        Message message = (Message) packet;
                                        String username = StringUtils.parseResource(message.getFrom());

                                        TranscriptMessage tm = new TranscriptMessage(username,
                                                message.getBody(),
                                                new Date());

                                        List log;
                                        synchronized (transcriptLog) {
                                            log = (List) transcriptLog.get(chatroom);
                                            if (log == null) {
                                                log = new ArrayList();
                                                transcriptLog.put(chatroom, log);
                                            }

                                            // update the last activity date
                                            transcriptLogActivityDates.put(chatroom, tm.date);

                                            // if there has never been a transcript log, let's pretend it was "now"
                                            if (!transcriptLogDates.containsKey(chatroom)) {
                                                transcriptLogDates.put(chatroom, tm.date);
                                            }
                                        }

                                        synchronized (log) {
                                            log.add(tm);
                                        }
                                    }
                                });
                            }

                            // get the latest list of usernames
                            ArrayList usernames = new ArrayList();
                            for (Iterator iterator1 = chat.getOccupants(); iterator1.hasNext();) {
                                String occupant = (String) iterator1.next();
                                String username = StringUtils.parseResource(occupant);
                                usernames.add(username);
                            }

                            synchronized (roomUsernames) {
                                roomUsernames.put(chatroom, usernames);
                            }

                            // broadcast any messages needing to be sent
                            List queue = getMessageQueue(chatroom);

                            synchronized (queue) {
                                for (Iterator iterator1 = queue.iterator(); iterator1.hasNext();) {
                                    String msg = (String) iterator1.next();
                                    chat.sendMessage(msg);
                                    iterator1.remove();
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    class TranscriptPersister implements Runnable {
        public void run() {
            while (true) {
                synchronized(transcriptLog) {
                    for (Iterator iterator = transcriptLog.entrySet().iterator(); iterator.hasNext();) {
                        Map.Entry entry = (Map.Entry) iterator.next();
                        String chatroom = (String) entry.getKey();
                        List log = (List) entry.getValue();

                        // note: these dates are never null due to the logic in the packet listener
                        Date lastActivity = (Date) transcriptLogActivityDates.get(chatroom);
                        Date lastLog = (Date) transcriptLogDates.get(chatroom);
                        long now = System.currentTimeMillis();

                        // don't bother if there are no logs
                        if (log.isEmpty()) {
                            continue;
                        }

                        // if the lastLog time is less than 6 hours ago, stop immediately
                        if ((now - lastLog.getTime()) < (JiveGlobals.getJiveIntProperty("chat.transcript.timer", 1000 * 60 * 60 * 6))) {
                            continue;
                        }

                        // now, if the lastActivity time is less than 15 minutes ago, stop immediately
                        if ((now - lastActivity.getTime()) < (JiveGlobals.getJiveIntProperty("chat.transcript.buffer", 1000 * 60 * 15))) {
                            continue;
                        }

                        // ok, looks like we should persist the transcript
                        // let's start by buffer up the log and then clearing it
                        HashSet uniqueUsers = new HashSet();
                        StringBuffer sb = new StringBuffer();
                        boolean chatBotSpoke = false;
                        Date oldDate = null;
                        synchronized(log) {
                            for (Iterator iterator1 = log.iterator(); iterator1.hasNext();) {
                                TranscriptMessage tm = (TranscriptMessage) iterator1.next();
                                uniqueUsers.add(tm.username);
                                if (getUserName().equals(tm.username)) {
                                    chatBotSpoke = true;
                                }
                                sb.append(tm);
                            }

                            // clear the log, we're done with it
                            log.clear();

                            // let's set the last log time as now
                            oldDate = (Date) transcriptLogDates.put(chatroom, new Date());
                        }

                        // make sure the only user in the transcript isn't the chatbot
                        // if it is, let's not persist this.
                        if (uniqueUsers.size() == 1 && chatBotSpoke) {
                            continue;
                        }

                        // finally, let's persist the buffered text
                        // first, find all forums that are linked to this chatroom
                        ForumFactory ff = getForumFactory();
                        ArrayList forums = new ArrayList();
                        for (Iterator iterator1 = ff.getForums(); iterator1.hasNext();) {
                            Forum forum = (Forum) iterator1.next();
                            if (chatroom.equals(forum.getProperty("chatroom"))) {
                                forums.add(forum);
                            }
                        }

                        // next, add a new thread for each forum
                        User user = null;
                        try {
                            user = ff.getUserManager().getUser(getUserName());
                        } catch (UserNotFoundException e) {
                            e.printStackTrace();
                        }

                        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a z");
                        for (Iterator iterator1 = forums.iterator(); iterator1.hasNext();) {
                            Forum forum = (Forum) iterator1.next();
                            try {
                                ForumMessage message = forum.createMessage(user);
                                message.setSubject("Chat transcript, " + sdf.format(oldDate));
                                message.setBody(sb.toString());
                                message.setProperty("chat.transcript", "true");
                                ForumThread thread = forum.createThread(message);
                                forum.addThread(thread);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    class TranscriptMessage {
        String username;
        String message;
        Date date;

        public TranscriptMessage(String username, String message, Date date) {
            this.username = username;
            this.message = message;
            this.date = date;
        }

        public String toString() {
            return username + "> " + message + "\n";
        }
    }
}
