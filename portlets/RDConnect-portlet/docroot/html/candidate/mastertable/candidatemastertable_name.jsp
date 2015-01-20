<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.WebsiteLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Website" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>

<portlet:defineObjects />
<%

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
MasterCandidate candidate = (MasterCandidate)row.getObject();

long BiobanK_REG_MAINCONTACT = 71378;
String orgPath = "";
String weburl = candidate.getUrl();
String contactperson = candidate.getContactperson();
String contactemail = candidate.getMail();
if(candidate.getState().equalsIgnoreCase("P") && candidate.getOrganisationid()!= 0 ) {
	try {
		Organization organization = OrganizationLocalServiceUtil.getOrganization(candidate.getOrganisationid());
	
		orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
		List<Website> websites = WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
		for(Website website : websites) {
			if(website.isPrimary()) {
				weburl =  website.getUrl();
			}
		}
		
		User maincontact = null;
		List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
		for(User usertmp : userlist) {
			List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(usertmp.getUserId(), organization.getGroup().getGroupId());
			for (UserGroupRole ugr : usergrouprolles) {
				if(ugr.getRole().getName().equalsIgnoreCase("BiobanK-REG-MAINCONTACT")
						|| ugr.getRole().getName().equalsIgnoreCase("Biobank, Registry Main Contact")
						|| ugr.getRole().getName().equalsIgnoreCase("BiobanK-REG-MAINCONTACT")) {
					contactperson = usertmp.getFullName();
					contactemail = usertmp.getEmailAddress();
				}
			}
		}
		
		if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("Biobank")) {
			orgPath = orgPath + "/bb_home";
		} else {
			orgPath = orgPath + "/reg_home";
		}
			
	} catch(Exception ex) {
		
	}
}
String name = "";
if(orgPath.equalsIgnoreCase("")) {
	name = candidate.getName();
} else {
	name = "<a href=\"" + orgPath + "\" target=\"_blank\">" + candidate.getName() + "</a>";
}
%>
<div class="rdc-table-nameentry">
<div class="rdc-table-nameentry-name"><%= name %></div>
<div class="rdc-table-nameentry-contact"><%= contactperson %>, <%= contactemail %></div>
<div class="rdc-table-nameentry-url"><a href="<%= weburl %>"><%= weburl %></a></div>
</div>