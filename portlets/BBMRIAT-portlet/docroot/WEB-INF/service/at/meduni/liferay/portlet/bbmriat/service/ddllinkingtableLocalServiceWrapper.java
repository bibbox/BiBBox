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

package at.meduni.liferay.portlet.bbmriat.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ddllinkingtableLocalService}.
 *
 * @author Robert Reihs
 * @see ddllinkingtableLocalService
 * @generated
 */
public class ddllinkingtableLocalServiceWrapper
	implements ddllinkingtableLocalService,
		ServiceWrapper<ddllinkingtableLocalService> {
	public ddllinkingtableLocalServiceWrapper(
		ddllinkingtableLocalService ddllinkingtableLocalService) {
		_ddllinkingtableLocalService = ddllinkingtableLocalService;
	}

	/**
	* Adds the ddllinkingtable to the database. Also notifies the appropriate model listeners.
	*
	* @param ddllinkingtable the ddllinkingtable
	* @return the ddllinkingtable that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable addddllinkingtable(
		at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable ddllinkingtable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddllinkingtableLocalService.addddllinkingtable(ddllinkingtable);
	}

	/**
	* Creates a new ddllinkingtable with the primary key. Does not add the ddllinkingtable to the database.
	*
	* @param ddllinkingtable the primary key for the new ddllinkingtable
	* @return the new ddllinkingtable
	*/
	@Override
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable createddllinkingtable(
		long ddllinkingtable) {
		return _ddllinkingtableLocalService.createddllinkingtable(ddllinkingtable);
	}

	/**
	* Deletes the ddllinkingtable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ddllinkingtable the primary key of the ddllinkingtable
	* @return the ddllinkingtable that was removed
	* @throws PortalException if a ddllinkingtable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable deleteddllinkingtable(
		long ddllinkingtable)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ddllinkingtableLocalService.deleteddllinkingtable(ddllinkingtable);
	}

	/**
	* Deletes the ddllinkingtable from the database. Also notifies the appropriate model listeners.
	*
	* @param ddllinkingtable the ddllinkingtable
	* @return the ddllinkingtable that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable deleteddllinkingtable(
		at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable ddllinkingtable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddllinkingtableLocalService.deleteddllinkingtable(ddllinkingtable);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ddllinkingtableLocalService.dynamicQuery();
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
		return _ddllinkingtableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ddllinkingtableLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ddllinkingtableLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _ddllinkingtableLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ddllinkingtableLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable fetchddllinkingtable(
		long ddllinkingtable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddllinkingtableLocalService.fetchddllinkingtable(ddllinkingtable);
	}

	/**
	* Returns the ddllinkingtable with the primary key.
	*
	* @param ddllinkingtable the primary key of the ddllinkingtable
	* @return the ddllinkingtable
	* @throws PortalException if a ddllinkingtable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable getddllinkingtable(
		long ddllinkingtable)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ddllinkingtableLocalService.getddllinkingtable(ddllinkingtable);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ddllinkingtableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ddllinkingtables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ddllinkingtables
	* @param end the upper bound of the range of ddllinkingtables (not inclusive)
	* @return the range of ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> getddllinkingtables(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddllinkingtableLocalService.getddllinkingtables(start, end);
	}

	/**
	* Returns the number of ddllinkingtables.
	*
	* @return the number of ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getddllinkingtablesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddllinkingtableLocalService.getddllinkingtablesCount();
	}

	/**
	* Updates the ddllinkingtable in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ddllinkingtable the ddllinkingtable
	* @return the ddllinkingtable that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable updateddllinkingtable(
		at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable ddllinkingtable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddllinkingtableLocalService.updateddllinkingtable(ddllinkingtable);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ddllinkingtableLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ddllinkingtableLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ddllinkingtableLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> getDDLEntrysByRecordAndRecordset(
		long recordid, long recordsetid) {
		return _ddllinkingtableLocalService.getDDLEntrysByRecordAndRecordset(recordid,
			recordsetid);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ddllinkingtableLocalService getWrappedddllinkingtableLocalService() {
		return _ddllinkingtableLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedddllinkingtableLocalService(
		ddllinkingtableLocalService ddllinkingtableLocalService) {
		_ddllinkingtableLocalService = ddllinkingtableLocalService;
	}

	@Override
	public ddllinkingtableLocalService getWrappedService() {
		return _ddllinkingtableLocalService;
	}

	@Override
	public void setWrappedService(
		ddllinkingtableLocalService ddllinkingtableLocalService) {
		_ddllinkingtableLocalService = ddllinkingtableLocalService;
	}

	private ddllinkingtableLocalService _ddllinkingtableLocalService;
}