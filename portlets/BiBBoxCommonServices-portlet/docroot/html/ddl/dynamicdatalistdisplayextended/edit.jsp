<%@ include file="/html/ddl/init.jsp"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<style>
.yui3-skin-sam .yui3-calendarnav-prevmonth span,.yui3-skin-sam .yui3-calendarnav-nextmonth span
	{
	display: inline;
}

.aui .notdisplayInput {
	display: none;
}

span.fieldnametip {
	position: relative;
	display: inline;
}

span.fieldnametip span {
	position: absolute;
	width: 200px;
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
	width: 0;
	height: 0;
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
	width: 0;
	height: 0;
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
	// Read data for edit
long recordsetId = ParamUtil.getLong(request, "recordsetId");
long recordId = ParamUtil.getLong(request, "recordId");
String redirect = ParamUtil.getString(request, "redirect");

long organizationId = 0;
long scopegroupId = themeDisplay.getScopeGroupId();
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
}

DDLRecordSet recordset = DDLRecordSetLocalServiceUtil.getDDLRecordSet(recordsetId);
DDLRecord record = DDLRecordLocalServiceUtil.getDDLRecord(recordId);
Map<String, Map<String, String>> fieldmap = recordset.getDDMStructure().getFieldsMap();

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
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>
<portlet:actionURL name="updateDDL" var="updateDDLURL"
	windowState="normal" />
<aui:form action="<%=updateDDLURL%>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%=redirect%>" />
		<aui:input type="hidden" name="recordsetId"
			value='<%=String.valueOf(recordsetId)%>' />
		<aui:input type="hidden" name="recordId"
			value='<%=String.valueOf(recordId)%>' />
		<aui:input type="hidden" name="organizationId"
			value='<%=String.valueOf(organizationId)%>' />
		<aui:input type="hidden" name="scopegroupId"
			value='<%=String.valueOf(scopegroupId)%>' />
		<aui:layout>

			<%
				for(String fieldname : fieldmap.keySet()) {
					if(fieldname.equalsIgnoreCase("_fieldsDisplay")) {
						continue;
					}
					
					Field field = record.getField(fieldname);
					DDLConfiguration fieldconfiguration = DDLConfigurationLocalServiceUtil.getDDLConfigurationForField(recordset.getDDMStructureId(), fieldname);
					String viewtip = "";
					String editscript = "";
					int columwidth = 100;
					String startcssclass = "";
					String criterionjason = "";
					if(fieldconfiguration != null) {
						if(!fieldconfiguration.getDisplay()) {
							continue;
						}
						
						// Create Popup for tips
						if(!fieldconfiguration.getEdittip().equalsIgnoreCase("")) {
							viewtip = "&nbsp;&nbsp;<span class=\"fieldnametip\"><img src=\"" + request.getContextPath() + "/images/icon_fragezeichen.png\" alt=\"?\"><span>" + fieldconfiguration.getEdittip() + "</span></span>" ;
						}
							
						// JavaScript for edit
						editscript = fieldconfiguration.getEditscript();
						
						// Set columnwith for edit elements
						if(fieldconfiguration.getColumwidth() != 0) {
							columwidth = (int)fieldconfiguration.getColumwidth();
						}
						
						//-------------------------------------------------
						// Display Filter
						String[] displayfilters = fieldconfiguration.getViewscript().split("§statement§");
						boolean displayfiltershit = false;
						if(!fieldconfiguration.getViewscript().equalsIgnoreCase("")) {
							criterionjason += "{\"criterion\":[";
						}
						String seperate = "";
						for(String displayfilter : displayfilters) {
							String[] elments = displayfilter.split("§=§");
							if(elments.length == 2) {
								Field compare_field = record.getField(elments[0]);
								if(!compare_field.getValue().toString().contains(elments[1])) {
									displayfiltershit = true;
								}
								String type = fieldmap.get(fieldname).get("type");
								if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("select")) {
									if(fieldmap.get(fieldname).get("multiple").equalsIgnoreCase("true")) {
										type += "multiple";
									}
								}
								criterionjason += seperate + "{ \"fieldname\":\"" + elments[0] + "\", \"fieldtype\":\"" + type + "\", \"fieldvalue\":\"" + elments[1] + "\" }";
								seperate = ",";
							}
						}
						if(!fieldconfiguration.getViewscript().equalsIgnoreCase("")) {
							criterionjason += "]}";
						}
						if(displayfiltershit) {
							startcssclass = "notdisplayInput";
						}
					}
					String fieldtitle = fieldmap.get(fieldname).get("label") + viewtip + ":";
					// Create the inputs
			%>
			<aui:column cssClass='<%=fieldname + " " + startcssclass%>'
				columnWidth='<%=columwidth%>'>
				<%
					if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("text")) {
								// Text
								String value = "";
								if(field.getValue() != null) {
									value = field.getValue().toString();
								}
				%>
				<aui:input cssClass="<%=fieldname%>" name="<%=fieldname%>"
					label="<%=fieldtitle%>" value="<%=value%>" />
				<%
					} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("textarea")) {
								// Text Box
								String value = "";
								if(field.getValue() != null) {
									value = field.getValue().toString();
								}
				%>
				<aui:input cssClass="<%=fieldname%>" name="<%=fieldname%>"
					label="<%=fieldtitle%>" type="textarea" value="<%=value%>" />
				<%
					} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("ddm-text-html")) {
								// HTML
								String value = "";
								if(field.getValue() != null) {
									value = field.getValue().toString().replaceAll("\\[\"", "").replaceAll("\"\\]", "");
								}
				%>
				<aui:field-wrapper cssClass="<%=fieldname%>"
					label="<%=fieldtitle%>">
					<liferay-ui:input-editor cssClass="<%=fieldname%>"
						toolbarSet="liferay-article" initMethod="initEditor" width="100%" />
				</aui:field-wrapper>
				<script type="text/javascript">
							function <portlet:namespace />initEditor() { return '<%=value%>'; }
						</script>
				<%
					} else if (fieldmap.get(fieldname).get("type").equalsIgnoreCase("ddm-number")) {
											// Number
											String value = "";
											if (field.getValue() != null) {
												value = field.getValue().toString();
											}
				%>
				<aui:input cssClass='<%= fieldname + " form-control field-digits" %>' name="<%=fieldname%>"
					label="<%=fieldtitle%>" value="<%=value%>" />
				<%
					} else if (fieldmap.get(fieldname).get("type").equalsIgnoreCase("ddm-integer")) {
											// Integer
											String value = "";
											if (field.getValue() != null) {
												value = field.getValue().toString();
											}
				%>
				<aui:input cssClass="<%=fieldname%>" name="<%=fieldname%>"
					label="<%=fieldtitle%>" value="<%=value%>" />
				<%
					} else if (fieldmap.get(fieldname).get("type").equalsIgnoreCase("ddm-decimal")) {
											// Decimal
											String value = "";
											if (field.getValue() != null) {
												value = field.getValue().toString();
											}
				%>
				<aui:input cssClass="<%=fieldname%>" name="<%=fieldname%>"
					label="<%=fieldtitle%>" value="<%=value%>" />
				<%
					} else if (fieldmap.get(fieldname).get("type").equalsIgnoreCase("ddm-date")) {
											// Date
											String value = "";
											if (field != null && field.getValue() != null) {
												java.util.Date da = new java.util.Date(field.getValue().toString());
												value = dateFormat.format(da);
											}
				%>
				<label for="<%=fieldname%>"><%=fieldtitle%></label>
				<input cssClass="<%=fieldname%>" class="form-control field-date"
					name="<portlet:namespace /><%=fieldname%>" type="text"
					placeholder="dd/mm/yyyy" value="<%=value%>">
				<%
					} else if (fieldmap.get(fieldname).get("type").equalsIgnoreCase("checkbox")) {
											// Checkbox
											String value = "";
											if (field.getValue() != null) {
												value = field.getValue().toString();
											}
				%>
				<aui:input cssClass="<%=fieldname%>" name="<%=fieldname%>"
					label="<%=fieldtitle%>" type="checkbox" value="<%=value%>" />
				<%
					} else if (fieldmap.get(fieldname).get("type").equalsIgnoreCase("radio")) {
											// Radio
											String value = "";
											if (field != null && field.getValue() != null) {
												value = field.getValue().toString().replaceAll("\\[\"", "").replaceAll("\"\\]", "");
											}
				%>
				<aui:field-wrapper name="<%=fieldname%>" label="<%=fieldtitle%>">
					<%
						for (String option : field_options.get(fieldname).keySet()) {
					%>
					<aui:input cssClass="<%=fieldname%>"
						checked="<%=value.equalsIgnoreCase(option) ? true : false%>"
						inlineLabel="right" name="<%=fieldname%>" type="radio"
						value="<%=option%>"
						label="<%=field_options.get(fieldname).get(option)%>" />
					<%
						}
					%>
				</aui:field-wrapper>
				<%
					} else if (fieldmap.get(fieldname).get("type").equalsIgnoreCase("select")) {
											// Selectbox
											if (fieldmap.get(fieldname).get("multiple").equalsIgnoreCase("true")) {
												// Multiselect
												String value = "";
												if (field != null && field.getValue() != null) {
													value = field.getValue().toString();
												}
				%>
				<aui:select name="<%=fieldname%>" label="<%=fieldtitle%>"
					cssClass="<%=fieldname%>" multiple="true">
					<%
						for (String option : field_options.get(fieldname).keySet()) {
															String option_teststring = "\"" + option + "\"";
					%>
					<aui:option selected="<%=value.contains(option_teststring)%>"
						value="<%=option%>">
						<liferay-ui:message
							key='<%=field_options.get(fieldname).get(option)%>' />
					</aui:option>
					<%
						}
					%>
				</aui:select>
				<%
					} else {
												// Dropdown
												String value = "";
												if (field.getValue() != null) {
													value = field.getValue().toString().replaceAll("\\[\"", "").replaceAll("\"\\]", "");
												}
				%>
				<aui:select name="<%=fieldname%>" label="<%=fieldtitle%>"
					cssClass="<%=fieldname%>">
					<%
						for (String option : field_options.get(fieldname).keySet()) {
					%>
					<aui:option selected="<%=option.equalsIgnoreCase(value)%>"
						value="<%=option%>">
						<liferay-ui:message
							key='<%=field_options.get(fieldname).get(option)%>' />
					</aui:option>
					<%
						}
					%>
				</aui:select>
				<%
					}
										}
				%>
			</aui:column>
			<%
				if (!criterionjason.equalsIgnoreCase("")) {
			%>
			<aui:script>
						AUI().use('aui-base', 'bibboxcs', function(A){
							<%
				if (fieldconfiguration != null) {
											String[] displayfilters = fieldconfiguration.getViewscript().split("§statement§");
											for (String displayfilter : displayfilters) {
												String[] elments = displayfilter.split("§=§");
												if (elments.length == 2) {
													Field compare_field = record.getField(elments[0]);
			%>
										A.all(".<%=elments[0]%>").on('change',function(){
											A.bibboxcsEditScripts.DisplayRules('<%=fieldname%>', '<%=criterionjason%>');
										});
										<%
				}
											}
										}
			%>
						});
					</aui:script>
			<%
				}
			%>
			<aui:script>
				<%=editscript%>
			</aui:script>
			<%
				}
			%>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%=redirect%>" />
	</aui:button-row>
</aui:form>

<aui:script>
AUI.add('bibboxcs', function (A) {
	A.bibboxcsEditScripts = {
		DisplayRules: function (fieldname, criterion) {
			//alert(criterion);
			var jsonData = JSON.parse(criterion);
			var hide = false;
			for (var i = 0; i < jsonData.criterion.length; i++) {
				if(jsonData.criterion[i].fieldtype == "selectmultiple") {
					if(A.bibboxcsEditScripts.MultiselectEditScript(jsonData.criterion[i].fieldname, jsonData.criterion[i].fieldvalue)) {
						hide = true;
					}
					//alert("Multiselect: " + A.bibboxcsEditScripts.MultiselectEditScript(jsonData.criterion[i].fieldname, jsonData.criterion[i].fieldvalue));
				} else {
					if(A.bibboxcsEditScripts.MultiselectEditScript(jsonData.criterion[i].fieldname, jsonData.criterion[i].fieldvalue)) {
						hide = true;
					}
					//alert("Other: " + A.bibboxcsEditScripts.ValuesEditScript(jsonData.criterion[i].fieldname, jsonData.criterion[i].fieldvalue));
				}		
			}
			if(hide) {
				A.bibboxcsEditScripts.HideField(fieldname);
			} else {
				A.bibboxcsEditScripts.UnhideField(fieldname);
			}
		},
		HideField: function(fieldname) {
			A.all("." + fieldname).addClass('notdisplayInput');
		},
		UnhideField: function(fieldname) {
			A.all("." + fieldname).removeClass('notdisplayInput');
		},
		MultiselectEditScript: function (fieldname, fieldvalue){
 		   	var multiselect_values = '';
    		var multiselect=A.all("." + fieldname + " option:selected");
    		multiselect.each(function (taskNode) {
 			   multiselect_values += taskNode.get('value') + ';';
 		   });
 		   if(multiselect_values.indexOf(fieldvalue + ";") > -1) {
				//alert(multiselect_values + " contains " + fieldvalue);
				return true;
			} else {
				//alert(multiselect_values + " m!= " + fieldvalue);
				return false;
			}
		},
		ValuesEditScript: function (fieldname, fieldvalue){
			var inputobject = "" + A.all("." + fieldname).get('value');
			inputobject = inputobject.replace(/^,/i, "");
			if(inputobject == fieldvalue) {
				//alert(inputobject + " == " + fieldvalue);
				return true;
			} else {
				//alert(inputobject + " != " + fieldvalue);
				return false;
			}
		}
	};
});
</aui:script>
<aui:script use="aui-form-validator">
AUI().use(
  'aui-form-validator',
  function(A) {
    new A.FormValidator(
      {
        boundingBox: '#<portlet:namespace />fm'
      }
    );
  }
);
</aui:script>
<aui:script use="aui-io-request, event, node, aui-popover, valuechange, event-hover, aui-tooltip, event-valuechange, click">
	AUI().use(
	  'aui-datepicker',
	  function(Y) {
	    var datepicker = new Y.DatePicker({
			trigger: '.field-date',
			mask: '%d/%m/%Y',
			popover: {
				toolbars: {
					header: [[
						{
						   icon:'icon-trash',
						   label: 'Clear',
						   on: {
						      click: function() {
						          datepicker.clearSelection();
						      }
						   }
						 },
						{
						    icon:'icon-globe',
						    label: 'Today',
						    on: {
						        click: function() {
						             datepicker.clearSelection();
						             datepicker.selectDates(new Date());
						         }
						     }
						 }
					]]
				},
				zIndex: 1
				}
			}
		);
	}
	);
</aui:script>
