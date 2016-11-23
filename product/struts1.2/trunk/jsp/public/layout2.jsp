<!--
  Title: layout2.jsp
  Description: standard layout 2, AKA vbox layout
-->

<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<tiles:useAttribute id="list" name="list" classname="java.util.List"/>

<logic:iterate id="name" name="list" type="java.lang.String">
  <tiles:insert beanName="name" flush="false"/>
  <br>
</logic:iterate>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
