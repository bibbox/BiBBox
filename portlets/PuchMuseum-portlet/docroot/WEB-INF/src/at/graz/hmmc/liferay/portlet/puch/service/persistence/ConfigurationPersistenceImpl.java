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

import at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException;
import at.graz.hmmc.liferay.portlet.puch.model.Configuration;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationImpl;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl;

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
 * The persistence implementation for the configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ConfigurationPersistence
 * @see ConfigurationUtil
 * @generated
 */
public class ConfigurationPersistenceImpl extends BasePersistenceImpl<Configuration>
	implements ConfigurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConfigurationUtil} to access the configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConfigurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_OPTIONFINDER = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByoptionFinder",
			new String[] { String.class.getName(), String.class.getName() },
			ConfigurationModelImpl.SCOPE_COLUMN_BITMASK |
			ConfigurationModelImpl.OPTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPTIONFINDER = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByoptionFinder",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the configuration where scope = &#63; and optionkey = &#63; or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException} if it could not be found.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @return the matching configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByoptionFinder(String scope, String optionkey)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = fetchByoptionFinder(scope, optionkey);

		if (configuration == null) {
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

			throw new NoSuchConfigurationException(msg.toString());
		}

		return configuration;
	}

	/**
	 * Returns the configuration where scope = &#63; and optionkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @return the matching configuration, or <code>null</code> if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByoptionFinder(String scope, String optionkey)
		throws SystemException {
		return fetchByoptionFinder(scope, optionkey, true);
	}

	/**
	 * Returns the configuration where scope = &#63; and optionkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching configuration, or <code>null</code> if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByoptionFinder(String scope, String optionkey,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { scope, optionkey };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_OPTIONFINDER,
					finderArgs, this);
		}

		if (result instanceof Configuration) {
			Configuration configuration = (Configuration)result;

			if (!Validator.equals(scope, configuration.getScope()) ||
					!Validator.equals(optionkey, configuration.getOptionkey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONFIGURATION_WHERE);

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

				List<Configuration> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONFINDER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ConfigurationPersistenceImpl.fetchByoptionFinder(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Configuration configuration = list.get(0);

					result = configuration;

					cacheResult(configuration);

					if ((configuration.getScope() == null) ||
							!configuration.getScope().equals(scope) ||
							(configuration.getOptionkey() == null) ||
							!configuration.getOptionkey().equals(optionkey)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONFINDER,
							finderArgs, configuration);
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
			return (Configuration)result;
		}
	}

	/**
	 * Removes the configuration where scope = &#63; and optionkey = &#63; from the database.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @return the configuration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration removeByoptionFinder(String scope, String optionkey)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = findByoptionFinder(scope, optionkey);

		return remove(configuration);
	}

	/**
	 * Returns the number of configurations where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @return the number of matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByoptionFinder(String scope, String optionkey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPTIONFINDER;

		Object[] finderArgs = new Object[] { scope, optionkey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONFIGURATION_WHERE);

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

	private static final String _FINDER_COLUMN_OPTIONFINDER_SCOPE_1 = "configuration.scope IS NULL AND ";
	private static final String _FINDER_COLUMN_OPTIONFINDER_SCOPE_2 = "configuration.scope = ? AND ";
	private static final String _FINDER_COLUMN_OPTIONFINDER_SCOPE_3 = "(configuration.scope IS NULL OR configuration.scope = '') AND ";
	private static final String _FINDER_COLUMN_OPTIONFINDER_OPTIONKEY_1 = "configuration.optionkey IS NULL";
	private static final String _FINDER_COLUMN_OPTIONFINDER_OPTIONKEY_2 = "configuration.optionkey = ?";
	private static final String _FINDER_COLUMN_OPTIONFINDER_OPTIONKEY_3 = "(configuration.optionkey IS NULL OR configuration.optionkey = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_OPTIONSFINDERVALUE = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByoptionsFinderValue",
			new String[] { String.class.getName(), String.class.getName() },
			ConfigurationModelImpl.SCOPE_COLUMN_BITMASK |
			ConfigurationModelImpl.OPTIONVALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPTIONSFINDERVALUE = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByoptionsFinderValue",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the configuration where scope = &#63; and optionvalue = &#63; or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException} if it could not be found.
	 *
	 * @param scope the scope
	 * @param optionvalue the optionvalue
	 * @return the matching configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByoptionsFinderValue(String scope,
		String optionvalue)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = fetchByoptionsFinderValue(scope,
				optionvalue);

		if (configuration == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("scope=");
			msg.append(scope);

			msg.append(", optionvalue=");
			msg.append(optionvalue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchConfigurationException(msg.toString());
		}

		return configuration;
	}

	/**
	 * Returns the configuration where scope = &#63; and optionvalue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param scope the scope
	 * @param optionvalue the optionvalue
	 * @return the matching configuration, or <code>null</code> if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByoptionsFinderValue(String scope,
		String optionvalue) throws SystemException {
		return fetchByoptionsFinderValue(scope, optionvalue, true);
	}

	/**
	 * Returns the configuration where scope = &#63; and optionvalue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param scope the scope
	 * @param optionvalue the optionvalue
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching configuration, or <code>null</code> if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByoptionsFinderValue(String scope,
		String optionvalue, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { scope, optionvalue };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_OPTIONSFINDERVALUE,
					finderArgs, this);
		}

		if (result instanceof Configuration) {
			Configuration configuration = (Configuration)result;

			if (!Validator.equals(scope, configuration.getScope()) ||
					!Validator.equals(optionvalue,
						configuration.getOptionvalue())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONFIGURATION_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERVALUE_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERVALUE_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_OPTIONSFINDERVALUE_SCOPE_2);
			}

			boolean bindOptionvalue = false;

			if (optionvalue == null) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERVALUE_OPTIONVALUE_1);
			}
			else if (optionvalue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERVALUE_OPTIONVALUE_3);
			}
			else {
				bindOptionvalue = true;

				query.append(_FINDER_COLUMN_OPTIONSFINDERVALUE_OPTIONVALUE_2);
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

				if (bindOptionvalue) {
					qPos.add(optionvalue);
				}

				List<Configuration> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONSFINDERVALUE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ConfigurationPersistenceImpl.fetchByoptionsFinderValue(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Configuration configuration = list.get(0);

					result = configuration;

					cacheResult(configuration);

					if ((configuration.getScope() == null) ||
							!configuration.getScope().equals(scope) ||
							(configuration.getOptionvalue() == null) ||
							!configuration.getOptionvalue().equals(optionvalue)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONSFINDERVALUE,
							finderArgs, configuration);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OPTIONSFINDERVALUE,
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
			return (Configuration)result;
		}
	}

	/**
	 * Removes the configuration where scope = &#63; and optionvalue = &#63; from the database.
	 *
	 * @param scope the scope
	 * @param optionvalue the optionvalue
	 * @return the configuration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration removeByoptionsFinderValue(String scope,
		String optionvalue)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = findByoptionsFinderValue(scope,
				optionvalue);

		return remove(configuration);
	}

	/**
	 * Returns the number of configurations where scope = &#63; and optionvalue = &#63;.
	 *
	 * @param scope the scope
	 * @param optionvalue the optionvalue
	 * @return the number of matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByoptionsFinderValue(String scope, String optionvalue)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPTIONSFINDERVALUE;

		Object[] finderArgs = new Object[] { scope, optionvalue };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONFIGURATION_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERVALUE_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERVALUE_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_OPTIONSFINDERVALUE_SCOPE_2);
			}

			boolean bindOptionvalue = false;

			if (optionvalue == null) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERVALUE_OPTIONVALUE_1);
			}
			else if (optionvalue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERVALUE_OPTIONVALUE_3);
			}
			else {
				bindOptionvalue = true;

				query.append(_FINDER_COLUMN_OPTIONSFINDERVALUE_OPTIONVALUE_2);
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

				if (bindOptionvalue) {
					qPos.add(optionvalue);
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

	private static final String _FINDER_COLUMN_OPTIONSFINDERVALUE_SCOPE_1 = "configuration.scope IS NULL AND ";
	private static final String _FINDER_COLUMN_OPTIONSFINDERVALUE_SCOPE_2 = "configuration.scope = ? AND ";
	private static final String _FINDER_COLUMN_OPTIONSFINDERVALUE_SCOPE_3 = "(configuration.scope IS NULL OR configuration.scope = '') AND ";
	private static final String _FINDER_COLUMN_OPTIONSFINDERVALUE_OPTIONVALUE_1 = "configuration.optionvalue IS NULL";
	private static final String _FINDER_COLUMN_OPTIONSFINDERVALUE_OPTIONVALUE_2 = "configuration.optionvalue = ?";
	private static final String _FINDER_COLUMN_OPTIONSFINDERVALUE_OPTIONVALUE_3 = "(configuration.optionvalue IS NULL OR configuration.optionvalue = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIONSFINDERKEY =
		new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByoptionsFinderKey",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERKEY =
		new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByoptionsFinderKey",
			new String[] { String.class.getName(), String.class.getName() },
			ConfigurationModelImpl.SCOPE_COLUMN_BITMASK |
			ConfigurationModelImpl.OPTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPTIONSFINDERKEY = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByoptionsFinderKey",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the configurations where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @return the matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findByoptionsFinderKey(String scope,
		String optionkey) throws SystemException {
		return findByoptionsFinderKey(scope, optionkey, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configurations where scope = &#63; and optionkey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param start the lower bound of the range of configurations
	 * @param end the upper bound of the range of configurations (not inclusive)
	 * @return the range of matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findByoptionsFinderKey(String scope,
		String optionkey, int start, int end) throws SystemException {
		return findByoptionsFinderKey(scope, optionkey, start, end, null);
	}

	/**
	 * Returns an ordered range of all the configurations where scope = &#63; and optionkey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param start the lower bound of the range of configurations
	 * @param end the upper bound of the range of configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findByoptionsFinderKey(String scope,
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

		List<Configuration> list = (List<Configuration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Configuration configuration : list) {
				if (!Validator.equals(scope, configuration.getScope()) ||
						!Validator.equals(optionkey,
							configuration.getOptionkey())) {
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

			query.append(_SQL_SELECT_CONFIGURATION_WHERE);

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
				query.append(ConfigurationModelImpl.ORDER_BY_JPQL);
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
					list = (List<Configuration>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Configuration>(list);
				}
				else {
					list = (List<Configuration>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByoptionsFinderKey_First(String scope,
		String optionkey, OrderByComparator orderByComparator)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = fetchByoptionsFinderKey_First(scope,
				optionkey, orderByComparator);

		if (configuration != null) {
			return configuration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scope=");
		msg.append(scope);

		msg.append(", optionkey=");
		msg.append(optionkey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConfigurationException(msg.toString());
	}

	/**
	 * Returns the first configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration, or <code>null</code> if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByoptionsFinderKey_First(String scope,
		String optionkey, OrderByComparator orderByComparator)
		throws SystemException {
		List<Configuration> list = findByoptionsFinderKey(scope, optionkey, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByoptionsFinderKey_Last(String scope,
		String optionkey, OrderByComparator orderByComparator)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = fetchByoptionsFinderKey_Last(scope,
				optionkey, orderByComparator);

		if (configuration != null) {
			return configuration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scope=");
		msg.append(scope);

		msg.append(", optionkey=");
		msg.append(optionkey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConfigurationException(msg.toString());
	}

	/**
	 * Returns the last configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration, or <code>null</code> if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByoptionsFinderKey_Last(String scope,
		String optionkey, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByoptionsFinderKey(scope, optionkey);

		if (count == 0) {
			return null;
		}

		List<Configuration> list = findByoptionsFinderKey(scope, optionkey,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the configurations before and after the current configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	 *
	 * @param configurationId the primary key of the current configuration
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration[] findByoptionsFinderKey_PrevAndNext(
		long configurationId, String scope, String optionkey,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = findByPrimaryKey(configurationId);

		Session session = null;

		try {
			session = openSession();

			Configuration[] array = new ConfigurationImpl[3];

			array[0] = getByoptionsFinderKey_PrevAndNext(session,
					configuration, scope, optionkey, orderByComparator, true);

			array[1] = configuration;

			array[2] = getByoptionsFinderKey_PrevAndNext(session,
					configuration, scope, optionkey, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Configuration getByoptionsFinderKey_PrevAndNext(Session session,
		Configuration configuration, String scope, String optionkey,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONFIGURATION_WHERE);

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
			query.append(ConfigurationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(configuration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Configuration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the configurations where scope = &#63; and optionkey = &#63; from the database.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByoptionsFinderKey(String scope, String optionkey)
		throws SystemException {
		for (Configuration configuration : findByoptionsFinderKey(scope,
				optionkey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(configuration);
		}
	}

	/**
	 * Returns the number of configurations where scope = &#63; and optionkey = &#63;.
	 *
	 * @param scope the scope
	 * @param optionkey the optionkey
	 * @return the number of matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByoptionsFinderKey(String scope, String optionkey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPTIONSFINDERKEY;

		Object[] finderArgs = new Object[] { scope, optionkey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONFIGURATION_WHERE);

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

	private static final String _FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_1 = "configuration.scope IS NULL AND ";
	private static final String _FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_2 = "configuration.scope = ? AND ";
	private static final String _FINDER_COLUMN_OPTIONSFINDERKEY_SCOPE_3 = "(configuration.scope IS NULL OR configuration.scope = '') AND ";
	private static final String _FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_1 = "configuration.optionkey IS NULL";
	private static final String _FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_2 = "configuration.optionkey = ?";
	private static final String _FINDER_COLUMN_OPTIONSFINDERKEY_OPTIONKEY_3 = "(configuration.optionkey IS NULL OR configuration.optionkey = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIONSFINDER =
		new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByoptionsFinder",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDER =
		new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByoptionsFinder", new String[] { String.class.getName() },
			ConfigurationModelImpl.SCOPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPTIONSFINDER = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByoptionsFinder",
			new String[] { String.class.getName() });

	/**
	 * Returns all the configurations where scope = &#63;.
	 *
	 * @param scope the scope
	 * @return the matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findByoptionsFinder(String scope)
		throws SystemException {
		return findByoptionsFinder(scope, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the configurations where scope = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scope the scope
	 * @param start the lower bound of the range of configurations
	 * @param end the upper bound of the range of configurations (not inclusive)
	 * @return the range of matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findByoptionsFinder(String scope, int start,
		int end) throws SystemException {
		return findByoptionsFinder(scope, start, end, null);
	}

	/**
	 * Returns an ordered range of all the configurations where scope = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scope the scope
	 * @param start the lower bound of the range of configurations
	 * @param end the upper bound of the range of configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findByoptionsFinder(String scope, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<Configuration> list = (List<Configuration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Configuration configuration : list) {
				if (!Validator.equals(scope, configuration.getScope())) {
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

			query.append(_SQL_SELECT_CONFIGURATION_WHERE);

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
				query.append(ConfigurationModelImpl.ORDER_BY_JPQL);
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
					list = (List<Configuration>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Configuration>(list);
				}
				else {
					list = (List<Configuration>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first configuration in the ordered set where scope = &#63;.
	 *
	 * @param scope the scope
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByoptionsFinder_First(String scope,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = fetchByoptionsFinder_First(scope,
				orderByComparator);

		if (configuration != null) {
			return configuration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scope=");
		msg.append(scope);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConfigurationException(msg.toString());
	}

	/**
	 * Returns the first configuration in the ordered set where scope = &#63;.
	 *
	 * @param scope the scope
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration, or <code>null</code> if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByoptionsFinder_First(String scope,
		OrderByComparator orderByComparator) throws SystemException {
		List<Configuration> list = findByoptionsFinder(scope, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last configuration in the ordered set where scope = &#63;.
	 *
	 * @param scope the scope
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByoptionsFinder_Last(String scope,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = fetchByoptionsFinder_Last(scope,
				orderByComparator);

		if (configuration != null) {
			return configuration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scope=");
		msg.append(scope);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConfigurationException(msg.toString());
	}

	/**
	 * Returns the last configuration in the ordered set where scope = &#63;.
	 *
	 * @param scope the scope
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration, or <code>null</code> if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByoptionsFinder_Last(String scope,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByoptionsFinder(scope);

		if (count == 0) {
			return null;
		}

		List<Configuration> list = findByoptionsFinder(scope, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the configurations before and after the current configuration in the ordered set where scope = &#63;.
	 *
	 * @param configurationId the primary key of the current configuration
	 * @param scope the scope
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration[] findByoptionsFinder_PrevAndNext(
		long configurationId, String scope, OrderByComparator orderByComparator)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = findByPrimaryKey(configurationId);

		Session session = null;

		try {
			session = openSession();

			Configuration[] array = new ConfigurationImpl[3];

			array[0] = getByoptionsFinder_PrevAndNext(session, configuration,
					scope, orderByComparator, true);

			array[1] = configuration;

			array[2] = getByoptionsFinder_PrevAndNext(session, configuration,
					scope, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Configuration getByoptionsFinder_PrevAndNext(Session session,
		Configuration configuration, String scope,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONFIGURATION_WHERE);

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
			query.append(ConfigurationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(configuration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Configuration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the configurations where scope = &#63; from the database.
	 *
	 * @param scope the scope
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByoptionsFinder(String scope) throws SystemException {
		for (Configuration configuration : findByoptionsFinder(scope,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(configuration);
		}
	}

	/**
	 * Returns the number of configurations where scope = &#63;.
	 *
	 * @param scope the scope
	 * @return the number of matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByoptionsFinder(String scope) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPTIONSFINDER;

		Object[] finderArgs = new Object[] { scope };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONFIGURATION_WHERE);

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

	private static final String _FINDER_COLUMN_OPTIONSFINDER_SCOPE_1 = "configuration.scope IS NULL";
	private static final String _FINDER_COLUMN_OPTIONSFINDER_SCOPE_2 = "configuration.scope = ?";
	private static final String _FINDER_COLUMN_OPTIONSFINDER_SCOPE_3 = "(configuration.scope IS NULL OR configuration.scope = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIONSFINDERFORKEY =
		new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOptionsFinderForKey",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERFORKEY =
		new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOptionsFinderForKey",
			new String[] { String.class.getName() },
			ConfigurationModelImpl.OPTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPTIONSFINDERFORKEY = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOptionsFinderForKey",
			new String[] { String.class.getName() });

	/**
	 * Returns all the configurations where optionkey = &#63;.
	 *
	 * @param optionkey the optionkey
	 * @return the matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findByOptionsFinderForKey(String optionkey)
		throws SystemException {
		return findByOptionsFinderForKey(optionkey, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configurations where optionkey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param optionkey the optionkey
	 * @param start the lower bound of the range of configurations
	 * @param end the upper bound of the range of configurations (not inclusive)
	 * @return the range of matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findByOptionsFinderForKey(String optionkey,
		int start, int end) throws SystemException {
		return findByOptionsFinderForKey(optionkey, start, end, null);
	}

	/**
	 * Returns an ordered range of all the configurations where optionkey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param optionkey the optionkey
	 * @param start the lower bound of the range of configurations
	 * @param end the upper bound of the range of configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findByOptionsFinderForKey(String optionkey,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERFORKEY;
			finderArgs = new Object[] { optionkey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIONSFINDERFORKEY;
			finderArgs = new Object[] { optionkey, start, end, orderByComparator };
		}

		List<Configuration> list = (List<Configuration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Configuration configuration : list) {
				if (!Validator.equals(optionkey, configuration.getOptionkey())) {
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

			query.append(_SQL_SELECT_CONFIGURATION_WHERE);

			boolean bindOptionkey = false;

			if (optionkey == null) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERFORKEY_OPTIONKEY_1);
			}
			else if (optionkey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERFORKEY_OPTIONKEY_3);
			}
			else {
				bindOptionkey = true;

				query.append(_FINDER_COLUMN_OPTIONSFINDERFORKEY_OPTIONKEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOptionkey) {
					qPos.add(optionkey);
				}

				if (!pagination) {
					list = (List<Configuration>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Configuration>(list);
				}
				else {
					list = (List<Configuration>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first configuration in the ordered set where optionkey = &#63;.
	 *
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByOptionsFinderForKey_First(String optionkey,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = fetchByOptionsFinderForKey_First(optionkey,
				orderByComparator);

		if (configuration != null) {
			return configuration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("optionkey=");
		msg.append(optionkey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConfigurationException(msg.toString());
	}

	/**
	 * Returns the first configuration in the ordered set where optionkey = &#63;.
	 *
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration, or <code>null</code> if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByOptionsFinderForKey_First(String optionkey,
		OrderByComparator orderByComparator) throws SystemException {
		List<Configuration> list = findByOptionsFinderForKey(optionkey, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last configuration in the ordered set where optionkey = &#63;.
	 *
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByOptionsFinderForKey_Last(String optionkey,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = fetchByOptionsFinderForKey_Last(optionkey,
				orderByComparator);

		if (configuration != null) {
			return configuration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("optionkey=");
		msg.append(optionkey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConfigurationException(msg.toString());
	}

	/**
	 * Returns the last configuration in the ordered set where optionkey = &#63;.
	 *
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration, or <code>null</code> if a matching configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByOptionsFinderForKey_Last(String optionkey,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOptionsFinderForKey(optionkey);

		if (count == 0) {
			return null;
		}

		List<Configuration> list = findByOptionsFinderForKey(optionkey,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the configurations before and after the current configuration in the ordered set where optionkey = &#63;.
	 *
	 * @param configurationId the primary key of the current configuration
	 * @param optionkey the optionkey
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration[] findByOptionsFinderForKey_PrevAndNext(
		long configurationId, String optionkey,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = findByPrimaryKey(configurationId);

		Session session = null;

		try {
			session = openSession();

			Configuration[] array = new ConfigurationImpl[3];

			array[0] = getByOptionsFinderForKey_PrevAndNext(session,
					configuration, optionkey, orderByComparator, true);

			array[1] = configuration;

			array[2] = getByOptionsFinderForKey_PrevAndNext(session,
					configuration, optionkey, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Configuration getByOptionsFinderForKey_PrevAndNext(
		Session session, Configuration configuration, String optionkey,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONFIGURATION_WHERE);

		boolean bindOptionkey = false;

		if (optionkey == null) {
			query.append(_FINDER_COLUMN_OPTIONSFINDERFORKEY_OPTIONKEY_1);
		}
		else if (optionkey.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OPTIONSFINDERFORKEY_OPTIONKEY_3);
		}
		else {
			bindOptionkey = true;

			query.append(_FINDER_COLUMN_OPTIONSFINDERFORKEY_OPTIONKEY_2);
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
			query.append(ConfigurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOptionkey) {
			qPos.add(optionkey);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(configuration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Configuration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the configurations where optionkey = &#63; from the database.
	 *
	 * @param optionkey the optionkey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOptionsFinderForKey(String optionkey)
		throws SystemException {
		for (Configuration configuration : findByOptionsFinderForKey(
				optionkey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(configuration);
		}
	}

	/**
	 * Returns the number of configurations where optionkey = &#63;.
	 *
	 * @param optionkey the optionkey
	 * @return the number of matching configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOptionsFinderForKey(String optionkey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPTIONSFINDERFORKEY;

		Object[] finderArgs = new Object[] { optionkey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONFIGURATION_WHERE);

			boolean bindOptionkey = false;

			if (optionkey == null) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERFORKEY_OPTIONKEY_1);
			}
			else if (optionkey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPTIONSFINDERFORKEY_OPTIONKEY_3);
			}
			else {
				bindOptionkey = true;

				query.append(_FINDER_COLUMN_OPTIONSFINDERFORKEY_OPTIONKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_OPTIONSFINDERFORKEY_OPTIONKEY_1 = "configuration.optionkey IS NULL";
	private static final String _FINDER_COLUMN_OPTIONSFINDERFORKEY_OPTIONKEY_2 = "configuration.optionkey = ?";
	private static final String _FINDER_COLUMN_OPTIONSFINDERFORKEY_OPTIONKEY_3 = "(configuration.optionkey IS NULL OR configuration.optionkey = '')";

	public ConfigurationPersistenceImpl() {
		setModelClass(Configuration.class);
	}

	/**
	 * Caches the configuration in the entity cache if it is enabled.
	 *
	 * @param configuration the configuration
	 */
	@Override
	public void cacheResult(Configuration configuration) {
		EntityCacheUtil.putResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationImpl.class, configuration.getPrimaryKey(),
			configuration);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONFINDER,
			new Object[] { configuration.getScope(), configuration.getOptionkey() },
			configuration);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONSFINDERVALUE,
			new Object[] {
				configuration.getScope(), configuration.getOptionvalue()
			}, configuration);

		configuration.resetOriginalValues();
	}

	/**
	 * Caches the configurations in the entity cache if it is enabled.
	 *
	 * @param configurations the configurations
	 */
	@Override
	public void cacheResult(List<Configuration> configurations) {
		for (Configuration configuration : configurations) {
			if (EntityCacheUtil.getResult(
						ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						ConfigurationImpl.class, configuration.getPrimaryKey()) == null) {
				cacheResult(configuration);
			}
			else {
				configuration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all configurations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConfigurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConfigurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the configuration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Configuration configuration) {
		EntityCacheUtil.removeResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationImpl.class, configuration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(configuration);
	}

	@Override
	public void clearCache(List<Configuration> configurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Configuration configuration : configurations) {
			EntityCacheUtil.removeResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				ConfigurationImpl.class, configuration.getPrimaryKey());

			clearUniqueFindersCache(configuration);
		}
	}

	protected void cacheUniqueFindersCache(Configuration configuration) {
		if (configuration.isNew()) {
			Object[] args = new Object[] {
					configuration.getScope(), configuration.getOptionkey()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OPTIONFINDER, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONFINDER, args,
				configuration);

			args = new Object[] {
					configuration.getScope(), configuration.getOptionvalue()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OPTIONSFINDERVALUE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONSFINDERVALUE,
				args, configuration);
		}
		else {
			ConfigurationModelImpl configurationModelImpl = (ConfigurationModelImpl)configuration;

			if ((configurationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_OPTIONFINDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						configuration.getScope(), configuration.getOptionkey()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OPTIONFINDER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONFINDER,
					args, configuration);
			}

			if ((configurationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_OPTIONSFINDERVALUE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						configuration.getScope(), configuration.getOptionvalue()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OPTIONSFINDERVALUE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPTIONSFINDERVALUE,
					args, configuration);
			}
		}
	}

	protected void clearUniqueFindersCache(Configuration configuration) {
		ConfigurationModelImpl configurationModelImpl = (ConfigurationModelImpl)configuration;

		Object[] args = new Object[] {
				configuration.getScope(), configuration.getOptionkey()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONFINDER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OPTIONFINDER, args);

		if ((configurationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_OPTIONFINDER.getColumnBitmask()) != 0) {
			args = new Object[] {
					configurationModelImpl.getOriginalScope(),
					configurationModelImpl.getOriginalOptionkey()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONFINDER, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OPTIONFINDER, args);
		}

		args = new Object[] {
				configuration.getScope(), configuration.getOptionvalue()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFINDERVALUE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OPTIONSFINDERVALUE,
			args);

		if ((configurationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_OPTIONSFINDERVALUE.getColumnBitmask()) != 0) {
			args = new Object[] {
					configurationModelImpl.getOriginalScope(),
					configurationModelImpl.getOriginalOptionvalue()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFINDERVALUE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OPTIONSFINDERVALUE,
				args);
		}
	}

	/**
	 * Creates a new configuration with the primary key. Does not add the configuration to the database.
	 *
	 * @param configurationId the primary key for the new configuration
	 * @return the new configuration
	 */
	@Override
	public Configuration create(long configurationId) {
		Configuration configuration = new ConfigurationImpl();

		configuration.setNew(true);
		configuration.setPrimaryKey(configurationId);

		return configuration;
	}

	/**
	 * Removes the configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configurationId the primary key of the configuration
	 * @return the configuration that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration remove(long configurationId)
		throws NoSuchConfigurationException, SystemException {
		return remove((Serializable)configurationId);
	}

	/**
	 * Removes the configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the configuration
	 * @return the configuration that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration remove(Serializable primaryKey)
		throws NoSuchConfigurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Configuration configuration = (Configuration)session.get(ConfigurationImpl.class,
					primaryKey);

			if (configuration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(configuration);
		}
		catch (NoSuchConfigurationException nsee) {
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
	protected Configuration removeImpl(Configuration configuration)
		throws SystemException {
		configuration = toUnwrappedModel(configuration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(configuration)) {
				configuration = (Configuration)session.get(ConfigurationImpl.class,
						configuration.getPrimaryKeyObj());
			}

			if (configuration != null) {
				session.delete(configuration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (configuration != null) {
			clearCache(configuration);
		}

		return configuration;
	}

	@Override
	public Configuration updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.Configuration configuration)
		throws SystemException {
		configuration = toUnwrappedModel(configuration);

		boolean isNew = configuration.isNew();

		ConfigurationModelImpl configurationModelImpl = (ConfigurationModelImpl)configuration;

		Session session = null;

		try {
			session = openSession();

			if (configuration.isNew()) {
				session.save(configuration);

				configuration.setNew(false);
			}
			else {
				session.merge(configuration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ConfigurationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((configurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						configurationModelImpl.getOriginalScope(),
						configurationModelImpl.getOriginalOptionkey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFINDERKEY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERKEY,
					args);

				args = new Object[] {
						configurationModelImpl.getScope(),
						configurationModelImpl.getOptionkey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFINDERKEY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERKEY,
					args);
			}

			if ((configurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						configurationModelImpl.getOriginalScope()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFINDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDER,
					args);

				args = new Object[] { configurationModelImpl.getScope() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFINDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDER,
					args);
			}

			if ((configurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERFORKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						configurationModelImpl.getOriginalOptionkey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFINDERFORKEY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERFORKEY,
					args);

				args = new Object[] { configurationModelImpl.getOptionkey() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFINDERFORKEY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFINDERFORKEY,
					args);
			}
		}

		EntityCacheUtil.putResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationImpl.class, configuration.getPrimaryKey(),
			configuration);

		clearUniqueFindersCache(configuration);
		cacheUniqueFindersCache(configuration);

		return configuration;
	}

	protected Configuration toUnwrappedModel(Configuration configuration) {
		if (configuration instanceof ConfigurationImpl) {
			return configuration;
		}

		ConfigurationImpl configurationImpl = new ConfigurationImpl();

		configurationImpl.setNew(configuration.isNew());
		configurationImpl.setPrimaryKey(configuration.getPrimaryKey());

		configurationImpl.setConfigurationId(configuration.getConfigurationId());
		configurationImpl.setScope(configuration.getScope());
		configurationImpl.setOptionkey(configuration.getOptionkey());
		configurationImpl.setOptionvalue(configuration.getOptionvalue());

		return configurationImpl;
	}

	/**
	 * Returns the configuration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the configuration
	 * @return the configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = fetchByPrimaryKey(primaryKey);

		if (configuration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return configuration;
	}

	/**
	 * Returns the configuration with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException} if it could not be found.
	 *
	 * @param configurationId the primary key of the configuration
	 * @return the configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByPrimaryKey(long configurationId)
		throws NoSuchConfigurationException, SystemException {
		return findByPrimaryKey((Serializable)configurationId);
	}

	/**
	 * Returns the configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the configuration
	 * @return the configuration, or <code>null</code> if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Configuration configuration = (Configuration)EntityCacheUtil.getResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				ConfigurationImpl.class, primaryKey);

		if (configuration == _nullConfiguration) {
			return null;
		}

		if (configuration == null) {
			Session session = null;

			try {
				session = openSession();

				configuration = (Configuration)session.get(ConfigurationImpl.class,
						primaryKey);

				if (configuration != null) {
					cacheResult(configuration);
				}
				else {
					EntityCacheUtil.putResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						ConfigurationImpl.class, primaryKey, _nullConfiguration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
					ConfigurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return configuration;
	}

	/**
	 * Returns the configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configurationId the primary key of the configuration
	 * @return the configuration, or <code>null</code> if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByPrimaryKey(long configurationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)configurationId);
	}

	/**
	 * Returns all the configurations.
	 *
	 * @return the configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of configurations
	 * @param end the upper bound of the range of configurations (not inclusive)
	 * @return the range of configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of configurations
	 * @param end the upper bound of the range of configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findAll(int start, int end,
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

		List<Configuration> list = (List<Configuration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONFIGURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONFIGURATION;

				if (pagination) {
					sql = sql.concat(ConfigurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Configuration>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Configuration>(list);
				}
				else {
					list = (List<Configuration>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the configurations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Configuration configuration : findAll()) {
			remove(configuration);
		}
	}

	/**
	 * Returns the number of configurations.
	 *
	 * @return the number of configurations
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

				Query q = session.createQuery(_SQL_COUNT_CONFIGURATION);

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
	 * Initializes the configuration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.hmmc.liferay.portlet.puch.model.Configuration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Configuration>> listenersList = new ArrayList<ModelListener<Configuration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Configuration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ConfigurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONFIGURATION = "SELECT configuration FROM Configuration configuration";
	private static final String _SQL_SELECT_CONFIGURATION_WHERE = "SELECT configuration FROM Configuration configuration WHERE ";
	private static final String _SQL_COUNT_CONFIGURATION = "SELECT COUNT(configuration) FROM Configuration configuration";
	private static final String _SQL_COUNT_CONFIGURATION_WHERE = "SELECT COUNT(configuration) FROM Configuration configuration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "configuration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Configuration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Configuration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConfigurationPersistenceImpl.class);
	private static Configuration _nullConfiguration = new ConfigurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Configuration> toCacheModel() {
				return _nullConfigurationCacheModel;
			}
		};

	private static CacheModel<Configuration> _nullConfigurationCacheModel = new CacheModel<Configuration>() {
			@Override
			public Configuration toEntityModel() {
				return _nullConfiguration;
			}
		};
}