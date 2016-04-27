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

package at.graz.meduni.liferay.portlet.saat.service.persistence;

import at.graz.meduni.liferay.portlet.saat.model.ICDO3;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the i c d o3 service. This utility wraps {@link ICDO3PersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ICDO3Persistence
 * @see ICDO3PersistenceImpl
 * @generated
 */
public class ICDO3Util {
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
	public static void clearCache(ICDO3 icdo3) {
		getPersistence().clearCache(icdo3);
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
	public static List<ICDO3> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ICDO3> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ICDO3> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ICDO3 update(ICDO3 icdo3) throws SystemException {
		return getPersistence().update(icdo3);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ICDO3 update(ICDO3 icdo3, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(icdo3, serviceContext);
	}

	/**
	* Returns all the i c d o3s where code = &#63;.
	*
	* @param code the code
	* @return the matching i c d o3s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICDO3> findByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns a range of all the i c d o3s where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.ICDO3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of i c d o3s
	* @param end the upper bound of the range of i c d o3s (not inclusive)
	* @return the range of matching i c d o3s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICDO3> findByCode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	* Returns an ordered range of all the i c d o3s where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.ICDO3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of i c d o3s
	* @param end the upper bound of the range of i c d o3s (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i c d o3s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICDO3> findByCode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	* Returns the first i c d o3 in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i c d o3
	* @throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception if a matching i c d o3 could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICDO3 findByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	* Returns the first i c d o3 in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i c d o3, or <code>null</code> if a matching i c d o3 could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICDO3 fetchByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	* Returns the last i c d o3 in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i c d o3
	* @throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception if a matching i c d o3 could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICDO3 findByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	* Returns the last i c d o3 in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i c d o3, or <code>null</code> if a matching i c d o3 could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICDO3 fetchByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	* Returns the i c d o3s before and after the current i c d o3 in the ordered set where code = &#63;.
	*
	* @param icdo3Id the primary key of the current i c d o3
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i c d o3
	* @throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception if a i c d o3 with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICDO3[] findByCode_PrevAndNext(
		long icdo3Id, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCode_PrevAndNext(icdo3Id, code, orderByComparator);
	}

	/**
	* Removes all the i c d o3s where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCode(code);
	}

	/**
	* Returns the number of i c d o3s where code = &#63;.
	*
	* @param code the code
	* @return the number of matching i c d o3s
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Caches the i c d o3 in the entity cache if it is enabled.
	*
	* @param icdo3 the i c d o3
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.saat.model.ICDO3 icdo3) {
		getPersistence().cacheResult(icdo3);
	}

	/**
	* Caches the i c d o3s in the entity cache if it is enabled.
	*
	* @param icdo3s the i c d o3s
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICDO3> icdo3s) {
		getPersistence().cacheResult(icdo3s);
	}

	/**
	* Creates a new i c d o3 with the primary key. Does not add the i c d o3 to the database.
	*
	* @param icdo3Id the primary key for the new i c d o3
	* @return the new i c d o3
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICDO3 create(
		long icdo3Id) {
		return getPersistence().create(icdo3Id);
	}

	/**
	* Removes the i c d o3 with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param icdo3Id the primary key of the i c d o3
	* @return the i c d o3 that was removed
	* @throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception if a i c d o3 with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICDO3 remove(
		long icdo3Id)
		throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(icdo3Id);
	}

	public static at.graz.meduni.liferay.portlet.saat.model.ICDO3 updateImpl(
		at.graz.meduni.liferay.portlet.saat.model.ICDO3 icdo3)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(icdo3);
	}

	/**
	* Returns the i c d o3 with the primary key or throws a {@link at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception} if it could not be found.
	*
	* @param icdo3Id the primary key of the i c d o3
	* @return the i c d o3
	* @throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception if a i c d o3 with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICDO3 findByPrimaryKey(
		long icdo3Id)
		throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(icdo3Id);
	}

	/**
	* Returns the i c d o3 with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param icdo3Id the primary key of the i c d o3
	* @return the i c d o3, or <code>null</code> if a i c d o3 with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICDO3 fetchByPrimaryKey(
		long icdo3Id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(icdo3Id);
	}

	/**
	* Returns all the i c d o3s.
	*
	* @return the i c d o3s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICDO3> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the i c d o3s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.ICDO3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i c d o3s
	* @param end the upper bound of the range of i c d o3s (not inclusive)
	* @return the range of i c d o3s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICDO3> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the i c d o3s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.ICDO3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i c d o3s
	* @param end the upper bound of the range of i c d o3s (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of i c d o3s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICDO3> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the i c d o3s from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of i c d o3s.
	*
	* @return the number of i c d o3s
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ICDO3Persistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ICDO3Persistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.saat.service.ClpSerializer.getServletContextName(),
					ICDO3Persistence.class.getName());

			ReferenceRegistry.registerReference(ICDO3Util.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ICDO3Persistence persistence) {
	}

	private static ICDO3Persistence _persistence;
}