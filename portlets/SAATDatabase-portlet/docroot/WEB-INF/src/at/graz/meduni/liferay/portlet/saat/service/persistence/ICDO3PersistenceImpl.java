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

import at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception;
import at.graz.meduni.liferay.portlet.saat.model.ICDO3;
import at.graz.meduni.liferay.portlet.saat.model.impl.ICDO3Impl;
import at.graz.meduni.liferay.portlet.saat.model.impl.ICDO3ModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the i c d o3 service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ICDO3Persistence
 * @see ICDO3Util
 * @generated
 */
public class ICDO3PersistenceImpl extends BasePersistenceImpl<ICDO3>
	implements ICDO3Persistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ICDO3Util} to access the i c d o3 persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ICDO3Impl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
			ICDO3ModelImpl.FINDER_CACHE_ENABLED, ICDO3Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
			ICDO3ModelImpl.FINDER_CACHE_ENABLED, ICDO3Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
			ICDO3ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE = new FinderPath(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
			ICDO3ModelImpl.FINDER_CACHE_ENABLED, ICDO3Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE = new FinderPath(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
			ICDO3ModelImpl.FINDER_CACHE_ENABLED, ICDO3Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCode",
			new String[] { String.class.getName() },
			ICDO3ModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
			ICDO3ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the i c d o3s where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching i c d o3s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ICDO3> findByCode(String code) throws SystemException {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ICDO3> findByCode(String code, int start, int end)
		throws SystemException {
		return findByCode(code, start, end, null);
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
	@Override
	public List<ICDO3> findByCode(String code, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE;
			finderArgs = new Object[] { code };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE;
			finderArgs = new Object[] { code, start, end, orderByComparator };
		}

		List<ICDO3> list = (List<ICDO3>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ICDO3 icdo3 : list) {
				if (!Validator.equals(code, icdo3.getCode())) {
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

			query.append(_SQL_SELECT_ICDO3_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ICDO3ModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				if (!pagination) {
					list = (List<ICDO3>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ICDO3>(list);
				}
				else {
					list = (List<ICDO3>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first i c d o3 in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i c d o3
	 * @throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception if a matching i c d o3 could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICDO3 findByCode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchICDO3Exception, SystemException {
		ICDO3 icdo3 = fetchByCode_First(code, orderByComparator);

		if (icdo3 != null) {
			return icdo3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchICDO3Exception(msg.toString());
	}

	/**
	 * Returns the first i c d o3 in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i c d o3, or <code>null</code> if a matching i c d o3 could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICDO3 fetchByCode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ICDO3> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ICDO3 findByCode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchICDO3Exception, SystemException {
		ICDO3 icdo3 = fetchByCode_Last(code, orderByComparator);

		if (icdo3 != null) {
			return icdo3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchICDO3Exception(msg.toString());
	}

	/**
	 * Returns the last i c d o3 in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i c d o3, or <code>null</code> if a matching i c d o3 could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICDO3 fetchByCode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<ICDO3> list = findByCode(code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ICDO3[] findByCode_PrevAndNext(long icdo3Id, String code,
		OrderByComparator orderByComparator)
		throws NoSuchICDO3Exception, SystemException {
		ICDO3 icdo3 = findByPrimaryKey(icdo3Id);

		Session session = null;

		try {
			session = openSession();

			ICDO3[] array = new ICDO3Impl[3];

			array[0] = getByCode_PrevAndNext(session, icdo3, code,
					orderByComparator, true);

			array[1] = icdo3;

			array[2] = getByCode_PrevAndNext(session, icdo3, code,
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

	protected ICDO3 getByCode_PrevAndNext(Session session, ICDO3 icdo3,
		String code, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ICDO3_WHERE);

		boolean bindCode = false;

		if (code == null) {
			query.append(_FINDER_COLUMN_CODE_CODE_1);
		}
		else if (code.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CODE_CODE_3);
		}
		else {
			bindCode = true;

			query.append(_FINDER_COLUMN_CODE_CODE_2);
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
			query.append(ICDO3ModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCode) {
			qPos.add(code);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(icdo3);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ICDO3> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i c d o3s where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCode(String code) throws SystemException {
		for (ICDO3 icdo3 : findByCode(code, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(icdo3);
		}
	}

	/**
	 * Returns the number of i c d o3s where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching i c d o3s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ICDO3_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "icdo3.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "icdo3.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(icdo3.code IS NULL OR icdo3.code = '')";

	public ICDO3PersistenceImpl() {
		setModelClass(ICDO3.class);
	}

	/**
	 * Caches the i c d o3 in the entity cache if it is enabled.
	 *
	 * @param icdo3 the i c d o3
	 */
	@Override
	public void cacheResult(ICDO3 icdo3) {
		EntityCacheUtil.putResult(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
			ICDO3Impl.class, icdo3.getPrimaryKey(), icdo3);

		icdo3.resetOriginalValues();
	}

	/**
	 * Caches the i c d o3s in the entity cache if it is enabled.
	 *
	 * @param icdo3s the i c d o3s
	 */
	@Override
	public void cacheResult(List<ICDO3> icdo3s) {
		for (ICDO3 icdo3 : icdo3s) {
			if (EntityCacheUtil.getResult(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
						ICDO3Impl.class, icdo3.getPrimaryKey()) == null) {
				cacheResult(icdo3);
			}
			else {
				icdo3.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all i c d o3s.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ICDO3Impl.class.getName());
		}

		EntityCacheUtil.clearCache(ICDO3Impl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the i c d o3.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ICDO3 icdo3) {
		EntityCacheUtil.removeResult(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
			ICDO3Impl.class, icdo3.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ICDO3> icdo3s) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ICDO3 icdo3 : icdo3s) {
			EntityCacheUtil.removeResult(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
				ICDO3Impl.class, icdo3.getPrimaryKey());
		}
	}

	/**
	 * Creates a new i c d o3 with the primary key. Does not add the i c d o3 to the database.
	 *
	 * @param icdo3Id the primary key for the new i c d o3
	 * @return the new i c d o3
	 */
	@Override
	public ICDO3 create(long icdo3Id) {
		ICDO3 icdo3 = new ICDO3Impl();

		icdo3.setNew(true);
		icdo3.setPrimaryKey(icdo3Id);

		return icdo3;
	}

	/**
	 * Removes the i c d o3 with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param icdo3Id the primary key of the i c d o3
	 * @return the i c d o3 that was removed
	 * @throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception if a i c d o3 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICDO3 remove(long icdo3Id)
		throws NoSuchICDO3Exception, SystemException {
		return remove((Serializable)icdo3Id);
	}

	/**
	 * Removes the i c d o3 with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the i c d o3
	 * @return the i c d o3 that was removed
	 * @throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception if a i c d o3 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICDO3 remove(Serializable primaryKey)
		throws NoSuchICDO3Exception, SystemException {
		Session session = null;

		try {
			session = openSession();

			ICDO3 icdo3 = (ICDO3)session.get(ICDO3Impl.class, primaryKey);

			if (icdo3 == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchICDO3Exception(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(icdo3);
		}
		catch (NoSuchICDO3Exception nsee) {
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
	protected ICDO3 removeImpl(ICDO3 icdo3) throws SystemException {
		icdo3 = toUnwrappedModel(icdo3);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(icdo3)) {
				icdo3 = (ICDO3)session.get(ICDO3Impl.class,
						icdo3.getPrimaryKeyObj());
			}

			if (icdo3 != null) {
				session.delete(icdo3);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (icdo3 != null) {
			clearCache(icdo3);
		}

		return icdo3;
	}

	@Override
	public ICDO3 updateImpl(
		at.graz.meduni.liferay.portlet.saat.model.ICDO3 icdo3)
		throws SystemException {
		icdo3 = toUnwrappedModel(icdo3);

		boolean isNew = icdo3.isNew();

		ICDO3ModelImpl icdo3ModelImpl = (ICDO3ModelImpl)icdo3;

		Session session = null;

		try {
			session = openSession();

			if (icdo3.isNew()) {
				session.save(icdo3);

				icdo3.setNew(false);
			}
			else {
				session.merge(icdo3);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ICDO3ModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((icdo3ModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { icdo3ModelImpl.getOriginalCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);

				args = new Object[] { icdo3ModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);
			}
		}

		EntityCacheUtil.putResult(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
			ICDO3Impl.class, icdo3.getPrimaryKey(), icdo3);

		return icdo3;
	}

	protected ICDO3 toUnwrappedModel(ICDO3 icdo3) {
		if (icdo3 instanceof ICDO3Impl) {
			return icdo3;
		}

		ICDO3Impl icdo3Impl = new ICDO3Impl();

		icdo3Impl.setNew(icdo3.isNew());
		icdo3Impl.setPrimaryKey(icdo3.getPrimaryKey());

		icdo3Impl.setIcdo3Id(icdo3.getIcdo3Id());
		icdo3Impl.setCode(icdo3.getCode());
		icdo3Impl.setTerm(icdo3.getTerm());
		icdo3Impl.setSui(icdo3.getSui());
		icdo3Impl.setTyp(icdo3.getTyp());
		icdo3Impl.setUse(icdo3.getUse());
		icdo3Impl.setDescription(icdo3.getDescription());
		icdo3Impl.setLocalisation(icdo3.getLocalisation());
		icdo3Impl.setLink(icdo3.getLink());
		icdo3Impl.setExklusiva(icdo3.getExklusiva());
		icdo3Impl.setHint(icdo3.getHint());

		return icdo3Impl;
	}

	/**
	 * Returns the i c d o3 with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the i c d o3
	 * @return the i c d o3
	 * @throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception if a i c d o3 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICDO3 findByPrimaryKey(Serializable primaryKey)
		throws NoSuchICDO3Exception, SystemException {
		ICDO3 icdo3 = fetchByPrimaryKey(primaryKey);

		if (icdo3 == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchICDO3Exception(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return icdo3;
	}

	/**
	 * Returns the i c d o3 with the primary key or throws a {@link at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception} if it could not be found.
	 *
	 * @param icdo3Id the primary key of the i c d o3
	 * @return the i c d o3
	 * @throws at.graz.meduni.liferay.portlet.saat.NoSuchICDO3Exception if a i c d o3 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICDO3 findByPrimaryKey(long icdo3Id)
		throws NoSuchICDO3Exception, SystemException {
		return findByPrimaryKey((Serializable)icdo3Id);
	}

	/**
	 * Returns the i c d o3 with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the i c d o3
	 * @return the i c d o3, or <code>null</code> if a i c d o3 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICDO3 fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ICDO3 icdo3 = (ICDO3)EntityCacheUtil.getResult(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
				ICDO3Impl.class, primaryKey);

		if (icdo3 == _nullICDO3) {
			return null;
		}

		if (icdo3 == null) {
			Session session = null;

			try {
				session = openSession();

				icdo3 = (ICDO3)session.get(ICDO3Impl.class, primaryKey);

				if (icdo3 != null) {
					cacheResult(icdo3);
				}
				else {
					EntityCacheUtil.putResult(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
						ICDO3Impl.class, primaryKey, _nullICDO3);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ICDO3ModelImpl.ENTITY_CACHE_ENABLED,
					ICDO3Impl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return icdo3;
	}

	/**
	 * Returns the i c d o3 with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param icdo3Id the primary key of the i c d o3
	 * @return the i c d o3, or <code>null</code> if a i c d o3 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICDO3 fetchByPrimaryKey(long icdo3Id) throws SystemException {
		return fetchByPrimaryKey((Serializable)icdo3Id);
	}

	/**
	 * Returns all the i c d o3s.
	 *
	 * @return the i c d o3s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ICDO3> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ICDO3> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<ICDO3> findAll(int start, int end,
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

		List<ICDO3> list = (List<ICDO3>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ICDO3);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ICDO3;

				if (pagination) {
					sql = sql.concat(ICDO3ModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ICDO3>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ICDO3>(list);
				}
				else {
					list = (List<ICDO3>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the i c d o3s from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ICDO3 icdo3 : findAll()) {
			remove(icdo3);
		}
	}

	/**
	 * Returns the number of i c d o3s.
	 *
	 * @return the number of i c d o3s
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

				Query q = session.createQuery(_SQL_COUNT_ICDO3);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the i c d o3 persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.saat.model.ICDO3")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ICDO3>> listenersList = new ArrayList<ModelListener<ICDO3>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ICDO3>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ICDO3Impl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ICDO3 = "SELECT icdo3 FROM ICDO3 icdo3";
	private static final String _SQL_SELECT_ICDO3_WHERE = "SELECT icdo3 FROM ICDO3 icdo3 WHERE ";
	private static final String _SQL_COUNT_ICDO3 = "SELECT COUNT(icdo3) FROM ICDO3 icdo3";
	private static final String _SQL_COUNT_ICDO3_WHERE = "SELECT COUNT(icdo3) FROM ICDO3 icdo3 WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "icdo3.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ICDO3 exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ICDO3 exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ICDO3PersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code", "use"
			});
	private static ICDO3 _nullICDO3 = new ICDO3Impl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ICDO3> toCacheModel() {
				return _nullICDO3CacheModel;
			}
		};

	private static CacheModel<ICDO3> _nullICDO3CacheModel = new CacheModel<ICDO3>() {
			@Override
			public ICDO3 toEntityModel() {
				return _nullICDO3;
			}
		};
}