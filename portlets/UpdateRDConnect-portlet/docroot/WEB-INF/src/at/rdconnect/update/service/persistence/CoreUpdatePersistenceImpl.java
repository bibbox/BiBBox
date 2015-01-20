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

package at.rdconnect.update.service.persistence;

import at.rdconnect.update.NoSuchCoreUpdateException;
import at.rdconnect.update.model.CoreUpdate;
import at.rdconnect.update.model.impl.CoreUpdateImpl;
import at.rdconnect.update.model.impl.CoreUpdateModelImpl;

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
 * The persistence implementation for the core update service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see CoreUpdatePersistence
 * @see CoreUpdateUtil
 * @generated
 */
public class CoreUpdatePersistenceImpl extends BasePersistenceImpl<CoreUpdate>
	implements CoreUpdatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CoreUpdateUtil} to access the core update persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CoreUpdateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
			CoreUpdateModelImpl.FINDER_CACHE_ENABLED, CoreUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
			CoreUpdateModelImpl.FINDER_CACHE_ENABLED, CoreUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
			CoreUpdateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
			CoreUpdateModelImpl.FINDER_CACHE_ENABLED, CoreUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
			CoreUpdateModelImpl.FINDER_CACHE_ENABLED, CoreUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] { Long.class.getName() },
			CoreUpdateModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
			CoreUpdateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the core updates where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @return the matching core updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoreUpdate> findByOrganizationId(long organizationid)
		throws SystemException {
		return findByOrganizationId(organizationid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the core updates where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.CoreUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of core updates
	 * @param end the upper bound of the range of core updates (not inclusive)
	 * @return the range of matching core updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoreUpdate> findByOrganizationId(long organizationid,
		int start, int end) throws SystemException {
		return findByOrganizationId(organizationid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the core updates where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.CoreUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of core updates
	 * @param end the upper bound of the range of core updates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching core updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoreUpdate> findByOrganizationId(long organizationid,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] { organizationid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] {
					organizationid,
					
					start, end, orderByComparator
				};
		}

		List<CoreUpdate> list = (List<CoreUpdate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CoreUpdate coreUpdate : list) {
				if ((organizationid != coreUpdate.getOrganizationid())) {
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

			query.append(_SQL_SELECT_COREUPDATE_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CoreUpdateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationid);

				if (!pagination) {
					list = (List<CoreUpdate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CoreUpdate>(list);
				}
				else {
					list = (List<CoreUpdate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first core update in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching core update
	 * @throws at.rdconnect.update.NoSuchCoreUpdateException if a matching core update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoreUpdate findByOrganizationId_First(long organizationid,
		OrderByComparator orderByComparator)
		throws NoSuchCoreUpdateException, SystemException {
		CoreUpdate coreUpdate = fetchByOrganizationId_First(organizationid,
				orderByComparator);

		if (coreUpdate != null) {
			return coreUpdate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationid=");
		msg.append(organizationid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoreUpdateException(msg.toString());
	}

	/**
	 * Returns the first core update in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching core update, or <code>null</code> if a matching core update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoreUpdate fetchByOrganizationId_First(long organizationid,
		OrderByComparator orderByComparator) throws SystemException {
		List<CoreUpdate> list = findByOrganizationId(organizationid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last core update in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching core update
	 * @throws at.rdconnect.update.NoSuchCoreUpdateException if a matching core update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoreUpdate findByOrganizationId_Last(long organizationid,
		OrderByComparator orderByComparator)
		throws NoSuchCoreUpdateException, SystemException {
		CoreUpdate coreUpdate = fetchByOrganizationId_Last(organizationid,
				orderByComparator);

		if (coreUpdate != null) {
			return coreUpdate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationid=");
		msg.append(organizationid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoreUpdateException(msg.toString());
	}

	/**
	 * Returns the last core update in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching core update, or <code>null</code> if a matching core update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoreUpdate fetchByOrganizationId_Last(long organizationid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(organizationid);

		if (count == 0) {
			return null;
		}

		List<CoreUpdate> list = findByOrganizationId(organizationid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the core updates before and after the current core update in the ordered set where organizationid = &#63;.
	 *
	 * @param coreid the primary key of the current core update
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next core update
	 * @throws at.rdconnect.update.NoSuchCoreUpdateException if a core update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoreUpdate[] findByOrganizationId_PrevAndNext(long coreid,
		long organizationid, OrderByComparator orderByComparator)
		throws NoSuchCoreUpdateException, SystemException {
		CoreUpdate coreUpdate = findByPrimaryKey(coreid);

		Session session = null;

		try {
			session = openSession();

			CoreUpdate[] array = new CoreUpdateImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session, coreUpdate,
					organizationid, orderByComparator, true);

			array[1] = coreUpdate;

			array[2] = getByOrganizationId_PrevAndNext(session, coreUpdate,
					organizationid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CoreUpdate getByOrganizationId_PrevAndNext(Session session,
		CoreUpdate coreUpdate, long organizationid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COREUPDATE_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

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
			query.append(CoreUpdateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationid);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(coreUpdate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CoreUpdate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the core updates where organizationid = &#63; from the database.
	 *
	 * @param organizationid the organizationid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organizationid)
		throws SystemException {
		for (CoreUpdate coreUpdate : findByOrganizationId(organizationid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(coreUpdate);
		}
	}

	/**
	 * Returns the number of core updates where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @return the number of matching core updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationId(long organizationid)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { organizationid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COREUPDATE_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationid);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "coreUpdate.organizationid = ?";

	public CoreUpdatePersistenceImpl() {
		setModelClass(CoreUpdate.class);
	}

	/**
	 * Caches the core update in the entity cache if it is enabled.
	 *
	 * @param coreUpdate the core update
	 */
	@Override
	public void cacheResult(CoreUpdate coreUpdate) {
		EntityCacheUtil.putResult(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
			CoreUpdateImpl.class, coreUpdate.getPrimaryKey(), coreUpdate);

		coreUpdate.resetOriginalValues();
	}

	/**
	 * Caches the core updates in the entity cache if it is enabled.
	 *
	 * @param coreUpdates the core updates
	 */
	@Override
	public void cacheResult(List<CoreUpdate> coreUpdates) {
		for (CoreUpdate coreUpdate : coreUpdates) {
			if (EntityCacheUtil.getResult(
						CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
						CoreUpdateImpl.class, coreUpdate.getPrimaryKey()) == null) {
				cacheResult(coreUpdate);
			}
			else {
				coreUpdate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all core updates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CoreUpdateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CoreUpdateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the core update.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CoreUpdate coreUpdate) {
		EntityCacheUtil.removeResult(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
			CoreUpdateImpl.class, coreUpdate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CoreUpdate> coreUpdates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CoreUpdate coreUpdate : coreUpdates) {
			EntityCacheUtil.removeResult(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
				CoreUpdateImpl.class, coreUpdate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new core update with the primary key. Does not add the core update to the database.
	 *
	 * @param coreid the primary key for the new core update
	 * @return the new core update
	 */
	@Override
	public CoreUpdate create(long coreid) {
		CoreUpdate coreUpdate = new CoreUpdateImpl();

		coreUpdate.setNew(true);
		coreUpdate.setPrimaryKey(coreid);

		return coreUpdate;
	}

	/**
	 * Removes the core update with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coreid the primary key of the core update
	 * @return the core update that was removed
	 * @throws at.rdconnect.update.NoSuchCoreUpdateException if a core update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoreUpdate remove(long coreid)
		throws NoSuchCoreUpdateException, SystemException {
		return remove((Serializable)coreid);
	}

	/**
	 * Removes the core update with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the core update
	 * @return the core update that was removed
	 * @throws at.rdconnect.update.NoSuchCoreUpdateException if a core update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoreUpdate remove(Serializable primaryKey)
		throws NoSuchCoreUpdateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CoreUpdate coreUpdate = (CoreUpdate)session.get(CoreUpdateImpl.class,
					primaryKey);

			if (coreUpdate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCoreUpdateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(coreUpdate);
		}
		catch (NoSuchCoreUpdateException nsee) {
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
	protected CoreUpdate removeImpl(CoreUpdate coreUpdate)
		throws SystemException {
		coreUpdate = toUnwrappedModel(coreUpdate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(coreUpdate)) {
				coreUpdate = (CoreUpdate)session.get(CoreUpdateImpl.class,
						coreUpdate.getPrimaryKeyObj());
			}

			if (coreUpdate != null) {
				session.delete(coreUpdate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (coreUpdate != null) {
			clearCache(coreUpdate);
		}

		return coreUpdate;
	}

	@Override
	public CoreUpdate updateImpl(
		at.rdconnect.update.model.CoreUpdate coreUpdate)
		throws SystemException {
		coreUpdate = toUnwrappedModel(coreUpdate);

		boolean isNew = coreUpdate.isNew();

		CoreUpdateModelImpl coreUpdateModelImpl = (CoreUpdateModelImpl)coreUpdate;

		Session session = null;

		try {
			session = openSession();

			if (coreUpdate.isNew()) {
				session.save(coreUpdate);

				coreUpdate.setNew(false);
			}
			else {
				session.merge(coreUpdate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CoreUpdateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((coreUpdateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						coreUpdateModelImpl.getOriginalOrganizationid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] { coreUpdateModelImpl.getOrganizationid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
			CoreUpdateImpl.class, coreUpdate.getPrimaryKey(), coreUpdate);

		return coreUpdate;
	}

	protected CoreUpdate toUnwrappedModel(CoreUpdate coreUpdate) {
		if (coreUpdate instanceof CoreUpdateImpl) {
			return coreUpdate;
		}

		CoreUpdateImpl coreUpdateImpl = new CoreUpdateImpl();

		coreUpdateImpl.setNew(coreUpdate.isNew());
		coreUpdateImpl.setPrimaryKey(coreUpdate.getPrimaryKey());

		coreUpdateImpl.setCoreid(coreUpdate.getCoreid());
		coreUpdateImpl.setOrganizationid(coreUpdate.getOrganizationid());
		coreUpdateImpl.setFieldname(coreUpdate.getFieldname());
		coreUpdateImpl.setValue(coreUpdate.getValue());

		return coreUpdateImpl;
	}

	/**
	 * Returns the core update with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the core update
	 * @return the core update
	 * @throws at.rdconnect.update.NoSuchCoreUpdateException if a core update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoreUpdate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCoreUpdateException, SystemException {
		CoreUpdate coreUpdate = fetchByPrimaryKey(primaryKey);

		if (coreUpdate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCoreUpdateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return coreUpdate;
	}

	/**
	 * Returns the core update with the primary key or throws a {@link at.rdconnect.update.NoSuchCoreUpdateException} if it could not be found.
	 *
	 * @param coreid the primary key of the core update
	 * @return the core update
	 * @throws at.rdconnect.update.NoSuchCoreUpdateException if a core update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoreUpdate findByPrimaryKey(long coreid)
		throws NoSuchCoreUpdateException, SystemException {
		return findByPrimaryKey((Serializable)coreid);
	}

	/**
	 * Returns the core update with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the core update
	 * @return the core update, or <code>null</code> if a core update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoreUpdate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CoreUpdate coreUpdate = (CoreUpdate)EntityCacheUtil.getResult(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
				CoreUpdateImpl.class, primaryKey);

		if (coreUpdate == _nullCoreUpdate) {
			return null;
		}

		if (coreUpdate == null) {
			Session session = null;

			try {
				session = openSession();

				coreUpdate = (CoreUpdate)session.get(CoreUpdateImpl.class,
						primaryKey);

				if (coreUpdate != null) {
					cacheResult(coreUpdate);
				}
				else {
					EntityCacheUtil.putResult(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
						CoreUpdateImpl.class, primaryKey, _nullCoreUpdate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CoreUpdateModelImpl.ENTITY_CACHE_ENABLED,
					CoreUpdateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return coreUpdate;
	}

	/**
	 * Returns the core update with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coreid the primary key of the core update
	 * @return the core update, or <code>null</code> if a core update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoreUpdate fetchByPrimaryKey(long coreid) throws SystemException {
		return fetchByPrimaryKey((Serializable)coreid);
	}

	/**
	 * Returns all the core updates.
	 *
	 * @return the core updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoreUpdate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the core updates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.CoreUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of core updates
	 * @param end the upper bound of the range of core updates (not inclusive)
	 * @return the range of core updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoreUpdate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the core updates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.CoreUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of core updates
	 * @param end the upper bound of the range of core updates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of core updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CoreUpdate> findAll(int start, int end,
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

		List<CoreUpdate> list = (List<CoreUpdate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COREUPDATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COREUPDATE;

				if (pagination) {
					sql = sql.concat(CoreUpdateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CoreUpdate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CoreUpdate>(list);
				}
				else {
					list = (List<CoreUpdate>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the core updates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CoreUpdate coreUpdate : findAll()) {
			remove(coreUpdate);
		}
	}

	/**
	 * Returns the number of core updates.
	 *
	 * @return the number of core updates
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

				Query q = session.createQuery(_SQL_COUNT_COREUPDATE);

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
	 * Initializes the core update persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.rdconnect.update.model.CoreUpdate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CoreUpdate>> listenersList = new ArrayList<ModelListener<CoreUpdate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CoreUpdate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CoreUpdateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COREUPDATE = "SELECT coreUpdate FROM CoreUpdate coreUpdate";
	private static final String _SQL_SELECT_COREUPDATE_WHERE = "SELECT coreUpdate FROM CoreUpdate coreUpdate WHERE ";
	private static final String _SQL_COUNT_COREUPDATE = "SELECT COUNT(coreUpdate) FROM CoreUpdate coreUpdate";
	private static final String _SQL_COUNT_COREUPDATE_WHERE = "SELECT COUNT(coreUpdate) FROM CoreUpdate coreUpdate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "coreUpdate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CoreUpdate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CoreUpdate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CoreUpdatePersistenceImpl.class);
	private static CoreUpdate _nullCoreUpdate = new CoreUpdateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CoreUpdate> toCacheModel() {
				return _nullCoreUpdateCacheModel;
			}
		};

	private static CacheModel<CoreUpdate> _nullCoreUpdateCacheModel = new CacheModel<CoreUpdate>() {
			@Override
			public CoreUpdate toEntityModel() {
				return _nullCoreUpdate;
			}
		};
}