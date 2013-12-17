<%@include file="/html/init.jsp" %>
<portlet:defineObjects />
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Candidate candidate = (Candidate)row.getObject();
%>
<div class="rdc-table-candidatetype">
<div class="rdc-table-candidatetype-type"><%= candidate.getCandidatetype() %></div>
<div class="rdc-table-candidatetype-subtype"><%= candidate.getCandidatesubtype() %></div>
</div>