package com.opensymphony.website;

import com.opensymphony.util.ClassLoaderUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * User: patrick
 * Date: Oct 31, 2005
 * Time: 10:37:32 AM
 */
public class WikiCssFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getRequestURI().endsWith("styles/site.css")) {
            InputStream is = ClassLoaderUtil.getResourceAsStream("site.css", getClass());
            ServletOutputStream os = res.getOutputStream();

            byte[] buffer = new byte[2048];
            int length = -1;
            while ((length = is.read(buffer)) != -1) {
                os.write(buffer, 0, length);
            }
        } else {
            chain.doFilter(req, res);
        }
    }

    public void destroy() {
    }
}
