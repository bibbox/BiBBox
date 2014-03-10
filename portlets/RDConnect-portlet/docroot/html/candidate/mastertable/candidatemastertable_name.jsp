<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>

<portlet:defineObjects />
<%

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
MasterCandidate candidate = (MasterCandidate)row.getObject();

String orgPath = "";
if(candidate.getState().equalsIgnoreCase("P") && candidate.getOrganisationid()!= 0 ) {
	Organization organization = OrganizationLocalServiceUtil.getOrganization(candidate.getOrganisationid());
	orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
	
	if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
		orgPath = orgPath + "/at_home";
	} else {
		List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
	  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
	  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
	  		
	  		if(rdc_rsname.equals("core")) {  		
	  			List<DDLRecord> records = rdc_rs.getRecords();
	  			for(DDLRecord record : records) {
	  				if(record.getFieldValue("Radio2493") != null) {
		  				String type = record.getFieldValue("Radio2493").toString();
		  				if(type.equalsIgnoreCase("[bb]") || type.equalsIgnoreCase("[\"bb\"]")) {
		  					orgPath = orgPath + "/bb_home";
		  				} else if(type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
		  					orgPath = orgPath + "/home";
		  				} else {
		  					orgPath = orgPath + "/regbb_home";
		  				}
	  				}
	  			}
	  		}
		}
	}
}
String name = "";
if(orgPath.equalsIgnoreCase("")) {
	name = candidate.getName();
} else {
	name = "<a href=\"" + orgPath + "\" target=\"_blank\">" + candidate.getName() + "</a>";
}
%>
<div class="rdc-table-nameentry">
<div class="rdc-table-nameentry-name"><%= name %></div>
<div class="rdc-table-nameentry-diseases"><%= candidate.getDiseasesfreetext() %>, <%= candidate.getDiseasescodes() %></div>
<div class="rdc-table-nameentry-contact"><%= candidate.getContactperson() %>, <%= candidate.getMail() %></div>
<div class="rdc-table-nameentry-url"><a href="<%= candidate.getUrl() %>"><%= candidate.getUrl() %></a></div>
</div>