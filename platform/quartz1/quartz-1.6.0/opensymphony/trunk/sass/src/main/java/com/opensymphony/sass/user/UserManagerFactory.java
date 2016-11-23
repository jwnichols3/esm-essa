package com.opensymphony.sass.user;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class UserManagerFactory {
    private static final UserManager instance = new UserManagerImpl();

    public static UserManager getInstance() {
        return instance;
    }
}
