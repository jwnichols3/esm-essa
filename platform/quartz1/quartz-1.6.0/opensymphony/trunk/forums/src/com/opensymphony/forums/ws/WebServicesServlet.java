package com.opensymphony.forums.ws;

import com.caucho.hessian.server.HessianServlet;
import com.jivesoftware.forum.ForumFactory;
import com.jivesoftware.base.*;

/**
 * User: patrick
 * Date: Jul 22, 2005
 * Time: 3:56:21 PM
 */
public class WebServicesServlet extends HessianServlet implements WebServices {
    public WSUser getUser(AuthContext ac, String username) {
        WSUser wsUser = null;
        try {
            AuthToken authToken = AuthFactory.getAuthToken(ac.getUsername(), ac.getPassword());
            UserManager um = ForumFactory.getInstance(authToken).getUserManager();
            User user = um.getUser(username);
            wsUser = new WSUser();
            wsUser.setUsername(user.getUsername());
            wsUser.setName(user.getName());
            wsUser.setEmail(user.getEmail());
            wsUser.setLastModified(user.getModificationDate());
            wsUser.setCreated(user.getCreationDate());
        } catch (UnauthorizedException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            return null;
        }

        return wsUser;
    }

    public boolean authenticate(String username, String password) {
        try {
            AuthFactory.getAuthToken(username, password);
            return true;
        } catch (UnauthorizedException e) {
            return false;
        }
    }
}
