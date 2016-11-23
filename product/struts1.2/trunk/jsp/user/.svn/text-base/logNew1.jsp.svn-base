<!--
  Title: logNew1.jsp
  Description: Enter a new log entry.
  Legalise: Copyright (C) 2007 Digital Burro, INC.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="log.new.title"/></h2>

<html:errors/>

<html:form action="/user/logInsertAction?action=insert" focus="dayBeanArray">
  <table width="0%" border="5">
    <tr>
      <td align="right"><bean:message key="log.new.form.book"/>:</td>
      <td><html:text property="logBook" size="3"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.page"/>:</td>
      <td><html:text property="logPage" size="3"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.date"/>:</td>
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
      <td align="right"><bean:message key="log.new.form.aircraft"/>:</td>
      <td>
        <html:select property="aircraftNdx">
          <html:optionsCollection property="aircraftArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.from"/>:</td>
      <td>
        <html:select property="fromAirportNdx">
          <html:optionsCollection property="airportArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.to"/>:</td>
      <td>
        <html:select property="toAirportNdx">
          <html:optionsCollection property="airportArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.ia"/>:</td>
      <td><html:text property="instrumentApproach" size="3"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.takeoff"/>:</td>
      <td><html:text property="takeOff" size="3"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.landing"/>:</td>
      <td><html:text property="landing" size="3"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.night"/>:</td>
      <td>
        <html:select property="nightNdx">
          <html:optionsCollection property="durationArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.actual_instrument"/>:</td>
      <td>
        <html:select property="actualInstrumentNdx">
          <html:optionsCollection property="durationArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.simulated_instrument"/>:</td>
      <td>
        <html:select property="simulatedInstrumentNdx">
          <html:optionsCollection property="durationArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.cross_country"/>:</td>
      <td><html:checkbox property="crossCountry"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.dual"/>:</td>
      <td><html:checkbox property="dual"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.pic"/>:</td>
      <td><html:checkbox property="pic"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.total"/>:</td>
      <td>
        <html:select property="totalFlightNdx">
          <html:optionsCollection property="durationArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>

    <tr>
      <td align="right"><bean:message key="log.new.form.purpose"/>:</td>
      <td>
        <html:select property="purposeNdx">
          <html:optionsCollection property="purposeArray" label="label" value="ndx"/>
        </html:select>
      </td>
    </tr>
  
    <tr>
      <td align="right"><bean:message key="log.new.form.note"/>:</td>
      <td><html:text property="note" size="50"/></td>
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
