<%@include file="/html/init.jsp" %>
<portlet:defineObjects />
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
MasterCandidate candidate = (MasterCandidate)row.getObject();

String state = "";
if(candidate.getState().equalsIgnoreCase("P")) {
	state = "P";
} else {
	state = "NP";
}
%>
<div class="rdc-table-state-publisched"><%= state %></div>