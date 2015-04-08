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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.patientnamegeneratorImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.patientnamegeneratorModelImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator;

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
 * The persistence implementation for the patientnamegenerator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see patientnamegeneratorPersistence
 * @see patientnamegeneratorUtil
 * @generated
 */
public class patientnamegeneratorPersistenceImpl extends BasePersistenceImpl<patientnamegenerator>
	implements patientnamegeneratorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link patientnamegeneratorUtil} to access the patientnamegenerator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = patientnamegeneratorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
			patientnamegeneratorModelImpl.FINDER_CACHE_ENABLED,
			patientnamegeneratorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
			patientnamegeneratorModelImpl.FINDER_CACHE_ENABLED,
			patientnamegeneratorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
			patientnamegeneratorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMES = new FinderPath(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
			patientnamegeneratorModelImpl.FINDER_CACHE_ENABLED,
			patientnamegeneratorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNames",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMES = new FinderPath(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
			patientnamegeneratorModelImpl.FINDER_CACHE_ENABLED,
			patientnamegeneratorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNames",
			new String[] { String.class.getName(), String.class.getName() },
			patientnamegeneratorModelImpl.NAME_COLUMN_BITMASK |
			patientnamegeneratorModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMES = new FinderPath(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
			patientnamegeneratorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNames",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the patientnamegenerators where name = &#63; and type = &#63;.
	 *
	 * @param name the name
	 * @param type the type
	 * @return the matching patientnamegenerators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<patientnamegenerator> findByNames(String name, String type)
		throws SystemException {
		return findByNames(name, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the patientnamegenerators where name = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.patientnamegeneratorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param type the type
	 * @param start the lower bound of the range of patientnamegenerators
	 * @param end the upper bound of the range of patientnamegenerators (not inclusive)
	 * @return the range of matching patientnamegenerators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<patientnamegenerator> findByNames(String name, String type,
		int start, int end) throws SystemException {
		return findByNames(name, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patientnamegenerators where name = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.patientnamegeneratorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param type the type
	 * @param start the lower bound of the range of patientnamegenerators
	 * @param end the upper bound of the range of patientnamegenerators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patientnamegenerators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<patientnamegenerator> findByNames(String name, String type,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMES;
			finderArgs = new Object[] { name, type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMES;
			finderArgs = new Object[] { name, type, start, end, orderByComparator };
		}

		List<patientnamegenerator> list = (List<patientnamegenerator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (patientnamegenerator patientnamegenerator : list) {
				if (!Validator.equals(name, patientnamegenerator.getName()) ||
						!Validator.equals(type, patientnamegenerator.getType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PATIENTNAMEGENERATOR_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMES_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMES_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMES_NAME_2);
			}

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_NAMES_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMES_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_NAMES_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(patientnamegeneratorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (bindType) {
					qPos.add(type);
				}

				if (!pagination) {
					list = (List<patientnamegenerator>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<patientnamegenerator>(list);
				}
				else {
					list = (List<patientnamegenerator>)QueryUtil.list(q,
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
	 * Returns the first patientnamegenerator in the ordered set where name = &#63; and type = &#63;.
	 *
	 * @param name the name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patientnamegenerator
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException if a matching patientnamegenerator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patientnamegenerator findByNames_First(String name, String type,
		OrderByComparator orderByComparator)
		throws NoSuchpatientnamegeneratorException, SystemException {
		patientnamegenerator patientnamegenerator = fetchByNames_First(name,
				type, orderByComparator);

		if (patientnamegenerator != null) {
			return patientnamegenerator;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchpatientnamegeneratorException(msg.toString());
	}

	/**
	 * Returns the first patientnamegenerator in the ordered set where name = &#63; and type = &#63;.
	 *
	 * @param name the name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patientnamegenerator, or <code>null</code> if a matching patientnamegenerator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patientnamegenerator fetchByNames_First(String name, String type,
		OrderByComparator orderByComparator) throws SystemException {
		List<patientnamegenerator> list = findByNames(name, type, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patientnamegenerator in the ordered set where name = &#63; and type = &#63;.
	 *
	 * @param name the name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patientnamegenerator
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException if a matching patientnamegenerator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patientnamegenerator findByNames_Last(String name, String type,
		OrderByComparator orderByComparator)
		throws NoSuchpatientnamegeneratorException, SystemException {
		patientnamegenerator patientnamegenerator = fetchByNames_Last(name,
				type, orderByComparator);

		if (patientnamegenerator != null) {
			return patientnamegenerator;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchpatientnamegeneratorException(msg.toString());
	}

	/**
	 * Returns the last patientnamegenerator in the ordered set where name = &#63; and type = &#63;.
	 *
	 * @param name the name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patientnamegenerator, or <code>null</code> if a matching patientnamegenerator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patientnamegenerator fetchByNames_Last(String name, String type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNames(name, type);

		if (count == 0) {
			return null;
		}

		List<patientnamegenerator> list = findByNames(name, type, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patientnamegenerators before and after the current patientnamegenerator in the ordered set where name = &#63; and type = &#63;.
	 *
	 * @param patientnamegeneratorId the primary key of the current patientnamegenerator
	 * @param name the name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patientnamegenerator
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException if a patientnamegenerator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patientnamegenerator[] findByNames_PrevAndNext(
		long patientnamegeneratorId, String name, String type,
		OrderByComparator orderByComparator)
		throws NoSuchpatientnamegeneratorException, SystemException {
		patientnamegenerator patientnamegenerator = findByPrimaryKey(patientnamegeneratorId);

		Session session = null;

		try {
			session = openSession();

			patientnamegenerator[] array = new patientnamegeneratorImpl[3];

			array[0] = getByNames_PrevAndNext(session, patientnamegenerator,
					name, type, orderByComparator, true);

			array[1] = patientnamegenerator;

			array[2] = getByNames_PrevAndNext(session, patientnamegenerator,
					name, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected patientnamegenerator getByNames_PrevAndNext(Session session,
		patientnamegenerator patientnamegenerator, String name, String type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATIENTNAMEGENERATOR_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAMES_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAMES_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAMES_NAME_2);
		}

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_NAMES_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAMES_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_NAMES_TYPE_2);
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
			query.append(patientnamegeneratorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patientnamegenerator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<patientnamegenerator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patientnamegenerators where name = &#63; and type = &#63; from the database.
	 *
	 * @param name the name
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNames(String name, String type)
		throws SystemException {
		for (patientnamegenerator patientnamegenerator : findByNames(name,
				type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patientnamegenerator);
		}
	}

	/**
	 * Returns the number of patientnamegenerators where name = &#63; and type = &#63;.
	 *
	 * @param name the name
	 * @param type the type
	 * @return the number of matching patientnamegenerators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNames(String name, String type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMES;

		Object[] finderArgs = new Object[] { name, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PATIENTNAMEGENERATOR_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMES_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMES_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMES_NAME_2);
			}

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_NAMES_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMES_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_NAMES_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (bindType) {
					qPos.add(type);
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

	private static final String _FINDER_COLUMN_NAMES_NAME_1 = "patientnamegenerator.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMES_NAME_2 = "patientnamegenerator.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMES_NAME_3 = "(patientnamegenerator.name IS NULL OR patientnamegenerator.name = '') AND ";
	private static final String _FINDER_COLUMN_NAMES_TYPE_1 = "patientnamegenerator.type IS NULL";
	private static final String _FINDER_COLUMN_NAMES_TYPE_2 = "patientnamegenerator.type = ?";
	private static final String _FINDER_COLUMN_NAMES_TYPE_3 = "(patientnamegenerator.type IS NULL OR patientnamegenerator.type = '')";

	public patientnamegeneratorPersistenceImpl() {
		setModelClass(patientnamegenerator.class);
	}

	/**
	 * Caches the patientnamegenerator in the entity cache if it is enabled.
	 *
	 * @param patientnamegenerator the patientnamegenerator
	 */
	@Override
	public void cacheResult(patientnamegenerator patientnamegenerator) {
		EntityCacheUtil.putResult(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
			patientnamegeneratorImpl.class,
			patientnamegenerator.getPrimaryKey(), patientnamegenerator);

		patientnamegenerator.resetOriginalValues();
	}

	/**
	 * Caches the patientnamegenerators in the entity cache if it is enabled.
	 *
	 * @param patientnamegenerators the patientnamegenerators
	 */
	@Override
	public void cacheResult(List<patientnamegenerator> patientnamegenerators) {
		for (patientnamegenerator patientnamegenerator : patientnamegenerators) {
			if (EntityCacheUtil.getResult(
						patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
						patientnamegeneratorImpl.class,
						patientnamegenerator.getPrimaryKey()) == null) {
				cacheResult(patientnamegenerator);
			}
			else {
				patientnamegenerator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all patientnamegenerators.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(patientnamegeneratorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(patientnamegeneratorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the patientnamegenerator.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(patientnamegenerator patientnamegenerator) {
		EntityCacheUtil.removeResult(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
			patientnamegeneratorImpl.class, patientnamegenerator.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<patientnamegenerator> patientnamegenerators) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (patientnamegenerator patientnamegenerator : patientnamegenerators) {
			EntityCacheUtil.removeResult(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
				patientnamegeneratorImpl.class,
				patientnamegenerator.getPrimaryKey());
		}
	}

	/**
	 * Creates a new patientnamegenerator with the primary key. Does not add the patientnamegenerator to the database.
	 *
	 * @param patientnamegeneratorId the primary key for the new patientnamegenerator
	 * @return the new patientnamegenerator
	 */
	@Override
	public patientnamegenerator create(long patientnamegeneratorId) {
		patientnamegenerator patientnamegenerator = new patientnamegeneratorImpl();

		patientnamegenerator.setNew(true);
		patientnamegenerator.setPrimaryKey(patientnamegeneratorId);

		return patientnamegenerator;
	}

	/**
	 * Removes the patientnamegenerator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientnamegeneratorId the primary key of the patientnamegenerator
	 * @return the patientnamegenerator that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException if a patientnamegenerator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patientnamegenerator remove(long patientnamegeneratorId)
		throws NoSuchpatientnamegeneratorException, SystemException {
		return remove((Serializable)patientnamegeneratorId);
	}

	/**
	 * Removes the patientnamegenerator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the patientnamegenerator
	 * @return the patientnamegenerator that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException if a patientnamegenerator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patientnamegenerator remove(Serializable primaryKey)
		throws NoSuchpatientnamegeneratorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			patientnamegenerator patientnamegenerator = (patientnamegenerator)session.get(patientnamegeneratorImpl.class,
					primaryKey);

			if (patientnamegenerator == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchpatientnamegeneratorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(patientnamegenerator);
		}
		catch (NoSuchpatientnamegeneratorException nsee) {
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
	protected patientnamegenerator removeImpl(
		patientnamegenerator patientnamegenerator) throws SystemException {
		patientnamegenerator = toUnwrappedModel(patientnamegenerator);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(patientnamegenerator)) {
				patientnamegenerator = (patientnamegenerator)session.get(patientnamegeneratorImpl.class,
						patientnamegenerator.getPrimaryKeyObj());
			}

			if (patientnamegenerator != null) {
				session.delete(patientnamegenerator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (patientnamegenerator != null) {
			clearCache(patientnamegenerator);
		}

		return patientnamegenerator;
	}

	@Override
	public patientnamegenerator updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator patientnamegenerator)
		throws SystemException {
		patientnamegenerator = toUnwrappedModel(patientnamegenerator);

		boolean isNew = patientnamegenerator.isNew();

		patientnamegeneratorModelImpl patientnamegeneratorModelImpl = (patientnamegeneratorModelImpl)patientnamegenerator;

		Session session = null;

		try {
			session = openSession();

			if (patientnamegenerator.isNew()) {
				session.save(patientnamegenerator);

				patientnamegenerator.setNew(false);
			}
			else {
				session.merge(patientnamegenerator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !patientnamegeneratorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((patientnamegeneratorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientnamegeneratorModelImpl.getOriginalName(),
						patientnamegeneratorModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMES, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMES,
					args);

				args = new Object[] {
						patientnamegeneratorModelImpl.getName(),
						patientnamegeneratorModelImpl.getType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMES, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMES,
					args);
			}
		}

		EntityCacheUtil.putResult(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
			patientnamegeneratorImpl.class,
			patientnamegenerator.getPrimaryKey(), patientnamegenerator);

		return patientnamegenerator;
	}

	protected patientnamegenerator toUnwrappedModel(
		patientnamegenerator patientnamegenerator) {
		if (patientnamegenerator instanceof patientnamegeneratorImpl) {
			return patientnamegenerator;
		}

		patientnamegeneratorImpl patientnamegeneratorImpl = new patientnamegeneratorImpl();

		patientnamegeneratorImpl.setNew(patientnamegenerator.isNew());
		patientnamegeneratorImpl.setPrimaryKey(patientnamegenerator.getPrimaryKey());

		patientnamegeneratorImpl.setPatientnamegeneratorId(patientnamegenerator.getPatientnamegeneratorId());
		patientnamegeneratorImpl.setName(patientnamegenerator.getName());
		patientnamegeneratorImpl.setType(patientnamegenerator.getType());

		return patientnamegeneratorImpl;
	}

	/**
	 * Returns the patientnamegenerator with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the patientnamegenerator
	 * @return the patientnamegenerator
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException if a patientnamegenerator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patientnamegenerator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchpatientnamegeneratorException, SystemException {
		patientnamegenerator patientnamegenerator = fetchByPrimaryKey(primaryKey);

		if (patientnamegenerator == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchpatientnamegeneratorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return patientnamegenerator;
	}

	/**
	 * Returns the patientnamegenerator with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException} if it could not be found.
	 *
	 * @param patientnamegeneratorId the primary key of the patientnamegenerator
	 * @return the patientnamegenerator
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException if a patientnamegenerator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patientnamegenerator findByPrimaryKey(long patientnamegeneratorId)
		throws NoSuchpatientnamegeneratorException, SystemException {
		return findByPrimaryKey((Serializable)patientnamegeneratorId);
	}

	/**
	 * Returns the patientnamegenerator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the patientnamegenerator
	 * @return the patientnamegenerator, or <code>null</code> if a patientnamegenerator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patientnamegenerator fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		patientnamegenerator patientnamegenerator = (patientnamegenerator)EntityCacheUtil.getResult(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
				patientnamegeneratorImpl.class, primaryKey);

		if (patientnamegenerator == _nullpatientnamegenerator) {
			return null;
		}

		if (patientnamegenerator == null) {
			Session session = null;

			try {
				session = openSession();

				patientnamegenerator = (patientnamegenerator)session.get(patientnamegeneratorImpl.class,
						primaryKey);

				if (patientnamegenerator != null) {
					cacheResult(patientnamegenerator);
				}
				else {
					EntityCacheUtil.putResult(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
						patientnamegeneratorImpl.class, primaryKey,
						_nullpatientnamegenerator);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(patientnamegeneratorModelImpl.ENTITY_CACHE_ENABLED,
					patientnamegeneratorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return patientnamegenerator;
	}

	/**
	 * Returns the patientnamegenerator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patientnamegeneratorId the primary key of the patientnamegenerator
	 * @return the patientnamegenerator, or <code>null</code> if a patientnamegenerator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patientnamegenerator fetchByPrimaryKey(long patientnamegeneratorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)patientnamegeneratorId);
	}

	/**
	 * Returns all the patientnamegenerators.
	 *
	 * @return the patientnamegenerators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<patientnamegenerator> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patientnamegenerators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.patientnamegeneratorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of patientnamegenerators
	 * @param end the upper bound of the range of patientnamegenerators (not inclusive)
	 * @return the range of patientnamegenerators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<patientnamegenerator> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the patientnamegenerators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.patientnamegeneratorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of patientnamegenerators
	 * @param end the upper bound of the range of patientnamegenerators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patientnamegenerators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<patientnamegenerator> findAll(int start, int end,
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

		List<patientnamegenerator> list = (List<patientnamegenerator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PATIENTNAMEGENERATOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PATIENTNAMEGENERATOR;

				if (pagination) {
					sql = sql.concat(patientnamegeneratorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<patientnamegenerator>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<patientnamegenerator>(list);
				}
				else {
					list = (List<patientnamegenerator>)QueryUtil.list(q,
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
	 * Removes all the patientnamegenerators from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (patientnamegenerator patientnamegenerator : findAll()) {
			remove(patientnamegenerator);
		}
	}

	/**
	 * Returns the number of patientnamegenerators.
	 *
	 * @return the number of patientnamegenerators
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

				Query q = session.createQuery(_SQL_COUNT_PATIENTNAMEGENERATOR);

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
	 * Initializes the patientnamegenerator persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<patientnamegenerator>> listenersList = new ArrayList<ModelListener<patientnamegenerator>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<patientnamegenerator>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(patientnamegeneratorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PATIENTNAMEGENERATOR = "SELECT patientnamegenerator FROM patientnamegenerator patientnamegenerator";
	private static final String _SQL_SELECT_PATIENTNAMEGENERATOR_WHERE = "SELECT patientnamegenerator FROM patientnamegenerator patientnamegenerator WHERE ";
	private static final String _SQL_COUNT_PATIENTNAMEGENERATOR = "SELECT COUNT(patientnamegenerator) FROM patientnamegenerator patientnamegenerator";
	private static final String _SQL_COUNT_PATIENTNAMEGENERATOR_WHERE = "SELECT COUNT(patientnamegenerator) FROM patientnamegenerator patientnamegenerator WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "patientnamegenerator.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No patientnamegenerator exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No patientnamegenerator exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(patientnamegeneratorPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static patientnamegenerator _nullpatientnamegenerator = new patientnamegeneratorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<patientnamegenerator> toCacheModel() {
				return _nullpatientnamegeneratorCacheModel;
			}
		};

	private static CacheModel<patientnamegenerator> _nullpatientnamegeneratorCacheModel =
		new CacheModel<patientnamegenerator>() {
			@Override
			public patientnamegenerator toEntityModel() {
				return _nullpatientnamegenerator;
			}
		};
}