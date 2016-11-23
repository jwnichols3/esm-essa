<!--
  Title: directorySizeAdHocResponse1.jsp
  Description: display results from ad hoc directory size request.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="fs_size.adhoc.title"/></h2>

<jsp:useBean id="response1" scope="session" class="com.bgi.essa.shared.transfer.StatVfsDTO"/>

<bean:define id="name" name="response1" property="name"/>
<bean:define id="sample_time" name="response1" property="timeStamp"/>

<bean:define id="block_size" name="response1" property="blockSize"/>
<bean:define id="fragment_size" name="response1" property="fragmentSize"/>
<bean:define id="total_block_population" name="response1" property="fileSystemBlocks"/>
<bean:define id="free_block_population" name="response1" property="freeBlocks"/>

<table width="0%" border="5">
  <tr>
    <td align="right"><bean:message key="fs_size.adhoc.sample_time"/>:</td>
    <td><bean:write name="sample_time"/></td>
  </tr>
  
  <tr>
    <td align="right"><bean:message key="fs_size.adhoc.name"/>:</td>
    <td><bean:write name="name"/></td>
  </tr>

  <tr>
    <td align="right"><bean:message key="fs_size.adhoc.block_size"/>:</td>
    <td><bean:write name="block_size"/></td>
  </tr>
   
  <tr>
    <td align="right"><bean:message key="fs_size.adhoc.fragment_size"/>:</td>
    <td><bean:write name="fragment_size"/></td>
  </tr>
  
  <tr>
    <td align="right"><bean:message key="fs_size.adhoc.total_block_population"/>:</td>
    <td><bean:write name="total_block_population"/></td>
  </tr>
  
  <tr>
    <td align="right"><bean:message key="fs_size.adhoc.free_block_population"/>:</td>
    <td><bean:write name="free_block_population"/></td>
  </tr>
 
</table>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
