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

package at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException;
import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent;
import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventImpl;
import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl;

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
import com.liferay.portal.kernel.util.CalendarUtil;
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
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the r d connect event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see RDConnectEventPersistence
 * @see RDConnectEventUtil
 * @generated
 */
public class RDConnectEventPersistenceImpl extends BasePersistenceImpl<RDConnectEvent>
	implements RDConnectEventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RDConnectEventUtil} to access the r d connect event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RDConnectEventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventModelImpl.FINDER_CACHE_ENABLED,
			RDConnectEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventModelImpl.FINDER_CACHE_ENABLED,
			RDConnectEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESTRICTED =
		new FinderPath(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventModelImpl.FINDER_CACHE_ENABLED,
			RDConnectEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRestricted",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESTRICTED =
		new FinderPath(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventModelImpl.FINDER_CACHE_ENABLED,
			RDConnectEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRestricted",
			new String[] { String.class.getName() },
			RDConnectEventModelImpl.RESTRICTED_COLUMN_BITMASK |
			RDConnectEventModelImpl.EVENTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESTRICTED = new FinderPath(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRestricted",
			new String[] { String.class.getName() });

	/**
	 * Returns all the r d connect events where restricted = &#63;.
	 *
	 * @param restricted the restricted
	 * @return the matching r d connect events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEvent> findByRestricted(String restricted)
		throws SystemException {
		return findByRestricted(restricted, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the r d connect events where restricted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param restricted the restricted
	 * @param start the lower bound of the range of r d connect events
	 * @param end the upper bound of the range of r d connect events (not inclusive)
	 * @return the range of matching r d connect events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEvent> findByRestricted(String restricted, int start,
		int end) throws SystemException {
		return findByRestricted(restricted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d connect events where restricted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param restricted the restricted
	 * @param start the lower bound of the range of r d connect events
	 * @param end the upper bound of the range of r d connect events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching r d connect events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEvent> findByRestricted(String restricted, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESTRICTED;
			finderArgs = new Object[] { restricted };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESTRICTED;
			finderArgs = new Object[] { restricted, start, end, orderByComparator };
		}

		List<RDConnectEvent> list = (List<RDConnectEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RDConnectEvent rdConnectEvent : list) {
				if (!Validator.equals(restricted, rdConnectEvent.getRestricted())) {
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

			query.append(_SQL_SELECT_RDCONNECTEVENT_WHERE);

			boolean bindRestricted = false;

			if (restricted == null) {
				query.append(_FINDER_COLUMN_RESTRICTED_RESTRICTED_1);
			}
			else if (restricted.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RESTRICTED_RESTRICTED_3);
			}
			else {
				bindRestricted = true;

				query.append(_FINDER_COLUMN_RESTRICTED_RESTRICTED_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RDConnectEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRestricted) {
					qPos.add(restricted);
				}

				if (!pagination) {
					list = (List<RDConnectEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDConnectEvent>(list);
				}
				else {
					list = (List<RDConnectEvent>)QueryUtil.list(q,
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
	 * Returns the first r d connect event in the ordered set where restricted = &#63;.
	 *
	 * @param restricted the restricted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d connect event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a matching r d connect event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent findByRestricted_First(String restricted,
		OrderByComparator orderByComparator)
		throws NoSuchRDConnectEventException, SystemException {
		RDConnectEvent rdConnectEvent = fetchByRestricted_First(restricted,
				orderByComparator);

		if (rdConnectEvent != null) {
			return rdConnectEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("restricted=");
		msg.append(restricted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDConnectEventException(msg.toString());
	}

	/**
	 * Returns the first r d connect event in the ordered set where restricted = &#63;.
	 *
	 * @param restricted the restricted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d connect event, or <code>null</code> if a matching r d connect event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent fetchByRestricted_First(String restricted,
		OrderByComparator orderByComparator) throws SystemException {
		List<RDConnectEvent> list = findByRestricted(restricted, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last r d connect event in the ordered set where restricted = &#63;.
	 *
	 * @param restricted the restricted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d connect event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a matching r d connect event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent findByRestricted_Last(String restricted,
		OrderByComparator orderByComparator)
		throws NoSuchRDConnectEventException, SystemException {
		RDConnectEvent rdConnectEvent = fetchByRestricted_Last(restricted,
				orderByComparator);

		if (rdConnectEvent != null) {
			return rdConnectEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("restricted=");
		msg.append(restricted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDConnectEventException(msg.toString());
	}

	/**
	 * Returns the last r d connect event in the ordered set where restricted = &#63;.
	 *
	 * @param restricted the restricted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d connect event, or <code>null</code> if a matching r d connect event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent fetchByRestricted_Last(String restricted,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRestricted(restricted);

		if (count == 0) {
			return null;
		}

		List<RDConnectEvent> list = findByRestricted(restricted, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the r d connect events before and after the current r d connect event in the ordered set where restricted = &#63;.
	 *
	 * @param eventId the primary key of the current r d connect event
	 * @param restricted the restricted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next r d connect event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a r d connect event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent[] findByRestricted_PrevAndNext(long eventId,
		String restricted, OrderByComparator orderByComparator)
		throws NoSuchRDConnectEventException, SystemException {
		RDConnectEvent rdConnectEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			RDConnectEvent[] array = new RDConnectEventImpl[3];

			array[0] = getByRestricted_PrevAndNext(session, rdConnectEvent,
					restricted, orderByComparator, true);

			array[1] = rdConnectEvent;

			array[2] = getByRestricted_PrevAndNext(session, rdConnectEvent,
					restricted, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RDConnectEvent getByRestricted_PrevAndNext(Session session,
		RDConnectEvent rdConnectEvent, String restricted,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RDCONNECTEVENT_WHERE);

		boolean bindRestricted = false;

		if (restricted == null) {
			query.append(_FINDER_COLUMN_RESTRICTED_RESTRICTED_1);
		}
		else if (restricted.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RESTRICTED_RESTRICTED_3);
		}
		else {
			bindRestricted = true;

			query.append(_FINDER_COLUMN_RESTRICTED_RESTRICTED_2);
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
			query.append(RDConnectEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRestricted) {
			qPos.add(restricted);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rdConnectEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RDConnectEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the r d connect events where restricted = &#63; from the database.
	 *
	 * @param restricted the restricted
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRestricted(String restricted) throws SystemException {
		for (RDConnectEvent rdConnectEvent : findByRestricted(restricted,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rdConnectEvent);
		}
	}

	/**
	 * Returns the number of r d connect events where restricted = &#63;.
	 *
	 * @param restricted the restricted
	 * @return the number of matching r d connect events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRestricted(String restricted) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESTRICTED;

		Object[] finderArgs = new Object[] { restricted };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RDCONNECTEVENT_WHERE);

			boolean bindRestricted = false;

			if (restricted == null) {
				query.append(_FINDER_COLUMN_RESTRICTED_RESTRICTED_1);
			}
			else if (restricted.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RESTRICTED_RESTRICTED_3);
			}
			else {
				bindRestricted = true;

				query.append(_FINDER_COLUMN_RESTRICTED_RESTRICTED_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRestricted) {
					qPos.add(restricted);
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

	private static final String _FINDER_COLUMN_RESTRICTED_RESTRICTED_1 = "rdConnectEvent.restricted IS NULL";
	private static final String _FINDER_COLUMN_RESTRICTED_RESTRICTED_2 = "rdConnectEvent.restricted = ?";
	private static final String _FINDER_COLUMN_RESTRICTED_RESTRICTED_3 = "(rdConnectEvent.restricted IS NULL OR rdConnectEvent.restricted = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTDATE =
		new FinderPath(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventModelImpl.FINDER_CACHE_ENABLED,
			RDConnectEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEventdate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDATE =
		new FinderPath(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventModelImpl.FINDER_CACHE_ENABLED,
			RDConnectEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventdate",
			new String[] { Date.class.getName() },
			RDConnectEventModelImpl.EVENTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTDATE = new FinderPath(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventdate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the r d connect events where eventdate = &#63;.
	 *
	 * @param eventdate the eventdate
	 * @return the matching r d connect events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEvent> findByEventdate(Date eventdate)
		throws SystemException {
		return findByEventdate(eventdate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the r d connect events where eventdate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventdate the eventdate
	 * @param start the lower bound of the range of r d connect events
	 * @param end the upper bound of the range of r d connect events (not inclusive)
	 * @return the range of matching r d connect events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEvent> findByEventdate(Date eventdate, int start,
		int end) throws SystemException {
		return findByEventdate(eventdate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d connect events where eventdate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventdate the eventdate
	 * @param start the lower bound of the range of r d connect events
	 * @param end the upper bound of the range of r d connect events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching r d connect events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEvent> findByEventdate(Date eventdate, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDATE;
			finderArgs = new Object[] { eventdate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTDATE;
			finderArgs = new Object[] { eventdate, start, end, orderByComparator };
		}

		List<RDConnectEvent> list = (List<RDConnectEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RDConnectEvent rdConnectEvent : list) {
				if (!Validator.equals(eventdate, rdConnectEvent.getEventdate())) {
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

			query.append(_SQL_SELECT_RDCONNECTEVENT_WHERE);

			boolean bindEventdate = false;

			if (eventdate == null) {
				query.append(_FINDER_COLUMN_EVENTDATE_EVENTDATE_1);
			}
			else {
				bindEventdate = true;

				query.append(_FINDER_COLUMN_EVENTDATE_EVENTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RDConnectEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventdate) {
					qPos.add(CalendarUtil.getTimestamp(eventdate));
				}

				if (!pagination) {
					list = (List<RDConnectEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDConnectEvent>(list);
				}
				else {
					list = (List<RDConnectEvent>)QueryUtil.list(q,
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
	 * Returns the first r d connect event in the ordered set where eventdate = &#63;.
	 *
	 * @param eventdate the eventdate
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d connect event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a matching r d connect event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent findByEventdate_First(Date eventdate,
		OrderByComparator orderByComparator)
		throws NoSuchRDConnectEventException, SystemException {
		RDConnectEvent rdConnectEvent = fetchByEventdate_First(eventdate,
				orderByComparator);

		if (rdConnectEvent != null) {
			return rdConnectEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventdate=");
		msg.append(eventdate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDConnectEventException(msg.toString());
	}

	/**
	 * Returns the first r d connect event in the ordered set where eventdate = &#63;.
	 *
	 * @param eventdate the eventdate
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d connect event, or <code>null</code> if a matching r d connect event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent fetchByEventdate_First(Date eventdate,
		OrderByComparator orderByComparator) throws SystemException {
		List<RDConnectEvent> list = findByEventdate(eventdate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last r d connect event in the ordered set where eventdate = &#63;.
	 *
	 * @param eventdate the eventdate
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d connect event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a matching r d connect event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent findByEventdate_Last(Date eventdate,
		OrderByComparator orderByComparator)
		throws NoSuchRDConnectEventException, SystemException {
		RDConnectEvent rdConnectEvent = fetchByEventdate_Last(eventdate,
				orderByComparator);

		if (rdConnectEvent != null) {
			return rdConnectEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventdate=");
		msg.append(eventdate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDConnectEventException(msg.toString());
	}

	/**
	 * Returns the last r d connect event in the ordered set where eventdate = &#63;.
	 *
	 * @param eventdate the eventdate
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d connect event, or <code>null</code> if a matching r d connect event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent fetchByEventdate_Last(Date eventdate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventdate(eventdate);

		if (count == 0) {
			return null;
		}

		List<RDConnectEvent> list = findByEventdate(eventdate, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the r d connect events before and after the current r d connect event in the ordered set where eventdate = &#63;.
	 *
	 * @param eventId the primary key of the current r d connect event
	 * @param eventdate the eventdate
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next r d connect event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a r d connect event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent[] findByEventdate_PrevAndNext(long eventId,
		Date eventdate, OrderByComparator orderByComparator)
		throws NoSuchRDConnectEventException, SystemException {
		RDConnectEvent rdConnectEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			RDConnectEvent[] array = new RDConnectEventImpl[3];

			array[0] = getByEventdate_PrevAndNext(session, rdConnectEvent,
					eventdate, orderByComparator, true);

			array[1] = rdConnectEvent;

			array[2] = getByEventdate_PrevAndNext(session, rdConnectEvent,
					eventdate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RDConnectEvent getByEventdate_PrevAndNext(Session session,
		RDConnectEvent rdConnectEvent, Date eventdate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RDCONNECTEVENT_WHERE);

		boolean bindEventdate = false;

		if (eventdate == null) {
			query.append(_FINDER_COLUMN_EVENTDATE_EVENTDATE_1);
		}
		else {
			bindEventdate = true;

			query.append(_FINDER_COLUMN_EVENTDATE_EVENTDATE_2);
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
			query.append(RDConnectEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEventdate) {
			qPos.add(CalendarUtil.getTimestamp(eventdate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rdConnectEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RDConnectEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the r d connect events where eventdate = &#63; from the database.
	 *
	 * @param eventdate the eventdate
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventdate(Date eventdate) throws SystemException {
		for (RDConnectEvent rdConnectEvent : findByEventdate(eventdate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rdConnectEvent);
		}
	}

	/**
	 * Returns the number of r d connect events where eventdate = &#63;.
	 *
	 * @param eventdate the eventdate
	 * @return the number of matching r d connect events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventdate(Date eventdate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTDATE;

		Object[] finderArgs = new Object[] { eventdate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RDCONNECTEVENT_WHERE);

			boolean bindEventdate = false;

			if (eventdate == null) {
				query.append(_FINDER_COLUMN_EVENTDATE_EVENTDATE_1);
			}
			else {
				bindEventdate = true;

				query.append(_FINDER_COLUMN_EVENTDATE_EVENTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventdate) {
					qPos.add(CalendarUtil.getTimestamp(eventdate));
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

	private static final String _FINDER_COLUMN_EVENTDATE_EVENTDATE_1 = "rdConnectEvent.eventdate IS NULL";
	private static final String _FINDER_COLUMN_EVENTDATE_EVENTDATE_2 = "rdConnectEvent.eventdate = ?";

	public RDConnectEventPersistenceImpl() {
		setModelClass(RDConnectEvent.class);
	}

	/**
	 * Caches the r d connect event in the entity cache if it is enabled.
	 *
	 * @param rdConnectEvent the r d connect event
	 */
	@Override
	public void cacheResult(RDConnectEvent rdConnectEvent) {
		EntityCacheUtil.putResult(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventImpl.class, rdConnectEvent.getPrimaryKey(),
			rdConnectEvent);

		rdConnectEvent.resetOriginalValues();
	}

	/**
	 * Caches the r d connect events in the entity cache if it is enabled.
	 *
	 * @param rdConnectEvents the r d connect events
	 */
	@Override
	public void cacheResult(List<RDConnectEvent> rdConnectEvents) {
		for (RDConnectEvent rdConnectEvent : rdConnectEvents) {
			if (EntityCacheUtil.getResult(
						RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
						RDConnectEventImpl.class, rdConnectEvent.getPrimaryKey()) == null) {
				cacheResult(rdConnectEvent);
			}
			else {
				rdConnectEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all r d connect events.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RDConnectEventImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RDConnectEventImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the r d connect event.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RDConnectEvent rdConnectEvent) {
		EntityCacheUtil.removeResult(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventImpl.class, rdConnectEvent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RDConnectEvent> rdConnectEvents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RDConnectEvent rdConnectEvent : rdConnectEvents) {
			EntityCacheUtil.removeResult(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
				RDConnectEventImpl.class, rdConnectEvent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new r d connect event with the primary key. Does not add the r d connect event to the database.
	 *
	 * @param eventId the primary key for the new r d connect event
	 * @return the new r d connect event
	 */
	@Override
	public RDConnectEvent create(long eventId) {
		RDConnectEvent rdConnectEvent = new RDConnectEventImpl();

		rdConnectEvent.setNew(true);
		rdConnectEvent.setPrimaryKey(eventId);

		return rdConnectEvent;
	}

	/**
	 * Removes the r d connect event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the r d connect event
	 * @return the r d connect event that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a r d connect event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent remove(long eventId)
		throws NoSuchRDConnectEventException, SystemException {
		return remove((Serializable)eventId);
	}

	/**
	 * Removes the r d connect event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the r d connect event
	 * @return the r d connect event that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a r d connect event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent remove(Serializable primaryKey)
		throws NoSuchRDConnectEventException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RDConnectEvent rdConnectEvent = (RDConnectEvent)session.get(RDConnectEventImpl.class,
					primaryKey);

			if (rdConnectEvent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRDConnectEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rdConnectEvent);
		}
		catch (NoSuchRDConnectEventException nsee) {
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
	protected RDConnectEvent removeImpl(RDConnectEvent rdConnectEvent)
		throws SystemException {
		rdConnectEvent = toUnwrappedModel(rdConnectEvent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rdConnectEvent)) {
				rdConnectEvent = (RDConnectEvent)session.get(RDConnectEventImpl.class,
						rdConnectEvent.getPrimaryKeyObj());
			}

			if (rdConnectEvent != null) {
				session.delete(rdConnectEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rdConnectEvent != null) {
			clearCache(rdConnectEvent);
		}

		return rdConnectEvent;
	}

	@Override
	public RDConnectEvent updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent rdConnectEvent)
		throws SystemException {
		rdConnectEvent = toUnwrappedModel(rdConnectEvent);

		boolean isNew = rdConnectEvent.isNew();

		RDConnectEventModelImpl rdConnectEventModelImpl = (RDConnectEventModelImpl)rdConnectEvent;

		Session session = null;

		try {
			session = openSession();

			if (rdConnectEvent.isNew()) {
				session.save(rdConnectEvent);

				rdConnectEvent.setNew(false);
			}
			else {
				session.merge(rdConnectEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RDConnectEventModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rdConnectEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESTRICTED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rdConnectEventModelImpl.getOriginalRestricted()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESTRICTED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESTRICTED,
					args);

				args = new Object[] { rdConnectEventModelImpl.getRestricted() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESTRICTED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESTRICTED,
					args);
			}

			if ((rdConnectEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rdConnectEventModelImpl.getOriginalEventdate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDATE,
					args);

				args = new Object[] { rdConnectEventModelImpl.getEventdate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventImpl.class, rdConnectEvent.getPrimaryKey(),
			rdConnectEvent);

		return rdConnectEvent;
	}

	protected RDConnectEvent toUnwrappedModel(RDConnectEvent rdConnectEvent) {
		if (rdConnectEvent instanceof RDConnectEventImpl) {
			return rdConnectEvent;
		}

		RDConnectEventImpl rdConnectEventImpl = new RDConnectEventImpl();

		rdConnectEventImpl.setNew(rdConnectEvent.isNew());
		rdConnectEventImpl.setPrimaryKey(rdConnectEvent.getPrimaryKey());

		rdConnectEventImpl.setEventId(rdConnectEvent.getEventId());
		rdConnectEventImpl.setEventdate(rdConnectEvent.getEventdate());
		rdConnectEventImpl.setOrganizationId(rdConnectEvent.getOrganizationId());
		rdConnectEventImpl.setUserId(rdConnectEvent.getUserId());
		rdConnectEventImpl.setShorttext(rdConnectEvent.getShorttext());
		rdConnectEventImpl.setLongtext(rdConnectEvent.getLongtext());
		rdConnectEventImpl.setLink(rdConnectEvent.getLink());
		rdConnectEventImpl.setRestricted(rdConnectEvent.getRestricted());

		return rdConnectEventImpl;
	}

	/**
	 * Returns the r d connect event with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the r d connect event
	 * @return the r d connect event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a r d connect event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRDConnectEventException, SystemException {
		RDConnectEvent rdConnectEvent = fetchByPrimaryKey(primaryKey);

		if (rdConnectEvent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRDConnectEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rdConnectEvent;
	}

	/**
	 * Returns the r d connect event with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException} if it could not be found.
	 *
	 * @param eventId the primary key of the r d connect event
	 * @return the r d connect event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a r d connect event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent findByPrimaryKey(long eventId)
		throws NoSuchRDConnectEventException, SystemException {
		return findByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns the r d connect event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the r d connect event
	 * @return the r d connect event, or <code>null</code> if a r d connect event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RDConnectEvent rdConnectEvent = (RDConnectEvent)EntityCacheUtil.getResult(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
				RDConnectEventImpl.class, primaryKey);

		if (rdConnectEvent == _nullRDConnectEvent) {
			return null;
		}

		if (rdConnectEvent == null) {
			Session session = null;

			try {
				session = openSession();

				rdConnectEvent = (RDConnectEvent)session.get(RDConnectEventImpl.class,
						primaryKey);

				if (rdConnectEvent != null) {
					cacheResult(rdConnectEvent);
				}
				else {
					EntityCacheUtil.putResult(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
						RDConnectEventImpl.class, primaryKey,
						_nullRDConnectEvent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RDConnectEventModelImpl.ENTITY_CACHE_ENABLED,
					RDConnectEventImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rdConnectEvent;
	}

	/**
	 * Returns the r d connect event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the r d connect event
	 * @return the r d connect event, or <code>null</code> if a r d connect event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEvent fetchByPrimaryKey(long eventId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns all the r d connect events.
	 *
	 * @return the r d connect events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEvent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the r d connect events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of r d connect events
	 * @param end the upper bound of the range of r d connect events (not inclusive)
	 * @return the range of r d connect events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEvent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d connect events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of r d connect events
	 * @param end the upper bound of the range of r d connect events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of r d connect events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEvent> findAll(int start, int end,
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

		List<RDConnectEvent> list = (List<RDConnectEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RDCONNECTEVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RDCONNECTEVENT;

				if (pagination) {
					sql = sql.concat(RDConnectEventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RDConnectEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDConnectEvent>(list);
				}
				else {
					list = (List<RDConnectEvent>)QueryUtil.list(q,
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
	 * Removes all the r d connect events from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RDConnectEvent rdConnectEvent : findAll()) {
			remove(rdConnectEvent);
		}
	}

	/**
	 * Returns the number of r d connect events.
	 *
	 * @return the number of r d connect events
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

				Query q = session.createQuery(_SQL_COUNT_RDCONNECTEVENT);

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
	 * Initializes the r d connect event persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RDConnectEvent>> listenersList = new ArrayList<ModelListener<RDConnectEvent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RDConnectEvent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RDConnectEventImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RDCONNECTEVENT = "SELECT rdConnectEvent FROM RDConnectEvent rdConnectEvent";
	private static final String _SQL_SELECT_RDCONNECTEVENT_WHERE = "SELECT rdConnectEvent FROM RDConnectEvent rdConnectEvent WHERE ";
	private static final String _SQL_COUNT_RDCONNECTEVENT = "SELECT COUNT(rdConnectEvent) FROM RDConnectEvent rdConnectEvent";
	private static final String _SQL_COUNT_RDCONNECTEVENT_WHERE = "SELECT COUNT(rdConnectEvent) FROM RDConnectEvent rdConnectEvent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rdConnectEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RDConnectEvent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RDConnectEvent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RDConnectEventPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"longtext"
			});
	private static RDConnectEvent _nullRDConnectEvent = new RDConnectEventImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RDConnectEvent> toCacheModel() {
				return _nullRDConnectEventCacheModel;
			}
		};

	private static CacheModel<RDConnectEvent> _nullRDConnectEventCacheModel = new CacheModel<RDConnectEvent>() {
			@Override
			public RDConnectEvent toEntityModel() {
				return _nullRDConnectEvent;
			}
		};
}