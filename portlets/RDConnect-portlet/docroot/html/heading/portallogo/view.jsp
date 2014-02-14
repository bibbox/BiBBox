<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>

<portlet:defineObjects />

<%
long organizationId = 0;
long comunity_id = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isUser()) {
 	// the group is a private user community
 	// getting the userId of the group's owner is
  	organizationId = currentGroup.getClassPK();
  	//System.out.println("user group - user id :" +  userId );
}
else if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();
  	//System.out.println("Organization group - organizationId  :" +  organizationId );
}
else {
 	// its a normal community
 	//System.out.println("its a normal community");
	comunity_id = currentGroup.getClassPK();
}
if(organizationId != 0) {
	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization.getLogoId();
	
	if(organization.getLogoId() == 0) {
		List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
	  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
	  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
	  		
	  		if(rdc_rsname.equals("core")) {  		
	  			List<DDLRecord> records = rdc_rs.getRecords();
	  			for(DDLRecord record : records) {
	  				String type = record.getFieldValue("Radio2493").toString();
	  				if(type.equalsIgnoreCase("[bb]") || type.equalsIgnoreCase("[\"bb\"]")) {
	  					imgPath = request.getContextPath() + "/images/Biobank.png";
	  				} else if(type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
	  					imgPath = request.getContextPath() + "/images/Registry.png";
	  				} else {
	  					imgPath = request.getContextPath() + "/images/RegistryBiobank.png";
	  				}
	  			}
	  		}
	  	} 
	}
	
	%>
		<img alt="logo" src="<%= imgPath %>" width="180px" height="180px" />
	<%
} else {
	%>
		<img alt="logo" src="<%= request.getContextPath() %>/images/RDLogoglobe.png" width="180px" height="180px" />
	<%
}
%>

<br />

