package at.meduni.liferay.portlet.test;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordConstants;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSetConstants;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Ajaxtest
 */
public class Ajaxtest extends MVCPortlet {
	final String alphabet_ = "abcdefghijklmopqrstuvwxyz";
    final int N_ = alphabet_.length();
    Random random_ = new Random();
	
	public void somethingHappensHere(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException { 
		System.out.println("ID: " + ParamUtil.getString(actionRequest, "id"));
		System.out.println("Name: " + ParamUtil.getString(actionRequest, "name"));
		System.out.println("Somthing has happend");
		
		
		
		/*DDLRecordSet rs = DDLRecordSetLocalServiceUtil.getRecordSet(1);
		
		//DDLRecordSet rs = DDLRecordSetLocalServiceUtil.getRecordSet(14503);
		
		//rs.getNameCurrentValue()
		
		
		
		List<DDLRecord> rcords = rs.getRecords();
		for(DDLRecord re : rcords) {
			re.
		}*/
		/*System.out.println("Record set id: " + "34805");
		DDLRecordSet rs = DDLRecordSetLocalServiceUtil.getRecordSet(34805); 
		
		
		*/
		try {
		Organization organization = OrganizationLocalServiceUtil.getOrganization(24401);
		
		ServiceContext serviceContext = new ServiceContext();

        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);
        Group group = organization.getGroup();
        serviceContext.setScopeGroupId(group.getGroupId());
        
        serviceContext.setUserId(organization.getUserId());
        
		ServiceContext serviceContextRecord = serviceContext;
		
		

		long groupId = 24402;
		String recordSetKey = null;
		int scope = 0;
		String[] languageid = {"0"};
		String[] names = {"DDL-ADD-PublisherII"};
		String[] description = {"DDL-ADD-Publisher"};
		Map<Locale,String> nameMap = LocalizationUtil.getLocalizationMap(languageid, names);
		Map<Locale,String> descriptionMap = LocalizationUtil.getLocalizationMap(languageid, description);
		
		DDLRecordSet recordSet = DDLRecordSetServiceUtil.addRecordSet(groupId, 14503, recordSetKey, nameMap, 
				descriptionMap, DDLRecordSetConstants.MIN_DISPLAY_ROWS_DEFAULT, scope, serviceContext);
		
		System.out.println("Record set id: " + recordSet.getRecordSetId());
		
		
		System.out.println("DDM Structure ID: " + recordSet.getDDMStructureId());
		System.out.println("Record Set ID: " + recordSet.getRecordSetId());
		DDMStructure ddmStructure = recordSet.getDDMStructure();
		if(ddmStructure != null)
			System.out.println("RDC INFO: ist null");
		else 
			System.out.println("RDC INFO: ist nicht null");
		
		Fields fields2 = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);
		if(fields2 != null)
			System.out.println("RDC fields: ist null");
		else 
			System.out.println("RDC fields: ist nicht null");
		
		//DDLRecordSet recordSet = DDLRecordSetLocalServiceUtil.getRecordSet(52584); 
		
		//long groupId = organization.getGroupId();
		
		Map<String,Serializable> fields = new HashMap<String, Serializable>();
		String displaynames = "";
		fields.put("TextNr1", "auto");
		displaynames += "TextNr1" + "_INSTANCE_abcd"; 
		fields.put("Boolean1659", "");
		displaynames += ",Boolean1659" + "_INSTANCE_cdef";
		fields.put("Text1877", "auto2");
		displaynames += ",Text1877" + "_INSTANCE_aklm";
		fields.put("_fieldsDisplay", displaynames);
		DDLRecord r = DDLRecordServiceUtil.addRecord(groupId, recordSet.getRecordSetId(), DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, serviceContext);
		
		/*Map<String,Serializable> fields = new HashMap<String, Serializable>();
		String displaynames = "";
		fields.put("name", "autoname");
		displaynames += "name" + randomIdGenerator(); 
		fields.put("acronym", "");
		displaynames += "," + "acronym" + randomIdGenerator(); 
		fields.put("Radio2493", "bb");
		displaynames += "," + "Radio2493" + randomIdGenerator(); 
		fields.put("Description", "");
		displaynames += "," + "Description" + randomIdGenerator();
		fields.put("subtype", "");
		displaynames += "," + "subtype" + randomIdGenerator();
		fields.put("legalEntity", "");
		displaynames += "," + "legalEntity" + randomIdGenerator();
		fields.put("countryCode", "austria");
		displaynames += "," + "countryCode" + randomIdGenerator();
		fields.put("geographicAreaCovered", "");
		displaynames += "," + "geographicAreaCovered" + randomIdGenerator();
		fields.put("Text5085", "");
		displaynames += "," + "Text5085" + randomIdGenerator();
		fields.put("year_of_establishment", "");
		displaynames += "," + "year_of_establishment" + randomIdGenerator();
		fields.put("_fieldsDisplay", displaynames);
		DDLRecord r = DDLRecordServiceUtil.addRecord(groupId, recordSet.getRecordSetId(), DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, serviceContext);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
	
	private String randomIdGenerator() {
		String id = "_INSTANCE_";
	    for (int i = 0; i < 4; i++) {
	    	id += alphabet_.charAt(random_.nextInt(N_));
	    }
	    return id;
	}
}
