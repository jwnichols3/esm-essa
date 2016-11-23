package snippet;

import com.atlassian.renderer.RenderContext;
import com.atlassian.renderer.v2.RenderMode;
import com.atlassian.renderer.v2.SubRenderer;
import com.atlassian.renderer.v2.macro.BaseMacro;
import com.atlassian.renderer.v2.macro.MacroException;
import com.atlassian.mail.Email;
import com.atlassian.mail.MailFactory;
import com.atlassian.mail.server.SMTPMailServer;
import com.atlassian.confluence.renderer.PageContext;

import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;

/**
 * <p/>
 * Macro that gets a snippet of the content from a URL. The content will be trimmed down to the content
 * found between some special tags. This is very handy for documentation that includes code. The code
 * can be in CVS (whatever build system is used will make sure it builds properly) and the URL can
 * be a ViewCVS URL. (In case of ViewCVS the URL should point to the download URL of a file). The content
 * is cached for one hour in order to improve performance. The snippet is also unindented to remove excess space.
 * Example of content of the URL:
 * </p>
 * <p/>
 * <pre>
 * this
 * // START SNIPPET: something
 * macro
 * // START SNIPPET: somethingElse
 * is
 * // END SNIPPET: somethingElse
 * very
 * // END SNIPPET: something
 * cool
 * </pre>
 * </p>
 * <p/>
 * Example usage:
 * <pre>
 * {snippet:lang=java|id=something|linenumbers=true|url=http://some/url/to/viewcvs}
 * </pre>
 * </p>
 * <p/>
 * This will give the following content
 * <pre>
 * {code:java}
 * 1. macro
 * 2. is
 * 3. very
 * {code}
 * </pre>
 * </p>
 * <p/>
 * Parameters:
 * <ul>
 * <li>id - (required) the id of the snippet in the URL content</li>
 * <li>url - (required) the location of the content</li>
 * <li>lang - (optional) if present, will wrap the content in {code:lang}</li>
 * <li>linenumbers (optional) if present and true, will add line numbers</li>
 * </ul>
 * </p>
 *
 * @author Jon Tirs&eacute;n
 * @author Aslak Helles&oslash;y
 * @author Carlos Villela
 * @version $Revision: 280 $
 */
public class SnippetMacro extends BaseMacro
{
    public static boolean TOGGLE = true;

    private static final int MINUTE = 60 * 1000;
    public static final Map cache = new HashMap();
    public static final Map timeCached = new HashMap();
    private long timeout = 60 * MINUTE; // one hour default cache
    private SubRenderer subRenderer;

    public RenderMode getBodyRenderMode()
    {
        return RenderMode.ALL;
    }

    public boolean hasBody()
    {
        return false;
    }

    public boolean isInline()
    {
        return false;
    }

    public String execute(Map parameters, String string, RenderContext renderContext) throws MacroException
    {
        String id = (String) parameters.get("id");
        required(id, "id");
        String urlParam = (String) parameters.get("url");
        required(urlParam, "url");

         if (urlParam.startsWith("com.opensymphony.")) {
            // ok, this is a direct class reference, we can fix this
            // first, figure out which module we're talking about
            int nextDot = urlParam.indexOf('.', "com.opensymphony.".length());
            String module = urlParam.substring("com.opensymphony.".length(), nextDot);

            if ("xwork".equals(module)) {
                String url = "http://svn.opensymphony.com/svn/xwork/branches/xwork_1-2/src/java/";
                urlParam = url + urlParam.replaceAll("\\.", "/") + ".java";
            } else if ("xwork2".equals(module)) {
                String url = "http://svn.opensymphony.com/svn/xwork/trunk/src/java/";
                urlParam = url + urlParam.replaceAll("\\.", "/") + ".java";
            } else {
                urlParam = module + "/src/java/" + urlParam.replaceAll("\\.", "/") + ".java";
            }
        } else if (urlParam.startsWith("org.apache.struts2.")) {
            // ex: https://svn.apache.org/repos/asf/struts/strut2/trunk/core/src/main/java/org/apache/struts/action2/
            // support for Struts 2.0
            String url = "https://svn.apache.org/repos/asf/struts/struts2/trunk/core/src/main/java/";
            urlParam = url + urlParam.replaceAll("\\.", "/") + ".java";
        }

        if (!urlParam.startsWith("http")) {
            if (urlParam.startsWith("struts2/")) {
                // cut out the struts2 part
                urlParam = urlParam.substring("struts2/".length());
                urlParam = "https://svn.apache.org/repos/asf/struts/struts2/trunk/" + urlParam;
            } else {
                urlParam = "https://opensymphony.dev.java.net/source/browse/*checkout*/" + urlParam;
            }
        }


        // one last check to short-circuit any xwork access
        if (urlParam.startsWith("https://opensymphony.dev.java.net/source/browse/*checkout*/xwork/")) {
            urlParam = urlParam.substring("https://opensymphony.dev.java.net/source/browse/*checkout*/xwork/".length());
            urlParam = "http://svn.opensymphony.com/svn/xwork/branches/xwork_1-2/src/java/" + urlParam;
        }

        String linesParam = (String) parameters.get("linenumbers");
        URL url = null;
        try {
            url = new URL(urlParam);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage());
        }
        String lang = (String) parameters.get("lang");

        try {
            boolean withLineNumbers = "true".equals(linesParam);
            Snippet snippet = null;
            String encoded = null;

            encoded = URLEncoder.encode(urlParam, "UTF-8");
            snippet = getSnippet(url, id, renderContext);

            List lines = snippet.getLines();
            // if there are no actual lines, this snippet is invalid!
            if (lines == null || lines.isEmpty()) {
                email(renderContext, url, id, "An invalid snippet was found", null);
            }

            StringWriter writer = new StringWriter();

            // check if each line starts with a whitespace and a "*" (JavaDocs)
            boolean javaDoc = true;
            if (!"true".equals(parameters.get("javadoc"))) {
                // ok, we weren't told specifically, let's try to figure it out
                for (Iterator iterator = lines.iterator(); iterator.hasNext();) {
                    String line = (String) iterator.next();
                    if (!Snippet.stripEOL(line).trim().startsWith("* ")) {
                        javaDoc = false;
                        break;
                    }
                }
            }

            if (lang != null)
            {
                writer.write("{code:lang=" + lang + "}\n");
            }
            snippet.writeContent(writer, withLineNumbers, javaDoc);
            if (lang != null)
            {
                writer.write("{code}\n");
            }


            String msg;
            if (lang != null) {
                String content = writer.getBuffer().toString();
                if (javaDoc) {
                    // this is in a javadoc, so we can assume that XML content is escaped, we need to fix that
                    content = content.replaceAll("\\&lt;", "<").replaceAll("\\&gt;", ">").replaceAll("\\&#64;", "@");
                }

                msg = subRenderer.render(content, new RenderContext());
            } else {
                msg = subRenderer.render(writer.getBuffer().toString(), new RenderContext(),
                        RenderMode.suppress(RenderMode.F_MACROS | RenderMode.F_HTMLESCAPE | RenderMode.F_LINEBREAKS | RenderMode.F_LINKS));

                if (javaDoc) {
                    // @{link Writer} -> Writer
                    // @{link Foo#bar()} -> Foo.bar()
                    // @{link #foo()} -> foo()
                    msg = cleanupJavadoc(msg);
                }
            }

            if (TOGGLE) {
                return "<table bgcolor='#ffffe0' cellpadding='0' cellspacing='0' width='100%' border='0'>" +
                        "<tr>" +
                        "<td>" +
                        "<div stlye='font-size:8px; text-align:center;'>" +
                        "<center>Content pulled from external source. Click <a href='/plugins/snippet/clearCache.action?id=" + id + "&amp;url=" + encoded + "'>here</a> to refresh.</center>" +
                        "</div>" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td>" +
                        msg +
                        "</td>" +
                        "</tr>" +
                        "</table>";
            } else {
                return msg;
            }
        } catch (Exception e) {
            email(renderContext, url, id, null, e);
            return "An error occurred: " + e.getMessage() + ". The system administrator has been notified.";
        }
    }

    private void email(RenderContext renderContext, URL url, String id, String msg, Exception e) {
        if (true) {
            // disabled for now
            return;
        }

        try {
            PageContext pc = (PageContext) renderContext;

            Email mail = new Email("plightbo@gmail.com");
            mail.setFrom("cvs@webwork.dev.java.net");
            mail.setFromName("OpenSymphony Wiki");
            mail.setSubject("Bad Snippet");
            String append = "";
            if (e != null) {
                msg = "Exception: " + e.getMessage();
                StringWriter writer = new StringWriter();
                e.printStackTrace(new PrintWriter(writer));
                append = writer.toString();
            }
            mail.setBody(msg + ":\n" +
                    "\n" +
                    " Page: " + "http://wiki.opensymphony.com" + pc.getEntity().getUrlPath() + "\n" +
                    " URL:  " + url + "\n" +
                    " ID:   " + id + "\n" +
                    "\n" +
                    append);

            SMTPMailServer mailServer = MailFactory.getServerManager().getDefaultSMTPMailServer();
            if (mailServer != null) {
                mailServer.send(mail);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String s = "foo {@link Writer} bar {@link Foo#bar()} baz {@link #foo()} qoz";
        System.out.println(cleanupJavadoc(s));
    }

    public static String cleanupJavadoc(String msg) {
        return msg.replaceAll("\\{\\@link ([^ \\}]+)\\}", "$1");
    }

    Snippet getSnippet(URL url, String id, RenderContext renderContext) throws IOException
    {
        Snippet result = getCachedSnippet(url, id);
        if (result == null)
        {
            result = new SnippetReader(url).readSnippet(id);
            cacheSnippet(url, id, result);
        }

        return result;
    }

    public static void clearCacheSnippet(URL url, String id) {
        cache.remove(globalSnippetId(url, id));
    }

    private Snippet getCachedSnippet(URL url, String id)
    {
        if (isCacheTimedout(url, id))
        {
            removeFromCache(url, id);
        }
        return (Snippet) cache.get(globalSnippetId(url, id));
    }

    boolean isCacheTimedout(URL url, String id)
    {
        return timeInCache(url, id) >= timeout;
    }

    long timeInCache(URL url, String id)
    {
        return System.currentTimeMillis() - getTimeCached(url, id);
    }

    long getTimeCached(URL url, String id)
    {
        String globalId = globalSnippetId(url, id);
        return timeCached.containsKey(globalId) ? ((Long) timeCached.get(globalId)).longValue() : 0;
    }

    private void removeFromCache(URL url, String id)
    {
        String globalId = globalSnippetId(url, id);
        timeCached.remove(globalId);
        cache.remove(globalId);
    }

    private static String globalSnippetId(URL url, String id)
    {
        return url + " " + id;
    }

    private void required(String id, String param)
    {
        if (id == null || "".equals(id))
        {
            throw new IllegalArgumentException(param + " is a required parameter");
        }
    }

    public void cacheSnippet(URL url, String id, Snippet snippet)
    {
        cache.put(globalSnippetId(url, id), snippet);
        timeCached.put(globalSnippetId(url, id), new Long(System.currentTimeMillis()));
    }

    public void setCacheTimeout(int timeout)
    {
        this.timeout = timeout;
    }

    public void setSubRenderer(SubRenderer subRenderer)
    {
        this.subRenderer = subRenderer;
    }
}
