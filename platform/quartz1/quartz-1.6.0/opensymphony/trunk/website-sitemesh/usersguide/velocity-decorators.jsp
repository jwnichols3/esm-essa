<html>
    <head>
        <title>Building Decorators with Velocity</title>
    </head>

    <body>
        As of SiteMesh 2.0.2 <a href="http://jakarta.apache.org/velocity/">Velocity</a> (.vm)
        decorators are supported.

        <p>Here is an example of how such a decorator (e.g. /decorators/main.vm) might look like:</p>

<pre class="code">
#parse ("/includes/decorators/header.vm")
  &lt;h2&gt;<b>$title</b>&lt;/h2&gt;
  <b>$head</b>
  &lt;img src="<b>$base</b>/images/logo.gif" border="0"&gt;
  &lt;td valign="top" class="body"&gt;
    &lt;div class="header"&gt;
      &lt;span class="pagetitle"&gt;<b>$title</b>&lt;/span&gt;
    &lt;/div&gt;
    <b>$body</b>
  &lt;/td&gt;
#parse ("/includes/decorators/footer.vm")
</pre>

        <h3>Installation</h3>

        <ul>

        	<li>Download <a
        	href="http://jakarta.apache.org/velocity/">Velocity</a> 1.3.1 or
        	higher and copy it into <b><code>[web-app]/WEB-INF/lib</code></b>.
        	The SiteMesh distribution comes with <b>velocity-dep-1.3.1.jar</b>.</p></li>

        	<li>Download <a
        	href="http://jakarta.apache.org/velocity/tools/">VelocityTools</a> 1.1
        	and copy it into <b><code>[web-app]/WEB-INF/lib</code></b>.
        	The SiteMesh distribution comes with <b>velocity-tools-view-1.1.jar</b>.</p></li>

			<li>Download <a
        	href="http://jakarta.apache.org/commons/collections/">Commons Collections</a> 2.1 or
        	higher and copy it into <b><code>[web-app]/WEB-INF/lib</code></b>.
        	The SiteMesh distribution comes with <b>commons-collections.jar</b>.</p></li>

        	<li>Add the following to <b><code>[web-app]/WEB-INF/web.xml</code></b>
        	within the <b><code>&lt;web-app&gt;</code></b> tag:</li>
       	</ul>

<pre class="code">
&lt;servlet&gt;
  &lt;servlet-name&gt;<b>sitemesh-velocity</b>&lt;/servlet-name&gt;
  &lt;servlet-class&gt;
    <b>com.opensymphony.module.sitemesh.velocity.VelocityDecoratorServlet</b>
  &lt;/servlet-class&gt;
&lt;/servlet&gt;

&lt;servlet-mapping&gt;
  &lt;servlet-name&gt;sitemesh-velocity&lt;/servlet-name&gt;
  &lt;url-pattern&gt;<b>*.vm</b>&lt;/url-pattern&gt;
&lt;/servlet-mapping&gt;
</pre>

		<ul>
			<li>Modify <b><code>decorators.xml</code></b> to reference a .vm
			decorator.</li>
		</ul>

		<p>A working example is included with the SiteMesh distribution, under the <a href="https://sitemesh.dev.java.net/source/browse/sitemesh/src/example-webapp/">src/example-webapp</a> directory.</p>

		<h3>Context</h3>

		VelocityDecoratorServlet puts some things into the context object that you should be aware of:

		<table border="0" cellspacing="10">
		    <tr>
		        <td valign="top"><strong>$request</strong><br /><nobr>(from <a href="http://jakarta.apache.org/velocity/tools/javadoc/org/apache/velocity/tools/view/servlet/VelocityViewServlet.html">VelocityViewServlet</a>)</nobr></td>
		        <td valign="top">The HttpServletRequest object</td>
		    </tr>
		    <tr>
		        <td valign="top"><strong>$response</strong><br /><nobr>(from <a href="http://jakarta.apache.org/velocity/tools/javadoc/org/apache/velocity/tools/view/servlet/VelocityViewServlet.html">VelocityViewServlet</a>)</nobr></td>
		        <td valign="top">The HttpServletResponse object</td>
		    </tr>
		    <tr>
		        <td valign="top"><strong>$session</strong><br /><nobr>(from <a href="http://jakarta.apache.org/velocity/tools/javadoc/org/apache/velocity/tools/view/servlet/VelocityViewServlet.html">VelocityViewServlet</a>)</nobr></td>
		        <td valign="top">The HttpSession object</td>
		    </tr>
		    <tr>
		        <td valign="top"><strong>$application</strong><br /><nobr>(from <a href="http://jakarta.apache.org/velocity/tools/javadoc/org/apache/velocity/tools/view/servlet/VelocityViewServlet.html">VelocityViewServlet</a>)</nobr></td>
		        <td valign="top">The ServletContext object</td>
		    </tr>
		    <tr>
		        <td valign="top"><strong>$base</strong></td>
		        <td valign="top">request.getContextPath()</td>
		    </tr>
		    <tr>
		        <td valign="top"><strong>$title</strong></td>
		        <td valign="top">Parsed page title (&lt;title&gt;...&lt;title&gt;)</td>
		    </tr>
		    <tr>
		        <td valign="top"><strong>$head</strong></td>
		        <td valign="top">Parsed page head</td>
		    </tr>
		    <tr>
		        <td valign="top"><strong>$body</strong></td>
		        <td valign="top">Parsed page body</td>
		    </tr>
		    <tr>
		        <td valign="top"><strong>$page</strong></td>
		        <td valign="top">SiteMesh's internal Page object</td>
		    </tr>
		    <tr>
		        <td valign="top"><strong>Anything else</strong></td>
		        <td valign="top">Search for the attribute by that name in the request, session and application scopes</td>
        </tr>
		</table>
	</body>
</html>