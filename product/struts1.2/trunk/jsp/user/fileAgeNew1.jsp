<!--
  Title: fileAgeNew1.jsp
  Description: create a new file age rule
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="file_age.title.new"/></h2>

<html:errors/>

<html:form action="/user/fileAgeInsertAction?action=insert" focus="note">
  <table width="0%" border="0">  
    <tr>
      <td class="hdright"><bean:message key="file_age.form.file_name"/>:</td>
      <td class="fine" colspan="5"><html:text property="fileName" size="50"/></td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="file_age.form.threshold"/>:</td>
      <td class="fine"><html:text property="threshold" size="6"/></td>
      
      <td class="hdright"><bean:message key="file_age.form.older"/>:</td>
      <td class="fine"><html:radio property="ageOption" value="OLDER"/></td>
      
      <td class="hdright"><bean:message key="file_age.form.newer"/>:</td>
      <td class="fine"><html:radio property="ageOption" value="NEWER"/></td>
    </tr>
       
    <tr>
      <td class="hdright"><bean:message key="file_age.form.note"/>:</td>
      <td class="fine" colspan="5"><html:textarea property="note" cols="50" rows="4"/></td>
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
