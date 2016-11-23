<!--
  Title: cmaEdit1.jsp
  Description: Update an existing CMA
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="cma.title.edit"/></h2>

<html:errors/>

<html:form action="/user/cmaEditAction?action=update" focus="name">
  <table width="0%" border="0">    
    <tr>  
      <td class="hdright"><bean:message key="cma.form.key"/>:</td>
      <td class="fine"><html:text property="key2"/></td>
    </tr>
    
    <tr>  
      <td class="hdright"><bean:message key="cma.form.value"/>:</td>
      <td class="fine"><html:text property="value2"/></td>
    </tr>

    <tr>
      <td class="hdright"><bean:message key="cma.form.active"/>:</td>
      <td class="input"><html:checkbox property="active"/></td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="cma.form.note"/>:</td>
      <td class="input"><html:textarea property="note" cols="50" rows="4"/></td>
    </tr>

    <tr>
      <td><html:submit value="Submit"/></td>
      <td><html:cancel/></td>
    </tr>
  </table>

  <html:hidden property="rowId"/>
  <html:hidden property="ruleId"/>
  <html:hidden property="taskId"/>
</html:form>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
