<%@ include file="/html/idcard/init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

D2Biobank biobank = (D2Biobank)row.getObject(); 
%>

<liferay-ui:icon-menu>

    <c:if
        test="<%= D2BiobankPermission.contains(permissionChecker, biobank.getBiobankId(), ActionKeys.UPDATE) %>">
        <portlet:renderURL var="editURL">
            <portlet:param name="biobankId" value="<%= String.valueOf(biobank.getBiobankId()) %>" />
            <portlet:param name="mvcPath" value="/html/idcard/biobank/edit_biobank.jsp" />
        </portlet:renderURL>

        <liferay-ui:icon image="edit" message="Edit"
            url="<%= editURL.toString() %>" />
    </c:if>
    
    <c:if
	    test="<%=D2BiobankPermission.contains(permissionChecker, biobank.getBiobankId(), ActionKeys.PERMISSIONS) %>">
	
	    <liferay-security:permissionsURL
	        modelResource="<%= D2Biobank.class.getName() %>"
	        modelResourceDescription="<%= biobank.getBiobankName() %>"
	        resourcePrimKey="<%= String.valueOf(biobank.getBiobankId()) %>"
	        var="permissionsURL" />
	
	    <liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	
	</c:if>
	
	<c:if
        test="<%=D2BiobankPermission.contains(permissionChecker, biobank.getBiobankId(), ActionKeys.DELETE) %>">

        <portlet:actionURL name="deleteBiobank" var="deleteURL">
            <portlet:param name="biobankId" value="<%= String.valueOf(biobank.getBiobankId()) %>" />
        </portlet:actionURL>

        <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
    </c:if>

</liferay-ui:icon-menu>