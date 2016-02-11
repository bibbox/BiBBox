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

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException;
import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification;
import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventNotificationImpl;
import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventNotificationModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the r d connect event notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see RDConnectEventNotificationPersistence
 * @see RDConnectEventNotificationUtil
 * @generated
 */
public class RDConnectEventNotificationPersistenceImpl
	extends BasePersistenceImpl<RDConnectEventNotification>
	implements RDConnectEventNotificationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RDConnectEventNotificationUtil} to access the r d connect event notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RDConnectEventNotificationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventNotificationModelImpl.FINDER_CACHE_ENABLED,
			RDConnectEventNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventNotificationModelImpl.FINDER_CACHE_ENABLED,
			RDConnectEventNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventNotificationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EVENTNOTIFICATIONFORUSER =
		new FinderPath(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventNotificationModelImpl.FINDER_CACHE_ENABLED,
			RDConnectEventNotificationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEventNotificationForUser",
			new String[] { String.class.getName(), Long.class.getName() },
			RDConnectEventNotificationModelImpl.NOTIFICATIONTYPE_COLUMN_BITMASK |
			RDConnectEventNotificationModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTNOTIFICATIONFORUSER =
		new FinderPath(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventNotificationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEventNotificationForUser",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the r d connect event notification where notificationtype = &#63; and userId = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException} if it could not be found.
	 *
	 * @param notificationtype the notificationtype
	 * @param userId the user ID
	 * @return the matching r d connect event notification
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a matching r d connect event notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification findByEventNotificationForUser(
		String notificationtype, long userId)
		throws NoSuchRDConnectEventNotificationException, SystemException {
		RDConnectEventNotification rdConnectEventNotification = fetchByEventNotificationForUser(notificationtype,
				userId);

		if (rdConnectEventNotification == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("notificationtype=");
			msg.append(notificationtype);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRDConnectEventNotificationException(msg.toString());
		}

		return rdConnectEventNotification;
	}

	/**
	 * Returns the r d connect event notification where notificationtype = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param notificationtype the notificationtype
	 * @param userId the user ID
	 * @return the matching r d connect event notification, or <code>null</code> if a matching r d connect event notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification fetchByEventNotificationForUser(
		String notificationtype, long userId) throws SystemException {
		return fetchByEventNotificationForUser(notificationtype, userId, true);
	}

	/**
	 * Returns the r d connect event notification where notificationtype = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param notificationtype the notificationtype
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching r d connect event notification, or <code>null</code> if a matching r d connect event notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification fetchByEventNotificationForUser(
		String notificationtype, long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { notificationtype, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EVENTNOTIFICATIONFORUSER,
					finderArgs, this);
		}

		if (result instanceof RDConnectEventNotification) {
			RDConnectEventNotification rdConnectEventNotification = (RDConnectEventNotification)result;

			if (!Validator.equals(notificationtype,
						rdConnectEventNotification.getNotificationtype()) ||
					(userId != rdConnectEventNotification.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RDCONNECTEVENTNOTIFICATION_WHERE);

			boolean bindNotificationtype = false;

			if (notificationtype == null) {
				query.append(_FINDER_COLUMN_EVENTNOTIFICATIONFORUSER_NOTIFICATIONTYPE_1);
			}
			else if (notificationtype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTNOTIFICATIONFORUSER_NOTIFICATIONTYPE_3);
			}
			else {
				bindNotificationtype = true;

				query.append(_FINDER_COLUMN_EVENTNOTIFICATIONFORUSER_NOTIFICATIONTYPE_2);
			}

			query.append(_FINDER_COLUMN_EVENTNOTIFICATIONFORUSER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNotificationtype) {
					qPos.add(notificationtype);
				}

				qPos.add(userId);

				List<RDConnectEventNotification> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTNOTIFICATIONFORUSER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"RDConnectEventNotificationPersistenceImpl.fetchByEventNotificationForUser(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					RDConnectEventNotification rdConnectEventNotification = list.get(0);

					result = rdConnectEventNotification;

					cacheResult(rdConnectEventNotification);

					if ((rdConnectEventNotification.getNotificationtype() == null) ||
							!rdConnectEventNotification.getNotificationtype()
														   .equals(notificationtype) ||
							(rdConnectEventNotification.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTNOTIFICATIONFORUSER,
							finderArgs, rdConnectEventNotification);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTNOTIFICATIONFORUSER,
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
			return (RDConnectEventNotification)result;
		}
	}

	/**
	 * Removes the r d connect event notification where notificationtype = &#63; and userId = &#63; from the database.
	 *
	 * @param notificationtype the notificationtype
	 * @param userId the user ID
	 * @return the r d connect event notification that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification removeByEventNotificationForUser(
		String notificationtype, long userId)
		throws NoSuchRDConnectEventNotificationException, SystemException {
		RDConnectEventNotification rdConnectEventNotification = findByEventNotificationForUser(notificationtype,
				userId);

		return remove(rdConnectEventNotification);
	}

	/**
	 * Returns the number of r d connect event notifications where notificationtype = &#63; and userId = &#63;.
	 *
	 * @param notificationtype the notificationtype
	 * @param userId the user ID
	 * @return the number of matching r d connect event notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventNotificationForUser(String notificationtype,
		long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTNOTIFICATIONFORUSER;

		Object[] finderArgs = new Object[] { notificationtype, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RDCONNECTEVENTNOTIFICATION_WHERE);

			boolean bindNotificationtype = false;

			if (notificationtype == null) {
				query.append(_FINDER_COLUMN_EVENTNOTIFICATIONFORUSER_NOTIFICATIONTYPE_1);
			}
			else if (notificationtype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTNOTIFICATIONFORUSER_NOTIFICATIONTYPE_3);
			}
			else {
				bindNotificationtype = true;

				query.append(_FINDER_COLUMN_EVENTNOTIFICATIONFORUSER_NOTIFICATIONTYPE_2);
			}

			query.append(_FINDER_COLUMN_EVENTNOTIFICATIONFORUSER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNotificationtype) {
					qPos.add(notificationtype);
				}

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_EVENTNOTIFICATIONFORUSER_NOTIFICATIONTYPE_1 =
		"rdConnectEventNotification.notificationtype IS NULL AND ";
	private static final String _FINDER_COLUMN_EVENTNOTIFICATIONFORUSER_NOTIFICATIONTYPE_2 =
		"rdConnectEventNotification.notificationtype = ? AND ";
	private static final String _FINDER_COLUMN_EVENTNOTIFICATIONFORUSER_NOTIFICATIONTYPE_3 =
		"(rdConnectEventNotification.notificationtype IS NULL OR rdConnectEventNotification.notificationtype = '') AND ";
	private static final String _FINDER_COLUMN_EVENTNOTIFICATIONFORUSER_USERID_2 =
		"rdConnectEventNotification.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTNOTIFICATIONSFORUSER =
		new FinderPath(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventNotificationModelImpl.FINDER_CACHE_ENABLED,
			RDConnectEventNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEventNotificationsForUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTNOTIFICATIONSFORUSER =
		new FinderPath(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventNotificationModelImpl.FINDER_CACHE_ENABLED,
			RDConnectEventNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEventNotificationsForUser",
			new String[] { Long.class.getName() },
			RDConnectEventNotificationModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTNOTIFICATIONSFORUSER =
		new FinderPath(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventNotificationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEventNotificationsForUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the r d connect event notifications where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching r d connect event notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEventNotification> findByEventNotificationsForUser(
		long userId) throws SystemException {
		return findByEventNotificationsForUser(userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the r d connect event notifications where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of r d connect event notifications
	 * @param end the upper bound of the range of r d connect event notifications (not inclusive)
	 * @return the range of matching r d connect event notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEventNotification> findByEventNotificationsForUser(
		long userId, int start, int end) throws SystemException {
		return findByEventNotificationsForUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d connect event notifications where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of r d connect event notifications
	 * @param end the upper bound of the range of r d connect event notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching r d connect event notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEventNotification> findByEventNotificationsForUser(
		long userId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTNOTIFICATIONSFORUSER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTNOTIFICATIONSFORUSER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<RDConnectEventNotification> list = (List<RDConnectEventNotification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RDConnectEventNotification rdConnectEventNotification : list) {
				if ((userId != rdConnectEventNotification.getUserId())) {
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

			query.append(_SQL_SELECT_RDCONNECTEVENTNOTIFICATION_WHERE);

			query.append(_FINDER_COLUMN_EVENTNOTIFICATIONSFORUSER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RDConnectEventNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<RDConnectEventNotification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDConnectEventNotification>(list);
				}
				else {
					list = (List<RDConnectEventNotification>)QueryUtil.list(q,
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
	 * Returns the first r d connect event notification in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d connect event notification
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a matching r d connect event notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification findByEventNotificationsForUser_First(
		long userId, OrderByComparator orderByComparator)
		throws NoSuchRDConnectEventNotificationException, SystemException {
		RDConnectEventNotification rdConnectEventNotification = fetchByEventNotificationsForUser_First(userId,
				orderByComparator);

		if (rdConnectEventNotification != null) {
			return rdConnectEventNotification;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDConnectEventNotificationException(msg.toString());
	}

	/**
	 * Returns the first r d connect event notification in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d connect event notification, or <code>null</code> if a matching r d connect event notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification fetchByEventNotificationsForUser_First(
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<RDConnectEventNotification> list = findByEventNotificationsForUser(userId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last r d connect event notification in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d connect event notification
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a matching r d connect event notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification findByEventNotificationsForUser_Last(
		long userId, OrderByComparator orderByComparator)
		throws NoSuchRDConnectEventNotificationException, SystemException {
		RDConnectEventNotification rdConnectEventNotification = fetchByEventNotificationsForUser_Last(userId,
				orderByComparator);

		if (rdConnectEventNotification != null) {
			return rdConnectEventNotification;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDConnectEventNotificationException(msg.toString());
	}

	/**
	 * Returns the last r d connect event notification in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d connect event notification, or <code>null</code> if a matching r d connect event notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification fetchByEventNotificationsForUser_Last(
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByEventNotificationsForUser(userId);

		if (count == 0) {
			return null;
		}

		List<RDConnectEventNotification> list = findByEventNotificationsForUser(userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the r d connect event notifications before and after the current r d connect event notification in the ordered set where userId = &#63;.
	 *
	 * @param eventnotificationId the primary key of the current r d connect event notification
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next r d connect event notification
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a r d connect event notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification[] findByEventNotificationsForUser_PrevAndNext(
		long eventnotificationId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchRDConnectEventNotificationException, SystemException {
		RDConnectEventNotification rdConnectEventNotification = findByPrimaryKey(eventnotificationId);

		Session session = null;

		try {
			session = openSession();

			RDConnectEventNotification[] array = new RDConnectEventNotificationImpl[3];

			array[0] = getByEventNotificationsForUser_PrevAndNext(session,
					rdConnectEventNotification, userId, orderByComparator, true);

			array[1] = rdConnectEventNotification;

			array[2] = getByEventNotificationsForUser_PrevAndNext(session,
					rdConnectEventNotification, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RDConnectEventNotification getByEventNotificationsForUser_PrevAndNext(
		Session session, RDConnectEventNotification rdConnectEventNotification,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RDCONNECTEVENTNOTIFICATION_WHERE);

		query.append(_FINDER_COLUMN_EVENTNOTIFICATIONSFORUSER_USERID_2);

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
			query.append(RDConnectEventNotificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rdConnectEventNotification);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RDConnectEventNotification> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the r d connect event notifications where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventNotificationsForUser(long userId)
		throws SystemException {
		for (RDConnectEventNotification rdConnectEventNotification : findByEventNotificationsForUser(
				userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rdConnectEventNotification);
		}
	}

	/**
	 * Returns the number of r d connect event notifications where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching r d connect event notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventNotificationsForUser(long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTNOTIFICATIONSFORUSER;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RDCONNECTEVENTNOTIFICATION_WHERE);

			query.append(_FINDER_COLUMN_EVENTNOTIFICATIONSFORUSER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_EVENTNOTIFICATIONSFORUSER_USERID_2 =
		"rdConnectEventNotification.userId = ?";

	public RDConnectEventNotificationPersistenceImpl() {
		setModelClass(RDConnectEventNotification.class);
	}

	/**
	 * Caches the r d connect event notification in the entity cache if it is enabled.
	 *
	 * @param rdConnectEventNotification the r d connect event notification
	 */
	@Override
	public void cacheResult(
		RDConnectEventNotification rdConnectEventNotification) {
		EntityCacheUtil.putResult(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventNotificationImpl.class,
			rdConnectEventNotification.getPrimaryKey(),
			rdConnectEventNotification);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTNOTIFICATIONFORUSER,
			new Object[] {
				rdConnectEventNotification.getNotificationtype(),
				rdConnectEventNotification.getUserId()
			}, rdConnectEventNotification);

		rdConnectEventNotification.resetOriginalValues();
	}

	/**
	 * Caches the r d connect event notifications in the entity cache if it is enabled.
	 *
	 * @param rdConnectEventNotifications the r d connect event notifications
	 */
	@Override
	public void cacheResult(
		List<RDConnectEventNotification> rdConnectEventNotifications) {
		for (RDConnectEventNotification rdConnectEventNotification : rdConnectEventNotifications) {
			if (EntityCacheUtil.getResult(
						RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
						RDConnectEventNotificationImpl.class,
						rdConnectEventNotification.getPrimaryKey()) == null) {
				cacheResult(rdConnectEventNotification);
			}
			else {
				rdConnectEventNotification.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all r d connect event notifications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RDConnectEventNotificationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RDConnectEventNotificationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the r d connect event notification.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		RDConnectEventNotification rdConnectEventNotification) {
		EntityCacheUtil.removeResult(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventNotificationImpl.class,
			rdConnectEventNotification.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(rdConnectEventNotification);
	}

	@Override
	public void clearCache(
		List<RDConnectEventNotification> rdConnectEventNotifications) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RDConnectEventNotification rdConnectEventNotification : rdConnectEventNotifications) {
			EntityCacheUtil.removeResult(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
				RDConnectEventNotificationImpl.class,
				rdConnectEventNotification.getPrimaryKey());

			clearUniqueFindersCache(rdConnectEventNotification);
		}
	}

	protected void cacheUniqueFindersCache(
		RDConnectEventNotification rdConnectEventNotification) {
		if (rdConnectEventNotification.isNew()) {
			Object[] args = new Object[] {
					rdConnectEventNotification.getNotificationtype(),
					rdConnectEventNotification.getUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVENTNOTIFICATIONFORUSER,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTNOTIFICATIONFORUSER,
				args, rdConnectEventNotification);
		}
		else {
			RDConnectEventNotificationModelImpl rdConnectEventNotificationModelImpl =
				(RDConnectEventNotificationModelImpl)rdConnectEventNotification;

			if ((rdConnectEventNotificationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EVENTNOTIFICATIONFORUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rdConnectEventNotification.getNotificationtype(),
						rdConnectEventNotification.getUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVENTNOTIFICATIONFORUSER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTNOTIFICATIONFORUSER,
					args, rdConnectEventNotification);
			}
		}
	}

	protected void clearUniqueFindersCache(
		RDConnectEventNotification rdConnectEventNotification) {
		RDConnectEventNotificationModelImpl rdConnectEventNotificationModelImpl = (RDConnectEventNotificationModelImpl)rdConnectEventNotification;

		Object[] args = new Object[] {
				rdConnectEventNotification.getNotificationtype(),
				rdConnectEventNotification.getUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTNOTIFICATIONFORUSER,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTNOTIFICATIONFORUSER,
			args);

		if ((rdConnectEventNotificationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EVENTNOTIFICATIONFORUSER.getColumnBitmask()) != 0) {
			args = new Object[] {
					rdConnectEventNotificationModelImpl.getOriginalNotificationtype(),
					rdConnectEventNotificationModelImpl.getOriginalUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTNOTIFICATIONFORUSER,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTNOTIFICATIONFORUSER,
				args);
		}
	}

	/**
	 * Creates a new r d connect event notification with the primary key. Does not add the r d connect event notification to the database.
	 *
	 * @param eventnotificationId the primary key for the new r d connect event notification
	 * @return the new r d connect event notification
	 */
	@Override
	public RDConnectEventNotification create(long eventnotificationId) {
		RDConnectEventNotification rdConnectEventNotification = new RDConnectEventNotificationImpl();

		rdConnectEventNotification.setNew(true);
		rdConnectEventNotification.setPrimaryKey(eventnotificationId);

		return rdConnectEventNotification;
	}

	/**
	 * Removes the r d connect event notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventnotificationId the primary key of the r d connect event notification
	 * @return the r d connect event notification that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a r d connect event notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification remove(long eventnotificationId)
		throws NoSuchRDConnectEventNotificationException, SystemException {
		return remove((Serializable)eventnotificationId);
	}

	/**
	 * Removes the r d connect event notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the r d connect event notification
	 * @return the r d connect event notification that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a r d connect event notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification remove(Serializable primaryKey)
		throws NoSuchRDConnectEventNotificationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RDConnectEventNotification rdConnectEventNotification = (RDConnectEventNotification)session.get(RDConnectEventNotificationImpl.class,
					primaryKey);

			if (rdConnectEventNotification == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRDConnectEventNotificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rdConnectEventNotification);
		}
		catch (NoSuchRDConnectEventNotificationException nsee) {
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
	protected RDConnectEventNotification removeImpl(
		RDConnectEventNotification rdConnectEventNotification)
		throws SystemException {
		rdConnectEventNotification = toUnwrappedModel(rdConnectEventNotification);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rdConnectEventNotification)) {
				rdConnectEventNotification = (RDConnectEventNotification)session.get(RDConnectEventNotificationImpl.class,
						rdConnectEventNotification.getPrimaryKeyObj());
			}

			if (rdConnectEventNotification != null) {
				session.delete(rdConnectEventNotification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rdConnectEventNotification != null) {
			clearCache(rdConnectEventNotification);
		}

		return rdConnectEventNotification;
	}

	@Override
	public RDConnectEventNotification updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification rdConnectEventNotification)
		throws SystemException {
		rdConnectEventNotification = toUnwrappedModel(rdConnectEventNotification);

		boolean isNew = rdConnectEventNotification.isNew();

		RDConnectEventNotificationModelImpl rdConnectEventNotificationModelImpl = (RDConnectEventNotificationModelImpl)rdConnectEventNotification;

		Session session = null;

		try {
			session = openSession();

			if (rdConnectEventNotification.isNew()) {
				session.save(rdConnectEventNotification);

				rdConnectEventNotification.setNew(false);
			}
			else {
				session.merge(rdConnectEventNotification);
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
				!RDConnectEventNotificationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rdConnectEventNotificationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTNOTIFICATIONSFORUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rdConnectEventNotificationModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTNOTIFICATIONSFORUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTNOTIFICATIONSFORUSER,
					args);

				args = new Object[] {
						rdConnectEventNotificationModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTNOTIFICATIONSFORUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTNOTIFICATIONSFORUSER,
					args);
			}
		}

		EntityCacheUtil.putResult(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectEventNotificationImpl.class,
			rdConnectEventNotification.getPrimaryKey(),
			rdConnectEventNotification);

		clearUniqueFindersCache(rdConnectEventNotification);
		cacheUniqueFindersCache(rdConnectEventNotification);

		return rdConnectEventNotification;
	}

	protected RDConnectEventNotification toUnwrappedModel(
		RDConnectEventNotification rdConnectEventNotification) {
		if (rdConnectEventNotification instanceof RDConnectEventNotificationImpl) {
			return rdConnectEventNotification;
		}

		RDConnectEventNotificationImpl rdConnectEventNotificationImpl = new RDConnectEventNotificationImpl();

		rdConnectEventNotificationImpl.setNew(rdConnectEventNotification.isNew());
		rdConnectEventNotificationImpl.setPrimaryKey(rdConnectEventNotification.getPrimaryKey());

		rdConnectEventNotificationImpl.setEventnotificationId(rdConnectEventNotification.getEventnotificationId());
		rdConnectEventNotificationImpl.setNotificationtype(rdConnectEventNotification.getNotificationtype());
		rdConnectEventNotificationImpl.setUserId(rdConnectEventNotification.getUserId());
		rdConnectEventNotificationImpl.setNotificationselected(rdConnectEventNotification.isNotificationselected());

		return rdConnectEventNotificationImpl;
	}

	/**
	 * Returns the r d connect event notification with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the r d connect event notification
	 * @return the r d connect event notification
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a r d connect event notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRDConnectEventNotificationException, SystemException {
		RDConnectEventNotification rdConnectEventNotification = fetchByPrimaryKey(primaryKey);

		if (rdConnectEventNotification == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRDConnectEventNotificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rdConnectEventNotification;
	}

	/**
	 * Returns the r d connect event notification with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException} if it could not be found.
	 *
	 * @param eventnotificationId the primary key of the r d connect event notification
	 * @return the r d connect event notification
	 * @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a r d connect event notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification findByPrimaryKey(long eventnotificationId)
		throws NoSuchRDConnectEventNotificationException, SystemException {
		return findByPrimaryKey((Serializable)eventnotificationId);
	}

	/**
	 * Returns the r d connect event notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the r d connect event notification
	 * @return the r d connect event notification, or <code>null</code> if a r d connect event notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RDConnectEventNotification rdConnectEventNotification = (RDConnectEventNotification)EntityCacheUtil.getResult(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
				RDConnectEventNotificationImpl.class, primaryKey);

		if (rdConnectEventNotification == _nullRDConnectEventNotification) {
			return null;
		}

		if (rdConnectEventNotification == null) {
			Session session = null;

			try {
				session = openSession();

				rdConnectEventNotification = (RDConnectEventNotification)session.get(RDConnectEventNotificationImpl.class,
						primaryKey);

				if (rdConnectEventNotification != null) {
					cacheResult(rdConnectEventNotification);
				}
				else {
					EntityCacheUtil.putResult(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
						RDConnectEventNotificationImpl.class, primaryKey,
						_nullRDConnectEventNotification);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RDConnectEventNotificationModelImpl.ENTITY_CACHE_ENABLED,
					RDConnectEventNotificationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rdConnectEventNotification;
	}

	/**
	 * Returns the r d connect event notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventnotificationId the primary key of the r d connect event notification
	 * @return the r d connect event notification, or <code>null</code> if a r d connect event notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectEventNotification fetchByPrimaryKey(
		long eventnotificationId) throws SystemException {
		return fetchByPrimaryKey((Serializable)eventnotificationId);
	}

	/**
	 * Returns all the r d connect event notifications.
	 *
	 * @return the r d connect event notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEventNotification> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the r d connect event notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of r d connect event notifications
	 * @param end the upper bound of the range of r d connect event notifications (not inclusive)
	 * @return the range of r d connect event notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEventNotification> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d connect event notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of r d connect event notifications
	 * @param end the upper bound of the range of r d connect event notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of r d connect event notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectEventNotification> findAll(int start, int end,
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

		List<RDConnectEventNotification> list = (List<RDConnectEventNotification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RDCONNECTEVENTNOTIFICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RDCONNECTEVENTNOTIFICATION;

				if (pagination) {
					sql = sql.concat(RDConnectEventNotificationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RDConnectEventNotification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDConnectEventNotification>(list);
				}
				else {
					list = (List<RDConnectEventNotification>)QueryUtil.list(q,
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
	 * Removes all the r d connect event notifications from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RDConnectEventNotification rdConnectEventNotification : findAll()) {
			remove(rdConnectEventNotification);
		}
	}

	/**
	 * Returns the number of r d connect event notifications.
	 *
	 * @return the number of r d connect event notifications
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

				Query q = session.createQuery(_SQL_COUNT_RDCONNECTEVENTNOTIFICATION);

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
	 * Initializes the r d connect event notification persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RDConnectEventNotification>> listenersList = new ArrayList<ModelListener<RDConnectEventNotification>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RDConnectEventNotification>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RDConnectEventNotificationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RDCONNECTEVENTNOTIFICATION = "SELECT rdConnectEventNotification FROM RDConnectEventNotification rdConnectEventNotification";
	private static final String _SQL_SELECT_RDCONNECTEVENTNOTIFICATION_WHERE = "SELECT rdConnectEventNotification FROM RDConnectEventNotification rdConnectEventNotification WHERE ";
	private static final String _SQL_COUNT_RDCONNECTEVENTNOTIFICATION = "SELECT COUNT(rdConnectEventNotification) FROM RDConnectEventNotification rdConnectEventNotification";
	private static final String _SQL_COUNT_RDCONNECTEVENTNOTIFICATION_WHERE = "SELECT COUNT(rdConnectEventNotification) FROM RDConnectEventNotification rdConnectEventNotification WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rdConnectEventNotification.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RDConnectEventNotification exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RDConnectEventNotification exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RDConnectEventNotificationPersistenceImpl.class);
	private static RDConnectEventNotification _nullRDConnectEventNotification = new RDConnectEventNotificationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RDConnectEventNotification> toCacheModel() {
				return _nullRDConnectEventNotificationCacheModel;
			}
		};

	private static CacheModel<RDConnectEventNotification> _nullRDConnectEventNotificationCacheModel =
		new CacheModel<RDConnectEventNotification>() {
			@Override
			public RDConnectEventNotification toEntityModel() {
				return _nullRDConnectEventNotification;
			}
		};
}