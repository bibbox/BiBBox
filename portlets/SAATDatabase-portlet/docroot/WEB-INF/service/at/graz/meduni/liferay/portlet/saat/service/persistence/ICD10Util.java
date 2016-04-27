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

import at.graz.meduni.liferay.portlet.saat.model.ICD10;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the i c d10 service. This utility wraps {@link ICD10PersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ICD10Persistence
 * @see ICD10PersistenceImpl
 * @generated
 */
public class ICD10Util {
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
	public static void clearCache(ICD10 icd10) {
		getPersistence().clearCache(icd10);
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
	public static List<ICD10> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ICD10> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ICD10> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ICD10 update(ICD10 icd10) throws SystemException {
		return getPersistence().update(icd10);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ICD10 update(ICD10 icd10, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(icd10, serviceContext);
	}

	/**
	* Returns all the i c d10s where code = &#63;.
	*
	* @param code the code
	* @return the matching i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICD10> findByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns a range of all the i c d10s where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.ICD10ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of i c d10s
	* @param end the upper bound of the range of i c d10s (not inclusive)
	* @return the range of matching i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICD10> findByCode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	* Returns an ordered range of all the i c d10s where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.ICD10ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of i c d10s
	* @param end the upper bound of the range of i c d10s (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICD10> findByCode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	* Returns the first i c d10 in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i c d10
	* @throws at.graz.meduni.liferay.portlet.saat.NoSuchICD10Exception if a matching i c d10 could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICD10 findByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.NoSuchICD10Exception,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	* Returns the first i c d10 in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i c d10, or <code>null</code> if a matching i c d10 could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICD10 fetchByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	* Returns the last i c d10 in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i c d10
	* @throws at.graz.meduni.liferay.portlet.saat.NoSuchICD10Exception if a matching i c d10 could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICD10 findByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.NoSuchICD10Exception,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	* Returns the last i c d10 in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i c d10, or <code>null</code> if a matching i c d10 could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICD10 fetchByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	* Returns the i c d10s before and after the current i c d10 in the ordered set where code = &#63;.
	*
	* @param icd10Id the primary key of the current i c d10
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i c d10
	* @throws at.graz.meduni.liferay.portlet.saat.NoSuchICD10Exception if a i c d10 with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICD10[] findByCode_PrevAndNext(
		long icd10Id, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.NoSuchICD10Exception,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCode_PrevAndNext(icd10Id, code, orderByComparator);
	}

	/**
	* Removes all the i c d10s where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCode(code);
	}

	/**
	* Returns the number of i c d10s where code = &#63;.
	*
	* @param code the code
	* @return the number of matching i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Caches the i c d10 in the entity cache if it is enabled.
	*
	* @param icd10 the i c d10
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.saat.model.ICD10 icd10) {
		getPersistence().cacheResult(icd10);
	}

	/**
	* Caches the i c d10s in the entity cache if it is enabled.
	*
	* @param icd10s the i c d10s
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICD10> icd10s) {
		getPersistence().cacheResult(icd10s);
	}

	/**
	* Creates a new i c d10 with the primary key. Does not add the i c d10 to the database.
	*
	* @param icd10Id the primary key for the new i c d10
	* @return the new i c d10
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICD10 create(
		long icd10Id) {
		return getPersistence().create(icd10Id);
	}

	/**
	* Removes the i c d10 with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param icd10Id the primary key of the i c d10
	* @return the i c d10 that was removed
	* @throws at.graz.meduni.liferay.portlet.saat.NoSuchICD10Exception if a i c d10 with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICD10 remove(
		long icd10Id)
		throws at.graz.meduni.liferay.portlet.saat.NoSuchICD10Exception,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(icd10Id);
	}

	public static at.graz.meduni.liferay.portlet.saat.model.ICD10 updateImpl(
		at.graz.meduni.liferay.portlet.saat.model.ICD10 icd10)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(icd10);
	}

	/**
	* Returns the i c d10 with the primary key or throws a {@link at.graz.meduni.liferay.portlet.saat.NoSuchICD10Exception} if it could not be found.
	*
	* @param icd10Id the primary key of the i c d10
	* @return the i c d10
	* @throws at.graz.meduni.liferay.portlet.saat.NoSuchICD10Exception if a i c d10 with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICD10 findByPrimaryKey(
		long icd10Id)
		throws at.graz.meduni.liferay.portlet.saat.NoSuchICD10Exception,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(icd10Id);
	}

	/**
	* Returns the i c d10 with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param icd10Id the primary key of the i c d10
	* @return the i c d10, or <code>null</code> if a i c d10 with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.saat.model.ICD10 fetchByPrimaryKey(
		long icd10Id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(icd10Id);
	}

	/**
	* Returns all the i c d10s.
	*
	* @return the i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICD10> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the i c d10s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.ICD10ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i c d10s
	* @param end the upper bound of the range of i c d10s (not inclusive)
	* @return the range of i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICD10> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the i c d10s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.ICD10ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i c d10s
	* @param end the upper bound of the range of i c d10s (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.saat.model.ICD10> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the i c d10s from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of i c d10s.
	*
	* @return the number of i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ICD10Persistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ICD10Persistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.saat.service.ClpSerializer.getServletContextName(),
					ICD10Persistence.class.getName());

			ReferenceRegistry.registerReference(ICD10Util.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ICD10Persistence persistence) {
	}

	private static ICD10Persistence _persistence;
}