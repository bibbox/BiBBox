<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />
A1
<%
long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
}
String eventtype = ParamUtil.getString(request, "eventtype");
//String eventdisplay = KdssmpConfigurationLocalServiceUtil.getConfigurationOption("Display", eventtype).getOptionvalue();
%>

Create Event <%= eventtype %>