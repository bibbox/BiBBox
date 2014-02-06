<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>

<portlet:defineObjects />
<span>
<aui:a href='<%= themeDisplay.getURLPortal()+"/home" %>'><img alt="homelogo" src="<%= request.getContextPath() %>/images/home.png" height="40" width="34" /></aui:a>
<%
long organizationId = 0;
long userId = themeDisplay.getUserId();
List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(userId);
int i = 0;
for(Organization o : organisations) {
	organizationId = o.getOrganizationId();
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+o.getLogoId();
	String orgPath = themeDisplay.getURLPortal()+"/web"+o.getGroup().getFriendlyURL();
	
	if(o.getLogoId() == 0) {
		List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(o.getGroupId());
	  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
	  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
	  		
	  		if(rdc_rsname.equals("core")) {  		
	  			List<DDLRecord> records = rdc_rs.getRecords();
	  			for(DDLRecord record : records) {
	  				String type = record.getFieldValue("Radio2493").toString();
	  				if(type.equalsIgnoreCase("[bb]")) {
	  					imgPath = request.getContextPath() + "/images/Biobank.png";
	  				} else if(type.equalsIgnoreCase("[reg]")) {
	  					imgPath = request.getContextPath() + "/images/Registry.png";
	  				} else {
	  					imgPath = request.getContextPath() + "/images/RegistryBiobank.png";
	  				}
	  			}
	  		}
	  	} 
	}
	
	if(i>4) {
		continue;
	}
	
	%>
	<aui:a href="<%= orgPath %>"><img alt="logo" height="40" width="40" src="<%= imgPath %>" /></aui:a>
	<%
	i++;
}

%>
</span>

<span>

<% String useraccountedit = themeDisplay.getURLPortal() + "/my_account"; %>

<!--<aui:a href="<%= useraccountedit %>"><%= themeDisplay.getUser().getFullName() %></aui:a>-->

</span>

