<%@ include file="/html/rdconnect/init.jsp" %> 

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
DiseaseMatrix diseasematrix = (DiseaseMatrix)row.getObject();

String name = DiseaseMatrix.class.getName();
long diseasematrixId = diseasematrix.getDiseasematrixId();

String redirect = PortalUtil.getCurrentURL(renderRequest);

long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();
}
%>

<liferay-ui:icon-menu >

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/rdconnect/diseasematrix/diseasematrix_edit.jsp" />
		<portlet:param name="organizationId" value="<%= Long.toString(organizationId) %>" />
		<portlet:param name="diseasematrixId" value="<%= String.valueOf(diseasematrixId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<portlet:actionURL name="deleteDiseaseMatrix" var="deleteURL">
		<portlet:param name="diseasematrixId" value="<%= String.valueOf(diseasematrixId) %>"/>
		<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

</liferay-ui:icon-menu>