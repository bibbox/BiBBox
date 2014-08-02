<%@ include file="/html/organisation/init.jsp" %> 

<portlet:defineObjects />

<%
String optionsParentOrganisationNameOption_option = GetterUtil.getString(portletPreferences.getValue("optionsParentOrganisationNameOption", "organisation"));
String organisationName_option = GetterUtil.getString(portletPreferences.getValue("optionsOrganisationName", "Organisation"));
String parentOrganisationName_option = GetterUtil.getString(portletPreferences.getValue("optionsParentOrganisationName", "Portal"));
long optionsPageTemplate_option = GetterUtil.getLong(portletPreferences.getValue("optionsPageTemplate", "0"));
String optionsDDLGeneration_option = GetterUtil.getString(portletPreferences.getValue("optionsDDLGeneration", ""));

if(optionsParentOrganisationNameOption_option.equalsIgnoreCase("name")) {
} else if(optionsParentOrganisationNameOption_option.equalsIgnoreCase("portal")) {
	optionsParentOrganisationNameOption_option = themeDisplay.getServerName();
} else if(optionsParentOrganisationNameOption_option.equalsIgnoreCase("organisation")) {
	long organizationId = 0;
	com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
	if (currentGroup.isOrganization()) {
		organizationId = currentGroup.getClassPK();
	  	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	  	parentOrganisationName_option = organization.getName();
	}
}
%>
<%= optionsDDLGeneration_option %><br>
Create new <b><%= organisationName_option %></b> for <%= parentOrganisationName_option %>:

<liferay-ui:success key="organisation-created-successfully" message="organisation-created-successfully" />
<liferay-ui:error key="fields-required" message="fields-required" />

<portlet:actionURL name='<%= "createOrganisation" %>' var="createOrganisationURL" windowState="normal" />
<aui:form action="<%= createOrganisationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<!-- hidden elements direct from config -->
		<aui:input name="bibbox_cs_pagetemplate" type="hidden" value ="<%= optionsPageTemplate_option %>" />
		<aui:input name="bibbox_cs_ddlgeneration" type="hidden" value ="<%= optionsDDLGeneration_option %>" />
		
		<aui:layout cssClass="bibbox_cs_organisationname">
			<aui:column columnWidth="100" first="true">
				<aui:input name="bibbox_cs_organisationname" label="<%= organisationName_option %>" type="text" value ="" cssClass="propose" />
				
			</aui:column>
		</aui:layout>
		<!-- DDL Information -->
		<div>
			<aui:layout>
					
				<%
				String[] ddloptionsplited = optionsDDLGeneration_option.split("__");
				for(String ddloptions : ddloptionsplited) {
					if(ddloptions.contains("_x_")) {
						continue;
					} else if(ddloptions.contains("_c_")) {
						continue;
					} else if(ddloptions.contains("_o_")) {
						continue;
					} else {
						String[] split = ddloptions.split("_");
						String option = split[1];
						long ddmstuctureid = Long.parseLong(split[0]);
						if(option.equals("f")) {
							// File upload
						} else {
							// Insert Information
						}
						%>
						<aui:column columnWidth="100" first="true">
							[<%= option %>] <%= ddmstuctureid %><br>
						</aui:column>
						<%
					}
				}
				%>
			</aui:layout>
		</div>
	</aui:fieldset>
	<aui:button-row cssClass="proposebuttonrow">
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>