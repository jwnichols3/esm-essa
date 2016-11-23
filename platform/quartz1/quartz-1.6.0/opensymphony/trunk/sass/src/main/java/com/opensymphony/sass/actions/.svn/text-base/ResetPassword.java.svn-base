package com.opensymphony.sass.actions;

import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.sass.user.UserManager;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class ResetPassword extends ActionSupport {
    private UserManager userManager;
    private String username;

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String execute() throws Exception {
        if (userManager.getUser(username) == null) {
            return INPUT;
        }

        userManager.resetPassword(username);
        return SUCCESS;
    }
}
