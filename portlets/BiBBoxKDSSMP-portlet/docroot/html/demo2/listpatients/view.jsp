<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />

<style>
	.event-container-text-right {
		width: 353px;
		height: 100px;
		border: 1px solid black;
		margin: 20px 0 0 0;
	   	border-radius: 15px;
	}
	.event-container-icon {
		width: 110px;
		height: 100px;
		border: 1px solid black;
		margin: 20px 0 0 0;
	   	border-radius: 15px;
	}
	.event-container-text-bottom {
		width: 110px;
		height: 150px;
		border: 1px solid black;
		margin: 20px 0 0 0;
	   	border-radius: 15px;
	}
	.event {
	   	width: 110px;
	   	height: 100px; 
	   	border: 1px solid black;
	   	border-radius: 15px;
	   	text-align: center;
	   	float: left;
	   	margin: -1px 0 0 -1px;	
	   	position: relative;
	   	top: -42px;
	   	color: #FFFFFF;
	}
	.event-text {
	   	width: 240px;
	   	height: 100px; 
	   	text-align: center;
	   	float: left;
	   	position: relative;
	   	top: -42px;
		overflow:hidden;
	}
	.event-text-bottom {
	   	width: 110px;
	   	height: 50px; 
	   	text-align: center;
	   	float: left;
	   	position: relative;
	   	top: -42px;
	}
	.event-date {
		position: relative;
		width: 70px;
	   	height: 40px;
	   	border: 1px solid black;
	   	background-color: #A8A8A8;
		color: #FFFFFF;
		top: -14px;
		right: -39px;
		font-size: 10px;
		line-height: 12px;
		text-align: center;
		border-radius: 5px;
	}
	.changecolor {
		background-color: green;
	}
	.configurationeventtype {
		width: 150px;
	   	height: 20px;
	   	border: 1px solid black;
	   	border-bottom: 0px solid black;
	   	background-color: #A8A8A8;
		color: #FFFFFF;
		font-size: 14px;
		line-height: 20px;
		text-align: left;
		border-top-left-radius: 5px;
		border-top-right-radius: 5px;
	}
	.symbolconfigurationoverview {
		width: 450px;
		border: 1px solid black;
		background-color: #DBDBDB;
		padding: 10px;
	}
</style>

<h3>Patients:</h3>

<%
long optionsRoleForUser_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsRoleForUser", "0"));
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
List<KdssmpPatient> patients = KdssmpPatientLocalServiceUtil.getKdssmpPatients(-1, -1);
for(KdssmpPatient patient : patients) {
	LinkedHashMap<String, String> icons = new LinkedHashMap<String, String>();
	icons.put("A1", "patient");
	icons.put("A2", patient.getGender());
	icons.put("ASUMMETY", patient.getFirstname() + " " + patient.getLastname() + "<br>" + dateFormat.format(patient.getDateofbirth()));
	icons.put("ACODE", patient.getGender());
	icons.put("A4", "+");
	
	Organization organization = OrganizationLocalServiceUtil.getOrganization(patient.getOrganizationId());
	String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
	icons.put("link", orgPath);
	
	List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId(), organization.getGroup().getGroupId());
	for (UserGroupRole ugr : usergrouprolles) {
		if(ugr.getRoleId() == optionsRoleForUser_cfg) {
			icons.put("A4", icons.get("A4") + "§,§stared");
		}
	}
	
	String initialdiagnosis = patient.getInitialDiagnosis();
	if(!initialdiagnosis.equals("")) {
		initialdiagnosis = initialdiagnosis.replaceAll("erstdiagnose", "");
		icons.put("A3", initialdiagnosis);
	}
	
	if(patient.getDateofdeath() != null) {
		icons.put("A4", icons.get("A4") + "§,§death");
	}
	icons.put("A4", icons.get("A4") + "§,§TEXT:<div style=\"background-image: url('/BiBBoxKDSSMP-portlet/images/folder_document.png');background-size: 20px 20px;background-repeat: no-repeat;width: 25px;height: 25px;margin-left: 6px;margin-top: 2px;\">" + patient.getNumberOfEvents() + "</div>");
	
	%>
	<%= SymbolConfigurationLocalServiceUtil.getSymbol("default", "patient", icons) %>
	<%
}
%>