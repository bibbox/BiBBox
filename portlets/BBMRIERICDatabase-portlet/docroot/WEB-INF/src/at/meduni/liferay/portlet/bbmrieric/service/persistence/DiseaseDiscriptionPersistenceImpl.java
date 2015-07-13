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

import at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException;
import at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription;
import at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionImpl;
import at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl;

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
 * The persistence implementation for the disease discription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DiseaseDiscriptionPersistence
 * @see DiseaseDiscriptionUtil
 * @generated
 */
public class DiseaseDiscriptionPersistenceImpl extends BasePersistenceImpl<DiseaseDiscription>
	implements DiseaseDiscriptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DiseaseDiscriptionUtil} to access the disease discription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DiseaseDiscriptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionModelImpl.FINDER_CACHE_ENABLED,
			DiseaseDiscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionModelImpl.FINDER_CACHE_ENABLED,
			DiseaseDiscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_DISEASECODE = new FinderPath(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionModelImpl.FINDER_CACHE_ENABLED,
			DiseaseDiscriptionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByDiseaseCode", new String[] { String.class.getName() },
			DiseaseDiscriptionModelImpl.DISEASECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DISEASECODE = new FinderPath(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDiseaseCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the disease discription where diseasecode = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException} if it could not be found.
	 *
	 * @param diseasecode the diseasecode
	 * @return the matching disease discription
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a matching disease discription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription findByDiseaseCode(String diseasecode)
		throws NoSuchDiseaseDiscriptionException, SystemException {
		DiseaseDiscription diseaseDiscription = fetchByDiseaseCode(diseasecode);

		if (diseaseDiscription == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("diseasecode=");
			msg.append(diseasecode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDiseaseDiscriptionException(msg.toString());
		}

		return diseaseDiscription;
	}

	/**
	 * Returns the disease discription where diseasecode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param diseasecode the diseasecode
	 * @return the matching disease discription, or <code>null</code> if a matching disease discription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription fetchByDiseaseCode(String diseasecode)
		throws SystemException {
		return fetchByDiseaseCode(diseasecode, true);
	}

	/**
	 * Returns the disease discription where diseasecode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param diseasecode the diseasecode
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching disease discription, or <code>null</code> if a matching disease discription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription fetchByDiseaseCode(String diseasecode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { diseasecode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DISEASECODE,
					finderArgs, this);
		}

		if (result instanceof DiseaseDiscription) {
			DiseaseDiscription diseaseDiscription = (DiseaseDiscription)result;

			if (!Validator.equals(diseasecode,
						diseaseDiscription.getDiseasecode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DISEASEDISCRIPTION_WHERE);

			boolean bindDiseasecode = false;

			if (diseasecode == null) {
				query.append(_FINDER_COLUMN_DISEASECODE_DISEASECODE_1);
			}
			else if (diseasecode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DISEASECODE_DISEASECODE_3);
			}
			else {
				bindDiseasecode = true;

				query.append(_FINDER_COLUMN_DISEASECODE_DISEASECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDiseasecode) {
					qPos.add(diseasecode);
				}

				List<DiseaseDiscription> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DISEASECODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DiseaseDiscriptionPersistenceImpl.fetchByDiseaseCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DiseaseDiscription diseaseDiscription = list.get(0);

					result = diseaseDiscription;

					cacheResult(diseaseDiscription);

					if ((diseaseDiscription.getDiseasecode() == null) ||
							!diseaseDiscription.getDiseasecode()
												   .equals(diseasecode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DISEASECODE,
							finderArgs, diseaseDiscription);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DISEASECODE,
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
			return (DiseaseDiscription)result;
		}
	}

	/**
	 * Removes the disease discription where diseasecode = &#63; from the database.
	 *
	 * @param diseasecode the diseasecode
	 * @return the disease discription that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription removeByDiseaseCode(String diseasecode)
		throws NoSuchDiseaseDiscriptionException, SystemException {
		DiseaseDiscription diseaseDiscription = findByDiseaseCode(diseasecode);

		return remove(diseaseDiscription);
	}

	/**
	 * Returns the number of disease discriptions where diseasecode = &#63;.
	 *
	 * @param diseasecode the diseasecode
	 * @return the number of matching disease discriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDiseaseCode(String diseasecode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DISEASECODE;

		Object[] finderArgs = new Object[] { diseasecode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DISEASEDISCRIPTION_WHERE);

			boolean bindDiseasecode = false;

			if (diseasecode == null) {
				query.append(_FINDER_COLUMN_DISEASECODE_DISEASECODE_1);
			}
			else if (diseasecode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DISEASECODE_DISEASECODE_3);
			}
			else {
				bindDiseasecode = true;

				query.append(_FINDER_COLUMN_DISEASECODE_DISEASECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDiseasecode) {
					qPos.add(diseasecode);
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

	private static final String _FINDER_COLUMN_DISEASECODE_DISEASECODE_1 = "diseaseDiscription.diseasecode IS NULL";
	private static final String _FINDER_COLUMN_DISEASECODE_DISEASECODE_2 = "diseaseDiscription.diseasecode = ?";
	private static final String _FINDER_COLUMN_DISEASECODE_DISEASECODE_3 = "(diseaseDiscription.diseasecode IS NULL OR diseaseDiscription.diseasecode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DISEASEGROUP =
		new FinderPath(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionModelImpl.FINDER_CACHE_ENABLED,
			DiseaseDiscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDiseaseGroup",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISEASEGROUP =
		new FinderPath(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionModelImpl.FINDER_CACHE_ENABLED,
			DiseaseDiscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDiseaseGroup",
			new String[] { String.class.getName() },
			DiseaseDiscriptionModelImpl.DISEASEGROUP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DISEASEGROUP = new FinderPath(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDiseaseGroup",
			new String[] { String.class.getName() });

	/**
	 * Returns all the disease discriptions where diseasegroup = &#63;.
	 *
	 * @param diseasegroup the diseasegroup
	 * @return the matching disease discriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseDiscription> findByDiseaseGroup(String diseasegroup)
		throws SystemException {
		return findByDiseaseGroup(diseasegroup, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disease discriptions where diseasegroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param diseasegroup the diseasegroup
	 * @param start the lower bound of the range of disease discriptions
	 * @param end the upper bound of the range of disease discriptions (not inclusive)
	 * @return the range of matching disease discriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseDiscription> findByDiseaseGroup(String diseasegroup,
		int start, int end) throws SystemException {
		return findByDiseaseGroup(diseasegroup, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disease discriptions where diseasegroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param diseasegroup the diseasegroup
	 * @param start the lower bound of the range of disease discriptions
	 * @param end the upper bound of the range of disease discriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disease discriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseDiscription> findByDiseaseGroup(String diseasegroup,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISEASEGROUP;
			finderArgs = new Object[] { diseasegroup };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DISEASEGROUP;
			finderArgs = new Object[] {
					diseasegroup,
					
					start, end, orderByComparator
				};
		}

		List<DiseaseDiscription> list = (List<DiseaseDiscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DiseaseDiscription diseaseDiscription : list) {
				if (!Validator.equals(diseasegroup,
							diseaseDiscription.getDiseasegroup())) {
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

			query.append(_SQL_SELECT_DISEASEDISCRIPTION_WHERE);

			boolean bindDiseasegroup = false;

			if (diseasegroup == null) {
				query.append(_FINDER_COLUMN_DISEASEGROUP_DISEASEGROUP_1);
			}
			else if (diseasegroup.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DISEASEGROUP_DISEASEGROUP_3);
			}
			else {
				bindDiseasegroup = true;

				query.append(_FINDER_COLUMN_DISEASEGROUP_DISEASEGROUP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DiseaseDiscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDiseasegroup) {
					qPos.add(diseasegroup);
				}

				if (!pagination) {
					list = (List<DiseaseDiscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DiseaseDiscription>(list);
				}
				else {
					list = (List<DiseaseDiscription>)QueryUtil.list(q,
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
	 * Returns the first disease discription in the ordered set where diseasegroup = &#63;.
	 *
	 * @param diseasegroup the diseasegroup
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disease discription
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a matching disease discription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription findByDiseaseGroup_First(String diseasegroup,
		OrderByComparator orderByComparator)
		throws NoSuchDiseaseDiscriptionException, SystemException {
		DiseaseDiscription diseaseDiscription = fetchByDiseaseGroup_First(diseasegroup,
				orderByComparator);

		if (diseaseDiscription != null) {
			return diseaseDiscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("diseasegroup=");
		msg.append(diseasegroup);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDiseaseDiscriptionException(msg.toString());
	}

	/**
	 * Returns the first disease discription in the ordered set where diseasegroup = &#63;.
	 *
	 * @param diseasegroup the diseasegroup
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disease discription, or <code>null</code> if a matching disease discription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription fetchByDiseaseGroup_First(String diseasegroup,
		OrderByComparator orderByComparator) throws SystemException {
		List<DiseaseDiscription> list = findByDiseaseGroup(diseasegroup, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disease discription in the ordered set where diseasegroup = &#63;.
	 *
	 * @param diseasegroup the diseasegroup
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disease discription
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a matching disease discription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription findByDiseaseGroup_Last(String diseasegroup,
		OrderByComparator orderByComparator)
		throws NoSuchDiseaseDiscriptionException, SystemException {
		DiseaseDiscription diseaseDiscription = fetchByDiseaseGroup_Last(diseasegroup,
				orderByComparator);

		if (diseaseDiscription != null) {
			return diseaseDiscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("diseasegroup=");
		msg.append(diseasegroup);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDiseaseDiscriptionException(msg.toString());
	}

	/**
	 * Returns the last disease discription in the ordered set where diseasegroup = &#63;.
	 *
	 * @param diseasegroup the diseasegroup
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disease discription, or <code>null</code> if a matching disease discription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription fetchByDiseaseGroup_Last(String diseasegroup,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDiseaseGroup(diseasegroup);

		if (count == 0) {
			return null;
		}

		List<DiseaseDiscription> list = findByDiseaseGroup(diseasegroup,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disease discriptions before and after the current disease discription in the ordered set where diseasegroup = &#63;.
	 *
	 * @param diseasediscriptionId the primary key of the current disease discription
	 * @param diseasegroup the diseasegroup
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disease discription
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a disease discription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription[] findByDiseaseGroup_PrevAndNext(
		long diseasediscriptionId, String diseasegroup,
		OrderByComparator orderByComparator)
		throws NoSuchDiseaseDiscriptionException, SystemException {
		DiseaseDiscription diseaseDiscription = findByPrimaryKey(diseasediscriptionId);

		Session session = null;

		try {
			session = openSession();

			DiseaseDiscription[] array = new DiseaseDiscriptionImpl[3];

			array[0] = getByDiseaseGroup_PrevAndNext(session,
					diseaseDiscription, diseasegroup, orderByComparator, true);

			array[1] = diseaseDiscription;

			array[2] = getByDiseaseGroup_PrevAndNext(session,
					diseaseDiscription, diseasegroup, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DiseaseDiscription getByDiseaseGroup_PrevAndNext(
		Session session, DiseaseDiscription diseaseDiscription,
		String diseasegroup, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISEASEDISCRIPTION_WHERE);

		boolean bindDiseasegroup = false;

		if (diseasegroup == null) {
			query.append(_FINDER_COLUMN_DISEASEGROUP_DISEASEGROUP_1);
		}
		else if (diseasegroup.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DISEASEGROUP_DISEASEGROUP_3);
		}
		else {
			bindDiseasegroup = true;

			query.append(_FINDER_COLUMN_DISEASEGROUP_DISEASEGROUP_2);
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
			query.append(DiseaseDiscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDiseasegroup) {
			qPos.add(diseasegroup);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(diseaseDiscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DiseaseDiscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disease discriptions where diseasegroup = &#63; from the database.
	 *
	 * @param diseasegroup the diseasegroup
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDiseaseGroup(String diseasegroup)
		throws SystemException {
		for (DiseaseDiscription diseaseDiscription : findByDiseaseGroup(
				diseasegroup, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(diseaseDiscription);
		}
	}

	/**
	 * Returns the number of disease discriptions where diseasegroup = &#63;.
	 *
	 * @param diseasegroup the diseasegroup
	 * @return the number of matching disease discriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDiseaseGroup(String diseasegroup)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DISEASEGROUP;

		Object[] finderArgs = new Object[] { diseasegroup };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DISEASEDISCRIPTION_WHERE);

			boolean bindDiseasegroup = false;

			if (diseasegroup == null) {
				query.append(_FINDER_COLUMN_DISEASEGROUP_DISEASEGROUP_1);
			}
			else if (diseasegroup.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DISEASEGROUP_DISEASEGROUP_3);
			}
			else {
				bindDiseasegroup = true;

				query.append(_FINDER_COLUMN_DISEASEGROUP_DISEASEGROUP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDiseasegroup) {
					qPos.add(diseasegroup);
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

	private static final String _FINDER_COLUMN_DISEASEGROUP_DISEASEGROUP_1 = "diseaseDiscription.diseasegroup IS NULL";
	private static final String _FINDER_COLUMN_DISEASEGROUP_DISEASEGROUP_2 = "diseaseDiscription.diseasegroup = ?";
	private static final String _FINDER_COLUMN_DISEASEGROUP_DISEASEGROUP_3 = "(diseaseDiscription.diseasegroup IS NULL OR diseaseDiscription.diseasegroup = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOT = new FinderPath(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionModelImpl.FINDER_CACHE_ENABLED,
			DiseaseDiscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoot",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOT = new FinderPath(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionModelImpl.FINDER_CACHE_ENABLED,
			DiseaseDiscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoot",
			new String[] { Boolean.class.getName() },
			DiseaseDiscriptionModelImpl.ROOT_COLUMN_BITMASK |
			DiseaseDiscriptionModelImpl.DISEASEGROUP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOT = new FinderPath(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoot",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the disease discriptions where root = &#63;.
	 *
	 * @param root the root
	 * @return the matching disease discriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseDiscription> findByRoot(boolean root)
		throws SystemException {
		return findByRoot(root, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disease discriptions where root = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param root the root
	 * @param start the lower bound of the range of disease discriptions
	 * @param end the upper bound of the range of disease discriptions (not inclusive)
	 * @return the range of matching disease discriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseDiscription> findByRoot(boolean root, int start, int end)
		throws SystemException {
		return findByRoot(root, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disease discriptions where root = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param root the root
	 * @param start the lower bound of the range of disease discriptions
	 * @param end the upper bound of the range of disease discriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disease discriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseDiscription> findByRoot(boolean root, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOT;
			finderArgs = new Object[] { root };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOT;
			finderArgs = new Object[] { root, start, end, orderByComparator };
		}

		List<DiseaseDiscription> list = (List<DiseaseDiscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DiseaseDiscription diseaseDiscription : list) {
				if ((root != diseaseDiscription.getRoot())) {
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

			query.append(_SQL_SELECT_DISEASEDISCRIPTION_WHERE);

			query.append(_FINDER_COLUMN_ROOT_ROOT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DiseaseDiscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(root);

				if (!pagination) {
					list = (List<DiseaseDiscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DiseaseDiscription>(list);
				}
				else {
					list = (List<DiseaseDiscription>)QueryUtil.list(q,
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
	 * Returns the first disease discription in the ordered set where root = &#63;.
	 *
	 * @param root the root
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disease discription
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a matching disease discription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription findByRoot_First(boolean root,
		OrderByComparator orderByComparator)
		throws NoSuchDiseaseDiscriptionException, SystemException {
		DiseaseDiscription diseaseDiscription = fetchByRoot_First(root,
				orderByComparator);

		if (diseaseDiscription != null) {
			return diseaseDiscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("root=");
		msg.append(root);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDiseaseDiscriptionException(msg.toString());
	}

	/**
	 * Returns the first disease discription in the ordered set where root = &#63;.
	 *
	 * @param root the root
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disease discription, or <code>null</code> if a matching disease discription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription fetchByRoot_First(boolean root,
		OrderByComparator orderByComparator) throws SystemException {
		List<DiseaseDiscription> list = findByRoot(root, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disease discription in the ordered set where root = &#63;.
	 *
	 * @param root the root
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disease discription
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a matching disease discription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription findByRoot_Last(boolean root,
		OrderByComparator orderByComparator)
		throws NoSuchDiseaseDiscriptionException, SystemException {
		DiseaseDiscription diseaseDiscription = fetchByRoot_Last(root,
				orderByComparator);

		if (diseaseDiscription != null) {
			return diseaseDiscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("root=");
		msg.append(root);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDiseaseDiscriptionException(msg.toString());
	}

	/**
	 * Returns the last disease discription in the ordered set where root = &#63;.
	 *
	 * @param root the root
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disease discription, or <code>null</code> if a matching disease discription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription fetchByRoot_Last(boolean root,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRoot(root);

		if (count == 0) {
			return null;
		}

		List<DiseaseDiscription> list = findByRoot(root, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disease discriptions before and after the current disease discription in the ordered set where root = &#63;.
	 *
	 * @param diseasediscriptionId the primary key of the current disease discription
	 * @param root the root
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disease discription
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a disease discription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription[] findByRoot_PrevAndNext(
		long diseasediscriptionId, boolean root,
		OrderByComparator orderByComparator)
		throws NoSuchDiseaseDiscriptionException, SystemException {
		DiseaseDiscription diseaseDiscription = findByPrimaryKey(diseasediscriptionId);

		Session session = null;

		try {
			session = openSession();

			DiseaseDiscription[] array = new DiseaseDiscriptionImpl[3];

			array[0] = getByRoot_PrevAndNext(session, diseaseDiscription, root,
					orderByComparator, true);

			array[1] = diseaseDiscription;

			array[2] = getByRoot_PrevAndNext(session, diseaseDiscription, root,
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

	protected DiseaseDiscription getByRoot_PrevAndNext(Session session,
		DiseaseDiscription diseaseDiscription, boolean root,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISEASEDISCRIPTION_WHERE);

		query.append(_FINDER_COLUMN_ROOT_ROOT_2);

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
			query.append(DiseaseDiscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(root);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(diseaseDiscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DiseaseDiscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disease discriptions where root = &#63; from the database.
	 *
	 * @param root the root
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRoot(boolean root) throws SystemException {
		for (DiseaseDiscription diseaseDiscription : findByRoot(root,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(diseaseDiscription);
		}
	}

	/**
	 * Returns the number of disease discriptions where root = &#63;.
	 *
	 * @param root the root
	 * @return the number of matching disease discriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRoot(boolean root) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROOT;

		Object[] finderArgs = new Object[] { root };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DISEASEDISCRIPTION_WHERE);

			query.append(_FINDER_COLUMN_ROOT_ROOT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(root);

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

	private static final String _FINDER_COLUMN_ROOT_ROOT_2 = "diseaseDiscription.root = ?";

	public DiseaseDiscriptionPersistenceImpl() {
		setModelClass(DiseaseDiscription.class);
	}

	/**
	 * Caches the disease discription in the entity cache if it is enabled.
	 *
	 * @param diseaseDiscription the disease discription
	 */
	@Override
	public void cacheResult(DiseaseDiscription diseaseDiscription) {
		EntityCacheUtil.putResult(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionImpl.class, diseaseDiscription.getPrimaryKey(),
			diseaseDiscription);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DISEASECODE,
			new Object[] { diseaseDiscription.getDiseasecode() },
			diseaseDiscription);

		diseaseDiscription.resetOriginalValues();
	}

	/**
	 * Caches the disease discriptions in the entity cache if it is enabled.
	 *
	 * @param diseaseDiscriptions the disease discriptions
	 */
	@Override
	public void cacheResult(List<DiseaseDiscription> diseaseDiscriptions) {
		for (DiseaseDiscription diseaseDiscription : diseaseDiscriptions) {
			if (EntityCacheUtil.getResult(
						DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
						DiseaseDiscriptionImpl.class,
						diseaseDiscription.getPrimaryKey()) == null) {
				cacheResult(diseaseDiscription);
			}
			else {
				diseaseDiscription.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all disease discriptions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DiseaseDiscriptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DiseaseDiscriptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the disease discription.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DiseaseDiscription diseaseDiscription) {
		EntityCacheUtil.removeResult(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionImpl.class, diseaseDiscription.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(diseaseDiscription);
	}

	@Override
	public void clearCache(List<DiseaseDiscription> diseaseDiscriptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DiseaseDiscription diseaseDiscription : diseaseDiscriptions) {
			EntityCacheUtil.removeResult(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
				DiseaseDiscriptionImpl.class, diseaseDiscription.getPrimaryKey());

			clearUniqueFindersCache(diseaseDiscription);
		}
	}

	protected void cacheUniqueFindersCache(
		DiseaseDiscription diseaseDiscription) {
		if (diseaseDiscription.isNew()) {
			Object[] args = new Object[] { diseaseDiscription.getDiseasecode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DISEASECODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DISEASECODE, args,
				diseaseDiscription);
		}
		else {
			DiseaseDiscriptionModelImpl diseaseDiscriptionModelImpl = (DiseaseDiscriptionModelImpl)diseaseDiscription;

			if ((diseaseDiscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DISEASECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { diseaseDiscription.getDiseasecode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DISEASECODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DISEASECODE,
					args, diseaseDiscription);
			}
		}
	}

	protected void clearUniqueFindersCache(
		DiseaseDiscription diseaseDiscription) {
		DiseaseDiscriptionModelImpl diseaseDiscriptionModelImpl = (DiseaseDiscriptionModelImpl)diseaseDiscription;

		Object[] args = new Object[] { diseaseDiscription.getDiseasecode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DISEASECODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DISEASECODE, args);

		if ((diseaseDiscriptionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DISEASECODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					diseaseDiscriptionModelImpl.getOriginalDiseasecode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DISEASECODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DISEASECODE, args);
		}
	}

	/**
	 * Creates a new disease discription with the primary key. Does not add the disease discription to the database.
	 *
	 * @param diseasediscriptionId the primary key for the new disease discription
	 * @return the new disease discription
	 */
	@Override
	public DiseaseDiscription create(long diseasediscriptionId) {
		DiseaseDiscription diseaseDiscription = new DiseaseDiscriptionImpl();

		diseaseDiscription.setNew(true);
		diseaseDiscription.setPrimaryKey(diseasediscriptionId);

		return diseaseDiscription;
	}

	/**
	 * Removes the disease discription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param diseasediscriptionId the primary key of the disease discription
	 * @return the disease discription that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a disease discription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription remove(long diseasediscriptionId)
		throws NoSuchDiseaseDiscriptionException, SystemException {
		return remove((Serializable)diseasediscriptionId);
	}

	/**
	 * Removes the disease discription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the disease discription
	 * @return the disease discription that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a disease discription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription remove(Serializable primaryKey)
		throws NoSuchDiseaseDiscriptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DiseaseDiscription diseaseDiscription = (DiseaseDiscription)session.get(DiseaseDiscriptionImpl.class,
					primaryKey);

			if (diseaseDiscription == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDiseaseDiscriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(diseaseDiscription);
		}
		catch (NoSuchDiseaseDiscriptionException nsee) {
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
	protected DiseaseDiscription removeImpl(
		DiseaseDiscription diseaseDiscription) throws SystemException {
		diseaseDiscription = toUnwrappedModel(diseaseDiscription);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(diseaseDiscription)) {
				diseaseDiscription = (DiseaseDiscription)session.get(DiseaseDiscriptionImpl.class,
						diseaseDiscription.getPrimaryKeyObj());
			}

			if (diseaseDiscription != null) {
				session.delete(diseaseDiscription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (diseaseDiscription != null) {
			clearCache(diseaseDiscription);
		}

		return diseaseDiscription;
	}

	@Override
	public DiseaseDiscription updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription diseaseDiscription)
		throws SystemException {
		diseaseDiscription = toUnwrappedModel(diseaseDiscription);

		boolean isNew = diseaseDiscription.isNew();

		DiseaseDiscriptionModelImpl diseaseDiscriptionModelImpl = (DiseaseDiscriptionModelImpl)diseaseDiscription;

		Session session = null;

		try {
			session = openSession();

			if (diseaseDiscription.isNew()) {
				session.save(diseaseDiscription);

				diseaseDiscription.setNew(false);
			}
			else {
				session.merge(diseaseDiscription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DiseaseDiscriptionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((diseaseDiscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISEASEGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						diseaseDiscriptionModelImpl.getOriginalDiseasegroup()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DISEASEGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISEASEGROUP,
					args);

				args = new Object[] {
						diseaseDiscriptionModelImpl.getDiseasegroup()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DISEASEGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISEASEGROUP,
					args);
			}

			if ((diseaseDiscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						diseaseDiscriptionModelImpl.getOriginalRoot()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOT,
					args);

				args = new Object[] { diseaseDiscriptionModelImpl.getRoot() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOT,
					args);
			}
		}

		EntityCacheUtil.putResult(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseDiscriptionImpl.class, diseaseDiscription.getPrimaryKey(),
			diseaseDiscription);

		clearUniqueFindersCache(diseaseDiscription);
		cacheUniqueFindersCache(diseaseDiscription);

		return diseaseDiscription;
	}

	protected DiseaseDiscription toUnwrappedModel(
		DiseaseDiscription diseaseDiscription) {
		if (diseaseDiscription instanceof DiseaseDiscriptionImpl) {
			return diseaseDiscription;
		}

		DiseaseDiscriptionImpl diseaseDiscriptionImpl = new DiseaseDiscriptionImpl();

		diseaseDiscriptionImpl.setNew(diseaseDiscription.isNew());
		diseaseDiscriptionImpl.setPrimaryKey(diseaseDiscription.getPrimaryKey());

		diseaseDiscriptionImpl.setDiseasediscriptionId(diseaseDiscription.getDiseasediscriptionId());
		diseaseDiscriptionImpl.setDiseasecode(diseaseDiscription.getDiseasecode());
		diseaseDiscriptionImpl.setDiseasegroup(diseaseDiscription.getDiseasegroup());
		diseaseDiscriptionImpl.setDiseasediscription(diseaseDiscription.getDiseasediscription());
		diseaseDiscriptionImpl.setRoot(diseaseDiscription.isRoot());

		return diseaseDiscriptionImpl;
	}

	/**
	 * Returns the disease discription with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the disease discription
	 * @return the disease discription
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a disease discription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDiseaseDiscriptionException, SystemException {
		DiseaseDiscription diseaseDiscription = fetchByPrimaryKey(primaryKey);

		if (diseaseDiscription == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDiseaseDiscriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return diseaseDiscription;
	}

	/**
	 * Returns the disease discription with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException} if it could not be found.
	 *
	 * @param diseasediscriptionId the primary key of the disease discription
	 * @return the disease discription
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a disease discription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription findByPrimaryKey(long diseasediscriptionId)
		throws NoSuchDiseaseDiscriptionException, SystemException {
		return findByPrimaryKey((Serializable)diseasediscriptionId);
	}

	/**
	 * Returns the disease discription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the disease discription
	 * @return the disease discription, or <code>null</code> if a disease discription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DiseaseDiscription diseaseDiscription = (DiseaseDiscription)EntityCacheUtil.getResult(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
				DiseaseDiscriptionImpl.class, primaryKey);

		if (diseaseDiscription == _nullDiseaseDiscription) {
			return null;
		}

		if (diseaseDiscription == null) {
			Session session = null;

			try {
				session = openSession();

				diseaseDiscription = (DiseaseDiscription)session.get(DiseaseDiscriptionImpl.class,
						primaryKey);

				if (diseaseDiscription != null) {
					cacheResult(diseaseDiscription);
				}
				else {
					EntityCacheUtil.putResult(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
						DiseaseDiscriptionImpl.class, primaryKey,
						_nullDiseaseDiscription);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DiseaseDiscriptionModelImpl.ENTITY_CACHE_ENABLED,
					DiseaseDiscriptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return diseaseDiscription;
	}

	/**
	 * Returns the disease discription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param diseasediscriptionId the primary key of the disease discription
	 * @return the disease discription, or <code>null</code> if a disease discription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseDiscription fetchByPrimaryKey(long diseasediscriptionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)diseasediscriptionId);
	}

	/**
	 * Returns all the disease discriptions.
	 *
	 * @return the disease discriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseDiscription> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disease discriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of disease discriptions
	 * @param end the upper bound of the range of disease discriptions (not inclusive)
	 * @return the range of disease discriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseDiscription> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the disease discriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of disease discriptions
	 * @param end the upper bound of the range of disease discriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of disease discriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseDiscription> findAll(int start, int end,
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

		List<DiseaseDiscription> list = (List<DiseaseDiscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DISEASEDISCRIPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DISEASEDISCRIPTION;

				if (pagination) {
					sql = sql.concat(DiseaseDiscriptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DiseaseDiscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DiseaseDiscription>(list);
				}
				else {
					list = (List<DiseaseDiscription>)QueryUtil.list(q,
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
	 * Removes all the disease discriptions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DiseaseDiscription diseaseDiscription : findAll()) {
			remove(diseaseDiscription);
		}
	}

	/**
	 * Returns the number of disease discriptions.
	 *
	 * @return the number of disease discriptions
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

				Query q = session.createQuery(_SQL_COUNT_DISEASEDISCRIPTION);

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
	 * Initializes the disease discription persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DiseaseDiscription>> listenersList = new ArrayList<ModelListener<DiseaseDiscription>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DiseaseDiscription>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DiseaseDiscriptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DISEASEDISCRIPTION = "SELECT diseaseDiscription FROM DiseaseDiscription diseaseDiscription";
	private static final String _SQL_SELECT_DISEASEDISCRIPTION_WHERE = "SELECT diseaseDiscription FROM DiseaseDiscription diseaseDiscription WHERE ";
	private static final String _SQL_COUNT_DISEASEDISCRIPTION = "SELECT COUNT(diseaseDiscription) FROM DiseaseDiscription diseaseDiscription";
	private static final String _SQL_COUNT_DISEASEDISCRIPTION_WHERE = "SELECT COUNT(diseaseDiscription) FROM DiseaseDiscription diseaseDiscription WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "diseaseDiscription.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DiseaseDiscription exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DiseaseDiscription exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DiseaseDiscriptionPersistenceImpl.class);
	private static DiseaseDiscription _nullDiseaseDiscription = new DiseaseDiscriptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DiseaseDiscription> toCacheModel() {
				return _nullDiseaseDiscriptionCacheModel;
			}
		};

	private static CacheModel<DiseaseDiscription> _nullDiseaseDiscriptionCacheModel =
		new CacheModel<DiseaseDiscription>() {
			@Override
			public DiseaseDiscription toEntityModel() {
				return _nullDiseaseDiscription;
			}
		};
}