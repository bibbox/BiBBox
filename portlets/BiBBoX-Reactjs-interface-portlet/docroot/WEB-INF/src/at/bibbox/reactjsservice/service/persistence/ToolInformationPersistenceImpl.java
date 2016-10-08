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

package at.bibbox.reactjsservice.service.persistence;

import at.bibbox.reactjsservice.NoSuchToolInformationException;
import at.bibbox.reactjsservice.model.ToolInformation;
import at.bibbox.reactjsservice.model.impl.ToolInformationImpl;
import at.bibbox.reactjsservice.model.impl.ToolInformationModelImpl;

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
 * The persistence implementation for the tool information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ToolInformationPersistence
 * @see ToolInformationUtil
 * @generated
 */
public class ToolInformationPersistenceImpl extends BasePersistenceImpl<ToolInformation>
	implements ToolInformationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ToolInformationUtil} to access the tool information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ToolInformationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
			ToolInformationModelImpl.FINDER_CACHE_ENABLED,
			ToolInformationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
			ToolInformationModelImpl.FINDER_CACHE_ENABLED,
			ToolInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
			ToolInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
			ToolInformationModelImpl.FINDER_CACHE_ENABLED,
			ToolInformationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategory",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
			ToolInformationModelImpl.FINDER_CACHE_ENABLED,
			ToolInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { String.class.getName() },
			ToolInformationModelImpl.CATEGORY_COLUMN_BITMASK |
			ToolInformationModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
			ToolInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { String.class.getName() });

	/**
	 * Returns all the tool informations where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching tool informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ToolInformation> findByCategory(String category)
		throws SystemException {
		return findByCategory(category, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the tool informations where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.bibbox.reactjsservice.model.impl.ToolInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of tool informations
	 * @param end the upper bound of the range of tool informations (not inclusive)
	 * @return the range of matching tool informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ToolInformation> findByCategory(String category, int start,
		int end) throws SystemException {
		return findByCategory(category, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tool informations where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.bibbox.reactjsservice.model.impl.ToolInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of tool informations
	 * @param end the upper bound of the range of tool informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tool informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ToolInformation> findByCategory(String category, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { category };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { category, start, end, orderByComparator };
		}

		List<ToolInformation> list = (List<ToolInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ToolInformation toolInformation : list) {
				if (!Validator.equals(category, toolInformation.getCategory())) {
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

			query.append(_SQL_SELECT_TOOLINFORMATION_WHERE);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ToolInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategory) {
					qPos.add(category);
				}

				if (!pagination) {
					list = (List<ToolInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ToolInformation>(list);
				}
				else {
					list = (List<ToolInformation>)QueryUtil.list(q,
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
	 * Returns the first tool information in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tool information
	 * @throws at.bibbox.reactjsservice.NoSuchToolInformationException if a matching tool information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ToolInformation findByCategory_First(String category,
		OrderByComparator orderByComparator)
		throws NoSuchToolInformationException, SystemException {
		ToolInformation toolInformation = fetchByCategory_First(category,
				orderByComparator);

		if (toolInformation != null) {
			return toolInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolInformationException(msg.toString());
	}

	/**
	 * Returns the first tool information in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tool information, or <code>null</code> if a matching tool information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ToolInformation fetchByCategory_First(String category,
		OrderByComparator orderByComparator) throws SystemException {
		List<ToolInformation> list = findByCategory(category, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tool information in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tool information
	 * @throws at.bibbox.reactjsservice.NoSuchToolInformationException if a matching tool information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ToolInformation findByCategory_Last(String category,
		OrderByComparator orderByComparator)
		throws NoSuchToolInformationException, SystemException {
		ToolInformation toolInformation = fetchByCategory_Last(category,
				orderByComparator);

		if (toolInformation != null) {
			return toolInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchToolInformationException(msg.toString());
	}

	/**
	 * Returns the last tool information in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tool information, or <code>null</code> if a matching tool information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ToolInformation fetchByCategory_Last(String category,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(category);

		if (count == 0) {
			return null;
		}

		List<ToolInformation> list = findByCategory(category, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tool informations before and after the current tool information in the ordered set where category = &#63;.
	 *
	 * @param toolInformationId the primary key of the current tool information
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tool information
	 * @throws at.bibbox.reactjsservice.NoSuchToolInformationException if a tool information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ToolInformation[] findByCategory_PrevAndNext(
		long toolInformationId, String category,
		OrderByComparator orderByComparator)
		throws NoSuchToolInformationException, SystemException {
		ToolInformation toolInformation = findByPrimaryKey(toolInformationId);

		Session session = null;

		try {
			session = openSession();

			ToolInformation[] array = new ToolInformationImpl[3];

			array[0] = getByCategory_PrevAndNext(session, toolInformation,
					category, orderByComparator, true);

			array[1] = toolInformation;

			array[2] = getByCategory_PrevAndNext(session, toolInformation,
					category, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ToolInformation getByCategory_PrevAndNext(Session session,
		ToolInformation toolInformation, String category,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOOLINFORMATION_WHERE);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
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
			query.append(ToolInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCategory) {
			qPos.add(category);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(toolInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ToolInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tool informations where category = &#63; from the database.
	 *
	 * @param category the category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategory(String category) throws SystemException {
		for (ToolInformation toolInformation : findByCategory(category,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(toolInformation);
		}
	}

	/**
	 * Returns the number of tool informations where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching tool informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategory(String category) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { category };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOOLINFORMATION_WHERE);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategory) {
					qPos.add(category);
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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_1 = "toolInformation.category IS NULL";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_2 = "toolInformation.category = ?";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_3 = "(toolInformation.category IS NULL OR toolInformation.category = '')";

	public ToolInformationPersistenceImpl() {
		setModelClass(ToolInformation.class);
	}

	/**
	 * Caches the tool information in the entity cache if it is enabled.
	 *
	 * @param toolInformation the tool information
	 */
	@Override
	public void cacheResult(ToolInformation toolInformation) {
		EntityCacheUtil.putResult(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
			ToolInformationImpl.class, toolInformation.getPrimaryKey(),
			toolInformation);

		toolInformation.resetOriginalValues();
	}

	/**
	 * Caches the tool informations in the entity cache if it is enabled.
	 *
	 * @param toolInformations the tool informations
	 */
	@Override
	public void cacheResult(List<ToolInformation> toolInformations) {
		for (ToolInformation toolInformation : toolInformations) {
			if (EntityCacheUtil.getResult(
						ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
						ToolInformationImpl.class,
						toolInformation.getPrimaryKey()) == null) {
				cacheResult(toolInformation);
			}
			else {
				toolInformation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tool informations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ToolInformationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ToolInformationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tool information.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ToolInformation toolInformation) {
		EntityCacheUtil.removeResult(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
			ToolInformationImpl.class, toolInformation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ToolInformation> toolInformations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ToolInformation toolInformation : toolInformations) {
			EntityCacheUtil.removeResult(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
				ToolInformationImpl.class, toolInformation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tool information with the primary key. Does not add the tool information to the database.
	 *
	 * @param toolInformationId the primary key for the new tool information
	 * @return the new tool information
	 */
	@Override
	public ToolInformation create(long toolInformationId) {
		ToolInformation toolInformation = new ToolInformationImpl();

		toolInformation.setNew(true);
		toolInformation.setPrimaryKey(toolInformationId);

		return toolInformation;
	}

	/**
	 * Removes the tool information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param toolInformationId the primary key of the tool information
	 * @return the tool information that was removed
	 * @throws at.bibbox.reactjsservice.NoSuchToolInformationException if a tool information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ToolInformation remove(long toolInformationId)
		throws NoSuchToolInformationException, SystemException {
		return remove((Serializable)toolInformationId);
	}

	/**
	 * Removes the tool information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tool information
	 * @return the tool information that was removed
	 * @throws at.bibbox.reactjsservice.NoSuchToolInformationException if a tool information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ToolInformation remove(Serializable primaryKey)
		throws NoSuchToolInformationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ToolInformation toolInformation = (ToolInformation)session.get(ToolInformationImpl.class,
					primaryKey);

			if (toolInformation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchToolInformationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(toolInformation);
		}
		catch (NoSuchToolInformationException nsee) {
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
	protected ToolInformation removeImpl(ToolInformation toolInformation)
		throws SystemException {
		toolInformation = toUnwrappedModel(toolInformation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(toolInformation)) {
				toolInformation = (ToolInformation)session.get(ToolInformationImpl.class,
						toolInformation.getPrimaryKeyObj());
			}

			if (toolInformation != null) {
				session.delete(toolInformation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (toolInformation != null) {
			clearCache(toolInformation);
		}

		return toolInformation;
	}

	@Override
	public ToolInformation updateImpl(
		at.bibbox.reactjsservice.model.ToolInformation toolInformation)
		throws SystemException {
		toolInformation = toUnwrappedModel(toolInformation);

		boolean isNew = toolInformation.isNew();

		ToolInformationModelImpl toolInformationModelImpl = (ToolInformationModelImpl)toolInformation;

		Session session = null;

		try {
			session = openSession();

			if (toolInformation.isNew()) {
				session.save(toolInformation);

				toolInformation.setNew(false);
			}
			else {
				session.merge(toolInformation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ToolInformationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((toolInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						toolInformationModelImpl.getOriginalCategory()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] { toolInformationModelImpl.getCategory() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
			ToolInformationImpl.class, toolInformation.getPrimaryKey(),
			toolInformation);

		return toolInformation;
	}

	protected ToolInformation toUnwrappedModel(ToolInformation toolInformation) {
		if (toolInformation instanceof ToolInformationImpl) {
			return toolInformation;
		}

		ToolInformationImpl toolInformationImpl = new ToolInformationImpl();

		toolInformationImpl.setNew(toolInformation.isNew());
		toolInformationImpl.setPrimaryKey(toolInformation.getPrimaryKey());

		toolInformationImpl.setToolInformationId(toolInformation.getToolInformationId());
		toolInformationImpl.setGitUUID(toolInformation.getGitUUID());
		toolInformationImpl.setLogourl(toolInformation.getLogourl());
		toolInformationImpl.setName(toolInformation.getName());
		toolInformationImpl.setCategory(toolInformation.getCategory());
		toolInformationImpl.setCompany(toolInformation.getCompany());
		toolInformationImpl.setDemourl(toolInformation.getDemourl());
		toolInformationImpl.setDownloadurl(toolInformation.getDownloadurl());
		toolInformationImpl.setToolId(toolInformation.getToolId());
		toolInformationImpl.setPlatform(toolInformation.getPlatform());
		toolInformationImpl.setLicense(toolInformation.getLicense());
		toolInformationImpl.setDescription(toolInformation.getDescription());

		return toolInformationImpl;
	}

	/**
	 * Returns the tool information with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tool information
	 * @return the tool information
	 * @throws at.bibbox.reactjsservice.NoSuchToolInformationException if a tool information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ToolInformation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchToolInformationException, SystemException {
		ToolInformation toolInformation = fetchByPrimaryKey(primaryKey);

		if (toolInformation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchToolInformationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return toolInformation;
	}

	/**
	 * Returns the tool information with the primary key or throws a {@link at.bibbox.reactjsservice.NoSuchToolInformationException} if it could not be found.
	 *
	 * @param toolInformationId the primary key of the tool information
	 * @return the tool information
	 * @throws at.bibbox.reactjsservice.NoSuchToolInformationException if a tool information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ToolInformation findByPrimaryKey(long toolInformationId)
		throws NoSuchToolInformationException, SystemException {
		return findByPrimaryKey((Serializable)toolInformationId);
	}

	/**
	 * Returns the tool information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tool information
	 * @return the tool information, or <code>null</code> if a tool information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ToolInformation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ToolInformation toolInformation = (ToolInformation)EntityCacheUtil.getResult(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
				ToolInformationImpl.class, primaryKey);

		if (toolInformation == _nullToolInformation) {
			return null;
		}

		if (toolInformation == null) {
			Session session = null;

			try {
				session = openSession();

				toolInformation = (ToolInformation)session.get(ToolInformationImpl.class,
						primaryKey);

				if (toolInformation != null) {
					cacheResult(toolInformation);
				}
				else {
					EntityCacheUtil.putResult(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
						ToolInformationImpl.class, primaryKey,
						_nullToolInformation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ToolInformationModelImpl.ENTITY_CACHE_ENABLED,
					ToolInformationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return toolInformation;
	}

	/**
	 * Returns the tool information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param toolInformationId the primary key of the tool information
	 * @return the tool information, or <code>null</code> if a tool information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ToolInformation fetchByPrimaryKey(long toolInformationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)toolInformationId);
	}

	/**
	 * Returns all the tool informations.
	 *
	 * @return the tool informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ToolInformation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tool informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.bibbox.reactjsservice.model.impl.ToolInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tool informations
	 * @param end the upper bound of the range of tool informations (not inclusive)
	 * @return the range of tool informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ToolInformation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tool informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.bibbox.reactjsservice.model.impl.ToolInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tool informations
	 * @param end the upper bound of the range of tool informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tool informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ToolInformation> findAll(int start, int end,
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

		List<ToolInformation> list = (List<ToolInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TOOLINFORMATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOOLINFORMATION;

				if (pagination) {
					sql = sql.concat(ToolInformationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ToolInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ToolInformation>(list);
				}
				else {
					list = (List<ToolInformation>)QueryUtil.list(q,
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
	 * Removes all the tool informations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ToolInformation toolInformation : findAll()) {
			remove(toolInformation);
		}
	}

	/**
	 * Returns the number of tool informations.
	 *
	 * @return the number of tool informations
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

				Query q = session.createQuery(_SQL_COUNT_TOOLINFORMATION);

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
	 * Initializes the tool information persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.bibbox.reactjsservice.model.ToolInformation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ToolInformation>> listenersList = new ArrayList<ModelListener<ToolInformation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ToolInformation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ToolInformationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TOOLINFORMATION = "SELECT toolInformation FROM ToolInformation toolInformation";
	private static final String _SQL_SELECT_TOOLINFORMATION_WHERE = "SELECT toolInformation FROM ToolInformation toolInformation WHERE ";
	private static final String _SQL_COUNT_TOOLINFORMATION = "SELECT COUNT(toolInformation) FROM ToolInformation toolInformation";
	private static final String _SQL_COUNT_TOOLINFORMATION_WHERE = "SELECT COUNT(toolInformation) FROM ToolInformation toolInformation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "toolInformation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ToolInformation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ToolInformation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ToolInformationPersistenceImpl.class);
	private static ToolInformation _nullToolInformation = new ToolInformationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ToolInformation> toCacheModel() {
				return _nullToolInformationCacheModel;
			}
		};

	private static CacheModel<ToolInformation> _nullToolInformationCacheModel = new CacheModel<ToolInformation>() {
			@Override
			public ToolInformation toEntityModel() {
				return _nullToolInformation;
			}
		};
}