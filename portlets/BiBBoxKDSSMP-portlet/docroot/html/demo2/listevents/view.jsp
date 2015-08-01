<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />

<% 
String portletResource = ParamUtil.getString(request, "portletResource");
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
  	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
  	
  	KdssmpPatient patient = KdssmpPatientLocalServiceUtil.getPatientForOrganization(organizationId);
  	List<Event> events = EventLocalServiceUtil.getEventsForPatient(patient.getPatientId());
  	
  	for(Event event : events) {
  		LinkedHashMap<String, String> icons = new LinkedHashMap<String, String>();
  		icons.put("date", dateFormat.format(event.getEventdate()));
  		icons.put("A1", event.getEventtype());
  		icons.put("ACODE", event.getEventtype());
  		if(event.getStatus().equalsIgnoreCase("signed")) {
  			icons.put("A4", "signed");
  		}
  		
  		Layout event_layout = LayoutLocalServiceUtil.getLayout(event.getLayoutId());
  		icons.put("link", "/web"+organization.getGroup().getFriendlyURL() + "" + event_layout.getFriendlyURL());
  		
  		List<KdssmpConfiguration> parameters = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", event.getEventtype());
  		for(KdssmpConfiguration parameter : parameters) {
  			KdssmpConfiguration icon_parameter = KdssmpConfigurationLocalServiceUtil.getConfigurationOption("IconConfiguration", String.valueOf(parameter.getConfigurationId()));
  			if(icon_parameter == null) {
  				continue;
  			}
  			KdssmpConfiguration data_parameter = KdssmpConfigurationLocalServiceUtil.getKdssmpConfiguration(parameter.getConfigurationId());
  			if(data_parameter == null) {
  				continue;
  			}
  			EventData eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), data_parameter.getOptionvalue());
  			if(eventdata == null) {
  				continue;
  			}
  			icons.put(icon_parameter.getOptionvalue(), eventdata.getValue());
  		}
  		
  		%>
  		<%= SymbolConfigurationLocalServiceUtil.getSymbol("default", "event", icons) %><br>
  		<%
  	}
  	
} else {
	%>
	<h3>Portlet can not worke here.</h3>
	<%
}
%>