<%@ include file="/html/test/init.jsp" %>

This is the <b>Test Background Tasks</b> portlet in View mode.

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/test/testbackgroundtasks/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name='<%= "testBackgroundTasks" %>' var="testBackgroundTasksURL"></portlet:actionURL>
<aui:form action="<%= testBackgroundTasksURL %>" method="POST" name="<portlet:namespace />fm">
	<aui:fieldset>

            <aui:input name="TaskName"></aui:input>

        </aui:fieldset>

        <aui:button-row>

            <aui:button type="submit"></aui:button>
            <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

        </aui:button-row>
</aui:form>
