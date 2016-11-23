<!--
  Title: fileSystemAdHocResponse1.jsp
  Description: display results from ad hoc file system request.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="file_system.adhoc.title"/></h2>

<jsp:useBean id="response1" scope="session" class="com.bgi.essa.shared.transfer.FileSystemSampleDTO"/>

<bean:define id="sample_time" name="response1" property="timeStamp"/>

<table width="0%" border="5">
  <tr>
    <td align="right"><bean:message key="file_system.adhoc.sample_time"/>:</td>
    <td><bean:write name="sample_time"/></td>
  </tr>
</table>

<table width="0%" border="5">
  <tr>
    <th class="hdmiddle">
      <bean:message key="file_system.adhoc.device"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="file_system.adhoc.mount"/>
    </th>  
       
    <th class="hdmiddle">
      <bean:message key="file_system.adhoc.fs_type"/>
    </th>        
  </tr>
    
  <logic:iterate id="ndx1" name="response2">  
    <tr>
      <td class="fine">
        <bean:write name="ndx1" property="device"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="mountPoint"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="fileSystemType"/>
      </td>
    </tr>
  </logic:iterate>
</table>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
