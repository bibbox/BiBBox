<%@ include file="/html/init.jsp"%>

<%
ParameterConfiguration parameterconfiguration = null;

	long parameterconfigurationId = ParamUtil.getLong(request, "parameterconfigurationId");

	if (parameterconfigurationId > 0) {
		parameterconfiguration = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(parameterconfigurationId);
	}
	
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='Back to list'
/>

<aui:model-context bean="<%= parameterconfiguration %>" model="<%= ParameterConfiguration.class %>" />

<portlet:actionURL name='<%= parameterconfiguration == null ? "addParameterConfiguration" : "updateParameterConfiguration" %>' var="editParameterConfigurationURL" windowState="normal" />
<aui:form action="<%= editParameterConfigurationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="parameterconfigurationId" value='<%= parameterconfiguration == null ? "" : parameterconfiguration.getParameterconfigurationId() %>'/>
		
		<aui:layout cssClass="cssgroup">
			<aui:input name="displaynameshort" />
			<aui:input name="displaynamelong" />
			<aui:input name="datatype" />
			<aui:input name="group" />
			<aui:input name="tab" />
		</aui:layout>
		
		<aui:layout cssClass="cssgroup">
			<aui:input name="viewscript" />
			<aui:input name="viewvisible" />
			<aui:input name="viewtip" />
			<aui:input name="viewtitlecss" />
			<aui:input name="viewvaluecss" />
			<aui:input name="viewcss" />
		</aui:layout>
		
		<aui:layout cssClass="cssgroup">
			<aui:input name="editscript" />
			<aui:input name="editvisible" />
			<aui:input name="edittip" />
			<aui:input name="edittitlecss" />
			<aui:input name="editvaluecss" />
			<aui:input name="editcss" />
			<aui:input name="editcolumnwidth" />
		</aui:layout>
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>