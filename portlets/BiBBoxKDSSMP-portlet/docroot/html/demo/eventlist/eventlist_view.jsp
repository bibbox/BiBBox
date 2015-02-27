<%@ include file="/html/demo/init.jsp" %> 

<portlet:defineObjects />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
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

<%
List<Layout> pagelayouts = themeDisplay.getLayouts();
for(Layout l : pagelayouts) {
	%>
	<%= l.getName() %>
	<%
}
%>