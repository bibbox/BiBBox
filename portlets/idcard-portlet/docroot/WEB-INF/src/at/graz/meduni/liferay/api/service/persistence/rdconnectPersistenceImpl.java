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

package at.graz.meduni.liferay.api.service.persistence;

import at.graz.meduni.liferay.api.NoSuchrdconnectException;
import at.graz.meduni.liferay.api.model.impl.rdconnectImpl;
import at.graz.meduni.liferay.api.model.impl.rdconnectModelImpl;
import at.graz.meduni.liferay.api.model.rdconnect;

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
 * The persistence implementation for the rdconnect service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see rdconnectPersistence
 * @see rdconnectUtil
 * @generated
 */
public class rdconnectPersistenceImpl extends BasePersistenceImpl<rdconnect>
	implements rdconnectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link rdconnectUtil} to access the rdconnect persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = rdconnectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
			rdconnectModelImpl.FINDER_CACHE_ENABLED, rdconnectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
			rdconnectModelImpl.FINDER_CACHE_ENABLED, rdconnectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
			rdconnectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
			rdconnectModelImpl.FINDER_CACHE_ENABLED, rdconnectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
			rdconnectModelImpl.FINDER_CACHE_ENABLED, rdconnectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			rdconnectModelImpl.USERID_COLUMN_BITMASK |
			rdconnectModelImpl.ACCESSDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
			rdconnectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the rdconnects where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching rdconnects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<rdconnect> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rdconnects where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.api.model.impl.rdconnectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of rdconnects
	 * @param end the upper bound of the range of rdconnects (not inclusive)
	 * @return the range of matching rdconnects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<rdconnect> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rdconnects where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.api.model.impl.rdconnectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of rdconnects
	 * @param end the upper bound of the range of rdconnects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rdconnects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<rdconnect> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<rdconnect> list = (List<rdconnect>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (rdconnect rdconnect : list) {
				if ((userId != rdconnect.getUserId())) {
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

			query.append(_SQL_SELECT_RDCONNECT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(rdconnectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<rdconnect>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<rdconnect>(list);
				}
				else {
					list = (List<rdconnect>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rdconnect in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rdconnect
	 * @throws at.graz.meduni.liferay.api.NoSuchrdconnectException if a matching rdconnect could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public rdconnect findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchrdconnectException, SystemException {
		rdconnect rdconnect = fetchByUserId_First(userId, orderByComparator);

		if (rdconnect != null) {
			return rdconnect;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchrdconnectException(msg.toString());
	}

	/**
	 * Returns the first rdconnect in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rdconnect, or <code>null</code> if a matching rdconnect could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public rdconnect fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<rdconnect> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rdconnect in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rdconnect
	 * @throws at.graz.meduni.liferay.api.NoSuchrdconnectException if a matching rdconnect could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public rdconnect findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchrdconnectException, SystemException {
		rdconnect rdconnect = fetchByUserId_Last(userId, orderByComparator);

		if (rdconnect != null) {
			return rdconnect;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchrdconnectException(msg.toString());
	}

	/**
	 * Returns the last rdconnect in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rdconnect, or <code>null</code> if a matching rdconnect could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public rdconnect fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<rdconnect> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rdconnects before and after the current rdconnect in the ordered set where userId = &#63;.
	 *
	 * @param idcardapilogId the primary key of the current rdconnect
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rdconnect
	 * @throws at.graz.meduni.liferay.api.NoSuchrdconnectException if a rdconnect with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public rdconnect[] findByUserId_PrevAndNext(long idcardapilogId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchrdconnectException, SystemException {
		rdconnect rdconnect = findByPrimaryKey(idcardapilogId);

		Session session = null;

		try {
			session = openSession();

			rdconnect[] array = new rdconnectImpl[3];

			array[0] = getByUserId_PrevAndNext(session, rdconnect, userId,
					orderByComparator, true);

			array[1] = rdconnect;

			array[2] = getByUserId_PrevAndNext(session, rdconnect, userId,
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

	protected rdconnect getByUserId_PrevAndNext(Session session,
		rdconnect rdconnect, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RDCONNECT_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(rdconnectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rdconnect);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<rdconnect> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rdconnects where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (rdconnect rdconnect : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rdconnect);
		}
	}

	/**
	 * Returns the number of rdconnects where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching rdconnects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RDCONNECT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "rdconnect.userId = ?";

	public rdconnectPersistenceImpl() {
		setModelClass(rdconnect.class);
	}

	/**
	 * Caches the rdconnect in the entity cache if it is enabled.
	 *
	 * @param rdconnect the rdconnect
	 */
	@Override
	public void cacheResult(rdconnect rdconnect) {
		EntityCacheUtil.putResult(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
			rdconnectImpl.class, rdconnect.getPrimaryKey(), rdconnect);

		rdconnect.resetOriginalValues();
	}

	/**
	 * Caches the rdconnects in the entity cache if it is enabled.
	 *
	 * @param rdconnects the rdconnects
	 */
	@Override
	public void cacheResult(List<rdconnect> rdconnects) {
		for (rdconnect rdconnect : rdconnects) {
			if (EntityCacheUtil.getResult(
						rdconnectModelImpl.ENTITY_CACHE_ENABLED,
						rdconnectImpl.class, rdconnect.getPrimaryKey()) == null) {
				cacheResult(rdconnect);
			}
			else {
				rdconnect.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rdconnects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(rdconnectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(rdconnectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rdconnect.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(rdconnect rdconnect) {
		EntityCacheUtil.removeResult(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
			rdconnectImpl.class, rdconnect.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<rdconnect> rdconnects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (rdconnect rdconnect : rdconnects) {
			EntityCacheUtil.removeResult(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
				rdconnectImpl.class, rdconnect.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rdconnect with the primary key. Does not add the rdconnect to the database.
	 *
	 * @param idcardapilogId the primary key for the new rdconnect
	 * @return the new rdconnect
	 */
	@Override
	public rdconnect create(long idcardapilogId) {
		rdconnect rdconnect = new rdconnectImpl();

		rdconnect.setNew(true);
		rdconnect.setPrimaryKey(idcardapilogId);

		return rdconnect;
	}

	/**
	 * Removes the rdconnect with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idcardapilogId the primary key of the rdconnect
	 * @return the rdconnect that was removed
	 * @throws at.graz.meduni.liferay.api.NoSuchrdconnectException if a rdconnect with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public rdconnect remove(long idcardapilogId)
		throws NoSuchrdconnectException, SystemException {
		return remove((Serializable)idcardapilogId);
	}

	/**
	 * Removes the rdconnect with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rdconnect
	 * @return the rdconnect that was removed
	 * @throws at.graz.meduni.liferay.api.NoSuchrdconnectException if a rdconnect with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public rdconnect remove(Serializable primaryKey)
		throws NoSuchrdconnectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			rdconnect rdconnect = (rdconnect)session.get(rdconnectImpl.class,
					primaryKey);

			if (rdconnect == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchrdconnectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rdconnect);
		}
		catch (NoSuchrdconnectException nsee) {
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
	protected rdconnect removeImpl(rdconnect rdconnect)
		throws SystemException {
		rdconnect = toUnwrappedModel(rdconnect);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rdconnect)) {
				rdconnect = (rdconnect)session.get(rdconnectImpl.class,
						rdconnect.getPrimaryKeyObj());
			}

			if (rdconnect != null) {
				session.delete(rdconnect);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rdconnect != null) {
			clearCache(rdconnect);
		}

		return rdconnect;
	}

	@Override
	public rdconnect updateImpl(
		at.graz.meduni.liferay.api.model.rdconnect rdconnect)
		throws SystemException {
		rdconnect = toUnwrappedModel(rdconnect);

		boolean isNew = rdconnect.isNew();

		rdconnectModelImpl rdconnectModelImpl = (rdconnectModelImpl)rdconnect;

		Session session = null;

		try {
			session = openSession();

			if (rdconnect.isNew()) {
				session.save(rdconnect);

				rdconnect.setNew(false);
			}
			else {
				session.merge(rdconnect);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !rdconnectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rdconnectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rdconnectModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { rdconnectModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
			rdconnectImpl.class, rdconnect.getPrimaryKey(), rdconnect);

		return rdconnect;
	}

	protected rdconnect toUnwrappedModel(rdconnect rdconnect) {
		if (rdconnect instanceof rdconnectImpl) {
			return rdconnect;
		}

		rdconnectImpl rdconnectImpl = new rdconnectImpl();

		rdconnectImpl.setNew(rdconnect.isNew());
		rdconnectImpl.setPrimaryKey(rdconnect.getPrimaryKey());

		rdconnectImpl.setIdcardapilogId(rdconnect.getIdcardapilogId());
		rdconnectImpl.setUserId(rdconnect.getUserId());
		rdconnectImpl.setIpaddress(rdconnect.getIpaddress());
		rdconnectImpl.setAccessDate(rdconnect.getAccessDate());
		rdconnectImpl.setRequestparameter(rdconnect.getRequestparameter());

		return rdconnectImpl;
	}

	/**
	 * Returns the rdconnect with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rdconnect
	 * @return the rdconnect
	 * @throws at.graz.meduni.liferay.api.NoSuchrdconnectException if a rdconnect with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public rdconnect findByPrimaryKey(Serializable primaryKey)
		throws NoSuchrdconnectException, SystemException {
		rdconnect rdconnect = fetchByPrimaryKey(primaryKey);

		if (rdconnect == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchrdconnectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rdconnect;
	}

	/**
	 * Returns the rdconnect with the primary key or throws a {@link at.graz.meduni.liferay.api.NoSuchrdconnectException} if it could not be found.
	 *
	 * @param idcardapilogId the primary key of the rdconnect
	 * @return the rdconnect
	 * @throws at.graz.meduni.liferay.api.NoSuchrdconnectException if a rdconnect with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public rdconnect findByPrimaryKey(long idcardapilogId)
		throws NoSuchrdconnectException, SystemException {
		return findByPrimaryKey((Serializable)idcardapilogId);
	}

	/**
	 * Returns the rdconnect with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rdconnect
	 * @return the rdconnect, or <code>null</code> if a rdconnect with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public rdconnect fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		rdconnect rdconnect = (rdconnect)EntityCacheUtil.getResult(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
				rdconnectImpl.class, primaryKey);

		if (rdconnect == _nullrdconnect) {
			return null;
		}

		if (rdconnect == null) {
			Session session = null;

			try {
				session = openSession();

				rdconnect = (rdconnect)session.get(rdconnectImpl.class,
						primaryKey);

				if (rdconnect != null) {
					cacheResult(rdconnect);
				}
				else {
					EntityCacheUtil.putResult(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
						rdconnectImpl.class, primaryKey, _nullrdconnect);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(rdconnectModelImpl.ENTITY_CACHE_ENABLED,
					rdconnectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rdconnect;
	}

	/**
	 * Returns the rdconnect with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idcardapilogId the primary key of the rdconnect
	 * @return the rdconnect, or <code>null</code> if a rdconnect with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public rdconnect fetchByPrimaryKey(long idcardapilogId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)idcardapilogId);
	}

	/**
	 * Returns all the rdconnects.
	 *
	 * @return the rdconnects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<rdconnect> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rdconnects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.api.model.impl.rdconnectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rdconnects
	 * @param end the upper bound of the range of rdconnects (not inclusive)
	 * @return the range of rdconnects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<rdconnect> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rdconnects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.api.model.impl.rdconnectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rdconnects
	 * @param end the upper bound of the range of rdconnects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rdconnects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<rdconnect> findAll(int start, int end,
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

		List<rdconnect> list = (List<rdconnect>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RDCONNECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RDCONNECT;

				if (pagination) {
					sql = sql.concat(rdconnectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<rdconnect>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<rdconnect>(list);
				}
				else {
					list = (List<rdconnect>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rdconnects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (rdconnect rdconnect : findAll()) {
			remove(rdconnect);
		}
	}

	/**
	 * Returns the number of rdconnects.
	 *
	 * @return the number of rdconnects
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

				Query q = session.createQuery(_SQL_COUNT_RDCONNECT);

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
	 * Initializes the rdconnect persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.api.model.rdconnect")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<rdconnect>> listenersList = new ArrayList<ModelListener<rdconnect>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<rdconnect>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(rdconnectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RDCONNECT = "SELECT rdconnect FROM rdconnect rdconnect";
	private static final String _SQL_SELECT_RDCONNECT_WHERE = "SELECT rdconnect FROM rdconnect rdconnect WHERE ";
	private static final String _SQL_COUNT_RDCONNECT = "SELECT COUNT(rdconnect) FROM rdconnect rdconnect";
	private static final String _SQL_COUNT_RDCONNECT_WHERE = "SELECT COUNT(rdconnect) FROM rdconnect rdconnect WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rdconnect.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No rdconnect exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No rdconnect exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(rdconnectPersistenceImpl.class);
	private static rdconnect _nullrdconnect = new rdconnectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<rdconnect> toCacheModel() {
				return _nullrdconnectCacheModel;
			}
		};

	private static CacheModel<rdconnect> _nullrdconnectCacheModel = new CacheModel<rdconnect>() {
			@Override
			public rdconnect toEntityModel() {
				return _nullrdconnect;
			}
		};
}