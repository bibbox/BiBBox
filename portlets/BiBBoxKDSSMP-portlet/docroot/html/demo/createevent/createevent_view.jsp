<%@ include file="/html/demo/init.jsp" %> 
<%@ page import="com.liferay.portal.model.LayoutTypePortlet" %>

<portlet:defineObjects />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<style>
	<%
	List<KdssmpConfiguration> options = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("CSSConfig");
	for(KdssmpConfiguration option : options) {
		%>
		<%= "." + option.getOptionkey().toLowerCase().replaceAll(" ", "") + "{" %> 
		<%= option.getOptionvalue() %>
		<%= "}" %>
		<%
	}
	%>
</style>

<%
HashMap<String, String> eventcreation = new HashMap<String, String>();
List<KdssmpConfiguration> event_options = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("EventGroup");
for(KdssmpConfiguration event_option : event_options) {
	if(eventcreation.containsKey(event_option.getOptionvalue())) {
		eventcreation.put(event_option.getOptionvalue(), eventcreation.get(event_option.getOptionvalue()) + "<br>" + "&nbsp<i id=\"addorganisations\" style=\"cursor: pointer;\" class=\"fa fa-plus\">&nbsp" + event_option.getOptionkey() + "</i>");
	} else {
		eventcreation.put(event_option.getOptionvalue(), "&nbsp<i id=\"addorganisations\" style=\"cursor: pointer;\" class=\"fa fa-plus\">&nbsp" + event_option.getOptionkey() + "</i>");
	}
}
for(String key : eventcreation.keySet()) {
	%>
	<div style="border-style: solid;border-width: 1px; margin-bottom: 5px;border-radius: 5px;">
	<div style="background-color: blue; color: #FFFFFF;">
	<%= key %> :
	</div>
	<%= eventcreation.get(key) %><br>
	</div>
	<%
}
%>