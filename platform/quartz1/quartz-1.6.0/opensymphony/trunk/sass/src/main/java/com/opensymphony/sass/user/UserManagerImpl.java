package com.opensymphony.sass.user;

import com.opensymphony.util.GUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import javax.naming.ldap.LdapContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import com.opensymphony.sass.util.Blowfish;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class UserManagerImpl implements UserManager {
    protected Blowfish cipher = new Blowfish(System.getProperty("ldap.pass"));

    public static final long TIMEOUT = 1000 * 60 * 60 * 15; // 15 minutes


    final CacheEntry groupNames = new CacheEntry(null);
    final Map groupCache = new HashMap();
    final Map userCache = new HashMap();

    private static final String BASE_ORG = ",dc=opensymphony,dc=com";
    private static final String COOKIE_NAME = "openSymphony.auth";
    private static final String COOKIE_DOMAIN = ".opensymphony.com";
    private static final String ADMIN_EMAIL = "admin@opensymphony.com";
    private static final String ORG_NAME = "OpenSymphony";
    private static final String LDAP_HOST = "opensymphony.com";

    static class CacheEntry {
        private long time = System.currentTimeMillis();
        private Object entry;

        public CacheEntry(Object entry) {
            this.entry = entry;
        }

        public Object getEntry() {
            return entry;
        }

        public boolean isValid() {
            return (System.currentTimeMillis() < time + TIMEOUT);
        }

        public void refresh() {
            time = System.currentTimeMillis();
        }
    }

    public Group getGroup(String groupname) {
        synchronized (groupCache) {
            if (groupCache.containsKey(groupname)) {
                CacheEntry entry = (CacheEntry) groupCache.get(groupname);
                if (entry.isValid()) {
                    return (Group) entry.getEntry();
                } else {
                    groupCache.remove(groupname);
                }
            }
        }

        DirContext ctx = getDirContext();
        try {
            Attributes matchAttrs = new BasicAttributes(true); // ignore attribute name case
            matchAttrs.put(new BasicAttribute("cn", groupname));
            // Search for objects with those matching attributes
            NamingEnumeration answer = ctx.search("ou=Group" + BASE_ORG, matchAttrs);
            if (answer.hasMore()) {
                SearchResult sr = (SearchResult) answer.next();
                Attributes attrs = sr.getAttributes();
                Group group = new Group();
                group.setName((String) attrs.get("cn").get());

                // now get all the usernames in this group...
                Attribute attr = attrs.get("uniqueMember");
                ArrayList usernames = new ArrayList();
                for (int i = 0; i < attr.size(); i++) {
                    String rdn = (String) attr.get(i);
                    String username = extractUsername(rdn);
                    usernames.add(username);
                }

                group.setUsernames(usernames);

                synchronized (groupCache) {
                    groupCache.put(groupname, new CacheEntry(group));
                }

                return group;
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                ctx.close();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    private String extractUsername(String rdn) {
        int comma = rdn.indexOf(",");
        return rdn.substring("uid=".length(), comma);
    }

    public List getAllGroups() {
        List names;
        synchronized(groupNames) {
            names = (List) groupNames.getEntry();
            if (!groupNames.isValid() || names == null) {
                if (names == null) {
                    names = new ArrayList();
                    groupNames.entry = names;
                } else {
                    names.clear();
                }

                loadGroupNames(names);
                groupNames.refresh();
            }
        }

        List groups = new ArrayList();
        for (Iterator iterator = names.iterator(); iterator.hasNext();) {
            String groupName = (String) iterator.next();
            groups.add(getGroup(groupName));
        }

        return groups;
    }

    private void loadGroupNames(List names) {
        DirContext ctx = getDirContext();
        try {
            LdapContext lc = (LdapContext) ctx.lookup("ou=Group" + BASE_ORG);
            NamingEnumeration ne = lc.list("");
            while (ne.hasMore()) {
                NameClassPair ncp = (NameClassPair) ne.next();
                String groupName = ncp.getName().substring("cn=".length());
                names.add(groupName);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void login(String username, String password, boolean remember, HttpServletResponse res) {
        Cookie cookie = new Cookie(COOKIE_NAME, encryptAuthInfo(username, password));
        cookie.setDomain(COOKIE_DOMAIN);
        cookie.setPath("/");

        if (remember) {
            cookie.setMaxAge(60 * 60 * 24 * 365); // 1 year
        }

        res.addCookie(cookie);
    }

    public boolean changePassword(HttpServletRequest req, HttpServletResponse res, String password) {
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals(COOKIE_NAME)) {
                String value = cookie.getValue();
                String[] values = decryptAuthInfo(value);
                if (values != null) {
                    String username = values[0];
                    if (resetPassword(username, password)) {
                        cookie.setValue(encryptAuthInfo(username, password));
                        res.addCookie(cookie);

                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean resetPassword(String username, String password) {
        DirContext ctx = getDirContext();
        try {
            ctx.modifyAttributes("uid=" + username + ",ou=People" + BASE_ORG,
                    new ModificationItem[]{
                            new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                                    new BasicAttribute("userPassword", password))
                    });

            return true;
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                ctx.close();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public void logout(HttpServletRequest req, HttpServletResponse res) {
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals(COOKIE_NAME)) {
                cookie.setMaxAge(0);
                cookie.setValue(null);
                cookie.setDomain(COOKIE_DOMAIN);
                cookie.setPath("/");
                res.addCookie(cookie);
                return;
            }
        }
    }

    public void resetPassword(String username) {
        String password = GUID.generateGUID();
        if (resetPassword(username, password)) {
            // now send an email out...

            String host = "localhost";
            String from = ADMIN_EMAIL;
            String to = getUser(username).getEmail();

            // Get system properties
            Properties props = System.getProperties();

            // Setup mail server
            props.put("mail.smtp.host", host);

            // Get session
            Session session = Session.getDefaultInstance(props, null);

            // Define message
            String text = "Your password for " + ORG_NAME + " has been reset to: \n\n" +
                    password + "\n\n" +
                    "Please log back in as soon as you can and change it.";
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject(ORG_NAME + ": Reset password");
                message.setText(text);

                // Send message
                Transport.send(message);
            } catch (MessagingException e) {
                System.out.println("Couldn't send password reset to " + to + ": \n" + text);
                e.printStackTrace();
            }
        }
    }

    public boolean authenticate(String username, String password) {
        try {
            getDirContext("uid=" + username + ",ou=People", password);

            return true;
        } catch (NamingException e) {
            return false;
        }
    }

    public String authenticate(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            return null;
        }

        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals(COOKIE_NAME)) {
                String[] values = decryptAuthInfo(cookie.getValue());
                String username = values[0];
                String password = values[1];
                if (username == null || password == null) {
                    return null;
                }

                if (authenticate(username, password)) {
                    return username;
                }
            }
        }

        return null;
    }

    public UserManagerImpl() {
    }

    public DirContext getDirContext() {
        try {
            String ldapPass = System.getProperty("ldap.pass");
            return getDirContext("cn=Manager", ldapPass);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public DirContext getDirContext(String username, String password) throws NamingException {
        Hashtable env = new Hashtable(11);
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://" + LDAP_HOST + ":389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, username + "" + BASE_ORG); // specify the username
        env.put(Context.SECURITY_CREDENTIALS, password);           // specify the password

        return new InitialDirContext(env);
    }

    public User getUser(String username) {
        synchronized (userCache) {
            if (userCache.containsKey(username)) {
                CacheEntry entry = (CacheEntry) userCache.get(username);
                if (entry.isValid()) {
                    return (User) entry.getEntry();
                } else {
                    userCache.remove(username);
                }
            }
        }

        DirContext ctx = getDirContext();
        try {
            Attributes matchAttrs = new BasicAttributes(true); // ignore attribute name case
            matchAttrs.put(new BasicAttribute("uid", username));
            // Search for objects with those matching attributes
            NamingEnumeration answer = ctx.search("ou=People" + BASE_ORG, matchAttrs);
            if (answer.hasMore()) {
                SearchResult sr = (SearchResult) answer.next();
                Attributes attrs = sr.getAttributes();
                User user = new User();
                user.setUsername((String) attrs.get("uid").get());
                user.setName((String) attrs.get("cn").get());
                user.setEmail((String) attrs.get("mail").get());

                // now figure out all the groups for this user
                List groupNames = new ArrayList();
                BasicAttributes groupMatchAttrs = new BasicAttributes(true);
                groupMatchAttrs.put(new BasicAttribute("uniqueMember", "uid=" + username + ",ou=People" + BASE_ORG));
                NamingEnumeration ne = ctx.search("ou=Group" + BASE_ORG, groupMatchAttrs);
                while (ne.hasMore()) {
                    SearchResult groupSr = (SearchResult) ne.next();
                    Attributes groupAttrs = groupSr.getAttributes();
                    String groupName = (String) groupAttrs.get("cn").get();
                    groupNames.add(groupName);
                }
                // needed to make default instances of jira and confluence happy (should fix later)
                groupNames.add("confluence-users");
                groupNames.add("jira-users");
                user.setGroupNames(groupNames);

                synchronized (userCache) {
                    userCache.put(username, new CacheEntry(user));
                }

                return user;
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                ctx.close();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public void create(User user, String password) {
        DirContext ctx = getDirContext();
        try {
            BasicAttributes attrs = new BasicAttributes();
            BasicAttribute objectClass = new BasicAttribute("objectClass");
            objectClass.add("inetOrgPerson");
            objectClass.add("organizationalPerson");
            objectClass.add("person");
            objectClass.add("top");
            attrs.put(objectClass);
            attrs.put("uid", user.getUsername());
            attrs.put("cn", user.getName());
            attrs.put("sn", user.getName());
            attrs.put("mail", user.getEmail());
            attrs.put("userPassword", password);
            ctx.bind("uid=" + user.getUsername() + ",ou=People" + BASE_ORG, null, attrs);
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                ctx.close();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
    }

    public List getAllUsers() {
        List users = new ArrayList();
        DirContext ctx = getDirContext();
        try {
            LdapContext lc = (LdapContext) ctx.lookup("ou=People" + BASE_ORG);
            NamingEnumeration ne = lc.list("");
            while (ne.hasMore()) {
                NameClassPair ncp = (NameClassPair) ne.next();
                users.add(getUser(ncp.getName().substring("uid=".length())));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return users;
    }


    public String encryptAuthInfo(String username, String password) {
        if (username == null || password == null) {
            throw new NullPointerException("Username or password was null.");
        }
        return cipher.encryptString(username + '\002' + password);
    }

    public String [] decryptAuthInfo(String value) {
        // Check that the cookie value isn't null or zero-length
        if (value == null || value.length() <= 0) {
            return null;
        }
        // Decode the cookie value
        value = cipher.decryptString(value);
        if (value == null) {
            return null;
        }

        int pos = value.indexOf('\002');
        String username = (pos < 0) ? "" : value.substring(0, pos);
        String password = (pos < 0) ? "" : value.substring(pos + 1);

        return new String[]{username, password};
    }

}
