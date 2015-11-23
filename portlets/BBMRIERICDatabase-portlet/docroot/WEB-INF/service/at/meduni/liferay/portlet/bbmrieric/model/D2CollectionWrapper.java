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

package at.meduni.liferay.portlet.bbmrieric.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link D2Collection}.
 * </p>
 *
 * @author reihsr
 * @see D2Collection
 * @generated
 */
public class D2CollectionWrapper implements D2Collection,
	ModelWrapper<D2Collection> {
	public D2CollectionWrapper(D2Collection d2Collection) {
		_d2Collection = d2Collection;
	}

	@Override
	public Class<?> getModelClass() {
		return D2Collection.class;
	}

	@Override
	public String getModelClassName() {
		return D2Collection.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("d2collectionId", getD2collectionId());
		attributes.put("biobankId", getBiobankId());
		attributes.put("parentd2collectionId", getParentd2collectionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("updateuuid", getUpdateuuid());
		attributes.put("bbmricollectionID", getBbmricollectionID());
		attributes.put("bbmriparentcollectionID", getBbmriparentcollectionID());
		attributes.put("bbmribiobankID", getBbmribiobankID());
		attributes.put("collectionName", getCollectionName());
		attributes.put("materialStoredDNA", getMaterialStoredDNA());
		attributes.put("materialStoredPlasma", getMaterialStoredPlasma());
		attributes.put("materialStoredSerum", getMaterialStoredSerum());
		attributes.put("materialStoredUrine", getMaterialStoredUrine());
		attributes.put("materialStoredSaliva", getMaterialStoredSaliva());
		attributes.put("materialStoredFaeces", getMaterialStoredFaeces());
		attributes.put("materialStoredRNA", getMaterialStoredRNA());
		attributes.put("materialStoredBlood", getMaterialStoredBlood());
		attributes.put("materialStoredTissueFrozen",
			getMaterialStoredTissueFrozen());
		attributes.put("materialStoredTissueFFPE", getMaterialStoredTissueFFPE());
		attributes.put("materialStoredImmortalizedCellLines",
			getMaterialStoredImmortalizedCellLines());
		attributes.put("materialStoredIsolatedPathogen",
			getMaterialStoredIsolatedPathogen());
		attributes.put("materialStoredOther", getMaterialStoredOther());
		attributes.put("collectionTypeCaseControl",
			getCollectionTypeCaseControl());
		attributes.put("collectionTypeCohort", getCollectionTypeCohort());
		attributes.put("collectionTypeCrossSectional",
			getCollectionTypeCrossSectional());
		attributes.put("collectionTypeLongitudinal",
			getCollectionTypeLongitudinal());
		attributes.put("collectionTypeTwinStudy", getCollectionTypeTwinStudy());
		attributes.put("collectionTypeQualityControl",
			getCollectionTypeQualityControl());
		attributes.put("collectionTypePopulationBased",
			getCollectionTypePopulationBased());
		attributes.put("collectionTypeDiseaseSpecific",
			getCollectionTypeDiseaseSpecific());
		attributes.put("collectionTypeBirthCohort",
			getCollectionTypeBirthCohort());
		attributes.put("collectionTypeOther", getCollectionTypeOther());
		attributes.put("collectionOrderOfMagnitude",
			getCollectionOrderOfMagnitude());
		attributes.put("bioresourceReference", getBioresourceReference());
		attributes.put("contactIDRef", getContactIDRef());
		attributes.put("contactPriority", getContactPriority());
		attributes.put("biobankNetworkIDRef", getBiobankNetworkIDRef());
		attributes.put("geoLatitude", getGeoLatitude());
		attributes.put("geoLongitude", getGeoLongitude());
		attributes.put("collaborationPartnersCommercial",
			getCollaborationPartnersCommercial());
		attributes.put("collaborationPartnersNonforprofit",
			getCollaborationPartnersNonforprofit());
		attributes.put("collectionAcronym", getCollectionAcronym());
		attributes.put("collectionDescription", getCollectionDescription());
		attributes.put("collectionSexMale", getCollectionSexMale());
		attributes.put("collectionSexFemale", getCollectionSexFemale());
		attributes.put("collectionSexUnknown", getCollectionSexUnknown());
		attributes.put("collectionSexUndiferrentiated",
			getCollectionSexUndiferrentiated());
		attributes.put("collectionAgeLow", getCollectionAgeLow());
		attributes.put("collectionAgeHigh", getCollectionAgeHigh());
		attributes.put("collectionAgeUnit", getCollectionAgeUnit());
		attributes.put("collectionAvailableBiologicalSamples",
			getCollectionAvailableBiologicalSamples());
		attributes.put("collectionAvailableSurveyData",
			getCollectionAvailableSurveyData());
		attributes.put("collectionAvailableImagingData",
			getCollectionAvailableImagingData());
		attributes.put("collectionAvailableMedicalRecords",
			getCollectionAvailableMedicalRecords());
		attributes.put("collectionAvailableNationalRegistries",
			getCollectionAvailableNationalRegistries());
		attributes.put("collectionAvailableGenealogicalRecords",
			getCollectionAvailableGenealogicalRecords());
		attributes.put("collectionAvailablePhysioBiochemMeasurements",
			getCollectionAvailablePhysioBiochemMeasurements());
		attributes.put("collectionAvailableOther", getCollectionAvailableOther());
		attributes.put("temperatureRoom", getTemperatureRoom());
		attributes.put("temperature2to10", getTemperature2to10());
		attributes.put("temperature18to35", getTemperature18to35());
		attributes.put("temperature60to85", getTemperature60to85());
		attributes.put("temperatureLN", getTemperatureLN());
		attributes.put("temperatureOther", getTemperatureOther());
		attributes.put("diagnosisAvailable", getDiagnosisAvailable());
		attributes.put("collectionHeadFirstName", getCollectionHeadFirstName());
		attributes.put("collectionHeadLastName", getCollectionHeadLastName());
		attributes.put("collectionHeadRole", getCollectionHeadRole());
		attributes.put("collectionSampleAccessFee",
			getCollectionSampleAccessFee());
		attributes.put("collectionSampleAccessJointProjects",
			getCollectionSampleAccessJointProjects());
		attributes.put("collectionSampleAccessDescription",
			getCollectionSampleAccessDescription());
		attributes.put("collectionSampleAccessURI",
			getCollectionSampleAccessURI());
		attributes.put("collectionDataAccessFee", getCollectionDataAccessFee());
		attributes.put("collectionDataAccessJointProjects",
			getCollectionDataAccessJointProjects());
		attributes.put("collectionDataAccessDescription",
			getCollectionDataAccessDescription());
		attributes.put("collectionDataAccessURI", getCollectionDataAccessURI());
		attributes.put("collectionSize", getCollectionSize());
		attributes.put("collectionSizeTimestamp", getCollectionSizeTimestamp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long d2collectionId = (Long)attributes.get("d2collectionId");

		if (d2collectionId != null) {
			setD2collectionId(d2collectionId);
		}

		Long biobankId = (Long)attributes.get("biobankId");

		if (biobankId != null) {
			setBiobankId(biobankId);
		}

		Long parentd2collectionId = (Long)attributes.get("parentd2collectionId");

		if (parentd2collectionId != null) {
			setParentd2collectionId(parentd2collectionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String updateuuid = (String)attributes.get("updateuuid");

		if (updateuuid != null) {
			setUpdateuuid(updateuuid);
		}

		String bbmricollectionID = (String)attributes.get("bbmricollectionID");

		if (bbmricollectionID != null) {
			setBbmricollectionID(bbmricollectionID);
		}

		String bbmriparentcollectionID = (String)attributes.get(
				"bbmriparentcollectionID");

		if (bbmriparentcollectionID != null) {
			setBbmriparentcollectionID(bbmriparentcollectionID);
		}

		String bbmribiobankID = (String)attributes.get("bbmribiobankID");

		if (bbmribiobankID != null) {
			setBbmribiobankID(bbmribiobankID);
		}

		String collectionName = (String)attributes.get("collectionName");

		if (collectionName != null) {
			setCollectionName(collectionName);
		}

		Boolean materialStoredDNA = (Boolean)attributes.get("materialStoredDNA");

		if (materialStoredDNA != null) {
			setMaterialStoredDNA(materialStoredDNA);
		}

		Boolean materialStoredPlasma = (Boolean)attributes.get(
				"materialStoredPlasma");

		if (materialStoredPlasma != null) {
			setMaterialStoredPlasma(materialStoredPlasma);
		}

		Boolean materialStoredSerum = (Boolean)attributes.get(
				"materialStoredSerum");

		if (materialStoredSerum != null) {
			setMaterialStoredSerum(materialStoredSerum);
		}

		Boolean materialStoredUrine = (Boolean)attributes.get(
				"materialStoredUrine");

		if (materialStoredUrine != null) {
			setMaterialStoredUrine(materialStoredUrine);
		}

		Boolean materialStoredSaliva = (Boolean)attributes.get(
				"materialStoredSaliva");

		if (materialStoredSaliva != null) {
			setMaterialStoredSaliva(materialStoredSaliva);
		}

		Boolean materialStoredFaeces = (Boolean)attributes.get(
				"materialStoredFaeces");

		if (materialStoredFaeces != null) {
			setMaterialStoredFaeces(materialStoredFaeces);
		}

		Boolean materialStoredRNA = (Boolean)attributes.get("materialStoredRNA");

		if (materialStoredRNA != null) {
			setMaterialStoredRNA(materialStoredRNA);
		}

		Boolean materialStoredBlood = (Boolean)attributes.get(
				"materialStoredBlood");

		if (materialStoredBlood != null) {
			setMaterialStoredBlood(materialStoredBlood);
		}

		Boolean materialStoredTissueFrozen = (Boolean)attributes.get(
				"materialStoredTissueFrozen");

		if (materialStoredTissueFrozen != null) {
			setMaterialStoredTissueFrozen(materialStoredTissueFrozen);
		}

		Boolean materialStoredTissueFFPE = (Boolean)attributes.get(
				"materialStoredTissueFFPE");

		if (materialStoredTissueFFPE != null) {
			setMaterialStoredTissueFFPE(materialStoredTissueFFPE);
		}

		Boolean materialStoredImmortalizedCellLines = (Boolean)attributes.get(
				"materialStoredImmortalizedCellLines");

		if (materialStoredImmortalizedCellLines != null) {
			setMaterialStoredImmortalizedCellLines(materialStoredImmortalizedCellLines);
		}

		Boolean materialStoredIsolatedPathogen = (Boolean)attributes.get(
				"materialStoredIsolatedPathogen");

		if (materialStoredIsolatedPathogen != null) {
			setMaterialStoredIsolatedPathogen(materialStoredIsolatedPathogen);
		}

		String materialStoredOther = (String)attributes.get(
				"materialStoredOther");

		if (materialStoredOther != null) {
			setMaterialStoredOther(materialStoredOther);
		}

		Boolean collectionTypeCaseControl = (Boolean)attributes.get(
				"collectionTypeCaseControl");

		if (collectionTypeCaseControl != null) {
			setCollectionTypeCaseControl(collectionTypeCaseControl);
		}

		Boolean collectionTypeCohort = (Boolean)attributes.get(
				"collectionTypeCohort");

		if (collectionTypeCohort != null) {
			setCollectionTypeCohort(collectionTypeCohort);
		}

		Boolean collectionTypeCrossSectional = (Boolean)attributes.get(
				"collectionTypeCrossSectional");

		if (collectionTypeCrossSectional != null) {
			setCollectionTypeCrossSectional(collectionTypeCrossSectional);
		}

		Boolean collectionTypeLongitudinal = (Boolean)attributes.get(
				"collectionTypeLongitudinal");

		if (collectionTypeLongitudinal != null) {
			setCollectionTypeLongitudinal(collectionTypeLongitudinal);
		}

		Boolean collectionTypeTwinStudy = (Boolean)attributes.get(
				"collectionTypeTwinStudy");

		if (collectionTypeTwinStudy != null) {
			setCollectionTypeTwinStudy(collectionTypeTwinStudy);
		}

		Boolean collectionTypeQualityControl = (Boolean)attributes.get(
				"collectionTypeQualityControl");

		if (collectionTypeQualityControl != null) {
			setCollectionTypeQualityControl(collectionTypeQualityControl);
		}

		Boolean collectionTypePopulationBased = (Boolean)attributes.get(
				"collectionTypePopulationBased");

		if (collectionTypePopulationBased != null) {
			setCollectionTypePopulationBased(collectionTypePopulationBased);
		}

		Boolean collectionTypeDiseaseSpecific = (Boolean)attributes.get(
				"collectionTypeDiseaseSpecific");

		if (collectionTypeDiseaseSpecific != null) {
			setCollectionTypeDiseaseSpecific(collectionTypeDiseaseSpecific);
		}

		Boolean collectionTypeBirthCohort = (Boolean)attributes.get(
				"collectionTypeBirthCohort");

		if (collectionTypeBirthCohort != null) {
			setCollectionTypeBirthCohort(collectionTypeBirthCohort);
		}

		String collectionTypeOther = (String)attributes.get(
				"collectionTypeOther");

		if (collectionTypeOther != null) {
			setCollectionTypeOther(collectionTypeOther);
		}

		Long collectionOrderOfMagnitude = (Long)attributes.get(
				"collectionOrderOfMagnitude");

		if (collectionOrderOfMagnitude != null) {
			setCollectionOrderOfMagnitude(collectionOrderOfMagnitude);
		}

		String bioresourceReference = (String)attributes.get(
				"bioresourceReference");

		if (bioresourceReference != null) {
			setBioresourceReference(bioresourceReference);
		}

		String contactIDRef = (String)attributes.get("contactIDRef");

		if (contactIDRef != null) {
			setContactIDRef(contactIDRef);
		}

		Long contactPriority = (Long)attributes.get("contactPriority");

		if (contactPriority != null) {
			setContactPriority(contactPriority);
		}

		String biobankNetworkIDRef = (String)attributes.get(
				"biobankNetworkIDRef");

		if (biobankNetworkIDRef != null) {
			setBiobankNetworkIDRef(biobankNetworkIDRef);
		}

		String geoLatitude = (String)attributes.get("geoLatitude");

		if (geoLatitude != null) {
			setGeoLatitude(geoLatitude);
		}

		String geoLongitude = (String)attributes.get("geoLongitude");

		if (geoLongitude != null) {
			setGeoLongitude(geoLongitude);
		}

		Boolean collaborationPartnersCommercial = (Boolean)attributes.get(
				"collaborationPartnersCommercial");

		if (collaborationPartnersCommercial != null) {
			setCollaborationPartnersCommercial(collaborationPartnersCommercial);
		}

		Boolean collaborationPartnersNonforprofit = (Boolean)attributes.get(
				"collaborationPartnersNonforprofit");

		if (collaborationPartnersNonforprofit != null) {
			setCollaborationPartnersNonforprofit(collaborationPartnersNonforprofit);
		}

		String collectionAcronym = (String)attributes.get("collectionAcronym");

		if (collectionAcronym != null) {
			setCollectionAcronym(collectionAcronym);
		}

		String collectionDescription = (String)attributes.get(
				"collectionDescription");

		if (collectionDescription != null) {
			setCollectionDescription(collectionDescription);
		}

		Boolean collectionSexMale = (Boolean)attributes.get("collectionSexMale");

		if (collectionSexMale != null) {
			setCollectionSexMale(collectionSexMale);
		}

		Boolean collectionSexFemale = (Boolean)attributes.get(
				"collectionSexFemale");

		if (collectionSexFemale != null) {
			setCollectionSexFemale(collectionSexFemale);
		}

		Boolean collectionSexUnknown = (Boolean)attributes.get(
				"collectionSexUnknown");

		if (collectionSexUnknown != null) {
			setCollectionSexUnknown(collectionSexUnknown);
		}

		Boolean collectionSexUndiferrentiated = (Boolean)attributes.get(
				"collectionSexUndiferrentiated");

		if (collectionSexUndiferrentiated != null) {
			setCollectionSexUndiferrentiated(collectionSexUndiferrentiated);
		}

		Long collectionAgeLow = (Long)attributes.get("collectionAgeLow");

		if (collectionAgeLow != null) {
			setCollectionAgeLow(collectionAgeLow);
		}

		Long collectionAgeHigh = (Long)attributes.get("collectionAgeHigh");

		if (collectionAgeHigh != null) {
			setCollectionAgeHigh(collectionAgeHigh);
		}

		String collectionAgeUnit = (String)attributes.get("collectionAgeUnit");

		if (collectionAgeUnit != null) {
			setCollectionAgeUnit(collectionAgeUnit);
		}

		Boolean collectionAvailableBiologicalSamples = (Boolean)attributes.get(
				"collectionAvailableBiologicalSamples");

		if (collectionAvailableBiologicalSamples != null) {
			setCollectionAvailableBiologicalSamples(collectionAvailableBiologicalSamples);
		}

		Boolean collectionAvailableSurveyData = (Boolean)attributes.get(
				"collectionAvailableSurveyData");

		if (collectionAvailableSurveyData != null) {
			setCollectionAvailableSurveyData(collectionAvailableSurveyData);
		}

		Boolean collectionAvailableImagingData = (Boolean)attributes.get(
				"collectionAvailableImagingData");

		if (collectionAvailableImagingData != null) {
			setCollectionAvailableImagingData(collectionAvailableImagingData);
		}

		Boolean collectionAvailableMedicalRecords = (Boolean)attributes.get(
				"collectionAvailableMedicalRecords");

		if (collectionAvailableMedicalRecords != null) {
			setCollectionAvailableMedicalRecords(collectionAvailableMedicalRecords);
		}

		Boolean collectionAvailableNationalRegistries = (Boolean)attributes.get(
				"collectionAvailableNationalRegistries");

		if (collectionAvailableNationalRegistries != null) {
			setCollectionAvailableNationalRegistries(collectionAvailableNationalRegistries);
		}

		Boolean collectionAvailableGenealogicalRecords = (Boolean)attributes.get(
				"collectionAvailableGenealogicalRecords");

		if (collectionAvailableGenealogicalRecords != null) {
			setCollectionAvailableGenealogicalRecords(collectionAvailableGenealogicalRecords);
		}

		Boolean collectionAvailablePhysioBiochemMeasurements = (Boolean)attributes.get(
				"collectionAvailablePhysioBiochemMeasurements");

		if (collectionAvailablePhysioBiochemMeasurements != null) {
			setCollectionAvailablePhysioBiochemMeasurements(collectionAvailablePhysioBiochemMeasurements);
		}

		String collectionAvailableOther = (String)attributes.get(
				"collectionAvailableOther");

		if (collectionAvailableOther != null) {
			setCollectionAvailableOther(collectionAvailableOther);
		}

		Boolean temperatureRoom = (Boolean)attributes.get("temperatureRoom");

		if (temperatureRoom != null) {
			setTemperatureRoom(temperatureRoom);
		}

		Boolean temperature2to10 = (Boolean)attributes.get("temperature2to10");

		if (temperature2to10 != null) {
			setTemperature2to10(temperature2to10);
		}

		Boolean temperature18to35 = (Boolean)attributes.get("temperature18to35");

		if (temperature18to35 != null) {
			setTemperature18to35(temperature18to35);
		}

		Boolean temperature60to85 = (Boolean)attributes.get("temperature60to85");

		if (temperature60to85 != null) {
			setTemperature60to85(temperature60to85);
		}

		Boolean temperatureLN = (Boolean)attributes.get("temperatureLN");

		if (temperatureLN != null) {
			setTemperatureLN(temperatureLN);
		}

		String temperatureOther = (String)attributes.get("temperatureOther");

		if (temperatureOther != null) {
			setTemperatureOther(temperatureOther);
		}

		String diagnosisAvailable = (String)attributes.get("diagnosisAvailable");

		if (diagnosisAvailable != null) {
			setDiagnosisAvailable(diagnosisAvailable);
		}

		String collectionHeadFirstName = (String)attributes.get(
				"collectionHeadFirstName");

		if (collectionHeadFirstName != null) {
			setCollectionHeadFirstName(collectionHeadFirstName);
		}

		String collectionHeadLastName = (String)attributes.get(
				"collectionHeadLastName");

		if (collectionHeadLastName != null) {
			setCollectionHeadLastName(collectionHeadLastName);
		}

		String collectionHeadRole = (String)attributes.get("collectionHeadRole");

		if (collectionHeadRole != null) {
			setCollectionHeadRole(collectionHeadRole);
		}

		Boolean collectionSampleAccessFee = (Boolean)attributes.get(
				"collectionSampleAccessFee");

		if (collectionSampleAccessFee != null) {
			setCollectionSampleAccessFee(collectionSampleAccessFee);
		}

		Boolean collectionSampleAccessJointProjects = (Boolean)attributes.get(
				"collectionSampleAccessJointProjects");

		if (collectionSampleAccessJointProjects != null) {
			setCollectionSampleAccessJointProjects(collectionSampleAccessJointProjects);
		}

		String collectionSampleAccessDescription = (String)attributes.get(
				"collectionSampleAccessDescription");

		if (collectionSampleAccessDescription != null) {
			setCollectionSampleAccessDescription(collectionSampleAccessDescription);
		}

		String collectionSampleAccessURI = (String)attributes.get(
				"collectionSampleAccessURI");

		if (collectionSampleAccessURI != null) {
			setCollectionSampleAccessURI(collectionSampleAccessURI);
		}

		Boolean collectionDataAccessFee = (Boolean)attributes.get(
				"collectionDataAccessFee");

		if (collectionDataAccessFee != null) {
			setCollectionDataAccessFee(collectionDataAccessFee);
		}

		Boolean collectionDataAccessJointProjects = (Boolean)attributes.get(
				"collectionDataAccessJointProjects");

		if (collectionDataAccessJointProjects != null) {
			setCollectionDataAccessJointProjects(collectionDataAccessJointProjects);
		}

		String collectionDataAccessDescription = (String)attributes.get(
				"collectionDataAccessDescription");

		if (collectionDataAccessDescription != null) {
			setCollectionDataAccessDescription(collectionDataAccessDescription);
		}

		String collectionDataAccessURI = (String)attributes.get(
				"collectionDataAccessURI");

		if (collectionDataAccessURI != null) {
			setCollectionDataAccessURI(collectionDataAccessURI);
		}

		Long collectionSize = (Long)attributes.get("collectionSize");

		if (collectionSize != null) {
			setCollectionSize(collectionSize);
		}

		Long collectionSizeTimestamp = (Long)attributes.get(
				"collectionSizeTimestamp");

		if (collectionSizeTimestamp != null) {
			setCollectionSizeTimestamp(collectionSizeTimestamp);
		}
	}

	/**
	* Returns the primary key of this d2 collection.
	*
	* @return the primary key of this d2 collection
	*/
	@Override
	public long getPrimaryKey() {
		return _d2Collection.getPrimaryKey();
	}

	/**
	* Sets the primary key of this d2 collection.
	*
	* @param primaryKey the primary key of this d2 collection
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_d2Collection.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this d2 collection.
	*
	* @return the uuid of this d2 collection
	*/
	@Override
	public java.lang.String getUuid() {
		return _d2Collection.getUuid();
	}

	/**
	* Sets the uuid of this d2 collection.
	*
	* @param uuid the uuid of this d2 collection
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_d2Collection.setUuid(uuid);
	}

	/**
	* Returns the d2collection ID of this d2 collection.
	*
	* @return the d2collection ID of this d2 collection
	*/
	@Override
	public long getD2collectionId() {
		return _d2Collection.getD2collectionId();
	}

	/**
	* Sets the d2collection ID of this d2 collection.
	*
	* @param d2collectionId the d2collection ID of this d2 collection
	*/
	@Override
	public void setD2collectionId(long d2collectionId) {
		_d2Collection.setD2collectionId(d2collectionId);
	}

	/**
	* Returns the biobank ID of this d2 collection.
	*
	* @return the biobank ID of this d2 collection
	*/
	@Override
	public long getBiobankId() {
		return _d2Collection.getBiobankId();
	}

	/**
	* Sets the biobank ID of this d2 collection.
	*
	* @param biobankId the biobank ID of this d2 collection
	*/
	@Override
	public void setBiobankId(long biobankId) {
		_d2Collection.setBiobankId(biobankId);
	}

	/**
	* Returns the parentd2collection ID of this d2 collection.
	*
	* @return the parentd2collection ID of this d2 collection
	*/
	@Override
	public long getParentd2collectionId() {
		return _d2Collection.getParentd2collectionId();
	}

	/**
	* Sets the parentd2collection ID of this d2 collection.
	*
	* @param parentd2collectionId the parentd2collection ID of this d2 collection
	*/
	@Override
	public void setParentd2collectionId(long parentd2collectionId) {
		_d2Collection.setParentd2collectionId(parentd2collectionId);
	}

	/**
	* Returns the company ID of this d2 collection.
	*
	* @return the company ID of this d2 collection
	*/
	@Override
	public long getCompanyId() {
		return _d2Collection.getCompanyId();
	}

	/**
	* Sets the company ID of this d2 collection.
	*
	* @param companyId the company ID of this d2 collection
	*/
	@Override
	public void setCompanyId(long companyId) {
		_d2Collection.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this d2 collection.
	*
	* @return the group ID of this d2 collection
	*/
	@Override
	public long getGroupId() {
		return _d2Collection.getGroupId();
	}

	/**
	* Sets the group ID of this d2 collection.
	*
	* @param groupId the group ID of this d2 collection
	*/
	@Override
	public void setGroupId(long groupId) {
		_d2Collection.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this d2 collection.
	*
	* @return the user ID of this d2 collection
	*/
	@Override
	public long getUserId() {
		return _d2Collection.getUserId();
	}

	/**
	* Sets the user ID of this d2 collection.
	*
	* @param userId the user ID of this d2 collection
	*/
	@Override
	public void setUserId(long userId) {
		_d2Collection.setUserId(userId);
	}

	/**
	* Returns the user uuid of this d2 collection.
	*
	* @return the user uuid of this d2 collection
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2Collection.getUserUuid();
	}

	/**
	* Sets the user uuid of this d2 collection.
	*
	* @param userUuid the user uuid of this d2 collection
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_d2Collection.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this d2 collection.
	*
	* @return the user name of this d2 collection
	*/
	@Override
	public java.lang.String getUserName() {
		return _d2Collection.getUserName();
	}

	/**
	* Sets the user name of this d2 collection.
	*
	* @param userName the user name of this d2 collection
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_d2Collection.setUserName(userName);
	}

	/**
	* Returns the create date of this d2 collection.
	*
	* @return the create date of this d2 collection
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _d2Collection.getCreateDate();
	}

	/**
	* Sets the create date of this d2 collection.
	*
	* @param createDate the create date of this d2 collection
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_d2Collection.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this d2 collection.
	*
	* @return the modified date of this d2 collection
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _d2Collection.getModifiedDate();
	}

	/**
	* Sets the modified date of this d2 collection.
	*
	* @param modifiedDate the modified date of this d2 collection
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_d2Collection.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the updateuuid of this d2 collection.
	*
	* @return the updateuuid of this d2 collection
	*/
	@Override
	public java.lang.String getUpdateuuid() {
		return _d2Collection.getUpdateuuid();
	}

	/**
	* Sets the updateuuid of this d2 collection.
	*
	* @param updateuuid the updateuuid of this d2 collection
	*/
	@Override
	public void setUpdateuuid(java.lang.String updateuuid) {
		_d2Collection.setUpdateuuid(updateuuid);
	}

	/**
	* Returns the bbmricollection i d of this d2 collection.
	*
	* @return the bbmricollection i d of this d2 collection
	*/
	@Override
	public java.lang.String getBbmricollectionID() {
		return _d2Collection.getBbmricollectionID();
	}

	/**
	* Sets the bbmricollection i d of this d2 collection.
	*
	* @param bbmricollectionID the bbmricollection i d of this d2 collection
	*/
	@Override
	public void setBbmricollectionID(java.lang.String bbmricollectionID) {
		_d2Collection.setBbmricollectionID(bbmricollectionID);
	}

	/**
	* Returns the bbmriparentcollection i d of this d2 collection.
	*
	* @return the bbmriparentcollection i d of this d2 collection
	*/
	@Override
	public java.lang.String getBbmriparentcollectionID() {
		return _d2Collection.getBbmriparentcollectionID();
	}

	/**
	* Sets the bbmriparentcollection i d of this d2 collection.
	*
	* @param bbmriparentcollectionID the bbmriparentcollection i d of this d2 collection
	*/
	@Override
	public void setBbmriparentcollectionID(
		java.lang.String bbmriparentcollectionID) {
		_d2Collection.setBbmriparentcollectionID(bbmriparentcollectionID);
	}

	/**
	* Returns the bbmribiobank i d of this d2 collection.
	*
	* @return the bbmribiobank i d of this d2 collection
	*/
	@Override
	public java.lang.String getBbmribiobankID() {
		return _d2Collection.getBbmribiobankID();
	}

	/**
	* Sets the bbmribiobank i d of this d2 collection.
	*
	* @param bbmribiobankID the bbmribiobank i d of this d2 collection
	*/
	@Override
	public void setBbmribiobankID(java.lang.String bbmribiobankID) {
		_d2Collection.setBbmribiobankID(bbmribiobankID);
	}

	/**
	* Returns the collection name of this d2 collection.
	*
	* @return the collection name of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionName() {
		return _d2Collection.getCollectionName();
	}

	/**
	* Sets the collection name of this d2 collection.
	*
	* @param collectionName the collection name of this d2 collection
	*/
	@Override
	public void setCollectionName(java.lang.String collectionName) {
		_d2Collection.setCollectionName(collectionName);
	}

	/**
	* Returns the material stored d n a of this d2 collection.
	*
	* @return the material stored d n a of this d2 collection
	*/
	@Override
	public boolean getMaterialStoredDNA() {
		return _d2Collection.getMaterialStoredDNA();
	}

	/**
	* Returns <code>true</code> if this d2 collection is material stored d n a.
	*
	* @return <code>true</code> if this d2 collection is material stored d n a; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialStoredDNA() {
		return _d2Collection.isMaterialStoredDNA();
	}

	/**
	* Sets whether this d2 collection is material stored d n a.
	*
	* @param materialStoredDNA the material stored d n a of this d2 collection
	*/
	@Override
	public void setMaterialStoredDNA(boolean materialStoredDNA) {
		_d2Collection.setMaterialStoredDNA(materialStoredDNA);
	}

	/**
	* Returns the material stored plasma of this d2 collection.
	*
	* @return the material stored plasma of this d2 collection
	*/
	@Override
	public boolean getMaterialStoredPlasma() {
		return _d2Collection.getMaterialStoredPlasma();
	}

	/**
	* Returns <code>true</code> if this d2 collection is material stored plasma.
	*
	* @return <code>true</code> if this d2 collection is material stored plasma; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialStoredPlasma() {
		return _d2Collection.isMaterialStoredPlasma();
	}

	/**
	* Sets whether this d2 collection is material stored plasma.
	*
	* @param materialStoredPlasma the material stored plasma of this d2 collection
	*/
	@Override
	public void setMaterialStoredPlasma(boolean materialStoredPlasma) {
		_d2Collection.setMaterialStoredPlasma(materialStoredPlasma);
	}

	/**
	* Returns the material stored serum of this d2 collection.
	*
	* @return the material stored serum of this d2 collection
	*/
	@Override
	public boolean getMaterialStoredSerum() {
		return _d2Collection.getMaterialStoredSerum();
	}

	/**
	* Returns <code>true</code> if this d2 collection is material stored serum.
	*
	* @return <code>true</code> if this d2 collection is material stored serum; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialStoredSerum() {
		return _d2Collection.isMaterialStoredSerum();
	}

	/**
	* Sets whether this d2 collection is material stored serum.
	*
	* @param materialStoredSerum the material stored serum of this d2 collection
	*/
	@Override
	public void setMaterialStoredSerum(boolean materialStoredSerum) {
		_d2Collection.setMaterialStoredSerum(materialStoredSerum);
	}

	/**
	* Returns the material stored urine of this d2 collection.
	*
	* @return the material stored urine of this d2 collection
	*/
	@Override
	public boolean getMaterialStoredUrine() {
		return _d2Collection.getMaterialStoredUrine();
	}

	/**
	* Returns <code>true</code> if this d2 collection is material stored urine.
	*
	* @return <code>true</code> if this d2 collection is material stored urine; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialStoredUrine() {
		return _d2Collection.isMaterialStoredUrine();
	}

	/**
	* Sets whether this d2 collection is material stored urine.
	*
	* @param materialStoredUrine the material stored urine of this d2 collection
	*/
	@Override
	public void setMaterialStoredUrine(boolean materialStoredUrine) {
		_d2Collection.setMaterialStoredUrine(materialStoredUrine);
	}

	/**
	* Returns the material stored saliva of this d2 collection.
	*
	* @return the material stored saliva of this d2 collection
	*/
	@Override
	public boolean getMaterialStoredSaliva() {
		return _d2Collection.getMaterialStoredSaliva();
	}

	/**
	* Returns <code>true</code> if this d2 collection is material stored saliva.
	*
	* @return <code>true</code> if this d2 collection is material stored saliva; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialStoredSaliva() {
		return _d2Collection.isMaterialStoredSaliva();
	}

	/**
	* Sets whether this d2 collection is material stored saliva.
	*
	* @param materialStoredSaliva the material stored saliva of this d2 collection
	*/
	@Override
	public void setMaterialStoredSaliva(boolean materialStoredSaliva) {
		_d2Collection.setMaterialStoredSaliva(materialStoredSaliva);
	}

	/**
	* Returns the material stored faeces of this d2 collection.
	*
	* @return the material stored faeces of this d2 collection
	*/
	@Override
	public boolean getMaterialStoredFaeces() {
		return _d2Collection.getMaterialStoredFaeces();
	}

	/**
	* Returns <code>true</code> if this d2 collection is material stored faeces.
	*
	* @return <code>true</code> if this d2 collection is material stored faeces; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialStoredFaeces() {
		return _d2Collection.isMaterialStoredFaeces();
	}

	/**
	* Sets whether this d2 collection is material stored faeces.
	*
	* @param materialStoredFaeces the material stored faeces of this d2 collection
	*/
	@Override
	public void setMaterialStoredFaeces(boolean materialStoredFaeces) {
		_d2Collection.setMaterialStoredFaeces(materialStoredFaeces);
	}

	/**
	* Returns the material stored r n a of this d2 collection.
	*
	* @return the material stored r n a of this d2 collection
	*/
	@Override
	public boolean getMaterialStoredRNA() {
		return _d2Collection.getMaterialStoredRNA();
	}

	/**
	* Returns <code>true</code> if this d2 collection is material stored r n a.
	*
	* @return <code>true</code> if this d2 collection is material stored r n a; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialStoredRNA() {
		return _d2Collection.isMaterialStoredRNA();
	}

	/**
	* Sets whether this d2 collection is material stored r n a.
	*
	* @param materialStoredRNA the material stored r n a of this d2 collection
	*/
	@Override
	public void setMaterialStoredRNA(boolean materialStoredRNA) {
		_d2Collection.setMaterialStoredRNA(materialStoredRNA);
	}

	/**
	* Returns the material stored blood of this d2 collection.
	*
	* @return the material stored blood of this d2 collection
	*/
	@Override
	public boolean getMaterialStoredBlood() {
		return _d2Collection.getMaterialStoredBlood();
	}

	/**
	* Returns <code>true</code> if this d2 collection is material stored blood.
	*
	* @return <code>true</code> if this d2 collection is material stored blood; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialStoredBlood() {
		return _d2Collection.isMaterialStoredBlood();
	}

	/**
	* Sets whether this d2 collection is material stored blood.
	*
	* @param materialStoredBlood the material stored blood of this d2 collection
	*/
	@Override
	public void setMaterialStoredBlood(boolean materialStoredBlood) {
		_d2Collection.setMaterialStoredBlood(materialStoredBlood);
	}

	/**
	* Returns the material stored tissue frozen of this d2 collection.
	*
	* @return the material stored tissue frozen of this d2 collection
	*/
	@Override
	public boolean getMaterialStoredTissueFrozen() {
		return _d2Collection.getMaterialStoredTissueFrozen();
	}

	/**
	* Returns <code>true</code> if this d2 collection is material stored tissue frozen.
	*
	* @return <code>true</code> if this d2 collection is material stored tissue frozen; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialStoredTissueFrozen() {
		return _d2Collection.isMaterialStoredTissueFrozen();
	}

	/**
	* Sets whether this d2 collection is material stored tissue frozen.
	*
	* @param materialStoredTissueFrozen the material stored tissue frozen of this d2 collection
	*/
	@Override
	public void setMaterialStoredTissueFrozen(
		boolean materialStoredTissueFrozen) {
		_d2Collection.setMaterialStoredTissueFrozen(materialStoredTissueFrozen);
	}

	/**
	* Returns the material stored tissue f f p e of this d2 collection.
	*
	* @return the material stored tissue f f p e of this d2 collection
	*/
	@Override
	public boolean getMaterialStoredTissueFFPE() {
		return _d2Collection.getMaterialStoredTissueFFPE();
	}

	/**
	* Returns <code>true</code> if this d2 collection is material stored tissue f f p e.
	*
	* @return <code>true</code> if this d2 collection is material stored tissue f f p e; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialStoredTissueFFPE() {
		return _d2Collection.isMaterialStoredTissueFFPE();
	}

	/**
	* Sets whether this d2 collection is material stored tissue f f p e.
	*
	* @param materialStoredTissueFFPE the material stored tissue f f p e of this d2 collection
	*/
	@Override
	public void setMaterialStoredTissueFFPE(boolean materialStoredTissueFFPE) {
		_d2Collection.setMaterialStoredTissueFFPE(materialStoredTissueFFPE);
	}

	/**
	* Returns the material stored immortalized cell lines of this d2 collection.
	*
	* @return the material stored immortalized cell lines of this d2 collection
	*/
	@Override
	public boolean getMaterialStoredImmortalizedCellLines() {
		return _d2Collection.getMaterialStoredImmortalizedCellLines();
	}

	/**
	* Returns <code>true</code> if this d2 collection is material stored immortalized cell lines.
	*
	* @return <code>true</code> if this d2 collection is material stored immortalized cell lines; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialStoredImmortalizedCellLines() {
		return _d2Collection.isMaterialStoredImmortalizedCellLines();
	}

	/**
	* Sets whether this d2 collection is material stored immortalized cell lines.
	*
	* @param materialStoredImmortalizedCellLines the material stored immortalized cell lines of this d2 collection
	*/
	@Override
	public void setMaterialStoredImmortalizedCellLines(
		boolean materialStoredImmortalizedCellLines) {
		_d2Collection.setMaterialStoredImmortalizedCellLines(materialStoredImmortalizedCellLines);
	}

	/**
	* Returns the material stored isolated pathogen of this d2 collection.
	*
	* @return the material stored isolated pathogen of this d2 collection
	*/
	@Override
	public boolean getMaterialStoredIsolatedPathogen() {
		return _d2Collection.getMaterialStoredIsolatedPathogen();
	}

	/**
	* Returns <code>true</code> if this d2 collection is material stored isolated pathogen.
	*
	* @return <code>true</code> if this d2 collection is material stored isolated pathogen; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialStoredIsolatedPathogen() {
		return _d2Collection.isMaterialStoredIsolatedPathogen();
	}

	/**
	* Sets whether this d2 collection is material stored isolated pathogen.
	*
	* @param materialStoredIsolatedPathogen the material stored isolated pathogen of this d2 collection
	*/
	@Override
	public void setMaterialStoredIsolatedPathogen(
		boolean materialStoredIsolatedPathogen) {
		_d2Collection.setMaterialStoredIsolatedPathogen(materialStoredIsolatedPathogen);
	}

	/**
	* Returns the material stored other of this d2 collection.
	*
	* @return the material stored other of this d2 collection
	*/
	@Override
	public java.lang.String getMaterialStoredOther() {
		return _d2Collection.getMaterialStoredOther();
	}

	/**
	* Sets the material stored other of this d2 collection.
	*
	* @param materialStoredOther the material stored other of this d2 collection
	*/
	@Override
	public void setMaterialStoredOther(java.lang.String materialStoredOther) {
		_d2Collection.setMaterialStoredOther(materialStoredOther);
	}

	/**
	* Returns the collection type case control of this d2 collection.
	*
	* @return the collection type case control of this d2 collection
	*/
	@Override
	public boolean getCollectionTypeCaseControl() {
		return _d2Collection.getCollectionTypeCaseControl();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection type case control.
	*
	* @return <code>true</code> if this d2 collection is collection type case control; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionTypeCaseControl() {
		return _d2Collection.isCollectionTypeCaseControl();
	}

	/**
	* Sets whether this d2 collection is collection type case control.
	*
	* @param collectionTypeCaseControl the collection type case control of this d2 collection
	*/
	@Override
	public void setCollectionTypeCaseControl(boolean collectionTypeCaseControl) {
		_d2Collection.setCollectionTypeCaseControl(collectionTypeCaseControl);
	}

	/**
	* Returns the collection type cohort of this d2 collection.
	*
	* @return the collection type cohort of this d2 collection
	*/
	@Override
	public boolean getCollectionTypeCohort() {
		return _d2Collection.getCollectionTypeCohort();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection type cohort.
	*
	* @return <code>true</code> if this d2 collection is collection type cohort; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionTypeCohort() {
		return _d2Collection.isCollectionTypeCohort();
	}

	/**
	* Sets whether this d2 collection is collection type cohort.
	*
	* @param collectionTypeCohort the collection type cohort of this d2 collection
	*/
	@Override
	public void setCollectionTypeCohort(boolean collectionTypeCohort) {
		_d2Collection.setCollectionTypeCohort(collectionTypeCohort);
	}

	/**
	* Returns the collection type cross sectional of this d2 collection.
	*
	* @return the collection type cross sectional of this d2 collection
	*/
	@Override
	public boolean getCollectionTypeCrossSectional() {
		return _d2Collection.getCollectionTypeCrossSectional();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection type cross sectional.
	*
	* @return <code>true</code> if this d2 collection is collection type cross sectional; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionTypeCrossSectional() {
		return _d2Collection.isCollectionTypeCrossSectional();
	}

	/**
	* Sets whether this d2 collection is collection type cross sectional.
	*
	* @param collectionTypeCrossSectional the collection type cross sectional of this d2 collection
	*/
	@Override
	public void setCollectionTypeCrossSectional(
		boolean collectionTypeCrossSectional) {
		_d2Collection.setCollectionTypeCrossSectional(collectionTypeCrossSectional);
	}

	/**
	* Returns the collection type longitudinal of this d2 collection.
	*
	* @return the collection type longitudinal of this d2 collection
	*/
	@Override
	public boolean getCollectionTypeLongitudinal() {
		return _d2Collection.getCollectionTypeLongitudinal();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection type longitudinal.
	*
	* @return <code>true</code> if this d2 collection is collection type longitudinal; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionTypeLongitudinal() {
		return _d2Collection.isCollectionTypeLongitudinal();
	}

	/**
	* Sets whether this d2 collection is collection type longitudinal.
	*
	* @param collectionTypeLongitudinal the collection type longitudinal of this d2 collection
	*/
	@Override
	public void setCollectionTypeLongitudinal(
		boolean collectionTypeLongitudinal) {
		_d2Collection.setCollectionTypeLongitudinal(collectionTypeLongitudinal);
	}

	/**
	* Returns the collection type twin study of this d2 collection.
	*
	* @return the collection type twin study of this d2 collection
	*/
	@Override
	public boolean getCollectionTypeTwinStudy() {
		return _d2Collection.getCollectionTypeTwinStudy();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection type twin study.
	*
	* @return <code>true</code> if this d2 collection is collection type twin study; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionTypeTwinStudy() {
		return _d2Collection.isCollectionTypeTwinStudy();
	}

	/**
	* Sets whether this d2 collection is collection type twin study.
	*
	* @param collectionTypeTwinStudy the collection type twin study of this d2 collection
	*/
	@Override
	public void setCollectionTypeTwinStudy(boolean collectionTypeTwinStudy) {
		_d2Collection.setCollectionTypeTwinStudy(collectionTypeTwinStudy);
	}

	/**
	* Returns the collection type quality control of this d2 collection.
	*
	* @return the collection type quality control of this d2 collection
	*/
	@Override
	public boolean getCollectionTypeQualityControl() {
		return _d2Collection.getCollectionTypeQualityControl();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection type quality control.
	*
	* @return <code>true</code> if this d2 collection is collection type quality control; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionTypeQualityControl() {
		return _d2Collection.isCollectionTypeQualityControl();
	}

	/**
	* Sets whether this d2 collection is collection type quality control.
	*
	* @param collectionTypeQualityControl the collection type quality control of this d2 collection
	*/
	@Override
	public void setCollectionTypeQualityControl(
		boolean collectionTypeQualityControl) {
		_d2Collection.setCollectionTypeQualityControl(collectionTypeQualityControl);
	}

	/**
	* Returns the collection type population based of this d2 collection.
	*
	* @return the collection type population based of this d2 collection
	*/
	@Override
	public boolean getCollectionTypePopulationBased() {
		return _d2Collection.getCollectionTypePopulationBased();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection type population based.
	*
	* @return <code>true</code> if this d2 collection is collection type population based; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionTypePopulationBased() {
		return _d2Collection.isCollectionTypePopulationBased();
	}

	/**
	* Sets whether this d2 collection is collection type population based.
	*
	* @param collectionTypePopulationBased the collection type population based of this d2 collection
	*/
	@Override
	public void setCollectionTypePopulationBased(
		boolean collectionTypePopulationBased) {
		_d2Collection.setCollectionTypePopulationBased(collectionTypePopulationBased);
	}

	/**
	* Returns the collection type disease specific of this d2 collection.
	*
	* @return the collection type disease specific of this d2 collection
	*/
	@Override
	public boolean getCollectionTypeDiseaseSpecific() {
		return _d2Collection.getCollectionTypeDiseaseSpecific();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection type disease specific.
	*
	* @return <code>true</code> if this d2 collection is collection type disease specific; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionTypeDiseaseSpecific() {
		return _d2Collection.isCollectionTypeDiseaseSpecific();
	}

	/**
	* Sets whether this d2 collection is collection type disease specific.
	*
	* @param collectionTypeDiseaseSpecific the collection type disease specific of this d2 collection
	*/
	@Override
	public void setCollectionTypeDiseaseSpecific(
		boolean collectionTypeDiseaseSpecific) {
		_d2Collection.setCollectionTypeDiseaseSpecific(collectionTypeDiseaseSpecific);
	}

	/**
	* Returns the collection type birth cohort of this d2 collection.
	*
	* @return the collection type birth cohort of this d2 collection
	*/
	@Override
	public boolean getCollectionTypeBirthCohort() {
		return _d2Collection.getCollectionTypeBirthCohort();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection type birth cohort.
	*
	* @return <code>true</code> if this d2 collection is collection type birth cohort; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionTypeBirthCohort() {
		return _d2Collection.isCollectionTypeBirthCohort();
	}

	/**
	* Sets whether this d2 collection is collection type birth cohort.
	*
	* @param collectionTypeBirthCohort the collection type birth cohort of this d2 collection
	*/
	@Override
	public void setCollectionTypeBirthCohort(boolean collectionTypeBirthCohort) {
		_d2Collection.setCollectionTypeBirthCohort(collectionTypeBirthCohort);
	}

	/**
	* Returns the collection type other of this d2 collection.
	*
	* @return the collection type other of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionTypeOther() {
		return _d2Collection.getCollectionTypeOther();
	}

	/**
	* Sets the collection type other of this d2 collection.
	*
	* @param collectionTypeOther the collection type other of this d2 collection
	*/
	@Override
	public void setCollectionTypeOther(java.lang.String collectionTypeOther) {
		_d2Collection.setCollectionTypeOther(collectionTypeOther);
	}

	/**
	* Returns the collection order of magnitude of this d2 collection.
	*
	* @return the collection order of magnitude of this d2 collection
	*/
	@Override
	public long getCollectionOrderOfMagnitude() {
		return _d2Collection.getCollectionOrderOfMagnitude();
	}

	/**
	* Sets the collection order of magnitude of this d2 collection.
	*
	* @param collectionOrderOfMagnitude the collection order of magnitude of this d2 collection
	*/
	@Override
	public void setCollectionOrderOfMagnitude(long collectionOrderOfMagnitude) {
		_d2Collection.setCollectionOrderOfMagnitude(collectionOrderOfMagnitude);
	}

	/**
	* Returns the bioresource reference of this d2 collection.
	*
	* @return the bioresource reference of this d2 collection
	*/
	@Override
	public java.lang.String getBioresourceReference() {
		return _d2Collection.getBioresourceReference();
	}

	/**
	* Sets the bioresource reference of this d2 collection.
	*
	* @param bioresourceReference the bioresource reference of this d2 collection
	*/
	@Override
	public void setBioresourceReference(java.lang.String bioresourceReference) {
		_d2Collection.setBioresourceReference(bioresourceReference);
	}

	/**
	* Returns the contact i d ref of this d2 collection.
	*
	* @return the contact i d ref of this d2 collection
	*/
	@Override
	public java.lang.String getContactIDRef() {
		return _d2Collection.getContactIDRef();
	}

	/**
	* Sets the contact i d ref of this d2 collection.
	*
	* @param contactIDRef the contact i d ref of this d2 collection
	*/
	@Override
	public void setContactIDRef(java.lang.String contactIDRef) {
		_d2Collection.setContactIDRef(contactIDRef);
	}

	/**
	* Returns the contact priority of this d2 collection.
	*
	* @return the contact priority of this d2 collection
	*/
	@Override
	public long getContactPriority() {
		return _d2Collection.getContactPriority();
	}

	/**
	* Sets the contact priority of this d2 collection.
	*
	* @param contactPriority the contact priority of this d2 collection
	*/
	@Override
	public void setContactPriority(long contactPriority) {
		_d2Collection.setContactPriority(contactPriority);
	}

	/**
	* Returns the biobank network i d ref of this d2 collection.
	*
	* @return the biobank network i d ref of this d2 collection
	*/
	@Override
	public java.lang.String getBiobankNetworkIDRef() {
		return _d2Collection.getBiobankNetworkIDRef();
	}

	/**
	* Sets the biobank network i d ref of this d2 collection.
	*
	* @param biobankNetworkIDRef the biobank network i d ref of this d2 collection
	*/
	@Override
	public void setBiobankNetworkIDRef(java.lang.String biobankNetworkIDRef) {
		_d2Collection.setBiobankNetworkIDRef(biobankNetworkIDRef);
	}

	/**
	* Returns the geo latitude of this d2 collection.
	*
	* @return the geo latitude of this d2 collection
	*/
	@Override
	public java.lang.String getGeoLatitude() {
		return _d2Collection.getGeoLatitude();
	}

	/**
	* Sets the geo latitude of this d2 collection.
	*
	* @param geoLatitude the geo latitude of this d2 collection
	*/
	@Override
	public void setGeoLatitude(java.lang.String geoLatitude) {
		_d2Collection.setGeoLatitude(geoLatitude);
	}

	/**
	* Returns the geo longitude of this d2 collection.
	*
	* @return the geo longitude of this d2 collection
	*/
	@Override
	public java.lang.String getGeoLongitude() {
		return _d2Collection.getGeoLongitude();
	}

	/**
	* Sets the geo longitude of this d2 collection.
	*
	* @param geoLongitude the geo longitude of this d2 collection
	*/
	@Override
	public void setGeoLongitude(java.lang.String geoLongitude) {
		_d2Collection.setGeoLongitude(geoLongitude);
	}

	/**
	* Returns the collaboration partners commercial of this d2 collection.
	*
	* @return the collaboration partners commercial of this d2 collection
	*/
	@Override
	public boolean getCollaborationPartnersCommercial() {
		return _d2Collection.getCollaborationPartnersCommercial();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collaboration partners commercial.
	*
	* @return <code>true</code> if this d2 collection is collaboration partners commercial; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollaborationPartnersCommercial() {
		return _d2Collection.isCollaborationPartnersCommercial();
	}

	/**
	* Sets whether this d2 collection is collaboration partners commercial.
	*
	* @param collaborationPartnersCommercial the collaboration partners commercial of this d2 collection
	*/
	@Override
	public void setCollaborationPartnersCommercial(
		boolean collaborationPartnersCommercial) {
		_d2Collection.setCollaborationPartnersCommercial(collaborationPartnersCommercial);
	}

	/**
	* Returns the collaboration partners nonforprofit of this d2 collection.
	*
	* @return the collaboration partners nonforprofit of this d2 collection
	*/
	@Override
	public boolean getCollaborationPartnersNonforprofit() {
		return _d2Collection.getCollaborationPartnersNonforprofit();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collaboration partners nonforprofit.
	*
	* @return <code>true</code> if this d2 collection is collaboration partners nonforprofit; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollaborationPartnersNonforprofit() {
		return _d2Collection.isCollaborationPartnersNonforprofit();
	}

	/**
	* Sets whether this d2 collection is collaboration partners nonforprofit.
	*
	* @param collaborationPartnersNonforprofit the collaboration partners nonforprofit of this d2 collection
	*/
	@Override
	public void setCollaborationPartnersNonforprofit(
		boolean collaborationPartnersNonforprofit) {
		_d2Collection.setCollaborationPartnersNonforprofit(collaborationPartnersNonforprofit);
	}

	/**
	* Returns the collection acronym of this d2 collection.
	*
	* @return the collection acronym of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionAcronym() {
		return _d2Collection.getCollectionAcronym();
	}

	/**
	* Sets the collection acronym of this d2 collection.
	*
	* @param collectionAcronym the collection acronym of this d2 collection
	*/
	@Override
	public void setCollectionAcronym(java.lang.String collectionAcronym) {
		_d2Collection.setCollectionAcronym(collectionAcronym);
	}

	/**
	* Returns the collection description of this d2 collection.
	*
	* @return the collection description of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionDescription() {
		return _d2Collection.getCollectionDescription();
	}

	/**
	* Sets the collection description of this d2 collection.
	*
	* @param collectionDescription the collection description of this d2 collection
	*/
	@Override
	public void setCollectionDescription(java.lang.String collectionDescription) {
		_d2Collection.setCollectionDescription(collectionDescription);
	}

	/**
	* Returns the collection sex male of this d2 collection.
	*
	* @return the collection sex male of this d2 collection
	*/
	@Override
	public boolean getCollectionSexMale() {
		return _d2Collection.getCollectionSexMale();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection sex male.
	*
	* @return <code>true</code> if this d2 collection is collection sex male; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionSexMale() {
		return _d2Collection.isCollectionSexMale();
	}

	/**
	* Sets whether this d2 collection is collection sex male.
	*
	* @param collectionSexMale the collection sex male of this d2 collection
	*/
	@Override
	public void setCollectionSexMale(boolean collectionSexMale) {
		_d2Collection.setCollectionSexMale(collectionSexMale);
	}

	/**
	* Returns the collection sex female of this d2 collection.
	*
	* @return the collection sex female of this d2 collection
	*/
	@Override
	public boolean getCollectionSexFemale() {
		return _d2Collection.getCollectionSexFemale();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection sex female.
	*
	* @return <code>true</code> if this d2 collection is collection sex female; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionSexFemale() {
		return _d2Collection.isCollectionSexFemale();
	}

	/**
	* Sets whether this d2 collection is collection sex female.
	*
	* @param collectionSexFemale the collection sex female of this d2 collection
	*/
	@Override
	public void setCollectionSexFemale(boolean collectionSexFemale) {
		_d2Collection.setCollectionSexFemale(collectionSexFemale);
	}

	/**
	* Returns the collection sex unknown of this d2 collection.
	*
	* @return the collection sex unknown of this d2 collection
	*/
	@Override
	public boolean getCollectionSexUnknown() {
		return _d2Collection.getCollectionSexUnknown();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection sex unknown.
	*
	* @return <code>true</code> if this d2 collection is collection sex unknown; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionSexUnknown() {
		return _d2Collection.isCollectionSexUnknown();
	}

	/**
	* Sets whether this d2 collection is collection sex unknown.
	*
	* @param collectionSexUnknown the collection sex unknown of this d2 collection
	*/
	@Override
	public void setCollectionSexUnknown(boolean collectionSexUnknown) {
		_d2Collection.setCollectionSexUnknown(collectionSexUnknown);
	}

	/**
	* Returns the collection sex undiferrentiated of this d2 collection.
	*
	* @return the collection sex undiferrentiated of this d2 collection
	*/
	@Override
	public boolean getCollectionSexUndiferrentiated() {
		return _d2Collection.getCollectionSexUndiferrentiated();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection sex undiferrentiated.
	*
	* @return <code>true</code> if this d2 collection is collection sex undiferrentiated; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionSexUndiferrentiated() {
		return _d2Collection.isCollectionSexUndiferrentiated();
	}

	/**
	* Sets whether this d2 collection is collection sex undiferrentiated.
	*
	* @param collectionSexUndiferrentiated the collection sex undiferrentiated of this d2 collection
	*/
	@Override
	public void setCollectionSexUndiferrentiated(
		boolean collectionSexUndiferrentiated) {
		_d2Collection.setCollectionSexUndiferrentiated(collectionSexUndiferrentiated);
	}

	/**
	* Returns the collection age low of this d2 collection.
	*
	* @return the collection age low of this d2 collection
	*/
	@Override
	public long getCollectionAgeLow() {
		return _d2Collection.getCollectionAgeLow();
	}

	/**
	* Sets the collection age low of this d2 collection.
	*
	* @param collectionAgeLow the collection age low of this d2 collection
	*/
	@Override
	public void setCollectionAgeLow(long collectionAgeLow) {
		_d2Collection.setCollectionAgeLow(collectionAgeLow);
	}

	/**
	* Returns the collection age high of this d2 collection.
	*
	* @return the collection age high of this d2 collection
	*/
	@Override
	public long getCollectionAgeHigh() {
		return _d2Collection.getCollectionAgeHigh();
	}

	/**
	* Sets the collection age high of this d2 collection.
	*
	* @param collectionAgeHigh the collection age high of this d2 collection
	*/
	@Override
	public void setCollectionAgeHigh(long collectionAgeHigh) {
		_d2Collection.setCollectionAgeHigh(collectionAgeHigh);
	}

	/**
	* Returns the collection age unit of this d2 collection.
	*
	* @return the collection age unit of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionAgeUnit() {
		return _d2Collection.getCollectionAgeUnit();
	}

	/**
	* Sets the collection age unit of this d2 collection.
	*
	* @param collectionAgeUnit the collection age unit of this d2 collection
	*/
	@Override
	public void setCollectionAgeUnit(java.lang.String collectionAgeUnit) {
		_d2Collection.setCollectionAgeUnit(collectionAgeUnit);
	}

	/**
	* Returns the collection available biological samples of this d2 collection.
	*
	* @return the collection available biological samples of this d2 collection
	*/
	@Override
	public boolean getCollectionAvailableBiologicalSamples() {
		return _d2Collection.getCollectionAvailableBiologicalSamples();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection available biological samples.
	*
	* @return <code>true</code> if this d2 collection is collection available biological samples; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionAvailableBiologicalSamples() {
		return _d2Collection.isCollectionAvailableBiologicalSamples();
	}

	/**
	* Sets whether this d2 collection is collection available biological samples.
	*
	* @param collectionAvailableBiologicalSamples the collection available biological samples of this d2 collection
	*/
	@Override
	public void setCollectionAvailableBiologicalSamples(
		boolean collectionAvailableBiologicalSamples) {
		_d2Collection.setCollectionAvailableBiologicalSamples(collectionAvailableBiologicalSamples);
	}

	/**
	* Returns the collection available survey data of this d2 collection.
	*
	* @return the collection available survey data of this d2 collection
	*/
	@Override
	public boolean getCollectionAvailableSurveyData() {
		return _d2Collection.getCollectionAvailableSurveyData();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection available survey data.
	*
	* @return <code>true</code> if this d2 collection is collection available survey data; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionAvailableSurveyData() {
		return _d2Collection.isCollectionAvailableSurveyData();
	}

	/**
	* Sets whether this d2 collection is collection available survey data.
	*
	* @param collectionAvailableSurveyData the collection available survey data of this d2 collection
	*/
	@Override
	public void setCollectionAvailableSurveyData(
		boolean collectionAvailableSurveyData) {
		_d2Collection.setCollectionAvailableSurveyData(collectionAvailableSurveyData);
	}

	/**
	* Returns the collection available imaging data of this d2 collection.
	*
	* @return the collection available imaging data of this d2 collection
	*/
	@Override
	public boolean getCollectionAvailableImagingData() {
		return _d2Collection.getCollectionAvailableImagingData();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection available imaging data.
	*
	* @return <code>true</code> if this d2 collection is collection available imaging data; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionAvailableImagingData() {
		return _d2Collection.isCollectionAvailableImagingData();
	}

	/**
	* Sets whether this d2 collection is collection available imaging data.
	*
	* @param collectionAvailableImagingData the collection available imaging data of this d2 collection
	*/
	@Override
	public void setCollectionAvailableImagingData(
		boolean collectionAvailableImagingData) {
		_d2Collection.setCollectionAvailableImagingData(collectionAvailableImagingData);
	}

	/**
	* Returns the collection available medical records of this d2 collection.
	*
	* @return the collection available medical records of this d2 collection
	*/
	@Override
	public boolean getCollectionAvailableMedicalRecords() {
		return _d2Collection.getCollectionAvailableMedicalRecords();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection available medical records.
	*
	* @return <code>true</code> if this d2 collection is collection available medical records; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionAvailableMedicalRecords() {
		return _d2Collection.isCollectionAvailableMedicalRecords();
	}

	/**
	* Sets whether this d2 collection is collection available medical records.
	*
	* @param collectionAvailableMedicalRecords the collection available medical records of this d2 collection
	*/
	@Override
	public void setCollectionAvailableMedicalRecords(
		boolean collectionAvailableMedicalRecords) {
		_d2Collection.setCollectionAvailableMedicalRecords(collectionAvailableMedicalRecords);
	}

	/**
	* Returns the collection available national registries of this d2 collection.
	*
	* @return the collection available national registries of this d2 collection
	*/
	@Override
	public boolean getCollectionAvailableNationalRegistries() {
		return _d2Collection.getCollectionAvailableNationalRegistries();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection available national registries.
	*
	* @return <code>true</code> if this d2 collection is collection available national registries; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionAvailableNationalRegistries() {
		return _d2Collection.isCollectionAvailableNationalRegistries();
	}

	/**
	* Sets whether this d2 collection is collection available national registries.
	*
	* @param collectionAvailableNationalRegistries the collection available national registries of this d2 collection
	*/
	@Override
	public void setCollectionAvailableNationalRegistries(
		boolean collectionAvailableNationalRegistries) {
		_d2Collection.setCollectionAvailableNationalRegistries(collectionAvailableNationalRegistries);
	}

	/**
	* Returns the collection available genealogical records of this d2 collection.
	*
	* @return the collection available genealogical records of this d2 collection
	*/
	@Override
	public boolean getCollectionAvailableGenealogicalRecords() {
		return _d2Collection.getCollectionAvailableGenealogicalRecords();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection available genealogical records.
	*
	* @return <code>true</code> if this d2 collection is collection available genealogical records; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionAvailableGenealogicalRecords() {
		return _d2Collection.isCollectionAvailableGenealogicalRecords();
	}

	/**
	* Sets whether this d2 collection is collection available genealogical records.
	*
	* @param collectionAvailableGenealogicalRecords the collection available genealogical records of this d2 collection
	*/
	@Override
	public void setCollectionAvailableGenealogicalRecords(
		boolean collectionAvailableGenealogicalRecords) {
		_d2Collection.setCollectionAvailableGenealogicalRecords(collectionAvailableGenealogicalRecords);
	}

	/**
	* Returns the collection available physio biochem measurements of this d2 collection.
	*
	* @return the collection available physio biochem measurements of this d2 collection
	*/
	@Override
	public boolean getCollectionAvailablePhysioBiochemMeasurements() {
		return _d2Collection.getCollectionAvailablePhysioBiochemMeasurements();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection available physio biochem measurements.
	*
	* @return <code>true</code> if this d2 collection is collection available physio biochem measurements; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionAvailablePhysioBiochemMeasurements() {
		return _d2Collection.isCollectionAvailablePhysioBiochemMeasurements();
	}

	/**
	* Sets whether this d2 collection is collection available physio biochem measurements.
	*
	* @param collectionAvailablePhysioBiochemMeasurements the collection available physio biochem measurements of this d2 collection
	*/
	@Override
	public void setCollectionAvailablePhysioBiochemMeasurements(
		boolean collectionAvailablePhysioBiochemMeasurements) {
		_d2Collection.setCollectionAvailablePhysioBiochemMeasurements(collectionAvailablePhysioBiochemMeasurements);
	}

	/**
	* Returns the collection available other of this d2 collection.
	*
	* @return the collection available other of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionAvailableOther() {
		return _d2Collection.getCollectionAvailableOther();
	}

	/**
	* Sets the collection available other of this d2 collection.
	*
	* @param collectionAvailableOther the collection available other of this d2 collection
	*/
	@Override
	public void setCollectionAvailableOther(
		java.lang.String collectionAvailableOther) {
		_d2Collection.setCollectionAvailableOther(collectionAvailableOther);
	}

	/**
	* Returns the temperature room of this d2 collection.
	*
	* @return the temperature room of this d2 collection
	*/
	@Override
	public boolean getTemperatureRoom() {
		return _d2Collection.getTemperatureRoom();
	}

	/**
	* Returns <code>true</code> if this d2 collection is temperature room.
	*
	* @return <code>true</code> if this d2 collection is temperature room; <code>false</code> otherwise
	*/
	@Override
	public boolean isTemperatureRoom() {
		return _d2Collection.isTemperatureRoom();
	}

	/**
	* Sets whether this d2 collection is temperature room.
	*
	* @param temperatureRoom the temperature room of this d2 collection
	*/
	@Override
	public void setTemperatureRoom(boolean temperatureRoom) {
		_d2Collection.setTemperatureRoom(temperatureRoom);
	}

	/**
	* Returns the temperature2to10 of this d2 collection.
	*
	* @return the temperature2to10 of this d2 collection
	*/
	@Override
	public boolean getTemperature2to10() {
		return _d2Collection.getTemperature2to10();
	}

	/**
	* Returns <code>true</code> if this d2 collection is temperature2to10.
	*
	* @return <code>true</code> if this d2 collection is temperature2to10; <code>false</code> otherwise
	*/
	@Override
	public boolean isTemperature2to10() {
		return _d2Collection.isTemperature2to10();
	}

	/**
	* Sets whether this d2 collection is temperature2to10.
	*
	* @param temperature2to10 the temperature2to10 of this d2 collection
	*/
	@Override
	public void setTemperature2to10(boolean temperature2to10) {
		_d2Collection.setTemperature2to10(temperature2to10);
	}

	/**
	* Returns the temperature18to35 of this d2 collection.
	*
	* @return the temperature18to35 of this d2 collection
	*/
	@Override
	public boolean getTemperature18to35() {
		return _d2Collection.getTemperature18to35();
	}

	/**
	* Returns <code>true</code> if this d2 collection is temperature18to35.
	*
	* @return <code>true</code> if this d2 collection is temperature18to35; <code>false</code> otherwise
	*/
	@Override
	public boolean isTemperature18to35() {
		return _d2Collection.isTemperature18to35();
	}

	/**
	* Sets whether this d2 collection is temperature18to35.
	*
	* @param temperature18to35 the temperature18to35 of this d2 collection
	*/
	@Override
	public void setTemperature18to35(boolean temperature18to35) {
		_d2Collection.setTemperature18to35(temperature18to35);
	}

	/**
	* Returns the temperature60to85 of this d2 collection.
	*
	* @return the temperature60to85 of this d2 collection
	*/
	@Override
	public boolean getTemperature60to85() {
		return _d2Collection.getTemperature60to85();
	}

	/**
	* Returns <code>true</code> if this d2 collection is temperature60to85.
	*
	* @return <code>true</code> if this d2 collection is temperature60to85; <code>false</code> otherwise
	*/
	@Override
	public boolean isTemperature60to85() {
		return _d2Collection.isTemperature60to85();
	}

	/**
	* Sets whether this d2 collection is temperature60to85.
	*
	* @param temperature60to85 the temperature60to85 of this d2 collection
	*/
	@Override
	public void setTemperature60to85(boolean temperature60to85) {
		_d2Collection.setTemperature60to85(temperature60to85);
	}

	/**
	* Returns the temperature l n of this d2 collection.
	*
	* @return the temperature l n of this d2 collection
	*/
	@Override
	public boolean getTemperatureLN() {
		return _d2Collection.getTemperatureLN();
	}

	/**
	* Returns <code>true</code> if this d2 collection is temperature l n.
	*
	* @return <code>true</code> if this d2 collection is temperature l n; <code>false</code> otherwise
	*/
	@Override
	public boolean isTemperatureLN() {
		return _d2Collection.isTemperatureLN();
	}

	/**
	* Sets whether this d2 collection is temperature l n.
	*
	* @param temperatureLN the temperature l n of this d2 collection
	*/
	@Override
	public void setTemperatureLN(boolean temperatureLN) {
		_d2Collection.setTemperatureLN(temperatureLN);
	}

	/**
	* Returns the temperature other of this d2 collection.
	*
	* @return the temperature other of this d2 collection
	*/
	@Override
	public java.lang.String getTemperatureOther() {
		return _d2Collection.getTemperatureOther();
	}

	/**
	* Sets the temperature other of this d2 collection.
	*
	* @param temperatureOther the temperature other of this d2 collection
	*/
	@Override
	public void setTemperatureOther(java.lang.String temperatureOther) {
		_d2Collection.setTemperatureOther(temperatureOther);
	}

	/**
	* Returns the diagnosis available of this d2 collection.
	*
	* @return the diagnosis available of this d2 collection
	*/
	@Override
	public java.lang.String getDiagnosisAvailable() {
		return _d2Collection.getDiagnosisAvailable();
	}

	/**
	* Sets the diagnosis available of this d2 collection.
	*
	* @param diagnosisAvailable the diagnosis available of this d2 collection
	*/
	@Override
	public void setDiagnosisAvailable(java.lang.String diagnosisAvailable) {
		_d2Collection.setDiagnosisAvailable(diagnosisAvailable);
	}

	/**
	* Returns the collection head first name of this d2 collection.
	*
	* @return the collection head first name of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionHeadFirstName() {
		return _d2Collection.getCollectionHeadFirstName();
	}

	/**
	* Sets the collection head first name of this d2 collection.
	*
	* @param collectionHeadFirstName the collection head first name of this d2 collection
	*/
	@Override
	public void setCollectionHeadFirstName(
		java.lang.String collectionHeadFirstName) {
		_d2Collection.setCollectionHeadFirstName(collectionHeadFirstName);
	}

	/**
	* Returns the collection head last name of this d2 collection.
	*
	* @return the collection head last name of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionHeadLastName() {
		return _d2Collection.getCollectionHeadLastName();
	}

	/**
	* Sets the collection head last name of this d2 collection.
	*
	* @param collectionHeadLastName the collection head last name of this d2 collection
	*/
	@Override
	public void setCollectionHeadLastName(
		java.lang.String collectionHeadLastName) {
		_d2Collection.setCollectionHeadLastName(collectionHeadLastName);
	}

	/**
	* Returns the collection head role of this d2 collection.
	*
	* @return the collection head role of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionHeadRole() {
		return _d2Collection.getCollectionHeadRole();
	}

	/**
	* Sets the collection head role of this d2 collection.
	*
	* @param collectionHeadRole the collection head role of this d2 collection
	*/
	@Override
	public void setCollectionHeadRole(java.lang.String collectionHeadRole) {
		_d2Collection.setCollectionHeadRole(collectionHeadRole);
	}

	/**
	* Returns the collection sample access fee of this d2 collection.
	*
	* @return the collection sample access fee of this d2 collection
	*/
	@Override
	public boolean getCollectionSampleAccessFee() {
		return _d2Collection.getCollectionSampleAccessFee();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection sample access fee.
	*
	* @return <code>true</code> if this d2 collection is collection sample access fee; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionSampleAccessFee() {
		return _d2Collection.isCollectionSampleAccessFee();
	}

	/**
	* Sets whether this d2 collection is collection sample access fee.
	*
	* @param collectionSampleAccessFee the collection sample access fee of this d2 collection
	*/
	@Override
	public void setCollectionSampleAccessFee(boolean collectionSampleAccessFee) {
		_d2Collection.setCollectionSampleAccessFee(collectionSampleAccessFee);
	}

	/**
	* Returns the collection sample access joint projects of this d2 collection.
	*
	* @return the collection sample access joint projects of this d2 collection
	*/
	@Override
	public boolean getCollectionSampleAccessJointProjects() {
		return _d2Collection.getCollectionSampleAccessJointProjects();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection sample access joint projects.
	*
	* @return <code>true</code> if this d2 collection is collection sample access joint projects; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionSampleAccessJointProjects() {
		return _d2Collection.isCollectionSampleAccessJointProjects();
	}

	/**
	* Sets whether this d2 collection is collection sample access joint projects.
	*
	* @param collectionSampleAccessJointProjects the collection sample access joint projects of this d2 collection
	*/
	@Override
	public void setCollectionSampleAccessJointProjects(
		boolean collectionSampleAccessJointProjects) {
		_d2Collection.setCollectionSampleAccessJointProjects(collectionSampleAccessJointProjects);
	}

	/**
	* Returns the collection sample access description of this d2 collection.
	*
	* @return the collection sample access description of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionSampleAccessDescription() {
		return _d2Collection.getCollectionSampleAccessDescription();
	}

	/**
	* Sets the collection sample access description of this d2 collection.
	*
	* @param collectionSampleAccessDescription the collection sample access description of this d2 collection
	*/
	@Override
	public void setCollectionSampleAccessDescription(
		java.lang.String collectionSampleAccessDescription) {
		_d2Collection.setCollectionSampleAccessDescription(collectionSampleAccessDescription);
	}

	/**
	* Returns the collection sample access u r i of this d2 collection.
	*
	* @return the collection sample access u r i of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionSampleAccessURI() {
		return _d2Collection.getCollectionSampleAccessURI();
	}

	/**
	* Sets the collection sample access u r i of this d2 collection.
	*
	* @param collectionSampleAccessURI the collection sample access u r i of this d2 collection
	*/
	@Override
	public void setCollectionSampleAccessURI(
		java.lang.String collectionSampleAccessURI) {
		_d2Collection.setCollectionSampleAccessURI(collectionSampleAccessURI);
	}

	/**
	* Returns the collection data access fee of this d2 collection.
	*
	* @return the collection data access fee of this d2 collection
	*/
	@Override
	public boolean getCollectionDataAccessFee() {
		return _d2Collection.getCollectionDataAccessFee();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection data access fee.
	*
	* @return <code>true</code> if this d2 collection is collection data access fee; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionDataAccessFee() {
		return _d2Collection.isCollectionDataAccessFee();
	}

	/**
	* Sets whether this d2 collection is collection data access fee.
	*
	* @param collectionDataAccessFee the collection data access fee of this d2 collection
	*/
	@Override
	public void setCollectionDataAccessFee(boolean collectionDataAccessFee) {
		_d2Collection.setCollectionDataAccessFee(collectionDataAccessFee);
	}

	/**
	* Returns the collection data access joint projects of this d2 collection.
	*
	* @return the collection data access joint projects of this d2 collection
	*/
	@Override
	public boolean getCollectionDataAccessJointProjects() {
		return _d2Collection.getCollectionDataAccessJointProjects();
	}

	/**
	* Returns <code>true</code> if this d2 collection is collection data access joint projects.
	*
	* @return <code>true</code> if this d2 collection is collection data access joint projects; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollectionDataAccessJointProjects() {
		return _d2Collection.isCollectionDataAccessJointProjects();
	}

	/**
	* Sets whether this d2 collection is collection data access joint projects.
	*
	* @param collectionDataAccessJointProjects the collection data access joint projects of this d2 collection
	*/
	@Override
	public void setCollectionDataAccessJointProjects(
		boolean collectionDataAccessJointProjects) {
		_d2Collection.setCollectionDataAccessJointProjects(collectionDataAccessJointProjects);
	}

	/**
	* Returns the collection data access description of this d2 collection.
	*
	* @return the collection data access description of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionDataAccessDescription() {
		return _d2Collection.getCollectionDataAccessDescription();
	}

	/**
	* Sets the collection data access description of this d2 collection.
	*
	* @param collectionDataAccessDescription the collection data access description of this d2 collection
	*/
	@Override
	public void setCollectionDataAccessDescription(
		java.lang.String collectionDataAccessDescription) {
		_d2Collection.setCollectionDataAccessDescription(collectionDataAccessDescription);
	}

	/**
	* Returns the collection data access u r i of this d2 collection.
	*
	* @return the collection data access u r i of this d2 collection
	*/
	@Override
	public java.lang.String getCollectionDataAccessURI() {
		return _d2Collection.getCollectionDataAccessURI();
	}

	/**
	* Sets the collection data access u r i of this d2 collection.
	*
	* @param collectionDataAccessURI the collection data access u r i of this d2 collection
	*/
	@Override
	public void setCollectionDataAccessURI(
		java.lang.String collectionDataAccessURI) {
		_d2Collection.setCollectionDataAccessURI(collectionDataAccessURI);
	}

	/**
	* Returns the collection size of this d2 collection.
	*
	* @return the collection size of this d2 collection
	*/
	@Override
	public long getCollectionSize() {
		return _d2Collection.getCollectionSize();
	}

	/**
	* Sets the collection size of this d2 collection.
	*
	* @param collectionSize the collection size of this d2 collection
	*/
	@Override
	public void setCollectionSize(long collectionSize) {
		_d2Collection.setCollectionSize(collectionSize);
	}

	/**
	* Returns the collection size timestamp of this d2 collection.
	*
	* @return the collection size timestamp of this d2 collection
	*/
	@Override
	public long getCollectionSizeTimestamp() {
		return _d2Collection.getCollectionSizeTimestamp();
	}

	/**
	* Sets the collection size timestamp of this d2 collection.
	*
	* @param collectionSizeTimestamp the collection size timestamp of this d2 collection
	*/
	@Override
	public void setCollectionSizeTimestamp(long collectionSizeTimestamp) {
		_d2Collection.setCollectionSizeTimestamp(collectionSizeTimestamp);
	}

	@Override
	public boolean isNew() {
		return _d2Collection.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_d2Collection.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _d2Collection.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_d2Collection.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _d2Collection.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _d2Collection.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_d2Collection.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _d2Collection.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_d2Collection.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_d2Collection.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_d2Collection.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new D2CollectionWrapper((D2Collection)_d2Collection.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2Collection) {
		return _d2Collection.compareTo(d2Collection);
	}

	@Override
	public int hashCode() {
		return _d2Collection.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> toCacheModel() {
		return _d2Collection.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection toEscapedModel() {
		return new D2CollectionWrapper(_d2Collection.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection toUnescapedModel() {
		return new D2CollectionWrapper(_d2Collection.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _d2Collection.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _d2Collection.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_d2Collection.persist();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformation() {
		return _d2Collection.getContactInformation();
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getChildD2Collection() {
		return _d2Collection.getChildD2Collection();
	}

	@Override
	public java.lang.String getChildD2CollectionAuiTreeStructure() {
		return _d2Collection.getChildD2CollectionAuiTreeStructure();
	}

	@Override
	public java.lang.String getCollectionTypeHTML() {
		return _d2Collection.getCollectionTypeHTML();
	}

	@Override
	public java.lang.String getCollectionTemeratureHTML() {
		return _d2Collection.getCollectionTemeratureHTML();
	}

	@Override
	public java.lang.String getCollectionDataAvailableHTML() {
		return _d2Collection.getCollectionDataAvailableHTML();
	}

	@Override
	public java.lang.String getCollectionMaterialTypeHTML() {
		return _d2Collection.getCollectionMaterialTypeHTML();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof D2CollectionWrapper)) {
			return false;
		}

		D2CollectionWrapper d2CollectionWrapper = (D2CollectionWrapper)obj;

		if (Validator.equals(_d2Collection, d2CollectionWrapper._d2Collection)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _d2Collection.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public D2Collection getWrappedD2Collection() {
		return _d2Collection;
	}

	@Override
	public D2Collection getWrappedModel() {
		return _d2Collection;
	}

	@Override
	public void resetOriginalValues() {
		_d2Collection.resetOriginalValues();
	}

	private D2Collection _d2Collection;
}