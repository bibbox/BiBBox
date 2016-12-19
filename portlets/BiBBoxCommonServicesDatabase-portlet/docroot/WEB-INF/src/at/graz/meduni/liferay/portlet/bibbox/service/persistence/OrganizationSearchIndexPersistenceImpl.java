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

package at.graz.meduni.liferay.portlet.bibbox.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException;
import at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the organization search index service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see OrganizationSearchIndexPersistence
 * @see OrganizationSearchIndexUtil
 * @generated
 */
public class OrganizationSearchIndexPersistenceImpl extends BasePersistenceImpl<OrganizationSearchIndex>
	implements OrganizationSearchIndexPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrganizationSearchIndexUtil} to access the organization search index persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrganizationSearchIndexImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationSearchIndexModelImpl.FINDER_CACHE_ENABLED,
			OrganizationSearchIndexImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationSearchIndexModelImpl.FINDER_CACHE_ENABLED,
			OrganizationSearchIndexImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationSearchIndexModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXACTSEARCH =
		new FinderPath(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationSearchIndexModelImpl.FINDER_CACHE_ENABLED,
			OrganizationSearchIndexImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExactSearch",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXACTSEARCH =
		new FinderPath(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationSearchIndexModelImpl.FINDER_CACHE_ENABLED,
			OrganizationSearchIndexImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExactSearch",
			new String[] { String.class.getName() },
			OrganizationSearchIndexModelImpl.SEARCHVALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXACTSEARCH = new FinderPath(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationSearchIndexModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExactSearch",
			new String[] { String.class.getName() });

	/**
	 * Returns all the organization search indexs where searchvalue = &#63;.
	 *
	 * @param searchvalue the searchvalue
	 * @return the matching organization search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizationSearchIndex> findByExactSearch(String searchvalue)
		throws SystemException {
		return findByExactSearch(searchvalue, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization search indexs where searchvalue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param searchvalue the searchvalue
	 * @param start the lower bound of the range of organization search indexs
	 * @param end the upper bound of the range of organization search indexs (not inclusive)
	 * @return the range of matching organization search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizationSearchIndex> findByExactSearch(String searchvalue,
		int start, int end) throws SystemException {
		return findByExactSearch(searchvalue, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization search indexs where searchvalue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param searchvalue the searchvalue
	 * @param start the lower bound of the range of organization search indexs
	 * @param end the upper bound of the range of organization search indexs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizationSearchIndex> findByExactSearch(String searchvalue,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXACTSEARCH;
			finderArgs = new Object[] { searchvalue };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EXACTSEARCH;
			finderArgs = new Object[] { searchvalue, start, end, orderByComparator };
		}

		List<OrganizationSearchIndex> list = (List<OrganizationSearchIndex>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OrganizationSearchIndex organizationSearchIndex : list) {
				if (!Validator.equals(searchvalue,
							organizationSearchIndex.getSearchvalue())) {
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

			query.append(_SQL_SELECT_ORGANIZATIONSEARCHINDEX_WHERE);

			boolean bindSearchvalue = false;

			if (searchvalue == null) {
				query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHVALUE_1);
			}
			else if (searchvalue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHVALUE_3);
			}
			else {
				bindSearchvalue = true;

				query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHVALUE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrganizationSearchIndexModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSearchvalue) {
					qPos.add(searchvalue);
				}

				if (!pagination) {
					list = (List<OrganizationSearchIndex>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrganizationSearchIndex>(list);
				}
				else {
					list = (List<OrganizationSearchIndex>)QueryUtil.list(q,
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
	 * Returns the first organization search index in the ordered set where searchvalue = &#63;.
	 *
	 * @param searchvalue the searchvalue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization search index
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a matching organization search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex findByExactSearch_First(String searchvalue,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationSearchIndexException, SystemException {
		OrganizationSearchIndex organizationSearchIndex = fetchByExactSearch_First(searchvalue,
				orderByComparator);

		if (organizationSearchIndex != null) {
			return organizationSearchIndex;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("searchvalue=");
		msg.append(searchvalue);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationSearchIndexException(msg.toString());
	}

	/**
	 * Returns the first organization search index in the ordered set where searchvalue = &#63;.
	 *
	 * @param searchvalue the searchvalue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization search index, or <code>null</code> if a matching organization search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex fetchByExactSearch_First(
		String searchvalue, OrderByComparator orderByComparator)
		throws SystemException {
		List<OrganizationSearchIndex> list = findByExactSearch(searchvalue, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization search index in the ordered set where searchvalue = &#63;.
	 *
	 * @param searchvalue the searchvalue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization search index
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a matching organization search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex findByExactSearch_Last(String searchvalue,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationSearchIndexException, SystemException {
		OrganizationSearchIndex organizationSearchIndex = fetchByExactSearch_Last(searchvalue,
				orderByComparator);

		if (organizationSearchIndex != null) {
			return organizationSearchIndex;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("searchvalue=");
		msg.append(searchvalue);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationSearchIndexException(msg.toString());
	}

	/**
	 * Returns the last organization search index in the ordered set where searchvalue = &#63;.
	 *
	 * @param searchvalue the searchvalue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization search index, or <code>null</code> if a matching organization search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex fetchByExactSearch_Last(String searchvalue,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByExactSearch(searchvalue);

		if (count == 0) {
			return null;
		}

		List<OrganizationSearchIndex> list = findByExactSearch(searchvalue,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization search indexs before and after the current organization search index in the ordered set where searchvalue = &#63;.
	 *
	 * @param searchid the primary key of the current organization search index
	 * @param searchvalue the searchvalue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization search index
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a organization search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex[] findByExactSearch_PrevAndNext(
		long searchid, String searchvalue, OrderByComparator orderByComparator)
		throws NoSuchOrganizationSearchIndexException, SystemException {
		OrganizationSearchIndex organizationSearchIndex = findByPrimaryKey(searchid);

		Session session = null;

		try {
			session = openSession();

			OrganizationSearchIndex[] array = new OrganizationSearchIndexImpl[3];

			array[0] = getByExactSearch_PrevAndNext(session,
					organizationSearchIndex, searchvalue, orderByComparator,
					true);

			array[1] = organizationSearchIndex;

			array[2] = getByExactSearch_PrevAndNext(session,
					organizationSearchIndex, searchvalue, orderByComparator,
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

	protected OrganizationSearchIndex getByExactSearch_PrevAndNext(
		Session session, OrganizationSearchIndex organizationSearchIndex,
		String searchvalue, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATIONSEARCHINDEX_WHERE);

		boolean bindSearchvalue = false;

		if (searchvalue == null) {
			query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHVALUE_1);
		}
		else if (searchvalue.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHVALUE_3);
		}
		else {
			bindSearchvalue = true;

			query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHVALUE_2);
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
			query.append(OrganizationSearchIndexModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSearchvalue) {
			qPos.add(searchvalue);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organizationSearchIndex);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OrganizationSearchIndex> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization search indexs where searchvalue = &#63; from the database.
	 *
	 * @param searchvalue the searchvalue
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByExactSearch(String searchvalue)
		throws SystemException {
		for (OrganizationSearchIndex organizationSearchIndex : findByExactSearch(
				searchvalue, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(organizationSearchIndex);
		}
	}

	/**
	 * Returns the number of organization search indexs where searchvalue = &#63;.
	 *
	 * @param searchvalue the searchvalue
	 * @return the number of matching organization search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByExactSearch(String searchvalue) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EXACTSEARCH;

		Object[] finderArgs = new Object[] { searchvalue };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGANIZATIONSEARCHINDEX_WHERE);

			boolean bindSearchvalue = false;

			if (searchvalue == null) {
				query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHVALUE_1);
			}
			else if (searchvalue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHVALUE_3);
			}
			else {
				bindSearchvalue = true;

				query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHVALUE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSearchvalue) {
					qPos.add(searchvalue);
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

	private static final String _FINDER_COLUMN_EXACTSEARCH_SEARCHVALUE_1 = "organizationSearchIndex.searchvalue IS NULL";
	private static final String _FINDER_COLUMN_EXACTSEARCH_SEARCHVALUE_2 = "organizationSearchIndex.searchvalue = ?";
	private static final String _FINDER_COLUMN_EXACTSEARCH_SEARCHVALUE_3 = "(organizationSearchIndex.searchvalue IS NULL OR organizationSearchIndex.searchvalue = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_KEYANDORGANIZATION = new FinderPath(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationSearchIndexModelImpl.FINDER_CACHE_ENABLED,
			OrganizationSearchIndexImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByKeyAndOrganization",
			new String[] { Long.class.getName(), String.class.getName() },
			OrganizationSearchIndexModelImpl.ORGANISATIONID_COLUMN_BITMASK |
			OrganizationSearchIndexModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KEYANDORGANIZATION = new FinderPath(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationSearchIndexModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByKeyAndOrganization",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the organization search index where organisationid = &#63; and key = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException} if it could not be found.
	 *
	 * @param organisationid the organisationid
	 * @param key the key
	 * @return the matching organization search index
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a matching organization search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex findByKeyAndOrganization(
		long organisationid, String key)
		throws NoSuchOrganizationSearchIndexException, SystemException {
		OrganizationSearchIndex organizationSearchIndex = fetchByKeyAndOrganization(organisationid,
				key);

		if (organizationSearchIndex == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("organisationid=");
			msg.append(organisationid);

			msg.append(", key=");
			msg.append(key);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrganizationSearchIndexException(msg.toString());
		}

		return organizationSearchIndex;
	}

	/**
	 * Returns the organization search index where organisationid = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organisationid the organisationid
	 * @param key the key
	 * @return the matching organization search index, or <code>null</code> if a matching organization search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex fetchByKeyAndOrganization(
		long organisationid, String key) throws SystemException {
		return fetchByKeyAndOrganization(organisationid, key, true);
	}

	/**
	 * Returns the organization search index where organisationid = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organisationid the organisationid
	 * @param key the key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching organization search index, or <code>null</code> if a matching organization search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex fetchByKeyAndOrganization(
		long organisationid, String key, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { organisationid, key };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KEYANDORGANIZATION,
					finderArgs, this);
		}

		if (result instanceof OrganizationSearchIndex) {
			OrganizationSearchIndex organizationSearchIndex = (OrganizationSearchIndex)result;

			if ((organisationid != organizationSearchIndex.getOrganisationid()) ||
					!Validator.equals(key, organizationSearchIndex.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ORGANIZATIONSEARCHINDEX_WHERE);

			query.append(_FINDER_COLUMN_KEYANDORGANIZATION_ORGANISATIONID_2);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_KEYANDORGANIZATION_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEYANDORGANIZATION_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEYANDORGANIZATION_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationid);

				if (bindKey) {
					qPos.add(key);
				}

				List<OrganizationSearchIndex> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDORGANIZATION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"OrganizationSearchIndexPersistenceImpl.fetchByKeyAndOrganization(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					OrganizationSearchIndex organizationSearchIndex = list.get(0);

					result = organizationSearchIndex;

					cacheResult(organizationSearchIndex);

					if ((organizationSearchIndex.getOrganisationid() != organisationid) ||
							(organizationSearchIndex.getKey() == null) ||
							!organizationSearchIndex.getKey().equals(key)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDORGANIZATION,
							finderArgs, organizationSearchIndex);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEYANDORGANIZATION,
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
			return (OrganizationSearchIndex)result;
		}
	}

	/**
	 * Removes the organization search index where organisationid = &#63; and key = &#63; from the database.
	 *
	 * @param organisationid the organisationid
	 * @param key the key
	 * @return the organization search index that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex removeByKeyAndOrganization(
		long organisationid, String key)
		throws NoSuchOrganizationSearchIndexException, SystemException {
		OrganizationSearchIndex organizationSearchIndex = findByKeyAndOrganization(organisationid,
				key);

		return remove(organizationSearchIndex);
	}

	/**
	 * Returns the number of organization search indexs where organisationid = &#63; and key = &#63;.
	 *
	 * @param organisationid the organisationid
	 * @param key the key
	 * @return the number of matching organization search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByKeyAndOrganization(long organisationid, String key)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_KEYANDORGANIZATION;

		Object[] finderArgs = new Object[] { organisationid, key };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ORGANIZATIONSEARCHINDEX_WHERE);

			query.append(_FINDER_COLUMN_KEYANDORGANIZATION_ORGANISATIONID_2);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_KEYANDORGANIZATION_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEYANDORGANIZATION_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEYANDORGANIZATION_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationid);

				if (bindKey) {
					qPos.add(key);
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

	private static final String _FINDER_COLUMN_KEYANDORGANIZATION_ORGANISATIONID_2 =
		"organizationSearchIndex.organisationid = ? AND ";
	private static final String _FINDER_COLUMN_KEYANDORGANIZATION_KEY_1 = "organizationSearchIndex.key IS NULL";
	private static final String _FINDER_COLUMN_KEYANDORGANIZATION_KEY_2 = "organizationSearchIndex.key = ?";
	private static final String _FINDER_COLUMN_KEYANDORGANIZATION_KEY_3 = "(organizationSearchIndex.key IS NULL OR organizationSearchIndex.key = '')";

	public OrganizationSearchIndexPersistenceImpl() {
		setModelClass(OrganizationSearchIndex.class);
	}

	/**
	 * Caches the organization search index in the entity cache if it is enabled.
	 *
	 * @param organizationSearchIndex the organization search index
	 */
	@Override
	public void cacheResult(OrganizationSearchIndex organizationSearchIndex) {
		EntityCacheUtil.putResult(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationSearchIndexImpl.class,
			organizationSearchIndex.getPrimaryKey(), organizationSearchIndex);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDORGANIZATION,
			new Object[] {
				organizationSearchIndex.getOrganisationid(),
				organizationSearchIndex.getKey()
			}, organizationSearchIndex);

		organizationSearchIndex.resetOriginalValues();
	}

	/**
	 * Caches the organization search indexs in the entity cache if it is enabled.
	 *
	 * @param organizationSearchIndexs the organization search indexs
	 */
	@Override
	public void cacheResult(
		List<OrganizationSearchIndex> organizationSearchIndexs) {
		for (OrganizationSearchIndex organizationSearchIndex : organizationSearchIndexs) {
			if (EntityCacheUtil.getResult(
						OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationSearchIndexImpl.class,
						organizationSearchIndex.getPrimaryKey()) == null) {
				cacheResult(organizationSearchIndex);
			}
			else {
				organizationSearchIndex.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all organization search indexs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrganizationSearchIndexImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrganizationSearchIndexImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organization search index.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrganizationSearchIndex organizationSearchIndex) {
		EntityCacheUtil.removeResult(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationSearchIndexImpl.class,
			organizationSearchIndex.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(organizationSearchIndex);
	}

	@Override
	public void clearCache(
		List<OrganizationSearchIndex> organizationSearchIndexs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrganizationSearchIndex organizationSearchIndex : organizationSearchIndexs) {
			EntityCacheUtil.removeResult(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationSearchIndexImpl.class,
				organizationSearchIndex.getPrimaryKey());

			clearUniqueFindersCache(organizationSearchIndex);
		}
	}

	protected void cacheUniqueFindersCache(
		OrganizationSearchIndex organizationSearchIndex) {
		if (organizationSearchIndex.isNew()) {
			Object[] args = new Object[] {
					organizationSearchIndex.getOrganisationid(),
					organizationSearchIndex.getKey()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEYANDORGANIZATION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDORGANIZATION,
				args, organizationSearchIndex);
		}
		else {
			OrganizationSearchIndexModelImpl organizationSearchIndexModelImpl = (OrganizationSearchIndexModelImpl)organizationSearchIndex;

			if ((organizationSearchIndexModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_KEYANDORGANIZATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizationSearchIndex.getOrganisationid(),
						organizationSearchIndex.getKey()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEYANDORGANIZATION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDORGANIZATION,
					args, organizationSearchIndex);
			}
		}
	}

	protected void clearUniqueFindersCache(
		OrganizationSearchIndex organizationSearchIndex) {
		OrganizationSearchIndexModelImpl organizationSearchIndexModelImpl = (OrganizationSearchIndexModelImpl)organizationSearchIndex;

		Object[] args = new Object[] {
				organizationSearchIndex.getOrganisationid(),
				organizationSearchIndex.getKey()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEYANDORGANIZATION,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEYANDORGANIZATION,
			args);

		if ((organizationSearchIndexModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_KEYANDORGANIZATION.getColumnBitmask()) != 0) {
			args = new Object[] {
					organizationSearchIndexModelImpl.getOriginalOrganisationid(),
					organizationSearchIndexModelImpl.getOriginalKey()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEYANDORGANIZATION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEYANDORGANIZATION,
				args);
		}
	}

	/**
	 * Creates a new organization search index with the primary key. Does not add the organization search index to the database.
	 *
	 * @param searchid the primary key for the new organization search index
	 * @return the new organization search index
	 */
	@Override
	public OrganizationSearchIndex create(long searchid) {
		OrganizationSearchIndex organizationSearchIndex = new OrganizationSearchIndexImpl();

		organizationSearchIndex.setNew(true);
		organizationSearchIndex.setPrimaryKey(searchid);

		return organizationSearchIndex;
	}

	/**
	 * Removes the organization search index with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchid the primary key of the organization search index
	 * @return the organization search index that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a organization search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex remove(long searchid)
		throws NoSuchOrganizationSearchIndexException, SystemException {
		return remove((Serializable)searchid);
	}

	/**
	 * Removes the organization search index with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organization search index
	 * @return the organization search index that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a organization search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex remove(Serializable primaryKey)
		throws NoSuchOrganizationSearchIndexException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrganizationSearchIndex organizationSearchIndex = (OrganizationSearchIndex)session.get(OrganizationSearchIndexImpl.class,
					primaryKey);

			if (organizationSearchIndex == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationSearchIndexException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(organizationSearchIndex);
		}
		catch (NoSuchOrganizationSearchIndexException nsee) {
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
	protected OrganizationSearchIndex removeImpl(
		OrganizationSearchIndex organizationSearchIndex)
		throws SystemException {
		organizationSearchIndex = toUnwrappedModel(organizationSearchIndex);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organizationSearchIndex)) {
				organizationSearchIndex = (OrganizationSearchIndex)session.get(OrganizationSearchIndexImpl.class,
						organizationSearchIndex.getPrimaryKeyObj());
			}

			if (organizationSearchIndex != null) {
				session.delete(organizationSearchIndex);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (organizationSearchIndex != null) {
			clearCache(organizationSearchIndex);
		}

		return organizationSearchIndex;
	}

	@Override
	public OrganizationSearchIndex updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex organizationSearchIndex)
		throws SystemException {
		organizationSearchIndex = toUnwrappedModel(organizationSearchIndex);

		boolean isNew = organizationSearchIndex.isNew();

		OrganizationSearchIndexModelImpl organizationSearchIndexModelImpl = (OrganizationSearchIndexModelImpl)organizationSearchIndex;

		Session session = null;

		try {
			session = openSession();

			if (organizationSearchIndex.isNew()) {
				session.save(organizationSearchIndex);

				organizationSearchIndex.setNew(false);
			}
			else {
				session.merge(organizationSearchIndex);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrganizationSearchIndexModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((organizationSearchIndexModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXACTSEARCH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizationSearchIndexModelImpl.getOriginalSearchvalue()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXACTSEARCH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXACTSEARCH,
					args);

				args = new Object[] {
						organizationSearchIndexModelImpl.getSearchvalue()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXACTSEARCH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXACTSEARCH,
					args);
			}
		}

		EntityCacheUtil.putResult(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationSearchIndexImpl.class,
			organizationSearchIndex.getPrimaryKey(), organizationSearchIndex);

		clearUniqueFindersCache(organizationSearchIndex);
		cacheUniqueFindersCache(organizationSearchIndex);

		return organizationSearchIndex;
	}

	protected OrganizationSearchIndex toUnwrappedModel(
		OrganizationSearchIndex organizationSearchIndex) {
		if (organizationSearchIndex instanceof OrganizationSearchIndexImpl) {
			return organizationSearchIndex;
		}

		OrganizationSearchIndexImpl organizationSearchIndexImpl = new OrganizationSearchIndexImpl();

		organizationSearchIndexImpl.setNew(organizationSearchIndex.isNew());
		organizationSearchIndexImpl.setPrimaryKey(organizationSearchIndex.getPrimaryKey());

		organizationSearchIndexImpl.setSearchid(organizationSearchIndex.getSearchid());
		organizationSearchIndexImpl.setOrganisationid(organizationSearchIndex.getOrganisationid());
		organizationSearchIndexImpl.setLocationid(organizationSearchIndex.getLocationid());
		organizationSearchIndexImpl.setLocation(organizationSearchIndex.getLocation());
		organizationSearchIndexImpl.setKey(organizationSearchIndex.getKey());
		organizationSearchIndexImpl.setSearchvalue(organizationSearchIndex.getSearchvalue());

		return organizationSearchIndexImpl;
	}

	/**
	 * Returns the organization search index with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization search index
	 * @return the organization search index
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a organization search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationSearchIndexException, SystemException {
		OrganizationSearchIndex organizationSearchIndex = fetchByPrimaryKey(primaryKey);

		if (organizationSearchIndex == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationSearchIndexException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return organizationSearchIndex;
	}

	/**
	 * Returns the organization search index with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException} if it could not be found.
	 *
	 * @param searchid the primary key of the organization search index
	 * @return the organization search index
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a organization search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex findByPrimaryKey(long searchid)
		throws NoSuchOrganizationSearchIndexException, SystemException {
		return findByPrimaryKey((Serializable)searchid);
	}

	/**
	 * Returns the organization search index with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization search index
	 * @return the organization search index, or <code>null</code> if a organization search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OrganizationSearchIndex organizationSearchIndex = (OrganizationSearchIndex)EntityCacheUtil.getResult(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationSearchIndexImpl.class, primaryKey);

		if (organizationSearchIndex == _nullOrganizationSearchIndex) {
			return null;
		}

		if (organizationSearchIndex == null) {
			Session session = null;

			try {
				session = openSession();

				organizationSearchIndex = (OrganizationSearchIndex)session.get(OrganizationSearchIndexImpl.class,
						primaryKey);

				if (organizationSearchIndex != null) {
					cacheResult(organizationSearchIndex);
				}
				else {
					EntityCacheUtil.putResult(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationSearchIndexImpl.class, primaryKey,
						_nullOrganizationSearchIndex);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrganizationSearchIndexModelImpl.ENTITY_CACHE_ENABLED,
					OrganizationSearchIndexImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return organizationSearchIndex;
	}

	/**
	 * Returns the organization search index with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchid the primary key of the organization search index
	 * @return the organization search index, or <code>null</code> if a organization search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizationSearchIndex fetchByPrimaryKey(long searchid)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)searchid);
	}

	/**
	 * Returns all the organization search indexs.
	 *
	 * @return the organization search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizationSearchIndex> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization search indexs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization search indexs
	 * @param end the upper bound of the range of organization search indexs (not inclusive)
	 * @return the range of organization search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizationSearchIndex> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization search indexs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization search indexs
	 * @param end the upper bound of the range of organization search indexs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizationSearchIndex> findAll(int start, int end,
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

		List<OrganizationSearchIndex> list = (List<OrganizationSearchIndex>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORGANIZATIONSEARCHINDEX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATIONSEARCHINDEX;

				if (pagination) {
					sql = sql.concat(OrganizationSearchIndexModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OrganizationSearchIndex>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrganizationSearchIndex>(list);
				}
				else {
					list = (List<OrganizationSearchIndex>)QueryUtil.list(q,
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
	 * Removes all the organization search indexs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OrganizationSearchIndex organizationSearchIndex : findAll()) {
			remove(organizationSearchIndex);
		}
	}

	/**
	 * Returns the number of organization search indexs.
	 *
	 * @return the number of organization search indexs
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

				Query q = session.createQuery(_SQL_COUNT_ORGANIZATIONSEARCHINDEX);

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
	 * Initializes the organization search index persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrganizationSearchIndex>> listenersList = new ArrayList<ModelListener<OrganizationSearchIndex>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrganizationSearchIndex>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrganizationSearchIndexImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORGANIZATIONSEARCHINDEX = "SELECT organizationSearchIndex FROM OrganizationSearchIndex organizationSearchIndex";
	private static final String _SQL_SELECT_ORGANIZATIONSEARCHINDEX_WHERE = "SELECT organizationSearchIndex FROM OrganizationSearchIndex organizationSearchIndex WHERE ";
	private static final String _SQL_COUNT_ORGANIZATIONSEARCHINDEX = "SELECT COUNT(organizationSearchIndex) FROM OrganizationSearchIndex organizationSearchIndex";
	private static final String _SQL_COUNT_ORGANIZATIONSEARCHINDEX_WHERE = "SELECT COUNT(organizationSearchIndex) FROM OrganizationSearchIndex organizationSearchIndex WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "organizationSearchIndex.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrganizationSearchIndex exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OrganizationSearchIndex exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrganizationSearchIndexPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"key", "searchvalue"
			});
	private static OrganizationSearchIndex _nullOrganizationSearchIndex = new OrganizationSearchIndexImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OrganizationSearchIndex> toCacheModel() {
				return _nullOrganizationSearchIndexCacheModel;
			}
		};

	private static CacheModel<OrganizationSearchIndex> _nullOrganizationSearchIndexCacheModel =
		new CacheModel<OrganizationSearchIndex>() {
			@Override
			public OrganizationSearchIndex toEntityModel() {
				return _nullOrganizationSearchIndex;
			}
		};
}