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

package at.meduni.liferay.portlet.rdconnect.service.persistence;

import at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException;
import at.meduni.liferay.portlet.rdconnect.model.MasterCandidate;
import at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateImpl;
import at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateModelImpl;

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
import com.liferay.portal.kernel.util.CharPool;
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
 * The persistence implementation for the master candidate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see MasterCandidatePersistence
 * @see MasterCandidateUtil
 * @generated
 */
public class MasterCandidatePersistenceImpl extends BasePersistenceImpl<MasterCandidate>
	implements MasterCandidatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MasterCandidateUtil} to access the master candidate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MasterCandidateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateModelImpl.FINDER_CACHE_ENABLED,
			MasterCandidateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateModelImpl.FINDER_CACHE_ENABLED,
			MasterCandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CNST = new FinderPath(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateModelImpl.FINDER_CACHE_ENABLED,
			MasterCandidateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCNST",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CNST = new FinderPath(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCNST",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the master candidates where country LIKE &#63; and name LIKE &#63; and candidatetype LIKE &#63;.
	 *
	 * @param country the country
	 * @param name the name
	 * @param candidatetype the candidatetype
	 * @return the matching master candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterCandidate> findByCNST(String country, String name,
		String candidatetype) throws SystemException {
		return findByCNST(country, name, candidatetype, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master candidates where country LIKE &#63; and name LIKE &#63; and candidatetype LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param country the country
	 * @param name the name
	 * @param candidatetype the candidatetype
	 * @param start the lower bound of the range of master candidates
	 * @param end the upper bound of the range of master candidates (not inclusive)
	 * @return the range of matching master candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterCandidate> findByCNST(String country, String name,
		String candidatetype, int start, int end) throws SystemException {
		return findByCNST(country, name, candidatetype, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master candidates where country LIKE &#63; and name LIKE &#63; and candidatetype LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param country the country
	 * @param name the name
	 * @param candidatetype the candidatetype
	 * @param start the lower bound of the range of master candidates
	 * @param end the upper bound of the range of master candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterCandidate> findByCNST(String country, String name,
		String candidatetype, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CNST;
		finderArgs = new Object[] {
				country, name, candidatetype,
				
				start, end, orderByComparator
			};

		List<MasterCandidate> list = (List<MasterCandidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasterCandidate masterCandidate : list) {
				if (!StringUtil.wildcardMatches(masterCandidate.getCountry(),
							country, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false) ||
						!StringUtil.wildcardMatches(masterCandidate.getName(),
							name, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false) ||
						!StringUtil.wildcardMatches(
							masterCandidate.getCandidatetype(), candidatetype,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_MASTERCANDIDATE_WHERE);

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_CNST_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CNST_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_CNST_COUNTRY_2);
			}

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_CNST_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CNST_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CNST_NAME_2);
			}

			boolean bindCandidatetype = false;

			if (candidatetype == null) {
				query.append(_FINDER_COLUMN_CNST_CANDIDATETYPE_1);
			}
			else if (candidatetype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CNST_CANDIDATETYPE_3);
			}
			else {
				bindCandidatetype = true;

				query.append(_FINDER_COLUMN_CNST_CANDIDATETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasterCandidateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountry) {
					qPos.add(country.toLowerCase());
				}

				if (bindName) {
					qPos.add(name.toLowerCase());
				}

				if (bindCandidatetype) {
					qPos.add(candidatetype.toLowerCase());
				}

				if (!pagination) {
					list = (List<MasterCandidate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterCandidate>(list);
				}
				else {
					list = (List<MasterCandidate>)QueryUtil.list(q,
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
	 * Returns the first master candidate in the ordered set where country LIKE &#63; and name LIKE &#63; and candidatetype LIKE &#63;.
	 *
	 * @param country the country
	 * @param name the name
	 * @param candidatetype the candidatetype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException if a matching master candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate findByCNST_First(String country, String name,
		String candidatetype, OrderByComparator orderByComparator)
		throws NoSuchMasterCandidateException, SystemException {
		MasterCandidate masterCandidate = fetchByCNST_First(country, name,
				candidatetype, orderByComparator);

		if (masterCandidate != null) {
			return masterCandidate;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("country=");
		msg.append(country);

		msg.append(", name=");
		msg.append(name);

		msg.append(", candidatetype=");
		msg.append(candidatetype);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterCandidateException(msg.toString());
	}

	/**
	 * Returns the first master candidate in the ordered set where country LIKE &#63; and name LIKE &#63; and candidatetype LIKE &#63;.
	 *
	 * @param country the country
	 * @param name the name
	 * @param candidatetype the candidatetype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master candidate, or <code>null</code> if a matching master candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate fetchByCNST_First(String country, String name,
		String candidatetype, OrderByComparator orderByComparator)
		throws SystemException {
		List<MasterCandidate> list = findByCNST(country, name, candidatetype,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master candidate in the ordered set where country LIKE &#63; and name LIKE &#63; and candidatetype LIKE &#63;.
	 *
	 * @param country the country
	 * @param name the name
	 * @param candidatetype the candidatetype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException if a matching master candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate findByCNST_Last(String country, String name,
		String candidatetype, OrderByComparator orderByComparator)
		throws NoSuchMasterCandidateException, SystemException {
		MasterCandidate masterCandidate = fetchByCNST_Last(country, name,
				candidatetype, orderByComparator);

		if (masterCandidate != null) {
			return masterCandidate;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("country=");
		msg.append(country);

		msg.append(", name=");
		msg.append(name);

		msg.append(", candidatetype=");
		msg.append(candidatetype);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterCandidateException(msg.toString());
	}

	/**
	 * Returns the last master candidate in the ordered set where country LIKE &#63; and name LIKE &#63; and candidatetype LIKE &#63;.
	 *
	 * @param country the country
	 * @param name the name
	 * @param candidatetype the candidatetype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master candidate, or <code>null</code> if a matching master candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate fetchByCNST_Last(String country, String name,
		String candidatetype, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCNST(country, name, candidatetype);

		if (count == 0) {
			return null;
		}

		List<MasterCandidate> list = findByCNST(country, name, candidatetype,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master candidates before and after the current master candidate in the ordered set where country LIKE &#63; and name LIKE &#63; and candidatetype LIKE &#63;.
	 *
	 * @param masterCandidateId the primary key of the current master candidate
	 * @param country the country
	 * @param name the name
	 * @param candidatetype the candidatetype
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException if a master candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate[] findByCNST_PrevAndNext(long masterCandidateId,
		String country, String name, String candidatetype,
		OrderByComparator orderByComparator)
		throws NoSuchMasterCandidateException, SystemException {
		MasterCandidate masterCandidate = findByPrimaryKey(masterCandidateId);

		Session session = null;

		try {
			session = openSession();

			MasterCandidate[] array = new MasterCandidateImpl[3];

			array[0] = getByCNST_PrevAndNext(session, masterCandidate, country,
					name, candidatetype, orderByComparator, true);

			array[1] = masterCandidate;

			array[2] = getByCNST_PrevAndNext(session, masterCandidate, country,
					name, candidatetype, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterCandidate getByCNST_PrevAndNext(Session session,
		MasterCandidate masterCandidate, String country, String name,
		String candidatetype, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASTERCANDIDATE_WHERE);

		boolean bindCountry = false;

		if (country == null) {
			query.append(_FINDER_COLUMN_CNST_COUNTRY_1);
		}
		else if (country.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CNST_COUNTRY_3);
		}
		else {
			bindCountry = true;

			query.append(_FINDER_COLUMN_CNST_COUNTRY_2);
		}

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_CNST_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CNST_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_CNST_NAME_2);
		}

		boolean bindCandidatetype = false;

		if (candidatetype == null) {
			query.append(_FINDER_COLUMN_CNST_CANDIDATETYPE_1);
		}
		else if (candidatetype.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CNST_CANDIDATETYPE_3);
		}
		else {
			bindCandidatetype = true;

			query.append(_FINDER_COLUMN_CNST_CANDIDATETYPE_2);
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
			query.append(MasterCandidateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCountry) {
			qPos.add(country.toLowerCase());
		}

		if (bindName) {
			qPos.add(name.toLowerCase());
		}

		if (bindCandidatetype) {
			qPos.add(candidatetype.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masterCandidate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasterCandidate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master candidates where country LIKE &#63; and name LIKE &#63; and candidatetype LIKE &#63; from the database.
	 *
	 * @param country the country
	 * @param name the name
	 * @param candidatetype the candidatetype
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCNST(String country, String name, String candidatetype)
		throws SystemException {
		for (MasterCandidate masterCandidate : findByCNST(country, name,
				candidatetype, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(masterCandidate);
		}
	}

	/**
	 * Returns the number of master candidates where country LIKE &#63; and name LIKE &#63; and candidatetype LIKE &#63;.
	 *
	 * @param country the country
	 * @param name the name
	 * @param candidatetype the candidatetype
	 * @return the number of matching master candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCNST(String country, String name, String candidatetype)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CNST;

		Object[] finderArgs = new Object[] { country, name, candidatetype };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_MASTERCANDIDATE_WHERE);

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_CNST_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CNST_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_CNST_COUNTRY_2);
			}

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_CNST_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CNST_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_CNST_NAME_2);
			}

			boolean bindCandidatetype = false;

			if (candidatetype == null) {
				query.append(_FINDER_COLUMN_CNST_CANDIDATETYPE_1);
			}
			else if (candidatetype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CNST_CANDIDATETYPE_3);
			}
			else {
				bindCandidatetype = true;

				query.append(_FINDER_COLUMN_CNST_CANDIDATETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountry) {
					qPos.add(country.toLowerCase());
				}

				if (bindName) {
					qPos.add(name.toLowerCase());
				}

				if (bindCandidatetype) {
					qPos.add(candidatetype.toLowerCase());
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

	private static final String _FINDER_COLUMN_CNST_COUNTRY_1 = "masterCandidate.country LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CNST_COUNTRY_2 = "lower(masterCandidate.country) LIKE ? AND ";
	private static final String _FINDER_COLUMN_CNST_COUNTRY_3 = "(masterCandidate.country IS NULL OR masterCandidate.country LIKE '') AND ";
	private static final String _FINDER_COLUMN_CNST_NAME_1 = "masterCandidate.name LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CNST_NAME_2 = "lower(masterCandidate.name) LIKE ? AND ";
	private static final String _FINDER_COLUMN_CNST_NAME_3 = "(masterCandidate.name IS NULL OR masterCandidate.name LIKE '') AND ";
	private static final String _FINDER_COLUMN_CNST_CANDIDATETYPE_1 = "masterCandidate.candidatetype LIKE NULL";
	private static final String _FINDER_COLUMN_CNST_CANDIDATETYPE_2 = "lower(masterCandidate.candidatetype) LIKE ?";
	private static final String _FINDER_COLUMN_CNST_CANDIDATETYPE_3 = "(masterCandidate.candidatetype IS NULL OR masterCandidate.candidatetype LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRY = new FinderPath(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateModelImpl.FINDER_CACHE_ENABLED,
			MasterCandidateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountry",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY =
		new FinderPath(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateModelImpl.FINDER_CACHE_ENABLED,
			MasterCandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCountry",
			new String[] { String.class.getName() },
			MasterCandidateModelImpl.COUNTRY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRY = new FinderPath(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCountry",
			new String[] { String.class.getName() });

	/**
	 * Returns all the master candidates where country = &#63;.
	 *
	 * @param country the country
	 * @return the matching master candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterCandidate> findByCountry(String country)
		throws SystemException {
		return findByCountry(country, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master candidates where country = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param country the country
	 * @param start the lower bound of the range of master candidates
	 * @param end the upper bound of the range of master candidates (not inclusive)
	 * @return the range of matching master candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterCandidate> findByCountry(String country, int start,
		int end) throws SystemException {
		return findByCountry(country, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master candidates where country = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param country the country
	 * @param start the lower bound of the range of master candidates
	 * @param end the upper bound of the range of master candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterCandidate> findByCountry(String country, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY;
			finderArgs = new Object[] { country };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRY;
			finderArgs = new Object[] { country, start, end, orderByComparator };
		}

		List<MasterCandidate> list = (List<MasterCandidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasterCandidate masterCandidate : list) {
				if (!Validator.equals(country, masterCandidate.getCountry())) {
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

			query.append(_SQL_SELECT_MASTERCANDIDATE_WHERE);

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_COUNTRY_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRY_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_COUNTRY_COUNTRY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasterCandidateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountry) {
					qPos.add(country);
				}

				if (!pagination) {
					list = (List<MasterCandidate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterCandidate>(list);
				}
				else {
					list = (List<MasterCandidate>)QueryUtil.list(q,
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
	 * Returns the first master candidate in the ordered set where country = &#63;.
	 *
	 * @param country the country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException if a matching master candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate findByCountry_First(String country,
		OrderByComparator orderByComparator)
		throws NoSuchMasterCandidateException, SystemException {
		MasterCandidate masterCandidate = fetchByCountry_First(country,
				orderByComparator);

		if (masterCandidate != null) {
			return masterCandidate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("country=");
		msg.append(country);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterCandidateException(msg.toString());
	}

	/**
	 * Returns the first master candidate in the ordered set where country = &#63;.
	 *
	 * @param country the country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master candidate, or <code>null</code> if a matching master candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate fetchByCountry_First(String country,
		OrderByComparator orderByComparator) throws SystemException {
		List<MasterCandidate> list = findByCountry(country, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master candidate in the ordered set where country = &#63;.
	 *
	 * @param country the country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException if a matching master candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate findByCountry_Last(String country,
		OrderByComparator orderByComparator)
		throws NoSuchMasterCandidateException, SystemException {
		MasterCandidate masterCandidate = fetchByCountry_Last(country,
				orderByComparator);

		if (masterCandidate != null) {
			return masterCandidate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("country=");
		msg.append(country);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterCandidateException(msg.toString());
	}

	/**
	 * Returns the last master candidate in the ordered set where country = &#63;.
	 *
	 * @param country the country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master candidate, or <code>null</code> if a matching master candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate fetchByCountry_Last(String country,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCountry(country);

		if (count == 0) {
			return null;
		}

		List<MasterCandidate> list = findByCountry(country, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master candidates before and after the current master candidate in the ordered set where country = &#63;.
	 *
	 * @param masterCandidateId the primary key of the current master candidate
	 * @param country the country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException if a master candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate[] findByCountry_PrevAndNext(long masterCandidateId,
		String country, OrderByComparator orderByComparator)
		throws NoSuchMasterCandidateException, SystemException {
		MasterCandidate masterCandidate = findByPrimaryKey(masterCandidateId);

		Session session = null;

		try {
			session = openSession();

			MasterCandidate[] array = new MasterCandidateImpl[3];

			array[0] = getByCountry_PrevAndNext(session, masterCandidate,
					country, orderByComparator, true);

			array[1] = masterCandidate;

			array[2] = getByCountry_PrevAndNext(session, masterCandidate,
					country, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterCandidate getByCountry_PrevAndNext(Session session,
		MasterCandidate masterCandidate, String country,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASTERCANDIDATE_WHERE);

		boolean bindCountry = false;

		if (country == null) {
			query.append(_FINDER_COLUMN_COUNTRY_COUNTRY_1);
		}
		else if (country.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COUNTRY_COUNTRY_3);
		}
		else {
			bindCountry = true;

			query.append(_FINDER_COLUMN_COUNTRY_COUNTRY_2);
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
			query.append(MasterCandidateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCountry) {
			qPos.add(country);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masterCandidate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasterCandidate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master candidates where country = &#63; from the database.
	 *
	 * @param country the country
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountry(String country) throws SystemException {
		for (MasterCandidate masterCandidate : findByCountry(country,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(masterCandidate);
		}
	}

	/**
	 * Returns the number of master candidates where country = &#63;.
	 *
	 * @param country the country
	 * @return the number of matching master candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountry(String country) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRY;

		Object[] finderArgs = new Object[] { country };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MASTERCANDIDATE_WHERE);

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_COUNTRY_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRY_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_COUNTRY_COUNTRY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountry) {
					qPos.add(country);
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

	private static final String _FINDER_COLUMN_COUNTRY_COUNTRY_1 = "masterCandidate.country IS NULL";
	private static final String _FINDER_COLUMN_COUNTRY_COUNTRY_2 = "masterCandidate.country = ?";
	private static final String _FINDER_COLUMN_COUNTRY_COUNTRY_3 = "(masterCandidate.country IS NULL OR masterCandidate.country = '')";

	public MasterCandidatePersistenceImpl() {
		setModelClass(MasterCandidate.class);
	}

	/**
	 * Caches the master candidate in the entity cache if it is enabled.
	 *
	 * @param masterCandidate the master candidate
	 */
	@Override
	public void cacheResult(MasterCandidate masterCandidate) {
		EntityCacheUtil.putResult(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateImpl.class, masterCandidate.getPrimaryKey(),
			masterCandidate);

		masterCandidate.resetOriginalValues();
	}

	/**
	 * Caches the master candidates in the entity cache if it is enabled.
	 *
	 * @param masterCandidates the master candidates
	 */
	@Override
	public void cacheResult(List<MasterCandidate> masterCandidates) {
		for (MasterCandidate masterCandidate : masterCandidates) {
			if (EntityCacheUtil.getResult(
						MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
						MasterCandidateImpl.class,
						masterCandidate.getPrimaryKey()) == null) {
				cacheResult(masterCandidate);
			}
			else {
				masterCandidate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all master candidates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MasterCandidateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MasterCandidateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master candidate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterCandidate masterCandidate) {
		EntityCacheUtil.removeResult(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateImpl.class, masterCandidate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MasterCandidate> masterCandidates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MasterCandidate masterCandidate : masterCandidates) {
			EntityCacheUtil.removeResult(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
				MasterCandidateImpl.class, masterCandidate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new master candidate with the primary key. Does not add the master candidate to the database.
	 *
	 * @param masterCandidateId the primary key for the new master candidate
	 * @return the new master candidate
	 */
	@Override
	public MasterCandidate create(long masterCandidateId) {
		MasterCandidate masterCandidate = new MasterCandidateImpl();

		masterCandidate.setNew(true);
		masterCandidate.setPrimaryKey(masterCandidateId);

		return masterCandidate;
	}

	/**
	 * Removes the master candidate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterCandidateId the primary key of the master candidate
	 * @return the master candidate that was removed
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException if a master candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate remove(long masterCandidateId)
		throws NoSuchMasterCandidateException, SystemException {
		return remove((Serializable)masterCandidateId);
	}

	/**
	 * Removes the master candidate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master candidate
	 * @return the master candidate that was removed
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException if a master candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate remove(Serializable primaryKey)
		throws NoSuchMasterCandidateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MasterCandidate masterCandidate = (MasterCandidate)session.get(MasterCandidateImpl.class,
					primaryKey);

			if (masterCandidate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterCandidateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(masterCandidate);
		}
		catch (NoSuchMasterCandidateException nsee) {
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
	protected MasterCandidate removeImpl(MasterCandidate masterCandidate)
		throws SystemException {
		masterCandidate = toUnwrappedModel(masterCandidate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterCandidate)) {
				masterCandidate = (MasterCandidate)session.get(MasterCandidateImpl.class,
						masterCandidate.getPrimaryKeyObj());
			}

			if (masterCandidate != null) {
				session.delete(masterCandidate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (masterCandidate != null) {
			clearCache(masterCandidate);
		}

		return masterCandidate;
	}

	@Override
	public MasterCandidate updateImpl(
		at.meduni.liferay.portlet.rdconnect.model.MasterCandidate masterCandidate)
		throws SystemException {
		masterCandidate = toUnwrappedModel(masterCandidate);

		boolean isNew = masterCandidate.isNew();

		MasterCandidateModelImpl masterCandidateModelImpl = (MasterCandidateModelImpl)masterCandidate;

		Session session = null;

		try {
			session = openSession();

			if (masterCandidate.isNew()) {
				session.save(masterCandidate);

				masterCandidate.setNew(false);
			}
			else {
				session.merge(masterCandidate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MasterCandidateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((masterCandidateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterCandidateModelImpl.getOriginalCountry()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY,
					args);

				args = new Object[] { masterCandidateModelImpl.getCountry() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY,
					args);
			}
		}

		EntityCacheUtil.putResult(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateImpl.class, masterCandidate.getPrimaryKey(),
			masterCandidate);

		return masterCandidate;
	}

	protected MasterCandidate toUnwrappedModel(MasterCandidate masterCandidate) {
		if (masterCandidate instanceof MasterCandidateImpl) {
			return masterCandidate;
		}

		MasterCandidateImpl masterCandidateImpl = new MasterCandidateImpl();

		masterCandidateImpl.setNew(masterCandidate.isNew());
		masterCandidateImpl.setPrimaryKey(masterCandidate.getPrimaryKey());

		masterCandidateImpl.setMasterCandidateId(masterCandidate.getMasterCandidateId());
		masterCandidateImpl.setName(masterCandidate.getName());
		masterCandidateImpl.setUrl(masterCandidate.getUrl());
		masterCandidateImpl.setContactperson(masterCandidate.getContactperson());
		masterCandidateImpl.setCandidatetype(masterCandidate.getCandidatetype());
		masterCandidateImpl.setCountry(masterCandidate.getCountry());
		masterCandidateImpl.setDiseasescodes(masterCandidate.getDiseasescodes());
		masterCandidateImpl.setDiseasesfreetext(masterCandidate.getDiseasesfreetext());
		masterCandidateImpl.setComment(masterCandidate.getComment());
		masterCandidateImpl.setAddress(masterCandidate.getAddress());
		masterCandidateImpl.setDate(masterCandidate.getDate());
		masterCandidateImpl.setMail(masterCandidate.getMail());
		masterCandidateImpl.setHead(masterCandidate.getHead());
		masterCandidateImpl.setGroupid(masterCandidate.getGroupid());
		masterCandidateImpl.setCompanyid(masterCandidate.getCompanyid());

		return masterCandidateImpl;
	}

	/**
	 * Returns the master candidate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the master candidate
	 * @return the master candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException if a master candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterCandidateException, SystemException {
		MasterCandidate masterCandidate = fetchByPrimaryKey(primaryKey);

		if (masterCandidate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterCandidateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return masterCandidate;
	}

	/**
	 * Returns the master candidate with the primary key or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException} if it could not be found.
	 *
	 * @param masterCandidateId the primary key of the master candidate
	 * @return the master candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException if a master candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate findByPrimaryKey(long masterCandidateId)
		throws NoSuchMasterCandidateException, SystemException {
		return findByPrimaryKey((Serializable)masterCandidateId);
	}

	/**
	 * Returns the master candidate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master candidate
	 * @return the master candidate, or <code>null</code> if a master candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MasterCandidate masterCandidate = (MasterCandidate)EntityCacheUtil.getResult(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
				MasterCandidateImpl.class, primaryKey);

		if (masterCandidate == _nullMasterCandidate) {
			return null;
		}

		if (masterCandidate == null) {
			Session session = null;

			try {
				session = openSession();

				masterCandidate = (MasterCandidate)session.get(MasterCandidateImpl.class,
						primaryKey);

				if (masterCandidate != null) {
					cacheResult(masterCandidate);
				}
				else {
					EntityCacheUtil.putResult(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
						MasterCandidateImpl.class, primaryKey,
						_nullMasterCandidate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MasterCandidateModelImpl.ENTITY_CACHE_ENABLED,
					MasterCandidateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return masterCandidate;
	}

	/**
	 * Returns the master candidate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterCandidateId the primary key of the master candidate
	 * @return the master candidate, or <code>null</code> if a master candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidate fetchByPrimaryKey(long masterCandidateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)masterCandidateId);
	}

	/**
	 * Returns all the master candidates.
	 *
	 * @return the master candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterCandidate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master candidates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of master candidates
	 * @param end the upper bound of the range of master candidates (not inclusive)
	 * @return the range of master candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterCandidate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master candidates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of master candidates
	 * @param end the upper bound of the range of master candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterCandidate> findAll(int start, int end,
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

		List<MasterCandidate> list = (List<MasterCandidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MASTERCANDIDATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERCANDIDATE;

				if (pagination) {
					sql = sql.concat(MasterCandidateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MasterCandidate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterCandidate>(list);
				}
				else {
					list = (List<MasterCandidate>)QueryUtil.list(q,
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
	 * Removes all the master candidates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MasterCandidate masterCandidate : findAll()) {
			remove(masterCandidate);
		}
	}

	/**
	 * Returns the number of master candidates.
	 *
	 * @return the number of master candidates
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

				Query q = session.createQuery(_SQL_COUNT_MASTERCANDIDATE);

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
	 * Initializes the master candidate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.rdconnect.model.MasterCandidate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MasterCandidate>> listenersList = new ArrayList<ModelListener<MasterCandidate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MasterCandidate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MasterCandidateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MASTERCANDIDATE = "SELECT masterCandidate FROM MasterCandidate masterCandidate";
	private static final String _SQL_SELECT_MASTERCANDIDATE_WHERE = "SELECT masterCandidate FROM MasterCandidate masterCandidate WHERE ";
	private static final String _SQL_COUNT_MASTERCANDIDATE = "SELECT COUNT(masterCandidate) FROM MasterCandidate masterCandidate";
	private static final String _SQL_COUNT_MASTERCANDIDATE_WHERE = "SELECT COUNT(masterCandidate) FROM MasterCandidate masterCandidate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "masterCandidate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MasterCandidate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MasterCandidate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MasterCandidatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"comment", "date"
			});
	private static MasterCandidate _nullMasterCandidate = new MasterCandidateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MasterCandidate> toCacheModel() {
				return _nullMasterCandidateCacheModel;
			}
		};

	private static CacheModel<MasterCandidate> _nullMasterCandidateCacheModel = new CacheModel<MasterCandidate>() {
			@Override
			public MasterCandidate toEntityModel() {
				return _nullMasterCandidate;
			}
		};
}