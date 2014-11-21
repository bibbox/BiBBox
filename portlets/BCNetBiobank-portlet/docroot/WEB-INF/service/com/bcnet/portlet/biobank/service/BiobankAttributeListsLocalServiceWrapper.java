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
 * Provides a wrapper for {@link BiobankAttributeListsLocalService}.
 *
 * @author suyama
 * @see BiobankAttributeListsLocalService
 * @generated
 */
public class BiobankAttributeListsLocalServiceWrapper
	implements BiobankAttributeListsLocalService,
		ServiceWrapper<BiobankAttributeListsLocalService> {
	public BiobankAttributeListsLocalServiceWrapper(
		BiobankAttributeListsLocalService biobankAttributeListsLocalService) {
		_biobankAttributeListsLocalService = biobankAttributeListsLocalService;
	}

	/**
	* Adds the biobank attribute lists to the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeLists the biobank attribute lists
	* @return the biobank attribute lists that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists addBiobankAttributeLists(
		com.bcnet.portlet.biobank.model.BiobankAttributeLists biobankAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.addBiobankAttributeLists(biobankAttributeLists);
	}

	/**
	* Creates a new biobank attribute lists with the primary key. Does not add the biobank attribute lists to the database.
	*
	* @param biobankAttributeListsId the primary key for the new biobank attribute lists
	* @return the new biobank attribute lists
	*/
	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists createBiobankAttributeLists(
		long biobankAttributeListsId) {
		return _biobankAttributeListsLocalService.createBiobankAttributeLists(biobankAttributeListsId);
	}

	/**
	* Deletes the biobank attribute lists with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeListsId the primary key of the biobank attribute lists
	* @return the biobank attribute lists that was removed
	* @throws PortalException if a biobank attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists deleteBiobankAttributeLists(
		long biobankAttributeListsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.deleteBiobankAttributeLists(biobankAttributeListsId);
	}

	/**
	* Deletes the biobank attribute lists from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeLists the biobank attribute lists
	* @return the biobank attribute lists that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists deleteBiobankAttributeLists(
		com.bcnet.portlet.biobank.model.BiobankAttributeLists biobankAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.deleteBiobankAttributeLists(biobankAttributeLists);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _biobankAttributeListsLocalService.dynamicQuery();
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
		return _biobankAttributeListsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _biobankAttributeListsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _biobankAttributeListsLocalService.dynamicQuery(dynamicQuery,
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
		return _biobankAttributeListsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _biobankAttributeListsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBiobankAttributeLists(
		long biobankAttributeListsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.fetchBiobankAttributeLists(biobankAttributeListsId);
	}

	/**
	* Returns the biobank attribute lists with the primary key.
	*
	* @param biobankAttributeListsId the primary key of the biobank attribute lists
	* @return the biobank attribute lists
	* @throws PortalException if a biobank attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists getBiobankAttributeLists(
		long biobankAttributeListsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.getBiobankAttributeLists(biobankAttributeListsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the biobank attribute listses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank attribute listses
	* @param end the upper bound of the range of biobank attribute listses (not inclusive)
	* @return the range of biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> getBiobankAttributeListses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.getBiobankAttributeListses(start,
			end);
	}

	/**
	* Returns the number of biobank attribute listses.
	*
	* @return the number of biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBiobankAttributeListsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.getBiobankAttributeListsesCount();
	}

	/**
	* Updates the biobank attribute lists in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeLists the biobank attribute lists
	* @return the biobank attribute lists that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists updateBiobankAttributeLists(
		com.bcnet.portlet.biobank.model.BiobankAttributeLists biobankAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.updateBiobankAttributeLists(biobankAttributeLists);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _biobankAttributeListsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_biobankAttributeListsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _biobankAttributeListsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists addBiobankAttributeLists(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.addBiobankAttributeLists(biobankDbId,
			attributeListName, attributeListValue);
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> getBiobankAtrributeListsByBiobankDbId(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.getBiobankAtrributeListsByBiobankDbId(biobankDbId);
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> getBiobankAtrributeListsByBiobankDbId_AttributeListName(
		long biobankDbId, java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.getBiobankAtrributeListsByBiobankDbId_AttributeListName(biobankDbId,
			attributeListName);
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists getBiobankAtrributeListsByBiobankDbId_AttributeListName_AttributeListValue(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.getBiobankAtrributeListsByBiobankDbId_AttributeListName_AttributeListValue(biobankDbId,
			attributeListName, attributeListValue);
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists deleteBiobankAttributeLists(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankAttributeListsLocalService.deleteBiobankAttributeLists(biobankDbId,
			attributeListName, attributeListValue);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BiobankAttributeListsLocalService getWrappedBiobankAttributeListsLocalService() {
		return _biobankAttributeListsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBiobankAttributeListsLocalService(
		BiobankAttributeListsLocalService biobankAttributeListsLocalService) {
		_biobankAttributeListsLocalService = biobankAttributeListsLocalService;
	}

	@Override
	public BiobankAttributeListsLocalService getWrappedService() {
		return _biobankAttributeListsLocalService;
	}

	@Override
	public void setWrappedService(
		BiobankAttributeListsLocalService biobankAttributeListsLocalService) {
		_biobankAttributeListsLocalService = biobankAttributeListsLocalService;
	}

	private BiobankAttributeListsLocalService _biobankAttributeListsLocalService;
}