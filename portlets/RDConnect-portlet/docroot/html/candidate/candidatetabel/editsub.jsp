<%@include file="/html/init.jsp" %>
<portlet:defineObjects />
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Candidate candidate = (Candidate)row.getObject();

String checked = "";
if(candidate.getAccepted())
	checked = "checked";
%>

<input id="candidateid"  type="hidden" name="candidateid" value="<%= candidate.getCandidateId() %>" />
<input id="masterid" style="width: 60px;" type="text" name="masterid" value="<%= candidate.getMasterId() %>" />
<input id="accepted" type="checkbox" name="accepted" <%= checked %> />