<%@ include file="/html/init.jsp" %> 

<portlet:defineObjects />

This is the <b>Test Ddl Display</b> portlet in View mode.
<br /><br />
<%
String ddlname = "reg_core";
long structureid = 14446;

List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(themeDisplay.getSiteGroupId());
for(DDLRecordSet rdc_rs : rdc_recordlist) {
	
	
	String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
	if(rdc_rsname.equalsIgnoreCase(ddlname)) {
		List<DDLRecord> records = rdc_rs.getRecords();
			for(DDLRecord record : records) {
				
			
				%>
				<%= record.getFieldValue("acronym") %> | <%= rdc_rsname %><br />
				<%
			}
	}
}
%>
<hr>
