<%@ include file="/html/init.jsp" %>

<portlet:defineObjects />

<%
List<RDCRecommender> recommanders = RDCRecommenderLocalServiceUtil.getReconnandationsForUser(themeDisplay.getUserId());
if(recommanders != null) {
	%>
	<%= recommanders.size() %>
	<%
	for(RDCRecommender recommander : recommanders) {
		%>
		<%= recommander.getRdcrecommenderid() %> - <%= recommander.getOrganisationId() %> - <%= recommander.getRecommendervalue() %> <br>
		<%
	}
}
%>