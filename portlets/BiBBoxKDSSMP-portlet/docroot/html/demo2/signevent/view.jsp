<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />

<%
long eventlayoutid =  themeDisplay.getLayout().getPlid();
long eventId = 0;
Event event = EventLocalServiceUtil.getEventForLayout(eventlayoutid);
eventId = event.getEventId();

%>
<portlet:actionURL name='signEvent' var="signEventURL" windowState="normal" />
<aui:form action="<%= signEventURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input type="hidden" name="eventId" value="<%= String.valueOf(eventId) %>" />
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
			<aui:button type="submit" value="Sign/Finalize"/>
		</aui:button-row>
</aui:form>