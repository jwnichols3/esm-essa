package com.opensymphony.sass.actions;

import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.sass.user.UserManager;
import com.opensymphony.sass.user.User;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class Create extends ActionSupport {
    protected UserManager userManager;

    protected User user;
    protected String password;
    protected String passwordVerify;

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean isValidUsername() {
        return userManager.getUser(user.getUsername()) == null;
    }

    public String execute() throws Exception {
        userManager.create(user, password);

        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordVerify() {
        return passwordVerify;
    }

    public void setPasswordVerify(String passwordVerify) {
        this.passwordVerify = passwordVerify;
    }
}
