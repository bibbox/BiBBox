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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for EventData. This utility wraps
 * {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.impl.EventDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author reihsr
 * @see EventDataLocalService
 * @see at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base.EventDataLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.impl.EventDataLocalServiceImpl
 * @generated
 */
public class EventDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.impl.EventDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the event data to the database. Also notifies the appropriate model listeners.
	*
	* @param eventData the event data
	* @return the event data that was added
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData addEventData(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData eventData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEventData(eventData);
	}

	/**
	* Creates a new event data with the primary key. Does not add the event data to the database.
	*
	* @param eventdataId the primary key for the new event data
	* @return the new event data
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData createEventData(
		long eventdataId) {
		return getService().createEventData(eventdataId);
	}

	/**
	* Deletes the event data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventdataId the primary key of the event data
	* @return the event data that was removed
	* @throws PortalException if a event data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData deleteEventData(
		long eventdataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEventData(eventdataId);
	}

	/**
	* Deletes the event data from the database. Also notifies the appropriate model listeners.
	*
	* @param eventData the event data
	* @return the event data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData deleteEventData(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData eventData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEventData(eventData);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchEventData(
		long eventdataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEventData(eventdataId);
	}

	/**
	* Returns the event data with the primary key.
	*
	* @param eventdataId the primary key of the event data
	* @return the event data
	* @throws PortalException if a event data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData getEventData(
		long eventdataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventData(eventdataId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the event datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event datas
	* @param end the upper bound of the range of event datas (not inclusive)
	* @return the range of event datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> getEventDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventDatas(start, end);
	}

	/**
	* Returns the number of event datas.
	*
	* @return the number of event datas
	* @throws SystemException if a system exception occurred
	*/
	public static int getEventDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventDatasCount();
	}

	/**
	* Updates the event data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventData the event data
	* @return the event data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData updateEventData(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData eventData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEventData(eventData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData createNewEventData(
		long eventId, long patientId, java.lang.String key,
		java.lang.String value) {
		return getService().createNewEventData(eventId, patientId, key, value);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData getEventDataByOntology(
		long eventlayoutId, java.lang.String ontology) {
		return getService().getEventDataByOntology(eventlayoutId, ontology);
	}

	public static void clearService() {
		_service = null;
	}

	public static EventDataLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EventDataLocalService.class.getName());

			if (invokableLocalService instanceof EventDataLocalService) {
				_service = (EventDataLocalService)invokableLocalService;
			}
			else {
				_service = new EventDataLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EventDataLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EventDataLocalService service) {
	}

	private static EventDataLocalService _service;
}