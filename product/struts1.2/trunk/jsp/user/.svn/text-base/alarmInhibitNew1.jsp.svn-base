<!--
  Title: alarmInhibitNew1.jsp
  Description: create a new "alarm inhibit" attribute
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="alarm_inhibit.title.new"/></h2>

<html:errors/>

<html:form action="/user/alarmInhibitInsertAction?action=insert" focus="note">
  <table width="0%" border="0">  
    <tr>
      <td class="hdright"><bean:message key="alarm_inhibit.form.day"/>:</td>
      <td>
        <html:select property="dayNdx">
          <html:optionsCollection property="dayArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="alarm_inhibit.form.start"/>:</td>
      <td>
        <html:select property="startNdx">
          <html:optionsCollection property="startArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="alarm_inhibit.form.stop"/>:</td>
      <td>
        <html:select property="stopNdx">
          <html:optionsCollection property="stopArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="alarm_inhibit.form.note"/>:</td>
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
