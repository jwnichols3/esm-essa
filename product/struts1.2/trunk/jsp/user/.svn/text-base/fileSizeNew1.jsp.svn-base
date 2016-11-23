<!--
  Title: fileSizeNew1.jsp
  Description: create a new file size rule
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="file_size.title.new"/></h2>

<html:errors/>

<html:form action="/user/fileSizeInsertAction?action=insert" focus="note">
  <table width="0%" border="0">  
    <tr>
      <td class="hdright"><bean:message key="file_size.form.file_name"/>:</td>
      <td class="fine" colspan="5"><html:text property="fileName" size="50"/></td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="file_size.form.threshold"/>:</td>
      <td>
        <html:select property="optionNdx">
          <html:optionsCollection property="optionArray" label="label" value="ndx"/>
        </html:select>
      </td>

      <td class="hdright"><bean:message key="file_size.form.minimum"/>:</td>
      <td class="fine"><html:text property="minThreshold" size="6"/></td>
  
      <td class="hdright"><bean:message key="file_size.form.maximum"/>:</td>
      <td class="fine"><html:text property="maxThreshold" size="6"/></td>
    </tr>
       
    <tr>
      <td class="hdright"><bean:message key="file_size.form.note"/>:</td>
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
