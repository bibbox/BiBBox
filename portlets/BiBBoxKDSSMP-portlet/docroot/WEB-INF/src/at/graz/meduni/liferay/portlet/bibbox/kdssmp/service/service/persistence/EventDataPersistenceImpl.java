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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl;

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
 * The persistence implementation for the event data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see EventDataPersistence
 * @see EventDataUtil
 * @generated
 */
public class EventDataPersistenceImpl extends BasePersistenceImpl<EventData>
	implements EventDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventDataUtil} to access the event data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventDataModelImpl.ENTITY_CACHE_ENABLED,
			EventDataModelImpl.FINDER_CACHE_ENABLED, EventDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventDataModelImpl.ENTITY_CACHE_ENABLED,
			EventDataModelImpl.FINDER_CACHE_ENABLED, EventDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventDataModelImpl.ENTITY_CACHE_ENABLED,
			EventDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTLAYOUT =
		new FinderPath(EventDataModelImpl.ENTITY_CACHE_ENABLED,
			EventDataModelImpl.FINDER_CACHE_ENABLED, EventDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventLayout",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTLAYOUT =
		new FinderPath(EventDataModelImpl.ENTITY_CACHE_ENABLED,
			EventDataModelImpl.FINDER_CACHE_ENABLED, EventDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventLayout",
			new String[] { Long.class.getName() },
			EventDataModelImpl.EVENTLAYOUTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTLAYOUT = new FinderPath(EventDataModelImpl.ENTITY_CACHE_ENABLED,
			EventDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventLayout",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the event datas where eventlayoutId = &#63;.
	 *
	 * @param eventlayoutId the eventlayout ID
	 * @return the matching event datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventData> findByEventLayout(long eventlayoutId)
		throws SystemException {
		return findByEventLayout(eventlayoutId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event datas where eventlayoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventlayoutId the eventlayout ID
	 * @param start the lower bound of the range of event datas
	 * @param end the upper bound of the range of event datas (not inclusive)
	 * @return the range of matching event datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventData> findByEventLayout(long eventlayoutId, int start,
		int end) throws SystemException {
		return findByEventLayout(eventlayoutId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event datas where eventlayoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventlayoutId the eventlayout ID
	 * @param start the lower bound of the range of event datas
	 * @param end the upper bound of the range of event datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventData> findByEventLayout(long eventlayoutId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTLAYOUT;
			finderArgs = new Object[] { eventlayoutId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTLAYOUT;
			finderArgs = new Object[] {
					eventlayoutId,
					
					start, end, orderByComparator
				};
		}

		List<EventData> list = (List<EventData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventData eventData : list) {
				if ((eventlayoutId != eventData.getEventlayoutId())) {
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

			query.append(_SQL_SELECT_EVENTDATA_WHERE);

			query.append(_FINDER_COLUMN_EVENTLAYOUT_EVENTLAYOUTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventlayoutId);

				if (!pagination) {
					list = (List<EventData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventData>(list);
				}
				else {
					list = (List<EventData>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first event data in the ordered set where eventlayoutId = &#63;.
	 *
	 * @param eventlayoutId the eventlayout ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event data
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a matching event data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventData findByEventLayout_First(long eventlayoutId,
		OrderByComparator orderByComparator)
		throws NoSuchEventDataException, SystemException {
		EventData eventData = fetchByEventLayout_First(eventlayoutId,
				orderByComparator);

		if (eventData != null) {
			return eventData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventlayoutId=");
		msg.append(eventlayoutId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventDataException(msg.toString());
	}

	/**
	 * Returns the first event data in the ordered set where eventlayoutId = &#63;.
	 *
	 * @param eventlayoutId the eventlayout ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event data, or <code>null</code> if a matching event data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventData fetchByEventLayout_First(long eventlayoutId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventData> list = findByEventLayout(eventlayoutId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event data in the ordered set where eventlayoutId = &#63;.
	 *
	 * @param eventlayoutId the eventlayout ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event data
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a matching event data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventData findByEventLayout_Last(long eventlayoutId,
		OrderByComparator orderByComparator)
		throws NoSuchEventDataException, SystemException {
		EventData eventData = fetchByEventLayout_Last(eventlayoutId,
				orderByComparator);

		if (eventData != null) {
			return eventData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventlayoutId=");
		msg.append(eventlayoutId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventDataException(msg.toString());
	}

	/**
	 * Returns the last event data in the ordered set where eventlayoutId = &#63;.
	 *
	 * @param eventlayoutId the eventlayout ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event data, or <code>null</code> if a matching event data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventData fetchByEventLayout_Last(long eventlayoutId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventLayout(eventlayoutId);

		if (count == 0) {
			return null;
		}

		List<EventData> list = findByEventLayout(eventlayoutId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event datas before and after the current event data in the ordered set where eventlayoutId = &#63;.
	 *
	 * @param eventdataId the primary key of the current event data
	 * @param eventlayoutId the eventlayout ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event data
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a event data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventData[] findByEventLayout_PrevAndNext(long eventdataId,
		long eventlayoutId, OrderByComparator orderByComparator)
		throws NoSuchEventDataException, SystemException {
		EventData eventData = findByPrimaryKey(eventdataId);

		Session session = null;

		try {
			session = openSession();

			EventData[] array = new EventDataImpl[3];

			array[0] = getByEventLayout_PrevAndNext(session, eventData,
					eventlayoutId, orderByComparator, true);

			array[1] = eventData;

			array[2] = getByEventLayout_PrevAndNext(session, eventData,
					eventlayoutId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventData getByEventLayout_PrevAndNext(Session session,
		EventData eventData, long eventlayoutId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTDATA_WHERE);

		query.append(_FINDER_COLUMN_EVENTLAYOUT_EVENTLAYOUTID_2);

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
			query.append(EventDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventlayoutId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event datas where eventlayoutId = &#63; from the database.
	 *
	 * @param eventlayoutId the eventlayout ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventLayout(long eventlayoutId)
		throws SystemException {
		for (EventData eventData : findByEventLayout(eventlayoutId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventData);
		}
	}

	/**
	 * Returns the number of event datas where eventlayoutId = &#63;.
	 *
	 * @param eventlayoutId the eventlayout ID
	 * @return the number of matching event datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventLayout(long eventlayoutId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTLAYOUT;

		Object[] finderArgs = new Object[] { eventlayoutId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTDATA_WHERE);

			query.append(_FINDER_COLUMN_EVENTLAYOUT_EVENTLAYOUTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventlayoutId);

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

	private static final String _FINDER_COLUMN_EVENTLAYOUT_EVENTLAYOUTID_2 = "eventData.eventlayoutId = ?";

	public EventDataPersistenceImpl() {
		setModelClass(EventData.class);
	}

	/**
	 * Caches the event data in the entity cache if it is enabled.
	 *
	 * @param eventData the event data
	 */
	@Override
	public void cacheResult(EventData eventData) {
		EntityCacheUtil.putResult(EventDataModelImpl.ENTITY_CACHE_ENABLED,
			EventDataImpl.class, eventData.getPrimaryKey(), eventData);

		eventData.resetOriginalValues();
	}

	/**
	 * Caches the event datas in the entity cache if it is enabled.
	 *
	 * @param eventDatas the event datas
	 */
	@Override
	public void cacheResult(List<EventData> eventDatas) {
		for (EventData eventData : eventDatas) {
			if (EntityCacheUtil.getResult(
						EventDataModelImpl.ENTITY_CACHE_ENABLED,
						EventDataImpl.class, eventData.getPrimaryKey()) == null) {
				cacheResult(eventData);
			}
			else {
				eventData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all event datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventDataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventDataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventData eventData) {
		EntityCacheUtil.removeResult(EventDataModelImpl.ENTITY_CACHE_ENABLED,
			EventDataImpl.class, eventData.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EventData> eventDatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventData eventData : eventDatas) {
			EntityCacheUtil.removeResult(EventDataModelImpl.ENTITY_CACHE_ENABLED,
				EventDataImpl.class, eventData.getPrimaryKey());
		}
	}

	/**
	 * Creates a new event data with the primary key. Does not add the event data to the database.
	 *
	 * @param eventdataId the primary key for the new event data
	 * @return the new event data
	 */
	@Override
	public EventData create(long eventdataId) {
		EventData eventData = new EventDataImpl();

		eventData.setNew(true);
		eventData.setPrimaryKey(eventdataId);

		return eventData;
	}

	/**
	 * Removes the event data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventdataId the primary key of the event data
	 * @return the event data that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a event data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventData remove(long eventdataId)
		throws NoSuchEventDataException, SystemException {
		return remove((Serializable)eventdataId);
	}

	/**
	 * Removes the event data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event data
	 * @return the event data that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a event data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventData remove(Serializable primaryKey)
		throws NoSuchEventDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EventData eventData = (EventData)session.get(EventDataImpl.class,
					primaryKey);

			if (eventData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventData);
		}
		catch (NoSuchEventDataException nsee) {
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
	protected EventData removeImpl(EventData eventData)
		throws SystemException {
		eventData = toUnwrappedModel(eventData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventData)) {
				eventData = (EventData)session.get(EventDataImpl.class,
						eventData.getPrimaryKeyObj());
			}

			if (eventData != null) {
				session.delete(eventData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eventData != null) {
			clearCache(eventData);
		}

		return eventData;
	}

	@Override
	public EventData updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData eventData)
		throws SystemException {
		eventData = toUnwrappedModel(eventData);

		boolean isNew = eventData.isNew();

		EventDataModelImpl eventDataModelImpl = (EventDataModelImpl)eventData;

		Session session = null;

		try {
			session = openSession();

			if (eventData.isNew()) {
				session.save(eventData);

				eventData.setNew(false);
			}
			else {
				session.merge(eventData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventDataModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTLAYOUT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventDataModelImpl.getOriginalEventlayoutId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTLAYOUT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTLAYOUT,
					args);

				args = new Object[] { eventDataModelImpl.getEventlayoutId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTLAYOUT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTLAYOUT,
					args);
			}
		}

		EntityCacheUtil.putResult(EventDataModelImpl.ENTITY_CACHE_ENABLED,
			EventDataImpl.class, eventData.getPrimaryKey(), eventData);

		return eventData;
	}

	protected EventData toUnwrappedModel(EventData eventData) {
		if (eventData instanceof EventDataImpl) {
			return eventData;
		}

		EventDataImpl eventDataImpl = new EventDataImpl();

		eventDataImpl.setNew(eventData.isNew());
		eventDataImpl.setPrimaryKey(eventData.getPrimaryKey());

		eventDataImpl.setEventdataId(eventData.getEventdataId());
		eventDataImpl.setEventlayoutId(eventData.getEventlayoutId());
		eventDataImpl.setPatientId(eventData.getPatientId());
		eventDataImpl.setOntology(eventData.getOntology());
		eventDataImpl.setValue(eventData.getValue());

		return eventDataImpl;
	}

	/**
	 * Returns the event data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the event data
	 * @return the event data
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a event data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventDataException, SystemException {
		EventData eventData = fetchByPrimaryKey(primaryKey);

		if (eventData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eventData;
	}

	/**
	 * Returns the event data with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException} if it could not be found.
	 *
	 * @param eventdataId the primary key of the event data
	 * @return the event data
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException if a event data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventData findByPrimaryKey(long eventdataId)
		throws NoSuchEventDataException, SystemException {
		return findByPrimaryKey((Serializable)eventdataId);
	}

	/**
	 * Returns the event data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event data
	 * @return the event data, or <code>null</code> if a event data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EventData eventData = (EventData)EntityCacheUtil.getResult(EventDataModelImpl.ENTITY_CACHE_ENABLED,
				EventDataImpl.class, primaryKey);

		if (eventData == _nullEventData) {
			return null;
		}

		if (eventData == null) {
			Session session = null;

			try {
				session = openSession();

				eventData = (EventData)session.get(EventDataImpl.class,
						primaryKey);

				if (eventData != null) {
					cacheResult(eventData);
				}
				else {
					EntityCacheUtil.putResult(EventDataModelImpl.ENTITY_CACHE_ENABLED,
						EventDataImpl.class, primaryKey, _nullEventData);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EventDataModelImpl.ENTITY_CACHE_ENABLED,
					EventDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eventData;
	}

	/**
	 * Returns the event data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventdataId the primary key of the event data
	 * @return the event data, or <code>null</code> if a event data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventData fetchByPrimaryKey(long eventdataId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eventdataId);
	}

	/**
	 * Returns all the event datas.
	 *
	 * @return the event datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event datas
	 * @param end the upper bound of the range of event datas (not inclusive)
	 * @return the range of event datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the event datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event datas
	 * @param end the upper bound of the range of event datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventData> findAll(int start, int end,
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

		List<EventData> list = (List<EventData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTDATA;

				if (pagination) {
					sql = sql.concat(EventDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EventData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventData>(list);
				}
				else {
					list = (List<EventData>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the event datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EventData eventData : findAll()) {
			remove(eventData);
		}
	}

	/**
	 * Returns the number of event datas.
	 *
	 * @return the number of event datas
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

				Query q = session.createQuery(_SQL_COUNT_EVENTDATA);

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
	 * Initializes the event data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EventData>> listenersList = new ArrayList<ModelListener<EventData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EventData>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EventDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVENTDATA = "SELECT eventData FROM EventData eventData";
	private static final String _SQL_SELECT_EVENTDATA_WHERE = "SELECT eventData FROM EventData eventData WHERE ";
	private static final String _SQL_COUNT_EVENTDATA = "SELECT COUNT(eventData) FROM EventData eventData";
	private static final String _SQL_COUNT_EVENTDATA_WHERE = "SELECT COUNT(eventData) FROM EventData eventData WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventData exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventDataPersistenceImpl.class);
	private static EventData _nullEventData = new EventDataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EventData> toCacheModel() {
				return _nullEventDataCacheModel;
			}
		};

	private static CacheModel<EventData> _nullEventDataCacheModel = new CacheModel<EventData>() {
			@Override
			public EventData toEntityModel() {
				return _nullEventData;
			}
		};
}