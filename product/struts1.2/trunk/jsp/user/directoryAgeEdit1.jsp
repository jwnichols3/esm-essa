<!--
  Title: directoryAgeEdit1.jsp
  Description: Update an existing rule
  Author: linden
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="directory_age.title.edit"/></h2>

<html:errors/>

<html:form action="/user/directoryAgeEditAction?action=update" focus="name">
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
      <td class="hdright"><bean:message key="directory_age.form.active"/>:</td>
      <td class="input"><html:checkbox property="active"/></td>
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
    
  <hr>
    
  <h4><bean:message key="vpo.title.browse"/></h4>
   
  <table width="0%" border="1">
    <tr>
      <th class="hdmiddle" colspan="2">
        <bean:message key="option.generic"/>
      </th>
    
      <th class="hdmiddle">
        <bean:message key="vpo.column.app_name"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="vpo.column.severity"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="vpo.column.retry"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="vpo.column.source"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="vpo.column.message"/>
      </th>
    </tr>

    <logic:iterate id="ndx1" name="default_vpo_list">
      <tr>
        <td class="fine">
          <html:link page="/user/vpoPrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="edit.generic"/>
          </html:link>
        </td>
                   
        <td class="fine">
          <html:link page="/user/vpoPrepAction.do?action=audit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="audit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="appName"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="severity"/>
        </td>
      
        <td class="fine">
          <bean:write name="ndx1" property="frequency"/>
        </td>
        
        <td class="fine">
          <logic:notEqual name="ndx1" property="sourceHost" value="EMPTY_STRING">
            <bean:write name="ndx1" property="sourceHost"/>
          </logic:notEqual>
        </td>
             
        <td class="fine">
          <logic:notEqual name="ndx1" property="message" value="EMPTY_STRING">
            <bean:write name="ndx1" property="message"/>
          </logic:notEqual>
        </td>
      </tr>
    </logic:iterate>
  </table>
  
  <h4><bean:message key="canned.title.task_browse"/></h4>
  
  <table width="0%" border="1">
    <tr>
      <th class="hdmiddle" colspan="2">
        <bean:message key="option.generic"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="canned.column.action"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="canned.column.subject"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="canned.column.address"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="canned.column.active"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="canned.column.note"/>
      </th>
    </tr>
 
    <logic:iterate id="ndx1" name="default_canned_list">
      <tr>
        <td class="fine">
          <html:link page="/user/cannedPrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="edit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/cannedPrepAction.do?action=audit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="audit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="action"/>
        </td>
        
        <td class="fine">
          <logic:notEqual name="ndx1" property="subject" value="EMPTY_STRING">
            <bean:write name="ndx1" property="subject"/>
          </logic:notEqual>
        </td>
        
        <td class="fine">
          <logic:notEqual name="ndx1" property="address" value="EMPTY_STRING">
            <bean:write name="ndx1" property="address"/>
          </logic:notEqual>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="active"/>
        </td>
        
        <td class="fine">
          <logic:notEqual name="ndx1" property="note" value="EMPTY_STRING">
            <bean:write name="ndx1" property="note"/>
          </logic:notEqual>
        </td>
      </tr>
    </logic:iterate>
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
