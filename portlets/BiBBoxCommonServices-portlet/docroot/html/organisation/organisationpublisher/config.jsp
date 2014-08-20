<%@ include file="/html/organisation/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
String optionsParentOrganisationNameOption_cfg = GetterUtil.getString(portletPreferences.getValue("optionsParentOrganisationNameOption", "organisation"));
String optionsOrganisationName_cfg = GetterUtil.getString(portletPreferences.getValue("optionsOrganisationName", "Organisation"));
String optionsParentOrganisationName_cfg = GetterUtil.getString(portletPreferences.getValue("optionsParentOrganisationName", "Portal"));
long optionsPageTemplate_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsPageTemplate", "0"));
String optionsDDLGeneration_cfg = GetterUtil.getString(portletPreferences.getValue("optionsDDLGeneration", ""));
long optionsWhereToCreateOrganisation_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsWhereToCreateOrganisation", "0"));
String optionsOrganizationType_cfg = GetterUtil.getString(portletPreferences.getValue("optionsOrganizationType", ""));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
   			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<!-- Organisation Name Title creation -->
			<aui:column columnWidth="100" first="true">
				<aui:input name="preferences--optionsOrganisationName--" label="Organisation Name Title" type="text" value ="<%= optionsOrganisationName_cfg %>" cssClass="propose" />
			</aui:column>
			<!-- Parent Organisation Naming  -->
			<aui:column columnWidth="25" first="true">
				<aui:select label="Parent Organisation Name Options" name="preferences--optionsParentOrganisationNameOption--" >
					<aui:option value="organisation" selected="<%=\"organisation\".equals(optionsParentOrganisationNameOption_cfg) %>" >Organisation</aui:option>
					<aui:option value="portal" selected="<%=\"portal\".equals(optionsParentOrganisationNameOption_cfg) %>" >Portal</aui:option>
					<aui:option value="name" selected="<%=\"name\".equals(optionsParentOrganisationNameOption_cfg) %>" >Set Specific Name</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="75" last="true">
				<aui:input name="preferences--optionsParentOrganisationName--" label="Set Specific Name" type="text" value ="<%= optionsParentOrganisationName_cfg %>" cssClass="propose" />
			</aui:column>
			<!-- Select where to create the Organization -->
			<aui:column columnWidth="25" first="true">
				<aui:select label="Select Parent Organisation for Organisation" name="preferences--optionsWhereToCreateOrganisation--">
					<aui:option value="0" selected='<%= optionsWhereToCreateOrganisation_cfg == 0 ? true : false %>' >As Main Organization</aui:option>
					<aui:option value="1" selected='<%= optionsWhereToCreateOrganisation_cfg == 1 ? true : false %>' >In the Organization of the portlet</aui:option>
					<%
					List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 0);
					for(Organization organization : organizations) {
						%>
						<aui:option value="<%= organization.getOrganizationId() %>" selected='<%= optionsWhereToCreateOrganisation_cfg == organization.getOrganizationId() ? true : false %>' >In Organization: <%= organization.getName() %></aui:option>
						<%
					}
					%>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="75" last="true">
				<aui:input name="preferences--optionsOrganizationType--" label="Set OrganisationType" type="text" value ="<%= optionsOrganizationType_cfg %>" />
			</aui:column>
			<!-- Select Site Template for creation -->
			<aui:column columnWidth="100" first="true">
				<%
				List<LayoutSetPrototype> site_templates = LayoutSetPrototypeServiceUtil.search(company.getCompanyId(), Boolean.TRUE, null);
				%>
				<aui:select label="Select PageTemplate for Organisation" name="preferences--optionsPageTemplate--">
					<aui:option value="0" selected='<%= optionsPageTemplate_cfg == 0 ? true : false %>' >No Page</aui:option>
					<% for(LayoutSetPrototype site_template : site_templates) { %>
						<aui:option value="<%= site_template.getPrimaryKey() %>" selected='<%= optionsPageTemplate_cfg == site_template.getPrimaryKey() ? true : false %>' ><%= site_template.getName() %></aui:option>
					<% } %>
				</aui:select>
			</aui:column>
		</aui:layout>
		DDL Options:
		<div style="border-style: solid; border-width: 1px;padding:5px;">
			<aui:layout>
			<!-- DDL selection -->
				<%
				List<DDMStructure> ddm_structures = DDMStructureLocalServiceUtil.getStructures(themeDisplay.getCompanyGroupId());
				int ddlcount = 0;
				for(DDMStructure ddm_structure : ddm_structures) { 
					if(ddm_structure.getClassName().equals("com.liferay.portlet.dynamicdatalists.model.DDLRecordSet")) {
						String fieldname_ddlstatus = "bibbox_cs_" + "ddlstatus_" + ddlcount;
						String fieldname_ddlname = "bibbox_cs_" + "ddlname_" + ddlcount;
						String pattern_string = ".*_" + ddm_structure.getPrimaryKey() + "_\\w_\"(.*?)\"_.*";
						Pattern pattern = Pattern.compile(pattern_string);
						Matcher matcher = pattern.matcher(optionsDDLGeneration_cfg);
						String ddlname = ddm_structure.getName(themeDisplay.getLocale());
						while (matcher.find()) {
							ddlname = matcher.group(1);
						}
						%>
						<aui:column columnWidth="50" first="true">
							<aui:select label="<%= ddm_structure.getName() %>" name="<%= fieldname_ddlstatus %>">
								<aui:option value="<%= \"_\" + ddm_structure.getPrimaryKey() + \"_x_\" %>" selected="<%=optionsDDLGeneration_cfg.contains(\"_\" + ddm_structure.getPrimaryKey() + \"_x_\") %>" >do not create</aui:option>
								<aui:option value="<%= \"_\" + ddm_structure.getPrimaryKey() + \"_c_\" %>" selected="<%=optionsDDLGeneration_cfg.contains(\"_\" + ddm_structure.getPrimaryKey() + \"_c_\") %>" >create</aui:option>
								<aui:option value="<%= \"_\" + ddm_structure.getPrimaryKey() + \"_o_\" %>" selected="<%=optionsDDLGeneration_cfg.contains(\"_\" + ddm_structure.getPrimaryKey() + \"_o_\") %>" >create with one empty entry</aui:option>
								<aui:option value="<%= \"_\" + ddm_structure.getPrimaryKey() + \"_f_\" %>" selected="<%=optionsDDLGeneration_cfg.contains(\"_\" + ddm_structure.getPrimaryKey() + \"_f_\") %>" >upload File</aui:option>
								<aui:option value="<%= \"_\" + ddm_structure.getPrimaryKey() + \"_i_\" %>" selected="<%=optionsDDLGeneration_cfg.contains(\"_\" + ddm_structure.getPrimaryKey() + \"_i_\") %>" >insert Information</aui:option>
							</aui:select>
						</aui:column>
						<aui:column columnWidth="50" last="true">
							<aui:input name="<%=fieldname_ddlname %>" label="DDL Title" type="text" value ="<%= ddlname %>" />
						</aui:column>
						<% 
						ddlcount ++;
					}
				}
				%>
				<aui:input name="bibbox_cs_numberofddls" type="hidden" value="<%= ddlcount %>" /> 			
			</aui:layout>
		</div>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
