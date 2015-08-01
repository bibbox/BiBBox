<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
KdssmpConfiguration kdssmpconfiguration = null;

	long kdssmpconfigurationId = ParamUtil.getLong(request, "kdssmpconfigurationId");

	if (kdssmpconfigurationId > 0) {
		kdssmpconfiguration = KdssmpConfigurationLocalServiceUtil.getKdssmpConfiguration(kdssmpconfigurationId);
	}
	
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='Back to list'
/>

puchmuseumsobjekterstellenpuchmuseumsobjectId