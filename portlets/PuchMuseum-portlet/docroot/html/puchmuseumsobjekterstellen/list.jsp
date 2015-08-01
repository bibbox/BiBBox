<%@ include file="/html/init.jsp"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>

<aui:button-row>
	<portlet:renderURL var="addObjectFahrzeugURL">
		<portlet:param name="mvcPath" value="/html/puchmuseumsobjekterstellen/edit.jsp" />
		<portlet:param name="objekttyp" value="fahrzeug" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<aui:a href="<%= addObjectFahrzeugURL.toString() %>"><i class="fa fa-car fa-3x"></i></aui:a>
	<portlet:renderURL var="addObjectMotorradURL">
		<portlet:param name="mvcPath" value="/html/puchmuseumsobjekterstellen/edit.jsp" />
		<portlet:param name="objekttyp" value="motorrad" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<aui:a href="<%= addObjectMotorradURL.toString() %>"><i class="fa fa-motorcycle fa-3x"></i></aui:a>
	<portlet:renderURL var="addObjectFahrradURL">
		<portlet:param name="mvcPath" value="/html/puchmuseumsobjekterstellen/edit.jsp" />
		<portlet:param name="objekttyp" value="fahrrad" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<aui:a href="<%= addObjectFahrradURL.toString() %>"><i class="fa fa-bicycle fa-3x"></i></aui:a>
</aui:button-row>

<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "5")) %>' emptyResultsMessage="empty-results-message-objects">
	<liferay-ui:search-container-results
		results="<%= PuchMuseumsObjektLocalServiceUtil.getPuchMuseumsObjekts(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= PuchMuseumsObjektLocalServiceUtil.getPuchMuseumsObjektsCount() %>"
	/>
	
	<liferay-ui:search-container-row
		className="at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt"
		keyProperty="puchmuseumsobjectId"
		modelVar="puchmuseumsobject" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="ID"
			value="<%= Long.toString(puchmuseumsobject.getPuchmuseumsobjectId()) %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Typ"
			value="<%= puchmuseumsobject.getObjekttyp() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="CreateDate"
			value="<%= dateFormat.format(puchmuseumsobject.getCreateDate()) %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="ModifiedDate"
			value="<%= dateFormat.format(puchmuseumsobject.getModifiedDate()) %>"
		/>
		
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/puchmuseumsobjekterstellen/puchmuseumsobject_action.jsp"
		/>
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>