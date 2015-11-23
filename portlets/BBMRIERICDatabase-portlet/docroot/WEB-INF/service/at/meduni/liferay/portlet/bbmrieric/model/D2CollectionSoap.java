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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class D2CollectionSoap implements Serializable {
	public static D2CollectionSoap toSoapModel(D2Collection model) {
		D2CollectionSoap soapModel = new D2CollectionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setD2collectionId(model.getD2collectionId());
		soapModel.setBiobankId(model.getBiobankId());
		soapModel.setParentd2collectionId(model.getParentd2collectionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUpdateuuid(model.getUpdateuuid());
		soapModel.setBbmricollectionID(model.getBbmricollectionID());
		soapModel.setBbmriparentcollectionID(model.getBbmriparentcollectionID());
		soapModel.setBbmribiobankID(model.getBbmribiobankID());
		soapModel.setCollectionName(model.getCollectionName());
		soapModel.setMaterialStoredDNA(model.getMaterialStoredDNA());
		soapModel.setMaterialStoredPlasma(model.getMaterialStoredPlasma());
		soapModel.setMaterialStoredSerum(model.getMaterialStoredSerum());
		soapModel.setMaterialStoredUrine(model.getMaterialStoredUrine());
		soapModel.setMaterialStoredSaliva(model.getMaterialStoredSaliva());
		soapModel.setMaterialStoredFaeces(model.getMaterialStoredFaeces());
		soapModel.setMaterialStoredRNA(model.getMaterialStoredRNA());
		soapModel.setMaterialStoredBlood(model.getMaterialStoredBlood());
		soapModel.setMaterialStoredTissueFrozen(model.getMaterialStoredTissueFrozen());
		soapModel.setMaterialStoredTissueFFPE(model.getMaterialStoredTissueFFPE());
		soapModel.setMaterialStoredImmortalizedCellLines(model.getMaterialStoredImmortalizedCellLines());
		soapModel.setMaterialStoredIsolatedPathogen(model.getMaterialStoredIsolatedPathogen());
		soapModel.setMaterialStoredOther(model.getMaterialStoredOther());
		soapModel.setCollectionTypeCaseControl(model.getCollectionTypeCaseControl());
		soapModel.setCollectionTypeCohort(model.getCollectionTypeCohort());
		soapModel.setCollectionTypeCrossSectional(model.getCollectionTypeCrossSectional());
		soapModel.setCollectionTypeLongitudinal(model.getCollectionTypeLongitudinal());
		soapModel.setCollectionTypeTwinStudy(model.getCollectionTypeTwinStudy());
		soapModel.setCollectionTypeQualityControl(model.getCollectionTypeQualityControl());
		soapModel.setCollectionTypePopulationBased(model.getCollectionTypePopulationBased());
		soapModel.setCollectionTypeDiseaseSpecific(model.getCollectionTypeDiseaseSpecific());
		soapModel.setCollectionTypeBirthCohort(model.getCollectionTypeBirthCohort());
		soapModel.setCollectionTypeOther(model.getCollectionTypeOther());
		soapModel.setCollectionOrderOfMagnitude(model.getCollectionOrderOfMagnitude());
		soapModel.setBioresourceReference(model.getBioresourceReference());
		soapModel.setContactIDRef(model.getContactIDRef());
		soapModel.setContactPriority(model.getContactPriority());
		soapModel.setBiobankNetworkIDRef(model.getBiobankNetworkIDRef());
		soapModel.setGeoLatitude(model.getGeoLatitude());
		soapModel.setGeoLongitude(model.getGeoLongitude());
		soapModel.setCollaborationPartnersCommercial(model.getCollaborationPartnersCommercial());
		soapModel.setCollaborationPartnersNonforprofit(model.getCollaborationPartnersNonforprofit());
		soapModel.setCollectionAcronym(model.getCollectionAcronym());
		soapModel.setCollectionDescription(model.getCollectionDescription());
		soapModel.setCollectionSexMale(model.getCollectionSexMale());
		soapModel.setCollectionSexFemale(model.getCollectionSexFemale());
		soapModel.setCollectionSexUnknown(model.getCollectionSexUnknown());
		soapModel.setCollectionSexUndiferrentiated(model.getCollectionSexUndiferrentiated());
		soapModel.setCollectionAgeLow(model.getCollectionAgeLow());
		soapModel.setCollectionAgeHigh(model.getCollectionAgeHigh());
		soapModel.setCollectionAgeUnit(model.getCollectionAgeUnit());
		soapModel.setCollectionAvailableBiologicalSamples(model.getCollectionAvailableBiologicalSamples());
		soapModel.setCollectionAvailableSurveyData(model.getCollectionAvailableSurveyData());
		soapModel.setCollectionAvailableImagingData(model.getCollectionAvailableImagingData());
		soapModel.setCollectionAvailableMedicalRecords(model.getCollectionAvailableMedicalRecords());
		soapModel.setCollectionAvailableNationalRegistries(model.getCollectionAvailableNationalRegistries());
		soapModel.setCollectionAvailableGenealogicalRecords(model.getCollectionAvailableGenealogicalRecords());
		soapModel.setCollectionAvailablePhysioBiochemMeasurements(model.getCollectionAvailablePhysioBiochemMeasurements());
		soapModel.setCollectionAvailableOther(model.getCollectionAvailableOther());
		soapModel.setTemperatureRoom(model.getTemperatureRoom());
		soapModel.setTemperature2to10(model.getTemperature2to10());
		soapModel.setTemperature18to35(model.getTemperature18to35());
		soapModel.setTemperature60to85(model.getTemperature60to85());
		soapModel.setTemperatureLN(model.getTemperatureLN());
		soapModel.setTemperatureOther(model.getTemperatureOther());
		soapModel.setDiagnosisAvailable(model.getDiagnosisAvailable());
		soapModel.setCollectionHeadFirstName(model.getCollectionHeadFirstName());
		soapModel.setCollectionHeadLastName(model.getCollectionHeadLastName());
		soapModel.setCollectionHeadRole(model.getCollectionHeadRole());
		soapModel.setCollectionSampleAccessFee(model.getCollectionSampleAccessFee());
		soapModel.setCollectionSampleAccessJointProjects(model.getCollectionSampleAccessJointProjects());
		soapModel.setCollectionSampleAccessDescription(model.getCollectionSampleAccessDescription());
		soapModel.setCollectionSampleAccessURI(model.getCollectionSampleAccessURI());
		soapModel.setCollectionDataAccessFee(model.getCollectionDataAccessFee());
		soapModel.setCollectionDataAccessJointProjects(model.getCollectionDataAccessJointProjects());
		soapModel.setCollectionDataAccessDescription(model.getCollectionDataAccessDescription());
		soapModel.setCollectionDataAccessURI(model.getCollectionDataAccessURI());
		soapModel.setCollectionSize(model.getCollectionSize());
		soapModel.setCollectionSizeTimestamp(model.getCollectionSizeTimestamp());

		return soapModel;
	}

	public static D2CollectionSoap[] toSoapModels(D2Collection[] models) {
		D2CollectionSoap[] soapModels = new D2CollectionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static D2CollectionSoap[][] toSoapModels(D2Collection[][] models) {
		D2CollectionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new D2CollectionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new D2CollectionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static D2CollectionSoap[] toSoapModels(List<D2Collection> models) {
		List<D2CollectionSoap> soapModels = new ArrayList<D2CollectionSoap>(models.size());

		for (D2Collection model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new D2CollectionSoap[soapModels.size()]);
	}

	public D2CollectionSoap() {
	}

	public long getPrimaryKey() {
		return _d2collectionId;
	}

	public void setPrimaryKey(long pk) {
		setD2collectionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getD2collectionId() {
		return _d2collectionId;
	}

	public void setD2collectionId(long d2collectionId) {
		_d2collectionId = d2collectionId;
	}

	public long getBiobankId() {
		return _biobankId;
	}

	public void setBiobankId(long biobankId) {
		_biobankId = biobankId;
	}

	public long getParentd2collectionId() {
		return _parentd2collectionId;
	}

	public void setParentd2collectionId(long parentd2collectionId) {
		_parentd2collectionId = parentd2collectionId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getUpdateuuid() {
		return _updateuuid;
	}

	public void setUpdateuuid(String updateuuid) {
		_updateuuid = updateuuid;
	}

	public String getBbmricollectionID() {
		return _bbmricollectionID;
	}

	public void setBbmricollectionID(String bbmricollectionID) {
		_bbmricollectionID = bbmricollectionID;
	}

	public String getBbmriparentcollectionID() {
		return _bbmriparentcollectionID;
	}

	public void setBbmriparentcollectionID(String bbmriparentcollectionID) {
		_bbmriparentcollectionID = bbmriparentcollectionID;
	}

	public String getBbmribiobankID() {
		return _bbmribiobankID;
	}

	public void setBbmribiobankID(String bbmribiobankID) {
		_bbmribiobankID = bbmribiobankID;
	}

	public String getCollectionName() {
		return _collectionName;
	}

	public void setCollectionName(String collectionName) {
		_collectionName = collectionName;
	}

	public boolean getMaterialStoredDNA() {
		return _materialStoredDNA;
	}

	public boolean isMaterialStoredDNA() {
		return _materialStoredDNA;
	}

	public void setMaterialStoredDNA(boolean materialStoredDNA) {
		_materialStoredDNA = materialStoredDNA;
	}

	public boolean getMaterialStoredPlasma() {
		return _materialStoredPlasma;
	}

	public boolean isMaterialStoredPlasma() {
		return _materialStoredPlasma;
	}

	public void setMaterialStoredPlasma(boolean materialStoredPlasma) {
		_materialStoredPlasma = materialStoredPlasma;
	}

	public boolean getMaterialStoredSerum() {
		return _materialStoredSerum;
	}

	public boolean isMaterialStoredSerum() {
		return _materialStoredSerum;
	}

	public void setMaterialStoredSerum(boolean materialStoredSerum) {
		_materialStoredSerum = materialStoredSerum;
	}

	public boolean getMaterialStoredUrine() {
		return _materialStoredUrine;
	}

	public boolean isMaterialStoredUrine() {
		return _materialStoredUrine;
	}

	public void setMaterialStoredUrine(boolean materialStoredUrine) {
		_materialStoredUrine = materialStoredUrine;
	}

	public boolean getMaterialStoredSaliva() {
		return _materialStoredSaliva;
	}

	public boolean isMaterialStoredSaliva() {
		return _materialStoredSaliva;
	}

	public void setMaterialStoredSaliva(boolean materialStoredSaliva) {
		_materialStoredSaliva = materialStoredSaliva;
	}

	public boolean getMaterialStoredFaeces() {
		return _materialStoredFaeces;
	}

	public boolean isMaterialStoredFaeces() {
		return _materialStoredFaeces;
	}

	public void setMaterialStoredFaeces(boolean materialStoredFaeces) {
		_materialStoredFaeces = materialStoredFaeces;
	}

	public boolean getMaterialStoredRNA() {
		return _materialStoredRNA;
	}

	public boolean isMaterialStoredRNA() {
		return _materialStoredRNA;
	}

	public void setMaterialStoredRNA(boolean materialStoredRNA) {
		_materialStoredRNA = materialStoredRNA;
	}

	public boolean getMaterialStoredBlood() {
		return _materialStoredBlood;
	}

	public boolean isMaterialStoredBlood() {
		return _materialStoredBlood;
	}

	public void setMaterialStoredBlood(boolean materialStoredBlood) {
		_materialStoredBlood = materialStoredBlood;
	}

	public boolean getMaterialStoredTissueFrozen() {
		return _materialStoredTissueFrozen;
	}

	public boolean isMaterialStoredTissueFrozen() {
		return _materialStoredTissueFrozen;
	}

	public void setMaterialStoredTissueFrozen(
		boolean materialStoredTissueFrozen) {
		_materialStoredTissueFrozen = materialStoredTissueFrozen;
	}

	public boolean getMaterialStoredTissueFFPE() {
		return _materialStoredTissueFFPE;
	}

	public boolean isMaterialStoredTissueFFPE() {
		return _materialStoredTissueFFPE;
	}

	public void setMaterialStoredTissueFFPE(boolean materialStoredTissueFFPE) {
		_materialStoredTissueFFPE = materialStoredTissueFFPE;
	}

	public boolean getMaterialStoredImmortalizedCellLines() {
		return _materialStoredImmortalizedCellLines;
	}

	public boolean isMaterialStoredImmortalizedCellLines() {
		return _materialStoredImmortalizedCellLines;
	}

	public void setMaterialStoredImmortalizedCellLines(
		boolean materialStoredImmortalizedCellLines) {
		_materialStoredImmortalizedCellLines = materialStoredImmortalizedCellLines;
	}

	public boolean getMaterialStoredIsolatedPathogen() {
		return _materialStoredIsolatedPathogen;
	}

	public boolean isMaterialStoredIsolatedPathogen() {
		return _materialStoredIsolatedPathogen;
	}

	public void setMaterialStoredIsolatedPathogen(
		boolean materialStoredIsolatedPathogen) {
		_materialStoredIsolatedPathogen = materialStoredIsolatedPathogen;
	}

	public String getMaterialStoredOther() {
		return _materialStoredOther;
	}

	public void setMaterialStoredOther(String materialStoredOther) {
		_materialStoredOther = materialStoredOther;
	}

	public boolean getCollectionTypeCaseControl() {
		return _collectionTypeCaseControl;
	}

	public boolean isCollectionTypeCaseControl() {
		return _collectionTypeCaseControl;
	}

	public void setCollectionTypeCaseControl(boolean collectionTypeCaseControl) {
		_collectionTypeCaseControl = collectionTypeCaseControl;
	}

	public boolean getCollectionTypeCohort() {
		return _collectionTypeCohort;
	}

	public boolean isCollectionTypeCohort() {
		return _collectionTypeCohort;
	}

	public void setCollectionTypeCohort(boolean collectionTypeCohort) {
		_collectionTypeCohort = collectionTypeCohort;
	}

	public boolean getCollectionTypeCrossSectional() {
		return _collectionTypeCrossSectional;
	}

	public boolean isCollectionTypeCrossSectional() {
		return _collectionTypeCrossSectional;
	}

	public void setCollectionTypeCrossSectional(
		boolean collectionTypeCrossSectional) {
		_collectionTypeCrossSectional = collectionTypeCrossSectional;
	}

	public boolean getCollectionTypeLongitudinal() {
		return _collectionTypeLongitudinal;
	}

	public boolean isCollectionTypeLongitudinal() {
		return _collectionTypeLongitudinal;
	}

	public void setCollectionTypeLongitudinal(
		boolean collectionTypeLongitudinal) {
		_collectionTypeLongitudinal = collectionTypeLongitudinal;
	}

	public boolean getCollectionTypeTwinStudy() {
		return _collectionTypeTwinStudy;
	}

	public boolean isCollectionTypeTwinStudy() {
		return _collectionTypeTwinStudy;
	}

	public void setCollectionTypeTwinStudy(boolean collectionTypeTwinStudy) {
		_collectionTypeTwinStudy = collectionTypeTwinStudy;
	}

	public boolean getCollectionTypeQualityControl() {
		return _collectionTypeQualityControl;
	}

	public boolean isCollectionTypeQualityControl() {
		return _collectionTypeQualityControl;
	}

	public void setCollectionTypeQualityControl(
		boolean collectionTypeQualityControl) {
		_collectionTypeQualityControl = collectionTypeQualityControl;
	}

	public boolean getCollectionTypePopulationBased() {
		return _collectionTypePopulationBased;
	}

	public boolean isCollectionTypePopulationBased() {
		return _collectionTypePopulationBased;
	}

	public void setCollectionTypePopulationBased(
		boolean collectionTypePopulationBased) {
		_collectionTypePopulationBased = collectionTypePopulationBased;
	}

	public boolean getCollectionTypeDiseaseSpecific() {
		return _collectionTypeDiseaseSpecific;
	}

	public boolean isCollectionTypeDiseaseSpecific() {
		return _collectionTypeDiseaseSpecific;
	}

	public void setCollectionTypeDiseaseSpecific(
		boolean collectionTypeDiseaseSpecific) {
		_collectionTypeDiseaseSpecific = collectionTypeDiseaseSpecific;
	}

	public boolean getCollectionTypeBirthCohort() {
		return _collectionTypeBirthCohort;
	}

	public boolean isCollectionTypeBirthCohort() {
		return _collectionTypeBirthCohort;
	}

	public void setCollectionTypeBirthCohort(boolean collectionTypeBirthCohort) {
		_collectionTypeBirthCohort = collectionTypeBirthCohort;
	}

	public String getCollectionTypeOther() {
		return _collectionTypeOther;
	}

	public void setCollectionTypeOther(String collectionTypeOther) {
		_collectionTypeOther = collectionTypeOther;
	}

	public long getCollectionOrderOfMagnitude() {
		return _collectionOrderOfMagnitude;
	}

	public void setCollectionOrderOfMagnitude(long collectionOrderOfMagnitude) {
		_collectionOrderOfMagnitude = collectionOrderOfMagnitude;
	}

	public String getBioresourceReference() {
		return _bioresourceReference;
	}

	public void setBioresourceReference(String bioresourceReference) {
		_bioresourceReference = bioresourceReference;
	}

	public String getContactIDRef() {
		return _contactIDRef;
	}

	public void setContactIDRef(String contactIDRef) {
		_contactIDRef = contactIDRef;
	}

	public long getContactPriority() {
		return _contactPriority;
	}

	public void setContactPriority(long contactPriority) {
		_contactPriority = contactPriority;
	}

	public String getBiobankNetworkIDRef() {
		return _biobankNetworkIDRef;
	}

	public void setBiobankNetworkIDRef(String biobankNetworkIDRef) {
		_biobankNetworkIDRef = biobankNetworkIDRef;
	}

	public String getGeoLatitude() {
		return _geoLatitude;
	}

	public void setGeoLatitude(String geoLatitude) {
		_geoLatitude = geoLatitude;
	}

	public String getGeoLongitude() {
		return _geoLongitude;
	}

	public void setGeoLongitude(String geoLongitude) {
		_geoLongitude = geoLongitude;
	}

	public boolean getCollaborationPartnersCommercial() {
		return _collaborationPartnersCommercial;
	}

	public boolean isCollaborationPartnersCommercial() {
		return _collaborationPartnersCommercial;
	}

	public void setCollaborationPartnersCommercial(
		boolean collaborationPartnersCommercial) {
		_collaborationPartnersCommercial = collaborationPartnersCommercial;
	}

	public boolean getCollaborationPartnersNonforprofit() {
		return _collaborationPartnersNonforprofit;
	}

	public boolean isCollaborationPartnersNonforprofit() {
		return _collaborationPartnersNonforprofit;
	}

	public void setCollaborationPartnersNonforprofit(
		boolean collaborationPartnersNonforprofit) {
		_collaborationPartnersNonforprofit = collaborationPartnersNonforprofit;
	}

	public String getCollectionAcronym() {
		return _collectionAcronym;
	}

	public void setCollectionAcronym(String collectionAcronym) {
		_collectionAcronym = collectionAcronym;
	}

	public String getCollectionDescription() {
		return _collectionDescription;
	}

	public void setCollectionDescription(String collectionDescription) {
		_collectionDescription = collectionDescription;
	}

	public boolean getCollectionSexMale() {
		return _collectionSexMale;
	}

	public boolean isCollectionSexMale() {
		return _collectionSexMale;
	}

	public void setCollectionSexMale(boolean collectionSexMale) {
		_collectionSexMale = collectionSexMale;
	}

	public boolean getCollectionSexFemale() {
		return _collectionSexFemale;
	}

	public boolean isCollectionSexFemale() {
		return _collectionSexFemale;
	}

	public void setCollectionSexFemale(boolean collectionSexFemale) {
		_collectionSexFemale = collectionSexFemale;
	}

	public boolean getCollectionSexUnknown() {
		return _collectionSexUnknown;
	}

	public boolean isCollectionSexUnknown() {
		return _collectionSexUnknown;
	}

	public void setCollectionSexUnknown(boolean collectionSexUnknown) {
		_collectionSexUnknown = collectionSexUnknown;
	}

	public boolean getCollectionSexUndiferrentiated() {
		return _collectionSexUndiferrentiated;
	}

	public boolean isCollectionSexUndiferrentiated() {
		return _collectionSexUndiferrentiated;
	}

	public void setCollectionSexUndiferrentiated(
		boolean collectionSexUndiferrentiated) {
		_collectionSexUndiferrentiated = collectionSexUndiferrentiated;
	}

	public long getCollectionAgeLow() {
		return _collectionAgeLow;
	}

	public void setCollectionAgeLow(long collectionAgeLow) {
		_collectionAgeLow = collectionAgeLow;
	}

	public long getCollectionAgeHigh() {
		return _collectionAgeHigh;
	}

	public void setCollectionAgeHigh(long collectionAgeHigh) {
		_collectionAgeHigh = collectionAgeHigh;
	}

	public String getCollectionAgeUnit() {
		return _collectionAgeUnit;
	}

	public void setCollectionAgeUnit(String collectionAgeUnit) {
		_collectionAgeUnit = collectionAgeUnit;
	}

	public boolean getCollectionAvailableBiologicalSamples() {
		return _collectionAvailableBiologicalSamples;
	}

	public boolean isCollectionAvailableBiologicalSamples() {
		return _collectionAvailableBiologicalSamples;
	}

	public void setCollectionAvailableBiologicalSamples(
		boolean collectionAvailableBiologicalSamples) {
		_collectionAvailableBiologicalSamples = collectionAvailableBiologicalSamples;
	}

	public boolean getCollectionAvailableSurveyData() {
		return _collectionAvailableSurveyData;
	}

	public boolean isCollectionAvailableSurveyData() {
		return _collectionAvailableSurveyData;
	}

	public void setCollectionAvailableSurveyData(
		boolean collectionAvailableSurveyData) {
		_collectionAvailableSurveyData = collectionAvailableSurveyData;
	}

	public boolean getCollectionAvailableImagingData() {
		return _collectionAvailableImagingData;
	}

	public boolean isCollectionAvailableImagingData() {
		return _collectionAvailableImagingData;
	}

	public void setCollectionAvailableImagingData(
		boolean collectionAvailableImagingData) {
		_collectionAvailableImagingData = collectionAvailableImagingData;
	}

	public boolean getCollectionAvailableMedicalRecords() {
		return _collectionAvailableMedicalRecords;
	}

	public boolean isCollectionAvailableMedicalRecords() {
		return _collectionAvailableMedicalRecords;
	}

	public void setCollectionAvailableMedicalRecords(
		boolean collectionAvailableMedicalRecords) {
		_collectionAvailableMedicalRecords = collectionAvailableMedicalRecords;
	}

	public boolean getCollectionAvailableNationalRegistries() {
		return _collectionAvailableNationalRegistries;
	}

	public boolean isCollectionAvailableNationalRegistries() {
		return _collectionAvailableNationalRegistries;
	}

	public void setCollectionAvailableNationalRegistries(
		boolean collectionAvailableNationalRegistries) {
		_collectionAvailableNationalRegistries = collectionAvailableNationalRegistries;
	}

	public boolean getCollectionAvailableGenealogicalRecords() {
		return _collectionAvailableGenealogicalRecords;
	}

	public boolean isCollectionAvailableGenealogicalRecords() {
		return _collectionAvailableGenealogicalRecords;
	}

	public void setCollectionAvailableGenealogicalRecords(
		boolean collectionAvailableGenealogicalRecords) {
		_collectionAvailableGenealogicalRecords = collectionAvailableGenealogicalRecords;
	}

	public boolean getCollectionAvailablePhysioBiochemMeasurements() {
		return _collectionAvailablePhysioBiochemMeasurements;
	}

	public boolean isCollectionAvailablePhysioBiochemMeasurements() {
		return _collectionAvailablePhysioBiochemMeasurements;
	}

	public void setCollectionAvailablePhysioBiochemMeasurements(
		boolean collectionAvailablePhysioBiochemMeasurements) {
		_collectionAvailablePhysioBiochemMeasurements = collectionAvailablePhysioBiochemMeasurements;
	}

	public String getCollectionAvailableOther() {
		return _collectionAvailableOther;
	}

	public void setCollectionAvailableOther(String collectionAvailableOther) {
		_collectionAvailableOther = collectionAvailableOther;
	}

	public boolean getTemperatureRoom() {
		return _temperatureRoom;
	}

	public boolean isTemperatureRoom() {
		return _temperatureRoom;
	}

	public void setTemperatureRoom(boolean temperatureRoom) {
		_temperatureRoom = temperatureRoom;
	}

	public boolean getTemperature2to10() {
		return _temperature2to10;
	}

	public boolean isTemperature2to10() {
		return _temperature2to10;
	}

	public void setTemperature2to10(boolean temperature2to10) {
		_temperature2to10 = temperature2to10;
	}

	public boolean getTemperature18to35() {
		return _temperature18to35;
	}

	public boolean isTemperature18to35() {
		return _temperature18to35;
	}

	public void setTemperature18to35(boolean temperature18to35) {
		_temperature18to35 = temperature18to35;
	}

	public boolean getTemperature60to85() {
		return _temperature60to85;
	}

	public boolean isTemperature60to85() {
		return _temperature60to85;
	}

	public void setTemperature60to85(boolean temperature60to85) {
		_temperature60to85 = temperature60to85;
	}

	public boolean getTemperatureLN() {
		return _temperatureLN;
	}

	public boolean isTemperatureLN() {
		return _temperatureLN;
	}

	public void setTemperatureLN(boolean temperatureLN) {
		_temperatureLN = temperatureLN;
	}

	public String getTemperatureOther() {
		return _temperatureOther;
	}

	public void setTemperatureOther(String temperatureOther) {
		_temperatureOther = temperatureOther;
	}

	public String getDiagnosisAvailable() {
		return _diagnosisAvailable;
	}

	public void setDiagnosisAvailable(String diagnosisAvailable) {
		_diagnosisAvailable = diagnosisAvailable;
	}

	public String getCollectionHeadFirstName() {
		return _collectionHeadFirstName;
	}

	public void setCollectionHeadFirstName(String collectionHeadFirstName) {
		_collectionHeadFirstName = collectionHeadFirstName;
	}

	public String getCollectionHeadLastName() {
		return _collectionHeadLastName;
	}

	public void setCollectionHeadLastName(String collectionHeadLastName) {
		_collectionHeadLastName = collectionHeadLastName;
	}

	public String getCollectionHeadRole() {
		return _collectionHeadRole;
	}

	public void setCollectionHeadRole(String collectionHeadRole) {
		_collectionHeadRole = collectionHeadRole;
	}

	public boolean getCollectionSampleAccessFee() {
		return _collectionSampleAccessFee;
	}

	public boolean isCollectionSampleAccessFee() {
		return _collectionSampleAccessFee;
	}

	public void setCollectionSampleAccessFee(boolean collectionSampleAccessFee) {
		_collectionSampleAccessFee = collectionSampleAccessFee;
	}

	public boolean getCollectionSampleAccessJointProjects() {
		return _collectionSampleAccessJointProjects;
	}

	public boolean isCollectionSampleAccessJointProjects() {
		return _collectionSampleAccessJointProjects;
	}

	public void setCollectionSampleAccessJointProjects(
		boolean collectionSampleAccessJointProjects) {
		_collectionSampleAccessJointProjects = collectionSampleAccessJointProjects;
	}

	public String getCollectionSampleAccessDescription() {
		return _collectionSampleAccessDescription;
	}

	public void setCollectionSampleAccessDescription(
		String collectionSampleAccessDescription) {
		_collectionSampleAccessDescription = collectionSampleAccessDescription;
	}

	public String getCollectionSampleAccessURI() {
		return _collectionSampleAccessURI;
	}

	public void setCollectionSampleAccessURI(String collectionSampleAccessURI) {
		_collectionSampleAccessURI = collectionSampleAccessURI;
	}

	public boolean getCollectionDataAccessFee() {
		return _collectionDataAccessFee;
	}

	public boolean isCollectionDataAccessFee() {
		return _collectionDataAccessFee;
	}

	public void setCollectionDataAccessFee(boolean collectionDataAccessFee) {
		_collectionDataAccessFee = collectionDataAccessFee;
	}

	public boolean getCollectionDataAccessJointProjects() {
		return _collectionDataAccessJointProjects;
	}

	public boolean isCollectionDataAccessJointProjects() {
		return _collectionDataAccessJointProjects;
	}

	public void setCollectionDataAccessJointProjects(
		boolean collectionDataAccessJointProjects) {
		_collectionDataAccessJointProjects = collectionDataAccessJointProjects;
	}

	public String getCollectionDataAccessDescription() {
		return _collectionDataAccessDescription;
	}

	public void setCollectionDataAccessDescription(
		String collectionDataAccessDescription) {
		_collectionDataAccessDescription = collectionDataAccessDescription;
	}

	public String getCollectionDataAccessURI() {
		return _collectionDataAccessURI;
	}

	public void setCollectionDataAccessURI(String collectionDataAccessURI) {
		_collectionDataAccessURI = collectionDataAccessURI;
	}

	public long getCollectionSize() {
		return _collectionSize;
	}

	public void setCollectionSize(long collectionSize) {
		_collectionSize = collectionSize;
	}

	public long getCollectionSizeTimestamp() {
		return _collectionSizeTimestamp;
	}

	public void setCollectionSizeTimestamp(long collectionSizeTimestamp) {
		_collectionSizeTimestamp = collectionSizeTimestamp;
	}

	private String _uuid;
	private long _d2collectionId;
	private long _biobankId;
	private long _parentd2collectionId;
	private long _companyId;
	private long _groupId;
	private long _userId;
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
}