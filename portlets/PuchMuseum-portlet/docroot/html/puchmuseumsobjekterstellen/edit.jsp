<%@ include file="/html/init.jsp" %>

<script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>

<%
PuchMuseumsObjekt puchmuseumsobjekt = null;

	long puchmuseumsobjektId = ParamUtil.getLong(request, "puchmuseumsobjektId");

	if (puchmuseumsobjektId > 0) {
		puchmuseumsobjekt = PuchMuseumsObjektLocalServiceUtil.getPuchMuseumsObjekt(puchmuseumsobjektId);
	}
	
	String objekttyp = "";
	if (puchmuseumsobjekt != null) {
		objekttyp = puchmuseumsobjekt.getObjekttyp();
	} else {
		objekttyp = ParamUtil.getString(request, "objekttyp");
	}
	
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='Back to list'
/>

creating <%= objekttyp %><br>

<portlet:actionURL name='<%= puchmuseumsobjekt == null ? "addKdssmpConfiguration" : "updateKdssmpConfiguration" %>' var="editKdssmpConfigurationURL" windowState="normal" />
<aui:form action="<%= editKdssmpConfigurationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="objekttyp" value="<%= objekttyp %>" />
		<aui:input type="hidden" name="configurationId" value='<%= puchmuseumsobjekt == null ? "" : puchmuseumsobjekt.getPuchmuseumsobjectId() %>'/>
		
		<%
			List<Configuration> configurations = ConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", objekttyp);
			for(Configuration configuration : configurations) {
				ParameterConfiguration parameterconfig = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(Long.parseLong(configuration.getOptionvalue()));

				String id = parameterconfig.getDatatype() + parameterconfig.getParameterconfigurationId();
				//parameterconfig.getParameterconfigurationId()
				if(parameterconfig.getDatatype().equalsIgnoreCase("html")) {
					%><%@ include file="/html/puchmuseumsobjekterstellen/dynamicelements/html.jspf" %><%
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("text")) {
					%><%@ include file="/html/puchmuseumsobjekterstellen/dynamicelements/text.jspf" %><%
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("textbox")) {
					%><%@ include file="/html/puchmuseumsobjekterstellen/dynamicelements/textbox.jspf" %><%
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("Select")) {
					%><%@ include file="/html/puchmuseumsobjekterstellen/dynamicelements/select.jspf" %><%
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("Multiselect")) {
					%><%@ include file="/html/puchmuseumsobjekterstellen/dynamicelements/multiselect.jspf" %><%
				}
			}
		%>
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>

