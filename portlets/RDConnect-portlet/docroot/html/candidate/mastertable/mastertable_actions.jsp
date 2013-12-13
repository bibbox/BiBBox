<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
MasterCandidate master = (MasterCandidate)row.getObject();

long masterId = master.getMasterCandidateId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu >
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/candidate/mastertable/edit_mastertable.jsp" />
		<portlet:param name="masterId" value="<%= String.valueOf(masterId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>

	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<liferay-ui:icon image="publish" url="#" />

	<portlet:actionURL name="deletePatient" var="deleteURL">
		<portlet:param name="masterId" value="<%= String.valueOf(masterId) %>" />
		<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>
		
	<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</liferay-ui:icon-menu>