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

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl;

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
 * The persistence implementation for the invitation organisation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see InvitationOrganisationPersistence
 * @see InvitationOrganisationUtil
 * @generated
 */
public class InvitationOrganisationPersistenceImpl extends BasePersistenceImpl<InvitationOrganisation>
	implements InvitationOrganisationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InvitationOrganisationUtil} to access the invitation organisation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InvitationOrganisationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationModelImpl.FINDER_CACHE_ENABLED,
			InvitationOrganisationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationModelImpl.FINDER_CACHE_ENABLED,
			InvitationOrganisationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANISATION =
		new FinderPath(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationModelImpl.FINDER_CACHE_ENABLED,
			InvitationOrganisationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganisation",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANISATION =
		new FinderPath(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationModelImpl.FINDER_CACHE_ENABLED,
			InvitationOrganisationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganisation",
			new String[] { Long.class.getName() },
			InvitationOrganisationModelImpl.ORGANISATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANISATION = new FinderPath(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganisation",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the invitation organisations where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @return the matching invitation organisations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationOrganisation> findByOrganisation(long organisationId)
		throws SystemException {
		return findByOrganisation(organisationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitation organisations where organisationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationId the organisation ID
	 * @param start the lower bound of the range of invitation organisations
	 * @param end the upper bound of the range of invitation organisations (not inclusive)
	 * @return the range of matching invitation organisations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationOrganisation> findByOrganisation(
		long organisationId, int start, int end) throws SystemException {
		return findByOrganisation(organisationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the invitation organisations where organisationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationId the organisation ID
	 * @param start the lower bound of the range of invitation organisations
	 * @param end the upper bound of the range of invitation organisations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invitation organisations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationOrganisation> findByOrganisation(
		long organisationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANISATION;
			finderArgs = new Object[] { organisationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANISATION;
			finderArgs = new Object[] {
					organisationId,
					
					start, end, orderByComparator
				};
		}

		List<InvitationOrganisation> list = (List<InvitationOrganisation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (InvitationOrganisation invitationOrganisation : list) {
				if ((organisationId != invitationOrganisation.getOrganisationId())) {
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

			query.append(_SQL_SELECT_INVITATIONORGANISATION_WHERE);

			query.append(_FINDER_COLUMN_ORGANISATION_ORGANISATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvitationOrganisationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationId);

				if (!pagination) {
					list = (List<InvitationOrganisation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<InvitationOrganisation>(list);
				}
				else {
					list = (List<InvitationOrganisation>)QueryUtil.list(q,
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
	 * Returns the first invitation organisation in the ordered set where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitation organisation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a matching invitation organisation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation findByOrganisation_First(
		long organisationId, OrderByComparator orderByComparator)
		throws NoSuchInvitationOrganisationException, SystemException {
		InvitationOrganisation invitationOrganisation = fetchByOrganisation_First(organisationId,
				orderByComparator);

		if (invitationOrganisation != null) {
			return invitationOrganisation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organisationId=");
		msg.append(organisationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitationOrganisationException(msg.toString());
	}

	/**
	 * Returns the first invitation organisation in the ordered set where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitation organisation, or <code>null</code> if a matching invitation organisation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation fetchByOrganisation_First(
		long organisationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<InvitationOrganisation> list = findByOrganisation(organisationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invitation organisation in the ordered set where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitation organisation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a matching invitation organisation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation findByOrganisation_Last(long organisationId,
		OrderByComparator orderByComparator)
		throws NoSuchInvitationOrganisationException, SystemException {
		InvitationOrganisation invitationOrganisation = fetchByOrganisation_Last(organisationId,
				orderByComparator);

		if (invitationOrganisation != null) {
			return invitationOrganisation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organisationId=");
		msg.append(organisationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitationOrganisationException(msg.toString());
	}

	/**
	 * Returns the last invitation organisation in the ordered set where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitation organisation, or <code>null</code> if a matching invitation organisation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation fetchByOrganisation_Last(
		long organisationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOrganisation(organisationId);

		if (count == 0) {
			return null;
		}

		List<InvitationOrganisation> list = findByOrganisation(organisationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the invitation organisations before and after the current invitation organisation in the ordered set where organisationId = &#63;.
	 *
	 * @param invitationOrganisationId the primary key of the current invitation organisation
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invitation organisation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a invitation organisation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation[] findByOrganisation_PrevAndNext(
		long invitationOrganisationId, long organisationId,
		OrderByComparator orderByComparator)
		throws NoSuchInvitationOrganisationException, SystemException {
		InvitationOrganisation invitationOrganisation = findByPrimaryKey(invitationOrganisationId);

		Session session = null;

		try {
			session = openSession();

			InvitationOrganisation[] array = new InvitationOrganisationImpl[3];

			array[0] = getByOrganisation_PrevAndNext(session,
					invitationOrganisation, organisationId, orderByComparator,
					true);

			array[1] = invitationOrganisation;

			array[2] = getByOrganisation_PrevAndNext(session,
					invitationOrganisation, organisationId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected InvitationOrganisation getByOrganisation_PrevAndNext(
		Session session, InvitationOrganisation invitationOrganisation,
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

		query.append(_SQL_SELECT_INVITATIONORGANISATION_WHERE);

		query.append(_FINDER_COLUMN_ORGANISATION_ORGANISATIONID_2);

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
			query.append(InvitationOrganisationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organisationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invitationOrganisation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<InvitationOrganisation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invitation organisations where organisationId = &#63; from the database.
	 *
	 * @param organisationId the organisation ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganisation(long organisationId)
		throws SystemException {
		for (InvitationOrganisation invitationOrganisation : findByOrganisation(
				organisationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(invitationOrganisation);
		}
	}

	/**
	 * Returns the number of invitation organisations where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @return the number of matching invitation organisations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganisation(long organisationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANISATION;

		Object[] finderArgs = new Object[] { organisationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVITATIONORGANISATION_WHERE);

			query.append(_FINDER_COLUMN_ORGANISATION_ORGANISATIONID_2);

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

	private static final String _FINDER_COLUMN_ORGANISATION_ORGANISATIONID_2 = "invitationOrganisation.organisationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INVITATIONORGANISATIONS =
		new FinderPath(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationModelImpl.FINDER_CACHE_ENABLED,
			InvitationOrganisationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByInvitationOrganisations",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INVITATIONORGANISATIONS =
		new FinderPath(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationModelImpl.FINDER_CACHE_ENABLED,
			InvitationOrganisationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByInvitationOrganisations",
			new String[] { Long.class.getName() },
			InvitationOrganisationModelImpl.INVITATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INVITATIONORGANISATIONS = new FinderPath(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByInvitationOrganisations",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the invitation organisations where invitationId = &#63;.
	 *
	 * @param invitationId the invitation ID
	 * @return the matching invitation organisations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationOrganisation> findByInvitationOrganisations(
		long invitationId) throws SystemException {
		return findByInvitationOrganisations(invitationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitation organisations where invitationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param invitationId the invitation ID
	 * @param start the lower bound of the range of invitation organisations
	 * @param end the upper bound of the range of invitation organisations (not inclusive)
	 * @return the range of matching invitation organisations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationOrganisation> findByInvitationOrganisations(
		long invitationId, int start, int end) throws SystemException {
		return findByInvitationOrganisations(invitationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the invitation organisations where invitationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param invitationId the invitation ID
	 * @param start the lower bound of the range of invitation organisations
	 * @param end the upper bound of the range of invitation organisations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invitation organisations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationOrganisation> findByInvitationOrganisations(
		long invitationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INVITATIONORGANISATIONS;
			finderArgs = new Object[] { invitationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INVITATIONORGANISATIONS;
			finderArgs = new Object[] {
					invitationId,
					
					start, end, orderByComparator
				};
		}

		List<InvitationOrganisation> list = (List<InvitationOrganisation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (InvitationOrganisation invitationOrganisation : list) {
				if ((invitationId != invitationOrganisation.getInvitationId())) {
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

			query.append(_SQL_SELECT_INVITATIONORGANISATION_WHERE);

			query.append(_FINDER_COLUMN_INVITATIONORGANISATIONS_INVITATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvitationOrganisationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(invitationId);

				if (!pagination) {
					list = (List<InvitationOrganisation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<InvitationOrganisation>(list);
				}
				else {
					list = (List<InvitationOrganisation>)QueryUtil.list(q,
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
	 * Returns the first invitation organisation in the ordered set where invitationId = &#63;.
	 *
	 * @param invitationId the invitation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitation organisation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a matching invitation organisation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation findByInvitationOrganisations_First(
		long invitationId, OrderByComparator orderByComparator)
		throws NoSuchInvitationOrganisationException, SystemException {
		InvitationOrganisation invitationOrganisation = fetchByInvitationOrganisations_First(invitationId,
				orderByComparator);

		if (invitationOrganisation != null) {
			return invitationOrganisation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("invitationId=");
		msg.append(invitationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitationOrganisationException(msg.toString());
	}

	/**
	 * Returns the first invitation organisation in the ordered set where invitationId = &#63;.
	 *
	 * @param invitationId the invitation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invitation organisation, or <code>null</code> if a matching invitation organisation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation fetchByInvitationOrganisations_First(
		long invitationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<InvitationOrganisation> list = findByInvitationOrganisations(invitationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invitation organisation in the ordered set where invitationId = &#63;.
	 *
	 * @param invitationId the invitation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitation organisation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a matching invitation organisation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation findByInvitationOrganisations_Last(
		long invitationId, OrderByComparator orderByComparator)
		throws NoSuchInvitationOrganisationException, SystemException {
		InvitationOrganisation invitationOrganisation = fetchByInvitationOrganisations_Last(invitationId,
				orderByComparator);

		if (invitationOrganisation != null) {
			return invitationOrganisation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("invitationId=");
		msg.append(invitationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvitationOrganisationException(msg.toString());
	}

	/**
	 * Returns the last invitation organisation in the ordered set where invitationId = &#63;.
	 *
	 * @param invitationId the invitation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invitation organisation, or <code>null</code> if a matching invitation organisation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation fetchByInvitationOrganisations_Last(
		long invitationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByInvitationOrganisations(invitationId);

		if (count == 0) {
			return null;
		}

		List<InvitationOrganisation> list = findByInvitationOrganisations(invitationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the invitation organisations before and after the current invitation organisation in the ordered set where invitationId = &#63;.
	 *
	 * @param invitationOrganisationId the primary key of the current invitation organisation
	 * @param invitationId the invitation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invitation organisation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a invitation organisation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation[] findByInvitationOrganisations_PrevAndNext(
		long invitationOrganisationId, long invitationId,
		OrderByComparator orderByComparator)
		throws NoSuchInvitationOrganisationException, SystemException {
		InvitationOrganisation invitationOrganisation = findByPrimaryKey(invitationOrganisationId);

		Session session = null;

		try {
			session = openSession();

			InvitationOrganisation[] array = new InvitationOrganisationImpl[3];

			array[0] = getByInvitationOrganisations_PrevAndNext(session,
					invitationOrganisation, invitationId, orderByComparator,
					true);

			array[1] = invitationOrganisation;

			array[2] = getByInvitationOrganisations_PrevAndNext(session,
					invitationOrganisation, invitationId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected InvitationOrganisation getByInvitationOrganisations_PrevAndNext(
		Session session, InvitationOrganisation invitationOrganisation,
		long invitationId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVITATIONORGANISATION_WHERE);

		query.append(_FINDER_COLUMN_INVITATIONORGANISATIONS_INVITATIONID_2);

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
			query.append(InvitationOrganisationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(invitationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invitationOrganisation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<InvitationOrganisation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invitation organisations where invitationId = &#63; from the database.
	 *
	 * @param invitationId the invitation ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByInvitationOrganisations(long invitationId)
		throws SystemException {
		for (InvitationOrganisation invitationOrganisation : findByInvitationOrganisations(
				invitationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(invitationOrganisation);
		}
	}

	/**
	 * Returns the number of invitation organisations where invitationId = &#63;.
	 *
	 * @param invitationId the invitation ID
	 * @return the number of matching invitation organisations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByInvitationOrganisations(long invitationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INVITATIONORGANISATIONS;

		Object[] finderArgs = new Object[] { invitationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVITATIONORGANISATION_WHERE);

			query.append(_FINDER_COLUMN_INVITATIONORGANISATIONS_INVITATIONID_2);

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

	private static final String _FINDER_COLUMN_INVITATIONORGANISATIONS_INVITATIONID_2 =
		"invitationOrganisation.invitationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_INVITATIONIDANDORGANISATIONID =
		new FinderPath(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationModelImpl.FINDER_CACHE_ENABLED,
			InvitationOrganisationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByInvitationIdAndOrganisationId",
			new String[] { Long.class.getName(), Long.class.getName() },
			InvitationOrganisationModelImpl.INVITATIONID_COLUMN_BITMASK |
			InvitationOrganisationModelImpl.ORGANISATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INVITATIONIDANDORGANISATIONID =
		new FinderPath(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByInvitationIdAndOrganisationId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the invitation organisation where invitationId = &#63; and organisationId = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException} if it could not be found.
	 *
	 * @param invitationId the invitation ID
	 * @param organisationId the organisation ID
	 * @return the matching invitation organisation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a matching invitation organisation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation findByInvitationIdAndOrganisationId(
		long invitationId, long organisationId)
		throws NoSuchInvitationOrganisationException, SystemException {
		InvitationOrganisation invitationOrganisation = fetchByInvitationIdAndOrganisationId(invitationId,
				organisationId);

		if (invitationOrganisation == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("invitationId=");
			msg.append(invitationId);

			msg.append(", organisationId=");
			msg.append(organisationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchInvitationOrganisationException(msg.toString());
		}

		return invitationOrganisation;
	}

	/**
	 * Returns the invitation organisation where invitationId = &#63; and organisationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param invitationId the invitation ID
	 * @param organisationId the organisation ID
	 * @return the matching invitation organisation, or <code>null</code> if a matching invitation organisation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation fetchByInvitationIdAndOrganisationId(
		long invitationId, long organisationId) throws SystemException {
		return fetchByInvitationIdAndOrganisationId(invitationId,
			organisationId, true);
	}

	/**
	 * Returns the invitation organisation where invitationId = &#63; and organisationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param invitationId the invitation ID
	 * @param organisationId the organisation ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching invitation organisation, or <code>null</code> if a matching invitation organisation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation fetchByInvitationIdAndOrganisationId(
		long invitationId, long organisationId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { invitationId, organisationId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_INVITATIONIDANDORGANISATIONID,
					finderArgs, this);
		}

		if (result instanceof InvitationOrganisation) {
			InvitationOrganisation invitationOrganisation = (InvitationOrganisation)result;

			if ((invitationId != invitationOrganisation.getInvitationId()) ||
					(organisationId != invitationOrganisation.getOrganisationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_INVITATIONORGANISATION_WHERE);

			query.append(_FINDER_COLUMN_INVITATIONIDANDORGANISATIONID_INVITATIONID_2);

			query.append(_FINDER_COLUMN_INVITATIONIDANDORGANISATIONID_ORGANISATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(invitationId);

				qPos.add(organisationId);

				List<InvitationOrganisation> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVITATIONIDANDORGANISATIONID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"InvitationOrganisationPersistenceImpl.fetchByInvitationIdAndOrganisationId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					InvitationOrganisation invitationOrganisation = list.get(0);

					result = invitationOrganisation;

					cacheResult(invitationOrganisation);

					if ((invitationOrganisation.getInvitationId() != invitationId) ||
							(invitationOrganisation.getOrganisationId() != organisationId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVITATIONIDANDORGANISATIONID,
							finderArgs, invitationOrganisation);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INVITATIONIDANDORGANISATIONID,
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
			return (InvitationOrganisation)result;
		}
	}

	/**
	 * Removes the invitation organisation where invitationId = &#63; and organisationId = &#63; from the database.
	 *
	 * @param invitationId the invitation ID
	 * @param organisationId the organisation ID
	 * @return the invitation organisation that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation removeByInvitationIdAndOrganisationId(
		long invitationId, long organisationId)
		throws NoSuchInvitationOrganisationException, SystemException {
		InvitationOrganisation invitationOrganisation = findByInvitationIdAndOrganisationId(invitationId,
				organisationId);

		return remove(invitationOrganisation);
	}

	/**
	 * Returns the number of invitation organisations where invitationId = &#63; and organisationId = &#63;.
	 *
	 * @param invitationId the invitation ID
	 * @param organisationId the organisation ID
	 * @return the number of matching invitation organisations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByInvitationIdAndOrganisationId(long invitationId,
		long organisationId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INVITATIONIDANDORGANISATIONID;

		Object[] finderArgs = new Object[] { invitationId, organisationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INVITATIONORGANISATION_WHERE);

			query.append(_FINDER_COLUMN_INVITATIONIDANDORGANISATIONID_INVITATIONID_2);

			query.append(_FINDER_COLUMN_INVITATIONIDANDORGANISATIONID_ORGANISATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(invitationId);

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

	private static final String _FINDER_COLUMN_INVITATIONIDANDORGANISATIONID_INVITATIONID_2 =
		"invitationOrganisation.invitationId = ? AND ";
	private static final String _FINDER_COLUMN_INVITATIONIDANDORGANISATIONID_ORGANISATIONID_2 =
		"invitationOrganisation.organisationId = ?";

	public InvitationOrganisationPersistenceImpl() {
		setModelClass(InvitationOrganisation.class);
	}

	/**
	 * Caches the invitation organisation in the entity cache if it is enabled.
	 *
	 * @param invitationOrganisation the invitation organisation
	 */
	@Override
	public void cacheResult(InvitationOrganisation invitationOrganisation) {
		EntityCacheUtil.putResult(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationImpl.class,
			invitationOrganisation.getPrimaryKey(), invitationOrganisation);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVITATIONIDANDORGANISATIONID,
			new Object[] {
				invitationOrganisation.getInvitationId(),
				invitationOrganisation.getOrganisationId()
			}, invitationOrganisation);

		invitationOrganisation.resetOriginalValues();
	}

	/**
	 * Caches the invitation organisations in the entity cache if it is enabled.
	 *
	 * @param invitationOrganisations the invitation organisations
	 */
	@Override
	public void cacheResult(
		List<InvitationOrganisation> invitationOrganisations) {
		for (InvitationOrganisation invitationOrganisation : invitationOrganisations) {
			if (EntityCacheUtil.getResult(
						InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
						InvitationOrganisationImpl.class,
						invitationOrganisation.getPrimaryKey()) == null) {
				cacheResult(invitationOrganisation);
			}
			else {
				invitationOrganisation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all invitation organisations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InvitationOrganisationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InvitationOrganisationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the invitation organisation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InvitationOrganisation invitationOrganisation) {
		EntityCacheUtil.removeResult(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationImpl.class,
			invitationOrganisation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(invitationOrganisation);
	}

	@Override
	public void clearCache(List<InvitationOrganisation> invitationOrganisations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InvitationOrganisation invitationOrganisation : invitationOrganisations) {
			EntityCacheUtil.removeResult(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
				InvitationOrganisationImpl.class,
				invitationOrganisation.getPrimaryKey());

			clearUniqueFindersCache(invitationOrganisation);
		}
	}

	protected void cacheUniqueFindersCache(
		InvitationOrganisation invitationOrganisation) {
		if (invitationOrganisation.isNew()) {
			Object[] args = new Object[] {
					invitationOrganisation.getInvitationId(),
					invitationOrganisation.getOrganisationId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INVITATIONIDANDORGANISATIONID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVITATIONIDANDORGANISATIONID,
				args, invitationOrganisation);
		}
		else {
			InvitationOrganisationModelImpl invitationOrganisationModelImpl = (InvitationOrganisationModelImpl)invitationOrganisation;

			if ((invitationOrganisationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_INVITATIONIDANDORGANISATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invitationOrganisation.getInvitationId(),
						invitationOrganisation.getOrganisationId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INVITATIONIDANDORGANISATIONID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVITATIONIDANDORGANISATIONID,
					args, invitationOrganisation);
			}
		}
	}

	protected void clearUniqueFindersCache(
		InvitationOrganisation invitationOrganisation) {
		InvitationOrganisationModelImpl invitationOrganisationModelImpl = (InvitationOrganisationModelImpl)invitationOrganisation;

		Object[] args = new Object[] {
				invitationOrganisation.getInvitationId(),
				invitationOrganisation.getOrganisationId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INVITATIONIDANDORGANISATIONID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INVITATIONIDANDORGANISATIONID,
			args);

		if ((invitationOrganisationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_INVITATIONIDANDORGANISATIONID.getColumnBitmask()) != 0) {
			args = new Object[] {
					invitationOrganisationModelImpl.getOriginalInvitationId(),
					invitationOrganisationModelImpl.getOriginalOrganisationId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INVITATIONIDANDORGANISATIONID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INVITATIONIDANDORGANISATIONID,
				args);
		}
	}

	/**
	 * Creates a new invitation organisation with the primary key. Does not add the invitation organisation to the database.
	 *
	 * @param invitationOrganisationId the primary key for the new invitation organisation
	 * @return the new invitation organisation
	 */
	@Override
	public InvitationOrganisation create(long invitationOrganisationId) {
		InvitationOrganisation invitationOrganisation = new InvitationOrganisationImpl();

		invitationOrganisation.setNew(true);
		invitationOrganisation.setPrimaryKey(invitationOrganisationId);

		return invitationOrganisation;
	}

	/**
	 * Removes the invitation organisation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invitationOrganisationId the primary key of the invitation organisation
	 * @return the invitation organisation that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a invitation organisation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation remove(long invitationOrganisationId)
		throws NoSuchInvitationOrganisationException, SystemException {
		return remove((Serializable)invitationOrganisationId);
	}

	/**
	 * Removes the invitation organisation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the invitation organisation
	 * @return the invitation organisation that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a invitation organisation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation remove(Serializable primaryKey)
		throws NoSuchInvitationOrganisationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			InvitationOrganisation invitationOrganisation = (InvitationOrganisation)session.get(InvitationOrganisationImpl.class,
					primaryKey);

			if (invitationOrganisation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInvitationOrganisationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(invitationOrganisation);
		}
		catch (NoSuchInvitationOrganisationException nsee) {
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
	protected InvitationOrganisation removeImpl(
		InvitationOrganisation invitationOrganisation)
		throws SystemException {
		invitationOrganisation = toUnwrappedModel(invitationOrganisation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(invitationOrganisation)) {
				invitationOrganisation = (InvitationOrganisation)session.get(InvitationOrganisationImpl.class,
						invitationOrganisation.getPrimaryKeyObj());
			}

			if (invitationOrganisation != null) {
				session.delete(invitationOrganisation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (invitationOrganisation != null) {
			clearCache(invitationOrganisation);
		}

		return invitationOrganisation;
	}

	@Override
	public InvitationOrganisation updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation invitationOrganisation)
		throws SystemException {
		invitationOrganisation = toUnwrappedModel(invitationOrganisation);

		boolean isNew = invitationOrganisation.isNew();

		InvitationOrganisationModelImpl invitationOrganisationModelImpl = (InvitationOrganisationModelImpl)invitationOrganisation;

		Session session = null;

		try {
			session = openSession();

			if (invitationOrganisation.isNew()) {
				session.save(invitationOrganisation);

				invitationOrganisation.setNew(false);
			}
			else {
				session.merge(invitationOrganisation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !InvitationOrganisationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((invitationOrganisationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANISATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invitationOrganisationModelImpl.getOriginalOrganisationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANISATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANISATION,
					args);

				args = new Object[] {
						invitationOrganisationModelImpl.getOrganisationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANISATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANISATION,
					args);
			}

			if ((invitationOrganisationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INVITATIONORGANISATIONS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invitationOrganisationModelImpl.getOriginalInvitationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INVITATIONORGANISATIONS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INVITATIONORGANISATIONS,
					args);

				args = new Object[] {
						invitationOrganisationModelImpl.getInvitationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INVITATIONORGANISATIONS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INVITATIONORGANISATIONS,
					args);
			}
		}

		EntityCacheUtil.putResult(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationOrganisationImpl.class,
			invitationOrganisation.getPrimaryKey(), invitationOrganisation);

		clearUniqueFindersCache(invitationOrganisation);
		cacheUniqueFindersCache(invitationOrganisation);

		return invitationOrganisation;
	}

	protected InvitationOrganisation toUnwrappedModel(
		InvitationOrganisation invitationOrganisation) {
		if (invitationOrganisation instanceof InvitationOrganisationImpl) {
			return invitationOrganisation;
		}

		InvitationOrganisationImpl invitationOrganisationImpl = new InvitationOrganisationImpl();

		invitationOrganisationImpl.setNew(invitationOrganisation.isNew());
		invitationOrganisationImpl.setPrimaryKey(invitationOrganisation.getPrimaryKey());

		invitationOrganisationImpl.setInvitationOrganisationId(invitationOrganisation.getInvitationOrganisationId());
		invitationOrganisationImpl.setInvitationId(invitationOrganisation.getInvitationId());
		invitationOrganisationImpl.setOrganisationId(invitationOrganisation.getOrganisationId());
		invitationOrganisationImpl.setUserId(invitationOrganisation.getUserId());
		invitationOrganisationImpl.setLastchanged(invitationOrganisation.getLastchanged());
		invitationOrganisationImpl.setLastchanger(invitationOrganisation.getLastchanger());

		return invitationOrganisationImpl;
	}

	/**
	 * Returns the invitation organisation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the invitation organisation
	 * @return the invitation organisation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a invitation organisation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInvitationOrganisationException, SystemException {
		InvitationOrganisation invitationOrganisation = fetchByPrimaryKey(primaryKey);

		if (invitationOrganisation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInvitationOrganisationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return invitationOrganisation;
	}

	/**
	 * Returns the invitation organisation with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException} if it could not be found.
	 *
	 * @param invitationOrganisationId the primary key of the invitation organisation
	 * @return the invitation organisation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a invitation organisation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation findByPrimaryKey(
		long invitationOrganisationId)
		throws NoSuchInvitationOrganisationException, SystemException {
		return findByPrimaryKey((Serializable)invitationOrganisationId);
	}

	/**
	 * Returns the invitation organisation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the invitation organisation
	 * @return the invitation organisation, or <code>null</code> if a invitation organisation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		InvitationOrganisation invitationOrganisation = (InvitationOrganisation)EntityCacheUtil.getResult(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
				InvitationOrganisationImpl.class, primaryKey);

		if (invitationOrganisation == _nullInvitationOrganisation) {
			return null;
		}

		if (invitationOrganisation == null) {
			Session session = null;

			try {
				session = openSession();

				invitationOrganisation = (InvitationOrganisation)session.get(InvitationOrganisationImpl.class,
						primaryKey);

				if (invitationOrganisation != null) {
					cacheResult(invitationOrganisation);
				}
				else {
					EntityCacheUtil.putResult(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
						InvitationOrganisationImpl.class, primaryKey,
						_nullInvitationOrganisation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InvitationOrganisationModelImpl.ENTITY_CACHE_ENABLED,
					InvitationOrganisationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return invitationOrganisation;
	}

	/**
	 * Returns the invitation organisation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invitationOrganisationId the primary key of the invitation organisation
	 * @return the invitation organisation, or <code>null</code> if a invitation organisation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationOrganisation fetchByPrimaryKey(
		long invitationOrganisationId) throws SystemException {
		return fetchByPrimaryKey((Serializable)invitationOrganisationId);
	}

	/**
	 * Returns all the invitation organisations.
	 *
	 * @return the invitation organisations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationOrganisation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitation organisations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitation organisations
	 * @param end the upper bound of the range of invitation organisations (not inclusive)
	 * @return the range of invitation organisations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationOrganisation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the invitation organisations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitation organisations
	 * @param end the upper bound of the range of invitation organisations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of invitation organisations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationOrganisation> findAll(int start, int end,
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

		List<InvitationOrganisation> list = (List<InvitationOrganisation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INVITATIONORGANISATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INVITATIONORGANISATION;

				if (pagination) {
					sql = sql.concat(InvitationOrganisationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<InvitationOrganisation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<InvitationOrganisation>(list);
				}
				else {
					list = (List<InvitationOrganisation>)QueryUtil.list(q,
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
	 * Removes all the invitation organisations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (InvitationOrganisation invitationOrganisation : findAll()) {
			remove(invitationOrganisation);
		}
	}

	/**
	 * Returns the number of invitation organisations.
	 *
	 * @return the number of invitation organisations
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

				Query q = session.createQuery(_SQL_COUNT_INVITATIONORGANISATION);

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
	 * Initializes the invitation organisation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<InvitationOrganisation>> listenersList = new ArrayList<ModelListener<InvitationOrganisation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<InvitationOrganisation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InvitationOrganisationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INVITATIONORGANISATION = "SELECT invitationOrganisation FROM InvitationOrganisation invitationOrganisation";
	private static final String _SQL_SELECT_INVITATIONORGANISATION_WHERE = "SELECT invitationOrganisation FROM InvitationOrganisation invitationOrganisation WHERE ";
	private static final String _SQL_COUNT_INVITATIONORGANISATION = "SELECT COUNT(invitationOrganisation) FROM InvitationOrganisation invitationOrganisation";
	private static final String _SQL_COUNT_INVITATIONORGANISATION_WHERE = "SELECT COUNT(invitationOrganisation) FROM InvitationOrganisation invitationOrganisation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "invitationOrganisation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No InvitationOrganisation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No InvitationOrganisation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InvitationOrganisationPersistenceImpl.class);
	private static InvitationOrganisation _nullInvitationOrganisation = new InvitationOrganisationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<InvitationOrganisation> toCacheModel() {
				return _nullInvitationOrganisationCacheModel;
			}
		};

	private static CacheModel<InvitationOrganisation> _nullInvitationOrganisationCacheModel =
		new CacheModel<InvitationOrganisation>() {
			@Override
			public InvitationOrganisation toEntityModel() {
				return _nullInvitationOrganisation;
			}
		};
}