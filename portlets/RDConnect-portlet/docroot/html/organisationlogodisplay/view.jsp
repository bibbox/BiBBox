<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.WebsiteLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>

<portlet:defineObjects />

<%
long organizationId = 0;
long userId2 = themeDisplay.getUserId();
List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(userId2);
for(Organization organization : organisations) {
	organizationId = organization.getOrganizationId();
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization.getLogoId();
	String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
	
	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
  	
 	// Core Functions
 	String organizationtype = organization.getExpandoBridge().getAttribute("Organization Type").toString();
 	if(organizationtype.equalsIgnoreCase("Biobank")) {
 		if(organization.getLogoId() == 0) {
 			imgPath = request.getContextPath() + "/images/Biobank.png";
 		}
 		orgPath = orgPath + "/bb_home";	
 	} else {
 		if(organization.getLogoId() == 0) {
 			imgPath = request.getContextPath() + "/images/Registry.png";
 		}
 		orgPath = orgPath + "/reg_home";
 	}
  	
%>
	<p><aui:a href="<%= orgPath %>"><img alt="logo" src="<%= imgPath %>" width="120px" /><br><%= organization.getName() %></aui:a></p>
	
	
<%
}
%>
<br />



