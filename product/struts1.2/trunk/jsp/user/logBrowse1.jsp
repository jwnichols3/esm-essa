<!--
  Title: logBrowse1.jsp
  Description: Display selected log book entries.
  Legalise: Copyright (C) 2007 Digital Burro, INC.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="log.browse.title"/></h2>

<table width="0%" border="2">
  <tr>
    <th class="hdmiddle">
      <bean:message key="log.browse.column.key"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="log.browse.column.date"/>
    </th>
 
    <th class="hdmiddle">
      <bean:message key="log.browse.column.registration"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="log.browse.column.from"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="log.browse.column.to"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="log.browse.column.total"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="log.browse.column.pic"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="log.browse.column.night"/>
    </th>
  
    <th class="hdmiddle">
      <bean:message key="log.browse.column.ifr"/>
    </th>
      
    <th class="hdmiddle">
      <bean:message key="log.browse.column.ia"/>
    </th>
   
    <th class="hdmiddle">
      <bean:message key="log.browse.column.purpose"/>
    </th>
   
    <th class="hdmiddle">
      <bean:message key="log.browse.column.book"/>
    </th>
   
    <th class="hdmiddle">
      <bean:message key="log.browse.column.page"/>
    </th>
        
    <th class="hdmiddle">
      <bean:message key="log.browse.column.active"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="log.browse.column.note"/>
    </th>
  </tr>

  <logic:iterate id="ndx1" name="select_response">
    <tr>
      <td class="fine">
        <html:link page="/user/logEditAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
          <bean:write name="ndx1" property="rowId"/>
        </html:link>
      </td>
 
      <td class="fine">
        <bean:write name="ndx1" property="flightDate"/>
      </td>
 
      <td class="fine">
        <bean:write name="ndx1" property="regString"/>
      </td>

      <td class="fine">
        <bean:write name="ndx1" property="fromIataString"/>
      </td>

      <td class="fine">
        <bean:write name="ndx1" property="toIataString"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="totalTime"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="picTime"/>
      </td>
 
      <td class="fine">
        <bean:write name="ndx1" property="nightTime"/>
      </td>

      <td class="fine">
        <bean:write name="ndx1" property="actualIfrTime"/>
      </td>

      <td class="fine">
        <bean:write name="ndx1" property="instrumentApproach"/>
      </td>
 
      <td class="fine">
        <bean:write name="ndx1" property="purpose"/>
      </td>
 
      <td class="fine">
        <bean:write name="ndx1" property="logBook"/>
      </td>

      <td class="fine">
        <bean:write name="ndx1" property="logPage"/>
      </td>
     
      <td class="fine">
        <bean:write name="ndx1" property="active"/>
      </td>

      <td class="fine">
        <bean:write name="ndx1" property="note"/>
      </td>
    </tr>
  </logic:iterate>
</table>

<table width="0%" border="2">
  <tr>
    <td class="fine">
      <html:link page="/private/aircraftSelectAction.do?action=select_next">
        <bean:message key="navigation.next"/>
      </html:link>
    </td>

    <td class="fine">
      <html:link page="/private/aircraftSelectAction.do?action=select_last">
        <bean:message key="navigation.last"/>
      </html:link>
    </td>
  </tr>
</table>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
