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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.directory.Attributes;
import javax.naming.directory.SearchResult;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;
import at.meduni.liferay.portlet.bbmrieric.model.D2Collection;
import at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationImpl;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionImpl;
import at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.base.D2CollectionLocalServiceBaseImpl;
import at.meduni.liferay.portlet.bbmrieric.util.LDAPAttributeEscaper;

/**
 * The implementation of the d2 collection local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.D2CollectionLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalServiceUtil
 */
public class D2CollectionLocalServiceImpl
	extends D2CollectionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalServiceUtil} to access the d2 collection local service.
	 */
	
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	String classpath_ = "BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.D2CollectionLocalServiceImpl";
	
	/**
	 * 
	 * @param d2collection
	 * @param serviceContext
	 * @return
	 */
	public D2Collection addD2Collection(D2Collection d2collection, ServiceContext serviceContext) {
		return addD2Collection(d2collection.getD2collectionId(), d2collection.getCompanyId(), d2collection.getGroupId(), d2collection.getUserId(), 
				d2collection.getBiobankId(), d2collection.getParentd2collectionId(), d2collection.getUpdateuuid(),
				d2collection.getBbmricollectionID(), d2collection.getBbmriparentcollectionID(), d2collection.getBbmribiobankID(), d2collection.getCollectionName(), d2collection.getMaterialStoredDNA(), 
				d2collection.getMaterialStoredPlasma(), d2collection.getMaterialStoredSerum(), d2collection.getMaterialStoredUrine(), d2collection.getMaterialStoredSaliva(),
				d2collection.getMaterialStoredFaeces(), d2collection.getMaterialStoredRNA(), d2collection.getMaterialStoredBlood(), d2collection.getMaterialStoredTissueFrozen(),
				d2collection.getMaterialStoredTissueFFPE(), d2collection.getMaterialStoredImmortalizedCellLines(), d2collection.getMaterialStoredIsolatedPathogen(),
				d2collection.getMaterialStoredOther(), d2collection.getCollectionTypeCaseControl(), d2collection.getCollectionTypeCohort(), d2collection.getCollectionTypeCrossSectional(),
				d2collection.getCollectionTypeLongitudinal(), d2collection.getCollectionTypeTwinStudy(), d2collection.getCollectionTypeQualityControl(),
				d2collection.getCollectionTypePopulationBased(), d2collection.getCollectionTypeDiseaseSpecific(), d2collection.getCollectionTypeBirthCohort(),
				d2collection.getCollectionTypeOther(), d2collection.getCollectionOrderOfMagnitude(), d2collection.getBioresourceReference(), d2collection.getContactIDRef(),
				d2collection.getContactPriority(), d2collection.getBiobankNetworkIDRef(), d2collection.getGeoLatitude(), d2collection.getGeoLongitude(),
				d2collection.getCollaborationPartnersCommercial(), d2collection.getCollaborationPartnersNonforprofit(), d2collection.getCollectionAcronym(),
				d2collection.getCollectionDescription(), d2collection.getCollectionSexMale(), d2collection.getCollectionSexFemale(), d2collection.getCollectionSexUnknown(),
				d2collection.getCollectionSexUndiferrentiated(), d2collection.getCollectionAgeLow(), d2collection.getCollectionAgeLow(), d2collection.getCollectionAgeUnit(),
				d2collection.getCollectionAvailableBiologicalSamples(), d2collection.getCollectionAvailableSurveyData(), d2collection.getCollectionAvailableImagingData(),
				d2collection.getCollectionAvailableMedicalRecords(), d2collection.getCollectionAvailableNationalRegistries(), d2collection.getCollectionAvailableGenealogicalRecords(),
				d2collection.getCollectionAvailablePhysioBiochemMeasurements(), d2collection.getCollectionAvailableOther(), d2collection.getTemperatureRoom(),
				d2collection.getTemperature2to10(), d2collection.getTemperature18to35(), d2collection.getTemperature60to85(), d2collection.getTemperatureLN(),
				d2collection.getTemperatureOther(), d2collection.getDiagnosisAvailable(), d2collection.getCollectionHeadFirstName(), d2collection.getCollectionHeadLastName(),
				d2collection.getCollectionHeadRole(), d2collection.getCollectionSampleAccessFee(), d2collection.getCollectionDataAccessJointProjects(),
				d2collection.getCollectionSampleAccessDescription(), d2collection.getCollectionSampleAccessURI(), d2collection.getCollectionDataAccessFee(),
				d2collection.getCollectionDataAccessJointProjects(), d2collection.getCollectionSampleAccessDescription(), d2collection.getCollectionDataAccessURI(),
				d2collection.getCollectionSize(), d2collection.getCollectionSizeTimestamp(), serviceContext);
	}
	
	/**
	 * 
	 * @param collectionId
	 * @param companyId
	 * @param groupId
	 * @param userId
	 * @param ldapupdateuuid
	 * @param bbmricollectionID
	 * @param bbmribiobankID
	 * @param collectionName
	 * @param materialStoredDNA
	 * @param materialStoredPlasma
	 * @param materialStoredSerum
	 * @param materialStoredUrine
	 * @param materialStoredSaliva
	 * @param materialStoredFaeces
	 * @param materialStoredRNA
	 * @param materialStoredBlood
	 * @param materialStoredTissueFrozen
	 * @param materialStoredTissueFFPE
	 * @param materialStoredImmortalizedCellLines
	 * @param materialStoredIsolatedPathogen
	 * @param materialStoredOther
	 * @param collectionTypeCaseControl
	 * @param collectionTypeCohort
	 * @param collectionTypeCrossSectional
	 * @param collectionTypeLongitudinal
	 * @param collectionTypeTwinStudy
	 * @param collectionTypeQualityControl
	 * @param collectionTypePopulationBased
	 * @param collectionTypeDiseaseSpecific
	 * @param collectionTypeBirthCohort
	 * @param collectionTypeOther
	 * @param collectionOrderOfMagnitude
	 * @param bioresourceReference
	 * @param contactIDRef
	 * @param contactPriority
	 * @param biobankNetworkIDRef
	 * @param geoLatitude
	 * @param geoLongitude
	 * @param collaborationPartnersCommercial
	 * @param collaborationPartnersNonforprofit
	 * @param collectionAcronym
	 * @param collectionDescription
	 * @param collectionSexMale
	 * @param collectionSexFemale
	 * @param collectionSexUnknown
	 * @param collectionSexUndiferrentiated
	 * @param collectionAgeLow
	 * @param collectionAgeHigh
	 * @param collectionAgeUnit
	 * @param collectionAvailableBiologicalSamples
	 * @param collectionAvailableSurveyData
	 * @param collectionAvailableImagingData
	 * @param collectionAvailableMedicalRecords
	 * @param collectionAvailableNationalRegistries
	 * @param collectionAvailableGenealogicalRecords
	 * @param collectionAvailablePhysioBiochemMeasurements
	 * @param collectionAvailableOther
	 * @param temperatureRoom
	 * @param temperature2to10
	 * @param temperature18to35
	 * @param temperature60to85
	 * @param temperatureLN
	 * @param temperatureOther
	 * @param diagnosisAvailable
	 * @param collectionHeadFirstName
	 * @param collectionHeadLastName
	 * @param collectionHeadRole
	 * @param collectionSampleAccessFee
	 * @param collectionSampleAccessJointProjects
	 * @param collectionSampleAccessDescription
	 * @param collectionSampleAccessURI
	 * @param collectionDataAccessFee
	 * @param collectionDataAccessJointProjects
	 * @param collectionDataAccessDescription
	 * @param collectionDataAccessURI
	 * @param collectionSize
	 * @param collectionSizeTimestamp
	 * @param serviceContext
	 * @return
	 */
	public D2Collection addD2Collection(long collectionId, long companyId, long groupId, long userId, long biobankId, long parentcollectionId, String ldapupdateuuid,
			String bbmricollectionID, String bbmriparentcollectionID, String bbmribiobankID, String collectionName, boolean materialStoredDNA, boolean materialStoredPlasma,
			boolean materialStoredSerum, boolean materialStoredUrine, boolean materialStoredSaliva, boolean materialStoredFaeces,
			boolean materialStoredRNA, boolean materialStoredBlood, boolean materialStoredTissueFrozen, boolean materialStoredTissueFFPE,
			boolean materialStoredImmortalizedCellLines, boolean materialStoredIsolatedPathogen, String materialStoredOther,
			boolean collectionTypeCaseControl, boolean collectionTypeCohort, boolean collectionTypeCrossSectional, boolean collectionTypeLongitudinal, 
			boolean collectionTypeTwinStudy, boolean collectionTypeQualityControl, boolean collectionTypePopulationBased, boolean collectionTypeDiseaseSpecific,
			boolean collectionTypeBirthCohort, String collectionTypeOther, long collectionOrderOfMagnitude, String bioresourceReference, String contactIDRef,
			long contactPriority, String biobankNetworkIDRef, String geoLatitude, String geoLongitude, boolean collaborationPartnersCommercial,
			boolean collaborationPartnersNonforprofit, String collectionAcronym, String collectionDescription, boolean collectionSexMale,
			boolean collectionSexFemale, boolean collectionSexUnknown, boolean collectionSexUndiferrentiated, long collectionAgeLow, long collectionAgeHigh,
			String collectionAgeUnit, boolean collectionAvailableBiologicalSamples, boolean collectionAvailableSurveyData, boolean collectionAvailableImagingData,
			boolean collectionAvailableMedicalRecords, boolean collectionAvailableNationalRegistries, boolean collectionAvailableGenealogicalRecords,
			boolean collectionAvailablePhysioBiochemMeasurements, String collectionAvailableOther, boolean temperatureRoom, boolean temperature2to10,
			boolean temperature18to35, boolean temperature60to85, boolean temperatureLN, String temperatureOther, String diagnosisAvailable, 
			String collectionHeadFirstName, String collectionHeadLastName, String collectionHeadRole, boolean collectionSampleAccessFee, boolean collectionSampleAccessJointProjects,
			String collectionSampleAccessDescription, String collectionSampleAccessURI, boolean collectionDataAccessFee, boolean collectionDataAccessJointProjects,
			String collectionDataAccessDescription, String collectionDataAccessURI, long collectionSize, long collectionSizeTimestamp, ServiceContext serviceContext) {
		try {
			// Set Primary Key
			if(collectionId == 0) {
				collectionId = counterLocalService.increment();
			}
			D2Collection d2collection = d2CollectionPersistence.create(collectionId);
			// Set provenance fields
			if(companyId == 0) {
				companyId =serviceContext.getCompanyId();
			}
			if(groupId == 0) {
				groupId = serviceContext.getScopeGroupId();
			}
			if(userId == 0) {
				userId =serviceContext.getUserId();
			}
			Date now = new Date();
			d2collection.setCreateDate(serviceContext.getCreateDate(now));
			d2collection.setModifiedDate(serviceContext.getModifiedDate(now));
			d2collection.setUserId(userId);
			d2collection.setGroupId(groupId);
			d2collection.setCompanyId(companyId);
			d2collection.setUpdateuuid(ldapupdateuuid);
			d2collection.setBiobankId(biobankId);
			d2collection.setParentd2collectionId(parentcollectionId);
			// Set mandatory fields
			d2collection.setBbmribiobankID(bbmribiobankID);
			d2collection.setBbmricollectionID(bbmricollectionID);
			d2collection.setBbmriparentcollectionID(bbmriparentcollectionID);
			d2collection.setContactIDRef(contactIDRef);
			d2collection.setCollectionName(collectionName);
			d2collection.setMaterialStoredDNA(materialStoredDNA);
			d2collection.setMaterialStoredPlasma(materialStoredPlasma);
			d2collection.setMaterialStoredSerum(materialStoredSerum);
			d2collection.setMaterialStoredUrine(materialStoredUrine);
			d2collection.setMaterialStoredSaliva(materialStoredSaliva);
			d2collection.setMaterialStoredFaeces(materialStoredFaeces);
			d2collection.setMaterialStoredRNA(materialStoredRNA);
			d2collection.setMaterialStoredBlood(materialStoredBlood);
			d2collection.setMaterialStoredTissueFrozen(materialStoredTissueFrozen);
			d2collection.setMaterialStoredTissueFFPE(materialStoredTissueFFPE);
			d2collection.setMaterialStoredImmortalizedCellLines(materialStoredImmortalizedCellLines);
			d2collection.setMaterialStoredIsolatedPathogen(materialStoredIsolatedPathogen);
			d2collection.setMaterialStoredOther(materialStoredOther);
			d2collection.setCollectionTypeCaseControl(collectionTypeCaseControl);
			d2collection.setCollectionTypeCohort(collectionTypeCohort);
			d2collection.setCollectionTypeCrossSectional(collectionTypeCrossSectional);
			d2collection.setCollectionTypeLongitudinal(collectionTypeLongitudinal);
			d2collection.setCollectionTypeTwinStudy(collectionTypeTwinStudy);
			d2collection.setCollectionTypeQualityControl(collectionTypeQualityControl);
			d2collection.setCollectionTypePopulationBased(collectionTypePopulationBased);
			d2collection.setCollectionTypeDiseaseSpecific(collectionTypeDiseaseSpecific);
			d2collection.setCollectionTypeBirthCohort(collectionTypeBirthCohort);
			d2collection.setCollectionTypeOther(collectionTypeOther);
			d2collection.setCollectionOrderOfMagnitude(collectionOrderOfMagnitude);
			// Optional Fields
			d2collection.setBioresourceReference(bioresourceReference);
			d2collection.setContactIDRef(contactIDRef);
			d2collection.setContactPriority(contactPriority);
			d2collection.setBiobankNetworkIDRef(biobankNetworkIDRef);
			d2collection.setGeoLatitude(geoLatitude);
			d2collection.setGeoLongitude(geoLongitude);
			d2collection.setCollaborationPartnersCommercial(collaborationPartnersCommercial);
			d2collection.setCollaborationPartnersNonforprofit(collaborationPartnersNonforprofit);
			d2collection.setCollectionAcronym(collectionAcronym);
			d2collection.setCollectionDescription(collectionDescription);
			d2collection.setCollectionSexMale(collectionSexMale);
			d2collection.setCollectionSexFemale(collectionSexFemale);
			d2collection.setCollectionSexUnknown(collectionSexUnknown);
			d2collection.setCollectionSexUndiferrentiated(collectionSexUndiferrentiated);
			d2collection.setCollectionAgeLow(collectionAgeLow);
			d2collection.setCollectionAgeHigh(collectionAgeHigh);
			d2collection.setCollectionAgeUnit(collectionAgeUnit);
			d2collection.setCollectionAvailableBiologicalSamples(collectionAvailableBiologicalSamples);
			d2collection.setCollectionAvailableSurveyData(collectionAvailableSurveyData);
			d2collection.setCollectionAvailableImagingData(collectionAvailableImagingData);
			d2collection.setCollectionAvailableMedicalRecords(collectionAvailableMedicalRecords);
			d2collection.setCollectionAvailableNationalRegistries(collectionAvailableNationalRegistries);
			d2collection.setCollectionAvailableGenealogicalRecords(collectionAvailableGenealogicalRecords);
			d2collection.setCollectionAvailablePhysioBiochemMeasurements(collectionAvailablePhysioBiochemMeasurements);
			d2collection.setCollectionAvailableOther(collectionAvailableOther);
			d2collection.setTemperatureRoom(temperatureRoom);
			d2collection.setTemperature2to10(temperature2to10);
			d2collection.setTemperature18to35(temperature18to35);
			d2collection.setTemperature60to85(temperature60to85);
			d2collection.setTemperatureLN(temperatureLN);
			d2collection.setTemperatureOther(temperatureOther);
			d2collection.setDiagnosisAvailable(diagnosisAvailable);
			d2collection.setCollectionHeadFirstName(collectionHeadFirstName);
			d2collection.setCollectionHeadLastName(collectionHeadLastName);
			d2collection.setCollectionHeadRole(collectionHeadRole);
			d2collection.setCollectionSampleAccessFee(collectionSampleAccessFee);
			d2collection.setCollectionSampleAccessJointProjects(collectionSampleAccessJointProjects);
			d2collection.setCollectionSampleAccessDescription(collectionSampleAccessDescription);
			d2collection.setCollectionSampleAccessURI(collectionSampleAccessURI);
			d2collection.setCollectionDataAccessFee(collectionDataAccessFee);
			d2collection.setCollectionDataAccessJointProjects(collectionDataAccessJointProjects);
			d2collection.setCollectionDataAccessDescription(collectionDataAccessDescription);
			d2collection.setCollectionDataAccessURI(collectionDataAccessURI);
			d2collection.setCollectionSize(collectionSize);
			d2collection.setCollectionSizeTimestamp(collectionSizeTimestamp);
			return d2CollectionPersistence.update(d2collection);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addD2Collection] Error adding D2Collection.");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param d2collection
	 * @param serviceContext
	 * @return
	 */
	public D2Collection updateD2Collection(D2Collection d2collection, ServiceContext serviceContext) {
		try {
			Date now = new Date();
			d2collection.setModifiedDate(serviceContext.getModifiedDate(now));
	        // Liferay Expension Fields
			d2collection.setExpandoBridgeAttributes(serviceContext);
			return d2CollectionPersistence.update(d2collection);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::updateD2Collection] Error updating D2Collection.");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param collectionId
	 * @param companyId
	 * @param groupId
	 * @param userId
	 * @param ldapupdateuuid
	 * @param bbmricollectionID
	 * @param bbmribiobankID
	 * @param collectionName
	 * @param materialStoredDNA
	 * @param materialStoredPlasma
	 * @param materialStoredSerum
	 * @param materialStoredUrine
	 * @param materialStoredSaliva
	 * @param materialStoredFaeces
	 * @param materialStoredRNA
	 * @param materialStoredBlood
	 * @param materialStoredTissueFrozen
	 * @param materialStoredTissueFFPE
	 * @param materialStoredImmortalizedCellLines
	 * @param materialStoredIsolatedPathogen
	 * @param materialStoredOther
	 * @param collectionTypeCaseControl
	 * @param collectionTypeCohort
	 * @param collectionTypeCrossSectional
	 * @param collectionTypeLongitudinal
	 * @param collectionTypeTwinStudy
	 * @param collectionTypeQualityControl
	 * @param collectionTypePopulationBased
	 * @param collectionTypeDiseaseSpecific
	 * @param collectionTypeBirthCohort
	 * @param collectionTypeOther
	 * @param collectionOrderOfMagnitude
	 * @param bioresourceReference
	 * @param contactIDRef
	 * @param contactPriority
	 * @param biobankNetworkIDRef
	 * @param geoLatitude
	 * @param geoLongitude
	 * @param collaborationPartnersCommercial
	 * @param collaborationPartnersNonforprofit
	 * @param collectionAcronym
	 * @param collectionDescription
	 * @param collectionSexMale
	 * @param collectionSexFemale
	 * @param collectionSexUnknown
	 * @param collectionSexUndiferrentiated
	 * @param collectionAgeLow
	 * @param collectionAgeHigh
	 * @param collectionAgeUnit
	 * @param collectionAvailableBiologicalSamples
	 * @param collectionAvailableSurveyData
	 * @param collectionAvailableImagingData
	 * @param collectionAvailableMedicalRecords
	 * @param collectionAvailableNationalRegistries
	 * @param collectionAvailableGenealogicalRecords
	 * @param collectionAvailablePhysioBiochemMeasurements
	 * @param collectionAvailableOther
	 * @param temperatureRoom
	 * @param temperature2to10
	 * @param temperature18to35
	 * @param temperature60to85
	 * @param temperatureLN
	 * @param temperatureOther
	 * @param diagnosisAvailable
	 * @param collectionHeadFirstName
	 * @param collectionHeadLastName
	 * @param collectionHeadRole
	 * @param collectionSampleAccessFee
	 * @param collectionSampleAccessJointProjects
	 * @param collectionSampleAccessDescription
	 * @param collectionSampleAccessURI
	 * @param collectionDataAccessFee
	 * @param collectionDataAccessJointProjects
	 * @param collectionDataAccessDescription
	 * @param collectionDataAccessURI
	 * @param collectionSize
	 * @param collectionSizeTimestamp
	 * @param serviceContext
	 * @return
	 */
	public D2Collection updateD2Collection(long collectionId, long companyId, long groupId, long userId, long biobankId, long parentcollectionId, String ldapupdateuuid,
			String bbmricollectionID, String bbmriparentcollectionID, String bbmribiobankID, String collectionName, boolean materialStoredDNA, boolean materialStoredPlasma,
			boolean materialStoredSerum, boolean materialStoredUrine, boolean materialStoredSaliva, boolean materialStoredFaeces,
			boolean materialStoredRNA, boolean materialStoredBlood, boolean materialStoredTissueFrozen, boolean materialStoredTissueFFPE,
			boolean materialStoredImmortalizedCellLines, boolean materialStoredIsolatedPathogen, String materialStoredOther,
			boolean collectionTypeCaseControl, boolean collectionTypeCohort, boolean collectionTypeCrossSectional, boolean collectionTypeLongitudinal, 
			boolean collectionTypeTwinStudy, boolean collectionTypeQualityControl, boolean collectionTypePopulationBased, boolean collectionTypeDiseaseSpecific,
			boolean collectionTypeBirthCohort, String collectionTypeOther, long collectionOrderOfMagnitude, String bioresourceReference, String contactIDRef,
			long contactPriority, String biobankNetworkIDRef, String geoLatitude, String geoLongitude, boolean collaborationPartnersCommercial,
			boolean collaborationPartnersNonforprofit, String collectionAcronym, String collectionDescription, boolean collectionSexMale,
			boolean collectionSexFemale, boolean collectionSexUnknown, boolean collectionSexUndiferrentiated, long collectionAgeLow, long collectionAgeHigh,
			String collectionAgeUnit, boolean collectionAvailableBiologicalSamples, boolean collectionAvailableSurveyData, boolean collectionAvailableImagingData,
			boolean collectionAvailableMedicalRecords, boolean collectionAvailableNationalRegistries, boolean collectionAvailableGenealogicalRecords,
			boolean collectionAvailablePhysioBiochemMeasurements, String collectionAvailableOther, boolean temperatureRoom, boolean temperature2to10,
			boolean temperature18to35, boolean temperature60to85, boolean temperatureLN, String temperatureOther, String diagnosisAvailable, 
			String collectionHeadFirstName, String collectionHeadLastName, String collectionHeadRole, boolean collectionSampleAccessFee, boolean collectionSampleAccessJointProjects,
			String collectionSampleAccessDescription, String collectionSampleAccessURI, boolean collectionDataAccessFee, boolean collectionDataAccessJointProjects,
			String collectionDataAccessDescription, String collectionDataAccessURI, long collectionSize, long collectionSizeTimestamp, ServiceContext serviceContext) {
		try {
			//D2Collection d2collection = d2CollectionPersistence.create(collectionId);
			D2Collection d2collection = D2CollectionLocalServiceUtil.getD2Collection(collectionId);
			// Set provenance fields
			if(companyId == 0) {
				companyId =serviceContext.getCompanyId();
			}
			if(groupId == 0) {
				groupId = serviceContext.getScopeGroupId();
			}
			if(userId == 0) {
				userId =serviceContext.getUserId();
			}
			Date now = new Date();
			d2collection.setModifiedDate(serviceContext.getModifiedDate(now));
			d2collection.setUserId(userId);
			d2collection.setGroupId(groupId);
			d2collection.setCompanyId(companyId);
			d2collection.setBiobankId(biobankId);
			d2collection.setParentd2collectionId(parentcollectionId);
			// Set mandatory fields
			d2collection.setBbmribiobankID(bbmribiobankID);
			d2collection.setBbmricollectionID(bbmricollectionID);
			d2collection.setBbmriparentcollectionID(bbmriparentcollectionID);
			d2collection.setContactIDRef(contactIDRef);
			d2collection.setCollectionName(collectionName);
			d2collection.setMaterialStoredDNA(materialStoredDNA);
			d2collection.setMaterialStoredPlasma(materialStoredPlasma);
			d2collection.setMaterialStoredSerum(materialStoredSerum);
			d2collection.setMaterialStoredUrine(materialStoredUrine);
			d2collection.setMaterialStoredSaliva(materialStoredSaliva);
			d2collection.setMaterialStoredFaeces(materialStoredFaeces);
			d2collection.setMaterialStoredRNA(materialStoredRNA);
			d2collection.setMaterialStoredBlood(materialStoredBlood);
			d2collection.setMaterialStoredTissueFrozen(materialStoredTissueFrozen);
			d2collection.setMaterialStoredTissueFFPE(materialStoredTissueFFPE);
			d2collection.setMaterialStoredImmortalizedCellLines(materialStoredImmortalizedCellLines);
			d2collection.setMaterialStoredIsolatedPathogen(materialStoredIsolatedPathogen);
			d2collection.setMaterialStoredOther(materialStoredOther);
			d2collection.setCollectionTypeCaseControl(collectionTypeCaseControl);
			d2collection.setCollectionTypeCohort(collectionTypeCohort);
			d2collection.setCollectionTypeCrossSectional(collectionTypeCrossSectional);
			d2collection.setCollectionTypeLongitudinal(collectionTypeLongitudinal);
			d2collection.setCollectionTypeTwinStudy(collectionTypeTwinStudy);
			d2collection.setCollectionTypeQualityControl(collectionTypeQualityControl);
			d2collection.setCollectionTypePopulationBased(collectionTypePopulationBased);
			d2collection.setCollectionTypeDiseaseSpecific(collectionTypeDiseaseSpecific);
			d2collection.setCollectionTypeBirthCohort(collectionTypeBirthCohort);
			d2collection.setCollectionTypeOther(collectionTypeOther);
			d2collection.setCollectionOrderOfMagnitude(collectionOrderOfMagnitude);
			// Optional Fields
			d2collection.setBioresourceReference(bioresourceReference);
			d2collection.setContactIDRef(contactIDRef);
			d2collection.setContactPriority(contactPriority);
			d2collection.setBiobankNetworkIDRef(biobankNetworkIDRef);
			d2collection.setGeoLatitude(geoLatitude);
			d2collection.setGeoLongitude(geoLongitude);
			d2collection.setCollaborationPartnersCommercial(collaborationPartnersCommercial);
			d2collection.setCollaborationPartnersNonforprofit(collaborationPartnersNonforprofit);
			d2collection.setCollectionAcronym(collectionAcronym);
			d2collection.setCollectionDescription(collectionDescription);
			d2collection.setCollectionSexMale(collectionSexMale);
			d2collection.setCollectionSexFemale(collectionSexFemale);
			d2collection.setCollectionSexUnknown(collectionSexUnknown);
			d2collection.setCollectionSexUndiferrentiated(collectionSexUndiferrentiated);
			d2collection.setCollectionAgeLow(collectionAgeLow);
			d2collection.setCollectionAgeHigh(collectionAgeHigh);
			d2collection.setCollectionAgeUnit(collectionAgeUnit);
			d2collection.setCollectionAvailableBiologicalSamples(collectionAvailableBiologicalSamples);
			d2collection.setCollectionAvailableSurveyData(collectionAvailableSurveyData);
			d2collection.setCollectionAvailableImagingData(collectionAvailableImagingData);
			d2collection.setCollectionAvailableMedicalRecords(collectionAvailableMedicalRecords);
			d2collection.setCollectionAvailableNationalRegistries(collectionAvailableNationalRegistries);
			d2collection.setCollectionAvailableGenealogicalRecords(collectionAvailableGenealogicalRecords);
			d2collection.setCollectionAvailablePhysioBiochemMeasurements(collectionAvailablePhysioBiochemMeasurements);
			d2collection.setCollectionAvailableOther(collectionAvailableOther);
			d2collection.setTemperatureRoom(temperatureRoom);
			d2collection.setTemperature2to10(temperature2to10);
			d2collection.setTemperature18to35(temperature18to35);
			d2collection.setTemperature60to85(temperature60to85);
			d2collection.setTemperatureLN(temperatureLN);
			d2collection.setTemperatureOther(temperatureOther);
			d2collection.setDiagnosisAvailable(diagnosisAvailable);
			d2collection.setCollectionHeadFirstName(collectionHeadFirstName);
			d2collection.setCollectionHeadLastName(collectionHeadLastName);
			d2collection.setCollectionHeadRole(collectionHeadRole);
			d2collection.setCollectionSampleAccessFee(collectionSampleAccessFee);
			d2collection.setCollectionSampleAccessJointProjects(collectionSampleAccessJointProjects);
			d2collection.setCollectionSampleAccessDescription(collectionSampleAccessDescription);
			d2collection.setCollectionSampleAccessURI(collectionSampleAccessURI);
			d2collection.setCollectionDataAccessFee(collectionDataAccessFee);
			d2collection.setCollectionDataAccessJointProjects(collectionDataAccessJointProjects);
			d2collection.setCollectionDataAccessDescription(collectionDataAccessDescription);
			d2collection.setCollectionDataAccessURI(collectionDataAccessURI);
			d2collection.setCollectionSize(collectionSize);
			d2collection.setCollectionSizeTimestamp(collectionSizeTimestamp);
			return d2CollectionPersistence.update(d2collection);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::updateD2Collection] Error updating D2Collection.");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param groupId
	 * @param bbmricollectionID
	 * @param bbmribiobankID
	 * @return
	 */
	public D2Collection getD2CollectionByBBMRIERICID(long groupId, String bbmricollectionID, String bbmribiobankID) {
		try {
			return d2CollectionPersistence.findByCollectionBBMRIERICID(groupId, bbmricollectionID, bbmribiobankID);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [" + classpath_ + "::getD2CollectionByBBMRIERICID] No Collection exists with (groupId: " + groupId + ",  bbmricollectionID: " + bbmricollectionID + ",  bbmribiobankID: " + bbmribiobankID + ".");
		}
		return null;
	}
	
	/**
	 * 
	 * @param biobankId
	 * @return
	 */
	public List<D2Collection> getD2CollectionByBiobankId(long biobankId) {
		try {
			return d2CollectionPersistence.findByCollectionForD2Biobank(biobankId);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [" + classpath_ + "::getD2CollectionByBiobankId] No Collections exists with (biobankId: " + biobankId + ").");
		}
		return null;
	}
	
	/**
	 * 
	 */
	public List<D2Collection> getRootD2Collection(long biobankId) {
		try {
			return d2CollectionPersistence.findByRootCollectionForD2Biobank(biobankId, 0);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [" + classpath_ + "::getRootD2Collection] No Collections exists with (biobankId: " + biobankId + ").");
		}
		return null;
	}
	
	/**
	 * 
	 * @param biobankId
	 * @param collectionId
	 * @return
	 */
	public List<D2Collection> getChildD2Collection(long biobankId, long collectionId) {
		try {
			return d2CollectionPersistence.findByRootCollectionForD2Biobank(biobankId, collectionId);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [" + classpath_ + "::getChildD2Collection] No Collections exists with (biobankId: " + biobankId + ", collectionId: " + collectionId + ").");
		}
		return null;
	}
	
	/**
	 * 
	 * @param biobankId
	 * @return
	 */
	public int getD2CollectionByBiobankIdCount(long biobankId) {
		try {
			return d2CollectionPersistence.findByCollectionForD2Biobank(biobankId).size();
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [" + classpath_ + "::getD2CollectionByBiobankIdCount] No Collections exists with (biobankId: " + biobankId + ".");
		}
		return 0;
	}
	
	/**
	 * 
	 * @param d2collection
	 * @param attrs
	 * @return
	 */
	public D2Collection getD2CollectionFromLDAP(D2Collection d2collection, Attributes attrs, SearchResult sr, boolean contact) {
		if(d2collection == null) {
			d2collection = new D2CollectionImpl();
		}
		/*String[] ldapid = LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionID")).split(":");
		String bbmricollectionID = LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionID"));
		String bbmribiobankID = "";
		String bbmriparentcollectionID = "";
		int idcount = 0;
		for(int count = ldapid.length-1; count >= 0; count--) {
			idcount ++;
			if(ldapid[count].equals("collection")) {
				if(idcount > 2) {
					for(int parentcounter = 0; parentcounter < ldapid.length-1; parentcounter++) {
						if(bbmriparentcollectionID.length() != 0) {
							bbmriparentcollectionID += ":";
						}
						bbmriparentcollectionID += ldapid[parentcounter];
					}
					break;
				} else {
					break;
				}
			}
		}
		for(int count = 0; count < ldapid.length-idcount; count++) {
			if(bbmribiobankID.length() != 0) {
				bbmribiobankID += ":";
			}
			bbmribiobankID += ldapid[count];
		}*/
		
		String id_string = sr.getNameInNamespace();
		String bbmricollectionID = LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionID"));
		String bbmribiobankID = "";
		String bbmriparentcollectionID = "";
		
		String[] ldapid = id_string.split(",");
		boolean firstid = true;
		for(String id : ldapid) {
			if(firstid) {
				firstid = false;
				continue;
			}
			String[] title_id = id.split("=");
			if(title_id[0].equalsIgnoreCase("collectionID") && bbmriparentcollectionID.equals("")) {
				bbmriparentcollectionID = title_id[1];
				continue;
			}
			if(title_id[0].equalsIgnoreCase("biobankID")) {
				bbmribiobankID = title_id[1];
				break;
			}
		}
		
		d2collection.setBbmribiobankID(bbmribiobankID);
		d2collection.setBbmricollectionID(bbmricollectionID);
		d2collection.setBbmriparentcollectionID(bbmriparentcollectionID);
		// Mandatory Fields
		d2collection.setCollectionName(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionName")));
		d2collection.setMaterialStoredDNA(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("materialStoredDNA")));
		d2collection.setMaterialStoredPlasma(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("materialStoredPlasma")));
		d2collection.setMaterialStoredSerum(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("materialStoredSerum")));
		d2collection.setMaterialStoredUrine(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("materialStoredUrine")));
		d2collection.setMaterialStoredSaliva(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("materialStoredSaliva")));
		d2collection.setMaterialStoredFaeces(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("materialStoredFaeces")));
		d2collection.setMaterialStoredRNA(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("materialStoredRNA")));
		d2collection.setMaterialStoredBlood(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("materialStoredBlood")));
		d2collection.setMaterialStoredTissueFrozen(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("materialStoredTissueFrozen")));
		d2collection.setMaterialStoredTissueFFPE(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("materialStoredTissueFFPE")));
		d2collection.setMaterialStoredImmortalizedCellLines(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("materialStoredImmortalizedCellLines")));
		d2collection.setMaterialStoredIsolatedPathogen(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("materialStoredIsolatedPathogen")));
		d2collection.setMaterialStoredOther(LDAPAttributeEscaper.getAttributeValues(attrs.get("materialStoredOther")));
		d2collection.setCollectionTypeCaseControl(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionTypeCaseControl")));
		d2collection.setCollectionTypeCohort(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionTypeCohort")));
		d2collection.setCollectionTypeCrossSectional(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionTypeCrossSectional")));
		d2collection.setCollectionTypeLongitudinal(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionTypeLongitudinal")));
		d2collection.setCollectionTypeTwinStudy(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionTypeTwinStudy")));
		d2collection.setCollectionTypeQualityControl(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionTypeQualityControl")));
		d2collection.setCollectionTypePopulationBased(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionTypePopulationBased")));
		d2collection.setCollectionTypeDiseaseSpecific(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionTypeDiseaseSpecific")));
		d2collection.setCollectionTypeBirthCohort(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionTypeBirthCohort")));
		d2collection.setCollectionTypeOther(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionTypeOther")));
		d2collection.setCollectionOrderOfMagnitude(LDAPAttributeEscaper.getAttributeValuesLong(attrs.get("collectionOrderOfMagnitude")));
		// Optional Fields
		d2collection.setBioresourceReference(LDAPAttributeEscaper.getAttributeValues(attrs.get("bioresourceReference")));
		if(contact) {
			d2collection.setContactIDRef(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactIDRef")));
			d2collection.setContactPriority(LDAPAttributeEscaper.getAttributeValuesLong(attrs.get("contactPriority")));
		}
		d2collection.setBiobankNetworkIDRef(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankNetworkIDRef")));
		d2collection.setGeoLatitude(LDAPAttributeEscaper.getAttributeValues(attrs.get("geoLatitude")));
		d2collection.setGeoLongitude(LDAPAttributeEscaper.getAttributeValues(attrs.get("geoLongitude")));
		d2collection.setCollaborationPartnersCommercial(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collaborationPartnersCommercial")));
		d2collection.setCollaborationPartnersNonforprofit(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collaborationPartnersNonforprofit")));
		d2collection.setCollectionAcronym(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionAcronym")));
		d2collection.setCollectionDescription(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionDescription")));
		d2collection.setCollectionSexMale(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionSexMale")));
		d2collection.setCollectionSexFemale(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionSexFemale")));
		d2collection.setCollectionSexUnknown(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionSexUnknown")));
		d2collection.setCollectionSexUndiferrentiated(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionSexUndiferrentiated")));
		d2collection.setCollectionAgeLow(LDAPAttributeEscaper.getAttributeValuesLong(attrs.get("collectionAgeLow")));
		d2collection.setCollectionAgeHigh(LDAPAttributeEscaper.getAttributeValuesLong(attrs.get("collectionAgeHigh")));
		d2collection.setCollectionAgeUnit(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionAgeUnit")));
		d2collection.setCollectionAvailableBiologicalSamples(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionAvailableBiologicalSamples")));
		d2collection.setCollectionAvailableSurveyData(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionAvailableSurveyData")));
		d2collection.setCollectionAvailableImagingData(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionAvailableImagingData")));
		d2collection.setCollectionAvailableMedicalRecords(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionAvailableMedicalRecords")));
		d2collection.setCollectionAvailableNationalRegistries(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionAvailableNationalRegistries")));
		d2collection.setCollectionAvailableGenealogicalRecords(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionAvailableGenealogicalRecords")));
		d2collection.setCollectionAvailablePhysioBiochemMeasurements(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionAvailablePhysioBiochemMeasurements")));
		d2collection.setCollectionAvailableOther(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionAvailableOther")));
		d2collection.setTemperatureRoom(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("temperatureRoom")));
		d2collection.setTemperature2to10(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("temperature2to10")));
		d2collection.setTemperature18to35(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("temperature18to35")));
		d2collection.setTemperature60to85(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("temperature60to85")));
		d2collection.setTemperatureLN(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("temperatureLN")));
		d2collection.setTemperatureOther(LDAPAttributeEscaper.getAttributeValues(attrs.get("temperatureOther")));
		d2collection.setDiagnosisAvailable(LDAPAttributeEscaper.getAttributeValues(attrs.get("diagnosisAvailable")));
		d2collection.setCollectionHeadFirstName(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionHeadFirstName")));
		d2collection.setCollectionHeadLastName(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionHeadLastName")));
		d2collection.setCollectionHeadRole(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionHeadRole")));
		d2collection.setCollectionSampleAccessFee(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionSampleAccessFee")));
		d2collection.setCollectionSampleAccessJointProjects(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionSampleAccessJointProjects")));
		d2collection.setCollectionSampleAccessDescription(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionSampleAccessDescription")));
		d2collection.setCollectionSampleAccessURI(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionSampleAccessURI")));
		d2collection.setCollectionDataAccessFee(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionDataAccessFee")));
		d2collection.setCollectionDataAccessJointProjects(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collectionDataAccessJointProjects")));
		d2collection.setCollectionDataAccessDescription(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionDataAccessDescription")));
		d2collection.setCollectionDataAccessURI(LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionDataAccessURI")));
		d2collection.setCollectionSize(LDAPAttributeEscaper.getAttributeValuesLong(attrs.get("collectionSize")));
		d2collection.setCollectionSizeTimestamp(LDAPAttributeEscaper.getAttributeValuesLong(attrs.get("collectionSizeTimestamp")));
		return d2collection;
	}
	
	/**
	 * 
	 * @param groupId
	 * @param ldapupdateuuid
	 * @return
	 */
	public List<D2Collection> getLDAPNotUpdatedCollection(long groupId, String ldapupdateuuid) {
		try {
			return d2CollectionPersistence.findByNotUUID(groupId, ldapupdateuuid);
		} catch (SystemException e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::getLDAPNotUpdatedBiobanks] Error getting Biobank List with not updateId: " + ldapupdateuuid + ".");
			e.printStackTrace();
		}
		return null;
	}
	
}