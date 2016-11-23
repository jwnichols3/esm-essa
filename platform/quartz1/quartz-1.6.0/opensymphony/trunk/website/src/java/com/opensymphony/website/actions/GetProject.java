package com.opensymphony.website.actions;

import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.website.ProjectManager;
import com.opensymphony.website.Project;
import com.opensymphony.webwork.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * User: plightbo
 * Date: Apr 21, 2005
 * Time: 6:06:02 PM
 */
public class GetProject extends ActionSupport implements ServletRequestAware {
    private Project project;
    private HttpServletRequest req;

    public void setServletRequest(HttpServletRequest req) {
        this.req = req;
    }

    public String execute() throws Exception {
        String name = constructProjectName();
        project = ProjectManager.getInstance().getProject(name);

        return SUCCESS;
    }
    
    public String license() throws Exception {
        String name = constructProjectName();
        project = ProjectManager.getInstance().getProject(name);

        if(project.getLicense() != null && project.getLicense().equals("apache"))
            return "apache";
        
        return SUCCESS;
    }

    private String constructProjectName() {
        String path = req.getServletPath();
        return path.substring(1, path.indexOf("/", 1));
    }

    public Project getProject() {
        return project;
    }
}
