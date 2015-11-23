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

package at.meduni.liferay.portlet.bbmrieric.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link D2CollectionLocalService}.
 *
 * @author reihsr
 * @see D2CollectionLocalService
 * @generated
 */
public class D2CollectionLocalServiceWrapper implements D2CollectionLocalService,
	ServiceWrapper<D2CollectionLocalService> {
	public D2CollectionLocalServiceWrapper(
		D2CollectionLocalService d2CollectionLocalService) {
		_d2CollectionLocalService = d2CollectionLocalService;
	}

	/**
	* Adds the d2 collection to the database. Also notifies the appropriate model listeners.
	*
	* @param d2Collection the d2 collection
	* @return the d2 collection that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection addD2Collection(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2Collection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.addD2Collection(d2Collection);
	}

	/**
	* Creates a new d2 collection with the primary key. Does not add the d2 collection to the database.
	*
	* @param d2collectionId the primary key for the new d2 collection
	* @return the new d2 collection
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection createD2Collection(
		long d2collectionId) {
		return _d2CollectionLocalService.createD2Collection(d2collectionId);
	}

	/**
	* Deletes the d2 collection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param d2collectionId the primary key of the d2 collection
	* @return the d2 collection that was removed
	* @throws PortalException if a d2 collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection deleteD2Collection(
		long d2collectionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.deleteD2Collection(d2collectionId);
	}

	/**
	* Deletes the d2 collection from the database. Also notifies the appropriate model listeners.
	*
	* @param d2Collection the d2 collection
	* @return the d2 collection that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection deleteD2Collection(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2Collection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.deleteD2Collection(d2Collection);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _d2CollectionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection fetchD2Collection(
		long d2collectionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.fetchD2Collection(d2collectionId);
	}

	/**
	* Returns the d2 collection with the matching UUID and company.
	*
	* @param uuid the d2 collection's UUID
	* @param companyId the primary key of the company
	* @return the matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection fetchD2CollectionByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.fetchD2CollectionByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the d2 collection matching the UUID and group.
	*
	* @param uuid the d2 collection's UUID
	* @param groupId the primary key of the group
	* @return the matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection fetchD2CollectionByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.fetchD2CollectionByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the d2 collection with the primary key.
	*
	* @param d2collectionId the primary key of the d2 collection
	* @return the d2 collection
	* @throws PortalException if a d2 collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection getD2Collection(
		long d2collectionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.getD2Collection(d2collectionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the d2 collection with the matching UUID and company.
	*
	* @param uuid the d2 collection's UUID
	* @param companyId the primary key of the company
	* @return the matching d2 collection
	* @throws PortalException if a matching d2 collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection getD2CollectionByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.getD2CollectionByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the d2 collection matching the UUID and group.
	*
	* @param uuid the d2 collection's UUID
	* @param groupId the primary key of the group
	* @return the matching d2 collection
	* @throws PortalException if a matching d2 collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection getD2CollectionByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.getD2CollectionByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the d2 collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d2 collections
	* @param end the upper bound of the range of d2 collections (not inclusive)
	* @return the range of d2 collections
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getD2Collections(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.getD2Collections(start, end);
	}

	/**
	* Returns the number of d2 collections.
	*
	* @return the number of d2 collections
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getD2CollectionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.getD2CollectionsCount();
	}

	/**
	* Updates the d2 collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param d2Collection the d2 collection
	* @return the d2 collection that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection updateD2Collection(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2Collection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2CollectionLocalService.updateD2Collection(d2Collection);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _d2CollectionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_d2CollectionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _d2CollectionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* @param d2collection
	* @param serviceContext
	* @return
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection addD2Collection(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2collection,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _d2CollectionLocalService.addD2Collection(d2collection,
			serviceContext);
	}

	/**
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
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection addD2Collection(
		long collectionId, long companyId, long groupId, long userId,
		long biobankId, long parentcollectionId,
		java.lang.String ldapupdateuuid, java.lang.String bbmricollectionID,
		java.lang.String bbmriparentcollectionID,
		java.lang.String bbmribiobankID, java.lang.String collectionName,
		boolean materialStoredDNA, boolean materialStoredPlasma,
		boolean materialStoredSerum, boolean materialStoredUrine,
		boolean materialStoredSaliva, boolean materialStoredFaeces,
		boolean materialStoredRNA, boolean materialStoredBlood,
		boolean materialStoredTissueFrozen, boolean materialStoredTissueFFPE,
		boolean materialStoredImmortalizedCellLines,
		boolean materialStoredIsolatedPathogen,
		java.lang.String materialStoredOther,
		boolean collectionTypeCaseControl, boolean collectionTypeCohort,
		boolean collectionTypeCrossSectional,
		boolean collectionTypeLongitudinal, boolean collectionTypeTwinStudy,
		boolean collectionTypeQualityControl,
		boolean collectionTypePopulationBased,
		boolean collectionTypeDiseaseSpecific,
		boolean collectionTypeBirthCohort,
		java.lang.String collectionTypeOther, long collectionOrderOfMagnitude,
		java.lang.String bioresourceReference, java.lang.String contactIDRef,
		long contactPriority, java.lang.String biobankNetworkIDRef,
		java.lang.String geoLatitude, java.lang.String geoLongitude,
		boolean collaborationPartnersCommercial,
		boolean collaborationPartnersNonforprofit,
		java.lang.String collectionAcronym,
		java.lang.String collectionDescription, boolean collectionSexMale,
		boolean collectionSexFemale, boolean collectionSexUnknown,
		boolean collectionSexUndiferrentiated, long collectionAgeLow,
		long collectionAgeHigh, java.lang.String collectionAgeUnit,
		boolean collectionAvailableBiologicalSamples,
		boolean collectionAvailableSurveyData,
		boolean collectionAvailableImagingData,
		boolean collectionAvailableMedicalRecords,
		boolean collectionAvailableNationalRegistries,
		boolean collectionAvailableGenealogicalRecords,
		boolean collectionAvailablePhysioBiochemMeasurements,
		java.lang.String collectionAvailableOther, boolean temperatureRoom,
		boolean temperature2to10, boolean temperature18to35,
		boolean temperature60to85, boolean temperatureLN,
		java.lang.String temperatureOther, java.lang.String diagnosisAvailable,
		java.lang.String collectionHeadFirstName,
		java.lang.String collectionHeadLastName,
		java.lang.String collectionHeadRole, boolean collectionSampleAccessFee,
		boolean collectionSampleAccessJointProjects,
		java.lang.String collectionSampleAccessDescription,
		java.lang.String collectionSampleAccessURI,
		boolean collectionDataAccessFee,
		boolean collectionDataAccessJointProjects,
		java.lang.String collectionDataAccessDescription,
		java.lang.String collectionDataAccessURI, long collectionSize,
		long collectionSizeTimestamp,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _d2CollectionLocalService.addD2Collection(collectionId,
			companyId, groupId, userId, biobankId, parentcollectionId,
			ldapupdateuuid, bbmricollectionID, bbmriparentcollectionID,
			bbmribiobankID, collectionName, materialStoredDNA,
			materialStoredPlasma, materialStoredSerum, materialStoredUrine,
			materialStoredSaliva, materialStoredFaeces, materialStoredRNA,
			materialStoredBlood, materialStoredTissueFrozen,
			materialStoredTissueFFPE, materialStoredImmortalizedCellLines,
			materialStoredIsolatedPathogen, materialStoredOther,
			collectionTypeCaseControl, collectionTypeCohort,
			collectionTypeCrossSectional, collectionTypeLongitudinal,
			collectionTypeTwinStudy, collectionTypeQualityControl,
			collectionTypePopulationBased, collectionTypeDiseaseSpecific,
			collectionTypeBirthCohort, collectionTypeOther,
			collectionOrderOfMagnitude, bioresourceReference, contactIDRef,
			contactPriority, biobankNetworkIDRef, geoLatitude, geoLongitude,
			collaborationPartnersCommercial, collaborationPartnersNonforprofit,
			collectionAcronym, collectionDescription, collectionSexMale,
			collectionSexFemale, collectionSexUnknown,
			collectionSexUndiferrentiated, collectionAgeLow, collectionAgeHigh,
			collectionAgeUnit, collectionAvailableBiologicalSamples,
			collectionAvailableSurveyData, collectionAvailableImagingData,
			collectionAvailableMedicalRecords,
			collectionAvailableNationalRegistries,
			collectionAvailableGenealogicalRecords,
			collectionAvailablePhysioBiochemMeasurements,
			collectionAvailableOther, temperatureRoom, temperature2to10,
			temperature18to35, temperature60to85, temperatureLN,
			temperatureOther, diagnosisAvailable, collectionHeadFirstName,
			collectionHeadLastName, collectionHeadRole,
			collectionSampleAccessFee, collectionSampleAccessJointProjects,
			collectionSampleAccessDescription, collectionSampleAccessURI,
			collectionDataAccessFee, collectionDataAccessJointProjects,
			collectionDataAccessDescription, collectionDataAccessURI,
			collectionSize, collectionSizeTimestamp, serviceContext);
	}

	/**
	* @param d2collection
	* @param serviceContext
	* @return
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection updateD2Collection(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2collection,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _d2CollectionLocalService.updateD2Collection(d2collection,
			serviceContext);
	}

	/**
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
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection updateD2Collection(
		long collectionId, long companyId, long groupId, long userId,
		long biobankId, long parentcollectionId,
		java.lang.String ldapupdateuuid, java.lang.String bbmricollectionID,
		java.lang.String bbmriparentcollectionID,
		java.lang.String bbmribiobankID, java.lang.String collectionName,
		boolean materialStoredDNA, boolean materialStoredPlasma,
		boolean materialStoredSerum, boolean materialStoredUrine,
		boolean materialStoredSaliva, boolean materialStoredFaeces,
		boolean materialStoredRNA, boolean materialStoredBlood,
		boolean materialStoredTissueFrozen, boolean materialStoredTissueFFPE,
		boolean materialStoredImmortalizedCellLines,
		boolean materialStoredIsolatedPathogen,
		java.lang.String materialStoredOther,
		boolean collectionTypeCaseControl, boolean collectionTypeCohort,
		boolean collectionTypeCrossSectional,
		boolean collectionTypeLongitudinal, boolean collectionTypeTwinStudy,
		boolean collectionTypeQualityControl,
		boolean collectionTypePopulationBased,
		boolean collectionTypeDiseaseSpecific,
		boolean collectionTypeBirthCohort,
		java.lang.String collectionTypeOther, long collectionOrderOfMagnitude,
		java.lang.String bioresourceReference, java.lang.String contactIDRef,
		long contactPriority, java.lang.String biobankNetworkIDRef,
		java.lang.String geoLatitude, java.lang.String geoLongitude,
		boolean collaborationPartnersCommercial,
		boolean collaborationPartnersNonforprofit,
		java.lang.String collectionAcronym,
		java.lang.String collectionDescription, boolean collectionSexMale,
		boolean collectionSexFemale, boolean collectionSexUnknown,
		boolean collectionSexUndiferrentiated, long collectionAgeLow,
		long collectionAgeHigh, java.lang.String collectionAgeUnit,
		boolean collectionAvailableBiologicalSamples,
		boolean collectionAvailableSurveyData,
		boolean collectionAvailableImagingData,
		boolean collectionAvailableMedicalRecords,
		boolean collectionAvailableNationalRegistries,
		boolean collectionAvailableGenealogicalRecords,
		boolean collectionAvailablePhysioBiochemMeasurements,
		java.lang.String collectionAvailableOther, boolean temperatureRoom,
		boolean temperature2to10, boolean temperature18to35,
		boolean temperature60to85, boolean temperatureLN,
		java.lang.String temperatureOther, java.lang.String diagnosisAvailable,
		java.lang.String collectionHeadFirstName,
		java.lang.String collectionHeadLastName,
		java.lang.String collectionHeadRole, boolean collectionSampleAccessFee,
		boolean collectionSampleAccessJointProjects,
		java.lang.String collectionSampleAccessDescription,
		java.lang.String collectionSampleAccessURI,
		boolean collectionDataAccessFee,
		boolean collectionDataAccessJointProjects,
		java.lang.String collectionDataAccessDescription,
		java.lang.String collectionDataAccessURI, long collectionSize,
		long collectionSizeTimestamp,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _d2CollectionLocalService.updateD2Collection(collectionId,
			companyId, groupId, userId, biobankId, parentcollectionId,
			ldapupdateuuid, bbmricollectionID, bbmriparentcollectionID,
			bbmribiobankID, collectionName, materialStoredDNA,
			materialStoredPlasma, materialStoredSerum, materialStoredUrine,
			materialStoredSaliva, materialStoredFaeces, materialStoredRNA,
			materialStoredBlood, materialStoredTissueFrozen,
			materialStoredTissueFFPE, materialStoredImmortalizedCellLines,
			materialStoredIsolatedPathogen, materialStoredOther,
			collectionTypeCaseControl, collectionTypeCohort,
			collectionTypeCrossSectional, collectionTypeLongitudinal,
			collectionTypeTwinStudy, collectionTypeQualityControl,
			collectionTypePopulationBased, collectionTypeDiseaseSpecific,
			collectionTypeBirthCohort, collectionTypeOther,
			collectionOrderOfMagnitude, bioresourceReference, contactIDRef,
			contactPriority, biobankNetworkIDRef, geoLatitude, geoLongitude,
			collaborationPartnersCommercial, collaborationPartnersNonforprofit,
			collectionAcronym, collectionDescription, collectionSexMale,
			collectionSexFemale, collectionSexUnknown,
			collectionSexUndiferrentiated, collectionAgeLow, collectionAgeHigh,
			collectionAgeUnit, collectionAvailableBiologicalSamples,
			collectionAvailableSurveyData, collectionAvailableImagingData,
			collectionAvailableMedicalRecords,
			collectionAvailableNationalRegistries,
			collectionAvailableGenealogicalRecords,
			collectionAvailablePhysioBiochemMeasurements,
			collectionAvailableOther, temperatureRoom, temperature2to10,
			temperature18to35, temperature60to85, temperatureLN,
			temperatureOther, diagnosisAvailable, collectionHeadFirstName,
			collectionHeadLastName, collectionHeadRole,
			collectionSampleAccessFee, collectionSampleAccessJointProjects,
			collectionSampleAccessDescription, collectionSampleAccessURI,
			collectionDataAccessFee, collectionDataAccessJointProjects,
			collectionDataAccessDescription, collectionDataAccessURI,
			collectionSize, collectionSizeTimestamp, serviceContext);
	}

	/**
	* @param groupId
	* @param bbmricollectionID
	* @param bbmribiobankID
	* @return
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection getD2CollectionByBBMRIERICID(
		long groupId, java.lang.String bbmricollectionID,
		java.lang.String bbmribiobankID) {
		return _d2CollectionLocalService.getD2CollectionByBBMRIERICID(groupId,
			bbmricollectionID, bbmribiobankID);
	}

	/**
	* @param biobankId
	* @return
	*/
	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getD2CollectionByBiobankId(
		long biobankId) {
		return _d2CollectionLocalService.getD2CollectionByBiobankId(biobankId);
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getRootD2Collection(
		long biobankId) {
		return _d2CollectionLocalService.getRootD2Collection(biobankId);
	}

	/**
	* @param biobankId
	* @param collectionId
	* @return
	*/
	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getChildD2Collection(
		long biobankId, long collectionId) {
		return _d2CollectionLocalService.getChildD2Collection(biobankId,
			collectionId);
	}

	/**
	* @param biobankId
	* @return
	*/
	@Override
	public int getD2CollectionByBiobankIdCount(long biobankId) {
		return _d2CollectionLocalService.getD2CollectionByBiobankIdCount(biobankId);
	}

	/**
	* @param d2collection
	* @param attrs
	* @return
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection getD2CollectionFromLDAP(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2collection,
		javax.naming.directory.Attributes attrs) {
		return _d2CollectionLocalService.getD2CollectionFromLDAP(d2collection,
			attrs);
	}

	/**
	* @param groupId
	* @param ldapupdateuuid
	* @return
	*/
	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getLDAPNotUpdatedCollection(
		long groupId, java.lang.String ldapupdateuuid) {
		return _d2CollectionLocalService.getLDAPNotUpdatedCollection(groupId,
			ldapupdateuuid);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public D2CollectionLocalService getWrappedD2CollectionLocalService() {
		return _d2CollectionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedD2CollectionLocalService(
		D2CollectionLocalService d2CollectionLocalService) {
		_d2CollectionLocalService = d2CollectionLocalService;
	}

	@Override
	public D2CollectionLocalService getWrappedService() {
		return _d2CollectionLocalService;
	}

	@Override
	public void setWrappedService(
		D2CollectionLocalService d2CollectionLocalService) {
		_d2CollectionLocalService = d2CollectionLocalService;
	}

	private D2CollectionLocalService _d2CollectionLocalService;
}