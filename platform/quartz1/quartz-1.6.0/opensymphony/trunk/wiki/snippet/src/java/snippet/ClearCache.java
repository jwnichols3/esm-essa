package snippet;

import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.webwork.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;

/**
 * User: plightbo
 * Date: Sep 10, 2005
 * Time: 11:53:14 PM
 */
public class ClearCache extends ActionSupport implements ServletRequestAware {
    String url;
    String id;
    String redirect;
    HttpServletRequest req;

    public void setServletRequest(HttpServletRequest req) {
        this.req = req;
    }

    public String execute() throws Exception {
        SnippetMacro.clearCacheSnippet(new URL(url), id);
        redirect = req.getHeader("Referer");
        if (redirect == null) {
            redirect = "/snippet/clearCache.vm";
        }

        return SUCCESS;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRedirect() {
        return redirect;
    }
}
