package at.meduni.liferay.portlet.rdconnect.staticddl;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

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
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class RegStaticDDL
 */
public class RegStaticDDL extends MVCPortlet {
	public void updateCoreDDL(ActionRequest request, ActionResponse response) throws Exception {	
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long recordId = ParamUtil.getLong(request, "recordId");
			long recordSetId = ParamUtil.getLong(request, "recordSetId");
			long organizationId = ParamUtil.getLong(request, "organizationId");
			
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
			
			ServiceContext serviceContext = new ServiceContext();
	
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	        Group group = organization.getGroup();
	        serviceContext.setScopeGroupId(group.getGroupId());
	        
	        serviceContext.setUserId(organization.getUserId());
			
			DDLRecordSet recordSet = DDLRecordSetLocalServiceUtil.getDDLRecordSet(recordSetId);
			DDMStructure ddmStructure = recordSet.getDDMStructure();
			
			DDLRecord record = DDLRecordLocalServiceUtil.getRecord(recordId);
			
			Fields fields = record.getFields();//DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);
			
			Map<String, Map<String, String>> fieldmap = ddmStructure.getFieldsMap();
			for(String fieldname : fieldmap.keySet()) {
				if(fieldname.equalsIgnoreCase("_fieldsDisplay")) {
					continue;
				}
				if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("select") && fieldmap.get(fieldname).get("multiple").equalsIgnoreCase("true")) {
					//System.out.println("Field: " + fieldname + " type: " + fieldmap.get(fieldname).get("type") + " Value: --" );
					String[] items = ParamUtil.getParameterValues(request, fieldname);
					boolean first = true;
					String fieldvalue = "[";
					for(String item : items){
						if(!first) {
							fieldvalue += ",";
							first = false;
						}
						fieldvalue += "\"" + item + "\"";
					}
					fieldvalue += "]";
					Field field_acronym = new Field(fieldname, fieldvalue);
					fields.put(field_acronym);
					//record.getField(fieldname).setValue(fieldvalue);
				} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("select")) {
					String value = ParamUtil.getString(request, fieldname);
					if(value == null) {
						value = "";
					}
					//record.getField(fieldname).setValue("[\"" + value + "\"]");
					Field field_acronym = new Field(fieldname, "[\"" + ParamUtil.getString(request, fieldname) + "\"]");
					fields.put(field_acronym);
				} else {
					String value = ParamUtil.getString(request, fieldname);
					if(value == null) {
						value = "";
					}
					System.out.println("#" + value + "#");
					//record.getField(fieldname).setValue(value);
					//System.out.println("Field: " + fieldname + " type: " + fieldmap.get(fieldname).get("type") + " Value: " + ParamUtil.getString(request, fieldname));
					Field field_acronym = new Field(fieldname, ParamUtil.getString(request, fieldname));
					fields.put(field_acronym);
				}
			}
			
			//record.getField("").setValue(value);
			
			DDLRecordLocalServiceUtil.updateRecord(themeDisplay.getUserId(), recordId, false, record.getDisplayIndex(), fields, false, serviceContext);
			//DDLRecordLocalServiceUtil.updateDDLRecord(record);
			
			// Read Data from request
			/*String acronym = ParamUtil.getString(request, "acronym");
			String Description = ParamUtil.getString(request, "Description");
			String Hoste_institute = ParamUtil.getString(request, "Hoste_institute");
			String Host_institution_is_a = ParamUtil.getString(request, "Host_institution_is_a");
			String Type_of_host_institution = ParamUtil.getString(request, "Type_of_host_institution");
			String Text5085 = ParamUtil.getString(request, "Text5085");
			String Target_population_of_the_registry = ParamUtil.getString(request, "Target_population_of_the_registry");
			String year_of_establishment = ParamUtil.getString(request, "year_of_establishment");
			String Ontologies = ParamUtil.getString(request, "Ontologies");
			String Additional_Ontologies = ParamUtil.getString(request, "Additional_Ontologies");
			String Associated_data_available = ParamUtil.getString(request, "Associated_data_available");
			String Additional_Associated_data_available = ParamUtil.getString(request, "Additional_Associated_data_available");
			String Imaging_available = ParamUtil.getString(request, "Imaging_available");
			String Additional_Imaging_available = ParamUtil.getString(request, "Additional_Imaging_available");
			String The_registry_biobanks_is_listed_in_other_inventories_networks = ParamUtil.getString(request, "The_registry_biobanks_is_listed_in_other_inventories_networks");
			String Additional_networks_inventories = ParamUtil.getString(request, "Additional_networks_inventories");*/
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
