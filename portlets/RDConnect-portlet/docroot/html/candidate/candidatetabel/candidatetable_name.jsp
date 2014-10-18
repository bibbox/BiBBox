<%@include file="/html/init.jsp" %>
<portlet:defineObjects />
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Candidate candidate = (Candidate)row.getObject();

String name = "";
if(candidate.getUrl().equalsIgnoreCase("")) {
	name = candidate.getName();
} else {
	if(candidate.getUrl().startsWith("http")) {
		name = "<a href=\"" + candidate.getUrl() + "\" target=\"_blank\">" + candidate.getName() + "</a>";
	} else {
		name = "<a href=\"http://" + candidate.getUrl() + "\" target=\"_blank\">" + candidate.getName() + "</a>";
	}
}
%>
<div class="rdc-table-nameentry">
<div class="rdc-table-nameentry-name"><%= name %></div>
<div class="rdc-table-nameentry-diseases"><%= candidate.getDiseasesfreetext() %>, <%= candidate.getDiseasescodes() %></div>
<div class="rdc-table-nameentry-contact"><%= candidate.getContactperson() %>, <%= candidate.getMail() %></div>
<div class="rdc-table-nameentry-contact"><%= candidate.getDate() %></div>
</div>