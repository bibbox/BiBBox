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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the event data service. This utility wraps {@link EventDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see EventDataPersistence
 * @see EventDataPersistenceImpl
 * @generated
 */
public class EventDataUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(EventData eventData) {
		getPersistence().clearCache(eventData);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EventData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EventData update(EventData eventData)
		throws SystemException {
		return getPersistence().update(eventData);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EventData update(EventData eventData,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(eventData, serviceContext);
	}

	/**
	* Returns all the event datas where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findByEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEvent(eventId);
	}

	/**
	* Returns a range of all the event datas where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of event datas
	* @param end the upper bound of the range of event datas (not inclusive)
	* @return the range of matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findByEvent(
		long eventId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEvent(eventId, start, end);
	}

	/**
	* Returns an ordered range of all the event datas where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of event datas
	* @param end the upper bound of the range of event datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findByEvent(
		long eventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEvent(eventId, start, end, orderByComparator);
	}

	/**
	* Returns the first event data in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData findByEvent_First(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEvent_First(eventId, orderByComparator);
	}

	/**
	* Returns the first event data in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event data, or <code>null</code> if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByEvent_First(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEvent_First(eventId, orderByComparator);
	}

	/**
	* Returns the last event data in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData findByEvent_Last(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEvent_Last(eventId, orderByComparator);
	}

	/**
	* Returns the last event data in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event data, or <code>null</code> if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByEvent_Last(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEvent_Last(eventId, orderByComparator);
	}

	/**
	* Returns the event datas before and after the current event data in the ordered set where eventId = &#63;.
	*
	* @param eventdataId the primary key of the current event data
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a event data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData[] findByEvent_PrevAndNext(
		long eventdataId, long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEvent_PrevAndNext(eventdataId, eventId,
			orderByComparator);
	}

	/**
	* Removes all the event datas where eventId = &#63; from the database.
	*
	* @param eventId the event ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEvent(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEvent(eventId);
	}

	/**
	* Returns the number of event datas where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the number of matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEvent(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEvent(eventId);
	}

	/**
	* Returns all the event datas where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @return the matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findByPatient(
		long patientId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPatient(patientId);
	}

	/**
	* Returns a range of all the event datas where patientId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param patientId the patient ID
	* @param start the lower bound of the range of event datas
	* @param end the upper bound of the range of event datas (not inclusive)
	* @return the range of matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findByPatient(
		long patientId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPatient(patientId, start, end);
	}

	/**
	* Returns an ordered range of all the event datas where patientId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param patientId the patient ID
	* @param start the lower bound of the range of event datas
	* @param end the upper bound of the range of event datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findByPatient(
		long patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPatient(patientId, start, end, orderByComparator);
	}

	/**
	* Returns the first event data in the ordered set where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData findByPatient_First(
		long patientId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPatient_First(patientId, orderByComparator);
	}

	/**
	* Returns the first event data in the ordered set where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event data, or <code>null</code> if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByPatient_First(
		long patientId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPatient_First(patientId, orderByComparator);
	}

	/**
	* Returns the last event data in the ordered set where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData findByPatient_Last(
		long patientId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPatient_Last(patientId, orderByComparator);
	}

	/**
	* Returns the last event data in the ordered set where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event data, or <code>null</code> if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByPatient_Last(
		long patientId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPatient_Last(patientId, orderByComparator);
	}

	/**
	* Returns the event datas before and after the current event data in the ordered set where patientId = &#63;.
	*
	* @param eventdataId the primary key of the current event data
	* @param patientId the patient ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a event data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData[] findByPatient_PrevAndNext(
		long eventdataId, long patientId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPatient_PrevAndNext(eventdataId, patientId,
			orderByComparator);
	}

	/**
	* Removes all the event datas where patientId = &#63; from the database.
	*
	* @param patientId the patient ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPatient(long patientId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPatient(patientId);
	}

	/**
	* Returns the number of event datas where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @return the number of matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPatient(long patientId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPatient(patientId);
	}

	/**
	* Returns the event data where eventId = &#63; and ontology = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException} if it could not be found.
	*
	* @param eventId the event ID
	* @param ontology the ontology
	* @return the matching event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData findByDataByOntology(
		long eventId, java.lang.String ontology)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDataByOntology(eventId, ontology);
	}

	/**
	* Returns the event data where eventId = &#63; and ontology = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param eventId the event ID
	* @param ontology the ontology
	* @return the matching event data, or <code>null</code> if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByDataByOntology(
		long eventId, java.lang.String ontology)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDataByOntology(eventId, ontology);
	}

	/**
	* Returns the event data where eventId = &#63; and ontology = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param eventId the event ID
	* @param ontology the ontology
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching event data, or <code>null</code> if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByDataByOntology(
		long eventId, java.lang.String ontology, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDataByOntology(eventId, ontology, retrieveFromCache);
	}

	/**
	* Removes the event data where eventId = &#63; and ontology = &#63; from the database.
	*
	* @param eventId the event ID
	* @param ontology the ontology
	* @return the event data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData removeByDataByOntology(
		long eventId, java.lang.String ontology)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByDataByOntology(eventId, ontology);
	}

	/**
	* Returns the number of event datas where eventId = &#63; and ontology = &#63;.
	*
	* @param eventId the event ID
	* @param ontology the ontology
	* @return the number of matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDataByOntology(long eventId,
		java.lang.String ontology)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDataByOntology(eventId, ontology);
	}

	/**
	* Caches the event data in the entity cache if it is enabled.
	*
	* @param eventData the event data
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData eventData) {
		getPersistence().cacheResult(eventData);
	}

	/**
	* Caches the event datas in the entity cache if it is enabled.
	*
	* @param eventDatas the event datas
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> eventDatas) {
		getPersistence().cacheResult(eventDatas);
	}

	/**
	* Creates a new event data with the primary key. Does not add the event data to the database.
	*
	* @param eventdataId the primary key for the new event data
	* @return the new event data
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData create(
		long eventdataId) {
		return getPersistence().create(eventdataId);
	}

	/**
	* Removes the event data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventdataId the primary key of the event data
	* @return the event data that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a event data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData remove(
		long eventdataId)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eventdataId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData eventData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eventData);
	}

	/**
	* Returns the event data with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException} if it could not be found.
	*
	* @param eventdataId the primary key of the event data
	* @return the event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a event data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData findByPrimaryKey(
		long eventdataId)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eventdataId);
	}

	/**
	* Returns the event data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventdataId the primary key of the event data
	* @return the event data, or <code>null</code> if a event data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByPrimaryKey(
		long eventdataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eventdataId);
	}

	/**
	* Returns all the event datas.
	*
	* @return the event datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the event datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event datas
	* @param end the upper bound of the range of event datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of event datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the event datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of event datas.
	*
	* @return the number of event datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EventDataPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EventDataPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.ClpSerializer.getServletContextName(),
					EventDataPersistence.class.getName());

			ReferenceRegistry.registerReference(EventDataUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EventDataPersistence persistence) {
	}

	private static EventDataPersistence _persistence;
}