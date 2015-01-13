package at.rdconnect.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.rdconnect.update.model.AccessibilityUpdate;
import at.rdconnect.update.model.AddressUpdate;
import at.rdconnect.update.model.CoreUpdate;
import at.rdconnect.update.model.QualityUpdate;
import at.rdconnect.update.service.AccessibilityUpdateLocalServiceUtil;
import at.rdconnect.update.service.AddressUpdateLocalServiceUtil;
import at.rdconnect.update.service.CoreUpdateLocalServiceUtil;
import at.rdconnect.update.service.QualityUpdateLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordConstants;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSetConstants;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.portlet.usersadmin.util.UsersAdminUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class UpdateRDConnect
 */
public class UpdateRDConnect extends MVCPortlet {
	
	public void updateRDCAddress(ActionRequest request, ActionResponse response) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		List<AddressUpdate> addressupdatelist = AddressUpdateLocalServiceUtil.getAddressUpdates(-1, -1);
		
		for(AddressUpdate addressupdate : addressupdatelist) {
			if(addressupdate.getOrganizationid() != 0) {
				Organization organization = OrganizationLocalServiceUtil.getOrganization(addressupdate.getOrganizationid());
				
				try {
					List<Address> addresses = new ArrayList<Address>();
					String street1 = addressupdate.getStreet1();
					String street2 = addressupdate.getStreet2();
					String street3 = addressupdate.getStreet3();
					String city = addressupdate.getCity();
					String zip = addressupdate.getZip();
					
					int typeId = (int)addressupdate.getTypeid();
					long regionId = addressupdate.getRegionid();
					long countryId = addressupdate.getContryid();
					boolean mailing = addressupdate.getMailing();
					boolean primary = addressupdate.getPrimary_ad();
					addresses.add(AddressLocalServiceUtil.addAddress(themeDisplay.getUserId(), Organization.class.getName(), organization.getOrganizationId(), street1, street2, street3, city, zip, 
							regionId, countryId, typeId, mailing, primary, new ServiceContext()));
					UsersAdminUtil.updateAddresses(Organization.class.getName(), organization.getOrganizationId(), addresses);
				} catch (PortalException e) {
					System.out.println("RDC Exception MasterPublish::addAddressToOrganisation");
					System.out.println("PortalException");
					e.printStackTrace();
				} catch (SystemException e) {
					System.out.println("RDC Exception MasterPublish::addAddressToOrganisation");
					System.out.println("SystemException");
					e.printStackTrace();
				} catch (Exception e) {
					System.out.println("RDC Exception MasterPublish::addAddressToOrganisation");
					e.printStackTrace();
				}
				
				
			}
		}

		sendRedirect(request, response);
	}
	
	public void updateRDCCore(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 10709);
		System.out.println(themeDisplay.getCompanyId() + " " +  organizations.size());
		for(Organization organization : organizations) {
			System.out.println(organization.getName());
			ServiceContext serviceContext = new ServiceContext();

	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	        Group group = organization.getGroup();
	        serviceContext.setScopeGroupId(group.getGroupId());
	        
	        serviceContext.setUserId(organization.getUserId());
	        
			ServiceContext serviceContextRecord = serviceContext;
			long groupId = organization.getGroupId();
			// create core | ID 28331
			try {
				DDLRecordSet recordSet = null;
				List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(groupId);
			  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
			  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
			  		
			  		if(rdc_rsname.equals("core")) {  		
			  			recordSet = rdc_rs;
			  			List<DDLRecord> ddlrecords = DDLRecordLocalServiceUtil.getRecords(recordSet.getRecordSetId());
			  			for(DDLRecord ddlrecord : ddlrecords) {
			  				DDLRecordLocalServiceUtil.deleteDDLRecord(ddlrecord);
			  			}
			  		}
			  	}
				
				//DDLRecordSet recordSet = createRecordSet(request, organization, "core", 16059, serviceContext);
				// -------
				
				DDMStructure ddmStructure = recordSet.getDDMStructure();		
				Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);
				fields.put(new Field("acronym", ""));
				fields.put(new Field("Additional_Associated_data_available", ""));
				fields.put(new Field("Additional_Biomaterial_available", ""));
				fields.put(new Field("Additional_Biomaterial_prepared", ""));
				fields.put(new Field("Additional_Imaging_available", ""));
				fields.put(new Field("Additional_networks_inventories", ""));
				fields.put(new Field("Additional_Ontologies", ""));
				fields.put(new Field("Additional_Origin_of_collection", ""));
				fields.put(new Field("Additional_Use_of_collection", ""));
				fields.put(new Field("Associated_data_available", "[\"Not specified\"]"));
				fields.put(new Field("Biomaterial_Available", "[\"not specified\"]"));
				fields.put(new Field("Biomaterial_prepared", "[\"not specified\"]"));
				fields.put(new Field("countryCode", ""));
				fields.put(new Field("Hoste_institute", ""));
				fields.put(new Field("Host_institution_is_a", "[\"not specified\"]"));
				fields.put(new Field("How_many_RD_are_in_the_registry_biobank", "[\"not specified\"]"));
				fields.put(new Field("Imaging_available", "[\"not specified\"]"));
				fields.put(new Field("Ontologies", "[\"not specified\"]"));
				fields.put(new Field("Origin_of_collection", "[\"not specified\"]"));
				fields.put(new Field("Percentage_of_rare_diseases_in_your_registry_biobank", ""));
				fields.put(new Field("Target_population_of_the_registry", "[\"not specified\"]"));
				fields.put(new Field("Text5085", ""));
				fields.put(new Field("The_registry_biobanks_is_listed_in_other_inventories_networks", "[\"not specified\"]"));
				fields.put(new Field("Type_of_host_institution", ""));
				fields.put(new Field("Use_of_collection", "[\"not specified\"]"));
				fields.put(new Field("year_of_establishment", ""));
				fields.put(new Field("Description", ""));
				
				List<CoreUpdate> coreupdates = CoreUpdateLocalServiceUtil.getCoreUpdateByOrganization(organization.getOrganizationId());
				for(CoreUpdate coreupdate : coreupdates) {
					if(coreupdate.getFieldname().equalsIgnoreCase("Radio2493")) {
						continue;
					}
					if(!fields.contains(coreupdate.getFieldname())) {
						
						System.out.println("Additional field:" + coreupdate.getFieldname());
						continue;
					}
					if(coreupdate.getValue().equalsIgnoreCase("null") || coreupdate.getValue() == null) {
						coreupdate.setValue("");
					}
					Field tmp_filed = new Field(coreupdate.getFieldname(), coreupdate.getValue());
					fields.put(tmp_filed);
				}
				DDLRecord record = DDLRecordLocalServiceUtil.addRecord(
						serviceContext.getUserId(),
						serviceContext.getScopeGroupId(), recordSet.getRecordSetId(),
						DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
						serviceContext);
			} catch (PortalException e) {
				System.out.println("RDC Exception in MasterPublish:createDDLs");
				System.out.println("Could not create core");
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (SystemException e) {
				System.out.println("RDC Exception in MasterPublish:createDDLs");
				System.out.println("Could not create core");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	private DDLRecordSet createRecordSet(ActionRequest request, Organization organization, String name, long ddmStructureId, ServiceContext serviceContext) throws PortalException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = organization.getGroupId();
		String recordSetKey = null;
		int scope = 0;
		String[] languageid = {"0"};
		String[] names = {name};
		String[] description = {name};
		Map<Locale,String> nameMap = LocalizationUtil.getLocalizationMap(languageid, names);
		Map<Locale,String> descriptionMap = LocalizationUtil.getLocalizationMap(languageid, description);

		DDLRecordSet recordSet = DDLRecordSetLocalServiceUtil.addRecordSet(themeDisplay.getUserId(), groupId, ddmStructureId, recordSetKey, nameMap, 
				descriptionMap, DDLRecordSetConstants.MIN_DISPLAY_ROWS_DEFAULT, scope, serviceContext);
		return recordSet;
	}
	
	public void updateRDCAccessibility(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 10709);
		System.out.println(themeDisplay.getCompanyId() + " " +  organizations.size());
		for(Organization organization : organizations) {
			System.out.println(organization.getName());
			ServiceContext serviceContext = new ServiceContext();

	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	        Group group = organization.getGroup();
	        serviceContext.setScopeGroupId(group.getGroupId());
	        
	        serviceContext.setUserId(organization.getUserId());
	        
			ServiceContext serviceContextRecord = serviceContext;
			long groupId = organization.getGroupId();
			// create core | ID 28331
			try {
				
				DDLRecordSet recordSet = createRecordSet(request, organization, "reg_accessibility", 22594, serviceContext);
				// -------
				
				DDMStructure ddmStructure = recordSet.getDDMStructure();		
				Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);
				fields.put(new Field("Personal_Data_Collected", "[\"not specified\"]"));
				fields.put(new Field("Available_Data", "[\"not specified\"]"));
				fields.put(new Field("Specific_procedure_for_access_to_raw_data", "[\"not specified\"]"));
				fields.put(new Field("Other4838", ""));
				fields.put(new Field("Has_the_registry_a_Data_Access_Committee_", "[\"not specified\"]"));
				fields.put(new Field("If_yes__please_provide_the_Data_Access_Committee_webpage", ""));
				fields.put(new Field("Do_you_use_a_Data_Access_Agreement_", "[\"not specified\"]"));
				fields.put(new Field("Patient_s_data_linked_to_other_resources_", "[\"not specified\"]"));
				fields.put(new Field("Other1", ""));
				fields.put(new Field("Select9246", "[\"not specified\"]"));
				fields.put(new Field("Type_of_consent_is_obtained_from_the_patients", "[\"not specified\"]"));
				fields.put(new Field("Is_an_ethics_board_decision_already_available_for_the_use_of_the_samples_in_research", "[\"not specified\"]"));
				
				
				List<AccessibilityUpdate> coreupdates = AccessibilityUpdateLocalServiceUtil.getAccessibilityUpdateByOrganization(organization.getOrganizationId());
				for(AccessibilityUpdate coreupdate : coreupdates) {
					if(!fields.contains(coreupdate.getFieldname())) {
						System.out.println("Additional field:" + coreupdate.getFieldname());
						continue;
					}
					if(coreupdate.getValue().equalsIgnoreCase("null") || coreupdate.getValue() == null) {
						coreupdate.setValue("");
					}
					Field tmp_filed = new Field(coreupdate.getFieldname(), coreupdate.getValue());
					fields.put(tmp_filed);
				}
				DDLRecord record = DDLRecordLocalServiceUtil.addRecord(
						serviceContext.getUserId(),
						serviceContext.getScopeGroupId(), recordSet.getRecordSetId(),
						DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
						serviceContext);
			} catch (PortalException e) {
				System.out.println("RDC Exception in MasterPublish:createDDLs");
				System.out.println("Could not create core");
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (SystemException e) {
				System.out.println("RDC Exception in MasterPublish:createDDLs");
				System.out.println("Could not create core");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public void updateRDCQuality(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 10709);
		System.out.println(themeDisplay.getCompanyId() + " " +  organizations.size());
		for(Organization organization : organizations) {
			System.out.println(organization.getName());
			ServiceContext serviceContext = new ServiceContext();

	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	        Group group = organization.getGroup();
	        serviceContext.setScopeGroupId(group.getGroupId());
	        
	        serviceContext.setUserId(organization.getUserId());
	        
			ServiceContext serviceContextRecord = serviceContext;
			long groupId = organization.getGroupId();
			// create core | ID 28331
			try {
				
				DDLRecordSet recordSet = createRecordSet(request, organization, "reg_quality", 23725, serviceContext);
				// -------
				
				DDMStructure ddmStructure = recordSet.getDDMStructure();		
				Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);
				fields.put(new Field("Accreditation_certification_program", "[\"not specified\"]"));
				fields.put(new Field("If_yes__specify__ISO_standards___", ""));
				fields.put(new Field("Standardized_case-inclusion_and-exclusion_criteria", "[\"not specified\"]"));
				fields.put(new Field("If_yes__specify", ""));
				fields.put(new Field("Standardized_Operating_Procedures__SOPs__available_for_data_management", "[\"not specified\"]"));
				fields.put(new Field("Quality_control_external_audits", "[\"not specified\"]"));
				fields.put(new Field("If_yes__frequency_of_audits", ""));
				fields.put(new Field("Training_program_for_the_registering_activities", "[\"not specified\"]"));
				
				List<QualityUpdate> coreupdates = QualityUpdateLocalServiceUtil.getQualityUpdateByOrganization(organization.getOrganizationId());
				for(QualityUpdate coreupdate : coreupdates) {
					if(!fields.contains(coreupdate.getFieldname())) {
						System.out.println("Additional field:" + coreupdate.getFieldname());
						continue;
					}
					if(coreupdate.getValue().equalsIgnoreCase("null") || coreupdate.getValue() == null) {
						coreupdate.setValue("");
					}
					Field tmp_filed = new Field(coreupdate.getFieldname(), coreupdate.getValue());
					fields.put(tmp_filed);
				}
				DDLRecord record = DDLRecordLocalServiceUtil.addRecord(
						serviceContext.getUserId(),
						serviceContext.getScopeGroupId(), recordSet.getRecordSetId(),
						DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
						serviceContext);
			} catch (PortalException e) {
				System.out.println("RDC Exception in MasterPublish:createDDLs");
				System.out.println("Could not create core");
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (SystemException e) {
				System.out.println("RDC Exception in MasterPublish:createDDLs");
				System.out.println("Could not create core");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
