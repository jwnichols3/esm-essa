package com.opensymphony.forums.ws;

import java.io.Serializable;

/**
 * User: patrick
 * Date: Jul 22, 2005
 * Time: 4:04:05 PM
 */
public class AuthContext implements Serializable {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
