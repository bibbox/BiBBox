<%@ include file="/html/init.jsp"%>

<%
PuchMuseumsObjekt puchmuseumsobjekt = null;
long puchmuseumsobjektId = ParamUtil.getLong(request, "puchmuseumsobjectId");
puchmuseumsobjekt = PuchMuseumsObjektLocalServiceUtil.getPuchMuseumsObjekt(puchmuseumsobjektId);
String objekttyp = puchmuseumsobjekt.getObjekttyp();
String redirect = ParamUtil.getString(request, "redirect");

Configuration icon_configuration = ConfigurationLocalServiceUtil.getConfigurationOption("Icon", objekttyp);
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='back-to-list-objects'
/>

<%= icon_configuration.getOptionvalue() %><%= objekttyp %><br>

<%
	List<Configuration> configurations = ConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", objekttyp);
	for (Configuration configuration : configurations) {
		ParameterConfiguration parameterconfig = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(Long.parseLong(configuration.getOptionvalue()));
		if(!parameterconfig.getViewvisible()) {
			continue;
		}
		
		String id = parameterconfig.getParameterconfigurationId() + "";

		ObjectData objectdata = ObjectDataLocalServiceUtil.getObjectDataForObject(puchmuseumsobjektId, id);
		String data = "";
		%>
		<div style='<%= parameterconfig.getViewcss() %>'>
		<%
		if (objectdata != null) {
			if (parameterconfig.getDatatype().equalsIgnoreCase("html")) {
				%>
				<div style="<%= parameterconfig.getViewtitlecss() %>"><%= parameterconfig.getDisplaynameshort() %>: </div><div style="<%= parameterconfig.getViewvaluecss() %>"><%= objectdata.formatValueHTML() %></div>
				<%
			} else if (parameterconfig.getDatatype().equalsIgnoreCase("text")) {
				%>
				<div style="<%= parameterconfig.getViewtitlecss() %>"><%= parameterconfig.getDisplaynameshort() %>: </div><div style="<%= parameterconfig.getViewvaluecss() %>"><%= objectdata.formatValueHTML() %></div>
				<%
			} else if (parameterconfig.getDatatype().equalsIgnoreCase("textbox")) {
				%>
				<div style="<%= parameterconfig.getViewtitlecss() %>"><%= parameterconfig.getDisplaynameshort() %>: </div><div style="<%= parameterconfig.getViewvaluecss() %>"><%= objectdata.formatValueHTML() %></div>
				<%
			} else if (parameterconfig.getDatatype().equalsIgnoreCase("Select")) {
				%>
				<div style="<%= parameterconfig.getViewtitlecss() %>"><%= parameterconfig.getDisplaynameshort() %>: </div><div style="<%= parameterconfig.getViewvaluecss() %>"><%= objectdata.formatValueHTML() %></div>
				<%
			} else if (parameterconfig.getDatatype().equalsIgnoreCase("Multiselect")) {
				%>
				<div style="<%= parameterconfig.getViewtitlecss() %>"><%= parameterconfig.getDisplaynameshort() %>: </div><div style="<%= parameterconfig.getViewvaluecss() %>"><%= objectdata.formatValueHTML() %></div>
				<%
			}
		} else {
			%>
			<%= parameterconfig.getDisplaynameshort() %><br>
			<%
		}
		%>
		<div style='content: "";clear: both;display: table;'></div>
		</div>
		<%
	}
%>