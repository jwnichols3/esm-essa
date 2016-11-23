package com.opensymphony.sass.actions;

import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.webwork.interceptor.ServletResponseAware;
import com.opensymphony.sass.user.UserManager;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class Login extends ActionSupport implements ServletResponseAware {
    protected UserManager userManager;

    protected String username;
    protected String password;
    protected boolean remember;
    private HttpServletResponse res;

    public void setServletResponse(HttpServletResponse res) {
        this.res = res;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean isAuthenticated() {
        return userManager.authenticate(username, password);
    }

    public String execute() throws Exception {
        userManager.login(username, password, remember, res);

        return SUCCESS;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }
}
