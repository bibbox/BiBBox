<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>

<portlet:defineObjects />

<div class="rdc-portalmenu-div-container">
<span>
<aui:a href='<%= themeDisplay.getURLPortal()+"/home" %>'><img class="rdc-portalmenu-div-container-homelogo" alt="homelogo" src="<%= request.getContextPath() %>/images/home.png" height="32px" width="30px" /></aui:a>
<%
long organizationId = 0;
long userId = themeDisplay.getUserId();
List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(userId);
int i = 0;
for(Organization o : organisations) {
	organizationId = o.getOrganizationId();
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+o.getLogoId();
	String orgPath = themeDisplay.getURLPortal()+"/web"+o.getGroup().getFriendlyURL();
	
	
		List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(o.getGroupId());
	  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
	  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
	  		
	  		if(rdc_rsname.equals("core")) {  		
	  			List<DDLRecord> records = rdc_rs.getRecords();
	  			for(DDLRecord record : records) {
	  				if(record.getFieldValue("Radio2493") != null) {
		  				String type = record.getFieldValue("Radio2493").toString();
		  				if(type.equalsIgnoreCase("[bb]") || type.equalsIgnoreCase("[\"bb\"]")) {
		  					if(o.getLogoId() == 0) {
		  						imgPath = request.getContextPath() + "/images/Biobank.png";
		  					}
		  					orgPath = orgPath + "/bb_home";
		  				} else if(type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
		  					if(o.getLogoId() == 0) {
		  						imgPath = request.getContextPath() + "/images/Registry.png";
		  					}
		  					orgPath = orgPath + "/home";
		  				} else {
		  					if(o.getLogoId() == 0) {
		  						imgPath = request.getContextPath() + "/images/RegistryBiobank.png";
		  					}
		  					orgPath = orgPath + "/regbb_home";
		  				}
	  				}
	  			}
	  		}
	  	} 
	
	
	if(i>4) {
		continue;
	}
	
	%>
	<aui:a href="<%= orgPath %>"><img class="rdc-portalmenu-div-container-logo" alt="logo" height="40px" width="40px" src="<%= imgPath %>" /></aui:a>
	<%
	i++;
}

%>
</span>

<span class="rdc_portalmenu-search-input" style="float:right;">
<portlet:actionURL name='searchRDC' var="searchRDCURL" />
<% String searchurl1 = themeDisplay.getURLPortal()+"/web/guest/unified-list"; %>
<aui:form name="filterform" action="<%= searchurl1 %>" method="get" >
<aui:input name="name" label="" size="190" />
</aui:form>
<% String imgLupePath = request.getContextPath() + "/images/lupe.png"; %>
<div class="rdc_portalmenu-search-input-lupe"><img class="rdc_portalmenu-search-input-lupe-img" alt="logo" height="25px" width="25px" src="<%= imgLupePath %>" /></div>
</span>

<!--  <span>
<% String useraccountedit = "";//themeDisplay.getURLPortal() + "/my_account"; %>
<aui:a href="<%= useraccountedit %>"><%= themeDisplay.getUser().getFullName() %></aui:a>
</span>-->

</div>