<!--
  Title: directorySizeAdHocResponse1.jsp
  Description: display results from ad hoc directory size request.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="dir_size.adhoc.title"/></h2>

<jsp:useBean id="response1" scope="session" class="com.bgi.essa.shared.transfer.DirectorySizeSampleDTO"/>

<bean:define id="bytePop" name="response1" property="bytePopulation"/>
<bean:define id="dirPop" name="response1" property="directoryPopulation"/>
<bean:define id="filePop" name="response1" property="filePopulation"/>
<bean:define id="name" name="response1" property="name"/>
<bean:define id="sample_time" name="response1" property="timeStamp"/>

<bean:define id="exists" name="response1" property="isExists"/>
<bean:define id="recursion" name="response1" property="isRecursion"/>

<table width="0%" border="5">
  <tr>
    <td align="right"><bean:message key="dir_size.adhoc.sample_time"/>:</td>
    <td><bean:write name="sample_time"/></td>
  </tr>
  
  <tr>
    <td align="right"><bean:message key="dir_size.adhoc.name"/>:</td>
    <td><bean:write name="name"/></td>
  </tr>
  
  <tr>
    <td align="right"><bean:message key="dir_size.adhoc.exists"/>:</td>
    <td><bean:write name="exists"/></td>
  </tr>
  
  <tr>
    <td align="right"><bean:message key="dir_size.adhoc.recursive"/>:</td>
    <td><bean:write name="recursion"/></td>
  </tr>
  
  <tr>
    <td align="right"><bean:message key="dir_size.adhoc.file_pop"/>:</td>
    <td><bean:write name="filePop"/></td>
  </tr>
   
  <tr>
    <td align="right"><bean:message key="dir_size.adhoc.dir_pop"/>:</td>
    <td><bean:write name="dirPop"/></td>
  </tr>
  
  <tr>
    <td align="right"><bean:message key="dir_size.adhoc.byte_pop"/>:</td>
    <td><bean:write name="bytePop"/></td>
  </tr>
</table>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
