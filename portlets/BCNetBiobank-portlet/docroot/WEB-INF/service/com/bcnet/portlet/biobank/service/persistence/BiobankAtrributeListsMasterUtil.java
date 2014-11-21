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

package com.bcnet.portlet.biobank.service.persistence;

import com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the biobank atrribute lists master service. This utility wraps {@link BiobankAtrributeListsMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankAtrributeListsMasterPersistence
 * @see BiobankAtrributeListsMasterPersistenceImpl
 * @generated
 */
public class BiobankAtrributeListsMasterUtil {
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
	public static void clearCache(
		BiobankAtrributeListsMaster biobankAtrributeListsMaster) {
		getPersistence().clearCache(biobankAtrributeListsMaster);
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
	public static List<BiobankAtrributeListsMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BiobankAtrributeListsMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BiobankAtrributeListsMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BiobankAtrributeListsMaster update(
		BiobankAtrributeListsMaster biobankAtrributeListsMaster)
		throws SystemException {
		return getPersistence().update(biobankAtrributeListsMaster);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BiobankAtrributeListsMaster update(
		BiobankAtrributeListsMaster biobankAtrributeListsMaster,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(biobankAtrributeListsMaster, serviceContext);
	}

	/**
	* Returns all the biobank atrribute lists masters where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @return the matching biobank atrribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster> findByattribute(
		java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByattribute(attributeListName);
	}

	/**
	* Returns a range of all the biobank atrribute lists masters where attributeListName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAtrributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param attributeListName the attribute list name
	* @param start the lower bound of the range of biobank atrribute lists masters
	* @param end the upper bound of the range of biobank atrribute lists masters (not inclusive)
	* @return the range of matching biobank atrribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster> findByattribute(
		java.lang.String attributeListName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByattribute(attributeListName, start, end);
	}

	/**
	* Returns an ordered range of all the biobank atrribute lists masters where attributeListName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAtrributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param attributeListName the attribute list name
	* @param start the lower bound of the range of biobank atrribute lists masters
	* @param end the upper bound of the range of biobank atrribute lists masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching biobank atrribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster> findByattribute(
		java.lang.String attributeListName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattribute(attributeListName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first biobank atrribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching biobank atrribute lists master
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException if a matching biobank atrribute lists master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster findByattribute_First(
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattribute_First(attributeListName, orderByComparator);
	}

	/**
	* Returns the first biobank atrribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching biobank atrribute lists master, or <code>null</code> if a matching biobank atrribute lists master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster fetchByattribute_First(
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByattribute_First(attributeListName, orderByComparator);
	}

	/**
	* Returns the last biobank atrribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching biobank atrribute lists master
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException if a matching biobank atrribute lists master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster findByattribute_Last(
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattribute_Last(attributeListName, orderByComparator);
	}

	/**
	* Returns the last biobank atrribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching biobank atrribute lists master, or <code>null</code> if a matching biobank atrribute lists master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster fetchByattribute_Last(
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByattribute_Last(attributeListName, orderByComparator);
	}

	/**
	* Returns the biobank atrribute lists masters before and after the current biobank atrribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param biobankAttributeListsMasterId the primary key of the current biobank atrribute lists master
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next biobank atrribute lists master
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException if a biobank atrribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster[] findByattribute_PrevAndNext(
		long biobankAttributeListsMasterId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattribute_PrevAndNext(biobankAttributeListsMasterId,
			attributeListName, orderByComparator);
	}

	/**
	* Removes all the biobank atrribute lists masters where attributeListName = &#63; from the database.
	*
	* @param attributeListName the attribute list name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByattribute(java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByattribute(attributeListName);
	}

	/**
	* Returns the number of biobank atrribute lists masters where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @return the number of matching biobank atrribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByattribute(java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByattribute(attributeListName);
	}

	/**
	* Caches the biobank atrribute lists master in the entity cache if it is enabled.
	*
	* @param biobankAtrributeListsMaster the biobank atrribute lists master
	*/
	public static void cacheResult(
		com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster biobankAtrributeListsMaster) {
		getPersistence().cacheResult(biobankAtrributeListsMaster);
	}

	/**
	* Caches the biobank atrribute lists masters in the entity cache if it is enabled.
	*
	* @param biobankAtrributeListsMasters the biobank atrribute lists masters
	*/
	public static void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster> biobankAtrributeListsMasters) {
		getPersistence().cacheResult(biobankAtrributeListsMasters);
	}

	/**
	* Creates a new biobank atrribute lists master with the primary key. Does not add the biobank atrribute lists master to the database.
	*
	* @param biobankAttributeListsMasterId the primary key for the new biobank atrribute lists master
	* @return the new biobank atrribute lists master
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster create(
		long biobankAttributeListsMasterId) {
		return getPersistence().create(biobankAttributeListsMasterId);
	}

	/**
	* Removes the biobank atrribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeListsMasterId the primary key of the biobank atrribute lists master
	* @return the biobank atrribute lists master that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException if a biobank atrribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster remove(
		long biobankAttributeListsMasterId)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(biobankAttributeListsMasterId);
	}

	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster updateImpl(
		com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster biobankAtrributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(biobankAtrributeListsMaster);
	}

	/**
	* Returns the biobank atrribute lists master with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException} if it could not be found.
	*
	* @param biobankAttributeListsMasterId the primary key of the biobank atrribute lists master
	* @return the biobank atrribute lists master
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException if a biobank atrribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster findByPrimaryKey(
		long biobankAttributeListsMasterId)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(biobankAttributeListsMasterId);
	}

	/**
	* Returns the biobank atrribute lists master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param biobankAttributeListsMasterId the primary key of the biobank atrribute lists master
	* @return the biobank atrribute lists master, or <code>null</code> if a biobank atrribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster fetchByPrimaryKey(
		long biobankAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(biobankAttributeListsMasterId);
	}

	/**
	* Returns all the biobank atrribute lists masters.
	*
	* @return the biobank atrribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the biobank atrribute lists masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAtrributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank atrribute lists masters
	* @param end the upper bound of the range of biobank atrribute lists masters (not inclusive)
	* @return the range of biobank atrribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the biobank atrribute lists masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAtrributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank atrribute lists masters
	* @param end the upper bound of the range of biobank atrribute lists masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of biobank atrribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the biobank atrribute lists masters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of biobank atrribute lists masters.
	*
	* @return the number of biobank atrribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BiobankAtrributeListsMasterPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BiobankAtrributeListsMasterPersistence)PortletBeanLocatorUtil.locate(com.bcnet.portlet.biobank.service.ClpSerializer.getServletContextName(),
					BiobankAtrributeListsMasterPersistence.class.getName());

			ReferenceRegistry.registerReference(BiobankAtrributeListsMasterUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		BiobankAtrributeListsMasterPersistence persistence) {
	}

	private static BiobankAtrributeListsMasterPersistence _persistence;
}