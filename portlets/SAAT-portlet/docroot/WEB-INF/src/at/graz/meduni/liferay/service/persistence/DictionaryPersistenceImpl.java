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

import at.graz.meduni.liferay.NoSuchDictionaryException;
import at.graz.meduni.liferay.model.Dictionary;
import at.graz.meduni.liferay.model.impl.DictionaryImpl;
import at.graz.meduni.liferay.model.impl.DictionaryModelImpl;

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
 * The persistence implementation for the dictionary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DictionaryPersistence
 * @see DictionaryUtil
 * @generated
 */
public class DictionaryPersistenceImpl extends BasePersistenceImpl<Dictionary>
	implements DictionaryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DictionaryUtil} to access the dictionary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DictionaryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SYNONYM = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySynonym",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SYNONYM =
		new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySynonym",
			new String[] { String.class.getName() },
			DictionaryModelImpl.SYNONYM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SYNONYM = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySynonym",
			new String[] { String.class.getName() });

	/**
	 * Returns all the dictionaries where synonym = &#63;.
	 *
	 * @param synonym the synonym
	 * @return the matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findBySynonym(String synonym)
		throws SystemException {
		return findBySynonym(synonym, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionaries where synonym = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param synonym the synonym
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @return the range of matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findBySynonym(String synonym, int start, int end)
		throws SystemException {
		return findBySynonym(synonym, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionaries where synonym = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param synonym the synonym
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findBySynonym(String synonym, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SYNONYM;
			finderArgs = new Object[] { synonym };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SYNONYM;
			finderArgs = new Object[] { synonym, start, end, orderByComparator };
		}

		List<Dictionary> list = (List<Dictionary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Dictionary dictionary : list) {
				if (!Validator.equals(synonym, dictionary.getSynonym())) {
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

			query.append(_SQL_SELECT_DICTIONARY_WHERE);

			boolean bindSynonym = false;

			if (synonym == null) {
				query.append(_FINDER_COLUMN_SYNONYM_SYNONYM_1);
			}
			else if (synonym.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SYNONYM_SYNONYM_3);
			}
			else {
				bindSynonym = true;

				query.append(_FINDER_COLUMN_SYNONYM_SYNONYM_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictionaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSynonym) {
					qPos.add(synonym);
				}

				if (!pagination) {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Dictionary>(list);
				}
				else {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dictionary in the ordered set where synonym = &#63;.
	 *
	 * @param synonym the synonym
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryException if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary findBySynonym_First(String synonym,
		OrderByComparator orderByComparator)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = fetchBySynonym_First(synonym, orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("synonym=");
		msg.append(synonym);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the first dictionary in the ordered set where synonym = &#63;.
	 *
	 * @param synonym the synonym
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary fetchBySynonym_First(String synonym,
		OrderByComparator orderByComparator) throws SystemException {
		List<Dictionary> list = findBySynonym(synonym, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary in the ordered set where synonym = &#63;.
	 *
	 * @param synonym the synonym
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryException if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary findBySynonym_Last(String synonym,
		OrderByComparator orderByComparator)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = fetchBySynonym_Last(synonym, orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("synonym=");
		msg.append(synonym);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the last dictionary in the ordered set where synonym = &#63;.
	 *
	 * @param synonym the synonym
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary fetchBySynonym_Last(String synonym,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySynonym(synonym);

		if (count == 0) {
			return null;
		}

		List<Dictionary> list = findBySynonym(synonym, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionaries before and after the current dictionary in the ordered set where synonym = &#63;.
	 *
	 * @param dictionary_id the primary key of the current dictionary
	 * @param synonym the synonym
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryException if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary[] findBySynonym_PrevAndNext(long dictionary_id,
		String synonym, OrderByComparator orderByComparator)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = findByPrimaryKey(dictionary_id);

		Session session = null;

		try {
			session = openSession();

			Dictionary[] array = new DictionaryImpl[3];

			array[0] = getBySynonym_PrevAndNext(session, dictionary, synonym,
					orderByComparator, true);

			array[1] = dictionary;

			array[2] = getBySynonym_PrevAndNext(session, dictionary, synonym,
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

	protected Dictionary getBySynonym_PrevAndNext(Session session,
		Dictionary dictionary, String synonym,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTIONARY_WHERE);

		boolean bindSynonym = false;

		if (synonym == null) {
			query.append(_FINDER_COLUMN_SYNONYM_SYNONYM_1);
		}
		else if (synonym.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SYNONYM_SYNONYM_3);
		}
		else {
			bindSynonym = true;

			query.append(_FINDER_COLUMN_SYNONYM_SYNONYM_2);
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
			query.append(DictionaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSynonym) {
			qPos.add(synonym);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictionary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dictionary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionaries where synonym = &#63; from the database.
	 *
	 * @param synonym the synonym
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySynonym(String synonym) throws SystemException {
		for (Dictionary dictionary : findBySynonym(synonym, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dictionary);
		}
	}

	/**
	 * Returns the number of dictionaries where synonym = &#63;.
	 *
	 * @param synonym the synonym
	 * @return the number of matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySynonym(String synonym) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SYNONYM;

		Object[] finderArgs = new Object[] { synonym };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTIONARY_WHERE);

			boolean bindSynonym = false;

			if (synonym == null) {
				query.append(_FINDER_COLUMN_SYNONYM_SYNONYM_1);
			}
			else if (synonym.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SYNONYM_SYNONYM_3);
			}
			else {
				bindSynonym = true;

				query.append(_FINDER_COLUMN_SYNONYM_SYNONYM_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSynonym) {
					qPos.add(synonym);
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

	private static final String _FINDER_COLUMN_SYNONYM_SYNONYM_1 = "dictionary.synonym IS NULL";
	private static final String _FINDER_COLUMN_SYNONYM_SYNONYM_2 = "dictionary.synonym = ?";
	private static final String _FINDER_COLUMN_SYNONYM_SYNONYM_3 = "(dictionary.synonym IS NULL OR dictionary.synonym = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOTNODES =
		new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRootNodes",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTNODES =
		new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRootNodes",
			new String[] { Boolean.class.getName() },
			DictionaryModelImpl.ROOT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTNODES = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRootNodes",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the dictionaries where root = &#63;.
	 *
	 * @param root the root
	 * @return the matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findByRootNodes(boolean root)
		throws SystemException {
		return findByRootNodes(root, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionaries where root = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param root the root
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @return the range of matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findByRootNodes(boolean root, int start, int end)
		throws SystemException {
		return findByRootNodes(root, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionaries where root = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param root the root
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findByRootNodes(boolean root, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTNODES;
			finderArgs = new Object[] { root };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOTNODES;
			finderArgs = new Object[] { root, start, end, orderByComparator };
		}

		List<Dictionary> list = (List<Dictionary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Dictionary dictionary : list) {
				if ((root != dictionary.getRoot())) {
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

			query.append(_SQL_SELECT_DICTIONARY_WHERE);

			query.append(_FINDER_COLUMN_ROOTNODES_ROOT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictionaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(root);

				if (!pagination) {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Dictionary>(list);
				}
				else {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dictionary in the ordered set where root = &#63;.
	 *
	 * @param root the root
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryException if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary findByRootNodes_First(boolean root,
		OrderByComparator orderByComparator)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = fetchByRootNodes_First(root, orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("root=");
		msg.append(root);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the first dictionary in the ordered set where root = &#63;.
	 *
	 * @param root the root
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary fetchByRootNodes_First(boolean root,
		OrderByComparator orderByComparator) throws SystemException {
		List<Dictionary> list = findByRootNodes(root, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary in the ordered set where root = &#63;.
	 *
	 * @param root the root
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryException if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary findByRootNodes_Last(boolean root,
		OrderByComparator orderByComparator)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = fetchByRootNodes_Last(root, orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("root=");
		msg.append(root);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the last dictionary in the ordered set where root = &#63;.
	 *
	 * @param root the root
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary fetchByRootNodes_Last(boolean root,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRootNodes(root);

		if (count == 0) {
			return null;
		}

		List<Dictionary> list = findByRootNodes(root, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionaries before and after the current dictionary in the ordered set where root = &#63;.
	 *
	 * @param dictionary_id the primary key of the current dictionary
	 * @param root the root
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryException if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary[] findByRootNodes_PrevAndNext(long dictionary_id,
		boolean root, OrderByComparator orderByComparator)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = findByPrimaryKey(dictionary_id);

		Session session = null;

		try {
			session = openSession();

			Dictionary[] array = new DictionaryImpl[3];

			array[0] = getByRootNodes_PrevAndNext(session, dictionary, root,
					orderByComparator, true);

			array[1] = dictionary;

			array[2] = getByRootNodes_PrevAndNext(session, dictionary, root,
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

	protected Dictionary getByRootNodes_PrevAndNext(Session session,
		Dictionary dictionary, boolean root,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTIONARY_WHERE);

		query.append(_FINDER_COLUMN_ROOTNODES_ROOT_2);

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
			query.append(DictionaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(root);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictionary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dictionary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionaries where root = &#63; from the database.
	 *
	 * @param root the root
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRootNodes(boolean root) throws SystemException {
		for (Dictionary dictionary : findByRootNodes(root, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dictionary);
		}
	}

	/**
	 * Returns the number of dictionaries where root = &#63;.
	 *
	 * @param root the root
	 * @return the number of matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRootNodes(boolean root) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROOTNODES;

		Object[] finderArgs = new Object[] { root };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTIONARY_WHERE);

			query.append(_FINDER_COLUMN_ROOTNODES_ROOT_2);

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

	private static final String _FINDER_COLUMN_ROOTNODES_ROOT_2 = "dictionary.root = ?";

	public DictionaryPersistenceImpl() {
		setModelClass(Dictionary.class);
	}

	/**
	 * Caches the dictionary in the entity cache if it is enabled.
	 *
	 * @param dictionary the dictionary
	 */
	@Override
	public void cacheResult(Dictionary dictionary) {
		EntityCacheUtil.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryImpl.class, dictionary.getPrimaryKey(), dictionary);

		dictionary.resetOriginalValues();
	}

	/**
	 * Caches the dictionaries in the entity cache if it is enabled.
	 *
	 * @param dictionaries the dictionaries
	 */
	@Override
	public void cacheResult(List<Dictionary> dictionaries) {
		for (Dictionary dictionary : dictionaries) {
			if (EntityCacheUtil.getResult(
						DictionaryModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryImpl.class, dictionary.getPrimaryKey()) == null) {
				cacheResult(dictionary);
			}
			else {
				dictionary.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dictionaries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DictionaryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DictionaryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dictionary.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dictionary dictionary) {
		EntityCacheUtil.removeResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryImpl.class, dictionary.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Dictionary> dictionaries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Dictionary dictionary : dictionaries) {
			EntityCacheUtil.removeResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryImpl.class, dictionary.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	 *
	 * @param dictionary_id the primary key for the new dictionary
	 * @return the new dictionary
	 */
	@Override
	public Dictionary create(long dictionary_id) {
		Dictionary dictionary = new DictionaryImpl();

		dictionary.setNew(true);
		dictionary.setPrimaryKey(dictionary_id);

		return dictionary;
	}

	/**
	 * Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictionary_id the primary key of the dictionary
	 * @return the dictionary that was removed
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryException if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary remove(long dictionary_id)
		throws NoSuchDictionaryException, SystemException {
		return remove((Serializable)dictionary_id);
	}

	/**
	 * Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dictionary
	 * @return the dictionary that was removed
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryException if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary remove(Serializable primaryKey)
		throws NoSuchDictionaryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Dictionary dictionary = (Dictionary)session.get(DictionaryImpl.class,
					primaryKey);

			if (dictionary == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDictionaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dictionary);
		}
		catch (NoSuchDictionaryException nsee) {
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
	protected Dictionary removeImpl(Dictionary dictionary)
		throws SystemException {
		dictionary = toUnwrappedModel(dictionary);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dictionary)) {
				dictionary = (Dictionary)session.get(DictionaryImpl.class,
						dictionary.getPrimaryKeyObj());
			}

			if (dictionary != null) {
				session.delete(dictionary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dictionary != null) {
			clearCache(dictionary);
		}

		return dictionary;
	}

	@Override
	public Dictionary updateImpl(
		at.graz.meduni.liferay.model.Dictionary dictionary)
		throws SystemException {
		dictionary = toUnwrappedModel(dictionary);

		boolean isNew = dictionary.isNew();

		DictionaryModelImpl dictionaryModelImpl = (DictionaryModelImpl)dictionary;

		Session session = null;

		try {
			session = openSession();

			if (dictionary.isNew()) {
				session.save(dictionary);

				dictionary.setNew(false);
			}
			else {
				session.merge(dictionary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DictionaryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dictionaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SYNONYM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryModelImpl.getOriginalSynonym()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SYNONYM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SYNONYM,
					args);

				args = new Object[] { dictionaryModelImpl.getSynonym() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SYNONYM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SYNONYM,
					args);
			}

			if ((dictionaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTNODES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryModelImpl.getOriginalRoot()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOTNODES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTNODES,
					args);

				args = new Object[] { dictionaryModelImpl.getRoot() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROOTNODES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOTNODES,
					args);
			}
		}

		EntityCacheUtil.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryImpl.class, dictionary.getPrimaryKey(), dictionary);

		return dictionary;
	}

	protected Dictionary toUnwrappedModel(Dictionary dictionary) {
		if (dictionary instanceof DictionaryImpl) {
			return dictionary;
		}

		DictionaryImpl dictionaryImpl = new DictionaryImpl();

		dictionaryImpl.setNew(dictionary.isNew());
		dictionaryImpl.setPrimaryKey(dictionary.getPrimaryKey());

		dictionaryImpl.setDictionary_id(dictionary.getDictionary_id());
		dictionaryImpl.setSynonym(dictionary.getSynonym());
		dictionaryImpl.setBefore_synonym(dictionary.getBefore_synonym());
		dictionaryImpl.setAfter_synonym(dictionary.getAfter_synonym());
		dictionaryImpl.setForeword(dictionary.isForeword());
		dictionaryImpl.setEnding(dictionary.isEnding());
		dictionaryImpl.setSentence(dictionary.isSentence());
		dictionaryImpl.setIscode(dictionary.isIscode());
		dictionaryImpl.setPattern(dictionary.getPattern());
		dictionaryImpl.setCode_typ(dictionary.getCode_typ());
		dictionaryImpl.setCode_value(dictionary.getCode_value());
		dictionaryImpl.setRoot(dictionary.isRoot());
		dictionaryImpl.setNegation(dictionary.isNegation());
		dictionaryImpl.setOccur(dictionary.isOccur());
		dictionaryImpl.setDisease_ids(dictionary.getDisease_ids());
		dictionaryImpl.setDirty(dictionary.isDirty());
		dictionaryImpl.setPriority(dictionary.getPriority());
		dictionaryImpl.setDisease_ids_count(dictionary.getDisease_ids_count());
		dictionaryImpl.setPriority_mode(dictionary.isPriority_mode());

		return dictionaryImpl;
	}

	/**
	 * Returns the dictionary with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary
	 * @return the dictionary
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryException if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = fetchByPrimaryKey(primaryKey);

		if (dictionary == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDictionaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dictionary;
	}

	/**
	 * Returns the dictionary with the primary key or throws a {@link at.graz.meduni.liferay.NoSuchDictionaryException} if it could not be found.
	 *
	 * @param dictionary_id the primary key of the dictionary
	 * @return the dictionary
	 * @throws at.graz.meduni.liferay.NoSuchDictionaryException if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary findByPrimaryKey(long dictionary_id)
		throws NoSuchDictionaryException, SystemException {
		return findByPrimaryKey((Serializable)dictionary_id);
	}

	/**
	 * Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary
	 * @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Dictionary dictionary = (Dictionary)EntityCacheUtil.getResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryImpl.class, primaryKey);

		if (dictionary == _nullDictionary) {
			return null;
		}

		if (dictionary == null) {
			Session session = null;

			try {
				session = openSession();

				dictionary = (Dictionary)session.get(DictionaryImpl.class,
						primaryKey);

				if (dictionary != null) {
					cacheResult(dictionary);
				}
				else {
					EntityCacheUtil.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryImpl.class, primaryKey, _nullDictionary);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dictionary;
	}

	/**
	 * Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dictionary_id the primary key of the dictionary
	 * @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary fetchByPrimaryKey(long dictionary_id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dictionary_id);
	}

	/**
	 * Returns all the dictionaries.
	 *
	 * @return the dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @return the range of dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findAll(int start, int end,
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

		List<Dictionary> list = (List<Dictionary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DICTIONARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DICTIONARY;

				if (pagination) {
					sql = sql.concat(DictionaryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Dictionary>(list);
				}
				else {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dictionaries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Dictionary dictionary : findAll()) {
			remove(dictionary);
		}
	}

	/**
	 * Returns the number of dictionaries.
	 *
	 * @return the number of dictionaries
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

				Query q = session.createQuery(_SQL_COUNT_DICTIONARY);

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
	 * Initializes the dictionary persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.model.Dictionary")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Dictionary>> listenersList = new ArrayList<ModelListener<Dictionary>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Dictionary>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DictionaryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DICTIONARY = "SELECT dictionary FROM Dictionary dictionary";
	private static final String _SQL_SELECT_DICTIONARY_WHERE = "SELECT dictionary FROM Dictionary dictionary WHERE ";
	private static final String _SQL_COUNT_DICTIONARY = "SELECT COUNT(dictionary) FROM Dictionary dictionary";
	private static final String _SQL_COUNT_DICTIONARY_WHERE = "SELECT COUNT(dictionary) FROM Dictionary dictionary WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dictionary.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Dictionary exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Dictionary exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DictionaryPersistenceImpl.class);
	private static Dictionary _nullDictionary = new DictionaryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Dictionary> toCacheModel() {
				return _nullDictionaryCacheModel;
			}
		};

	private static CacheModel<Dictionary> _nullDictionaryCacheModel = new CacheModel<Dictionary>() {
			@Override
			public Dictionary toEntityModel() {
				return _nullDictionary;
			}
		};
}