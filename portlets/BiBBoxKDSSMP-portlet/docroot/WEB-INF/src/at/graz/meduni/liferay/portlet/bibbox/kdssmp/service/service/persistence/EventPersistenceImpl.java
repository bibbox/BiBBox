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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventException;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventModelImpl;

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
 * The persistence implementation for the event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see EventPersistence
 * @see EventUtil
 * @generated
 */
public class EventPersistenceImpl extends BasePersistenceImpl<Event>
	implements EventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventUtil} to access the event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
			EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
			EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
			EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PATIENT = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
			EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPatient",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATIENT =
		new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
			EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPatient",
			new String[] { Long.class.getName() },
			EventModelImpl.PATIENTID_COLUMN_BITMASK |
			EventModelImpl.EVENTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PATIENT = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
			EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPatient",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the events where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Event> findByPatient(long patientId) throws SystemException {
		return findByPatient(patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the events where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @return the range of matching events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Event> findByPatient(long patientId, int start, int end)
		throws SystemException {
		return findByPatient(patientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the events where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Event> findByPatient(long patientId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATIENT;
			finderArgs = new Object[] { patientId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PATIENT;
			finderArgs = new Object[] { patientId, start, end, orderByComparator };
		}

		List<Event> list = (List<Event>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Event event : list) {
				if ((patientId != event.getPatientId())) {
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

			query.append(_SQL_SELECT_EVENT_WHERE);

			query.append(_FINDER_COLUMN_PATIENT_PATIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(patientId);

				if (!pagination) {
					list = (List<Event>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Event>(list);
				}
				else {
					list = (List<Event>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first event in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventException if a matching event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event findByPatient_First(long patientId,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		Event event = fetchByPatient_First(patientId, orderByComparator);

		if (event != null) {
			return event;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("patientId=");
		msg.append(patientId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the first event in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event, or <code>null</code> if a matching event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event fetchByPatient_First(long patientId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Event> list = findByPatient(patientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventException if a matching event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event findByPatient_Last(long patientId,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		Event event = fetchByPatient_Last(patientId, orderByComparator);

		if (event != null) {
			return event;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("patientId=");
		msg.append(patientId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the last event in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event, or <code>null</code> if a matching event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event fetchByPatient_Last(long patientId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPatient(patientId);

		if (count == 0) {
			return null;
		}

		List<Event> list = findByPatient(patientId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the events before and after the current event in the ordered set where patientId = &#63;.
	 *
	 * @param eventId the primary key of the current event
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventException if a event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event[] findByPatient_PrevAndNext(long eventId, long patientId,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		Event event = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			Event[] array = new EventImpl[3];

			array[0] = getByPatient_PrevAndNext(session, event, patientId,
					orderByComparator, true);

			array[1] = event;

			array[2] = getByPatient_PrevAndNext(session, event, patientId,
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

	protected Event getByPatient_PrevAndNext(Session session, Event event,
		long patientId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENT_WHERE);

		query.append(_FINDER_COLUMN_PATIENT_PATIENTID_2);

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
			query.append(EventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(patientId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(event);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Event> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the events where patientId = &#63; from the database.
	 *
	 * @param patientId the patient ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPatient(long patientId) throws SystemException {
		for (Event event : findByPatient(patientId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(event);
		}
	}

	/**
	 * Returns the number of events where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPatient(long patientId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PATIENT;

		Object[] finderArgs = new Object[] { patientId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENT_WHERE);

			query.append(_FINDER_COLUMN_PATIENT_PATIENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(patientId);

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

	private static final String _FINDER_COLUMN_PATIENT_PATIENTID_2 = "event.patientId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_LAYOUTID = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
			EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLayoutId",
			new String[] { Long.class.getName() },
			EventModelImpl.LAYOUTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LAYOUTID = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
			EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLayoutId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the event where layoutId = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventException} if it could not be found.
	 *
	 * @param layoutId the layout ID
	 * @return the matching event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventException if a matching event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event findByLayoutId(long layoutId)
		throws NoSuchEventException, SystemException {
		Event event = fetchByLayoutId(layoutId);

		if (event == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("layoutId=");
			msg.append(layoutId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEventException(msg.toString());
		}

		return event;
	}

	/**
	 * Returns the event where layoutId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param layoutId the layout ID
	 * @return the matching event, or <code>null</code> if a matching event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event fetchByLayoutId(long layoutId) throws SystemException {
		return fetchByLayoutId(layoutId, true);
	}

	/**
	 * Returns the event where layoutId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param layoutId the layout ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching event, or <code>null</code> if a matching event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event fetchByLayoutId(long layoutId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { layoutId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LAYOUTID,
					finderArgs, this);
		}

		if (result instanceof Event) {
			Event event = (Event)result;

			if ((layoutId != event.getLayoutId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EVENT_WHERE);

			query.append(_FINDER_COLUMN_LAYOUTID_LAYOUTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(layoutId);

				List<Event> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LAYOUTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EventPersistenceImpl.fetchByLayoutId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Event event = list.get(0);

					result = event;

					cacheResult(event);

					if ((event.getLayoutId() != layoutId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LAYOUTID,
							finderArgs, event);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LAYOUTID,
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
			return (Event)result;
		}
	}

	/**
	 * Removes the event where layoutId = &#63; from the database.
	 *
	 * @param layoutId the layout ID
	 * @return the event that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event removeByLayoutId(long layoutId)
		throws NoSuchEventException, SystemException {
		Event event = findByLayoutId(layoutId);

		return remove(event);
	}

	/**
	 * Returns the number of events where layoutId = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @return the number of matching events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLayoutId(long layoutId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LAYOUTID;

		Object[] finderArgs = new Object[] { layoutId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENT_WHERE);

			query.append(_FINDER_COLUMN_LAYOUTID_LAYOUTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(layoutId);

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

	private static final String _FINDER_COLUMN_LAYOUTID_LAYOUTID_2 = "event.layoutId = ?";

	public EventPersistenceImpl() {
		setModelClass(Event.class);
	}

	/**
	 * Caches the event in the entity cache if it is enabled.
	 *
	 * @param event the event
	 */
	@Override
	public void cacheResult(Event event) {
		EntityCacheUtil.putResult(EventModelImpl.ENTITY_CACHE_ENABLED,
			EventImpl.class, event.getPrimaryKey(), event);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LAYOUTID,
			new Object[] { event.getLayoutId() }, event);

		event.resetOriginalValues();
	}

	/**
	 * Caches the events in the entity cache if it is enabled.
	 *
	 * @param events the events
	 */
	@Override
	public void cacheResult(List<Event> events) {
		for (Event event : events) {
			if (EntityCacheUtil.getResult(EventModelImpl.ENTITY_CACHE_ENABLED,
						EventImpl.class, event.getPrimaryKey()) == null) {
				cacheResult(event);
			}
			else {
				event.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all events.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Event event) {
		EntityCacheUtil.removeResult(EventModelImpl.ENTITY_CACHE_ENABLED,
			EventImpl.class, event.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(event);
	}

	@Override
	public void clearCache(List<Event> events) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Event event : events) {
			EntityCacheUtil.removeResult(EventModelImpl.ENTITY_CACHE_ENABLED,
				EventImpl.class, event.getPrimaryKey());

			clearUniqueFindersCache(event);
		}
	}

	protected void cacheUniqueFindersCache(Event event) {
		if (event.isNew()) {
			Object[] args = new Object[] { event.getLayoutId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LAYOUTID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LAYOUTID, args, event);
		}
		else {
			EventModelImpl eventModelImpl = (EventModelImpl)event;

			if ((eventModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LAYOUTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { event.getLayoutId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LAYOUTID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LAYOUTID, args,
					event);
			}
		}
	}

	protected void clearUniqueFindersCache(Event event) {
		EventModelImpl eventModelImpl = (EventModelImpl)event;

		Object[] args = new Object[] { event.getLayoutId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LAYOUTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LAYOUTID, args);

		if ((eventModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LAYOUTID.getColumnBitmask()) != 0) {
			args = new Object[] { eventModelImpl.getOriginalLayoutId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LAYOUTID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LAYOUTID, args);
		}
	}

	/**
	 * Creates a new event with the primary key. Does not add the event to the database.
	 *
	 * @param eventId the primary key for the new event
	 * @return the new event
	 */
	@Override
	public Event create(long eventId) {
		Event event = new EventImpl();

		event.setNew(true);
		event.setPrimaryKey(eventId);

		return event;
	}

	/**
	 * Removes the event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the event
	 * @return the event that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventException if a event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event remove(long eventId)
		throws NoSuchEventException, SystemException {
		return remove((Serializable)eventId);
	}

	/**
	 * Removes the event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event
	 * @return the event that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventException if a event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event remove(Serializable primaryKey)
		throws NoSuchEventException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Event event = (Event)session.get(EventImpl.class, primaryKey);

			if (event == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(event);
		}
		catch (NoSuchEventException nsee) {
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
	protected Event removeImpl(Event event) throws SystemException {
		event = toUnwrappedModel(event);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(event)) {
				event = (Event)session.get(EventImpl.class,
						event.getPrimaryKeyObj());
			}

			if (event != null) {
				session.delete(event);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (event != null) {
			clearCache(event);
		}

		return event;
	}

	@Override
	public Event updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event event)
		throws SystemException {
		event = toUnwrappedModel(event);

		boolean isNew = event.isNew();

		EventModelImpl eventModelImpl = (EventModelImpl)event;

		Session session = null;

		try {
			session = openSession();

			if (event.isNew()) {
				session.save(event);

				event.setNew(false);
			}
			else {
				session.merge(event);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATIENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventModelImpl.getOriginalPatientId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PATIENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATIENT,
					args);

				args = new Object[] { eventModelImpl.getPatientId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PATIENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATIENT,
					args);
			}
		}

		EntityCacheUtil.putResult(EventModelImpl.ENTITY_CACHE_ENABLED,
			EventImpl.class, event.getPrimaryKey(), event);

		clearUniqueFindersCache(event);
		cacheUniqueFindersCache(event);

		return event;
	}

	protected Event toUnwrappedModel(Event event) {
		if (event instanceof EventImpl) {
			return event;
		}

		EventImpl eventImpl = new EventImpl();

		eventImpl.setNew(event.isNew());
		eventImpl.setPrimaryKey(event.getPrimaryKey());

		eventImpl.setEventId(event.getEventId());
		eventImpl.setPatientId(event.getPatientId());
		eventImpl.setLayoutId(event.getLayoutId());
		eventImpl.setEventdate(event.getEventdate());
		eventImpl.setEventtype(event.getEventtype());
		eventImpl.setStatus(event.getStatus());

		return eventImpl;
	}

	/**
	 * Returns the event with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the event
	 * @return the event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventException if a event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventException, SystemException {
		Event event = fetchByPrimaryKey(primaryKey);

		if (event == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return event;
	}

	/**
	 * Returns the event with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventException} if it could not be found.
	 *
	 * @param eventId the primary key of the event
	 * @return the event
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventException if a event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event findByPrimaryKey(long eventId)
		throws NoSuchEventException, SystemException {
		return findByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns the event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event
	 * @return the event, or <code>null</code> if a event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Event event = (Event)EntityCacheUtil.getResult(EventModelImpl.ENTITY_CACHE_ENABLED,
				EventImpl.class, primaryKey);

		if (event == _nullEvent) {
			return null;
		}

		if (event == null) {
			Session session = null;

			try {
				session = openSession();

				event = (Event)session.get(EventImpl.class, primaryKey);

				if (event != null) {
					cacheResult(event);
				}
				else {
					EntityCacheUtil.putResult(EventModelImpl.ENTITY_CACHE_ENABLED,
						EventImpl.class, primaryKey, _nullEvent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EventModelImpl.ENTITY_CACHE_ENABLED,
					EventImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return event;
	}

	/**
	 * Returns the event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the event
	 * @return the event, or <code>null</code> if a event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Event fetchByPrimaryKey(long eventId) throws SystemException {
		return fetchByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns all the events.
	 *
	 * @return the events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Event> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @return the range of events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Event> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Event> findAll(int start, int end,
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

		List<Event> list = (List<Event>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENT;

				if (pagination) {
					sql = sql.concat(EventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Event>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Event>(list);
				}
				else {
					list = (List<Event>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the events from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Event event : findAll()) {
			remove(event);
		}
	}

	/**
	 * Returns the number of events.
	 *
	 * @return the number of events
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

				Query q = session.createQuery(_SQL_COUNT_EVENT);

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
	 * Initializes the event persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Event>> listenersList = new ArrayList<ModelListener<Event>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Event>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EventImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVENT = "SELECT event FROM Event event";
	private static final String _SQL_SELECT_EVENT_WHERE = "SELECT event FROM Event event WHERE ";
	private static final String _SQL_COUNT_EVENT = "SELECT COUNT(event) FROM Event event";
	private static final String _SQL_COUNT_EVENT_WHERE = "SELECT COUNT(event) FROM Event event WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "event.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Event exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Event exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventPersistenceImpl.class);
	private static Event _nullEvent = new EventImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Event> toCacheModel() {
				return _nullEventCacheModel;
			}
		};

	private static CacheModel<Event> _nullEventCacheModel = new CacheModel<Event>() {
			@Override
			public Event toEntityModel() {
				return _nullEvent;
			}
		};
}