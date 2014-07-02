<%@ include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>

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
   organizationId_string = "13162";
   
%>


<portlet:actionURL name='<%="uploadFile"%>' var="uploadFileURL"
   windowState="normal" />
<div style="width: 900px;flaot:left;display:none;">

<p>
   you can complete the "disease matrix" also by using this xls file. The file can be downloaded, filled in and uploaded directly into the system
      
</p>
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
</div>
<portlet:resourceURL var="fileDownloadURL" id="fileDownload" /><a href="<portlet:resourceURL><portlet:param name="<%=Constants.CMD%>" value="export_xls" /><portlet:param name="exportlist" value="Equipment Inventory List" /><portlet:param name="RDCOrganisationId" value="38350" /></portlet:resourceURL>"> Equipment Item</a>
<br>
<portlet:resourceURL var="fileDownloadURL" id="fileDownload" /><a href="<portlet:resourceURL><portlet:param name="<%=Constants.CMD%>" value="export_xls" /><portlet:param name="exportlist" value="ICT Equipment" /><portlet:param name="RDCOrganisationId" value="15943" /></portlet:resourceURL>"> ICT Equipment</a>
<br>
<portlet:resourceURL var="fileDownloadURL" id="fileDownload" /><a href="<portlet:resourceURL><portlet:param name="<%=Constants.CMD%>" value="export_xls" /><portlet:param name="exportlist" value="Telefone" /><portlet:param name="RDCOrganisationId" value="15939" /></portlet:resourceURL>"> Telefone</a>