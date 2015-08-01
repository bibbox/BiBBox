<%@ include file="/html/init.jsp" %>

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
			if(objekttyp.equalsIgnoreCase("fahrzeug")) {
				%><%@ include file="/html/puchmuseumsobjekterstellen/objecttype/fahrzeug.jspf" %><%
			} else if(objekttyp.equalsIgnoreCase("fahrrad")) {
				%><%@ include file="/html/puchmuseumsobjekterstellen/objecttype/fahrrad.jspf" %><%
			} else if(objekttyp.equalsIgnoreCase("motorrad")) {
				%><%@ include file="/html/puchmuseumsobjekterstellen/objecttype/motorrad.jspf" %><%
			} else {
				System.err.println("Type not defined");
			}
		%>
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>

