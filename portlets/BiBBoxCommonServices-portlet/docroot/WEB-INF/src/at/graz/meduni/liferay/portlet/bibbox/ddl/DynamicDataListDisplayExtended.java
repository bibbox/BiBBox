package at.graz.meduni.liferay.portlet.bibbox.ddl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DynamicDataListDisplayExtended
 */
public class DynamicDataListDisplayExtended extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Update DDL from Edit
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void updateDDL(ActionRequest request, ActionResponse response) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long recordId = ParamUtil.getLong(request, "recordId");
			long recordsetId = ParamUtil.getLong(request, "recordsetId");
			long organizationId = ParamUtil.getLong(request, "organizationId");
			long scopegroupId = ParamUtil.getLong(request, "scopegroupId");
			
			// Update DDL
			DDLRecordSet recordset = DDLRecordSetLocalServiceUtil.getDDLRecordSet(recordsetId);
			DDLRecord record = DDLRecordLocalServiceUtil.getDDLRecord(recordId);
			Map<String, Map<String, String>> fieldmap = recordset.getDDMStructure().getFieldsMap();
			String fieldschanged = "";
			
			ServiceContext serviceContext = new ServiceContext();	
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	        serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());        
	        serviceContext.setUserId(themeDisplay.getUserId());

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
			Fields fields = record.getFields();
			for(String fieldname : fieldmap.keySet()) {
				if(fieldname.equalsIgnoreCase("_fieldsDisplay")) {
					continue;
				}
				try {
					String newfieldvalue = "";
					if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("select")) {
						// Select
						if(fieldmap.get(fieldname).get("multiple").equalsIgnoreCase("true")) {
							// Multiselect
							String[] items = ParamUtil.getParameterValues(request, fieldname);
							boolean first = true;
							String fieldvalue = "[";
							for(String item : items){
								if(!first) {
									fieldvalue += ",";
								} else {
									first = false;
								}
								fieldvalue += "\"" + item + "\"";
							}
							fieldvalue += "]";
							//System.out.println(fieldvalue);
							Field field_new = new Field(fieldname, fieldvalue);
							fields.put(field_new);
							newfieldvalue = fieldvalue;
						} else {
							// Dropbox
							String value = ParamUtil.getString(request, fieldname);
							if(value == null) {
								value = "";
							}
							Field field_new = new Field(fieldname, "[\"" + value + "\"]");
							fields.put(field_new);
							newfieldvalue = "[\"" + value + "\"]";
						}
					} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("text")) {
						String value = ParamUtil.getString(request, fieldname);
						if(value == null) {
							value = "";
						}
						Field field_new = new Field(fieldname, value);
						fields.put(field_new);
						newfieldvalue = value;
					} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("textarea")) {
						String value = ParamUtil.getString(request, fieldname);
						if(value == null) {
							value = "";
						}
						Field field_new = new Field(fieldname, value);
						fields.put(field_new);
						newfieldvalue = value;
					} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("ddm-text-html")) {
						String value = ParamUtil.getString(request, fieldname);
						if(value == null) {
							value = "";
						}
						Field field_new = new Field(fieldname, "[\"" + value + "\"]");
						fields.put(field_new);
						newfieldvalue = "[\"" + value + "\"]";
					} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("ddm-number")) {
						String value = ParamUtil.getString(request, fieldname);
						if(value == null) {
							value = "";
						}
						Field field_new = new Field(fieldname, value);
						fields.put(field_new);
						newfieldvalue = value;
					} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("ddm-integer")) {
						String value = ParamUtil.getString(request, fieldname);
						if(value == null) {
							value = "";
						}
						Field field_new = new Field(fieldname, value);
						fields.put(field_new);
						newfieldvalue = value;
					} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("ddm-decimal")) {
						String value = ParamUtil.getString(request, fieldname);
						if(value == null) {
							value = "";
						}
						Field field_new = new Field(fieldname, value);
						fields.put(field_new);
						newfieldvalue = value;
					} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("ddm-date")) {
						Date valuedate = ParamUtil.getDate(request, fieldname, dateFormat);
						Field field_new = new Field(fieldname, valuedate.getTime());
						fields.put(field_new);
						newfieldvalue = String.valueOf(valuedate);
					} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("checkbox")) {
						String value = ParamUtil.getString(request, fieldname);
						if(value == null) {
							value = "";
						}
						Field field_new = new Field(fieldname, value);
						fields.put(field_new);
						newfieldvalue = value;
					} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("radio")) {
						String value = ParamUtil.getString(request, fieldname);
						if(value == null) {
							value = "";
						}
						Field field_new = new Field(fieldname, value);
						fields.put(field_new);
						newfieldvalue = value;
					}
					// Determine if there was an update on a value.
					Field field_old = record.getField(fieldname);
					Field field_new = fields.get(fieldname);
					if(field_new != null && field_new.getValue() != null) {
						if(field_old != null && field_old.getValue() != null) {
							String oldvalue = field_old.getValue().toString();
							if(!oldvalue.equalsIgnoreCase(newfieldvalue)) {
								fieldschanged = "<br>" + fieldname + " answer changed from " + oldvalue + " to " + newfieldvalue + ".";
								System.out.println(fieldschanged);
							}
						} else {
							if(!newfieldvalue.equalsIgnoreCase("")) {
								fieldschanged = "<br>" + fieldname + " new answer: " + newfieldvalue;
								System.out.println(fieldschanged);
							}
						}
					}
				} catch(Exception ex) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.ddl.DynamicDataListDisplayExtended::updateDDL] Error wihle Updating DDL field: " + fieldname + ".");
					ex.printStackTrace();
				}
			}
			DDLRecordLocalServiceUtil.updateRecord(themeDisplay.getUserId(), recordId, false, record.getDisplayIndex(), fields, false, serviceContext);
			// Update Modified date of Organization
			// Add event for Organization
			if(organizationId != 0) {
				Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
				// Update Modified date
				organization.setModifiedDate(new Date());
				OrganizationLocalServiceUtil.updateOrganization(organization);
				
				// Add event for Organization
				if(fieldschanged.equalsIgnoreCase("")) {
					fieldschanged = "<br>No Items have changed.";
				}
				
				String organizationtype = organization.getExpandoBridge().getAttribute("Organization Type").toString();
				String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
			 	if(organizationtype.equalsIgnoreCase("Biobank")) {
			 		orgPath = orgPath + "/bb_home";
			 	} else if (organizationtype.equalsIgnoreCase("Registry")) {
			 		orgPath = orgPath + "/reg_home";
			 	} else if (organizationtype.equalsIgnoreCase("Network")) {
			 		orgPath = orgPath + "/home";
			 	}
				
				String eventtype = "Data Updated: " + "[url organization " + organizationId + "]" + organization.getName() + "[urlend]";
				String shorttext = "[url organization " + organizationId + "]" + organization.getName() + "[urlend] updated the fields in " + recordset.getName();
				String longtext = themeDisplay.getUser().getFullName() + " updated the fields in " + recordset.getName() + " for [url organization " + organizationId + "]" + organization.getName() + "[urlend]." + fieldschanged;
				String link = "";
				String restricted = "false";
				addEventEntry(eventtype, new Date(), organizationId, themeDisplay.getUserId(), shorttext, longtext, link, restricted);
			}
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.ddl.DynamicDataListDisplayExtended::updateDDL] Error wihle Updating DDL.");
			ex.printStackTrace();
		}
	}
	
	/**
	 * RD-Connect Event System add event entry
	 * 
	 * @param eventdate
	 * @param organizationId
	 * @param userId
	 * @param shorttext
	 * @param longtext
	 * @param link
	 * @param restricted
	 */
	private void addEventEntry(String eventtype, Date eventdate, long organizationId, long userId, String shorttext, String longtext, String link, String restricted) {
		RDConnectEventLocalServiceUtil.createEvent(eventtype, eventdate, organizationId, userId, shorttext, longtext, link, restricted);
	}
}
