<!--
  Title: bootTimeAdHocResponse1.jsp
  Description: display results from ad hoc boot time request.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="boot_time.adhoc.title"/></h2>

<jsp:useBean id="response1" scope="session" class="com.bgi.essa.shared.transfer.BootTimeSampleDTO"/>

<bean:define id="boot_time" name="response1" property="bootTime"/>
<bean:define id="sample_time" name="response1" property="timeStamp"/>

<table width="0%" border="5">
  <tr>
    <td align="right"><bean:message key="boot_time.adhoc.sample_time"/>:</td>
    <td><bean:write name="sample_time"/></td>
  </tr>
  
  <tr>
    <td align="right"><bean:message key="boot_time.adhoc.boot_time"/>:</td>
    <td><bean:write name="boot_time"/></td>
  </tr>
</table>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
