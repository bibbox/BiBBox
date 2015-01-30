<%@ include file="/html/rdconnect/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);	
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_add_diseasematrix = "ADD_DISEASEMATRIX";

long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();

	SimpleDateFormat simpledateformat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	%>
	<c:choose>
		<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_diseasematrix) %>">
			<div style="width: 800px;flaot:left;">
				<!-- Add Desease -->
				<aui:button-row>
					<portlet:renderURL var="addDiseaseMatrixURL">
						<portlet:param name="mvcPath" value="/html/rdconnect/diseasematrix/diseasematrix_edit.jsp" />
						<portlet:param name="organizationId" value="<%= Long.toString(organizationId) %>" />
						<portlet:param name="redirect" value="<%= redirect %>" />
					</portlet:renderURL>
					<aui:button value="add-diseasematrix" onClick="<%= addDiseaseMatrixURL.toString() %>"/>
				</aui:button-row>
				<!-- Upload XML -->
				<portlet:actionURL name='<%="uploadFile"%>' var="uploadFileURL" windowState="normal" />
				<aui:form action="<%=uploadFileURL%>" enctype="multipart/form-data"
					method="post" name="fm">
					<div style="width: 200px;flaot:left;">
						<aui:fieldset>
							<aui:input type="hidden" name="rdc_organisation" value="<%= organizationId %>" />
							<input type="file" name="fileupload" id="fileupload" size="60" />
						</aui:fieldset>
					</div>
					<div style="width: 200px;flaot:left;">
						<aui:button-row>
							<aui:button name="saveButton" type="submit" value="save" />
						</aui:button-row>
					</div>
				</aui:form>
				<!-- Download XML -->
				<portlet:resourceURL var="fileDownloadURL" id="fileDownload" />
				<a href="<portlet:resourceURL><portlet:param name="<%=Constants.CMD%>" value="export_xls" />
				<portlet:param name="RDCOrganisationId" value="<%= String.valueOf(organizationId) %>" />
				</portlet:resourceURL>">Download Disease Matrix as XLS File</a>
			</div>
		</c:when>
	</c:choose>
	
	<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "5")) %>' emptyResultsMessage="diseasematrix-empty-results-message">
		<liferay-ui:search-container-results
			results="<%= DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organizationId, searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%= DiseaseMatrixLocalServiceUtil.getDiseaseMatrixsCount(organizationId) %>"
		/>
	
		<liferay-ui:search-container-row
			className="at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix"
			keyProperty="diseasematrixId"
			modelVar="diseasematrix" escapedModel="<%= true %>"
		>
			<liferay-ui:search-container-column-text
				name="diseasename"
				value="<%= diseasematrix.getDiseasename() %>"
			/>
			<liferay-ui:search-container-column-text
				name="patientcount"
				value="<%= diseasematrix.getPatientcount() %>"
			/>
			<liferay-ui:search-container-column-text
				name="gene"
				value="<%= diseasematrix.getGene() %>"
			/>
			<liferay-ui:search-container-column-text
				name="orphanumber"
				value="<%= diseasematrix.getOrphanumber() %>"
			/>
			<liferay-ui:search-container-column-text
				name="icd10"
				value="<%= diseasematrix.getIcd10() %>"
			/>
			<liferay-ui:search-container-column-text
				name="omim"
				value="<%= diseasematrix.getOmim() %>"
			/>
			<liferay-ui:search-container-column-text
				name="synonym"
				value="<%= diseasematrix.getSynonym() %>"
			/>
			<liferay-ui:search-container-column-text
				name="modifieddate"
				value="<%= simpledateformat.format(diseasematrix.getModifieddate()) %>"
			/>
			<c:choose>
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_diseasematrix) %>">
					<liferay-ui:search-container-column-jsp
						align="right"
						path="/html/rdconnect/diseasematrix/diseasematrix_actions.jsp"
					/>
				</c:when>
			</c:choose>
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	
	<%
} else {
	%>
	This portlet is only available for the use in Organizations.
	<%
}
%>