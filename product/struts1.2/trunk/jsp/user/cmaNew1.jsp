<!--
  Title: cmaNew1.jsp
  Description: create a new CMA
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="cma.title.new"/></h2>

<html:errors/>

<html:form action="/user/cmaInsertAction?action=insert" focus="note">
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
      <td class="hdright"><bean:message key="cma.form.note"/>:</td>
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
