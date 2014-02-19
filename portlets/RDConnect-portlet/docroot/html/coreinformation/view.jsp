<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.WebsiteLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>

<portlet:defineObjects />

<%
long organizationId = 0;
long userId2 = themeDisplay.getUserId();
List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
for(Organization organization : organizations) {
	organizationId = organization.getOrganizationId();
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization.getLogoId();
	String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
	if(organization.getName().equalsIgnoreCase("National Biobank of Test"))
		continue;
	if(organization.getName().equalsIgnoreCase("BBMUSK"))
		continue;
	if(organization.getName().equalsIgnoreCase("Medical Univeristy of Shi'Kahr"))
		continue;
	
	
	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
	
	
		
	  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
	  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
	  		
	  		if(rdc_rsname.equals("core")) {  		
	  			List<DDLRecord> records = rdc_rs.getRecords();
	  			for(DDLRecord record : records) {
	  				if(record.getFieldValue("Radio2493") != null) {
		  				String type = record.getFieldValue("Radio2493").toString();
		  				//System.out.println("Type: " + type + " recordid: " + record.getRecordId() + " organisation: " + organization.getName() );
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
%>
<table class="rdc_coreinformation_organisation-table-images">
	<tr>
		<td rowspan="4"><aui:a href="<%= orgPath %>"><img alt="logo" src="<%= imgPath %>" width="60px" /></aui:a></td>
		<td><aui:a href="<%= orgPath %>"><%= organization.getName() %></aui:a></td>
	</tr>
	<tr>
		<div id="myToggler">
			<td class="header toggler-header-collapsed">Diseases</td>
			<div class="content toggler-content-collapsed">
	<% 
	//List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
	for(DDLRecordSet rdc_rs : rdc_recordlist) {
		String rdc_rsname = rdc_rs.getNameCurrentValue();
		if(rdc_rsname.equals("Disease Matrix")) { 
			List<DDLRecord> records = rdc_rs.getRecords();
			for(DDLRecord record : records) {
				if(record.getFieldValue("Name") != null) {
					String diseasname = record.getFieldValue("Name").toString();
					if(diseasname.length() != 0) {
						%><%= diseasname %><%
					}
				}
			}
		}
	}
	%>
			</div>
		</div>
		
	</tr>
	
<tr>
		<td>Contact:
<%
User maincontact = null;
List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
for(User usertmp : userlist) {
	List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(usertmp.getUserId(), organization.getGroup().getGroupId());
	for (UserGroupRole ugr : usergrouprolles) {
		if(ugr.getRole().getName().equalsIgnoreCase("BiobanK-REG-MAINCONTACT")
				|| ugr.getRole().getName().equalsIgnoreCase("Biobank, Registry Main Contact")
				|| ugr.getRole().getName().equalsIgnoreCase("BiobanK-REG-MAINCONTACT")) {
			maincontact =  usertmp;
		}
	}
}

if(maincontact != null) {
%> 
<a href="mailto:<%= maincontact.getEmailAddress() %>"><%= maincontact.getFullName() %></a>
<% } %>
		</td>
	</tr>
	<tr>
		<td>
			<%
				for(com.liferay.portal.model.Website website : WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId())) {
			%>
			<aui:a href="<%= website.getUrl() %>"><%= website.getUrl() %></aui:a>
			<%
				}
			%>
		</td>
	</tr>	
	
</table>
<br>
<%
}
%>
<br />

<aui:script use="aui-toggler">
YUI().use(
  'aui-toggler',
  function(Y) {
    new Y.TogglerDelegate(
      {
        animated: true,
        closeAllOnExpand: true,
        container: '#myToggler',
        content: '.content',
        expanded: false,
        header: '.header',
        transition: {
          duration: 0.2,
          easing: 'cubic-bezier(0, 0.1, 0, 1)'
        }
      }
    );
  }
);
</aui:script>
