<!--
  Title: userNew1.jsp
  Description: add a new user
  Legalise: Copyright (C) 2007 Digital Burro, INC.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="user.new.title"/></h2>

<html:form action="/user/userInsertAction?action=insert" focus="key" name="userForm" type="net.braingang.fl1.presentation_tier.struts1_1.airport.AirportForm" scope="request">
  <table width="0%" border="5">
    <tr>
      <td align="right"><bean:message key="user.new.form.key"/>:</td>
      <td><html:text property="key"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="user.new.form.name"/>:</td>
      <td><html:text property="name" size="50"/></td>
    </tr>

    <tr>
      <td><html:submit value="Submit"/></td>
      <td><html:cancel/></td>
    </tr>
  </table>
</html:form>

<html:errors/>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
