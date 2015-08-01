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

import at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException;
import at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug;
import at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugImpl;
import at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugModelImpl;

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
 * The persistence implementation for the fahrzeug service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see FahrzeugPersistence
 * @see FahrzeugUtil
 * @generated
 */
public class FahrzeugPersistenceImpl extends BasePersistenceImpl<Fahrzeug>
	implements FahrzeugPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FahrzeugUtil} to access the fahrzeug persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FahrzeugImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
			FahrzeugModelImpl.FINDER_CACHE_ENABLED, FahrzeugImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
			FahrzeugModelImpl.FINDER_CACHE_ENABLED, FahrzeugImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
			FahrzeugModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYP = new FinderPath(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
			FahrzeugModelImpl.FINDER_CACHE_ENABLED, FahrzeugImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTyp",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP = new FinderPath(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
			FahrzeugModelImpl.FINDER_CACHE_ENABLED, FahrzeugImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTyp",
			new String[] { String.class.getName() },
			FahrzeugModelImpl.TYP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYP = new FinderPath(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
			FahrzeugModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTyp",
			new String[] { String.class.getName() });

	/**
	 * Returns all the fahrzeugs where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the matching fahrzeugs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fahrzeug> findByTyp(String typ) throws SystemException {
		return findByTyp(typ, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fahrzeugs where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of fahrzeugs
	 * @param end the upper bound of the range of fahrzeugs (not inclusive)
	 * @return the range of matching fahrzeugs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fahrzeug> findByTyp(String typ, int start, int end)
		throws SystemException {
		return findByTyp(typ, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fahrzeugs where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of fahrzeugs
	 * @param end the upper bound of the range of fahrzeugs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fahrzeugs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fahrzeug> findByTyp(String typ, int start, int end,
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

		List<Fahrzeug> list = (List<Fahrzeug>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Fahrzeug fahrzeug : list) {
				if (!Validator.equals(typ, fahrzeug.getTyp())) {
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

			query.append(_SQL_SELECT_FAHRZEUG_WHERE);

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
				query.append(FahrzeugModelImpl.ORDER_BY_JPQL);
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
					list = (List<Fahrzeug>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Fahrzeug>(list);
				}
				else {
					list = (List<Fahrzeug>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fahrzeug in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fahrzeug
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException if a matching fahrzeug could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fahrzeug findByTyp_First(String typ,
		OrderByComparator orderByComparator)
		throws NoSuchFahrzeugException, SystemException {
		Fahrzeug fahrzeug = fetchByTyp_First(typ, orderByComparator);

		if (fahrzeug != null) {
			return fahrzeug;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typ=");
		msg.append(typ);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFahrzeugException(msg.toString());
	}

	/**
	 * Returns the first fahrzeug in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fahrzeug, or <code>null</code> if a matching fahrzeug could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fahrzeug fetchByTyp_First(String typ,
		OrderByComparator orderByComparator) throws SystemException {
		List<Fahrzeug> list = findByTyp(typ, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fahrzeug in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fahrzeug
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException if a matching fahrzeug could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fahrzeug findByTyp_Last(String typ,
		OrderByComparator orderByComparator)
		throws NoSuchFahrzeugException, SystemException {
		Fahrzeug fahrzeug = fetchByTyp_Last(typ, orderByComparator);

		if (fahrzeug != null) {
			return fahrzeug;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typ=");
		msg.append(typ);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFahrzeugException(msg.toString());
	}

	/**
	 * Returns the last fahrzeug in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fahrzeug, or <code>null</code> if a matching fahrzeug could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fahrzeug fetchByTyp_Last(String typ,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTyp(typ);

		if (count == 0) {
			return null;
		}

		List<Fahrzeug> list = findByTyp(typ, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fahrzeugs before and after the current fahrzeug in the ordered set where typ = &#63;.
	 *
	 * @param fahrzeugId the primary key of the current fahrzeug
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fahrzeug
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException if a fahrzeug with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fahrzeug[] findByTyp_PrevAndNext(long fahrzeugId, String typ,
		OrderByComparator orderByComparator)
		throws NoSuchFahrzeugException, SystemException {
		Fahrzeug fahrzeug = findByPrimaryKey(fahrzeugId);

		Session session = null;

		try {
			session = openSession();

			Fahrzeug[] array = new FahrzeugImpl[3];

			array[0] = getByTyp_PrevAndNext(session, fahrzeug, typ,
					orderByComparator, true);

			array[1] = fahrzeug;

			array[2] = getByTyp_PrevAndNext(session, fahrzeug, typ,
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

	protected Fahrzeug getByTyp_PrevAndNext(Session session, Fahrzeug fahrzeug,
		String typ, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAHRZEUG_WHERE);

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
			query.append(FahrzeugModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(fahrzeug);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Fahrzeug> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fahrzeugs where typ = &#63; from the database.
	 *
	 * @param typ the typ
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTyp(String typ) throws SystemException {
		for (Fahrzeug fahrzeug : findByTyp(typ, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(fahrzeug);
		}
	}

	/**
	 * Returns the number of fahrzeugs where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the number of matching fahrzeugs
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

			query.append(_SQL_COUNT_FAHRZEUG_WHERE);

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

	private static final String _FINDER_COLUMN_TYP_TYP_1 = "fahrzeug.typ IS NULL";
	private static final String _FINDER_COLUMN_TYP_TYP_2 = "fahrzeug.typ = ?";
	private static final String _FINDER_COLUMN_TYP_TYP_3 = "(fahrzeug.typ IS NULL OR fahrzeug.typ = '')";

	public FahrzeugPersistenceImpl() {
		setModelClass(Fahrzeug.class);
	}

	/**
	 * Caches the fahrzeug in the entity cache if it is enabled.
	 *
	 * @param fahrzeug the fahrzeug
	 */
	@Override
	public void cacheResult(Fahrzeug fahrzeug) {
		EntityCacheUtil.putResult(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
			FahrzeugImpl.class, fahrzeug.getPrimaryKey(), fahrzeug);

		fahrzeug.resetOriginalValues();
	}

	/**
	 * Caches the fahrzeugs in the entity cache if it is enabled.
	 *
	 * @param fahrzeugs the fahrzeugs
	 */
	@Override
	public void cacheResult(List<Fahrzeug> fahrzeugs) {
		for (Fahrzeug fahrzeug : fahrzeugs) {
			if (EntityCacheUtil.getResult(
						FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
						FahrzeugImpl.class, fahrzeug.getPrimaryKey()) == null) {
				cacheResult(fahrzeug);
			}
			else {
				fahrzeug.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fahrzeugs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FahrzeugImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FahrzeugImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fahrzeug.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Fahrzeug fahrzeug) {
		EntityCacheUtil.removeResult(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
			FahrzeugImpl.class, fahrzeug.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Fahrzeug> fahrzeugs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Fahrzeug fahrzeug : fahrzeugs) {
			EntityCacheUtil.removeResult(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
				FahrzeugImpl.class, fahrzeug.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fahrzeug with the primary key. Does not add the fahrzeug to the database.
	 *
	 * @param fahrzeugId the primary key for the new fahrzeug
	 * @return the new fahrzeug
	 */
	@Override
	public Fahrzeug create(long fahrzeugId) {
		Fahrzeug fahrzeug = new FahrzeugImpl();

		fahrzeug.setNew(true);
		fahrzeug.setPrimaryKey(fahrzeugId);

		return fahrzeug;
	}

	/**
	 * Removes the fahrzeug with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fahrzeugId the primary key of the fahrzeug
	 * @return the fahrzeug that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException if a fahrzeug with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fahrzeug remove(long fahrzeugId)
		throws NoSuchFahrzeugException, SystemException {
		return remove((Serializable)fahrzeugId);
	}

	/**
	 * Removes the fahrzeug with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fahrzeug
	 * @return the fahrzeug that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException if a fahrzeug with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fahrzeug remove(Serializable primaryKey)
		throws NoSuchFahrzeugException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Fahrzeug fahrzeug = (Fahrzeug)session.get(FahrzeugImpl.class,
					primaryKey);

			if (fahrzeug == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFahrzeugException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fahrzeug);
		}
		catch (NoSuchFahrzeugException nsee) {
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
	protected Fahrzeug removeImpl(Fahrzeug fahrzeug) throws SystemException {
		fahrzeug = toUnwrappedModel(fahrzeug);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fahrzeug)) {
				fahrzeug = (Fahrzeug)session.get(FahrzeugImpl.class,
						fahrzeug.getPrimaryKeyObj());
			}

			if (fahrzeug != null) {
				session.delete(fahrzeug);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fahrzeug != null) {
			clearCache(fahrzeug);
		}

		return fahrzeug;
	}

	@Override
	public Fahrzeug updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug fahrzeug)
		throws SystemException {
		fahrzeug = toUnwrappedModel(fahrzeug);

		boolean isNew = fahrzeug.isNew();

		FahrzeugModelImpl fahrzeugModelImpl = (FahrzeugModelImpl)fahrzeug;

		Session session = null;

		try {
			session = openSession();

			if (fahrzeug.isNew()) {
				session.save(fahrzeug);

				fahrzeug.setNew(false);
			}
			else {
				session.merge(fahrzeug);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FahrzeugModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((fahrzeugModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { fahrzeugModelImpl.getOriginalTyp() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP,
					args);

				args = new Object[] { fahrzeugModelImpl.getTyp() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP,
					args);
			}
		}

		EntityCacheUtil.putResult(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
			FahrzeugImpl.class, fahrzeug.getPrimaryKey(), fahrzeug);

		return fahrzeug;
	}

	protected Fahrzeug toUnwrappedModel(Fahrzeug fahrzeug) {
		if (fahrzeug instanceof FahrzeugImpl) {
			return fahrzeug;
		}

		FahrzeugImpl fahrzeugImpl = new FahrzeugImpl();

		fahrzeugImpl.setNew(fahrzeug.isNew());
		fahrzeugImpl.setPrimaryKey(fahrzeug.getPrimaryKey());

		fahrzeugImpl.setFahrzeugId(fahrzeug.getFahrzeugId());
		fahrzeugImpl.setCreaterUserId(fahrzeug.getCreaterUserId());
		fahrzeugImpl.setCreateDate(fahrzeug.getCreateDate());
		fahrzeugImpl.setModifiedUserId(fahrzeug.getModifiedUserId());
		fahrzeugImpl.setModifiedDate(fahrzeug.getModifiedDate());
		fahrzeugImpl.setTyp(fahrzeug.getTyp());

		return fahrzeugImpl;
	}

	/**
	 * Returns the fahrzeug with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fahrzeug
	 * @return the fahrzeug
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException if a fahrzeug with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fahrzeug findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFahrzeugException, SystemException {
		Fahrzeug fahrzeug = fetchByPrimaryKey(primaryKey);

		if (fahrzeug == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFahrzeugException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return fahrzeug;
	}

	/**
	 * Returns the fahrzeug with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException} if it could not be found.
	 *
	 * @param fahrzeugId the primary key of the fahrzeug
	 * @return the fahrzeug
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException if a fahrzeug with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fahrzeug findByPrimaryKey(long fahrzeugId)
		throws NoSuchFahrzeugException, SystemException {
		return findByPrimaryKey((Serializable)fahrzeugId);
	}

	/**
	 * Returns the fahrzeug with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fahrzeug
	 * @return the fahrzeug, or <code>null</code> if a fahrzeug with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fahrzeug fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Fahrzeug fahrzeug = (Fahrzeug)EntityCacheUtil.getResult(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
				FahrzeugImpl.class, primaryKey);

		if (fahrzeug == _nullFahrzeug) {
			return null;
		}

		if (fahrzeug == null) {
			Session session = null;

			try {
				session = openSession();

				fahrzeug = (Fahrzeug)session.get(FahrzeugImpl.class, primaryKey);

				if (fahrzeug != null) {
					cacheResult(fahrzeug);
				}
				else {
					EntityCacheUtil.putResult(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
						FahrzeugImpl.class, primaryKey, _nullFahrzeug);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FahrzeugModelImpl.ENTITY_CACHE_ENABLED,
					FahrzeugImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return fahrzeug;
	}

	/**
	 * Returns the fahrzeug with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fahrzeugId the primary key of the fahrzeug
	 * @return the fahrzeug, or <code>null</code> if a fahrzeug with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fahrzeug fetchByPrimaryKey(long fahrzeugId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)fahrzeugId);
	}

	/**
	 * Returns all the fahrzeugs.
	 *
	 * @return the fahrzeugs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fahrzeug> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fahrzeugs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fahrzeugs
	 * @param end the upper bound of the range of fahrzeugs (not inclusive)
	 * @return the range of fahrzeugs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fahrzeug> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fahrzeugs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fahrzeugs
	 * @param end the upper bound of the range of fahrzeugs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fahrzeugs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fahrzeug> findAll(int start, int end,
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

		List<Fahrzeug> list = (List<Fahrzeug>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FAHRZEUG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FAHRZEUG;

				if (pagination) {
					sql = sql.concat(FahrzeugModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Fahrzeug>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Fahrzeug>(list);
				}
				else {
					list = (List<Fahrzeug>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fahrzeugs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Fahrzeug fahrzeug : findAll()) {
			remove(fahrzeug);
		}
	}

	/**
	 * Returns the number of fahrzeugs.
	 *
	 * @return the number of fahrzeugs
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

				Query q = session.createQuery(_SQL_COUNT_FAHRZEUG);

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
	 * Initializes the fahrzeug persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Fahrzeug>> listenersList = new ArrayList<ModelListener<Fahrzeug>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Fahrzeug>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FahrzeugImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FAHRZEUG = "SELECT fahrzeug FROM Fahrzeug fahrzeug";
	private static final String _SQL_SELECT_FAHRZEUG_WHERE = "SELECT fahrzeug FROM Fahrzeug fahrzeug WHERE ";
	private static final String _SQL_COUNT_FAHRZEUG = "SELECT COUNT(fahrzeug) FROM Fahrzeug fahrzeug";
	private static final String _SQL_COUNT_FAHRZEUG_WHERE = "SELECT COUNT(fahrzeug) FROM Fahrzeug fahrzeug WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fahrzeug.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Fahrzeug exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Fahrzeug exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FahrzeugPersistenceImpl.class);
	private static Fahrzeug _nullFahrzeug = new FahrzeugImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Fahrzeug> toCacheModel() {
				return _nullFahrzeugCacheModel;
			}
		};

	private static CacheModel<Fahrzeug> _nullFahrzeugCacheModel = new CacheModel<Fahrzeug>() {
			@Override
			public Fahrzeug toEntityModel() {
				return _nullFahrzeug;
			}
		};
}