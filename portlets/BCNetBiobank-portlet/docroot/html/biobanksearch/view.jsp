<%@ include file="/html/init.jsp" %>


<%
	String currentTab = ParamUtil.getString(request, "tabs1", "identity");
%>
 


<liferay-portlet:renderURL var="changeTabURL" >
	<portlet:param name="mvcPath" value="/html/biobanksearch/view.jsp" />
</liferay-portlet:renderURL>


<liferay-ui:tabs
    names="identity,services"
    url="<%= changeTabURL %>"
/>

<liferay-util:include
    page='<%= "/html/biobanksearch/" + currentTab + ".jsp" %>'
    servletContext="<%= application %>"
/>

<%
String keywords = "";
String countryCode = "";
List<BiobankGeneralInformation> results = BiobankGeneralInformationLocalServiceUtil.findBiobanksByKeywordsCountry(keywords, countryCode, 0, 100);

long biobankid = 0;

for(BiobankGeneralInformation biobankgeneralinformation : results) {
	if(biobankid == biobankgeneralinformation.getBiobankDbId()) {
		%><h4 class="header toggler-header-collapsed"><span><%= biobankgeneralinformation.getBiobankName() %></span><%= "Acronym" %></h4><%
	}
	%><p class="content toggler-content-collapsed"><%
	String attributelistname = "";
	String attributelistvalue = "";
	List<BiobankAttributeLists> biobankattributelists = biobankgeneralinformation.getBiobankAttributeLists();
	for(BiobankAttributeLists biobankattribute : biobankattributelists){
		if(attributelistname.equalsIgnoreCase(biobankattribute.getAttributeListName())) {
			if(!attributelistvalue.equalsIgnoreCase("")) {
				attributelistvalue += ", ";
			}
			attributelistvalue += biobankattribute.getAttributeListValue();
		} else if(!attributelistname.equalsIgnoreCase("")) {
			%><%= biobankattribute.getAttributeListName() %>:<br />
			<%= attributelistvalue %>:<br /><%
			
			attributelistname = biobankattribute.getAttributeListName();
			attributelistvalue = "";
		}
	}
	%></p>
<%
}
%>
