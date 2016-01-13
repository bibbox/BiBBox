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

package at.meduni.liferay.portlet.bbmrieric.service.persistence;

import at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException;
import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkImpl;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl;

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
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the d2 biobank network service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see D2BiobankNetworkPersistence
 * @see D2BiobankNetworkUtil
 * @generated
 */
public class D2BiobankNetworkPersistenceImpl extends BasePersistenceImpl<D2BiobankNetwork>
	implements D2BiobankNetworkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link D2BiobankNetworkUtil} to access the d2 biobank network persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = D2BiobankNetworkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			D2BiobankNetworkModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the d2 biobank networks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetwork> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobank networks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of d2 biobank networks
	 * @param end the upper bound of the range of d2 biobank networks (not inclusive)
	 * @return the range of matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetwork> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobank networks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of d2 biobank networks
	 * @param end the upper bound of the range of d2 biobank networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetwork> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<D2BiobankNetwork> list = (List<D2BiobankNetwork>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2BiobankNetwork d2BiobankNetwork : list) {
				if (!Validator.equals(uuid, d2BiobankNetwork.getUuid())) {
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

			query.append(_SQL_SELECT_D2BIOBANKNETWORK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2BiobankNetworkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<D2BiobankNetwork>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2BiobankNetwork>(list);
				}
				else {
					list = (List<D2BiobankNetwork>)QueryUtil.list(q,
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
	 * Returns the first d2 biobank network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = fetchByUuid_First(uuid,
				orderByComparator);

		if (d2BiobankNetwork != null) {
			return d2BiobankNetwork;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2BiobankNetwork> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = fetchByUuid_Last(uuid,
				orderByComparator);

		if (d2BiobankNetwork != null) {
			return d2BiobankNetwork;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<D2BiobankNetwork> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobank networks before and after the current d2 biobank network in the ordered set where uuid = &#63;.
	 *
	 * @param d2biobanknetworkId the primary key of the current d2 biobank network
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork[] findByUuid_PrevAndNext(long d2biobanknetworkId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = findByPrimaryKey(d2biobanknetworkId);

		Session session = null;

		try {
			session = openSession();

			D2BiobankNetwork[] array = new D2BiobankNetworkImpl[3];

			array[0] = getByUuid_PrevAndNext(session, d2BiobankNetwork, uuid,
					orderByComparator, true);

			array[1] = d2BiobankNetwork;

			array[2] = getByUuid_PrevAndNext(session, d2BiobankNetwork, uuid,
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

	protected D2BiobankNetwork getByUuid_PrevAndNext(Session session,
		D2BiobankNetwork d2BiobankNetwork, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANKNETWORK_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(D2BiobankNetworkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2BiobankNetwork);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2BiobankNetwork> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobank networks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (D2BiobankNetwork d2BiobankNetwork : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2BiobankNetwork);
		}
	}

	/**
	 * Returns the number of d2 biobank networks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_D2BIOBANKNETWORK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "d2BiobankNetwork.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "d2BiobankNetwork.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(d2BiobankNetwork.uuid IS NULL OR d2BiobankNetwork.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			D2BiobankNetworkModelImpl.UUID_COLUMN_BITMASK |
			D2BiobankNetworkModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the d2 biobank network where uuid = &#63; and groupId = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork findByUUID_G(String uuid, long groupId)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = fetchByUUID_G(uuid, groupId);

		if (d2BiobankNetwork == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchD2BiobankNetworkException(msg.toString());
		}

		return d2BiobankNetwork;
	}

	/**
	 * Returns the d2 biobank network where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the d2 biobank network where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof D2BiobankNetwork) {
			D2BiobankNetwork d2BiobankNetwork = (D2BiobankNetwork)result;

			if (!Validator.equals(uuid, d2BiobankNetwork.getUuid()) ||
					(groupId != d2BiobankNetwork.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_D2BIOBANKNETWORK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<D2BiobankNetwork> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					D2BiobankNetwork d2BiobankNetwork = list.get(0);

					result = d2BiobankNetwork;

					cacheResult(d2BiobankNetwork);

					if ((d2BiobankNetwork.getUuid() == null) ||
							!d2BiobankNetwork.getUuid().equals(uuid) ||
							(d2BiobankNetwork.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, d2BiobankNetwork);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
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
			return (D2BiobankNetwork)result;
		}
	}

	/**
	 * Removes the d2 biobank network where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the d2 biobank network that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork removeByUUID_G(String uuid, long groupId)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = findByUUID_G(uuid, groupId);

		return remove(d2BiobankNetwork);
	}

	/**
	 * Returns the number of d2 biobank networks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_D2BIOBANKNETWORK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "d2BiobankNetwork.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "d2BiobankNetwork.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(d2BiobankNetwork.uuid IS NULL OR d2BiobankNetwork.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "d2BiobankNetwork.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			D2BiobankNetworkModelImpl.UUID_COLUMN_BITMASK |
			D2BiobankNetworkModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the d2 biobank networks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetwork> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobank networks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of d2 biobank networks
	 * @param end the upper bound of the range of d2 biobank networks (not inclusive)
	 * @return the range of matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetwork> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobank networks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of d2 biobank networks
	 * @param end the upper bound of the range of d2 biobank networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetwork> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<D2BiobankNetwork> list = (List<D2BiobankNetwork>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2BiobankNetwork d2BiobankNetwork : list) {
				if (!Validator.equals(uuid, d2BiobankNetwork.getUuid()) ||
						(companyId != d2BiobankNetwork.getCompanyId())) {
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

			query.append(_SQL_SELECT_D2BIOBANKNETWORK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2BiobankNetworkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<D2BiobankNetwork>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2BiobankNetwork>(list);
				}
				else {
					list = (List<D2BiobankNetwork>)QueryUtil.list(q,
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
	 * Returns the first d2 biobank network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (d2BiobankNetwork != null) {
			return d2BiobankNetwork;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2BiobankNetwork> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (d2BiobankNetwork != null) {
			return d2BiobankNetwork;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<D2BiobankNetwork> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobank networks before and after the current d2 biobank network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param d2biobanknetworkId the primary key of the current d2 biobank network
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork[] findByUuid_C_PrevAndNext(
		long d2biobanknetworkId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = findByPrimaryKey(d2biobanknetworkId);

		Session session = null;

		try {
			session = openSession();

			D2BiobankNetwork[] array = new D2BiobankNetworkImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, d2BiobankNetwork, uuid,
					companyId, orderByComparator, true);

			array[1] = d2BiobankNetwork;

			array[2] = getByUuid_C_PrevAndNext(session, d2BiobankNetwork, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected D2BiobankNetwork getByUuid_C_PrevAndNext(Session session,
		D2BiobankNetwork d2BiobankNetwork, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANKNETWORK_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(D2BiobankNetworkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2BiobankNetwork);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2BiobankNetwork> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobank networks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (D2BiobankNetwork d2BiobankNetwork : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2BiobankNetwork);
		}
	}

	/**
	 * Returns the number of d2 biobank networks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_D2BIOBANKNETWORK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "d2BiobankNetwork.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "d2BiobankNetwork.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(d2BiobankNetwork.uuid IS NULL OR d2BiobankNetwork.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "d2BiobankNetwork.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTUUID = new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNotUUID",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTUUID = new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNotUUID",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @return the matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetwork> findByNotUUID(long groupId, String updateuuid)
		throws SystemException {
		return findByNotUUID(groupId, updateuuid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param start the lower bound of the range of d2 biobank networks
	 * @param end the upper bound of the range of d2 biobank networks (not inclusive)
	 * @return the range of matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetwork> findByNotUUID(long groupId,
		String updateuuid, int start, int end) throws SystemException {
		return findByNotUUID(groupId, updateuuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param start the lower bound of the range of d2 biobank networks
	 * @param end the upper bound of the range of d2 biobank networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetwork> findByNotUUID(long groupId,
		String updateuuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTUUID;
		finderArgs = new Object[] {
				groupId, updateuuid,
				
				start, end, orderByComparator
			};

		List<D2BiobankNetwork> list = (List<D2BiobankNetwork>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2BiobankNetwork d2BiobankNetwork : list) {
				if ((groupId != d2BiobankNetwork.getGroupId()) ||
						Validator.equals(updateuuid,
							d2BiobankNetwork.getUpdateuuid())) {
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

			query.append(_SQL_SELECT_D2BIOBANKNETWORK_WHERE);

			query.append(_FINDER_COLUMN_NOTUUID_GROUPID_2);

			boolean bindUpdateuuid = false;

			if (updateuuid == null) {
				query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_1);
			}
			else if (updateuuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_3);
			}
			else {
				bindUpdateuuid = true;

				query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2BiobankNetworkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUpdateuuid) {
					qPos.add(updateuuid);
				}

				if (!pagination) {
					list = (List<D2BiobankNetwork>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2BiobankNetwork>(list);
				}
				else {
					list = (List<D2BiobankNetwork>)QueryUtil.list(q,
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
	 * Returns the first d2 biobank network in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork findByNotUUID_First(long groupId,
		String updateuuid, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = fetchByNotUUID_First(groupId,
				updateuuid, orderByComparator);

		if (d2BiobankNetwork != null) {
			return d2BiobankNetwork;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", updateuuid=");
		msg.append(updateuuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank network in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork fetchByNotUUID_First(long groupId,
		String updateuuid, OrderByComparator orderByComparator)
		throws SystemException {
		List<D2BiobankNetwork> list = findByNotUUID(groupId, updateuuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank network in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork findByNotUUID_Last(long groupId, String updateuuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = fetchByNotUUID_Last(groupId,
				updateuuid, orderByComparator);

		if (d2BiobankNetwork != null) {
			return d2BiobankNetwork;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", updateuuid=");
		msg.append(updateuuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank network in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork fetchByNotUUID_Last(long groupId,
		String updateuuid, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByNotUUID(groupId, updateuuid);

		if (count == 0) {
			return null;
		}

		List<D2BiobankNetwork> list = findByNotUUID(groupId, updateuuid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobank networks before and after the current d2 biobank network in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param d2biobanknetworkId the primary key of the current d2 biobank network
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork[] findByNotUUID_PrevAndNext(
		long d2biobanknetworkId, long groupId, String updateuuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = findByPrimaryKey(d2biobanknetworkId);

		Session session = null;

		try {
			session = openSession();

			D2BiobankNetwork[] array = new D2BiobankNetworkImpl[3];

			array[0] = getByNotUUID_PrevAndNext(session, d2BiobankNetwork,
					groupId, updateuuid, orderByComparator, true);

			array[1] = d2BiobankNetwork;

			array[2] = getByNotUUID_PrevAndNext(session, d2BiobankNetwork,
					groupId, updateuuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected D2BiobankNetwork getByNotUUID_PrevAndNext(Session session,
		D2BiobankNetwork d2BiobankNetwork, long groupId, String updateuuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANKNETWORK_WHERE);

		query.append(_FINDER_COLUMN_NOTUUID_GROUPID_2);

		boolean bindUpdateuuid = false;

		if (updateuuid == null) {
			query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_1);
		}
		else if (updateuuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_3);
		}
		else {
			bindUpdateuuid = true;

			query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_2);
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
			query.append(D2BiobankNetworkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindUpdateuuid) {
			qPos.add(updateuuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2BiobankNetwork);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2BiobankNetwork> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNotUUID(long groupId, String updateuuid)
		throws SystemException {
		for (D2BiobankNetwork d2BiobankNetwork : findByNotUUID(groupId,
				updateuuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2BiobankNetwork);
		}
	}

	/**
	 * Returns the number of d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @return the number of matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNotUUID(long groupId, String updateuuid)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTUUID;

		Object[] finderArgs = new Object[] { groupId, updateuuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_D2BIOBANKNETWORK_WHERE);

			query.append(_FINDER_COLUMN_NOTUUID_GROUPID_2);

			boolean bindUpdateuuid = false;

			if (updateuuid == null) {
				query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_1);
			}
			else if (updateuuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_3);
			}
			else {
				bindUpdateuuid = true;

				query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUpdateuuid) {
					qPos.add(updateuuid);
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

	private static final String _FINDER_COLUMN_NOTUUID_GROUPID_2 = "d2BiobankNetwork.groupId = ? AND ";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_1 = "d2BiobankNetwork.updateuuid IS NOT NULL";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_2 = "d2BiobankNetwork.updateuuid != ?";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_3 = "(d2BiobankNetwork.updateuuid IS NULL OR d2BiobankNetwork.updateuuid != '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_BIOBANKNETWORKBBMRIERICID =
		new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByBiobankNetworkBBMRIERICID",
			new String[] { Long.class.getName(), String.class.getName() },
			D2BiobankNetworkModelImpl.GROUPID_COLUMN_BITMASK |
			D2BiobankNetworkModelImpl.BBMRIBIOBANKNETWORKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BIOBANKNETWORKBBMRIERICID =
		new FinderPath(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBiobankNetworkBBMRIERICID",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the d2 biobank network where groupId = &#63; and bbmriBiobankNetworkID = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param bbmriBiobankNetworkID the bbmri biobank network i d
	 * @return the matching d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork findByBiobankNetworkBBMRIERICID(long groupId,
		String bbmriBiobankNetworkID)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = fetchByBiobankNetworkBBMRIERICID(groupId,
				bbmriBiobankNetworkID);

		if (d2BiobankNetwork == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", bbmriBiobankNetworkID=");
			msg.append(bbmriBiobankNetworkID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchD2BiobankNetworkException(msg.toString());
		}

		return d2BiobankNetwork;
	}

	/**
	 * Returns the d2 biobank network where groupId = &#63; and bbmriBiobankNetworkID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param bbmriBiobankNetworkID the bbmri biobank network i d
	 * @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork fetchByBiobankNetworkBBMRIERICID(long groupId,
		String bbmriBiobankNetworkID) throws SystemException {
		return fetchByBiobankNetworkBBMRIERICID(groupId, bbmriBiobankNetworkID,
			true);
	}

	/**
	 * Returns the d2 biobank network where groupId = &#63; and bbmriBiobankNetworkID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param bbmriBiobankNetworkID the bbmri biobank network i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork fetchByBiobankNetworkBBMRIERICID(long groupId,
		String bbmriBiobankNetworkID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, bbmriBiobankNetworkID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BIOBANKNETWORKBBMRIERICID,
					finderArgs, this);
		}

		if (result instanceof D2BiobankNetwork) {
			D2BiobankNetwork d2BiobankNetwork = (D2BiobankNetwork)result;

			if ((groupId != d2BiobankNetwork.getGroupId()) ||
					!Validator.equals(bbmriBiobankNetworkID,
						d2BiobankNetwork.getBbmriBiobankNetworkID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_D2BIOBANKNETWORK_WHERE);

			query.append(_FINDER_COLUMN_BIOBANKNETWORKBBMRIERICID_GROUPID_2);

			boolean bindBbmriBiobankNetworkID = false;

			if (bbmriBiobankNetworkID == null) {
				query.append(_FINDER_COLUMN_BIOBANKNETWORKBBMRIERICID_BBMRIBIOBANKNETWORKID_1);
			}
			else if (bbmriBiobankNetworkID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKNETWORKBBMRIERICID_BBMRIBIOBANKNETWORKID_3);
			}
			else {
				bindBbmriBiobankNetworkID = true;

				query.append(_FINDER_COLUMN_BIOBANKNETWORKBBMRIERICID_BBMRIBIOBANKNETWORKID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindBbmriBiobankNetworkID) {
					qPos.add(bbmriBiobankNetworkID);
				}

				List<D2BiobankNetwork> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKNETWORKBBMRIERICID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"D2BiobankNetworkPersistenceImpl.fetchByBiobankNetworkBBMRIERICID(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					D2BiobankNetwork d2BiobankNetwork = list.get(0);

					result = d2BiobankNetwork;

					cacheResult(d2BiobankNetwork);

					if ((d2BiobankNetwork.getGroupId() != groupId) ||
							(d2BiobankNetwork.getBbmriBiobankNetworkID() == null) ||
							!d2BiobankNetwork.getBbmriBiobankNetworkID()
												 .equals(bbmriBiobankNetworkID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKNETWORKBBMRIERICID,
							finderArgs, d2BiobankNetwork);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BIOBANKNETWORKBBMRIERICID,
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
			return (D2BiobankNetwork)result;
		}
	}

	/**
	 * Removes the d2 biobank network where groupId = &#63; and bbmriBiobankNetworkID = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param bbmriBiobankNetworkID the bbmri biobank network i d
	 * @return the d2 biobank network that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork removeByBiobankNetworkBBMRIERICID(long groupId,
		String bbmriBiobankNetworkID)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = findByBiobankNetworkBBMRIERICID(groupId,
				bbmriBiobankNetworkID);

		return remove(d2BiobankNetwork);
	}

	/**
	 * Returns the number of d2 biobank networks where groupId = &#63; and bbmriBiobankNetworkID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param bbmriBiobankNetworkID the bbmri biobank network i d
	 * @return the number of matching d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBiobankNetworkBBMRIERICID(long groupId,
		String bbmriBiobankNetworkID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BIOBANKNETWORKBBMRIERICID;

		Object[] finderArgs = new Object[] { groupId, bbmriBiobankNetworkID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_D2BIOBANKNETWORK_WHERE);

			query.append(_FINDER_COLUMN_BIOBANKNETWORKBBMRIERICID_GROUPID_2);

			boolean bindBbmriBiobankNetworkID = false;

			if (bbmriBiobankNetworkID == null) {
				query.append(_FINDER_COLUMN_BIOBANKNETWORKBBMRIERICID_BBMRIBIOBANKNETWORKID_1);
			}
			else if (bbmriBiobankNetworkID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKNETWORKBBMRIERICID_BBMRIBIOBANKNETWORKID_3);
			}
			else {
				bindBbmriBiobankNetworkID = true;

				query.append(_FINDER_COLUMN_BIOBANKNETWORKBBMRIERICID_BBMRIBIOBANKNETWORKID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindBbmriBiobankNetworkID) {
					qPos.add(bbmriBiobankNetworkID);
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

	private static final String _FINDER_COLUMN_BIOBANKNETWORKBBMRIERICID_GROUPID_2 =
		"d2BiobankNetwork.groupId = ? AND ";
	private static final String _FINDER_COLUMN_BIOBANKNETWORKBBMRIERICID_BBMRIBIOBANKNETWORKID_1 =
		"d2BiobankNetwork.bbmriBiobankNetworkID IS NULL";
	private static final String _FINDER_COLUMN_BIOBANKNETWORKBBMRIERICID_BBMRIBIOBANKNETWORKID_2 =
		"d2BiobankNetwork.bbmriBiobankNetworkID = ?";
	private static final String _FINDER_COLUMN_BIOBANKNETWORKBBMRIERICID_BBMRIBIOBANKNETWORKID_3 =
		"(d2BiobankNetwork.bbmriBiobankNetworkID IS NULL OR d2BiobankNetwork.bbmriBiobankNetworkID = '')";

	public D2BiobankNetworkPersistenceImpl() {
		setModelClass(D2BiobankNetwork.class);
	}

	/**
	 * Caches the d2 biobank network in the entity cache if it is enabled.
	 *
	 * @param d2BiobankNetwork the d2 biobank network
	 */
	@Override
	public void cacheResult(D2BiobankNetwork d2BiobankNetwork) {
		EntityCacheUtil.putResult(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkImpl.class, d2BiobankNetwork.getPrimaryKey(),
			d2BiobankNetwork);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				d2BiobankNetwork.getUuid(), d2BiobankNetwork.getGroupId()
			}, d2BiobankNetwork);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKNETWORKBBMRIERICID,
			new Object[] {
				d2BiobankNetwork.getGroupId(),
				d2BiobankNetwork.getBbmriBiobankNetworkID()
			}, d2BiobankNetwork);

		d2BiobankNetwork.resetOriginalValues();
	}

	/**
	 * Caches the d2 biobank networks in the entity cache if it is enabled.
	 *
	 * @param d2BiobankNetworks the d2 biobank networks
	 */
	@Override
	public void cacheResult(List<D2BiobankNetwork> d2BiobankNetworks) {
		for (D2BiobankNetwork d2BiobankNetwork : d2BiobankNetworks) {
			if (EntityCacheUtil.getResult(
						D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
						D2BiobankNetworkImpl.class,
						d2BiobankNetwork.getPrimaryKey()) == null) {
				cacheResult(d2BiobankNetwork);
			}
			else {
				d2BiobankNetwork.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all d2 biobank networks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(D2BiobankNetworkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(D2BiobankNetworkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the d2 biobank network.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(D2BiobankNetwork d2BiobankNetwork) {
		EntityCacheUtil.removeResult(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkImpl.class, d2BiobankNetwork.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(d2BiobankNetwork);
	}

	@Override
	public void clearCache(List<D2BiobankNetwork> d2BiobankNetworks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (D2BiobankNetwork d2BiobankNetwork : d2BiobankNetworks) {
			EntityCacheUtil.removeResult(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
				D2BiobankNetworkImpl.class, d2BiobankNetwork.getPrimaryKey());

			clearUniqueFindersCache(d2BiobankNetwork);
		}
	}

	protected void cacheUniqueFindersCache(D2BiobankNetwork d2BiobankNetwork) {
		if (d2BiobankNetwork.isNew()) {
			Object[] args = new Object[] {
					d2BiobankNetwork.getUuid(), d2BiobankNetwork.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				d2BiobankNetwork);

			args = new Object[] {
					d2BiobankNetwork.getGroupId(),
					d2BiobankNetwork.getBbmriBiobankNetworkID()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BIOBANKNETWORKBBMRIERICID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKNETWORKBBMRIERICID,
				args, d2BiobankNetwork);
		}
		else {
			D2BiobankNetworkModelImpl d2BiobankNetworkModelImpl = (D2BiobankNetworkModelImpl)d2BiobankNetwork;

			if ((d2BiobankNetworkModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankNetwork.getUuid(),
						d2BiobankNetwork.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					d2BiobankNetwork);
			}

			if ((d2BiobankNetworkModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BIOBANKNETWORKBBMRIERICID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankNetwork.getGroupId(),
						d2BiobankNetwork.getBbmriBiobankNetworkID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BIOBANKNETWORKBBMRIERICID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKNETWORKBBMRIERICID,
					args, d2BiobankNetwork);
			}
		}
	}

	protected void clearUniqueFindersCache(D2BiobankNetwork d2BiobankNetwork) {
		D2BiobankNetworkModelImpl d2BiobankNetworkModelImpl = (D2BiobankNetworkModelImpl)d2BiobankNetwork;

		Object[] args = new Object[] {
				d2BiobankNetwork.getUuid(), d2BiobankNetwork.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((d2BiobankNetworkModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					d2BiobankNetworkModelImpl.getOriginalUuid(),
					d2BiobankNetworkModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				d2BiobankNetwork.getGroupId(),
				d2BiobankNetwork.getBbmriBiobankNetworkID()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKNETWORKBBMRIERICID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BIOBANKNETWORKBBMRIERICID,
			args);

		if ((d2BiobankNetworkModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BIOBANKNETWORKBBMRIERICID.getColumnBitmask()) != 0) {
			args = new Object[] {
					d2BiobankNetworkModelImpl.getOriginalGroupId(),
					d2BiobankNetworkModelImpl.getOriginalBbmriBiobankNetworkID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKNETWORKBBMRIERICID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BIOBANKNETWORKBBMRIERICID,
				args);
		}
	}

	/**
	 * Creates a new d2 biobank network with the primary key. Does not add the d2 biobank network to the database.
	 *
	 * @param d2biobanknetworkId the primary key for the new d2 biobank network
	 * @return the new d2 biobank network
	 */
	@Override
	public D2BiobankNetwork create(long d2biobanknetworkId) {
		D2BiobankNetwork d2BiobankNetwork = new D2BiobankNetworkImpl();

		d2BiobankNetwork.setNew(true);
		d2BiobankNetwork.setPrimaryKey(d2biobanknetworkId);

		String uuid = PortalUUIDUtil.generate();

		d2BiobankNetwork.setUuid(uuid);

		return d2BiobankNetwork;
	}

	/**
	 * Removes the d2 biobank network with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param d2biobanknetworkId the primary key of the d2 biobank network
	 * @return the d2 biobank network that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork remove(long d2biobanknetworkId)
		throws NoSuchD2BiobankNetworkException, SystemException {
		return remove((Serializable)d2biobanknetworkId);
	}

	/**
	 * Removes the d2 biobank network with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the d2 biobank network
	 * @return the d2 biobank network that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork remove(Serializable primaryKey)
		throws NoSuchD2BiobankNetworkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			D2BiobankNetwork d2BiobankNetwork = (D2BiobankNetwork)session.get(D2BiobankNetworkImpl.class,
					primaryKey);

			if (d2BiobankNetwork == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchD2BiobankNetworkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(d2BiobankNetwork);
		}
		catch (NoSuchD2BiobankNetworkException nsee) {
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
	protected D2BiobankNetwork removeImpl(D2BiobankNetwork d2BiobankNetwork)
		throws SystemException {
		d2BiobankNetwork = toUnwrappedModel(d2BiobankNetwork);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(d2BiobankNetwork)) {
				d2BiobankNetwork = (D2BiobankNetwork)session.get(D2BiobankNetworkImpl.class,
						d2BiobankNetwork.getPrimaryKeyObj());
			}

			if (d2BiobankNetwork != null) {
				session.delete(d2BiobankNetwork);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (d2BiobankNetwork != null) {
			clearCache(d2BiobankNetwork);
		}

		return d2BiobankNetwork;
	}

	@Override
	public D2BiobankNetwork updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork d2BiobankNetwork)
		throws SystemException {
		d2BiobankNetwork = toUnwrappedModel(d2BiobankNetwork);

		boolean isNew = d2BiobankNetwork.isNew();

		D2BiobankNetworkModelImpl d2BiobankNetworkModelImpl = (D2BiobankNetworkModelImpl)d2BiobankNetwork;

		if (Validator.isNull(d2BiobankNetwork.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			d2BiobankNetwork.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (d2BiobankNetwork.isNew()) {
				session.save(d2BiobankNetwork);

				d2BiobankNetwork.setNew(false);
			}
			else {
				session.merge(d2BiobankNetwork);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !D2BiobankNetworkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((d2BiobankNetworkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankNetworkModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { d2BiobankNetworkModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((d2BiobankNetworkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankNetworkModelImpl.getOriginalUuid(),
						d2BiobankNetworkModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						d2BiobankNetworkModelImpl.getUuid(),
						d2BiobankNetworkModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkImpl.class, d2BiobankNetwork.getPrimaryKey(),
			d2BiobankNetwork);

		clearUniqueFindersCache(d2BiobankNetwork);
		cacheUniqueFindersCache(d2BiobankNetwork);

		return d2BiobankNetwork;
	}

	protected D2BiobankNetwork toUnwrappedModel(
		D2BiobankNetwork d2BiobankNetwork) {
		if (d2BiobankNetwork instanceof D2BiobankNetworkImpl) {
			return d2BiobankNetwork;
		}

		D2BiobankNetworkImpl d2BiobankNetworkImpl = new D2BiobankNetworkImpl();

		d2BiobankNetworkImpl.setNew(d2BiobankNetwork.isNew());
		d2BiobankNetworkImpl.setPrimaryKey(d2BiobankNetwork.getPrimaryKey());

		d2BiobankNetworkImpl.setUuid(d2BiobankNetwork.getUuid());
		d2BiobankNetworkImpl.setD2biobanknetworkId(d2BiobankNetwork.getD2biobanknetworkId());
		d2BiobankNetworkImpl.setParentd2biobanknetworkId(d2BiobankNetwork.getParentd2biobanknetworkId());
		d2BiobankNetworkImpl.setStatus(d2BiobankNetwork.getStatus());
		d2BiobankNetworkImpl.setStatusByUserId(d2BiobankNetwork.getStatusByUserId());
		d2BiobankNetworkImpl.setStatusByUserName(d2BiobankNetwork.getStatusByUserName());
		d2BiobankNetworkImpl.setStatusDate(d2BiobankNetwork.getStatusDate());
		d2BiobankNetworkImpl.setCompanyId(d2BiobankNetwork.getCompanyId());
		d2BiobankNetworkImpl.setGroupId(d2BiobankNetwork.getGroupId());
		d2BiobankNetworkImpl.setUserId(d2BiobankNetwork.getUserId());
		d2BiobankNetworkImpl.setUserName(d2BiobankNetwork.getUserName());
		d2BiobankNetworkImpl.setCreateDate(d2BiobankNetwork.getCreateDate());
		d2BiobankNetworkImpl.setModifiedDate(d2BiobankNetwork.getModifiedDate());
		d2BiobankNetworkImpl.setUpdateuuid(d2BiobankNetwork.getUpdateuuid());
		d2BiobankNetworkImpl.setContactIDRef(d2BiobankNetwork.getContactIDRef());
		d2BiobankNetworkImpl.setContactPriority(d2BiobankNetwork.getContactPriority());
		d2BiobankNetworkImpl.setBbmriBiobankNetworkID(d2BiobankNetwork.getBbmriBiobankNetworkID());
		d2BiobankNetworkImpl.setBiobankNetworkName(d2BiobankNetwork.getBiobankNetworkName());
		d2BiobankNetworkImpl.setBiobankNetworkCommonCollectionFocus(d2BiobankNetwork.isBiobankNetworkCommonCollectionFocus());
		d2BiobankNetworkImpl.setBiobankNetworkCommonCharter(d2BiobankNetwork.isBiobankNetworkCommonCharter());
		d2BiobankNetworkImpl.setBiobankNetworkCommonSOPs(d2BiobankNetwork.isBiobankNetworkCommonSOPs());
		d2BiobankNetworkImpl.setBiobankNetworkCommonDataAccessPolicy(d2BiobankNetwork.isBiobankNetworkCommonDataAccessPolicy());
		d2BiobankNetworkImpl.setBiobankNetworkCommonSampleAccessPolicy(d2BiobankNetwork.isBiobankNetworkCommonSampleAccessPolicy());
		d2BiobankNetworkImpl.setBiobankNetworkCommonMTA(d2BiobankNetwork.isBiobankNetworkCommonMTA());
		d2BiobankNetworkImpl.setBiobankNetworkCommonRepresentation(d2BiobankNetwork.isBiobankNetworkCommonRepresentation());
		d2BiobankNetworkImpl.setBiobankNetworkCommonURL(d2BiobankNetwork.isBiobankNetworkCommonURL());
		d2BiobankNetworkImpl.setBiobankNetworkIDRef(d2BiobankNetwork.getBiobankNetworkIDRef());
		d2BiobankNetworkImpl.setGeoLatitude(d2BiobankNetwork.getGeoLatitude());
		d2BiobankNetworkImpl.setGeoLongitude(d2BiobankNetwork.getGeoLongitude());
		d2BiobankNetworkImpl.setBiobankNetworkAcronym(d2BiobankNetwork.getBiobankNetworkAcronym());
		d2BiobankNetworkImpl.setBiobankNetworkDescription(d2BiobankNetwork.getBiobankNetworkDescription());
		d2BiobankNetworkImpl.setBiobankNetworkURL(d2BiobankNetwork.getBiobankNetworkURL());
		d2BiobankNetworkImpl.setBiobankNetworkJuridicalPerson(d2BiobankNetwork.getBiobankNetworkJuridicalPerson());

		return d2BiobankNetworkImpl;
	}

	/**
	 * Returns the d2 biobank network with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the d2 biobank network
	 * @return the d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork findByPrimaryKey(Serializable primaryKey)
		throws NoSuchD2BiobankNetworkException, SystemException {
		D2BiobankNetwork d2BiobankNetwork = fetchByPrimaryKey(primaryKey);

		if (d2BiobankNetwork == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchD2BiobankNetworkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return d2BiobankNetwork;
	}

	/**
	 * Returns the d2 biobank network with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException} if it could not be found.
	 *
	 * @param d2biobanknetworkId the primary key of the d2 biobank network
	 * @return the d2 biobank network
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork findByPrimaryKey(long d2biobanknetworkId)
		throws NoSuchD2BiobankNetworkException, SystemException {
		return findByPrimaryKey((Serializable)d2biobanknetworkId);
	}

	/**
	 * Returns the d2 biobank network with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the d2 biobank network
	 * @return the d2 biobank network, or <code>null</code> if a d2 biobank network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		D2BiobankNetwork d2BiobankNetwork = (D2BiobankNetwork)EntityCacheUtil.getResult(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
				D2BiobankNetworkImpl.class, primaryKey);

		if (d2BiobankNetwork == _nullD2BiobankNetwork) {
			return null;
		}

		if (d2BiobankNetwork == null) {
			Session session = null;

			try {
				session = openSession();

				d2BiobankNetwork = (D2BiobankNetwork)session.get(D2BiobankNetworkImpl.class,
						primaryKey);

				if (d2BiobankNetwork != null) {
					cacheResult(d2BiobankNetwork);
				}
				else {
					EntityCacheUtil.putResult(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
						D2BiobankNetworkImpl.class, primaryKey,
						_nullD2BiobankNetwork);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(D2BiobankNetworkModelImpl.ENTITY_CACHE_ENABLED,
					D2BiobankNetworkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return d2BiobankNetwork;
	}

	/**
	 * Returns the d2 biobank network with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param d2biobanknetworkId the primary key of the d2 biobank network
	 * @return the d2 biobank network, or <code>null</code> if a d2 biobank network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetwork fetchByPrimaryKey(long d2biobanknetworkId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)d2biobanknetworkId);
	}

	/**
	 * Returns all the d2 biobank networks.
	 *
	 * @return the d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetwork> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobank networks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d2 biobank networks
	 * @param end the upper bound of the range of d2 biobank networks (not inclusive)
	 * @return the range of d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetwork> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobank networks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d2 biobank networks
	 * @param end the upper bound of the range of d2 biobank networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of d2 biobank networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetwork> findAll(int start, int end,
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

		List<D2BiobankNetwork> list = (List<D2BiobankNetwork>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_D2BIOBANKNETWORK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_D2BIOBANKNETWORK;

				if (pagination) {
					sql = sql.concat(D2BiobankNetworkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<D2BiobankNetwork>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2BiobankNetwork>(list);
				}
				else {
					list = (List<D2BiobankNetwork>)QueryUtil.list(q,
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
	 * Removes all the d2 biobank networks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (D2BiobankNetwork d2BiobankNetwork : findAll()) {
			remove(d2BiobankNetwork);
		}
	}

	/**
	 * Returns the number of d2 biobank networks.
	 *
	 * @return the number of d2 biobank networks
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

				Query q = session.createQuery(_SQL_COUNT_D2BIOBANKNETWORK);

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
	 * Initializes the d2 biobank network persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<D2BiobankNetwork>> listenersList = new ArrayList<ModelListener<D2BiobankNetwork>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<D2BiobankNetwork>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(D2BiobankNetworkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_D2BIOBANKNETWORK = "SELECT d2BiobankNetwork FROM D2BiobankNetwork d2BiobankNetwork";
	private static final String _SQL_SELECT_D2BIOBANKNETWORK_WHERE = "SELECT d2BiobankNetwork FROM D2BiobankNetwork d2BiobankNetwork WHERE ";
	private static final String _SQL_COUNT_D2BIOBANKNETWORK = "SELECT COUNT(d2BiobankNetwork) FROM D2BiobankNetwork d2BiobankNetwork";
	private static final String _SQL_COUNT_D2BIOBANKNETWORK_WHERE = "SELECT COUNT(d2BiobankNetwork) FROM D2BiobankNetwork d2BiobankNetwork WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "d2BiobankNetwork.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No D2BiobankNetwork exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No D2BiobankNetwork exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(D2BiobankNetworkPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static D2BiobankNetwork _nullD2BiobankNetwork = new D2BiobankNetworkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<D2BiobankNetwork> toCacheModel() {
				return _nullD2BiobankNetworkCacheModel;
			}
		};

	private static CacheModel<D2BiobankNetwork> _nullD2BiobankNetworkCacheModel = new CacheModel<D2BiobankNetwork>() {
			@Override
			public D2BiobankNetwork toEntityModel() {
				return _nullD2BiobankNetwork;
			}
		};
}