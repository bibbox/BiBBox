<%@ include file="/html/ddl/init.jsp" %>  

<portlet:defineObjects />
<liferay-theme:defineObjects />

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<style>
.modifieddateforddl {
	text-decoration: overline;
	font-size: 80%;
	height: 100%;
}
.clear:after {
    clear: both;
    content: "";
    display: table;
}

span.fieldnametip {
  position: relative;
  display: inline;
}
span.fieldnametip span {
  position: absolute;
  width:200px;
  color: #000000;
  background: #F4F4E1;
  border: 1px solid #E0E0CF;
  line-height: 21px;
  text-align: center;
  visibility: hidden;
  border-radius: 5px;
}
span.fieldnametip span:before {
  content: '';
  position: absolute;
  top: 100%;
  left: 50%;
  margin-left: -12px;
  width: 0; height: 0;
  border-top: 12px solid #E0E0CF;
  border-right: 12px solid transparent;
  border-left: 12px solid transparent;
}
span.fieldnametip span:after {
  content: '';
  position: absolute;
  top: 100%;
  left: 50%;
  margin-left: -8px;
  width: 0; height: 0;
  border-top: 8px solid #F4F4E1;
  border-right: 8px solid transparent;
  border-left: 8px solid transparent;
}
span:hover.fieldnametip span {
  visibility: visible;
  opacity: 0.9;
  bottom: 25px;
  left: 50%;
  margin-left: -100px;
  z-index: 999;
}
</style>

<%
// Get Configurations
String recordname_cfg = GetterUtil.getString(portletPreferences.getValue("recordname", ""));
boolean countFields_cfg = GetterUtil.getBoolean(portletPreferences.getValue("countFields", "false"));
float countFieldsCutoff_cfg = GetterUtil.getFloat(portletPreferences.getValue("countFieldsCutoff", "0.8"));

SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

String redirect = PortalUtil.getCurrentURL(renderRequest);	
//Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_add_diseasematrix = "EDIT_DDL_ENTRY";

// Setup Organization
long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// Get Organization if group is one
  	organizationId = currentGroup.getClassPK();
  	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
}
%>

<h3>Record Name: <%= recordname_cfg %></h3><br>

<% 
List<DDLRecordSet> recordsets = DDLRecordSetLocalServiceUtil.getRecordSets(scopeGroupId);
for (DDLRecordSet recordset : recordsets) {
	if(recordname_cfg.equalsIgnoreCase(recordset.getNameCurrentValue())) {
		List<DDLRecord> records = recordset.getRecords();
		for (DDLRecord record : records) {
			%>
			<c:choose>
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_diseasematrix) %>">
					<aui:button-row>
						<portlet:renderURL var="editDDLEntryURL">
							<portlet:param name="mvcPath" value="/html/ddl/dynamicdatalistdisplayextended/edit.jsp" />
							<portlet:param name="recordsetId" value="<%= Long.toString(recordset.getRecordSetId()) %>" />
							<portlet:param name="recordId" value="<%= Long.toString(record.getRecordId()) %>" />
							<portlet:param name="redirect" value="<%= redirect %>" />
						</portlet:renderURL>
						<aui:button value="edit-ddl-entry" onClick="<%= editDDLEntryURL.toString() %>"/>
					</aui:button-row>
				</c:when>
			</c:choose>
			
			<div style="clear: both;">
			<div class="floatingddlcontainer clear">
			<%
			Map<String, Map<String, String>> fieldmap = recordset.getDDMStructure().getFieldsMap();
			/*for(String key : fieldmap.keySet()) {
				System.out.println(key);
				for(String key2 : fieldmap.get(key).keySet()) {
					System.out.println("  " + key2 + " - " + fieldmap.get(key).get(key2));
				}
			}*/

			Map<String, Map<String, String>> fieldmap_options = null;
			fieldmap_options = recordset.getDDMStructure().getTransientFieldsMap(themeDisplay.getLocale().toString());
			HashMap<String, LinkedHashMap<String, String>> field_options = new HashMap<String, LinkedHashMap<String, String>>();
		  	for(String key_options : fieldmap_options.keySet()) {
		  		String ddlfield = fieldmap_options.get(key_options).get("_parentName_");
		  		if(!field_options.containsKey(ddlfield)) {
		  			field_options.put(ddlfield, new LinkedHashMap<String, String>());
		  		}
		  		field_options.get(ddlfield).put(fieldmap_options.get(key_options).get("value"), fieldmap_options.get(key_options).get("label"));
		  	}
		  	
			int counter_sum = 0;
			int counter_filled = 0;
			String group = "";
			for(String fieldname : fieldmap.keySet()) {
				if(fieldname.equalsIgnoreCase("_fieldsDisplay")) {
					continue;
				}
				Field field = record.getField(fieldname);
				DDLConfiguration fieldconfiguration = DDLConfigurationLocalServiceUtil.getDDLConfigurationForField(recordset.getDDMStructureId(), fieldname);
				String cssclasselementwidth = "width: 100%;";
				String viewtip = "";
				String titlecss = "";
				String valuecss = "";
				if(fieldconfiguration != null) {
					if(!fieldconfiguration.getDisplay()) {
						continue;
					}
					
					// Display Filter
					String[] displayfilters = fieldconfiguration.getViewscript().split("§statement§");
					boolean displayfiltershit = false;
					for(String displayfilter : displayfilters) {
						String[] elments = displayfilter.split("§=§");
						if(elments.length == 2) {
							Field compare_field = record.getField(elments[0]);
							if(!compare_field.getValue().toString().contains(elments[1])) {
								displayfiltershit = true;
							}
						}
					}
					if(displayfiltershit) {
						continue;
					}
					
					// Configuration Display Styles
					if(fieldconfiguration.getColumwidth() != 0) {
						cssclasselementwidth = "width: " + fieldconfiguration.getColumwidth() + "%;";
					}
					titlecss = fieldconfiguration.getViewtitlecss();
					valuecss = fieldconfiguration.getViewvaluecss();
					
					// Create Popup for tips
					if(!fieldconfiguration.getDisplaytip().equalsIgnoreCase("")) {
						viewtip = "&nbsp;&nbsp;<span class=\"fieldnametip\"><img src=\"" + request.getContextPath() + "/images/icon_fragezeichen.png\" alt=\"?\"><span>" + fieldconfiguration.getDisplaytip() + "</span></span>" ;
					}
					
					// Print Group
					if(!group.equalsIgnoreCase(fieldconfiguration.getGroup())) {
						group = fieldconfiguration.getGroup();
						%>
						<h3><%= group %></h3>
						<%
					}
				}
				counter_sum ++;
				String fieldtitle = fieldmap.get(fieldname).get("label") + viewtip + ":";
				%>
				<div style="float: left;height: 100%;<%= cssclasselementwidth %>">
				
				<%
				if(field == null) {
					%>
					<div style="float: left;<%= titlecss %>"><%= fieldtitle %></div><div  style="float: left;<%= valuecss %>">&nbsp;</div>
					<%
				} else {
	 				if(field.getType().equalsIgnoreCase("text")) {
						// Text
						if(field.getValue() != null && !field.getValue().toString().isEmpty()) {
							counter_filled ++;
						}
						%>
						<div style="float: left;<%= titlecss %>"><%= fieldtitle %></div><div  style="float: left;<%= valuecss %>"><%= field.getValue() %></div>
						<% 
					} else if(field.getType().equalsIgnoreCase("ddm-number")) {
						// Number
						String value = "";
						if(field.getValue() != null) {
							counter_filled ++;
							value = field.getValue().toString();
						}
						%>
						<div style="float: left;<%= titlecss %>"><%= fieldtitle %></div><div  style="float: left;<%= valuecss %>"><%= value %></div>
						<% 
					} else if(field.getType().equalsIgnoreCase("checkbox")) {
						// Boolean
						counter_filled ++;
						String value = "";
						if(field.getValue().toString().equalsIgnoreCase("false")) {
							value = "<i class=\"fa fa-square-o\"></i>";
						} else {
							value = "<i class=\"fa fa-check-square-o\"></i>";
						}
						%>
						<div style="float: left;<%= titlecss %>"><%= fieldtitle %></div><div  style="float: left;<%= valuecss %>"><%= value %></div>
						<%
					} else if(field.getType().equalsIgnoreCase("ddm-documentlibrary")) {
						// Documents_and_Media
						%>
						--<%= fieldtitle %> <%= field.getValue() %>
						<%
					} else if(field.getType().equalsIgnoreCase("ddm-text-html")) {
						// HTML
						String value = "";
						if(!field.getValue().toString().isEmpty()) {
							counter_filled ++;
							value = field.getValue().toString().replaceAll("\\[\"", "").replaceAll("\"\\]", "");
						}
						%>
						<div style="float: left;<%= titlecss %>"><%= fieldtitle %></div><div  style="float: left;<%= valuecss %>"><%= value %></div>
						<%
					} else if(field.getType().equalsIgnoreCase("ddm-link-to-page")) {
						// Link of to a page
						%>
						--<%= fieldtitle %> <%= field.getValue() %>
						<%
					} else if(field.getType().equalsIgnoreCase("radio")) {
						// Radio
						if(!field.getValue().toString().isEmpty() && !field.getValue().toString().equalsIgnoreCase("not specified")) {
							counter_filled ++;
						}
						%>
						<div style="float: left;<%= titlecss %>"><%= fieldtitle %></div><div  style="float: left;<%= valuecss %>"><%= field_options.get(fieldname).get(field.getValue().toString().replaceAll("\\[\"", "").replaceAll("\"\\]", "")) %></div>
						<%
					} else if(field.getType().equalsIgnoreCase("ddm-integer")) {
						// Integer
						String value = "";
						if(field.getValue() != null) {
							counter_filled ++;
							value = field.getValue().toString();
						}
						%>
						<div style="float: left;<%= titlecss %>"><%= fieldtitle %></div><div  style="float: left;<%= valuecss %>"><%= value %></div>
						<%  
					} else if(field.getType().equalsIgnoreCase("textarea")) {
						// Text Box
						if(!field.getValue().toString().isEmpty()) {
							counter_filled ++;
						}
						%>
						<div style="float: left;<%= titlecss %>"><%= fieldtitle %></div><div  style="float: left;<%= valuecss %>"><%= field.getValue() %></div>
						<% 
					} else if(field.getType().equalsIgnoreCase("ddm-decimal")) {
						// Decimal
						String value = "";
						if(field.getValue() != null) {
							counter_filled ++;
							value = field.getValue().toString();
						}
						%>
						<div style="float: left;<%= titlecss %>"><%= fieldtitle %></div><div  style="float: left;<%= valuecss %>"><%= value %></div>
						<%  
					} else if(field.getType().equalsIgnoreCase("ddm-date")) {
						// Date
						String value = "";
						if(field != null && field.getValue() != null) {
							counter_filled ++;
							java.util.Date da = new java.util.Date(field.getValue().toString());
							value = dateFormat.format(da);
						}
						%>
						<div style="float: left;<%= titlecss %>"><%= fieldtitle %></div><div  style="float: left;<%= valuecss %>"><%= value %></div>
						<% 
					} else if(field.getType().equalsIgnoreCase("select")) {
						// Selectbox
						if(fieldmap.get(fieldname).get("multiple").equalsIgnoreCase("true")) {
							// Multiselect
							%>
							<div style="float: left;<%= titlecss %>"><%= fieldtitle %></div>
							<div  style="float: left;<%= valuecss %>">
								<%
								String newline = "";
								String[] field_options_options = field.getValue().toString().replaceAll("\\[\"", "").replaceAll("\"\\]", "").split("\",\"");
								for(String field_options_option : field_options_options) {
									%>
									<%= newline %><%= field_options.get(fieldname).get(field_options_option) %>
									<%
									newline = "<br>";
								}
								%>
							</div>
							<%
						} else {
							// Dropdown
							%>
							<div style="float: left;<%= titlecss %>"><%= fieldtitle %></div><div  style="float: left;<%= valuecss %>"><%= field_options.get(fieldname).get(field.getValue().toString().replaceAll("\\[\"", "").replaceAll("\"\\]", "")) %></div>
							<%
						}
					}
				}
				%>
				<br>
				</div>
				<%
			}
			%>
			</div>
			</div><br>
			<%
			if(countFields_cfg) {
				if(counter_filled*1.0/counter_sum*1.0 < countFieldsCutoff_cfg) {
					%>
					<span style="color:red"><%= counter_filled %> of <%= counter_sum %> fields completed.</span><br>
					<%
				} else {
					%>
					<span style="color:green"><%= counter_filled %> of <%= counter_sum %> fields completed.</span><br>
					<%
				}
			}
			%>
			<span class="modifieddateforddl">v<%= record.getVersion() %> | <%= dateFormat.format(record.getModifiedDate()) %></span>
			<%
		}
	}
}
%>