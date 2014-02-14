<%@include file="/html/init.jsp" %>
<portlet:defineObjects />
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Candidate candidate = (Candidate)row.getObject();

String checked = "";
if(candidate.getAccepted())
	checked = "checked";
String state = candidate.getState();
%>

<input id="candidateid"  type="hidden" name="candidateid" value="<%= candidate.getCandidateId() %>" />
J:<input id="masterid" style="width: 55px;margin-left:7px;" type="text" name="masterid" value="<%= candidate.getMasterId() %>" />
<!-- <input id="accepted" type="checkbox" name="accepted" <%= checked %> /> -->
<br>S:<% if(state.equalsIgnoreCase("P")) { %> 
published 
<% } else { %>
<select id="state" style="width: 120px;" type="text" name="state">
	<option value="X" <%= state.equalsIgnoreCase("X") ? "selected" : "" %> >Rejected</option>
	<option value="0" <%= state.equalsIgnoreCase("0") ? "selected" : "" %> >Not Decided</option>
	<option value="1" <%= state.equalsIgnoreCase("1") ? "selected" : "" %> >Accepted</option>
</select>
<% } %>