<%@ include file="/html/demo/init.jsp" %> 
<%@ page import="com.liferay.portal.model.LayoutTypePortlet" %>

<portlet:defineObjects />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<style>
	.event-container {
		width: 353px;
		height: 100px;
		border: 1px solid black;
		margin: 20px 0 0 0;
	   	border-radius: 15px;
	}
	.event {
	   	width: 110px;
	   	height: 100px; 
	   	border: 1px solid black;
	   	border-radius: 15px;
	   	text-align: center;
	   	float: left;
	   	margin: -1px 0 0 -1px;	
	   	position: relative;
	   	top: -42px;
	   	color: #FFFFFF;
	}
	.event-text {
	   	width: 240px;
	   	height: 100px; 
	   	text-align: center;
	   	float: left;
	   	position: relative;
	   	top: -42px;
	}
	.event-date {
		position: relative;
		width: 70px;
	   	height: 40px;
	   	border: 1px solid black;
	   	background-color: #A8A8A8;
		color: #FFFFFF;
		top: -14px;
		right: -39px;
		font-size: 10px;
		line-height: 12px;
		text-align: center;
		border-radius: 5px;
	}
	
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
String redirect = PortalUtil.getCurrentURL(renderRequest);
String portletResource = ParamUtil.getString(request, "portletResource");
SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	long organizationId = currentGroup.getClassPK();
  	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
%>

<br>
<%

List<Event> events = EventLocalServiceUtil.getEventsForPatient(organizationId);

for(Event event : events) {
	Layout l = LayoutLocalServiceUtil.getLayout(themeDisplay.getScopeGroupId(), false, event.getEventId());
	LayoutTypePortlet ltp = (LayoutTypePortlet) l.getLayoutType();
	String pagetype = event.getEventtype().toLowerCase().replaceAll(" ", "");
	String typeicon = "";
	if(event.getEventGroup().equalsIgnoreCase("Act")) {
		typeicon = request.getContextPath() + "/images/act.png";
	} else {
		typeicon = request.getContextPath() + "/images/observation.png";
	}
	%>
	<div class="event-container" style="background-color: yellow; ">
		<div class="event-date"><%= dateFormat.format(event.getEventdate()) %></div>
		<div class="event <%= pagetype.toLowerCase().replaceAll(" ", "") %>">
		<img style="width: 21px; height: 20px;float: left;margin: 5px;" id='typeicon' src="<%= typeicon %>" />
		<%= pagetype %><br>
		
		</div>
		<div class="event-text"><%= l.getName() %> - <%= l.getLayoutPrototypeUuid() %></div>
	</div>
	<br>
	<%
}
%>
<br>

this: layout = <%= themeDisplay.getLayout().getLayoutPrototypeUuid() %>



<% } else { %>
	<div>The portet is not able to work in this page.</div>
<% } %>