<%@ include file="/html/demo/init.jsp" %> 
<%@ page import="com.liferay.portal.model.LayoutTypePortlet" %>

<portlet:defineObjects />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<style>
	.event-container {
		width: 253px;
		height: 85px;
		border: 1px solid black;
		margin: 0 0 5px 0;
	   	border-radius: 15px;
	}
	.event {
	   	width: 100px;
	   	height: 85px; 
	   	border: 1px solid black;
	   	border-radius: 15px;
	   	text-align: center;
	   	float: left;
	   	margin: -1px 0 0 -1px;
	}
	.event-text {
	   	width: 150px;
	   	height: 85px; 
	   	text-align: center;
	   	float: left;
	}
	
	.patient {
		background-color: #A39082;
		color: #FFFFFF;
	}
	.primärdiagnose {
		background-color: #A1D750;
		color: #FFFFFF;
	}
	.probeexcession {
		background-color: blue;
		color: #FFFFFF;
	} 
	.biopsie {
		background-color: #00A257;
		color: #FFFFFF;
	}
</style>

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
String portletResource = ParamUtil.getString(request, "portletResource");

com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	long organizationId = currentGroup.getClassPK();
  	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
%>

<portlet:actionURL name='<%= "createNewEvent" %>' var="createNewEventURL" windowState="normal" />
<aui:form action="<%= createNewEventURL %>" method="POST" name="fm">
	<aui:fieldset>
		<!-- hidden elements direct from config -->
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
	</aui:fieldset>
	<aui:button-row cssClass="proposebuttonrow">
		<aui:button type="submit" value="ABC" />
	</aui:button-row>
</aui:form>

<button id="addorganisations" type="button">Add Event</button>
<br>
<%
List<Layout> pagelayouts = themeDisplay.getLayouts();
for(Layout l : pagelayouts) {
	LayoutTypePortlet ltp = (LayoutTypePortlet) l.getLayoutType();
	String pagetype = l.getExpandoBridge().getAttribute("pageType").toString();
	%>
	<div class="event-container">
		<div class="event <%= pagetype.toLowerCase().replaceAll(" ", "") %>"><%= l.getName() %><br> 
		<%= pagetype %><br></div>
		<div class="event-text"><%= l.getName() %></div>
	</div>
	<%
}
%>
<br>
<% 
String addOrganizationURL = themeDisplay.getURLCurrent().split("[?]")[0];
if(addOrganizationURL.matches("/web/" + organizationId)) {
	addOrganizationURL += "/patient";
}
if(addOrganizationURL.matches("/web/" + organizationId + "/")) {
	addOrganizationURL += "patient";
}
addOrganizationURL = addOrganizationURL + "/-/event/createevent/" + organizationId;
%>
<%= addOrganizationURL %>
<!-- Popup for adding Organiaztions to the list -->
<aui:script use="aui-base">
            A.all('#addorganisations').on(
               'click',
               function(event) {
                  Liferay.Util.selectEntity(
                     {
                        dialog: {
                           cache: false,
                           constrain: true,
                           modal: true,
                           width: 1000,
                        },
                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_addorganisation',
                        title: '<%= "Create Event for Patient " + organization.getName() %>',
                        uri: '<%= addOrganizationURL %>'
                     }
                  );
               }
            );
</aui:script>

<% } else { %>
	<div>The portet is not able to work in this page.</div>
<% } %>