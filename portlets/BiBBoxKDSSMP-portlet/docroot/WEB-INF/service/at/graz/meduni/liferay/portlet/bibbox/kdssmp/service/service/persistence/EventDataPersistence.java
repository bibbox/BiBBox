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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the event data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see EventDataPersistenceImpl
 * @see EventDataUtil
 * @generated
 */
public interface EventDataPersistence extends BasePersistence<EventData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventDataUtil} to access the event data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the event datas where eventlayoutId = &#63;.
	*
	* @param eventlayoutId the eventlayout ID
	* @return the matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findByEventLayout(
		long eventlayoutId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the event datas where eventlayoutId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventlayoutId the eventlayout ID
	* @param start the lower bound of the range of event datas
	* @param end the upper bound of the range of event datas (not inclusive)
	* @return the range of matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findByEventLayout(
		long eventlayoutId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event datas where eventlayoutId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventlayoutId the eventlayout ID
	* @param start the lower bound of the range of event datas
	* @param end the upper bound of the range of event datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findByEventLayout(
		long eventlayoutId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event data in the ordered set where eventlayoutId = &#63;.
	*
	* @param eventlayoutId the eventlayout ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData findByEventLayout_First(
		long eventlayoutId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event data in the ordered set where eventlayoutId = &#63;.
	*
	* @param eventlayoutId the eventlayout ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event data, or <code>null</code> if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByEventLayout_First(
		long eventlayoutId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event data in the ordered set where eventlayoutId = &#63;.
	*
	* @param eventlayoutId the eventlayout ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData findByEventLayout_Last(
		long eventlayoutId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event data in the ordered set where eventlayoutId = &#63;.
	*
	* @param eventlayoutId the eventlayout ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event data, or <code>null</code> if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByEventLayout_Last(
		long eventlayoutId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event datas before and after the current event data in the ordered set where eventlayoutId = &#63;.
	*
	* @param eventdataId the primary key of the current event data
	* @param eventlayoutId the eventlayout ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a event data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData[] findByEventLayout_PrevAndNext(
		long eventdataId, long eventlayoutId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event datas where eventlayoutId = &#63; from the database.
	*
	* @param eventlayoutId the eventlayout ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEventLayout(long eventlayoutId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event datas where eventlayoutId = &#63;.
	*
	* @param eventlayoutId the eventlayout ID
	* @return the number of matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventLayout(long eventlayoutId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event datas where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @return the matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findByPatient(
		long patientId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findByPatient(
		long patientId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findByPatient(
		long patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event data in the ordered set where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData findByPatient_First(
		long patientId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event data in the ordered set where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event data, or <code>null</code> if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByPatient_First(
		long patientId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event data in the ordered set where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData findByPatient_Last(
		long patientId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event data in the ordered set where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event data, or <code>null</code> if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByPatient_Last(
		long patientId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData[] findByPatient_PrevAndNext(
		long eventdataId, long patientId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event datas where patientId = &#63; from the database.
	*
	* @param patientId the patient ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPatient(long patientId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event datas where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @return the number of matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByPatient(long patientId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event data where eventlayoutId = &#63; and ontology = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException} if it could not be found.
	*
	* @param eventlayoutId the eventlayout ID
	* @param ontology the ontology
	* @return the matching event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData findByDataByOntology(
		long eventlayoutId, java.lang.String ontology)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event data where eventlayoutId = &#63; and ontology = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param eventlayoutId the eventlayout ID
	* @param ontology the ontology
	* @return the matching event data, or <code>null</code> if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByDataByOntology(
		long eventlayoutId, java.lang.String ontology)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event data where eventlayoutId = &#63; and ontology = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param eventlayoutId the eventlayout ID
	* @param ontology the ontology
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching event data, or <code>null</code> if a matching event data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByDataByOntology(
		long eventlayoutId, java.lang.String ontology, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the event data where eventlayoutId = &#63; and ontology = &#63; from the database.
	*
	* @param eventlayoutId the eventlayout ID
	* @param ontology the ontology
	* @return the event data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData removeByDataByOntology(
		long eventlayoutId, java.lang.String ontology)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event datas where eventlayoutId = &#63; and ontology = &#63;.
	*
	* @param eventlayoutId the eventlayout ID
	* @param ontology the ontology
	* @return the number of matching event datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByDataByOntology(long eventlayoutId,
		java.lang.String ontology)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the event data in the entity cache if it is enabled.
	*
	* @param eventData the event data
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData eventData);

	/**
	* Caches the event datas in the entity cache if it is enabled.
	*
	* @param eventDatas the event datas
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> eventDatas);

	/**
	* Creates a new event data with the primary key. Does not add the event data to the database.
	*
	* @param eventdataId the primary key for the new event data
	* @return the new event data
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData create(
		long eventdataId);

	/**
	* Removes the event data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventdataId the primary key of the event data
	* @return the event data that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a event data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData remove(
		long eventdataId)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData eventData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event data with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException} if it could not be found.
	*
	* @param eventdataId the primary key of the event data
	* @return the event data
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a event data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData findByPrimaryKey(
		long eventdataId)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventdataId the primary key of the event data
	* @return the event data, or <code>null</code> if a event data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData fetchByPrimaryKey(
		long eventdataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event datas.
	*
	* @return the event datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event datas.
	*
	* @return the number of event datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}