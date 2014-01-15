<%@include file="/html/init.jsp" %>
<portlet:defineObjects />
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
MasterCandidate candidate = (MasterCandidate)row.getObject();

String state = "";
if(candidate.getState().equalsIgnoreCase("P") && candidate.getOrganisationid()!= 0 ) {
	Organization organisations = OrganizationLocalServiceUtil.getOrganization(candidate.getOrganisationid());
	String orgPath = themeDisplay.getURLPortal()+"/web"+organisations.getGroup().getFriendlyURL();
	state = "P";
	%>
	<aui:a href="<%= orgPath %>"><div class="rdc-table-state-publisched"><%= state %></div></aui:a>
	<%
} else {
	state = "NP";
%>
<div class="rdc-table-state-publisched"><%= state %></div>

<%
}
%>