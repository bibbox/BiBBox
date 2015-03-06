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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl;

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
 * The persistence implementation for the kdssmp configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see KdssmpConfigurationPersistence
 * @see KdssmpConfigurationUtil
 * @generated
 */
public class KdssmpConfigurationPersistenceImpl extends BasePersistenceImpl<KdssmpConfiguration>
	implements KdssmpConfigurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KdssmpConfigurationUtil} to access the kdssmp configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KdssmpConfigurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationModelImpl.FINDER_CACHE_ENABLED,
			KdssmpConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationModelImpl.FINDER_CACHE_ENABLED,
			KdssmpConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_OPTIONFINDER = new FinderPath(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationModelImpl.FINDER_CACHE_ENABLED,
			KdssmpConfigurationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByoptionfinder",
			new String[] { String.class.getName(), String.class.getName() },
			KdssmpConfigurationModelImpl.SCOPE_COLUMN_BITMASK |
			KdssmpConfigurationModelImpl.OPTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPTIONFINDER = new FinderPath(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByoptionfinder",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the kdssmp configuration where scope = &#63; and optionkey = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException} if it could not be found.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @return the matching kdssmp configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a matching kdssmp configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration findByoptionfinder(String scope, String optionkey)
		throws NoSuchKdssmpConfigurationException, SystemException {
		KdssmpConfiguration kdssmpConfiguration = fetchByoptionfinder(scope,
				optionkey);

		if (kdssmpConfiguration == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("scope=");
			msg.append(scope);

			msg.append(", optionkey=");
			msg.append(optionkey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchKdssmpConfigurationException(msg.toString());
		}

		return kdssmpConfiguration;
	}

	/**
	 * Returns the kdssmp configuration where scope = &#63; and optionkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @return the matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration fetchByoptionfinder(String scope,
		String optionkey) throws SystemException {
		return fetchByoptionfinder(scope, optionkey, true);
	}

	/**
	 * Returns the kdssmp configuration where scope = &#63; and optionkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration fetchByoptionfinder(String scope,
		String optionkey, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { scope, optionkey };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_OPTIONFINDER,
					finderArgs, this);
		}

		if (result instanceof KdssmpConfiguration) {
			KdssmpConfiguration kdssmpConfiguration = (KdssmpConfiguration)result;

			if (!Validator.equals(scope, kdssmpConfiguration.getScope()) ||
					!Validator.equals(optionkey,
						kdssmpConfiguration.getOptionkey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_KDSSMPCONFIGURATION_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_OPTIONFINDER_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONFINDER_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_OPTIONFINDER_SCOPE_2);
			}

			boolean bindOptionkey = false;

			if (optionkey == null) {
				query.append(_FINDER_COLUMN_OPTIONFINDER_OPTIONKEY_1);
			}
			else if (optionkey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONFINDER_OPTIONKEY_3);
			}
			else {
				bindOptionkey = true;

				query.append(_FINDER_COLUMN_OPTIONFINDER_OPTIONKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScope) {
					qPos.add(scope);
				}

				if (bindOptionkey) {
					qPos.add(optionkey);
				}

				List<KdssmpConfiguration> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONFINDER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"KdssmpConfigurationPersistenceImpl.fetchByoptionfinder(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					KdssmpConfiguration kdssmpConfiguration = list.get(0);

					result = kdssmpConfiguration;

					cacheResult(kdssmpConfiguration);

					if ((kdssmpConfiguration.getScope() == null) ||
							!kdssmpConfiguration.getScope().equals(scope) ||
							(kdssmpConfiguration.getOptionkey() == null) ||
							!kdssmpConfiguration.getOptionkey().equals(optionkey)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONFINDER,
							finderArgs, kdssmpConfiguration);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OPTIONFINDER,
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
			return (KdssmpConfiguration)result;
		}
	}

	/**
	 * Removes the kdssmp configuration where scope = &#63; and optionkey = &#63; from the database.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @return the kdssmp configuration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration removeByoptionfinder(String scope,
		String optionkey)
		throws NoSuchKdssmpConfigurationException, SystemException {
		KdssmpConfiguration kdssmpConfiguration = findByoptionfinder(scope,
				optionkey);

		return remove(kdssmpConfiguration);
	}

	/**
	 * Returns the number of kdssmp configurations where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @return the number of matching kdssmp configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByoptionfinder(String scope, String optionkey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPTIONFINDER;

		Object[] finderArgs = new Object[] { scope, optionkey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_KDSSMPCONFIGURATION_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_OPTIONFINDER_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONFINDER_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_OPTIONFINDER_SCOPE_2);
			}

			boolean bindOptionkey = false;

			if (optionkey == null) {
				query.append(_FINDER_COLUMN_OPTIONFINDER_OPTIONKEY_1);
			}
			else if (optionkey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONFINDER_OPTIONKEY_3);
			}
			else {
				bindOptionkey = true;

				query.append(_FINDER_COLUMN_OPTIONFINDER_OPTIONKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScope) {
					qPos.add(scope);
				}

				if (bindOptionkey) {
					qPos.add(optionkey);
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

	private static final String _FINDER_COLUMN_OPTIONFINDER_SCOPE_1 = "kdssmpConfiguration.scope IS NULL AND ";
	private static final String _FINDER_COLUMN_OPTIONFINDER_SCOPE_2 = "kdssmpConfiguration.scope = ? AND ";
	private static final String _FINDER_COLUMN_OPTIONFINDER_SCOPE_3 = "(kdssmpConfiguration.scope IS NULL OR kdssmpConfiguration.scope = '') AND ";
	private static final String _FINDER_COLUMN_OPTIONFINDER_OPTIONKEY_1 = "kdssmpConfiguration.optionkey IS NULL";
	private static final String _FINDER_COLUMN_OPTIONFINDER_OPTIONKEY_2 = "kdssmpConfiguration.optionkey = ?";
	private static final String _FINDER_COLUMN_OPTIONFINDER_OPTIONKEY_3 = "(kdssmpConfiguration.optionkey IS NULL OR kdssmpConfiguration.optionkey = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIONSFINDERKEY =
		new FinderPath(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationModelImpl.FINDER_CACHE_ENABLED,
			KdssmpConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByoptionsfinderkey",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERKEY =
		new FinderPath(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationModelImpl.FINDER_CACHE_ENABLED,
			KdssmpConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByoptionsfinderkey",
			new String[] { String.class.getName(), String.class.getName() },
			KdssmpConfigurationModelImpl.SCOPE_COLUMN_BITMASK |
			KdssmpConfigurationModelImpl.OPTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPTIONSFINDERKEY = new FinderPath(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByoptionsfinderkey",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the kdssmp configurations where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @return the matching kdssmp configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpConfiguration> findByoptionsfinderkey(String scope,
		String optionkey) throws SystemException {
		return findByoptionsfinderkey(scope, optionkey, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kdssmp configurations where scope = &#63; and optionkey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param start the lower bound of the range of kdssmp configurations
	 * @param end the upper bound of the range of kdssmp configurations (not inclusive)
	 * @return the range of matching kdssmp configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpConfiguration> findByoptionsfinderkey(String scope,
		String optionkey, int start, int end) throws SystemException {
		return findByoptionsfinderkey(scope, optionkey, start, end, null);
	}

	/**
	 * Returns an ordered range of all the kdssmp configurations where scope = &#63; and optionkey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param start the lower bound of the range of kdssmp configurations
	 * @param end the upper bound of the range of kdssmp configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kdssmp configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpConfiguration> findByoptionsfinderkey(String scope,
		String optionkey, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERKEY;
			finderArgs = new Object[] { scope, optionkey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIONSFINDERKEY;
			finderArgs = new Object[] {
					scope, optionkey,
					
					start, end, orderByComparator
				};
		}

		List<KdssmpConfiguration> list = (List<KdssmpConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (KdssmpConfiguration kdssmpConfiguration : list) {
				if (!Validator.equals(scope, kdssmpConfiguration.getScope()) ||
						!Validator.equals(optionkey,
							kdssmpConfiguration.getOptionkey())) {
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

			query.append(_SQL_SELECT_KDSSMPCONFIGURATION_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_2);
			}

			boolean bindOptionkey = false;

			if (optionkey == null) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_1);
			}
			else if (optionkey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_3);
			}
			else {
				bindOptionkey = true;

				query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(KdssmpConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScope) {
					qPos.add(scope);
				}

				if (bindOptionkey) {
					qPos.add(optionkey);
				}

				if (!pagination) {
					list = (List<KdssmpConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<KdssmpConfiguration>(list);
				}
				else {
					list = (List<KdssmpConfiguration>)QueryUtil.list(q,
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
	 * Returns the first kdssmp configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kdssmp configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a matching kdssmp configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration findByoptionsfinderkey_First(String scope,
		String optionkey, OrderByComparator orderByComparator)
		throws NoSuchKdssmpConfigurationException, SystemException {
		KdssmpConfiguration kdssmpConfiguration = fetchByoptionsfinderkey_First(scope,
				optionkey, orderByComparator);

		if (kdssmpConfiguration != null) {
			return kdssmpConfiguration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scope=");
		msg.append(scope);

		msg.append(", optionkey=");
		msg.append(optionkey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKdssmpConfigurationException(msg.toString());
	}

	/**
	 * Returns the first kdssmp configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration fetchByoptionsfinderkey_First(String scope,
		String optionkey, OrderByComparator orderByComparator)
		throws SystemException {
		List<KdssmpConfiguration> list = findByoptionsfinderkey(scope,
				optionkey, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kdssmp configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kdssmp configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a matching kdssmp configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration findByoptionsfinderkey_Last(String scope,
		String optionkey, OrderByComparator orderByComparator)
		throws NoSuchKdssmpConfigurationException, SystemException {
		KdssmpConfiguration kdssmpConfiguration = fetchByoptionsfinderkey_Last(scope,
				optionkey, orderByComparator);

		if (kdssmpConfiguration != null) {
			return kdssmpConfiguration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scope=");
		msg.append(scope);

		msg.append(", optionkey=");
		msg.append(optionkey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKdssmpConfigurationException(msg.toString());
	}

	/**
	 * Returns the last kdssmp configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration fetchByoptionsfinderkey_Last(String scope,
		String optionkey, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByoptionsfinderkey(scope, optionkey);

		if (count == 0) {
			return null;
		}

		List<KdssmpConfiguration> list = findByoptionsfinderkey(scope,
				optionkey, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the kdssmp configurations before and after the current kdssmp configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	 *
	 * @param configurationId the primary key of the current kdssmp configuration
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kdssmp configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a kdssmp configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration[] findByoptionsfinderkey_PrevAndNext(
		long configurationId, String scope, String optionkey,
		OrderByComparator orderByComparator)
		throws NoSuchKdssmpConfigurationException, SystemException {
		KdssmpConfiguration kdssmpConfiguration = findByPrimaryKey(configurationId);

		Session session = null;

		try {
			session = openSession();

			KdssmpConfiguration[] array = new KdssmpConfigurationImpl[3];

			array[0] = getByoptionsfinderkey_PrevAndNext(session,
					kdssmpConfiguration, scope, optionkey, orderByComparator,
					true);

			array[1] = kdssmpConfiguration;

			array[2] = getByoptionsfinderkey_PrevAndNext(session,
					kdssmpConfiguration, scope, optionkey, orderByComparator,
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

	protected KdssmpConfiguration getByoptionsfinderkey_PrevAndNext(
		Session session, KdssmpConfiguration kdssmpConfiguration, String scope,
		String optionkey, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KDSSMPCONFIGURATION_WHERE);

		boolean bindScope = false;

		if (scope == null) {
			query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_1);
		}
		else if (scope.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_3);
		}
		else {
			bindScope = true;

			query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_2);
		}

		boolean bindOptionkey = false;

		if (optionkey == null) {
			query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_1);
		}
		else if (optionkey.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_3);
		}
		else {
			bindOptionkey = true;

			query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_2);
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
			query.append(KdssmpConfigurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindScope) {
			qPos.add(scope);
		}

		if (bindOptionkey) {
			qPos.add(optionkey);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(kdssmpConfiguration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KdssmpConfiguration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kdssmp configurations where scope = &#63; and optionkey = &#63; from the database.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByoptionsfinderkey(String scope, String optionkey)
		throws SystemException {
		for (KdssmpConfiguration kdssmpConfiguration : findByoptionsfinderkey(
				scope, optionkey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(kdssmpConfiguration);
		}
	}

	/**
	 * Returns the number of kdssmp configurations where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @return the number of matching kdssmp configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByoptionsfinderkey(String scope, String optionkey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPTIONSFINDERKEY;

		Object[] finderArgs = new Object[] { scope, optionkey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_KDSSMPCONFIGURATION_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_2);
			}

			boolean bindOptionkey = false;

			if (optionkey == null) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_1);
			}
			else if (optionkey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_3);
			}
			else {
				bindOptionkey = true;

				query.append(_FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScope) {
					qPos.add(scope);
				}

				if (bindOptionkey) {
					qPos.add(optionkey);
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

	private static final String _FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_1 = "kdssmpConfiguration.scope IS NULL AND ";
	private static final String _FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_2 = "kdssmpConfiguration.scope = ? AND ";
	private static final String _FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_3 = "(kdssmpConfiguration.scope IS NULL OR kdssmpConfiguration.scope = '') AND ";
	private static final String _FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_1 = "kdssmpConfiguration.optionkey IS NULL";
	private static final String _FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_2 = "kdssmpConfiguration.optionkey = ?";
	private static final String _FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_3 = "(kdssmpConfiguration.optionkey IS NULL OR kdssmpConfiguration.optionkey = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIONSFINDER =
		new FinderPath(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationModelImpl.FINDER_CACHE_ENABLED,
			KdssmpConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByoptionsfinder",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDER =
		new FinderPath(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationModelImpl.FINDER_CACHE_ENABLED,
			KdssmpConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByoptionsfinder",
			new String[] { String.class.getName() },
			KdssmpConfigurationModelImpl.SCOPE_COLUMN_BITMASK |
			KdssmpConfigurationModelImpl.OPTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPTIONSFINDER = new FinderPath(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByoptionsfinder",
			new String[] { String.class.getName() });

	/**
	 * Returns all the kdssmp configurations where scope = &#63;.
	 *
	 * @param scope the scope
	 * @return the matching kdssmp configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpConfiguration> findByoptionsfinder(String scope)
		throws SystemException {
		return findByoptionsfinder(scope, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the kdssmp configurations where scope = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scope the scope
	 * @param start the lower bound of the range of kdssmp configurations
	 * @param end the upper bound of the range of kdssmp configurations (not inclusive)
	 * @return the range of matching kdssmp configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpConfiguration> findByoptionsfinder(String scope,
		int start, int end) throws SystemException {
		return findByoptionsfinder(scope, start, end, null);
	}

	/**
	 * Returns an ordered range of all the kdssmp configurations where scope = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scope the scope
	 * @param start the lower bound of the range of kdssmp configurations
	 * @param end the upper bound of the range of kdssmp configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kdssmp configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpConfiguration> findByoptionsfinder(String scope,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDER;
			finderArgs = new Object[] { scope };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIONSFINDER;
			finderArgs = new Object[] { scope, start, end, orderByComparator };
		}

		List<KdssmpConfiguration> list = (List<KdssmpConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (KdssmpConfiguration kdssmpConfiguration : list) {
				if (!Validator.equals(scope, kdssmpConfiguration.getScope())) {
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

			query.append(_SQL_SELECT_KDSSMPCONFIGURATION_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_OPTIONSFINDER_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONSFINDER_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_OPTIONSFINDER_SCOPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(KdssmpConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScope) {
					qPos.add(scope);
				}

				if (!pagination) {
					list = (List<KdssmpConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<KdssmpConfiguration>(list);
				}
				else {
					list = (List<KdssmpConfiguration>)QueryUtil.list(q,
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
	 * Returns the first kdssmp configuration in the ordered set where scope = &#63;.
	 *
	 * @param scope the scope
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kdssmp configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a matching kdssmp configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration findByoptionsfinder_First(String scope,
		OrderByComparator orderByComparator)
		throws NoSuchKdssmpConfigurationException, SystemException {
		KdssmpConfiguration kdssmpConfiguration = fetchByoptionsfinder_First(scope,
				orderByComparator);

		if (kdssmpConfiguration != null) {
			return kdssmpConfiguration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scope=");
		msg.append(scope);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKdssmpConfigurationException(msg.toString());
	}

	/**
	 * Returns the first kdssmp configuration in the ordered set where scope = &#63;.
	 *
	 * @param scope the scope
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration fetchByoptionsfinder_First(String scope,
		OrderByComparator orderByComparator) throws SystemException {
		List<KdssmpConfiguration> list = findByoptionsfinder(scope, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kdssmp configuration in the ordered set where scope = &#63;.
	 *
	 * @param scope the scope
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kdssmp configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a matching kdssmp configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration findByoptionsfinder_Last(String scope,
		OrderByComparator orderByComparator)
		throws NoSuchKdssmpConfigurationException, SystemException {
		KdssmpConfiguration kdssmpConfiguration = fetchByoptionsfinder_Last(scope,
				orderByComparator);

		if (kdssmpConfiguration != null) {
			return kdssmpConfiguration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scope=");
		msg.append(scope);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKdssmpConfigurationException(msg.toString());
	}

	/**
	 * Returns the last kdssmp configuration in the ordered set where scope = &#63;.
	 *
	 * @param scope the scope
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration fetchByoptionsfinder_Last(String scope,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByoptionsfinder(scope);

		if (count == 0) {
			return null;
		}

		List<KdssmpConfiguration> list = findByoptionsfinder(scope, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the kdssmp configurations before and after the current kdssmp configuration in the ordered set where scope = &#63;.
	 *
	 * @param configurationId the primary key of the current kdssmp configuration
	 * @param scope the scope
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kdssmp configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a kdssmp configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration[] findByoptionsfinder_PrevAndNext(
		long configurationId, String scope, OrderByComparator orderByComparator)
		throws NoSuchKdssmpConfigurationException, SystemException {
		KdssmpConfiguration kdssmpConfiguration = findByPrimaryKey(configurationId);

		Session session = null;

		try {
			session = openSession();

			KdssmpConfiguration[] array = new KdssmpConfigurationImpl[3];

			array[0] = getByoptionsfinder_PrevAndNext(session,
					kdssmpConfiguration, scope, orderByComparator, true);

			array[1] = kdssmpConfiguration;

			array[2] = getByoptionsfinder_PrevAndNext(session,
					kdssmpConfiguration, scope, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KdssmpConfiguration getByoptionsfinder_PrevAndNext(
		Session session, KdssmpConfiguration kdssmpConfiguration, String scope,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KDSSMPCONFIGURATION_WHERE);

		boolean bindScope = false;

		if (scope == null) {
			query.append(_FINDER_COLUMN_OPTIONSFINDER_SCOPE_1);
		}
		else if (scope.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OPTIONSFINDER_SCOPE_3);
		}
		else {
			bindScope = true;

			query.append(_FINDER_COLUMN_OPTIONSFINDER_SCOPE_2);
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
			query.append(KdssmpConfigurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindScope) {
			qPos.add(scope);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(kdssmpConfiguration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KdssmpConfiguration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kdssmp configurations where scope = &#63; from the database.
	 *
	 * @param scope the scope
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByoptionsfinder(String scope) throws SystemException {
		for (KdssmpConfiguration kdssmpConfiguration : findByoptionsfinder(
				scope, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(kdssmpConfiguration);
		}
	}

	/**
	 * Returns the number of kdssmp configurations where scope = &#63;.
	 *
	 * @param scope the scope
	 * @return the number of matching kdssmp configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByoptionsfinder(String scope) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPTIONSFINDER;

		Object[] finderArgs = new Object[] { scope };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KDSSMPCONFIGURATION_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_OPTIONSFINDER_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONSFINDER_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_OPTIONSFINDER_SCOPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScope) {
					qPos.add(scope);
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

	private static final String _FINDER_COLUMN_OPTIONSFINDER_SCOPE_1 = "kdssmpConfiguration.scope IS NULL";
	private static final String _FINDER_COLUMN_OPTIONSFINDER_SCOPE_2 = "kdssmpConfiguration.scope = ?";
	private static final String _FINDER_COLUMN_OPTIONSFINDER_SCOPE_3 = "(kdssmpConfiguration.scope IS NULL OR kdssmpConfiguration.scope = '')";

	public KdssmpConfigurationPersistenceImpl() {
		setModelClass(KdssmpConfiguration.class);
	}

	/**
	 * Caches the kdssmp configuration in the entity cache if it is enabled.
	 *
	 * @param kdssmpConfiguration the kdssmp configuration
	 */
	@Override
	public void cacheResult(KdssmpConfiguration kdssmpConfiguration) {
		EntityCacheUtil.putResult(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationImpl.class, kdssmpConfiguration.getPrimaryKey(),
			kdssmpConfiguration);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONFINDER,
			new Object[] {
				kdssmpConfiguration.getScope(),
				kdssmpConfiguration.getOptionkey()
			}, kdssmpConfiguration);

		kdssmpConfiguration.resetOriginalValues();
	}

	/**
	 * Caches the kdssmp configurations in the entity cache if it is enabled.
	 *
	 * @param kdssmpConfigurations the kdssmp configurations
	 */
	@Override
	public void cacheResult(List<KdssmpConfiguration> kdssmpConfigurations) {
		for (KdssmpConfiguration kdssmpConfiguration : kdssmpConfigurations) {
			if (EntityCacheUtil.getResult(
						KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						KdssmpConfigurationImpl.class,
						kdssmpConfiguration.getPrimaryKey()) == null) {
				cacheResult(kdssmpConfiguration);
			}
			else {
				kdssmpConfiguration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kdssmp configurations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(KdssmpConfigurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(KdssmpConfigurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kdssmp configuration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KdssmpConfiguration kdssmpConfiguration) {
		EntityCacheUtil.removeResult(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationImpl.class, kdssmpConfiguration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(kdssmpConfiguration);
	}

	@Override
	public void clearCache(List<KdssmpConfiguration> kdssmpConfigurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KdssmpConfiguration kdssmpConfiguration : kdssmpConfigurations) {
			EntityCacheUtil.removeResult(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				KdssmpConfigurationImpl.class,
				kdssmpConfiguration.getPrimaryKey());

			clearUniqueFindersCache(kdssmpConfiguration);
		}
	}

	protected void cacheUniqueFindersCache(
		KdssmpConfiguration kdssmpConfiguration) {
		if (kdssmpConfiguration.isNew()) {
			Object[] args = new Object[] {
					kdssmpConfiguration.getScope(),
					kdssmpConfiguration.getOptionkey()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OPTIONFINDER, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONFINDER, args,
				kdssmpConfiguration);
		}
		else {
			KdssmpConfigurationModelImpl kdssmpConfigurationModelImpl = (KdssmpConfigurationModelImpl)kdssmpConfiguration;

			if ((kdssmpConfigurationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_OPTIONFINDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kdssmpConfiguration.getScope(),
						kdssmpConfiguration.getOptionkey()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OPTIONFINDER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONFINDER,
					args, kdssmpConfiguration);
			}
		}
	}

	protected void clearUniqueFindersCache(
		KdssmpConfiguration kdssmpConfiguration) {
		KdssmpConfigurationModelImpl kdssmpConfigurationModelImpl = (KdssmpConfigurationModelImpl)kdssmpConfiguration;

		Object[] args = new Object[] {
				kdssmpConfiguration.getScope(),
				kdssmpConfiguration.getOptionkey()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONFINDER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OPTIONFINDER, args);

		if ((kdssmpConfigurationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_OPTIONFINDER.getColumnBitmask()) != 0) {
			args = new Object[] {
					kdssmpConfigurationModelImpl.getOriginalScope(),
					kdssmpConfigurationModelImpl.getOriginalOptionkey()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONFINDER, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OPTIONFINDER, args);
		}
	}

	/**
	 * Creates a new kdssmp configuration with the primary key. Does not add the kdssmp configuration to the database.
	 *
	 * @param configurationId the primary key for the new kdssmp configuration
	 * @return the new kdssmp configuration
	 */
	@Override
	public KdssmpConfiguration create(long configurationId) {
		KdssmpConfiguration kdssmpConfiguration = new KdssmpConfigurationImpl();

		kdssmpConfiguration.setNew(true);
		kdssmpConfiguration.setPrimaryKey(configurationId);

		return kdssmpConfiguration;
	}

	/**
	 * Removes the kdssmp configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configurationId the primary key of the kdssmp configuration
	 * @return the kdssmp configuration that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a kdssmp configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration remove(long configurationId)
		throws NoSuchKdssmpConfigurationException, SystemException {
		return remove((Serializable)configurationId);
	}

	/**
	 * Removes the kdssmp configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kdssmp configuration
	 * @return the kdssmp configuration that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a kdssmp configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration remove(Serializable primaryKey)
		throws NoSuchKdssmpConfigurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KdssmpConfiguration kdssmpConfiguration = (KdssmpConfiguration)session.get(KdssmpConfigurationImpl.class,
					primaryKey);

			if (kdssmpConfiguration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKdssmpConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(kdssmpConfiguration);
		}
		catch (NoSuchKdssmpConfigurationException nsee) {
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
	protected KdssmpConfiguration removeImpl(
		KdssmpConfiguration kdssmpConfiguration) throws SystemException {
		kdssmpConfiguration = toUnwrappedModel(kdssmpConfiguration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kdssmpConfiguration)) {
				kdssmpConfiguration = (KdssmpConfiguration)session.get(KdssmpConfigurationImpl.class,
						kdssmpConfiguration.getPrimaryKeyObj());
			}

			if (kdssmpConfiguration != null) {
				session.delete(kdssmpConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kdssmpConfiguration != null) {
			clearCache(kdssmpConfiguration);
		}

		return kdssmpConfiguration;
	}

	@Override
	public KdssmpConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration kdssmpConfiguration)
		throws SystemException {
		kdssmpConfiguration = toUnwrappedModel(kdssmpConfiguration);

		boolean isNew = kdssmpConfiguration.isNew();

		KdssmpConfigurationModelImpl kdssmpConfigurationModelImpl = (KdssmpConfigurationModelImpl)kdssmpConfiguration;

		Session session = null;

		try {
			session = openSession();

			if (kdssmpConfiguration.isNew()) {
				session.save(kdssmpConfiguration);

				kdssmpConfiguration.setNew(false);
			}
			else {
				session.merge(kdssmpConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !KdssmpConfigurationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((kdssmpConfigurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kdssmpConfigurationModelImpl.getOriginalScope(),
						kdssmpConfigurationModelImpl.getOriginalOptionkey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFINDERKEY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERKEY,
					args);

				args = new Object[] {
						kdssmpConfigurationModelImpl.getScope(),
						kdssmpConfigurationModelImpl.getOptionkey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFINDERKEY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERKEY,
					args);
			}

			if ((kdssmpConfigurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kdssmpConfigurationModelImpl.getOriginalScope()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFINDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDER,
					args);

				args = new Object[] { kdssmpConfigurationModelImpl.getScope() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFINDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDER,
					args);
			}
		}

		EntityCacheUtil.putResult(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpConfigurationImpl.class, kdssmpConfiguration.getPrimaryKey(),
			kdssmpConfiguration);

		clearUniqueFindersCache(kdssmpConfiguration);
		cacheUniqueFindersCache(kdssmpConfiguration);

		return kdssmpConfiguration;
	}

	protected KdssmpConfiguration toUnwrappedModel(
		KdssmpConfiguration kdssmpConfiguration) {
		if (kdssmpConfiguration instanceof KdssmpConfigurationImpl) {
			return kdssmpConfiguration;
		}

		KdssmpConfigurationImpl kdssmpConfigurationImpl = new KdssmpConfigurationImpl();

		kdssmpConfigurationImpl.setNew(kdssmpConfiguration.isNew());
		kdssmpConfigurationImpl.setPrimaryKey(kdssmpConfiguration.getPrimaryKey());

		kdssmpConfigurationImpl.setConfigurationId(kdssmpConfiguration.getConfigurationId());
		kdssmpConfigurationImpl.setScope(kdssmpConfiguration.getScope());
		kdssmpConfigurationImpl.setOptionkey(kdssmpConfiguration.getOptionkey());
		kdssmpConfigurationImpl.setOptionvalue(kdssmpConfiguration.getOptionvalue());

		return kdssmpConfigurationImpl;
	}

	/**
	 * Returns the kdssmp configuration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the kdssmp configuration
	 * @return the kdssmp configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a kdssmp configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKdssmpConfigurationException, SystemException {
		KdssmpConfiguration kdssmpConfiguration = fetchByPrimaryKey(primaryKey);

		if (kdssmpConfiguration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKdssmpConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return kdssmpConfiguration;
	}

	/**
	 * Returns the kdssmp configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException} if it could not be found.
	 *
	 * @param configurationId the primary key of the kdssmp configuration
	 * @return the kdssmp configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a kdssmp configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration findByPrimaryKey(long configurationId)
		throws NoSuchKdssmpConfigurationException, SystemException {
		return findByPrimaryKey((Serializable)configurationId);
	}

	/**
	 * Returns the kdssmp configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kdssmp configuration
	 * @return the kdssmp configuration, or <code>null</code> if a kdssmp configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		KdssmpConfiguration kdssmpConfiguration = (KdssmpConfiguration)EntityCacheUtil.getResult(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				KdssmpConfigurationImpl.class, primaryKey);

		if (kdssmpConfiguration == _nullKdssmpConfiguration) {
			return null;
		}

		if (kdssmpConfiguration == null) {
			Session session = null;

			try {
				session = openSession();

				kdssmpConfiguration = (KdssmpConfiguration)session.get(KdssmpConfigurationImpl.class,
						primaryKey);

				if (kdssmpConfiguration != null) {
					cacheResult(kdssmpConfiguration);
				}
				else {
					EntityCacheUtil.putResult(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						KdssmpConfigurationImpl.class, primaryKey,
						_nullKdssmpConfiguration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(KdssmpConfigurationModelImpl.ENTITY_CACHE_ENABLED,
					KdssmpConfigurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return kdssmpConfiguration;
	}

	/**
	 * Returns the kdssmp configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configurationId the primary key of the kdssmp configuration
	 * @return the kdssmp configuration, or <code>null</code> if a kdssmp configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpConfiguration fetchByPrimaryKey(long configurationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)configurationId);
	}

	/**
	 * Returns all the kdssmp configurations.
	 *
	 * @return the kdssmp configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpConfiguration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kdssmp configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kdssmp configurations
	 * @param end the upper bound of the range of kdssmp configurations (not inclusive)
	 * @return the range of kdssmp configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpConfiguration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the kdssmp configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kdssmp configurations
	 * @param end the upper bound of the range of kdssmp configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kdssmp configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpConfiguration> findAll(int start, int end,
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

		List<KdssmpConfiguration> list = (List<KdssmpConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KDSSMPCONFIGURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KDSSMPCONFIGURATION;

				if (pagination) {
					sql = sql.concat(KdssmpConfigurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<KdssmpConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<KdssmpConfiguration>(list);
				}
				else {
					list = (List<KdssmpConfiguration>)QueryUtil.list(q,
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
	 * Removes all the kdssmp configurations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (KdssmpConfiguration kdssmpConfiguration : findAll()) {
			remove(kdssmpConfiguration);
		}
	}

	/**
	 * Returns the number of kdssmp configurations.
	 *
	 * @return the number of kdssmp configurations
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

				Query q = session.createQuery(_SQL_COUNT_KDSSMPCONFIGURATION);

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
	 * Initializes the kdssmp configuration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<KdssmpConfiguration>> listenersList = new ArrayList<ModelListener<KdssmpConfiguration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<KdssmpConfiguration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(KdssmpConfigurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_KDSSMPCONFIGURATION = "SELECT kdssmpConfiguration FROM KdssmpConfiguration kdssmpConfiguration";
	private static final String _SQL_SELECT_KDSSMPCONFIGURATION_WHERE = "SELECT kdssmpConfiguration FROM KdssmpConfiguration kdssmpConfiguration WHERE ";
	private static final String _SQL_COUNT_KDSSMPCONFIGURATION = "SELECT COUNT(kdssmpConfiguration) FROM KdssmpConfiguration kdssmpConfiguration";
	private static final String _SQL_COUNT_KDSSMPCONFIGURATION_WHERE = "SELECT COUNT(kdssmpConfiguration) FROM KdssmpConfiguration kdssmpConfiguration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kdssmpConfiguration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KdssmpConfiguration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KdssmpConfiguration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(KdssmpConfigurationPersistenceImpl.class);
	private static KdssmpConfiguration _nullKdssmpConfiguration = new KdssmpConfigurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<KdssmpConfiguration> toCacheModel() {
				return _nullKdssmpConfigurationCacheModel;
			}
		};

	private static CacheModel<KdssmpConfiguration> _nullKdssmpConfigurationCacheModel =
		new CacheModel<KdssmpConfiguration>() {
			@Override
			public KdssmpConfiguration toEntityModel() {
				return _nullKdssmpConfiguration;
			}
		};
}