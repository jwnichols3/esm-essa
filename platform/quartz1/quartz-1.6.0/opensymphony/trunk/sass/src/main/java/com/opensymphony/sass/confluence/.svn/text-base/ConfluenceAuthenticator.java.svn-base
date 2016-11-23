package com.opensymphony.sass.confluence;

import com.opensymphony.sass.user.UserManager;
import com.opensymphony.sass.user.UserManagerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

import com.atlassian.seraph.auth.DefaultAuthenticator;

/**
 * @author <a href="mailto:plightbo@gmail.com">Patrick Lightbody</a>
 */
public class ConfluenceAuthenticator extends com.atlassian.confluence.user.ConfluenceAuthenticator {
    UserManager um = UserManagerFactory.getInstance();

    public Principal getUser(HttpServletRequest request, HttpServletResponse response) {
        Principal user = null;

        try {
            if (request.getSession() != null && request.getSession().getAttribute(DefaultAuthenticator.LOGGED_IN_KEY) != null)
            {
                user = (Principal) request.getSession().getAttribute(DefaultAuthenticator.LOGGED_IN_KEY);
            } else {
                String username = um.authenticate(request);
                if (username != null) {
                    user = getUser(username);
                    request.getSession().setAttribute(DefaultAuthenticator.LOGGED_IN_KEY, user);
                    request.getSession().setAttribute(DefaultAuthenticator.LOGGED_OUT_KEY, null);
                } else {
                    //user was not found, or not currently valid
                    return null;
                }
            }
        }
        catch (Exception e) // catch class cast exceptions
        {
            e.printStackTrace();
        }
        return user;
    }
    
}
