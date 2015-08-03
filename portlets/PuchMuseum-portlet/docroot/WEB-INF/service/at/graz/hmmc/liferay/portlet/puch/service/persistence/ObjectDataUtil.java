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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the object data service. This utility wraps {@link ObjectDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ObjectDataPersistence
 * @see ObjectDataPersistenceImpl
 * @generated
 */
public class ObjectDataUtil {
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
	public static void clearCache(ObjectData objectData) {
		getPersistence().clearCache(objectData);
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
	public static List<ObjectData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ObjectData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ObjectData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ObjectData update(ObjectData objectData)
		throws SystemException {
		return getPersistence().update(objectData);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ObjectData update(ObjectData objectData,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(objectData, serviceContext);
	}

	/**
	* Returns all the object datas where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @return the matching object datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> findByEvent(
		long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEvent(puchmuseumsobjectId);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> findByEvent(
		long puchmuseumsobjectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEvent(puchmuseumsobjectId, start, end);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> findByEvent(
		long puchmuseumsobjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEvent(puchmuseumsobjectId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first object data in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData findByEvent_First(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEvent_First(puchmuseumsobjectId, orderByComparator);
	}

	/**
	* Returns the first object data in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object data, or <code>null</code> if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData fetchByEvent_First(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEvent_First(puchmuseumsobjectId, orderByComparator);
	}

	/**
	* Returns the last object data in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData findByEvent_Last(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEvent_Last(puchmuseumsobjectId, orderByComparator);
	}

	/**
	* Returns the last object data in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object data, or <code>null</code> if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData fetchByEvent_Last(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEvent_Last(puchmuseumsobjectId, orderByComparator);
	}

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
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData[] findByEvent_PrevAndNext(
		long objectdataId, long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEvent_PrevAndNext(objectdataId, puchmuseumsobjectId,
			orderByComparator);
	}

	/**
	* Removes all the object datas where puchmuseumsobjectId = &#63; from the database.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEvent(long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEvent(puchmuseumsobjectId);
	}

	/**
	* Returns the number of object datas where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @return the number of matching object datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEvent(long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEvent(puchmuseumsobjectId);
	}

	/**
	* Returns the object data where puchmuseumsobjectId = &#63; and objectkey = &#63; or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException} if it could not be found.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param objectkey the objectkey
	* @return the matching object data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData findByDataByOntology(
		long puchmuseumsobjectId, java.lang.String objectkey)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDataByOntology(puchmuseumsobjectId, objectkey);
	}

	/**
	* Returns the object data where puchmuseumsobjectId = &#63; and objectkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param objectkey the objectkey
	* @return the matching object data, or <code>null</code> if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData fetchByDataByOntology(
		long puchmuseumsobjectId, java.lang.String objectkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDataByOntology(puchmuseumsobjectId, objectkey);
	}

	/**
	* Returns the object data where puchmuseumsobjectId = &#63; and objectkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param objectkey the objectkey
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching object data, or <code>null</code> if a matching object data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData fetchByDataByOntology(
		long puchmuseumsobjectId, java.lang.String objectkey,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDataByOntology(puchmuseumsobjectId, objectkey,
			retrieveFromCache);
	}

	/**
	* Removes the object data where puchmuseumsobjectId = &#63; and objectkey = &#63; from the database.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param objectkey the objectkey
	* @return the object data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData removeByDataByOntology(
		long puchmuseumsobjectId, java.lang.String objectkey)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByDataByOntology(puchmuseumsobjectId, objectkey);
	}

	/**
	* Returns the number of object datas where puchmuseumsobjectId = &#63; and objectkey = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param objectkey the objectkey
	* @return the number of matching object datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDataByOntology(long puchmuseumsobjectId,
		java.lang.String objectkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByDataByOntology(puchmuseumsobjectId, objectkey);
	}

	/**
	* Caches the object data in the entity cache if it is enabled.
	*
	* @param objectData the object data
	*/
	public static void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectData objectData) {
		getPersistence().cacheResult(objectData);
	}

	/**
	* Caches the object datas in the entity cache if it is enabled.
	*
	* @param objectDatas the object datas
	*/
	public static void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> objectDatas) {
		getPersistence().cacheResult(objectDatas);
	}

	/**
	* Creates a new object data with the primary key. Does not add the object data to the database.
	*
	* @param objectdataId the primary key for the new object data
	* @return the new object data
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData create(
		long objectdataId) {
		return getPersistence().create(objectdataId);
	}

	/**
	* Removes the object data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param objectdataId the primary key of the object data
	* @return the object data that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a object data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData remove(
		long objectdataId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(objectdataId);
	}

	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectData objectData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(objectData);
	}

	/**
	* Returns the object data with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException} if it could not be found.
	*
	* @param objectdataId the primary key of the object data
	* @return the object data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a object data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData findByPrimaryKey(
		long objectdataId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(objectdataId);
	}

	/**
	* Returns the object data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param objectdataId the primary key of the object data
	* @return the object data, or <code>null</code> if a object data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectData fetchByPrimaryKey(
		long objectdataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(objectdataId);
	}

	/**
	* Returns all the object datas.
	*
	* @return the object datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the object datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of object datas.
	*
	* @return the number of object datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ObjectDataPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ObjectDataPersistence)PortletBeanLocatorUtil.locate(at.graz.hmmc.liferay.portlet.puch.service.ClpSerializer.getServletContextName(),
					ObjectDataPersistence.class.getName());

			ReferenceRegistry.registerReference(ObjectDataUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ObjectDataPersistence persistence) {
	}

	private static ObjectDataPersistence _persistence;
}