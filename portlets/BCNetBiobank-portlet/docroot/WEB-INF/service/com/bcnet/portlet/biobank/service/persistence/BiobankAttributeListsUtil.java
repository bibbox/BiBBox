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

import com.bcnet.portlet.biobank.model.BiobankAttributeLists;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the biobank attribute lists service. This utility wraps {@link BiobankAttributeListsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankAttributeListsPersistence
 * @see BiobankAttributeListsPersistenceImpl
 * @generated
 */
public class BiobankAttributeListsUtil {
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
	public static void clearCache(BiobankAttributeLists biobankAttributeLists) {
		getPersistence().clearCache(biobankAttributeLists);
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
	public static List<BiobankAttributeLists> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BiobankAttributeLists> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BiobankAttributeLists> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BiobankAttributeLists update(
		BiobankAttributeLists biobankAttributeLists) throws SystemException {
		return getPersistence().update(biobankAttributeLists);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BiobankAttributeLists update(
		BiobankAttributeLists biobankAttributeLists,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(biobankAttributeLists, serviceContext);
	}

	/**
	* Returns all the biobank attribute listses where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @return the matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findBybiobankDbId(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybiobankDbId(biobankDbId);
	}

	/**
	* Returns a range of all the biobank attribute listses where biobankDbId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param biobankDbId the biobank db ID
	* @param start the lower bound of the range of biobank attribute listses
	* @param end the upper bound of the range of biobank attribute listses (not inclusive)
	* @return the range of matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findBybiobankDbId(
		long biobankDbId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybiobankDbId(biobankDbId, start, end);
	}

	/**
	* Returns an ordered range of all the biobank attribute listses where biobankDbId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param biobankDbId the biobank db ID
	* @param start the lower bound of the range of biobank attribute listses
	* @param end the upper bound of the range of biobank attribute listses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findBybiobankDbId(
		long biobankDbId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybiobankDbId(biobankDbId, start, end, orderByComparator);
	}

	/**
	* Returns the first biobank attribute lists in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching biobank attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists findBybiobankDbId_First(
		long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybiobankDbId_First(biobankDbId, orderByComparator);
	}

	/**
	* Returns the first biobank attribute lists in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBybiobankDbId_First(
		long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybiobankDbId_First(biobankDbId, orderByComparator);
	}

	/**
	* Returns the last biobank attribute lists in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching biobank attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists findBybiobankDbId_Last(
		long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybiobankDbId_Last(biobankDbId, orderByComparator);
	}

	/**
	* Returns the last biobank attribute lists in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBybiobankDbId_Last(
		long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybiobankDbId_Last(biobankDbId, orderByComparator);
	}

	/**
	* Returns the biobank attribute listses before and after the current biobank attribute lists in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankAttributeListsId the primary key of the current biobank attribute lists
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next biobank attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a biobank attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists[] findBybiobankDbId_PrevAndNext(
		long biobankAttributeListsId, long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybiobankDbId_PrevAndNext(biobankAttributeListsId,
			biobankDbId, orderByComparator);
	}

	/**
	* Removes all the biobank attribute listses where biobankDbId = &#63; from the database.
	*
	* @param biobankDbId the biobank db ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybiobankDbId(long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybiobankDbId(biobankDbId);
	}

	/**
	* Returns the number of biobank attribute listses where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @return the number of matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybiobankDbId(long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybiobankDbId(biobankDbId);
	}

	/**
	* Returns all the biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @return the matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findBybiobankDbId_attributeListName(
		long biobankDbId, java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybiobankDbId_attributeListName(biobankDbId,
			attributeListName);
	}

	/**
	* Returns a range of all the biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param start the lower bound of the range of biobank attribute listses
	* @param end the upper bound of the range of biobank attribute listses (not inclusive)
	* @return the range of matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findBybiobankDbId_attributeListName(
		long biobankDbId, java.lang.String attributeListName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybiobankDbId_attributeListName(biobankDbId,
			attributeListName, start, end);
	}

	/**
	* Returns an ordered range of all the biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param start the lower bound of the range of biobank attribute listses
	* @param end the upper bound of the range of biobank attribute listses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findBybiobankDbId_attributeListName(
		long biobankDbId, java.lang.String attributeListName, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybiobankDbId_attributeListName(biobankDbId,
			attributeListName, start, end, orderByComparator);
	}

	/**
	* Returns the first biobank attribute lists in the ordered set where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching biobank attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists findBybiobankDbId_attributeListName_First(
		long biobankDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybiobankDbId_attributeListName_First(biobankDbId,
			attributeListName, orderByComparator);
	}

	/**
	* Returns the first biobank attribute lists in the ordered set where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBybiobankDbId_attributeListName_First(
		long biobankDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybiobankDbId_attributeListName_First(biobankDbId,
			attributeListName, orderByComparator);
	}

	/**
	* Returns the last biobank attribute lists in the ordered set where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching biobank attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists findBybiobankDbId_attributeListName_Last(
		long biobankDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybiobankDbId_attributeListName_Last(biobankDbId,
			attributeListName, orderByComparator);
	}

	/**
	* Returns the last biobank attribute lists in the ordered set where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBybiobankDbId_attributeListName_Last(
		long biobankDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybiobankDbId_attributeListName_Last(biobankDbId,
			attributeListName, orderByComparator);
	}

	/**
	* Returns the biobank attribute listses before and after the current biobank attribute lists in the ordered set where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* @param biobankAttributeListsId the primary key of the current biobank attribute lists
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next biobank attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a biobank attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists[] findBybiobankDbId_attributeListName_PrevAndNext(
		long biobankAttributeListsId, long biobankDbId,
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybiobankDbId_attributeListName_PrevAndNext(biobankAttributeListsId,
			biobankDbId, attributeListName, orderByComparator);
	}

	/**
	* Removes all the biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63; from the database.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybiobankDbId_attributeListName(long biobankDbId,
		java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBybiobankDbId_attributeListName(biobankDbId,
			attributeListName);
	}

	/**
	* Returns the number of biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @return the number of matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybiobankDbId_attributeListName(long biobankDbId,
		java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBybiobankDbId_attributeListName(biobankDbId,
			attributeListName);
	}

	/**
	* Returns the biobank attribute lists where biobankDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException} if it could not be found.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the matching biobank attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists findBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybiobankDbId_attributeListName_attributeListValue(biobankDbId,
			attributeListName, attributeListValue);
	}

	/**
	* Returns the biobank attribute lists where biobankDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybiobankDbId_attributeListName_attributeListValue(biobankDbId,
			attributeListName, attributeListValue);
	}

	/**
	* Returns the biobank attribute lists where biobankDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybiobankDbId_attributeListName_attributeListValue(biobankDbId,
			attributeListName, attributeListValue, retrieveFromCache);
	}

	/**
	* Removes the biobank attribute lists where biobankDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; from the database.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the biobank attribute lists that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists removeBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeBybiobankDbId_attributeListName_attributeListValue(biobankDbId,
			attributeListName, attributeListValue);
	}

	/**
	* Returns the number of biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the number of matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBybiobankDbId_attributeListName_attributeListValue(biobankDbId,
			attributeListName, attributeListValue);
	}

	/**
	* Caches the biobank attribute lists in the entity cache if it is enabled.
	*
	* @param biobankAttributeLists the biobank attribute lists
	*/
	public static void cacheResult(
		com.bcnet.portlet.biobank.model.BiobankAttributeLists biobankAttributeLists) {
		getPersistence().cacheResult(biobankAttributeLists);
	}

	/**
	* Caches the biobank attribute listses in the entity cache if it is enabled.
	*
	* @param biobankAttributeListses the biobank attribute listses
	*/
	public static void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> biobankAttributeListses) {
		getPersistence().cacheResult(biobankAttributeListses);
	}

	/**
	* Creates a new biobank attribute lists with the primary key. Does not add the biobank attribute lists to the database.
	*
	* @param biobankAttributeListsId the primary key for the new biobank attribute lists
	* @return the new biobank attribute lists
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists create(
		long biobankAttributeListsId) {
		return getPersistence().create(biobankAttributeListsId);
	}

	/**
	* Removes the biobank attribute lists with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeListsId the primary key of the biobank attribute lists
	* @return the biobank attribute lists that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a biobank attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists remove(
		long biobankAttributeListsId)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(biobankAttributeListsId);
	}

	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists updateImpl(
		com.bcnet.portlet.biobank.model.BiobankAttributeLists biobankAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(biobankAttributeLists);
	}

	/**
	* Returns the biobank attribute lists with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException} if it could not be found.
	*
	* @param biobankAttributeListsId the primary key of the biobank attribute lists
	* @return the biobank attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a biobank attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists findByPrimaryKey(
		long biobankAttributeListsId)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(biobankAttributeListsId);
	}

	/**
	* Returns the biobank attribute lists with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param biobankAttributeListsId the primary key of the biobank attribute lists
	* @return the biobank attribute lists, or <code>null</code> if a biobank attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchByPrimaryKey(
		long biobankAttributeListsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(biobankAttributeListsId);
	}

	/**
	* Returns all the biobank attribute listses.
	*
	* @return the biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the biobank attribute listses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank attribute listses
	* @param end the upper bound of the range of biobank attribute listses (not inclusive)
	* @return the range of biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the biobank attribute listses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank attribute listses
	* @param end the upper bound of the range of biobank attribute listses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the biobank attribute listses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of biobank attribute listses.
	*
	* @return the number of biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BiobankAttributeListsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BiobankAttributeListsPersistence)PortletBeanLocatorUtil.locate(com.bcnet.portlet.biobank.service.ClpSerializer.getServletContextName(),
					BiobankAttributeListsPersistence.class.getName());

			ReferenceRegistry.registerReference(BiobankAttributeListsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BiobankAttributeListsPersistence persistence) {
	}

	private static BiobankAttributeListsPersistence _persistence;
}