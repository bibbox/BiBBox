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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterOptionsImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterOptionsModelImpl;

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
 * The persistence implementation for the kdssmp parameter options service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see KdssmpParameterOptionsPersistence
 * @see KdssmpParameterOptionsUtil
 * @generated
 */
public class KdssmpParameterOptionsPersistenceImpl extends BasePersistenceImpl<KdssmpParameterOptions>
	implements KdssmpParameterOptionsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KdssmpParameterOptionsUtil} to access the kdssmp parameter options persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KdssmpParameterOptionsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterOptionsModelImpl.FINDER_CACHE_ENABLED,
			KdssmpParameterOptionsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterOptionsModelImpl.FINDER_CACHE_ENABLED,
			KdssmpParameterOptionsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterOptionsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIONS = new FinderPath(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterOptionsModelImpl.FINDER_CACHE_ENABLED,
			KdssmpParameterOptionsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOptions",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONS =
		new FinderPath(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterOptionsModelImpl.FINDER_CACHE_ENABLED,
			KdssmpParameterOptionsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOptions",
			new String[] { Long.class.getName() },
			KdssmpParameterOptionsModelImpl.PARAMETERCONFIGURATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPTIONS = new FinderPath(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterOptionsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOptions",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the kdssmp parameter optionses where parameterconfigurationId = &#63;.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @return the matching kdssmp parameter optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpParameterOptions> findByOptions(
		long parameterconfigurationId) throws SystemException {
		return findByOptions(parameterconfigurationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kdssmp parameter optionses where parameterconfigurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param start the lower bound of the range of kdssmp parameter optionses
	 * @param end the upper bound of the range of kdssmp parameter optionses (not inclusive)
	 * @return the range of matching kdssmp parameter optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpParameterOptions> findByOptions(
		long parameterconfigurationId, int start, int end)
		throws SystemException {
		return findByOptions(parameterconfigurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the kdssmp parameter optionses where parameterconfigurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param start the lower bound of the range of kdssmp parameter optionses
	 * @param end the upper bound of the range of kdssmp parameter optionses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kdssmp parameter optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpParameterOptions> findByOptions(
		long parameterconfigurationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONS;
			finderArgs = new Object[] { parameterconfigurationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIONS;
			finderArgs = new Object[] {
					parameterconfigurationId,
					
					start, end, orderByComparator
				};
		}

		List<KdssmpParameterOptions> list = (List<KdssmpParameterOptions>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (KdssmpParameterOptions kdssmpParameterOptions : list) {
				if ((parameterconfigurationId != kdssmpParameterOptions.getParameterconfigurationId())) {
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

			query.append(_SQL_SELECT_KDSSMPPARAMETEROPTIONS_WHERE);

			query.append(_FINDER_COLUMN_OPTIONS_PARAMETERCONFIGURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(KdssmpParameterOptionsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parameterconfigurationId);

				if (!pagination) {
					list = (List<KdssmpParameterOptions>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<KdssmpParameterOptions>(list);
				}
				else {
					list = (List<KdssmpParameterOptions>)QueryUtil.list(q,
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
	 * Returns the first kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kdssmp parameter options
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a matching kdssmp parameter options could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterOptions findByOptions_First(
		long parameterconfigurationId, OrderByComparator orderByComparator)
		throws NoSuchKdssmpParameterOptionsException, SystemException {
		KdssmpParameterOptions kdssmpParameterOptions = fetchByOptions_First(parameterconfigurationId,
				orderByComparator);

		if (kdssmpParameterOptions != null) {
			return kdssmpParameterOptions;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parameterconfigurationId=");
		msg.append(parameterconfigurationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKdssmpParameterOptionsException(msg.toString());
	}

	/**
	 * Returns the first kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kdssmp parameter options, or <code>null</code> if a matching kdssmp parameter options could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterOptions fetchByOptions_First(
		long parameterconfigurationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<KdssmpParameterOptions> list = findByOptions(parameterconfigurationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kdssmp parameter options
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a matching kdssmp parameter options could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterOptions findByOptions_Last(
		long parameterconfigurationId, OrderByComparator orderByComparator)
		throws NoSuchKdssmpParameterOptionsException, SystemException {
		KdssmpParameterOptions kdssmpParameterOptions = fetchByOptions_Last(parameterconfigurationId,
				orderByComparator);

		if (kdssmpParameterOptions != null) {
			return kdssmpParameterOptions;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parameterconfigurationId=");
		msg.append(parameterconfigurationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKdssmpParameterOptionsException(msg.toString());
	}

	/**
	 * Returns the last kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kdssmp parameter options, or <code>null</code> if a matching kdssmp parameter options could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterOptions fetchByOptions_Last(
		long parameterconfigurationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOptions(parameterconfigurationId);

		if (count == 0) {
			return null;
		}

		List<KdssmpParameterOptions> list = findByOptions(parameterconfigurationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the kdssmp parameter optionses before and after the current kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	 *
	 * @param parameteroptionsId the primary key of the current kdssmp parameter options
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kdssmp parameter options
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a kdssmp parameter options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterOptions[] findByOptions_PrevAndNext(
		long parameteroptionsId, long parameterconfigurationId,
		OrderByComparator orderByComparator)
		throws NoSuchKdssmpParameterOptionsException, SystemException {
		KdssmpParameterOptions kdssmpParameterOptions = findByPrimaryKey(parameteroptionsId);

		Session session = null;

		try {
			session = openSession();

			KdssmpParameterOptions[] array = new KdssmpParameterOptionsImpl[3];

			array[0] = getByOptions_PrevAndNext(session,
					kdssmpParameterOptions, parameterconfigurationId,
					orderByComparator, true);

			array[1] = kdssmpParameterOptions;

			array[2] = getByOptions_PrevAndNext(session,
					kdssmpParameterOptions, parameterconfigurationId,
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

	protected KdssmpParameterOptions getByOptions_PrevAndNext(Session session,
		KdssmpParameterOptions kdssmpParameterOptions,
		long parameterconfigurationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KDSSMPPARAMETEROPTIONS_WHERE);

		query.append(_FINDER_COLUMN_OPTIONS_PARAMETERCONFIGURATIONID_2);

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
			query.append(KdssmpParameterOptionsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parameterconfigurationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(kdssmpParameterOptions);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KdssmpParameterOptions> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kdssmp parameter optionses where parameterconfigurationId = &#63; from the database.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOptions(long parameterconfigurationId)
		throws SystemException {
		for (KdssmpParameterOptions kdssmpParameterOptions : findByOptions(
				parameterconfigurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(kdssmpParameterOptions);
		}
	}

	/**
	 * Returns the number of kdssmp parameter optionses where parameterconfigurationId = &#63;.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @return the number of matching kdssmp parameter optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOptions(long parameterconfigurationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPTIONS;

		Object[] finderArgs = new Object[] { parameterconfigurationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KDSSMPPARAMETEROPTIONS_WHERE);

			query.append(_FINDER_COLUMN_OPTIONS_PARAMETERCONFIGURATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parameterconfigurationId);

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

	private static final String _FINDER_COLUMN_OPTIONS_PARAMETERCONFIGURATIONID_2 =
		"kdssmpParameterOptions.parameterconfigurationId = ?";

	public KdssmpParameterOptionsPersistenceImpl() {
		setModelClass(KdssmpParameterOptions.class);
	}

	/**
	 * Caches the kdssmp parameter options in the entity cache if it is enabled.
	 *
	 * @param kdssmpParameterOptions the kdssmp parameter options
	 */
	@Override
	public void cacheResult(KdssmpParameterOptions kdssmpParameterOptions) {
		EntityCacheUtil.putResult(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterOptionsImpl.class,
			kdssmpParameterOptions.getPrimaryKey(), kdssmpParameterOptions);

		kdssmpParameterOptions.resetOriginalValues();
	}

	/**
	 * Caches the kdssmp parameter optionses in the entity cache if it is enabled.
	 *
	 * @param kdssmpParameterOptionses the kdssmp parameter optionses
	 */
	@Override
	public void cacheResult(
		List<KdssmpParameterOptions> kdssmpParameterOptionses) {
		for (KdssmpParameterOptions kdssmpParameterOptions : kdssmpParameterOptionses) {
			if (EntityCacheUtil.getResult(
						KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
						KdssmpParameterOptionsImpl.class,
						kdssmpParameterOptions.getPrimaryKey()) == null) {
				cacheResult(kdssmpParameterOptions);
			}
			else {
				kdssmpParameterOptions.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kdssmp parameter optionses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(KdssmpParameterOptionsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(KdssmpParameterOptionsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kdssmp parameter options.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KdssmpParameterOptions kdssmpParameterOptions) {
		EntityCacheUtil.removeResult(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterOptionsImpl.class,
			kdssmpParameterOptions.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<KdssmpParameterOptions> kdssmpParameterOptionses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KdssmpParameterOptions kdssmpParameterOptions : kdssmpParameterOptionses) {
			EntityCacheUtil.removeResult(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
				KdssmpParameterOptionsImpl.class,
				kdssmpParameterOptions.getPrimaryKey());
		}
	}

	/**
	 * Creates a new kdssmp parameter options with the primary key. Does not add the kdssmp parameter options to the database.
	 *
	 * @param parameteroptionsId the primary key for the new kdssmp parameter options
	 * @return the new kdssmp parameter options
	 */
	@Override
	public KdssmpParameterOptions create(long parameteroptionsId) {
		KdssmpParameterOptions kdssmpParameterOptions = new KdssmpParameterOptionsImpl();

		kdssmpParameterOptions.setNew(true);
		kdssmpParameterOptions.setPrimaryKey(parameteroptionsId);

		return kdssmpParameterOptions;
	}

	/**
	 * Removes the kdssmp parameter options with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parameteroptionsId the primary key of the kdssmp parameter options
	 * @return the kdssmp parameter options that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a kdssmp parameter options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterOptions remove(long parameteroptionsId)
		throws NoSuchKdssmpParameterOptionsException, SystemException {
		return remove((Serializable)parameteroptionsId);
	}

	/**
	 * Removes the kdssmp parameter options with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kdssmp parameter options
	 * @return the kdssmp parameter options that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a kdssmp parameter options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterOptions remove(Serializable primaryKey)
		throws NoSuchKdssmpParameterOptionsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KdssmpParameterOptions kdssmpParameterOptions = (KdssmpParameterOptions)session.get(KdssmpParameterOptionsImpl.class,
					primaryKey);

			if (kdssmpParameterOptions == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKdssmpParameterOptionsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(kdssmpParameterOptions);
		}
		catch (NoSuchKdssmpParameterOptionsException nsee) {
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
	protected KdssmpParameterOptions removeImpl(
		KdssmpParameterOptions kdssmpParameterOptions)
		throws SystemException {
		kdssmpParameterOptions = toUnwrappedModel(kdssmpParameterOptions);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kdssmpParameterOptions)) {
				kdssmpParameterOptions = (KdssmpParameterOptions)session.get(KdssmpParameterOptionsImpl.class,
						kdssmpParameterOptions.getPrimaryKeyObj());
			}

			if (kdssmpParameterOptions != null) {
				session.delete(kdssmpParameterOptions);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kdssmpParameterOptions != null) {
			clearCache(kdssmpParameterOptions);
		}

		return kdssmpParameterOptions;
	}

	@Override
	public KdssmpParameterOptions updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions kdssmpParameterOptions)
		throws SystemException {
		kdssmpParameterOptions = toUnwrappedModel(kdssmpParameterOptions);

		boolean isNew = kdssmpParameterOptions.isNew();

		KdssmpParameterOptionsModelImpl kdssmpParameterOptionsModelImpl = (KdssmpParameterOptionsModelImpl)kdssmpParameterOptions;

		Session session = null;

		try {
			session = openSession();

			if (kdssmpParameterOptions.isNew()) {
				session.save(kdssmpParameterOptions);

				kdssmpParameterOptions.setNew(false);
			}
			else {
				session.merge(kdssmpParameterOptions);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !KdssmpParameterOptionsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((kdssmpParameterOptionsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kdssmpParameterOptionsModelImpl.getOriginalParameterconfigurationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONS,
					args);

				args = new Object[] {
						kdssmpParameterOptionsModelImpl.getParameterconfigurationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONS,
					args);
			}
		}

		EntityCacheUtil.putResult(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterOptionsImpl.class,
			kdssmpParameterOptions.getPrimaryKey(), kdssmpParameterOptions);

		return kdssmpParameterOptions;
	}

	protected KdssmpParameterOptions toUnwrappedModel(
		KdssmpParameterOptions kdssmpParameterOptions) {
		if (kdssmpParameterOptions instanceof KdssmpParameterOptionsImpl) {
			return kdssmpParameterOptions;
		}

		KdssmpParameterOptionsImpl kdssmpParameterOptionsImpl = new KdssmpParameterOptionsImpl();

		kdssmpParameterOptionsImpl.setNew(kdssmpParameterOptions.isNew());
		kdssmpParameterOptionsImpl.setPrimaryKey(kdssmpParameterOptions.getPrimaryKey());

		kdssmpParameterOptionsImpl.setParameteroptionsId(kdssmpParameterOptions.getParameteroptionsId());
		kdssmpParameterOptionsImpl.setParameterconfigurationId(kdssmpParameterOptions.getParameterconfigurationId());
		kdssmpParameterOptionsImpl.setOption(kdssmpParameterOptions.getOption());
		kdssmpParameterOptionsImpl.setValue(kdssmpParameterOptions.getValue());

		return kdssmpParameterOptionsImpl;
	}

	/**
	 * Returns the kdssmp parameter options with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the kdssmp parameter options
	 * @return the kdssmp parameter options
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a kdssmp parameter options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterOptions findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKdssmpParameterOptionsException, SystemException {
		KdssmpParameterOptions kdssmpParameterOptions = fetchByPrimaryKey(primaryKey);

		if (kdssmpParameterOptions == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKdssmpParameterOptionsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return kdssmpParameterOptions;
	}

	/**
	 * Returns the kdssmp parameter options with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException} if it could not be found.
	 *
	 * @param parameteroptionsId the primary key of the kdssmp parameter options
	 * @return the kdssmp parameter options
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a kdssmp parameter options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterOptions findByPrimaryKey(long parameteroptionsId)
		throws NoSuchKdssmpParameterOptionsException, SystemException {
		return findByPrimaryKey((Serializable)parameteroptionsId);
	}

	/**
	 * Returns the kdssmp parameter options with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kdssmp parameter options
	 * @return the kdssmp parameter options, or <code>null</code> if a kdssmp parameter options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterOptions fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		KdssmpParameterOptions kdssmpParameterOptions = (KdssmpParameterOptions)EntityCacheUtil.getResult(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
				KdssmpParameterOptionsImpl.class, primaryKey);

		if (kdssmpParameterOptions == _nullKdssmpParameterOptions) {
			return null;
		}

		if (kdssmpParameterOptions == null) {
			Session session = null;

			try {
				session = openSession();

				kdssmpParameterOptions = (KdssmpParameterOptions)session.get(KdssmpParameterOptionsImpl.class,
						primaryKey);

				if (kdssmpParameterOptions != null) {
					cacheResult(kdssmpParameterOptions);
				}
				else {
					EntityCacheUtil.putResult(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
						KdssmpParameterOptionsImpl.class, primaryKey,
						_nullKdssmpParameterOptions);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(KdssmpParameterOptionsModelImpl.ENTITY_CACHE_ENABLED,
					KdssmpParameterOptionsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return kdssmpParameterOptions;
	}

	/**
	 * Returns the kdssmp parameter options with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parameteroptionsId the primary key of the kdssmp parameter options
	 * @return the kdssmp parameter options, or <code>null</code> if a kdssmp parameter options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterOptions fetchByPrimaryKey(long parameteroptionsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)parameteroptionsId);
	}

	/**
	 * Returns all the kdssmp parameter optionses.
	 *
	 * @return the kdssmp parameter optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpParameterOptions> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kdssmp parameter optionses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kdssmp parameter optionses
	 * @param end the upper bound of the range of kdssmp parameter optionses (not inclusive)
	 * @return the range of kdssmp parameter optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpParameterOptions> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the kdssmp parameter optionses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kdssmp parameter optionses
	 * @param end the upper bound of the range of kdssmp parameter optionses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kdssmp parameter optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpParameterOptions> findAll(int start, int end,
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

		List<KdssmpParameterOptions> list = (List<KdssmpParameterOptions>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KDSSMPPARAMETEROPTIONS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KDSSMPPARAMETEROPTIONS;

				if (pagination) {
					sql = sql.concat(KdssmpParameterOptionsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<KdssmpParameterOptions>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<KdssmpParameterOptions>(list);
				}
				else {
					list = (List<KdssmpParameterOptions>)QueryUtil.list(q,
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
	 * Removes all the kdssmp parameter optionses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (KdssmpParameterOptions kdssmpParameterOptions : findAll()) {
			remove(kdssmpParameterOptions);
		}
	}

	/**
	 * Returns the number of kdssmp parameter optionses.
	 *
	 * @return the number of kdssmp parameter optionses
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

				Query q = session.createQuery(_SQL_COUNT_KDSSMPPARAMETEROPTIONS);

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
	 * Initializes the kdssmp parameter options persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<KdssmpParameterOptions>> listenersList = new ArrayList<ModelListener<KdssmpParameterOptions>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<KdssmpParameterOptions>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(KdssmpParameterOptionsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_KDSSMPPARAMETEROPTIONS = "SELECT kdssmpParameterOptions FROM KdssmpParameterOptions kdssmpParameterOptions";
	private static final String _SQL_SELECT_KDSSMPPARAMETEROPTIONS_WHERE = "SELECT kdssmpParameterOptions FROM KdssmpParameterOptions kdssmpParameterOptions WHERE ";
	private static final String _SQL_COUNT_KDSSMPPARAMETEROPTIONS = "SELECT COUNT(kdssmpParameterOptions) FROM KdssmpParameterOptions kdssmpParameterOptions";
	private static final String _SQL_COUNT_KDSSMPPARAMETEROPTIONS_WHERE = "SELECT COUNT(kdssmpParameterOptions) FROM KdssmpParameterOptions kdssmpParameterOptions WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kdssmpParameterOptions.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KdssmpParameterOptions exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KdssmpParameterOptions exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(KdssmpParameterOptionsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"option"
			});
	private static KdssmpParameterOptions _nullKdssmpParameterOptions = new KdssmpParameterOptionsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<KdssmpParameterOptions> toCacheModel() {
				return _nullKdssmpParameterOptionsCacheModel;
			}
		};

	private static CacheModel<KdssmpParameterOptions> _nullKdssmpParameterOptionsCacheModel =
		new CacheModel<KdssmpParameterOptions>() {
			@Override
			public KdssmpParameterOptions toEntityModel() {
				return _nullKdssmpParameterOptions;
			}
		};
}