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

package at.graz.hmmc.liferay.portlet.puch.service.persistence;

import at.graz.hmmc.liferay.portlet.puch.model.ObjectData;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the object data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ObjectDataPersistenceImpl
 * @see ObjectDataUtil
 * @generated
 */
public interface ObjectDataPersistence extends BasePersistence<ObjectData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ObjectDataUtil} to access the object data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the object datas where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @return the matching object datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> findByEvent(
		long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the object datas where puchmuseumsobjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param start the lower bound of the range of object datas
	* @param end the upper bound of the range of object datas (not inclusive)
	* @return the range of matching object datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> findByEvent(
		long puchmuseumsobjectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the object datas where puchmuseumsobjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param start the lower bound of the range of object datas
	* @param end the upper bound of the range of object datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching object datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> findByEvent(
		long puchmuseumsobjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first object data in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData findByEvent_First(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first object data in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object data, or <code>null</code> if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData fetchByEvent_First(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last object data in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData findByEvent_Last(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last object data in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object data, or <code>null</code> if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData fetchByEvent_Last(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object datas before and after the current object data in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param objectdataId the primary key of the current object data
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next object data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a object data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData[] findByEvent_PrevAndNext(
		long objectdataId, long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the object datas where puchmuseumsobjectId = &#63; from the database.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEvent(long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of object datas where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @return the number of matching object datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByEvent(long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object data where puchmuseumsobjectId = &#63; and objectkey = &#63; or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException} if it could not be found.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param objectkey the objectkey
	* @return the matching object data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData findByDataByOntology(
		long puchmuseumsobjectId, java.lang.String objectkey)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object data where puchmuseumsobjectId = &#63; and objectkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param objectkey the objectkey
	* @return the matching object data, or <code>null</code> if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData fetchByDataByOntology(
		long puchmuseumsobjectId, java.lang.String objectkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object data where puchmuseumsobjectId = &#63; and objectkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param objectkey the objectkey
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching object data, or <code>null</code> if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData fetchByDataByOntology(
		long puchmuseumsobjectId, java.lang.String objectkey,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the object data where puchmuseumsobjectId = &#63; and objectkey = &#63; from the database.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param objectkey the objectkey
	* @return the object data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData removeByDataByOntology(
		long puchmuseumsobjectId, java.lang.String objectkey)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of object datas where puchmuseumsobjectId = &#63; and objectkey = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param objectkey the objectkey
	* @return the number of matching object datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByDataByOntology(long puchmuseumsobjectId,
		java.lang.String objectkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the object data in the entity cache if it is enabled.
	*
	* @param objectData the object data
	*/
	public void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectData objectData);

	/**
	* Caches the object datas in the entity cache if it is enabled.
	*
	* @param objectDatas the object datas
	*/
	public void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> objectDatas);

	/**
	* Creates a new object data with the primary key. Does not add the object data to the database.
	*
	* @param objectdataId the primary key for the new object data
	* @return the new object data
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData create(
		long objectdataId);

	/**
	* Removes the object data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param objectdataId the primary key of the object data
	* @return the object data that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a object data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData remove(
		long objectdataId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectData objectData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object data with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException} if it could not be found.
	*
	* @param objectdataId the primary key of the object data
	* @return the object data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a object data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData findByPrimaryKey(
		long objectdataId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param objectdataId the primary key of the object data
	* @return the object data, or <code>null</code> if a object data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData fetchByPrimaryKey(
		long objectdataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the object datas.
	*
	* @return the object datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the object datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of object datas
	* @param end the upper bound of the range of object datas (not inclusive)
	* @return the range of object datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the object datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of object datas
	* @param end the upper bound of the range of object datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of object datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the object datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of object datas.
	*
	* @return the number of object datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}