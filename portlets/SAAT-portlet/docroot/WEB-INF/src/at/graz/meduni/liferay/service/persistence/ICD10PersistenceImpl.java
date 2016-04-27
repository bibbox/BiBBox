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

package at.graz.meduni.liferay.service.persistence;

import at.graz.meduni.liferay.NoSuchICD10Exception;
import at.graz.meduni.liferay.model.ICD10;
import at.graz.meduni.liferay.model.impl.ICD10Impl;
import at.graz.meduni.liferay.model.impl.ICD10ModelImpl;

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
 * The persistence implementation for the i c d10 service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ICD10Persistence
 * @see ICD10Util
 * @generated
 */
public class ICD10PersistenceImpl extends BasePersistenceImpl<ICD10>
	implements ICD10Persistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ICD10Util} to access the i c d10 persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ICD10Impl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
			ICD10ModelImpl.FINDER_CACHE_ENABLED, ICD10Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
			ICD10ModelImpl.FINDER_CACHE_ENABLED, ICD10Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
			ICD10ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE = new FinderPath(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
			ICD10ModelImpl.FINDER_CACHE_ENABLED, ICD10Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE = new FinderPath(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
			ICD10ModelImpl.FINDER_CACHE_ENABLED, ICD10Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCode",
			new String[] { String.class.getName() },
			ICD10ModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
			ICD10ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the i c d10s where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching i c d10s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ICD10> findByCode(String code) throws SystemException {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i c d10s where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.ICD10ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of i c d10s
	 * @param end the upper bound of the range of i c d10s (not inclusive)
	 * @return the range of matching i c d10s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ICD10> findByCode(String code, int start, int end)
		throws SystemException {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i c d10s where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.ICD10ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of i c d10s
	 * @param end the upper bound of the range of i c d10s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i c d10s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ICD10> findByCode(String code, int start, int end,
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

		List<ICD10> list = (List<ICD10>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ICD10 icd10 : list) {
				if (!Validator.equals(code, icd10.getCode())) {
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

			query.append(_SQL_SELECT_ICD10_WHERE);

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
				query.append(ICD10ModelImpl.ORDER_BY_JPQL);
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
					list = (List<ICD10>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ICD10>(list);
				}
				else {
					list = (List<ICD10>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first i c d10 in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i c d10
	 * @throws at.graz.meduni.liferay.NoSuchICD10Exception if a matching i c d10 could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICD10 findByCode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchICD10Exception, SystemException {
		ICD10 icd10 = fetchByCode_First(code, orderByComparator);

		if (icd10 != null) {
			return icd10;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchICD10Exception(msg.toString());
	}

	/**
	 * Returns the first i c d10 in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i c d10, or <code>null</code> if a matching i c d10 could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICD10 fetchByCode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ICD10> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i c d10 in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i c d10
	 * @throws at.graz.meduni.liferay.NoSuchICD10Exception if a matching i c d10 could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICD10 findByCode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchICD10Exception, SystemException {
		ICD10 icd10 = fetchByCode_Last(code, orderByComparator);

		if (icd10 != null) {
			return icd10;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchICD10Exception(msg.toString());
	}

	/**
	 * Returns the last i c d10 in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i c d10, or <code>null</code> if a matching i c d10 could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICD10 fetchByCode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<ICD10> list = findByCode(code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i c d10s before and after the current i c d10 in the ordered set where code = &#63;.
	 *
	 * @param id the primary key of the current i c d10
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i c d10
	 * @throws at.graz.meduni.liferay.NoSuchICD10Exception if a i c d10 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICD10[] findByCode_PrevAndNext(long id, String code,
		OrderByComparator orderByComparator)
		throws NoSuchICD10Exception, SystemException {
		ICD10 icd10 = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ICD10[] array = new ICD10Impl[3];

			array[0] = getByCode_PrevAndNext(session, icd10, code,
					orderByComparator, true);

			array[1] = icd10;

			array[2] = getByCode_PrevAndNext(session, icd10, code,
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

	protected ICD10 getByCode_PrevAndNext(Session session, ICD10 icd10,
		String code, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ICD10_WHERE);

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
			query.append(ICD10ModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(icd10);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ICD10> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i c d10s where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCode(String code) throws SystemException {
		for (ICD10 icd10 : findByCode(code, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(icd10);
		}
	}

	/**
	 * Returns the number of i c d10s where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching i c d10s
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

			query.append(_SQL_COUNT_ICD10_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "icd10.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "icd10.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(icd10.code IS NULL OR icd10.code = '')";

	public ICD10PersistenceImpl() {
		setModelClass(ICD10.class);
	}

	/**
	 * Caches the i c d10 in the entity cache if it is enabled.
	 *
	 * @param icd10 the i c d10
	 */
	@Override
	public void cacheResult(ICD10 icd10) {
		EntityCacheUtil.putResult(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
			ICD10Impl.class, icd10.getPrimaryKey(), icd10);

		icd10.resetOriginalValues();
	}

	/**
	 * Caches the i c d10s in the entity cache if it is enabled.
	 *
	 * @param icd10s the i c d10s
	 */
	@Override
	public void cacheResult(List<ICD10> icd10s) {
		for (ICD10 icd10 : icd10s) {
			if (EntityCacheUtil.getResult(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
						ICD10Impl.class, icd10.getPrimaryKey()) == null) {
				cacheResult(icd10);
			}
			else {
				icd10.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all i c d10s.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ICD10Impl.class.getName());
		}

		EntityCacheUtil.clearCache(ICD10Impl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the i c d10.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ICD10 icd10) {
		EntityCacheUtil.removeResult(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
			ICD10Impl.class, icd10.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ICD10> icd10s) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ICD10 icd10 : icd10s) {
			EntityCacheUtil.removeResult(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
				ICD10Impl.class, icd10.getPrimaryKey());
		}
	}

	/**
	 * Creates a new i c d10 with the primary key. Does not add the i c d10 to the database.
	 *
	 * @param id the primary key for the new i c d10
	 * @return the new i c d10
	 */
	@Override
	public ICD10 create(long id) {
		ICD10 icd10 = new ICD10Impl();

		icd10.setNew(true);
		icd10.setPrimaryKey(id);

		return icd10;
	}

	/**
	 * Removes the i c d10 with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the i c d10
	 * @return the i c d10 that was removed
	 * @throws at.graz.meduni.liferay.NoSuchICD10Exception if a i c d10 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICD10 remove(long id) throws NoSuchICD10Exception, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the i c d10 with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the i c d10
	 * @return the i c d10 that was removed
	 * @throws at.graz.meduni.liferay.NoSuchICD10Exception if a i c d10 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICD10 remove(Serializable primaryKey)
		throws NoSuchICD10Exception, SystemException {
		Session session = null;

		try {
			session = openSession();

			ICD10 icd10 = (ICD10)session.get(ICD10Impl.class, primaryKey);

			if (icd10 == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchICD10Exception(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(icd10);
		}
		catch (NoSuchICD10Exception nsee) {
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
	protected ICD10 removeImpl(ICD10 icd10) throws SystemException {
		icd10 = toUnwrappedModel(icd10);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(icd10)) {
				icd10 = (ICD10)session.get(ICD10Impl.class,
						icd10.getPrimaryKeyObj());
			}

			if (icd10 != null) {
				session.delete(icd10);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (icd10 != null) {
			clearCache(icd10);
		}

		return icd10;
	}

	@Override
	public ICD10 updateImpl(at.graz.meduni.liferay.model.ICD10 icd10)
		throws SystemException {
		icd10 = toUnwrappedModel(icd10);

		boolean isNew = icd10.isNew();

		ICD10ModelImpl icd10ModelImpl = (ICD10ModelImpl)icd10;

		Session session = null;

		try {
			session = openSession();

			if (icd10.isNew()) {
				session.save(icd10);

				icd10.setNew(false);
			}
			else {
				session.merge(icd10);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ICD10ModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((icd10ModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { icd10ModelImpl.getOriginalCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);

				args = new Object[] { icd10ModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);
			}
		}

		EntityCacheUtil.putResult(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
			ICD10Impl.class, icd10.getPrimaryKey(), icd10);

		return icd10;
	}

	protected ICD10 toUnwrappedModel(ICD10 icd10) {
		if (icd10 instanceof ICD10Impl) {
			return icd10;
		}

		ICD10Impl icd10Impl = new ICD10Impl();

		icd10Impl.setNew(icd10.isNew());
		icd10Impl.setPrimaryKey(icd10.getPrimaryKey());

		icd10Impl.setId(icd10.getId());
		icd10Impl.setCode(icd10.getCode());
		icd10Impl.setDescription(icd10.getDescription());
		icd10Impl.setINKLUSIVA(icd10.getINKLUSIVA());
		icd10Impl.setEXKLUSIVA(icd10.getEXKLUSIVA());
		icd10Impl.setTYPE(icd10.getTYPE());
		icd10Impl.setUSED(icd10.getUSED());
		icd10Impl.setFROM_CODE(icd10.getFROM_CODE());
		icd10Impl.setTO_CODE(icd10.getTO_CODE());

		return icd10Impl;
	}

	/**
	 * Returns the i c d10 with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the i c d10
	 * @return the i c d10
	 * @throws at.graz.meduni.liferay.NoSuchICD10Exception if a i c d10 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICD10 findByPrimaryKey(Serializable primaryKey)
		throws NoSuchICD10Exception, SystemException {
		ICD10 icd10 = fetchByPrimaryKey(primaryKey);

		if (icd10 == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchICD10Exception(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return icd10;
	}

	/**
	 * Returns the i c d10 with the primary key or throws a {@link at.graz.meduni.liferay.NoSuchICD10Exception} if it could not be found.
	 *
	 * @param id the primary key of the i c d10
	 * @return the i c d10
	 * @throws at.graz.meduni.liferay.NoSuchICD10Exception if a i c d10 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICD10 findByPrimaryKey(long id)
		throws NoSuchICD10Exception, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the i c d10 with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the i c d10
	 * @return the i c d10, or <code>null</code> if a i c d10 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICD10 fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ICD10 icd10 = (ICD10)EntityCacheUtil.getResult(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
				ICD10Impl.class, primaryKey);

		if (icd10 == _nullICD10) {
			return null;
		}

		if (icd10 == null) {
			Session session = null;

			try {
				session = openSession();

				icd10 = (ICD10)session.get(ICD10Impl.class, primaryKey);

				if (icd10 != null) {
					cacheResult(icd10);
				}
				else {
					EntityCacheUtil.putResult(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
						ICD10Impl.class, primaryKey, _nullICD10);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ICD10ModelImpl.ENTITY_CACHE_ENABLED,
					ICD10Impl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return icd10;
	}

	/**
	 * Returns the i c d10 with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the i c d10
	 * @return the i c d10, or <code>null</code> if a i c d10 with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ICD10 fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the i c d10s.
	 *
	 * @return the i c d10s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ICD10> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i c d10s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.ICD10ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of i c d10s
	 * @param end the upper bound of the range of i c d10s (not inclusive)
	 * @return the range of i c d10s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ICD10> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the i c d10s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.ICD10ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of i c d10s
	 * @param end the upper bound of the range of i c d10s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of i c d10s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ICD10> findAll(int start, int end,
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

		List<ICD10> list = (List<ICD10>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ICD10);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ICD10;

				if (pagination) {
					sql = sql.concat(ICD10ModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ICD10>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ICD10>(list);
				}
				else {
					list = (List<ICD10>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the i c d10s from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ICD10 icd10 : findAll()) {
			remove(icd10);
		}
	}

	/**
	 * Returns the number of i c d10s.
	 *
	 * @return the number of i c d10s
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

				Query q = session.createQuery(_SQL_COUNT_ICD10);

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
	 * Initializes the i c d10 persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.model.ICD10")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ICD10>> listenersList = new ArrayList<ModelListener<ICD10>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ICD10>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ICD10Impl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ICD10 = "SELECT icd10 FROM ICD10 icd10";
	private static final String _SQL_SELECT_ICD10_WHERE = "SELECT icd10 FROM ICD10 icd10 WHERE ";
	private static final String _SQL_COUNT_ICD10 = "SELECT COUNT(icd10) FROM ICD10 icd10";
	private static final String _SQL_COUNT_ICD10_WHERE = "SELECT COUNT(icd10) FROM ICD10 icd10 WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "icd10.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ICD10 exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ICD10 exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ICD10PersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "code"
			});
	private static ICD10 _nullICD10 = new ICD10Impl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ICD10> toCacheModel() {
				return _nullICD10CacheModel;
			}
		};

	private static CacheModel<ICD10> _nullICD10CacheModel = new CacheModel<ICD10>() {
			@Override
			public ICD10 toEntityModel() {
				return _nullICD10;
			}
		};
}