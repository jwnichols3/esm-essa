<!--
  Title: cannedNew1.jsp
  Description: create a new "canned action" attribute
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="canned.title.new"/></h2>

<html:errors/>

<html:form action="/user/cannedInsertAction?action=insert" focus="note">
  <table width="0%" border="0">  
    <tr>
      <td class="hdright"><bean:message key="canned.form.action"/>:</td>
      <td>
        <html:select property="actionNdx">
          <html:optionsCollection property="actionArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>
      
    <tr>  
      <td class="hdright"><bean:message key="canned.form.subject"/>:</td>
      <td class="fine"><html:text property="subject" size="50"/></td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="canned.form.address"/>:</td>
      <td class="input"><html:textarea property="address" cols="50" rows="4"/></td>
    </tr>
            
    <tr>
      <td class="hdright"><bean:message key="canned.form.note"/>:</td>
      <td class="input"><html:textarea property="note" cols="50" rows="4"/></td>
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
