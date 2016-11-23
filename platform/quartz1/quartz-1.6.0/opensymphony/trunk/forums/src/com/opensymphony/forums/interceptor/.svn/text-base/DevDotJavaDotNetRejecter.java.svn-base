package com.opensymphony.forums.interceptor;

import com.jivesoftware.forum.ForumMessage;
import com.jivesoftware.forum.MessageInterceptor;
import com.jivesoftware.forum.MessageRejectedException;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class DevDotJavaDotNetRejecter implements MessageInterceptor {

    public DevDotJavaDotNetRejecter() {
    }

    public DevDotJavaDotNetRejecter(int objectType, long objectID) {
    }


    public int getType() {
        return MessageInterceptor.TYPE_PRE;
    }

    public void invokeInterceptor(ForumMessage forumMessage, int i) throws MessageRejectedException {
        // only allow mail from opensymphony and dev.java.net
        String email = forumMessage.getProperty("email");
        if (email == null) {
            return;
        }

        if (email.endsWith("dev.java.net") || email.endsWith("opensymphony.com")) {
            return;
        }

        throw new MessageRejectedException("Email intercepted that does not end with @dev.java.net or @opensymphony.com", forumMessage);
    }
}
