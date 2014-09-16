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

package at.graz.meduni.liferay.portlet.bbmriat.service.service.persistence;

import at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException;
import at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink;
import at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkImpl;
import at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl;

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
 * The persistence implementation for the organizationlink service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Reihs Robert
 * @see OrganizationlinkPersistence
 * @see OrganizationlinkUtil
 * @generated
 */
public class OrganizationlinkPersistenceImpl extends BasePersistenceImpl<Organizationlink>
	implements OrganizationlinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrganizationlinkUtil} to access the organizationlink persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrganizationlinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationlinkModelImpl.FINDER_CACHE_ENABLED,
			OrganizationlinkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationlinkModelImpl.FINDER_CACHE_ENABLED,
			OrganizationlinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationlinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTORGANIZATION =
		new FinderPath(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationlinkModelImpl.FINDER_CACHE_ENABLED,
			OrganizationlinkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentorganization",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTORGANIZATION =
		new FinderPath(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationlinkModelImpl.FINDER_CACHE_ENABLED,
			OrganizationlinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentorganization", new String[] { Long.class.getName() },
			OrganizationlinkModelImpl.PARENTORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTORGANIZATION = new FinderPath(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationlinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentorganization", new String[] { Long.class.getName() });

	/**
	 * Returns all the organizationlinks where parentorganizationId = &#63;.
	 *
	 * @param parentorganizationId the parentorganization ID
	 * @return the matching organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organizationlink> findByParentorganization(
		long parentorganizationId) throws SystemException {
		return findByParentorganization(parentorganizationId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizationlinks where parentorganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentorganizationId the parentorganization ID
	 * @param start the lower bound of the range of organizationlinks
	 * @param end the upper bound of the range of organizationlinks (not inclusive)
	 * @return the range of matching organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organizationlink> findByParentorganization(
		long parentorganizationId, int start, int end)
		throws SystemException {
		return findByParentorganization(parentorganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizationlinks where parentorganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentorganizationId the parentorganization ID
	 * @param start the lower bound of the range of organizationlinks
	 * @param end the upper bound of the range of organizationlinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organizationlink> findByParentorganization(
		long parentorganizationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTORGANIZATION;
			finderArgs = new Object[] { parentorganizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTORGANIZATION;
			finderArgs = new Object[] {
					parentorganizationId,
					
					start, end, orderByComparator
				};
		}

		List<Organizationlink> list = (List<Organizationlink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Organizationlink organizationlink : list) {
				if ((parentorganizationId != organizationlink.getParentorganizationId())) {
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

			query.append(_SQL_SELECT_ORGANIZATIONLINK_WHERE);

			query.append(_FINDER_COLUMN_PARENTORGANIZATION_PARENTORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrganizationlinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentorganizationId);

				if (!pagination) {
					list = (List<Organizationlink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Organizationlink>(list);
				}
				else {
					list = (List<Organizationlink>)QueryUtil.list(q,
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
	 * Returns the first organizationlink in the ordered set where parentorganizationId = &#63;.
	 *
	 * @param parentorganizationId the parentorganization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizationlink
	 * @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a matching organizationlink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink findByParentorganization_First(
		long parentorganizationId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationlinkException, SystemException {
		Organizationlink organizationlink = fetchByParentorganization_First(parentorganizationId,
				orderByComparator);

		if (organizationlink != null) {
			return organizationlink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentorganizationId=");
		msg.append(parentorganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationlinkException(msg.toString());
	}

	/**
	 * Returns the first organizationlink in the ordered set where parentorganizationId = &#63;.
	 *
	 * @param parentorganizationId the parentorganization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizationlink, or <code>null</code> if a matching organizationlink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink fetchByParentorganization_First(
		long parentorganizationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Organizationlink> list = findByParentorganization(parentorganizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organizationlink in the ordered set where parentorganizationId = &#63;.
	 *
	 * @param parentorganizationId the parentorganization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizationlink
	 * @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a matching organizationlink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink findByParentorganization_Last(
		long parentorganizationId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationlinkException, SystemException {
		Organizationlink organizationlink = fetchByParentorganization_Last(parentorganizationId,
				orderByComparator);

		if (organizationlink != null) {
			return organizationlink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentorganizationId=");
		msg.append(parentorganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationlinkException(msg.toString());
	}

	/**
	 * Returns the last organizationlink in the ordered set where parentorganizationId = &#63;.
	 *
	 * @param parentorganizationId the parentorganization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizationlink, or <code>null</code> if a matching organizationlink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink fetchByParentorganization_Last(
		long parentorganizationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentorganization(parentorganizationId);

		if (count == 0) {
			return null;
		}

		List<Organizationlink> list = findByParentorganization(parentorganizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizationlinks before and after the current organizationlink in the ordered set where parentorganizationId = &#63;.
	 *
	 * @param organizationlinkId the primary key of the current organizationlink
	 * @param parentorganizationId the parentorganization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organizationlink
	 * @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a organizationlink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink[] findByParentorganization_PrevAndNext(
		long organizationlinkId, long parentorganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationlinkException, SystemException {
		Organizationlink organizationlink = findByPrimaryKey(organizationlinkId);

		Session session = null;

		try {
			session = openSession();

			Organizationlink[] array = new OrganizationlinkImpl[3];

			array[0] = getByParentorganization_PrevAndNext(session,
					organizationlink, parentorganizationId, orderByComparator,
					true);

			array[1] = organizationlink;

			array[2] = getByParentorganization_PrevAndNext(session,
					organizationlink, parentorganizationId, orderByComparator,
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

	protected Organizationlink getByParentorganization_PrevAndNext(
		Session session, Organizationlink organizationlink,
		long parentorganizationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATIONLINK_WHERE);

		query.append(_FINDER_COLUMN_PARENTORGANIZATION_PARENTORGANIZATIONID_2);

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
			query.append(OrganizationlinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentorganizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organizationlink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Organizationlink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organizationlinks where parentorganizationId = &#63; from the database.
	 *
	 * @param parentorganizationId the parentorganization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentorganization(long parentorganizationId)
		throws SystemException {
		for (Organizationlink organizationlink : findByParentorganization(
				parentorganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(organizationlink);
		}
	}

	/**
	 * Returns the number of organizationlinks where parentorganizationId = &#63;.
	 *
	 * @param parentorganizationId the parentorganization ID
	 * @return the number of matching organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentorganization(long parentorganizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTORGANIZATION;

		Object[] finderArgs = new Object[] { parentorganizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGANIZATIONLINK_WHERE);

			query.append(_FINDER_COLUMN_PARENTORGANIZATION_PARENTORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentorganizationId);

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

	private static final String _FINDER_COLUMN_PARENTORGANIZATION_PARENTORGANIZATIONID_2 =
		"organizationlink.parentorganizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATION =
		new FinderPath(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationlinkModelImpl.FINDER_CACHE_ENABLED,
			OrganizationlinkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganization",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION =
		new FinderPath(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationlinkModelImpl.FINDER_CACHE_ENABLED,
			OrganizationlinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganization",
			new String[] { Long.class.getName() },
			OrganizationlinkModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATION = new FinderPath(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationlinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganization",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the organizationlinks where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organizationlink> findByOrganization(long organizationId)
		throws SystemException {
		return findByOrganization(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizationlinks where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organizationlinks
	 * @param end the upper bound of the range of organizationlinks (not inclusive)
	 * @return the range of matching organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organizationlink> findByOrganization(long organizationId,
		int start, int end) throws SystemException {
		return findByOrganization(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizationlinks where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organizationlinks
	 * @param end the upper bound of the range of organizationlinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organizationlink> findByOrganization(long organizationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATION;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<Organizationlink> list = (List<Organizationlink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Organizationlink organizationlink : list) {
				if ((organizationId != organizationlink.getOrganizationId())) {
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

			query.append(_SQL_SELECT_ORGANIZATIONLINK_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrganizationlinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<Organizationlink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Organizationlink>(list);
				}
				else {
					list = (List<Organizationlink>)QueryUtil.list(q,
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
	 * Returns the first organizationlink in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizationlink
	 * @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a matching organizationlink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink findByOrganization_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationlinkException, SystemException {
		Organizationlink organizationlink = fetchByOrganization_First(organizationId,
				orderByComparator);

		if (organizationlink != null) {
			return organizationlink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationlinkException(msg.toString());
	}

	/**
	 * Returns the first organizationlink in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizationlink, or <code>null</code> if a matching organizationlink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink fetchByOrganization_First(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Organizationlink> list = findByOrganization(organizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organizationlink in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizationlink
	 * @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a matching organizationlink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink findByOrganization_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationlinkException, SystemException {
		Organizationlink organizationlink = fetchByOrganization_Last(organizationId,
				orderByComparator);

		if (organizationlink != null) {
			return organizationlink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationlinkException(msg.toString());
	}

	/**
	 * Returns the last organizationlink in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizationlink, or <code>null</code> if a matching organizationlink could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink fetchByOrganization_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganization(organizationId);

		if (count == 0) {
			return null;
		}

		List<Organizationlink> list = findByOrganization(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizationlinks before and after the current organizationlink in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationlinkId the primary key of the current organizationlink
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organizationlink
	 * @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a organizationlink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink[] findByOrganization_PrevAndNext(
		long organizationlinkId, long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationlinkException, SystemException {
		Organizationlink organizationlink = findByPrimaryKey(organizationlinkId);

		Session session = null;

		try {
			session = openSession();

			Organizationlink[] array = new OrganizationlinkImpl[3];

			array[0] = getByOrganization_PrevAndNext(session, organizationlink,
					organizationId, orderByComparator, true);

			array[1] = organizationlink;

			array[2] = getByOrganization_PrevAndNext(session, organizationlink,
					organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Organizationlink getByOrganization_PrevAndNext(Session session,
		Organizationlink organizationlink, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATIONLINK_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

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
			query.append(OrganizationlinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organizationlink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Organizationlink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organizationlinks where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganization(long organizationId)
		throws SystemException {
		for (Organizationlink organizationlink : findByOrganization(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(organizationlink);
		}
	}

	/**
	 * Returns the number of organizationlinks where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganization(long organizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATION;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGANIZATIONLINK_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2 = "organizationlink.organizationId = ?";

	public OrganizationlinkPersistenceImpl() {
		setModelClass(Organizationlink.class);
	}

	/**
	 * Caches the organizationlink in the entity cache if it is enabled.
	 *
	 * @param organizationlink the organizationlink
	 */
	@Override
	public void cacheResult(Organizationlink organizationlink) {
		EntityCacheUtil.putResult(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationlinkImpl.class, organizationlink.getPrimaryKey(),
			organizationlink);

		organizationlink.resetOriginalValues();
	}

	/**
	 * Caches the organizationlinks in the entity cache if it is enabled.
	 *
	 * @param organizationlinks the organizationlinks
	 */
	@Override
	public void cacheResult(List<Organizationlink> organizationlinks) {
		for (Organizationlink organizationlink : organizationlinks) {
			if (EntityCacheUtil.getResult(
						OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationlinkImpl.class,
						organizationlink.getPrimaryKey()) == null) {
				cacheResult(organizationlink);
			}
			else {
				organizationlink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all organizationlinks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrganizationlinkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrganizationlinkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organizationlink.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Organizationlink organizationlink) {
		EntityCacheUtil.removeResult(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationlinkImpl.class, organizationlink.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Organizationlink> organizationlinks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Organizationlink organizationlink : organizationlinks) {
			EntityCacheUtil.removeResult(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationlinkImpl.class, organizationlink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new organizationlink with the primary key. Does not add the organizationlink to the database.
	 *
	 * @param organizationlinkId the primary key for the new organizationlink
	 * @return the new organizationlink
	 */
	@Override
	public Organizationlink create(long organizationlinkId) {
		Organizationlink organizationlink = new OrganizationlinkImpl();

		organizationlink.setNew(true);
		organizationlink.setPrimaryKey(organizationlinkId);

		return organizationlink;
	}

	/**
	 * Removes the organizationlink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationlinkId the primary key of the organizationlink
	 * @return the organizationlink that was removed
	 * @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a organizationlink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink remove(long organizationlinkId)
		throws NoSuchOrganizationlinkException, SystemException {
		return remove((Serializable)organizationlinkId);
	}

	/**
	 * Removes the organizationlink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organizationlink
	 * @return the organizationlink that was removed
	 * @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a organizationlink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink remove(Serializable primaryKey)
		throws NoSuchOrganizationlinkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Organizationlink organizationlink = (Organizationlink)session.get(OrganizationlinkImpl.class,
					primaryKey);

			if (organizationlink == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationlinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(organizationlink);
		}
		catch (NoSuchOrganizationlinkException nsee) {
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
	protected Organizationlink removeImpl(Organizationlink organizationlink)
		throws SystemException {
		organizationlink = toUnwrappedModel(organizationlink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organizationlink)) {
				organizationlink = (Organizationlink)session.get(OrganizationlinkImpl.class,
						organizationlink.getPrimaryKeyObj());
			}

			if (organizationlink != null) {
				session.delete(organizationlink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (organizationlink != null) {
			clearCache(organizationlink);
		}

		return organizationlink;
	}

	@Override
	public Organizationlink updateImpl(
		at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink organizationlink)
		throws SystemException {
		organizationlink = toUnwrappedModel(organizationlink);

		boolean isNew = organizationlink.isNew();

		OrganizationlinkModelImpl organizationlinkModelImpl = (OrganizationlinkModelImpl)organizationlink;

		Session session = null;

		try {
			session = openSession();

			if (organizationlink.isNew()) {
				session.save(organizationlink);

				organizationlink.setNew(false);
			}
			else {
				session.merge(organizationlink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrganizationlinkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((organizationlinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTORGANIZATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizationlinkModelImpl.getOriginalParentorganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTORGANIZATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTORGANIZATION,
					args);

				args = new Object[] {
						organizationlinkModelImpl.getParentorganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTORGANIZATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTORGANIZATION,
					args);
			}

			if ((organizationlinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizationlinkModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION,
					args);

				args = new Object[] {
						organizationlinkModelImpl.getOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION,
					args);
			}
		}

		EntityCacheUtil.putResult(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationlinkImpl.class, organizationlink.getPrimaryKey(),
			organizationlink);

		return organizationlink;
	}

	protected Organizationlink toUnwrappedModel(
		Organizationlink organizationlink) {
		if (organizationlink instanceof OrganizationlinkImpl) {
			return organizationlink;
		}

		OrganizationlinkImpl organizationlinkImpl = new OrganizationlinkImpl();

		organizationlinkImpl.setNew(organizationlink.isNew());
		organizationlinkImpl.setPrimaryKey(organizationlink.getPrimaryKey());

		organizationlinkImpl.setOrganizationlinkId(organizationlink.getOrganizationlinkId());
		organizationlinkImpl.setParentorganizationId(organizationlink.getParentorganizationId());
		organizationlinkImpl.setOrganizationId(organizationlink.getOrganizationId());

		return organizationlinkImpl;
	}

	/**
	 * Returns the organizationlink with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the organizationlink
	 * @return the organizationlink
	 * @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a organizationlink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationlinkException, SystemException {
		Organizationlink organizationlink = fetchByPrimaryKey(primaryKey);

		if (organizationlink == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationlinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return organizationlink;
	}

	/**
	 * Returns the organizationlink with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException} if it could not be found.
	 *
	 * @param organizationlinkId the primary key of the organizationlink
	 * @return the organizationlink
	 * @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a organizationlink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink findByPrimaryKey(long organizationlinkId)
		throws NoSuchOrganizationlinkException, SystemException {
		return findByPrimaryKey((Serializable)organizationlinkId);
	}

	/**
	 * Returns the organizationlink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organizationlink
	 * @return the organizationlink, or <code>null</code> if a organizationlink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Organizationlink organizationlink = (Organizationlink)EntityCacheUtil.getResult(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationlinkImpl.class, primaryKey);

		if (organizationlink == _nullOrganizationlink) {
			return null;
		}

		if (organizationlink == null) {
			Session session = null;

			try {
				session = openSession();

				organizationlink = (Organizationlink)session.get(OrganizationlinkImpl.class,
						primaryKey);

				if (organizationlink != null) {
					cacheResult(organizationlink);
				}
				else {
					EntityCacheUtil.putResult(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationlinkImpl.class, primaryKey,
						_nullOrganizationlink);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrganizationlinkModelImpl.ENTITY_CACHE_ENABLED,
					OrganizationlinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return organizationlink;
	}

	/**
	 * Returns the organizationlink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationlinkId the primary key of the organizationlink
	 * @return the organizationlink, or <code>null</code> if a organizationlink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink fetchByPrimaryKey(long organizationlinkId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)organizationlinkId);
	}

	/**
	 * Returns all the organizationlinks.
	 *
	 * @return the organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organizationlink> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizationlinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizationlinks
	 * @param end the upper bound of the range of organizationlinks (not inclusive)
	 * @return the range of organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organizationlink> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizationlinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizationlinks
	 * @param end the upper bound of the range of organizationlinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organizationlink> findAll(int start, int end,
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

		List<Organizationlink> list = (List<Organizationlink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORGANIZATIONLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATIONLINK;

				if (pagination) {
					sql = sql.concat(OrganizationlinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Organizationlink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Organizationlink>(list);
				}
				else {
					list = (List<Organizationlink>)QueryUtil.list(q,
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
	 * Removes all the organizationlinks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Organizationlink organizationlink : findAll()) {
			remove(organizationlink);
		}
	}

	/**
	 * Returns the number of organizationlinks.
	 *
	 * @return the number of organizationlinks
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

				Query q = session.createQuery(_SQL_COUNT_ORGANIZATIONLINK);

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
	 * Initializes the organizationlink persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Organizationlink>> listenersList = new ArrayList<ModelListener<Organizationlink>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Organizationlink>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrganizationlinkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORGANIZATIONLINK = "SELECT organizationlink FROM Organizationlink organizationlink";
	private static final String _SQL_SELECT_ORGANIZATIONLINK_WHERE = "SELECT organizationlink FROM Organizationlink organizationlink WHERE ";
	private static final String _SQL_COUNT_ORGANIZATIONLINK = "SELECT COUNT(organizationlink) FROM Organizationlink organizationlink";
	private static final String _SQL_COUNT_ORGANIZATIONLINK_WHERE = "SELECT COUNT(organizationlink) FROM Organizationlink organizationlink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "organizationlink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Organizationlink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Organizationlink exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrganizationlinkPersistenceImpl.class);
	private static Organizationlink _nullOrganizationlink = new OrganizationlinkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Organizationlink> toCacheModel() {
				return _nullOrganizationlinkCacheModel;
			}
		};

	private static CacheModel<Organizationlink> _nullOrganizationlinkCacheModel = new CacheModel<Organizationlink>() {
			@Override
			public Organizationlink toEntityModel() {
				return _nullOrganizationlink;
			}
		};
}