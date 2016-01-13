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

import at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException;
import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkImpl;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl;

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
 * The persistence implementation for the d2 biobank network link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see D2BiobankNetworkLinkPersistence
 * @see D2BiobankNetworkLinkUtil
 * @generated
 */
public class D2BiobankNetworkLinkPersistenceImpl extends BasePersistenceImpl<D2BiobankNetworkLink>
	implements D2BiobankNetworkLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link D2BiobankNetworkLinkUtil} to access the d2 biobank network link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = D2BiobankNetworkLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			D2BiobankNetworkLinkModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the d2 biobank network links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobank network links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of d2 biobank network links
	 * @param end the upper bound of the range of d2 biobank network links (not inclusive)
	 * @return the range of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobank network links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of d2 biobank network links
	 * @param end the upper bound of the range of d2 biobank network links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<D2BiobankNetworkLink> list = (List<D2BiobankNetworkLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2BiobankNetworkLink d2BiobankNetworkLink : list) {
				if (!Validator.equals(uuid, d2BiobankNetworkLink.getUuid())) {
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

			query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE);

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
				query.append(D2BiobankNetworkLinkModelImpl.ORDER_BY_JPQL);
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
					list = (List<D2BiobankNetworkLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2BiobankNetworkLink>(list);
				}
				else {
					list = (List<D2BiobankNetworkLink>)QueryUtil.list(q,
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
	 * Returns the first d2 biobank network link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByUuid_First(uuid,
				orderByComparator);

		if (d2BiobankNetworkLink != null) {
			return d2BiobankNetworkLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkLinkException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank network link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2BiobankNetworkLink> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank network link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByUuid_Last(uuid,
				orderByComparator);

		if (d2BiobankNetworkLink != null) {
			return d2BiobankNetworkLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkLinkException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank network link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<D2BiobankNetworkLink> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobank network links before and after the current d2 biobank network link in the ordered set where uuid = &#63;.
	 *
	 * @param d2biobanknetworklinkId the primary key of the current d2 biobank network link
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink[] findByUuid_PrevAndNext(
		long d2biobanknetworklinkId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = findByPrimaryKey(d2biobanknetworklinkId);

		Session session = null;

		try {
			session = openSession();

			D2BiobankNetworkLink[] array = new D2BiobankNetworkLinkImpl[3];

			array[0] = getByUuid_PrevAndNext(session, d2BiobankNetworkLink,
					uuid, orderByComparator, true);

			array[1] = d2BiobankNetworkLink;

			array[2] = getByUuid_PrevAndNext(session, d2BiobankNetworkLink,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected D2BiobankNetworkLink getByUuid_PrevAndNext(Session session,
		D2BiobankNetworkLink d2BiobankNetworkLink, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE);

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
			query.append(D2BiobankNetworkLinkModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(d2BiobankNetworkLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2BiobankNetworkLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobank network links where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (D2BiobankNetworkLink d2BiobankNetworkLink : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2BiobankNetworkLink);
		}
	}

	/**
	 * Returns the number of d2 biobank network links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching d2 biobank network links
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

			query.append(_SQL_COUNT_D2BIOBANKNETWORKLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "d2BiobankNetworkLink.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "d2BiobankNetworkLink.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(d2BiobankNetworkLink.uuid IS NULL OR d2BiobankNetworkLink.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			D2BiobankNetworkLinkModelImpl.UUID_COLUMN_BITMASK |
			D2BiobankNetworkLinkModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the d2 biobank network link where uuid = &#63; and groupId = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByUUID_G(String uuid, long groupId)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByUUID_G(uuid, groupId);

		if (d2BiobankNetworkLink == null) {
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

			throw new NoSuchD2BiobankNetworkLinkException(msg.toString());
		}

		return d2BiobankNetworkLink;
	}

	/**
	 * Returns the d2 biobank network link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the d2 biobank network link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof D2BiobankNetworkLink) {
			D2BiobankNetworkLink d2BiobankNetworkLink = (D2BiobankNetworkLink)result;

			if (!Validator.equals(uuid, d2BiobankNetworkLink.getUuid()) ||
					(groupId != d2BiobankNetworkLink.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE);

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

				List<D2BiobankNetworkLink> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					D2BiobankNetworkLink d2BiobankNetworkLink = list.get(0);

					result = d2BiobankNetworkLink;

					cacheResult(d2BiobankNetworkLink);

					if ((d2BiobankNetworkLink.getUuid() == null) ||
							!d2BiobankNetworkLink.getUuid().equals(uuid) ||
							(d2BiobankNetworkLink.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, d2BiobankNetworkLink);
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
			return (D2BiobankNetworkLink)result;
		}
	}

	/**
	 * Removes the d2 biobank network link where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the d2 biobank network link that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink removeByUUID_G(String uuid, long groupId)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = findByUUID_G(uuid, groupId);

		return remove(d2BiobankNetworkLink);
	}

	/**
	 * Returns the number of d2 biobank network links where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching d2 biobank network links
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

			query.append(_SQL_COUNT_D2BIOBANKNETWORKLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "d2BiobankNetworkLink.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "d2BiobankNetworkLink.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(d2BiobankNetworkLink.uuid IS NULL OR d2BiobankNetworkLink.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "d2BiobankNetworkLink.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			D2BiobankNetworkLinkModelImpl.UUID_COLUMN_BITMASK |
			D2BiobankNetworkLinkModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the d2 biobank network links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobank network links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of d2 biobank network links
	 * @param end the upper bound of the range of d2 biobank network links (not inclusive)
	 * @return the range of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobank network links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of d2 biobank network links
	 * @param end the upper bound of the range of d2 biobank network links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByUuid_C(String uuid, long companyId,
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

		List<D2BiobankNetworkLink> list = (List<D2BiobankNetworkLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2BiobankNetworkLink d2BiobankNetworkLink : list) {
				if (!Validator.equals(uuid, d2BiobankNetworkLink.getUuid()) ||
						(companyId != d2BiobankNetworkLink.getCompanyId())) {
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

			query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE);

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
				query.append(D2BiobankNetworkLinkModelImpl.ORDER_BY_JPQL);
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
					list = (List<D2BiobankNetworkLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2BiobankNetworkLink>(list);
				}
				else {
					list = (List<D2BiobankNetworkLink>)QueryUtil.list(q,
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
	 * Returns the first d2 biobank network link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (d2BiobankNetworkLink != null) {
			return d2BiobankNetworkLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkLinkException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank network link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<D2BiobankNetworkLink> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank network link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (d2BiobankNetworkLink != null) {
			return d2BiobankNetworkLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkLinkException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank network link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<D2BiobankNetworkLink> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobank network links before and after the current d2 biobank network link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param d2biobanknetworklinkId the primary key of the current d2 biobank network link
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink[] findByUuid_C_PrevAndNext(
		long d2biobanknetworklinkId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = findByPrimaryKey(d2biobanknetworklinkId);

		Session session = null;

		try {
			session = openSession();

			D2BiobankNetworkLink[] array = new D2BiobankNetworkLinkImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, d2BiobankNetworkLink,
					uuid, companyId, orderByComparator, true);

			array[1] = d2BiobankNetworkLink;

			array[2] = getByUuid_C_PrevAndNext(session, d2BiobankNetworkLink,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected D2BiobankNetworkLink getByUuid_C_PrevAndNext(Session session,
		D2BiobankNetworkLink d2BiobankNetworkLink, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE);

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
			query.append(D2BiobankNetworkLinkModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(d2BiobankNetworkLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2BiobankNetworkLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobank network links where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (D2BiobankNetworkLink d2BiobankNetworkLink : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2BiobankNetworkLink);
		}
	}

	/**
	 * Returns the number of d2 biobank network links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching d2 biobank network links
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

			query.append(_SQL_COUNT_D2BIOBANKNETWORKLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "d2BiobankNetworkLink.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "d2BiobankNetworkLink.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(d2BiobankNetworkLink.uuid IS NULL OR d2BiobankNetworkLink.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "d2BiobankNetworkLink.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NETWORKLINKBYCHILD = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByNetworkLinkByChild",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			D2BiobankNetworkLinkModelImpl.D2BIOBANKNETWORKID_COLUMN_BITMASK |
			D2BiobankNetworkLinkModelImpl.D2LINKID_COLUMN_BITMASK |
			D2BiobankNetworkLinkModelImpl.D2LINKTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NETWORKLINKBYCHILD = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNetworkLinkByChild",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the d2 biobank network link where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException} if it could not be found.
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @return the matching d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByNetworkLinkByChild(
		long d2biobanknetworkId, long d2linkId, String d2linktype)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByNetworkLinkByChild(d2biobanknetworkId,
				d2linkId, d2linktype);

		if (d2BiobankNetworkLink == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("d2biobanknetworkId=");
			msg.append(d2biobanknetworkId);

			msg.append(", d2linkId=");
			msg.append(d2linkId);

			msg.append(", d2linktype=");
			msg.append(d2linktype);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchD2BiobankNetworkLinkException(msg.toString());
		}

		return d2BiobankNetworkLink;
	}

	/**
	 * Returns the d2 biobank network link where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @return the matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByNetworkLinkByChild(
		long d2biobanknetworkId, long d2linkId, String d2linktype)
		throws SystemException {
		return fetchByNetworkLinkByChild(d2biobanknetworkId, d2linkId,
			d2linktype, true);
	}

	/**
	 * Returns the d2 biobank network link where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByNetworkLinkByChild(
		long d2biobanknetworkId, long d2linkId, String d2linktype,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				d2biobanknetworkId, d2linkId, d2linktype
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NETWORKLINKBYCHILD,
					finderArgs, this);
		}

		if (result instanceof D2BiobankNetworkLink) {
			D2BiobankNetworkLink d2BiobankNetworkLink = (D2BiobankNetworkLink)result;

			if ((d2biobanknetworkId != d2BiobankNetworkLink.getD2biobanknetworkId()) ||
					(d2linkId != d2BiobankNetworkLink.getD2linkId()) ||
					!Validator.equals(d2linktype,
						d2BiobankNetworkLink.getD2linktype())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE);

			query.append(_FINDER_COLUMN_NETWORKLINKBYCHILD_D2BIOBANKNETWORKID_2);

			query.append(_FINDER_COLUMN_NETWORKLINKBYCHILD_D2LINKID_2);

			boolean bindD2linktype = false;

			if (d2linktype == null) {
				query.append(_FINDER_COLUMN_NETWORKLINKBYCHILD_D2LINKTYPE_1);
			}
			else if (d2linktype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NETWORKLINKBYCHILD_D2LINKTYPE_3);
			}
			else {
				bindD2linktype = true;

				query.append(_FINDER_COLUMN_NETWORKLINKBYCHILD_D2LINKTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(d2biobanknetworkId);

				qPos.add(d2linkId);

				if (bindD2linktype) {
					qPos.add(d2linktype);
				}

				List<D2BiobankNetworkLink> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NETWORKLINKBYCHILD,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"D2BiobankNetworkLinkPersistenceImpl.fetchByNetworkLinkByChild(long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					D2BiobankNetworkLink d2BiobankNetworkLink = list.get(0);

					result = d2BiobankNetworkLink;

					cacheResult(d2BiobankNetworkLink);

					if ((d2BiobankNetworkLink.getD2biobanknetworkId() != d2biobanknetworkId) ||
							(d2BiobankNetworkLink.getD2linkId() != d2linkId) ||
							(d2BiobankNetworkLink.getD2linktype() == null) ||
							!d2BiobankNetworkLink.getD2linktype()
													 .equals(d2linktype)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NETWORKLINKBYCHILD,
							finderArgs, d2BiobankNetworkLink);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NETWORKLINKBYCHILD,
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
			return (D2BiobankNetworkLink)result;
		}
	}

	/**
	 * Removes the d2 biobank network link where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63; from the database.
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @return the d2 biobank network link that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink removeByNetworkLinkByChild(
		long d2biobanknetworkId, long d2linkId, String d2linktype)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = findByNetworkLinkByChild(d2biobanknetworkId,
				d2linkId, d2linktype);

		return remove(d2BiobankNetworkLink);
	}

	/**
	 * Returns the number of d2 biobank network links where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @return the number of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNetworkLinkByChild(long d2biobanknetworkId,
		long d2linkId, String d2linktype) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NETWORKLINKBYCHILD;

		Object[] finderArgs = new Object[] {
				d2biobanknetworkId, d2linkId, d2linktype
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_D2BIOBANKNETWORKLINK_WHERE);

			query.append(_FINDER_COLUMN_NETWORKLINKBYCHILD_D2BIOBANKNETWORKID_2);

			query.append(_FINDER_COLUMN_NETWORKLINKBYCHILD_D2LINKID_2);

			boolean bindD2linktype = false;

			if (d2linktype == null) {
				query.append(_FINDER_COLUMN_NETWORKLINKBYCHILD_D2LINKTYPE_1);
			}
			else if (d2linktype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NETWORKLINKBYCHILD_D2LINKTYPE_3);
			}
			else {
				bindD2linktype = true;

				query.append(_FINDER_COLUMN_NETWORKLINKBYCHILD_D2LINKTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(d2biobanknetworkId);

				qPos.add(d2linkId);

				if (bindD2linktype) {
					qPos.add(d2linktype);
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

	private static final String _FINDER_COLUMN_NETWORKLINKBYCHILD_D2BIOBANKNETWORKID_2 =
		"d2BiobankNetworkLink.d2biobanknetworkId = ? AND ";
	private static final String _FINDER_COLUMN_NETWORKLINKBYCHILD_D2LINKID_2 = "d2BiobankNetworkLink.d2linkId = ? AND ";
	private static final String _FINDER_COLUMN_NETWORKLINKBYCHILD_D2LINKTYPE_1 = "d2BiobankNetworkLink.d2linktype IS NULL";
	private static final String _FINDER_COLUMN_NETWORKLINKBYCHILD_D2LINKTYPE_2 = "d2BiobankNetworkLink.d2linktype = ?";
	private static final String _FINDER_COLUMN_NETWORKLINKBYCHILD_D2LINKTYPE_3 = "(d2BiobankNetworkLink.d2linktype IS NULL OR d2BiobankNetworkLink.d2linktype = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NETWORKLINKSFORCHILD =
		new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNetworkLinksForChild",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NETWORKLINKSFORCHILD =
		new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNetworkLinksForChild",
			new String[] { Long.class.getName(), String.class.getName() },
			D2BiobankNetworkLinkModelImpl.D2LINKID_COLUMN_BITMASK |
			D2BiobankNetworkLinkModelImpl.D2LINKTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NETWORKLINKSFORCHILD = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNetworkLinksForChild",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the d2 biobank network links where d2linkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @return the matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByNetworkLinksForChild(
		long d2linkId, String d2linktype) throws SystemException {
		return findByNetworkLinksForChild(d2linkId, d2linktype,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobank network links where d2linkId = &#63; and d2linktype = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @param start the lower bound of the range of d2 biobank network links
	 * @param end the upper bound of the range of d2 biobank network links (not inclusive)
	 * @return the range of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByNetworkLinksForChild(
		long d2linkId, String d2linktype, int start, int end)
		throws SystemException {
		return findByNetworkLinksForChild(d2linkId, d2linktype, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobank network links where d2linkId = &#63; and d2linktype = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @param start the lower bound of the range of d2 biobank network links
	 * @param end the upper bound of the range of d2 biobank network links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByNetworkLinksForChild(
		long d2linkId, String d2linktype, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NETWORKLINKSFORCHILD;
			finderArgs = new Object[] { d2linkId, d2linktype };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NETWORKLINKSFORCHILD;
			finderArgs = new Object[] {
					d2linkId, d2linktype,
					
					start, end, orderByComparator
				};
		}

		List<D2BiobankNetworkLink> list = (List<D2BiobankNetworkLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2BiobankNetworkLink d2BiobankNetworkLink : list) {
				if ((d2linkId != d2BiobankNetworkLink.getD2linkId()) ||
						!Validator.equals(d2linktype,
							d2BiobankNetworkLink.getD2linktype())) {
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

			query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE);

			query.append(_FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKID_2);

			boolean bindD2linktype = false;

			if (d2linktype == null) {
				query.append(_FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKTYPE_1);
			}
			else if (d2linktype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKTYPE_3);
			}
			else {
				bindD2linktype = true;

				query.append(_FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2BiobankNetworkLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(d2linkId);

				if (bindD2linktype) {
					qPos.add(d2linktype);
				}

				if (!pagination) {
					list = (List<D2BiobankNetworkLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2BiobankNetworkLink>(list);
				}
				else {
					list = (List<D2BiobankNetworkLink>)QueryUtil.list(q,
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
	 * Returns the first d2 biobank network link in the ordered set where d2linkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByNetworkLinksForChild_First(
		long d2linkId, String d2linktype, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByNetworkLinksForChild_First(d2linkId,
				d2linktype, orderByComparator);

		if (d2BiobankNetworkLink != null) {
			return d2BiobankNetworkLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("d2linkId=");
		msg.append(d2linkId);

		msg.append(", d2linktype=");
		msg.append(d2linktype);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkLinkException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank network link in the ordered set where d2linkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByNetworkLinksForChild_First(
		long d2linkId, String d2linktype, OrderByComparator orderByComparator)
		throws SystemException {
		List<D2BiobankNetworkLink> list = findByNetworkLinksForChild(d2linkId,
				d2linktype, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank network link in the ordered set where d2linkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByNetworkLinksForChild_Last(long d2linkId,
		String d2linktype, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByNetworkLinksForChild_Last(d2linkId,
				d2linktype, orderByComparator);

		if (d2BiobankNetworkLink != null) {
			return d2BiobankNetworkLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("d2linkId=");
		msg.append(d2linkId);

		msg.append(", d2linktype=");
		msg.append(d2linktype);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkLinkException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank network link in the ordered set where d2linkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByNetworkLinksForChild_Last(
		long d2linkId, String d2linktype, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByNetworkLinksForChild(d2linkId, d2linktype);

		if (count == 0) {
			return null;
		}

		List<D2BiobankNetworkLink> list = findByNetworkLinksForChild(d2linkId,
				d2linktype, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobank network links before and after the current d2 biobank network link in the ordered set where d2linkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2biobanknetworklinkId the primary key of the current d2 biobank network link
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink[] findByNetworkLinksForChild_PrevAndNext(
		long d2biobanknetworklinkId, long d2linkId, String d2linktype,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = findByPrimaryKey(d2biobanknetworklinkId);

		Session session = null;

		try {
			session = openSession();

			D2BiobankNetworkLink[] array = new D2BiobankNetworkLinkImpl[3];

			array[0] = getByNetworkLinksForChild_PrevAndNext(session,
					d2BiobankNetworkLink, d2linkId, d2linktype,
					orderByComparator, true);

			array[1] = d2BiobankNetworkLink;

			array[2] = getByNetworkLinksForChild_PrevAndNext(session,
					d2BiobankNetworkLink, d2linkId, d2linktype,
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

	protected D2BiobankNetworkLink getByNetworkLinksForChild_PrevAndNext(
		Session session, D2BiobankNetworkLink d2BiobankNetworkLink,
		long d2linkId, String d2linktype, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE);

		query.append(_FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKID_2);

		boolean bindD2linktype = false;

		if (d2linktype == null) {
			query.append(_FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKTYPE_1);
		}
		else if (d2linktype.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKTYPE_3);
		}
		else {
			bindD2linktype = true;

			query.append(_FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKTYPE_2);
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
			query.append(D2BiobankNetworkLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(d2linkId);

		if (bindD2linktype) {
			qPos.add(d2linktype);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2BiobankNetworkLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2BiobankNetworkLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobank network links where d2linkId = &#63; and d2linktype = &#63; from the database.
	 *
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNetworkLinksForChild(long d2linkId, String d2linktype)
		throws SystemException {
		for (D2BiobankNetworkLink d2BiobankNetworkLink : findByNetworkLinksForChild(
				d2linkId, d2linktype, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2BiobankNetworkLink);
		}
	}

	/**
	 * Returns the number of d2 biobank network links where d2linkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2linkId the d2link ID
	 * @param d2linktype the d2linktype
	 * @return the number of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNetworkLinksForChild(long d2linkId, String d2linktype)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NETWORKLINKSFORCHILD;

		Object[] finderArgs = new Object[] { d2linkId, d2linktype };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_D2BIOBANKNETWORKLINK_WHERE);

			query.append(_FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKID_2);

			boolean bindD2linktype = false;

			if (d2linktype == null) {
				query.append(_FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKTYPE_1);
			}
			else if (d2linktype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKTYPE_3);
			}
			else {
				bindD2linktype = true;

				query.append(_FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(d2linkId);

				if (bindD2linktype) {
					qPos.add(d2linktype);
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

	private static final String _FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKID_2 = "d2BiobankNetworkLink.d2linkId = ? AND ";
	private static final String _FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKTYPE_1 =
		"d2BiobankNetworkLink.d2linktype IS NULL";
	private static final String _FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKTYPE_2 =
		"d2BiobankNetworkLink.d2linktype = ?";
	private static final String _FINDER_COLUMN_NETWORKLINKSFORCHILD_D2LINKTYPE_3 =
		"(d2BiobankNetworkLink.d2linktype IS NULL OR d2BiobankNetworkLink.d2linktype = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHILDFORNETWORKLINKS =
		new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByChildForNetworkLinks",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDFORNETWORKLINKS =
		new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByChildForNetworkLinks",
			new String[] { Long.class.getName(), String.class.getName() },
			D2BiobankNetworkLinkModelImpl.D2BIOBANKNETWORKID_COLUMN_BITMASK |
			D2BiobankNetworkLinkModelImpl.D2LINKTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHILDFORNETWORKLINKS = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChildForNetworkLinks",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linktype the d2linktype
	 * @return the matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByChildForNetworkLinks(
		long d2biobanknetworkId, String d2linktype) throws SystemException {
		return findByChildForNetworkLinks(d2biobanknetworkId, d2linktype,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linktype the d2linktype
	 * @param start the lower bound of the range of d2 biobank network links
	 * @param end the upper bound of the range of d2 biobank network links (not inclusive)
	 * @return the range of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByChildForNetworkLinks(
		long d2biobanknetworkId, String d2linktype, int start, int end)
		throws SystemException {
		return findByChildForNetworkLinks(d2biobanknetworkId, d2linktype,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linktype the d2linktype
	 * @param start the lower bound of the range of d2 biobank network links
	 * @param end the upper bound of the range of d2 biobank network links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByChildForNetworkLinks(
		long d2biobanknetworkId, String d2linktype, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDFORNETWORKLINKS;
			finderArgs = new Object[] { d2biobanknetworkId, d2linktype };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHILDFORNETWORKLINKS;
			finderArgs = new Object[] {
					d2biobanknetworkId, d2linktype,
					
					start, end, orderByComparator
				};
		}

		List<D2BiobankNetworkLink> list = (List<D2BiobankNetworkLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2BiobankNetworkLink d2BiobankNetworkLink : list) {
				if ((d2biobanknetworkId != d2BiobankNetworkLink.getD2biobanknetworkId()) ||
						!Validator.equals(d2linktype,
							d2BiobankNetworkLink.getD2linktype())) {
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

			query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE);

			query.append(_FINDER_COLUMN_CHILDFORNETWORKLINKS_D2BIOBANKNETWORKID_2);

			boolean bindD2linktype = false;

			if (d2linktype == null) {
				query.append(_FINDER_COLUMN_CHILDFORNETWORKLINKS_D2LINKTYPE_1);
			}
			else if (d2linktype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHILDFORNETWORKLINKS_D2LINKTYPE_3);
			}
			else {
				bindD2linktype = true;

				query.append(_FINDER_COLUMN_CHILDFORNETWORKLINKS_D2LINKTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2BiobankNetworkLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(d2biobanknetworkId);

				if (bindD2linktype) {
					qPos.add(d2linktype);
				}

				if (!pagination) {
					list = (List<D2BiobankNetworkLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2BiobankNetworkLink>(list);
				}
				else {
					list = (List<D2BiobankNetworkLink>)QueryUtil.list(q,
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
	 * Returns the first d2 biobank network link in the ordered set where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linktype the d2linktype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByChildForNetworkLinks_First(
		long d2biobanknetworkId, String d2linktype,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByChildForNetworkLinks_First(d2biobanknetworkId,
				d2linktype, orderByComparator);

		if (d2BiobankNetworkLink != null) {
			return d2BiobankNetworkLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("d2biobanknetworkId=");
		msg.append(d2biobanknetworkId);

		msg.append(", d2linktype=");
		msg.append(d2linktype);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkLinkException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank network link in the ordered set where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linktype the d2linktype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByChildForNetworkLinks_First(
		long d2biobanknetworkId, String d2linktype,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2BiobankNetworkLink> list = findByChildForNetworkLinks(d2biobanknetworkId,
				d2linktype, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank network link in the ordered set where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linktype the d2linktype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByChildForNetworkLinks_Last(
		long d2biobanknetworkId, String d2linktype,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByChildForNetworkLinks_Last(d2biobanknetworkId,
				d2linktype, orderByComparator);

		if (d2BiobankNetworkLink != null) {
			return d2BiobankNetworkLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("d2biobanknetworkId=");
		msg.append(d2biobanknetworkId);

		msg.append(", d2linktype=");
		msg.append(d2linktype);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkLinkException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank network link in the ordered set where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linktype the d2linktype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByChildForNetworkLinks_Last(
		long d2biobanknetworkId, String d2linktype,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByChildForNetworkLinks(d2biobanknetworkId, d2linktype);

		if (count == 0) {
			return null;
		}

		List<D2BiobankNetworkLink> list = findByChildForNetworkLinks(d2biobanknetworkId,
				d2linktype, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobank network links before and after the current d2 biobank network link in the ordered set where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2biobanknetworklinkId the primary key of the current d2 biobank network link
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linktype the d2linktype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink[] findByChildForNetworkLinks_PrevAndNext(
		long d2biobanknetworklinkId, long d2biobanknetworkId,
		String d2linktype, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = findByPrimaryKey(d2biobanknetworklinkId);

		Session session = null;

		try {
			session = openSession();

			D2BiobankNetworkLink[] array = new D2BiobankNetworkLinkImpl[3];

			array[0] = getByChildForNetworkLinks_PrevAndNext(session,
					d2BiobankNetworkLink, d2biobanknetworkId, d2linktype,
					orderByComparator, true);

			array[1] = d2BiobankNetworkLink;

			array[2] = getByChildForNetworkLinks_PrevAndNext(session,
					d2BiobankNetworkLink, d2biobanknetworkId, d2linktype,
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

	protected D2BiobankNetworkLink getByChildForNetworkLinks_PrevAndNext(
		Session session, D2BiobankNetworkLink d2BiobankNetworkLink,
		long d2biobanknetworkId, String d2linktype,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE);

		query.append(_FINDER_COLUMN_CHILDFORNETWORKLINKS_D2BIOBANKNETWORKID_2);

		boolean bindD2linktype = false;

		if (d2linktype == null) {
			query.append(_FINDER_COLUMN_CHILDFORNETWORKLINKS_D2LINKTYPE_1);
		}
		else if (d2linktype.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CHILDFORNETWORKLINKS_D2LINKTYPE_3);
		}
		else {
			bindD2linktype = true;

			query.append(_FINDER_COLUMN_CHILDFORNETWORKLINKS_D2LINKTYPE_2);
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
			query.append(D2BiobankNetworkLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(d2biobanknetworkId);

		if (bindD2linktype) {
			qPos.add(d2linktype);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2BiobankNetworkLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2BiobankNetworkLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63; from the database.
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linktype the d2linktype
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByChildForNetworkLinks(long d2biobanknetworkId,
		String d2linktype) throws SystemException {
		for (D2BiobankNetworkLink d2BiobankNetworkLink : findByChildForNetworkLinks(
				d2biobanknetworkId, d2linktype, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(d2BiobankNetworkLink);
		}
	}

	/**
	 * Returns the number of d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	 *
	 * @param d2biobanknetworkId the d2biobanknetwork ID
	 * @param d2linktype the d2linktype
	 * @return the number of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByChildForNetworkLinks(long d2biobanknetworkId,
		String d2linktype) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CHILDFORNETWORKLINKS;

		Object[] finderArgs = new Object[] { d2biobanknetworkId, d2linktype };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_D2BIOBANKNETWORKLINK_WHERE);

			query.append(_FINDER_COLUMN_CHILDFORNETWORKLINKS_D2BIOBANKNETWORKID_2);

			boolean bindD2linktype = false;

			if (d2linktype == null) {
				query.append(_FINDER_COLUMN_CHILDFORNETWORKLINKS_D2LINKTYPE_1);
			}
			else if (d2linktype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHILDFORNETWORKLINKS_D2LINKTYPE_3);
			}
			else {
				bindD2linktype = true;

				query.append(_FINDER_COLUMN_CHILDFORNETWORKLINKS_D2LINKTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(d2biobanknetworkId);

				if (bindD2linktype) {
					qPos.add(d2linktype);
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

	private static final String _FINDER_COLUMN_CHILDFORNETWORKLINKS_D2BIOBANKNETWORKID_2 =
		"d2BiobankNetworkLink.d2biobanknetworkId = ? AND ";
	private static final String _FINDER_COLUMN_CHILDFORNETWORKLINKS_D2LINKTYPE_1 =
		"d2BiobankNetworkLink.d2linktype IS NULL";
	private static final String _FINDER_COLUMN_CHILDFORNETWORKLINKS_D2LINKTYPE_2 =
		"d2BiobankNetworkLink.d2linktype = ?";
	private static final String _FINDER_COLUMN_CHILDFORNETWORKLINKS_D2LINKTYPE_3 =
		"(d2BiobankNetworkLink.d2linktype IS NULL OR d2BiobankNetworkLink.d2linktype = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTUUID = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNotUUID",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTUUID = new FinderPath(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNotUUID",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @return the matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByNotUUID(long groupId,
		String updateuuid) throws SystemException {
		return findByNotUUID(groupId, updateuuid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param start the lower bound of the range of d2 biobank network links
	 * @param end the upper bound of the range of d2 biobank network links (not inclusive)
	 * @return the range of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByNotUUID(long groupId,
		String updateuuid, int start, int end) throws SystemException {
		return findByNotUUID(groupId, updateuuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param start the lower bound of the range of d2 biobank network links
	 * @param end the upper bound of the range of d2 biobank network links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findByNotUUID(long groupId,
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

		List<D2BiobankNetworkLink> list = (List<D2BiobankNetworkLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2BiobankNetworkLink d2BiobankNetworkLink : list) {
				if ((groupId != d2BiobankNetworkLink.getGroupId()) ||
						Validator.equals(updateuuid,
							d2BiobankNetworkLink.getUpdateuuid())) {
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

			query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE);

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
				query.append(D2BiobankNetworkLinkModelImpl.ORDER_BY_JPQL);
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
					list = (List<D2BiobankNetworkLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2BiobankNetworkLink>(list);
				}
				else {
					list = (List<D2BiobankNetworkLink>)QueryUtil.list(q,
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
	 * Returns the first d2 biobank network link in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByNotUUID_First(long groupId,
		String updateuuid, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByNotUUID_First(groupId,
				updateuuid, orderByComparator);

		if (d2BiobankNetworkLink != null) {
			return d2BiobankNetworkLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", updateuuid=");
		msg.append(updateuuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkLinkException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank network link in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByNotUUID_First(long groupId,
		String updateuuid, OrderByComparator orderByComparator)
		throws SystemException {
		List<D2BiobankNetworkLink> list = findByNotUUID(groupId, updateuuid, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank network link in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByNotUUID_Last(long groupId,
		String updateuuid, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByNotUUID_Last(groupId,
				updateuuid, orderByComparator);

		if (d2BiobankNetworkLink != null) {
			return d2BiobankNetworkLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", updateuuid=");
		msg.append(updateuuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankNetworkLinkException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank network link in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByNotUUID_Last(long groupId,
		String updateuuid, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByNotUUID(groupId, updateuuid);

		if (count == 0) {
			return null;
		}

		List<D2BiobankNetworkLink> list = findByNotUUID(groupId, updateuuid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobank network links before and after the current d2 biobank network link in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param d2biobanknetworklinkId the primary key of the current d2 biobank network link
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink[] findByNotUUID_PrevAndNext(
		long d2biobanknetworklinkId, long groupId, String updateuuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = findByPrimaryKey(d2biobanknetworklinkId);

		Session session = null;

		try {
			session = openSession();

			D2BiobankNetworkLink[] array = new D2BiobankNetworkLinkImpl[3];

			array[0] = getByNotUUID_PrevAndNext(session, d2BiobankNetworkLink,
					groupId, updateuuid, orderByComparator, true);

			array[1] = d2BiobankNetworkLink;

			array[2] = getByNotUUID_PrevAndNext(session, d2BiobankNetworkLink,
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

	protected D2BiobankNetworkLink getByNotUUID_PrevAndNext(Session session,
		D2BiobankNetworkLink d2BiobankNetworkLink, long groupId,
		String updateuuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE);

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
			query.append(D2BiobankNetworkLinkModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(d2BiobankNetworkLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2BiobankNetworkLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNotUUID(long groupId, String updateuuid)
		throws SystemException {
		for (D2BiobankNetworkLink d2BiobankNetworkLink : findByNotUUID(
				groupId, updateuuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2BiobankNetworkLink);
		}
	}

	/**
	 * Returns the number of d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @return the number of matching d2 biobank network links
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

			query.append(_SQL_COUNT_D2BIOBANKNETWORKLINK_WHERE);

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

	private static final String _FINDER_COLUMN_NOTUUID_GROUPID_2 = "d2BiobankNetworkLink.groupId = ? AND ";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_1 = "d2BiobankNetworkLink.updateuuid IS NOT NULL";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_2 = "d2BiobankNetworkLink.updateuuid != ?";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_3 = "(d2BiobankNetworkLink.updateuuid IS NULL OR d2BiobankNetworkLink.updateuuid != '')";

	public D2BiobankNetworkLinkPersistenceImpl() {
		setModelClass(D2BiobankNetworkLink.class);
	}

	/**
	 * Caches the d2 biobank network link in the entity cache if it is enabled.
	 *
	 * @param d2BiobankNetworkLink the d2 biobank network link
	 */
	@Override
	public void cacheResult(D2BiobankNetworkLink d2BiobankNetworkLink) {
		EntityCacheUtil.putResult(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			d2BiobankNetworkLink.getPrimaryKey(), d2BiobankNetworkLink);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				d2BiobankNetworkLink.getUuid(),
				d2BiobankNetworkLink.getGroupId()
			}, d2BiobankNetworkLink);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NETWORKLINKBYCHILD,
			new Object[] {
				d2BiobankNetworkLink.getD2biobanknetworkId(),
				d2BiobankNetworkLink.getD2linkId(),
				d2BiobankNetworkLink.getD2linktype()
			}, d2BiobankNetworkLink);

		d2BiobankNetworkLink.resetOriginalValues();
	}

	/**
	 * Caches the d2 biobank network links in the entity cache if it is enabled.
	 *
	 * @param d2BiobankNetworkLinks the d2 biobank network links
	 */
	@Override
	public void cacheResult(List<D2BiobankNetworkLink> d2BiobankNetworkLinks) {
		for (D2BiobankNetworkLink d2BiobankNetworkLink : d2BiobankNetworkLinks) {
			if (EntityCacheUtil.getResult(
						D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
						D2BiobankNetworkLinkImpl.class,
						d2BiobankNetworkLink.getPrimaryKey()) == null) {
				cacheResult(d2BiobankNetworkLink);
			}
			else {
				d2BiobankNetworkLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all d2 biobank network links.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(D2BiobankNetworkLinkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(D2BiobankNetworkLinkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the d2 biobank network link.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(D2BiobankNetworkLink d2BiobankNetworkLink) {
		EntityCacheUtil.removeResult(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class, d2BiobankNetworkLink.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(d2BiobankNetworkLink);
	}

	@Override
	public void clearCache(List<D2BiobankNetworkLink> d2BiobankNetworkLinks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (D2BiobankNetworkLink d2BiobankNetworkLink : d2BiobankNetworkLinks) {
			EntityCacheUtil.removeResult(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
				D2BiobankNetworkLinkImpl.class,
				d2BiobankNetworkLink.getPrimaryKey());

			clearUniqueFindersCache(d2BiobankNetworkLink);
		}
	}

	protected void cacheUniqueFindersCache(
		D2BiobankNetworkLink d2BiobankNetworkLink) {
		if (d2BiobankNetworkLink.isNew()) {
			Object[] args = new Object[] {
					d2BiobankNetworkLink.getUuid(),
					d2BiobankNetworkLink.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				d2BiobankNetworkLink);

			args = new Object[] {
					d2BiobankNetworkLink.getD2biobanknetworkId(),
					d2BiobankNetworkLink.getD2linkId(),
					d2BiobankNetworkLink.getD2linktype()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NETWORKLINKBYCHILD,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NETWORKLINKBYCHILD,
				args, d2BiobankNetworkLink);
		}
		else {
			D2BiobankNetworkLinkModelImpl d2BiobankNetworkLinkModelImpl = (D2BiobankNetworkLinkModelImpl)d2BiobankNetworkLink;

			if ((d2BiobankNetworkLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankNetworkLink.getUuid(),
						d2BiobankNetworkLink.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					d2BiobankNetworkLink);
			}

			if ((d2BiobankNetworkLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NETWORKLINKBYCHILD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankNetworkLink.getD2biobanknetworkId(),
						d2BiobankNetworkLink.getD2linkId(),
						d2BiobankNetworkLink.getD2linktype()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NETWORKLINKBYCHILD,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NETWORKLINKBYCHILD,
					args, d2BiobankNetworkLink);
			}
		}
	}

	protected void clearUniqueFindersCache(
		D2BiobankNetworkLink d2BiobankNetworkLink) {
		D2BiobankNetworkLinkModelImpl d2BiobankNetworkLinkModelImpl = (D2BiobankNetworkLinkModelImpl)d2BiobankNetworkLink;

		Object[] args = new Object[] {
				d2BiobankNetworkLink.getUuid(),
				d2BiobankNetworkLink.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((d2BiobankNetworkLinkModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					d2BiobankNetworkLinkModelImpl.getOriginalUuid(),
					d2BiobankNetworkLinkModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				d2BiobankNetworkLink.getD2biobanknetworkId(),
				d2BiobankNetworkLink.getD2linkId(),
				d2BiobankNetworkLink.getD2linktype()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NETWORKLINKBYCHILD,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NETWORKLINKBYCHILD,
			args);

		if ((d2BiobankNetworkLinkModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NETWORKLINKBYCHILD.getColumnBitmask()) != 0) {
			args = new Object[] {
					d2BiobankNetworkLinkModelImpl.getOriginalD2biobanknetworkId(),
					d2BiobankNetworkLinkModelImpl.getOriginalD2linkId(),
					d2BiobankNetworkLinkModelImpl.getOriginalD2linktype()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NETWORKLINKBYCHILD,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NETWORKLINKBYCHILD,
				args);
		}
	}

	/**
	 * Creates a new d2 biobank network link with the primary key. Does not add the d2 biobank network link to the database.
	 *
	 * @param d2biobanknetworklinkId the primary key for the new d2 biobank network link
	 * @return the new d2 biobank network link
	 */
	@Override
	public D2BiobankNetworkLink create(long d2biobanknetworklinkId) {
		D2BiobankNetworkLink d2BiobankNetworkLink = new D2BiobankNetworkLinkImpl();

		d2BiobankNetworkLink.setNew(true);
		d2BiobankNetworkLink.setPrimaryKey(d2biobanknetworklinkId);

		String uuid = PortalUUIDUtil.generate();

		d2BiobankNetworkLink.setUuid(uuid);

		return d2BiobankNetworkLink;
	}

	/**
	 * Removes the d2 biobank network link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param d2biobanknetworklinkId the primary key of the d2 biobank network link
	 * @return the d2 biobank network link that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink remove(long d2biobanknetworklinkId)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		return remove((Serializable)d2biobanknetworklinkId);
	}

	/**
	 * Removes the d2 biobank network link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the d2 biobank network link
	 * @return the d2 biobank network link that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink remove(Serializable primaryKey)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			D2BiobankNetworkLink d2BiobankNetworkLink = (D2BiobankNetworkLink)session.get(D2BiobankNetworkLinkImpl.class,
					primaryKey);

			if (d2BiobankNetworkLink == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchD2BiobankNetworkLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(d2BiobankNetworkLink);
		}
		catch (NoSuchD2BiobankNetworkLinkException nsee) {
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
	protected D2BiobankNetworkLink removeImpl(
		D2BiobankNetworkLink d2BiobankNetworkLink) throws SystemException {
		d2BiobankNetworkLink = toUnwrappedModel(d2BiobankNetworkLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(d2BiobankNetworkLink)) {
				d2BiobankNetworkLink = (D2BiobankNetworkLink)session.get(D2BiobankNetworkLinkImpl.class,
						d2BiobankNetworkLink.getPrimaryKeyObj());
			}

			if (d2BiobankNetworkLink != null) {
				session.delete(d2BiobankNetworkLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (d2BiobankNetworkLink != null) {
			clearCache(d2BiobankNetworkLink);
		}

		return d2BiobankNetworkLink;
	}

	@Override
	public D2BiobankNetworkLink updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink d2BiobankNetworkLink)
		throws SystemException {
		d2BiobankNetworkLink = toUnwrappedModel(d2BiobankNetworkLink);

		boolean isNew = d2BiobankNetworkLink.isNew();

		D2BiobankNetworkLinkModelImpl d2BiobankNetworkLinkModelImpl = (D2BiobankNetworkLinkModelImpl)d2BiobankNetworkLink;

		if (Validator.isNull(d2BiobankNetworkLink.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			d2BiobankNetworkLink.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (d2BiobankNetworkLink.isNew()) {
				session.save(d2BiobankNetworkLink);

				d2BiobankNetworkLink.setNew(false);
			}
			else {
				session.merge(d2BiobankNetworkLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !D2BiobankNetworkLinkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((d2BiobankNetworkLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankNetworkLinkModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { d2BiobankNetworkLinkModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((d2BiobankNetworkLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankNetworkLinkModelImpl.getOriginalUuid(),
						d2BiobankNetworkLinkModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						d2BiobankNetworkLinkModelImpl.getUuid(),
						d2BiobankNetworkLinkModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((d2BiobankNetworkLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NETWORKLINKSFORCHILD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankNetworkLinkModelImpl.getOriginalD2linkId(),
						d2BiobankNetworkLinkModelImpl.getOriginalD2linktype()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NETWORKLINKSFORCHILD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NETWORKLINKSFORCHILD,
					args);

				args = new Object[] {
						d2BiobankNetworkLinkModelImpl.getD2linkId(),
						d2BiobankNetworkLinkModelImpl.getD2linktype()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NETWORKLINKSFORCHILD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NETWORKLINKSFORCHILD,
					args);
			}

			if ((d2BiobankNetworkLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDFORNETWORKLINKS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankNetworkLinkModelImpl.getOriginalD2biobanknetworkId(),
						d2BiobankNetworkLinkModelImpl.getOriginalD2linktype()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHILDFORNETWORKLINKS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDFORNETWORKLINKS,
					args);

				args = new Object[] {
						d2BiobankNetworkLinkModelImpl.getD2biobanknetworkId(),
						d2BiobankNetworkLinkModelImpl.getD2linktype()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHILDFORNETWORKLINKS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDFORNETWORKLINKS,
					args);
			}
		}

		EntityCacheUtil.putResult(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankNetworkLinkImpl.class,
			d2BiobankNetworkLink.getPrimaryKey(), d2BiobankNetworkLink);

		clearUniqueFindersCache(d2BiobankNetworkLink);
		cacheUniqueFindersCache(d2BiobankNetworkLink);

		return d2BiobankNetworkLink;
	}

	protected D2BiobankNetworkLink toUnwrappedModel(
		D2BiobankNetworkLink d2BiobankNetworkLink) {
		if (d2BiobankNetworkLink instanceof D2BiobankNetworkLinkImpl) {
			return d2BiobankNetworkLink;
		}

		D2BiobankNetworkLinkImpl d2BiobankNetworkLinkImpl = new D2BiobankNetworkLinkImpl();

		d2BiobankNetworkLinkImpl.setNew(d2BiobankNetworkLink.isNew());
		d2BiobankNetworkLinkImpl.setPrimaryKey(d2BiobankNetworkLink.getPrimaryKey());

		d2BiobankNetworkLinkImpl.setUuid(d2BiobankNetworkLink.getUuid());
		d2BiobankNetworkLinkImpl.setD2biobanknetworklinkId(d2BiobankNetworkLink.getD2biobanknetworklinkId());
		d2BiobankNetworkLinkImpl.setD2biobanknetworkId(d2BiobankNetworkLink.getD2biobanknetworkId());
		d2BiobankNetworkLinkImpl.setD2linkId(d2BiobankNetworkLink.getD2linkId());
		d2BiobankNetworkLinkImpl.setD2linktype(d2BiobankNetworkLink.getD2linktype());
		d2BiobankNetworkLinkImpl.setStatus(d2BiobankNetworkLink.getStatus());
		d2BiobankNetworkLinkImpl.setStatusByUserId(d2BiobankNetworkLink.getStatusByUserId());
		d2BiobankNetworkLinkImpl.setStatusByUserName(d2BiobankNetworkLink.getStatusByUserName());
		d2BiobankNetworkLinkImpl.setStatusDate(d2BiobankNetworkLink.getStatusDate());
		d2BiobankNetworkLinkImpl.setCompanyId(d2BiobankNetworkLink.getCompanyId());
		d2BiobankNetworkLinkImpl.setGroupId(d2BiobankNetworkLink.getGroupId());
		d2BiobankNetworkLinkImpl.setUserId(d2BiobankNetworkLink.getUserId());
		d2BiobankNetworkLinkImpl.setUserName(d2BiobankNetworkLink.getUserName());
		d2BiobankNetworkLinkImpl.setCreateDate(d2BiobankNetworkLink.getCreateDate());
		d2BiobankNetworkLinkImpl.setModifiedDate(d2BiobankNetworkLink.getModifiedDate());
		d2BiobankNetworkLinkImpl.setUpdateuuid(d2BiobankNetworkLink.getUpdateuuid());

		return d2BiobankNetworkLinkImpl;
	}

	/**
	 * Returns the d2 biobank network link with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the d2 biobank network link
	 * @return the d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = fetchByPrimaryKey(primaryKey);

		if (d2BiobankNetworkLink == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchD2BiobankNetworkLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return d2BiobankNetworkLink;
	}

	/**
	 * Returns the d2 biobank network link with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException} if it could not be found.
	 *
	 * @param d2biobanknetworklinkId the primary key of the d2 biobank network link
	 * @return the d2 biobank network link
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink findByPrimaryKey(long d2biobanknetworklinkId)
		throws NoSuchD2BiobankNetworkLinkException, SystemException {
		return findByPrimaryKey((Serializable)d2biobanknetworklinkId);
	}

	/**
	 * Returns the d2 biobank network link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the d2 biobank network link
	 * @return the d2 biobank network link, or <code>null</code> if a d2 biobank network link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		D2BiobankNetworkLink d2BiobankNetworkLink = (D2BiobankNetworkLink)EntityCacheUtil.getResult(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
				D2BiobankNetworkLinkImpl.class, primaryKey);

		if (d2BiobankNetworkLink == _nullD2BiobankNetworkLink) {
			return null;
		}

		if (d2BiobankNetworkLink == null) {
			Session session = null;

			try {
				session = openSession();

				d2BiobankNetworkLink = (D2BiobankNetworkLink)session.get(D2BiobankNetworkLinkImpl.class,
						primaryKey);

				if (d2BiobankNetworkLink != null) {
					cacheResult(d2BiobankNetworkLink);
				}
				else {
					EntityCacheUtil.putResult(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
						D2BiobankNetworkLinkImpl.class, primaryKey,
						_nullD2BiobankNetworkLink);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(D2BiobankNetworkLinkModelImpl.ENTITY_CACHE_ENABLED,
					D2BiobankNetworkLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return d2BiobankNetworkLink;
	}

	/**
	 * Returns the d2 biobank network link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param d2biobanknetworklinkId the primary key of the d2 biobank network link
	 * @return the d2 biobank network link, or <code>null</code> if a d2 biobank network link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2BiobankNetworkLink fetchByPrimaryKey(long d2biobanknetworklinkId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)d2biobanknetworklinkId);
	}

	/**
	 * Returns all the d2 biobank network links.
	 *
	 * @return the d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobank network links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d2 biobank network links
	 * @param end the upper bound of the range of d2 biobank network links (not inclusive)
	 * @return the range of d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobank network links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d2 biobank network links
	 * @param end the upper bound of the range of d2 biobank network links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of d2 biobank network links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2BiobankNetworkLink> findAll(int start, int end,
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

		List<D2BiobankNetworkLink> list = (List<D2BiobankNetworkLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_D2BIOBANKNETWORKLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_D2BIOBANKNETWORKLINK;

				if (pagination) {
					sql = sql.concat(D2BiobankNetworkLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<D2BiobankNetworkLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2BiobankNetworkLink>(list);
				}
				else {
					list = (List<D2BiobankNetworkLink>)QueryUtil.list(q,
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
	 * Removes all the d2 biobank network links from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (D2BiobankNetworkLink d2BiobankNetworkLink : findAll()) {
			remove(d2BiobankNetworkLink);
		}
	}

	/**
	 * Returns the number of d2 biobank network links.
	 *
	 * @return the number of d2 biobank network links
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

				Query q = session.createQuery(_SQL_COUNT_D2BIOBANKNETWORKLINK);

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
	 * Initializes the d2 biobank network link persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<D2BiobankNetworkLink>> listenersList = new ArrayList<ModelListener<D2BiobankNetworkLink>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<D2BiobankNetworkLink>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(D2BiobankNetworkLinkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_D2BIOBANKNETWORKLINK = "SELECT d2BiobankNetworkLink FROM D2BiobankNetworkLink d2BiobankNetworkLink";
	private static final String _SQL_SELECT_D2BIOBANKNETWORKLINK_WHERE = "SELECT d2BiobankNetworkLink FROM D2BiobankNetworkLink d2BiobankNetworkLink WHERE ";
	private static final String _SQL_COUNT_D2BIOBANKNETWORKLINK = "SELECT COUNT(d2BiobankNetworkLink) FROM D2BiobankNetworkLink d2BiobankNetworkLink";
	private static final String _SQL_COUNT_D2BIOBANKNETWORKLINK_WHERE = "SELECT COUNT(d2BiobankNetworkLink) FROM D2BiobankNetworkLink d2BiobankNetworkLink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "d2BiobankNetworkLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No D2BiobankNetworkLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No D2BiobankNetworkLink exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(D2BiobankNetworkLinkPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static D2BiobankNetworkLink _nullD2BiobankNetworkLink = new D2BiobankNetworkLinkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<D2BiobankNetworkLink> toCacheModel() {
				return _nullD2BiobankNetworkLinkCacheModel;
			}
		};

	private static CacheModel<D2BiobankNetworkLink> _nullD2BiobankNetworkLinkCacheModel =
		new CacheModel<D2BiobankNetworkLink>() {
			@Override
			public D2BiobankNetworkLink toEntityModel() {
				return _nullD2BiobankNetworkLink;
			}
		};
}