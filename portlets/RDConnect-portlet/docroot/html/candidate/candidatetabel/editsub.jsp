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
J:<input id="masterid" style="width: 45px;" type="text" name="masterid" value="<%= candidate.getMasterId() %>" />
<!-- <input id="accepted" type="checkbox" name="accepted" <%= checked %> /> -->
<br>S:<% if(state.equalsIgnoreCase("P")) { %> published <% } else { %>
<select id="state" style="width: 45px;" type="text" name="state">
	<option value="X" selected='<%= state.equalsIgnoreCase("X") ? true : false %>' >X</option>
	<option value="0" selected='<%= state.equalsIgnoreCase("0") ? true : false %>' >0</option>
	<option value="1" selected='<%= state.equalsIgnoreCase("1") ? true : false %>' >1</option>
	<option value="2" selected='<%= state.equalsIgnoreCase("2") ? true : false %>' >2</option>
	<option value="3" selected='<%= state.equalsIgnoreCase("3") ? true : false %>' >3</option>
	<option value="4" selected='<%= state.equalsIgnoreCase("4") ? true : false %>' >4</option>
	<option value="5" selected='<%= state.equalsIgnoreCase("5") ? true : false %>' >5</option>
</select>
<% } %>