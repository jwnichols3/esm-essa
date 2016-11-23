package com.opensymphony.website;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * User: plightbo
 * Date: Apr 21, 2005
 * Time: 6:31:13 PM
 */
public class ProjectFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getServletPath();
        int index = path.indexOf("/", 1);
        String name = null;
        if (index != -1) {
            name = path.substring(1, index);
            Project project = ProjectManager.getInstance().getProject(name);
            request.setAttribute("project", project);
        }

        chain.doFilter(request, res);
    }

    public void destroy() {
    }
}
