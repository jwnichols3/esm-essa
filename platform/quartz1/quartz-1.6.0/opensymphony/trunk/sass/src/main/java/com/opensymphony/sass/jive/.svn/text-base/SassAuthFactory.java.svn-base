package com.opensymphony.sass.jive;

import com.jivesoftware.base.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.sass.user.UserManager;

import java.io.Serializable;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class SassAuthFactory extends AuthFactory {
    UserManager um = com.opensymphony.sass.user.UserManagerFactory.getInstance();

    protected AuthToken createAuthToken(HttpServletRequest req, HttpServletResponse res) throws UnauthorizedException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            AuthToken authToken = (AuthToken) session.getAttribute(SESSION_AUTHORIZATION);
            if (authToken != null) {
                return authToken;
            }
        }

        String username = um.authenticate(req);
        if (username != null) {
            AuthToken authToken = getAuthToken(username);
            session = req.getSession(true);
            session.setAttribute(SESSION_AUTHORIZATION, authToken);
            return authToken;
        }

        throw new UnauthorizedException("Could not authenticate by request");
    }

    protected AuthToken createAuthToken(String username, String password) throws UnauthorizedException {
        if (um.authenticate(username, password)) {
            return getAuthToken(username);
        }

        throw new UnauthorizedException("Could not authenticate " + username);
    }

    private AuthToken getAuthToken(String username) {
        com.jivesoftware.base.UserManager um = UserManagerFactory.getInstance();
        try {
            User user = um.getUser(username);
            return new SassAuthToken(user.getID());
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected AuthToken createAnonymousAuthToken() {
        return new SassAuthToken();
    }

    public static class SassAuthToken implements AuthToken, Serializable {
        long userID;

        public SassAuthToken() {
        }

        public SassAuthToken(long userID) {
            this.userID = userID;
        }

        public long getUserID() {
            return userID;
        }

        public boolean isAnonymous() {
            return userID == 0;
        }
    }
}
