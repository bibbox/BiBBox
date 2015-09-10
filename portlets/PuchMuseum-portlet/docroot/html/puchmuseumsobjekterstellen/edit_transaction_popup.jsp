<%@ include file="/html/init.jsp"%>

<%
long transactionId = ParamUtil.getLong(request, "transactionId");
long puchmuseumsobjektId = ParamUtil.getLong(request, "puchmuseumsobjectId");
String transactiontype = ParamUtil.getString(request, "transactiontype");
String redirect = ParamUtil.getString(request, "redirect");

Transaktion transaction = null;

if(transactionId > 0) {
	transaction = TransaktionLocalServiceUtil.getTransaktion(transactionId);
}

%>

Erstelle <%= transactiontype %><br>
<hr>


<portlet:actionURL name='<%= transaction == null ? "addTransaction" : "updateTransaction" %>' var="editTransactionURL" windowState="normal" />
<aui:form action="<%= editTransactionURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="transactiontype" value="<%= transactiontype %>" />
		<aui:input type="hidden" name="puchmuseumsobjektId" value='<%= puchmuseumsobjektId %>'/>
		<aui:input type="hidden" name="transaktionId" value='<%= transaction == null ? "" : transaction.getTransaktionId() %>'/>
		
		<%
			List<Configuration> configurations = ConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", transactiontype);
			for(Configuration configuration : configurations) {
				ParameterConfiguration parameterconfig = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(Long.parseLong(configuration.getOptionvalue()));

				String id = parameterconfig.getParameterconfigurationId() + "";
				
				TransaktionData transaktiondata = null;
				String data = "";
				if(transaction != null) {
					transaktiondata = TransaktionDataLocalServiceUtil.getTransaktionDataForObject(transaction.getTransaktionId(), id);
					if(transaktiondata != null) {
						data = transaktiondata.getObjectvalue();
					}
				}
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