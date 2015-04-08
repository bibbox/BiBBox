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

package at.meduni.liferay.portlet.rdconnect.service.persistence;

import at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException;
import at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess;
import at.meduni.liferay.portlet.rdconnect.model.impl.RDCOrganizationUserAccessImpl;
import at.meduni.liferay.portlet.rdconnect.model.impl.RDCOrganizationUserAccessModelImpl;

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
 * The persistence implementation for the r d c organization user access service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see RDCOrganizationUserAccessPersistence
 * @see RDCOrganizationUserAccessUtil
 * @generated
 */
public class RDCOrganizationUserAccessPersistenceImpl
	extends BasePersistenceImpl<RDCOrganizationUserAccess>
	implements RDCOrganizationUserAccessPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RDCOrganizationUserAccessUtil} to access the r d c organization user access persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RDCOrganizationUserAccessImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
			RDCOrganizationUserAccessModelImpl.FINDER_CACHE_ENABLED,
			RDCOrganizationUserAccessImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
			RDCOrganizationUserAccessModelImpl.FINDER_CACHE_ENABLED,
			RDCOrganizationUserAccessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
			RDCOrganizationUserAccessModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
			RDCOrganizationUserAccessModelImpl.FINDER_CACHE_ENABLED,
			RDCOrganizationUserAccessImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
			RDCOrganizationUserAccessModelImpl.FINDER_CACHE_ENABLED,
			RDCOrganizationUserAccessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] { Long.class.getName() },
			RDCOrganizationUserAccessModelImpl.ORGANISATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
			RDCOrganizationUserAccessModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationId", new String[] { Long.class.getName() });

	/**
	 * Returns all the r d c organization user accesses where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @return the matching r d c organization user accesses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDCOrganizationUserAccess> findByOrganizationId(
		long organisationId) throws SystemException {
		return findByOrganizationId(organisationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the r d c organization user accesses where organisationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.RDCOrganizationUserAccessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationId the organisation ID
	 * @param start the lower bound of the range of r d c organization user accesses
	 * @param end the upper bound of the range of r d c organization user accesses (not inclusive)
	 * @return the range of matching r d c organization user accesses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDCOrganizationUserAccess> findByOrganizationId(
		long organisationId, int start, int end) throws SystemException {
		return findByOrganizationId(organisationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d c organization user accesses where organisationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.RDCOrganizationUserAccessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationId the organisation ID
	 * @param start the lower bound of the range of r d c organization user accesses
	 * @param end the upper bound of the range of r d c organization user accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching r d c organization user accesses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDCOrganizationUserAccess> findByOrganizationId(
		long organisationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] { organisationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] {
					organisationId,
					
					start, end, orderByComparator
				};
		}

		List<RDCOrganizationUserAccess> list = (List<RDCOrganizationUserAccess>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RDCOrganizationUserAccess rdcOrganizationUserAccess : list) {
				if ((organisationId != rdcOrganizationUserAccess.getOrganisationId())) {
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

			query.append(_SQL_SELECT_RDCORGANIZATIONUSERACCESS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANISATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RDCOrganizationUserAccessModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationId);

				if (!pagination) {
					list = (List<RDCOrganizationUserAccess>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDCOrganizationUserAccess>(list);
				}
				else {
					list = (List<RDCOrganizationUserAccess>)QueryUtil.list(q,
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
	 * Returns the first r d c organization user access in the ordered set where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d c organization user access
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a matching r d c organization user access could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCOrganizationUserAccess findByOrganizationId_First(
		long organisationId, OrderByComparator orderByComparator)
		throws NoSuchRDCOrganizationUserAccessException, SystemException {
		RDCOrganizationUserAccess rdcOrganizationUserAccess = fetchByOrganizationId_First(organisationId,
				orderByComparator);

		if (rdcOrganizationUserAccess != null) {
			return rdcOrganizationUserAccess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organisationId=");
		msg.append(organisationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDCOrganizationUserAccessException(msg.toString());
	}

	/**
	 * Returns the first r d c organization user access in the ordered set where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d c organization user access, or <code>null</code> if a matching r d c organization user access could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCOrganizationUserAccess fetchByOrganizationId_First(
		long organisationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<RDCOrganizationUserAccess> list = findByOrganizationId(organisationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last r d c organization user access in the ordered set where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d c organization user access
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a matching r d c organization user access could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCOrganizationUserAccess findByOrganizationId_Last(
		long organisationId, OrderByComparator orderByComparator)
		throws NoSuchRDCOrganizationUserAccessException, SystemException {
		RDCOrganizationUserAccess rdcOrganizationUserAccess = fetchByOrganizationId_Last(organisationId,
				orderByComparator);

		if (rdcOrganizationUserAccess != null) {
			return rdcOrganizationUserAccess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organisationId=");
		msg.append(organisationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDCOrganizationUserAccessException(msg.toString());
	}

	/**
	 * Returns the last r d c organization user access in the ordered set where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d c organization user access, or <code>null</code> if a matching r d c organization user access could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCOrganizationUserAccess fetchByOrganizationId_Last(
		long organisationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOrganizationId(organisationId);

		if (count == 0) {
			return null;
		}

		List<RDCOrganizationUserAccess> list = findByOrganizationId(organisationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the r d c organization user accesses before and after the current r d c organization user access in the ordered set where organisationId = &#63;.
	 *
	 * @param rdcorganizationuseraccessId the primary key of the current r d c organization user access
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next r d c organization user access
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a r d c organization user access with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCOrganizationUserAccess[] findByOrganizationId_PrevAndNext(
		long rdcorganizationuseraccessId, long organisationId,
		OrderByComparator orderByComparator)
		throws NoSuchRDCOrganizationUserAccessException, SystemException {
		RDCOrganizationUserAccess rdcOrganizationUserAccess = findByPrimaryKey(rdcorganizationuseraccessId);

		Session session = null;

		try {
			session = openSession();

			RDCOrganizationUserAccess[] array = new RDCOrganizationUserAccessImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session,
					rdcOrganizationUserAccess, organisationId,
					orderByComparator, true);

			array[1] = rdcOrganizationUserAccess;

			array[2] = getByOrganizationId_PrevAndNext(session,
					rdcOrganizationUserAccess, organisationId,
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

	protected RDCOrganizationUserAccess getByOrganizationId_PrevAndNext(
		Session session, RDCOrganizationUserAccess rdcOrganizationUserAccess,
		long organisationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RDCORGANIZATIONUSERACCESS_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANISATIONID_2);

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
			query.append(RDCOrganizationUserAccessModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organisationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rdcOrganizationUserAccess);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RDCOrganizationUserAccess> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the r d c organization user accesses where organisationId = &#63; from the database.
	 *
	 * @param organisationId the organisation ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organisationId)
		throws SystemException {
		for (RDCOrganizationUserAccess rdcOrganizationUserAccess : findByOrganizationId(
				organisationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rdcOrganizationUserAccess);
		}
	}

	/**
	 * Returns the number of r d c organization user accesses where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @return the number of matching r d c organization user accesses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationId(long organisationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { organisationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RDCORGANIZATIONUSERACCESS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANISATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANISATIONID_2 = "rdcOrganizationUserAccess.organisationId = ?";

	public RDCOrganizationUserAccessPersistenceImpl() {
		setModelClass(RDCOrganizationUserAccess.class);
	}

	/**
	 * Caches the r d c organization user access in the entity cache if it is enabled.
	 *
	 * @param rdcOrganizationUserAccess the r d c organization user access
	 */
	@Override
	public void cacheResult(RDCOrganizationUserAccess rdcOrganizationUserAccess) {
		EntityCacheUtil.putResult(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
			RDCOrganizationUserAccessImpl.class,
			rdcOrganizationUserAccess.getPrimaryKey(), rdcOrganizationUserAccess);

		rdcOrganizationUserAccess.resetOriginalValues();
	}

	/**
	 * Caches the r d c organization user accesses in the entity cache if it is enabled.
	 *
	 * @param rdcOrganizationUserAccesses the r d c organization user accesses
	 */
	@Override
	public void cacheResult(
		List<RDCOrganizationUserAccess> rdcOrganizationUserAccesses) {
		for (RDCOrganizationUserAccess rdcOrganizationUserAccess : rdcOrganizationUserAccesses) {
			if (EntityCacheUtil.getResult(
						RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
						RDCOrganizationUserAccessImpl.class,
						rdcOrganizationUserAccess.getPrimaryKey()) == null) {
				cacheResult(rdcOrganizationUserAccess);
			}
			else {
				rdcOrganizationUserAccess.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all r d c organization user accesses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RDCOrganizationUserAccessImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RDCOrganizationUserAccessImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the r d c organization user access.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RDCOrganizationUserAccess rdcOrganizationUserAccess) {
		EntityCacheUtil.removeResult(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
			RDCOrganizationUserAccessImpl.class,
			rdcOrganizationUserAccess.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<RDCOrganizationUserAccess> rdcOrganizationUserAccesses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RDCOrganizationUserAccess rdcOrganizationUserAccess : rdcOrganizationUserAccesses) {
			EntityCacheUtil.removeResult(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
				RDCOrganizationUserAccessImpl.class,
				rdcOrganizationUserAccess.getPrimaryKey());
		}
	}

	/**
	 * Creates a new r d c organization user access with the primary key. Does not add the r d c organization user access to the database.
	 *
	 * @param rdcorganizationuseraccessId the primary key for the new r d c organization user access
	 * @return the new r d c organization user access
	 */
	@Override
	public RDCOrganizationUserAccess create(long rdcorganizationuseraccessId) {
		RDCOrganizationUserAccess rdcOrganizationUserAccess = new RDCOrganizationUserAccessImpl();

		rdcOrganizationUserAccess.setNew(true);
		rdcOrganizationUserAccess.setPrimaryKey(rdcorganizationuseraccessId);

		return rdcOrganizationUserAccess;
	}

	/**
	 * Removes the r d c organization user access with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rdcorganizationuseraccessId the primary key of the r d c organization user access
	 * @return the r d c organization user access that was removed
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a r d c organization user access with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCOrganizationUserAccess remove(long rdcorganizationuseraccessId)
		throws NoSuchRDCOrganizationUserAccessException, SystemException {
		return remove((Serializable)rdcorganizationuseraccessId);
	}

	/**
	 * Removes the r d c organization user access with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the r d c organization user access
	 * @return the r d c organization user access that was removed
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a r d c organization user access with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCOrganizationUserAccess remove(Serializable primaryKey)
		throws NoSuchRDCOrganizationUserAccessException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RDCOrganizationUserAccess rdcOrganizationUserAccess = (RDCOrganizationUserAccess)session.get(RDCOrganizationUserAccessImpl.class,
					primaryKey);

			if (rdcOrganizationUserAccess == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRDCOrganizationUserAccessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rdcOrganizationUserAccess);
		}
		catch (NoSuchRDCOrganizationUserAccessException nsee) {
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
	protected RDCOrganizationUserAccess removeImpl(
		RDCOrganizationUserAccess rdcOrganizationUserAccess)
		throws SystemException {
		rdcOrganizationUserAccess = toUnwrappedModel(rdcOrganizationUserAccess);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rdcOrganizationUserAccess)) {
				rdcOrganizationUserAccess = (RDCOrganizationUserAccess)session.get(RDCOrganizationUserAccessImpl.class,
						rdcOrganizationUserAccess.getPrimaryKeyObj());
			}

			if (rdcOrganizationUserAccess != null) {
				session.delete(rdcOrganizationUserAccess);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rdcOrganizationUserAccess != null) {
			clearCache(rdcOrganizationUserAccess);
		}

		return rdcOrganizationUserAccess;
	}

	@Override
	public RDCOrganizationUserAccess updateImpl(
		at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess rdcOrganizationUserAccess)
		throws SystemException {
		rdcOrganizationUserAccess = toUnwrappedModel(rdcOrganizationUserAccess);

		boolean isNew = rdcOrganizationUserAccess.isNew();

		RDCOrganizationUserAccessModelImpl rdcOrganizationUserAccessModelImpl = (RDCOrganizationUserAccessModelImpl)rdcOrganizationUserAccess;

		Session session = null;

		try {
			session = openSession();

			if (rdcOrganizationUserAccess.isNew()) {
				session.save(rdcOrganizationUserAccess);

				rdcOrganizationUserAccess.setNew(false);
			}
			else {
				session.merge(rdcOrganizationUserAccess);
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
				!RDCOrganizationUserAccessModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rdcOrganizationUserAccessModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rdcOrganizationUserAccessModelImpl.getOriginalOrganisationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] {
						rdcOrganizationUserAccessModelImpl.getOrganisationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
			RDCOrganizationUserAccessImpl.class,
			rdcOrganizationUserAccess.getPrimaryKey(), rdcOrganizationUserAccess);

		return rdcOrganizationUserAccess;
	}

	protected RDCOrganizationUserAccess toUnwrappedModel(
		RDCOrganizationUserAccess rdcOrganizationUserAccess) {
		if (rdcOrganizationUserAccess instanceof RDCOrganizationUserAccessImpl) {
			return rdcOrganizationUserAccess;
		}

		RDCOrganizationUserAccessImpl rdcOrganizationUserAccessImpl = new RDCOrganizationUserAccessImpl();

		rdcOrganizationUserAccessImpl.setNew(rdcOrganizationUserAccess.isNew());
		rdcOrganizationUserAccessImpl.setPrimaryKey(rdcOrganizationUserAccess.getPrimaryKey());

		rdcOrganizationUserAccessImpl.setRdcorganizationuseraccessId(rdcOrganizationUserAccess.getRdcorganizationuseraccessId());
		rdcOrganizationUserAccessImpl.setOrganisationId(rdcOrganizationUserAccess.getOrganisationId());
		rdcOrganizationUserAccessImpl.setUserId(rdcOrganizationUserAccess.getUserId());
		rdcOrganizationUserAccessImpl.setIpaddress(rdcOrganizationUserAccess.getIpaddress());
		rdcOrganizationUserAccessImpl.setLastaccess(rdcOrganizationUserAccess.getLastaccess());

		return rdcOrganizationUserAccessImpl;
	}

	/**
	 * Returns the r d c organization user access with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the r d c organization user access
	 * @return the r d c organization user access
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a r d c organization user access with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCOrganizationUserAccess findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRDCOrganizationUserAccessException, SystemException {
		RDCOrganizationUserAccess rdcOrganizationUserAccess = fetchByPrimaryKey(primaryKey);

		if (rdcOrganizationUserAccess == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRDCOrganizationUserAccessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rdcOrganizationUserAccess;
	}

	/**
	 * Returns the r d c organization user access with the primary key or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException} if it could not be found.
	 *
	 * @param rdcorganizationuseraccessId the primary key of the r d c organization user access
	 * @return the r d c organization user access
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a r d c organization user access with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCOrganizationUserAccess findByPrimaryKey(
		long rdcorganizationuseraccessId)
		throws NoSuchRDCOrganizationUserAccessException, SystemException {
		return findByPrimaryKey((Serializable)rdcorganizationuseraccessId);
	}

	/**
	 * Returns the r d c organization user access with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the r d c organization user access
	 * @return the r d c organization user access, or <code>null</code> if a r d c organization user access with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCOrganizationUserAccess fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RDCOrganizationUserAccess rdcOrganizationUserAccess = (RDCOrganizationUserAccess)EntityCacheUtil.getResult(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
				RDCOrganizationUserAccessImpl.class, primaryKey);

		if (rdcOrganizationUserAccess == _nullRDCOrganizationUserAccess) {
			return null;
		}

		if (rdcOrganizationUserAccess == null) {
			Session session = null;

			try {
				session = openSession();

				rdcOrganizationUserAccess = (RDCOrganizationUserAccess)session.get(RDCOrganizationUserAccessImpl.class,
						primaryKey);

				if (rdcOrganizationUserAccess != null) {
					cacheResult(rdcOrganizationUserAccess);
				}
				else {
					EntityCacheUtil.putResult(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
						RDCOrganizationUserAccessImpl.class, primaryKey,
						_nullRDCOrganizationUserAccess);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RDCOrganizationUserAccessModelImpl.ENTITY_CACHE_ENABLED,
					RDCOrganizationUserAccessImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rdcOrganizationUserAccess;
	}

	/**
	 * Returns the r d c organization user access with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rdcorganizationuseraccessId the primary key of the r d c organization user access
	 * @return the r d c organization user access, or <code>null</code> if a r d c organization user access with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCOrganizationUserAccess fetchByPrimaryKey(
		long rdcorganizationuseraccessId) throws SystemException {
		return fetchByPrimaryKey((Serializable)rdcorganizationuseraccessId);
	}

	/**
	 * Returns all the r d c organization user accesses.
	 *
	 * @return the r d c organization user accesses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDCOrganizationUserAccess> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the r d c organization user accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.RDCOrganizationUserAccessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of r d c organization user accesses
	 * @param end the upper bound of the range of r d c organization user accesses (not inclusive)
	 * @return the range of r d c organization user accesses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDCOrganizationUserAccess> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d c organization user accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.RDCOrganizationUserAccessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of r d c organization user accesses
	 * @param end the upper bound of the range of r d c organization user accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of r d c organization user accesses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDCOrganizationUserAccess> findAll(int start, int end,
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

		List<RDCOrganizationUserAccess> list = (List<RDCOrganizationUserAccess>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RDCORGANIZATIONUSERACCESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RDCORGANIZATIONUSERACCESS;

				if (pagination) {
					sql = sql.concat(RDCOrganizationUserAccessModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RDCOrganizationUserAccess>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDCOrganizationUserAccess>(list);
				}
				else {
					list = (List<RDCOrganizationUserAccess>)QueryUtil.list(q,
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
	 * Removes all the r d c organization user accesses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RDCOrganizationUserAccess rdcOrganizationUserAccess : findAll()) {
			remove(rdcOrganizationUserAccess);
		}
	}

	/**
	 * Returns the number of r d c organization user accesses.
	 *
	 * @return the number of r d c organization user accesses
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

				Query q = session.createQuery(_SQL_COUNT_RDCORGANIZATIONUSERACCESS);

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
	 * Initializes the r d c organization user access persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RDCOrganizationUserAccess>> listenersList = new ArrayList<ModelListener<RDCOrganizationUserAccess>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RDCOrganizationUserAccess>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RDCOrganizationUserAccessImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RDCORGANIZATIONUSERACCESS = "SELECT rdcOrganizationUserAccess FROM RDCOrganizationUserAccess rdcOrganizationUserAccess";
	private static final String _SQL_SELECT_RDCORGANIZATIONUSERACCESS_WHERE = "SELECT rdcOrganizationUserAccess FROM RDCOrganizationUserAccess rdcOrganizationUserAccess WHERE ";
	private static final String _SQL_COUNT_RDCORGANIZATIONUSERACCESS = "SELECT COUNT(rdcOrganizationUserAccess) FROM RDCOrganizationUserAccess rdcOrganizationUserAccess";
	private static final String _SQL_COUNT_RDCORGANIZATIONUSERACCESS_WHERE = "SELECT COUNT(rdcOrganizationUserAccess) FROM RDCOrganizationUserAccess rdcOrganizationUserAccess WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rdcOrganizationUserAccess.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RDCOrganizationUserAccess exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RDCOrganizationUserAccess exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RDCOrganizationUserAccessPersistenceImpl.class);
	private static RDCOrganizationUserAccess _nullRDCOrganizationUserAccess = new RDCOrganizationUserAccessImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RDCOrganizationUserAccess> toCacheModel() {
				return _nullRDCOrganizationUserAccessCacheModel;
			}
		};

	private static CacheModel<RDCOrganizationUserAccess> _nullRDCOrganizationUserAccessCacheModel =
		new CacheModel<RDCOrganizationUserAccess>() {
			@Override
			public RDCOrganizationUserAccess toEntityModel() {
				return _nullRDCOrganizationUserAccess;
			}
		};
}