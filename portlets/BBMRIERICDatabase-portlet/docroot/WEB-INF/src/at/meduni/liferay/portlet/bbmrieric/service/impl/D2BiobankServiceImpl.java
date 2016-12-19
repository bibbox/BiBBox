/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package at.meduni.liferay.portlet.bbmrieric.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.CountryServiceUtil;

import at.meduni.liferay.portlet.bbmrieric.model.ContactInformation;
import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;
import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork;
import at.meduni.liferay.portlet.bbmrieric.model.D2Collection;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.base.D2BiobankServiceBaseImpl;

/**
 * The implementation of the d2 biobank remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.service.D2BiobankService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author reihsr
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.D2BiobankServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.D2BiobankServiceUtil
 */
public class D2BiobankServiceImpl extends D2BiobankServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.bbmrieric.service.D2BiobankServiceUtil} to access the d2 biobank remote service.
	 */
	
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "eu_bbmri_eric_biobanks")
	public JSONObject getBiobanks() {
		System.out.print("Starting: " );
		JSONObject jsonobject = getMetaData(0);
		jsonobject.put("items", getBiobanksArray(0));
		return jsonobject;
	}
	
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "eu_bbmri_eric_biobanks")
	public JSONObject getNextBiobank(String start) {
		System.out.print("Starting from: " + start );
		int s = Integer.valueOf(start);
		JSONObject jsonobject = getMetaData(s);
		jsonobject.put("items", getBiobanksArray(s));
		return jsonobject;
	}
	
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "eu_bbmri_eric_collections")
	public JSONObject getCollections() {
		JSONObject jsonobject = getMetaDataCollection(0);
		jsonobject.put("items", getCollectionsArray(0));
		return jsonobject;
	}
	
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "eu_bbmri_eric_collections")
	public JSONObject getNextCollections(String start) {
		int s = Integer.valueOf(start);
		JSONObject jsonobject = getMetaDataCollection(s);
		jsonobject.put("items", getCollectionsArray(s));
		return jsonobject;
	}
	
	@JSONWebService(value = "eu_bbmri_eric_biobanks_123")
	public JSONObject getBiobanks1234(String start) {
		int s = Integer.valueOf(start);
		JSONObject jsonobject = getMetaData(s);
		jsonobject.put("items", getBiobanksArray(s));
		return jsonobject;
	}
	
	private JSONObject getMetaData(int start) {
		JSONObject jsonobject = JSONFactoryUtil.createJSONObject();
		jsonobject.put("start", start);
		jsonobject.put("num", 100);
		jsonobject.put("href", "/api/v2/eu_bbmri_eric_biobanks");
		jsonobject.put("nextHref", "http://old.bbrmi-eric.eu/api/v2/eu_bbmri_eric_biobanks?start=" + (start + 100));
		try {
			jsonobject.put("total", D2BiobankLocalServiceUtil.getD2BiobanksCount());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonobject;
	}
	
	private JSONObject getMetaDataCollection(int start) {
		JSONObject jsonobject = JSONFactoryUtil.createJSONObject();
		jsonobject.put("start", start);
		jsonobject.put("num", 100);
		jsonobject.put("href", "/api/v2/eu_bbmri_eric_collections");
		jsonobject.put("nextHref", "http://old.bbrmi-eric.eu/api/v2/eu_bbmri_eric_collections?start=" + (start + 100));
		try {
			jsonobject.put("total", D2BiobankLocalServiceUtil.getD2BiobanksCount());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonobject;
	}
	
	private JSONArray getBiobanksArray(int start) {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		try {
			List<D2Biobank> d2biobanks = D2BiobankLocalServiceUtil.getD2Biobanks(start, start+100);
			for(D2Biobank d2biobank : d2biobanks) {
				JSONObject biobankobject = JSONFactoryUtil.createJSONObject();
				biobankobject.put("_href", "http://old.bbrmi-eric.eu/api/v2/eu_bbmri_eric_biobanks/" + d2biobank.getBbmribiobankID());
				biobankobject.put("id", d2biobank.getBbmribiobankID());
				biobankobject.put("name", d2biobank.getBiobankName());
				biobankobject.put("acronym", d2biobank.getBiobankAcronym());
				biobankobject.put("description", d2biobank.getBiobankDescription());
				biobankobject.put("url", d2biobank.getBiobankURL());
				biobankobject.put("juridical_person", d2biobank.getBiobankJurisdicalPerson());
				try {
					biobankobject.put("country", getCountry(d2biobank.getBiobankCountry(), CountryServiceUtil.getCountryByA2(d2biobank.getBiobankCountry()).getName()));
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				biobankobject.put("it_support_available", d2biobank.getBiobankITSupportAvailable());
				biobankobject.put("it_staff_size", d2biobank.getBiobankITStaffSize());
				biobankobject.put("is_available", d2biobank.getBiobankISAvailable());
				biobankobject.put("his_available", d2biobank.getBiobankHISAvailable());
				biobankobject.put("partner_charter_signed", d2biobank.getBiobankPartnerCharterSigned());
				biobankobject.put("head_firstname", d2biobank.getBiobankHeadFirstName());
				biobankobject.put("head_lastname", d2biobank.getBiobankHeadLastName());
				biobankobject.put("head_role", d2biobank.getBiobankHeadRole());
				biobankobject.put("contact", getContact(d2biobank.getContactInformation()));
				biobankobject.put("contact_priority", d2biobank.getContactPriority());
				biobankobject.put("latitude", d2biobank.getGeoLatitude());
				biobankobject.put("longitude", d2biobank.getGeoLongitude());
				biobankobject.put("collaboration_commercial", d2biobank.getCollaborationPartnersCommercial());
				biobankobject.put("collaboration_non_for_profit", d2biobank.getCollaborationPartnersNonforprofit());
				biobankobject.put("network", getNetworks(d2biobank.getNetworksWhereBiobankIsMember()));
				jsonarray.put(biobankobject);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray;
	}
	
	private JSONObject getCountry(String id, String name) {
		JSONObject jsonobject = JSONFactoryUtil.createJSONObject();
		jsonobject.put("_href", "/api/v2/eu_bbmri_eric_countries/" + id);
		jsonobject.put("id", id);
		jsonobject.put("name", name);
		return jsonobject;
	}
	
	private JSONArray getContact(ContactInformation contactinformation) {
		JSONObject jsonobject = JSONFactoryUtil.createJSONObject();
		jsonobject.put("_href", "/api/v2/eu_bbmri_eric_persons/" + contactinformation.getContactID());
		jsonobject.put("id", contactinformation.getContactID());
		jsonobject.put("name", contactinformation.getContactEmail());
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		jsonarray.put(jsonobject);
		return jsonarray;
	}
	
	private JSONArray getNetworks(List<D2BiobankNetwork> networks) {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		for(D2BiobankNetwork network : networks) {
			JSONObject jsonobject = JSONFactoryUtil.createJSONObject();
			jsonobject.put("_href", "/api/v2/eu_bbmri_eric_networks/" + network.getBbmriBiobankNetworkID());
			jsonobject.put("id", network.getBbmriBiobankNetworkID());
			jsonarray.put(jsonobject);
		}
		return jsonarray;
	}

	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "eu_bbmri_eric_biobank")
	public JSONObject getBiobank(String biobankId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private JSONArray getCollectionsArray(int start) {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		try {
			List<D2Collection> d2collections = D2CollectionLocalServiceUtil.getD2Collections(start, start+100);
			for(D2Collection d2collection : d2collections) {
				JSONObject collectionobject = JSONFactoryUtil.createJSONObject();
				collectionobject.put("_href", "/api/v2/eu_bbmri_eric_collections/" + d2collection.getBbmricollectionID());
				collectionobject.put("id", d2collection.getBbmricollectionID());
				collectionobject.put("name", d2collection.getCollectionName());
				collectionobject.put("biobank", getBiobankObject(d2collection.getBbmribiobankID()));
				collectionobject.put("network", getNetworks(d2collection.getNetworksWhereCollectionIsMember()));
				collectionobject.put("type", getTypeArray(d2collection));
				collectionobject.put("data_categories", getDataCategoriesArray(d2collection));
				JSONObject order_of_magnitude = JSONFactoryUtil.createJSONObject();
				order_of_magnitude.put("_href", "/api/v2/eu_bbmri_eric_biobank_size/" + d2collection.getCollectionOrderOfMagnitude());
				order_of_magnitude.put("id", d2collection.getCollectionOrderOfMagnitude());
				collectionobject.put("order_of_magnitude", order_of_magnitude);
				collectionobject.put("size", d2collection.getCollectionSize());
				collectionobject.put("contact", getContact(d2collection.getContactInformation()));
				collectionobject.put("contact_priority", d2collection.getContactPriority());
				collectionobject.put("sex", getSexArray(d2collection));
				collectionobject.put("diagnosis_available", getDiagnosisAvailableArray(d2collection));
				collectionobject.put("age_unit", getAgeUnitArray(d2collection));
				collectionobject.put("body_part_examined", JSONFactoryUtil.createJSONArray());
				collectionobject.put("imaging_modality", JSONFactoryUtil.createJSONArray());
				collectionobject.put("image_dataset_type", JSONFactoryUtil.createJSONArray());
				collectionobject.put("materials", getMaterialsArray(d2collection));
				collectionobject.put("storage_temperatures", getStorageTemperaturesArray(d2collection));
				collectionobject.put("sample_access_fee", d2collection.getCollectionSampleAccessFee());
				collectionobject.put("sample_access_joint_project", d2collection.getCollectionSampleAccessJointProjects());
				collectionobject.put("sample_access_description", d2collection.getCollectionSampleAccessDescription());
				collectionobject.put("sample_access_uri", d2collection.getCollectionSampleAccessURI());
				collectionobject.put("data_access_fee", d2collection.getCollectionDataAccessFee());
				collectionobject.put("data_access_joint_project", d2collection.getCollectionDataAccessJointProjects());
				collectionobject.put("data_access_description", d2collection.getCollectionDataAccessDescription());
				collectionobject.put("data_access_uri", d2collection.getCollectionDataAccessURI());
				collectionobject.put("collaboration_commercial", d2collection.getCollaborationPartnersCommercial());
				collectionobject.put("collaboration_non_for_profit", d2collection.getCollaborationPartnersNonforprofit());
				
				jsonarray.put(collectionobject);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray;
	}
	
	private JSONObject getBiobankObject(String bbmribiobankID) {
		D2Biobank d2biobank = D2BiobankLocalServiceUtil.getD2BiobankByBBMRIERICID(bbmribiobankID);
		JSONObject biobankobject = JSONFactoryUtil.createJSONObject();
		biobankobject.put("_href", "http://old.bbrmi-eric.eu/api/v2/eu_bbmri_eric_biobanks/" + d2biobank.getBbmribiobankID());
		biobankobject.put("id", d2biobank.getBbmribiobankID());
		biobankobject.put("name", d2biobank.getBiobankName());
		return biobankobject;
	}
	
	private JSONArray getTypeArray(D2Collection d2collection) {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		if(d2collection.getCollectionTypeBirthCohort()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_collection_types/", "BIRTH_COHORT", "Birth cohort"));
		}
		if(d2collection.getCollectionTypeCaseControl()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_collection_types/", "CASE_CONTROL", "Case-Control"));
		}
		if(d2collection.getCollectionTypeCohort()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_collection_types/", "COHORT", "Cohort"));
		}
		if(d2collection.getCollectionTypeCrossSectional()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_collection_types/", "CROSS_SECTIONAL", "Cross-sectional"));
		}
		if(d2collection.getCollectionTypeDiseaseSpecific()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_collection_types/", "DISEASE_SPECIFIC", "Disease specific"));
		}
		if(d2collection.getCollectionTypeLongitudinal()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_collection_types/", "LONGITUDINAL", "Longitudinal"));
		}
		if(d2collection.getCollectionTypePopulationBased()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_collection_types/", "POPULATION_BASED", "Population-based"));
		}
		if(d2collection.getCollectionTypeQualityControl()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_collection_types/", "QUALITY_CONTROL", "Qualtiy control"));
		}
		if(d2collection.getCollectionTypeTwinStudy()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_collection_types/", "TWIN_STUDY", "Twin-study"));
		}
		if(d2collection.getCollectionTypeOther().equalsIgnoreCase("TRUE")) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_collection_types/", "OTHER", "Other"));
		}
		return jsonarray;
	}
	
	private JSONObject getJSONOObject(String url, String id, String label) {
		JSONObject jsonobject = JSONFactoryUtil.createJSONObject();
		jsonobject.put("_href", url + id);
		jsonobject.put("id", id);
		jsonobject.put("label", label);
		return jsonobject;
	}
	
	private JSONArray getDataCategoriesArray(D2Collection d2collection) {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		if(d2collection.getCollectionAvailableBiologicalSamples()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_data_types/", "BIOLOGICAL_SAMPLES", "Biological samples"));
		}
		if(d2collection.getCollectionAvailableGenealogicalRecords()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_data_types/", "GENEALOGICAL_RECORDS", "Genealogical records"));
		}
		if(d2collection.getCollectionAvailableImagingData()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_data_types/", "IMAGING_DATA", "Imaging data"));
		}
		if(d2collection.getCollectionAvailableMedicalRecords()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_data_types/", "MEDICAL_RECORDS", "Medical records"));
		}
		if(d2collection.getCollectionAvailableNationalRegistries()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_data_types/", "NATIONAL_REGISTRIES", "National registries"));
		}
		if(d2collection.getCollectionAvailablePhysioBiochemMeasurements()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_data_types/", "PHYSIOLOGICAL_BIOCHEMICAL_MEASUREMENTS", "Physiological/Biochemical measurements"));
		}
		if(d2collection.getCollectionAvailableSurveyData()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_data_types/", "SURVEY_DATA", "Survey data"));
		}
		if(d2collection.getCollectionAvailableOther().equalsIgnoreCase("TRUE")) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_data_types/", "OTHER", "Other"));
		}
		return jsonarray;
	}
	
	private JSONArray getSexArray(D2Collection d2collection) {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		if(d2collection.getCollectionSexMale()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_sex_types", "MALE", "Male"));
		}
		if(d2collection.getCollectionSexFemale()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_sex_types", "FEMALE", "Female"));
		}
		if(d2collection.getCollectionSexUndiferrentiated()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_sex_types", "UNDIFFERENTIAL", "Undifferentiated"));
		}
		if(d2collection.getCollectionSexUnknown()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_sex_types", "UNKNOWN", "Unknown"));
		}
		return jsonarray;
	}
	
	private JSONArray getDiagnosisAvailableArray(D2Collection d2collection) {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		for(String diagnosis : d2collection.getDiagnosisAvailable().split(",")) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_disease_types/", diagnosis.trim(), diagnosis.trim()));
		}
		return jsonarray;
	}
	
	private JSONArray getAgeUnitArray(D2Collection d2collection) {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		if(d2collection.getCollectionAgeUnit().equalsIgnoreCase("year") || d2collection.getCollectionAgeUnit().equalsIgnoreCase("years")) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_age_units/", "YEAR", "Year"));
		}
		if(d2collection.getCollectionAgeUnit().equalsIgnoreCase("days") || d2collection.getCollectionAgeUnit().equalsIgnoreCase("day")) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_age_units/", "DAY", "Day"));
		}
		if(d2collection.getCollectionAgeUnit().equalsIgnoreCase("week") || d2collection.getCollectionAgeUnit().equalsIgnoreCase("weeks")) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_age_units/", "WEEK", "Week"));
		}
		if(d2collection.getCollectionAgeUnit().equalsIgnoreCase("month") || d2collection.getCollectionAgeUnit().equalsIgnoreCase("months")) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_age_units/", "MONTH", "Month"));
		}
		return jsonarray;
	}
	
	private JSONArray getMaterialsArray(D2Collection d2collection) {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		if(d2collection.getMaterialStoredBlood()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "WHOLE_BLOOD", "Whole Blood"));
		}
		if(d2collection.getMaterialStoredDNA()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "DNA", "DNA"));
		}
		if(d2collection.getMaterialStoredFaeces()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "FECES", "Feaces"));
		}
		if(d2collection.getMaterialStoredImmortalizedCellLines()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "CELL_LINES", "Cell lines"));
		}
		if(d2collection.getMaterialStoredIsolatedPathogen()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "PATHOGEN", "Pathogen"));
		}
		if(d2collection.getMaterialStoredPlasma()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "PLASMA", "Plasma"));
		}
		if(d2collection.getMaterialStoredRNA()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "MICRO_RNA", "microRNA"));
		}
		if(d2collection.getMaterialStoredSaliva()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "SALIVA", "Saliva"));
		}
		if(d2collection.getMaterialStoredSerum()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "SERUM", "Serum"));
		}
		if(d2collection.getMaterialStoredTissueFFPE()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "TISSUE_PARAFFIN_EMBEDDED", "Tissue, paraffin preserved"));
		}
		if(d2collection.getMaterialStoredTissueFrozen()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "TISSUE_FROZEN", "Tissue, cryo preserved"));
		}
		if(d2collection.getMaterialStoredUrine()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "URINE", "Urine"));
		}
		if(d2collection.getMaterialStoredOther().equalsIgnoreCase("TRUE")) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_material_types/", "OTHER", "Other"));
		}
		return jsonarray;
	}
	
	private JSONArray getStorageTemperaturesArray(D2Collection d2collection) {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		if(d2collection.getTemperature18to35()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_temp_types/", "temperature-18to-35", "-18ºC to -35ºC"));
		}
		if(d2collection.getTemperature2to10()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_temp_types/", "temperature2to10", "2ºC to 10ºC"));
		}
		if(d2collection.getTemperature60to85()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_temp_types/", "temperature-60to-85", "-60ºC to -80ºC"));
		}
		if(d2collection.getTemperatureLN()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_temp_types/", "temperatureLN", "Liquid Nitrogen"));
		}
		if(d2collection.getTemperatureRoom()) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_temp_types/", "temperatureRoom", "Room temperature"));
		}
		if(d2collection.getTemperatureOther().equalsIgnoreCase("TRUE")) {
			jsonarray.put(getJSONOObject("/api/v2/eu_bbmri_eric_temp_types/", "temperatureOther", "Other"));
		}
		return jsonarray;
	}
}