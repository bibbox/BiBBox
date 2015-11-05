<%@ include file="/html/idcard/init.jsp" %>

<aui:button-row cssClass="d2biobank-button">
	<portlet:renderURL var="addEntryURL">
		<portlet:param name="mvcPath" value="/html/idcard/d2biobank/edit_entry.jsp"></portlet:param>
	</portlet:renderURL>
	<aui:button onClick="<%= addEntryURL.toString() %>" value="Add Biobank"></aui:button>
</aui:button-row>

