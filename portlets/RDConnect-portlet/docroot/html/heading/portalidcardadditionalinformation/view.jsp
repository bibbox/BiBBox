<!-- 
RDConnect
heading/portalidcardadditionalinformation/view.jsp

Display the information of an organization (URL, address, phone, fax)
Used in the ID-Card theme next to the card.
 -->

<%@page import="com.liferay.portal.service.persistence.PhoneUtil"%>
<%@page import="com.liferay.portal.model.PhoneModel"%>
<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.service.persistence.CountryUtil" %>
<%@ page import="com.liferay.portal.model.Country" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>
<%@ page import="com.liferay.portal.service.WebsiteLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.PhoneLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Website" %>
<%@ page import="com.liferay.portal.model.Phone" %>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalService" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>

<portlet:defineObjects />

<%
String currentURL = PortalUtil.getCurrentURL(request);
long BiobanK_REG_MAINCONTACT = 71378;
long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();
  	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
  	String country = "";
  	
  	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
  		
  		if(rdc_rsname.equals("core")) {  		
	  		List<DDLRecord> records = rdc_rs.getRecords();
	  		for(DDLRecord record : records) {
	  			if(record.getFieldValue("countryCode") != null) {
	  				country = record.getFieldValue("countryCode").toString();
	  			}
	  		}
  		}
  	}
    
  	// create a map with countrys and countrycodes
  	//TODO: fix with liferay country object
    Map<String, String> map = new HashMap<String, String>();

     map.put("Andorra, Principality Of", "AD");
     map.put("United Arab Emirates", "AE");
     map.put("Afghanistan, Islamic State Of", "AF");
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
    
     boolean faxset = true;
     Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Control Panel");
     long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
     String editimgpath = request.getContextPath() + "/images/edit.png";
%>

<div class="rdc_idcard_idcaibody">
	<%
	// Edit link
	boolean portaleditorrole = false;
    boolean biobankregistryownerrole = false;
    for(Role role : themeDisplay.getUser().getRoles()) {
    	if(role.getName().equalsIgnoreCase("PORTAL-EDITOR"))
    		portaleditorrole = true;
    	if(role.getName().equalsIgnoreCase("Administrator"))
    		portaleditorrole = true;
    	if(role.getName().equalsIgnoreCase("RD-Connect CURATOR"))
    		portaleditorrole = true;
    }
    //Biobank, Registry Owner
    for (UserGroupRole ugr : UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId(), organization.getGroupId())) {
    	if(ugr.getRole().getName().equalsIgnoreCase("BIOBANK-REG-OWNER"))
    		biobankregistryownerrole = true; 
    	if(ugr.getRole().getName().equalsIgnoreCase("BB-REG-EDITOR"))
			biobankregistryownerrole = true;
		if(ugr.getRole().getName().equalsIgnoreCase("BB-REG-OWNER"))
			biobankregistryownerrole = true;
    }
    if(biobankregistryownerrole || portaleditorrole) {
	
	
		LiferayPortletURL editusersURL = PortletURLFactoryUtil.create(request, "125", controlPanelPlid, "RENDER_PHASE");
		editusersURL.setParameter("struts_action", "/users_admin/edit_organization");
	    editusersURL.setParameter("tab", "websites");
	    editusersURL.setParameter("redirect", currentURL);
	    editusersURL.setParameter("p_p_state", "maximized");
		String editpathaddresses = editusersURL.toString() + "&_125_organizationId=" + organizationId + "#_125_tab=_125_addresses";
		String editpathphone = editusersURL.toString() + "&_125_organizationId=" + organizationId + "#_125_tab=_125_phoneNumbers";
		String editpathwebsites = editusersURL.toString() + "&_125_organizationId=" + organizationId + "#_125_tab=_125_websites";
		%>
		<div class="rdc_idcard_idcaibody-edit-icon-websites"><span id="organizationeditwebsite" style="cursor:pointer;"><img alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></span> </div>
		<div class="rdc_idcard_idcaibody-edit-icon-phone"><span id="organizationeditphone" style="cursor:pointer;"><img alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></span> </div>
		<div class="rdc_idcard_idcaibody-edit-icon-address"><span id="organizationeditaddress" style="cursor:pointer;"><img alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></span> </div>
		<% 
	} 
	%>
	<div class="rdc_idcard_idcaibody-top">
		<div class="rdc_idcard_idcaibody-flag">
			<% 
			if(map.containsKey(country)) { 
				%>
				<img id='countryflag' src="http://www.geonames.org/flags/x/<%= map.get(country).toLowerCase() %>.gif" />
				<% 
			} else if(country.equalsIgnoreCase("International")) { 
				String wordimage = request.getContextPath() + "/images/world.png";
				%>
				<img id='countryflag' src="<%= wordimage %>" />
				<% 
			} else { 
				%>
				<%= country %>
				<% 
			} 
			%>
		</div>
		<div class="rdc_idcard_idcaibody-webpage">
			<% 
			List<Website> websites = WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
			boolean first = true; 
			for(Website website : websites) {
				if(!first) {
					%><br /><%
				}
				//if(website.isPrimary()) {
				%><aui:a href='<%= website.getUrl() %>' target="blank">Website Link</aui:a><%
				//}
				first = false;
			}
			%>
		</div>
	</div>
	<div class="rdc_idcard_idcaibody-contactinformation">
		<span class="rdc_idcard_idcaibody-headlines">Host institution</span><br>
	
		<%
		String phone = "";
		String fax = "";
		List<Phone> phones = PhoneLocalServiceUtil.getPhones(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
		for(Phone tmpphone : phones) {
			if(tmpphone.isPrimary()) {
				phone = "Tel. " + tmpphone.getNumber() + "-" + tmpphone.getExtension();
				if(phone.length() >= 17) {
					phone = phone.replaceAll(" ", "");
					if(phone.length() >= 17) {
						phone = "<span style=\"font-size: 80%\">" + phone + "</span>";
					}
				} 
			}
			if(tmpphone.getTypeId() == 12007) {
				fax = "Fax. " + tmpphone.getNumber() + "-" + tmpphone.getExtension();
				if(fax.length() >= 17) {
					fax = fax.replaceAll(" ", "");
					if(fax.length() >= 17) {
						fax = "<span style=\"font-size: 80%\">" + fax + "</span>";
					}
				}
			}
		}
		%>
	
		<table>
			<tr>
				<td class="rdc_idcard_idcaibody-contactinformation-tdfirst"><%= organization.getAddress().getStreet1() %></td>
				<td class="rdc_idcard_idcaibody-contactinformation-tdlast"><%= phone.length() != 0 ? phone : "" %></td>
			</tr>
			<% 
			String street2 = "";
			if(!organization.getAddress().getStreet2().equalsIgnoreCase("")) { 
				street2 = organization.getAddress().getStreet2();
				%>
				<tr>
					<td><%= street2 %></td><td class="rdc_idcard_idcaibody-contactinformation-tdlast">
					<% 
					if(faxset) {
						faxset = false;
						%>
						<%= fax.length() != 0 ? fax : "" %>
						<%
					}
					%>
					</td>
				</tr>
				<% 
			} 
			%>
			<% 
			if(!organization.getAddress().getStreet3().equalsIgnoreCase("")) { 
				%>
				<tr>
					<td><%= organization.getAddress().getStreet3() %></td>
					<td class="rdc_idcard_idcaibody-contactinformation-tdlast">
					<% 
					if(faxset) {
						faxset = false;
						%>
						<%= fax.length() != 0 ? fax : "" %> 
						<%
					}
					%>
					</td>
				</tr>
				<% 
			} 
			%>
			<tr>
				<td><%= organization.getAddress().getZip() %> <%= organization.getAddress().getCity() %></td>
				<td class="rdc_idcard_idcaibody-contactinformation-tdlast">
				<% 
				if(faxset) {
					faxset = false;
					%>
					<%= fax.length() != 0 ? fax : "" %> 
					<%
				}
				%>
				</td>
			</tr>
			<tr>
				<td><%= organization.getAddress().getCountry().getNameCurrentValue() %></td>
				<td></td>
			</tr>
		</table>
	</div>
</div>
<%
}


String portletResource = ParamUtil.getString(request, "portletResource");
Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Control Panel");
long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
// Edit Organization Link
LiferayPortletURL editorganizationURL = PortletURLFactoryUtil.create(request, "125", controlPanelPlid, "RENDER_PHASE");
editorganizationURL.setDoAsGroupId(themeDisplay.getSiteGroupId());
editorganizationURL.setParameter("redirect", currentURL);
editorganizationURL.setWindowState(WindowState.MAXIMIZED);
editorganizationURL.setParameter("organizationId", "" + organizationId);
editorganizationURL.setParameter("struts_action", "/users_admin/edit_organization");
/*editusersURL.setParameter("tab", "websites");
editusersURL.setParameter("redirect", currentURL);
editusersURL.setParameter("p_p_state", "maximized");
String editpathaddresses = editusersURL.toString() + "&_125_organizationId=" + organizationId + "#_125_tab=_125_addresses";
String editpathphone = editusersURL.toString() + "&_125_organizationId=" + organizationId + "#_125_tab=_125_phoneNumbers";
String editpathwebsites = editusersURL.toString() + "&_125_organizationId=" + organizationId + "#_125_tab=_125_websites";*/

%>	


<aui:script use="aui-base">
            A.all('#organizationeditaddress').on(
               'click',
               function(event) {
                  Liferay.Util.selectEntity(
                     {
                        dialog: {
                           constrain: true,
                           modal: true,
                           width: 1200
                        },
                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_editorganizationaddresses',
                        title: 'Edit Organization',
                        uri: '<%=editorganizationURL.toString() + "#_125_tab=_125_addresses" %>'
                     }
                  );
               }
            );
</aui:script>
<aui:script use="aui-base">
            A.all('#organizationeditphone').on(
               'click',
               function(event) {
                  Liferay.Util.selectEntity(
                     {
                        dialog: {
                           constrain: true,
                           modal: true,
                           width: 1200
                        },
                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_editorganizationphonenumbers',
                        title: 'Edit Organization',
                        uri: '<%=editorganizationURL.toString() + "#_125_tab=_125_phoneNumbers" %>'
                     }
                  );
               }
            );
</aui:script>
<aui:script use="aui-base">
            A.all('#organizationeditwebsite').on(
               'click',
               function(event) {
                  Liferay.Util.selectEntity(
                     {
                        dialog: {
                           constrain: true,
                           modal: true,
                           width: 1200
                        },
                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_editorganizationwebpages',
                        title: 'Edit Organization',
                        uri: '<%=editorganizationURL.toString() + "#_125_tab=_125_websites" %>'
                     }
                  );
               }
            );
</aui:script>