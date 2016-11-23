<!--
  Title: fileSystemSizeNew1.jsp
  Description: create a new boot time rule
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="fs_size.title.new"/></h2>

<html:errors/>

<html:form action="/user/fileSystemSizeInsertAction?action=insert" focus="note">
  <table width="0%" border="0">
    <tr>
      <td class="hdright"><bean:message key="fs_size.form.target"/>:</td>
      <td class="input" colspan="5"><html:text property="target" size="50"/></td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="fs_size.form.threshold"/>:</td>
      <td class="input"><html:text property="threshold" size="6"/></td>
      
      <td class="hdright"><bean:message key="fs_size.form.block_threshold"/>:</td>
      <td class="input"><html:radio property="thresholdFlag" value="BLOCK"/></td>
      
      <td class="hdright"><bean:message key="fs_size.form.inode_threshold"/>:</td>
      <td class="input"><html:radio property="thresholdFlag" value="INODE"/></td>
    </tr>
         
    <tr>
      <td class="hdright"><bean:message key="fs_size.form.note"/>:</td>
      <td class="input" colspan="5"><html:textarea property="note" cols="50" rows="4"/></td>
    </tr>

    <tr>
      <td><html:submit value="Submit"/></td>
      <td><html:cancel/></td>
    </tr>
  </table>
</html:form>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
