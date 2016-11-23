package com.opensymphony.forums.user;

import com.jivesoftware.base.database.DbUser;
import com.jivesoftware.base.UserNotFoundException;

public class OSUser extends DbUser {
    protected OSUser(long id) throws UserNotFoundException {
        super(id);
    }

    protected OSUser(String username) throws UserNotFoundException {
        super(username);
    }

    public boolean isEmailVisible() {
        return false;
    }

    public boolean isSetEmailVisibleSupported() {
        return false;
    }
}
