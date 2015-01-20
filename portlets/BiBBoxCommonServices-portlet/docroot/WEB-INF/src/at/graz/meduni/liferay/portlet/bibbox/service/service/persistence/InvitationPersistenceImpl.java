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

package at.graz.meduni.liferay.portlet.bibbox.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl;

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
 * The persistence implementation for the invitation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see InvitationPersistence
 * @see InvitationUtil
 * @generated
 */
public class InvitationPersistenceImpl extends BasePersistenceImpl<Invitation>
	implements InvitationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InvitationUtil} to access the invitation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InvitationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, InvitationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, InvitationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, InvitationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, InvitationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Long.class.getName() },
			InvitationModelImpl.STATUS_COLUMN_BITMASK |
			InvitationModelImpl.LASTCHANGED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the invitations where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invitation> findByStatus(long status) throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of invitations
	 * @param end the upper bound of the range of invitations (not inclusive)
	 * @return the range of matching invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invitation> findByStatus(long status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the invitations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of invitations
	 * @param end the upper bound of the range of invitations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invitation> findByStatus(long status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<Invitation> list = (List<Invitation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Invitation invitation : list) {
				if ((status != invitation.getStatus())) {
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

			query.append(_SQL_SELECT_INVITATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvitationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<Invitation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Invitation>(list);
				}
				else {
					list = (List<Invitation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first invitation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a matching invitation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation findByStatus_First(long status,
		OrderByComparator orderByComparator)
		throws NoSuchInvitationException, SystemException {
		Invitation invitation = fetchByStatus_First(status, orderByComparator);

		if (invitation != null) {
			return invitation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitationException(msg.toString());
	}

	/**
	 * Returns the first invitation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitation, or <code>null</code> if a matching invitation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation fetchByStatus_First(long status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Invitation> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invitation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a matching invitation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation findByStatus_Last(long status,
		OrderByComparator orderByComparator)
		throws NoSuchInvitationException, SystemException {
		Invitation invitation = fetchByStatus_Last(status, orderByComparator);

		if (invitation != null) {
			return invitation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitationException(msg.toString());
	}

	/**
	 * Returns the last invitation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitation, or <code>null</code> if a matching invitation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation fetchByStatus_Last(long status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Invitation> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the invitations before and after the current invitation in the ordered set where status = &#63;.
	 *
	 * @param invitationId the primary key of the current invitation
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invitation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation[] findByStatus_PrevAndNext(long invitationId,
		long status, OrderByComparator orderByComparator)
		throws NoSuchInvitationException, SystemException {
		Invitation invitation = findByPrimaryKey(invitationId);

		Session session = null;

		try {
			session = openSession();

			Invitation[] array = new InvitationImpl[3];

			array[0] = getByStatus_PrevAndNext(session, invitation, status,
					orderByComparator, true);

			array[1] = invitation;

			array[2] = getByStatus_PrevAndNext(session, invitation, status,
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

	protected Invitation getByStatus_PrevAndNext(Session session,
		Invitation invitation, long status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVITATION_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(InvitationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invitation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Invitation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invitations where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(long status) throws SystemException {
		for (Invitation invitation : findByStatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(invitation);
		}
	}

	/**
	 * Returns the number of invitations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(long status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVITATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "invitation.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILTER = new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, InvitationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFilter",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILTER =
		new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, InvitationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFilter",
			new String[] { String.class.getName() },
			InvitationModelImpl.FILTER_COLUMN_BITMASK |
			InvitationModelImpl.LASTCHANGED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILTER = new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFilter",
			new String[] { String.class.getName() });

	/**
	 * Returns all the invitations where filter = &#63;.
	 *
	 * @param filter the filter
	 * @return the matching invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invitation> findByFilter(String filter)
		throws SystemException {
		return findByFilter(filter, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitations where filter = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param filter the filter
	 * @param start the lower bound of the range of invitations
	 * @param end the upper bound of the range of invitations (not inclusive)
	 * @return the range of matching invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invitation> findByFilter(String filter, int start, int end)
		throws SystemException {
		return findByFilter(filter, start, end, null);
	}

	/**
	 * Returns an ordered range of all the invitations where filter = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param filter the filter
	 * @param start the lower bound of the range of invitations
	 * @param end the upper bound of the range of invitations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invitation> findByFilter(String filter, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILTER;
			finderArgs = new Object[] { filter };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILTER;
			finderArgs = new Object[] { filter, start, end, orderByComparator };
		}

		List<Invitation> list = (List<Invitation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Invitation invitation : list) {
				if (!Validator.equals(filter, invitation.getFilter())) {
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

			query.append(_SQL_SELECT_INVITATION_WHERE);

			boolean bindFilter = false;

			if (filter == null) {
				query.append(_FINDER_COLUMN_FILTER_FILTER_1);
			}
			else if (filter.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILTER_FILTER_3);
			}
			else {
				bindFilter = true;

				query.append(_FINDER_COLUMN_FILTER_FILTER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvitationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFilter) {
					qPos.add(filter);
				}

				if (!pagination) {
					list = (List<Invitation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Invitation>(list);
				}
				else {
					list = (List<Invitation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first invitation in the ordered set where filter = &#63;.
	 *
	 * @param filter the filter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a matching invitation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation findByFilter_First(String filter,
		OrderByComparator orderByComparator)
		throws NoSuchInvitationException, SystemException {
		Invitation invitation = fetchByFilter_First(filter, orderByComparator);

		if (invitation != null) {
			return invitation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("filter=");
		msg.append(filter);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitationException(msg.toString());
	}

	/**
	 * Returns the first invitation in the ordered set where filter = &#63;.
	 *
	 * @param filter the filter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitation, or <code>null</code> if a matching invitation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation fetchByFilter_First(String filter,
		OrderByComparator orderByComparator) throws SystemException {
		List<Invitation> list = findByFilter(filter, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invitation in the ordered set where filter = &#63;.
	 *
	 * @param filter the filter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a matching invitation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation findByFilter_Last(String filter,
		OrderByComparator orderByComparator)
		throws NoSuchInvitationException, SystemException {
		Invitation invitation = fetchByFilter_Last(filter, orderByComparator);

		if (invitation != null) {
			return invitation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("filter=");
		msg.append(filter);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitationException(msg.toString());
	}

	/**
	 * Returns the last invitation in the ordered set where filter = &#63;.
	 *
	 * @param filter the filter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitation, or <code>null</code> if a matching invitation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation fetchByFilter_Last(String filter,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFilter(filter);

		if (count == 0) {
			return null;
		}

		List<Invitation> list = findByFilter(filter, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the invitations before and after the current invitation in the ordered set where filter = &#63;.
	 *
	 * @param invitationId the primary key of the current invitation
	 * @param filter the filter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invitation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation[] findByFilter_PrevAndNext(long invitationId,
		String filter, OrderByComparator orderByComparator)
		throws NoSuchInvitationException, SystemException {
		Invitation invitation = findByPrimaryKey(invitationId);

		Session session = null;

		try {
			session = openSession();

			Invitation[] array = new InvitationImpl[3];

			array[0] = getByFilter_PrevAndNext(session, invitation, filter,
					orderByComparator, true);

			array[1] = invitation;

			array[2] = getByFilter_PrevAndNext(session, invitation, filter,
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

	protected Invitation getByFilter_PrevAndNext(Session session,
		Invitation invitation, String filter,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVITATION_WHERE);

		boolean bindFilter = false;

		if (filter == null) {
			query.append(_FINDER_COLUMN_FILTER_FILTER_1);
		}
		else if (filter.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FILTER_FILTER_3);
		}
		else {
			bindFilter = true;

			query.append(_FINDER_COLUMN_FILTER_FILTER_2);
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
			query.append(InvitationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFilter) {
			qPos.add(filter);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invitation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Invitation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invitations where filter = &#63; from the database.
	 *
	 * @param filter the filter
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFilter(String filter) throws SystemException {
		for (Invitation invitation : findByFilter(filter, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(invitation);
		}
	}

	/**
	 * Returns the number of invitations where filter = &#63;.
	 *
	 * @param filter the filter
	 * @return the number of matching invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFilter(String filter) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILTER;

		Object[] finderArgs = new Object[] { filter };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVITATION_WHERE);

			boolean bindFilter = false;

			if (filter == null) {
				query.append(_FINDER_COLUMN_FILTER_FILTER_1);
			}
			else if (filter.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILTER_FILTER_3);
			}
			else {
				bindFilter = true;

				query.append(_FINDER_COLUMN_FILTER_FILTER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFilter) {
					qPos.add(filter);
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

	private static final String _FINDER_COLUMN_FILTER_FILTER_1 = "invitation.filter IS NULL";
	private static final String _FINDER_COLUMN_FILTER_FILTER_2 = "invitation.filter = ?";
	private static final String _FINDER_COLUMN_FILTER_FILTER_3 = "(invitation.filter IS NULL OR invitation.filter = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_INVITATION = new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, InvitationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByInvitation",
			new String[] { Long.class.getName() },
			InvitationModelImpl.INVITATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INVITATION = new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInvitation",
			new String[] { Long.class.getName() });

	/**
	 * Returns the invitation where invitationId = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException} if it could not be found.
	 *
	 * @param invitationId the invitation ID
	 * @return the matching invitation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a matching invitation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation findByInvitation(long invitationId)
		throws NoSuchInvitationException, SystemException {
		Invitation invitation = fetchByInvitation(invitationId);

		if (invitation == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("invitationId=");
			msg.append(invitationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchInvitationException(msg.toString());
		}

		return invitation;
	}

	/**
	 * Returns the invitation where invitationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param invitationId the invitation ID
	 * @return the matching invitation, or <code>null</code> if a matching invitation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation fetchByInvitation(long invitationId)
		throws SystemException {
		return fetchByInvitation(invitationId, true);
	}

	/**
	 * Returns the invitation where invitationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param invitationId the invitation ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching invitation, or <code>null</code> if a matching invitation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation fetchByInvitation(long invitationId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { invitationId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_INVITATION,
					finderArgs, this);
		}

		if (result instanceof Invitation) {
			Invitation invitation = (Invitation)result;

			if ((invitationId != invitation.getInvitationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_INVITATION_WHERE);

			query.append(_FINDER_COLUMN_INVITATION_INVITATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(invitationId);

				List<Invitation> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVITATION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"InvitationPersistenceImpl.fetchByInvitation(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Invitation invitation = list.get(0);

					result = invitation;

					cacheResult(invitation);

					if ((invitation.getInvitationId() != invitationId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVITATION,
							finderArgs, invitation);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INVITATION,
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
			return (Invitation)result;
		}
	}

	/**
	 * Removes the invitation where invitationId = &#63; from the database.
	 *
	 * @param invitationId the invitation ID
	 * @return the invitation that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation removeByInvitation(long invitationId)
		throws NoSuchInvitationException, SystemException {
		Invitation invitation = findByInvitation(invitationId);

		return remove(invitation);
	}

	/**
	 * Returns the number of invitations where invitationId = &#63;.
	 *
	 * @param invitationId the invitation ID
	 * @return the number of matching invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByInvitation(long invitationId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INVITATION;

		Object[] finderArgs = new Object[] { invitationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVITATION_WHERE);

			query.append(_FINDER_COLUMN_INVITATION_INVITATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(invitationId);

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

	private static final String _FINDER_COLUMN_INVITATION_INVITATIONID_2 = "invitation.invitationId = ?";

	public InvitationPersistenceImpl() {
		setModelClass(Invitation.class);
	}

	/**
	 * Caches the invitation in the entity cache if it is enabled.
	 *
	 * @param invitation the invitation
	 */
	@Override
	public void cacheResult(Invitation invitation) {
		EntityCacheUtil.putResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationImpl.class, invitation.getPrimaryKey(), invitation);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVITATION,
			new Object[] { invitation.getInvitationId() }, invitation);

		invitation.resetOriginalValues();
	}

	/**
	 * Caches the invitations in the entity cache if it is enabled.
	 *
	 * @param invitations the invitations
	 */
	@Override
	public void cacheResult(List<Invitation> invitations) {
		for (Invitation invitation : invitations) {
			if (EntityCacheUtil.getResult(
						InvitationModelImpl.ENTITY_CACHE_ENABLED,
						InvitationImpl.class, invitation.getPrimaryKey()) == null) {
				cacheResult(invitation);
			}
			else {
				invitation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all invitations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InvitationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InvitationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the invitation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Invitation invitation) {
		EntityCacheUtil.removeResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationImpl.class, invitation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(invitation);
	}

	@Override
	public void clearCache(List<Invitation> invitations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Invitation invitation : invitations) {
			EntityCacheUtil.removeResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
				InvitationImpl.class, invitation.getPrimaryKey());

			clearUniqueFindersCache(invitation);
		}
	}

	protected void cacheUniqueFindersCache(Invitation invitation) {
		if (invitation.isNew()) {
			Object[] args = new Object[] { invitation.getInvitationId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INVITATION, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVITATION, args,
				invitation);
		}
		else {
			InvitationModelImpl invitationModelImpl = (InvitationModelImpl)invitation;

			if ((invitationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_INVITATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { invitation.getInvitationId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INVITATION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVITATION,
					args, invitation);
			}
		}
	}

	protected void clearUniqueFindersCache(Invitation invitation) {
		InvitationModelImpl invitationModelImpl = (InvitationModelImpl)invitation;

		Object[] args = new Object[] { invitation.getInvitationId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INVITATION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INVITATION, args);

		if ((invitationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_INVITATION.getColumnBitmask()) != 0) {
			args = new Object[] { invitationModelImpl.getOriginalInvitationId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INVITATION, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INVITATION, args);
		}
	}

	/**
	 * Creates a new invitation with the primary key. Does not add the invitation to the database.
	 *
	 * @param invitationId the primary key for the new invitation
	 * @return the new invitation
	 */
	@Override
	public Invitation create(long invitationId) {
		Invitation invitation = new InvitationImpl();

		invitation.setNew(true);
		invitation.setPrimaryKey(invitationId);

		return invitation;
	}

	/**
	 * Removes the invitation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invitationId the primary key of the invitation
	 * @return the invitation that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation remove(long invitationId)
		throws NoSuchInvitationException, SystemException {
		return remove((Serializable)invitationId);
	}

	/**
	 * Removes the invitation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the invitation
	 * @return the invitation that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation remove(Serializable primaryKey)
		throws NoSuchInvitationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Invitation invitation = (Invitation)session.get(InvitationImpl.class,
					primaryKey);

			if (invitation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInvitationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(invitation);
		}
		catch (NoSuchInvitationException nsee) {
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
	protected Invitation removeImpl(Invitation invitation)
		throws SystemException {
		invitation = toUnwrappedModel(invitation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(invitation)) {
				invitation = (Invitation)session.get(InvitationImpl.class,
						invitation.getPrimaryKeyObj());
			}

			if (invitation != null) {
				session.delete(invitation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (invitation != null) {
			clearCache(invitation);
		}

		return invitation;
	}

	@Override
	public Invitation updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation)
		throws SystemException {
		invitation = toUnwrappedModel(invitation);

		boolean isNew = invitation.isNew();

		InvitationModelImpl invitationModelImpl = (InvitationModelImpl)invitation;

		Session session = null;

		try {
			session = openSession();

			if (invitation.isNew()) {
				session.save(invitation);

				invitation.setNew(false);
			}
			else {
				session.merge(invitation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !InvitationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((invitationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invitationModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { invitationModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((invitationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILTER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invitationModelImpl.getOriginalFilter()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILTER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILTER,
					args);

				args = new Object[] { invitationModelImpl.getFilter() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILTER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILTER,
					args);
			}
		}

		EntityCacheUtil.putResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationImpl.class, invitation.getPrimaryKey(), invitation);

		clearUniqueFindersCache(invitation);
		cacheUniqueFindersCache(invitation);

		return invitation;
	}

	protected Invitation toUnwrappedModel(Invitation invitation) {
		if (invitation instanceof InvitationImpl) {
			return invitation;
		}

		InvitationImpl invitationImpl = new InvitationImpl();

		invitationImpl.setNew(invitation.isNew());
		invitationImpl.setPrimaryKey(invitation.getPrimaryKey());

		invitationImpl.setInvitationId(invitation.getInvitationId());
		invitationImpl.setName(invitation.getName());
		invitationImpl.setSubject(invitation.getSubject());
		invitationImpl.setBody(invitation.getBody());
		invitationImpl.setStatus(invitation.getStatus());
		invitationImpl.setInvitationsend(invitation.getInvitationsend());
		invitationImpl.setLastchanged(invitation.getLastchanged());
		invitationImpl.setLastchanger(invitation.getLastchanger());
		invitationImpl.setFilter(invitation.getFilter());

		return invitationImpl;
	}

	/**
	 * Returns the invitation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the invitation
	 * @return the invitation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInvitationException, SystemException {
		Invitation invitation = fetchByPrimaryKey(primaryKey);

		if (invitation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInvitationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return invitation;
	}

	/**
	 * Returns the invitation with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException} if it could not be found.
	 *
	 * @param invitationId the primary key of the invitation
	 * @return the invitation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation findByPrimaryKey(long invitationId)
		throws NoSuchInvitationException, SystemException {
		return findByPrimaryKey((Serializable)invitationId);
	}

	/**
	 * Returns the invitation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the invitation
	 * @return the invitation, or <code>null</code> if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Invitation invitation = (Invitation)EntityCacheUtil.getResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
				InvitationImpl.class, primaryKey);

		if (invitation == _nullInvitation) {
			return null;
		}

		if (invitation == null) {
			Session session = null;

			try {
				session = openSession();

				invitation = (Invitation)session.get(InvitationImpl.class,
						primaryKey);

				if (invitation != null) {
					cacheResult(invitation);
				}
				else {
					EntityCacheUtil.putResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
						InvitationImpl.class, primaryKey, _nullInvitation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
					InvitationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return invitation;
	}

	/**
	 * Returns the invitation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invitationId the primary key of the invitation
	 * @return the invitation, or <code>null</code> if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation fetchByPrimaryKey(long invitationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)invitationId);
	}

	/**
	 * Returns all the invitations.
	 *
	 * @return the invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invitation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitations
	 * @param end the upper bound of the range of invitations (not inclusive)
	 * @return the range of invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invitation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the invitations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitations
	 * @param end the upper bound of the range of invitations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invitation> findAll(int start, int end,
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

		List<Invitation> list = (List<Invitation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INVITATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INVITATION;

				if (pagination) {
					sql = sql.concat(InvitationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Invitation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Invitation>(list);
				}
				else {
					list = (List<Invitation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the invitations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Invitation invitation : findAll()) {
			remove(invitation);
		}
	}

	/**
	 * Returns the number of invitations.
	 *
	 * @return the number of invitations
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

				Query q = session.createQuery(_SQL_COUNT_INVITATION);

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
	 * Initializes the invitation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Invitation>> listenersList = new ArrayList<ModelListener<Invitation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Invitation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InvitationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INVITATION = "SELECT invitation FROM Invitation invitation";
	private static final String _SQL_SELECT_INVITATION_WHERE = "SELECT invitation FROM Invitation invitation WHERE ";
	private static final String _SQL_COUNT_INVITATION = "SELECT COUNT(invitation) FROM Invitation invitation";
	private static final String _SQL_COUNT_INVITATION_WHERE = "SELECT COUNT(invitation) FROM Invitation invitation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "invitation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Invitation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Invitation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InvitationPersistenceImpl.class);
	private static Invitation _nullInvitation = new InvitationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Invitation> toCacheModel() {
				return _nullInvitationCacheModel;
			}
		};

	private static CacheModel<Invitation> _nullInvitationCacheModel = new CacheModel<Invitation>() {
			@Override
			public Invitation toEntityModel() {
				return _nullInvitation;
			}
		};
}