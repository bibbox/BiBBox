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
	  					orgPath = orgPath + "/bb_home";
	  				} else if(type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
	  					if(organization.getLogoId() == 0) {
	  						imgPath = request.getContextPath() + "/images/Registry.png";
	  					}
	  					orgPath = orgPath + "/home";
	  				} else {
	  					if(organization.getLogoId() == 0) {
	  						imgPath = request.getContextPath() + "/images/RegistryBiobank.png";
	  					}
	  					orgPath = orgPath + "/regbb_home";
	  				}
  				}
  			}
  		}
	}
  	if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
		orgPath = orgPath + "/at_home";
	}
%>
	<p><aui:a href="<%= orgPath %>"><img alt="logo" src="<%= imgPath %>" width="120px" /><br><%= organization.getName() %></aui:a></p>
	
	
<%
}
%>
<br />



