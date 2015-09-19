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

package at.graz.meduni.liferay.portlet.bibbox.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LogapiLocalService}.
 *
 * @author reihsr
 * @see LogapiLocalService
 * @generated
 */
public class LogapiLocalServiceWrapper implements LogapiLocalService,
	ServiceWrapper<LogapiLocalService> {
	public LogapiLocalServiceWrapper(LogapiLocalService logapiLocalService) {
		_logapiLocalService = logapiLocalService;
	}

	/**
	* Adds the logapi to the database. Also notifies the appropriate model listeners.
	*
	* @param logapi the logapi
	* @return the logapi that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi addLogapi(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi logapi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logapiLocalService.addLogapi(logapi);
	}

	/**
	* Creates a new logapi with the primary key. Does not add the logapi to the database.
	*
	* @param logapiId the primary key for the new logapi
	* @return the new logapi
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi createLogapi(
		long logapiId) {
		return _logapiLocalService.createLogapi(logapiId);
	}

	/**
	* Deletes the logapi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param logapiId the primary key of the logapi
	* @return the logapi that was removed
	* @throws PortalException if a logapi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi deleteLogapi(
		long logapiId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _logapiLocalService.deleteLogapi(logapiId);
	}

	/**
	* Deletes the logapi from the database. Also notifies the appropriate model listeners.
	*
	* @param logapi the logapi
	* @return the logapi that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi deleteLogapi(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi logapi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logapiLocalService.deleteLogapi(logapi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _logapiLocalService.dynamicQuery();
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
		return _logapiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.LogapiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _logapiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.LogapiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _logapiLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _logapiLocalService.dynamicQueryCount(dynamicQuery);
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
		return _logapiLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi fetchLogapi(
		long logapiId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logapiLocalService.fetchLogapi(logapiId);
	}

	/**
	* Returns the logapi with the primary key.
	*
	* @param logapiId the primary key of the logapi
	* @return the logapi
	* @throws PortalException if a logapi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi getLogapi(
		long logapiId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _logapiLocalService.getLogapi(logapiId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _logapiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the logapis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.LogapiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logapis
	* @param end the upper bound of the range of logapis (not inclusive)
	* @return the range of logapis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi> getLogapis(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logapiLocalService.getLogapis(start, end);
	}

	/**
	* Returns the number of logapis.
	*
	* @return the number of logapis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLogapisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logapiLocalService.getLogapisCount();
	}

	/**
	* Updates the logapi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param logapi the logapi
	* @return the logapi that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi updateLogapi(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi logapi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logapiLocalService.updateLogapi(logapi);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _logapiLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_logapiLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _logapiLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void addLogAPI(long userId, java.lang.String userIp,
		java.lang.String msg) {
		_logapiLocalService.addLogAPI(userId, userIp, msg);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LogapiLocalService getWrappedLogapiLocalService() {
		return _logapiLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLogapiLocalService(
		LogapiLocalService logapiLocalService) {
		_logapiLocalService = logapiLocalService;
	}

	@Override
	public LogapiLocalService getWrappedService() {
		return _logapiLocalService;
	}

	@Override
	public void setWrappedService(LogapiLocalService logapiLocalService) {
		_logapiLocalService = logapiLocalService;
	}

	private LogapiLocalService _logapiLocalService;
}