<%@ include file="/html/network/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);	
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_add_organization_to_network = "ADD_ORGANIZATION_TO_NETWORK";

// Load config parameters
long optionsMainContactRole_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", "0"));

// Main Fuctionality
long networkid= 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
java.util.TreeMap<java.util.Date, String> sortetdata = new java.util.TreeMap<java.util.Date, String>(Collections.reverseOrder());
if (currentGroup.isOrganization()) {
	// the group is an Organization
	networkid = currentGroup.getClassPK();
	%>
	<c:choose>
		<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_organization_to_network) %>">
			<portlet:renderURL var="addorganisationsURL">
				<portlet:param name="mvcPath" value="/html/network/networkvieworganizations/nvo_edit.jsp" />
				<portlet:param name="redirect" value="<%= redirect %>"/>
				<portlet:param name="networkId" value="<%= String.valueOf(networkid) %>"/>
			</portlet:renderURL>
			<aui:a href="<%= addorganisationsURL.toString() %>" cssClass="btn">Add Registry/Biobank</aui:a><br>
		</c:when>
	</c:choose>
	<%
  	List<Networks> networks = NetworksLocalServiceUtil.getNetworkOrganizations(networkid);
  	if(networks == null || networks.size() == 0) {
  		%>
		There is no Registry or Biobank in this network listed.<br>
		<%
  	} else {
	  	for(Networks network : networks) {
	  		Organization organization = OrganizationLocalServiceUtil.getOrganization(network.getOrganizationId());
			String country = "";
			java.util.Date modifieddate = organization.getModifiedDate();
			long organizationId = organization.getOrganizationId();
			String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization.getLogoId();
			String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
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
			// Modification Date
			List<DDLRecordSet> recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
			for(DDLRecordSet recordset : recordlist) {
				String recordsetname = String.valueOf(recordset.getNameCurrentValue());
				List<DDLRecord> records = recordset.getRecords();
					for(DDLRecord record : records) {
		  			if (modifieddate.before(record.getModifiedDate())) {
		  				modifieddate = record.getModifiedDate();
			  		}
			  	}
			}
			// Create cards
			String tableandcontent = "";
			 	
		 	tableandcontent += "<table class=\"rdc_coreinformation_organisation-table-images\">";
		  	tableandcontent += "<tr>";
		  	tableandcontent += "<td rowspan=\"4\" width=\"80px\"><a href=\"" + orgPath + "\"><img alt=\"logo\" src=\"" + imgPath + "\" width=\"60px\" /></a></td>";
		  	tableandcontent += "<td><a href=\"" + orgPath + "\">" + organization.getName() + "</a>";
		  	tableandcontent += "</td>";
		  	tableandcontent += "</tr>";
		  	tableandcontent += "<tr><td>Contact:";
			User maincontact = null;
			List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
			for(User usertmp : userlist) {
				List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(usertmp.getUserId(), organization.getGroup().getGroupId());
				for (UserGroupRole ugr : usergrouprolles) {
					if(ugr.getRoleId() == optionsMainContactRole_cfg) {
						maincontact =  usertmp;
					}
				}
			}
			if(maincontact != null) {
				tableandcontent += "<a href=\"mailto:" + maincontact.getEmailAddress() + "\">" + maincontact.getFullName() + "</a>";
			}
			tableandcontent += "</td></tr>";
			tableandcontent += "<tr><td class=\"rdc_coreinformation_organisation-table-images-bottomborder\">";
			for(com.liferay.portal.model.Website website : WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId())) {
				tableandcontent += "<a href=\"" + website.getUrl() + "\">" + website.getUrl() + "</a>";
			}
			tableandcontent += "</td></tr>";
			tableandcontent += "</table><br>";
			
			// Add Organization to sorting tree
			if(sortetdata.containsKey(modifieddate)) {
				String tmp = sortetdata.get(modifieddate);
				sortetdata.put(modifieddate, tmp + tableandcontent);
			} else {
				sortetdata.put(modifieddate, tableandcontent);
			}
		}
  		for(java.util.Date date : sortetdata.keySet()) {
			%><%= sortetdata.get(date) %><%	
		}
  	}
} else {
	%>
	This portlet is only available for the use in Organizations.
	<%
}
%>