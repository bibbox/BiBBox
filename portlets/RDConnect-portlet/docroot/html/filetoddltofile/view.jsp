<%@ include file="/html/init.jsp" %>

<portlet:defineObjects />

<portlet:actionURL name='<%= "uploadFile" %>' var="uploadFileURL" windowState="normal" />
<aui:form action="<%= uploadFileURL %>" enctype="multipart/form-data" method="post" name="fm" >
	<aui:fieldset>
		<input type="file" name="fileupload" id="fileupload" size="40" />
    </aui:fieldset>
    <br><br>
    <aui:button-row>
		<aui:button name="saveButton" type="submit" value="save"  />
	</aui:button-row>
</aui:form>

<portlet:resourceURL var="fileDownloadURL" id="fileDownload" />
     
<%
long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();
}

String organizationId_string = String.valueOf(organizationId);
%>
</br>
<!-- <a href="<portlet:resourceURL><portlet:param name="<%= Constants.CMD %>" value="export_csv" /><portlet:param name="RDCOrganisationId" value="<%= organizationId_string %>" /></portlet:resourceURL>">Download CSV File</a> -->
<a href="<portlet:resourceURL><portlet:param name="<%= Constants.CMD %>" value="export_xls" /><portlet:param name="RDCOrganisationId" value="<%= organizationId_string %>" /></portlet:resourceURL>">Download XLS File</a>
<!-- <a href="<portlet:resourceURL><portlet:param name="<%= Constants.CMD %>" value="export_xlsx" /><portlet:param name="RDCOrganisationId" value="<%= organizationId_string %>" /></portlet:resourceURL>">Download XLSX File</a> -->

