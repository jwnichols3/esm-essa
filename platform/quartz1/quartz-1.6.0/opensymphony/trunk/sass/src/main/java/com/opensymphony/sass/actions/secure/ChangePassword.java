package com.opensymphony.sass.actions.secure;

import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.webwork.interceptor.ServletRequestAware;
import com.opensymphony.webwork.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.sass.user.UserManager;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class ChangePassword extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    protected UserManager userManager;

    protected String password;
    protected String passwordVerify;
    private HttpServletRequest req;
    private HttpServletResponse res;

    public void setServletRequest(HttpServletRequest req) {
        this.req = req;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.res = response;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public String execute() throws Exception {
        if (userManager.changePassword(req, res, password)) {
            addActionMessage("Password changed successfully");
            return SUCCESS;
        }

        addFieldError("password", "Could not change password");
        return INPUT;
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
