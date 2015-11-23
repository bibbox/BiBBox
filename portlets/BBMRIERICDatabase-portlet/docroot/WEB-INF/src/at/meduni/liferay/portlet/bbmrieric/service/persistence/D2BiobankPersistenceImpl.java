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

import at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException;
import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankImpl;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the d2 biobank service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see D2BiobankPersistence
 * @see D2BiobankUtil
 * @generated
 */
public class D2BiobankPersistenceImpl extends BasePersistenceImpl<D2Biobank>
	implements D2BiobankPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link D2BiobankUtil} to access the d2 biobank persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = D2BiobankImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			D2BiobankModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the d2 biobanks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobanks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByUuid(String uuid, int start, int end,
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

		List<D2Biobank> list = (List<D2Biobank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Biobank d2Biobank : list) {
				if (!Validator.equals(uuid, d2Biobank.getUuid())) {
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

			query.append(_SQL_SELECT_D2BIOBANK_WHERE);

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
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
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
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Biobank>(list);
				}
				else {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 biobank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByUuid_First(uuid, orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Biobank> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByUuid_Last(uuid, orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<D2Biobank> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobanks before and after the current d2 biobank in the ordered set where uuid = &#63;.
	 *
	 * @param biobankId the primary key of the current d2 biobank
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank[] findByUuid_PrevAndNext(long biobankId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			D2Biobank[] array = new D2BiobankImpl[3];

			array[0] = getByUuid_PrevAndNext(session, d2Biobank, uuid,
					orderByComparator, true);

			array[1] = d2Biobank;

			array[2] = getByUuid_PrevAndNext(session, d2Biobank, uuid,
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

	protected D2Biobank getByUuid_PrevAndNext(Session session,
		D2Biobank d2Biobank, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANK_WHERE);

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
			query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(d2Biobank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Biobank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobanks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (D2Biobank d2Biobank : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(d2Biobank);
		}
	}

	/**
	 * Returns the number of d2 biobanks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching d2 biobanks
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

			query.append(_SQL_COUNT_D2BIOBANK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "d2Biobank.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "d2Biobank.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(d2Biobank.uuid IS NULL OR d2Biobank.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			D2BiobankModelImpl.UUID_COLUMN_BITMASK |
			D2BiobankModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the d2 biobank where uuid = &#63; and groupId = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByUUID_G(String uuid, long groupId)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByUUID_G(uuid, groupId);

		if (d2Biobank == null) {
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

			throw new NoSuchD2BiobankException(msg.toString());
		}

		return d2Biobank;
	}

	/**
	 * Returns the d2 biobank where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the d2 biobank where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof D2Biobank) {
			D2Biobank d2Biobank = (D2Biobank)result;

			if (!Validator.equals(uuid, d2Biobank.getUuid()) ||
					(groupId != d2Biobank.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_D2BIOBANK_WHERE);

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

				List<D2Biobank> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					D2Biobank d2Biobank = list.get(0);

					result = d2Biobank;

					cacheResult(d2Biobank);

					if ((d2Biobank.getUuid() == null) ||
							!d2Biobank.getUuid().equals(uuid) ||
							(d2Biobank.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, d2Biobank);
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
			return (D2Biobank)result;
		}
	}

	/**
	 * Removes the d2 biobank where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the d2 biobank that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank removeByUUID_G(String uuid, long groupId)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = findByUUID_G(uuid, groupId);

		return remove(d2Biobank);
	}

	/**
	 * Returns the number of d2 biobanks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching d2 biobanks
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

			query.append(_SQL_COUNT_D2BIOBANK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "d2Biobank.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "d2Biobank.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(d2Biobank.uuid IS NULL OR d2Biobank.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "d2Biobank.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			D2BiobankModelImpl.UUID_COLUMN_BITMASK |
			D2BiobankModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the d2 biobanks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobanks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<D2Biobank> list = (List<D2Biobank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Biobank d2Biobank : list) {
				if (!Validator.equals(uuid, d2Biobank.getUuid()) ||
						(companyId != d2Biobank.getCompanyId())) {
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

			query.append(_SQL_SELECT_D2BIOBANK_WHERE);

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
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
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
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Biobank>(list);
				}
				else {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 biobank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Biobank> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<D2Biobank> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobanks before and after the current d2 biobank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param biobankId the primary key of the current d2 biobank
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank[] findByUuid_C_PrevAndNext(long biobankId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			D2Biobank[] array = new D2BiobankImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, d2Biobank, uuid,
					companyId, orderByComparator, true);

			array[1] = d2Biobank;

			array[2] = getByUuid_C_PrevAndNext(session, d2Biobank, uuid,
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

	protected D2Biobank getByUuid_C_PrevAndNext(Session session,
		D2Biobank d2Biobank, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANK_WHERE);

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
			query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(d2Biobank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Biobank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobanks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (D2Biobank d2Biobank : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2Biobank);
		}
	}

	/**
	 * Returns the number of d2 biobanks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching d2 biobanks
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

			query.append(_SQL_COUNT_D2BIOBANK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "d2Biobank.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "d2Biobank.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(d2Biobank.uuid IS NULL OR d2Biobank.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "d2Biobank.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			D2BiobankModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the d2 biobanks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobanks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByGroupId(long groupId, int start, int end,
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

		List<D2Biobank> list = (List<D2Biobank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Biobank d2Biobank : list) {
				if ((groupId != d2Biobank.getGroupId())) {
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

			query.append(_SQL_SELECT_D2BIOBANK_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Biobank>(list);
				}
				else {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 biobank in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByGroupId_First(groupId, orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Biobank> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByGroupId_Last(groupId, orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<D2Biobank> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobanks before and after the current d2 biobank in the ordered set where groupId = &#63;.
	 *
	 * @param biobankId the primary key of the current d2 biobank
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank[] findByGroupId_PrevAndNext(long biobankId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			D2Biobank[] array = new D2BiobankImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, d2Biobank, groupId,
					orderByComparator, true);

			array[1] = d2Biobank;

			array[2] = getByGroupId_PrevAndNext(session, d2Biobank, groupId,
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

	protected D2Biobank getByGroupId_PrevAndNext(Session session,
		D2Biobank d2Biobank, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANK_WHERE);

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
			query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2Biobank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Biobank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the d2 biobanks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobanks that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(D2BiobankModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, D2BiobankImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, D2BiobankImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<D2Biobank>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the d2 biobanks before and after the current d2 biobank in the ordered set of d2 biobanks that the user has permission to view where groupId = &#63;.
	 *
	 * @param biobankId the primary key of the current d2 biobank
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank[] filterFindByGroupId_PrevAndNext(long biobankId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(biobankId, groupId,
				orderByComparator);
		}

		D2Biobank d2Biobank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			D2Biobank[] array = new D2BiobankImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, d2Biobank,
					groupId, orderByComparator, true);

			array[1] = d2Biobank;

			array[2] = filterGetByGroupId_PrevAndNext(session, d2Biobank,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected D2Biobank filterGetByGroupId_PrevAndNext(Session session,
		D2Biobank d2Biobank, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(D2BiobankModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, D2BiobankImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, D2BiobankImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2Biobank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Biobank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobanks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (D2Biobank d2Biobank : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(d2Biobank);
		}
	}

	/**
	 * Returns the number of d2 biobanks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching d2 biobanks
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

			query.append(_SQL_COUNT_D2BIOBANK_WHERE);

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

	/**
	 * Returns the number of d2 biobanks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_D2BIOBANK_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "d2Biobank.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			D2BiobankModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the d2 biobanks where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the d2 biobanks where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<D2Biobank> list = (List<D2Biobank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Biobank d2Biobank : list) {
				if ((companyId != d2Biobank.getCompanyId())) {
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

			query.append(_SQL_SELECT_D2BIOBANK_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Biobank>(list);
				}
				else {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 biobank in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Biobank> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByCompanyId_Last(companyId, orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<D2Biobank> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobanks before and after the current d2 biobank in the ordered set where companyId = &#63;.
	 *
	 * @param biobankId the primary key of the current d2 biobank
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank[] findByCompanyId_PrevAndNext(long biobankId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			D2Biobank[] array = new D2BiobankImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, d2Biobank,
					companyId, orderByComparator, true);

			array[1] = d2Biobank;

			array[2] = getByCompanyId_PrevAndNext(session, d2Biobank,
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

	protected D2Biobank getByCompanyId_PrevAndNext(Session session,
		D2Biobank d2Biobank, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANK_WHERE);

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
			query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2Biobank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Biobank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobanks where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (D2Biobank d2Biobank : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2Biobank);
		}
	}

	/**
	 * Returns the number of d2 biobanks where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching d2 biobanks
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

			query.append(_SQL_COUNT_D2BIOBANK_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "d2Biobank.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BIOBANKNAME =
		new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBiobankName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKNAME =
		new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBiobankName",
			new String[] { Long.class.getName(), String.class.getName() },
			D2BiobankModelImpl.GROUPID_COLUMN_BITMASK |
			D2BiobankModelImpl.BIOBANKNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BIOBANKNAME = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBiobankName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the d2 biobanks where groupId = &#63; and biobankName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @return the matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByBiobankName(long groupId, String biobankName)
		throws SystemException {
		return findByBiobankName(groupId, biobankName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobanks where groupId = &#63; and biobankName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByBiobankName(long groupId, String biobankName,
		int start, int end) throws SystemException {
		return findByBiobankName(groupId, biobankName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks where groupId = &#63; and biobankName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByBiobankName(long groupId, String biobankName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKNAME;
			finderArgs = new Object[] { groupId, biobankName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BIOBANKNAME;
			finderArgs = new Object[] {
					groupId, biobankName,
					
					start, end, orderByComparator
				};
		}

		List<D2Biobank> list = (List<D2Biobank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Biobank d2Biobank : list) {
				if ((groupId != d2Biobank.getGroupId()) ||
						!Validator.equals(biobankName,
							d2Biobank.getBiobankName())) {
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

			query.append(_SQL_SELECT_D2BIOBANK_WHERE);

			query.append(_FINDER_COLUMN_BIOBANKNAME_GROUPID_2);

			boolean bindBiobankName = false;

			if (biobankName == null) {
				query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_1);
			}
			else if (biobankName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_3);
			}
			else {
				bindBiobankName = true;

				query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindBiobankName) {
					qPos.add(biobankName);
				}

				if (!pagination) {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Biobank>(list);
				}
				else {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 biobank in the ordered set where groupId = &#63; and biobankName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByBiobankName_First(long groupId, String biobankName,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByBiobankName_First(groupId, biobankName,
				orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", biobankName=");
		msg.append(biobankName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank in the ordered set where groupId = &#63; and biobankName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByBiobankName_First(long groupId, String biobankName,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Biobank> list = findByBiobankName(groupId, biobankName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank in the ordered set where groupId = &#63; and biobankName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByBiobankName_Last(long groupId, String biobankName,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByBiobankName_Last(groupId, biobankName,
				orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", biobankName=");
		msg.append(biobankName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank in the ordered set where groupId = &#63; and biobankName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByBiobankName_Last(long groupId, String biobankName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBiobankName(groupId, biobankName);

		if (count == 0) {
			return null;
		}

		List<D2Biobank> list = findByBiobankName(groupId, biobankName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobanks before and after the current d2 biobank in the ordered set where groupId = &#63; and biobankName = &#63;.
	 *
	 * @param biobankId the primary key of the current d2 biobank
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank[] findByBiobankName_PrevAndNext(long biobankId,
		long groupId, String biobankName, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			D2Biobank[] array = new D2BiobankImpl[3];

			array[0] = getByBiobankName_PrevAndNext(session, d2Biobank,
					groupId, biobankName, orderByComparator, true);

			array[1] = d2Biobank;

			array[2] = getByBiobankName_PrevAndNext(session, d2Biobank,
					groupId, biobankName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected D2Biobank getByBiobankName_PrevAndNext(Session session,
		D2Biobank d2Biobank, long groupId, String biobankName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANK_WHERE);

		query.append(_FINDER_COLUMN_BIOBANKNAME_GROUPID_2);

		boolean bindBiobankName = false;

		if (biobankName == null) {
			query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_1);
		}
		else if (biobankName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_3);
		}
		else {
			bindBiobankName = true;

			query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_2);
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
			query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindBiobankName) {
			qPos.add(biobankName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2Biobank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Biobank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the d2 biobanks that the user has permission to view where groupId = &#63; and biobankName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @return the matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByBiobankName(long groupId,
		String biobankName) throws SystemException {
		return filterFindByBiobankName(groupId, biobankName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobanks that the user has permission to view where groupId = &#63; and biobankName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByBiobankName(long groupId,
		String biobankName, int start, int end) throws SystemException {
		return filterFindByBiobankName(groupId, biobankName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks that the user has permissions to view where groupId = &#63; and biobankName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByBiobankName(long groupId,
		String biobankName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByBiobankName(groupId, biobankName, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_BIOBANKNAME_GROUPID_2);

		boolean bindBiobankName = false;

		if (biobankName == null) {
			query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_1);
		}
		else if (biobankName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_3);
		}
		else {
			bindBiobankName = true;

			query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(D2BiobankModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, D2BiobankImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, D2BiobankImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindBiobankName) {
				qPos.add(biobankName);
			}

			return (List<D2Biobank>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the d2 biobanks before and after the current d2 biobank in the ordered set of d2 biobanks that the user has permission to view where groupId = &#63; and biobankName = &#63;.
	 *
	 * @param biobankId the primary key of the current d2 biobank
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank[] filterFindByBiobankName_PrevAndNext(long biobankId,
		long groupId, String biobankName, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByBiobankName_PrevAndNext(biobankId, groupId,
				biobankName, orderByComparator);
		}

		D2Biobank d2Biobank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			D2Biobank[] array = new D2BiobankImpl[3];

			array[0] = filterGetByBiobankName_PrevAndNext(session, d2Biobank,
					groupId, biobankName, orderByComparator, true);

			array[1] = d2Biobank;

			array[2] = filterGetByBiobankName_PrevAndNext(session, d2Biobank,
					groupId, biobankName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected D2Biobank filterGetByBiobankName_PrevAndNext(Session session,
		D2Biobank d2Biobank, long groupId, String biobankName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_BIOBANKNAME_GROUPID_2);

		boolean bindBiobankName = false;

		if (biobankName == null) {
			query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_1);
		}
		else if (biobankName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_3);
		}
		else {
			bindBiobankName = true;

			query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(D2BiobankModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, D2BiobankImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, D2BiobankImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindBiobankName) {
			qPos.add(biobankName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2Biobank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Biobank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobanks where groupId = &#63; and biobankName = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBiobankName(long groupId, String biobankName)
		throws SystemException {
		for (D2Biobank d2Biobank : findByBiobankName(groupId, biobankName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2Biobank);
		}
	}

	/**
	 * Returns the number of d2 biobanks where groupId = &#63; and biobankName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @return the number of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBiobankName(long groupId, String biobankName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BIOBANKNAME;

		Object[] finderArgs = new Object[] { groupId, biobankName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_D2BIOBANK_WHERE);

			query.append(_FINDER_COLUMN_BIOBANKNAME_GROUPID_2);

			boolean bindBiobankName = false;

			if (biobankName == null) {
				query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_1);
			}
			else if (biobankName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_3);
			}
			else {
				bindBiobankName = true;

				query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindBiobankName) {
					qPos.add(biobankName);
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

	/**
	 * Returns the number of d2 biobanks that the user has permission to view where groupId = &#63; and biobankName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankName the biobank name
	 * @return the number of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByBiobankName(long groupId, String biobankName)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByBiobankName(groupId, biobankName);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_D2BIOBANK_WHERE);

		query.append(_FINDER_COLUMN_BIOBANKNAME_GROUPID_2);

		boolean bindBiobankName = false;

		if (biobankName == null) {
			query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_1);
		}
		else if (biobankName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_3);
		}
		else {
			bindBiobankName = true;

			query.append(_FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindBiobankName) {
				qPos.add(biobankName);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_BIOBANKNAME_GROUPID_2 = "d2Biobank.groupId = ? AND ";
	private static final String _FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_1 = "d2Biobank.biobankName IS NULL";
	private static final String _FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_2 = "d2Biobank.biobankName = ?";
	private static final String _FINDER_COLUMN_BIOBANKNAME_BIOBANKNAME_3 = "(d2Biobank.biobankName IS NULL OR d2Biobank.biobankName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] { Long.class.getName(), Integer.class.getName() },
			D2BiobankModelImpl.GROUPID_COLUMN_BITMASK |
			D2BiobankModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the d2 biobanks where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByG_S(long groupId, int status)
		throws SystemException {
		return findByG_S(groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the d2 biobanks where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByG_S(long groupId, int status, int start,
		int end) throws SystemException {
		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByG_S(long groupId, int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] { groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] {
					groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<D2Biobank> list = (List<D2Biobank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Biobank d2Biobank : list) {
				if ((groupId != d2Biobank.getGroupId()) ||
						(status != d2Biobank.getStatus())) {
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

			query.append(_SQL_SELECT_D2BIOBANK_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Biobank>(list);
				}
				else {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 biobank in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByG_S_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByG_S_First(groupId, status,
				orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByG_S_First(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Biobank> list = findByG_S(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByG_S_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByG_S_Last(groupId, status, orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByG_S_Last(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<D2Biobank> list = findByG_S(groupId, status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobanks before and after the current d2 biobank in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param biobankId the primary key of the current d2 biobank
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank[] findByG_S_PrevAndNext(long biobankId, long groupId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			D2Biobank[] array = new D2BiobankImpl[3];

			array[0] = getByG_S_PrevAndNext(session, d2Biobank, groupId,
					status, orderByComparator, true);

			array[1] = d2Biobank;

			array[2] = getByG_S_PrevAndNext(session, d2Biobank, groupId,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected D2Biobank getByG_S_PrevAndNext(Session session,
		D2Biobank d2Biobank, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANK_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

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
			query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2Biobank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Biobank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the d2 biobanks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByG_S(long groupId, int status)
		throws SystemException {
		return filterFindByG_S(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobanks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByG_S(long groupId, int status, int start,
		int end) throws SystemException {
		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByG_S(long groupId, int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, status, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(D2BiobankModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, D2BiobankImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, D2BiobankImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(status);

			return (List<D2Biobank>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the d2 biobanks before and after the current d2 biobank in the ordered set of d2 biobanks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param biobankId the primary key of the current d2 biobank
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank[] filterFindByG_S_PrevAndNext(long biobankId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(biobankId, groupId, status,
				orderByComparator);
		}

		D2Biobank d2Biobank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			D2Biobank[] array = new D2BiobankImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(session, d2Biobank, groupId,
					status, orderByComparator, true);

			array[1] = d2Biobank;

			array[2] = filterGetByG_S_PrevAndNext(session, d2Biobank, groupId,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected D2Biobank filterGetByG_S_PrevAndNext(Session session,
		D2Biobank d2Biobank, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(D2BiobankModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, D2BiobankImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, D2BiobankImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2Biobank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Biobank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobanks where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_S(long groupId, int status) throws SystemException {
		for (D2Biobank d2Biobank : findByG_S(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2Biobank);
		}
	}

	/**
	 * Returns the number of d2 biobanks where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_S(long groupId, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S;

		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_D2BIOBANK_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

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

	/**
	 * Returns the number of d2 biobanks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_S(long groupId, int status)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_D2BIOBANK_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "d2Biobank.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_STATUS_2 = "d2Biobank.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BIOBANK = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBiobank",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANK =
		new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBiobank",
			new String[] { Long.class.getName(), Long.class.getName() },
			D2BiobankModelImpl.GROUPID_COLUMN_BITMASK |
			D2BiobankModelImpl.BIOBANKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BIOBANK = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBiobank",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the d2 biobanks where groupId = &#63; and biobankId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @return the matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByBiobank(long groupId, long biobankId)
		throws SystemException {
		return findByBiobank(groupId, biobankId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobanks where groupId = &#63; and biobankId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByBiobank(long groupId, long biobankId,
		int start, int end) throws SystemException {
		return findByBiobank(groupId, biobankId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks where groupId = &#63; and biobankId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByBiobank(long groupId, long biobankId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANK;
			finderArgs = new Object[] { groupId, biobankId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BIOBANK;
			finderArgs = new Object[] {
					groupId, biobankId,
					
					start, end, orderByComparator
				};
		}

		List<D2Biobank> list = (List<D2Biobank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Biobank d2Biobank : list) {
				if ((groupId != d2Biobank.getGroupId()) ||
						(biobankId != d2Biobank.getBiobankId())) {
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

			query.append(_SQL_SELECT_D2BIOBANK_WHERE);

			query.append(_FINDER_COLUMN_BIOBANK_GROUPID_2);

			query.append(_FINDER_COLUMN_BIOBANK_BIOBANKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(biobankId);

				if (!pagination) {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Biobank>(list);
				}
				else {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 biobank in the ordered set where groupId = &#63; and biobankId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByBiobank_First(long groupId, long biobankId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByBiobank_First(groupId, biobankId,
				orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", biobankId=");
		msg.append(biobankId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank in the ordered set where groupId = &#63; and biobankId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByBiobank_First(long groupId, long biobankId,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Biobank> list = findByBiobank(groupId, biobankId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank in the ordered set where groupId = &#63; and biobankId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByBiobank_Last(long groupId, long biobankId,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByBiobank_Last(groupId, biobankId,
				orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", biobankId=");
		msg.append(biobankId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank in the ordered set where groupId = &#63; and biobankId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByBiobank_Last(long groupId, long biobankId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBiobank(groupId, biobankId);

		if (count == 0) {
			return null;
		}

		List<D2Biobank> list = findByBiobank(groupId, biobankId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns all the d2 biobanks that the user has permission to view where groupId = &#63; and biobankId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @return the matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByBiobank(long groupId, long biobankId)
		throws SystemException {
		return filterFindByBiobank(groupId, biobankId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobanks that the user has permission to view where groupId = &#63; and biobankId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByBiobank(long groupId, long biobankId,
		int start, int end) throws SystemException {
		return filterFindByBiobank(groupId, biobankId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks that the user has permissions to view where groupId = &#63; and biobankId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByBiobank(long groupId, long biobankId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByBiobank(groupId, biobankId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_BIOBANK_GROUPID_2);

		query.append(_FINDER_COLUMN_BIOBANK_BIOBANKID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(D2BiobankModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, D2BiobankImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, D2BiobankImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(biobankId);

			return (List<D2Biobank>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes all the d2 biobanks where groupId = &#63; and biobankId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBiobank(long groupId, long biobankId)
		throws SystemException {
		for (D2Biobank d2Biobank : findByBiobank(groupId, biobankId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2Biobank);
		}
	}

	/**
	 * Returns the number of d2 biobanks where groupId = &#63; and biobankId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @return the number of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBiobank(long groupId, long biobankId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BIOBANK;

		Object[] finderArgs = new Object[] { groupId, biobankId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_D2BIOBANK_WHERE);

			query.append(_FINDER_COLUMN_BIOBANK_GROUPID_2);

			query.append(_FINDER_COLUMN_BIOBANK_BIOBANKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	/**
	 * Returns the number of d2 biobanks that the user has permission to view where groupId = &#63; and biobankId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param biobankId the biobank ID
	 * @return the number of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByBiobank(long groupId, long biobankId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByBiobank(groupId, biobankId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_D2BIOBANK_WHERE);

		query.append(_FINDER_COLUMN_BIOBANK_GROUPID_2);

		query.append(_FINDER_COLUMN_BIOBANK_BIOBANKID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(biobankId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_BIOBANK_GROUPID_2 = "d2Biobank.groupId = ? AND ";
	private static final String _FINDER_COLUMN_BIOBANK_BIOBANKID_2 = "d2Biobank.biobankId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_BIOBANKBBMRIERICID = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByBiobankBBMRIERICID",
			new String[] { Long.class.getName(), String.class.getName() },
			D2BiobankModelImpl.GROUPID_COLUMN_BITMASK |
			D2BiobankModelImpl.BBMRIBIOBANKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BIOBANKBBMRIERICID = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBiobankBBMRIERICID",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the d2 biobank where groupId = &#63; and bbmribiobankID = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param bbmribiobankID the bbmribiobank i d
	 * @return the matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByBiobankBBMRIERICID(long groupId,
		String bbmribiobankID) throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByBiobankBBMRIERICID(groupId, bbmribiobankID);

		if (d2Biobank == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", bbmribiobankID=");
			msg.append(bbmribiobankID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchD2BiobankException(msg.toString());
		}

		return d2Biobank;
	}

	/**
	 * Returns the d2 biobank where groupId = &#63; and bbmribiobankID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param bbmribiobankID the bbmribiobank i d
	 * @return the matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByBiobankBBMRIERICID(long groupId,
		String bbmribiobankID) throws SystemException {
		return fetchByBiobankBBMRIERICID(groupId, bbmribiobankID, true);
	}

	/**
	 * Returns the d2 biobank where groupId = &#63; and bbmribiobankID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param bbmribiobankID the bbmribiobank i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByBiobankBBMRIERICID(long groupId,
		String bbmribiobankID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, bbmribiobankID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BIOBANKBBMRIERICID,
					finderArgs, this);
		}

		if (result instanceof D2Biobank) {
			D2Biobank d2Biobank = (D2Biobank)result;

			if ((groupId != d2Biobank.getGroupId()) ||
					!Validator.equals(bbmribiobankID,
						d2Biobank.getBbmribiobankID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_D2BIOBANK_WHERE);

			query.append(_FINDER_COLUMN_BIOBANKBBMRIERICID_GROUPID_2);

			boolean bindBbmribiobankID = false;

			if (bbmribiobankID == null) {
				query.append(_FINDER_COLUMN_BIOBANKBBMRIERICID_BBMRIBIOBANKID_1);
			}
			else if (bbmribiobankID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKBBMRIERICID_BBMRIBIOBANKID_3);
			}
			else {
				bindBbmribiobankID = true;

				query.append(_FINDER_COLUMN_BIOBANKBBMRIERICID_BBMRIBIOBANKID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindBbmribiobankID) {
					qPos.add(bbmribiobankID);
				}

				List<D2Biobank> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKBBMRIERICID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"D2BiobankPersistenceImpl.fetchByBiobankBBMRIERICID(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					D2Biobank d2Biobank = list.get(0);

					result = d2Biobank;

					cacheResult(d2Biobank);

					if ((d2Biobank.getGroupId() != groupId) ||
							(d2Biobank.getBbmribiobankID() == null) ||
							!d2Biobank.getBbmribiobankID().equals(bbmribiobankID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKBBMRIERICID,
							finderArgs, d2Biobank);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BIOBANKBBMRIERICID,
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
			return (D2Biobank)result;
		}
	}

	/**
	 * Removes the d2 biobank where groupId = &#63; and bbmribiobankID = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param bbmribiobankID the bbmribiobank i d
	 * @return the d2 biobank that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank removeByBiobankBBMRIERICID(long groupId,
		String bbmribiobankID) throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = findByBiobankBBMRIERICID(groupId, bbmribiobankID);

		return remove(d2Biobank);
	}

	/**
	 * Returns the number of d2 biobanks where groupId = &#63; and bbmribiobankID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param bbmribiobankID the bbmribiobank i d
	 * @return the number of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBiobankBBMRIERICID(long groupId, String bbmribiobankID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BIOBANKBBMRIERICID;

		Object[] finderArgs = new Object[] { groupId, bbmribiobankID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_D2BIOBANK_WHERE);

			query.append(_FINDER_COLUMN_BIOBANKBBMRIERICID_GROUPID_2);

			boolean bindBbmribiobankID = false;

			if (bbmribiobankID == null) {
				query.append(_FINDER_COLUMN_BIOBANKBBMRIERICID_BBMRIBIOBANKID_1);
			}
			else if (bbmribiobankID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKBBMRIERICID_BBMRIBIOBANKID_3);
			}
			else {
				bindBbmribiobankID = true;

				query.append(_FINDER_COLUMN_BIOBANKBBMRIERICID_BBMRIBIOBANKID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_BIOBANKBBMRIERICID_GROUPID_2 = "d2Biobank.groupId = ? AND ";
	private static final String _FINDER_COLUMN_BIOBANKBBMRIERICID_BBMRIBIOBANKID_1 =
		"d2Biobank.bbmribiobankID IS NULL";
	private static final String _FINDER_COLUMN_BIOBANKBBMRIERICID_BBMRIBIOBANKID_2 =
		"d2Biobank.bbmribiobankID = ?";
	private static final String _FINDER_COLUMN_BIOBANKBBMRIERICID_BBMRIBIOBANKID_3 =
		"(d2Biobank.bbmribiobankID IS NULL OR d2Biobank.bbmribiobankID = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTUUID = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, D2BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNotUUID",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTUUID = new FinderPath(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNotUUID",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the d2 biobanks where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @return the matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByNotUUID(long groupId, String updateuuid)
		throws SystemException {
		return findByNotUUID(groupId, updateuuid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobanks where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByNotUUID(long groupId, String updateuuid,
		int start, int end) throws SystemException {
		return findByNotUUID(groupId, updateuuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findByNotUUID(long groupId, String updateuuid,
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

		List<D2Biobank> list = (List<D2Biobank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (D2Biobank d2Biobank : list) {
				if ((groupId != d2Biobank.getGroupId()) ||
						Validator.equals(updateuuid, d2Biobank.getUpdateuuid())) {
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

			query.append(_SQL_SELECT_D2BIOBANK_WHERE);

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
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
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
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Biobank>(list);
				}
				else {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first d2 biobank in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByNotUUID_First(long groupId, String updateuuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByNotUUID_First(groupId, updateuuid,
				orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", updateuuid=");
		msg.append(updateuuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the first d2 biobank in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByNotUUID_First(long groupId, String updateuuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<D2Biobank> list = findByNotUUID(groupId, updateuuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d2 biobank in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByNotUUID_Last(long groupId, String updateuuid,
		OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByNotUUID_Last(groupId, updateuuid,
				orderByComparator);

		if (d2Biobank != null) {
			return d2Biobank;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", updateuuid=");
		msg.append(updateuuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchD2BiobankException(msg.toString());
	}

	/**
	 * Returns the last d2 biobank in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByNotUUID_Last(long groupId, String updateuuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNotUUID(groupId, updateuuid);

		if (count == 0) {
			return null;
		}

		List<D2Biobank> list = findByNotUUID(groupId, updateuuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d2 biobanks before and after the current d2 biobank in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param biobankId the primary key of the current d2 biobank
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank[] findByNotUUID_PrevAndNext(long biobankId, long groupId,
		String updateuuid, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			D2Biobank[] array = new D2BiobankImpl[3];

			array[0] = getByNotUUID_PrevAndNext(session, d2Biobank, groupId,
					updateuuid, orderByComparator, true);

			array[1] = d2Biobank;

			array[2] = getByNotUUID_PrevAndNext(session, d2Biobank, groupId,
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

	protected D2Biobank getByNotUUID_PrevAndNext(Session session,
		D2Biobank d2Biobank, long groupId, String updateuuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_D2BIOBANK_WHERE);

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
			query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(d2Biobank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Biobank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the d2 biobanks that the user has permission to view where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @return the matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByNotUUID(long groupId, String updateuuid)
		throws SystemException {
		return filterFindByNotUUID(groupId, updateuuid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobanks that the user has permission to view where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByNotUUID(long groupId, String updateuuid,
		int start, int end) throws SystemException {
		return filterFindByNotUUID(groupId, updateuuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks that the user has permissions to view where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> filterFindByNotUUID(long groupId, String updateuuid,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByNotUUID(groupId, updateuuid, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_1);
		}

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

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(D2BiobankModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, D2BiobankImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, D2BiobankImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindUpdateuuid) {
				qPos.add(updateuuid);
			}

			return (List<D2Biobank>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the d2 biobanks before and after the current d2 biobank in the ordered set of d2 biobanks that the user has permission to view where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param biobankId the primary key of the current d2 biobank
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank[] filterFindByNotUUID_PrevAndNext(long biobankId,
		long groupId, String updateuuid, OrderByComparator orderByComparator)
		throws NoSuchD2BiobankException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByNotUUID_PrevAndNext(biobankId, groupId, updateuuid,
				orderByComparator);
		}

		D2Biobank d2Biobank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			D2Biobank[] array = new D2BiobankImpl[3];

			array[0] = filterGetByNotUUID_PrevAndNext(session, d2Biobank,
					groupId, updateuuid, orderByComparator, true);

			array[1] = d2Biobank;

			array[2] = filterGetByNotUUID_PrevAndNext(session, d2Biobank,
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

	protected D2Biobank filterGetByNotUUID_PrevAndNext(Session session,
		D2Biobank d2Biobank, long groupId, String updateuuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_1);
		}

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

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(D2BiobankModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(D2BiobankModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, D2BiobankImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, D2BiobankImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindUpdateuuid) {
			qPos.add(updateuuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(d2Biobank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<D2Biobank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d2 biobanks where groupId = &#63; and updateuuid &ne; &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNotUUID(long groupId, String updateuuid)
		throws SystemException {
		for (D2Biobank d2Biobank : findByNotUUID(groupId, updateuuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(d2Biobank);
		}
	}

	/**
	 * Returns the number of d2 biobanks where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @return the number of matching d2 biobanks
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

			query.append(_SQL_COUNT_D2BIOBANK_WHERE);

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

	/**
	 * Returns the number of d2 biobanks that the user has permission to view where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @return the number of matching d2 biobanks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByNotUUID(long groupId, String updateuuid)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByNotUUID(groupId, updateuuid);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_D2BIOBANK_WHERE);

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

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				D2Biobank.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindUpdateuuid) {
				qPos.add(updateuuid);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_NOTUUID_GROUPID_2 = "d2Biobank.groupId = ? AND ";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_1 = "d2Biobank.updateuuid IS NOT NULL";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_2 = "d2Biobank.updateuuid != ?";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_3 = "(d2Biobank.updateuuid IS NULL OR d2Biobank.updateuuid != '')";

	public D2BiobankPersistenceImpl() {
		setModelClass(D2Biobank.class);
	}

	/**
	 * Caches the d2 biobank in the entity cache if it is enabled.
	 *
	 * @param d2Biobank the d2 biobank
	 */
	@Override
	public void cacheResult(D2Biobank d2Biobank) {
		EntityCacheUtil.putResult(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankImpl.class, d2Biobank.getPrimaryKey(), d2Biobank);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { d2Biobank.getUuid(), d2Biobank.getGroupId() },
			d2Biobank);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKBBMRIERICID,
			new Object[] { d2Biobank.getGroupId(), d2Biobank.getBbmribiobankID() },
			d2Biobank);

		d2Biobank.resetOriginalValues();
	}

	/**
	 * Caches the d2 biobanks in the entity cache if it is enabled.
	 *
	 * @param d2Biobanks the d2 biobanks
	 */
	@Override
	public void cacheResult(List<D2Biobank> d2Biobanks) {
		for (D2Biobank d2Biobank : d2Biobanks) {
			if (EntityCacheUtil.getResult(
						D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
						D2BiobankImpl.class, d2Biobank.getPrimaryKey()) == null) {
				cacheResult(d2Biobank);
			}
			else {
				d2Biobank.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all d2 biobanks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(D2BiobankImpl.class.getName());
		}

		EntityCacheUtil.clearCache(D2BiobankImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the d2 biobank.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(D2Biobank d2Biobank) {
		EntityCacheUtil.removeResult(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankImpl.class, d2Biobank.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(d2Biobank);
	}

	@Override
	public void clearCache(List<D2Biobank> d2Biobanks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (D2Biobank d2Biobank : d2Biobanks) {
			EntityCacheUtil.removeResult(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
				D2BiobankImpl.class, d2Biobank.getPrimaryKey());

			clearUniqueFindersCache(d2Biobank);
		}
	}

	protected void cacheUniqueFindersCache(D2Biobank d2Biobank) {
		if (d2Biobank.isNew()) {
			Object[] args = new Object[] {
					d2Biobank.getUuid(), d2Biobank.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				d2Biobank);

			args = new Object[] {
					d2Biobank.getGroupId(), d2Biobank.getBbmribiobankID()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BIOBANKBBMRIERICID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKBBMRIERICID,
				args, d2Biobank);
		}
		else {
			D2BiobankModelImpl d2BiobankModelImpl = (D2BiobankModelImpl)d2Biobank;

			if ((d2BiobankModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2Biobank.getUuid(), d2Biobank.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					d2Biobank);
			}

			if ((d2BiobankModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BIOBANKBBMRIERICID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2Biobank.getGroupId(), d2Biobank.getBbmribiobankID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BIOBANKBBMRIERICID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKBBMRIERICID,
					args, d2Biobank);
			}
		}
	}

	protected void clearUniqueFindersCache(D2Biobank d2Biobank) {
		D2BiobankModelImpl d2BiobankModelImpl = (D2BiobankModelImpl)d2Biobank;

		Object[] args = new Object[] { d2Biobank.getUuid(), d2Biobank.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((d2BiobankModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					d2BiobankModelImpl.getOriginalUuid(),
					d2BiobankModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				d2Biobank.getGroupId(), d2Biobank.getBbmribiobankID()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKBBMRIERICID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BIOBANKBBMRIERICID,
			args);

		if ((d2BiobankModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BIOBANKBBMRIERICID.getColumnBitmask()) != 0) {
			args = new Object[] {
					d2BiobankModelImpl.getOriginalGroupId(),
					d2BiobankModelImpl.getOriginalBbmribiobankID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKBBMRIERICID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BIOBANKBBMRIERICID,
				args);
		}
	}

	/**
	 * Creates a new d2 biobank with the primary key. Does not add the d2 biobank to the database.
	 *
	 * @param biobankId the primary key for the new d2 biobank
	 * @return the new d2 biobank
	 */
	@Override
	public D2Biobank create(long biobankId) {
		D2Biobank d2Biobank = new D2BiobankImpl();

		d2Biobank.setNew(true);
		d2Biobank.setPrimaryKey(biobankId);

		String uuid = PortalUUIDUtil.generate();

		d2Biobank.setUuid(uuid);

		return d2Biobank;
	}

	/**
	 * Removes the d2 biobank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param biobankId the primary key of the d2 biobank
	 * @return the d2 biobank that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank remove(long biobankId)
		throws NoSuchD2BiobankException, SystemException {
		return remove((Serializable)biobankId);
	}

	/**
	 * Removes the d2 biobank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the d2 biobank
	 * @return the d2 biobank that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank remove(Serializable primaryKey)
		throws NoSuchD2BiobankException, SystemException {
		Session session = null;

		try {
			session = openSession();

			D2Biobank d2Biobank = (D2Biobank)session.get(D2BiobankImpl.class,
					primaryKey);

			if (d2Biobank == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchD2BiobankException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(d2Biobank);
		}
		catch (NoSuchD2BiobankException nsee) {
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
	protected D2Biobank removeImpl(D2Biobank d2Biobank)
		throws SystemException {
		d2Biobank = toUnwrappedModel(d2Biobank);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(d2Biobank)) {
				d2Biobank = (D2Biobank)session.get(D2BiobankImpl.class,
						d2Biobank.getPrimaryKeyObj());
			}

			if (d2Biobank != null) {
				session.delete(d2Biobank);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (d2Biobank != null) {
			clearCache(d2Biobank);
		}

		return d2Biobank;
	}

	@Override
	public D2Biobank updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.D2Biobank d2Biobank)
		throws SystemException {
		d2Biobank = toUnwrappedModel(d2Biobank);

		boolean isNew = d2Biobank.isNew();

		D2BiobankModelImpl d2BiobankModelImpl = (D2BiobankModelImpl)d2Biobank;

		if (Validator.isNull(d2Biobank.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			d2Biobank.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (d2Biobank.isNew()) {
				session.save(d2Biobank);

				d2Biobank.setNew(false);
			}
			else {
				session.merge(d2Biobank);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !D2BiobankModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((d2BiobankModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { d2BiobankModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((d2BiobankModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankModelImpl.getOriginalUuid(),
						d2BiobankModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						d2BiobankModelImpl.getUuid(),
						d2BiobankModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((d2BiobankModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { d2BiobankModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((d2BiobankModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { d2BiobankModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((d2BiobankModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankModelImpl.getOriginalGroupId(),
						d2BiobankModelImpl.getOriginalBiobankName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKNAME,
					args);

				args = new Object[] {
						d2BiobankModelImpl.getGroupId(),
						d2BiobankModelImpl.getBiobankName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKNAME,
					args);
			}

			if ((d2BiobankModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankModelImpl.getOriginalGroupId(),
						d2BiobankModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);

				args = new Object[] {
						d2BiobankModelImpl.getGroupId(),
						d2BiobankModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);
			}

			if ((d2BiobankModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						d2BiobankModelImpl.getOriginalGroupId(),
						d2BiobankModelImpl.getOriginalBiobankId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANK, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANK,
					args);

				args = new Object[] {
						d2BiobankModelImpl.getGroupId(),
						d2BiobankModelImpl.getBiobankId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANK, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANK,
					args);
			}
		}

		EntityCacheUtil.putResult(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
			D2BiobankImpl.class, d2Biobank.getPrimaryKey(), d2Biobank);

		clearUniqueFindersCache(d2Biobank);
		cacheUniqueFindersCache(d2Biobank);

		return d2Biobank;
	}

	protected D2Biobank toUnwrappedModel(D2Biobank d2Biobank) {
		if (d2Biobank instanceof D2BiobankImpl) {
			return d2Biobank;
		}

		D2BiobankImpl d2BiobankImpl = new D2BiobankImpl();

		d2BiobankImpl.setNew(d2Biobank.isNew());
		d2BiobankImpl.setPrimaryKey(d2Biobank.getPrimaryKey());

		d2BiobankImpl.setUuid(d2Biobank.getUuid());
		d2BiobankImpl.setBiobankId(d2Biobank.getBiobankId());
		d2BiobankImpl.setStatus(d2Biobank.getStatus());
		d2BiobankImpl.setStatusByUserId(d2Biobank.getStatusByUserId());
		d2BiobankImpl.setStatusByUserName(d2Biobank.getStatusByUserName());
		d2BiobankImpl.setStatusDate(d2Biobank.getStatusDate());
		d2BiobankImpl.setCompanyId(d2Biobank.getCompanyId());
		d2BiobankImpl.setGroupId(d2Biobank.getGroupId());
		d2BiobankImpl.setUserId(d2Biobank.getUserId());
		d2BiobankImpl.setUserName(d2Biobank.getUserName());
		d2BiobankImpl.setCreateDate(d2Biobank.getCreateDate());
		d2BiobankImpl.setModifiedDate(d2Biobank.getModifiedDate());
		d2BiobankImpl.setUpdateuuid(d2Biobank.getUpdateuuid());
		d2BiobankImpl.setContactIDRef(d2Biobank.getContactIDRef());
		d2BiobankImpl.setContactPriority(d2Biobank.getContactPriority());
		d2BiobankImpl.setBbmribiobankID(d2Biobank.getBbmribiobankID());
		d2BiobankImpl.setBiobankName(d2Biobank.getBiobankName());
		d2BiobankImpl.setBiobankJurisdicalPerson(d2Biobank.getBiobankJurisdicalPerson());
		d2BiobankImpl.setBiobankCountry(d2Biobank.getBiobankCountry());
		d2BiobankImpl.setBiobankPartnerCharterSigned(d2Biobank.isBiobankPartnerCharterSigned());
		d2BiobankImpl.setBioresourceReference(d2Biobank.getBioresourceReference());
		d2BiobankImpl.setBiobankNetworkIDRef(d2Biobank.getBiobankNetworkIDRef());
		d2BiobankImpl.setGeoLatitude(d2Biobank.getGeoLatitude());
		d2BiobankImpl.setGeoLongitude(d2Biobank.getGeoLongitude());
		d2BiobankImpl.setCollaborationPartnersCommercial(d2Biobank.isCollaborationPartnersCommercial());
		d2BiobankImpl.setCollaborationPartnersNonforprofit(d2Biobank.isCollaborationPartnersNonforprofit());
		d2BiobankImpl.setBiobankITSupportAvailable(d2Biobank.isBiobankITSupportAvailable());
		d2BiobankImpl.setBiobankITStaffSize(d2Biobank.getBiobankITStaffSize());
		d2BiobankImpl.setBiobankISAvailable(d2Biobank.isBiobankISAvailable());
		d2BiobankImpl.setBiobankHISAvailable(d2Biobank.isBiobankHISAvailable());
		d2BiobankImpl.setBiobankAcronym(d2Biobank.getBiobankAcronym());
		d2BiobankImpl.setBiobankDescription(d2Biobank.getBiobankDescription());
		d2BiobankImpl.setBiobankURL(d2Biobank.getBiobankURL());
		d2BiobankImpl.setBiobankHeadFirstName(d2Biobank.getBiobankHeadFirstName());
		d2BiobankImpl.setBiobankHeadLastName(d2Biobank.getBiobankHeadLastName());
		d2BiobankImpl.setBiobankHeadRole(d2Biobank.getBiobankHeadRole());
		d2BiobankImpl.setBiobankClinical(d2Biobank.isBiobankClinical());
		d2BiobankImpl.setBiobankPopulation(d2Biobank.isBiobankPopulation());
		d2BiobankImpl.setBiobankResearchStudy(d2Biobank.isBiobankResearchStudy());
		d2BiobankImpl.setBiobankNonHuman(d2Biobank.isBiobankNonHuman());
		d2BiobankImpl.setBiobankCollection(d2Biobank.isBiobankCollection());
		d2BiobankImpl.setBiobankType(d2Biobank.getBiobankType());

		return d2BiobankImpl;
	}

	/**
	 * Returns the d2 biobank with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the d2 biobank
	 * @return the d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByPrimaryKey(Serializable primaryKey)
		throws NoSuchD2BiobankException, SystemException {
		D2Biobank d2Biobank = fetchByPrimaryKey(primaryKey);

		if (d2Biobank == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchD2BiobankException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return d2Biobank;
	}

	/**
	 * Returns the d2 biobank with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException} if it could not be found.
	 *
	 * @param biobankId the primary key of the d2 biobank
	 * @return the d2 biobank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankException if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank findByPrimaryKey(long biobankId)
		throws NoSuchD2BiobankException, SystemException {
		return findByPrimaryKey((Serializable)biobankId);
	}

	/**
	 * Returns the d2 biobank with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the d2 biobank
	 * @return the d2 biobank, or <code>null</code> if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		D2Biobank d2Biobank = (D2Biobank)EntityCacheUtil.getResult(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
				D2BiobankImpl.class, primaryKey);

		if (d2Biobank == _nullD2Biobank) {
			return null;
		}

		if (d2Biobank == null) {
			Session session = null;

			try {
				session = openSession();

				d2Biobank = (D2Biobank)session.get(D2BiobankImpl.class,
						primaryKey);

				if (d2Biobank != null) {
					cacheResult(d2Biobank);
				}
				else {
					EntityCacheUtil.putResult(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
						D2BiobankImpl.class, primaryKey, _nullD2Biobank);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(D2BiobankModelImpl.ENTITY_CACHE_ENABLED,
					D2BiobankImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return d2Biobank;
	}

	/**
	 * Returns the d2 biobank with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param biobankId the primary key of the d2 biobank
	 * @return the d2 biobank, or <code>null</code> if a d2 biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public D2Biobank fetchByPrimaryKey(long biobankId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)biobankId);
	}

	/**
	 * Returns all the d2 biobanks.
	 *
	 * @return the d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d2 biobanks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @return the range of d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the d2 biobanks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d2 biobanks
	 * @param end the upper bound of the range of d2 biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of d2 biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<D2Biobank> findAll(int start, int end,
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

		List<D2Biobank> list = (List<D2Biobank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_D2BIOBANK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_D2BIOBANK;

				if (pagination) {
					sql = sql.concat(D2BiobankModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<D2Biobank>(list);
				}
				else {
					list = (List<D2Biobank>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the d2 biobanks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (D2Biobank d2Biobank : findAll()) {
			remove(d2Biobank);
		}
	}

	/**
	 * Returns the number of d2 biobanks.
	 *
	 * @return the number of d2 biobanks
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

				Query q = session.createQuery(_SQL_COUNT_D2BIOBANK);

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
	 * Initializes the d2 biobank persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.bbmrieric.model.D2Biobank")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<D2Biobank>> listenersList = new ArrayList<ModelListener<D2Biobank>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<D2Biobank>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(D2BiobankImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_D2BIOBANK = "SELECT d2Biobank FROM D2Biobank d2Biobank";
	private static final String _SQL_SELECT_D2BIOBANK_WHERE = "SELECT d2Biobank FROM D2Biobank d2Biobank WHERE ";
	private static final String _SQL_COUNT_D2BIOBANK = "SELECT COUNT(d2Biobank) FROM D2Biobank d2Biobank";
	private static final String _SQL_COUNT_D2BIOBANK_WHERE = "SELECT COUNT(d2Biobank) FROM D2Biobank d2Biobank WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "d2Biobank.biobankId";
	private static final String _FILTER_SQL_SELECT_D2BIOBANK_WHERE = "SELECT DISTINCT {d2Biobank.*} FROM bbmrieric.d2biobank d2Biobank WHERE ";
	private static final String _FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {bbmrieric.d2biobank.*} FROM (SELECT DISTINCT d2Biobank.biobankId FROM bbmrieric.d2biobank d2Biobank WHERE ";
	private static final String _FILTER_SQL_SELECT_D2BIOBANK_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN bbmrieric.d2biobank ON TEMP_TABLE.biobankId = bbmrieric.d2biobank.biobankId";
	private static final String _FILTER_SQL_COUNT_D2BIOBANK_WHERE = "SELECT COUNT(DISTINCT d2Biobank.biobankId) AS COUNT_VALUE FROM bbmrieric.d2biobank d2Biobank WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "d2Biobank";
	private static final String _FILTER_ENTITY_TABLE = "bbmrieric.d2biobank";
	private static final String _ORDER_BY_ENTITY_ALIAS = "d2Biobank.";
	private static final String _ORDER_BY_ENTITY_TABLE = "bbmrieric.d2biobank.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No D2Biobank exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No D2Biobank exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(D2BiobankPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static D2Biobank _nullD2Biobank = new D2BiobankImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<D2Biobank> toCacheModel() {
				return _nullD2BiobankCacheModel;
			}
		};

	private static CacheModel<D2Biobank> _nullD2BiobankCacheModel = new CacheModel<D2Biobank>() {
			@Override
			public D2Biobank toEntityModel() {
				return _nullD2Biobank;
			}
		};
}