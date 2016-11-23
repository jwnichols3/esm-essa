<!--
  Title: taskEdit1.jsp
  Description: Update an existing task
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="task.title.edit"/></h2>

<html:errors/>

<html:form action="/user/taskEditAction?action=update" focus="name">
  <table width="0%" border="0">
    <tr>
      <td class="hdright"><bean:message key="task.form.name"/>:</td>
      <td class="input"><html:text property="name"/></td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="task.form.frequency"/>:</td>
      <td class="input"><html:text property="frequency" size="6"/></td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="task.form.match_all"/>:</td>
      <td class="input"><html:checkbox property="matchAll"/></td>
    </tr>
      
    <tr>
      <td class="hdright"><bean:message key="task.form.active"/>:</td>
      <td class="input"><html:checkbox property="active"/></td>
    </tr>

    <tr>
      <td class="hdright"><bean:message key="task.form.note"/>:</td>
      <td class="input"><html:textarea property="note" cols="50" rows="4"/></td>
    </tr>

    <tr>
      <td><html:submit value="Submit"/></td>
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

  <h4><bean:message key="alarm_inhibit.title.browse"/></h4>
   
  <table width="0%" border="1">
    <tr>
      <th class="hdmiddle" colspan="2">
        <bean:message key="option.generic"/>
      </th>
    
      <th class="hdmiddle">
        <bean:message key="alarm_inhibit.column.day"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="alarm_inhibit.column.start"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="alarm_inhibit.column.stop"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="alarm_inhibit.column.active"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="alarm_inhibit.column.note"/>
      </th>
    </tr>

    <logic:iterate id="ndx1" name="alarm_inhibit_list">
      <tr>
        <td class="fine">
          <html:link page="/user/alarmInhibitPrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="edit.generic"/>
          </html:link>
        </td>
                   
        <td class="fine">
          <html:link page="/user/alarmInhibitPrepAction.do?action=audit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="audit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="day"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="start"/>
        </td>
      
        <td class="fine">
          <bean:write name="ndx1" property="stop"/>
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

  <h4><bean:message key="cma.title.task_browse"/></h4>
  
  <table width="0%" border="1">
    <tr>
      <th class="hdmiddle" colspan="2">
        <bean:message key="option.generic"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="cma.column.key"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="cma.column.value"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="cma.column.active"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="cma.column.note"/>
      </th>
    </tr>
    
    <logic:iterate id="ndx1" name="default_cma_list">
      <tr>
        <td class="fine">
          <html:link page="/user/cmaPrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="edit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/cmaPrepAction.do?action=audit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="audit.generic"/>
          </html:link>
        </td>
                             
        <td class="fine">
          <bean:write name="ndx1" property="key"/>
        </td>
             
        <td class="fine">
          <bean:write name="ndx1" property="value"/>
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
  
  <hr>

  <!--
  <h4><bean:message key="directory_age.title.task_browse"/></h4>
  
  <table width="0%" border="1">
    <tr>
      <th class="hdmiddle" colspan="3">
        <bean:message key="option.generic"/>
      </th>
    
      <th class="hdmiddle">
        <bean:message key="directory_age.column.directory_name"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="directory_age.column.threshold"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="directory_age.column.option"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="directory_age.column.active"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="directory_age.column.note"/>
      </th>
    </tr>

    <logic:iterate id="ndx1" name="directory_age_list">
      <tr>
        <td class="fine">
          <html:link page="/user/directoryAgePrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="edit.generic"/>
          </html:link>
        </td>
          
        <td class="fine">
          <html:link page="/user/directoryAgePrepAction.do?action=audit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="audit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/directoryAgePrepAction.do?action=sample" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="sample.generic"/>
          </html:link>
        </td>
      
        <td class="fine">
          <bean:write name="ndx1" property="directoryName"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="absThreshold"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="olderNewer"/>
        </td>
         
        <td class="fine">
          <logic:notEqual name="ndx1" property="note" value="EMPTY_STRING">
            <bean:write name="ndx1" property="note"/>
          </logic:notEqual>
        </td>

        <td class="fine">
          <bean:write name="ndx1" property="note"/>
        </td>
      </tr>
    </logic:iterate>
  </table>
  -->

  <h4><bean:message key="directory_size.title.task_browse"/></h4>
  
  <table width="0%" border="1">
    <tr>
      <th class="hdmiddle" colspan="3">
        <bean:message key="option.generic"/>
      </th>
    
      <th class="hdmiddle">
        <bean:message key="directory_size.column.directory"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="directory_size.column.max_threshold"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="directory_size.column.min_threshold"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="directory_size.column.option"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="directory_size.column.recursive"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="directory_size.column.active"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="directory_size.column.note"/>
      </th>
    </tr>

    <logic:iterate id="ndx1" name="directory_size_list">
      <tr>
        <td class="fine">
          <html:link page="/user/directorySizePrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="edit.generic"/>
          </html:link>
        </td>
            
        <td class="fine">
          <html:link page="/user/directorySizePrepAction.do?action=audit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="audit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/directorySizePrepAction.do?action=sample" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="sample.generic"/>
          </html:link>
        </td>
      
        <td class="fine">
          <bean:write name="ndx1" property="target"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="maximumThreshold"/>
        </td>
              
        <td class="fine">
          <bean:write name="ndx1" property="minimumThreshold"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="thresholdType"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="recursive"/>
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

  <h4><bean:message key="file_age.title.task_browse"/></h4>
  
  <table width="0%" border="1">
    <tr>
      <th class="hdmiddle" colspan="3">
        <bean:message key="option.generic"/>
      </th>
    
      <th class="hdmiddle">
        <bean:message key="file_age.column.file_name"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="file_age.column.threshold"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="file_age.column.option"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="file_age.column.active"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="file_age.column.note"/>
      </th>
    </tr>

    <logic:iterate id="ndx1" name="file_age_list">
      <tr>
        <td class="fine">
          <html:link page="/user/fileAgePrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="edit.generic"/>
          </html:link>
        </td>
          
        <td class="fine">
          <html:link page="/user/fileAgePrepAction.do?action=audit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="audit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/fileAgePrepAction.do?action=sample" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="sample.generic"/>
          </html:link>
        </td>
      
        <td class="fine">
          <bean:write name="ndx1" property="fileName"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="absThreshold"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="olderNewer"/>
        </td>
         
        <td class="fine">
          <logic:notEqual name="ndx1" property="note" value="EMPTY_STRING">
            <bean:write name="ndx1" property="note"/>
          </logic:notEqual>
        </td>

        <td class="fine">
          <bean:write name="ndx1" property="note"/>
        </td>
      </tr>
    </logic:iterate>
  </table>
  
  <h4><bean:message key="file_size.title.task_browse"/></h4>
  
  <table width="0%" border="1">
    <tr>
      <th class="hdmiddle" colspan="3">
        <bean:message key="option.generic"/>
      </th>
    
      <th class="hdmiddle">
        <bean:message key="file_size.column.target"/>
      </th>
          
      <th class="hdmiddle">
        <bean:message key="file_size.column.max_threshold"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="file_size.column.min_threshold"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="file_size.column.option"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="file_size.column.active"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="file_size.column.note"/>
      </th>
    </tr>

    <logic:iterate id="ndx1" name="file_size_list">
      <tr>
        <td class="fine">
          <html:link page="/user/fileSizePrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="edit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/fileSizePrepAction.do?action=audit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="audit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/fileSizePrepAction.do?action=sample" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="sample.generic"/>
          </html:link>
        </td>
      
        <td class="fine">
          <bean:write name="ndx1" property="target"/>
        </td>
              
        <td class="fine">
          <bean:write name="ndx1" property="maximumThreshold"/>
        </td>
              
        <td class="fine">
          <bean:write name="ndx1" property="minimumThreshold"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="thresholdType"/>
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
      
  <h4><bean:message key="fs_size.title.task_browse"/></h4>
  
  <table width="0%" border="1">
    <tr>
      <th class="hdmiddle" colspan="3">
        <bean:message key="option.generic"/>
      </th>
     
      <th class="hdmiddle">
        <bean:message key="fs_size.column.target"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="fs_size.column.block_threshold"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="fs_size.column.inode_threshold"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="fs_size.column.active"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="fs_size.column.note"/>
      </th>
    </tr>
 
    <logic:iterate id="ndx1" name="file_system_size_list">
      <tr>
        <td class="fine">
          <html:link page="/user/fileSystemSizePrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="edit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/fileSystemSizePrepAction.do?action=audit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="audit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/fileSystemSizePrepAction.do?action=sample" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="sample.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="target"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="blockThreshold"/>
        </td>
                   
        <td class="fine">
          <bean:write name="ndx1" property="inodeThreshold"/>
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
  
  <h4><bean:message key="process.title.task_browse"/></h4>
  
  <table width="0%" border="1">
    <tr>
      <th class="hdmiddle" colspan="3">
        <bean:message key="option.generic"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="process.column.target"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="process.column.min_pop"/>
      </th>
           
      <th class="hdmiddle">
        <bean:message key="process.column.max_pop"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="process.column.max_time"/>
      </th>
      
      <th class="hdmiddle">
        <bean:message key="process.column.active"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="process.column.note"/>
      </th>
    </tr>
 
    <logic:iterate id="ndx1" name="process_list">
      <tr>
        <td class="fine">
          <html:link page="/user/processPrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="edit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/processPrepAction.do?action=audit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="audit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/processPrepAction.do?action=sample" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="sample.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="target"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="minimumPopulation"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="maximumPopulation"/>
        </td>
        
        <td class="fine">
          <bean:write name="ndx1" property="maximumTime"/>
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
    
  <h4><bean:message key="boot_time.title.task_browse"/></h4>
  
  <table width="0%" border="1">
    <tr>
      <th class="hdmiddle" colspan="3">
        <bean:message key="option.generic"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="boot_time.column.active"/>
      </th>

      <th class="hdmiddle">
        <bean:message key="boot_time.column.note"/>
      </th>
    </tr>
 
    <logic:iterate id="ndx1" name="boot_time_list">
      <tr>
        <td class="fine">
          <html:link page="/user/bootTimePrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="edit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/bootTimePrepAction.do?action=audit" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="audit.generic"/>
          </html:link>
        </td>
        
        <td class="fine">
          <html:link page="/user/bootTimePrepAction.do?action=sample" paramId="key" paramName="ndx1" paramProperty="rowId">
            <bean:message key="sample.generic"/>
          </html:link>
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
  <html:hidden property="taskId"/>
</html:form>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
