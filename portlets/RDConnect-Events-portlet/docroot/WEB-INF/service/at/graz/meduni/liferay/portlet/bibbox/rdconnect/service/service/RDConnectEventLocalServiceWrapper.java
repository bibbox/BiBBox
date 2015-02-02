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

package at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RDConnectEventLocalService}.
 *
 * @author reihsr
 * @see RDConnectEventLocalService
 * @generated
 */
public class RDConnectEventLocalServiceWrapper
	implements RDConnectEventLocalService,
		ServiceWrapper<RDConnectEventLocalService> {
	public RDConnectEventLocalServiceWrapper(
		RDConnectEventLocalService rdConnectEventLocalService) {
		_rdConnectEventLocalService = rdConnectEventLocalService;
	}

	/**
	* Adds the r d connect event to the database. Also notifies the appropriate model listeners.
	*
	* @param rdConnectEvent the r d connect event
	* @return the r d connect event that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent addRDConnectEvent(
		at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent rdConnectEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdConnectEventLocalService.addRDConnectEvent(rdConnectEvent);
	}

	/**
	* Creates a new r d connect event with the primary key. Does not add the r d connect event to the database.
	*
	* @param eventId the primary key for the new r d connect event
	* @return the new r d connect event
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent createRDConnectEvent(
		long eventId) {
		return _rdConnectEventLocalService.createRDConnectEvent(eventId);
	}

	/**
	* Deletes the r d connect event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the r d connect event
	* @return the r d connect event that was removed
	* @throws PortalException if a r d connect event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent deleteRDConnectEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rdConnectEventLocalService.deleteRDConnectEvent(eventId);
	}

	/**
	* Deletes the r d connect event from the database. Also notifies the appropriate model listeners.
	*
	* @param rdConnectEvent the r d connect event
	* @return the r d connect event that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent deleteRDConnectEvent(
		at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent rdConnectEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdConnectEventLocalService.deleteRDConnectEvent(rdConnectEvent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rdConnectEventLocalService.dynamicQuery();
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
		return _rdConnectEventLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rdConnectEventLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rdConnectEventLocalService.dynamicQuery(dynamicQuery, start,
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
		return _rdConnectEventLocalService.dynamicQueryCount(dynamicQuery);
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
		return _rdConnectEventLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent fetchRDConnectEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdConnectEventLocalService.fetchRDConnectEvent(eventId);
	}

	/**
	* Returns the r d connect event with the primary key.
	*
	* @param eventId the primary key of the r d connect event
	* @return the r d connect event
	* @throws PortalException if a r d connect event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent getRDConnectEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rdConnectEventLocalService.getRDConnectEvent(eventId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rdConnectEventLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the r d connect events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d connect events
	* @param end the upper bound of the range of r d connect events (not inclusive)
	* @return the range of r d connect events
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent> getRDConnectEvents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdConnectEventLocalService.getRDConnectEvents(start, end);
	}

	/**
	* Returns the number of r d connect events.
	*
	* @return the number of r d connect events
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRDConnectEventsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdConnectEventLocalService.getRDConnectEventsCount();
	}

	/**
	* Updates the r d connect event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rdConnectEvent the r d connect event
	* @return the r d connect event that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent updateRDConnectEvent(
		at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent rdConnectEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdConnectEventLocalService.updateRDConnectEvent(rdConnectEvent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rdConnectEventLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rdConnectEventLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rdConnectEventLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void createEvent(java.util.Date eventdate, long organizationId,
		long userId, java.lang.String shorttext, java.lang.String longtext,
		java.lang.String link, java.lang.String restricted) {
		_rdConnectEventLocalService.createEvent(eventdate, organizationId,
			userId, shorttext, longtext, link, restricted);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RDConnectEventLocalService getWrappedRDConnectEventLocalService() {
		return _rdConnectEventLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRDConnectEventLocalService(
		RDConnectEventLocalService rdConnectEventLocalService) {
		_rdConnectEventLocalService = rdConnectEventLocalService;
	}

	@Override
	public RDConnectEventLocalService getWrappedService() {
		return _rdConnectEventLocalService;
	}

	@Override
	public void setWrappedService(
		RDConnectEventLocalService rdConnectEventLocalService) {
		_rdConnectEventLocalService = rdConnectEventLocalService;
	}

	private RDConnectEventLocalService _rdConnectEventLocalService;
}