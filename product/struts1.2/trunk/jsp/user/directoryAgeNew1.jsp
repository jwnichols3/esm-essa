<!--
  Title: directoryAgeNew1.jsp
  Description: create a new file age rule
  Author: linden
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="directory_age.title.new"/></h2>

<html:errors/>

<html:form action="/user/directoryAgeInsertAction?action=insert" focus="note">
  <table width="0%" border="0">  
    <tr>
      <td class="hdright"><bean:message key="directory_age.form.directory_name"/>:</td>
      <td class="fine" colspan="5"><html:text property="directoryName" size="50"/></td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="directory_age.form.threshold"/>:</td>
      <td class="fine"><html:text property="threshold" size="6"/></td>
      
      <td class="hdright"><bean:message key="directory_age.form.older"/>:</td>
      <td class="fine"><html:radio property="ageOption" value="OLDER"/></td>
      
      <td class="hdright"><bean:message key="directory_age.form.newer"/>:</td>
      <td class="fine"><html:radio property="ageOption" value="NEWER"/></td>
    </tr>
       
    <tr>
      <td class="hdright"><bean:message key="directory_age.form.note"/>:</td>
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
