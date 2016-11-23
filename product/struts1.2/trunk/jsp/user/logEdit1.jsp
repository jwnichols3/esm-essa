<!--
  Title: logEdit1.jsp
  Description: Update an existing log entry.
  Legalise: Copyright (C) 2007 Digital Burro, INC.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="log.edit.title"/></h2>

<html:errors/>

<html:form action="/user/logUpdateAction?action=update" focus="registration">
  <table width="0%" border="5">
    <tr>
      <td align="right"><bean:message key="log.edit.form.book"/>:</td>
      <td><html:text property="logBook" size="3"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.page"/>:</td>
      <td><html:text property="logPage" size="3"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.date"/>:</td>
      <td>
        <html:select property="dayBeanNdx">
          <html:optionsCollection property="dayBeanArray" label="day" value="ndx"/>
        </html:select>

        <html:select property="monthBeanNdx">
          <html:optionsCollection property="monthBeanArray" label="month" value="ndx"/>
        </html:select>

        <html:select property="yearBeanNdx">
          <html:optionsCollection property="yearBeanArray" label="year" value="ndx"/>
        </html:select>
      </tr>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.aircraft"/>:</td>
      <td>
        <html:select property="aircraftNdx">
          <html:optionsCollection property="aircraftArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.from"/>:</td>
      <td>
        <html:select property="fromAirportNdx">
          <html:optionsCollection property="airportArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.to"/>:</td>
      <td>
        <html:select property="toAirportNdx">
          <html:optionsCollection property="airportArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.ia"/>:</td>
      <td><html:text property="instrumentApproach" size="3"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.takeoff"/>:</td>
      <td><html:text property="takeOff" size="3"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.landing"/>:</td>
      <td><html:text property="landing" size="3"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.night"/>:</td>
      <td>
        <html:select property="nightNdx">
          <html:optionsCollection property="durationArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.actual_instrument"/>:</td>
      <td>
        <html:select property="actualInstrumentNdx">
          <html:optionsCollection property="durationArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.simulated_instrument"/>:</td>
      <td>
        <html:select property="simulatedInstrumentNdx">
          <html:optionsCollection property="durationArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.cross_country"/>:</td>
      <td><html:checkbox property="crossCountry"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.dual"/>:</td>
      <td><html:checkbox property="dual"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.pic"/>:</td>
      <td><html:checkbox property="pic"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.total"/>:</td>
      <td>
        <html:select property="totalFlightNdx">
          <html:optionsCollection property="durationArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.purpose"/>:</td>
      <td>
        <html:select property="purposeNdx">
          <html:optionsCollection property="purposeArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.active"/>:</td>
      <td colspan="4"><html:checkbox property="active"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.edit.form.note"/>:</td>
      <td colspan="4"><html:text property="note" size="50"/></td>
    </tr>

    <tr>
      <td><html:submit value="Submit"/></td>
      <td><html:cancel/></td>
    </tr>
  </table>

  <html:hidden property="rowId"/>
</html:form>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
