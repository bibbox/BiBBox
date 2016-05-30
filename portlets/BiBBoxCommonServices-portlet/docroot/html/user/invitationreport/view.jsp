<%@ include file="/html/user/init.jsp" %> 

ID;
Link of website;
Registry name;
Number of enrolled cases;
Number of disease;
Name Main Contact;
Email of Main contact;
Main Contact last login;
Organization last modified;
Last Contacted;
Number of Invitations;
Invitations send;
Responsedate;
Rejectdate;
Response
<br>

<%
long optionsParentOrganisation_option = GetterUtil.getLong(portletPreferences.getValue("optionsParentOrganisation", "0"));
long optionsMainContactRole_option = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", "0"));
String optionsTypeFilter_option = GetterUtil.getString(portletPreferences.getValue("optionsTypeFilter", ""));
java.util.Date now = new java.util.Date();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), optionsParentOrganisation_option);
System.out.println("SizeList: " + organizations.size());
for (Organization organization : organizations) {
	try {
		// Organization Type Filter
		if (!optionsTypeFilter_option.equals("")) {
			if (!organization.getExpandoBridge().getAttribute("Organization Type").equals(optionsTypeFilter_option)) {
				continue;
			}
		}
		
		// Variables for Display
		String webpageurl = "";
		User maincontact = null;
		java.util.Date lastlogin = null;
		int diseasecount = 0;
		String diesecountstring = "";
		java.util.Date responsedate = null;
		java.util.Date rejectdate = null;
		long numberofinvitations = 0;
		long numberofsendinvitations = 0;
		long numberofrespons = 0;
		java.util.Date lastinvitation = null;
		String response_msg = "no response";
		String fullname = "";
		String email = "";
		String lastloginstring = "";
		String modifieddatestring = "";
		String invitationorganisationssize = "";
		String lastcontacted = "";
		String responsedateString = "";
		String rejectdateString = "";
		
		// Get Webpages
		try {
			List<Website> websites = WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
			for(Website website : websites) {
				if(webpageurl.equals("")) {
					webpageurl += "  ";
				}
				webpageurl += website.getUrl();
			}
		} catch(Exception ex) {
			System.err.println("Error getting Webpage for Organization: " + organization.getOrganizationId() + " - " + ex.getMessage());
		}
		
		// Get Maincontact Data
		try {
			List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
			for(User user_mc : userlist) {
				List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user_mc.getUserId(), organization.getGroup().getGroupId());
				for (UserGroupRole ugr : usergrouprolles) {
					if(ugr.getRoleId() == optionsMainContactRole_option) {
						maincontact =  user_mc;
						lastlogin = maincontact.getLastLoginDate();
					}
				}
			}
			
			if(maincontact != null) {
				fullname = maincontact.getFullName();
				email = maincontact.getEmailAddress();
				lastloginstring = ((now.getTime() - lastlogin.getTime())/(1000 *60*60*24)) + " (" + dateFormat.format(lastlogin) + ")";
			}
			
			if(responsedate != null) {
				responsedateString = dateFormat.format(responsedate);
			}
			
			if(rejectdate != null) {
				rejectdateString = dateFormat.format(rejectdate);
			}
			
		} catch(Exception ex) {
			System.err.println("Error getting Maincontact Data for Organization: " + organization.getOrganizationId() + " - " + ex.getMessage());
		}
		
		// Get Disease Data
		try {
			List<DiseaseMatrix> diseasematrix = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organization.getOrganizationId(), -1, -1);
			for(DiseaseMatrix disease : diseasematrix) {
				try {
					diseasecount += Integer.parseInt(disease.getPatientcount());
				} catch (Exception ex) {
					if(!disease.getPatientcount().equalsIgnoreCase("null")) {
						if(!diesecountstring.equals("")) {
							diesecountstring += ", ";
						}
						diesecountstring += disease.getPatientcount();
					}
				}
			}
			
			if(!diesecountstring.equals("")) {
				diesecountstring = " (" + diesecountstring + ")";
			}
			diesecountstring = diseasecount + diesecountstring;
		} catch(Exception ex) {
			System.err.println("Error getting Disease Data for Organization: " + organization.getOrganizationId() + " - " + ex.getMessage());
		}
		
		// Get Invitation Data
		try {
			List<InvitationOrganisation> invitationorganisations = InvitationOrganisationLocalServiceUtil.getInvitationsByOrganisation(organization.getOrganizationId());
			invitationorganisationssize = invitationorganisations.size() + "";
			for(InvitationOrganisation invitationorganisation : invitationorganisations) {
				numberofinvitations++;
				if(invitationorganisation.getReactdate() != null || invitationorganisation.getRejectdate() != null) {
					numberofrespons ++;
				}
				if(invitationorganisation.getReactdate() != null) {
					if(responsedate == null) {
						responsedate = invitationorganisation.getReactdate();
					} else {
						if(responsedate.before(invitationorganisation.getReactdate())) {
							responsedate = invitationorganisation.getReactdate();
						}
					}
				}
				if(invitationorganisation.getRejectdate() != null) {
					if(rejectdate == null) {
						rejectdate = invitationorganisation.getRejectdate();
					} else {
						if(rejectdate.before(invitationorganisation.getRejectdate())) {
							rejectdate = invitationorganisation.getRejectdate();
						}
					}
				}
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
			
			if(lastinvitation != null) {
				lastcontacted = ((now.getTime() - lastinvitation.getTime())/(1000 *60*60*24)) + " (" + dateFormat.format(lastinvitation) + ")";
			} else {
				lastcontacted = "invitations: " + numberofinvitations;
			}
		} catch(Exception ex) {
			System.err.println("Error getting Invitation Data for Organization: " + organization.getOrganizationId() + " - " + ex.getMessage());
		}
		
		// Get Modifieddate
		try {
			java.util.Date modifieddate = organization.getModifiedDate();
			List<DDLRecordSet> ddlrecordsets = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
			for(DDLRecordSet ddlrecordset : ddlrecordsets) {
				String ddlrecordsetname = String.valueOf(ddlrecordset.getNameCurrentValue());
				if(ddlrecordsetname.equals("core")) {
					List<DDLRecord> records = ddlrecordset.getRecords();
		  			for(DDLRecord record : records) {
		  				if (modifieddate.before(record.getModifiedDate())) {
		  					modifieddate = record.getModifiedDate();
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
			modifieddatestring = ((now.getTime() - modifieddate.getTime())/(1000 *60*60*24)) + " (" + dateFormat.format(modifieddate) + ")";
		} catch(Exception ex) {
			System.err.println("Error getting Modifieddate for Organization: " + organization.getOrganizationId() + " - " + ex.getMessage());
		}
		
		// Get Responses
		try {
			if(responsedate != null) {
				response_msg = dateFormat.format(responsedate);
			}
			if(rejectdate != null) {
				response_msg = "rejected [" + dateFormat.format(rejectdate) + "]";
			}
		} catch(Exception ex) {
			System.err.println("Error getting Responses for Organization: " + organization.getOrganizationId() + " - " + ex.getMessage());
		}
		
		
		
		
		
		%>
		
		<%= organization.getOrganizationId() %>;
		<%= webpageurl %>;
		<%= organization.getName() %>;
		<%= diesecountstring %>;
		<%= DiseaseMatrixLocalServiceUtil.getDiseaseMatrixsCount(organization.getOrganizationId()) %>;
		<%= fullname %>;
		<%= email %>;
		<%= lastloginstring %>;
		<%= modifieddatestring %>;
		<%= lastcontacted %>;
		<%= numberofinvitations %>;
		<%= numberofsendinvitations %>;
		<%= responsedateString %>;
		<%= rejectdateString %>;
		<%= response_msg %>
		<br>
		<%
	} catch (Exception ex) {
		System.err.println("Error Displaying Organization: " + organization.getOrganizationId() + " - " + ex.getMessage());
		ex.printStackTrace();
	}
}
%>