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

package com.bcnet.portlet.biobank.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BiobankGeneralInformationLocalService}.
 *
 * @author suyama
 * @see BiobankGeneralInformationLocalService
 * @generated
 */
public class BiobankGeneralInformationLocalServiceWrapper
	implements BiobankGeneralInformationLocalService,
		ServiceWrapper<BiobankGeneralInformationLocalService> {
	public BiobankGeneralInformationLocalServiceWrapper(
		BiobankGeneralInformationLocalService biobankGeneralInformationLocalService) {
		_biobankGeneralInformationLocalService = biobankGeneralInformationLocalService;
	}

	/**
	* Adds the biobank general information to the database. Also notifies the appropriate model listeners.
	*
	* @param biobankGeneralInformation the biobank general information
	* @return the biobank general information that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation addBiobankGeneralInformation(
		com.bcnet.portlet.biobank.model.BiobankGeneralInformation biobankGeneralInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankGeneralInformationLocalService.addBiobankGeneralInformation(biobankGeneralInformation);
	}

	/**
	* Creates a new biobank general information with the primary key. Does not add the biobank general information to the database.
	*
	* @param biobankDbId the primary key for the new biobank general information
	* @return the new biobank general information
	*/
	@Override
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation createBiobankGeneralInformation(
		long biobankDbId) {
		return _biobankGeneralInformationLocalService.createBiobankGeneralInformation(biobankDbId);
	}

	/**
	* Deletes the biobank general information with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankDbId the primary key of the biobank general information
	* @return the biobank general information that was removed
	* @throws PortalException if a biobank general information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation deleteBiobankGeneralInformation(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biobankGeneralInformationLocalService.deleteBiobankGeneralInformation(biobankDbId);
	}

	/**
	* Deletes the biobank general information from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankGeneralInformation the biobank general information
	* @return the biobank general information that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation deleteBiobankGeneralInformation(
		com.bcnet.portlet.biobank.model.BiobankGeneralInformation biobankGeneralInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankGeneralInformationLocalService.deleteBiobankGeneralInformation(biobankGeneralInformation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _biobankGeneralInformationLocalService.dynamicQuery();
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
		return _biobankGeneralInformationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _biobankGeneralInformationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _biobankGeneralInformationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _biobankGeneralInformationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _biobankGeneralInformationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation fetchBiobankGeneralInformation(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankGeneralInformationLocalService.fetchBiobankGeneralInformation(biobankDbId);
	}

	/**
	* Returns the biobank general information with the primary key.
	*
	* @param biobankDbId the primary key of the biobank general information
	* @return the biobank general information
	* @throws PortalException if a biobank general information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation getBiobankGeneralInformation(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biobankGeneralInformationLocalService.getBiobankGeneralInformation(biobankDbId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biobankGeneralInformationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the biobank general informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank general informations
	* @param end the upper bound of the range of biobank general informations (not inclusive)
	* @return the range of biobank general informations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> getBiobankGeneralInformations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankGeneralInformationLocalService.getBiobankGeneralInformations(start,
			end);
	}

	/**
	* Returns the number of biobank general informations.
	*
	* @return the number of biobank general informations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBiobankGeneralInformationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankGeneralInformationLocalService.getBiobankGeneralInformationsCount();
	}

	/**
	* Updates the biobank general information in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param biobankGeneralInformation the biobank general information
	* @return the biobank general information that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation updateBiobankGeneralInformation(
		com.bcnet.portlet.biobank.model.BiobankGeneralInformation biobankGeneralInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankGeneralInformationLocalService.updateBiobankGeneralInformation(biobankGeneralInformation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _biobankGeneralInformationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_biobankGeneralInformationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _biobankGeneralInformationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> findBiobanksByIdentity(
		java.lang.String biobankId, java.lang.String acronym,
		java.lang.String name, java.lang.String countryCode, int begin, int end) {
		return _biobankGeneralInformationLocalService.findBiobanksByIdentity(biobankId,
			acronym, name, countryCode, begin, end);
	}

	@Override
	public int findBiobanksCountByIdentity(java.lang.String biobankId,
		java.lang.String acronym, java.lang.String name,
		java.lang.String countryCode) {
		return _biobankGeneralInformationLocalService.findBiobanksCountByIdentity(biobankId,
			acronym, name, countryCode);
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> findBiobanksByKeywordsCountry(
		java.lang.String keywords, java.lang.String countryCode, int begin,
		int end) {
		return _biobankGeneralInformationLocalService.findBiobanksByKeywordsCountry(keywords,
			countryCode, begin, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BiobankGeneralInformationLocalService getWrappedBiobankGeneralInformationLocalService() {
		return _biobankGeneralInformationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBiobankGeneralInformationLocalService(
		BiobankGeneralInformationLocalService biobankGeneralInformationLocalService) {
		_biobankGeneralInformationLocalService = biobankGeneralInformationLocalService;
	}

	@Override
	public BiobankGeneralInformationLocalService getWrappedService() {
		return _biobankGeneralInformationLocalService;
	}

	@Override
	public void setWrappedService(
		BiobankGeneralInformationLocalService biobankGeneralInformationLocalService) {
		_biobankGeneralInformationLocalService = biobankGeneralInformationLocalService;
	}

	private BiobankGeneralInformationLocalService _biobankGeneralInformationLocalService;
}