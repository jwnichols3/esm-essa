/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.sass.osuser;

import com.opensymphony.user.Entity;
import com.opensymphony.user.provider.CredentialsProvider;
import com.opensymphony.sass.user.User;
import com.opensymphony.sass.user.UserManager;
import com.opensymphony.sass.user.UserManagerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class SassUserManager implements CredentialsProvider {
    UserManager userManager = UserManagerFactory.getInstance();

    public boolean authenticate(String name, String password) {
        return userManager.authenticate(name, password);
    }

    public boolean changePassword(String name, String password) {
        return false;
    }

    public boolean create(String name) {
        // LDAP doesn't support this feature, so instead call the first provider that does
        return false;
    }

    public void flushCaches() {
    }

    public boolean handles(String name) {
        return userManager.getUser(name) != null;
    }

    public boolean init(Properties properties) {
        return true;
    }

    public List list() {
        List users = userManager.getAllUsers();
        List usernames = new ArrayList(users.size());
        for (Iterator iterator = users.iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();
            usernames.add(user.getUsername());
        }

        return usernames;
    }

    public boolean load(String name, Entity.Accessor accessor) {
        accessor.setName(name);
        accessor.setMutable(true);

        return true;
    }

    public boolean remove(String name) {
        return false;
    }

    public boolean store(String name, Entity.Accessor accessor) {
        return true;
    }
}