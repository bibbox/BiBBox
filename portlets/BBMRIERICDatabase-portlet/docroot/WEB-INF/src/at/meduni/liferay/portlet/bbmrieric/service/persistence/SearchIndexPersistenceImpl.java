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

import at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException;
import at.meduni.liferay.portlet.bbmrieric.model.SearchIndex;
import at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexImpl;
import at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl;

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
 * The persistence implementation for the search index service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see SearchIndexPersistence
 * @see SearchIndexUtil
 * @generated
 */
public class SearchIndexPersistenceImpl extends BasePersistenceImpl<SearchIndex>
	implements SearchIndexPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SearchIndexUtil} to access the search index persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SearchIndexImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, SearchIndexImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, SearchIndexImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXACTSEARCH =
		new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, SearchIndexImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExactSearch",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXACTSEARCH =
		new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, SearchIndexImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExactSearch",
			new String[] { String.class.getName() },
			SearchIndexModelImpl.SEARCHINDEXVALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXACTSEARCH = new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExactSearch",
			new String[] { String.class.getName() });

	/**
	 * Returns all the search indexs where searchindexvalue = &#63;.
	 *
	 * @param searchindexvalue the searchindexvalue
	 * @return the matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> findByExactSearch(String searchindexvalue)
		throws SystemException {
		return findByExactSearch(searchindexvalue, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search indexs where searchindexvalue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param searchindexvalue the searchindexvalue
	 * @param start the lower bound of the range of search indexs
	 * @param end the upper bound of the range of search indexs (not inclusive)
	 * @return the range of matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> findByExactSearch(String searchindexvalue,
		int start, int end) throws SystemException {
		return findByExactSearch(searchindexvalue, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search indexs where searchindexvalue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param searchindexvalue the searchindexvalue
	 * @param start the lower bound of the range of search indexs
	 * @param end the upper bound of the range of search indexs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> findByExactSearch(String searchindexvalue,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXACTSEARCH;
			finderArgs = new Object[] { searchindexvalue };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EXACTSEARCH;
			finderArgs = new Object[] {
					searchindexvalue,
					
					start, end, orderByComparator
				};
		}

		List<SearchIndex> list = (List<SearchIndex>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchIndex searchIndex : list) {
				if (!Validator.equals(searchindexvalue,
							searchIndex.getSearchindexvalue())) {
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

			query.append(_SQL_SELECT_SEARCHINDEX_WHERE);

			boolean bindSearchindexvalue = false;

			if (searchindexvalue == null) {
				query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHINDEXVALUE_1);
			}
			else if (searchindexvalue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHINDEXVALUE_3);
			}
			else {
				bindSearchindexvalue = true;

				query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHINDEXVALUE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchIndexModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSearchindexvalue) {
					qPos.add(searchindexvalue);
				}

				if (!pagination) {
					list = (List<SearchIndex>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchIndex>(list);
				}
				else {
					list = (List<SearchIndex>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first search index in the ordered set where searchindexvalue = &#63;.
	 *
	 * @param searchindexvalue the searchindexvalue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search index
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex findByExactSearch_First(String searchindexvalue,
		OrderByComparator orderByComparator)
		throws NoSuchSearchIndexException, SystemException {
		SearchIndex searchIndex = fetchByExactSearch_First(searchindexvalue,
				orderByComparator);

		if (searchIndex != null) {
			return searchIndex;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("searchindexvalue=");
		msg.append(searchindexvalue);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchIndexException(msg.toString());
	}

	/**
	 * Returns the first search index in the ordered set where searchindexvalue = &#63;.
	 *
	 * @param searchindexvalue the searchindexvalue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search index, or <code>null</code> if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex fetchByExactSearch_First(String searchindexvalue,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchIndex> list = findByExactSearch(searchindexvalue, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search index in the ordered set where searchindexvalue = &#63;.
	 *
	 * @param searchindexvalue the searchindexvalue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search index
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex findByExactSearch_Last(String searchindexvalue,
		OrderByComparator orderByComparator)
		throws NoSuchSearchIndexException, SystemException {
		SearchIndex searchIndex = fetchByExactSearch_Last(searchindexvalue,
				orderByComparator);

		if (searchIndex != null) {
			return searchIndex;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("searchindexvalue=");
		msg.append(searchindexvalue);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchIndexException(msg.toString());
	}

	/**
	 * Returns the last search index in the ordered set where searchindexvalue = &#63;.
	 *
	 * @param searchindexvalue the searchindexvalue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search index, or <code>null</code> if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex fetchByExactSearch_Last(String searchindexvalue,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByExactSearch(searchindexvalue);

		if (count == 0) {
			return null;
		}

		List<SearchIndex> list = findByExactSearch(searchindexvalue, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search indexs before and after the current search index in the ordered set where searchindexvalue = &#63;.
	 *
	 * @param searchid the primary key of the current search index
	 * @param searchindexvalue the searchindexvalue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search index
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex[] findByExactSearch_PrevAndNext(long searchid,
		String searchindexvalue, OrderByComparator orderByComparator)
		throws NoSuchSearchIndexException, SystemException {
		SearchIndex searchIndex = findByPrimaryKey(searchid);

		Session session = null;

		try {
			session = openSession();

			SearchIndex[] array = new SearchIndexImpl[3];

			array[0] = getByExactSearch_PrevAndNext(session, searchIndex,
					searchindexvalue, orderByComparator, true);

			array[1] = searchIndex;

			array[2] = getByExactSearch_PrevAndNext(session, searchIndex,
					searchindexvalue, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchIndex getByExactSearch_PrevAndNext(Session session,
		SearchIndex searchIndex, String searchindexvalue,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHINDEX_WHERE);

		boolean bindSearchindexvalue = false;

		if (searchindexvalue == null) {
			query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHINDEXVALUE_1);
		}
		else if (searchindexvalue.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHINDEXVALUE_3);
		}
		else {
			bindSearchindexvalue = true;

			query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHINDEXVALUE_2);
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
			query.append(SearchIndexModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSearchindexvalue) {
			qPos.add(searchindexvalue);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchIndex);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchIndex> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search indexs where searchindexvalue = &#63; from the database.
	 *
	 * @param searchindexvalue the searchindexvalue
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByExactSearch(String searchindexvalue)
		throws SystemException {
		for (SearchIndex searchIndex : findByExactSearch(searchindexvalue,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchIndex);
		}
	}

	/**
	 * Returns the number of search indexs where searchindexvalue = &#63;.
	 *
	 * @param searchindexvalue the searchindexvalue
	 * @return the number of matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByExactSearch(String searchindexvalue)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EXACTSEARCH;

		Object[] finderArgs = new Object[] { searchindexvalue };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHINDEX_WHERE);

			boolean bindSearchindexvalue = false;

			if (searchindexvalue == null) {
				query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHINDEXVALUE_1);
			}
			else if (searchindexvalue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHINDEXVALUE_3);
			}
			else {
				bindSearchindexvalue = true;

				query.append(_FINDER_COLUMN_EXACTSEARCH_SEARCHINDEXVALUE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSearchindexvalue) {
					qPos.add(searchindexvalue);
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

	private static final String _FINDER_COLUMN_EXACTSEARCH_SEARCHINDEXVALUE_1 = "searchIndex.searchindexvalue IS NULL";
	private static final String _FINDER_COLUMN_EXACTSEARCH_SEARCHINDEXVALUE_2 = "searchIndex.searchindexvalue = ?";
	private static final String _FINDER_COLUMN_EXACTSEARCH_SEARCHINDEXVALUE_3 = "(searchIndex.searchindexvalue IS NULL OR searchIndex.searchindexvalue = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHINDEXBYORGANIZATION =
		new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, SearchIndexImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySearchIndexByOrganization",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHINDEXBYORGANIZATION =
		new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, SearchIndexImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySearchIndexByOrganization",
			new String[] { Long.class.getName() },
			SearchIndexModelImpl.ORGANISATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEARCHINDEXBYORGANIZATION =
		new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySearchIndexByOrganization",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the search indexs where organisationid = &#63;.
	 *
	 * @param organisationid the organisationid
	 * @return the matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> findBySearchIndexByOrganization(
		long organisationid) throws SystemException {
		return findBySearchIndexByOrganization(organisationid,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search indexs where organisationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationid the organisationid
	 * @param start the lower bound of the range of search indexs
	 * @param end the upper bound of the range of search indexs (not inclusive)
	 * @return the range of matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> findBySearchIndexByOrganization(
		long organisationid, int start, int end) throws SystemException {
		return findBySearchIndexByOrganization(organisationid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search indexs where organisationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationid the organisationid
	 * @param start the lower bound of the range of search indexs
	 * @param end the upper bound of the range of search indexs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> findBySearchIndexByOrganization(
		long organisationid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHINDEXBYORGANIZATION;
			finderArgs = new Object[] { organisationid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHINDEXBYORGANIZATION;
			finderArgs = new Object[] {
					organisationid,
					
					start, end, orderByComparator
				};
		}

		List<SearchIndex> list = (List<SearchIndex>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchIndex searchIndex : list) {
				if ((organisationid != searchIndex.getOrganisationid())) {
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

			query.append(_SQL_SELECT_SEARCHINDEX_WHERE);

			query.append(_FINDER_COLUMN_SEARCHINDEXBYORGANIZATION_ORGANISATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchIndexModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationid);

				if (!pagination) {
					list = (List<SearchIndex>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchIndex>(list);
				}
				else {
					list = (List<SearchIndex>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first search index in the ordered set where organisationid = &#63;.
	 *
	 * @param organisationid the organisationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search index
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex findBySearchIndexByOrganization_First(
		long organisationid, OrderByComparator orderByComparator)
		throws NoSuchSearchIndexException, SystemException {
		SearchIndex searchIndex = fetchBySearchIndexByOrganization_First(organisationid,
				orderByComparator);

		if (searchIndex != null) {
			return searchIndex;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organisationid=");
		msg.append(organisationid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchIndexException(msg.toString());
	}

	/**
	 * Returns the first search index in the ordered set where organisationid = &#63;.
	 *
	 * @param organisationid the organisationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search index, or <code>null</code> if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex fetchBySearchIndexByOrganization_First(
		long organisationid, OrderByComparator orderByComparator)
		throws SystemException {
		List<SearchIndex> list = findBySearchIndexByOrganization(organisationid,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search index in the ordered set where organisationid = &#63;.
	 *
	 * @param organisationid the organisationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search index
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex findBySearchIndexByOrganization_Last(
		long organisationid, OrderByComparator orderByComparator)
		throws NoSuchSearchIndexException, SystemException {
		SearchIndex searchIndex = fetchBySearchIndexByOrganization_Last(organisationid,
				orderByComparator);

		if (searchIndex != null) {
			return searchIndex;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organisationid=");
		msg.append(organisationid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchIndexException(msg.toString());
	}

	/**
	 * Returns the last search index in the ordered set where organisationid = &#63;.
	 *
	 * @param organisationid the organisationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search index, or <code>null</code> if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex fetchBySearchIndexByOrganization_Last(
		long organisationid, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBySearchIndexByOrganization(organisationid);

		if (count == 0) {
			return null;
		}

		List<SearchIndex> list = findBySearchIndexByOrganization(organisationid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search indexs before and after the current search index in the ordered set where organisationid = &#63;.
	 *
	 * @param searchid the primary key of the current search index
	 * @param organisationid the organisationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search index
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex[] findBySearchIndexByOrganization_PrevAndNext(
		long searchid, long organisationid, OrderByComparator orderByComparator)
		throws NoSuchSearchIndexException, SystemException {
		SearchIndex searchIndex = findByPrimaryKey(searchid);

		Session session = null;

		try {
			session = openSession();

			SearchIndex[] array = new SearchIndexImpl[3];

			array[0] = getBySearchIndexByOrganization_PrevAndNext(session,
					searchIndex, organisationid, orderByComparator, true);

			array[1] = searchIndex;

			array[2] = getBySearchIndexByOrganization_PrevAndNext(session,
					searchIndex, organisationid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchIndex getBySearchIndexByOrganization_PrevAndNext(
		Session session, SearchIndex searchIndex, long organisationid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHINDEX_WHERE);

		query.append(_FINDER_COLUMN_SEARCHINDEXBYORGANIZATION_ORGANISATIONID_2);

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
			query.append(SearchIndexModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organisationid);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchIndex);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchIndex> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search indexs where organisationid = &#63; from the database.
	 *
	 * @param organisationid the organisationid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySearchIndexByOrganization(long organisationid)
		throws SystemException {
		for (SearchIndex searchIndex : findBySearchIndexByOrganization(
				organisationid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchIndex);
		}
	}

	/**
	 * Returns the number of search indexs where organisationid = &#63;.
	 *
	 * @param organisationid the organisationid
	 * @return the number of matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySearchIndexByOrganization(long organisationid)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEARCHINDEXBYORGANIZATION;

		Object[] finderArgs = new Object[] { organisationid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHINDEX_WHERE);

			query.append(_FINDER_COLUMN_SEARCHINDEXBYORGANIZATION_ORGANISATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationid);

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

	private static final String _FINDER_COLUMN_SEARCHINDEXBYORGANIZATION_ORGANISATIONID_2 =
		"searchIndex.organisationid = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_SEARCHINDEX = new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, SearchIndexImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySearchIndex",
			new String[] { Long.class.getName(), String.class.getName() },
			SearchIndexModelImpl.ORGANISATIONID_COLUMN_BITMASK |
			SearchIndexModelImpl.SEARCHINDEXKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEARCHINDEX = new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySearchIndex",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the search index where organisationid = &#63; and searchindexkey = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException} if it could not be found.
	 *
	 * @param organisationid the organisationid
	 * @param searchindexkey the searchindexkey
	 * @return the matching search index
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex findBySearchIndex(long organisationid,
		String searchindexkey)
		throws NoSuchSearchIndexException, SystemException {
		SearchIndex searchIndex = fetchBySearchIndex(organisationid,
				searchindexkey);

		if (searchIndex == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("organisationid=");
			msg.append(organisationid);

			msg.append(", searchindexkey=");
			msg.append(searchindexkey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSearchIndexException(msg.toString());
		}

		return searchIndex;
	}

	/**
	 * Returns the search index where organisationid = &#63; and searchindexkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organisationid the organisationid
	 * @param searchindexkey the searchindexkey
	 * @return the matching search index, or <code>null</code> if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex fetchBySearchIndex(long organisationid,
		String searchindexkey) throws SystemException {
		return fetchBySearchIndex(organisationid, searchindexkey, true);
	}

	/**
	 * Returns the search index where organisationid = &#63; and searchindexkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organisationid the organisationid
	 * @param searchindexkey the searchindexkey
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching search index, or <code>null</code> if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex fetchBySearchIndex(long organisationid,
		String searchindexkey, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { organisationid, searchindexkey };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SEARCHINDEX,
					finderArgs, this);
		}

		if (result instanceof SearchIndex) {
			SearchIndex searchIndex = (SearchIndex)result;

			if ((organisationid != searchIndex.getOrganisationid()) ||
					!Validator.equals(searchindexkey,
						searchIndex.getSearchindexkey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SEARCHINDEX_WHERE);

			query.append(_FINDER_COLUMN_SEARCHINDEX_ORGANISATIONID_2);

			boolean bindSearchindexkey = false;

			if (searchindexkey == null) {
				query.append(_FINDER_COLUMN_SEARCHINDEX_SEARCHINDEXKEY_1);
			}
			else if (searchindexkey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SEARCHINDEX_SEARCHINDEXKEY_3);
			}
			else {
				bindSearchindexkey = true;

				query.append(_FINDER_COLUMN_SEARCHINDEX_SEARCHINDEXKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationid);

				if (bindSearchindexkey) {
					qPos.add(searchindexkey);
				}

				List<SearchIndex> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHINDEX,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SearchIndexPersistenceImpl.fetchBySearchIndex(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SearchIndex searchIndex = list.get(0);

					result = searchIndex;

					cacheResult(searchIndex);

					if ((searchIndex.getOrganisationid() != organisationid) ||
							(searchIndex.getSearchindexkey() == null) ||
							!searchIndex.getSearchindexkey()
											.equals(searchindexkey)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHINDEX,
							finderArgs, searchIndex);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHINDEX,
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
			return (SearchIndex)result;
		}
	}

	/**
	 * Removes the search index where organisationid = &#63; and searchindexkey = &#63; from the database.
	 *
	 * @param organisationid the organisationid
	 * @param searchindexkey the searchindexkey
	 * @return the search index that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex removeBySearchIndex(long organisationid,
		String searchindexkey)
		throws NoSuchSearchIndexException, SystemException {
		SearchIndex searchIndex = findBySearchIndex(organisationid,
				searchindexkey);

		return remove(searchIndex);
	}

	/**
	 * Returns the number of search indexs where organisationid = &#63; and searchindexkey = &#63;.
	 *
	 * @param organisationid the organisationid
	 * @param searchindexkey the searchindexkey
	 * @return the number of matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySearchIndex(long organisationid, String searchindexkey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEARCHINDEX;

		Object[] finderArgs = new Object[] { organisationid, searchindexkey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SEARCHINDEX_WHERE);

			query.append(_FINDER_COLUMN_SEARCHINDEX_ORGANISATIONID_2);

			boolean bindSearchindexkey = false;

			if (searchindexkey == null) {
				query.append(_FINDER_COLUMN_SEARCHINDEX_SEARCHINDEXKEY_1);
			}
			else if (searchindexkey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SEARCHINDEX_SEARCHINDEXKEY_3);
			}
			else {
				bindSearchindexkey = true;

				query.append(_FINDER_COLUMN_SEARCHINDEX_SEARCHINDEXKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationid);

				if (bindSearchindexkey) {
					qPos.add(searchindexkey);
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

	private static final String _FINDER_COLUMN_SEARCHINDEX_ORGANISATIONID_2 = "searchIndex.organisationid = ? AND ";
	private static final String _FINDER_COLUMN_SEARCHINDEX_SEARCHINDEXKEY_1 = "searchIndex.searchindexkey IS NULL";
	private static final String _FINDER_COLUMN_SEARCHINDEX_SEARCHINDEXKEY_2 = "searchIndex.searchindexkey = ?";
	private static final String _FINDER_COLUMN_SEARCHINDEX_SEARCHINDEXKEY_3 = "(searchIndex.searchindexkey IS NULL OR searchIndex.searchindexkey = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTUUID = new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, SearchIndexImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNotUUID",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTUUID = new FinderPath(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNotUUID",
			new String[] { String.class.getName() });

	/**
	 * Returns all the search indexs where UUID &ne; &#63;.
	 *
	 * @param UUID the u u i d
	 * @return the matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> findByNotUUID(String UUID)
		throws SystemException {
		return findByNotUUID(UUID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search indexs where UUID &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param UUID the u u i d
	 * @param start the lower bound of the range of search indexs
	 * @param end the upper bound of the range of search indexs (not inclusive)
	 * @return the range of matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> findByNotUUID(String UUID, int start, int end)
		throws SystemException {
		return findByNotUUID(UUID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search indexs where UUID &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param UUID the u u i d
	 * @param start the lower bound of the range of search indexs
	 * @param end the upper bound of the range of search indexs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> findByNotUUID(String UUID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTUUID;
		finderArgs = new Object[] { UUID, start, end, orderByComparator };

		List<SearchIndex> list = (List<SearchIndex>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchIndex searchIndex : list) {
				if (Validator.equals(UUID, searchIndex.getUUID())) {
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

			query.append(_SQL_SELECT_SEARCHINDEX_WHERE);

			boolean bindUUID = false;

			if (UUID == null) {
				query.append(_FINDER_COLUMN_NOTUUID_UUID_1);
			}
			else if (UUID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTUUID_UUID_3);
			}
			else {
				bindUUID = true;

				query.append(_FINDER_COLUMN_NOTUUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchIndexModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUUID) {
					qPos.add(UUID);
				}

				if (!pagination) {
					list = (List<SearchIndex>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchIndex>(list);
				}
				else {
					list = (List<SearchIndex>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first search index in the ordered set where UUID &ne; &#63;.
	 *
	 * @param UUID the u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search index
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex findByNotUUID_First(String UUID,
		OrderByComparator orderByComparator)
		throws NoSuchSearchIndexException, SystemException {
		SearchIndex searchIndex = fetchByNotUUID_First(UUID, orderByComparator);

		if (searchIndex != null) {
			return searchIndex;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("UUID=");
		msg.append(UUID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchIndexException(msg.toString());
	}

	/**
	 * Returns the first search index in the ordered set where UUID &ne; &#63;.
	 *
	 * @param UUID the u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search index, or <code>null</code> if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex fetchByNotUUID_First(String UUID,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchIndex> list = findByNotUUID(UUID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search index in the ordered set where UUID &ne; &#63;.
	 *
	 * @param UUID the u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search index
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex findByNotUUID_Last(String UUID,
		OrderByComparator orderByComparator)
		throws NoSuchSearchIndexException, SystemException {
		SearchIndex searchIndex = fetchByNotUUID_Last(UUID, orderByComparator);

		if (searchIndex != null) {
			return searchIndex;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("UUID=");
		msg.append(UUID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchIndexException(msg.toString());
	}

	/**
	 * Returns the last search index in the ordered set where UUID &ne; &#63;.
	 *
	 * @param UUID the u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search index, or <code>null</code> if a matching search index could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex fetchByNotUUID_Last(String UUID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNotUUID(UUID);

		if (count == 0) {
			return null;
		}

		List<SearchIndex> list = findByNotUUID(UUID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search indexs before and after the current search index in the ordered set where UUID &ne; &#63;.
	 *
	 * @param searchid the primary key of the current search index
	 * @param UUID the u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search index
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex[] findByNotUUID_PrevAndNext(long searchid, String UUID,
		OrderByComparator orderByComparator)
		throws NoSuchSearchIndexException, SystemException {
		SearchIndex searchIndex = findByPrimaryKey(searchid);

		Session session = null;

		try {
			session = openSession();

			SearchIndex[] array = new SearchIndexImpl[3];

			array[0] = getByNotUUID_PrevAndNext(session, searchIndex, UUID,
					orderByComparator, true);

			array[1] = searchIndex;

			array[2] = getByNotUUID_PrevAndNext(session, searchIndex, UUID,
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

	protected SearchIndex getByNotUUID_PrevAndNext(Session session,
		SearchIndex searchIndex, String UUID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHINDEX_WHERE);

		boolean bindUUID = false;

		if (UUID == null) {
			query.append(_FINDER_COLUMN_NOTUUID_UUID_1);
		}
		else if (UUID.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NOTUUID_UUID_3);
		}
		else {
			bindUUID = true;

			query.append(_FINDER_COLUMN_NOTUUID_UUID_2);
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
			query.append(SearchIndexModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUUID) {
			qPos.add(UUID);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchIndex);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchIndex> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search indexs where UUID &ne; &#63; from the database.
	 *
	 * @param UUID the u u i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNotUUID(String UUID) throws SystemException {
		for (SearchIndex searchIndex : findByNotUUID(UUID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(searchIndex);
		}
	}

	/**
	 * Returns the number of search indexs where UUID &ne; &#63;.
	 *
	 * @param UUID the u u i d
	 * @return the number of matching search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNotUUID(String UUID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTUUID;

		Object[] finderArgs = new Object[] { UUID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHINDEX_WHERE);

			boolean bindUUID = false;

			if (UUID == null) {
				query.append(_FINDER_COLUMN_NOTUUID_UUID_1);
			}
			else if (UUID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTUUID_UUID_3);
			}
			else {
				bindUUID = true;

				query.append(_FINDER_COLUMN_NOTUUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUUID) {
					qPos.add(UUID);
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

	private static final String _FINDER_COLUMN_NOTUUID_UUID_1 = "searchIndex.UUID IS NOT NULL";
	private static final String _FINDER_COLUMN_NOTUUID_UUID_2 = "searchIndex.UUID != ?";
	private static final String _FINDER_COLUMN_NOTUUID_UUID_3 = "(searchIndex.UUID IS NULL OR searchIndex.UUID != '')";

	public SearchIndexPersistenceImpl() {
		setModelClass(SearchIndex.class);
	}

	/**
	 * Caches the search index in the entity cache if it is enabled.
	 *
	 * @param searchIndex the search index
	 */
	@Override
	public void cacheResult(SearchIndex searchIndex) {
		EntityCacheUtil.putResult(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexImpl.class, searchIndex.getPrimaryKey(), searchIndex);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHINDEX,
			new Object[] {
				searchIndex.getOrganisationid(), searchIndex.getSearchindexkey()
			}, searchIndex);

		searchIndex.resetOriginalValues();
	}

	/**
	 * Caches the search indexs in the entity cache if it is enabled.
	 *
	 * @param searchIndexs the search indexs
	 */
	@Override
	public void cacheResult(List<SearchIndex> searchIndexs) {
		for (SearchIndex searchIndex : searchIndexs) {
			if (EntityCacheUtil.getResult(
						SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
						SearchIndexImpl.class, searchIndex.getPrimaryKey()) == null) {
				cacheResult(searchIndex);
			}
			else {
				searchIndex.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all search indexs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SearchIndexImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SearchIndexImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the search index.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SearchIndex searchIndex) {
		EntityCacheUtil.removeResult(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexImpl.class, searchIndex.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(searchIndex);
	}

	@Override
	public void clearCache(List<SearchIndex> searchIndexs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SearchIndex searchIndex : searchIndexs) {
			EntityCacheUtil.removeResult(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
				SearchIndexImpl.class, searchIndex.getPrimaryKey());

			clearUniqueFindersCache(searchIndex);
		}
	}

	protected void cacheUniqueFindersCache(SearchIndex searchIndex) {
		if (searchIndex.isNew()) {
			Object[] args = new Object[] {
					searchIndex.getOrganisationid(),
					searchIndex.getSearchindexkey()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHINDEX, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHINDEX, args,
				searchIndex);
		}
		else {
			SearchIndexModelImpl searchIndexModelImpl = (SearchIndexModelImpl)searchIndex;

			if ((searchIndexModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SEARCHINDEX.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						searchIndex.getOrganisationid(),
						searchIndex.getSearchindexkey()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHINDEX,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHINDEX,
					args, searchIndex);
			}
		}
	}

	protected void clearUniqueFindersCache(SearchIndex searchIndex) {
		SearchIndexModelImpl searchIndexModelImpl = (SearchIndexModelImpl)searchIndex;

		Object[] args = new Object[] {
				searchIndex.getOrganisationid(), searchIndex.getSearchindexkey()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHINDEX, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHINDEX, args);

		if ((searchIndexModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SEARCHINDEX.getColumnBitmask()) != 0) {
			args = new Object[] {
					searchIndexModelImpl.getOriginalOrganisationid(),
					searchIndexModelImpl.getOriginalSearchindexkey()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHINDEX, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHINDEX, args);
		}
	}

	/**
	 * Creates a new search index with the primary key. Does not add the search index to the database.
	 *
	 * @param searchid the primary key for the new search index
	 * @return the new search index
	 */
	@Override
	public SearchIndex create(long searchid) {
		SearchIndex searchIndex = new SearchIndexImpl();

		searchIndex.setNew(true);
		searchIndex.setPrimaryKey(searchid);

		return searchIndex;
	}

	/**
	 * Removes the search index with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchid the primary key of the search index
	 * @return the search index that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex remove(long searchid)
		throws NoSuchSearchIndexException, SystemException {
		return remove((Serializable)searchid);
	}

	/**
	 * Removes the search index with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the search index
	 * @return the search index that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex remove(Serializable primaryKey)
		throws NoSuchSearchIndexException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SearchIndex searchIndex = (SearchIndex)session.get(SearchIndexImpl.class,
					primaryKey);

			if (searchIndex == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSearchIndexException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(searchIndex);
		}
		catch (NoSuchSearchIndexException nsee) {
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
	protected SearchIndex removeImpl(SearchIndex searchIndex)
		throws SystemException {
		searchIndex = toUnwrappedModel(searchIndex);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(searchIndex)) {
				searchIndex = (SearchIndex)session.get(SearchIndexImpl.class,
						searchIndex.getPrimaryKeyObj());
			}

			if (searchIndex != null) {
				session.delete(searchIndex);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (searchIndex != null) {
			clearCache(searchIndex);
		}

		return searchIndex;
	}

	@Override
	public SearchIndex updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.SearchIndex searchIndex)
		throws SystemException {
		searchIndex = toUnwrappedModel(searchIndex);

		boolean isNew = searchIndex.isNew();

		SearchIndexModelImpl searchIndexModelImpl = (SearchIndexModelImpl)searchIndex;

		Session session = null;

		try {
			session = openSession();

			if (searchIndex.isNew()) {
				session.save(searchIndex);

				searchIndex.setNew(false);
			}
			else {
				session.merge(searchIndex);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SearchIndexModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((searchIndexModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXACTSEARCH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						searchIndexModelImpl.getOriginalSearchindexvalue()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXACTSEARCH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXACTSEARCH,
					args);

				args = new Object[] { searchIndexModelImpl.getSearchindexvalue() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXACTSEARCH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXACTSEARCH,
					args);
			}

			if ((searchIndexModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHINDEXBYORGANIZATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						searchIndexModelImpl.getOriginalOrganisationid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHINDEXBYORGANIZATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHINDEXBYORGANIZATION,
					args);

				args = new Object[] { searchIndexModelImpl.getOrganisationid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHINDEXBYORGANIZATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHINDEXBYORGANIZATION,
					args);
			}
		}

		EntityCacheUtil.putResult(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
			SearchIndexImpl.class, searchIndex.getPrimaryKey(), searchIndex);

		clearUniqueFindersCache(searchIndex);
		cacheUniqueFindersCache(searchIndex);

		return searchIndex;
	}

	protected SearchIndex toUnwrappedModel(SearchIndex searchIndex) {
		if (searchIndex instanceof SearchIndexImpl) {
			return searchIndex;
		}

		SearchIndexImpl searchIndexImpl = new SearchIndexImpl();

		searchIndexImpl.setNew(searchIndex.isNew());
		searchIndexImpl.setPrimaryKey(searchIndex.getPrimaryKey());

		searchIndexImpl.setSearchid(searchIndex.getSearchid());
		searchIndexImpl.setOrganisationid(searchIndex.getOrganisationid());
		searchIndexImpl.setLocationid(searchIndex.getLocationid());
		searchIndexImpl.setLocation(searchIndex.getLocation());
		searchIndexImpl.setSearchindexkey(searchIndex.getSearchindexkey());
		searchIndexImpl.setSearchindexvalue(searchIndex.getSearchindexvalue());
		searchIndexImpl.setUUID(searchIndex.getUUID());

		return searchIndexImpl;
	}

	/**
	 * Returns the search index with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the search index
	 * @return the search index
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSearchIndexException, SystemException {
		SearchIndex searchIndex = fetchByPrimaryKey(primaryKey);

		if (searchIndex == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSearchIndexException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return searchIndex;
	}

	/**
	 * Returns the search index with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException} if it could not be found.
	 *
	 * @param searchid the primary key of the search index
	 * @return the search index
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex findByPrimaryKey(long searchid)
		throws NoSuchSearchIndexException, SystemException {
		return findByPrimaryKey((Serializable)searchid);
	}

	/**
	 * Returns the search index with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the search index
	 * @return the search index, or <code>null</code> if a search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SearchIndex searchIndex = (SearchIndex)EntityCacheUtil.getResult(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
				SearchIndexImpl.class, primaryKey);

		if (searchIndex == _nullSearchIndex) {
			return null;
		}

		if (searchIndex == null) {
			Session session = null;

			try {
				session = openSession();

				searchIndex = (SearchIndex)session.get(SearchIndexImpl.class,
						primaryKey);

				if (searchIndex != null) {
					cacheResult(searchIndex);
				}
				else {
					EntityCacheUtil.putResult(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
						SearchIndexImpl.class, primaryKey, _nullSearchIndex);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SearchIndexModelImpl.ENTITY_CACHE_ENABLED,
					SearchIndexImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return searchIndex;
	}

	/**
	 * Returns the search index with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchid the primary key of the search index
	 * @return the search index, or <code>null</code> if a search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex fetchByPrimaryKey(long searchid)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)searchid);
	}

	/**
	 * Returns all the search indexs.
	 *
	 * @return the search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search indexs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of search indexs
	 * @param end the upper bound of the range of search indexs (not inclusive)
	 * @return the range of search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the search indexs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of search indexs
	 * @param end the upper bound of the range of search indexs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> findAll(int start, int end,
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

		List<SearchIndex> list = (List<SearchIndex>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEARCHINDEX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEARCHINDEX;

				if (pagination) {
					sql = sql.concat(SearchIndexModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SearchIndex>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchIndex>(list);
				}
				else {
					list = (List<SearchIndex>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the search indexs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SearchIndex searchIndex : findAll()) {
			remove(searchIndex);
		}
	}

	/**
	 * Returns the number of search indexs.
	 *
	 * @return the number of search indexs
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

				Query q = session.createQuery(_SQL_COUNT_SEARCHINDEX);

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
	 * Initializes the search index persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.bbmrieric.model.SearchIndex")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SearchIndex>> listenersList = new ArrayList<ModelListener<SearchIndex>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SearchIndex>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SearchIndexImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SEARCHINDEX = "SELECT searchIndex FROM SearchIndex searchIndex";
	private static final String _SQL_SELECT_SEARCHINDEX_WHERE = "SELECT searchIndex FROM SearchIndex searchIndex WHERE ";
	private static final String _SQL_COUNT_SEARCHINDEX = "SELECT COUNT(searchIndex) FROM SearchIndex searchIndex";
	private static final String _SQL_COUNT_SEARCHINDEX_WHERE = "SELECT COUNT(searchIndex) FROM SearchIndex searchIndex WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "searchIndex.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SearchIndex exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SearchIndex exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SearchIndexPersistenceImpl.class);
	private static SearchIndex _nullSearchIndex = new SearchIndexImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SearchIndex> toCacheModel() {
				return _nullSearchIndexCacheModel;
			}
		};

	private static CacheModel<SearchIndex> _nullSearchIndexCacheModel = new CacheModel<SearchIndex>() {
			@Override
			public SearchIndex toEntityModel() {
				return _nullSearchIndex;
			}
		};
}