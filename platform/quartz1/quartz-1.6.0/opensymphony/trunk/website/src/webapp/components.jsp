<html>
<head>
    <title>The OpenSymphony Components</title>
</head>

<body>

    <h4>Foundation</h4>

    Comprises of basic components and core libraries that are shared by the rest
    of the suite. As well as providing functionality for the pre-built
    components, it contains helpers for common tasks in a J2EE environment and
    can lighten the load of code to be written by the developer.

    <ul>

        <li><a href="oscore/"><b>OSCore</b></a> - Set of utility-classes useful
        in any J2EE application.</li>

        <li><a href="xwork/"><b>XWork</b></a> - Command pattern framework</li>

    </ul>

    <h4>Business</h4>

    <ul>

        <li><a href="osworkflow/"><b>OSWorkflow</b></a> - Components to allow
        construction of applications based around organization workflow. Models
        entity versioning system, states (e.g. draft, approved, published) and rules
        (e.g. user X may change this version to the approved state).</li>

        <li><a href="quartz/"><b>Quartz</b></a> - An enterprise level job scheduling
        system that can be integrated with, or used along side virtually any J2EE or
        J2SE application.</li>

        <li><a href="propertyset/"><b>PropertySet</b></a> - A component which allows
        for flexible storage of typed properties.</li>

        <li><a href="osuser/"><b>OSUser</b></a> - User-management system. May use
        standard EJB based model, or integrate with existing system (such as custom
        database, <a href="http://www.hibernate.org">Hibernate</a>, LDAP server,
        operating-system). Contains tools for storing, managing, verifying and
        authenticating users including web-based applications. Uses J2EE standards
        for authentication.</li>

        <li><a href="osaccess/"><b>OSAccess</b></a> - Entitlement Security Engine.
        This module uses a pluggable provider system for fine grain access control.
        This completes the security that is left out of the J2EE standard. The
        standard defines how you do Authentication and Authorization to code/code
        resources. This means that the you can protect a a web page or a EJB. What
        the spec does not do say what data you can see on the page or through the
        EJB. OSAccess provides a common way of protecting data and any other
        identifiable item.</li>

    </ul>

    <h4>Presentation</h4>

    Tools to aid in the final presentation of the application over the web. This
    allows impressive looking websites to be developed that can be seamlessly
    integrated with sophisticated interactive web applications.

    <ul>

        <li><b><a href="webwork/">WebWork</a></b> - An MVC framework that stresses
        simplicity and interoperability.</li>

        <li><b><a href="sitemesh/">SiteMesh</a></b> - Presentation layer that
        sits on top of existing web-application. Will take simple pages produced
        by server (static, JSP generated, CGI, anything) and provide customized
        presentation. Templates can be designed with standard HTML tools. Allows
        integrating of multiple pages with custom looks applied into a single
        page (ideal for portal style applications).</li>

        <li><a href="oscache/"><b>OSCache</b></a> - Page caching mechanism to
        greatly improve the performance of your site. Can cache entire page or
        certain chunks, with configurable mechanism. Allows for higher error-tolerance
        on sites as well (e.g. if news database goes down, display last articles
        in cache instead of error to customers).</li>

        <li><b><a href="clickstream/">Clickstream</a></b> - Utility to show the
        current users on your site, and where they've been in detail. This
        allows you to track 'click streams' or 'traffic paths' across your
        site.</li>
    </ul>
</body>
</html>
