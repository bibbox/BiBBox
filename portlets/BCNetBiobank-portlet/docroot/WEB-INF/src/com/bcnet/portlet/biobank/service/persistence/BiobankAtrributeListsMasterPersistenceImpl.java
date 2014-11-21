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

import com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException;
import com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster;
import com.bcnet.portlet.biobank.model.impl.BiobankAtrributeListsMasterImpl;
import com.bcnet.portlet.biobank.model.impl.BiobankAtrributeListsMasterModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the biobank atrribute lists master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankAtrributeListsMasterPersistence
 * @see BiobankAtrributeListsMasterUtil
 * @generated
 */
public class BiobankAtrributeListsMasterPersistenceImpl
	extends BasePersistenceImpl<BiobankAtrributeListsMaster>
	implements BiobankAtrributeListsMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BiobankAtrributeListsMasterUtil} to access the biobank atrribute lists master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BiobankAtrributeListsMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAtrributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			BiobankAtrributeListsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAtrributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			BiobankAtrributeListsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAtrributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTRIBUTE =
		new FinderPath(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAtrributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			BiobankAtrributeListsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByattribute",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTE =
		new FinderPath(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAtrributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			BiobankAtrributeListsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByattribute",
			new String[] { String.class.getName() },
			BiobankAtrributeListsMasterModelImpl.ATTRIBUTELISTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ATTRIBUTE = new FinderPath(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAtrributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByattribute", new String[] { String.class.getName() });

	/**
	 * Returns all the biobank atrribute lists masters where attributeListName = &#63;.
	 *
	 * @param attributeListName the attribute list name
	 * @return the matching biobank atrribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankAtrributeListsMaster> findByattribute(
		String attributeListName) throws SystemException {
		return findByattribute(attributeListName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<BiobankAtrributeListsMaster> findByattribute(
		String attributeListName, int start, int end) throws SystemException {
		return findByattribute(attributeListName, start, end, null);
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
	@Override
	public List<BiobankAtrributeListsMaster> findByattribute(
		String attributeListName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTE;
			finderArgs = new Object[] { attributeListName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTRIBUTE;
			finderArgs = new Object[] {
					attributeListName,
					
					start, end, orderByComparator
				};
		}

		List<BiobankAtrributeListsMaster> list = (List<BiobankAtrributeListsMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BiobankAtrributeListsMaster biobankAtrributeListsMaster : list) {
				if (!Validator.equals(attributeListName,
							biobankAtrributeListsMaster.getAttributeListName())) {
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

			query.append(_SQL_SELECT_BIOBANKATRRIBUTELISTSMASTER_WHERE);

			boolean bindAttributeListName = false;

			if (attributeListName == null) {
				query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_1);
			}
			else if (attributeListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_3);
			}
			else {
				bindAttributeListName = true;

				query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BiobankAtrributeListsMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAttributeListName) {
					qPos.add(attributeListName);
				}

				if (!pagination) {
					list = (List<BiobankAtrributeListsMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BiobankAtrributeListsMaster>(list);
				}
				else {
					list = (List<BiobankAtrributeListsMaster>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first biobank atrribute lists master in the ordered set where attributeListName = &#63;.
	 *
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching biobank atrribute lists master
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException if a matching biobank atrribute lists master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAtrributeListsMaster findByattribute_First(
		String attributeListName, OrderByComparator orderByComparator)
		throws NoSuchBiobankAtrributeListsMasterException, SystemException {
		BiobankAtrributeListsMaster biobankAtrributeListsMaster = fetchByattribute_First(attributeListName,
				orderByComparator);

		if (biobankAtrributeListsMaster != null) {
			return biobankAtrributeListsMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attributeListName=");
		msg.append(attributeListName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBiobankAtrributeListsMasterException(msg.toString());
	}

	/**
	 * Returns the first biobank atrribute lists master in the ordered set where attributeListName = &#63;.
	 *
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching biobank atrribute lists master, or <code>null</code> if a matching biobank atrribute lists master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAtrributeListsMaster fetchByattribute_First(
		String attributeListName, OrderByComparator orderByComparator)
		throws SystemException {
		List<BiobankAtrributeListsMaster> list = findByattribute(attributeListName,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BiobankAtrributeListsMaster findByattribute_Last(
		String attributeListName, OrderByComparator orderByComparator)
		throws NoSuchBiobankAtrributeListsMasterException, SystemException {
		BiobankAtrributeListsMaster biobankAtrributeListsMaster = fetchByattribute_Last(attributeListName,
				orderByComparator);

		if (biobankAtrributeListsMaster != null) {
			return biobankAtrributeListsMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attributeListName=");
		msg.append(attributeListName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBiobankAtrributeListsMasterException(msg.toString());
	}

	/**
	 * Returns the last biobank atrribute lists master in the ordered set where attributeListName = &#63;.
	 *
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching biobank atrribute lists master, or <code>null</code> if a matching biobank atrribute lists master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAtrributeListsMaster fetchByattribute_Last(
		String attributeListName, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByattribute(attributeListName);

		if (count == 0) {
			return null;
		}

		List<BiobankAtrributeListsMaster> list = findByattribute(attributeListName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BiobankAtrributeListsMaster[] findByattribute_PrevAndNext(
		long biobankAttributeListsMasterId, String attributeListName,
		OrderByComparator orderByComparator)
		throws NoSuchBiobankAtrributeListsMasterException, SystemException {
		BiobankAtrributeListsMaster biobankAtrributeListsMaster = findByPrimaryKey(biobankAttributeListsMasterId);

		Session session = null;

		try {
			session = openSession();

			BiobankAtrributeListsMaster[] array = new BiobankAtrributeListsMasterImpl[3];

			array[0] = getByattribute_PrevAndNext(session,
					biobankAtrributeListsMaster, attributeListName,
					orderByComparator, true);

			array[1] = biobankAtrributeListsMaster;

			array[2] = getByattribute_PrevAndNext(session,
					biobankAtrributeListsMaster, attributeListName,
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

	protected BiobankAtrributeListsMaster getByattribute_PrevAndNext(
		Session session,
		BiobankAtrributeListsMaster biobankAtrributeListsMaster,
		String attributeListName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BIOBANKATRRIBUTELISTSMASTER_WHERE);

		boolean bindAttributeListName = false;

		if (attributeListName == null) {
			query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_1);
		}
		else if (attributeListName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_3);
		}
		else {
			bindAttributeListName = true;

			query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_2);
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
			query.append(BiobankAtrributeListsMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAttributeListName) {
			qPos.add(attributeListName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(biobankAtrributeListsMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BiobankAtrributeListsMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the biobank atrribute lists masters where attributeListName = &#63; from the database.
	 *
	 * @param attributeListName the attribute list name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByattribute(String attributeListName)
		throws SystemException {
		for (BiobankAtrributeListsMaster biobankAtrributeListsMaster : findByattribute(
				attributeListName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(biobankAtrributeListsMaster);
		}
	}

	/**
	 * Returns the number of biobank atrribute lists masters where attributeListName = &#63;.
	 *
	 * @param attributeListName the attribute list name
	 * @return the number of matching biobank atrribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByattribute(String attributeListName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ATTRIBUTE;

		Object[] finderArgs = new Object[] { attributeListName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BIOBANKATRRIBUTELISTSMASTER_WHERE);

			boolean bindAttributeListName = false;

			if (attributeListName == null) {
				query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_1);
			}
			else if (attributeListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_3);
			}
			else {
				bindAttributeListName = true;

				query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAttributeListName) {
					qPos.add(attributeListName);
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

	private static final String _FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_1 = "biobankAtrributeListsMaster.attributeListName IS NULL";
	private static final String _FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_2 = "biobankAtrributeListsMaster.attributeListName = ?";
	private static final String _FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_3 = "(biobankAtrributeListsMaster.attributeListName IS NULL OR biobankAtrributeListsMaster.attributeListName = '')";

	public BiobankAtrributeListsMasterPersistenceImpl() {
		setModelClass(BiobankAtrributeListsMaster.class);
	}

	/**
	 * Caches the biobank atrribute lists master in the entity cache if it is enabled.
	 *
	 * @param biobankAtrributeListsMaster the biobank atrribute lists master
	 */
	@Override
	public void cacheResult(
		BiobankAtrributeListsMaster biobankAtrributeListsMaster) {
		EntityCacheUtil.putResult(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAtrributeListsMasterImpl.class,
			biobankAtrributeListsMaster.getPrimaryKey(),
			biobankAtrributeListsMaster);

		biobankAtrributeListsMaster.resetOriginalValues();
	}

	/**
	 * Caches the biobank atrribute lists masters in the entity cache if it is enabled.
	 *
	 * @param biobankAtrributeListsMasters the biobank atrribute lists masters
	 */
	@Override
	public void cacheResult(
		List<BiobankAtrributeListsMaster> biobankAtrributeListsMasters) {
		for (BiobankAtrributeListsMaster biobankAtrributeListsMaster : biobankAtrributeListsMasters) {
			if (EntityCacheUtil.getResult(
						BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
						BiobankAtrributeListsMasterImpl.class,
						biobankAtrributeListsMaster.getPrimaryKey()) == null) {
				cacheResult(biobankAtrributeListsMaster);
			}
			else {
				biobankAtrributeListsMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all biobank atrribute lists masters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BiobankAtrributeListsMasterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BiobankAtrributeListsMasterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the biobank atrribute lists master.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		BiobankAtrributeListsMaster biobankAtrributeListsMaster) {
		EntityCacheUtil.removeResult(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAtrributeListsMasterImpl.class,
			biobankAtrributeListsMaster.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<BiobankAtrributeListsMaster> biobankAtrributeListsMasters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BiobankAtrributeListsMaster biobankAtrributeListsMaster : biobankAtrributeListsMasters) {
			EntityCacheUtil.removeResult(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
				BiobankAtrributeListsMasterImpl.class,
				biobankAtrributeListsMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new biobank atrribute lists master with the primary key. Does not add the biobank atrribute lists master to the database.
	 *
	 * @param biobankAttributeListsMasterId the primary key for the new biobank atrribute lists master
	 * @return the new biobank atrribute lists master
	 */
	@Override
	public BiobankAtrributeListsMaster create(
		long biobankAttributeListsMasterId) {
		BiobankAtrributeListsMaster biobankAtrributeListsMaster = new BiobankAtrributeListsMasterImpl();

		biobankAtrributeListsMaster.setNew(true);
		biobankAtrributeListsMaster.setPrimaryKey(biobankAttributeListsMasterId);

		return biobankAtrributeListsMaster;
	}

	/**
	 * Removes the biobank atrribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param biobankAttributeListsMasterId the primary key of the biobank atrribute lists master
	 * @return the biobank atrribute lists master that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException if a biobank atrribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAtrributeListsMaster remove(
		long biobankAttributeListsMasterId)
		throws NoSuchBiobankAtrributeListsMasterException, SystemException {
		return remove((Serializable)biobankAttributeListsMasterId);
	}

	/**
	 * Removes the biobank atrribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the biobank atrribute lists master
	 * @return the biobank atrribute lists master that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException if a biobank atrribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAtrributeListsMaster remove(Serializable primaryKey)
		throws NoSuchBiobankAtrributeListsMasterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BiobankAtrributeListsMaster biobankAtrributeListsMaster = (BiobankAtrributeListsMaster)session.get(BiobankAtrributeListsMasterImpl.class,
					primaryKey);

			if (biobankAtrributeListsMaster == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBiobankAtrributeListsMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(biobankAtrributeListsMaster);
		}
		catch (NoSuchBiobankAtrributeListsMasterException nsee) {
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
	protected BiobankAtrributeListsMaster removeImpl(
		BiobankAtrributeListsMaster biobankAtrributeListsMaster)
		throws SystemException {
		biobankAtrributeListsMaster = toUnwrappedModel(biobankAtrributeListsMaster);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(biobankAtrributeListsMaster)) {
				biobankAtrributeListsMaster = (BiobankAtrributeListsMaster)session.get(BiobankAtrributeListsMasterImpl.class,
						biobankAtrributeListsMaster.getPrimaryKeyObj());
			}

			if (biobankAtrributeListsMaster != null) {
				session.delete(biobankAtrributeListsMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (biobankAtrributeListsMaster != null) {
			clearCache(biobankAtrributeListsMaster);
		}

		return biobankAtrributeListsMaster;
	}

	@Override
	public BiobankAtrributeListsMaster updateImpl(
		com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster biobankAtrributeListsMaster)
		throws SystemException {
		biobankAtrributeListsMaster = toUnwrappedModel(biobankAtrributeListsMaster);

		boolean isNew = biobankAtrributeListsMaster.isNew();

		BiobankAtrributeListsMasterModelImpl biobankAtrributeListsMasterModelImpl =
			(BiobankAtrributeListsMasterModelImpl)biobankAtrributeListsMaster;

		Session session = null;

		try {
			session = openSession();

			if (biobankAtrributeListsMaster.isNew()) {
				session.save(biobankAtrributeListsMaster);

				biobankAtrributeListsMaster.setNew(false);
			}
			else {
				session.merge(biobankAtrributeListsMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!BiobankAtrributeListsMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((biobankAtrributeListsMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						biobankAtrributeListsMasterModelImpl.getOriginalAttributeListName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTRIBUTE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTE,
					args);

				args = new Object[] {
						biobankAtrributeListsMasterModelImpl.getAttributeListName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTRIBUTE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTE,
					args);
			}
		}

		EntityCacheUtil.putResult(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAtrributeListsMasterImpl.class,
			biobankAtrributeListsMaster.getPrimaryKey(),
			biobankAtrributeListsMaster);

		return biobankAtrributeListsMaster;
	}

	protected BiobankAtrributeListsMaster toUnwrappedModel(
		BiobankAtrributeListsMaster biobankAtrributeListsMaster) {
		if (biobankAtrributeListsMaster instanceof BiobankAtrributeListsMasterImpl) {
			return biobankAtrributeListsMaster;
		}

		BiobankAtrributeListsMasterImpl biobankAtrributeListsMasterImpl = new BiobankAtrributeListsMasterImpl();

		biobankAtrributeListsMasterImpl.setNew(biobankAtrributeListsMaster.isNew());
		biobankAtrributeListsMasterImpl.setPrimaryKey(biobankAtrributeListsMaster.getPrimaryKey());

		biobankAtrributeListsMasterImpl.setBiobankAttributeListsMasterId(biobankAtrributeListsMaster.getBiobankAttributeListsMasterId());
		biobankAtrributeListsMasterImpl.setAttributeListName(biobankAtrributeListsMaster.getAttributeListName());
		biobankAtrributeListsMasterImpl.setAttributeListValue(biobankAtrributeListsMaster.getAttributeListValue());

		return biobankAtrributeListsMasterImpl;
	}

	/**
	 * Returns the biobank atrribute lists master with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank atrribute lists master
	 * @return the biobank atrribute lists master
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException if a biobank atrribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAtrributeListsMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBiobankAtrributeListsMasterException, SystemException {
		BiobankAtrributeListsMaster biobankAtrributeListsMaster = fetchByPrimaryKey(primaryKey);

		if (biobankAtrributeListsMaster == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBiobankAtrributeListsMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return biobankAtrributeListsMaster;
	}

	/**
	 * Returns the biobank atrribute lists master with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException} if it could not be found.
	 *
	 * @param biobankAttributeListsMasterId the primary key of the biobank atrribute lists master
	 * @return the biobank atrribute lists master
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAtrributeListsMasterException if a biobank atrribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAtrributeListsMaster findByPrimaryKey(
		long biobankAttributeListsMasterId)
		throws NoSuchBiobankAtrributeListsMasterException, SystemException {
		return findByPrimaryKey((Serializable)biobankAttributeListsMasterId);
	}

	/**
	 * Returns the biobank atrribute lists master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank atrribute lists master
	 * @return the biobank atrribute lists master, or <code>null</code> if a biobank atrribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAtrributeListsMaster fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		BiobankAtrributeListsMaster biobankAtrributeListsMaster = (BiobankAtrributeListsMaster)EntityCacheUtil.getResult(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
				BiobankAtrributeListsMasterImpl.class, primaryKey);

		if (biobankAtrributeListsMaster == _nullBiobankAtrributeListsMaster) {
			return null;
		}

		if (biobankAtrributeListsMaster == null) {
			Session session = null;

			try {
				session = openSession();

				biobankAtrributeListsMaster = (BiobankAtrributeListsMaster)session.get(BiobankAtrributeListsMasterImpl.class,
						primaryKey);

				if (biobankAtrributeListsMaster != null) {
					cacheResult(biobankAtrributeListsMaster);
				}
				else {
					EntityCacheUtil.putResult(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
						BiobankAtrributeListsMasterImpl.class, primaryKey,
						_nullBiobankAtrributeListsMaster);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BiobankAtrributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
					BiobankAtrributeListsMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return biobankAtrributeListsMaster;
	}

	/**
	 * Returns the biobank atrribute lists master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param biobankAttributeListsMasterId the primary key of the biobank atrribute lists master
	 * @return the biobank atrribute lists master, or <code>null</code> if a biobank atrribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAtrributeListsMaster fetchByPrimaryKey(
		long biobankAttributeListsMasterId) throws SystemException {
		return fetchByPrimaryKey((Serializable)biobankAttributeListsMasterId);
	}

	/**
	 * Returns all the biobank atrribute lists masters.
	 *
	 * @return the biobank atrribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankAtrributeListsMaster> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BiobankAtrributeListsMaster> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<BiobankAtrributeListsMaster> findAll(int start, int end,
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

		List<BiobankAtrributeListsMaster> list = (List<BiobankAtrributeListsMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BIOBANKATRRIBUTELISTSMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BIOBANKATRRIBUTELISTSMASTER;

				if (pagination) {
					sql = sql.concat(BiobankAtrributeListsMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BiobankAtrributeListsMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BiobankAtrributeListsMaster>(list);
				}
				else {
					list = (List<BiobankAtrributeListsMaster>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the biobank atrribute lists masters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BiobankAtrributeListsMaster biobankAtrributeListsMaster : findAll()) {
			remove(biobankAtrributeListsMaster);
		}
	}

	/**
	 * Returns the number of biobank atrribute lists masters.
	 *
	 * @return the number of biobank atrribute lists masters
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

				Query q = session.createQuery(_SQL_COUNT_BIOBANKATRRIBUTELISTSMASTER);

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
	 * Initializes the biobank atrribute lists master persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BiobankAtrributeListsMaster>> listenersList = new ArrayList<ModelListener<BiobankAtrributeListsMaster>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BiobankAtrributeListsMaster>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BiobankAtrributeListsMasterImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BIOBANKATRRIBUTELISTSMASTER = "SELECT biobankAtrributeListsMaster FROM BiobankAtrributeListsMaster biobankAtrributeListsMaster";
	private static final String _SQL_SELECT_BIOBANKATRRIBUTELISTSMASTER_WHERE = "SELECT biobankAtrributeListsMaster FROM BiobankAtrributeListsMaster biobankAtrributeListsMaster WHERE ";
	private static final String _SQL_COUNT_BIOBANKATRRIBUTELISTSMASTER = "SELECT COUNT(biobankAtrributeListsMaster) FROM BiobankAtrributeListsMaster biobankAtrributeListsMaster";
	private static final String _SQL_COUNT_BIOBANKATRRIBUTELISTSMASTER_WHERE = "SELECT COUNT(biobankAtrributeListsMaster) FROM BiobankAtrributeListsMaster biobankAtrributeListsMaster WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "biobankAtrributeListsMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BiobankAtrributeListsMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BiobankAtrributeListsMaster exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BiobankAtrributeListsMasterPersistenceImpl.class);
	private static BiobankAtrributeListsMaster _nullBiobankAtrributeListsMaster = new BiobankAtrributeListsMasterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BiobankAtrributeListsMaster> toCacheModel() {
				return _nullBiobankAtrributeListsMasterCacheModel;
			}
		};

	private static CacheModel<BiobankAtrributeListsMaster> _nullBiobankAtrributeListsMasterCacheModel =
		new CacheModel<BiobankAtrributeListsMaster>() {
			@Override
			public BiobankAtrributeListsMaster toEntityModel() {
				return _nullBiobankAtrributeListsMaster;
			}
		};
}