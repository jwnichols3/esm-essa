<html>
<head>
<title>OSAccess Requirements</title>
</head>

<body bgcolor="#FFFFFF">
<p>OSAccess currently requires a J2EE 1.2 or greater container to run. This means that it does not run under Tomcat or
Jetty. When there are providers written to support non-EJB resources and users it will be able to run under a servlet
container.
  </p>
<p>So far it has been tested in the following application servers and web containers:</p>
<ul>
  <li><a href="http://www.orionserver.com">OrionServer</a>
    (version 1.5.2 and above)</li>
</ul>

<h3>Libraries needed</h3>
<p>OSAccess requires the following libraries</p>
<ul>
    <li><a href="oscore/">OSCore</a></li>
    <li>jaxp</li>
</ul>
and a JAXP compliant parser such as crimson from apache.
<br />

<p>If you have run OSAccess successfully in other servers, please <a href="mailto:snowwolf@indiancoalition.com"> let
  us know</a> and I'll add to this list.</p>

</body>
</html>
