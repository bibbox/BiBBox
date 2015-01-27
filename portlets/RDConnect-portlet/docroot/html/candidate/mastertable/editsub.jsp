<%@include file="/html/init.jsp" %>
<portlet:defineObjects />
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
MasterCandidate candidate = (MasterCandidate)row.getObject();

String checked = "";
if(candidate.getAccepted())
	checked = "checked";
String state = candidate.getState();
%>

<input id="candidateid"  type="hidden" name="candidateid" value="<%= candidate.getMasterCandidateId() %>" />
<br>S:<% if(state.equalsIgnoreCase("P")) { %> 
published 
<% } else { %>
<select id="state" style="width: 120px;" type="text" name="state">
	<option value="X" <%= state.equalsIgnoreCase("X") ? "selected" : "" %> >Delete</option>
	<option value="0" <%= state.equalsIgnoreCase("0") ? "selected" : "" %> >Not Decided</option>
	<option value="1" <%= state.equalsIgnoreCase("1") ? "selected" : "" %> >Accepted</option>
</select>
<% } %>