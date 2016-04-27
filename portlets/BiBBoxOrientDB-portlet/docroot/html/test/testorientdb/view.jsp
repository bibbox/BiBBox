<%@include file="/html/init.jsp" %>

<%
TestGetData td = new TestGetData();
List<ODocument> documents = td.getPatients2();
%>

This is the <b>Test Orient Db</b> portlet in View mode.

<portlet:actionURL name='<%= "addPerson" %>' var="addPersonURL" windowState="normal" />
<aui:form action="<%= addPersonURL %>" method="POST" name="fm">
	<aui:button-row cssClass="proposebuttonrow">
		<aui:button type="submit" value="Test" first="true" />
	</aui:button-row>
</aui:form>

<%
for(ODocument document : documents) {
	%>
	<%= document.field("name").toString() %> - <%= document.field("surname").toString() %><br>
	<%
}
%>
