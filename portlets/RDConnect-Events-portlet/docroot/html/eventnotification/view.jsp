<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

Subscripe to get email Notification about events in the system.

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:actionURL name='editEventNotification' var="editEventNotificationURL" windowState="normal" />
<aui:form action="<%= editEventNotificationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<%
		for(String eventtype : EventUtil.getEventTypes()) {
			%>
			<aui:input name="<%= eventtype %>" type="checkbox" label="<%= eventtype %>" />
			<%
		}
		
		%>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>