<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.util.DDMDisplay" %>

<portlet:defineObjects />

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);	

%>

<div id="myTab">

  <ul class="nav nav-tabs">
    <li class="active"><a href="#tab-1">Rename DDls</a></li>
    <li><a href="#tab-2">Add DDls to all Organisations</a></li>
    <li><a href="#tab-3">Tab #3</a></li>
  </ul>

<!-- --------------------------------------------------------------------------------- --> 
  <div class="tab-content">
    <div id="tab-1" class="tab-pane">
    	<portlet:actionURL name='<%= "renameDDLS" %>' var="renameDDLSURL" windowState="normal" />
		<aui:form action="<%= renameDDLSURL %>" method="POST" name="fm">
			<aui:fieldset>
				<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
				<aui:input type="text" name="ddlname" value="" />
				<aui:input type="text" name="structureid" value="" />
				<aui:input type="text" name="ddlnewname" value="" />
			</aui:fieldset>
			<aui:button-row>
				<aui:button type="submit"/>
			</aui:button-row>
		</aui:form>
    </div>
<!-- --------------------------------------------------------------------------------- -->    
    <div id="tab-2"  class="tab-pane">
    	<portlet:actionURL name='<%= "addDDLS" %>' var="addDDLSURL" windowState="normal" />
		<aui:form action="<%= addDDLSURL %>" method="POST" name="fm">
			<aui:fieldset>
				<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
				<aui:input type="text" name="ddlname" value="" />
				<aui:input type="text" name="structureid" value="" />
			</aui:fieldset>
			<aui:button-row>
				<aui:button type="submit"/>
			</aui:button-row>
		</aui:form>
    </div>
<!-- --------------------------------------------------------------------------------- -->
    <div id="tab-3" class="tab-pane">
      <p>Aliquid ipsum asperiores alias temporibus autem impedit soluta ut id iure explicabo veritatis consectetur debitis eaque recusandae odit quas nobis maxime saepe. Incidunt amet obcaecati. Ducimus soluta unde repellat laboriosam fuga modi rem itaque!</p>
    </div>
  </div>
<!-- --------------------------------------------------------------------------------- --> 
</div>

<aui:script use="aui-tabview">
AUI().use(
  'aui-tabview',
  function(Y) {
    new Y.TabView(
      {
        srcNode: '#myTab'
      }
    ).render();
  }
);
</aui:script>
