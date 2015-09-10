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

package at.graz.hmmc.liferay.portlet.puch.service.persistence;

import at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException;
import at.graz.hmmc.liferay.portlet.puch.model.Transaktion;
import at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionImpl;
import at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl;

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
 * The persistence implementation for the transaktion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see TransaktionPersistence
 * @see TransaktionUtil
 * @generated
 */
public class TransaktionPersistenceImpl extends BasePersistenceImpl<Transaktion>
	implements TransaktionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TransaktionUtil} to access the transaktion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TransaktionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionModelImpl.FINDER_CACHE_ENABLED, TransaktionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionModelImpl.FINDER_CACHE_ENABLED, TransaktionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYP = new FinderPath(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionModelImpl.FINDER_CACHE_ENABLED, TransaktionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTyp",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP = new FinderPath(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionModelImpl.FINDER_CACHE_ENABLED, TransaktionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTyp",
			new String[] { String.class.getName() },
			TransaktionModelImpl.TYP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYP = new FinderPath(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTyp",
			new String[] { String.class.getName() });

	/**
	 * Returns all the transaktions where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the matching transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Transaktion> findByTyp(String typ) throws SystemException {
		return findByTyp(typ, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the transaktions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of transaktions
	 * @param end the upper bound of the range of transaktions (not inclusive)
	 * @return the range of matching transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Transaktion> findByTyp(String typ, int start, int end)
		throws SystemException {
		return findByTyp(typ, start, end, null);
	}

	/**
	 * Returns an ordered range of all the transaktions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of transaktions
	 * @param end the upper bound of the range of transaktions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Transaktion> findByTyp(String typ, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP;
			finderArgs = new Object[] { typ };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYP;
			finderArgs = new Object[] { typ, start, end, orderByComparator };
		}

		List<Transaktion> list = (List<Transaktion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Transaktion transaktion : list) {
				if (!Validator.equals(typ, transaktion.getTyp())) {
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

			query.append(_SQL_SELECT_TRANSAKTION_WHERE);

			boolean bindTyp = false;

			if (typ == null) {
				query.append(_FINDER_COLUMN_TYP_TYP_1);
			}
			else if (typ.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYP_TYP_3);
			}
			else {
				bindTyp = true;

				query.append(_FINDER_COLUMN_TYP_TYP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TransaktionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTyp) {
					qPos.add(typ);
				}

				if (!pagination) {
					list = (List<Transaktion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Transaktion>(list);
				}
				else {
					list = (List<Transaktion>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first transaktion in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transaktion
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a matching transaktion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion findByTyp_First(String typ,
		OrderByComparator orderByComparator)
		throws NoSuchTransaktionException, SystemException {
		Transaktion transaktion = fetchByTyp_First(typ, orderByComparator);

		if (transaktion != null) {
			return transaktion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typ=");
		msg.append(typ);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTransaktionException(msg.toString());
	}

	/**
	 * Returns the first transaktion in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transaktion, or <code>null</code> if a matching transaktion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion fetchByTyp_First(String typ,
		OrderByComparator orderByComparator) throws SystemException {
		List<Transaktion> list = findByTyp(typ, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last transaktion in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transaktion
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a matching transaktion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion findByTyp_Last(String typ,
		OrderByComparator orderByComparator)
		throws NoSuchTransaktionException, SystemException {
		Transaktion transaktion = fetchByTyp_Last(typ, orderByComparator);

		if (transaktion != null) {
			return transaktion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typ=");
		msg.append(typ);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTransaktionException(msg.toString());
	}

	/**
	 * Returns the last transaktion in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transaktion, or <code>null</code> if a matching transaktion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion fetchByTyp_Last(String typ,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTyp(typ);

		if (count == 0) {
			return null;
		}

		List<Transaktion> list = findByTyp(typ, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the transaktions before and after the current transaktion in the ordered set where typ = &#63;.
	 *
	 * @param transaktionId the primary key of the current transaktion
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next transaktion
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a transaktion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion[] findByTyp_PrevAndNext(long transaktionId, String typ,
		OrderByComparator orderByComparator)
		throws NoSuchTransaktionException, SystemException {
		Transaktion transaktion = findByPrimaryKey(transaktionId);

		Session session = null;

		try {
			session = openSession();

			Transaktion[] array = new TransaktionImpl[3];

			array[0] = getByTyp_PrevAndNext(session, transaktion, typ,
					orderByComparator, true);

			array[1] = transaktion;

			array[2] = getByTyp_PrevAndNext(session, transaktion, typ,
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

	protected Transaktion getByTyp_PrevAndNext(Session session,
		Transaktion transaktion, String typ,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRANSAKTION_WHERE);

		boolean bindTyp = false;

		if (typ == null) {
			query.append(_FINDER_COLUMN_TYP_TYP_1);
		}
		else if (typ.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYP_TYP_3);
		}
		else {
			bindTyp = true;

			query.append(_FINDER_COLUMN_TYP_TYP_2);
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
			query.append(TransaktionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTyp) {
			qPos.add(typ);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(transaktion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Transaktion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the transaktions where typ = &#63; from the database.
	 *
	 * @param typ the typ
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTyp(String typ) throws SystemException {
		for (Transaktion transaktion : findByTyp(typ, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(transaktion);
		}
	}

	/**
	 * Returns the number of transaktions where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the number of matching transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTyp(String typ) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYP;

		Object[] finderArgs = new Object[] { typ };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANSAKTION_WHERE);

			boolean bindTyp = false;

			if (typ == null) {
				query.append(_FINDER_COLUMN_TYP_TYP_1);
			}
			else if (typ.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYP_TYP_3);
			}
			else {
				bindTyp = true;

				query.append(_FINDER_COLUMN_TYP_TYP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTyp) {
					qPos.add(typ);
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

	private static final String _FINDER_COLUMN_TYP_TYP_1 = "transaktion.typ IS NULL";
	private static final String _FINDER_COLUMN_TYP_TYP_2 = "transaktion.typ = ?";
	private static final String _FINDER_COLUMN_TYP_TYP_3 = "(transaktion.typ IS NULL OR transaktion.typ = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPANDOBJECT =
		new FinderPath(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionModelImpl.FINDER_CACHE_ENABLED, TransaktionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTypAndObject",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPANDOBJECT =
		new FinderPath(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionModelImpl.FINDER_CACHE_ENABLED, TransaktionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTypAndObject",
			new String[] { String.class.getName(), Long.class.getName() },
			TransaktionModelImpl.TYP_COLUMN_BITMASK |
			TransaktionModelImpl.PUCHMUSEUMSOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPANDOBJECT = new FinderPath(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypAndObject",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the transaktions where typ = &#63; and puchmuseumsobjectId = &#63;.
	 *
	 * @param typ the typ
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @return the matching transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Transaktion> findByTypAndObject(String typ,
		long puchmuseumsobjectId) throws SystemException {
		return findByTypAndObject(typ, puchmuseumsobjectId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the transaktions where typ = &#63; and puchmuseumsobjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typ the typ
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param start the lower bound of the range of transaktions
	 * @param end the upper bound of the range of transaktions (not inclusive)
	 * @return the range of matching transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Transaktion> findByTypAndObject(String typ,
		long puchmuseumsobjectId, int start, int end) throws SystemException {
		return findByTypAndObject(typ, puchmuseumsobjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the transaktions where typ = &#63; and puchmuseumsobjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typ the typ
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param start the lower bound of the range of transaktions
	 * @param end the upper bound of the range of transaktions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Transaktion> findByTypAndObject(String typ,
		long puchmuseumsobjectId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPANDOBJECT;
			finderArgs = new Object[] { typ, puchmuseumsobjectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPANDOBJECT;
			finderArgs = new Object[] {
					typ, puchmuseumsobjectId,
					
					start, end, orderByComparator
				};
		}

		List<Transaktion> list = (List<Transaktion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Transaktion transaktion : list) {
				if (!Validator.equals(typ, transaktion.getTyp()) ||
						(puchmuseumsobjectId != transaktion.getPuchmuseumsobjectId())) {
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

			query.append(_SQL_SELECT_TRANSAKTION_WHERE);

			boolean bindTyp = false;

			if (typ == null) {
				query.append(_FINDER_COLUMN_TYPANDOBJECT_TYP_1);
			}
			else if (typ.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPANDOBJECT_TYP_3);
			}
			else {
				bindTyp = true;

				query.append(_FINDER_COLUMN_TYPANDOBJECT_TYP_2);
			}

			query.append(_FINDER_COLUMN_TYPANDOBJECT_PUCHMUSEUMSOBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TransaktionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTyp) {
					qPos.add(typ);
				}

				qPos.add(puchmuseumsobjectId);

				if (!pagination) {
					list = (List<Transaktion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Transaktion>(list);
				}
				else {
					list = (List<Transaktion>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first transaktion in the ordered set where typ = &#63; and puchmuseumsobjectId = &#63;.
	 *
	 * @param typ the typ
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transaktion
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a matching transaktion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion findByTypAndObject_First(String typ,
		long puchmuseumsobjectId, OrderByComparator orderByComparator)
		throws NoSuchTransaktionException, SystemException {
		Transaktion transaktion = fetchByTypAndObject_First(typ,
				puchmuseumsobjectId, orderByComparator);

		if (transaktion != null) {
			return transaktion;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typ=");
		msg.append(typ);

		msg.append(", puchmuseumsobjectId=");
		msg.append(puchmuseumsobjectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTransaktionException(msg.toString());
	}

	/**
	 * Returns the first transaktion in the ordered set where typ = &#63; and puchmuseumsobjectId = &#63;.
	 *
	 * @param typ the typ
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transaktion, or <code>null</code> if a matching transaktion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion fetchByTypAndObject_First(String typ,
		long puchmuseumsobjectId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Transaktion> list = findByTypAndObject(typ, puchmuseumsobjectId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last transaktion in the ordered set where typ = &#63; and puchmuseumsobjectId = &#63;.
	 *
	 * @param typ the typ
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transaktion
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a matching transaktion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion findByTypAndObject_Last(String typ,
		long puchmuseumsobjectId, OrderByComparator orderByComparator)
		throws NoSuchTransaktionException, SystemException {
		Transaktion transaktion = fetchByTypAndObject_Last(typ,
				puchmuseumsobjectId, orderByComparator);

		if (transaktion != null) {
			return transaktion;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typ=");
		msg.append(typ);

		msg.append(", puchmuseumsobjectId=");
		msg.append(puchmuseumsobjectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTransaktionException(msg.toString());
	}

	/**
	 * Returns the last transaktion in the ordered set where typ = &#63; and puchmuseumsobjectId = &#63;.
	 *
	 * @param typ the typ
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transaktion, or <code>null</code> if a matching transaktion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion fetchByTypAndObject_Last(String typ,
		long puchmuseumsobjectId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTypAndObject(typ, puchmuseumsobjectId);

		if (count == 0) {
			return null;
		}

		List<Transaktion> list = findByTypAndObject(typ, puchmuseumsobjectId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the transaktions before and after the current transaktion in the ordered set where typ = &#63; and puchmuseumsobjectId = &#63;.
	 *
	 * @param transaktionId the primary key of the current transaktion
	 * @param typ the typ
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next transaktion
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a transaktion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion[] findByTypAndObject_PrevAndNext(long transaktionId,
		String typ, long puchmuseumsobjectId,
		OrderByComparator orderByComparator)
		throws NoSuchTransaktionException, SystemException {
		Transaktion transaktion = findByPrimaryKey(transaktionId);

		Session session = null;

		try {
			session = openSession();

			Transaktion[] array = new TransaktionImpl[3];

			array[0] = getByTypAndObject_PrevAndNext(session, transaktion, typ,
					puchmuseumsobjectId, orderByComparator, true);

			array[1] = transaktion;

			array[2] = getByTypAndObject_PrevAndNext(session, transaktion, typ,
					puchmuseumsobjectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Transaktion getByTypAndObject_PrevAndNext(Session session,
		Transaktion transaktion, String typ, long puchmuseumsobjectId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRANSAKTION_WHERE);

		boolean bindTyp = false;

		if (typ == null) {
			query.append(_FINDER_COLUMN_TYPANDOBJECT_TYP_1);
		}
		else if (typ.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPANDOBJECT_TYP_3);
		}
		else {
			bindTyp = true;

			query.append(_FINDER_COLUMN_TYPANDOBJECT_TYP_2);
		}

		query.append(_FINDER_COLUMN_TYPANDOBJECT_PUCHMUSEUMSOBJECTID_2);

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
			query.append(TransaktionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTyp) {
			qPos.add(typ);
		}

		qPos.add(puchmuseumsobjectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(transaktion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Transaktion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the transaktions where typ = &#63; and puchmuseumsobjectId = &#63; from the database.
	 *
	 * @param typ the typ
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTypAndObject(String typ, long puchmuseumsobjectId)
		throws SystemException {
		for (Transaktion transaktion : findByTypAndObject(typ,
				puchmuseumsobjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(transaktion);
		}
	}

	/**
	 * Returns the number of transaktions where typ = &#63; and puchmuseumsobjectId = &#63;.
	 *
	 * @param typ the typ
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @return the number of matching transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypAndObject(String typ, long puchmuseumsobjectId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPANDOBJECT;

		Object[] finderArgs = new Object[] { typ, puchmuseumsobjectId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRANSAKTION_WHERE);

			boolean bindTyp = false;

			if (typ == null) {
				query.append(_FINDER_COLUMN_TYPANDOBJECT_TYP_1);
			}
			else if (typ.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPANDOBJECT_TYP_3);
			}
			else {
				bindTyp = true;

				query.append(_FINDER_COLUMN_TYPANDOBJECT_TYP_2);
			}

			query.append(_FINDER_COLUMN_TYPANDOBJECT_PUCHMUSEUMSOBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTyp) {
					qPos.add(typ);
				}

				qPos.add(puchmuseumsobjectId);

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

	private static final String _FINDER_COLUMN_TYPANDOBJECT_TYP_1 = "transaktion.typ IS NULL AND ";
	private static final String _FINDER_COLUMN_TYPANDOBJECT_TYP_2 = "transaktion.typ = ? AND ";
	private static final String _FINDER_COLUMN_TYPANDOBJECT_TYP_3 = "(transaktion.typ IS NULL OR transaktion.typ = '') AND ";
	private static final String _FINDER_COLUMN_TYPANDOBJECT_PUCHMUSEUMSOBJECTID_2 =
		"transaktion.puchmuseumsobjectId = ?";

	public TransaktionPersistenceImpl() {
		setModelClass(Transaktion.class);
	}

	/**
	 * Caches the transaktion in the entity cache if it is enabled.
	 *
	 * @param transaktion the transaktion
	 */
	@Override
	public void cacheResult(Transaktion transaktion) {
		EntityCacheUtil.putResult(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionImpl.class, transaktion.getPrimaryKey(), transaktion);

		transaktion.resetOriginalValues();
	}

	/**
	 * Caches the transaktions in the entity cache if it is enabled.
	 *
	 * @param transaktions the transaktions
	 */
	@Override
	public void cacheResult(List<Transaktion> transaktions) {
		for (Transaktion transaktion : transaktions) {
			if (EntityCacheUtil.getResult(
						TransaktionModelImpl.ENTITY_CACHE_ENABLED,
						TransaktionImpl.class, transaktion.getPrimaryKey()) == null) {
				cacheResult(transaktion);
			}
			else {
				transaktion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all transaktions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TransaktionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TransaktionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the transaktion.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Transaktion transaktion) {
		EntityCacheUtil.removeResult(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionImpl.class, transaktion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Transaktion> transaktions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Transaktion transaktion : transaktions) {
			EntityCacheUtil.removeResult(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
				TransaktionImpl.class, transaktion.getPrimaryKey());
		}
	}

	/**
	 * Creates a new transaktion with the primary key. Does not add the transaktion to the database.
	 *
	 * @param transaktionId the primary key for the new transaktion
	 * @return the new transaktion
	 */
	@Override
	public Transaktion create(long transaktionId) {
		Transaktion transaktion = new TransaktionImpl();

		transaktion.setNew(true);
		transaktion.setPrimaryKey(transaktionId);

		return transaktion;
	}

	/**
	 * Removes the transaktion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transaktionId the primary key of the transaktion
	 * @return the transaktion that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a transaktion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion remove(long transaktionId)
		throws NoSuchTransaktionException, SystemException {
		return remove((Serializable)transaktionId);
	}

	/**
	 * Removes the transaktion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the transaktion
	 * @return the transaktion that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a transaktion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion remove(Serializable primaryKey)
		throws NoSuchTransaktionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Transaktion transaktion = (Transaktion)session.get(TransaktionImpl.class,
					primaryKey);

			if (transaktion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTransaktionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(transaktion);
		}
		catch (NoSuchTransaktionException nsee) {
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
	protected Transaktion removeImpl(Transaktion transaktion)
		throws SystemException {
		transaktion = toUnwrappedModel(transaktion);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(transaktion)) {
				transaktion = (Transaktion)session.get(TransaktionImpl.class,
						transaktion.getPrimaryKeyObj());
			}

			if (transaktion != null) {
				session.delete(transaktion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (transaktion != null) {
			clearCache(transaktion);
		}

		return transaktion;
	}

	@Override
	public Transaktion updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.Transaktion transaktion)
		throws SystemException {
		transaktion = toUnwrappedModel(transaktion);

		boolean isNew = transaktion.isNew();

		TransaktionModelImpl transaktionModelImpl = (TransaktionModelImpl)transaktion;

		Session session = null;

		try {
			session = openSession();

			if (transaktion.isNew()) {
				session.save(transaktion);

				transaktion.setNew(false);
			}
			else {
				session.merge(transaktion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TransaktionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((transaktionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						transaktionModelImpl.getOriginalTyp()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP,
					args);

				args = new Object[] { transaktionModelImpl.getTyp() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP,
					args);
			}

			if ((transaktionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPANDOBJECT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						transaktionModelImpl.getOriginalTyp(),
						transaktionModelImpl.getOriginalPuchmuseumsobjectId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPANDOBJECT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPANDOBJECT,
					args);

				args = new Object[] {
						transaktionModelImpl.getTyp(),
						transaktionModelImpl.getPuchmuseumsobjectId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPANDOBJECT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPANDOBJECT,
					args);
			}
		}

		EntityCacheUtil.putResult(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionImpl.class, transaktion.getPrimaryKey(), transaktion);

		return transaktion;
	}

	protected Transaktion toUnwrappedModel(Transaktion transaktion) {
		if (transaktion instanceof TransaktionImpl) {
			return transaktion;
		}

		TransaktionImpl transaktionImpl = new TransaktionImpl();

		transaktionImpl.setNew(transaktion.isNew());
		transaktionImpl.setPrimaryKey(transaktion.getPrimaryKey());

		transaktionImpl.setTransaktionId(transaktion.getTransaktionId());
		transaktionImpl.setCreaterUserId(transaktion.getCreaterUserId());
		transaktionImpl.setCreateDate(transaktion.getCreateDate());
		transaktionImpl.setModifiedUserId(transaktion.getModifiedUserId());
		transaktionImpl.setModifiedDate(transaktion.getModifiedDate());
		transaktionImpl.setTyp(transaktion.getTyp());
		transaktionImpl.setPuchmuseumsobjectId(transaktion.getPuchmuseumsobjectId());
		transaktionImpl.setStartDate(transaktion.getStartDate());
		transaktionImpl.setEndDate(transaktion.getEndDate());

		return transaktionImpl;
	}

	/**
	 * Returns the transaktion with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the transaktion
	 * @return the transaktion
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a transaktion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTransaktionException, SystemException {
		Transaktion transaktion = fetchByPrimaryKey(primaryKey);

		if (transaktion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTransaktionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return transaktion;
	}

	/**
	 * Returns the transaktion with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException} if it could not be found.
	 *
	 * @param transaktionId the primary key of the transaktion
	 * @return the transaktion
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a transaktion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion findByPrimaryKey(long transaktionId)
		throws NoSuchTransaktionException, SystemException {
		return findByPrimaryKey((Serializable)transaktionId);
	}

	/**
	 * Returns the transaktion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the transaktion
	 * @return the transaktion, or <code>null</code> if a transaktion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Transaktion transaktion = (Transaktion)EntityCacheUtil.getResult(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
				TransaktionImpl.class, primaryKey);

		if (transaktion == _nullTransaktion) {
			return null;
		}

		if (transaktion == null) {
			Session session = null;

			try {
				session = openSession();

				transaktion = (Transaktion)session.get(TransaktionImpl.class,
						primaryKey);

				if (transaktion != null) {
					cacheResult(transaktion);
				}
				else {
					EntityCacheUtil.putResult(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
						TransaktionImpl.class, primaryKey, _nullTransaktion);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TransaktionModelImpl.ENTITY_CACHE_ENABLED,
					TransaktionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return transaktion;
	}

	/**
	 * Returns the transaktion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transaktionId the primary key of the transaktion
	 * @return the transaktion, or <code>null</code> if a transaktion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion fetchByPrimaryKey(long transaktionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)transaktionId);
	}

	/**
	 * Returns all the transaktions.
	 *
	 * @return the transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Transaktion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the transaktions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaktions
	 * @param end the upper bound of the range of transaktions (not inclusive)
	 * @return the range of transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Transaktion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the transaktions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaktions
	 * @param end the upper bound of the range of transaktions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Transaktion> findAll(int start, int end,
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

		List<Transaktion> list = (List<Transaktion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRANSAKTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRANSAKTION;

				if (pagination) {
					sql = sql.concat(TransaktionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Transaktion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Transaktion>(list);
				}
				else {
					list = (List<Transaktion>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the transaktions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Transaktion transaktion : findAll()) {
			remove(transaktion);
		}
	}

	/**
	 * Returns the number of transaktions.
	 *
	 * @return the number of transaktions
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

				Query q = session.createQuery(_SQL_COUNT_TRANSAKTION);

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
	 * Initializes the transaktion persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.hmmc.liferay.portlet.puch.model.Transaktion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Transaktion>> listenersList = new ArrayList<ModelListener<Transaktion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Transaktion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TransaktionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TRANSAKTION = "SELECT transaktion FROM Transaktion transaktion";
	private static final String _SQL_SELECT_TRANSAKTION_WHERE = "SELECT transaktion FROM Transaktion transaktion WHERE ";
	private static final String _SQL_COUNT_TRANSAKTION = "SELECT COUNT(transaktion) FROM Transaktion transaktion";
	private static final String _SQL_COUNT_TRANSAKTION_WHERE = "SELECT COUNT(transaktion) FROM Transaktion transaktion WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "transaktion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Transaktion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Transaktion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TransaktionPersistenceImpl.class);
	private static Transaktion _nullTransaktion = new TransaktionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Transaktion> toCacheModel() {
				return _nullTransaktionCacheModel;
			}
		};

	private static CacheModel<Transaktion> _nullTransaktionCacheModel = new CacheModel<Transaktion>() {
			@Override
			public Transaktion toEntityModel() {
				return _nullTransaktion;
			}
		};
}