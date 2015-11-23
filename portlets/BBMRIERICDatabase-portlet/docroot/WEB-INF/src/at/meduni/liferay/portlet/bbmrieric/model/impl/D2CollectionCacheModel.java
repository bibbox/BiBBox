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

package at.meduni.liferay.portlet.bbmrieric.model.impl;

import at.meduni.liferay.portlet.bbmrieric.model.D2Collection;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing D2Collection in entity cache.
 *
 * @author reihsr
 * @see D2Collection
 * @generated
 */
public class D2CollectionCacheModel implements CacheModel<D2Collection>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(169);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", d2collectionId=");
		sb.append(d2collectionId);
		sb.append(", biobankId=");
		sb.append(biobankId);
		sb.append(", parentd2collectionId=");
		sb.append(parentd2collectionId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", updateuuid=");
		sb.append(updateuuid);
		sb.append(", bbmricollectionID=");
		sb.append(bbmricollectionID);
		sb.append(", bbmriparentcollectionID=");
		sb.append(bbmriparentcollectionID);
		sb.append(", bbmribiobankID=");
		sb.append(bbmribiobankID);
		sb.append(", collectionName=");
		sb.append(collectionName);
		sb.append(", materialStoredDNA=");
		sb.append(materialStoredDNA);
		sb.append(", materialStoredPlasma=");
		sb.append(materialStoredPlasma);
		sb.append(", materialStoredSerum=");
		sb.append(materialStoredSerum);
		sb.append(", materialStoredUrine=");
		sb.append(materialStoredUrine);
		sb.append(", materialStoredSaliva=");
		sb.append(materialStoredSaliva);
		sb.append(", materialStoredFaeces=");
		sb.append(materialStoredFaeces);
		sb.append(", materialStoredRNA=");
		sb.append(materialStoredRNA);
		sb.append(", materialStoredBlood=");
		sb.append(materialStoredBlood);
		sb.append(", materialStoredTissueFrozen=");
		sb.append(materialStoredTissueFrozen);
		sb.append(", materialStoredTissueFFPE=");
		sb.append(materialStoredTissueFFPE);
		sb.append(", materialStoredImmortalizedCellLines=");
		sb.append(materialStoredImmortalizedCellLines);
		sb.append(", materialStoredIsolatedPathogen=");
		sb.append(materialStoredIsolatedPathogen);
		sb.append(", materialStoredOther=");
		sb.append(materialStoredOther);
		sb.append(", collectionTypeCaseControl=");
		sb.append(collectionTypeCaseControl);
		sb.append(", collectionTypeCohort=");
		sb.append(collectionTypeCohort);
		sb.append(", collectionTypeCrossSectional=");
		sb.append(collectionTypeCrossSectional);
		sb.append(", collectionTypeLongitudinal=");
		sb.append(collectionTypeLongitudinal);
		sb.append(", collectionTypeTwinStudy=");
		sb.append(collectionTypeTwinStudy);
		sb.append(", collectionTypeQualityControl=");
		sb.append(collectionTypeQualityControl);
		sb.append(", collectionTypePopulationBased=");
		sb.append(collectionTypePopulationBased);
		sb.append(", collectionTypeDiseaseSpecific=");
		sb.append(collectionTypeDiseaseSpecific);
		sb.append(", collectionTypeBirthCohort=");
		sb.append(collectionTypeBirthCohort);
		sb.append(", collectionTypeOther=");
		sb.append(collectionTypeOther);
		sb.append(", collectionOrderOfMagnitude=");
		sb.append(collectionOrderOfMagnitude);
		sb.append(", bioresourceReference=");
		sb.append(bioresourceReference);
		sb.append(", contactIDRef=");
		sb.append(contactIDRef);
		sb.append(", contactPriority=");
		sb.append(contactPriority);
		sb.append(", biobankNetworkIDRef=");
		sb.append(biobankNetworkIDRef);
		sb.append(", geoLatitude=");
		sb.append(geoLatitude);
		sb.append(", geoLongitude=");
		sb.append(geoLongitude);
		sb.append(", collaborationPartnersCommercial=");
		sb.append(collaborationPartnersCommercial);
		sb.append(", collaborationPartnersNonforprofit=");
		sb.append(collaborationPartnersNonforprofit);
		sb.append(", collectionAcronym=");
		sb.append(collectionAcronym);
		sb.append(", collectionDescription=");
		sb.append(collectionDescription);
		sb.append(", collectionSexMale=");
		sb.append(collectionSexMale);
		sb.append(", collectionSexFemale=");
		sb.append(collectionSexFemale);
		sb.append(", collectionSexUnknown=");
		sb.append(collectionSexUnknown);
		sb.append(", collectionSexUndiferrentiated=");
		sb.append(collectionSexUndiferrentiated);
		sb.append(", collectionAgeLow=");
		sb.append(collectionAgeLow);
		sb.append(", collectionAgeHigh=");
		sb.append(collectionAgeHigh);
		sb.append(", collectionAgeUnit=");
		sb.append(collectionAgeUnit);
		sb.append(", collectionAvailableBiologicalSamples=");
		sb.append(collectionAvailableBiologicalSamples);
		sb.append(", collectionAvailableSurveyData=");
		sb.append(collectionAvailableSurveyData);
		sb.append(", collectionAvailableImagingData=");
		sb.append(collectionAvailableImagingData);
		sb.append(", collectionAvailableMedicalRecords=");
		sb.append(collectionAvailableMedicalRecords);
		sb.append(", collectionAvailableNationalRegistries=");
		sb.append(collectionAvailableNationalRegistries);
		sb.append(", collectionAvailableGenealogicalRecords=");
		sb.append(collectionAvailableGenealogicalRecords);
		sb.append(", collectionAvailablePhysioBiochemMeasurements=");
		sb.append(collectionAvailablePhysioBiochemMeasurements);
		sb.append(", collectionAvailableOther=");
		sb.append(collectionAvailableOther);
		sb.append(", temperatureRoom=");
		sb.append(temperatureRoom);
		sb.append(", temperature2to10=");
		sb.append(temperature2to10);
		sb.append(", temperature18to35=");
		sb.append(temperature18to35);
		sb.append(", temperature60to85=");
		sb.append(temperature60to85);
		sb.append(", temperatureLN=");
		sb.append(temperatureLN);
		sb.append(", temperatureOther=");
		sb.append(temperatureOther);
		sb.append(", diagnosisAvailable=");
		sb.append(diagnosisAvailable);
		sb.append(", collectionHeadFirstName=");
		sb.append(collectionHeadFirstName);
		sb.append(", collectionHeadLastName=");
		sb.append(collectionHeadLastName);
		sb.append(", collectionHeadRole=");
		sb.append(collectionHeadRole);
		sb.append(", collectionSampleAccessFee=");
		sb.append(collectionSampleAccessFee);
		sb.append(", collectionSampleAccessJointProjects=");
		sb.append(collectionSampleAccessJointProjects);
		sb.append(", collectionSampleAccessDescription=");
		sb.append(collectionSampleAccessDescription);
		sb.append(", collectionSampleAccessURI=");
		sb.append(collectionSampleAccessURI);
		sb.append(", collectionDataAccessFee=");
		sb.append(collectionDataAccessFee);
		sb.append(", collectionDataAccessJointProjects=");
		sb.append(collectionDataAccessJointProjects);
		sb.append(", collectionDataAccessDescription=");
		sb.append(collectionDataAccessDescription);
		sb.append(", collectionDataAccessURI=");
		sb.append(collectionDataAccessURI);
		sb.append(", collectionSize=");
		sb.append(collectionSize);
		sb.append(", collectionSizeTimestamp=");
		sb.append(collectionSizeTimestamp);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public D2Collection toEntityModel() {
		D2CollectionImpl d2CollectionImpl = new D2CollectionImpl();

		if (uuid == null) {
			d2CollectionImpl.setUuid(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setUuid(uuid);
		}

		d2CollectionImpl.setD2collectionId(d2collectionId);
		d2CollectionImpl.setBiobankId(biobankId);
		d2CollectionImpl.setParentd2collectionId(parentd2collectionId);
		d2CollectionImpl.setCompanyId(companyId);
		d2CollectionImpl.setGroupId(groupId);
		d2CollectionImpl.setUserId(userId);

		if (userName == null) {
			d2CollectionImpl.setUserName(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			d2CollectionImpl.setCreateDate(null);
		}
		else {
			d2CollectionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			d2CollectionImpl.setModifiedDate(null);
		}
		else {
			d2CollectionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (updateuuid == null) {
			d2CollectionImpl.setUpdateuuid(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setUpdateuuid(updateuuid);
		}

		if (bbmricollectionID == null) {
			d2CollectionImpl.setBbmricollectionID(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setBbmricollectionID(bbmricollectionID);
		}

		if (bbmriparentcollectionID == null) {
			d2CollectionImpl.setBbmriparentcollectionID(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setBbmriparentcollectionID(bbmriparentcollectionID);
		}

		if (bbmribiobankID == null) {
			d2CollectionImpl.setBbmribiobankID(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setBbmribiobankID(bbmribiobankID);
		}

		if (collectionName == null) {
			d2CollectionImpl.setCollectionName(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionName(collectionName);
		}

		d2CollectionImpl.setMaterialStoredDNA(materialStoredDNA);
		d2CollectionImpl.setMaterialStoredPlasma(materialStoredPlasma);
		d2CollectionImpl.setMaterialStoredSerum(materialStoredSerum);
		d2CollectionImpl.setMaterialStoredUrine(materialStoredUrine);
		d2CollectionImpl.setMaterialStoredSaliva(materialStoredSaliva);
		d2CollectionImpl.setMaterialStoredFaeces(materialStoredFaeces);
		d2CollectionImpl.setMaterialStoredRNA(materialStoredRNA);
		d2CollectionImpl.setMaterialStoredBlood(materialStoredBlood);
		d2CollectionImpl.setMaterialStoredTissueFrozen(materialStoredTissueFrozen);
		d2CollectionImpl.setMaterialStoredTissueFFPE(materialStoredTissueFFPE);
		d2CollectionImpl.setMaterialStoredImmortalizedCellLines(materialStoredImmortalizedCellLines);
		d2CollectionImpl.setMaterialStoredIsolatedPathogen(materialStoredIsolatedPathogen);

		if (materialStoredOther == null) {
			d2CollectionImpl.setMaterialStoredOther(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setMaterialStoredOther(materialStoredOther);
		}

		d2CollectionImpl.setCollectionTypeCaseControl(collectionTypeCaseControl);
		d2CollectionImpl.setCollectionTypeCohort(collectionTypeCohort);
		d2CollectionImpl.setCollectionTypeCrossSectional(collectionTypeCrossSectional);
		d2CollectionImpl.setCollectionTypeLongitudinal(collectionTypeLongitudinal);
		d2CollectionImpl.setCollectionTypeTwinStudy(collectionTypeTwinStudy);
		d2CollectionImpl.setCollectionTypeQualityControl(collectionTypeQualityControl);
		d2CollectionImpl.setCollectionTypePopulationBased(collectionTypePopulationBased);
		d2CollectionImpl.setCollectionTypeDiseaseSpecific(collectionTypeDiseaseSpecific);
		d2CollectionImpl.setCollectionTypeBirthCohort(collectionTypeBirthCohort);

		if (collectionTypeOther == null) {
			d2CollectionImpl.setCollectionTypeOther(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionTypeOther(collectionTypeOther);
		}

		d2CollectionImpl.setCollectionOrderOfMagnitude(collectionOrderOfMagnitude);

		if (bioresourceReference == null) {
			d2CollectionImpl.setBioresourceReference(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setBioresourceReference(bioresourceReference);
		}

		if (contactIDRef == null) {
			d2CollectionImpl.setContactIDRef(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setContactIDRef(contactIDRef);
		}

		d2CollectionImpl.setContactPriority(contactPriority);

		if (biobankNetworkIDRef == null) {
			d2CollectionImpl.setBiobankNetworkIDRef(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setBiobankNetworkIDRef(biobankNetworkIDRef);
		}

		if (geoLatitude == null) {
			d2CollectionImpl.setGeoLatitude(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setGeoLatitude(geoLatitude);
		}

		if (geoLongitude == null) {
			d2CollectionImpl.setGeoLongitude(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setGeoLongitude(geoLongitude);
		}

		d2CollectionImpl.setCollaborationPartnersCommercial(collaborationPartnersCommercial);
		d2CollectionImpl.setCollaborationPartnersNonforprofit(collaborationPartnersNonforprofit);

		if (collectionAcronym == null) {
			d2CollectionImpl.setCollectionAcronym(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionAcronym(collectionAcronym);
		}

		if (collectionDescription == null) {
			d2CollectionImpl.setCollectionDescription(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionDescription(collectionDescription);
		}

		d2CollectionImpl.setCollectionSexMale(collectionSexMale);
		d2CollectionImpl.setCollectionSexFemale(collectionSexFemale);
		d2CollectionImpl.setCollectionSexUnknown(collectionSexUnknown);
		d2CollectionImpl.setCollectionSexUndiferrentiated(collectionSexUndiferrentiated);
		d2CollectionImpl.setCollectionAgeLow(collectionAgeLow);
		d2CollectionImpl.setCollectionAgeHigh(collectionAgeHigh);

		if (collectionAgeUnit == null) {
			d2CollectionImpl.setCollectionAgeUnit(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionAgeUnit(collectionAgeUnit);
		}

		d2CollectionImpl.setCollectionAvailableBiologicalSamples(collectionAvailableBiologicalSamples);
		d2CollectionImpl.setCollectionAvailableSurveyData(collectionAvailableSurveyData);
		d2CollectionImpl.setCollectionAvailableImagingData(collectionAvailableImagingData);
		d2CollectionImpl.setCollectionAvailableMedicalRecords(collectionAvailableMedicalRecords);
		d2CollectionImpl.setCollectionAvailableNationalRegistries(collectionAvailableNationalRegistries);
		d2CollectionImpl.setCollectionAvailableGenealogicalRecords(collectionAvailableGenealogicalRecords);
		d2CollectionImpl.setCollectionAvailablePhysioBiochemMeasurements(collectionAvailablePhysioBiochemMeasurements);

		if (collectionAvailableOther == null) {
			d2CollectionImpl.setCollectionAvailableOther(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionAvailableOther(collectionAvailableOther);
		}

		d2CollectionImpl.setTemperatureRoom(temperatureRoom);
		d2CollectionImpl.setTemperature2to10(temperature2to10);
		d2CollectionImpl.setTemperature18to35(temperature18to35);
		d2CollectionImpl.setTemperature60to85(temperature60to85);
		d2CollectionImpl.setTemperatureLN(temperatureLN);

		if (temperatureOther == null) {
			d2CollectionImpl.setTemperatureOther(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setTemperatureOther(temperatureOther);
		}

		if (diagnosisAvailable == null) {
			d2CollectionImpl.setDiagnosisAvailable(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setDiagnosisAvailable(diagnosisAvailable);
		}

		if (collectionHeadFirstName == null) {
			d2CollectionImpl.setCollectionHeadFirstName(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionHeadFirstName(collectionHeadFirstName);
		}

		if (collectionHeadLastName == null) {
			d2CollectionImpl.setCollectionHeadLastName(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionHeadLastName(collectionHeadLastName);
		}

		if (collectionHeadRole == null) {
			d2CollectionImpl.setCollectionHeadRole(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionHeadRole(collectionHeadRole);
		}

		d2CollectionImpl.setCollectionSampleAccessFee(collectionSampleAccessFee);
		d2CollectionImpl.setCollectionSampleAccessJointProjects(collectionSampleAccessJointProjects);

		if (collectionSampleAccessDescription == null) {
			d2CollectionImpl.setCollectionSampleAccessDescription(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionSampleAccessDescription(collectionSampleAccessDescription);
		}

		if (collectionSampleAccessURI == null) {
			d2CollectionImpl.setCollectionSampleAccessURI(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionSampleAccessURI(collectionSampleAccessURI);
		}

		d2CollectionImpl.setCollectionDataAccessFee(collectionDataAccessFee);
		d2CollectionImpl.setCollectionDataAccessJointProjects(collectionDataAccessJointProjects);

		if (collectionDataAccessDescription == null) {
			d2CollectionImpl.setCollectionDataAccessDescription(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionDataAccessDescription(collectionDataAccessDescription);
		}

		if (collectionDataAccessURI == null) {
			d2CollectionImpl.setCollectionDataAccessURI(StringPool.BLANK);
		}
		else {
			d2CollectionImpl.setCollectionDataAccessURI(collectionDataAccessURI);
		}

		d2CollectionImpl.setCollectionSize(collectionSize);
		d2CollectionImpl.setCollectionSizeTimestamp(collectionSizeTimestamp);

		d2CollectionImpl.resetOriginalValues();

		return d2CollectionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		d2collectionId = objectInput.readLong();
		biobankId = objectInput.readLong();
		parentd2collectionId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		updateuuid = objectInput.readUTF();
		bbmricollectionID = objectInput.readUTF();
		bbmriparentcollectionID = objectInput.readUTF();
		bbmribiobankID = objectInput.readUTF();
		collectionName = objectInput.readUTF();
		materialStoredDNA = objectInput.readBoolean();
		materialStoredPlasma = objectInput.readBoolean();
		materialStoredSerum = objectInput.readBoolean();
		materialStoredUrine = objectInput.readBoolean();
		materialStoredSaliva = objectInput.readBoolean();
		materialStoredFaeces = objectInput.readBoolean();
		materialStoredRNA = objectInput.readBoolean();
		materialStoredBlood = objectInput.readBoolean();
		materialStoredTissueFrozen = objectInput.readBoolean();
		materialStoredTissueFFPE = objectInput.readBoolean();
		materialStoredImmortalizedCellLines = objectInput.readBoolean();
		materialStoredIsolatedPathogen = objectInput.readBoolean();
		materialStoredOther = objectInput.readUTF();
		collectionTypeCaseControl = objectInput.readBoolean();
		collectionTypeCohort = objectInput.readBoolean();
		collectionTypeCrossSectional = objectInput.readBoolean();
		collectionTypeLongitudinal = objectInput.readBoolean();
		collectionTypeTwinStudy = objectInput.readBoolean();
		collectionTypeQualityControl = objectInput.readBoolean();
		collectionTypePopulationBased = objectInput.readBoolean();
		collectionTypeDiseaseSpecific = objectInput.readBoolean();
		collectionTypeBirthCohort = objectInput.readBoolean();
		collectionTypeOther = objectInput.readUTF();
		collectionOrderOfMagnitude = objectInput.readLong();
		bioresourceReference = objectInput.readUTF();
		contactIDRef = objectInput.readUTF();
		contactPriority = objectInput.readLong();
		biobankNetworkIDRef = objectInput.readUTF();
		geoLatitude = objectInput.readUTF();
		geoLongitude = objectInput.readUTF();
		collaborationPartnersCommercial = objectInput.readBoolean();
		collaborationPartnersNonforprofit = objectInput.readBoolean();
		collectionAcronym = objectInput.readUTF();
		collectionDescription = objectInput.readUTF();
		collectionSexMale = objectInput.readBoolean();
		collectionSexFemale = objectInput.readBoolean();
		collectionSexUnknown = objectInput.readBoolean();
		collectionSexUndiferrentiated = objectInput.readBoolean();
		collectionAgeLow = objectInput.readLong();
		collectionAgeHigh = objectInput.readLong();
		collectionAgeUnit = objectInput.readUTF();
		collectionAvailableBiologicalSamples = objectInput.readBoolean();
		collectionAvailableSurveyData = objectInput.readBoolean();
		collectionAvailableImagingData = objectInput.readBoolean();
		collectionAvailableMedicalRecords = objectInput.readBoolean();
		collectionAvailableNationalRegistries = objectInput.readBoolean();
		collectionAvailableGenealogicalRecords = objectInput.readBoolean();
		collectionAvailablePhysioBiochemMeasurements = objectInput.readBoolean();
		collectionAvailableOther = objectInput.readUTF();
		temperatureRoom = objectInput.readBoolean();
		temperature2to10 = objectInput.readBoolean();
		temperature18to35 = objectInput.readBoolean();
		temperature60to85 = objectInput.readBoolean();
		temperatureLN = objectInput.readBoolean();
		temperatureOther = objectInput.readUTF();
		diagnosisAvailable = objectInput.readUTF();
		collectionHeadFirstName = objectInput.readUTF();
		collectionHeadLastName = objectInput.readUTF();
		collectionHeadRole = objectInput.readUTF();
		collectionSampleAccessFee = objectInput.readBoolean();
		collectionSampleAccessJointProjects = objectInput.readBoolean();
		collectionSampleAccessDescription = objectInput.readUTF();
		collectionSampleAccessURI = objectInput.readUTF();
		collectionDataAccessFee = objectInput.readBoolean();
		collectionDataAccessJointProjects = objectInput.readBoolean();
		collectionDataAccessDescription = objectInput.readUTF();
		collectionDataAccessURI = objectInput.readUTF();
		collectionSize = objectInput.readLong();
		collectionSizeTimestamp = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(d2collectionId);
		objectOutput.writeLong(biobankId);
		objectOutput.writeLong(parentd2collectionId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (updateuuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(updateuuid);
		}

		if (bbmricollectionID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bbmricollectionID);
		}

		if (bbmriparentcollectionID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bbmriparentcollectionID);
		}

		if (bbmribiobankID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bbmribiobankID);
		}

		if (collectionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionName);
		}

		objectOutput.writeBoolean(materialStoredDNA);
		objectOutput.writeBoolean(materialStoredPlasma);
		objectOutput.writeBoolean(materialStoredSerum);
		objectOutput.writeBoolean(materialStoredUrine);
		objectOutput.writeBoolean(materialStoredSaliva);
		objectOutput.writeBoolean(materialStoredFaeces);
		objectOutput.writeBoolean(materialStoredRNA);
		objectOutput.writeBoolean(materialStoredBlood);
		objectOutput.writeBoolean(materialStoredTissueFrozen);
		objectOutput.writeBoolean(materialStoredTissueFFPE);
		objectOutput.writeBoolean(materialStoredImmortalizedCellLines);
		objectOutput.writeBoolean(materialStoredIsolatedPathogen);

		if (materialStoredOther == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(materialStoredOther);
		}

		objectOutput.writeBoolean(collectionTypeCaseControl);
		objectOutput.writeBoolean(collectionTypeCohort);
		objectOutput.writeBoolean(collectionTypeCrossSectional);
		objectOutput.writeBoolean(collectionTypeLongitudinal);
		objectOutput.writeBoolean(collectionTypeTwinStudy);
		objectOutput.writeBoolean(collectionTypeQualityControl);
		objectOutput.writeBoolean(collectionTypePopulationBased);
		objectOutput.writeBoolean(collectionTypeDiseaseSpecific);
		objectOutput.writeBoolean(collectionTypeBirthCohort);

		if (collectionTypeOther == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionTypeOther);
		}

		objectOutput.writeLong(collectionOrderOfMagnitude);

		if (bioresourceReference == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bioresourceReference);
		}

		if (contactIDRef == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactIDRef);
		}

		objectOutput.writeLong(contactPriority);

		if (biobankNetworkIDRef == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankNetworkIDRef);
		}

		if (geoLatitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(geoLatitude);
		}

		if (geoLongitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(geoLongitude);
		}

		objectOutput.writeBoolean(collaborationPartnersCommercial);
		objectOutput.writeBoolean(collaborationPartnersNonforprofit);

		if (collectionAcronym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionAcronym);
		}

		if (collectionDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionDescription);
		}

		objectOutput.writeBoolean(collectionSexMale);
		objectOutput.writeBoolean(collectionSexFemale);
		objectOutput.writeBoolean(collectionSexUnknown);
		objectOutput.writeBoolean(collectionSexUndiferrentiated);
		objectOutput.writeLong(collectionAgeLow);
		objectOutput.writeLong(collectionAgeHigh);

		if (collectionAgeUnit == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionAgeUnit);
		}

		objectOutput.writeBoolean(collectionAvailableBiologicalSamples);
		objectOutput.writeBoolean(collectionAvailableSurveyData);
		objectOutput.writeBoolean(collectionAvailableImagingData);
		objectOutput.writeBoolean(collectionAvailableMedicalRecords);
		objectOutput.writeBoolean(collectionAvailableNationalRegistries);
		objectOutput.writeBoolean(collectionAvailableGenealogicalRecords);
		objectOutput.writeBoolean(collectionAvailablePhysioBiochemMeasurements);

		if (collectionAvailableOther == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionAvailableOther);
		}

		objectOutput.writeBoolean(temperatureRoom);
		objectOutput.writeBoolean(temperature2to10);
		objectOutput.writeBoolean(temperature18to35);
		objectOutput.writeBoolean(temperature60to85);
		objectOutput.writeBoolean(temperatureLN);

		if (temperatureOther == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(temperatureOther);
		}

		if (diagnosisAvailable == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diagnosisAvailable);
		}

		if (collectionHeadFirstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionHeadFirstName);
		}

		if (collectionHeadLastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionHeadLastName);
		}

		if (collectionHeadRole == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionHeadRole);
		}

		objectOutput.writeBoolean(collectionSampleAccessFee);
		objectOutput.writeBoolean(collectionSampleAccessJointProjects);

		if (collectionSampleAccessDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionSampleAccessDescription);
		}

		if (collectionSampleAccessURI == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionSampleAccessURI);
		}

		objectOutput.writeBoolean(collectionDataAccessFee);
		objectOutput.writeBoolean(collectionDataAccessJointProjects);

		if (collectionDataAccessDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionDataAccessDescription);
		}

		if (collectionDataAccessURI == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionDataAccessURI);
		}

		objectOutput.writeLong(collectionSize);
		objectOutput.writeLong(collectionSizeTimestamp);
	}

	public String uuid;
	public long d2collectionId;
	public long biobankId;
	public long parentd2collectionId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String updateuuid;
	public String bbmricollectionID;
	public String bbmriparentcollectionID;
	public String bbmribiobankID;
	public String collectionName;
	public boolean materialStoredDNA;
	public boolean materialStoredPlasma;
	public boolean materialStoredSerum;
	public boolean materialStoredUrine;
	public boolean materialStoredSaliva;
	public boolean materialStoredFaeces;
	public boolean materialStoredRNA;
	public boolean materialStoredBlood;
	public boolean materialStoredTissueFrozen;
	public boolean materialStoredTissueFFPE;
	public boolean materialStoredImmortalizedCellLines;
	public boolean materialStoredIsolatedPathogen;
	public String materialStoredOther;
	public boolean collectionTypeCaseControl;
	public boolean collectionTypeCohort;
	public boolean collectionTypeCrossSectional;
	public boolean collectionTypeLongitudinal;
	public boolean collectionTypeTwinStudy;
	public boolean collectionTypeQualityControl;
	public boolean collectionTypePopulationBased;
	public boolean collectionTypeDiseaseSpecific;
	public boolean collectionTypeBirthCohort;
	public String collectionTypeOther;
	public long collectionOrderOfMagnitude;
	public String bioresourceReference;
	public String contactIDRef;
	public long contactPriority;
	public String biobankNetworkIDRef;
	public String geoLatitude;
	public String geoLongitude;
	public boolean collaborationPartnersCommercial;
	public boolean collaborationPartnersNonforprofit;
	public String collectionAcronym;
	public String collectionDescription;
	public boolean collectionSexMale;
	public boolean collectionSexFemale;
	public boolean collectionSexUnknown;
	public boolean collectionSexUndiferrentiated;
	public long collectionAgeLow;
	public long collectionAgeHigh;
	public String collectionAgeUnit;
	public boolean collectionAvailableBiologicalSamples;
	public boolean collectionAvailableSurveyData;
	public boolean collectionAvailableImagingData;
	public boolean collectionAvailableMedicalRecords;
	public boolean collectionAvailableNationalRegistries;
	public boolean collectionAvailableGenealogicalRecords;
	public boolean collectionAvailablePhysioBiochemMeasurements;
	public String collectionAvailableOther;
	public boolean temperatureRoom;
	public boolean temperature2to10;
	public boolean temperature18to35;
	public boolean temperature60to85;
	public boolean temperatureLN;
	public String temperatureOther;
	public String diagnosisAvailable;
	public String collectionHeadFirstName;
	public String collectionHeadLastName;
	public String collectionHeadRole;
	public boolean collectionSampleAccessFee;
	public boolean collectionSampleAccessJointProjects;
	public String collectionSampleAccessDescription;
	public String collectionSampleAccessURI;
	public boolean collectionDataAccessFee;
	public boolean collectionDataAccessJointProjects;
	public String collectionDataAccessDescription;
	public String collectionDataAccessURI;
	public long collectionSize;
	public long collectionSizeTimestamp;
}