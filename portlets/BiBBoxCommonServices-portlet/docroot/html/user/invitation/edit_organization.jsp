<!-- 
BiBBoxCommonServices
user/edit_invitation

 -->
 
<%@ include file="/html/user/init.jsp"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	// Parameters for permission Checking
	String tabledata = "";
	long groupId = scopeGroupId;
	String name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	String actionId_add_invitation = "ADD_INVITATION";
	String actionId_edit_invitation = "EDIT_INVITATION";

	long optionsMainContactRole_option = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", "0"));
	String optionsTypeFilter_option = GetterUtil.getString(portletPreferences.getValue("optionsTypeFilter", ""));
	long optionsParentOrganisation_option = GetterUtil.getLong(portletPreferences.getValue("optionsParentOrganisation", "0"));
	if (optionsParentOrganisation_option == 1) {
		com.liferay.portal.model.Group currentGroup = themeDisplay.getLayout().getGroup();
		if (currentGroup.isOrganization()) {
			// the group is an Organization
			optionsParentOrganisation_option = currentGroup.getClassPK();
		}
	}
	
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	long invitationId = ParamUtil.getLong(request, "invitationId");
	java.util.TreeMap<java.util.Date, String> sortetdata = new java.util.TreeMap<java.util.Date, String>();
	java.util.Date now = new java.util.Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	%>
	
	<portlet:actionURL name='updateOrganisationForInvitation' var="updateOrganisationForInvitationURL" windowState="normal" />
	<aui:form action="<%= updateOrganisationForInvitationURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
			<aui:input type="hidden" name="bibbox_cs_invitationId" value="<%= invitationId %>" />
	<%

	
	
	long counter = 0;
	List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), optionsParentOrganisation_option);
	for (Organization organization : organizations) {
		if (!optionsTypeFilter_option.equals("")) {
			if (!organization.getExpandoBridge().getAttribute("Organization Type").equals(optionsTypeFilter_option)) {
				continue;
			}
		}
		java.util.Date modifieddate = organization.getModifiedDate();
		String type = "Registry/Biobank";
		String rowcss = "bibbox-cs-datatable-cell-even";
		if(counter % 2 == 0) {
			rowcss = "bibbox-cs-datatable-cell-odd";
		}
		String checked = "";
		if(InvitationOrganisationLocalServiceUtil.getInvitationOrganisation(invitationId, organization.getOrganizationId()) != null) {
			checked = "checked=\"true\"";
		}
		
		//------
		if(!tabledata.equalsIgnoreCase("")) {
			tabledata += ",";
		}
		tabledata += "{SelectionInput: '<input " + checked + " type=\"checkbox\" name=\"_invitation_WAR_BiBBoxCommonServicesportlet_bibbox_cs_organisations_" + counter + "\" ><input type=\"hidden\" name=\"_invitation_WAR_BiBBoxCommonServicesportlet_bibbox_cs_organisationsid_" + counter + "\"  value=\"" + organization.getOrganizationId() + "\">',";
		tabledata += "OrganizationId: " + organization.getOrganizationId() + ",";
		tabledata += "Name: '" + organization.getName().replaceAll("'", "&lsquo;") + "',";
		
		
		String tablerow = "<tr class=\"" + rowcss + "\"><td class=\"" + rowcss + "\"><input " + checked + " type=\"checkbox\" name=\"_invitation_WAR_BiBBoxCommonServicesportlet_bibbox_cs_organisations_" + counter + "\" ><input type=\"hidden\" name=\"_invitation_WAR_BiBBoxCommonServicesportlet_bibbox_cs_organisationsid_" + counter + "\"  value=\"" + organization.getOrganizationId() + "\"></td><td>" + organization.getOrganizationId() + "</td><td class=\"" + rowcss + "\">" + organization.getName() + "</td>";
		List<DDLRecordSet> ddlrecordsets = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
		for(DDLRecordSet ddlrecordset : ddlrecordsets) {
			String ddlrecordsetname = String.valueOf(ddlrecordset.getNameCurrentValue());
			if(ddlrecordsetname.equals("core")) {
				List<DDLRecord> records = ddlrecordset.getRecords();
	  			for(DDLRecord record : records) {
	  				if (modifieddate.before(record.getModifiedDate())) {
	  					modifieddate = record.getModifiedDate();
	  				}
	  				if(record.getFieldValue("Radio2493") != null) {
			  			String type_field = record.getFieldValue("Radio2493").toString();
			  			if(type_field.equalsIgnoreCase("[bb]") || type_field.equalsIgnoreCase("[\"bb\"]")) {
			  				type = "Biobank";
			  			} else if(type_field.equalsIgnoreCase("[reg]") || type_field.equalsIgnoreCase("[\"reg\"]")) {
			  				type = "Registry";
			  			}
		  			}
	  			}
			} else {
				List<DDLRecord> records = ddlrecordset.getRecords();
	  			for(DDLRecord record : records) {
	  				if (modifieddate.before(record.getModifiedDate())) {
	  					modifieddate = record.getModifiedDate();
	  				}
	  			}
			}
		}
		
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
		
		tablerow += "<td class=\"" + rowcss + "\">" + type + "</td>";
		tablerow += "<td class=\"" + rowcss + "\">" + ((now.getTime() - modifieddate.getTime())/(1000 *60*60*24)) + " (" + dateFormat.format(modifieddate) + ")</td>";
		// New Table
		tabledata += "'Days since last modified': '" + ((now.getTime() - modifieddate.getTime())/(1000 *60*60*24)) + " (" + dateFormat.format(modifieddate) + ")',";
		if(maincontact != null) {
			tablerow += "<td class=\"" + rowcss + "\">" + maincontact.getFullName() + "</td>";
			// New Table
			tabledata += "'Main Contact': '" + maincontact.getFullName().replaceAll("'", "&lsquo;") + "',";
			java.util.Date lastlogin = maincontact.getLastLoginDate();
			if(lastlogin != null) {
				tablerow += "<td class=\"" + rowcss + "\">" + ((now.getTime() - lastlogin.getTime())/(1000 *60*60*24)) + " (" + dateFormat.format(lastlogin) + ")</td>";
				// New Table
				tabledata += "'Main Contact last login': '" + ((now.getTime() - lastlogin.getTime())/(1000 *60*60*24)) + " (" + dateFormat.format(lastlogin) + ")',";
			} else {
				tablerow += "<td class=\"" + rowcss + "\">Never</td>";
				// New Table
				tabledata += "'Main Contact last login': 'Never',";
			}
			
		} else {
			tablerow += "<td class=\"" + rowcss + "\"></td>";
			tablerow += "<td class=\"" + rowcss + "\"></td>";
		}
		List<InvitationOrganisation> invitationorganisations = InvitationOrganisationLocalServiceUtil.getInvitationsByOrganisation(organization.getOrganizationId());
		long numberofinvitations = 0;
		long numberofsendinvitations = 0;
		java.util.Date lastinvitation = null;
		for(InvitationOrganisation invitationorganisation : invitationorganisations) {
			numberofinvitations++;
			try {
			Invitation invitation = InvitationLocalServiceUtil.getInvitation(invitationorganisation.getInvitationId());
			if(invitation.getStatus() == 1) {
				numberofsendinvitations++;
				java.util.Date datesend = invitation.getInvitationsend();
				if(lastinvitation == null) {
					lastinvitation = datesend;
				} else {
					if(lastinvitation.before(datesend)) {
						lastinvitation = datesend;
					}
				}
			}
			} catch(Exception e) {
				
			}
		}
		String lastcontacted = "";
		if(lastinvitation != null) {
			lastcontacted = ((now.getTime() - lastinvitation.getTime())/(1000 *60*60*24)) + " (" + dateFormat.format(lastinvitation) + ") / s:" + numberofsendinvitations + "/ i:" + numberofinvitations;
		} else {
			lastcontacted = "invitations: " + numberofinvitations;
		}
		tablerow += "<td class=\"" + rowcss + "\">" + lastcontacted + "</td>";
		tablerow += "</tr>";
		// New Table
		tabledata += "'Last Contacted': '" + lastcontacted + "'}";

		/*if(sortetdata.containsKey(modifieddate)) {
			String tmp = sortetdata.get(modifieddate);
			sortetdata.put(modifieddate, tmp + tablerow);
		} else {
			sortetdata.put(modifieddate, tablerow);
		}*/
		counter++;
	}
%>
<aui:input type="hidden" name="bibbox_cs_counter" value="<%= counter %>" />

<div id="myOrganizationTable"></div>

</aui:fieldset>
<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base,aui-io-request">
	AUI().use('aui-base', function(A){
         Liferay.Util.getOpener().refreshOrganizationListPortlet();
   });
</aui:script>
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
    		key: 'Main Contact last login',
    		sortable: true
    	},
    	{
    		key: 'Last Contacted',
    		sortable: true
    	}
    ];
	var dataTable = new Y.DataTable(
      {
        columns: nestedCols,
        data: remoteData,
      }
    ).render('#myOrganizationTable');

    dataTable.get('boundingBox').unselectable();
  }
);
</aui:script>