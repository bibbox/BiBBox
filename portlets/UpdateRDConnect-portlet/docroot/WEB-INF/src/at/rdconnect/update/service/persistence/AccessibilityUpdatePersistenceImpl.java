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

import at.rdconnect.update.NoSuchAccessibilityUpdateException;
import at.rdconnect.update.model.AccessibilityUpdate;
import at.rdconnect.update.model.impl.AccessibilityUpdateImpl;
import at.rdconnect.update.model.impl.AccessibilityUpdateModelImpl;

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
 * The persistence implementation for the accessibility update service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see AccessibilityUpdatePersistence
 * @see AccessibilityUpdateUtil
 * @generated
 */
public class AccessibilityUpdatePersistenceImpl extends BasePersistenceImpl<AccessibilityUpdate>
	implements AccessibilityUpdatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AccessibilityUpdateUtil} to access the accessibility update persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AccessibilityUpdateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AccessibilityUpdateModelImpl.FINDER_CACHE_ENABLED,
			AccessibilityUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AccessibilityUpdateModelImpl.FINDER_CACHE_ENABLED,
			AccessibilityUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AccessibilityUpdateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AccessibilityUpdateModelImpl.FINDER_CACHE_ENABLED,
			AccessibilityUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AccessibilityUpdateModelImpl.FINDER_CACHE_ENABLED,
			AccessibilityUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] { Long.class.getName() },
			AccessibilityUpdateModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AccessibilityUpdateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the accessibility updates where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @return the matching accessibility updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AccessibilityUpdate> findByOrganizationId(long organizationid)
		throws SystemException {
		return findByOrganizationId(organizationid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the accessibility updates where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.AccessibilityUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of accessibility updates
	 * @param end the upper bound of the range of accessibility updates (not inclusive)
	 * @return the range of matching accessibility updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AccessibilityUpdate> findByOrganizationId(long organizationid,
		int start, int end) throws SystemException {
		return findByOrganizationId(organizationid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the accessibility updates where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.AccessibilityUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of accessibility updates
	 * @param end the upper bound of the range of accessibility updates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accessibility updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AccessibilityUpdate> findByOrganizationId(long organizationid,
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

		List<AccessibilityUpdate> list = (List<AccessibilityUpdate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AccessibilityUpdate accessibilityUpdate : list) {
				if ((organizationid != accessibilityUpdate.getOrganizationid())) {
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

			query.append(_SQL_SELECT_ACCESSIBILITYUPDATE_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AccessibilityUpdateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationid);

				if (!pagination) {
					list = (List<AccessibilityUpdate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AccessibilityUpdate>(list);
				}
				else {
					list = (List<AccessibilityUpdate>)QueryUtil.list(q,
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
	 * Returns the first accessibility update in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching accessibility update
	 * @throws at.rdconnect.update.NoSuchAccessibilityUpdateException if a matching accessibility update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AccessibilityUpdate findByOrganizationId_First(long organizationid,
		OrderByComparator orderByComparator)
		throws NoSuchAccessibilityUpdateException, SystemException {
		AccessibilityUpdate accessibilityUpdate = fetchByOrganizationId_First(organizationid,
				orderByComparator);

		if (accessibilityUpdate != null) {
			return accessibilityUpdate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationid=");
		msg.append(organizationid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAccessibilityUpdateException(msg.toString());
	}

	/**
	 * Returns the first accessibility update in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching accessibility update, or <code>null</code> if a matching accessibility update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AccessibilityUpdate fetchByOrganizationId_First(
		long organizationid, OrderByComparator orderByComparator)
		throws SystemException {
		List<AccessibilityUpdate> list = findByOrganizationId(organizationid,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last accessibility update in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching accessibility update
	 * @throws at.rdconnect.update.NoSuchAccessibilityUpdateException if a matching accessibility update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AccessibilityUpdate findByOrganizationId_Last(long organizationid,
		OrderByComparator orderByComparator)
		throws NoSuchAccessibilityUpdateException, SystemException {
		AccessibilityUpdate accessibilityUpdate = fetchByOrganizationId_Last(organizationid,
				orderByComparator);

		if (accessibilityUpdate != null) {
			return accessibilityUpdate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationid=");
		msg.append(organizationid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAccessibilityUpdateException(msg.toString());
	}

	/**
	 * Returns the last accessibility update in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching accessibility update, or <code>null</code> if a matching accessibility update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AccessibilityUpdate fetchByOrganizationId_Last(long organizationid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(organizationid);

		if (count == 0) {
			return null;
		}

		List<AccessibilityUpdate> list = findByOrganizationId(organizationid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the accessibility updates before and after the current accessibility update in the ordered set where organizationid = &#63;.
	 *
	 * @param coreid the primary key of the current accessibility update
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next accessibility update
	 * @throws at.rdconnect.update.NoSuchAccessibilityUpdateException if a accessibility update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AccessibilityUpdate[] findByOrganizationId_PrevAndNext(long coreid,
		long organizationid, OrderByComparator orderByComparator)
		throws NoSuchAccessibilityUpdateException, SystemException {
		AccessibilityUpdate accessibilityUpdate = findByPrimaryKey(coreid);

		Session session = null;

		try {
			session = openSession();

			AccessibilityUpdate[] array = new AccessibilityUpdateImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session,
					accessibilityUpdate, organizationid, orderByComparator, true);

			array[1] = accessibilityUpdate;

			array[2] = getByOrganizationId_PrevAndNext(session,
					accessibilityUpdate, organizationid, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AccessibilityUpdate getByOrganizationId_PrevAndNext(
		Session session, AccessibilityUpdate accessibilityUpdate,
		long organizationid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACCESSIBILITYUPDATE_WHERE);

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
			query.append(AccessibilityUpdateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationid);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(accessibilityUpdate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AccessibilityUpdate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accessibility updates where organizationid = &#63; from the database.
	 *
	 * @param organizationid the organizationid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organizationid)
		throws SystemException {
		for (AccessibilityUpdate accessibilityUpdate : findByOrganizationId(
				organizationid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(accessibilityUpdate);
		}
	}

	/**
	 * Returns the number of accessibility updates where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @return the number of matching accessibility updates
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

			query.append(_SQL_COUNT_ACCESSIBILITYUPDATE_WHERE);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "accessibilityUpdate.organizationid = ?";

	public AccessibilityUpdatePersistenceImpl() {
		setModelClass(AccessibilityUpdate.class);
	}

	/**
	 * Caches the accessibility update in the entity cache if it is enabled.
	 *
	 * @param accessibilityUpdate the accessibility update
	 */
	@Override
	public void cacheResult(AccessibilityUpdate accessibilityUpdate) {
		EntityCacheUtil.putResult(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AccessibilityUpdateImpl.class, accessibilityUpdate.getPrimaryKey(),
			accessibilityUpdate);

		accessibilityUpdate.resetOriginalValues();
	}

	/**
	 * Caches the accessibility updates in the entity cache if it is enabled.
	 *
	 * @param accessibilityUpdates the accessibility updates
	 */
	@Override
	public void cacheResult(List<AccessibilityUpdate> accessibilityUpdates) {
		for (AccessibilityUpdate accessibilityUpdate : accessibilityUpdates) {
			if (EntityCacheUtil.getResult(
						AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
						AccessibilityUpdateImpl.class,
						accessibilityUpdate.getPrimaryKey()) == null) {
				cacheResult(accessibilityUpdate);
			}
			else {
				accessibilityUpdate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all accessibility updates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AccessibilityUpdateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AccessibilityUpdateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the accessibility update.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AccessibilityUpdate accessibilityUpdate) {
		EntityCacheUtil.removeResult(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AccessibilityUpdateImpl.class, accessibilityUpdate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AccessibilityUpdate> accessibilityUpdates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AccessibilityUpdate accessibilityUpdate : accessibilityUpdates) {
			EntityCacheUtil.removeResult(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
				AccessibilityUpdateImpl.class,
				accessibilityUpdate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new accessibility update with the primary key. Does not add the accessibility update to the database.
	 *
	 * @param coreid the primary key for the new accessibility update
	 * @return the new accessibility update
	 */
	@Override
	public AccessibilityUpdate create(long coreid) {
		AccessibilityUpdate accessibilityUpdate = new AccessibilityUpdateImpl();

		accessibilityUpdate.setNew(true);
		accessibilityUpdate.setPrimaryKey(coreid);

		return accessibilityUpdate;
	}

	/**
	 * Removes the accessibility update with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coreid the primary key of the accessibility update
	 * @return the accessibility update that was removed
	 * @throws at.rdconnect.update.NoSuchAccessibilityUpdateException if a accessibility update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AccessibilityUpdate remove(long coreid)
		throws NoSuchAccessibilityUpdateException, SystemException {
		return remove((Serializable)coreid);
	}

	/**
	 * Removes the accessibility update with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the accessibility update
	 * @return the accessibility update that was removed
	 * @throws at.rdconnect.update.NoSuchAccessibilityUpdateException if a accessibility update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AccessibilityUpdate remove(Serializable primaryKey)
		throws NoSuchAccessibilityUpdateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AccessibilityUpdate accessibilityUpdate = (AccessibilityUpdate)session.get(AccessibilityUpdateImpl.class,
					primaryKey);

			if (accessibilityUpdate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAccessibilityUpdateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(accessibilityUpdate);
		}
		catch (NoSuchAccessibilityUpdateException nsee) {
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
	protected AccessibilityUpdate removeImpl(
		AccessibilityUpdate accessibilityUpdate) throws SystemException {
		accessibilityUpdate = toUnwrappedModel(accessibilityUpdate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(accessibilityUpdate)) {
				accessibilityUpdate = (AccessibilityUpdate)session.get(AccessibilityUpdateImpl.class,
						accessibilityUpdate.getPrimaryKeyObj());
			}

			if (accessibilityUpdate != null) {
				session.delete(accessibilityUpdate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (accessibilityUpdate != null) {
			clearCache(accessibilityUpdate);
		}

		return accessibilityUpdate;
	}

	@Override
	public AccessibilityUpdate updateImpl(
		at.rdconnect.update.model.AccessibilityUpdate accessibilityUpdate)
		throws SystemException {
		accessibilityUpdate = toUnwrappedModel(accessibilityUpdate);

		boolean isNew = accessibilityUpdate.isNew();

		AccessibilityUpdateModelImpl accessibilityUpdateModelImpl = (AccessibilityUpdateModelImpl)accessibilityUpdate;

		Session session = null;

		try {
			session = openSession();

			if (accessibilityUpdate.isNew()) {
				session.save(accessibilityUpdate);

				accessibilityUpdate.setNew(false);
			}
			else {
				session.merge(accessibilityUpdate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AccessibilityUpdateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((accessibilityUpdateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						accessibilityUpdateModelImpl.getOriginalOrganizationid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] {
						accessibilityUpdateModelImpl.getOrganizationid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AccessibilityUpdateImpl.class, accessibilityUpdate.getPrimaryKey(),
			accessibilityUpdate);

		return accessibilityUpdate;
	}

	protected AccessibilityUpdate toUnwrappedModel(
		AccessibilityUpdate accessibilityUpdate) {
		if (accessibilityUpdate instanceof AccessibilityUpdateImpl) {
			return accessibilityUpdate;
		}

		AccessibilityUpdateImpl accessibilityUpdateImpl = new AccessibilityUpdateImpl();

		accessibilityUpdateImpl.setNew(accessibilityUpdate.isNew());
		accessibilityUpdateImpl.setPrimaryKey(accessibilityUpdate.getPrimaryKey());

		accessibilityUpdateImpl.setCoreid(accessibilityUpdate.getCoreid());
		accessibilityUpdateImpl.setOrganizationid(accessibilityUpdate.getOrganizationid());
		accessibilityUpdateImpl.setFieldname(accessibilityUpdate.getFieldname());
		accessibilityUpdateImpl.setValue(accessibilityUpdate.getValue());

		return accessibilityUpdateImpl;
	}

	/**
	 * Returns the accessibility update with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the accessibility update
	 * @return the accessibility update
	 * @throws at.rdconnect.update.NoSuchAccessibilityUpdateException if a accessibility update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AccessibilityUpdate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAccessibilityUpdateException, SystemException {
		AccessibilityUpdate accessibilityUpdate = fetchByPrimaryKey(primaryKey);

		if (accessibilityUpdate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAccessibilityUpdateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return accessibilityUpdate;
	}

	/**
	 * Returns the accessibility update with the primary key or throws a {@link at.rdconnect.update.NoSuchAccessibilityUpdateException} if it could not be found.
	 *
	 * @param coreid the primary key of the accessibility update
	 * @return the accessibility update
	 * @throws at.rdconnect.update.NoSuchAccessibilityUpdateException if a accessibility update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AccessibilityUpdate findByPrimaryKey(long coreid)
		throws NoSuchAccessibilityUpdateException, SystemException {
		return findByPrimaryKey((Serializable)coreid);
	}

	/**
	 * Returns the accessibility update with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the accessibility update
	 * @return the accessibility update, or <code>null</code> if a accessibility update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AccessibilityUpdate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AccessibilityUpdate accessibilityUpdate = (AccessibilityUpdate)EntityCacheUtil.getResult(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
				AccessibilityUpdateImpl.class, primaryKey);

		if (accessibilityUpdate == _nullAccessibilityUpdate) {
			return null;
		}

		if (accessibilityUpdate == null) {
			Session session = null;

			try {
				session = openSession();

				accessibilityUpdate = (AccessibilityUpdate)session.get(AccessibilityUpdateImpl.class,
						primaryKey);

				if (accessibilityUpdate != null) {
					cacheResult(accessibilityUpdate);
				}
				else {
					EntityCacheUtil.putResult(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
						AccessibilityUpdateImpl.class, primaryKey,
						_nullAccessibilityUpdate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AccessibilityUpdateModelImpl.ENTITY_CACHE_ENABLED,
					AccessibilityUpdateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return accessibilityUpdate;
	}

	/**
	 * Returns the accessibility update with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coreid the primary key of the accessibility update
	 * @return the accessibility update, or <code>null</code> if a accessibility update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AccessibilityUpdate fetchByPrimaryKey(long coreid)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)coreid);
	}

	/**
	 * Returns all the accessibility updates.
	 *
	 * @return the accessibility updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AccessibilityUpdate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the accessibility updates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.AccessibilityUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of accessibility updates
	 * @param end the upper bound of the range of accessibility updates (not inclusive)
	 * @return the range of accessibility updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AccessibilityUpdate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the accessibility updates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.AccessibilityUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of accessibility updates
	 * @param end the upper bound of the range of accessibility updates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of accessibility updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AccessibilityUpdate> findAll(int start, int end,
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

		List<AccessibilityUpdate> list = (List<AccessibilityUpdate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ACCESSIBILITYUPDATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACCESSIBILITYUPDATE;

				if (pagination) {
					sql = sql.concat(AccessibilityUpdateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AccessibilityUpdate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AccessibilityUpdate>(list);
				}
				else {
					list = (List<AccessibilityUpdate>)QueryUtil.list(q,
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
	 * Removes all the accessibility updates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AccessibilityUpdate accessibilityUpdate : findAll()) {
			remove(accessibilityUpdate);
		}
	}

	/**
	 * Returns the number of accessibility updates.
	 *
	 * @return the number of accessibility updates
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

				Query q = session.createQuery(_SQL_COUNT_ACCESSIBILITYUPDATE);

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
	 * Initializes the accessibility update persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.rdconnect.update.model.AccessibilityUpdate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AccessibilityUpdate>> listenersList = new ArrayList<ModelListener<AccessibilityUpdate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AccessibilityUpdate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AccessibilityUpdateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ACCESSIBILITYUPDATE = "SELECT accessibilityUpdate FROM AccessibilityUpdate accessibilityUpdate";
	private static final String _SQL_SELECT_ACCESSIBILITYUPDATE_WHERE = "SELECT accessibilityUpdate FROM AccessibilityUpdate accessibilityUpdate WHERE ";
	private static final String _SQL_COUNT_ACCESSIBILITYUPDATE = "SELECT COUNT(accessibilityUpdate) FROM AccessibilityUpdate accessibilityUpdate";
	private static final String _SQL_COUNT_ACCESSIBILITYUPDATE_WHERE = "SELECT COUNT(accessibilityUpdate) FROM AccessibilityUpdate accessibilityUpdate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "accessibilityUpdate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AccessibilityUpdate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AccessibilityUpdate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AccessibilityUpdatePersistenceImpl.class);
	private static AccessibilityUpdate _nullAccessibilityUpdate = new AccessibilityUpdateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AccessibilityUpdate> toCacheModel() {
				return _nullAccessibilityUpdateCacheModel;
			}
		};

	private static CacheModel<AccessibilityUpdate> _nullAccessibilityUpdateCacheModel =
		new CacheModel<AccessibilityUpdate>() {
			@Override
			public AccessibilityUpdate toEntityModel() {
				return _nullAccessibilityUpdate;
			}
		};
}