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

package com.inkwell.internet.productregistration.service.persistence;

import com.inkwell.internet.productregistration.model.PRProduct;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the p r product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see PRProductPersistenceImpl
 * @see PRProductUtil
 * @generated
 */
public interface PRProductPersistence extends BasePersistence<PRProduct> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PRProductUtil} to access the p r product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the p r products where groupId = &#63; and productName = &#63;.
	*
	* @param groupId the group ID
	* @param productName the product name
	* @return the matching p r products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> findByG_PN(
		long groupId, java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r products where groupId = &#63; and productName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param productName the product name
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @return the range of matching p r products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> findByG_PN(
		long groupId, java.lang.String productName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r products where groupId = &#63; and productName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param productName the product name
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> findByG_PN(
		long groupId, java.lang.String productName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r product in the ordered set where groupId = &#63; and productName = &#63;.
	*
	* @param groupId the group ID
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r product
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct findByG_PN_First(
		long groupId, java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r product in the ordered set where groupId = &#63; and productName = &#63;.
	*
	* @param groupId the group ID
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r product, or <code>null</code> if a matching p r product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct fetchByG_PN_First(
		long groupId, java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r product in the ordered set where groupId = &#63; and productName = &#63;.
	*
	* @param groupId the group ID
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r product
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct findByG_PN_Last(
		long groupId, java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r product in the ordered set where groupId = &#63; and productName = &#63;.
	*
	* @param groupId the group ID
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r product, or <code>null</code> if a matching p r product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct fetchByG_PN_Last(
		long groupId, java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r products before and after the current p r product in the ordered set where groupId = &#63; and productName = &#63;.
	*
	* @param productId the primary key of the current p r product
	* @param groupId the group ID
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r product
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct[] findByG_PN_PrevAndNext(
		long productId, long groupId, java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r products that the user has permission to view where groupId = &#63; and productName = &#63;.
	*
	* @param groupId the group ID
	* @param productName the product name
	* @return the matching p r products that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> filterFindByG_PN(
		long groupId, java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r products that the user has permission to view where groupId = &#63; and productName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param productName the product name
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @return the range of matching p r products that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> filterFindByG_PN(
		long groupId, java.lang.String productName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r products that the user has permissions to view where groupId = &#63; and productName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param productName the product name
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r products that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> filterFindByG_PN(
		long groupId, java.lang.String productName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r products before and after the current p r product in the ordered set of p r products that the user has permission to view where groupId = &#63; and productName = &#63;.
	*
	* @param productId the primary key of the current p r product
	* @param groupId the group ID
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r product
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct[] filterFindByG_PN_PrevAndNext(
		long productId, long groupId, java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r products where groupId = &#63; and productName = &#63; from the database.
	*
	* @param groupId the group ID
	* @param productName the product name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_PN(long groupId, java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r products where groupId = &#63; and productName = &#63;.
	*
	* @param groupId the group ID
	* @param productName the product name
	* @return the number of matching p r products
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_PN(long groupId, java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r products that the user has permission to view where groupId = &#63; and productName = &#63;.
	*
	* @param groupId the group ID
	* @param productName the product name
	* @return the number of matching p r products that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_PN(long groupId, java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r products where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching p r products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r products where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @return the range of matching p r products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r products where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r product in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r product
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r product in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r product, or <code>null</code> if a matching p r product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r product in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r product
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r product in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r product, or <code>null</code> if a matching p r product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r products before and after the current p r product in the ordered set where groupId = &#63;.
	*
	* @param productId the primary key of the current p r product
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r product
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct[] findByGroupId_PrevAndNext(
		long productId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r products that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching p r products that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r products that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @return the range of matching p r products that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r products that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r products that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r products before and after the current p r product in the ordered set of p r products that the user has permission to view where groupId = &#63;.
	*
	* @param productId the primary key of the current p r product
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r product
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct[] filterFindByGroupId_PrevAndNext(
		long productId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r products where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r products where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching p r products
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r products that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching p r products that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r products where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching p r products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r products where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @return the range of matching p r products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r products where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r product in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r product
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r product in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r product, or <code>null</code> if a matching p r product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r product in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r product
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r product in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r product, or <code>null</code> if a matching p r product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r products before and after the current p r product in the ordered set where companyId = &#63;.
	*
	* @param productId the primary key of the current p r product
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r product
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct[] findByCompanyId_PrevAndNext(
		long productId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r products where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r products where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching p r products
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the p r product in the entity cache if it is enabled.
	*
	* @param prProduct the p r product
	*/
	public void cacheResult(
		com.inkwell.internet.productregistration.model.PRProduct prProduct);

	/**
	* Caches the p r products in the entity cache if it is enabled.
	*
	* @param prProducts the p r products
	*/
	public void cacheResult(
		java.util.List<com.inkwell.internet.productregistration.model.PRProduct> prProducts);

	/**
	* Creates a new p r product with the primary key. Does not add the p r product to the database.
	*
	* @param productId the primary key for the new p r product
	* @return the new p r product
	*/
	public com.inkwell.internet.productregistration.model.PRProduct create(
		long productId);

	/**
	* Removes the p r product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productId the primary key of the p r product
	* @return the p r product that was removed
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct remove(
		long productId)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.inkwell.internet.productregistration.model.PRProduct updateImpl(
		com.inkwell.internet.productregistration.model.PRProduct prProduct)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r product with the primary key or throws a {@link com.inkwell.internet.productregistration.NoSuchProductException} if it could not be found.
	*
	* @param productId the primary key of the p r product
	* @return the p r product
	* @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct findByPrimaryKey(
		long productId)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r product with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param productId the primary key of the p r product
	* @return the p r product, or <code>null</code> if a p r product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRProduct fetchByPrimaryKey(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r products.
	*
	* @return the p r products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @return the range of p r products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p r products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRProduct> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r products from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r products.
	*
	* @return the number of p r products
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}