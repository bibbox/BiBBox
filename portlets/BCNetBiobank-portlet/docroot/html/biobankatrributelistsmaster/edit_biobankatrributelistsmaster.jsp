<%@ include file="/html/init.jsp" %>

<%
	BiobankAtrributeListsMaster biobankAtrributeListsMaster = null;

	long biobankAtrributeListsMasterId = ParamUtil.getLong(request, "biobankAtrributeListsMasterId");

	if (biobankAtrributeListsMasterId > 0) {
		biobankAtrributeListsMaster = BiobankAtrributeListsMasterLocalServiceUtil.getBiobankAtrributeListsMaster(biobankAtrributeListsMasterId);
	}

	List<BiobankAtrributeListsMaster> biobankAtrributeNames = BiobankAtrributeListsMasterLocalServiceUtil.getAllBiobankAtrributeListsMasters();

	String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= biobankAtrributeListsMaster %>" model="<%= BiobankAtrributeListsMaster.class %>" />
<portlet:renderURL var="viewBiobankAtrributeListsMasterURL" />
<portlet:actionURL name='<%= biobankAtrributeListsMaster == null ? "addBiobankAtrributeListsMaster" : "updateBiobankAtrributeListsMaster" %>' var="editBiobankAtrributeListsMasterURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewBiobankAtrributeListsMasterURL %>"
	title='<%= (biobankAtrributeListsMaster != null) ? biobankAtrributeListsMaster.getAttributeListName() : "new-biobankAtrributeListsMaster" %>'
/>

<aui:form action="<%= editBiobankAtrributeListsMasterURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

		<aui:input name="biobankAtrributeListsMasterId" type="hidden" value='<%= biobankAtrributeListsMaster == null ? "" : biobankAtrributeListsMaster.getBiobankAttributeListsMasterId() %>'/>

		<% 
			String biobankAtrributeListName = "";
			if (biobankAtrributeListsMaster != null) biobankAtrributeListName = biobankAtrributeListsMaster.getAttributeListName();
		%>

		<aui:select label="Attribute List Name" name="attributeListName" showEmptyOption="<%= true %>">
			<aui:option value="Type of Repository" selected="<%=\"Type of Repository\".equals(biobankAtrributeListName) %>">Type of Repository</aui:option>
	 		<aui:option value="Data Management" selected="<%=\"Data Management\".equals(biobankAtrributeListName) %>">Data Management</aui:option>
	 		<aui:option value="Database" selected="<%=\"Database\".equals(biobankAtrributeListName) %>">Database</aui:option>
	 		<aui:option value="Storage Facility" selected="<%=\"Storage Facility\".equals(biobankAtrributeListName) %>">Storage Facility</aui:option>
	 		<aui:option value="Monitoring" selected="<%=\"Monitoring\".equals(biobankAtrributeListName) %>">Monitoring</aui:option>
	 		<aui:option value="Genetic Platform" selected="<%=\"Genetic Platform\".equals(biobankAtrributeListName) %>">Genetic Platform</aui:option>
	 		<aui:option value="Proteomics Platform" selected="<%=\"Proteomics Platform\".equals(biobankAtrributeListName) %>">Proteomics Platform</aui:option>
	 		<aui:option value="Metabolomics Platform" selected="<%=\"Metabolomics Platform\".equals(biobankAtrributeListName) %>">Metabolomics Platform</aui:option>
	 		<aui:option value="Epigenomics Platform" selected="<%=\"Epigenomics Platform\".equals(biobankAtrributeListName) %>">Epigenomics Platform</aui:option>
	 		<aui:option value="Bioinformatics Data Analysis Service" selected="<%=\"Bioinformatics Data Analysis Service\".equals(biobankAtrributeListName) %>">Bioinformatics Data Analysis Service</aui:option>
			<aui:option value="Complementary Services" selected="<%=\"Complementary Services\".equals(biobankAtrributeListName) %>">Complementary Services</aui:option>
			<aui:option value="Automation Services" selected="<%=\"Automation Services\".equals(biobankAtrributeListName) %>">Automation Services</aui:option>		
			<aui:option value="Available Documents" selected="<%=\"Available Documents\".equals(biobankAtrributeListName) %>">Available Documents</aui:option>
			<aui:option value="Type of Staff" selected="<%=\"Type of Staff\".equals(biobankAtrributeListName) %>">Type of Staff</aui:option>
		</aui:select>
		
		<aui:input name="attributeListValue" label="Attribute Value"/>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button onClick="<%= viewBiobankAtrributeListsMasterURL %>"  type="cancel" />
	</aui:button-row>
</aui:form>