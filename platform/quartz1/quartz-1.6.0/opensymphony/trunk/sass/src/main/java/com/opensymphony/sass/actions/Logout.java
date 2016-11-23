package com.opensymphony.sass.actions;

import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.webwork.interceptor.ServletResponseAware;
import com.opensymphony.webwork.interceptor.ServletRequestAware;
import com.opensymphony.sass.user.UserManager;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * User: plightbo
 * Date: Nov 25, 2005
 * Time: 10:47:56 AM
 */
public class Logout extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    private UserManager userManager;
    private HttpServletRequest req;
    private HttpServletResponse res;

    public void setServletRequest(HttpServletRequest req) {
        this.req = req;
    }

    public void setServletResponse(HttpServletResponse res) {
        this.res = res;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public String execute() throws Exception {
        userManager.logout(req, res);

        return SUCCESS;
    }
}
