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
}
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
		</aui:layout>
		<!-- DDL Information -->
		<div>				
			<%
			String[] ddloptionsplited = optionsDDLGeneration_option.split("__");
			
			ServiceContext serviceContext = new ServiceContext();
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	        Group group = organization.getGroup();
	        serviceContext.setScopeGroupId(group.getGroupId());
	        serviceContext.setUserId(organization.getUserId());
			
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