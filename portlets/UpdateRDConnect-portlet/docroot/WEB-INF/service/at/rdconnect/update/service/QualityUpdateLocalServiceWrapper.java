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

package at.rdconnect.update.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link QualityUpdateLocalService}.
 *
 * @author reihsr
 * @see QualityUpdateLocalService
 * @generated
 */
public class QualityUpdateLocalServiceWrapper
	implements QualityUpdateLocalService,
		ServiceWrapper<QualityUpdateLocalService> {
	public QualityUpdateLocalServiceWrapper(
		QualityUpdateLocalService qualityUpdateLocalService) {
		_qualityUpdateLocalService = qualityUpdateLocalService;
	}

	/**
	* Adds the quality update to the database. Also notifies the appropriate model listeners.
	*
	* @param qualityUpdate the quality update
	* @return the quality update that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.rdconnect.update.model.QualityUpdate addQualityUpdate(
		at.rdconnect.update.model.QualityUpdate qualityUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _qualityUpdateLocalService.addQualityUpdate(qualityUpdate);
	}

	/**
	* Creates a new quality update with the primary key. Does not add the quality update to the database.
	*
	* @param coreid the primary key for the new quality update
	* @return the new quality update
	*/
	@Override
	public at.rdconnect.update.model.QualityUpdate createQualityUpdate(
		long coreid) {
		return _qualityUpdateLocalService.createQualityUpdate(coreid);
	}

	/**
	* Deletes the quality update with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param coreid the primary key of the quality update
	* @return the quality update that was removed
	* @throws PortalException if a quality update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.rdconnect.update.model.QualityUpdate deleteQualityUpdate(
		long coreid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _qualityUpdateLocalService.deleteQualityUpdate(coreid);
	}

	/**
	* Deletes the quality update from the database. Also notifies the appropriate model listeners.
	*
	* @param qualityUpdate the quality update
	* @return the quality update that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.rdconnect.update.model.QualityUpdate deleteQualityUpdate(
		at.rdconnect.update.model.QualityUpdate qualityUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _qualityUpdateLocalService.deleteQualityUpdate(qualityUpdate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _qualityUpdateLocalService.dynamicQuery();
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
		return _qualityUpdateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.QualityUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _qualityUpdateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.QualityUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _qualityUpdateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _qualityUpdateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _qualityUpdateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.rdconnect.update.model.QualityUpdate fetchQualityUpdate(
		long coreid) throws com.liferay.portal.kernel.exception.SystemException {
		return _qualityUpdateLocalService.fetchQualityUpdate(coreid);
	}

	/**
	* Returns the quality update with the primary key.
	*
	* @param coreid the primary key of the quality update
	* @return the quality update
	* @throws PortalException if a quality update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.rdconnect.update.model.QualityUpdate getQualityUpdate(long coreid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _qualityUpdateLocalService.getQualityUpdate(coreid);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _qualityUpdateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the quality updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.QualityUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of quality updates
	* @param end the upper bound of the range of quality updates (not inclusive)
	* @return the range of quality updates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.rdconnect.update.model.QualityUpdate> getQualityUpdates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _qualityUpdateLocalService.getQualityUpdates(start, end);
	}

	/**
	* Returns the number of quality updates.
	*
	* @return the number of quality updates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getQualityUpdatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _qualityUpdateLocalService.getQualityUpdatesCount();
	}

	/**
	* Updates the quality update in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param qualityUpdate the quality update
	* @return the quality update that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.rdconnect.update.model.QualityUpdate updateQualityUpdate(
		at.rdconnect.update.model.QualityUpdate qualityUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _qualityUpdateLocalService.updateQualityUpdate(qualityUpdate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _qualityUpdateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_qualityUpdateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _qualityUpdateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<at.rdconnect.update.model.QualityUpdate> getQualityUpdateByOrganization(
		long organizationid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _qualityUpdateLocalService.getQualityUpdateByOrganization(organizationid);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public QualityUpdateLocalService getWrappedQualityUpdateLocalService() {
		return _qualityUpdateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedQualityUpdateLocalService(
		QualityUpdateLocalService qualityUpdateLocalService) {
		_qualityUpdateLocalService = qualityUpdateLocalService;
	}

	@Override
	public QualityUpdateLocalService getWrappedService() {
		return _qualityUpdateLocalService;
	}

	@Override
	public void setWrappedService(
		QualityUpdateLocalService qualityUpdateLocalService) {
		_qualityUpdateLocalService = qualityUpdateLocalService;
	}

	private QualityUpdateLocalService _qualityUpdateLocalService;
}