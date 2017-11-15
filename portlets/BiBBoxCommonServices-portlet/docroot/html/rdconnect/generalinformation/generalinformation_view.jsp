<%@ include file="/html/rdconnect/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);	
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_manage_maincontact = "EDIT_GENERALINFORMATION";

long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();
  	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
  	GeneralInformation generalinformation = GeneralInformationLocalServiceUtil.getGeneralInformationByOrganization(organizationId);
  	long generalinformationId = 0;
  	if(generalinformation != null) {
  		generalinformationId = generalinformation.getGeneralinformationId();
  	}

	SimpleDateFormat simpledateformat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	%>
	<c:choose>
		<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_manage_maincontact) %>">
			<aui:button-row>
			<portlet:renderURL var="editGeneralInformationURL">
				<portlet:param name="mvcPath" value="/html/rdconnect/generalinformation/generalinformation_edit.jsp" />
				<portlet:param name="generalinformationId" value="<%= String.valueOf(generalinformationId) %>" />
				<portlet:param name="organizationId" value="<%= String.valueOf(organizationId) %>" />
				<portlet:param name="redirect" value="<%= redirect %>" />
			</portlet:renderURL>
				<aui:button value="edit-generalinformation" onClick="<%= editGeneralInformationURL.toString() %>"/>
		</aui:button-row>
		</c:when>
	</c:choose>
	
	<h1><%= organization.getName() %></h1>
	<%
	if(generalinformation != null) {
		%>
		Type of Hoste Institution: <%= generalinformation.getTypeofhosteinstitue() %><br />
		Source of funding: <%= generalinformation.getSourceoffunding() %><br />
		Target population: <%= generalinformation.getTargetpopulation() %><br />
		Year of establishment: <%= generalinformation.getYearofestablishment() %><br />
		RD coverage: <%= generalinformation.getHowmanyrdsareintheregistrybiobank() %><br />
		Ontologies used: <%= generalinformation.getOntologies() %><br />
		Biomaterial available: <%= generalinformation.getBiomaterialcollected() %><br />
		<%= generalinformation.getBiomaterialcollectedinbiobankFormated() %>
		Imaging available: <%= generalinformation.getImagingavailable() %><br />
		Also listed in: <%= generalinformation.getTheregistrybiobanksislistedinotherinventoriesnetworks() %><br />
		<%= generalinformation.getDescription() %><br />
		<%
	} else {
		%>
		Type of Hoste Institution:<br />
		Source of funding:<br />
		Target population:<br />
		Year of establishment:<br />
		RD coverage:<br />
		Ontologies used:<br />
		Biomaterial available:<br />
		Imaging available:<br />
		Also listed in:<br />
		<% 
	}
}
%>
