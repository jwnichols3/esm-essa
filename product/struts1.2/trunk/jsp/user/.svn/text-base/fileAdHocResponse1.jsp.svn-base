<!--
  Title: fileAdHocResponse1.jsp
  Description: display results from ad hoc file test request.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="file.adhoc.title"/></h2>

<jsp:useBean id="response1" scope="session" class="com.bgi.essa.shared.transfer.FileSampleDTO"/>

<bean:define id="name" name="response1" property="name"/>
<bean:define id="sample_time" name="response1" property="timeStamp"/>

<bean:define id="exists_flag" name="response1" property="isExists"/>
<bean:define id="file_flag" name="response1" property="isFile"/>
<bean:define id="directory_flag" name="response1" property="isDirectory"/>
<bean:define id="modified_time" name="response1" property="fileModified"/>
<bean:define id="file_length" name="response1" property="length"/>

<table width="0%" border="2">
  <tr>
    <td align="right"><bean:message key="file.adhoc.sample_time"/>:</td>
    <td><bean:write name="sample_time"/></td>
  </tr>
  
  <tr>
    <td align="right"><bean:message key="file.adhoc.name"/>:</td>
    <td><bean:write name="name"/></td>
  </tr>
  
  <tr>
    <td align="right"><bean:message key="file.adhoc.exists"/>:</td>
    <td><bean:write name="exists_flag"/></td>
  </tr>
    
  <tr>
    <td align="right"><bean:message key="file.adhoc.file"/>:</td>
    <td><bean:write name="file_flag"/></td>
  </tr>
    
  <tr>
    <td align="right"><bean:message key="file.adhoc.directory"/>:</td>
    <td><bean:write name="directory_flag"/></td>
  </tr>
    
  <tr>
    <td align="right"><bean:message key="file.adhoc.time"/>:</td>
    <td><bean:write name="modified_time"/></td>
  </tr>
    
  <tr>
    <td align="right"><bean:message key="file.adhoc.length"/>:</td>
    <td><bean:write name="file_length"/></td>
  </tr>
</table>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
