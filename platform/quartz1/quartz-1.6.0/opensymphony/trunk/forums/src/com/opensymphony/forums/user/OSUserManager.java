package com.opensymphony.forums.user;

import com.jivesoftware.base.database.DbUserManager;
import com.jivesoftware.base.User;
import com.jivesoftware.base.UserNotFoundException;
import com.jivesoftware.base.UserAlreadyExistsException;
import com.jivesoftware.base.UserManagerFactory;

import java.util.Map;

public class OSUserManager extends DbUserManager {
    public User createUser(String s, String s1, String s2) throws UserAlreadyExistsException {
        User user = super.createUser(s, s1, s2);
        return reGetUser(user);
    }

    public User createUser(String s, String s1, String s2, String s3, boolean b, boolean b1, Map map) throws UserAlreadyExistsException {
        User user = super.createUser(s, s1, s2, s3, b, b1, map);
        return reGetUser(user);
    }

    public User createUser(long l, String s, String s1, String s2, String s3, boolean b, boolean b1, Map map) throws UserAlreadyExistsException {
        User user = super.createUser(l, s, s1, s2, s3, b, b1, map);
        return reGetUser(user);
    }

    private User reGetUser(User user) {
        UserManagerFactory.userCache.remove(new Long(user.getID()));
        try {
            return lookupUser(user.getID());
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected User lookupUser(String username) throws UserNotFoundException {
        return new OSUser(username);
    }

    protected User lookupUser(long userID) throws UserNotFoundException {
        return new OSUser(userID);
    }

}
