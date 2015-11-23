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

import at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException;
import at.meduni.liferay.portlet.bbmrieric.model.D2Collection;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionImpl;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl;

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
 * The persistence implementation for the d2 collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see D2CollectionPersistence
 * @see D2CollectionUtil
 * @generated
 */
public class D2CollectionPersistenceImpl extends BasePersistenceImpl<D2Collection>
	implements D2CollectionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link D2CollectionUtil} to access the d2 collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = D2CollectionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			D2CollectionModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the d2 collections where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 collections where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @return the range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 collections where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByUuid(String uuid, int start, int end,
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

		List<D2Collection> list = (List<D2Collection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Collection d2Collection : list) {
				if (!Validator.equals(uuid, d2Collection.getUuid())) {
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

			query.append(_SQL_SELECT_D2COLLECTION_WHERE);

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
				query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
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
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Collection>(list);
				}
				else {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 collection in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByUuid_First(uuid, orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the first d2 collection in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Collection> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 collection in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByUuid_Last(uuid, orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the last d2 collection in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<D2Collection> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 collections before and after the current d2 collection in the ordered set where uuid = &#63;.
	 *
	 * @param d2collectionId the primary key of the current d2 collection
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection[] findByUuid_PrevAndNext(long d2collectionId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = findByPrimaryKey(d2collectionId);

		Session session = null;

		try {
			session = openSession();

			D2Collection[] array = new D2CollectionImpl[3];

			array[0] = getByUuid_PrevAndNext(session, d2Collection, uuid,
					orderByComparator, true);

			array[1] = d2Collection;

			array[2] = getByUuid_PrevAndNext(session, d2Collection, uuid,
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

	protected D2Collection getByUuid_PrevAndNext(Session session,
		D2Collection d2Collection, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2COLLECTION_WHERE);

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
			query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(d2Collection);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Collection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 collections where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (D2Collection d2Collection : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(d2Collection);
		}
	}

	/**
	 * Returns the number of d2 collections where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching d2 collections
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

			query.append(_SQL_COUNT_D2COLLECTION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "d2Collection.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "d2Collection.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(d2Collection.uuid IS NULL OR d2Collection.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			D2CollectionModelImpl.UUID_COLUMN_BITMASK |
			D2CollectionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the d2 collection where uuid = &#63; and groupId = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByUUID_G(String uuid, long groupId)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByUUID_G(uuid, groupId);

		if (d2Collection == null) {
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

			throw new NoSuchD2CollectionException(msg.toString());
		}

		return d2Collection;
	}

	/**
	 * Returns the d2 collection where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the d2 collection where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof D2Collection) {
			D2Collection d2Collection = (D2Collection)result;

			if (!Validator.equals(uuid, d2Collection.getUuid()) ||
					(groupId != d2Collection.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_D2COLLECTION_WHERE);

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

				List<D2Collection> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					D2Collection d2Collection = list.get(0);

					result = d2Collection;

					cacheResult(d2Collection);

					if ((d2Collection.getUuid() == null) ||
							!d2Collection.getUuid().equals(uuid) ||
							(d2Collection.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, d2Collection);
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
			return (D2Collection)result;
		}
	}

	/**
	 * Removes the d2 collection where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the d2 collection that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection removeByUUID_G(String uuid, long groupId)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = findByUUID_G(uuid, groupId);

		return remove(d2Collection);
	}

	/**
	 * Returns the number of d2 collections where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching d2 collections
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

			query.append(_SQL_COUNT_D2COLLECTION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "d2Collection.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "d2Collection.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(d2Collection.uuid IS NULL OR d2Collection.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "d2Collection.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			D2CollectionModelImpl.UUID_COLUMN_BITMASK |
			D2CollectionModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the d2 collections where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 collections where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @return the range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 collections where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByUuid_C(String uuid, long companyId,
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

		List<D2Collection> list = (List<D2Collection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Collection d2Collection : list) {
				if (!Validator.equals(uuid, d2Collection.getUuid()) ||
						(companyId != d2Collection.getCompanyId())) {
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

			query.append(_SQL_SELECT_D2COLLECTION_WHERE);

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
				query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
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
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Collection>(list);
				}
				else {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the first d2 collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Collection> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the last d2 collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<D2Collection> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 collections before and after the current d2 collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param d2collectionId the primary key of the current d2 collection
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection[] findByUuid_C_PrevAndNext(long d2collectionId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = findByPrimaryKey(d2collectionId);

		Session session = null;

		try {
			session = openSession();

			D2Collection[] array = new D2CollectionImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, d2Collection, uuid,
					companyId, orderByComparator, true);

			array[1] = d2Collection;

			array[2] = getByUuid_C_PrevAndNext(session, d2Collection, uuid,
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

	protected D2Collection getByUuid_C_PrevAndNext(Session session,
		D2Collection d2Collection, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2COLLECTION_WHERE);

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
			query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(d2Collection);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Collection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 collections where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (D2Collection d2Collection : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2Collection);
		}
	}

	/**
	 * Returns the number of d2 collections where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching d2 collections
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

			query.append(_SQL_COUNT_D2COLLECTION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "d2Collection.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "d2Collection.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(d2Collection.uuid IS NULL OR d2Collection.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "d2Collection.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			D2CollectionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the d2 collections where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 collections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @return the range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 collections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<D2Collection> list = (List<D2Collection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Collection d2Collection : list) {
				if ((groupId != d2Collection.getGroupId())) {
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

			query.append(_SQL_SELECT_D2COLLECTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Collection>(list);
				}
				else {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByGroupId_First(groupId,
				orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the first d2 collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Collection> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the last d2 collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<D2Collection> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 collections before and after the current d2 collection in the ordered set where groupId = &#63;.
	 *
	 * @param d2collectionId the primary key of the current d2 collection
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection[] findByGroupId_PrevAndNext(long d2collectionId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = findByPrimaryKey(d2collectionId);

		Session session = null;

		try {
			session = openSession();

			D2Collection[] array = new D2CollectionImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, d2Collection, groupId,
					orderByComparator, true);

			array[1] = d2Collection;

			array[2] = getByGroupId_PrevAndNext(session, d2Collection, groupId,
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

	protected D2Collection getByGroupId_PrevAndNext(Session session,
		D2Collection d2Collection, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2COLLECTION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2Collection);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Collection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 collections where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (D2Collection d2Collection : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2Collection);
		}
	}

	/**
	 * Returns the number of d2 collections where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_D2COLLECTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "d2Collection.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			D2CollectionModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the d2 collections where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the d2 collections where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @return the range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 collections where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<D2Collection> list = (List<D2Collection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Collection d2Collection : list) {
				if ((companyId != d2Collection.getCompanyId())) {
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

			query.append(_SQL_SELECT_D2COLLECTION_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Collection>(list);
				}
				else {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 collection in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the first d2 collection in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Collection> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 collection in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the last d2 collection in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<D2Collection> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 collections before and after the current d2 collection in the ordered set where companyId = &#63;.
	 *
	 * @param d2collectionId the primary key of the current d2 collection
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection[] findByCompanyId_PrevAndNext(long d2collectionId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = findByPrimaryKey(d2collectionId);

		Session session = null;

		try {
			session = openSession();

			D2Collection[] array = new D2CollectionImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, d2Collection,
					companyId, orderByComparator, true);

			array[1] = d2Collection;

			array[2] = getByCompanyId_PrevAndNext(session, d2Collection,
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

	protected D2Collection getByCompanyId_PrevAndNext(Session session,
		D2Collection d2Collection, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2COLLECTION_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2Collection);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Collection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 collections where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (D2Collection d2Collection : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2Collection);
		}
	}

	/**
	 * Returns the number of d2 collections where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_D2COLLECTION_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "d2Collection.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_COLLECTIONBYID = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCollectionByID",
			new String[] { Long.class.getName(), Long.class.getName() },
			D2CollectionModelImpl.GROUPID_COLUMN_BITMASK |
			D2CollectionModelImpl.D2COLLECTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLLECTIONBYID = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCollectionByID",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the d2 collection where groupId = &#63; and d2collectionId = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param d2collectionId the d2collection ID
	 * @return the matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByCollectionByID(long groupId, long d2collectionId)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByCollectionByID(groupId,
				d2collectionId);

		if (d2Collection == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", d2collectionId=");
			msg.append(d2collectionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchD2CollectionException(msg.toString());
		}

		return d2Collection;
	}

	/**
	 * Returns the d2 collection where groupId = &#63; and d2collectionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param d2collectionId the d2collection ID
	 * @return the matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByCollectionByID(long groupId, long d2collectionId)
		throws SystemException {
		return fetchByCollectionByID(groupId, d2collectionId, true);
	}

	/**
	 * Returns the d2 collection where groupId = &#63; and d2collectionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param d2collectionId the d2collection ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByCollectionByID(long groupId,
		long d2collectionId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, d2collectionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COLLECTIONBYID,
					finderArgs, this);
		}

		if (result instanceof D2Collection) {
			D2Collection d2Collection = (D2Collection)result;

			if ((groupId != d2Collection.getGroupId()) ||
					(d2collectionId != d2Collection.getD2collectionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_D2COLLECTION_WHERE);

			query.append(_FINDER_COLUMN_COLLECTIONBYID_GROUPID_2);

			query.append(_FINDER_COLUMN_COLLECTIONBYID_D2COLLECTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(d2collectionId);

				List<D2Collection> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONBYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"D2CollectionPersistenceImpl.fetchByCollectionByID(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					D2Collection d2Collection = list.get(0);

					result = d2Collection;

					cacheResult(d2Collection);

					if ((d2Collection.getGroupId() != groupId) ||
							(d2Collection.getD2collectionId() != d2collectionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONBYID,
							finderArgs, d2Collection);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLLECTIONBYID,
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
			return (D2Collection)result;
		}
	}

	/**
	 * Removes the d2 collection where groupId = &#63; and d2collectionId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param d2collectionId the d2collection ID
	 * @return the d2 collection that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection removeByCollectionByID(long groupId, long d2collectionId)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = findByCollectionByID(groupId, d2collectionId);

		return remove(d2Collection);
	}

	/**
	 * Returns the number of d2 collections where groupId = &#63; and d2collectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param d2collectionId the d2collection ID
	 * @return the number of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCollectionByID(long groupId, long d2collectionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLLECTIONBYID;

		Object[] finderArgs = new Object[] { groupId, d2collectionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_D2COLLECTION_WHERE);

			query.append(_FINDER_COLUMN_COLLECTIONBYID_GROUPID_2);

			query.append(_FINDER_COLUMN_COLLECTIONBYID_D2COLLECTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(d2collectionId);

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

	private static final String _FINDER_COLUMN_COLLECTIONBYID_GROUPID_2 = "d2Collection.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COLLECTIONBYID_D2COLLECTIONID_2 = "d2Collection.d2collectionId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_COLLECTIONBBMRIERICID = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCollectionBBMRIERICID",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			D2CollectionModelImpl.GROUPID_COLUMN_BITMASK |
			D2CollectionModelImpl.BBMRICOLLECTIONID_COLUMN_BITMASK |
			D2CollectionModelImpl.BBMRIBIOBANKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLLECTIONBBMRIERICID = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCollectionBBMRIERICID",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the d2 collection where groupId = &#63; and bbmricollectionID = &#63; and bbmribiobankID = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param bbmricollectionID the bbmricollection i d
	 * @param bbmribiobankID the bbmribiobank i d
	 * @return the matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByCollectionBBMRIERICID(long groupId,
		String bbmricollectionID, String bbmribiobankID)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByCollectionBBMRIERICID(groupId,
				bbmricollectionID, bbmribiobankID);

		if (d2Collection == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", bbmricollectionID=");
			msg.append(bbmricollectionID);

			msg.append(", bbmribiobankID=");
			msg.append(bbmribiobankID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchD2CollectionException(msg.toString());
		}

		return d2Collection;
	}

	/**
	 * Returns the d2 collection where groupId = &#63; and bbmricollectionID = &#63; and bbmribiobankID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param bbmricollectionID the bbmricollection i d
	 * @param bbmribiobankID the bbmribiobank i d
	 * @return the matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByCollectionBBMRIERICID(long groupId,
		String bbmricollectionID, String bbmribiobankID)
		throws SystemException {
		return fetchByCollectionBBMRIERICID(groupId, bbmricollectionID,
			bbmribiobankID, true);
	}

	/**
	 * Returns the d2 collection where groupId = &#63; and bbmricollectionID = &#63; and bbmribiobankID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param bbmricollectionID the bbmricollection i d
	 * @param bbmribiobankID the bbmribiobank i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByCollectionBBMRIERICID(long groupId,
		String bbmricollectionID, String bbmribiobankID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, bbmricollectionID, bbmribiobankID
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COLLECTIONBBMRIERICID,
					finderArgs, this);
		}

		if (result instanceof D2Collection) {
			D2Collection d2Collection = (D2Collection)result;

			if ((groupId != d2Collection.getGroupId()) ||
					!Validator.equals(bbmricollectionID,
						d2Collection.getBbmricollectionID()) ||
					!Validator.equals(bbmribiobankID,
						d2Collection.getBbmribiobankID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_D2COLLECTION_WHERE);

			query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_GROUPID_2);

			boolean bindBbmricollectionID = false;

			if (bbmricollectionID == null) {
				query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRICOLLECTIONID_1);
			}
			else if (bbmricollectionID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRICOLLECTIONID_3);
			}
			else {
				bindBbmricollectionID = true;

				query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRICOLLECTIONID_2);
			}

			boolean bindBbmribiobankID = false;

			if (bbmribiobankID == null) {
				query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRIBIOBANKID_1);
			}
			else if (bbmribiobankID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRIBIOBANKID_3);
			}
			else {
				bindBbmribiobankID = true;

				query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRIBIOBANKID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindBbmricollectionID) {
					qPos.add(bbmricollectionID);
				}

				if (bindBbmribiobankID) {
					qPos.add(bbmribiobankID);
				}

				List<D2Collection> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONBBMRIERICID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"D2CollectionPersistenceImpl.fetchByCollectionBBMRIERICID(long, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					D2Collection d2Collection = list.get(0);

					result = d2Collection;

					cacheResult(d2Collection);

					if ((d2Collection.getGroupId() != groupId) ||
							(d2Collection.getBbmricollectionID() == null) ||
							!d2Collection.getBbmricollectionID()
											 .equals(bbmricollectionID) ||
							(d2Collection.getBbmribiobankID() == null) ||
							!d2Collection.getBbmribiobankID()
											 .equals(bbmribiobankID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONBBMRIERICID,
							finderArgs, d2Collection);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLLECTIONBBMRIERICID,
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
			return (D2Collection)result;
		}
	}

	/**
	 * Removes the d2 collection where groupId = &#63; and bbmricollectionID = &#63; and bbmribiobankID = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param bbmricollectionID the bbmricollection i d
	 * @param bbmribiobankID the bbmribiobank i d
	 * @return the d2 collection that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection removeByCollectionBBMRIERICID(long groupId,
		String bbmricollectionID, String bbmribiobankID)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = findByCollectionBBMRIERICID(groupId,
				bbmricollectionID, bbmribiobankID);

		return remove(d2Collection);
	}

	/**
	 * Returns the number of d2 collections where groupId = &#63; and bbmricollectionID = &#63; and bbmribiobankID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param bbmricollectionID the bbmricollection i d
	 * @param bbmribiobankID the bbmribiobank i d
	 * @return the number of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCollectionBBMRIERICID(long groupId,
		String bbmricollectionID, String bbmribiobankID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLLECTIONBBMRIERICID;

		Object[] finderArgs = new Object[] {
				groupId, bbmricollectionID, bbmribiobankID
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_D2COLLECTION_WHERE);

			query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_GROUPID_2);

			boolean bindBbmricollectionID = false;

			if (bbmricollectionID == null) {
				query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRICOLLECTIONID_1);
			}
			else if (bbmricollectionID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRICOLLECTIONID_3);
			}
			else {
				bindBbmricollectionID = true;

				query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRICOLLECTIONID_2);
			}

			boolean bindBbmribiobankID = false;

			if (bbmribiobankID == null) {
				query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRIBIOBANKID_1);
			}
			else if (bbmribiobankID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRIBIOBANKID_3);
			}
			else {
				bindBbmribiobankID = true;

				query.append(_FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRIBIOBANKID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindBbmricollectionID) {
					qPos.add(bbmricollectionID);
				}

				if (bindBbmribiobankID) {
					qPos.add(bbmribiobankID);
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

	private static final String _FINDER_COLUMN_COLLECTIONBBMRIERICID_GROUPID_2 = "d2Collection.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRICOLLECTIONID_1 =
		"d2Collection.bbmricollectionID IS NULL AND ";
	private static final String _FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRICOLLECTIONID_2 =
		"d2Collection.bbmricollectionID = ? AND ";
	private static final String _FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRICOLLECTIONID_3 =
		"(d2Collection.bbmricollectionID IS NULL OR d2Collection.bbmricollectionID = '') AND ";
	private static final String _FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRIBIOBANKID_1 =
		"d2Collection.bbmribiobankID IS NULL";
	private static final String _FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRIBIOBANKID_2 =
		"d2Collection.bbmribiobankID = ?";
	private static final String _FINDER_COLUMN_COLLECTIONBBMRIERICID_BBMRIBIOBANKID_3 =
		"(d2Collection.bbmribiobankID IS NULL OR d2Collection.bbmribiobankID = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLLECTIONFORD2BIOBANK =
		new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCollectionForD2Biobank",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONFORD2BIOBANK =
		new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCollectionForD2Biobank",
			new String[] { Long.class.getName() },
			D2CollectionModelImpl.BIOBANKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLLECTIONFORD2BIOBANK = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCollectionForD2Biobank",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the d2 collections where biobankId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @return the matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByCollectionForD2Biobank(long biobankId)
		throws SystemException {
		return findByCollectionForD2Biobank(biobankId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 collections where biobankId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param biobankId the biobank ID
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @return the range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByCollectionForD2Biobank(long biobankId,
		int start, int end) throws SystemException {
		return findByCollectionForD2Biobank(biobankId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 collections where biobankId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param biobankId the biobank ID
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByCollectionForD2Biobank(long biobankId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONFORD2BIOBANK;
			finderArgs = new Object[] { biobankId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLLECTIONFORD2BIOBANK;
			finderArgs = new Object[] { biobankId, start, end, orderByComparator };
		}

		List<D2Collection> list = (List<D2Collection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Collection d2Collection : list) {
				if ((biobankId != d2Collection.getBiobankId())) {
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

			query.append(_SQL_SELECT_D2COLLECTION_WHERE);

			query.append(_FINDER_COLUMN_COLLECTIONFORD2BIOBANK_BIOBANKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(biobankId);

				if (!pagination) {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Collection>(list);
				}
				else {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 collection in the ordered set where biobankId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByCollectionForD2Biobank_First(long biobankId,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByCollectionForD2Biobank_First(biobankId,
				orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("biobankId=");
		msg.append(biobankId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the first d2 collection in the ordered set where biobankId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByCollectionForD2Biobank_First(long biobankId,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Collection> list = findByCollectionForD2Biobank(biobankId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 collection in the ordered set where biobankId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByCollectionForD2Biobank_Last(long biobankId,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByCollectionForD2Biobank_Last(biobankId,
				orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("biobankId=");
		msg.append(biobankId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the last d2 collection in the ordered set where biobankId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByCollectionForD2Biobank_Last(long biobankId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCollectionForD2Biobank(biobankId);

		if (count == 0) {
			return null;
		}

		List<D2Collection> list = findByCollectionForD2Biobank(biobankId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 collections before and after the current d2 collection in the ordered set where biobankId = &#63;.
	 *
	 * @param d2collectionId the primary key of the current d2 collection
	 * @param biobankId the biobank ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection[] findByCollectionForD2Biobank_PrevAndNext(
		long d2collectionId, long biobankId, OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = findByPrimaryKey(d2collectionId);

		Session session = null;

		try {
			session = openSession();

			D2Collection[] array = new D2CollectionImpl[3];

			array[0] = getByCollectionForD2Biobank_PrevAndNext(session,
					d2Collection, biobankId, orderByComparator, true);

			array[1] = d2Collection;

			array[2] = getByCollectionForD2Biobank_PrevAndNext(session,
					d2Collection, biobankId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected D2Collection getByCollectionForD2Biobank_PrevAndNext(
		Session session, D2Collection d2Collection, long biobankId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2COLLECTION_WHERE);

		query.append(_FINDER_COLUMN_COLLECTIONFORD2BIOBANK_BIOBANKID_2);

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
			query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(biobankId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2Collection);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Collection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 collections where biobankId = &#63; from the database.
	 *
	 * @param biobankId the biobank ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCollectionForD2Biobank(long biobankId)
		throws SystemException {
		for (D2Collection d2Collection : findByCollectionForD2Biobank(
				biobankId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2Collection);
		}
	}

	/**
	 * Returns the number of d2 collections where biobankId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @return the number of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCollectionForD2Biobank(long biobankId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLLECTIONFORD2BIOBANK;

		Object[] finderArgs = new Object[] { biobankId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_D2COLLECTION_WHERE);

			query.append(_FINDER_COLUMN_COLLECTIONFORD2BIOBANK_BIOBANKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(biobankId);

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

	private static final String _FINDER_COLUMN_COLLECTIONFORD2BIOBANK_BIOBANKID_2 =
		"d2Collection.biobankId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOTCOLLECTIONFORD2BIOBANK =
		new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRootCollectionForD2Biobank",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTCOLLECTIONFORD2BIOBANK =
		new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRootCollectionForD2Biobank",
			new String[] { Long.class.getName(), Long.class.getName() },
			D2CollectionModelImpl.BIOBANKID_COLUMN_BITMASK |
			D2CollectionModelImpl.PARENTD2COLLECTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTCOLLECTIONFORD2BIOBANK =
		new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRootCollectionForD2Biobank",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the d2 collections where biobankId = &#63; and parentd2collectionId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @param parentd2collectionId the parentd2collection ID
	 * @return the matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByRootCollectionForD2Biobank(long biobankId,
		long parentd2collectionId) throws SystemException {
		return findByRootCollectionForD2Biobank(biobankId,
			parentd2collectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 collections where biobankId = &#63; and parentd2collectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param biobankId the biobank ID
	 * @param parentd2collectionId the parentd2collection ID
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @return the range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByRootCollectionForD2Biobank(long biobankId,
		long parentd2collectionId, int start, int end)
		throws SystemException {
		return findByRootCollectionForD2Biobank(biobankId,
			parentd2collectionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 collections where biobankId = &#63; and parentd2collectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param biobankId the biobank ID
	 * @param parentd2collectionId the parentd2collection ID
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByRootCollectionForD2Biobank(long biobankId,
		long parentd2collectionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTCOLLECTIONFORD2BIOBANK;
			finderArgs = new Object[] { biobankId, parentd2collectionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOTCOLLECTIONFORD2BIOBANK;
			finderArgs = new Object[] {
					biobankId, parentd2collectionId,
					
					start, end, orderByComparator
				};
		}

		List<D2Collection> list = (List<D2Collection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Collection d2Collection : list) {
				if ((biobankId != d2Collection.getBiobankId()) ||
						(parentd2collectionId != d2Collection.getParentd2collectionId())) {
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

			query.append(_SQL_SELECT_D2COLLECTION_WHERE);

			query.append(_FINDER_COLUMN_ROOTCOLLECTIONFORD2BIOBANK_BIOBANKID_2);

			query.append(_FINDER_COLUMN_ROOTCOLLECTIONFORD2BIOBANK_PARENTD2COLLECTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(biobankId);

				qPos.add(parentd2collectionId);

				if (!pagination) {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Collection>(list);
				}
				else {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 collection in the ordered set where biobankId = &#63; and parentd2collectionId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @param parentd2collectionId the parentd2collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByRootCollectionForD2Biobank_First(long biobankId,
		long parentd2collectionId, OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByRootCollectionForD2Biobank_First(biobankId,
				parentd2collectionId, orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("biobankId=");
		msg.append(biobankId);

		msg.append(", parentd2collectionId=");
		msg.append(parentd2collectionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the first d2 collection in the ordered set where biobankId = &#63; and parentd2collectionId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @param parentd2collectionId the parentd2collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByRootCollectionForD2Biobank_First(
		long biobankId, long parentd2collectionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Collection> list = findByRootCollectionForD2Biobank(biobankId,
				parentd2collectionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 collection in the ordered set where biobankId = &#63; and parentd2collectionId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @param parentd2collectionId the parentd2collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByRootCollectionForD2Biobank_Last(long biobankId,
		long parentd2collectionId, OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByRootCollectionForD2Biobank_Last(biobankId,
				parentd2collectionId, orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("biobankId=");
		msg.append(biobankId);

		msg.append(", parentd2collectionId=");
		msg.append(parentd2collectionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the last d2 collection in the ordered set where biobankId = &#63; and parentd2collectionId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @param parentd2collectionId the parentd2collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByRootCollectionForD2Biobank_Last(long biobankId,
		long parentd2collectionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRootCollectionForD2Biobank(biobankId,
				parentd2collectionId);

		if (count == 0) {
			return null;
		}

		List<D2Collection> list = findByRootCollectionForD2Biobank(biobankId,
				parentd2collectionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 collections before and after the current d2 collection in the ordered set where biobankId = &#63; and parentd2collectionId = &#63;.
	 *
	 * @param d2collectionId the primary key of the current d2 collection
	 * @param biobankId the biobank ID
	 * @param parentd2collectionId the parentd2collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection[] findByRootCollectionForD2Biobank_PrevAndNext(
		long d2collectionId, long biobankId, long parentd2collectionId,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = findByPrimaryKey(d2collectionId);

		Session session = null;

		try {
			session = openSession();

			D2Collection[] array = new D2CollectionImpl[3];

			array[0] = getByRootCollectionForD2Biobank_PrevAndNext(session,
					d2Collection, biobankId, parentd2collectionId,
					orderByComparator, true);

			array[1] = d2Collection;

			array[2] = getByRootCollectionForD2Biobank_PrevAndNext(session,
					d2Collection, biobankId, parentd2collectionId,
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

	protected D2Collection getByRootCollectionForD2Biobank_PrevAndNext(
		Session session, D2Collection d2Collection, long biobankId,
		long parentd2collectionId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2COLLECTION_WHERE);

		query.append(_FINDER_COLUMN_ROOTCOLLECTIONFORD2BIOBANK_BIOBANKID_2);

		query.append(_FINDER_COLUMN_ROOTCOLLECTIONFORD2BIOBANK_PARENTD2COLLECTIONID_2);

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
			query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(biobankId);

		qPos.add(parentd2collectionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2Collection);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Collection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 collections where biobankId = &#63; and parentd2collectionId = &#63; from the database.
	 *
	 * @param biobankId the biobank ID
	 * @param parentd2collectionId the parentd2collection ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRootCollectionForD2Biobank(long biobankId,
		long parentd2collectionId) throws SystemException {
		for (D2Collection d2Collection : findByRootCollectionForD2Biobank(
				biobankId, parentd2collectionId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(d2Collection);
		}
	}

	/**
	 * Returns the number of d2 collections where biobankId = &#63; and parentd2collectionId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @param parentd2collectionId the parentd2collection ID
	 * @return the number of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRootCollectionForD2Biobank(long biobankId,
		long parentd2collectionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROOTCOLLECTIONFORD2BIOBANK;

		Object[] finderArgs = new Object[] { biobankId, parentd2collectionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_D2COLLECTION_WHERE);

			query.append(_FINDER_COLUMN_ROOTCOLLECTIONFORD2BIOBANK_BIOBANKID_2);

			query.append(_FINDER_COLUMN_ROOTCOLLECTIONFORD2BIOBANK_PARENTD2COLLECTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(biobankId);

				qPos.add(parentd2collectionId);

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

	private static final String _FINDER_COLUMN_ROOTCOLLECTIONFORD2BIOBANK_BIOBANKID_2 =
		"d2Collection.biobankId = ? AND ";
	private static final String _FINDER_COLUMN_ROOTCOLLECTIONFORD2BIOBANK_PARENTD2COLLECTIONID_2 =
		"d2Collection.parentd2collectionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTUUID = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, D2CollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNotUUID",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTUUID = new FinderPath(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNotUUID",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the d2 collections where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @return the matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByNotUUID(long groupId, String updateuuid)
		throws SystemException {
		return findByNotUUID(groupId, updateuuid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 collections where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @return the range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByNotUUID(long groupId, String updateuuid,
		int start, int end) throws SystemException {
		return findByNotUUID(groupId, updateuuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 collections where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findByNotUUID(long groupId, String updateuuid,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTUUID;
		finderArgs = new Object[] {
				groupId, updateuuid,
				
				start, end, orderByComparator
			};

		List<D2Collection> list = (List<D2Collection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Collection d2Collection : list) {
				if ((groupId != d2Collection.getGroupId()) ||
						Validator.equals(updateuuid,
							d2Collection.getUpdateuuid())) {
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

			query.append(_SQL_SELECT_D2COLLECTION_WHERE);

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
				query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
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
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Collection>(list);
				}
				else {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 collection in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByNotUUID_First(long groupId, String updateuuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByNotUUID_First(groupId, updateuuid,
				orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", updateuuid=");
		msg.append(updateuuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the first d2 collection in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByNotUUID_First(long groupId, String updateuuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Collection> list = findByNotUUID(groupId, updateuuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 collection in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByNotUUID_Last(long groupId, String updateuuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByNotUUID_Last(groupId, updateuuid,
				orderByComparator);

		if (d2Collection != null) {
			return d2Collection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", updateuuid=");
		msg.append(updateuuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2CollectionException(msg.toString());
	}

	/**
	 * Returns the last d2 collection in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 collection, or <code>null</code> if a matching d2 collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByNotUUID_Last(long groupId, String updateuuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNotUUID(groupId, updateuuid);

		if (count == 0) {
			return null;
		}

		List<D2Collection> list = findByNotUUID(groupId, updateuuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 collections before and after the current d2 collection in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param d2collectionId the primary key of the current d2 collection
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection[] findByNotUUID_PrevAndNext(long d2collectionId,
		long groupId, String updateuuid, OrderByComparator orderByComparator)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = findByPrimaryKey(d2collectionId);

		Session session = null;

		try {
			session = openSession();

			D2Collection[] array = new D2CollectionImpl[3];

			array[0] = getByNotUUID_PrevAndNext(session, d2Collection, groupId,
					updateuuid, orderByComparator, true);

			array[1] = d2Collection;

			array[2] = getByNotUUID_PrevAndNext(session, d2Collection, groupId,
					updateuuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected D2Collection getByNotUUID_PrevAndNext(Session session,
		D2Collection d2Collection, long groupId, String updateuuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2COLLECTION_WHERE);

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
			query.append(D2CollectionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(d2Collection);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Collection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 collections where groupId = &#63; and updateuuid &ne; &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNotUUID(long groupId, String updateuuid)
		throws SystemException {
		for (D2Collection d2Collection : findByNotUUID(groupId, updateuuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2Collection);
		}
	}

	/**
	 * Returns the number of d2 collections where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @return the number of matching d2 collections
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

			query.append(_SQL_COUNT_D2COLLECTION_WHERE);

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

	private static final String _FINDER_COLUMN_NOTUUID_GROUPID_2 = "d2Collection.groupId = ? AND ";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_1 = "d2Collection.updateuuid IS NOT NULL";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_2 = "d2Collection.updateuuid != ?";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_3 = "(d2Collection.updateuuid IS NULL OR d2Collection.updateuuid != '')";

	public D2CollectionPersistenceImpl() {
		setModelClass(D2Collection.class);
	}

	/**
	 * Caches the d2 collection in the entity cache if it is enabled.
	 *
	 * @param d2Collection the d2 collection
	 */
	@Override
	public void cacheResult(D2Collection d2Collection) {
		EntityCacheUtil.putResult(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionImpl.class, d2Collection.getPrimaryKey(), d2Collection);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { d2Collection.getUuid(), d2Collection.getGroupId() },
			d2Collection);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONBYID,
			new Object[] {
				d2Collection.getGroupId(), d2Collection.getD2collectionId()
			}, d2Collection);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONBBMRIERICID,
			new Object[] {
				d2Collection.getGroupId(), d2Collection.getBbmricollectionID(),
				d2Collection.getBbmribiobankID()
			}, d2Collection);

		d2Collection.resetOriginalValues();
	}

	/**
	 * Caches the d2 collections in the entity cache if it is enabled.
	 *
	 * @param d2Collections the d2 collections
	 */
	@Override
	public void cacheResult(List<D2Collection> d2Collections) {
		for (D2Collection d2Collection : d2Collections) {
			if (EntityCacheUtil.getResult(
						D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
						D2CollectionImpl.class, d2Collection.getPrimaryKey()) == null) {
				cacheResult(d2Collection);
			}
			else {
				d2Collection.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all d2 collections.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(D2CollectionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(D2CollectionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the d2 collection.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(D2Collection d2Collection) {
		EntityCacheUtil.removeResult(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionImpl.class, d2Collection.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(d2Collection);
	}

	@Override
	public void clearCache(List<D2Collection> d2Collections) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (D2Collection d2Collection : d2Collections) {
			EntityCacheUtil.removeResult(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
				D2CollectionImpl.class, d2Collection.getPrimaryKey());

			clearUniqueFindersCache(d2Collection);
		}
	}

	protected void cacheUniqueFindersCache(D2Collection d2Collection) {
		if (d2Collection.isNew()) {
			Object[] args = new Object[] {
					d2Collection.getUuid(), d2Collection.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				d2Collection);

			args = new Object[] {
					d2Collection.getGroupId(), d2Collection.getD2collectionId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLLECTIONBYID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONBYID,
				args, d2Collection);

			args = new Object[] {
					d2Collection.getGroupId(),
					d2Collection.getBbmricollectionID(),
					d2Collection.getBbmribiobankID()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLLECTIONBBMRIERICID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONBBMRIERICID,
				args, d2Collection);
		}
		else {
			D2CollectionModelImpl d2CollectionModelImpl = (D2CollectionModelImpl)d2Collection;

			if ((d2CollectionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2Collection.getUuid(), d2Collection.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					d2Collection);
			}

			if ((d2CollectionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COLLECTIONBYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2Collection.getGroupId(),
						d2Collection.getD2collectionId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLLECTIONBYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONBYID,
					args, d2Collection);
			}

			if ((d2CollectionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COLLECTIONBBMRIERICID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2Collection.getGroupId(),
						d2Collection.getBbmricollectionID(),
						d2Collection.getBbmribiobankID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLLECTIONBBMRIERICID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONBBMRIERICID,
					args, d2Collection);
			}
		}
	}

	protected void clearUniqueFindersCache(D2Collection d2Collection) {
		D2CollectionModelImpl d2CollectionModelImpl = (D2CollectionModelImpl)d2Collection;

		Object[] args = new Object[] {
				d2Collection.getUuid(), d2Collection.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((d2CollectionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					d2CollectionModelImpl.getOriginalUuid(),
					d2CollectionModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				d2Collection.getGroupId(), d2Collection.getD2collectionId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONBYID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLLECTIONBYID, args);

		if ((d2CollectionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COLLECTIONBYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					d2CollectionModelImpl.getOriginalGroupId(),
					d2CollectionModelImpl.getOriginalD2collectionId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONBYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLLECTIONBYID,
				args);
		}

		args = new Object[] {
				d2Collection.getGroupId(), d2Collection.getBbmricollectionID(),
				d2Collection.getBbmribiobankID()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONBBMRIERICID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLLECTIONBBMRIERICID,
			args);

		if ((d2CollectionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COLLECTIONBBMRIERICID.getColumnBitmask()) != 0) {
			args = new Object[] {
					d2CollectionModelImpl.getOriginalGroupId(),
					d2CollectionModelImpl.getOriginalBbmricollectionID(),
					d2CollectionModelImpl.getOriginalBbmribiobankID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONBBMRIERICID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLLECTIONBBMRIERICID,
				args);
		}
	}

	/**
	 * Creates a new d2 collection with the primary key. Does not add the d2 collection to the database.
	 *
	 * @param d2collectionId the primary key for the new d2 collection
	 * @return the new d2 collection
	 */
	@Override
	public D2Collection create(long d2collectionId) {
		D2Collection d2Collection = new D2CollectionImpl();

		d2Collection.setNew(true);
		d2Collection.setPrimaryKey(d2collectionId);

		String uuid = PortalUUIDUtil.generate();

		d2Collection.setUuid(uuid);

		return d2Collection;
	}

	/**
	 * Removes the d2 collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param d2collectionId the primary key of the d2 collection
	 * @return the d2 collection that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection remove(long d2collectionId)
		throws NoSuchD2CollectionException, SystemException {
		return remove((Serializable)d2collectionId);
	}

	/**
	 * Removes the d2 collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the d2 collection
	 * @return the d2 collection that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection remove(Serializable primaryKey)
		throws NoSuchD2CollectionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			D2Collection d2Collection = (D2Collection)session.get(D2CollectionImpl.class,
					primaryKey);

			if (d2Collection == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchD2CollectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(d2Collection);
		}
		catch (NoSuchD2CollectionException nsee) {
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
	protected D2Collection removeImpl(D2Collection d2Collection)
		throws SystemException {
		d2Collection = toUnwrappedModel(d2Collection);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(d2Collection)) {
				d2Collection = (D2Collection)session.get(D2CollectionImpl.class,
						d2Collection.getPrimaryKeyObj());
			}

			if (d2Collection != null) {
				session.delete(d2Collection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (d2Collection != null) {
			clearCache(d2Collection);
		}

		return d2Collection;
	}

	@Override
	public D2Collection updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2Collection)
		throws SystemException {
		d2Collection = toUnwrappedModel(d2Collection);

		boolean isNew = d2Collection.isNew();

		D2CollectionModelImpl d2CollectionModelImpl = (D2CollectionModelImpl)d2Collection;

		if (Validator.isNull(d2Collection.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			d2Collection.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (d2Collection.isNew()) {
				session.save(d2Collection);

				d2Collection.setNew(false);
			}
			else {
				session.merge(d2Collection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !D2CollectionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((d2CollectionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2CollectionModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { d2CollectionModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((d2CollectionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2CollectionModelImpl.getOriginalUuid(),
						d2CollectionModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						d2CollectionModelImpl.getUuid(),
						d2CollectionModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((d2CollectionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2CollectionModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { d2CollectionModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((d2CollectionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2CollectionModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { d2CollectionModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((d2CollectionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONFORD2BIOBANK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2CollectionModelImpl.getOriginalBiobankId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONFORD2BIOBANK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONFORD2BIOBANK,
					args);

				args = new Object[] { d2CollectionModelImpl.getBiobankId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONFORD2BIOBANK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONFORD2BIOBANK,
					args);
			}

			if ((d2CollectionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTCOLLECTIONFORD2BIOBANK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2CollectionModelImpl.getOriginalBiobankId(),
						d2CollectionModelImpl.getOriginalParentd2collectionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOTCOLLECTIONFORD2BIOBANK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTCOLLECTIONFORD2BIOBANK,
					args);

				args = new Object[] {
						d2CollectionModelImpl.getBiobankId(),
						d2CollectionModelImpl.getParentd2collectionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOTCOLLECTIONFORD2BIOBANK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTCOLLECTIONFORD2BIOBANK,
					args);
			}
		}

		EntityCacheUtil.putResult(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
			D2CollectionImpl.class, d2Collection.getPrimaryKey(), d2Collection);

		clearUniqueFindersCache(d2Collection);
		cacheUniqueFindersCache(d2Collection);

		return d2Collection;
	}

	protected D2Collection toUnwrappedModel(D2Collection d2Collection) {
		if (d2Collection instanceof D2CollectionImpl) {
			return d2Collection;
		}

		D2CollectionImpl d2CollectionImpl = new D2CollectionImpl();

		d2CollectionImpl.setNew(d2Collection.isNew());
		d2CollectionImpl.setPrimaryKey(d2Collection.getPrimaryKey());

		d2CollectionImpl.setUuid(d2Collection.getUuid());
		d2CollectionImpl.setD2collectionId(d2Collection.getD2collectionId());
		d2CollectionImpl.setBiobankId(d2Collection.getBiobankId());
		d2CollectionImpl.setParentd2collectionId(d2Collection.getParentd2collectionId());
		d2CollectionImpl.setCompanyId(d2Collection.getCompanyId());
		d2CollectionImpl.setGroupId(d2Collection.getGroupId());
		d2CollectionImpl.setUserId(d2Collection.getUserId());
		d2CollectionImpl.setUserName(d2Collection.getUserName());
		d2CollectionImpl.setCreateDate(d2Collection.getCreateDate());
		d2CollectionImpl.setModifiedDate(d2Collection.getModifiedDate());
		d2CollectionImpl.setUpdateuuid(d2Collection.getUpdateuuid());
		d2CollectionImpl.setBbmricollectionID(d2Collection.getBbmricollectionID());
		d2CollectionImpl.setBbmriparentcollectionID(d2Collection.getBbmriparentcollectionID());
		d2CollectionImpl.setBbmribiobankID(d2Collection.getBbmribiobankID());
		d2CollectionImpl.setCollectionName(d2Collection.getCollectionName());
		d2CollectionImpl.setMaterialStoredDNA(d2Collection.isMaterialStoredDNA());
		d2CollectionImpl.setMaterialStoredPlasma(d2Collection.isMaterialStoredPlasma());
		d2CollectionImpl.setMaterialStoredSerum(d2Collection.isMaterialStoredSerum());
		d2CollectionImpl.setMaterialStoredUrine(d2Collection.isMaterialStoredUrine());
		d2CollectionImpl.setMaterialStoredSaliva(d2Collection.isMaterialStoredSaliva());
		d2CollectionImpl.setMaterialStoredFaeces(d2Collection.isMaterialStoredFaeces());
		d2CollectionImpl.setMaterialStoredRNA(d2Collection.isMaterialStoredRNA());
		d2CollectionImpl.setMaterialStoredBlood(d2Collection.isMaterialStoredBlood());
		d2CollectionImpl.setMaterialStoredTissueFrozen(d2Collection.isMaterialStoredTissueFrozen());
		d2CollectionImpl.setMaterialStoredTissueFFPE(d2Collection.isMaterialStoredTissueFFPE());
		d2CollectionImpl.setMaterialStoredImmortalizedCellLines(d2Collection.isMaterialStoredImmortalizedCellLines());
		d2CollectionImpl.setMaterialStoredIsolatedPathogen(d2Collection.isMaterialStoredIsolatedPathogen());
		d2CollectionImpl.setMaterialStoredOther(d2Collection.getMaterialStoredOther());
		d2CollectionImpl.setCollectionTypeCaseControl(d2Collection.isCollectionTypeCaseControl());
		d2CollectionImpl.setCollectionTypeCohort(d2Collection.isCollectionTypeCohort());
		d2CollectionImpl.setCollectionTypeCrossSectional(d2Collection.isCollectionTypeCrossSectional());
		d2CollectionImpl.setCollectionTypeLongitudinal(d2Collection.isCollectionTypeLongitudinal());
		d2CollectionImpl.setCollectionTypeTwinStudy(d2Collection.isCollectionTypeTwinStudy());
		d2CollectionImpl.setCollectionTypeQualityControl(d2Collection.isCollectionTypeQualityControl());
		d2CollectionImpl.setCollectionTypePopulationBased(d2Collection.isCollectionTypePopulationBased());
		d2CollectionImpl.setCollectionTypeDiseaseSpecific(d2Collection.isCollectionTypeDiseaseSpecific());
		d2CollectionImpl.setCollectionTypeBirthCohort(d2Collection.isCollectionTypeBirthCohort());
		d2CollectionImpl.setCollectionTypeOther(d2Collection.getCollectionTypeOther());
		d2CollectionImpl.setCollectionOrderOfMagnitude(d2Collection.getCollectionOrderOfMagnitude());
		d2CollectionImpl.setBioresourceReference(d2Collection.getBioresourceReference());
		d2CollectionImpl.setContactIDRef(d2Collection.getContactIDRef());
		d2CollectionImpl.setContactPriority(d2Collection.getContactPriority());
		d2CollectionImpl.setBiobankNetworkIDRef(d2Collection.getBiobankNetworkIDRef());
		d2CollectionImpl.setGeoLatitude(d2Collection.getGeoLatitude());
		d2CollectionImpl.setGeoLongitude(d2Collection.getGeoLongitude());
		d2CollectionImpl.setCollaborationPartnersCommercial(d2Collection.isCollaborationPartnersCommercial());
		d2CollectionImpl.setCollaborationPartnersNonforprofit(d2Collection.isCollaborationPartnersNonforprofit());
		d2CollectionImpl.setCollectionAcronym(d2Collection.getCollectionAcronym());
		d2CollectionImpl.setCollectionDescription(d2Collection.getCollectionDescription());
		d2CollectionImpl.setCollectionSexMale(d2Collection.isCollectionSexMale());
		d2CollectionImpl.setCollectionSexFemale(d2Collection.isCollectionSexFemale());
		d2CollectionImpl.setCollectionSexUnknown(d2Collection.isCollectionSexUnknown());
		d2CollectionImpl.setCollectionSexUndiferrentiated(d2Collection.isCollectionSexUndiferrentiated());
		d2CollectionImpl.setCollectionAgeLow(d2Collection.getCollectionAgeLow());
		d2CollectionImpl.setCollectionAgeHigh(d2Collection.getCollectionAgeHigh());
		d2CollectionImpl.setCollectionAgeUnit(d2Collection.getCollectionAgeUnit());
		d2CollectionImpl.setCollectionAvailableBiologicalSamples(d2Collection.isCollectionAvailableBiologicalSamples());
		d2CollectionImpl.setCollectionAvailableSurveyData(d2Collection.isCollectionAvailableSurveyData());
		d2CollectionImpl.setCollectionAvailableImagingData(d2Collection.isCollectionAvailableImagingData());
		d2CollectionImpl.setCollectionAvailableMedicalRecords(d2Collection.isCollectionAvailableMedicalRecords());
		d2CollectionImpl.setCollectionAvailableNationalRegistries(d2Collection.isCollectionAvailableNationalRegistries());
		d2CollectionImpl.setCollectionAvailableGenealogicalRecords(d2Collection.isCollectionAvailableGenealogicalRecords());
		d2CollectionImpl.setCollectionAvailablePhysioBiochemMeasurements(d2Collection.isCollectionAvailablePhysioBiochemMeasurements());
		d2CollectionImpl.setCollectionAvailableOther(d2Collection.getCollectionAvailableOther());
		d2CollectionImpl.setTemperatureRoom(d2Collection.isTemperatureRoom());
		d2CollectionImpl.setTemperature2to10(d2Collection.isTemperature2to10());
		d2CollectionImpl.setTemperature18to35(d2Collection.isTemperature18to35());
		d2CollectionImpl.setTemperature60to85(d2Collection.isTemperature60to85());
		d2CollectionImpl.setTemperatureLN(d2Collection.isTemperatureLN());
		d2CollectionImpl.setTemperatureOther(d2Collection.getTemperatureOther());
		d2CollectionImpl.setDiagnosisAvailable(d2Collection.getDiagnosisAvailable());
		d2CollectionImpl.setCollectionHeadFirstName(d2Collection.getCollectionHeadFirstName());
		d2CollectionImpl.setCollectionHeadLastName(d2Collection.getCollectionHeadLastName());
		d2CollectionImpl.setCollectionHeadRole(d2Collection.getCollectionHeadRole());
		d2CollectionImpl.setCollectionSampleAccessFee(d2Collection.isCollectionSampleAccessFee());
		d2CollectionImpl.setCollectionSampleAccessJointProjects(d2Collection.isCollectionSampleAccessJointProjects());
		d2CollectionImpl.setCollectionSampleAccessDescription(d2Collection.getCollectionSampleAccessDescription());
		d2CollectionImpl.setCollectionSampleAccessURI(d2Collection.getCollectionSampleAccessURI());
		d2CollectionImpl.setCollectionDataAccessFee(d2Collection.isCollectionDataAccessFee());
		d2CollectionImpl.setCollectionDataAccessJointProjects(d2Collection.isCollectionDataAccessJointProjects());
		d2CollectionImpl.setCollectionDataAccessDescription(d2Collection.getCollectionDataAccessDescription());
		d2CollectionImpl.setCollectionDataAccessURI(d2Collection.getCollectionDataAccessURI());
		d2CollectionImpl.setCollectionSize(d2Collection.getCollectionSize());
		d2CollectionImpl.setCollectionSizeTimestamp(d2Collection.getCollectionSizeTimestamp());

		return d2CollectionImpl;
	}

	/**
	 * Returns the d2 collection with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the d2 collection
	 * @return the d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByPrimaryKey(Serializable primaryKey)
		throws NoSuchD2CollectionException, SystemException {
		D2Collection d2Collection = fetchByPrimaryKey(primaryKey);

		if (d2Collection == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchD2CollectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return d2Collection;
	}

	/**
	 * Returns the d2 collection with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException} if it could not be found.
	 *
	 * @param d2collectionId the primary key of the d2 collection
	 * @return the d2 collection
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2CollectionException if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection findByPrimaryKey(long d2collectionId)
		throws NoSuchD2CollectionException, SystemException {
		return findByPrimaryKey((Serializable)d2collectionId);
	}

	/**
	 * Returns the d2 collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the d2 collection
	 * @return the d2 collection, or <code>null</code> if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		D2Collection d2Collection = (D2Collection)EntityCacheUtil.getResult(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
				D2CollectionImpl.class, primaryKey);

		if (d2Collection == _nullD2Collection) {
			return null;
		}

		if (d2Collection == null) {
			Session session = null;

			try {
				session = openSession();

				d2Collection = (D2Collection)session.get(D2CollectionImpl.class,
						primaryKey);

				if (d2Collection != null) {
					cacheResult(d2Collection);
				}
				else {
					EntityCacheUtil.putResult(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
						D2CollectionImpl.class, primaryKey, _nullD2Collection);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(D2CollectionModelImpl.ENTITY_CACHE_ENABLED,
					D2CollectionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return d2Collection;
	}

	/**
	 * Returns the d2 collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param d2collectionId the primary key of the d2 collection
	 * @return the d2 collection, or <code>null</code> if a d2 collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Collection fetchByPrimaryKey(long d2collectionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)d2collectionId);
	}

	/**
	 * Returns all the d2 collections.
	 *
	 * @return the d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @return the range of d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d2 collections
	 * @param end the upper bound of the range of d2 collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of d2 collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Collection> findAll(int start, int end,
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

		List<D2Collection> list = (List<D2Collection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_D2COLLECTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_D2COLLECTION;

				if (pagination) {
					sql = sql.concat(D2CollectionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Collection>(list);
				}
				else {
					list = (List<D2Collection>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the d2 collections from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (D2Collection d2Collection : findAll()) {
			remove(d2Collection);
		}
	}

	/**
	 * Returns the number of d2 collections.
	 *
	 * @return the number of d2 collections
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

				Query q = session.createQuery(_SQL_COUNT_D2COLLECTION);

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
	 * Initializes the d2 collection persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.bbmrieric.model.D2Collection")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<D2Collection>> listenersList = new ArrayList<ModelListener<D2Collection>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<D2Collection>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(D2CollectionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_D2COLLECTION = "SELECT d2Collection FROM D2Collection d2Collection";
	private static final String _SQL_SELECT_D2COLLECTION_WHERE = "SELECT d2Collection FROM D2Collection d2Collection WHERE ";
	private static final String _SQL_COUNT_D2COLLECTION = "SELECT COUNT(d2Collection) FROM D2Collection d2Collection";
	private static final String _SQL_COUNT_D2COLLECTION_WHERE = "SELECT COUNT(d2Collection) FROM D2Collection d2Collection WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "d2Collection.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No D2Collection exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No D2Collection exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(D2CollectionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static D2Collection _nullD2Collection = new D2CollectionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<D2Collection> toCacheModel() {
				return _nullD2CollectionCacheModel;
			}
		};

	private static CacheModel<D2Collection> _nullD2CollectionCacheModel = new CacheModel<D2Collection>() {
			@Override
			public D2Collection toEntityModel() {
				return _nullD2Collection;
			}
		};
}