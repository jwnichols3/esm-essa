<!--
  Title: vpoNew1.jsp
  Description: create a new VPO attribute
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="vpo.title.new"/></h2>

<html:errors/>

<html:form action="/user/vpoInsertAction?action=insert" focus="note">
  <table width="0%" border="0">  
    <tr>
      <td class="hdright"><bean:message key="vpo.form.app_name"/>:</td>
      <td>
        <html:select property="appNameNdx">
          <html:optionsCollection property="appNameArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="vpo.form.severity"/>:</td>
      <td>
        <html:select property="severityNdx">
          <html:optionsCollection property="severityArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>
    
    <tr>  
      <td class="hdright"><bean:message key="vpo.form.retry"/>:</td>
      <td class="fine"><html:text property="frequency" size="6"/></td>
    </tr>
   
    <tr>  
      <td class="hdright"><bean:message key="vpo.form.source"/>:</td>
      <td class="fine"><html:text property="source"/></td>
    </tr>
            
    <tr>
      <td class="hdright"><bean:message key="vpo.form.message"/>:</td>
      <td class="input"><html:textarea property="message" cols="50" rows="4"/></td>
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
