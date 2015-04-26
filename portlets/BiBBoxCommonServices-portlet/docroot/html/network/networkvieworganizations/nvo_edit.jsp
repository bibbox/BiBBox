<%@ include file="/html/network/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String tabledata = "";	
long optionsMainContactRole_option = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", "0"));
long optionsParentOrganisation_option = GetterUtil.getLong(portletPreferences.getValue("optionsParentOrganisation", "0"));
String redirect = PortalUtil.getCurrentURL(renderRequest);
long networkId = ParamUtil.getLong(request, "networkId");
%>
	
<portlet:actionURL name='updateNetworkOrganisations' var="updateNetworkOrganisationsURL" windowState="normal" />
<aui:form action="<%= updateNetworkOrganisationsURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="bibbox_cs_networkId" value="<%= networkId %>" />
		<%
		long counter = 0;
		List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), optionsParentOrganisation_option);
		for (Organization organization : organizations) {
			String type = "Registry/Biobank";
			String checked = "";
			if(NetworksLocalServiceUtil.isOrganizationInNetwork(organization.getOrganizationId(), networkId)) {
				checked = "checked=\"true\"";
			}
		
			if(!tabledata.equalsIgnoreCase("")) {
				tabledata += ",";
			}
			tabledata += "{SelectionInput: '<input " + checked + " type=\"checkbox\" name=\"_networkvieworganizations_WAR_BiBBoxCommonServicesportlet_bibbox_cs_organisations_" + counter + "\" ><input type=\"hidden\" name=\"_networkvieworganizations_WAR_BiBBoxCommonServicesportlet_bibbox_cs_organisationsid_" + counter + "\"  value=\"" + organization.getOrganizationId() + "\">',";
			tabledata += "OrganizationId: " + organization.getOrganizationId() + ",";
			tabledata += "Name: '" + organization.getName().replaceAll("'", "&lsquo;") + "',";
			
			User maincontact = null;
			List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
			for(User user_mc : userlist) {
				List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user_mc.getUserId(), organization.getGroup().getGroupId());
				for (UserGroupRole ugr : usergrouprolles) {
					if(ugr.getRoleId() == optionsMainContactRole_option) {
						maincontact =  user_mc;
					}
				}
			}
			
			if(maincontact != null) {
				tabledata += "'Main Contact': '" + maincontact.getFullName().replaceAll("'", "&lsquo;") + "',";
			}
			type = organization.getExpandoBridge().getAttribute("Organization Type").toString();
			tabledata += "'Type': '" + type + "'}";
			
			counter++;
		}
		
		%>
		<aui:input type="hidden" name="bibbox_cs_counter" value="<%= counter %>" />

		<div id="listOrganizationTable"></div>

	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script use="node,aui-datatable,aui-datatype,datatable-sort">
AUI().use(
  'aui-datatable',
  'aui-datatype',
  'datatable-sort',
  function(Y) {
    var remoteData = [<%= tabledata %>];
    var nestedCols = [ 
    	{
    		key: 'SelectionInput',
    		sortable: true,
    		allowHTML: true,
    	},
    	{
    		key: 'OrganizationId',
    		sortable: true
    	},
    	{
    		key: 'Name',
    		sortable: true
    	},
    	{
    		key: 'Main Contact',
    		sortable: true
    	},
    	{
    		key: 'Type',
    		sortable: true
    	}
    ];
	var dataTable = new Y.DataTable(
      {
        columns: nestedCols,
        data: remoteData,
      }
    ).render('#listOrganizationTable');

    dataTable.get('boundingBox').unselectable();
  }
);
</aui:script>