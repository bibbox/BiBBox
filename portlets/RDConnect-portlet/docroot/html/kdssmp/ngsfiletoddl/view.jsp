<%@ include file="/html/init.jsp"%>
<portlet:defineObjects />

<%
   long organizationId = 0;
   com.liferay.portal.model.Group currentGroup = themeDisplay
         .getLayout().getGroup();
   if (currentGroup.isOrganization()) {
      // the group is an Organization
      organizationId = currentGroup.getClassPK();
   }

   String organizationId_string = String.valueOf(organizationId);
%>
<portlet:actionURL name='<%="uploadFile"%>' var="uploadFileURL" windowState="normal" />
<div style="width: 900px;flaot:left;">
<aui:form action="<%=uploadFileURL%>" enctype="multipart/form-data" method="post" name="fm">
	<div style="width: 200px;flaot:left;">
	
	<aui:fieldset>
		<aui:input type="hidden" name="rdc_organisation" value="<%= organizationId %>" />
		<aui:input type="hidden" name="rdc_ddlname" value="CaseVCFReport" />
		<input type="file" name="fileupload" id="fileupload" size="60" />
	</aui:fieldset>
	</div>
	<div style="width: 200px;flaot:left;">
	<aui:button-row>
		<aui:button name="saveButton" type="submit" value="save" />
	</aui:button-row>
	</div>
</aui:form>
</div>

<portlet:resourceURL var="fileDownloadURL" id="fileDownload" />
<a href="<portlet:resourceURL><portlet:param name="<%=Constants.CMD%>" value="export_xls" />
<portlet:param name="RDCOrganisationId" value="<%=organizationId_string%>" />
<portlet:param name="RDCDDLName" value="CaseVCFReport" />
</portlet:resourceURL>">Download DDL as XLS File</a>