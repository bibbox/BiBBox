<%@include file="/html/init.jsp" %>
<portlet:defineObjects />
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
MasterCandidate candidate = (MasterCandidate)row.getObject();
%>
<div class="rdc-table-candidatetype">
<div class="rdc-table-candidatetype-type"><%= candidate.getCandidatetype() %></div>
<div class="rdc-table-candidatetype-subtype"><%= candidate.getCandidatesubtype() %></div>
<div class="rdc-table-candidatetype-type"><br /><%= candidate.getSource() %></div>
</div>