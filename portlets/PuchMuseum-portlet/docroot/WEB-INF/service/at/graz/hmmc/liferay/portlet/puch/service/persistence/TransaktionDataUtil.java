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

import at.graz.hmmc.liferay.portlet.puch.model.TransaktionData;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the transaktion data service. This utility wraps {@link TransaktionDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see TransaktionDataPersistence
 * @see TransaktionDataPersistenceImpl
 * @generated
 */
public class TransaktionDataUtil {
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
	public static void clearCache(TransaktionData transaktionData) {
		getPersistence().clearCache(transaktionData);
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
	public static List<TransaktionData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TransaktionData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TransaktionData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TransaktionData update(TransaktionData transaktionData)
		throws SystemException {
		return getPersistence().update(transaktionData);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TransaktionData update(TransaktionData transaktionData,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(transaktionData, serviceContext);
	}

	/**
	* Returns all the transaktion datas where transaktionId = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @return the matching transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> findByTransaction(
		long transaktionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTransaction(transaktionId);
	}

	/**
	* Returns a range of all the transaktion datas where transaktionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param transaktionId the transaktion ID
	* @param start the lower bound of the range of transaktion datas
	* @param end the upper bound of the range of transaktion datas (not inclusive)
	* @return the range of matching transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> findByTransaction(
		long transaktionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTransaction(transaktionId, start, end);
	}

	/**
	* Returns an ordered range of all the transaktion datas where transaktionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param transaktionId the transaktion ID
	* @param start the lower bound of the range of transaktion datas
	* @param end the upper bound of the range of transaktion datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> findByTransaction(
		long transaktionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransaction(transaktionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first transaktion data in the ordered set where transaktionId = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching transaktion data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData findByTransaction_First(
		long transaktionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransaction_First(transaktionId, orderByComparator);
	}

	/**
	* Returns the first transaktion data in the ordered set where transaktionId = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching transaktion data, or <code>null</code> if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData fetchByTransaction_First(
		long transaktionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTransaction_First(transaktionId, orderByComparator);
	}

	/**
	* Returns the last transaktion data in the ordered set where transaktionId = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching transaktion data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData findByTransaction_Last(
		long transaktionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransaction_Last(transaktionId, orderByComparator);
	}

	/**
	* Returns the last transaktion data in the ordered set where transaktionId = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching transaktion data, or <code>null</code> if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData fetchByTransaction_Last(
		long transaktionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTransaction_Last(transaktionId, orderByComparator);
	}

	/**
	* Returns the transaktion datas before and after the current transaktion data in the ordered set where transaktionId = &#63;.
	*
	* @param transaktiondataId the primary key of the current transaktion data
	* @param transaktionId the transaktion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next transaktion data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a transaktion data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData[] findByTransaction_PrevAndNext(
		long transaktiondataId, long transaktionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransaction_PrevAndNext(transaktiondataId,
			transaktionId, orderByComparator);
	}

	/**
	* Removes all the transaktion datas where transaktionId = &#63; from the database.
	*
	* @param transaktionId the transaktion ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTransaction(long transaktionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTransaction(transaktionId);
	}

	/**
	* Returns the number of transaktion datas where transaktionId = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @return the number of matching transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTransaction(long transaktionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTransaction(transaktionId);
	}

	/**
	* Returns the transaktion data where transaktionId = &#63; and objectkey = &#63; or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException} if it could not be found.
	*
	* @param transaktionId the transaktion ID
	* @param objectkey the objectkey
	* @return the matching transaktion data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData findByDataByOntology(
		long transaktionId, java.lang.String objectkey)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDataByOntology(transaktionId, objectkey);
	}

	/**
	* Returns the transaktion data where transaktionId = &#63; and objectkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param transaktionId the transaktion ID
	* @param objectkey the objectkey
	* @return the matching transaktion data, or <code>null</code> if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData fetchByDataByOntology(
		long transaktionId, java.lang.String objectkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDataByOntology(transaktionId, objectkey);
	}

	/**
	* Returns the transaktion data where transaktionId = &#63; and objectkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param transaktionId the transaktion ID
	* @param objectkey the objectkey
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching transaktion data, or <code>null</code> if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData fetchByDataByOntology(
		long transaktionId, java.lang.String objectkey,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDataByOntology(transaktionId, objectkey,
			retrieveFromCache);
	}

	/**
	* Removes the transaktion data where transaktionId = &#63; and objectkey = &#63; from the database.
	*
	* @param transaktionId the transaktion ID
	* @param objectkey the objectkey
	* @return the transaktion data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData removeByDataByOntology(
		long transaktionId, java.lang.String objectkey)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByDataByOntology(transaktionId, objectkey);
	}

	/**
	* Returns the number of transaktion datas where transaktionId = &#63; and objectkey = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @param objectkey the objectkey
	* @return the number of matching transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDataByOntology(long transaktionId,
		java.lang.String objectkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDataByOntology(transaktionId, objectkey);
	}

	/**
	* Caches the transaktion data in the entity cache if it is enabled.
	*
	* @param transaktionData the transaktion data
	*/
	public static void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.TransaktionData transaktionData) {
		getPersistence().cacheResult(transaktionData);
	}

	/**
	* Caches the transaktion datas in the entity cache if it is enabled.
	*
	* @param transaktionDatas the transaktion datas
	*/
	public static void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> transaktionDatas) {
		getPersistence().cacheResult(transaktionDatas);
	}

	/**
	* Creates a new transaktion data with the primary key. Does not add the transaktion data to the database.
	*
	* @param transaktiondataId the primary key for the new transaktion data
	* @return the new transaktion data
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData create(
		long transaktiondataId) {
		return getPersistence().create(transaktiondataId);
	}

	/**
	* Removes the transaktion data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transaktiondataId the primary key of the transaktion data
	* @return the transaktion data that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a transaktion data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData remove(
		long transaktiondataId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(transaktiondataId);
	}

	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.TransaktionData transaktionData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(transaktionData);
	}

	/**
	* Returns the transaktion data with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException} if it could not be found.
	*
	* @param transaktiondataId the primary key of the transaktion data
	* @return the transaktion data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a transaktion data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData findByPrimaryKey(
		long transaktiondataId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(transaktiondataId);
	}

	/**
	* Returns the transaktion data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transaktiondataId the primary key of the transaktion data
	* @return the transaktion data, or <code>null</code> if a transaktion data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.TransaktionData fetchByPrimaryKey(
		long transaktiondataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(transaktiondataId);
	}

	/**
	* Returns all the transaktion datas.
	*
	* @return the transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the transaktion datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of transaktion datas
	* @param end the upper bound of the range of transaktion datas (not inclusive)
	* @return the range of transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the transaktion datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of transaktion datas
	* @param end the upper bound of the range of transaktion datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the transaktion datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of transaktion datas.
	*
	* @return the number of transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TransaktionDataPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TransaktionDataPersistence)PortletBeanLocatorUtil.locate(at.graz.hmmc.liferay.portlet.puch.service.ClpSerializer.getServletContextName(),
					TransaktionDataPersistence.class.getName());

			ReferenceRegistry.registerReference(TransaktionDataUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TransaktionDataPersistence persistence) {
	}

	private static TransaktionDataPersistence _persistence;
}