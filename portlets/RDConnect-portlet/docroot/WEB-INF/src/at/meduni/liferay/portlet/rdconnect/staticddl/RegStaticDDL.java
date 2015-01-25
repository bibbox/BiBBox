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
						} else {
							first = false;
						}
						fieldvalue += "\"" + item + "\"";
					}
					fieldvalue += "]";
					System.out.println(fieldvalue);
					Field field_acronym = new Field(fieldname, fieldvalue);
					fields.put(field_acronym);
				} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("select")) {
					String value = ParamUtil.getString(request, fieldname);
					if(value == null) {
						value = "";
					}
					Field field_acronym = new Field(fieldname, "[\"" + ParamUtil.getString(request, fieldname) + "\"]");
					fields.put(field_acronym);
				} else if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("ddm-text-html")) {
					String value = ParamUtil.getString(request, fieldname);
					if(value == null) {
						value = "";
					}
					Field field_acronym = new Field(fieldname, "[\"" + ParamUtil.getString(request, fieldname) + "\"]");
					fields.put(field_acronym);
				} else {
					String value = ParamUtil.getString(request, fieldname);
					if(value == null) {
						value = "";
					}
					Field field_acronym = new Field(fieldname, ParamUtil.getString(request, fieldname));
					fields.put(field_acronym);
				}
			}
			
			DDLRecordLocalServiceUtil.updateRecord(themeDisplay.getUserId(), recordId, false, record.getDisplayIndex(), fields, false, serviceContext);
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
