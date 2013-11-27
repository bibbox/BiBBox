<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

This is the <b>Ddl Reader</b> portlet in View mode.<br><br>

<%
List<DDLRecord> rec = DDLRecordLocalServiceUtil.getRecords(14505);
for(DDLRecord r : rec) {
%>

<%= r.toString() %>
<br>

<% 
Field f = r.getField("TextNr1"); 
Fields fs = r.getFields();
%>
<%= f.getValue() %>
<br>

<%
}
%>
