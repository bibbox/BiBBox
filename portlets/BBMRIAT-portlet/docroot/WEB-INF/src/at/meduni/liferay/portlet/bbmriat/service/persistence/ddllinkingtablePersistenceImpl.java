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

package at.meduni.liferay.portlet.bbmriat.service.persistence;

import at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException;
import at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable;
import at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableImpl;
import at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ddllinkingtable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ddllinkingtablePersistence
 * @see ddllinkingtableUtil
 * @generated
 */
public class ddllinkingtablePersistenceImpl extends BasePersistenceImpl<ddllinkingtable>
	implements ddllinkingtablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ddllinkingtableUtil} to access the ddllinkingtable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ddllinkingtableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
			ddllinkingtableModelImpl.FINDER_CACHE_ENABLED,
			ddllinkingtableImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
			ddllinkingtableModelImpl.FINDER_CACHE_ENABLED,
			ddllinkingtableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
			ddllinkingtableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECORDID = new FinderPath(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
			ddllinkingtableModelImpl.FINDER_CACHE_ENABLED,
			ddllinkingtableImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRecordid",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID =
		new FinderPath(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
			ddllinkingtableModelImpl.FINDER_CACHE_ENABLED,
			ddllinkingtableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRecordid",
			new String[] { Long.class.getName() },
			ddllinkingtableModelImpl.RECORDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECORDID = new FinderPath(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
			ddllinkingtableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRecordid",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ddllinkingtables where recordid = &#63;.
	 *
	 * @param recordid the recordid
	 * @return the matching ddllinkingtables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ddllinkingtable> findByRecordid(long recordid)
		throws SystemException {
		return findByRecordid(recordid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ddllinkingtables where recordid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recordid the recordid
	 * @param start the lower bound of the range of ddllinkingtables
	 * @param end the upper bound of the range of ddllinkingtables (not inclusive)
	 * @return the range of matching ddllinkingtables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ddllinkingtable> findByRecordid(long recordid, int start,
		int end) throws SystemException {
		return findByRecordid(recordid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ddllinkingtables where recordid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recordid the recordid
	 * @param start the lower bound of the range of ddllinkingtables
	 * @param end the upper bound of the range of ddllinkingtables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ddllinkingtables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ddllinkingtable> findByRecordid(long recordid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID;
			finderArgs = new Object[] { recordid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECORDID;
			finderArgs = new Object[] { recordid, start, end, orderByComparator };
		}

		List<ddllinkingtable> list = (List<ddllinkingtable>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ddllinkingtable ddllinkingtable : list) {
				if ((recordid != ddllinkingtable.getRecordid())) {
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

			query.append(_SQL_SELECT_DDLLINKINGTABLE_WHERE);

			query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ddllinkingtableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recordid);

				if (!pagination) {
					list = (List<ddllinkingtable>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ddllinkingtable>(list);
				}
				else {
					list = (List<ddllinkingtable>)QueryUtil.list(q,
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
	 * Returns the first ddllinkingtable in the ordered set where recordid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ddllinkingtable
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a matching ddllinkingtable could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ddllinkingtable findByRecordid_First(long recordid,
		OrderByComparator orderByComparator)
		throws NoSuchddllinkingtableException, SystemException {
		ddllinkingtable ddllinkingtable = fetchByRecordid_First(recordid,
				orderByComparator);

		if (ddllinkingtable != null) {
			return ddllinkingtable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recordid=");
		msg.append(recordid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchddllinkingtableException(msg.toString());
	}

	/**
	 * Returns the first ddllinkingtable in the ordered set where recordid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ddllinkingtable, or <code>null</code> if a matching ddllinkingtable could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ddllinkingtable fetchByRecordid_First(long recordid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ddllinkingtable> list = findByRecordid(recordid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ddllinkingtable in the ordered set where recordid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ddllinkingtable
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a matching ddllinkingtable could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ddllinkingtable findByRecordid_Last(long recordid,
		OrderByComparator orderByComparator)
		throws NoSuchddllinkingtableException, SystemException {
		ddllinkingtable ddllinkingtable = fetchByRecordid_Last(recordid,
				orderByComparator);

		if (ddllinkingtable != null) {
			return ddllinkingtable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recordid=");
		msg.append(recordid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchddllinkingtableException(msg.toString());
	}

	/**
	 * Returns the last ddllinkingtable in the ordered set where recordid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ddllinkingtable, or <code>null</code> if a matching ddllinkingtable could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ddllinkingtable fetchByRecordid_Last(long recordid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRecordid(recordid);

		if (count == 0) {
			return null;
		}

		List<ddllinkingtable> list = findByRecordid(recordid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ddllinkingtables before and after the current ddllinkingtable in the ordered set where recordid = &#63;.
	 *
	 * @param ddllinkingtable the primary key of the current ddllinkingtable
	 * @param recordid the recordid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ddllinkingtable
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a ddllinkingtable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ddllinkingtable[] findByRecordid_PrevAndNext(long ddllinkingtable,
		long recordid, OrderByComparator orderByComparator)
		throws NoSuchddllinkingtableException, SystemException {
		ddllinkingtable ddllinkingtable = findByPrimaryKey(ddllinkingtable);

		Session session = null;

		try {
			session = openSession();

			ddllinkingtable[] array = new ddllinkingtableImpl[3];

			array[0] = getByRecordid_PrevAndNext(session, ddllinkingtable,
					recordid, orderByComparator, true);

			array[1] = ddllinkingtable;

			array[2] = getByRecordid_PrevAndNext(session, ddllinkingtable,
					recordid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ddllinkingtable getByRecordid_PrevAndNext(Session session,
		ddllinkingtable ddllinkingtable, long recordid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DDLLINKINGTABLE_WHERE);

		query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

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
			query.append(ddllinkingtableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(recordid);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ddllinkingtable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ddllinkingtable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ddllinkingtables where recordid = &#63; from the database.
	 *
	 * @param recordid the recordid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRecordid(long recordid) throws SystemException {
		for (ddllinkingtable ddllinkingtable : findByRecordid(recordid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ddllinkingtable);
		}
	}

	/**
	 * Returns the number of ddllinkingtables where recordid = &#63;.
	 *
	 * @param recordid the recordid
	 * @return the number of matching ddllinkingtables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRecordid(long recordid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECORDID;

		Object[] finderArgs = new Object[] { recordid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DDLLINKINGTABLE_WHERE);

			query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recordid);

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

	private static final String _FINDER_COLUMN_RECORDID_RECORDID_2 = "ddllinkingtable.recordid = ?";

	public ddllinkingtablePersistenceImpl() {
		setModelClass(ddllinkingtable.class);
	}

	/**
	 * Caches the ddllinkingtable in the entity cache if it is enabled.
	 *
	 * @param ddllinkingtable the ddllinkingtable
	 */
	@Override
	public void cacheResult(ddllinkingtable ddllinkingtable) {
		EntityCacheUtil.putResult(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
			ddllinkingtableImpl.class, ddllinkingtable.getPrimaryKey(),
			ddllinkingtable);

		ddllinkingtable.resetOriginalValues();
	}

	/**
	 * Caches the ddllinkingtables in the entity cache if it is enabled.
	 *
	 * @param ddllinkingtables the ddllinkingtables
	 */
	@Override
	public void cacheResult(List<ddllinkingtable> ddllinkingtables) {
		for (ddllinkingtable ddllinkingtable : ddllinkingtables) {
			if (EntityCacheUtil.getResult(
						ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
						ddllinkingtableImpl.class,
						ddllinkingtable.getPrimaryKey()) == null) {
				cacheResult(ddllinkingtable);
			}
			else {
				ddllinkingtable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ddllinkingtables.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ddllinkingtableImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ddllinkingtableImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ddllinkingtable.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ddllinkingtable ddllinkingtable) {
		EntityCacheUtil.removeResult(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
			ddllinkingtableImpl.class, ddllinkingtable.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ddllinkingtable> ddllinkingtables) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ddllinkingtable ddllinkingtable : ddllinkingtables) {
			EntityCacheUtil.removeResult(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
				ddllinkingtableImpl.class, ddllinkingtable.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ddllinkingtable with the primary key. Does not add the ddllinkingtable to the database.
	 *
	 * @param ddllinkingtable the primary key for the new ddllinkingtable
	 * @return the new ddllinkingtable
	 */
	@Override
	public ddllinkingtable create(long ddllinkingtable) {
		ddllinkingtable ddllinkingtable = new ddllinkingtableImpl();

		ddllinkingtable.setNew(true);
		ddllinkingtable.setPrimaryKey(ddllinkingtable);

		return ddllinkingtable;
	}

	/**
	 * Removes the ddllinkingtable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddllinkingtable the primary key of the ddllinkingtable
	 * @return the ddllinkingtable that was removed
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a ddllinkingtable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ddllinkingtable remove(long ddllinkingtable)
		throws NoSuchddllinkingtableException, SystemException {
		return remove((Serializable)ddllinkingtable);
	}

	/**
	 * Removes the ddllinkingtable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ddllinkingtable
	 * @return the ddllinkingtable that was removed
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a ddllinkingtable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ddllinkingtable remove(Serializable primaryKey)
		throws NoSuchddllinkingtableException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ddllinkingtable ddllinkingtable = (ddllinkingtable)session.get(ddllinkingtableImpl.class,
					primaryKey);

			if (ddllinkingtable == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchddllinkingtableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ddllinkingtable);
		}
		catch (NoSuchddllinkingtableException nsee) {
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
	protected ddllinkingtable removeImpl(ddllinkingtable ddllinkingtable)
		throws SystemException {
		ddllinkingtable = toUnwrappedModel(ddllinkingtable);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ddllinkingtable)) {
				ddllinkingtable = (ddllinkingtable)session.get(ddllinkingtableImpl.class,
						ddllinkingtable.getPrimaryKeyObj());
			}

			if (ddllinkingtable != null) {
				session.delete(ddllinkingtable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ddllinkingtable != null) {
			clearCache(ddllinkingtable);
		}

		return ddllinkingtable;
	}

	@Override
	public ddllinkingtable updateImpl(
		at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable ddllinkingtable)
		throws SystemException {
		ddllinkingtable = toUnwrappedModel(ddllinkingtable);

		boolean isNew = ddllinkingtable.isNew();

		ddllinkingtableModelImpl ddllinkingtableModelImpl = (ddllinkingtableModelImpl)ddllinkingtable;

		Session session = null;

		try {
			session = openSession();

			if (ddllinkingtable.isNew()) {
				session.save(ddllinkingtable);

				ddllinkingtable.setNew(false);
			}
			else {
				session.merge(ddllinkingtable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ddllinkingtableModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ddllinkingtableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ddllinkingtableModelImpl.getOriginalRecordid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECORDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID,
					args);

				args = new Object[] { ddllinkingtableModelImpl.getRecordid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECORDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID,
					args);
			}
		}

		EntityCacheUtil.putResult(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
			ddllinkingtableImpl.class, ddllinkingtable.getPrimaryKey(),
			ddllinkingtable);

		return ddllinkingtable;
	}

	protected ddllinkingtable toUnwrappedModel(ddllinkingtable ddllinkingtable) {
		if (ddllinkingtable instanceof ddllinkingtableImpl) {
			return ddllinkingtable;
		}

		ddllinkingtableImpl ddllinkingtableImpl = new ddllinkingtableImpl();

		ddllinkingtableImpl.setNew(ddllinkingtable.isNew());
		ddllinkingtableImpl.setPrimaryKey(ddllinkingtable.getPrimaryKey());

		ddllinkingtableImpl.setDdllinkingtable(ddllinkingtable.getDdllinkingtable());
		ddllinkingtableImpl.setRecordid(ddllinkingtable.getRecordid());
		ddllinkingtableImpl.setRecordsetid(ddllinkingtable.getRecordsetid());
		ddllinkingtableImpl.setLinkrecordid(ddllinkingtable.getLinkrecordid());
		ddllinkingtableImpl.setLinkrecordsetid(ddllinkingtable.getLinkrecordsetid());

		return ddllinkingtableImpl;
	}

	/**
	 * Returns the ddllinkingtable with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ddllinkingtable
	 * @return the ddllinkingtable
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a ddllinkingtable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ddllinkingtable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchddllinkingtableException, SystemException {
		ddllinkingtable ddllinkingtable = fetchByPrimaryKey(primaryKey);

		if (ddllinkingtable == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchddllinkingtableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ddllinkingtable;
	}

	/**
	 * Returns the ddllinkingtable with the primary key or throws a {@link at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException} if it could not be found.
	 *
	 * @param ddllinkingtable the primary key of the ddllinkingtable
	 * @return the ddllinkingtable
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a ddllinkingtable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ddllinkingtable findByPrimaryKey(long ddllinkingtable)
		throws NoSuchddllinkingtableException, SystemException {
		return findByPrimaryKey((Serializable)ddllinkingtable);
	}

	/**
	 * Returns the ddllinkingtable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ddllinkingtable
	 * @return the ddllinkingtable, or <code>null</code> if a ddllinkingtable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ddllinkingtable fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ddllinkingtable ddllinkingtable = (ddllinkingtable)EntityCacheUtil.getResult(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
				ddllinkingtableImpl.class, primaryKey);

		if (ddllinkingtable == _nullddllinkingtable) {
			return null;
		}

		if (ddllinkingtable == null) {
			Session session = null;

			try {
				session = openSession();

				ddllinkingtable = (ddllinkingtable)session.get(ddllinkingtableImpl.class,
						primaryKey);

				if (ddllinkingtable != null) {
					cacheResult(ddllinkingtable);
				}
				else {
					EntityCacheUtil.putResult(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
						ddllinkingtableImpl.class, primaryKey,
						_nullddllinkingtable);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ddllinkingtableModelImpl.ENTITY_CACHE_ENABLED,
					ddllinkingtableImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ddllinkingtable;
	}

	/**
	 * Returns the ddllinkingtable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ddllinkingtable the primary key of the ddllinkingtable
	 * @return the ddllinkingtable, or <code>null</code> if a ddllinkingtable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ddllinkingtable fetchByPrimaryKey(long ddllinkingtable)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)ddllinkingtable);
	}

	/**
	 * Returns all the ddllinkingtables.
	 *
	 * @return the ddllinkingtables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ddllinkingtable> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ddllinkingtables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ddllinkingtables
	 * @param end the upper bound of the range of ddllinkingtables (not inclusive)
	 * @return the range of ddllinkingtables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ddllinkingtable> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ddllinkingtables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ddllinkingtables
	 * @param end the upper bound of the range of ddllinkingtables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ddllinkingtables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ddllinkingtable> findAll(int start, int end,
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

		List<ddllinkingtable> list = (List<ddllinkingtable>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DDLLINKINGTABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DDLLINKINGTABLE;

				if (pagination) {
					sql = sql.concat(ddllinkingtableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ddllinkingtable>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ddllinkingtable>(list);
				}
				else {
					list = (List<ddllinkingtable>)QueryUtil.list(q,
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
	 * Removes all the ddllinkingtables from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ddllinkingtable ddllinkingtable : findAll()) {
			remove(ddllinkingtable);
		}
	}

	/**
	 * Returns the number of ddllinkingtables.
	 *
	 * @return the number of ddllinkingtables
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

				Query q = session.createQuery(_SQL_COUNT_DDLLINKINGTABLE);

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
	 * Initializes the ddllinkingtable persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ddllinkingtable>> listenersList = new ArrayList<ModelListener<ddllinkingtable>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ddllinkingtable>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ddllinkingtableImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DDLLINKINGTABLE = "SELECT ddllinkingtable FROM ddllinkingtable ddllinkingtable";
	private static final String _SQL_SELECT_DDLLINKINGTABLE_WHERE = "SELECT ddllinkingtable FROM ddllinkingtable ddllinkingtable WHERE ";
	private static final String _SQL_COUNT_DDLLINKINGTABLE = "SELECT COUNT(ddllinkingtable) FROM ddllinkingtable ddllinkingtable";
	private static final String _SQL_COUNT_DDLLINKINGTABLE_WHERE = "SELECT COUNT(ddllinkingtable) FROM ddllinkingtable ddllinkingtable WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ddllinkingtable.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ddllinkingtable exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ddllinkingtable exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ddllinkingtablePersistenceImpl.class);
	private static ddllinkingtable _nullddllinkingtable = new ddllinkingtableImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ddllinkingtable> toCacheModel() {
				return _nullddllinkingtableCacheModel;
			}
		};

	private static CacheModel<ddllinkingtable> _nullddllinkingtableCacheModel = new CacheModel<ddllinkingtable>() {
			@Override
			public ddllinkingtable toEntityModel() {
				return _nullddllinkingtable;
			}
		};
}