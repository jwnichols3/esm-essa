<!--
  Title: processNew1.jsp
  Description: create a new process rule
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="process.title.new"/></h2>

<html:errors/>

<html:form action="/user/processInsertAction?action=insert" focus="note">
  <table width="0%" border="0">
    <tr>
      <td class="hdright"><bean:message key="process.form.option"/>:</td>
      <td>
        <html:select property="optionNdx">
          <html:optionsCollection property="optionArray" label="label" value="ndx"/>
        </html:select>
      </td>
      
      <td class="hdright"><bean:message key="process.form.target"/>:</td>
      <td class="fine" colspan="3"><html:text property="target" size="50"/></td>
    </tr>
     
    <tr>
      <td class="hdright"><bean:message key="process.form.threshold"/>:</td>
      <td>
        <html:select property="thresholdNdx">
          <html:optionsCollection property="thresholdArray" label="label" value="ndx"/>
        </html:select>
      </td>
      
      <td class="hdright"><bean:message key="process.form.maximum"/>:</td>
      <td class="fine"><html:text property="maxThreshold" size="6"/></td>
    </tr>
      
    <tr>
      <td class="hdright"><bean:message key="process.form.max_population"/>:</td>
      <td class="fine"><html:text property="maxPopulation" size="6"/></td>
    </tr>
      
    <tr>
      <td class="hdright"><bean:message key="process.form.min_population"/>:</td>
      <td class="fine"><html:text property="minPopulation" size="6"/></td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="process.form.note"/>:</td>
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
