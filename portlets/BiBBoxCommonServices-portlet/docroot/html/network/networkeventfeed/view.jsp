<%@ include file="/html/network/init.jsp" %> 
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="java.util.regex.Pattern" %>

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<portlet:defineObjects />
<liferay-theme:defineObjects />

	<style>
		.rdc-event-container {
			position: absolute;
	   		overflow: hidden;
	    	width: 85px;
	    	height: 35px; 
	    	border: 0px solid black;
	    	right: -85px;
	    	top: 8px;
		}

		#rdc-event-slide {
	    	position: absolute;
	    	left: -85px;
	    	width: 85px;
	    	height: 35px;
	    	transition: 1s;
			color: #FFFFFF;
			padding: 8px 0 0 7px;
		}
		
		.rdc-event-candidate-propose-slider {
			background-color: #3A5894;
		}
		
		.rdc-event-publish-slider {
			background-color: #6C846F;
		}

		.rdc-event-container:hover #rdc-event-slide {
	    	transition: 1s;
	    	left: 0;
		}
		
		.notdisplayText{
			display: none;
		}
	</style>

<%
Map<String, String> map = new HashMap<String, String>();

map.put("Andorra, Principality Of", "AD");
map.put("United Arab Emirates", "AE");
map.put("Afghanistan, Islamic State Of", "AF");
map.put("Afghanistan", "AF");
map.put("Antigua And Barbuda", "AG");
map.put("Anguilla", "AI");
map.put("Albania", "AL");
map.put("Armenia", "AM");
map.put("Netherlands Antilles", "AN");
map.put("Angola", "AO");
map.put("Antarctica", "AQ");
map.put("Argentina", "AR");
map.put("American Samoa", "AS");
map.put("Austria", "AT");
map.put("Australia", "AU");
map.put("Aruba", "AW");
map.put("Azerbaidjan", "AZ");
map.put("Bosnia-Herzegovina", "BA");
map.put("Barbados", "BB");
map.put("Bangladesh", "BD");
map.put("Belgium", "BE");
map.put("Burkina Faso", "BF");
map.put("Bulgaria", "BG");
map.put("Bahrain", "BH");
map.put("Burundi", "BI");
map.put("Benin", "BJ");
map.put("Bermuda", "BM");
map.put("Brunei Darussalam", "BN");
map.put("Bolivia", "BO");
map.put("Brazil", "BR");
map.put("Bahamas", "BS");
map.put("Bhutan", "BT");
map.put("Bouvet Island", "BV");
map.put("Botswana", "BW");
map.put("Belarus", "BY");
map.put("Belize", "BZ");
map.put("Canada", "CA");
map.put("Cocos (Keeling) Islands", "CC");
map.put("Central African Republic", "CF");
map.put("Congo, The Democratic Republic Of The", "CD");
map.put("Congo", "CG");
map.put("Switzerland", "CH");
map.put("Ivory Coast (Cote D'Ivoire)", "CI");
map.put("Cook Islands", "CK");
map.put("Chile", "CL");
map.put("Cameroon", "CM");
map.put("China", "CN");
map.put("Colombia", "CO");
map.put("Costa Rica", "CR");
map.put("Former Czechoslovakia", "CS");
map.put("Cuba", "CU");
map.put("Cape Verde", "CV");
map.put("Christmas Island", "CX");
map.put("Cyprus", "CY");
map.put("Czech Republic", "CZ");
map.put("Germany", "DE");
map.put("Djibouti", "DJ");
map.put("Denmark", "DK");
map.put("Dominica", "DM");
map.put("Dominican Republic", "DO");
map.put("Algeria", "DZ");
map.put("Ecuador", "EC");
map.put("Estonia", "EE");
map.put("Egypt", "EG");
map.put("Western Sahara", "EH");
map.put("Eritrea", "ER");
map.put("Spain", "ES");
map.put("Ethiopia", "ET");
map.put("Finland", "FI");
map.put("Fiji", "FJ");
map.put("Falkland Islands", "FK");
map.put("Micronesia", "FM");
map.put("Faroe Islands", "FO");
map.put("France", "FR");
map.put("France (European Territory)", "FX");
map.put("Gabon", "GA");
map.put("Great Britain", "UK");
map.put("Grenada", "GD");
map.put("Georgia", "GE");
map.put("French Guyana", "GF");
map.put("Ghana", "GH");
map.put("Gibraltar", "GI");
map.put("Greenland", "GL");
map.put("Gambia", "GM");
map.put("Guinea", "GN");
map.put("Guadeloupe (French)", "GP");
map.put("Equatorial Guinea", "GQ");
map.put("Greece", "GR");
map.put("S. Georgia & S. Sandwich Isls.", "GS");
map.put("Guatemala", "GT");
map.put("Guam (USA)", "GU");
map.put("Guinea Bissau", "GW");
map.put("Guyana", "GY");
map.put("Hong Kong", "HK");
map.put("Heard And McDonald Islands", "HM");
map.put("Honduras", "HN");
map.put("Croatia", "HR");
map.put("Haiti", "HT");
map.put("Hungary", "HU");
map.put("Indonesia", "ID");
map.put("Ireland", "IE");
map.put("Israel", "IL");
map.put("India", "IN");
map.put("British Indian Ocean Territory", "IO");
map.put("Iraq", "IQ");
map.put("Iran", "IR");
map.put("Iceland", "IS");
map.put("Italy", "IT");
map.put("Jamaica", "JM");
map.put("Jordan", "JO");
map.put("Japan", "JP");
map.put("Kenya", "KE");
map.put("Kyrgyz Republic (Kyrgyzstan)", "KG");
map.put("Cambodia, Kingdom Of", "KH");
map.put("Kiribati", "KI");
map.put("Comoros", "KM");
map.put("Saint Kitts & Nevis Anguilla", "KN");
map.put("North Korea", "KP");
map.put("South Korea", "KR");
map.put("Kuwait", "KW");
map.put("Cayman Islands", "KY");
map.put("Kazakhstan", "KZ");
map.put("Laos", "LA");
map.put("Lebanon", "LB");
map.put("Saint Lucia", "LC");
map.put("Liechtenstein", "LI");
map.put("Sri Lanka", "LK");
map.put("Liberia", "LR");
map.put("Lesotho", "LS");
map.put("Lithuania", "LT");
map.put("Luxembourg", "LU");
map.put("Latvia", "LV");
map.put("Libya", "LY");
map.put("Morocco", "MA");
map.put("Monaco", "MC");
map.put("Moldavia", "MD");
map.put("Madagascar", "MG");
map.put("Marshall Islands", "MH");
map.put("Macedonia", "MK");
map.put("Mali", "ML");
map.put("Myanmar", "MM");
map.put("Mongolia", "MN");
map.put("Macau", "MO");
map.put("Northern Mariana Islands", "MP");
map.put("Martinique (French)", "MQ");
map.put("Mauritania", "MR");
map.put("Montserrat", "MS");
map.put("Malta", "MT");
map.put("Mauritius", "MU");
map.put("Maldives", "MV");
map.put("Malawi", "MW");
map.put("Mexico", "MX");
map.put("Malaysia", "MY");
map.put("Mozambique", "MZ");
map.put("Namibia", "NA");
map.put("New Caledonia (French)", "NC");
map.put("Niger", "NE");
map.put("Norfolk Island", "NF");
map.put("Nigeria", "NG");
map.put("Nicaragua", "NI");
map.put("Netherlands", "NL");
map.put("Norway", "NO");
map.put("Nepal", "NP");
map.put("Nauru", "NR");
map.put("Neutral Zone", "NT");
map.put("Niue", "NU");
map.put("New Zealand", "NZ");
map.put("Oman", "OM");
map.put("Panama", "PA");
map.put("Peru", "PE");
map.put("Polynesia (French)", "PF");
map.put("Papua New Guinea", "PG");
map.put("Philippines", "PH");
map.put("Pakistan", "PK");
map.put("Poland", "PL");
map.put("Saint Pierre And Miquelon", "PM");
map.put("Pitcairn Island", "PN");
map.put("Puerto Rico", "PR");
map.put("Portugal", "PT");
map.put("Palau", "PW");
map.put("Paraguay", "PY");
map.put("Qatar", "QA");
map.put("Reunion (French)", "RE");
map.put("Romania", "RO");
map.put("Russian Federation", "RU");
map.put("Rwanda", "RW");
map.put("Saudi Arabia", "SA");
map.put("Solomon Islands", "SB");
map.put("Seychelles", "SC");
map.put("Sudan", "SD");
map.put("Sweden", "SE");
map.put("Singapore", "SG");
map.put("Saint Helena", "SH");
map.put("Slovenia", "SI");
map.put("Svalbard And Jan Mayen Islands", "SJ");
map.put("Slovak Republic", "SK");
map.put("Sierra Leone", "SL");
map.put("San Marino", "SM");
map.put("Senegal", "SN");
map.put("Somalia", "SO");
map.put("Suriname", "SR");
map.put("Saint Tome (Sao Tome) And Principe", "ST");
map.put("Former USSR", "SU");
map.put("El Salvador", "SV");
map.put("Syria", "SY");
map.put("Swaziland", "SZ");
map.put("Turks And Caicos Islands", "TC");
map.put("Chad", "TD");
map.put("French Southern Territories", "TF");
map.put("Togo", "TG");
map.put("Thailand", "TH");
map.put("Tadjikistan", "TJ");
map.put("Tokelau", "TK");
map.put("Turkmenistan", "TM");
map.put("Tunisia", "TN");
map.put("Tonga", "TO");
map.put("East Timor", "TP");
map.put("Turkey", "TR");
map.put("Trinidad And Tobago", "TT");
map.put("Tuvalu", "TV");
map.put("Taiwan", "TW");
map.put("Tanzania", "TZ");
map.put("Ukraine", "UA");
map.put("Uganda", "UG");
map.put("United Kingdom", "UK");
map.put("USA Minor Outlying Islands", "UM");
map.put("United States", "US");
map.put("Uruguay", "UY");
map.put("Uzbekistan", "UZ");
map.put("Holy See (Vatican City State)", "VA");
map.put("Saint Vincent & Grenadines", "VC");
map.put("Venezuela", "VE");
map.put("Virgin Islands (British)", "VG");
map.put("Virgin Islands (USA)", "VI");
map.put("Vietnam", "VN");
map.put("Vanuatu", "VU");
map.put("Wallis And Futuna Islands", "WF");
map.put("Samoa", "WS");
map.put("Yemen", "YE");
map.put("Mayotte", "YT");
map.put("Yugoslavia", "YU");
map.put("South Africa", "ZA");
map.put("Zambia", "ZM");
map.put("Zaire", "ZR");
map.put("Zimbabwe", "ZW");
%>	

<%
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);

String template = "<div style=\"margin: 5px 20px 10px 10px; width: 95%; background-color: #E2E3CE; border-radius: 3px;-webkit-box-shadow: 2px 2px 2px 1px rgba(0,0,0,0.50);-moz-box-shadow: 2px 2px 2px 1px rgba(0,0,0,0.50);box-shadow: 2px 2px 2px 1px rgba(0,0,0,0.50);position: relative;\"><div class=\"rdc-event-container\"><div class=\"[$sliderclass$]\" id=\"rdc-event-slide\">[$slidertext$]</div></div><table style=\"margin: 8px 0 5px 0; background-color: #FFFFFF; float:left; width:100%;height: 35px;\"><tr><td style=\"width:80px;\">[$logoleft$]</td><td style=\"\">[$title$]</td><td style=\"width:60px;\">[$logoright$]</td></tr></table><div style=\"margin: 5px;\">[$shorttext$]<br><i class=\"fa fa-plus-square\"></i></div><div class=\"notdisplayText\" style=\"margin: 5px;\">[$longtext$]<br><i class=\"fa fa-minus-square-o\"></i></div></div>";

long networkid= 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
java.util.TreeMap<java.util.Date, String> sortetdata = new java.util.TreeMap<java.util.Date, String>(Collections.reverseOrder());
if (currentGroup.isOrganization()) {
	// the group is an Organization
	networkid = currentGroup.getClassPK();
	
	List<Long> filterids = NetworksLocalServiceUtil.getNetworkIdList(networkid);
	
	//List<RDConnectEvent> rdconnectevents = RDConnectEventLocalServiceUtil.getEventsByOrganizationIds(filterids);
	List<RDConnectEvent> rdconnectevents = RDConnectEventLocalServiceUtil.getEvents();
	for(RDConnectEvent rdconnectevent : rdconnectevents) {
		if(!filterids.contains(rdconnectevent.getOrganizationId())) {
			continue;
		}
		boolean error = false;
		String event = template.replaceAll("\\[\\$slidertext\\$\\]", dateFormat.format(rdconnectevent.getEventdate()));
		event = event.replaceAll("\\[\\$title\\$\\]", rdconnectevent.getEventtype());
		// Add published Data
		if(rdconnectevent.getEventtype().contains("New Biobank Published") || rdconnectevent.getEventtype().contains("New Registry Published")) {
			try {
				Organization organization = OrganizationLocalServiceUtil.getOrganization(rdconnectevent.getOrganizationId());
				// left organization logo
				String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization.getLogoId();
				String organizationtype = organization.getExpandoBridge().getAttribute("Organization Type").toString();
			 	if(organizationtype.equalsIgnoreCase("Biobank")) {
			 		if(organization.getLogoId() == 0) {
			 			imgPath = request.getContextPath() + "/images/Biobank.png";
			 		}
			 	} else {
			 		if(organization.getLogoId() == 0) {
			 			imgPath = request.getContextPath() + "/images/Registry.png";
			 		}
			 	}
			 	event = event.replaceAll("\\[\\$logoleft\\$\\]", "<img style=\"height: 35px;\" src=\"" + imgPath + "\" />");
			 	// right country logo
			 	String pattern = "(.+?)from (.+?) was(.*)";
				String country = rdconnectevent.getShorttext().replaceAll(pattern, "$2");
				if(map.containsKey(country)) { 
					event = event.replaceAll("\\[\\$logoright\\$\\]", "<img style=\"height: 35px;\" id='countryflag' src=\"http://www.geonames.org/flags/x/" + map.get(country).toLowerCase() + ".gif\" />");
				} else { 
					String wordimage = request.getContextPath() + "/images/world.png";
					event = event.replaceAll("\\[\\$logoright\\$\\]", "<img style=\"height: 35px;\" id='countryflag' src=\"" + wordimage + "\" />");
				}
				// long discription
				String longtext = "<b>" + organization.getName() + "</b><br>"
							+ organizationtype + "<br>"
							+ "--Maincontact--" + "<br>";
				
				event = event.replaceAll("\\[\\$longtext\\$\\]", longtext);
				// Slider class
				event = event.replaceAll("\\[\\$sliderclass\\$\\]", "rdc-event-publish-slider");
			} catch (Exception e) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [RDConnect-Events-portlet::at.graz.meduni.liferay.portlet.bibbox.rdconnect.portlet.event.EventFeed::eventfeed_view.jsp] Error in EventFeed View for New Biobank Published/New Registry Published.");
				e.printStackTrace();
				error = true;
			}
		} 
		// Network Updated
		else if (rdconnectevent.getEventtype().equalsIgnoreCase("Network Updated")) {
			try {
				// Network
				Organization organization_network = OrganizationLocalServiceUtil.getOrganization(rdconnectevent.getOrganizationId());
				// left organization logo
				String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization_network.getLogoId();
				String networkorgPath = themeDisplay.getURLPortal()+"/web"+organization_network.getGroup().getFriendlyURL();
				String organizationtype = organization_network.getExpandoBridge().getAttribute("Organization Type").toString();
			 	if(organizationtype.equalsIgnoreCase("Biobank")) {
			 		if(organization_network.getLogoId() == 0) {
			 			imgPath = request.getContextPath() + "/images/Biobank.png";
			 		}
			 		networkorgPath = networkorgPath + "/bb_home";
			 	} else if (organizationtype.equalsIgnoreCase("Registry")) {
			 		if(organization_network.getLogoId() == 0) {
			 			imgPath = request.getContextPath() + "/images/Registry.png";
			 		}
			 		networkorgPath = networkorgPath + "/reg_home";
			 	} else if (organizationtype.equalsIgnoreCase("Network")) {
			 		if(organization_network.getLogoId() == 0) {
			 			imgPath = request.getContextPath() + "/images/Network.png";
			 		}
			 		networkorgPath = networkorgPath + "/home";
			 	}
			 	event = event.replaceAll("\\[\\$logoleft\\$\\]", "<img style=\"height: 35px;\" src=\"" + imgPath + "\" />");
			 	// Organization
			 	
			 	// right logo
			 	String pattern = "\\[url organization (\\w*)\\]";
			 	Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			 	Matcher m = r.matcher(rdconnectevent.getShorttext());
			 	long networkorganizationid = organization_network.getOrganizationId();
			 	while (m.find( )) {
			 		try {
			 			long tmp = Long.parseLong(m.group(1));
			 			if(tmp != organization_network.getOrganizationId()) {
			 				networkorganizationid = tmp;			
			 			}
			 		} catch (Exception e) {
			 			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [RDConnect-Events-portlet::at.graz.meduni.liferay.portlet.bibbox.rdconnect.portlet.event.EventFeed::eventfeed_view.jsp] Error parsing organization ID.");
						e.printStackTrace();
			 		}
			 	}
			 	Organization organization_for_network = OrganizationLocalServiceUtil.getOrganization(networkorganizationid);
			 	String wordimage = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization_for_network.getLogoId();
				String organizationtypenetwork = organization_for_network.getExpandoBridge().getAttribute("Organization Type").toString();
				String orgPath = themeDisplay.getURLPortal()+"/web"+organization_for_network.getGroup().getFriendlyURL();
			 	if(organizationtypenetwork.equalsIgnoreCase("Biobank")) {
			 		if(organization_for_network.getLogoId() == 0) {
			 			wordimage = request.getContextPath() + "/images/Biobank.png";
			 		}
			 		orgPath = orgPath + "/bb_home";
			 	} else if (organizationtypenetwork.equalsIgnoreCase("Registry")) {
			 		if(organization_for_network.getLogoId() == 0) {
			 			wordimage = request.getContextPath() + "/images/Registry.png";
			 		}
			 		orgPath = orgPath + "/reg_home";
			 	} else if (organizationtypenetwork.equalsIgnoreCase("Network")) {
			 		if(organization_for_network.getLogoId() == 0) {
			 			wordimage = request.getContextPath() + "/images/Network.png";
			 		}
			 		orgPath = orgPath + "/home";
			 	}
				event = event.replaceAll("\\[\\$logoright\\$\\]", "<img style=\"height: 35px;\" id='countryflag' src=\"" + wordimage + "\" />");
				
				// long discription
				event = event.replaceAll("\\[\\$shorttext\\$\\]", rdconnectevent.getShorttext().replaceAll("\\[urlend\\]", "</a>").replaceAll("\\[url organization " + organization_network.getOrganizationId() + "\\]", "<a href=\"" + networkorgPath + "\">").replaceAll("\\[url organization " + organization_for_network.getOrganizationId() + "\\]", "<a href=\"" + orgPath + "\">"));
				// short discription
				// .replaceAll("\[url organization " + organization_network.getOrganizationId() + "\]", "<a href=\"" + networkorgPath + "\">").replaceAll("\[url organization " + organization_for_network.getOrganizationId() + "\]", "<a href=\"" + orgPath + "\">")
				event = event.replaceAll("\\[\\$shorttext\\$\\]", rdconnectevent.getShorttext().replaceAll("\\[urlend\\]", "</a>").replaceAll("\\[url organization " + organization_network.getOrganizationId() + "\\]", "<a href=\"" + networkorgPath + "\">").replaceAll("\\[url organization " + organization_for_network.getOrganizationId() + "\\]", "<a href=\"" + orgPath + "\">"));
				// Slider class
				event = event.replaceAll("\\[\\$sliderclass\\$\\]", "rdc-event-publish-slider");
			} catch (Exception e) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [RDConnect-Events-portlet::at.graz.meduni.liferay.portlet.bibbox.rdconnect.portlet.event.EventFeed::eventfeed_view.jsp] Error in EventFeed View for Network Updated.");
				e.printStackTrace();
				error = true;
			}
		}
		// Print event
		if(!error) {
			%>
			<%= event %>
			<%
		}
	}
}
%>

<aui:script use="node,click">
AUI().use('aui-base', function(A){
	A.all(".fa-minus-square-o").on('click',function(event){
		event.target.get('parentNode').get('parentNode').all('.notdisplayText').removeClass('notdisplayText');
		event.target.get('parentNode').addClass('notdisplayText');
	});
});
AUI().use('aui-base', function(A){
	A.all(".fa-plus-square").on('click',function(event){
		event.target.get('parentNode').get('parentNode').all('.notdisplayText').removeClass('notdisplayText');
		event.target.get('parentNode').addClass('notdisplayText');
	});
});
</aui:script>