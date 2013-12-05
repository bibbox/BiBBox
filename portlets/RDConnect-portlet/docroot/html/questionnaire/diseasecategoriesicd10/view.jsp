<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<b>Disease Categories ICD10 Groups</b>

<%
DiseaseCategoriesICD10.getAllDDDLRecorsForDiseaseCategories();
%>
