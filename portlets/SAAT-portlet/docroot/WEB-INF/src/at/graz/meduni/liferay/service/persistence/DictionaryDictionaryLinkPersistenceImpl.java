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

package at.graz.meduni.liferay.service.persistence;

import at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException;
import at.graz.meduni.liferay.model.DictionaryDictionaryLink;
import at.graz.meduni.liferay.model.impl.DictionaryDictionaryLinkImpl;
import at.graz.meduni.liferay.model.impl.DictionaryDictionaryLinkModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the dictionary dictionary link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DictionaryDictionaryLinkPersistence
 * @see DictionaryDictionaryLinkUtil
 * @generated
 */
public class DictionaryDictionaryLinkPersistenceImpl extends BasePersistenceImpl<DictionaryDictionaryLink>
	implements DictionaryDictionaryLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DictionaryDictionaryLinkUtil} to access the dictionary dictionary link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DictionaryDictionaryLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTIONARYID =
		new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDictionaryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTIONARYID =
		new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDictionaryId",
			new String[] { Long.class.getName() },
			DictionaryDictionaryLinkModelImpl.DICTIONARY_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DICTIONARYID = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDictionaryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dictionary dictionary links where dictionary_id = &#63;.
	 *
	 * @param dictionary_id the dictionary_id
	 * @return the matching dictionary dictionary links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictionaryDictionaryLink> findByDictionaryId(long dictionary_id)
		throws SystemException {
		return findByDictionaryId(dictionary_id, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionary dictionary links where dictionary_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictionary_id the dictionary_id
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @return the range of matching dictionary dictionary links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictionaryDictionaryLink> findByDictionaryId(
		long dictionary_id, int start, int end) throws SystemException {
		return findByDictionaryId(dictionary_id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where dictionary_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictionary_id the dictionary_id
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionary dictionary links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictionaryDictionaryLink> findByDictionaryId(
		long dictionary_id, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTIONARYID;
			finderArgs = new Object[] { dictionary_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTIONARYID;
			finderArgs = new Object[] {
					dictionary_id,
					
					start, end, orderByComparator
				};
		}

		List<DictionaryDictionaryLink> list = (List<DictionaryDictionaryLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictionaryDictionaryLink dictionaryDictionaryLink : list) {
				if ((dictionary_id != dictionaryDictionaryLink.getDictionary_id())) {
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

			query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

			query.append(_FINDER_COLUMN_DICTIONARYID_DICTIONARY_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictionary_id);

				if (!pagination) {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictionaryDictionaryLink>(list);
				}
				else {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
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
	 * Returns the first dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	 *
	 * @param dictionary_id the dictionary_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictionaryDictionaryLink findByDictionaryId_First(
		long dictionary_id, OrderByComparator orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException, SystemException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByDictionaryId_First(dictionary_id,
				orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictionary_id=");
		msg.append(dictionary_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the first dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	 *
	 * @param dictionary_id the dictionary_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictionaryDictionaryLink fetchByDictionaryId_First(
		long dictionary_id, OrderByComparator orderByComparator)
		throws SystemException {
		List<DictionaryDictionaryLink> list = findByDictionaryId(dictionary_id,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	 *
	 * @param dictionary_id the dictionary_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictionaryDictionaryLink findByDictionaryId_Last(
		long dictionary_id, OrderByComparator orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException, SystemException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByDictionaryId_Last(dictionary_id,
				orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictionary_id=");
		msg.append(dictionary_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	 *
	 * @param dictionary_id the dictionary_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictionaryDictionaryLink fetchByDictionaryId_Last(
		long dictionary_id, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDictionaryId(dictionary_id);

		if (count == 0) {
			return null;
		}

		List<DictionaryDictionaryLink> list = findByDictionaryId(dictionary_id,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	 *
	 * @param id the primary key of the current dictionary dictionary link
	 * @param dictionary_id the dictionary_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary dictionary link
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictionaryDictionaryLink[] findByDictionaryId_PrevAndNext(long id,
		long dictionary_id, OrderByComparator orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException, SystemException {
		DictionaryDictionaryLink dictionaryDictionaryLink = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DictionaryDictionaryLink[] array = new DictionaryDictionaryLinkImpl[3];

			array[0] = getByDictionaryId_PrevAndNext(session,
					dictionaryDictionaryLink, dictionary_id, orderByComparator,
					true);

			array[1] = dictionaryDictionaryLink;

			array[2] = getByDictionaryId_PrevAndNext(session,
					dictionaryDictionaryLink, dictionary_id, orderByComparator,
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

	protected DictionaryDictionaryLink getByDictionaryId_PrevAndNext(
		Session session, DictionaryDictionaryLink dictionaryDictionaryLink,
		long dictionary_id, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

		query.append(_FINDER_COLUMN_DICTIONARYID_DICTIONARY_ID_2);

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
			query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dictionary_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictionaryDictionaryLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictionaryDictionaryLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionary dictionary links where dictionary_id = &#63; from the database.
	 *
	 * @param dictionary_id the dictionary_id
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDictionaryId(long dictionary_id)
		throws SystemException {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : findByDictionaryId(
				dictionary_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictionaryDictionaryLink);
		}
	}

	/**
	 * Returns the number of dictionary dictionary links where dictionary_id = &#63;.
	 *
	 * @param dictionary_id the dictionary_id
	 * @return the number of matching dictionary dictionary links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDictionaryId(long dictionary_id)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DICTIONARYID;

		Object[] finderArgs = new Object[] { dictionary_id };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTIONARYDICTIONARYLINK_WHERE);

			query.append(_FINDER_COLUMN_DICTIONARYID_DICTIONARY_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictionary_id);

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

	private static final String _FINDER_COLUMN_DICTIONARYID_DICTIONARY_ID_2 = "dictionaryDictionaryLink.dictionary_id = ?";

	public DictionaryDictionaryLinkPersistenceImpl() {
		setModelClass(DictionaryDictionaryLink.class);
	}

	/**
	 * Caches the dictionary dictionary link in the entity cache if it is enabled.
	 *
	 * @param dictionaryDictionaryLink the dictionary dictionary link
	 */
	@Override
	public void cacheResult(DictionaryDictionaryLink dictionaryDictionaryLink) {
		EntityCacheUtil.putResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			dictionaryDictionaryLink.getPrimaryKey(), dictionaryDictionaryLink);

		dictionaryDictionaryLink.resetOriginalValues();
	}

	/**
	 * Caches the dictionary dictionary links in the entity cache if it is enabled.
	 *
	 * @param dictionaryDictionaryLinks the dictionary dictionary links
	 */
	@Override
	public void cacheResult(
		List<DictionaryDictionaryLink> dictionaryDictionaryLinks) {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : dictionaryDictionaryLinks) {
			if (EntityCacheUtil.getResult(
						DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryDictionaryLinkImpl.class,
						dictionaryDictionaryLink.getPrimaryKey()) == null) {
				cacheResult(dictionaryDictionaryLink);
			}
			else {
				dictionaryDictionaryLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dictionary dictionary links.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DictionaryDictionaryLinkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DictionaryDictionaryLinkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dictionary dictionary link.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DictionaryDictionaryLink dictionaryDictionaryLink) {
		EntityCacheUtil.removeResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			dictionaryDictionaryLink.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<DictionaryDictionaryLink> dictionaryDictionaryLinks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DictionaryDictionaryLink dictionaryDictionaryLink : dictionaryDictionaryLinks) {
			EntityCacheUtil.removeResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryDictionaryLinkImpl.class,
				dictionaryDictionaryLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dictionary dictionary link with the primary key. Does not add the dictionary dictionary link to the database.
	 *
	 * @param id the primary key for the new dictionary dictionary link
	 * @return the new dictionary dictionary link
	 */
	@Override
	public DictionaryDictionaryLink create(long id) {
		DictionaryDictionaryLink dictionaryDictionaryLink = new DictionaryDictionaryLinkImpl();

		dictionaryDictionaryLink.setNew(true);
		dictionaryDictionaryLink.setPrimaryKey(id);

		return dictionaryDictionaryLink;
	}

	/**
	 * Removes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link that was removed
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictionaryDictionaryLink remove(long id)
		throws NoSuchDictionaryDictionaryLinkException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link that was removed
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictionaryDictionaryLink remove(Serializable primaryKey)
		throws NoSuchDictionaryDictionaryLinkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DictionaryDictionaryLink dictionaryDictionaryLink = (DictionaryDictionaryLink)session.get(DictionaryDictionaryLinkImpl.class,
					primaryKey);

			if (dictionaryDictionaryLink == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDictionaryDictionaryLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dictionaryDictionaryLink);
		}
		catch (NoSuchDictionaryDictionaryLinkException nsee) {
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
	protected DictionaryDictionaryLink removeImpl(
		DictionaryDictionaryLink dictionaryDictionaryLink)
		throws SystemException {
		dictionaryDictionaryLink = toUnwrappedModel(dictionaryDictionaryLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dictionaryDictionaryLink)) {
				dictionaryDictionaryLink = (DictionaryDictionaryLink)session.get(DictionaryDictionaryLinkImpl.class,
						dictionaryDictionaryLink.getPrimaryKeyObj());
			}

			if (dictionaryDictionaryLink != null) {
				session.delete(dictionaryDictionaryLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dictionaryDictionaryLink != null) {
			clearCache(dictionaryDictionaryLink);
		}

		return dictionaryDictionaryLink;
	}

	@Override
	public DictionaryDictionaryLink updateImpl(
		at.graz.meduni.liferay.model.DictionaryDictionaryLink dictionaryDictionaryLink)
		throws SystemException {
		dictionaryDictionaryLink = toUnwrappedModel(dictionaryDictionaryLink);

		boolean isNew = dictionaryDictionaryLink.isNew();

		DictionaryDictionaryLinkModelImpl dictionaryDictionaryLinkModelImpl = (DictionaryDictionaryLinkModelImpl)dictionaryDictionaryLink;

		Session session = null;

		try {
			session = openSession();

			if (dictionaryDictionaryLink.isNew()) {
				session.save(dictionaryDictionaryLink);

				dictionaryDictionaryLink.setNew(false);
			}
			else {
				session.merge(dictionaryDictionaryLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DictionaryDictionaryLinkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dictionaryDictionaryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTIONARYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getOriginalDictionary_id()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DICTIONARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTIONARYID,
					args);

				args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getDictionary_id()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DICTIONARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTIONARYID,
					args);
			}
		}

		EntityCacheUtil.putResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			dictionaryDictionaryLink.getPrimaryKey(), dictionaryDictionaryLink);

		return dictionaryDictionaryLink;
	}

	protected DictionaryDictionaryLink toUnwrappedModel(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		if (dictionaryDictionaryLink instanceof DictionaryDictionaryLinkImpl) {
			return dictionaryDictionaryLink;
		}

		DictionaryDictionaryLinkImpl dictionaryDictionaryLinkImpl = new DictionaryDictionaryLinkImpl();

		dictionaryDictionaryLinkImpl.setNew(dictionaryDictionaryLink.isNew());
		dictionaryDictionaryLinkImpl.setPrimaryKey(dictionaryDictionaryLink.getPrimaryKey());

		dictionaryDictionaryLinkImpl.setId(dictionaryDictionaryLink.getId());
		dictionaryDictionaryLinkImpl.setDictionary_id(dictionaryDictionaryLink.getDictionary_id());
		dictionaryDictionaryLinkImpl.setAddiction_id(dictionaryDictionaryLink.getAddiction_id());

		return dictionaryDictionaryLinkImpl;
	}

	/**
	 * Returns the dictionary dictionary link with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictionaryDictionaryLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDictionaryDictionaryLinkException, SystemException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByPrimaryKey(primaryKey);

		if (dictionaryDictionaryLink == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDictionaryDictionaryLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dictionaryDictionaryLink;
	}

	/**
	 * Returns the dictionary dictionary link with the primary key or throws a {@link at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException} if it could not be found.
	 *
	 * @param id the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictionaryDictionaryLink findByPrimaryKey(long id)
		throws NoSuchDictionaryDictionaryLinkException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dictionary dictionary link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link, or <code>null</code> if a dictionary dictionary link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictionaryDictionaryLink fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DictionaryDictionaryLink dictionaryDictionaryLink = (DictionaryDictionaryLink)EntityCacheUtil.getResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryDictionaryLinkImpl.class, primaryKey);

		if (dictionaryDictionaryLink == _nullDictionaryDictionaryLink) {
			return null;
		}

		if (dictionaryDictionaryLink == null) {
			Session session = null;

			try {
				session = openSession();

				dictionaryDictionaryLink = (DictionaryDictionaryLink)session.get(DictionaryDictionaryLinkImpl.class,
						primaryKey);

				if (dictionaryDictionaryLink != null) {
					cacheResult(dictionaryDictionaryLink);
				}
				else {
					EntityCacheUtil.putResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryDictionaryLinkImpl.class, primaryKey,
						_nullDictionaryDictionaryLink);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryDictionaryLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dictionaryDictionaryLink;
	}

	/**
	 * Returns the dictionary dictionary link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link, or <code>null</code> if a dictionary dictionary link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictionaryDictionaryLink fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the dictionary dictionary links.
	 *
	 * @return the dictionary dictionary links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictionaryDictionaryLink> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionary dictionary links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @return the range of dictionary dictionary links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictionaryDictionaryLink> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dictionary dictionary links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictionaryDictionaryLink> findAll(int start, int end,
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

		List<DictionaryDictionaryLink> list = (List<DictionaryDictionaryLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DICTIONARYDICTIONARYLINK;

				if (pagination) {
					sql = sql.concat(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictionaryDictionaryLink>(list);
				}
				else {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
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
	 * Removes all the dictionary dictionary links from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : findAll()) {
			remove(dictionaryDictionaryLink);
		}
	}

	/**
	 * Returns the number of dictionary dictionary links.
	 *
	 * @return the number of dictionary dictionary links
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

				Query q = session.createQuery(_SQL_COUNT_DICTIONARYDICTIONARYLINK);

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
	 * Initializes the dictionary dictionary link persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.model.DictionaryDictionaryLink")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DictionaryDictionaryLink>> listenersList = new ArrayList<ModelListener<DictionaryDictionaryLink>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DictionaryDictionaryLink>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DictionaryDictionaryLinkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DICTIONARYDICTIONARYLINK = "SELECT dictionaryDictionaryLink FROM DictionaryDictionaryLink dictionaryDictionaryLink";
	private static final String _SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE = "SELECT dictionaryDictionaryLink FROM DictionaryDictionaryLink dictionaryDictionaryLink WHERE ";
	private static final String _SQL_COUNT_DICTIONARYDICTIONARYLINK = "SELECT COUNT(dictionaryDictionaryLink) FROM DictionaryDictionaryLink dictionaryDictionaryLink";
	private static final String _SQL_COUNT_DICTIONARYDICTIONARYLINK_WHERE = "SELECT COUNT(dictionaryDictionaryLink) FROM DictionaryDictionaryLink dictionaryDictionaryLink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dictionaryDictionaryLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DictionaryDictionaryLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DictionaryDictionaryLink exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DictionaryDictionaryLinkPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static DictionaryDictionaryLink _nullDictionaryDictionaryLink = new DictionaryDictionaryLinkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DictionaryDictionaryLink> toCacheModel() {
				return _nullDictionaryDictionaryLinkCacheModel;
			}
		};

	private static CacheModel<DictionaryDictionaryLink> _nullDictionaryDictionaryLinkCacheModel =
		new CacheModel<DictionaryDictionaryLink>() {
			@Override
			public DictionaryDictionaryLink toEntityModel() {
				return _nullDictionaryDictionaryLink;
			}
		};
}