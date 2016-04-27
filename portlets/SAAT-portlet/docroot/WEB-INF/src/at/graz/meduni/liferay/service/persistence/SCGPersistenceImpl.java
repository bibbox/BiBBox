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

import at.graz.meduni.liferay.NoSuchSCGException;
import at.graz.meduni.liferay.model.SCG;
import at.graz.meduni.liferay.model.impl.SCGImpl;
import at.graz.meduni.liferay.model.impl.SCGModelImpl;

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
 * The persistence implementation for the s c g service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see SCGPersistence
 * @see SCGUtil
 * @generated
 */
public class SCGPersistenceImpl extends BasePersistenceImpl<SCG>
	implements SCGPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SCGUtil} to access the s c g persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SCGImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SCGModelImpl.ENTITY_CACHE_ENABLED,
			SCGModelImpl.FINDER_CACHE_ENABLED, SCGImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SCGModelImpl.ENTITY_CACHE_ENABLED,
			SCGModelImpl.FINDER_CACHE_ENABLED, SCGImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SCGModelImpl.ENTITY_CACHE_ENABLED,
			SCGModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE = new FinderPath(SCGModelImpl.ENTITY_CACHE_ENABLED,
			SCGModelImpl.FINDER_CACHE_ENABLED, SCGImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE = new FinderPath(SCGModelImpl.ENTITY_CACHE_ENABLED,
			SCGModelImpl.FINDER_CACHE_ENABLED, SCGImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCode",
			new String[] { String.class.getName() },
			SCGModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(SCGModelImpl.ENTITY_CACHE_ENABLED,
			SCGModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s c gs where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching s c gs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SCG> findByCode(String code) throws SystemException {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s c gs where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.SCGModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of s c gs
	 * @param end the upper bound of the range of s c gs (not inclusive)
	 * @return the range of matching s c gs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SCG> findByCode(String code, int start, int end)
		throws SystemException {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s c gs where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.SCGModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of s c gs
	 * @param end the upper bound of the range of s c gs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s c gs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SCG> findByCode(String code, int start, int end,
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

		List<SCG> list = (List<SCG>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SCG scg : list) {
				if (!Validator.equals(code, scg.getCode())) {
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

			query.append(_SQL_SELECT_SCG_WHERE);

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
				query.append(SCGModelImpl.ORDER_BY_JPQL);
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
					list = (List<SCG>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SCG>(list);
				}
				else {
					list = (List<SCG>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first s c g in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s c g
	 * @throws at.graz.meduni.liferay.NoSuchSCGException if a matching s c g could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SCG findByCode_First(String code, OrderByComparator orderByComparator)
		throws NoSuchSCGException, SystemException {
		SCG scg = fetchByCode_First(code, orderByComparator);

		if (scg != null) {
			return scg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSCGException(msg.toString());
	}

	/**
	 * Returns the first s c g in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s c g, or <code>null</code> if a matching s c g could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SCG fetchByCode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<SCG> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s c g in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s c g
	 * @throws at.graz.meduni.liferay.NoSuchSCGException if a matching s c g could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SCG findByCode_Last(String code, OrderByComparator orderByComparator)
		throws NoSuchSCGException, SystemException {
		SCG scg = fetchByCode_Last(code, orderByComparator);

		if (scg != null) {
			return scg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSCGException(msg.toString());
	}

	/**
	 * Returns the last s c g in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s c g, or <code>null</code> if a matching s c g could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SCG fetchByCode_Last(String code, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<SCG> list = findByCode(code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s c gs before and after the current s c g in the ordered set where code = &#63;.
	 *
	 * @param id the primary key of the current s c g
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s c g
	 * @throws at.graz.meduni.liferay.NoSuchSCGException if a s c g with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SCG[] findByCode_PrevAndNext(long id, String code,
		OrderByComparator orderByComparator)
		throws NoSuchSCGException, SystemException {
		SCG scg = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SCG[] array = new SCGImpl[3];

			array[0] = getByCode_PrevAndNext(session, scg, code,
					orderByComparator, true);

			array[1] = scg;

			array[2] = getByCode_PrevAndNext(session, scg, code,
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

	protected SCG getByCode_PrevAndNext(Session session, SCG scg, String code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCG_WHERE);

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
			query.append(SCGModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(scg);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SCG> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s c gs where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCode(String code) throws SystemException {
		for (SCG scg : findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(scg);
		}
	}

	/**
	 * Returns the number of s c gs where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching s c gs
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

			query.append(_SQL_COUNT_SCG_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "scg.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "scg.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(scg.code IS NULL OR scg.code = '')";

	public SCGPersistenceImpl() {
		setModelClass(SCG.class);
	}

	/**
	 * Caches the s c g in the entity cache if it is enabled.
	 *
	 * @param scg the s c g
	 */
	@Override
	public void cacheResult(SCG scg) {
		EntityCacheUtil.putResult(SCGModelImpl.ENTITY_CACHE_ENABLED,
			SCGImpl.class, scg.getPrimaryKey(), scg);

		scg.resetOriginalValues();
	}

	/**
	 * Caches the s c gs in the entity cache if it is enabled.
	 *
	 * @param scgs the s c gs
	 */
	@Override
	public void cacheResult(List<SCG> scgs) {
		for (SCG scg : scgs) {
			if (EntityCacheUtil.getResult(SCGModelImpl.ENTITY_CACHE_ENABLED,
						SCGImpl.class, scg.getPrimaryKey()) == null) {
				cacheResult(scg);
			}
			else {
				scg.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s c gs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SCGImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SCGImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s c g.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SCG scg) {
		EntityCacheUtil.removeResult(SCGModelImpl.ENTITY_CACHE_ENABLED,
			SCGImpl.class, scg.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SCG> scgs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SCG scg : scgs) {
			EntityCacheUtil.removeResult(SCGModelImpl.ENTITY_CACHE_ENABLED,
				SCGImpl.class, scg.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s c g with the primary key. Does not add the s c g to the database.
	 *
	 * @param id the primary key for the new s c g
	 * @return the new s c g
	 */
	@Override
	public SCG create(long id) {
		SCG scg = new SCGImpl();

		scg.setNew(true);
		scg.setPrimaryKey(id);

		return scg;
	}

	/**
	 * Removes the s c g with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the s c g
	 * @return the s c g that was removed
	 * @throws at.graz.meduni.liferay.NoSuchSCGException if a s c g with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SCG remove(long id) throws NoSuchSCGException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the s c g with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s c g
	 * @return the s c g that was removed
	 * @throws at.graz.meduni.liferay.NoSuchSCGException if a s c g with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SCG remove(Serializable primaryKey)
		throws NoSuchSCGException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SCG scg = (SCG)session.get(SCGImpl.class, primaryKey);

			if (scg == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSCGException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scg);
		}
		catch (NoSuchSCGException nsee) {
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
	protected SCG removeImpl(SCG scg) throws SystemException {
		scg = toUnwrappedModel(scg);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scg)) {
				scg = (SCG)session.get(SCGImpl.class, scg.getPrimaryKeyObj());
			}

			if (scg != null) {
				session.delete(scg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scg != null) {
			clearCache(scg);
		}

		return scg;
	}

	@Override
	public SCG updateImpl(at.graz.meduni.liferay.model.SCG scg)
		throws SystemException {
		scg = toUnwrappedModel(scg);

		boolean isNew = scg.isNew();

		SCGModelImpl scgModelImpl = (SCGModelImpl)scg;

		Session session = null;

		try {
			session = openSession();

			if (scg.isNew()) {
				session.save(scg);

				scg.setNew(false);
			}
			else {
				session.merge(scg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SCGModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((scgModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { scgModelImpl.getOriginalCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);

				args = new Object[] { scgModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);
			}
		}

		EntityCacheUtil.putResult(SCGModelImpl.ENTITY_CACHE_ENABLED,
			SCGImpl.class, scg.getPrimaryKey(), scg);

		return scg;
	}

	protected SCG toUnwrappedModel(SCG scg) {
		if (scg instanceof SCGImpl) {
			return scg;
		}

		SCGImpl scgImpl = new SCGImpl();

		scgImpl.setNew(scg.isNew());
		scgImpl.setPrimaryKey(scg.getPrimaryKey());

		scgImpl.setId(scg.getId());
		scgImpl.setCode(scg.getCode());
		scgImpl.setDescription(scg.getDescription());

		return scgImpl;
	}

	/**
	 * Returns the s c g with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s c g
	 * @return the s c g
	 * @throws at.graz.meduni.liferay.NoSuchSCGException if a s c g with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SCG findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSCGException, SystemException {
		SCG scg = fetchByPrimaryKey(primaryKey);

		if (scg == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSCGException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scg;
	}

	/**
	 * Returns the s c g with the primary key or throws a {@link at.graz.meduni.liferay.NoSuchSCGException} if it could not be found.
	 *
	 * @param id the primary key of the s c g
	 * @return the s c g
	 * @throws at.graz.meduni.liferay.NoSuchSCGException if a s c g with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SCG findByPrimaryKey(long id)
		throws NoSuchSCGException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the s c g with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s c g
	 * @return the s c g, or <code>null</code> if a s c g with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SCG fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SCG scg = (SCG)EntityCacheUtil.getResult(SCGModelImpl.ENTITY_CACHE_ENABLED,
				SCGImpl.class, primaryKey);

		if (scg == _nullSCG) {
			return null;
		}

		if (scg == null) {
			Session session = null;

			try {
				session = openSession();

				scg = (SCG)session.get(SCGImpl.class, primaryKey);

				if (scg != null) {
					cacheResult(scg);
				}
				else {
					EntityCacheUtil.putResult(SCGModelImpl.ENTITY_CACHE_ENABLED,
						SCGImpl.class, primaryKey, _nullSCG);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SCGModelImpl.ENTITY_CACHE_ENABLED,
					SCGImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scg;
	}

	/**
	 * Returns the s c g with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the s c g
	 * @return the s c g, or <code>null</code> if a s c g with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SCG fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the s c gs.
	 *
	 * @return the s c gs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SCG> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s c gs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.SCGModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s c gs
	 * @param end the upper bound of the range of s c gs (not inclusive)
	 * @return the range of s c gs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SCG> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s c gs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.SCGModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s c gs
	 * @param end the upper bound of the range of s c gs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s c gs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SCG> findAll(int start, int end,
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

		List<SCG> list = (List<SCG>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCG;

				if (pagination) {
					sql = sql.concat(SCGModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SCG>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SCG>(list);
				}
				else {
					list = (List<SCG>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the s c gs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SCG scg : findAll()) {
			remove(scg);
		}
	}

	/**
	 * Returns the number of s c gs.
	 *
	 * @return the number of s c gs
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

				Query q = session.createQuery(_SQL_COUNT_SCG);

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
	 * Initializes the s c g persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.model.SCG")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SCG>> listenersList = new ArrayList<ModelListener<SCG>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SCG>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SCGImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SCG = "SELECT scg FROM SCG scg";
	private static final String _SQL_SELECT_SCG_WHERE = "SELECT scg FROM SCG scg WHERE ";
	private static final String _SQL_COUNT_SCG = "SELECT COUNT(scg) FROM SCG scg";
	private static final String _SQL_COUNT_SCG_WHERE = "SELECT COUNT(scg) FROM SCG scg WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scg.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SCG exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SCG exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SCGPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "code"
			});
	private static SCG _nullSCG = new SCGImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SCG> toCacheModel() {
				return _nullSCGCacheModel;
			}
		};

	private static CacheModel<SCG> _nullSCGCacheModel = new CacheModel<SCG>() {
			@Override
			public SCG toEntityModel() {
				return _nullSCG;
			}
		};
}