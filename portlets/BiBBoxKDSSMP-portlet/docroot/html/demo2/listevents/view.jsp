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
  		icons.put("A4", "+");
  		if(event.getStatus().equalsIgnoreCase("signed")) {
  			icons.put("A4", icons.get("A4") + "§,§signed");
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
  		
  		if(event.getEventtype().equals("erstdiagnosecolon")) {
  			String diagnosis = "";
  			EventData eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "350");
  			if(eventdata != null) {
  				diagnosis = eventdata.getValue();
  			}
  			String symptoms = "";
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "351");
  			if(eventdata != null) {
  				symptoms = "S" + eventdata.getValue().split(";").length;
  			}
  			icons.put("A4", "TEXT:" + symptoms);
  			icons.put("A1", "erstdiagnose");
  			icons.put("A3", "colon");
  			icons.put("ASUMMETY", diagnosis);
  		}
  		
  		if(event.getEventtype().equals("einwilligungblutabnahme")) {
  			String summery = "Einwilligung Blutabnahme<br>" + dateFormat.format(event.getEventdate());
  			icons.put("ASUMMETY", summery);
  			icons.put("A1", "einwilligung");
  			icons.put("A3", "legal");
  		}
  		if(event.getEventtype().equals("ngsinformedconsent")) {
  			String summery = "PatientInneninformation/Einverständniserklärung<br>" + dateFormat.format(event.getEventdate()) + "<br>für die Diagnostik und klinische NGS Diagnostik<br>für Forschungsvorhaben der Medizinischen Universität Graz";
  			icons.put("ASUMMETY", summery);
  			icons.put("A1", "einwilligung");
  			icons.put("A3", "legal");
  			icons.put("A2", "ngs");
  		}
  		
		if(event.getEventtype().equals("oppraperat")) {
			icons.put("A1", "act");
			// Diagnosis
  			EventData eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "1");
  			if(eventdata != null) {
  				icons.put("ASUMMETY", eventdata.getValue());
  			}
  			// Organ
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "2");
  			if(eventdata != null) {
  				icons.put("A3", eventdata.getValue());
  			}
  			// T
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "356");
  			if(eventdata != null) {
  				icons.put("A4", icons.get("A4") + "§,§TEXT:<div style=\"background-color: #336666;height: 26px;\">T" + eventdata.getValue() + "</div>");
  			}
  			// N
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "357");
  			if(eventdata != null) {
  				icons.put("A4", icons.get("A4") + "§,§TEXT:<div style=\"background-color: #3399FF;height: 26px;\">N" + eventdata.getValue() + "</div>");
  			}
  			// N
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "358");
  			if(eventdata != null) {
  				icons.put("A4", icons.get("A4") + "§,§TEXT:<div style=\"background-color: #CC66FF;height: 26px;\">M" + eventdata.getValue() + "</div>");
  			}
  			// ICD 10
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "352");
  			if(eventdata != null) {
  				icons.put("A2", eventdata.getValue());
  			}
  			
  		}
		
		if(event.getEventtype().equals("probeexcession")) {
			icons.put("A1", "act");
			EventData eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "1");
  			if(eventdata != null) {
  				icons.put("ASUMMETY", eventdata.getValue());
  			}
  			// Organ
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "2");
  			if(eventdata != null) {
  				icons.put("A3", eventdata.getValue());
  			}
  			// ICD 10
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "352");
  			if(eventdata != null) {
  				icons.put("A2", eventdata.getValue());
  			}
		}
		
		if(event.getEventtype().equals("ngscounseling")) {
  			// Organ
  			icons.put("A2", "ngs");
  			icons.put("A3", "counseling");
  			String summery = "";
  			String a4 = "+";
  			EventData eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "10");
  			if(eventdata != null) {
  				summery += "<b>Surgery:</b> " + eventdata.getValue() + "<br>";
  			}
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "11");
  			if(eventdata != null) {
  				summery += "<b>Drugs:</b> " + eventdata.getValue() + "<br>";
  			}
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "12");
  			if(eventdata != null) {
  				summery += "<b>Diag. requir.:</b> " + eventdata.getValue() + "<br>";
  			}
  			icons.put("ASUMMETY", summery);
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "3");
  			if(eventdata != null) {
  				if(eventdata.getValue().equals("yes")) {
  					a4 += "§,§TEXT:IDB";
  				}
  			}
		}
		
		if(event.getEventtype().equals("ngsorder")) {
			icons.put("A2", "ngs");
			icons.put("A1", "order");
			String summery = "";
			String splitter = "";
			EventData eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "450");
  			if(eventdata != null) {
  				if(eventdata.getValue().equals("1")) {
  					summery += splitter + "AMLv1 Panel (21 Gene)";
  					splitter = "<br>";
  				}
  			}
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "451");
  			if(eventdata != null) {
  				if(eventdata.getValue().equals("1")) {
  					summery += splitter + "Patho Hotspot Panel V1 (8 Gene)";
  					splitter = "<br>";
  				}
  			}
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "452");
  			if(eventdata != null) {
  				if(eventdata.getValue().equals("1")) {
  					summery += splitter + "CeGaT CAN01 Kolonkarzinom (20 Gene)";
  					splitter = "<br>";
  				}
  			}
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "453");
  			if(eventdata != null) {
  				if(eventdata.getValue().equals("1")) {
  					summery += splitter + "CeGaT CAN11 Kolonkarzinom - Polypsis Coil (7 Gene)";
  					splitter = "<br>";
  				}
  			}
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "454");
  			if(eventdata != null) {
  				if(eventdata.getValue().equals("1")) {
  					summery += splitter + "CeGaT CAN12 Kolonkarzinom - hereditäres non-polyposis Kolorektalkarzinom (HNPCC) (5 Gene)";
  					splitter = "<br>";
  				}
  			}
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "455");
  			if(eventdata != null) {
  				if(eventdata.getValue().equals("1")) {
  					summery += splitter + "MGZ ID99.00 Hereditäres Nicht-Polypöses Kolorektales Karzinom / Lynch-Syndrom (4 Gene)";
  					splitter = "<br>";
  				}
  			}
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "456");
  			if(eventdata != null) {
  				if(eventdata.getValue().equals("1")) {
  					summery += splitter + "MGZ ID100.00 Kolonkarzinom (16 Gene)";
  					splitter = "<br>";
  				}
  			}
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "457");
  			if(eventdata != null) {
  				if(eventdata.getValue().equals("1")) {
  					summery += splitter + "LMK 23 (7 Gene)";
  					splitter = "<br>";
  				}
  			}
  			icons.put("ASUMMETY", summery);
		}
		
		if(event.getEventtype().equals("ngsanalysisreport")) {
			icons.put("A2", "ngs");
			icons.put("A1", "observation");
		}
		
		if(event.getEventtype().equals("ngsqualitycontrole")) {
			icons.put("A2", "ngs");
			icons.put("A1", "quality");
			String summery = "";
			EventData eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "750");
  			if(eventdata != null) {
  				summery += eventdata.getValue();
  			}
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "751");
  			if(eventdata != null) {
  				summery += "<br>Sequencer: " + eventdata.getValue();
  			}
  			eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "753");
  			if(eventdata != null) {
  				summery += "<br>Reagents: " + eventdata.getValue();
  			}
  			icons.put("ASUMMETY", summery);
		}
		
		if(event.getEventtype().equals("ngsmolecularpathologydiagnosis")) {
			icons.put("A2", "ngs");
			icons.put("A1", "diagnosis");
			EventData eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "1");
  			if(eventdata != null) {
  				icons.put("ASUMMETY", eventdata.getValue());
  			}
		}
		
		if(event.getEventtype().equals("ngsclinicaldecision")) {
			icons.put("A2", "ngs");
			icons.put("A1", "diagnosis");
			EventData eventdata = EventDataLocalServiceUtil.getEventDataByOntology(event.getEventId(), "1");
  			if(eventdata != null) {
  				icons.put("ASUMMETY", eventdata.getValue());
  			}
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