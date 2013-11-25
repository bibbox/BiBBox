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

import at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException;
import at.meduni.liferay.portlet.rdconnect.model.Candidate;
import at.meduni.liferay.portlet.rdconnect.model.impl.CandidateImpl;
import at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl;

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
 * The persistence implementation for the candidate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see CandidatePersistence
 * @see CandidateUtil
 * @generated
 */
public class CandidatePersistenceImpl extends BasePersistenceImpl<Candidate>
	implements CandidatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CandidateUtil} to access the candidate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CandidateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CNST = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCNST",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CNST = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCNST",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the candidates where country LIKE &#63; and name LIKE &#63; and source LIKE &#63; and candidatetype LIKE &#63; and subunitof = &#63;.
	 *
	 * @param country the country
	 * @param name the name
	 * @param source the source
	 * @param candidatetype the candidatetype
	 * @param subunitof the subunitof
	 * @return the matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findByCNST(String country, String name,
		String source, String candidatetype, String subunitof)
		throws SystemException {
		return findByCNST(country, name, source, candidatetype, subunitof,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidates where country LIKE &#63; and name LIKE &#63; and source LIKE &#63; and candidatetype LIKE &#63; and subunitof = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param country the country
	 * @param name the name
	 * @param source the source
	 * @param candidatetype the candidatetype
	 * @param subunitof the subunitof
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @return the range of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findByCNST(String country, String name,
		String source, String candidatetype, String subunitof, int start,
		int end) throws SystemException {
		return findByCNST(country, name, source, candidatetype, subunitof,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidates where country LIKE &#63; and name LIKE &#63; and source LIKE &#63; and candidatetype LIKE &#63; and subunitof = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param country the country
	 * @param name the name
	 * @param source the source
	 * @param candidatetype the candidatetype
	 * @param subunitof the subunitof
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findByCNST(String country, String name,
		String source, String candidatetype, String subunitof, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CNST;
		finderArgs = new Object[] {
				country, name, source, candidatetype, subunitof,
				
				start, end, orderByComparator
			};

		List<Candidate> list = (List<Candidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Candidate candidate : list) {
				if (!StringUtil.wildcardMatches(candidate.getCountry(),
							country, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false) ||
						!StringUtil.wildcardMatches(candidate.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false) ||
						!StringUtil.wildcardMatches(candidate.getSource(),
							source, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false) ||
						!StringUtil.wildcardMatches(
							candidate.getCandidatetype(), candidatetype,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false) ||
						!Validator.equals(subunitof, candidate.getSubunitof())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_CANDIDATE_WHERE);

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

			boolean bindSource = false;

			if (source == null) {
				query.append(_FINDER_COLUMN_CNST_SOURCE_1);
			}
			else if (source.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CNST_SOURCE_3);
			}
			else {
				bindSource = true;

				query.append(_FINDER_COLUMN_CNST_SOURCE_2);
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

			boolean bindSubunitof = false;

			if (subunitof == null) {
				query.append(_FINDER_COLUMN_CNST_SUBUNITOF_1);
			}
			else if (subunitof.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CNST_SUBUNITOF_3);
			}
			else {
				bindSubunitof = true;

				query.append(_FINDER_COLUMN_CNST_SUBUNITOF_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateModelImpl.ORDER_BY_JPQL);
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

				if (bindSource) {
					qPos.add(source.toLowerCase());
				}

				if (bindCandidatetype) {
					qPos.add(candidatetype.toLowerCase());
				}

				if (bindSubunitof) {
					qPos.add(subunitof);
				}

				if (!pagination) {
					list = (List<Candidate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Candidate>(list);
				}
				else {
					list = (List<Candidate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first candidate in the ordered set where country LIKE &#63; and name LIKE &#63; and source LIKE &#63; and candidatetype LIKE &#63; and subunitof = &#63;.
	 *
	 * @param country the country
	 * @param name the name
	 * @param source the source
	 * @param candidatetype the candidatetype
	 * @param subunitof the subunitof
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findByCNST_First(String country, String name,
		String source, String candidatetype, String subunitof,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = fetchByCNST_First(country, name, source,
				candidatetype, subunitof, orderByComparator);

		if (candidate != null) {
			return candidate;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("country=");
		msg.append(country);

		msg.append(", name=");
		msg.append(name);

		msg.append(", source=");
		msg.append(source);

		msg.append(", candidatetype=");
		msg.append(candidatetype);

		msg.append(", subunitof=");
		msg.append(subunitof);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateException(msg.toString());
	}

	/**
	 * Returns the first candidate in the ordered set where country LIKE &#63; and name LIKE &#63; and source LIKE &#63; and candidatetype LIKE &#63; and subunitof = &#63;.
	 *
	 * @param country the country
	 * @param name the name
	 * @param source the source
	 * @param candidatetype the candidatetype
	 * @param subunitof the subunitof
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate, or <code>null</code> if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByCNST_First(String country, String name,
		String source, String candidatetype, String subunitof,
		OrderByComparator orderByComparator) throws SystemException {
		List<Candidate> list = findByCNST(country, name, source, candidatetype,
				subunitof, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate in the ordered set where country LIKE &#63; and name LIKE &#63; and source LIKE &#63; and candidatetype LIKE &#63; and subunitof = &#63;.
	 *
	 * @param country the country
	 * @param name the name
	 * @param source the source
	 * @param candidatetype the candidatetype
	 * @param subunitof the subunitof
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findByCNST_Last(String country, String name,
		String source, String candidatetype, String subunitof,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = fetchByCNST_Last(country, name, source,
				candidatetype, subunitof, orderByComparator);

		if (candidate != null) {
			return candidate;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("country=");
		msg.append(country);

		msg.append(", name=");
		msg.append(name);

		msg.append(", source=");
		msg.append(source);

		msg.append(", candidatetype=");
		msg.append(candidatetype);

		msg.append(", subunitof=");
		msg.append(subunitof);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateException(msg.toString());
	}

	/**
	 * Returns the last candidate in the ordered set where country LIKE &#63; and name LIKE &#63; and source LIKE &#63; and candidatetype LIKE &#63; and subunitof = &#63;.
	 *
	 * @param country the country
	 * @param name the name
	 * @param source the source
	 * @param candidatetype the candidatetype
	 * @param subunitof the subunitof
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate, or <code>null</code> if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByCNST_Last(String country, String name,
		String source, String candidatetype, String subunitof,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCNST(country, name, source, candidatetype, subunitof);

		if (count == 0) {
			return null;
		}

		List<Candidate> list = findByCNST(country, name, source, candidatetype,
				subunitof, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidates before and after the current candidate in the ordered set where country LIKE &#63; and name LIKE &#63; and source LIKE &#63; and candidatetype LIKE &#63; and subunitof = &#63;.
	 *
	 * @param candidateId the primary key of the current candidate
	 * @param country the country
	 * @param name the name
	 * @param source the source
	 * @param candidatetype the candidatetype
	 * @param subunitof the subunitof
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate[] findByCNST_PrevAndNext(long candidateId, String country,
		String name, String source, String candidatetype, String subunitof,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = findByPrimaryKey(candidateId);

		Session session = null;

		try {
			session = openSession();

			Candidate[] array = new CandidateImpl[3];

			array[0] = getByCNST_PrevAndNext(session, candidate, country, name,
					source, candidatetype, subunitof, orderByComparator, true);

			array[1] = candidate;

			array[2] = getByCNST_PrevAndNext(session, candidate, country, name,
					source, candidatetype, subunitof, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Candidate getByCNST_PrevAndNext(Session session,
		Candidate candidate, String country, String name, String source,
		String candidatetype, String subunitof,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANDIDATE_WHERE);

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

		boolean bindSource = false;

		if (source == null) {
			query.append(_FINDER_COLUMN_CNST_SOURCE_1);
		}
		else if (source.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CNST_SOURCE_3);
		}
		else {
			bindSource = true;

			query.append(_FINDER_COLUMN_CNST_SOURCE_2);
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

		boolean bindSubunitof = false;

		if (subunitof == null) {
			query.append(_FINDER_COLUMN_CNST_SUBUNITOF_1);
		}
		else if (subunitof.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CNST_SUBUNITOF_3);
		}
		else {
			bindSubunitof = true;

			query.append(_FINDER_COLUMN_CNST_SUBUNITOF_2);
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
			query.append(CandidateModelImpl.ORDER_BY_JPQL);
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

		if (bindSource) {
			qPos.add(source.toLowerCase());
		}

		if (bindCandidatetype) {
			qPos.add(candidatetype.toLowerCase());
		}

		if (bindSubunitof) {
			qPos.add(subunitof);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Candidate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidates where country LIKE &#63; and name LIKE &#63; and source LIKE &#63; and candidatetype LIKE &#63; and subunitof = &#63; from the database.
	 *
	 * @param country the country
	 * @param name the name
	 * @param source the source
	 * @param candidatetype the candidatetype
	 * @param subunitof the subunitof
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCNST(String country, String name, String source,
		String candidatetype, String subunitof) throws SystemException {
		for (Candidate candidate : findByCNST(country, name, source,
				candidatetype, subunitof, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(candidate);
		}
	}

	/**
	 * Returns the number of candidates where country LIKE &#63; and name LIKE &#63; and source LIKE &#63; and candidatetype LIKE &#63; and subunitof = &#63;.
	 *
	 * @param country the country
	 * @param name the name
	 * @param source the source
	 * @param candidatetype the candidatetype
	 * @param subunitof the subunitof
	 * @return the number of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCNST(String country, String name, String source,
		String candidatetype, String subunitof) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CNST;

		Object[] finderArgs = new Object[] {
				country, name, source, candidatetype, subunitof
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_CANDIDATE_WHERE);

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

			boolean bindSource = false;

			if (source == null) {
				query.append(_FINDER_COLUMN_CNST_SOURCE_1);
			}
			else if (source.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CNST_SOURCE_3);
			}
			else {
				bindSource = true;

				query.append(_FINDER_COLUMN_CNST_SOURCE_2);
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

			boolean bindSubunitof = false;

			if (subunitof == null) {
				query.append(_FINDER_COLUMN_CNST_SUBUNITOF_1);
			}
			else if (subunitof.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CNST_SUBUNITOF_3);
			}
			else {
				bindSubunitof = true;

				query.append(_FINDER_COLUMN_CNST_SUBUNITOF_2);
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

				if (bindSource) {
					qPos.add(source.toLowerCase());
				}

				if (bindCandidatetype) {
					qPos.add(candidatetype.toLowerCase());
				}

				if (bindSubunitof) {
					qPos.add(subunitof);
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

	private static final String _FINDER_COLUMN_CNST_COUNTRY_1 = "candidate.country LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CNST_COUNTRY_2 = "lower(candidate.country) LIKE ? AND ";
	private static final String _FINDER_COLUMN_CNST_COUNTRY_3 = "(candidate.country IS NULL OR candidate.country LIKE '') AND ";
	private static final String _FINDER_COLUMN_CNST_NAME_1 = "candidate.name LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CNST_NAME_2 = "lower(candidate.name) LIKE ? AND ";
	private static final String _FINDER_COLUMN_CNST_NAME_3 = "(candidate.name IS NULL OR candidate.name LIKE '') AND ";
	private static final String _FINDER_COLUMN_CNST_SOURCE_1 = "candidate.source LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CNST_SOURCE_2 = "lower(candidate.source) LIKE ? AND ";
	private static final String _FINDER_COLUMN_CNST_SOURCE_3 = "(candidate.source IS NULL OR candidate.source LIKE '') AND ";
	private static final String _FINDER_COLUMN_CNST_CANDIDATETYPE_1 = "candidate.candidatetype LIKE NULL AND ";
	private static final String _FINDER_COLUMN_CNST_CANDIDATETYPE_2 = "lower(candidate.candidatetype) LIKE ? AND ";
	private static final String _FINDER_COLUMN_CNST_CANDIDATETYPE_3 = "(candidate.candidatetype IS NULL OR candidate.candidatetype LIKE '') AND ";
	private static final String _FINDER_COLUMN_CNST_SUBUNITOF_1 = "candidate.subunitof IS NULL";
	private static final String _FINDER_COLUMN_CNST_SUBUNITOF_2 = "candidate.subunitof = ?";
	private static final String _FINDER_COLUMN_CNST_SUBUNITOF_3 = "(candidate.subunitof IS NULL OR candidate.subunitof = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBREMOVER =
		new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubRemover",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBREMOVER =
		new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySubRemover",
			new String[] { String.class.getName() },
			CandidateModelImpl.SUBUNITOF_COLUMN_BITMASK |
			CandidateModelImpl.COUNTRY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SUBREMOVER = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySubRemover",
			new String[] { String.class.getName() });

	/**
	 * Returns all the candidates where subunitof = &#63;.
	 *
	 * @param subunitof the subunitof
	 * @return the matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findBySubRemover(String subunitof)
		throws SystemException {
		return findBySubRemover(subunitof, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidates where subunitof = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param subunitof the subunitof
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @return the range of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findBySubRemover(String subunitof, int start, int end)
		throws SystemException {
		return findBySubRemover(subunitof, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidates where subunitof = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param subunitof the subunitof
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findBySubRemover(String subunitof, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBREMOVER;
			finderArgs = new Object[] { subunitof };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBREMOVER;
			finderArgs = new Object[] { subunitof, start, end, orderByComparator };
		}

		List<Candidate> list = (List<Candidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Candidate candidate : list) {
				if (!Validator.equals(subunitof, candidate.getSubunitof())) {
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

			query.append(_SQL_SELECT_CANDIDATE_WHERE);

			boolean bindSubunitof = false;

			if (subunitof == null) {
				query.append(_FINDER_COLUMN_SUBREMOVER_SUBUNITOF_1);
			}
			else if (subunitof.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUBREMOVER_SUBUNITOF_3);
			}
			else {
				bindSubunitof = true;

				query.append(_FINDER_COLUMN_SUBREMOVER_SUBUNITOF_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSubunitof) {
					qPos.add(subunitof);
				}

				if (!pagination) {
					list = (List<Candidate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Candidate>(list);
				}
				else {
					list = (List<Candidate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first candidate in the ordered set where subunitof = &#63;.
	 *
	 * @param subunitof the subunitof
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findBySubRemover_First(String subunitof,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = fetchBySubRemover_First(subunitof,
				orderByComparator);

		if (candidate != null) {
			return candidate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("subunitof=");
		msg.append(subunitof);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateException(msg.toString());
	}

	/**
	 * Returns the first candidate in the ordered set where subunitof = &#63;.
	 *
	 * @param subunitof the subunitof
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate, or <code>null</code> if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchBySubRemover_First(String subunitof,
		OrderByComparator orderByComparator) throws SystemException {
		List<Candidate> list = findBySubRemover(subunitof, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate in the ordered set where subunitof = &#63;.
	 *
	 * @param subunitof the subunitof
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findBySubRemover_Last(String subunitof,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = fetchBySubRemover_Last(subunitof,
				orderByComparator);

		if (candidate != null) {
			return candidate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("subunitof=");
		msg.append(subunitof);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateException(msg.toString());
	}

	/**
	 * Returns the last candidate in the ordered set where subunitof = &#63;.
	 *
	 * @param subunitof the subunitof
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate, or <code>null</code> if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchBySubRemover_Last(String subunitof,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySubRemover(subunitof);

		if (count == 0) {
			return null;
		}

		List<Candidate> list = findBySubRemover(subunitof, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidates before and after the current candidate in the ordered set where subunitof = &#63;.
	 *
	 * @param candidateId the primary key of the current candidate
	 * @param subunitof the subunitof
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate[] findBySubRemover_PrevAndNext(long candidateId,
		String subunitof, OrderByComparator orderByComparator)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = findByPrimaryKey(candidateId);

		Session session = null;

		try {
			session = openSession();

			Candidate[] array = new CandidateImpl[3];

			array[0] = getBySubRemover_PrevAndNext(session, candidate,
					subunitof, orderByComparator, true);

			array[1] = candidate;

			array[2] = getBySubRemover_PrevAndNext(session, candidate,
					subunitof, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Candidate getBySubRemover_PrevAndNext(Session session,
		Candidate candidate, String subunitof,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANDIDATE_WHERE);

		boolean bindSubunitof = false;

		if (subunitof == null) {
			query.append(_FINDER_COLUMN_SUBREMOVER_SUBUNITOF_1);
		}
		else if (subunitof.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SUBREMOVER_SUBUNITOF_3);
		}
		else {
			bindSubunitof = true;

			query.append(_FINDER_COLUMN_SUBREMOVER_SUBUNITOF_2);
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
			query.append(CandidateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSubunitof) {
			qPos.add(subunitof);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Candidate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidates where subunitof = &#63; from the database.
	 *
	 * @param subunitof the subunitof
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySubRemover(String subunitof) throws SystemException {
		for (Candidate candidate : findBySubRemover(subunitof,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidate);
		}
	}

	/**
	 * Returns the number of candidates where subunitof = &#63;.
	 *
	 * @param subunitof the subunitof
	 * @return the number of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySubRemover(String subunitof) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SUBREMOVER;

		Object[] finderArgs = new Object[] { subunitof };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATE_WHERE);

			boolean bindSubunitof = false;

			if (subunitof == null) {
				query.append(_FINDER_COLUMN_SUBREMOVER_SUBUNITOF_1);
			}
			else if (subunitof.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUBREMOVER_SUBUNITOF_3);
			}
			else {
				bindSubunitof = true;

				query.append(_FINDER_COLUMN_SUBREMOVER_SUBUNITOF_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSubunitof) {
					qPos.add(subunitof);
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

	private static final String _FINDER_COLUMN_SUBREMOVER_SUBUNITOF_1 = "candidate.subunitof IS NULL";
	private static final String _FINDER_COLUMN_SUBREMOVER_SUBUNITOF_2 = "candidate.subunitof = ?";
	private static final String _FINDER_COLUMN_SUBREMOVER_SUBUNITOF_3 = "(candidate.subunitof IS NULL OR candidate.subunitof = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRY = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCountry",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY =
		new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCountry",
			new String[] { String.class.getName() },
			CandidateModelImpl.COUNTRY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRY = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCountry",
			new String[] { String.class.getName() });

	/**
	 * Returns all the candidates where country = &#63;.
	 *
	 * @param country the country
	 * @return the matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findByCountry(String country)
		throws SystemException {
		return findByCountry(country, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidates where country = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param country the country
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @return the range of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findByCountry(String country, int start, int end)
		throws SystemException {
		return findByCountry(country, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidates where country = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param country the country
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findByCountry(String country, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Candidate> list = (List<Candidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Candidate candidate : list) {
				if (!Validator.equals(country, candidate.getCountry())) {
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

			query.append(_SQL_SELECT_CANDIDATE_WHERE);

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
				query.append(CandidateModelImpl.ORDER_BY_JPQL);
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
					list = (List<Candidate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Candidate>(list);
				}
				else {
					list = (List<Candidate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first candidate in the ordered set where country = &#63;.
	 *
	 * @param country the country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findByCountry_First(String country,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = fetchByCountry_First(country, orderByComparator);

		if (candidate != null) {
			return candidate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("country=");
		msg.append(country);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateException(msg.toString());
	}

	/**
	 * Returns the first candidate in the ordered set where country = &#63;.
	 *
	 * @param country the country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate, or <code>null</code> if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByCountry_First(String country,
		OrderByComparator orderByComparator) throws SystemException {
		List<Candidate> list = findByCountry(country, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate in the ordered set where country = &#63;.
	 *
	 * @param country the country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findByCountry_Last(String country,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = fetchByCountry_Last(country, orderByComparator);

		if (candidate != null) {
			return candidate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("country=");
		msg.append(country);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateException(msg.toString());
	}

	/**
	 * Returns the last candidate in the ordered set where country = &#63;.
	 *
	 * @param country the country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate, or <code>null</code> if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByCountry_Last(String country,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCountry(country);

		if (count == 0) {
			return null;
		}

		List<Candidate> list = findByCountry(country, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidates before and after the current candidate in the ordered set where country = &#63;.
	 *
	 * @param candidateId the primary key of the current candidate
	 * @param country the country
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate[] findByCountry_PrevAndNext(long candidateId,
		String country, OrderByComparator orderByComparator)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = findByPrimaryKey(candidateId);

		Session session = null;

		try {
			session = openSession();

			Candidate[] array = new CandidateImpl[3];

			array[0] = getByCountry_PrevAndNext(session, candidate, country,
					orderByComparator, true);

			array[1] = candidate;

			array[2] = getByCountry_PrevAndNext(session, candidate, country,
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

	protected Candidate getByCountry_PrevAndNext(Session session,
		Candidate candidate, String country,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANDIDATE_WHERE);

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
			query.append(CandidateModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(candidate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Candidate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidates where country = &#63; from the database.
	 *
	 * @param country the country
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountry(String country) throws SystemException {
		for (Candidate candidate : findByCountry(country, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(candidate);
		}
	}

	/**
	 * Returns the number of candidates where country = &#63;.
	 *
	 * @param country the country
	 * @return the number of matching candidates
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

			query.append(_SQL_COUNT_CANDIDATE_WHERE);

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

	private static final String _FINDER_COLUMN_COUNTRY_COUNTRY_1 = "candidate.country IS NULL";
	private static final String _FINDER_COLUMN_COUNTRY_COUNTRY_2 = "candidate.country = ?";
	private static final String _FINDER_COLUMN_COUNTRY_COUNTRY_3 = "(candidate.country IS NULL OR candidate.country = '')";

	public CandidatePersistenceImpl() {
		setModelClass(Candidate.class);
	}

	/**
	 * Caches the candidate in the entity cache if it is enabled.
	 *
	 * @param candidate the candidate
	 */
	@Override
	public void cacheResult(Candidate candidate) {
		EntityCacheUtil.putResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateImpl.class, candidate.getPrimaryKey(), candidate);

		candidate.resetOriginalValues();
	}

	/**
	 * Caches the candidates in the entity cache if it is enabled.
	 *
	 * @param candidates the candidates
	 */
	@Override
	public void cacheResult(List<Candidate> candidates) {
		for (Candidate candidate : candidates) {
			if (EntityCacheUtil.getResult(
						CandidateModelImpl.ENTITY_CACHE_ENABLED,
						CandidateImpl.class, candidate.getPrimaryKey()) == null) {
				cacheResult(candidate);
			}
			else {
				candidate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all candidates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CandidateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CandidateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the candidate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Candidate candidate) {
		EntityCacheUtil.removeResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateImpl.class, candidate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Candidate> candidates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Candidate candidate : candidates) {
			EntityCacheUtil.removeResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
				CandidateImpl.class, candidate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new candidate with the primary key. Does not add the candidate to the database.
	 *
	 * @param candidateId the primary key for the new candidate
	 * @return the new candidate
	 */
	@Override
	public Candidate create(long candidateId) {
		Candidate candidate = new CandidateImpl();

		candidate.setNew(true);
		candidate.setPrimaryKey(candidateId);

		return candidate;
	}

	/**
	 * Removes the candidate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateId the primary key of the candidate
	 * @return the candidate that was removed
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate remove(long candidateId)
		throws NoSuchCandidateException, SystemException {
		return remove((Serializable)candidateId);
	}

	/**
	 * Removes the candidate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the candidate
	 * @return the candidate that was removed
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate remove(Serializable primaryKey)
		throws NoSuchCandidateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Candidate candidate = (Candidate)session.get(CandidateImpl.class,
					primaryKey);

			if (candidate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCandidateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(candidate);
		}
		catch (NoSuchCandidateException nsee) {
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
	protected Candidate removeImpl(Candidate candidate)
		throws SystemException {
		candidate = toUnwrappedModel(candidate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(candidate)) {
				candidate = (Candidate)session.get(CandidateImpl.class,
						candidate.getPrimaryKeyObj());
			}

			if (candidate != null) {
				session.delete(candidate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (candidate != null) {
			clearCache(candidate);
		}

		return candidate;
	}

	@Override
	public Candidate updateImpl(
		at.meduni.liferay.portlet.rdconnect.model.Candidate candidate)
		throws SystemException {
		candidate = toUnwrappedModel(candidate);

		boolean isNew = candidate.isNew();

		CandidateModelImpl candidateModelImpl = (CandidateModelImpl)candidate;

		Session session = null;

		try {
			session = openSession();

			if (candidate.isNew()) {
				session.save(candidate);

				candidate.setNew(false);
			}
			else {
				session.merge(candidate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CandidateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((candidateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBREMOVER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateModelImpl.getOriginalSubunitof()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBREMOVER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBREMOVER,
					args);

				args = new Object[] { candidateModelImpl.getSubunitof() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBREMOVER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBREMOVER,
					args);
			}

			if ((candidateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateModelImpl.getOriginalCountry()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY,
					args);

				args = new Object[] { candidateModelImpl.getCountry() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRY,
					args);
			}
		}

		EntityCacheUtil.putResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateImpl.class, candidate.getPrimaryKey(), candidate);

		return candidate;
	}

	protected Candidate toUnwrappedModel(Candidate candidate) {
		if (candidate instanceof CandidateImpl) {
			return candidate;
		}

		CandidateImpl candidateImpl = new CandidateImpl();

		candidateImpl.setNew(candidate.isNew());
		candidateImpl.setPrimaryKey(candidate.getPrimaryKey());

		candidateImpl.setCandidateId(candidate.getCandidateId());
		candidateImpl.setSource(candidate.getSource());
		candidateImpl.setName(candidate.getName());
		candidateImpl.setUrl(candidate.getUrl());
		candidateImpl.setContactperson(candidate.getContactperson());
		candidateImpl.setCandidatetype(candidate.getCandidatetype());
		candidateImpl.setSubunitof(candidate.getSubunitof());
		candidateImpl.setCountry(candidate.getCountry());
		candidateImpl.setDiseasescodes(candidate.getDiseasescodes());
		candidateImpl.setDiseasesfreetext(candidate.getDiseasesfreetext());
		candidateImpl.setComment(candidate.getComment());
		candidateImpl.setAddress(candidate.getAddress());
		candidateImpl.setDate(candidate.getDate());
		candidateImpl.setSearchurl(candidate.getSearchurl());
		candidateImpl.setSourceId(candidate.getSourceId());
		candidateImpl.setMail(candidate.getMail());
		candidateImpl.setHead(candidate.getHead());
		candidateImpl.setSubmittername(candidate.getSubmittername());
		candidateImpl.setSubmitteremail(candidate.getSubmitteremail());
		candidateImpl.setValidated(candidate.isValidated());

		return candidateImpl;
	}

	/**
	 * Returns the candidate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate
	 * @return the candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = fetchByPrimaryKey(primaryKey);

		if (candidate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCandidateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return candidate;
	}

	/**
	 * Returns the candidate with the primary key or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException} if it could not be found.
	 *
	 * @param candidateId the primary key of the candidate
	 * @return the candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findByPrimaryKey(long candidateId)
		throws NoSuchCandidateException, SystemException {
		return findByPrimaryKey((Serializable)candidateId);
	}

	/**
	 * Returns the candidate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate
	 * @return the candidate, or <code>null</code> if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Candidate candidate = (Candidate)EntityCacheUtil.getResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
				CandidateImpl.class, primaryKey);

		if (candidate == _nullCandidate) {
			return null;
		}

		if (candidate == null) {
			Session session = null;

			try {
				session = openSession();

				candidate = (Candidate)session.get(CandidateImpl.class,
						primaryKey);

				if (candidate != null) {
					cacheResult(candidate);
				}
				else {
					EntityCacheUtil.putResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
						CandidateImpl.class, primaryKey, _nullCandidate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
					CandidateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return candidate;
	}

	/**
	 * Returns the candidate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateId the primary key of the candidate
	 * @return the candidate, or <code>null</code> if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByPrimaryKey(long candidateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)candidateId);
	}

	/**
	 * Returns all the candidates.
	 *
	 * @return the candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @return the range of candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findAll(int start, int end,
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

		List<Candidate> list = (List<Candidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CANDIDATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANDIDATE;

				if (pagination) {
					sql = sql.concat(CandidateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Candidate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Candidate>(list);
				}
				else {
					list = (List<Candidate>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the candidates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Candidate candidate : findAll()) {
			remove(candidate);
		}
	}

	/**
	 * Returns the number of candidates.
	 *
	 * @return the number of candidates
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

				Query q = session.createQuery(_SQL_COUNT_CANDIDATE);

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
	 * Initializes the candidate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.rdconnect.model.Candidate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Candidate>> listenersList = new ArrayList<ModelListener<Candidate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Candidate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CandidateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CANDIDATE = "SELECT candidate FROM Candidate candidate";
	private static final String _SQL_SELECT_CANDIDATE_WHERE = "SELECT candidate FROM Candidate candidate WHERE ";
	private static final String _SQL_COUNT_CANDIDATE = "SELECT COUNT(candidate) FROM Candidate candidate";
	private static final String _SQL_COUNT_CANDIDATE_WHERE = "SELECT COUNT(candidate) FROM Candidate candidate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "candidate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Candidate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Candidate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CandidatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"comment", "date"
			});
	private static Candidate _nullCandidate = new CandidateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Candidate> toCacheModel() {
				return _nullCandidateCacheModel;
			}
		};

	private static CacheModel<Candidate> _nullCandidateCacheModel = new CacheModel<Candidate>() {
			@Override
			public Candidate toEntityModel() {
				return _nullCandidate;
			}
		};
}