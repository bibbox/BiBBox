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

import com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException;
import com.bcnet.portlet.biobank.model.BiobankAttributeLists;
import com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsImpl;
import com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl;

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
 * The persistence implementation for the biobank attribute lists service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankAttributeListsPersistence
 * @see BiobankAttributeListsUtil
 * @generated
 */
public class BiobankAttributeListsPersistenceImpl extends BasePersistenceImpl<BiobankAttributeLists>
	implements BiobankAttributeListsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BiobankAttributeListsUtil} to access the biobank attribute lists persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BiobankAttributeListsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			BiobankAttributeListsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			BiobankAttributeListsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BIOBANKDBID =
		new FinderPath(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			BiobankAttributeListsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybiobankDbId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKDBID =
		new FinderPath(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			BiobankAttributeListsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybiobankDbId",
			new String[] { Long.class.getName() },
			BiobankAttributeListsModelImpl.BIOBANKDBID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BIOBANKDBID = new FinderPath(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybiobankDbId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the biobank attribute listses where biobankDbId = &#63;.
	 *
	 * @param biobankDbId the biobank db ID
	 * @return the matching biobank attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankAttributeLists> findBybiobankDbId(long biobankDbId)
		throws SystemException {
		return findBybiobankDbId(biobankDbId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<BiobankAttributeLists> findBybiobankDbId(long biobankDbId,
		int start, int end) throws SystemException {
		return findBybiobankDbId(biobankDbId, start, end, null);
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
	@Override
	public List<BiobankAttributeLists> findBybiobankDbId(long biobankDbId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKDBID;
			finderArgs = new Object[] { biobankDbId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BIOBANKDBID;
			finderArgs = new Object[] { biobankDbId, start, end, orderByComparator };
		}

		List<BiobankAttributeLists> list = (List<BiobankAttributeLists>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BiobankAttributeLists biobankAttributeLists : list) {
				if ((biobankDbId != biobankAttributeLists.getBiobankDbId())) {
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

			query.append(_SQL_SELECT_BIOBANKATTRIBUTELISTS_WHERE);

			query.append(_FINDER_COLUMN_BIOBANKDBID_BIOBANKDBID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BiobankAttributeListsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(biobankDbId);

				if (!pagination) {
					list = (List<BiobankAttributeLists>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BiobankAttributeLists>(list);
				}
				else {
					list = (List<BiobankAttributeLists>)QueryUtil.list(q,
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
	 * Returns the first biobank attribute lists in the ordered set where biobankDbId = &#63;.
	 *
	 * @param biobankDbId the biobank db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching biobank attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a matching biobank attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeLists findBybiobankDbId_First(long biobankDbId,
		OrderByComparator orderByComparator)
		throws NoSuchBiobankAttributeListsException, SystemException {
		BiobankAttributeLists biobankAttributeLists = fetchBybiobankDbId_First(biobankDbId,
				orderByComparator);

		if (biobankAttributeLists != null) {
			return biobankAttributeLists;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("biobankDbId=");
		msg.append(biobankDbId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBiobankAttributeListsException(msg.toString());
	}

	/**
	 * Returns the first biobank attribute lists in the ordered set where biobankDbId = &#63;.
	 *
	 * @param biobankDbId the biobank db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeLists fetchBybiobankDbId_First(long biobankDbId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BiobankAttributeLists> list = findBybiobankDbId(biobankDbId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BiobankAttributeLists findBybiobankDbId_Last(long biobankDbId,
		OrderByComparator orderByComparator)
		throws NoSuchBiobankAttributeListsException, SystemException {
		BiobankAttributeLists biobankAttributeLists = fetchBybiobankDbId_Last(biobankDbId,
				orderByComparator);

		if (biobankAttributeLists != null) {
			return biobankAttributeLists;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("biobankDbId=");
		msg.append(biobankDbId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBiobankAttributeListsException(msg.toString());
	}

	/**
	 * Returns the last biobank attribute lists in the ordered set where biobankDbId = &#63;.
	 *
	 * @param biobankDbId the biobank db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching biobank attribute lists, or <code>null</code> if a matching biobank attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeLists fetchBybiobankDbId_Last(long biobankDbId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybiobankDbId(biobankDbId);

		if (count == 0) {
			return null;
		}

		List<BiobankAttributeLists> list = findBybiobankDbId(biobankDbId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BiobankAttributeLists[] findBybiobankDbId_PrevAndNext(
		long biobankAttributeListsId, long biobankDbId,
		OrderByComparator orderByComparator)
		throws NoSuchBiobankAttributeListsException, SystemException {
		BiobankAttributeLists biobankAttributeLists = findByPrimaryKey(biobankAttributeListsId);

		Session session = null;

		try {
			session = openSession();

			BiobankAttributeLists[] array = new BiobankAttributeListsImpl[3];

			array[0] = getBybiobankDbId_PrevAndNext(session,
					biobankAttributeLists, biobankDbId, orderByComparator, true);

			array[1] = biobankAttributeLists;

			array[2] = getBybiobankDbId_PrevAndNext(session,
					biobankAttributeLists, biobankDbId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BiobankAttributeLists getBybiobankDbId_PrevAndNext(
		Session session, BiobankAttributeLists biobankAttributeLists,
		long biobankDbId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BIOBANKATTRIBUTELISTS_WHERE);

		query.append(_FINDER_COLUMN_BIOBANKDBID_BIOBANKDBID_2);

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
			query.append(BiobankAttributeListsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(biobankDbId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(biobankAttributeLists);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BiobankAttributeLists> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the biobank attribute listses where biobankDbId = &#63; from the database.
	 *
	 * @param biobankDbId the biobank db ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybiobankDbId(long biobankDbId) throws SystemException {
		for (BiobankAttributeLists biobankAttributeLists : findBybiobankDbId(
				biobankDbId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(biobankAttributeLists);
		}
	}

	/**
	 * Returns the number of biobank attribute listses where biobankDbId = &#63;.
	 *
	 * @param biobankDbId the biobank db ID
	 * @return the number of matching biobank attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybiobankDbId(long biobankDbId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BIOBANKDBID;

		Object[] finderArgs = new Object[] { biobankDbId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BIOBANKATTRIBUTELISTS_WHERE);

			query.append(_FINDER_COLUMN_BIOBANKDBID_BIOBANKDBID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(biobankDbId);

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

	private static final String _FINDER_COLUMN_BIOBANKDBID_BIOBANKDBID_2 = "biobankAttributeLists.biobankDbId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BIOBANKDBID_ATTRIBUTELISTNAME =
		new FinderPath(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			BiobankAttributeListsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybiobankDbId_attributeListName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKDBID_ATTRIBUTELISTNAME =
		new FinderPath(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			BiobankAttributeListsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybiobankDbId_attributeListName",
			new String[] { Long.class.getName(), String.class.getName() },
			BiobankAttributeListsModelImpl.BIOBANKDBID_COLUMN_BITMASK |
			BiobankAttributeListsModelImpl.ATTRIBUTELISTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BIOBANKDBID_ATTRIBUTELISTNAME =
		new FinderPath(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybiobankDbId_attributeListName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63;.
	 *
	 * @param biobankDbId the biobank db ID
	 * @param attributeListName the attribute list name
	 * @return the matching biobank attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankAttributeLists> findBybiobankDbId_attributeListName(
		long biobankDbId, String attributeListName) throws SystemException {
		return findBybiobankDbId_attributeListName(biobankDbId,
			attributeListName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BiobankAttributeLists> findBybiobankDbId_attributeListName(
		long biobankDbId, String attributeListName, int start, int end)
		throws SystemException {
		return findBybiobankDbId_attributeListName(biobankDbId,
			attributeListName, start, end, null);
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
	@Override
	public List<BiobankAttributeLists> findBybiobankDbId_attributeListName(
		long biobankDbId, String attributeListName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKDBID_ATTRIBUTELISTNAME;
			finderArgs = new Object[] { biobankDbId, attributeListName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BIOBANKDBID_ATTRIBUTELISTNAME;
			finderArgs = new Object[] {
					biobankDbId, attributeListName,
					
					start, end, orderByComparator
				};
		}

		List<BiobankAttributeLists> list = (List<BiobankAttributeLists>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BiobankAttributeLists biobankAttributeLists : list) {
				if ((biobankDbId != biobankAttributeLists.getBiobankDbId()) ||
						!Validator.equals(attributeListName,
							biobankAttributeLists.getAttributeListName())) {
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

			query.append(_SQL_SELECT_BIOBANKATTRIBUTELISTS_WHERE);

			query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_BIOBANKDBID_2);

			boolean bindAttributeListName = false;

			if (attributeListName == null) {
				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_1);
			}
			else if (attributeListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_3);
			}
			else {
				bindAttributeListName = true;

				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BiobankAttributeListsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(biobankDbId);

				if (bindAttributeListName) {
					qPos.add(attributeListName);
				}

				if (!pagination) {
					list = (List<BiobankAttributeLists>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BiobankAttributeLists>(list);
				}
				else {
					list = (List<BiobankAttributeLists>)QueryUtil.list(q,
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
	 * Returns the first biobank attribute lists in the ordered set where biobankDbId = &#63; and attributeListName = &#63;.
	 *
	 * @param biobankDbId the biobank db ID
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching biobank attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a matching biobank attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeLists findBybiobankDbId_attributeListName_First(
		long biobankDbId, String attributeListName,
		OrderByComparator orderByComparator)
		throws NoSuchBiobankAttributeListsException, SystemException {
		BiobankAttributeLists biobankAttributeLists = fetchBybiobankDbId_attributeListName_First(biobankDbId,
				attributeListName, orderByComparator);

		if (biobankAttributeLists != null) {
			return biobankAttributeLists;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("biobankDbId=");
		msg.append(biobankDbId);

		msg.append(", attributeListName=");
		msg.append(attributeListName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBiobankAttributeListsException(msg.toString());
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
	@Override
	public BiobankAttributeLists fetchBybiobankDbId_attributeListName_First(
		long biobankDbId, String attributeListName,
		OrderByComparator orderByComparator) throws SystemException {
		List<BiobankAttributeLists> list = findBybiobankDbId_attributeListName(biobankDbId,
				attributeListName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BiobankAttributeLists findBybiobankDbId_attributeListName_Last(
		long biobankDbId, String attributeListName,
		OrderByComparator orderByComparator)
		throws NoSuchBiobankAttributeListsException, SystemException {
		BiobankAttributeLists biobankAttributeLists = fetchBybiobankDbId_attributeListName_Last(biobankDbId,
				attributeListName, orderByComparator);

		if (biobankAttributeLists != null) {
			return biobankAttributeLists;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("biobankDbId=");
		msg.append(biobankDbId);

		msg.append(", attributeListName=");
		msg.append(attributeListName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBiobankAttributeListsException(msg.toString());
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
	@Override
	public BiobankAttributeLists fetchBybiobankDbId_attributeListName_Last(
		long biobankDbId, String attributeListName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybiobankDbId_attributeListName(biobankDbId,
				attributeListName);

		if (count == 0) {
			return null;
		}

		List<BiobankAttributeLists> list = findBybiobankDbId_attributeListName(biobankDbId,
				attributeListName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BiobankAttributeLists[] findBybiobankDbId_attributeListName_PrevAndNext(
		long biobankAttributeListsId, long biobankDbId,
		String attributeListName, OrderByComparator orderByComparator)
		throws NoSuchBiobankAttributeListsException, SystemException {
		BiobankAttributeLists biobankAttributeLists = findByPrimaryKey(biobankAttributeListsId);

		Session session = null;

		try {
			session = openSession();

			BiobankAttributeLists[] array = new BiobankAttributeListsImpl[3];

			array[0] = getBybiobankDbId_attributeListName_PrevAndNext(session,
					biobankAttributeLists, biobankDbId, attributeListName,
					orderByComparator, true);

			array[1] = biobankAttributeLists;

			array[2] = getBybiobankDbId_attributeListName_PrevAndNext(session,
					biobankAttributeLists, biobankDbId, attributeListName,
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

	protected BiobankAttributeLists getBybiobankDbId_attributeListName_PrevAndNext(
		Session session, BiobankAttributeLists biobankAttributeLists,
		long biobankDbId, String attributeListName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BIOBANKATTRIBUTELISTS_WHERE);

		query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_BIOBANKDBID_2);

		boolean bindAttributeListName = false;

		if (attributeListName == null) {
			query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_1);
		}
		else if (attributeListName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_3);
		}
		else {
			bindAttributeListName = true;

			query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_2);
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
			query.append(BiobankAttributeListsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(biobankDbId);

		if (bindAttributeListName) {
			qPos.add(attributeListName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(biobankAttributeLists);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BiobankAttributeLists> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63; from the database.
	 *
	 * @param biobankDbId the biobank db ID
	 * @param attributeListName the attribute list name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybiobankDbId_attributeListName(long biobankDbId,
		String attributeListName) throws SystemException {
		for (BiobankAttributeLists biobankAttributeLists : findBybiobankDbId_attributeListName(
				biobankDbId, attributeListName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(biobankAttributeLists);
		}
	}

	/**
	 * Returns the number of biobank attribute listses where biobankDbId = &#63; and attributeListName = &#63;.
	 *
	 * @param biobankDbId the biobank db ID
	 * @param attributeListName the attribute list name
	 * @return the number of matching biobank attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybiobankDbId_attributeListName(long biobankDbId,
		String attributeListName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BIOBANKDBID_ATTRIBUTELISTNAME;

		Object[] finderArgs = new Object[] { biobankDbId, attributeListName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BIOBANKATTRIBUTELISTS_WHERE);

			query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_BIOBANKDBID_2);

			boolean bindAttributeListName = false;

			if (attributeListName == null) {
				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_1);
			}
			else if (attributeListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_3);
			}
			else {
				bindAttributeListName = true;

				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(biobankDbId);

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

	private static final String _FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_BIOBANKDBID_2 =
		"biobankAttributeLists.biobankDbId = ? AND ";
	private static final String _FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_1 =
		"biobankAttributeLists.attributeListName IS NULL";
	private static final String _FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_2 =
		"biobankAttributeLists.attributeListName = ?";
	private static final String _FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_3 =
		"(biobankAttributeLists.attributeListName IS NULL OR biobankAttributeLists.attributeListName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE =
		new FinderPath(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			BiobankAttributeListsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBybiobankDbId_attributeListName_attributeListValue",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			BiobankAttributeListsModelImpl.BIOBANKDBID_COLUMN_BITMASK |
			BiobankAttributeListsModelImpl.ATTRIBUTELISTNAME_COLUMN_BITMASK |
			BiobankAttributeListsModelImpl.ATTRIBUTELISTVALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE =
		new FinderPath(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybiobankDbId_attributeListName_attributeListValue",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

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
	@Override
	public BiobankAttributeLists findBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, String attributeListName, String attributeListValue)
		throws NoSuchBiobankAttributeListsException, SystemException {
		BiobankAttributeLists biobankAttributeLists = fetchBybiobankDbId_attributeListName_attributeListValue(biobankDbId,
				attributeListName, attributeListValue);

		if (biobankAttributeLists == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("biobankDbId=");
			msg.append(biobankDbId);

			msg.append(", attributeListName=");
			msg.append(attributeListName);

			msg.append(", attributeListValue=");
			msg.append(attributeListValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBiobankAttributeListsException(msg.toString());
		}

		return biobankAttributeLists;
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
	@Override
	public BiobankAttributeLists fetchBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, String attributeListName, String attributeListValue)
		throws SystemException {
		return fetchBybiobankDbId_attributeListName_attributeListValue(biobankDbId,
			attributeListName, attributeListValue, true);
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
	@Override
	public BiobankAttributeLists fetchBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, String attributeListName, String attributeListValue,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				biobankDbId, attributeListName, attributeListValue
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
					finderArgs, this);
		}

		if (result instanceof BiobankAttributeLists) {
			BiobankAttributeLists biobankAttributeLists = (BiobankAttributeLists)result;

			if ((biobankDbId != biobankAttributeLists.getBiobankDbId()) ||
					!Validator.equals(attributeListName,
						biobankAttributeLists.getAttributeListName()) ||
					!Validator.equals(attributeListValue,
						biobankAttributeLists.getAttributeListValue())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_BIOBANKATTRIBUTELISTS_WHERE);

			query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_BIOBANKDBID_2);

			boolean bindAttributeListName = false;

			if (attributeListName == null) {
				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_1);
			}
			else if (attributeListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_3);
			}
			else {
				bindAttributeListName = true;

				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_2);
			}

			boolean bindAttributeListValue = false;

			if (attributeListValue == null) {
				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_1);
			}
			else if (attributeListValue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_3);
			}
			else {
				bindAttributeListValue = true;

				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(biobankDbId);

				if (bindAttributeListName) {
					qPos.add(attributeListName);
				}

				if (bindAttributeListValue) {
					qPos.add(attributeListValue);
				}

				List<BiobankAttributeLists> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BiobankAttributeListsPersistenceImpl.fetchBybiobankDbId_attributeListName_attributeListValue(long, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BiobankAttributeLists biobankAttributeLists = list.get(0);

					result = biobankAttributeLists;

					cacheResult(biobankAttributeLists);

					if ((biobankAttributeLists.getBiobankDbId() != biobankDbId) ||
							(biobankAttributeLists.getAttributeListName() == null) ||
							!biobankAttributeLists.getAttributeListName()
													  .equals(attributeListName) ||
							(biobankAttributeLists.getAttributeListValue() == null) ||
							!biobankAttributeLists.getAttributeListValue()
													  .equals(attributeListValue)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
							finderArgs, biobankAttributeLists);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (BiobankAttributeLists)result;
		}
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
	@Override
	public BiobankAttributeLists removeBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, String attributeListName, String attributeListValue)
		throws NoSuchBiobankAttributeListsException, SystemException {
		BiobankAttributeLists biobankAttributeLists = findBybiobankDbId_attributeListName_attributeListValue(biobankDbId,
				attributeListName, attributeListValue);

		return remove(biobankAttributeLists);
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
	@Override
	public int countBybiobankDbId_attributeListName_attributeListValue(
		long biobankDbId, String attributeListName, String attributeListValue)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE;

		Object[] finderArgs = new Object[] {
				biobankDbId, attributeListName, attributeListValue
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_BIOBANKATTRIBUTELISTS_WHERE);

			query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_BIOBANKDBID_2);

			boolean bindAttributeListName = false;

			if (attributeListName == null) {
				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_1);
			}
			else if (attributeListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_3);
			}
			else {
				bindAttributeListName = true;

				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_2);
			}

			boolean bindAttributeListValue = false;

			if (attributeListValue == null) {
				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_1);
			}
			else if (attributeListValue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_3);
			}
			else {
				bindAttributeListValue = true;

				query.append(_FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(biobankDbId);

				if (bindAttributeListName) {
					qPos.add(attributeListName);
				}

				if (bindAttributeListValue) {
					qPos.add(attributeListValue);
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

	private static final String _FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_BIOBANKDBID_2 =
		"biobankAttributeLists.biobankDbId = ? AND ";
	private static final String _FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_1 =
		"biobankAttributeLists.attributeListName IS NULL AND ";
	private static final String _FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_2 =
		"biobankAttributeLists.attributeListName = ? AND ";
	private static final String _FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_3 =
		"(biobankAttributeLists.attributeListName IS NULL OR biobankAttributeLists.attributeListName = '') AND ";
	private static final String _FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_1 =
		"biobankAttributeLists.attributeListValue IS NULL";
	private static final String _FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_2 =
		"biobankAttributeLists.attributeListValue = ?";
	private static final String _FINDER_COLUMN_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_3 =
		"(biobankAttributeLists.attributeListValue IS NULL OR biobankAttributeLists.attributeListValue = '')";

	public BiobankAttributeListsPersistenceImpl() {
		setModelClass(BiobankAttributeLists.class);
	}

	/**
	 * Caches the biobank attribute lists in the entity cache if it is enabled.
	 *
	 * @param biobankAttributeLists the biobank attribute lists
	 */
	@Override
	public void cacheResult(BiobankAttributeLists biobankAttributeLists) {
		EntityCacheUtil.putResult(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsImpl.class,
			biobankAttributeLists.getPrimaryKey(), biobankAttributeLists);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
			new Object[] {
				biobankAttributeLists.getBiobankDbId(),
				biobankAttributeLists.getAttributeListName(),
				biobankAttributeLists.getAttributeListValue()
			}, biobankAttributeLists);

		biobankAttributeLists.resetOriginalValues();
	}

	/**
	 * Caches the biobank attribute listses in the entity cache if it is enabled.
	 *
	 * @param biobankAttributeListses the biobank attribute listses
	 */
	@Override
	public void cacheResult(List<BiobankAttributeLists> biobankAttributeListses) {
		for (BiobankAttributeLists biobankAttributeLists : biobankAttributeListses) {
			if (EntityCacheUtil.getResult(
						BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
						BiobankAttributeListsImpl.class,
						biobankAttributeLists.getPrimaryKey()) == null) {
				cacheResult(biobankAttributeLists);
			}
			else {
				biobankAttributeLists.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all biobank attribute listses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BiobankAttributeListsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BiobankAttributeListsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the biobank attribute lists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BiobankAttributeLists biobankAttributeLists) {
		EntityCacheUtil.removeResult(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsImpl.class,
			biobankAttributeLists.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(biobankAttributeLists);
	}

	@Override
	public void clearCache(List<BiobankAttributeLists> biobankAttributeListses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BiobankAttributeLists biobankAttributeLists : biobankAttributeListses) {
			EntityCacheUtil.removeResult(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
				BiobankAttributeListsImpl.class,
				biobankAttributeLists.getPrimaryKey());

			clearUniqueFindersCache(biobankAttributeLists);
		}
	}

	protected void cacheUniqueFindersCache(
		BiobankAttributeLists biobankAttributeLists) {
		if (biobankAttributeLists.isNew()) {
			Object[] args = new Object[] {
					biobankAttributeLists.getBiobankDbId(),
					biobankAttributeLists.getAttributeListName(),
					biobankAttributeLists.getAttributeListValue()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
				args, biobankAttributeLists);
		}
		else {
			BiobankAttributeListsModelImpl biobankAttributeListsModelImpl = (BiobankAttributeListsModelImpl)biobankAttributeLists;

			if ((biobankAttributeListsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						biobankAttributeLists.getBiobankDbId(),
						biobankAttributeLists.getAttributeListName(),
						biobankAttributeLists.getAttributeListValue()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
					args, biobankAttributeLists);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BiobankAttributeLists biobankAttributeLists) {
		BiobankAttributeListsModelImpl biobankAttributeListsModelImpl = (BiobankAttributeListsModelImpl)biobankAttributeLists;

		Object[] args = new Object[] {
				biobankAttributeLists.getBiobankDbId(),
				biobankAttributeLists.getAttributeListName(),
				biobankAttributeLists.getAttributeListValue()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
			args);

		if ((biobankAttributeListsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE.getColumnBitmask()) != 0) {
			args = new Object[] {
					biobankAttributeListsModelImpl.getOriginalBiobankDbId(),
					biobankAttributeListsModelImpl.getOriginalAttributeListName(),
					biobankAttributeListsModelImpl.getOriginalAttributeListValue()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BIOBANKDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
				args);
		}
	}

	/**
	 * Creates a new biobank attribute lists with the primary key. Does not add the biobank attribute lists to the database.
	 *
	 * @param biobankAttributeListsId the primary key for the new biobank attribute lists
	 * @return the new biobank attribute lists
	 */
	@Override
	public BiobankAttributeLists create(long biobankAttributeListsId) {
		BiobankAttributeLists biobankAttributeLists = new BiobankAttributeListsImpl();

		biobankAttributeLists.setNew(true);
		biobankAttributeLists.setPrimaryKey(biobankAttributeListsId);

		return biobankAttributeLists;
	}

	/**
	 * Removes the biobank attribute lists with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param biobankAttributeListsId the primary key of the biobank attribute lists
	 * @return the biobank attribute lists that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a biobank attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeLists remove(long biobankAttributeListsId)
		throws NoSuchBiobankAttributeListsException, SystemException {
		return remove((Serializable)biobankAttributeListsId);
	}

	/**
	 * Removes the biobank attribute lists with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the biobank attribute lists
	 * @return the biobank attribute lists that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a biobank attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeLists remove(Serializable primaryKey)
		throws NoSuchBiobankAttributeListsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BiobankAttributeLists biobankAttributeLists = (BiobankAttributeLists)session.get(BiobankAttributeListsImpl.class,
					primaryKey);

			if (biobankAttributeLists == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBiobankAttributeListsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(biobankAttributeLists);
		}
		catch (NoSuchBiobankAttributeListsException nsee) {
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
	protected BiobankAttributeLists removeImpl(
		BiobankAttributeLists biobankAttributeLists) throws SystemException {
		biobankAttributeLists = toUnwrappedModel(biobankAttributeLists);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(biobankAttributeLists)) {
				biobankAttributeLists = (BiobankAttributeLists)session.get(BiobankAttributeListsImpl.class,
						biobankAttributeLists.getPrimaryKeyObj());
			}

			if (biobankAttributeLists != null) {
				session.delete(biobankAttributeLists);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (biobankAttributeLists != null) {
			clearCache(biobankAttributeLists);
		}

		return biobankAttributeLists;
	}

	@Override
	public BiobankAttributeLists updateImpl(
		com.bcnet.portlet.biobank.model.BiobankAttributeLists biobankAttributeLists)
		throws SystemException {
		biobankAttributeLists = toUnwrappedModel(biobankAttributeLists);

		boolean isNew = biobankAttributeLists.isNew();

		BiobankAttributeListsModelImpl biobankAttributeListsModelImpl = (BiobankAttributeListsModelImpl)biobankAttributeLists;

		Session session = null;

		try {
			session = openSession();

			if (biobankAttributeLists.isNew()) {
				session.save(biobankAttributeLists);

				biobankAttributeLists.setNew(false);
			}
			else {
				session.merge(biobankAttributeLists);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BiobankAttributeListsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((biobankAttributeListsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKDBID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						biobankAttributeListsModelImpl.getOriginalBiobankDbId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKDBID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKDBID,
					args);

				args = new Object[] {
						biobankAttributeListsModelImpl.getBiobankDbId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKDBID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKDBID,
					args);
			}

			if ((biobankAttributeListsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKDBID_ATTRIBUTELISTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						biobankAttributeListsModelImpl.getOriginalBiobankDbId(),
						biobankAttributeListsModelImpl.getOriginalAttributeListName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKDBID_ATTRIBUTELISTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKDBID_ATTRIBUTELISTNAME,
					args);

				args = new Object[] {
						biobankAttributeListsModelImpl.getBiobankDbId(),
						biobankAttributeListsModelImpl.getAttributeListName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKDBID_ATTRIBUTELISTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKDBID_ATTRIBUTELISTNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsImpl.class,
			biobankAttributeLists.getPrimaryKey(), biobankAttributeLists);

		clearUniqueFindersCache(biobankAttributeLists);
		cacheUniqueFindersCache(biobankAttributeLists);

		return biobankAttributeLists;
	}

	protected BiobankAttributeLists toUnwrappedModel(
		BiobankAttributeLists biobankAttributeLists) {
		if (biobankAttributeLists instanceof BiobankAttributeListsImpl) {
			return biobankAttributeLists;
		}

		BiobankAttributeListsImpl biobankAttributeListsImpl = new BiobankAttributeListsImpl();

		biobankAttributeListsImpl.setNew(biobankAttributeLists.isNew());
		biobankAttributeListsImpl.setPrimaryKey(biobankAttributeLists.getPrimaryKey());

		biobankAttributeListsImpl.setBiobankAttributeListsId(biobankAttributeLists.getBiobankAttributeListsId());
		biobankAttributeListsImpl.setBiobankDbId(biobankAttributeLists.getBiobankDbId());
		biobankAttributeListsImpl.setAttributeListName(biobankAttributeLists.getAttributeListName());
		biobankAttributeListsImpl.setAttributeListValue(biobankAttributeLists.getAttributeListValue());

		return biobankAttributeListsImpl;
	}

	/**
	 * Returns the biobank attribute lists with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank attribute lists
	 * @return the biobank attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a biobank attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeLists findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBiobankAttributeListsException, SystemException {
		BiobankAttributeLists biobankAttributeLists = fetchByPrimaryKey(primaryKey);

		if (biobankAttributeLists == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBiobankAttributeListsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return biobankAttributeLists;
	}

	/**
	 * Returns the biobank attribute lists with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException} if it could not be found.
	 *
	 * @param biobankAttributeListsId the primary key of the biobank attribute lists
	 * @return the biobank attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException if a biobank attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeLists findByPrimaryKey(long biobankAttributeListsId)
		throws NoSuchBiobankAttributeListsException, SystemException {
		return findByPrimaryKey((Serializable)biobankAttributeListsId);
	}

	/**
	 * Returns the biobank attribute lists with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank attribute lists
	 * @return the biobank attribute lists, or <code>null</code> if a biobank attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeLists fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BiobankAttributeLists biobankAttributeLists = (BiobankAttributeLists)EntityCacheUtil.getResult(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
				BiobankAttributeListsImpl.class, primaryKey);

		if (biobankAttributeLists == _nullBiobankAttributeLists) {
			return null;
		}

		if (biobankAttributeLists == null) {
			Session session = null;

			try {
				session = openSession();

				biobankAttributeLists = (BiobankAttributeLists)session.get(BiobankAttributeListsImpl.class,
						primaryKey);

				if (biobankAttributeLists != null) {
					cacheResult(biobankAttributeLists);
				}
				else {
					EntityCacheUtil.putResult(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
						BiobankAttributeListsImpl.class, primaryKey,
						_nullBiobankAttributeLists);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BiobankAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
					BiobankAttributeListsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return biobankAttributeLists;
	}

	/**
	 * Returns the biobank attribute lists with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param biobankAttributeListsId the primary key of the biobank attribute lists
	 * @return the biobank attribute lists, or <code>null</code> if a biobank attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeLists fetchByPrimaryKey(long biobankAttributeListsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)biobankAttributeListsId);
	}

	/**
	 * Returns all the biobank attribute listses.
	 *
	 * @return the biobank attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankAttributeLists> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BiobankAttributeLists> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<BiobankAttributeLists> findAll(int start, int end,
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

		List<BiobankAttributeLists> list = (List<BiobankAttributeLists>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BIOBANKATTRIBUTELISTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BIOBANKATTRIBUTELISTS;

				if (pagination) {
					sql = sql.concat(BiobankAttributeListsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BiobankAttributeLists>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BiobankAttributeLists>(list);
				}
				else {
					list = (List<BiobankAttributeLists>)QueryUtil.list(q,
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
	 * Removes all the biobank attribute listses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BiobankAttributeLists biobankAttributeLists : findAll()) {
			remove(biobankAttributeLists);
		}
	}

	/**
	 * Returns the number of biobank attribute listses.
	 *
	 * @return the number of biobank attribute listses
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

				Query q = session.createQuery(_SQL_COUNT_BIOBANKATTRIBUTELISTS);

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
	 * Initializes the biobank attribute lists persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.BiobankAttributeLists")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BiobankAttributeLists>> listenersList = new ArrayList<ModelListener<BiobankAttributeLists>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BiobankAttributeLists>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BiobankAttributeListsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BIOBANKATTRIBUTELISTS = "SELECT biobankAttributeLists FROM BiobankAttributeLists biobankAttributeLists";
	private static final String _SQL_SELECT_BIOBANKATTRIBUTELISTS_WHERE = "SELECT biobankAttributeLists FROM BiobankAttributeLists biobankAttributeLists WHERE ";
	private static final String _SQL_COUNT_BIOBANKATTRIBUTELISTS = "SELECT COUNT(biobankAttributeLists) FROM BiobankAttributeLists biobankAttributeLists";
	private static final String _SQL_COUNT_BIOBANKATTRIBUTELISTS_WHERE = "SELECT COUNT(biobankAttributeLists) FROM BiobankAttributeLists biobankAttributeLists WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "biobankAttributeLists.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BiobankAttributeLists exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BiobankAttributeLists exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BiobankAttributeListsPersistenceImpl.class);
	private static BiobankAttributeLists _nullBiobankAttributeLists = new BiobankAttributeListsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BiobankAttributeLists> toCacheModel() {
				return _nullBiobankAttributeListsCacheModel;
			}
		};

	private static CacheModel<BiobankAttributeLists> _nullBiobankAttributeListsCacheModel =
		new CacheModel<BiobankAttributeLists>() {
			@Override
			public BiobankAttributeLists toEntityModel() {
				return _nullBiobankAttributeLists;
			}
		};
}