<!--
  Title: directorySizeNew1.jsp
  Description: create a new directory size rule
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="directory_size.title.new"/></h2>

<html:errors/>

<html:form action="/user/directorySizeInsertAction?action=insert" focus="directory">
  <table width="0%" border="0">  
    <tr>
      <td class="hdright"><bean:message key="directory_size.form.directory"/>:</td>
      <td class="fine" colspan="5"><html:text property="directory" size="50"/></td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="directory_size.form.threshold"/>:</td>
      <td>
        <html:select property="optionNdx">
          <html:optionsCollection property="optionArray" label="label" value="ndx"/>
        </html:select>
      </td>
      
      <td class="hdright"><bean:message key="directory_size.form.minimum"/>:</td>
      <td class="fine"><html:text property="minThreshold" size="6"/></td>
  
      <td class="hdright"><bean:message key="directory_size.form.maximum"/>:</td>
      <td class="fine"><html:text property="maxThreshold" size="6"/></td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="directory_size.form.recursive"/>:</td>
      <td class="input"><html:checkbox property="recursive"/></td>
    </tr>
       
    <tr>
      <td class="hdright"><bean:message key="directory_size.form.note"/>:</td>
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
