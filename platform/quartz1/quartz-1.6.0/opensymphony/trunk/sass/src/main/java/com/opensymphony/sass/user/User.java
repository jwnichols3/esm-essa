package com.opensymphony.sass.user;

import java.util.List;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class User {
    String username;
    String email;
    String name;
    List groupNames;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getGroupNames() {
        return groupNames;
    }

    public void setGroupNames(List groupNames) {
        this.groupNames = groupNames;
    }
}
