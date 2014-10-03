<%@ include file="/html/organisation/init.jsp" %> 

<portlet:defineObjects />

<%
String optionsParentOrganisationNameOption_option = GetterUtil.getString(portletPreferences.getValue("optionsParentOrganisationNameOption", "organisation"));
String organisationName_option = GetterUtil.getString(portletPreferences.getValue("optionsOrganisationName", "Organisation"));
String parentOrganisationName_option = GetterUtil.getString(portletPreferences.getValue("optionsParentOrganisationName", "Portal"));
long optionsPageTemplate_option = GetterUtil.getLong(portletPreferences.getValue("optionsPageTemplate", "0"));
String optionsDDLGeneration_option = GetterUtil.getString(portletPreferences.getValue("optionsDDLGeneration", ""));
long optionsWhereToCreateOrganisation_option = GetterUtil.getLong(portletPreferences.getValue("optionsWhereToCreateOrganisation", "0"));
String optionsOrganizationType_option = GetterUtil.getString(portletPreferences.getValue("optionsOrganizationType", ""));
String optionsSelectUser_option = GetterUtil.getString(portletPreferences.getValue("optionsSelectUser", "no"));
long optionsRoleForUser_option = GetterUtil.getLong(portletPreferences.getValue("optionsRoleForUser", "0"));

Organization organization = null;



if(optionsParentOrganisationNameOption_option.equalsIgnoreCase("name")) {
} else if(optionsParentOrganisationNameOption_option.equalsIgnoreCase("portal")) {
	optionsParentOrganisationNameOption_option = themeDisplay.getServerName();
} else if(optionsParentOrganisationNameOption_option.equalsIgnoreCase("organisation")) {
	long organizationId = 0;
	com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
	if (currentGroup.isOrganization()) {
		organizationId = currentGroup.getClassPK();
	  	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	  	parentOrganisationName_option = organization.getName();
	}
	if(optionsWhereToCreateOrganisation_option == 1) {
		optionsWhereToCreateOrganisation_option = organizationId;
	}
	if(optionsWhereToCreateOrganisation_option == 2) {
		boolean parentfound = false;
	  	Organization parent_organization = organization;
	  	optionsWhereToCreateOrganisation_option = parent_organization.getOrganizationId();
	  	while(!parentfound) {
	  		if(parent_organization.getParentOrganizationId() == 0) {
	  			parentfound = true;
	  		} else {
	  			parent_organization = parent_organization.getParentOrganization();
	  			optionsWhereToCreateOrganisation_option = parent_organization.getOrganizationId();
	  		}
	  	}
	}
}
//Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_create_organization = "CREATE_ORGANIZATION";
if(permissionChecker.hasPermission(groupId, name, primKey, actionId_create_organization)) {

%>

Create new <b><%= organisationName_option %></b> for <%= parentOrganisationName_option %>:

<liferay-ui:success key="organisation-created-successfully" message="organisation-created-successfully" />
<liferay-ui:error key="fields-required" message="fields-required" />

<portlet:actionURL name='<%= "createOrganisation" %>' var="createOrganisationURL" windowState="normal" />
<aui:form action="<%= createOrganisationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<!-- hidden elements direct from config -->
		<aui:input name="bibbox_cs_pagetemplate" type="hidden" value ="<%= optionsPageTemplate_option %>" />
		<aui:input name="bibbox_cs_ddlgeneration" type="hidden" value ="<%= optionsDDLGeneration_option %>" />
		<aui:input name="bibbox_cs_parentorganization" type="hidden" value ="<%= optionsWhereToCreateOrganisation_option %>" />
		
		<aui:layout cssClass="bibbox_cs_organisationname">
			<aui:column columnWidth="100" first="true">
				<aui:input name="bibbox_cs_organisationname" label="<%= organisationName_option %>" type="text" value ="" cssClass="propose" />	
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<% 
				if(optionsOrganizationType_option.contains(";")) {
					%>
					<aui:select label="Parent Organization Name Options" name="bibbox_cs_organizationtype" >
						<%
						String[] organizationtypes = optionsOrganizationType_option.split(";");
						for(String organizationtype : organizationtypes) {
							%>
							<aui:option value="<%= organizationtype %>" ><%= organizationtype %></aui:option>
							<%
						}
						%>
					</aui:select>
					<%
				} else {
					%>
					<aui:input name="bibbox_cs_organizationtype" type="hidden" value ="<%= optionsOrganizationType_option %>" />
					<%
				}
				%>
			</aui:column>
			<aui:input name="bibbox_cs_selectuser" type="hidden" value ="<%= optionsSelectUser_option %>" />
			<aui:input name="bibbox_cs_selectuserrole" type="hidden" value ="<%= optionsRoleForUser_option %>" />
			<%
			if(!optionsSelectUser_option.equals("no")) {
				%>
				<aui:column columnWidth="100" first="true">
					<aui:select label="Select Editor for new Organization" name="bibbox_cs_userfororganization" >
					<%
					List<User> users = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
					for(User user_om : users) {
						%>
						<aui:option value="<%= user_om.getUserId() %>" ><%= user_om.getFullName() %></aui:option>
						<%
					}
					%>
					</aui:select>
				</aui:column>
				<%
			}
			%>
			<aui:column columnWidth="100" first="true">
			</aui:column>
		</aui:layout>
		<!-- DDL Information -->
		<div>				
			<%
			String[] ddloptionsplited = optionsDDLGeneration_option.split("__");
			
			ServiceContext serviceContext = new ServiceContext();
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	        Group group = null;
	        
	        if(organization == null) {
	        	group = themeDisplay.getScopeGroup();
	        } else {
	        	group = organization.getGroup();
	        }
	        
	        serviceContext.setScopeGroupId(group.getGroupId());
	        serviceContext.setUserId(themeDisplay.getUserId());
			
			for(String ddloptions : ddloptionsplited) {
				%>
				<div>
					<%
					if(ddloptions.contains("_x_")) {
						continue;
					} else if(ddloptions.contains("_c_")) {
						continue;
					} else if(ddloptions.contains("_o_")) {
						continue;
					} else {
						String[] split = ddloptions.split("_");
						if(split.length <= 1) {
							continue;
						}
						String option = split[1];
						String title = "";
						for(int i=2;i<split.length;i++) {
							title += split[i];
						}
						// Get DDm Structure
						long ddmstuctureid = Long.parseLong(split[0]);
						if(option.equals("f")) {
							%>
							<h1>File Uplaod</h1>
							<%
							// File upload
						} else {
							%>
							<h1><%= title.subSequence(1, title.length()-1) %></h1>
							<aui:layout>
								
								<%
								DDMStructure ddmstructure = DDMStructureLocalServiceUtil.getDDMStructure(ddmstuctureid);			
								Set<String> fieldnames = ddmstructure.getFieldNames();
								//Fields fields = DDMUtil.getFields(ddmstuctureid, serviceContext);
								
								for(String fieldname : fieldnames) {		
									if(!fieldname.equalsIgnoreCase("_fieldsDisplay")) {
										if(ddmstructure.getFieldType(fieldname).equals("select")) {
											
										}
										%>
										<aui:column columnWidth="100" first="true">
											<aui:input name="<%= fieldname %>" label='<%= ddmstructure.getFieldLabel(fieldname, themeDisplay.getLocale()) + " - " + fieldname + " - " + ddmstructure.getFieldType(fieldname) %>' ></aui:input>
										</aui:column>
										<%
									}
								}
								%>

							</aui:layout>							
							<%
						}
						%>
						
											
							
					</div>
					<hr />
					<%
				}
			}
			%>
		</div>
	</aui:fieldset>
	<aui:button-row cssClass="proposebuttonrow">
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
<%
} else {
%>
You can not create a new <b><%= organisationName_option %></b> for <%= parentOrganisationName_option %>
<%
}

%>