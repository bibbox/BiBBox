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

import com.inkwell.internet.productregistration.NoSuchProductException;
import com.inkwell.internet.productregistration.model.PRProduct;
import com.inkwell.internet.productregistration.model.impl.PRProductImpl;
import com.inkwell.internet.productregistration.model.impl.PRProductModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the p r product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see PRProductPersistence
 * @see PRProductUtil
 * @generated
 */
public class PRProductPersistenceImpl extends BasePersistenceImpl<PRProduct>
	implements PRProductPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PRProductUtil} to access the p r product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PRProductImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, PRProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, PRProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_PN = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, PRProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_PN",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_PN = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, PRProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_PN",
			new String[] { Long.class.getName(), String.class.getName() },
			PRProductModelImpl.GROUPID_COLUMN_BITMASK |
			PRProductModelImpl.PRODUCTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_PN = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_PN",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the p r products where groupId = &#63; and productName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param productName the product name
	 * @return the matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PRProduct> findByG_PN(long groupId, String productName)
		throws SystemException {
		return findByG_PN(groupId, productName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PRProduct> findByG_PN(long groupId, String productName,
		int start, int end) throws SystemException {
		return findByG_PN(groupId, productName, start, end, null);
	}

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
	@Override
	public List<PRProduct> findByG_PN(long groupId, String productName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_PN;
			finderArgs = new Object[] { groupId, productName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_PN;
			finderArgs = new Object[] {
					groupId, productName,
					
					start, end, orderByComparator
				};
		}

		List<PRProduct> list = (List<PRProduct>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PRProduct prProduct : list) {
				if ((groupId != prProduct.getGroupId()) ||
						!Validator.equals(productName,
							prProduct.getProductName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PRPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_G_PN_GROUPID_2);

			boolean bindProductName = false;

			if (productName == null) {
				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_1);
			}
			else if (productName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_3);
			}
			else {
				bindProductName = true;

				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PRProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindProductName) {
					qPos.add(productName);
				}

				if (!pagination) {
					list = (List<PRProduct>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PRProduct>(list);
				}
				else {
					list = (List<PRProduct>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public PRProduct findByG_PN_First(long groupId, String productName,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = fetchByG_PN_First(groupId, productName,
				orderByComparator);

		if (prProduct != null) {
			return prProduct;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", productName=");
		msg.append(productName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the first p r product in the ordered set where groupId = &#63; and productName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param productName the product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p r product, or <code>null</code> if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct fetchByG_PN_First(long groupId, String productName,
		OrderByComparator orderByComparator) throws SystemException {
		List<PRProduct> list = findByG_PN(groupId, productName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public PRProduct findByG_PN_Last(long groupId, String productName,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = fetchByG_PN_Last(groupId, productName,
				orderByComparator);

		if (prProduct != null) {
			return prProduct;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", productName=");
		msg.append(productName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the last p r product in the ordered set where groupId = &#63; and productName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param productName the product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p r product, or <code>null</code> if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct fetchByG_PN_Last(long groupId, String productName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_PN(groupId, productName);

		if (count == 0) {
			return null;
		}

		List<PRProduct> list = findByG_PN(groupId, productName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public PRProduct[] findByG_PN_PrevAndNext(long productId, long groupId,
		String productName, OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			PRProduct[] array = new PRProductImpl[3];

			array[0] = getByG_PN_PrevAndNext(session, prProduct, groupId,
					productName, orderByComparator, true);

			array[1] = prProduct;

			array[2] = getByG_PN_PrevAndNext(session, prProduct, groupId,
					productName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRProduct getByG_PN_PrevAndNext(Session session,
		PRProduct prProduct, long groupId, String productName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRPRODUCT_WHERE);

		query.append(_FINDER_COLUMN_G_PN_GROUPID_2);

		boolean bindProductName = false;

		if (productName == null) {
			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_1);
		}
		else if (productName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_3);
		}
		else {
			bindProductName = true;

			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PRProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindProductName) {
			qPos.add(productName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(prProduct);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRProduct> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the p r products that the user has permission to view where groupId = &#63; and productName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param productName the product name
	 * @return the matching p r products that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PRProduct> filterFindByG_PN(long groupId, String productName)
		throws SystemException {
		return filterFindByG_PN(groupId, productName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PRProduct> filterFindByG_PN(long groupId, String productName,
		int start, int end) throws SystemException {
		return filterFindByG_PN(groupId, productName, start, end, null);
	}

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
	@Override
	public List<PRProduct> filterFindByG_PN(long groupId, String productName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_PN(groupId, productName, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_PN_GROUPID_2);

		boolean bindProductName = false;

		if (productName == null) {
			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_1);
		}
		else if (productName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_3);
		}
		else {
			bindProductName = true;

			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(PRProductModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PRProductModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRProduct.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PRProductImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PRProductImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindProductName) {
				qPos.add(productName);
			}

			return (List<PRProduct>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

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
	@Override
	public PRProduct[] filterFindByG_PN_PrevAndNext(long productId,
		long groupId, String productName, OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_PN_PrevAndNext(productId, groupId, productName,
				orderByComparator);
		}

		PRProduct prProduct = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			PRProduct[] array = new PRProductImpl[3];

			array[0] = filterGetByG_PN_PrevAndNext(session, prProduct, groupId,
					productName, orderByComparator, true);

			array[1] = prProduct;

			array[2] = filterGetByG_PN_PrevAndNext(session, prProduct, groupId,
					productName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRProduct filterGetByG_PN_PrevAndNext(Session session,
		PRProduct prProduct, long groupId, String productName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_PN_GROUPID_2);

		boolean bindProductName = false;

		if (productName == null) {
			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_1);
		}
		else if (productName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_3);
		}
		else {
			bindProductName = true;

			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(PRProductModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PRProductModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRProduct.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PRProductImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PRProductImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindProductName) {
			qPos.add(productName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(prProduct);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRProduct> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p r products where groupId = &#63; and productName = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param productName the product name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_PN(long groupId, String productName)
		throws SystemException {
		for (PRProduct prProduct : findByG_PN(groupId, productName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(prProduct);
		}
	}

	/**
	 * Returns the number of p r products where groupId = &#63; and productName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param productName the product name
	 * @return the number of matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_PN(long groupId, String productName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_PN;

		Object[] finderArgs = new Object[] { groupId, productName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_G_PN_GROUPID_2);

			boolean bindProductName = false;

			if (productName == null) {
				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_1);
			}
			else if (productName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_3);
			}
			else {
				bindProductName = true;

				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindProductName) {
					qPos.add(productName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of p r products that the user has permission to view where groupId = &#63; and productName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param productName the product name
	 * @return the number of matching p r products that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_PN(long groupId, String productName)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_PN(groupId, productName);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PRPRODUCT_WHERE);

		query.append(_FINDER_COLUMN_G_PN_GROUPID_2);

		boolean bindProductName = false;

		if (productName == null) {
			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_1);
		}
		else if (productName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_3);
		}
		else {
			bindProductName = true;

			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRProduct.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindProductName) {
				qPos.add(productName);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_PN_GROUPID_2 = "prProduct.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_PN_PRODUCTNAME_1 = "prProduct.productName IS NULL";
	private static final String _FINDER_COLUMN_G_PN_PRODUCTNAME_2 = "prProduct.productName = ?";
	private static final String _FINDER_COLUMN_G_PN_PRODUCTNAME_3 = "(prProduct.productName IS NULL OR prProduct.productName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, PRProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, PRProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			PRProductModelImpl.GROUPID_COLUMN_BITMASK |
			PRProductModelImpl.PRODUCTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the p r products where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PRProduct> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PRProduct> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<PRProduct> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<PRProduct> list = (List<PRProduct>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PRProduct prProduct : list) {
				if ((groupId != prProduct.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PRPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PRProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PRProduct>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PRProduct>(list);
				}
				else {
					list = (List<PRProduct>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first p r product in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = fetchByGroupId_First(groupId, orderByComparator);

		if (prProduct != null) {
			return prProduct;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the first p r product in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p r product, or <code>null</code> if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PRProduct> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p r product in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = fetchByGroupId_Last(groupId, orderByComparator);

		if (prProduct != null) {
			return prProduct;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the last p r product in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p r product, or <code>null</code> if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<PRProduct> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public PRProduct[] findByGroupId_PrevAndNext(long productId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			PRProduct[] array = new PRProductImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, prProduct, groupId,
					orderByComparator, true);

			array[1] = prProduct;

			array[2] = getByGroupId_PrevAndNext(session, prProduct, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRProduct getByGroupId_PrevAndNext(Session session,
		PRProduct prProduct, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRPRODUCT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PRProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(prProduct);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRProduct> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the p r products that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching p r products that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PRProduct> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PRProduct> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<PRProduct> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(PRProductModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PRProductModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRProduct.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PRProductImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PRProductImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<PRProduct>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

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
	@Override
	public PRProduct[] filterFindByGroupId_PrevAndNext(long productId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(productId, groupId,
				orderByComparator);
		}

		PRProduct prProduct = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			PRProduct[] array = new PRProductImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, prProduct,
					groupId, orderByComparator, true);

			array[1] = prProduct;

			array[2] = filterGetByGroupId_PrevAndNext(session, prProduct,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRProduct filterGetByGroupId_PrevAndNext(Session session,
		PRProduct prProduct, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(PRProductModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PRProductModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRProduct.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PRProductImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PRProductImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(prProduct);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRProduct> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p r products where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (PRProduct prProduct : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(prProduct);
		}
	}

	/**
	 * Returns the number of p r products where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of p r products that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching p r products that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_PRPRODUCT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRProduct.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "prProduct.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, PRProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, PRProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			PRProductModelImpl.COMPANYID_COLUMN_BITMASK |
			PRProductModelImpl.PRODUCTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the p r products where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PRProduct> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<PRProduct> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

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
	@Override
	public List<PRProduct> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<PRProduct> list = (List<PRProduct>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PRProduct prProduct : list) {
				if ((companyId != prProduct.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PRPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PRProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<PRProduct>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PRProduct>(list);
				}
				else {
					list = (List<PRProduct>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first p r product in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (prProduct != null) {
			return prProduct;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the first p r product in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p r product, or <code>null</code> if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PRProduct> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p r product in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = fetchByCompanyId_Last(companyId, orderByComparator);

		if (prProduct != null) {
			return prProduct;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the last p r product in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p r product, or <code>null</code> if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<PRProduct> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public PRProduct[] findByCompanyId_PrevAndNext(long productId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			PRProduct[] array = new PRProductImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, prProduct,
					companyId, orderByComparator, true);

			array[1] = prProduct;

			array[2] = getByCompanyId_PrevAndNext(session, prProduct,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRProduct getByCompanyId_PrevAndNext(Session session,
		PRProduct prProduct, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRPRODUCT_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PRProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(prProduct);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRProduct> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p r products where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (PRProduct prProduct : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(prProduct);
		}
	}

	/**
	 * Returns the number of p r products where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "prProduct.companyId = ?";

	public PRProductPersistenceImpl() {
		setModelClass(PRProduct.class);
	}

	/**
	 * Caches the p r product in the entity cache if it is enabled.
	 *
	 * @param prProduct the p r product
	 */
	@Override
	public void cacheResult(PRProduct prProduct) {
		EntityCacheUtil.putResult(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductImpl.class, prProduct.getPrimaryKey(), prProduct);

		prProduct.resetOriginalValues();
	}

	/**
	 * Caches the p r products in the entity cache if it is enabled.
	 *
	 * @param prProducts the p r products
	 */
	@Override
	public void cacheResult(List<PRProduct> prProducts) {
		for (PRProduct prProduct : prProducts) {
			if (EntityCacheUtil.getResult(
						PRProductModelImpl.ENTITY_CACHE_ENABLED,
						PRProductImpl.class, prProduct.getPrimaryKey()) == null) {
				cacheResult(prProduct);
			}
			else {
				prProduct.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p r products.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PRProductImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PRProductImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p r product.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PRProduct prProduct) {
		EntityCacheUtil.removeResult(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductImpl.class, prProduct.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PRProduct> prProducts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PRProduct prProduct : prProducts) {
			EntityCacheUtil.removeResult(PRProductModelImpl.ENTITY_CACHE_ENABLED,
				PRProductImpl.class, prProduct.getPrimaryKey());
		}
	}

	/**
	 * Creates a new p r product with the primary key. Does not add the p r product to the database.
	 *
	 * @param productId the primary key for the new p r product
	 * @return the new p r product
	 */
	@Override
	public PRProduct create(long productId) {
		PRProduct prProduct = new PRProductImpl();

		prProduct.setNew(true);
		prProduct.setPrimaryKey(productId);

		return prProduct;
	}

	/**
	 * Removes the p r product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the p r product
	 * @return the p r product that was removed
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct remove(long productId)
		throws NoSuchProductException, SystemException {
		return remove((Serializable)productId);
	}

	/**
	 * Removes the p r product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p r product
	 * @return the p r product that was removed
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct remove(Serializable primaryKey)
		throws NoSuchProductException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PRProduct prProduct = (PRProduct)session.get(PRProductImpl.class,
					primaryKey);

			if (prProduct == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(prProduct);
		}
		catch (NoSuchProductException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PRProduct removeImpl(PRProduct prProduct)
		throws SystemException {
		prProduct = toUnwrappedModel(prProduct);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(prProduct)) {
				prProduct = (PRProduct)session.get(PRProductImpl.class,
						prProduct.getPrimaryKeyObj());
			}

			if (prProduct != null) {
				session.delete(prProduct);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (prProduct != null) {
			clearCache(prProduct);
		}

		return prProduct;
	}

	@Override
	public PRProduct updateImpl(
		com.inkwell.internet.productregistration.model.PRProduct prProduct)
		throws SystemException {
		prProduct = toUnwrappedModel(prProduct);

		boolean isNew = prProduct.isNew();

		PRProductModelImpl prProductModelImpl = (PRProductModelImpl)prProduct;

		Session session = null;

		try {
			session = openSession();

			if (prProduct.isNew()) {
				session.save(prProduct);

				prProduct.setNew(false);
			}
			else {
				session.merge(prProduct);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PRProductModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((prProductModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_PN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						prProductModelImpl.getOriginalGroupId(),
						prProductModelImpl.getOriginalProductName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_PN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_PN,
					args);

				args = new Object[] {
						prProductModelImpl.getGroupId(),
						prProductModelImpl.getProductName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_PN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_PN,
					args);
			}

			if ((prProductModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						prProductModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { prProductModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((prProductModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						prProductModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { prProductModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductImpl.class, prProduct.getPrimaryKey(), prProduct);

		return prProduct;
	}

	protected PRProduct toUnwrappedModel(PRProduct prProduct) {
		if (prProduct instanceof PRProductImpl) {
			return prProduct;
		}

		PRProductImpl prProductImpl = new PRProductImpl();

		prProductImpl.setNew(prProduct.isNew());
		prProductImpl.setPrimaryKey(prProduct.getPrimaryKey());

		prProductImpl.setProductId(prProduct.getProductId());
		prProductImpl.setProductName(prProduct.getProductName());
		prProductImpl.setSerialNumber(prProduct.getSerialNumber());
		prProductImpl.setCompanyId(prProduct.getCompanyId());
		prProductImpl.setGroupId(prProduct.getGroupId());

		return prProductImpl;
	}

	/**
	 * Returns the p r product with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p r product
	 * @return the p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = fetchByPrimaryKey(primaryKey);

		if (prProduct == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return prProduct;
	}

	/**
	 * Returns the p r product with the primary key or throws a {@link com.inkwell.internet.productregistration.NoSuchProductException} if it could not be found.
	 *
	 * @param productId the primary key of the p r product
	 * @return the p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct findByPrimaryKey(long productId)
		throws NoSuchProductException, SystemException {
		return findByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns the p r product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p r product
	 * @return the p r product, or <code>null</code> if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PRProduct prProduct = (PRProduct)EntityCacheUtil.getResult(PRProductModelImpl.ENTITY_CACHE_ENABLED,
				PRProductImpl.class, primaryKey);

		if (prProduct == _nullPRProduct) {
			return null;
		}

		if (prProduct == null) {
			Session session = null;

			try {
				session = openSession();

				prProduct = (PRProduct)session.get(PRProductImpl.class,
						primaryKey);

				if (prProduct != null) {
					cacheResult(prProduct);
				}
				else {
					EntityCacheUtil.putResult(PRProductModelImpl.ENTITY_CACHE_ENABLED,
						PRProductImpl.class, primaryKey, _nullPRProduct);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PRProductModelImpl.ENTITY_CACHE_ENABLED,
					PRProductImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return prProduct;
	}

	/**
	 * Returns the p r product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the p r product
	 * @return the p r product, or <code>null</code> if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PRProduct fetchByPrimaryKey(long productId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns all the p r products.
	 *
	 * @return the p r products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PRProduct> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PRProduct> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<PRProduct> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<PRProduct> list = (List<PRProduct>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRPRODUCT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRPRODUCT;

				if (pagination) {
					sql = sql.concat(PRProductModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PRProduct>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PRProduct>(list);
				}
				else {
					list = (List<PRProduct>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the p r products from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PRProduct prProduct : findAll()) {
			remove(prProduct);
		}
	}

	/**
	 * Returns the number of p r products.
	 *
	 * @return the number of p r products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRPRODUCT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the p r product persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.inkwell.internet.productregistration.model.PRProduct")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PRProduct>> listenersList = new ArrayList<ModelListener<PRProduct>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PRProduct>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PRProductImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PRPRODUCT = "SELECT prProduct FROM PRProduct prProduct";
	private static final String _SQL_SELECT_PRPRODUCT_WHERE = "SELECT prProduct FROM PRProduct prProduct WHERE ";
	private static final String _SQL_COUNT_PRPRODUCT = "SELECT COUNT(prProduct) FROM PRProduct prProduct";
	private static final String _SQL_COUNT_PRPRODUCT_WHERE = "SELECT COUNT(prProduct) FROM PRProduct prProduct WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "prProduct.productId";
	private static final String _FILTER_SQL_SELECT_PRPRODUCT_WHERE = "SELECT DISTINCT {prProduct.*} FROM PR_PRProduct prProduct WHERE ";
	private static final String _FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {PR_PRProduct.*} FROM (SELECT DISTINCT prProduct.productId FROM PR_PRProduct prProduct WHERE ";
	private static final String _FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN PR_PRProduct ON TEMP_TABLE.productId = PR_PRProduct.productId";
	private static final String _FILTER_SQL_COUNT_PRPRODUCT_WHERE = "SELECT COUNT(DISTINCT prProduct.productId) AS COUNT_VALUE FROM PR_PRProduct prProduct WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "prProduct";
	private static final String _FILTER_ENTITY_TABLE = "PR_PRProduct";
	private static final String _ORDER_BY_ENTITY_ALIAS = "prProduct.";
	private static final String _ORDER_BY_ENTITY_TABLE = "PR_PRProduct.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PRProduct exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PRProduct exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PRProductPersistenceImpl.class);
	private static PRProduct _nullPRProduct = new PRProductImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PRProduct> toCacheModel() {
				return _nullPRProductCacheModel;
			}
		};

	private static CacheModel<PRProduct> _nullPRProductCacheModel = new CacheModel<PRProduct>() {
			@Override
			public PRProduct toEntityModel() {
				return _nullPRProduct;
			}
		};
}