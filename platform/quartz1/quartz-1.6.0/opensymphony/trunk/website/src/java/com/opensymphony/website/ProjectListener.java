package com.opensymphony.website;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

/**
 * User: plightbo
 * Date: Apr 21, 2005
 * Time: 5:52:40 PM
 */
public class ProjectListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        ProjectManager.getInstance().init(event.getServletContext());
    }

    public void contextDestroyed(ServletContextEvent event) {
    }
}
