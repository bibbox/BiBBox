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
 * Provides a wrapper for {@link BiobankLocalService}.
 *
 * @author suyama
 * @see BiobankLocalService
 * @generated
 */
public class BiobankLocalServiceWrapper implements BiobankLocalService,
	ServiceWrapper<BiobankLocalService> {
	public BiobankLocalServiceWrapper(BiobankLocalService biobankLocalService) {
		_biobankLocalService = biobankLocalService;
	}

	/**
	* Adds the biobank to the database. Also notifies the appropriate model listeners.
	*
	* @param biobank the biobank
	* @return the biobank that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.Biobank addBiobank(
		com.bcnet.portlet.biobank.model.Biobank biobank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.addBiobank(biobank);
	}

	/**
	* Creates a new biobank with the primary key. Does not add the biobank to the database.
	*
	* @param biobankDbId the primary key for the new biobank
	* @return the new biobank
	*/
	@Override
	public com.bcnet.portlet.biobank.model.Biobank createBiobank(
		long biobankDbId) {
		return _biobankLocalService.createBiobank(biobankDbId);
	}

	/**
	* Deletes the biobank with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankDbId the primary key of the biobank
	* @return the biobank that was removed
	* @throws PortalException if a biobank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.Biobank deleteBiobank(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.deleteBiobank(biobankDbId);
	}

	/**
	* Deletes the biobank from the database. Also notifies the appropriate model listeners.
	*
	* @param biobank the biobank
	* @return the biobank that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.Biobank deleteBiobank(
		com.bcnet.portlet.biobank.model.Biobank biobank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.deleteBiobank(biobank);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _biobankLocalService.dynamicQuery();
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
		return _biobankLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _biobankLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _biobankLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _biobankLocalService.dynamicQueryCount(dynamicQuery);
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
		return _biobankLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.bcnet.portlet.biobank.model.Biobank fetchBiobank(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.fetchBiobank(biobankDbId);
	}

	/**
	* Returns the biobank with the primary key.
	*
	* @param biobankDbId the primary key of the biobank
	* @return the biobank
	* @throws PortalException if a biobank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.Biobank getBiobank(long biobankDbId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.getBiobank(biobankDbId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the biobanks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobanks
	* @param end the upper bound of the range of biobanks (not inclusive)
	* @return the range of biobanks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.Biobank> getBiobanks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.getBiobanks(start, end);
	}

	/**
	* Returns the number of biobanks.
	*
	* @return the number of biobanks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBiobanksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.getBiobanksCount();
	}

	/**
	* Updates the biobank in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param biobank the biobank
	* @return the biobank that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.Biobank updateBiobank(
		com.bcnet.portlet.biobank.model.Biobank biobank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.updateBiobank(biobank);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _biobankLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_biobankLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _biobankLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.bcnet.portlet.biobank.model.Biobank addBiobank(
		java.lang.String biobankId, java.lang.String acronym,
		java.lang.String name, java.lang.String url, long juristicPersonId,
		java.lang.String countryCode, java.lang.String description,
		boolean backup, boolean trainingCourses)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.addBiobank(biobankId, acronym, name, url,
			juristicPersonId, countryCode, description, backup, trainingCourses);
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.Biobank> getAllBiobanks()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.getAllBiobanks();
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.Biobank> getAllBiobanks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.getAllBiobanks(start, end);
	}

	@Override
	public com.bcnet.portlet.biobank.model.Biobank updateBiobank(
		long biobankDbId, java.lang.String biobankId, java.lang.String acronym,
		java.lang.String name, java.lang.String url, long juristicPersonId,
		java.lang.String countryCode, java.lang.String description,
		boolean backup, boolean trainingCourses)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biobankLocalService.updateBiobank(biobankDbId, biobankId,
			acronym, name, url, juristicPersonId, countryCode, description,
			backup, trainingCourses);
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.Biobank> findBiobanksByIdentity(
		java.lang.String biobankId, java.lang.String acronym,
		java.lang.String name, java.lang.String countryCode, int begin, int end) {
		return _biobankLocalService.findBiobanksByIdentity(biobankId, acronym,
			name, countryCode, begin, end);
	}

	@Override
	public int findBiobanksCountByIdentity(java.lang.String biobankId,
		java.lang.String acronym, java.lang.String name,
		java.lang.String countryCode) {
		return _biobankLocalService.findBiobanksCountByIdentity(biobankId,
			acronym, name, countryCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BiobankLocalService getWrappedBiobankLocalService() {
		return _biobankLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBiobankLocalService(
		BiobankLocalService biobankLocalService) {
		_biobankLocalService = biobankLocalService;
	}

	@Override
	public BiobankLocalService getWrappedService() {
		return _biobankLocalService;
	}

	@Override
	public void setWrappedService(BiobankLocalService biobankLocalService) {
		_biobankLocalService = biobankLocalService;
	}

	private BiobankLocalService _biobankLocalService;
}