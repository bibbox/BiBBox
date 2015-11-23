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

import at.meduni.liferay.portlet.bbmrieric.service.ClpSerializer;
import at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class D2CollectionClp extends BaseModelImpl<D2Collection>
	implements D2Collection {
	public D2CollectionClp() {
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
	public long getPrimaryKey() {
		return _d2collectionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setD2collectionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _d2collectionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_d2CollectionRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getD2collectionId() {
		return _d2collectionId;
	}

	@Override
	public void setD2collectionId(long d2collectionId) {
		_d2collectionId = d2collectionId;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setD2collectionId", long.class);

				method.invoke(_d2CollectionRemoteModel, d2collectionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBiobankId() {
		return _biobankId;
	}

	@Override
	public void setBiobankId(long biobankId) {
		_biobankId = biobankId;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankId", long.class);

				method.invoke(_d2CollectionRemoteModel, biobankId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentd2collectionId() {
		return _parentd2collectionId;
	}

	@Override
	public void setParentd2collectionId(long parentd2collectionId) {
		_parentd2collectionId = parentd2collectionId;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setParentd2collectionId",
						long.class);

				method.invoke(_d2CollectionRemoteModel, parentd2collectionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_d2CollectionRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_d2CollectionRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_d2CollectionRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_d2CollectionRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_d2CollectionRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_d2CollectionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUpdateuuid() {
		return _updateuuid;
	}

	@Override
	public void setUpdateuuid(String updateuuid) {
		_updateuuid = updateuuid;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateuuid", String.class);

				method.invoke(_d2CollectionRemoteModel, updateuuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBbmricollectionID() {
		return _bbmricollectionID;
	}

	@Override
	public void setBbmricollectionID(String bbmricollectionID) {
		_bbmricollectionID = bbmricollectionID;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setBbmricollectionID",
						String.class);

				method.invoke(_d2CollectionRemoteModel, bbmricollectionID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBbmriparentcollectionID() {
		return _bbmriparentcollectionID;
	}

	@Override
	public void setBbmriparentcollectionID(String bbmriparentcollectionID) {
		_bbmriparentcollectionID = bbmriparentcollectionID;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setBbmriparentcollectionID",
						String.class);

				method.invoke(_d2CollectionRemoteModel, bbmriparentcollectionID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBbmribiobankID() {
		return _bbmribiobankID;
	}

	@Override
	public void setBbmribiobankID(String bbmribiobankID) {
		_bbmribiobankID = bbmribiobankID;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setBbmribiobankID",
						String.class);

				method.invoke(_d2CollectionRemoteModel, bbmribiobankID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionName() {
		return _collectionName;
	}

	@Override
	public void setCollectionName(String collectionName) {
		_collectionName = collectionName;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionName",
						String.class);

				method.invoke(_d2CollectionRemoteModel, collectionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialStoredDNA() {
		return _materialStoredDNA;
	}

	@Override
	public boolean isMaterialStoredDNA() {
		return _materialStoredDNA;
	}

	@Override
	public void setMaterialStoredDNA(boolean materialStoredDNA) {
		_materialStoredDNA = materialStoredDNA;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredDNA",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, materialStoredDNA);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialStoredPlasma() {
		return _materialStoredPlasma;
	}

	@Override
	public boolean isMaterialStoredPlasma() {
		return _materialStoredPlasma;
	}

	@Override
	public void setMaterialStoredPlasma(boolean materialStoredPlasma) {
		_materialStoredPlasma = materialStoredPlasma;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredPlasma",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, materialStoredPlasma);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialStoredSerum() {
		return _materialStoredSerum;
	}

	@Override
	public boolean isMaterialStoredSerum() {
		return _materialStoredSerum;
	}

	@Override
	public void setMaterialStoredSerum(boolean materialStoredSerum) {
		_materialStoredSerum = materialStoredSerum;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredSerum",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, materialStoredSerum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialStoredUrine() {
		return _materialStoredUrine;
	}

	@Override
	public boolean isMaterialStoredUrine() {
		return _materialStoredUrine;
	}

	@Override
	public void setMaterialStoredUrine(boolean materialStoredUrine) {
		_materialStoredUrine = materialStoredUrine;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredUrine",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, materialStoredUrine);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialStoredSaliva() {
		return _materialStoredSaliva;
	}

	@Override
	public boolean isMaterialStoredSaliva() {
		return _materialStoredSaliva;
	}

	@Override
	public void setMaterialStoredSaliva(boolean materialStoredSaliva) {
		_materialStoredSaliva = materialStoredSaliva;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredSaliva",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, materialStoredSaliva);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialStoredFaeces() {
		return _materialStoredFaeces;
	}

	@Override
	public boolean isMaterialStoredFaeces() {
		return _materialStoredFaeces;
	}

	@Override
	public void setMaterialStoredFaeces(boolean materialStoredFaeces) {
		_materialStoredFaeces = materialStoredFaeces;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredFaeces",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, materialStoredFaeces);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialStoredRNA() {
		return _materialStoredRNA;
	}

	@Override
	public boolean isMaterialStoredRNA() {
		return _materialStoredRNA;
	}

	@Override
	public void setMaterialStoredRNA(boolean materialStoredRNA) {
		_materialStoredRNA = materialStoredRNA;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredRNA",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, materialStoredRNA);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialStoredBlood() {
		return _materialStoredBlood;
	}

	@Override
	public boolean isMaterialStoredBlood() {
		return _materialStoredBlood;
	}

	@Override
	public void setMaterialStoredBlood(boolean materialStoredBlood) {
		_materialStoredBlood = materialStoredBlood;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredBlood",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, materialStoredBlood);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialStoredTissueFrozen() {
		return _materialStoredTissueFrozen;
	}

	@Override
	public boolean isMaterialStoredTissueFrozen() {
		return _materialStoredTissueFrozen;
	}

	@Override
	public void setMaterialStoredTissueFrozen(
		boolean materialStoredTissueFrozen) {
		_materialStoredTissueFrozen = materialStoredTissueFrozen;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredTissueFrozen",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					materialStoredTissueFrozen);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialStoredTissueFFPE() {
		return _materialStoredTissueFFPE;
	}

	@Override
	public boolean isMaterialStoredTissueFFPE() {
		return _materialStoredTissueFFPE;
	}

	@Override
	public void setMaterialStoredTissueFFPE(boolean materialStoredTissueFFPE) {
		_materialStoredTissueFFPE = materialStoredTissueFFPE;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredTissueFFPE",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, materialStoredTissueFFPE);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialStoredImmortalizedCellLines() {
		return _materialStoredImmortalizedCellLines;
	}

	@Override
	public boolean isMaterialStoredImmortalizedCellLines() {
		return _materialStoredImmortalizedCellLines;
	}

	@Override
	public void setMaterialStoredImmortalizedCellLines(
		boolean materialStoredImmortalizedCellLines) {
		_materialStoredImmortalizedCellLines = materialStoredImmortalizedCellLines;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredImmortalizedCellLines",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					materialStoredImmortalizedCellLines);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialStoredIsolatedPathogen() {
		return _materialStoredIsolatedPathogen;
	}

	@Override
	public boolean isMaterialStoredIsolatedPathogen() {
		return _materialStoredIsolatedPathogen;
	}

	@Override
	public void setMaterialStoredIsolatedPathogen(
		boolean materialStoredIsolatedPathogen) {
		_materialStoredIsolatedPathogen = materialStoredIsolatedPathogen;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredIsolatedPathogen",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					materialStoredIsolatedPathogen);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaterialStoredOther() {
		return _materialStoredOther;
	}

	@Override
	public void setMaterialStoredOther(String materialStoredOther) {
		_materialStoredOther = materialStoredOther;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialStoredOther",
						String.class);

				method.invoke(_d2CollectionRemoteModel, materialStoredOther);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionTypeCaseControl() {
		return _collectionTypeCaseControl;
	}

	@Override
	public boolean isCollectionTypeCaseControl() {
		return _collectionTypeCaseControl;
	}

	@Override
	public void setCollectionTypeCaseControl(boolean collectionTypeCaseControl) {
		_collectionTypeCaseControl = collectionTypeCaseControl;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionTypeCaseControl",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionTypeCaseControl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionTypeCohort() {
		return _collectionTypeCohort;
	}

	@Override
	public boolean isCollectionTypeCohort() {
		return _collectionTypeCohort;
	}

	@Override
	public void setCollectionTypeCohort(boolean collectionTypeCohort) {
		_collectionTypeCohort = collectionTypeCohort;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionTypeCohort",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, collectionTypeCohort);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionTypeCrossSectional() {
		return _collectionTypeCrossSectional;
	}

	@Override
	public boolean isCollectionTypeCrossSectional() {
		return _collectionTypeCrossSectional;
	}

	@Override
	public void setCollectionTypeCrossSectional(
		boolean collectionTypeCrossSectional) {
		_collectionTypeCrossSectional = collectionTypeCrossSectional;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionTypeCrossSectional",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionTypeCrossSectional);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionTypeLongitudinal() {
		return _collectionTypeLongitudinal;
	}

	@Override
	public boolean isCollectionTypeLongitudinal() {
		return _collectionTypeLongitudinal;
	}

	@Override
	public void setCollectionTypeLongitudinal(
		boolean collectionTypeLongitudinal) {
		_collectionTypeLongitudinal = collectionTypeLongitudinal;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionTypeLongitudinal",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionTypeLongitudinal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionTypeTwinStudy() {
		return _collectionTypeTwinStudy;
	}

	@Override
	public boolean isCollectionTypeTwinStudy() {
		return _collectionTypeTwinStudy;
	}

	@Override
	public void setCollectionTypeTwinStudy(boolean collectionTypeTwinStudy) {
		_collectionTypeTwinStudy = collectionTypeTwinStudy;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionTypeTwinStudy",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, collectionTypeTwinStudy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionTypeQualityControl() {
		return _collectionTypeQualityControl;
	}

	@Override
	public boolean isCollectionTypeQualityControl() {
		return _collectionTypeQualityControl;
	}

	@Override
	public void setCollectionTypeQualityControl(
		boolean collectionTypeQualityControl) {
		_collectionTypeQualityControl = collectionTypeQualityControl;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionTypeQualityControl",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionTypeQualityControl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionTypePopulationBased() {
		return _collectionTypePopulationBased;
	}

	@Override
	public boolean isCollectionTypePopulationBased() {
		return _collectionTypePopulationBased;
	}

	@Override
	public void setCollectionTypePopulationBased(
		boolean collectionTypePopulationBased) {
		_collectionTypePopulationBased = collectionTypePopulationBased;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionTypePopulationBased",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionTypePopulationBased);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionTypeDiseaseSpecific() {
		return _collectionTypeDiseaseSpecific;
	}

	@Override
	public boolean isCollectionTypeDiseaseSpecific() {
		return _collectionTypeDiseaseSpecific;
	}

	@Override
	public void setCollectionTypeDiseaseSpecific(
		boolean collectionTypeDiseaseSpecific) {
		_collectionTypeDiseaseSpecific = collectionTypeDiseaseSpecific;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionTypeDiseaseSpecific",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionTypeDiseaseSpecific);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionTypeBirthCohort() {
		return _collectionTypeBirthCohort;
	}

	@Override
	public boolean isCollectionTypeBirthCohort() {
		return _collectionTypeBirthCohort;
	}

	@Override
	public void setCollectionTypeBirthCohort(boolean collectionTypeBirthCohort) {
		_collectionTypeBirthCohort = collectionTypeBirthCohort;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionTypeBirthCohort",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionTypeBirthCohort);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionTypeOther() {
		return _collectionTypeOther;
	}

	@Override
	public void setCollectionTypeOther(String collectionTypeOther) {
		_collectionTypeOther = collectionTypeOther;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionTypeOther",
						String.class);

				method.invoke(_d2CollectionRemoteModel, collectionTypeOther);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCollectionOrderOfMagnitude() {
		return _collectionOrderOfMagnitude;
	}

	@Override
	public void setCollectionOrderOfMagnitude(long collectionOrderOfMagnitude) {
		_collectionOrderOfMagnitude = collectionOrderOfMagnitude;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionOrderOfMagnitude",
						long.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionOrderOfMagnitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBioresourceReference() {
		return _bioresourceReference;
	}

	@Override
	public void setBioresourceReference(String bioresourceReference) {
		_bioresourceReference = bioresourceReference;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setBioresourceReference",
						String.class);

				method.invoke(_d2CollectionRemoteModel, bioresourceReference);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactIDRef() {
		return _contactIDRef;
	}

	@Override
	public void setContactIDRef(String contactIDRef) {
		_contactIDRef = contactIDRef;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setContactIDRef", String.class);

				method.invoke(_d2CollectionRemoteModel, contactIDRef);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactPriority() {
		return _contactPriority;
	}

	@Override
	public void setContactPriority(long contactPriority) {
		_contactPriority = contactPriority;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setContactPriority", long.class);

				method.invoke(_d2CollectionRemoteModel, contactPriority);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankNetworkIDRef() {
		return _biobankNetworkIDRef;
	}

	@Override
	public void setBiobankNetworkIDRef(String biobankNetworkIDRef) {
		_biobankNetworkIDRef = biobankNetworkIDRef;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkIDRef",
						String.class);

				method.invoke(_d2CollectionRemoteModel, biobankNetworkIDRef);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGeoLatitude() {
		return _geoLatitude;
	}

	@Override
	public void setGeoLatitude(String geoLatitude) {
		_geoLatitude = geoLatitude;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setGeoLatitude", String.class);

				method.invoke(_d2CollectionRemoteModel, geoLatitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGeoLongitude() {
		return _geoLongitude;
	}

	@Override
	public void setGeoLongitude(String geoLongitude) {
		_geoLongitude = geoLongitude;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setGeoLongitude", String.class);

				method.invoke(_d2CollectionRemoteModel, geoLongitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollaborationPartnersCommercial() {
		return _collaborationPartnersCommercial;
	}

	@Override
	public boolean isCollaborationPartnersCommercial() {
		return _collaborationPartnersCommercial;
	}

	@Override
	public void setCollaborationPartnersCommercial(
		boolean collaborationPartnersCommercial) {
		_collaborationPartnersCommercial = collaborationPartnersCommercial;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollaborationPartnersCommercial",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collaborationPartnersCommercial);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollaborationPartnersNonforprofit() {
		return _collaborationPartnersNonforprofit;
	}

	@Override
	public boolean isCollaborationPartnersNonforprofit() {
		return _collaborationPartnersNonforprofit;
	}

	@Override
	public void setCollaborationPartnersNonforprofit(
		boolean collaborationPartnersNonforprofit) {
		_collaborationPartnersNonforprofit = collaborationPartnersNonforprofit;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollaborationPartnersNonforprofit",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collaborationPartnersNonforprofit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionAcronym() {
		return _collectionAcronym;
	}

	@Override
	public void setCollectionAcronym(String collectionAcronym) {
		_collectionAcronym = collectionAcronym;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionAcronym",
						String.class);

				method.invoke(_d2CollectionRemoteModel, collectionAcronym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionDescription() {
		return _collectionDescription;
	}

	@Override
	public void setCollectionDescription(String collectionDescription) {
		_collectionDescription = collectionDescription;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionDescription",
						String.class);

				method.invoke(_d2CollectionRemoteModel, collectionDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionSexMale() {
		return _collectionSexMale;
	}

	@Override
	public boolean isCollectionSexMale() {
		return _collectionSexMale;
	}

	@Override
	public void setCollectionSexMale(boolean collectionSexMale) {
		_collectionSexMale = collectionSexMale;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionSexMale",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, collectionSexMale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionSexFemale() {
		return _collectionSexFemale;
	}

	@Override
	public boolean isCollectionSexFemale() {
		return _collectionSexFemale;
	}

	@Override
	public void setCollectionSexFemale(boolean collectionSexFemale) {
		_collectionSexFemale = collectionSexFemale;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionSexFemale",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, collectionSexFemale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionSexUnknown() {
		return _collectionSexUnknown;
	}

	@Override
	public boolean isCollectionSexUnknown() {
		return _collectionSexUnknown;
	}

	@Override
	public void setCollectionSexUnknown(boolean collectionSexUnknown) {
		_collectionSexUnknown = collectionSexUnknown;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionSexUnknown",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, collectionSexUnknown);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionSexUndiferrentiated() {
		return _collectionSexUndiferrentiated;
	}

	@Override
	public boolean isCollectionSexUndiferrentiated() {
		return _collectionSexUndiferrentiated;
	}

	@Override
	public void setCollectionSexUndiferrentiated(
		boolean collectionSexUndiferrentiated) {
		_collectionSexUndiferrentiated = collectionSexUndiferrentiated;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionSexUndiferrentiated",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionSexUndiferrentiated);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCollectionAgeLow() {
		return _collectionAgeLow;
	}

	@Override
	public void setCollectionAgeLow(long collectionAgeLow) {
		_collectionAgeLow = collectionAgeLow;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionAgeLow",
						long.class);

				method.invoke(_d2CollectionRemoteModel, collectionAgeLow);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCollectionAgeHigh() {
		return _collectionAgeHigh;
	}

	@Override
	public void setCollectionAgeHigh(long collectionAgeHigh) {
		_collectionAgeHigh = collectionAgeHigh;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionAgeHigh",
						long.class);

				method.invoke(_d2CollectionRemoteModel, collectionAgeHigh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionAgeUnit() {
		return _collectionAgeUnit;
	}

	@Override
	public void setCollectionAgeUnit(String collectionAgeUnit) {
		_collectionAgeUnit = collectionAgeUnit;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionAgeUnit",
						String.class);

				method.invoke(_d2CollectionRemoteModel, collectionAgeUnit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionAvailableBiologicalSamples() {
		return _collectionAvailableBiologicalSamples;
	}

	@Override
	public boolean isCollectionAvailableBiologicalSamples() {
		return _collectionAvailableBiologicalSamples;
	}

	@Override
	public void setCollectionAvailableBiologicalSamples(
		boolean collectionAvailableBiologicalSamples) {
		_collectionAvailableBiologicalSamples = collectionAvailableBiologicalSamples;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionAvailableBiologicalSamples",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionAvailableBiologicalSamples);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionAvailableSurveyData() {
		return _collectionAvailableSurveyData;
	}

	@Override
	public boolean isCollectionAvailableSurveyData() {
		return _collectionAvailableSurveyData;
	}

	@Override
	public void setCollectionAvailableSurveyData(
		boolean collectionAvailableSurveyData) {
		_collectionAvailableSurveyData = collectionAvailableSurveyData;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionAvailableSurveyData",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionAvailableSurveyData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionAvailableImagingData() {
		return _collectionAvailableImagingData;
	}

	@Override
	public boolean isCollectionAvailableImagingData() {
		return _collectionAvailableImagingData;
	}

	@Override
	public void setCollectionAvailableImagingData(
		boolean collectionAvailableImagingData) {
		_collectionAvailableImagingData = collectionAvailableImagingData;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionAvailableImagingData",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionAvailableImagingData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionAvailableMedicalRecords() {
		return _collectionAvailableMedicalRecords;
	}

	@Override
	public boolean isCollectionAvailableMedicalRecords() {
		return _collectionAvailableMedicalRecords;
	}

	@Override
	public void setCollectionAvailableMedicalRecords(
		boolean collectionAvailableMedicalRecords) {
		_collectionAvailableMedicalRecords = collectionAvailableMedicalRecords;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionAvailableMedicalRecords",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionAvailableMedicalRecords);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionAvailableNationalRegistries() {
		return _collectionAvailableNationalRegistries;
	}

	@Override
	public boolean isCollectionAvailableNationalRegistries() {
		return _collectionAvailableNationalRegistries;
	}

	@Override
	public void setCollectionAvailableNationalRegistries(
		boolean collectionAvailableNationalRegistries) {
		_collectionAvailableNationalRegistries = collectionAvailableNationalRegistries;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionAvailableNationalRegistries",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionAvailableNationalRegistries);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionAvailableGenealogicalRecords() {
		return _collectionAvailableGenealogicalRecords;
	}

	@Override
	public boolean isCollectionAvailableGenealogicalRecords() {
		return _collectionAvailableGenealogicalRecords;
	}

	@Override
	public void setCollectionAvailableGenealogicalRecords(
		boolean collectionAvailableGenealogicalRecords) {
		_collectionAvailableGenealogicalRecords = collectionAvailableGenealogicalRecords;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionAvailableGenealogicalRecords",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionAvailableGenealogicalRecords);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionAvailablePhysioBiochemMeasurements() {
		return _collectionAvailablePhysioBiochemMeasurements;
	}

	@Override
	public boolean isCollectionAvailablePhysioBiochemMeasurements() {
		return _collectionAvailablePhysioBiochemMeasurements;
	}

	@Override
	public void setCollectionAvailablePhysioBiochemMeasurements(
		boolean collectionAvailablePhysioBiochemMeasurements) {
		_collectionAvailablePhysioBiochemMeasurements = collectionAvailablePhysioBiochemMeasurements;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionAvailablePhysioBiochemMeasurements",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionAvailablePhysioBiochemMeasurements);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionAvailableOther() {
		return _collectionAvailableOther;
	}

	@Override
	public void setCollectionAvailableOther(String collectionAvailableOther) {
		_collectionAvailableOther = collectionAvailableOther;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionAvailableOther",
						String.class);

				method.invoke(_d2CollectionRemoteModel, collectionAvailableOther);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTemperatureRoom() {
		return _temperatureRoom;
	}

	@Override
	public boolean isTemperatureRoom() {
		return _temperatureRoom;
	}

	@Override
	public void setTemperatureRoom(boolean temperatureRoom) {
		_temperatureRoom = temperatureRoom;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setTemperatureRoom",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, temperatureRoom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTemperature2to10() {
		return _temperature2to10;
	}

	@Override
	public boolean isTemperature2to10() {
		return _temperature2to10;
	}

	@Override
	public void setTemperature2to10(boolean temperature2to10) {
		_temperature2to10 = temperature2to10;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setTemperature2to10",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, temperature2to10);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTemperature18to35() {
		return _temperature18to35;
	}

	@Override
	public boolean isTemperature18to35() {
		return _temperature18to35;
	}

	@Override
	public void setTemperature18to35(boolean temperature18to35) {
		_temperature18to35 = temperature18to35;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setTemperature18to35",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, temperature18to35);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTemperature60to85() {
		return _temperature60to85;
	}

	@Override
	public boolean isTemperature60to85() {
		return _temperature60to85;
	}

	@Override
	public void setTemperature60to85(boolean temperature60to85) {
		_temperature60to85 = temperature60to85;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setTemperature60to85",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, temperature60to85);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTemperatureLN() {
		return _temperatureLN;
	}

	@Override
	public boolean isTemperatureLN() {
		return _temperatureLN;
	}

	@Override
	public void setTemperatureLN(boolean temperatureLN) {
		_temperatureLN = temperatureLN;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setTemperatureLN",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, temperatureLN);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTemperatureOther() {
		return _temperatureOther;
	}

	@Override
	public void setTemperatureOther(String temperatureOther) {
		_temperatureOther = temperatureOther;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setTemperatureOther",
						String.class);

				method.invoke(_d2CollectionRemoteModel, temperatureOther);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiagnosisAvailable() {
		return _diagnosisAvailable;
	}

	@Override
	public void setDiagnosisAvailable(String diagnosisAvailable) {
		_diagnosisAvailable = diagnosisAvailable;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setDiagnosisAvailable",
						String.class);

				method.invoke(_d2CollectionRemoteModel, diagnosisAvailable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionHeadFirstName() {
		return _collectionHeadFirstName;
	}

	@Override
	public void setCollectionHeadFirstName(String collectionHeadFirstName) {
		_collectionHeadFirstName = collectionHeadFirstName;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionHeadFirstName",
						String.class);

				method.invoke(_d2CollectionRemoteModel, collectionHeadFirstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionHeadLastName() {
		return _collectionHeadLastName;
	}

	@Override
	public void setCollectionHeadLastName(String collectionHeadLastName) {
		_collectionHeadLastName = collectionHeadLastName;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionHeadLastName",
						String.class);

				method.invoke(_d2CollectionRemoteModel, collectionHeadLastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionHeadRole() {
		return _collectionHeadRole;
	}

	@Override
	public void setCollectionHeadRole(String collectionHeadRole) {
		_collectionHeadRole = collectionHeadRole;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionHeadRole",
						String.class);

				method.invoke(_d2CollectionRemoteModel, collectionHeadRole);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionSampleAccessFee() {
		return _collectionSampleAccessFee;
	}

	@Override
	public boolean isCollectionSampleAccessFee() {
		return _collectionSampleAccessFee;
	}

	@Override
	public void setCollectionSampleAccessFee(boolean collectionSampleAccessFee) {
		_collectionSampleAccessFee = collectionSampleAccessFee;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionSampleAccessFee",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionSampleAccessFee);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionSampleAccessJointProjects() {
		return _collectionSampleAccessJointProjects;
	}

	@Override
	public boolean isCollectionSampleAccessJointProjects() {
		return _collectionSampleAccessJointProjects;
	}

	@Override
	public void setCollectionSampleAccessJointProjects(
		boolean collectionSampleAccessJointProjects) {
		_collectionSampleAccessJointProjects = collectionSampleAccessJointProjects;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionSampleAccessJointProjects",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionSampleAccessJointProjects);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionSampleAccessDescription() {
		return _collectionSampleAccessDescription;
	}

	@Override
	public void setCollectionSampleAccessDescription(
		String collectionSampleAccessDescription) {
		_collectionSampleAccessDescription = collectionSampleAccessDescription;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionSampleAccessDescription",
						String.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionSampleAccessDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionSampleAccessURI() {
		return _collectionSampleAccessURI;
	}

	@Override
	public void setCollectionSampleAccessURI(String collectionSampleAccessURI) {
		_collectionSampleAccessURI = collectionSampleAccessURI;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionSampleAccessURI",
						String.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionSampleAccessURI);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionDataAccessFee() {
		return _collectionDataAccessFee;
	}

	@Override
	public boolean isCollectionDataAccessFee() {
		return _collectionDataAccessFee;
	}

	@Override
	public void setCollectionDataAccessFee(boolean collectionDataAccessFee) {
		_collectionDataAccessFee = collectionDataAccessFee;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionDataAccessFee",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel, collectionDataAccessFee);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollectionDataAccessJointProjects() {
		return _collectionDataAccessJointProjects;
	}

	@Override
	public boolean isCollectionDataAccessJointProjects() {
		return _collectionDataAccessJointProjects;
	}

	@Override
	public void setCollectionDataAccessJointProjects(
		boolean collectionDataAccessJointProjects) {
		_collectionDataAccessJointProjects = collectionDataAccessJointProjects;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionDataAccessJointProjects",
						boolean.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionDataAccessJointProjects);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionDataAccessDescription() {
		return _collectionDataAccessDescription;
	}

	@Override
	public void setCollectionDataAccessDescription(
		String collectionDataAccessDescription) {
		_collectionDataAccessDescription = collectionDataAccessDescription;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionDataAccessDescription",
						String.class);

				method.invoke(_d2CollectionRemoteModel,
					collectionDataAccessDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCollectionDataAccessURI() {
		return _collectionDataAccessURI;
	}

	@Override
	public void setCollectionDataAccessURI(String collectionDataAccessURI) {
		_collectionDataAccessURI = collectionDataAccessURI;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionDataAccessURI",
						String.class);

				method.invoke(_d2CollectionRemoteModel, collectionDataAccessURI);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCollectionSize() {
		return _collectionSize;
	}

	@Override
	public void setCollectionSize(long collectionSize) {
		_collectionSize = collectionSize;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionSize", long.class);

				method.invoke(_d2CollectionRemoteModel, collectionSize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCollectionSizeTimestamp() {
		return _collectionSizeTimestamp;
	}

	@Override
	public void setCollectionSizeTimestamp(long collectionSizeTimestamp) {
		_collectionSizeTimestamp = collectionSizeTimestamp;

		if (_d2CollectionRemoteModel != null) {
			try {
				Class<?> clazz = _d2CollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setCollectionSizeTimestamp",
						long.class);

				method.invoke(_d2CollectionRemoteModel, collectionSizeTimestamp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getCollectionTypeHTML() {
		try {
			String methodName = "getCollectionTypeHTML";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getCollectionDataAvailableHTML() {
		try {
			String methodName = "getCollectionDataAvailableHTML";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getChildD2CollectionAuiTreeStructure() {
		try {
			String methodName = "getChildD2CollectionAuiTreeStructure";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getChildD2Collection() {
		try {
			String methodName = "getChildD2Collection";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> returnObj =
				(java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformation() {
		try {
			String methodName = "getContactInformation";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			at.meduni.liferay.portlet.bbmrieric.model.ContactInformation returnObj =
				(at.meduni.liferay.portlet.bbmrieric.model.ContactInformation)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getCollectionMaterialTypeHTML() {
		try {
			String methodName = "getCollectionMaterialTypeHTML";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getCollectionTemeratureHTML() {
		try {
			String methodName = "getCollectionTemeratureHTML";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				D2Collection.class.getName()));
	}

	public BaseModel<?> getD2CollectionRemoteModel() {
		return _d2CollectionRemoteModel;
	}

	public void setD2CollectionRemoteModel(BaseModel<?> d2CollectionRemoteModel) {
		_d2CollectionRemoteModel = d2CollectionRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _d2CollectionRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_d2CollectionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			D2CollectionLocalServiceUtil.addD2Collection(this);
		}
		else {
			D2CollectionLocalServiceUtil.updateD2Collection(this);
		}
	}

	@Override
	public D2Collection toEscapedModel() {
		return (D2Collection)ProxyUtil.newProxyInstance(D2Collection.class.getClassLoader(),
			new Class[] { D2Collection.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		D2CollectionClp clone = new D2CollectionClp();

		clone.setUuid(getUuid());
		clone.setD2collectionId(getD2collectionId());
		clone.setBiobankId(getBiobankId());
		clone.setParentd2collectionId(getParentd2collectionId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUpdateuuid(getUpdateuuid());
		clone.setBbmricollectionID(getBbmricollectionID());
		clone.setBbmriparentcollectionID(getBbmriparentcollectionID());
		clone.setBbmribiobankID(getBbmribiobankID());
		clone.setCollectionName(getCollectionName());
		clone.setMaterialStoredDNA(getMaterialStoredDNA());
		clone.setMaterialStoredPlasma(getMaterialStoredPlasma());
		clone.setMaterialStoredSerum(getMaterialStoredSerum());
		clone.setMaterialStoredUrine(getMaterialStoredUrine());
		clone.setMaterialStoredSaliva(getMaterialStoredSaliva());
		clone.setMaterialStoredFaeces(getMaterialStoredFaeces());
		clone.setMaterialStoredRNA(getMaterialStoredRNA());
		clone.setMaterialStoredBlood(getMaterialStoredBlood());
		clone.setMaterialStoredTissueFrozen(getMaterialStoredTissueFrozen());
		clone.setMaterialStoredTissueFFPE(getMaterialStoredTissueFFPE());
		clone.setMaterialStoredImmortalizedCellLines(getMaterialStoredImmortalizedCellLines());
		clone.setMaterialStoredIsolatedPathogen(getMaterialStoredIsolatedPathogen());
		clone.setMaterialStoredOther(getMaterialStoredOther());
		clone.setCollectionTypeCaseControl(getCollectionTypeCaseControl());
		clone.setCollectionTypeCohort(getCollectionTypeCohort());
		clone.setCollectionTypeCrossSectional(getCollectionTypeCrossSectional());
		clone.setCollectionTypeLongitudinal(getCollectionTypeLongitudinal());
		clone.setCollectionTypeTwinStudy(getCollectionTypeTwinStudy());
		clone.setCollectionTypeQualityControl(getCollectionTypeQualityControl());
		clone.setCollectionTypePopulationBased(getCollectionTypePopulationBased());
		clone.setCollectionTypeDiseaseSpecific(getCollectionTypeDiseaseSpecific());
		clone.setCollectionTypeBirthCohort(getCollectionTypeBirthCohort());
		clone.setCollectionTypeOther(getCollectionTypeOther());
		clone.setCollectionOrderOfMagnitude(getCollectionOrderOfMagnitude());
		clone.setBioresourceReference(getBioresourceReference());
		clone.setContactIDRef(getContactIDRef());
		clone.setContactPriority(getContactPriority());
		clone.setBiobankNetworkIDRef(getBiobankNetworkIDRef());
		clone.setGeoLatitude(getGeoLatitude());
		clone.setGeoLongitude(getGeoLongitude());
		clone.setCollaborationPartnersCommercial(getCollaborationPartnersCommercial());
		clone.setCollaborationPartnersNonforprofit(getCollaborationPartnersNonforprofit());
		clone.setCollectionAcronym(getCollectionAcronym());
		clone.setCollectionDescription(getCollectionDescription());
		clone.setCollectionSexMale(getCollectionSexMale());
		clone.setCollectionSexFemale(getCollectionSexFemale());
		clone.setCollectionSexUnknown(getCollectionSexUnknown());
		clone.setCollectionSexUndiferrentiated(getCollectionSexUndiferrentiated());
		clone.setCollectionAgeLow(getCollectionAgeLow());
		clone.setCollectionAgeHigh(getCollectionAgeHigh());
		clone.setCollectionAgeUnit(getCollectionAgeUnit());
		clone.setCollectionAvailableBiologicalSamples(getCollectionAvailableBiologicalSamples());
		clone.setCollectionAvailableSurveyData(getCollectionAvailableSurveyData());
		clone.setCollectionAvailableImagingData(getCollectionAvailableImagingData());
		clone.setCollectionAvailableMedicalRecords(getCollectionAvailableMedicalRecords());
		clone.setCollectionAvailableNationalRegistries(getCollectionAvailableNationalRegistries());
		clone.setCollectionAvailableGenealogicalRecords(getCollectionAvailableGenealogicalRecords());
		clone.setCollectionAvailablePhysioBiochemMeasurements(getCollectionAvailablePhysioBiochemMeasurements());
		clone.setCollectionAvailableOther(getCollectionAvailableOther());
		clone.setTemperatureRoom(getTemperatureRoom());
		clone.setTemperature2to10(getTemperature2to10());
		clone.setTemperature18to35(getTemperature18to35());
		clone.setTemperature60to85(getTemperature60to85());
		clone.setTemperatureLN(getTemperatureLN());
		clone.setTemperatureOther(getTemperatureOther());
		clone.setDiagnosisAvailable(getDiagnosisAvailable());
		clone.setCollectionHeadFirstName(getCollectionHeadFirstName());
		clone.setCollectionHeadLastName(getCollectionHeadLastName());
		clone.setCollectionHeadRole(getCollectionHeadRole());
		clone.setCollectionSampleAccessFee(getCollectionSampleAccessFee());
		clone.setCollectionSampleAccessJointProjects(getCollectionSampleAccessJointProjects());
		clone.setCollectionSampleAccessDescription(getCollectionSampleAccessDescription());
		clone.setCollectionSampleAccessURI(getCollectionSampleAccessURI());
		clone.setCollectionDataAccessFee(getCollectionDataAccessFee());
		clone.setCollectionDataAccessJointProjects(getCollectionDataAccessJointProjects());
		clone.setCollectionDataAccessDescription(getCollectionDataAccessDescription());
		clone.setCollectionDataAccessURI(getCollectionDataAccessURI());
		clone.setCollectionSize(getCollectionSize());
		clone.setCollectionSizeTimestamp(getCollectionSizeTimestamp());

		return clone;
	}

	@Override
	public int compareTo(D2Collection d2Collection) {
		long primaryKey = d2Collection.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof D2CollectionClp)) {
			return false;
		}

		D2CollectionClp d2Collection = (D2CollectionClp)obj;

		long primaryKey = d2Collection.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(169);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", d2collectionId=");
		sb.append(getD2collectionId());
		sb.append(", biobankId=");
		sb.append(getBiobankId());
		sb.append(", parentd2collectionId=");
		sb.append(getParentd2collectionId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", updateuuid=");
		sb.append(getUpdateuuid());
		sb.append(", bbmricollectionID=");
		sb.append(getBbmricollectionID());
		sb.append(", bbmriparentcollectionID=");
		sb.append(getBbmriparentcollectionID());
		sb.append(", bbmribiobankID=");
		sb.append(getBbmribiobankID());
		sb.append(", collectionName=");
		sb.append(getCollectionName());
		sb.append(", materialStoredDNA=");
		sb.append(getMaterialStoredDNA());
		sb.append(", materialStoredPlasma=");
		sb.append(getMaterialStoredPlasma());
		sb.append(", materialStoredSerum=");
		sb.append(getMaterialStoredSerum());
		sb.append(", materialStoredUrine=");
		sb.append(getMaterialStoredUrine());
		sb.append(", materialStoredSaliva=");
		sb.append(getMaterialStoredSaliva());
		sb.append(", materialStoredFaeces=");
		sb.append(getMaterialStoredFaeces());
		sb.append(", materialStoredRNA=");
		sb.append(getMaterialStoredRNA());
		sb.append(", materialStoredBlood=");
		sb.append(getMaterialStoredBlood());
		sb.append(", materialStoredTissueFrozen=");
		sb.append(getMaterialStoredTissueFrozen());
		sb.append(", materialStoredTissueFFPE=");
		sb.append(getMaterialStoredTissueFFPE());
		sb.append(", materialStoredImmortalizedCellLines=");
		sb.append(getMaterialStoredImmortalizedCellLines());
		sb.append(", materialStoredIsolatedPathogen=");
		sb.append(getMaterialStoredIsolatedPathogen());
		sb.append(", materialStoredOther=");
		sb.append(getMaterialStoredOther());
		sb.append(", collectionTypeCaseControl=");
		sb.append(getCollectionTypeCaseControl());
		sb.append(", collectionTypeCohort=");
		sb.append(getCollectionTypeCohort());
		sb.append(", collectionTypeCrossSectional=");
		sb.append(getCollectionTypeCrossSectional());
		sb.append(", collectionTypeLongitudinal=");
		sb.append(getCollectionTypeLongitudinal());
		sb.append(", collectionTypeTwinStudy=");
		sb.append(getCollectionTypeTwinStudy());
		sb.append(", collectionTypeQualityControl=");
		sb.append(getCollectionTypeQualityControl());
		sb.append(", collectionTypePopulationBased=");
		sb.append(getCollectionTypePopulationBased());
		sb.append(", collectionTypeDiseaseSpecific=");
		sb.append(getCollectionTypeDiseaseSpecific());
		sb.append(", collectionTypeBirthCohort=");
		sb.append(getCollectionTypeBirthCohort());
		sb.append(", collectionTypeOther=");
		sb.append(getCollectionTypeOther());
		sb.append(", collectionOrderOfMagnitude=");
		sb.append(getCollectionOrderOfMagnitude());
		sb.append(", bioresourceReference=");
		sb.append(getBioresourceReference());
		sb.append(", contactIDRef=");
		sb.append(getContactIDRef());
		sb.append(", contactPriority=");
		sb.append(getContactPriority());
		sb.append(", biobankNetworkIDRef=");
		sb.append(getBiobankNetworkIDRef());
		sb.append(", geoLatitude=");
		sb.append(getGeoLatitude());
		sb.append(", geoLongitude=");
		sb.append(getGeoLongitude());
		sb.append(", collaborationPartnersCommercial=");
		sb.append(getCollaborationPartnersCommercial());
		sb.append(", collaborationPartnersNonforprofit=");
		sb.append(getCollaborationPartnersNonforprofit());
		sb.append(", collectionAcronym=");
		sb.append(getCollectionAcronym());
		sb.append(", collectionDescription=");
		sb.append(getCollectionDescription());
		sb.append(", collectionSexMale=");
		sb.append(getCollectionSexMale());
		sb.append(", collectionSexFemale=");
		sb.append(getCollectionSexFemale());
		sb.append(", collectionSexUnknown=");
		sb.append(getCollectionSexUnknown());
		sb.append(", collectionSexUndiferrentiated=");
		sb.append(getCollectionSexUndiferrentiated());
		sb.append(", collectionAgeLow=");
		sb.append(getCollectionAgeLow());
		sb.append(", collectionAgeHigh=");
		sb.append(getCollectionAgeHigh());
		sb.append(", collectionAgeUnit=");
		sb.append(getCollectionAgeUnit());
		sb.append(", collectionAvailableBiologicalSamples=");
		sb.append(getCollectionAvailableBiologicalSamples());
		sb.append(", collectionAvailableSurveyData=");
		sb.append(getCollectionAvailableSurveyData());
		sb.append(", collectionAvailableImagingData=");
		sb.append(getCollectionAvailableImagingData());
		sb.append(", collectionAvailableMedicalRecords=");
		sb.append(getCollectionAvailableMedicalRecords());
		sb.append(", collectionAvailableNationalRegistries=");
		sb.append(getCollectionAvailableNationalRegistries());
		sb.append(", collectionAvailableGenealogicalRecords=");
		sb.append(getCollectionAvailableGenealogicalRecords());
		sb.append(", collectionAvailablePhysioBiochemMeasurements=");
		sb.append(getCollectionAvailablePhysioBiochemMeasurements());
		sb.append(", collectionAvailableOther=");
		sb.append(getCollectionAvailableOther());
		sb.append(", temperatureRoom=");
		sb.append(getTemperatureRoom());
		sb.append(", temperature2to10=");
		sb.append(getTemperature2to10());
		sb.append(", temperature18to35=");
		sb.append(getTemperature18to35());
		sb.append(", temperature60to85=");
		sb.append(getTemperature60to85());
		sb.append(", temperatureLN=");
		sb.append(getTemperatureLN());
		sb.append(", temperatureOther=");
		sb.append(getTemperatureOther());
		sb.append(", diagnosisAvailable=");
		sb.append(getDiagnosisAvailable());
		sb.append(", collectionHeadFirstName=");
		sb.append(getCollectionHeadFirstName());
		sb.append(", collectionHeadLastName=");
		sb.append(getCollectionHeadLastName());
		sb.append(", collectionHeadRole=");
		sb.append(getCollectionHeadRole());
		sb.append(", collectionSampleAccessFee=");
		sb.append(getCollectionSampleAccessFee());
		sb.append(", collectionSampleAccessJointProjects=");
		sb.append(getCollectionSampleAccessJointProjects());
		sb.append(", collectionSampleAccessDescription=");
		sb.append(getCollectionSampleAccessDescription());
		sb.append(", collectionSampleAccessURI=");
		sb.append(getCollectionSampleAccessURI());
		sb.append(", collectionDataAccessFee=");
		sb.append(getCollectionDataAccessFee());
		sb.append(", collectionDataAccessJointProjects=");
		sb.append(getCollectionDataAccessJointProjects());
		sb.append(", collectionDataAccessDescription=");
		sb.append(getCollectionDataAccessDescription());
		sb.append(", collectionDataAccessURI=");
		sb.append(getCollectionDataAccessURI());
		sb.append(", collectionSize=");
		sb.append(getCollectionSize());
		sb.append(", collectionSizeTimestamp=");
		sb.append(getCollectionSizeTimestamp());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(256);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.bbmrieric.model.D2Collection");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>d2collectionId</column-name><column-value><![CDATA[");
		sb.append(getD2collectionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankId</column-name><column-value><![CDATA[");
		sb.append(getBiobankId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentd2collectionId</column-name><column-value><![CDATA[");
		sb.append(getParentd2collectionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateuuid</column-name><column-value><![CDATA[");
		sb.append(getUpdateuuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bbmricollectionID</column-name><column-value><![CDATA[");
		sb.append(getBbmricollectionID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bbmriparentcollectionID</column-name><column-value><![CDATA[");
		sb.append(getBbmriparentcollectionID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bbmribiobankID</column-name><column-value><![CDATA[");
		sb.append(getBbmribiobankID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionName</column-name><column-value><![CDATA[");
		sb.append(getCollectionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredDNA</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredDNA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredPlasma</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredPlasma());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredSerum</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredSerum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredUrine</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredUrine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredSaliva</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredSaliva());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredFaeces</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredFaeces());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredRNA</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredRNA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredBlood</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredBlood());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredTissueFrozen</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredTissueFrozen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredTissueFFPE</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredTissueFFPE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredImmortalizedCellLines</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredImmortalizedCellLines());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredIsolatedPathogen</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredIsolatedPathogen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialStoredOther</column-name><column-value><![CDATA[");
		sb.append(getMaterialStoredOther());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionTypeCaseControl</column-name><column-value><![CDATA[");
		sb.append(getCollectionTypeCaseControl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionTypeCohort</column-name><column-value><![CDATA[");
		sb.append(getCollectionTypeCohort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionTypeCrossSectional</column-name><column-value><![CDATA[");
		sb.append(getCollectionTypeCrossSectional());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionTypeLongitudinal</column-name><column-value><![CDATA[");
		sb.append(getCollectionTypeLongitudinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionTypeTwinStudy</column-name><column-value><![CDATA[");
		sb.append(getCollectionTypeTwinStudy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionTypeQualityControl</column-name><column-value><![CDATA[");
		sb.append(getCollectionTypeQualityControl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionTypePopulationBased</column-name><column-value><![CDATA[");
		sb.append(getCollectionTypePopulationBased());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionTypeDiseaseSpecific</column-name><column-value><![CDATA[");
		sb.append(getCollectionTypeDiseaseSpecific());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionTypeBirthCohort</column-name><column-value><![CDATA[");
		sb.append(getCollectionTypeBirthCohort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionTypeOther</column-name><column-value><![CDATA[");
		sb.append(getCollectionTypeOther());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionOrderOfMagnitude</column-name><column-value><![CDATA[");
		sb.append(getCollectionOrderOfMagnitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bioresourceReference</column-name><column-value><![CDATA[");
		sb.append(getBioresourceReference());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactIDRef</column-name><column-value><![CDATA[");
		sb.append(getContactIDRef());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPriority</column-name><column-value><![CDATA[");
		sb.append(getContactPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkIDRef</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkIDRef());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geoLatitude</column-name><column-value><![CDATA[");
		sb.append(getGeoLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geoLongitude</column-name><column-value><![CDATA[");
		sb.append(getGeoLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collaborationPartnersCommercial</column-name><column-value><![CDATA[");
		sb.append(getCollaborationPartnersCommercial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collaborationPartnersNonforprofit</column-name><column-value><![CDATA[");
		sb.append(getCollaborationPartnersNonforprofit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionAcronym</column-name><column-value><![CDATA[");
		sb.append(getCollectionAcronym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionDescription</column-name><column-value><![CDATA[");
		sb.append(getCollectionDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionSexMale</column-name><column-value><![CDATA[");
		sb.append(getCollectionSexMale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionSexFemale</column-name><column-value><![CDATA[");
		sb.append(getCollectionSexFemale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionSexUnknown</column-name><column-value><![CDATA[");
		sb.append(getCollectionSexUnknown());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionSexUndiferrentiated</column-name><column-value><![CDATA[");
		sb.append(getCollectionSexUndiferrentiated());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionAgeLow</column-name><column-value><![CDATA[");
		sb.append(getCollectionAgeLow());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionAgeHigh</column-name><column-value><![CDATA[");
		sb.append(getCollectionAgeHigh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionAgeUnit</column-name><column-value><![CDATA[");
		sb.append(getCollectionAgeUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionAvailableBiologicalSamples</column-name><column-value><![CDATA[");
		sb.append(getCollectionAvailableBiologicalSamples());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionAvailableSurveyData</column-name><column-value><![CDATA[");
		sb.append(getCollectionAvailableSurveyData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionAvailableImagingData</column-name><column-value><![CDATA[");
		sb.append(getCollectionAvailableImagingData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionAvailableMedicalRecords</column-name><column-value><![CDATA[");
		sb.append(getCollectionAvailableMedicalRecords());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionAvailableNationalRegistries</column-name><column-value><![CDATA[");
		sb.append(getCollectionAvailableNationalRegistries());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionAvailableGenealogicalRecords</column-name><column-value><![CDATA[");
		sb.append(getCollectionAvailableGenealogicalRecords());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionAvailablePhysioBiochemMeasurements</column-name><column-value><![CDATA[");
		sb.append(getCollectionAvailablePhysioBiochemMeasurements());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionAvailableOther</column-name><column-value><![CDATA[");
		sb.append(getCollectionAvailableOther());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>temperatureRoom</column-name><column-value><![CDATA[");
		sb.append(getTemperatureRoom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>temperature2to10</column-name><column-value><![CDATA[");
		sb.append(getTemperature2to10());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>temperature18to35</column-name><column-value><![CDATA[");
		sb.append(getTemperature18to35());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>temperature60to85</column-name><column-value><![CDATA[");
		sb.append(getTemperature60to85());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>temperatureLN</column-name><column-value><![CDATA[");
		sb.append(getTemperatureLN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>temperatureOther</column-name><column-value><![CDATA[");
		sb.append(getTemperatureOther());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diagnosisAvailable</column-name><column-value><![CDATA[");
		sb.append(getDiagnosisAvailable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionHeadFirstName</column-name><column-value><![CDATA[");
		sb.append(getCollectionHeadFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionHeadLastName</column-name><column-value><![CDATA[");
		sb.append(getCollectionHeadLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionHeadRole</column-name><column-value><![CDATA[");
		sb.append(getCollectionHeadRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionSampleAccessFee</column-name><column-value><![CDATA[");
		sb.append(getCollectionSampleAccessFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionSampleAccessJointProjects</column-name><column-value><![CDATA[");
		sb.append(getCollectionSampleAccessJointProjects());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionSampleAccessDescription</column-name><column-value><![CDATA[");
		sb.append(getCollectionSampleAccessDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionSampleAccessURI</column-name><column-value><![CDATA[");
		sb.append(getCollectionSampleAccessURI());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionDataAccessFee</column-name><column-value><![CDATA[");
		sb.append(getCollectionDataAccessFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionDataAccessJointProjects</column-name><column-value><![CDATA[");
		sb.append(getCollectionDataAccessJointProjects());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionDataAccessDescription</column-name><column-value><![CDATA[");
		sb.append(getCollectionDataAccessDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionDataAccessURI</column-name><column-value><![CDATA[");
		sb.append(getCollectionDataAccessURI());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionSize</column-name><column-value><![CDATA[");
		sb.append(getCollectionSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionSizeTimestamp</column-name><column-value><![CDATA[");
		sb.append(getCollectionSizeTimestamp());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _d2collectionId;
	private long _biobankId;
	private long _parentd2collectionId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _updateuuid;
	private String _bbmricollectionID;
	private String _bbmriparentcollectionID;
	private String _bbmribiobankID;
	private String _collectionName;
	private boolean _materialStoredDNA;
	private boolean _materialStoredPlasma;
	private boolean _materialStoredSerum;
	private boolean _materialStoredUrine;
	private boolean _materialStoredSaliva;
	private boolean _materialStoredFaeces;
	private boolean _materialStoredRNA;
	private boolean _materialStoredBlood;
	private boolean _materialStoredTissueFrozen;
	private boolean _materialStoredTissueFFPE;
	private boolean _materialStoredImmortalizedCellLines;
	private boolean _materialStoredIsolatedPathogen;
	private String _materialStoredOther;
	private boolean _collectionTypeCaseControl;
	private boolean _collectionTypeCohort;
	private boolean _collectionTypeCrossSectional;
	private boolean _collectionTypeLongitudinal;
	private boolean _collectionTypeTwinStudy;
	private boolean _collectionTypeQualityControl;
	private boolean _collectionTypePopulationBased;
	private boolean _collectionTypeDiseaseSpecific;
	private boolean _collectionTypeBirthCohort;
	private String _collectionTypeOther;
	private long _collectionOrderOfMagnitude;
	private String _bioresourceReference;
	private String _contactIDRef;
	private long _contactPriority;
	private String _biobankNetworkIDRef;
	private String _geoLatitude;
	private String _geoLongitude;
	private boolean _collaborationPartnersCommercial;
	private boolean _collaborationPartnersNonforprofit;
	private String _collectionAcronym;
	private String _collectionDescription;
	private boolean _collectionSexMale;
	private boolean _collectionSexFemale;
	private boolean _collectionSexUnknown;
	private boolean _collectionSexUndiferrentiated;
	private long _collectionAgeLow;
	private long _collectionAgeHigh;
	private String _collectionAgeUnit;
	private boolean _collectionAvailableBiologicalSamples;
	private boolean _collectionAvailableSurveyData;
	private boolean _collectionAvailableImagingData;
	private boolean _collectionAvailableMedicalRecords;
	private boolean _collectionAvailableNationalRegistries;
	private boolean _collectionAvailableGenealogicalRecords;
	private boolean _collectionAvailablePhysioBiochemMeasurements;
	private String _collectionAvailableOther;
	private boolean _temperatureRoom;
	private boolean _temperature2to10;
	private boolean _temperature18to35;
	private boolean _temperature60to85;
	private boolean _temperatureLN;
	private String _temperatureOther;
	private String _diagnosisAvailable;
	private String _collectionHeadFirstName;
	private String _collectionHeadLastName;
	private String _collectionHeadRole;
	private boolean _collectionSampleAccessFee;
	private boolean _collectionSampleAccessJointProjects;
	private String _collectionSampleAccessDescription;
	private String _collectionSampleAccessURI;
	private boolean _collectionDataAccessFee;
	private boolean _collectionDataAccessJointProjects;
	private String _collectionDataAccessDescription;
	private String _collectionDataAccessURI;
	private long _collectionSize;
	private long _collectionSizeTimestamp;
	private BaseModel<?> _d2CollectionRemoteModel;
}