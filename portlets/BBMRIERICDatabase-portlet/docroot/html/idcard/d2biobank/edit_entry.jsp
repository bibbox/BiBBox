<%@ include file="/html/idcard/init.jsp" %>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/idcard/d2biobank/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL var="addBiobankURL"></portlet:actionURL>

<aui:form action="<%= addBiobankURL %>" name="<portlet:namespace />fm">
	<aui:fieldset>

            <aui:input name="name"></aui:input>
            <aui:input name="message"></aui:input>

        </aui:fieldset>

        <aui:button-row>

            <aui:button type="submit"></aui:button>
            <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

        </aui:button-row>
</aui:form>