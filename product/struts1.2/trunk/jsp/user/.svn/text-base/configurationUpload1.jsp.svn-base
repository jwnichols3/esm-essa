<!--
  Title: configurationUpload1.jsp
  Description: prepare for configuration upload
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="upload.new.title"/></h2>

<html:errors/>

<html:form action="/user/configurationInsertAction?action=upload" enctype="multipart/form-data">
  <table width="0%" border="5">
    <tr>
      <td align="right"><bean:message key="upload.form.file"/>:</td>
      <td><html:file size="50" property="rawItem"/></td>
    </tr>

    <tr>
      <td><html:submit value="Submit"/></td>
    </tr>
  </table>
</html:form>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
