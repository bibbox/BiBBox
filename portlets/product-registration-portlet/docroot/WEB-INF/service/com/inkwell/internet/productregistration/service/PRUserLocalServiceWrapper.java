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

package com.inkwell.internet.productregistration.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PRUserLocalService}.
 *
 * @author Rich Sezov
 * @see PRUserLocalService
 * @generated
 */
public class PRUserLocalServiceWrapper implements PRUserLocalService,
	ServiceWrapper<PRUserLocalService> {
	public PRUserLocalServiceWrapper(PRUserLocalService prUserLocalService) {
		_prUserLocalService = prUserLocalService;
	}

	/**
	* Adds the p r user to the database. Also notifies the appropriate model listeners.
	*
	* @param prUser the p r user
	* @return the p r user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.inkwell.internet.productregistration.model.PRUser addPRUser(
		com.inkwell.internet.productregistration.model.PRUser prUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.addPRUser(prUser);
	}

	/**
	* Creates a new p r user with the primary key. Does not add the p r user to the database.
	*
	* @param prUserId the primary key for the new p r user
	* @return the new p r user
	*/
	@Override
	public com.inkwell.internet.productregistration.model.PRUser createPRUser(
		long prUserId) {
		return _prUserLocalService.createPRUser(prUserId);
	}

	/**
	* Deletes the p r user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param prUserId the primary key of the p r user
	* @return the p r user that was removed
	* @throws PortalException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.inkwell.internet.productregistration.model.PRUser deletePRUser(
		long prUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.deletePRUser(prUserId);
	}

	/**
	* Deletes the p r user from the database. Also notifies the appropriate model listeners.
	*
	* @param prUser the p r user
	* @return the p r user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.inkwell.internet.productregistration.model.PRUser deletePRUser(
		com.inkwell.internet.productregistration.model.PRUser prUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.deletePRUser(prUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _prUserLocalService.dynamicQuery();
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
		return _prUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _prUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _prUserLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _prUserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _prUserLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.inkwell.internet.productregistration.model.PRUser fetchPRUser(
		long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.fetchPRUser(prUserId);
	}

	/**
	* Returns the p r user with the primary key.
	*
	* @param prUserId the primary key of the p r user
	* @return the p r user
	* @throws PortalException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.inkwell.internet.productregistration.model.PRUser getPRUser(
		long prUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.getPRUser(prUserId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the p r users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @return the range of p r users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> getPRUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.getPRUsers(start, end);
	}

	/**
	* Returns the number of p r users.
	*
	* @return the number of p r users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPRUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.getPRUsersCount();
	}

	/**
	* Updates the p r user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param prUser the p r user
	* @return the p r user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.inkwell.internet.productregistration.model.PRUser updatePRUser(
		com.inkwell.internet.productregistration.model.PRUser prUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.updatePRUser(prUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _prUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_prUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _prUserLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Adds a Registered User object to the database as a new record.
	*
	* @param user
	* @return
	* @throws SystemException
	*/
	@Override
	public com.inkwell.internet.productregistration.model.PRUser addPRUser(
		com.inkwell.internet.productregistration.model.PRUser user, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.addPRUser(user, userId);
	}

	/**
	* Gets a Registered User object from a Liferay User primary key or null if
	* it wasn't found.
	*
	* @param groupId
	* @param userId
	* @return
	* @throws SystemException
	*/
	@Override
	public com.inkwell.internet.productregistration.model.PRUser getPRUser(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.getPRUser(groupId, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PRUserLocalService getWrappedPRUserLocalService() {
		return _prUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPRUserLocalService(
		PRUserLocalService prUserLocalService) {
		_prUserLocalService = prUserLocalService;
	}

	@Override
	public PRUserLocalService getWrappedService() {
		return _prUserLocalService;
	}

	@Override
	public void setWrappedService(PRUserLocalService prUserLocalService) {
		_prUserLocalService = prUserLocalService;
	}

	private PRUserLocalService _prUserLocalService;
}