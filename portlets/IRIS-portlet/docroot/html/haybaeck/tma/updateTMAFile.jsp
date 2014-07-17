<%@ include file="/html/haybaeck/init.jsp" %>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	String currentUrl = PortalUtil.getCurrentURL(renderRequest);	
	String redirect_main = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:header
      backURL="<%= redirect %>"
      localizeTitle="<%= false %>"
      title="Back to TMA"
   />
   
   
   <portlet:actionURL name='<%="uploadFile"%>' var="uploadFileURL" windowState="normal" />

<aui:form action="<%=uploadFileURL%>" enctype="multipart/form-data" method="post" name="fm">
	<div style="width: 200px;flaot:left;">
	<aui:fieldset>
		<input type="file" name="fileupload" id="fileupload" size="60" />
	</aui:fieldset>
	</div>
	<div style="width: 200px;flaot:left;">
	<aui:button-row>
		<aui:button name="saveButton" type="submit" value="save" />
	</aui:button-row>
	</div>
</aui:form>