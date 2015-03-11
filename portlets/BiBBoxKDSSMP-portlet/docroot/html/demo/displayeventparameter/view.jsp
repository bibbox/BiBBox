<%@ include file="/html/demo/init.jsp" %> 

<portlet:defineObjects />

<%
String groupfilter = "1";
boolean showsubgroups = true;
long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
	
	Layout event_layout = themeDisplay.getLayout();
	Event event = EventLocalServiceUtil.getEvent(event_layout.getLayoutId());
	KdssmpConfiguration eventtype_display = KdssmpConfigurationLocalServiceUtil.getConfigurationOptionValue("Display", event.getEventtype());
	List<KdssmpConfiguration> parameters = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", eventtype_display.getOptionkey());
	%>
	#<%= parameters.size() %>-<%= "Parameter" %>-<%= event.getEventtype() %>-<%= eventtype_display.getOptionkey() %>#
	<%
	for(KdssmpConfiguration parameter : parameters) {
		KdssmpParameterConfiguration parameterconfig = KdssmpParameterConfigurationLocalServiceUtil.getKdssmpParameterConfiguration(Long.parseLong(parameter.getOptionvalue()));
		String id = parameterconfig.getDatatype() + parameterconfig.getParameterconfigurationId();
		%>
		*<%= parameterconfig.getGrouping() %>*
		<%
		if((parameterconfig.getGrouping().startsWith(groupfilter) && showsubgroups) || parameterconfig.getGrouping().equals(groupfilter)) {
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
			}
		}
	}
}
%>
