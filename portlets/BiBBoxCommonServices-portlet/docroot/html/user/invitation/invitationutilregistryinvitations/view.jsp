<!-- 
BiBBoxCommonServices
user/invitation

 -->
<%@ include file="/html/user/init.jsp"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	List<InvitationOrganisation> invitationorganisations = InvitationOrganisationLocalServiceUtil.getInvitationOrganisationByStatus(true);
%>
<h5>
	Responded (<%=invitationorganisations.size()%>)
</h5>

<%
	// Parameters for permission Checking
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
	java.util.TreeMap<java.util.Date, String> sortetdata = new java.util.TreeMap<java.util.Date, String>();
	java.util.Date now = new java.util.Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>
<table class="bibbox-cs-datatable-table">
	<thead class="bibbox-cs-datatable-columns">
		<tr>
			<th
				class="bibbox-cs-datatable-header bibbox-cs-datatable-first-header bibbox-cs-datatable-col-name">Name</th>
			<th class="bibbox-cs-datatable-header bibbox-cs-datatable-col-name">Type</th>
			<th class="bibbox-cs-datatable-header bibbox-cs-datatable-col-name">Days
				since last modified</th>
			<th class="bibbox-cs-datatable-header bibbox-cs-datatable-col-name">Main
				Contact</th>
			<th class="bibbox-cs-datatable-header bibbox-cs-datatable-col-name">Main
				Contact last login</th>
			<th class="bibbox-cs-datatable-header bibbox-cs-datatable-col-name">Last
				Contacted</th>
			<th class="bibbox-cs-datatable-header bibbox-cs-datatable-col-name">Response</th>
		</tr>
	</thead>
	<%
		long counter = 0;

		for (InvitationOrganisation invitationorganisation : invitationorganisations) {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(invitationorganisation.getOrganisationId());
			if (!optionsTypeFilter_option.equals("")) {
				if (!organization.getExpandoBridge().getAttribute("Organization Type").equals(optionsTypeFilter_option)) {
					continue;
				}
			}
			java.util.Date modifieddate = organization.getModifiedDate();
			String type = "Registry/Biobank";
			String rowcss = "bibbox-cs-datatable-cell-even";

			if (counter % 2 == 0) {
				rowcss = "bibbox-cs-datatable-cell-odd";
			}

			// Type
			String css_class_deleted = "";
			String organization_deleted = "";
			if (organization.getParentOrganizationId() != 0) {
				css_class_deleted = "bibbox-cs-datatable-organization-deleted";
				organization_deleted = " [deleted]";
			}
			String tablerow = "<tr class=\"" + rowcss + " " + css_class_deleted + "\"><td class=\"" + rowcss + " " + css_class_deleted + "\">" + organization.getName()
					+ organization_deleted + "</td>";
			List<DDLRecordSet> ddlrecordsets = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
			for (DDLRecordSet ddlrecordset : ddlrecordsets) {
				String ddlrecordsetname = String.valueOf(ddlrecordset.getNameCurrentValue());
				if (ddlrecordsetname.equals("core")) {
					List<DDLRecord> records = ddlrecordset.getRecords();
					for (DDLRecord record : records) {
						if (modifieddate.before(record.getModifiedDate())) {
							modifieddate = record.getModifiedDate();
						}
						if (record.getFieldValue("Radio2493") != null) {
							String type_field = record.getFieldValue("Radio2493").toString();
							if (type_field.equalsIgnoreCase("[bb]") || type_field.equalsIgnoreCase("[\"bb\"]")) {
								type = "Biobank";
							} else if (type_field.equalsIgnoreCase("[reg]") || type_field.equalsIgnoreCase("[\"reg\"]")) {
								type = "Registry";
							}
						}
					}
				} else {
					List<DDLRecord> records = ddlrecordset.getRecords();
					for (DDLRecord record : records) {
						if (modifieddate.before(record.getModifiedDate())) {
							modifieddate = record.getModifiedDate();
						}
					}
				}
			}

			// Main Contact
			User maincontact = null;
			List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
			for (User user_mc : userlist) {
				List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user_mc.getUserId(), organization.getGroup().getGroupId());
				for (UserGroupRole ugr : usergrouprolles) {
					if (ugr.getRoleId() == optionsMainContactRole_option) {
						maincontact = user_mc;
					}
				}
			}

			tablerow += "<td class=\"" + rowcss + "\">" + type + "</td>";
			tablerow += "<td class=\"" + rowcss + "\">" + ((now.getTime() - modifieddate.getTime()) / (1000 * 60 * 60 * 24)) + " (" + dateFormat.format(modifieddate)
					+ ")</td>";
			if (maincontact != null) {
				tablerow += "<td class=\"" + rowcss + "\">" + maincontact.getFullName() + "</td>";
				java.util.Date lastlogin = maincontact.getLastLoginDate();
				if (lastlogin != null) {
					tablerow += "<td class=\"" + rowcss + "\">" + ((now.getTime() - lastlogin.getTime()) / (1000 * 60 * 60 * 24)) + " (" + dateFormat.format(lastlogin)
							+ ")</td>";
				} else {
					tablerow += "<td class=\"" + rowcss + "\">Never</td>";
				}

			} else {
				tablerow += "<td class=\"" + rowcss + "\"></td>";
				tablerow += "<td class=\"" + rowcss + "\"></td>";
			}
			// Last Contacted
			List<InvitationOrganisation> invitationorganisations_tmp = InvitationOrganisationLocalServiceUtil.getInvitationsByOrganisation(organization.getOrganizationId());
			long numberofinvitations = 0;
			long numberofsendinvitations = 0;
			long numberofrespons = 0;
			java.util.Date lastinvitation = null;
			for (InvitationOrganisation invitationorganisation_tmp : invitationorganisations_tmp) {
				numberofinvitations++;
				if (invitationorganisation_tmp.getReactdate() != null || invitationorganisation_tmp.getRejectdate() != null) {
					numberofrespons++;
				}
				try {
					Invitation invitation_tmp = InvitationLocalServiceUtil.getInvitation(invitationorganisation_tmp.getInvitationId());
					if (invitation_tmp.getStatus() >= InvitationLocalServiceUtil.getStatusFromString("send")) {
						numberofsendinvitations++;
						java.util.Date datesend = invitation_tmp.getInvitationsend();
						if (lastinvitation == null) {
							lastinvitation = datesend;
						} else {
							if (lastinvitation.before(datesend)) {
								lastinvitation = datesend;
							}
						}
					}
				} catch (Exception e) {

				}
			}
			String lastcontacted = "";
			if (lastinvitation != null) {
				lastcontacted = ((now.getTime() - lastinvitation.getTime()) / (1000 * 60 * 60 * 24)) + " (" + dateFormat.format(lastinvitation) + ") / s:"
						+ numberofsendinvitations + "/ i:" + numberofinvitations + "/ r:" + numberofrespons;
			} else {
				lastcontacted = "in invitations: " + numberofinvitations;
			}
			tablerow += "<td class=\"" + rowcss + " " + css_class_deleted + "\">" + lastcontacted + "</td>";
			// Response
			String response_msg = "no response";
			if (invitationorganisation.getReactdate() != null) {
				response_msg = dateFormat.format(invitationorganisation.getReactdate());
			}
			if (invitationorganisation.getRejectdate() != null) {
				response_msg = "rejected [" + dateFormat.format(invitationorganisation.getRejectdate()) + "]";
			}

			tablerow += "<td class=\"" + rowcss + "\">" + response_msg + "</td>";
			tablerow += "</tr>";

			if (sortetdata.containsKey(modifieddate)) {
				String tmp = sortetdata.get(modifieddate);
				sortetdata.put(modifieddate, tmp + tablerow);
			} else {
				sortetdata.put(modifieddate, tablerow);
			}
			counter++;
		}
		for (java.util.Date date : sortetdata.keySet()) {
	%><%=sortetdata.get(date)%>
	<%
		}
	%>
</table>

<hr>

<%
	//--------------------------------
	//   Pending
	//--------------------------------

	List<InvitationOrganisation> invitationorganisationspending = InvitationOrganisationLocalServiceUtil.getInvitationOrganisationByStatus(false);
%>
<h5>
	Pending (<%=invitationorganisationspending.size()%>)
</h5>
<table class="bibbox-cs-datatable-table">
	<thead class="bibbox-cs-datatable-columns">
		<tr>
			<th
				class="bibbox-cs-datatable-header bibbox-cs-datatable-first-header bibbox-cs-datatable-col-name">Name</th>
			<th class="bibbox-cs-datatable-header bibbox-cs-datatable-col-name">Type</th>
			<th class="bibbox-cs-datatable-header bibbox-cs-datatable-col-name">Days
				since last modified</th>
			<th class="bibbox-cs-datatable-header bibbox-cs-datatable-col-name">Main
				Contact</th>
			<th class="bibbox-cs-datatable-header bibbox-cs-datatable-col-name">Main
				Contact last login</th>
			<th class="bibbox-cs-datatable-header bibbox-cs-datatable-col-name">Last
				Contacted</th>
			<th class="bibbox-cs-datatable-header bibbox-cs-datatable-col-name">Response</th>
		</tr>
	</thead>
	<%
		counter = 0;

		for (InvitationOrganisation invitationorganisation : invitationorganisationspending) {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(invitationorganisation.getOrganisationId());
			if (!optionsTypeFilter_option.equals("")) {
				if (!organization.getExpandoBridge().getAttribute("Organization Type").equals(optionsTypeFilter_option)) {
					continue;
				}
			}
			java.util.Date modifieddate = organization.getModifiedDate();
			String type = "Registry/Biobank";
			String rowcss = "bibbox-cs-datatable-cell-even";

			if (counter % 2 == 0) {
				rowcss = "bibbox-cs-datatable-cell-odd";
			}

			// Type
			String css_class_deleted = "";
			String organization_deleted = "";
			if (organization.getParentOrganizationId() != 0) {
				css_class_deleted = "bibbox-cs-datatable-organization-deleted";
				organization_deleted = " [deleted]";
			}
			String tablerow = "<tr class=\"" + rowcss + " " + css_class_deleted + "\"><td class=\"" + rowcss + " " + css_class_deleted + "\">" + organization.getName()
					+ organization_deleted + "</td>";
			List<DDLRecordSet> ddlrecordsets = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
			for (DDLRecordSet ddlrecordset : ddlrecordsets) {
				String ddlrecordsetname = String.valueOf(ddlrecordset.getNameCurrentValue());
				if (ddlrecordsetname.equals("core")) {
					List<DDLRecord> records = ddlrecordset.getRecords();
					for (DDLRecord record : records) {
						if (modifieddate.before(record.getModifiedDate())) {
							modifieddate = record.getModifiedDate();
						}
						if (record.getFieldValue("Radio2493") != null) {
							String type_field = record.getFieldValue("Radio2493").toString();
							if (type_field.equalsIgnoreCase("[bb]") || type_field.equalsIgnoreCase("[\"bb\"]")) {
								type = "Biobank";
							} else if (type_field.equalsIgnoreCase("[reg]") || type_field.equalsIgnoreCase("[\"reg\"]")) {
								type = "Registry";
							}
						}
					}
				} else {
					List<DDLRecord> records = ddlrecordset.getRecords();
					for (DDLRecord record : records) {
						if (modifieddate.before(record.getModifiedDate())) {
							modifieddate = record.getModifiedDate();
						}
					}
				}
			}

			// Main Contact
			User maincontact = null;
			List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
			for (User user_mc : userlist) {
				List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user_mc.getUserId(), organization.getGroup().getGroupId());
				for (UserGroupRole ugr : usergrouprolles) {
					if (ugr.getRoleId() == optionsMainContactRole_option) {
						maincontact = user_mc;
					}
				}
			}

			tablerow += "<td class=\"" + rowcss + "\">" + type + "</td>";
			tablerow += "<td class=\"" + rowcss + "\">" + ((now.getTime() - modifieddate.getTime()) / (1000 * 60 * 60 * 24)) + " (" + dateFormat.format(modifieddate)
					+ ")</td>";
			if (maincontact != null) {
				tablerow += "<td class=\"" + rowcss + "\">" + maincontact.getFullName() + "</td>";
				java.util.Date lastlogin = maincontact.getLastLoginDate();
				if (lastlogin != null) {
					tablerow += "<td class=\"" + rowcss + "\">" + ((now.getTime() - lastlogin.getTime()) / (1000 * 60 * 60 * 24)) + " (" + dateFormat.format(lastlogin)
							+ ")</td>";
				} else {
					tablerow += "<td class=\"" + rowcss + "\">Never</td>";
				}

			} else {
				tablerow += "<td class=\"" + rowcss + "\"></td>";
				tablerow += "<td class=\"" + rowcss + "\"></td>";
			}
			// Last Contacted
			List<InvitationOrganisation> invitationorganisations_tmp = InvitationOrganisationLocalServiceUtil.getInvitationsByOrganisation(organization.getOrganizationId());
			long numberofinvitations = 0;
			long numberofsendinvitations = 0;
			long numberofrespons = 0;
			java.util.Date lastinvitation = null;
			for (InvitationOrganisation invitationorganisation_tmp : invitationorganisations_tmp) {
				numberofinvitations++;
				if (invitationorganisation_tmp.getReactdate() != null || invitationorganisation_tmp.getRejectdate() != null) {
					numberofrespons++;
				}
				try {
					Invitation invitation_tmp = InvitationLocalServiceUtil.getInvitation(invitationorganisation_tmp.getInvitationId());
					if (invitation_tmp.getStatus() >= InvitationLocalServiceUtil.getStatusFromString("send")) {
						numberofsendinvitations++;
						java.util.Date datesend = invitation_tmp.getInvitationsend();
						if (lastinvitation == null) {
							lastinvitation = datesend;
						} else {
							if (lastinvitation.before(datesend)) {
								lastinvitation = datesend;
							}
						}
					}
				} catch (Exception e) {

				}
			}
			String lastcontacted = "";
			if (lastinvitation != null) {
				lastcontacted = ((now.getTime() - lastinvitation.getTime()) / (1000 * 60 * 60 * 24)) + " (" + dateFormat.format(lastinvitation) + ") / s:"
						+ numberofsendinvitations + "/ i:" + numberofinvitations + "/ r:" + numberofrespons;
			} else {
				lastcontacted = "in invitations: " + numberofinvitations;
			}
			tablerow += "<td class=\"" + rowcss + " " + css_class_deleted + "\">" + lastcontacted + "</td>";
			// Response
			String response_msg = "no response";
			if (invitationorganisation.getReactdate() != null) {
				response_msg = dateFormat.format(invitationorganisation.getReactdate());
			}
			if (invitationorganisation.getRejectdate() != null) {
				response_msg = "rejected [" + dateFormat.format(invitationorganisation.getRejectdate()) + "]";
			}

			tablerow += "<td class=\"" + rowcss + "\">" + response_msg + "</td>";
			tablerow += "</tr>";

			if (sortetdata.containsKey(modifieddate)) {
				String tmp = sortetdata.get(modifieddate);
				sortetdata.put(modifieddate, tmp + tablerow);
			} else {
				sortetdata.put(modifieddate, tablerow);
			}
			counter++;
		}
		for (java.util.Date date : sortetdata.keySet()) {
	%><%=sortetdata.get(date)%>
	<%
		}
	%>
</table>