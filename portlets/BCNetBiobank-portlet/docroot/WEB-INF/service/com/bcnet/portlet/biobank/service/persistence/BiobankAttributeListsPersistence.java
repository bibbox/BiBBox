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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the biobank attribute lists service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankAttributeListsPersistenceImpl
 * @see BiobankAttributeListsUtil
 * @generated
 */
public interface BiobankAttributeListsPersistence extends BasePersistence<BiobankAttributeLists> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BiobankAttributeListsUtil} to access the biobank attribute lists persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the biobank attribute listses where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @return the matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findBybiobankDbId(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findBybiobankDbId(
		long biobankDbId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findBybiobankDbId(
		long biobankDbId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first biobank attribute lists in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching biobank attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists findBybiobankDbId_First(
		long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first biobank attribute lists in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBybiobankDbId_First(
		long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last biobank attribute lists in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching biobank attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists findBybiobankDbId_Last(
		long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last biobank attribute lists in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBybiobankDbId_Last(
		long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists[] findBybiobankDbId_PrevAndNext(
		long biobankAttributeListsId, long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the biobank attribute listses where biobankDbId = &#63; from the database.
	*
	* @param biobankDbId the biobank db ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybiobankDbId(long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of biobank attribute listses where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @return the number of matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public int countBybiobankDbId(long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @return the matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findBybiobankDbId_attributeListName(
		long biobankDbId, java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findBybiobankDbId_attributeListName(
		long biobankDbId, java.lang.String attributeListName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findBybiobankDbId_attributeListName(
		long biobankDbId, java.lang.String attributeListName, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists findBybiobankDbId_attributeListName_First(
		long biobankDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first biobank attribute lists in the ordered set where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBybiobankDbId_attributeListName_First(
		long biobankDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists findBybiobankDbId_attributeListName_Last(
		long biobankDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last biobank attribute lists in the ordered set where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBybiobankDbId_attributeListName_Last(
		long biobankDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists[] findBybiobankDbId_attributeListName_PrevAndNext(
		long biobankAttributeListsId, long biobankDbId,
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63; from the database.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybiobankDbId_attributeListName(long biobankDbId,
		java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @return the number of matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public int countBybiobankDbId_attributeListName(long biobankDbId,
		java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists findBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the biobank attribute lists where biobankDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the biobank attribute lists where biobankDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; from the database.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the biobank attribute lists that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists removeBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the number of matching biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public int countBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the biobank attribute lists in the entity cache if it is enabled.
	*
	* @param biobankAttributeLists the biobank attribute lists
	*/
	public void cacheResult(
		com.bcnet.portlet.biobank.model.BiobankAttributeLists biobankAttributeLists);

	/**
	* Caches the biobank attribute listses in the entity cache if it is enabled.
	*
	* @param biobankAttributeListses the biobank attribute listses
	*/
	public void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> biobankAttributeListses);

	/**
	* Creates a new biobank attribute lists with the primary key. Does not add the biobank attribute lists to the database.
	*
	* @param biobankAttributeListsId the primary key for the new biobank attribute lists
	* @return the new biobank attribute lists
	*/
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists create(
		long biobankAttributeListsId);

	/**
	* Removes the biobank attribute lists with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeListsId the primary key of the biobank attribute lists
	* @return the biobank attribute lists that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a biobank attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists remove(
		long biobankAttributeListsId)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bcnet.portlet.biobank.model.BiobankAttributeLists updateImpl(
		com.bcnet.portlet.biobank.model.BiobankAttributeLists biobankAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the biobank attribute lists with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException} if it could not be found.
	*
	* @param biobankAttributeListsId the primary key of the biobank attribute lists
	* @return the biobank attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a biobank attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists findByPrimaryKey(
		long biobankAttributeListsId)
		throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the biobank attribute lists with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param biobankAttributeListsId the primary key of the biobank attribute lists
	* @return the biobank attribute lists, or <code>null</code> if a biobank attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchByPrimaryKey(
		long biobankAttributeListsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the biobank attribute listses.
	*
	* @return the biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the biobank attribute listses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of biobank attribute listses.
	*
	* @return the number of biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}