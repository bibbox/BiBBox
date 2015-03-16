<%@ include file="/html/demo/init.jsp" %> 

<portlet:defineObjects />

<style>
	.notdisplayInput {
		display: none;
	}
	.aui .highliteMultiselect {
		border: 1px solid red;
	}
	.highliteMultiselectElement {
		border: 1px solid red;
		color: red;
	}
	.aui select[multiple] {
		height: 200px;
	}
</style>

<%
String optionsGroupFilter_cfg = GetterUtil.getString(portletPreferences.getValue("optionsGroupFilter", ""));
String optionsTitle_cfg = GetterUtil.getString(portletPreferences.getValue("optionsTitle", ""));
boolean showsubgroups = true;
long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();

%><h3><%= optionsTitle_cfg %></h3>
<portlet:actionURL name='createEvent' var="createEventURL" windowState="normal" />

<aui:form action="<%= createEventURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input type="hidden" name="patientId" value="<%= String.valueOf(organizationId) %>" />
<%

if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	Layout event_layout = themeDisplay.getLayout();
	Event event = EventLocalServiceUtil.getEvent(event_layout.getLayoutId());
	KdssmpConfiguration eventtype_display = KdssmpConfigurationLocalServiceUtil.getConfigurationOptionValue("Display", event.getEventtype());
	List<KdssmpConfiguration> parameters = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", eventtype_display.getOptionkey());
	for(KdssmpConfiguration parameter : parameters) {
		KdssmpParameterConfiguration parameterconfig = KdssmpParameterConfigurationLocalServiceUtil.getKdssmpParameterConfiguration(Long.parseLong(parameter.getOptionvalue()));
		String id = parameterconfig.getDatatype() + parameterconfig.getParameterconfigurationId();
		if((parameterconfig.getGrouping().startsWith(optionsGroupFilter_cfg) && showsubgroups) || parameterconfig.getGrouping().equals(optionsGroupFilter_cfg)) {
			if(parameterconfig.getDatatype().equalsIgnoreCase("html")) {
				%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/html.jspf" %><%
			} else if(parameterconfig.getDatatype().equalsIgnoreCase("text")) {
				%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/text.jspf" %><%
			} else if(parameterconfig.getDatatype().equalsIgnoreCase("textbox")) {
				%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/textbox.jspf" %><%
			} else if(parameterconfig.getDatatype().equalsIgnoreCase("Select")) {
				%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/select.jspf" %><%
			} else if(parameterconfig.getDatatype().equalsIgnoreCase("Multiselect")) {
				%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/multiselect.jspf" %><%
			} else if(parameterconfig.getDatatype().equalsIgnoreCase("Calculated")) {
				%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/calculated.jspf" %><%
			}  
		}
	}
}
%>
		</aui:layout>
		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>
