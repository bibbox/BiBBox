<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>

<portlet:defineObjects />

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
MasterCandidate candidate = (MasterCandidate)row.getObject();
long organizationId = candidate.getOrganisationid();
boolean portaleditorrole = false;
for(Role role : themeDisplay.getUser().getRoles()) {
	if(role.getName().equalsIgnoreCase("PORTAL-EDITOR"))
		portaleditorrole = true;
	if(role.getName().equalsIgnoreCase("Administrator"))
		portaleditorrole = true;
}
if(portaleditorrole) {
%>
	<%= candidate.getMasterCandidateId() %>
<% 
} 
if(organizationId != 0) {
	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization.getLogoId();
	String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
	long organizationlogoid = organization.getLogoId();
	
	if(organizationlogoid == 0) {
		List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
		for(DDLRecordSet rdc_rs : rdc_recordlist) {
			String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
			if(rdc_rsname.equals("core")) {  		
	  			List<DDLRecord> records = rdc_rs.getRecords();
	  			for(DDLRecord record : records) {
	  				if(record.getFieldValue("Radio2493") != null) {
			  			String type = record.getFieldValue("Radio2493").toString();
			  			if(type.equalsIgnoreCase("[bb]") || type.equalsIgnoreCase("[\"bb\"]")) {
			  				if(organization.getLogoId() == 0) {
			  					imgPath = request.getContextPath() + "/images/Biobank.png";
			  				}
			  				if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
			  					orgPath = orgPath + "/at_home";
			  				} else {
			  					orgPath = orgPath + "/bb_home";
			  				}
			  			} else if(type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
			  				if(organization.getLogoId() == 0) {
			  					imgPath = request.getContextPath() + "/images/Registry.png";
			  				}
			  				if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
			  					orgPath = orgPath + "/at_home";
			  				} else {
			  					orgPath = orgPath + "/home";
			  				}
			  			} else {
			  				if(organization.getLogoId() == 0) {
			  					imgPath = request.getContextPath() + "/images/RegistryBiobank.png";
			  				}
			  				if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
			  					orgPath = orgPath + "/at_home";
			  				} else {
			  					orgPath = orgPath + "/regbb_home";
			  				}
			  			}
		  			}
	  			}
			}
		}
	}
	%>
	<a href="<%= orgPath %>"><img alt="logo" src="<%= imgPath %>" width="60px" /></a>
<%
} else {
	String imgPath = request.getContextPath() + "/images/NotPublished.png";
%>
	<img alt="logo" src="<%= imgPath %>" width="60px" />
<%
}
%>