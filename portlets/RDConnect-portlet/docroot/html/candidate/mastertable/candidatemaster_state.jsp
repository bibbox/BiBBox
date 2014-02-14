<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<portlet:defineObjects />
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
MasterCandidate candidate = (MasterCandidate)row.getObject();

String state = "";
if(candidate.getState().equalsIgnoreCase("P") && candidate.getOrganisationid()!= 0 ) {
	Organization organization = OrganizationLocalServiceUtil.getOrganization(candidate.getOrganisationid());
	String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
	
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
	
	state = "P";
	%>
	<aui:a href="<%= orgPath %>"><div class="rdc-table-state-publisched"><%= state %></div></aui:a>
	<%
} else {
	state = "NP";
%>
<div class="rdc-table-state-publisched"><%= state %></div>

<%
}
%>