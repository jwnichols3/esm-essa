<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">

<HTML>

<HEAD>

	<TITLE>OSAccess</TITLE>

</HEAD>

<BODY>

<h3>What is it?</h3>

<P>OSAccess is a centralized Entitlement Engine. This is not meant to

be a replacement for OSUser. Where as OSUser provides for user

authentication across different server platforms and then give you

access control at deployment time, OSAccess provides portable single

point of entry for authorization to an subset of data. Security

engines like <A HREF="../../../../../../osuser/">OSUser</A> let you

state that a user can see account information. The Entitlement Engine

the <I>OSAccess</I> implements then lets you state that the user can

only see his account. Further it says that the support services can

see his account but not change it. Thus, <A HREF="../../../../../../osuser/">OSUser</A>

provides a generalized level of security that is effective for

securing the website itself. And OSAccess is for securing the data

that is displayed by the website resources.</P>

<P>Lets look at an example:</P>

<P>A user comes into an online store. They want to see their current

order status. We use <A HREF="../../../../../../osuser/">OSUser</A>

to say that they need to login (Authentication) to get to the Order

Status Page (Authorization). Now that we know that the can get to the

page we need to know what kind of data we need to show. This is where

<B>OSAccess</B> comes in. If this is the person that made the order

we show the status. But if this is the shipping center we need to

show not only the status but a form or a link to update the status.

This is where we get Entitlement. The Shipping Clerk has a different

level of entitlement (i.e., update rights) then the customer.</P>

<P>This API provides the access to the following functions:</P>

<UL>

	<LI><P STYLE="margin-bottom: 0cm">Fine-grained access levels for

	individual resources

	</P>

	<LI><P STYLE="margin-bottom: 0cm">Protection at the User or Group

	level

	</P>

	<LI><P>Protection at a large grain level for classes of resources

	</P>

</UL>

<h3>Purpose</h3>

<P>Entitlement Access control is needed in almost every J2EE app. As

developers, we rewrite this for each product we create. By providing

a simple pluggable module, we can eliminate most of the rewrite.</P>

<h3>How it works</h3>

<P>OSAccess uses a pluggable provider mechanism much like <A HREF="../../../../../../osuser/">OSUser</A>.

There is a AccessManager that is the singleton interface into

OSAccess. This AccessManager loads and manages sets of providers.

OSAccess defines two (2) types of providers:</P>

<UL>

	<LI><P STYLE="margin-bottom: 0cm"><B>UserProvider</B> - This

	provider tells if a user is in a given group, a group is in a given

	group, and allows the adding/removing of users to groups and groups

	to groups.

	</P>

	<LI><P><B>ResourceProvider</B> - This provider is the heart of the

	system. It is what returns the test status for all entitlement

	request. It also provides <B>C</B>reate, <B>R</B>ead, <B>U</B>pdate,

	and <B>D</B>elete access to the entitlement data store.

	</P>

</UL>

<P>The AccessManager loads a UserProvider and an ResourceProvider for

each &quot;Realm&quot; that it needs to manage. This allows you to

access more than one data store.</P>

<P>Each method of AccessManger needs some combination of the follow:</P>

<UL>

	<LI><P STYLE="margin-bottom: 0cm"><B>userId</B> - This is a string

	representation of the user id. The rules around content are up to

	the implementation

	</P>

	<LI><P STYLE="margin-bottom: 0cm"><B>groupId</B> - This is a string

	representation of the group id. The rules around content are up to

	the implementation

	</P>

	<LI><P STYLE="margin-bottom: 0cm"><B>accessLevel</B> - This is the

	specific access levels that is granted to the object key. Levels are

	CRUD (<U>C</U>reate, <U>R</U>ead, <U>U</U>pdate, <U>D</U>elete)

	</P>

	<LI><P STYLE="margin-bottom: 0cm"><B>resourceKey</B> - The resource

	key is a case sensitive resource id string. It can also contain a

	key after a &quot;|&quot; char.

	</P>

	<LI><P><B>realm</B> - String name of the realm.

	</P>

</UL>

<P>If no Realm is provided or the passed Realm is not valid, the

system default will be used. The default is a generic provider that

always returns no group or object membership. A OSUser provider is in

the works.</P>

<P>OSAccess uses a simple access rights hierarchy. The pattern is a

matching break pattern. If at any point in the test access is found

then that access is returned. The order of execution of test goes

like this:

</P>

<OL>

	<LI><P STYLE="margin-bottom: 0cm">If there is a key passed in that

	identifies an instance of the resource, check to sees if the passed

	user has access rights for the resource id and key.

	</P>

	<LI><P STYLE="margin-bottom: 0cm">A check is then made to see if the

	user has right to the general resource.

	</P>

	<LI><P STYLE="margin-bottom: 0cm">Then a check is made to see if the

	user is a member of a group that has access.

	</P>

	<LI><P STYLE="margin-bottom: 0cm">A check is then made to see if the

	resource is contained in other resources and then checks 2, 3, and 4

	are repeated against the parent.

	</P>

	<LI><P>No match found empty string is returned.

	</P>

	<h3>Current Providers</h3>

</OL>

<CENTER>

	<TABLE WIDTH=95% BORDER=0 CELLPADDING=3 CELLSPACING=0 BGCOLOR="#000000">

		<COL WIDTH=49*>

		<COL WIDTH=22*>

		<COL WIDTH=36*>

		<COL WIDTH=27*>

		<COL WIDTH=30*>

		<COL WIDTH=26*>

		<COL WIDTH=24*>

		<COL WIDTH=19*>

		<COL WIDTH=20*>

		<COL WIDTH=4*>

		<TR>

			<TD WIDTH=19% BGCOLOR="#f0f0f0">

				<P>&nbsp;</P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#f0f0f0">

				<P ALIGN=CENTER><A HREF="http://www.orionserver.com/"><B>Orion</B></A></P>

			</TD>

			<TD WIDTH=14% BGCOLOR="#f0f0f0">

				<P ALIGN=CENTER><A HREF="http://www.bea.com/"><B>WebLogic</B></A></P>

			</TD>

			<TD WIDTH=10% BGCOLOR="#f0f0f0">

				<P ALIGN=CENTER><A HREF="http://www.pramati.com/"><B>Pramati</B></A></P>

			</TD>

			<TD WIDTH=12% BGCOLOR="#f0f0f0">

				<P ALIGN=CENTER><A HREF="http://www.jboss.org/"><B>JBoss</B></A></P>

			</TD>

			<TD WIDTH=10% BGCOLOR="#f0f0f0">

				<P ALIGN=CENTER><A HREF="http://jakarta.apache.org/tomcat"><B>Tomcat</B></A></P>

			</TD>

			<TD WIDTH=9% BGCOLOR="#f0f0f0">

				<P ALIGN=CENTER><A HREF="http://www.caucho.com/"><B>Resin</B></A></P>

			</TD>

			<TD WIDTH=7% BGCOLOR="#f0f0f0">

				<P ALIGN=CENTER><A HREF="http://jetty.mortbay.org/"><B>Jetty</B></A></P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#f0f0f0">

				<P ALIGN=CENTER><A HREF="http://www.macromedia.com/jrun"><B>JRun</B></A></P>

			</TD>

			<TD WIDTH=2% VALIGN=TOP></TD>

		</TR>

		<TR>

			<TD COLSPAN=10 WIDTH=100% BGCOLOR="#f0f0f0">

				<P><B>Production</B>

				</P>

			</TD>

		</TR>

		<TR>

			<TD WIDTH=19% BGCOLOR="#f0f0f0">

				<P><B>EJB Resource</B></P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#99ff33">

				<P ALIGN=CENTER>1.5.4</P>

			</TD>

			<TD WIDTH=14% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>6.1, 7.0</P>

			</TD>

			<TD WIDTH=10% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>3.0</P>

			</TD>

			<TD WIDTH=12% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>2.4.4, 3.0</P>

			</TD>

			<TD WIDTH=10% BGCOLOR="#cccccc">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=9% BGCOLOR="#cccccc">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=7% BGCOLOR="#cccccc">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>4.0</P>

			</TD>

			<TD WIDTH=2% VALIGN=TOP></TD>

		</TR>

		<TR>

			<TD WIDTH=19% BGCOLOR="#f0f0f0">

				<P><A HREF="/osuser/"><B>OSUser User</B></A></P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#99ff33">

				<P ALIGN=CENTER>1.5.4</P>

			</TD>

			<TD WIDTH=14% BGCOLOR="#99ff33">

				<P ALIGN=CENTER>6.1, 7.0</P>

			</TD>

			<TD WIDTH=10% BGCOLOR="#99ff33">

				<P ALIGN=CENTER>3.0</P>

			</TD>

			<TD WIDTH=12% BGCOLOR="#99ff33">

				<P ALIGN=CENTER>2.4.4, 3.0</P>

			</TD>

			<TD WIDTH=10% BGCOLOR="#cccccc">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=9% BGCOLOR="#cccccc">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=7% BGCOLOR="#cccccc">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#ff0000">

				<P ALIGN=CENTER>4.0</P>

			</TD>

			<TD WIDTH=2% VALIGN=TOP></TD>

		</TR>

		<TR>

			<TD COLSPAN=10 WIDTH=100% BGCOLOR="#e6e6e6">

				<P><B>Beta</B></P>

			</TD>

		</TR>

		<TR>

			<TD WIDTH=19% BGCOLOR="#f0f0f0">

				<P><B>Castor Resource</B></P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>1.5.4</P>

			</TD>

			<TD WIDTH=14% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>6.1, 7.0</P>

			</TD>

			<TD WIDTH=10% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>3.0</P>

			</TD>

			<TD WIDTH=12% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>2.4.4, 3.0</P>

			</TD>

			<TD WIDTH=10% BGCOLOR="#cccccc">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=9% BGCOLOR="#cccccc">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=7% BGCOLOR="#cccccc">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#ff0000">

				<P ALIGN=CENTER>4.0</P>

			</TD>

			<TD WIDTH=2% VALIGN=TOP></TD>

		</TR>

		<TR>

			<TD WIDTH=19% BGCOLOR="#f0f0f0">

				<P><B>Castor User</B></P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>1.5.4</P>

			</TD>

			<TD WIDTH=14% BGCOLOR="#ffff00">

				<P ALIGN=CENTER><FONT SIZE=3>6.1, 7.0</FONT></P>

			</TD>

			<TD WIDTH=10% BGCOLOR="#ffff00">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=12% BGCOLOR="#ffff00"></TD>

			<TD WIDTH=10% BGCOLOR="#cccccc"></TD>

			<TD WIDTH=9% BGCOLOR="#cccccc"></TD>

			<TD WIDTH=7% BGCOLOR="#cccccc"></TD>

			<TD WIDTH=8% BGCOLOR="#ffff33"></TD>

			<TD WIDTH=2% VALIGN=TOP></TD>

		</TR>

		<TR>

			<TD WIDTH=19% BGCOLOR="#f0f0f0">

				<P><B>JDBC Resource</B></P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>1.5.4</P>

			</TD>

			<TD WIDTH=14% BGCOLOR="#ffff00">

				<P ALIGN=CENTER><FONT SIZE=3>6.1, 7.0</FONT></P>

			</TD>

			<TD WIDTH=10% BGCOLOR="#ffff00">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=12% BGCOLOR="#ffff00"></TD>

			<TD WIDTH=10% BGCOLOR="#cccccc"></TD>

			<TD WIDTH=9% BGCOLOR="#cccccc"></TD>

			<TD WIDTH=7% BGCOLOR="#cccccc"></TD>

			<TD WIDTH=8% BGCOLOR="#ffff33"></TD>

			<TD WIDTH=2% VALIGN=TOP></TD>

		</TR>

		<TR>

			<TD WIDTH=19% BGCOLOR="#f0f0f0">

				<P><B>JDBC User</B></P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>1.5.4</P>

			</TD>

			<TD WIDTH=14% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>6.1, 7.0</P>

			</TD>

			<TD WIDTH=10% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>3.0</P>

			</TD>

			<TD WIDTH=12% BGCOLOR="#ffff00"></TD>

			<TD WIDTH=10% BGCOLOR="#cccccc">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=9% BGCOLOR="#cccccc">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=7% BGCOLOR="#cccccc">

				<P ALIGN=CENTER><BR>

				</P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#99ff33">

				<P ALIGN=CENTER>4.0</P>

			</TD>

			<TD WIDTH=2% VALIGN=TOP></TD>

		</TR>

		<TR>

			<TD WIDTH=19% BGCOLOR="#f0f0f0">

				<P><B>EJB User</B></P>

			</TD>

			<TD WIDTH=8% BGCOLOR="#ffff00">

				<P ALIGN=CENTER>1.5.4</P>

			</TD>

			<TD WIDTH=14% BGCOLOR="#ffff00">

				<P ALIGN=CENTER><FONT SIZE=3>6.1, 7.0</FONT></P>

			</TD>

			<TD WIDTH=10% BGCOLOR="#ffff00"></TD>

			<TD WIDTH=12% BGCOLOR="#ffff00"></TD>

			<TD WIDTH=10% BGCOLOR="#cccccc"></TD>

			<TD WIDTH=9% BGCOLOR="#cccccc"></TD>

			<TD WIDTH=7% BGCOLOR="#cccccc"></TD>

			<TD WIDTH=8% BGCOLOR="#ffff33"></TD>

			<TD WIDTH=2% VALIGN=TOP></TD>

		</TR>

		<TR>

			<TD COLSPAN=10 WIDTH=100%></TD>

		</TR>

	</TABLE>

</CENTER>

<H4>Key</H4>

<CENTER>

	<TABLE WIDTH=95% BORDER=0 CELLPADDING=3 CELLSPACING=0 BGCOLOR="#000000">

		<COL WIDTH=64*>

		<COL WIDTH=64*>

		<COL WIDTH=64*>

		<COL WIDTH=64*>

		<TR>

			<TD WIDTH=25% BGCOLOR="#99ff33">

				<P ALIGN=CENTER>Test and works</P>

			</TD>

			<TD WIDTH=25% BGCOLOR="#ffff33">

				<P ALIGN=CENTER>Unknown/untested</P>

			</TD>

			<TD WIDTH=25% BGCOLOR="#ff0000">

				<P ALIGN=CENTER>Does not work</P>

			</TD>

			<TD WIDTH=25% BGCOLOR="#cccccc">

				<P ALIGN=CENTER>Not applicable</P>

			</TD>

		</TR>

		<TR>

			<TD COLSPAN=4 WIDTH=100%></TD>

		</TR>

	</TABLE>

</CENTER>

</BODY>

</HTML>