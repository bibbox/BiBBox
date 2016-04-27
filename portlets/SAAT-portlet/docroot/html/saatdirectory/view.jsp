<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

This is the <b>Saat Directory</b> portlet in View mode.

<%
List<Dictionary> dictionaries = DictionaryLocalServiceUtil.getRootNodes();
for(Dictionary dictionarie : dictionaries) {
%>
<%= dictionarie.getSynonym() %><br>
<%
}
%>