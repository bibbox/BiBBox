<%@ include file="/html/init.jsp" %>


<%
	String currentTab = ParamUtil.getString(request, "tabs1", "General Information");
%>
 


<liferay-portlet:renderURL var="changeTabURL" >
	<portlet:param name="mvcPath" value="/html/biobank/biobank_tabs.jsp" />
</liferay-portlet:renderURL>


<liferay-ui:tabs
    names="General Information,Contact"
    url="<%= changeTabURL %>"
/>


<c:if test='<%= currentTab.equals("General Information") %>'>
	<liferay-util:include 
		page="/html/biobank/edit_biobank_general_information.jsp"
		servletContext="<%= application %>" 
	/>
</c:if>
<c:if test='<%= currentTab.equals("Contact") %>'>
	<liferay-util:include 
		page="/html/biobank/edit_biobank_contact.jsp"
		servletContext="<%= application %>" 
	/>
</c:if>

