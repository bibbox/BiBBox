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
}

String optionsHorizontalLayout_cfg = GetterUtil.getString(portletPreferences.getValue("optionsHorizontalLayout", "vertical"));
String layouttemplate = "";
if(optionsHorizontalLayout_cfg.equalsIgnoreCase("vertical")) {
	layouttemplate = "Fistname: §FIRSTNAME§<br>Lastname: §LASTNAME§<br>Date of birth: §DOB§ (§AGE§)<br>Gender: §GENDER§";
} else {
	layouttemplate = "Fistname: §FIRSTNAME§&nbsp&nbsp|&nbsp&nbspLastname: §LASTNAME§&nbsp&nbsp|&nbsp&nbspDate of birth: §DOB§ (§AGE§)&nbsp&nbsp|&nbsp&nbspGender: §GENDER§";
}

if(organization != null) {
	KdssmpPatient patient = KdssmpPatientLocalServiceUtil.getPatientForOrganization(organizationId);
	layouttemplate = layouttemplate.replaceAll("§FIRSTNAME§", patient.getFirstname());
	layouttemplate = layouttemplate.replaceAll("§LASTNAME§", patient.getLastname());
	layouttemplate = layouttemplate.replaceAll("§DOB§", dateFormat.format(patient.getDateofbirth()));
	Date now = new Date();
	long calc = now.getTime() - patient.getDateofbirth().getTime();
  	long MILLS_IN_YEAR = 1000L * 60 * 60 * 24 * 365;
  	long age = calc/MILLS_IN_YEAR;
	layouttemplate = layouttemplate.replaceAll("§AGE§", age+"");
	layouttemplate = layouttemplate.replaceAll("§GENDER§", patient.getGender());
	%>
	<%= layouttemplate %>
	<%
} else {
%>
	<h3>Portlet can not worke here.</h3>
<%
}
%>
