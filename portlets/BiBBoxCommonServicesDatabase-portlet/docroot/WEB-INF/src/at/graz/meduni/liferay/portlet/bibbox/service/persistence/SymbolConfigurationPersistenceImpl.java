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

package at.graz.meduni.liferay.portlet.bibbox.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException;
import at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolConfigurationImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolConfigurationModelImpl;

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
 * The persistence implementation for the symbol configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see SymbolConfigurationPersistence
 * @see SymbolConfigurationUtil
 * @generated
 */
public class SymbolConfigurationPersistenceImpl extends BasePersistenceImpl<SymbolConfiguration>
	implements SymbolConfigurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SymbolConfigurationUtil} to access the symbol configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SymbolConfigurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolConfigurationModelImpl.FINDER_CACHE_ENABLED,
			SymbolConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolConfigurationModelImpl.FINDER_CACHE_ENABLED,
			SymbolConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_FIELDSYMBOL = new FinderPath(SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolConfigurationModelImpl.FINDER_CACHE_ENABLED,
			SymbolConfigurationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFieldSymbol",
			new String[] { String.class.getName(), String.class.getName() },
			SymbolConfigurationModelImpl.SCOPE_COLUMN_BITMASK |
			SymbolConfigurationModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIELDSYMBOL = new FinderPath(SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFieldSymbol",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the symbol configuration where scope = &#63; and eventtype = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException} if it could not be found.
	 *
	 * @param scope the scope
	 * @param eventtype the eventtype
	 * @return the matching symbol configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException if a matching symbol configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolConfiguration findByFieldSymbol(String scope, String eventtype)
		throws NoSuchSymbolConfigurationException, SystemException {
		SymbolConfiguration symbolConfiguration = fetchByFieldSymbol(scope,
				eventtype);

		if (symbolConfiguration == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("scope=");
			msg.append(scope);

			msg.append(", eventtype=");
			msg.append(eventtype);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSymbolConfigurationException(msg.toString());
		}

		return symbolConfiguration;
	}

	/**
	 * Returns the symbol configuration where scope = &#63; and eventtype = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param scope the scope
	 * @param eventtype the eventtype
	 * @return the matching symbol configuration, or <code>null</code> if a matching symbol configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolConfiguration fetchByFieldSymbol(String scope, String eventtype)
		throws SystemException {
		return fetchByFieldSymbol(scope, eventtype, true);
	}

	/**
	 * Returns the symbol configuration where scope = &#63; and eventtype = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param scope the scope
	 * @param eventtype the eventtype
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching symbol configuration, or <code>null</code> if a matching symbol configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolConfiguration fetchByFieldSymbol(String scope,
		String eventtype, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { scope, eventtype };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FIELDSYMBOL,
					finderArgs, this);
		}

		if (result instanceof SymbolConfiguration) {
			SymbolConfiguration symbolConfiguration = (SymbolConfiguration)result;

			if (!Validator.equals(scope, symbolConfiguration.getScope()) ||
					!Validator.equals(eventtype,
						symbolConfiguration.getEventtype())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SYMBOLCONFIGURATION_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_FIELDSYMBOL_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIELDSYMBOL_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_FIELDSYMBOL_SCOPE_2);
			}

			boolean bindEventtype = false;

			if (eventtype == null) {
				query.append(_FINDER_COLUMN_FIELDSYMBOL_EVENTTYPE_1);
			}
			else if (eventtype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIELDSYMBOL_EVENTTYPE_3);
			}
			else {
				bindEventtype = true;

				query.append(_FINDER_COLUMN_FIELDSYMBOL_EVENTTYPE_2);
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

				if (bindEventtype) {
					qPos.add(eventtype);
				}

				List<SymbolConfiguration> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDSYMBOL,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SymbolConfigurationPersistenceImpl.fetchByFieldSymbol(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SymbolConfiguration symbolConfiguration = list.get(0);

					result = symbolConfiguration;

					cacheResult(symbolConfiguration);

					if ((symbolConfiguration.getScope() == null) ||
							!symbolConfiguration.getScope().equals(scope) ||
							(symbolConfiguration.getEventtype() == null) ||
							!symbolConfiguration.getEventtype().equals(eventtype)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDSYMBOL,
							finderArgs, symbolConfiguration);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FIELDSYMBOL,
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
			return (SymbolConfiguration)result;
		}
	}

	/**
	 * Removes the symbol configuration where scope = &#63; and eventtype = &#63; from the database.
	 *
	 * @param scope the scope
	 * @param eventtype the eventtype
	 * @return the symbol configuration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolConfiguration removeByFieldSymbol(String scope,
		String eventtype)
		throws NoSuchSymbolConfigurationException, SystemException {
		SymbolConfiguration symbolConfiguration = findByFieldSymbol(scope,
				eventtype);

		return remove(symbolConfiguration);
	}

	/**
	 * Returns the number of symbol configurations where scope = &#63; and eventtype = &#63;.
	 *
	 * @param scope the scope
	 * @param eventtype the eventtype
	 * @return the number of matching symbol configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFieldSymbol(String scope, String eventtype)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIELDSYMBOL;

		Object[] finderArgs = new Object[] { scope, eventtype };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SYMBOLCONFIGURATION_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_FIELDSYMBOL_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIELDSYMBOL_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_FIELDSYMBOL_SCOPE_2);
			}

			boolean bindEventtype = false;

			if (eventtype == null) {
				query.append(_FINDER_COLUMN_FIELDSYMBOL_EVENTTYPE_1);
			}
			else if (eventtype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIELDSYMBOL_EVENTTYPE_3);
			}
			else {
				bindEventtype = true;

				query.append(_FINDER_COLUMN_FIELDSYMBOL_EVENTTYPE_2);
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

				if (bindEventtype) {
					qPos.add(eventtype);
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

	private static final String _FINDER_COLUMN_FIELDSYMBOL_SCOPE_1 = "symbolConfiguration.scope IS NULL AND ";
	private static final String _FINDER_COLUMN_FIELDSYMBOL_SCOPE_2 = "symbolConfiguration.scope = ? AND ";
	private static final String _FINDER_COLUMN_FIELDSYMBOL_SCOPE_3 = "(symbolConfiguration.scope IS NULL OR symbolConfiguration.scope = '') AND ";
	private static final String _FINDER_COLUMN_FIELDSYMBOL_EVENTTYPE_1 = "symbolConfiguration.eventtype IS NULL";
	private static final String _FINDER_COLUMN_FIELDSYMBOL_EVENTTYPE_2 = "symbolConfiguration.eventtype = ?";
	private static final String _FINDER_COLUMN_FIELDSYMBOL_EVENTTYPE_3 = "(symbolConfiguration.eventtype IS NULL OR symbolConfiguration.eventtype = '')";

	public SymbolConfigurationPersistenceImpl() {
		setModelClass(SymbolConfiguration.class);
	}

	/**
	 * Caches the symbol configuration in the entity cache if it is enabled.
	 *
	 * @param symbolConfiguration the symbol configuration
	 */
	@Override
	public void cacheResult(SymbolConfiguration symbolConfiguration) {
		EntityCacheUtil.putResult(SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolConfigurationImpl.class, symbolConfiguration.getPrimaryKey(),
			symbolConfiguration);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDSYMBOL,
			new Object[] {
				symbolConfiguration.getScope(),
				symbolConfiguration.getEventtype()
			}, symbolConfiguration);

		symbolConfiguration.resetOriginalValues();
	}

	/**
	 * Caches the symbol configurations in the entity cache if it is enabled.
	 *
	 * @param symbolConfigurations the symbol configurations
	 */
	@Override
	public void cacheResult(List<SymbolConfiguration> symbolConfigurations) {
		for (SymbolConfiguration symbolConfiguration : symbolConfigurations) {
			if (EntityCacheUtil.getResult(
						SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						SymbolConfigurationImpl.class,
						symbolConfiguration.getPrimaryKey()) == null) {
				cacheResult(symbolConfiguration);
			}
			else {
				symbolConfiguration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all symbol configurations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SymbolConfigurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SymbolConfigurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the symbol configuration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SymbolConfiguration symbolConfiguration) {
		EntityCacheUtil.removeResult(SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolConfigurationImpl.class, symbolConfiguration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(symbolConfiguration);
	}

	@Override
	public void clearCache(List<SymbolConfiguration> symbolConfigurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SymbolConfiguration symbolConfiguration : symbolConfigurations) {
			EntityCacheUtil.removeResult(SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				SymbolConfigurationImpl.class,
				symbolConfiguration.getPrimaryKey());

			clearUniqueFindersCache(symbolConfiguration);
		}
	}

	protected void cacheUniqueFindersCache(
		SymbolConfiguration symbolConfiguration) {
		if (symbolConfiguration.isNew()) {
			Object[] args = new Object[] {
					symbolConfiguration.getScope(),
					symbolConfiguration.getEventtype()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIELDSYMBOL, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDSYMBOL, args,
				symbolConfiguration);
		}
		else {
			SymbolConfigurationModelImpl symbolConfigurationModelImpl = (SymbolConfigurationModelImpl)symbolConfiguration;

			if ((symbolConfigurationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FIELDSYMBOL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						symbolConfiguration.getScope(),
						symbolConfiguration.getEventtype()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIELDSYMBOL,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDSYMBOL,
					args, symbolConfiguration);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SymbolConfiguration symbolConfiguration) {
		SymbolConfigurationModelImpl symbolConfigurationModelImpl = (SymbolConfigurationModelImpl)symbolConfiguration;

		Object[] args = new Object[] {
				symbolConfiguration.getScope(),
				symbolConfiguration.getEventtype()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELDSYMBOL, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FIELDSYMBOL, args);

		if ((symbolConfigurationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FIELDSYMBOL.getColumnBitmask()) != 0) {
			args = new Object[] {
					symbolConfigurationModelImpl.getOriginalScope(),
					symbolConfigurationModelImpl.getOriginalEventtype()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELDSYMBOL, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FIELDSYMBOL, args);
		}
	}

	/**
	 * Creates a new symbol configuration with the primary key. Does not add the symbol configuration to the database.
	 *
	 * @param symbolconfigurationId the primary key for the new symbol configuration
	 * @return the new symbol configuration
	 */
	@Override
	public SymbolConfiguration create(long symbolconfigurationId) {
		SymbolConfiguration symbolConfiguration = new SymbolConfigurationImpl();

		symbolConfiguration.setNew(true);
		symbolConfiguration.setPrimaryKey(symbolconfigurationId);

		return symbolConfiguration;
	}

	/**
	 * Removes the symbol configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param symbolconfigurationId the primary key of the symbol configuration
	 * @return the symbol configuration that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException if a symbol configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolConfiguration remove(long symbolconfigurationId)
		throws NoSuchSymbolConfigurationException, SystemException {
		return remove((Serializable)symbolconfigurationId);
	}

	/**
	 * Removes the symbol configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the symbol configuration
	 * @return the symbol configuration that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException if a symbol configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolConfiguration remove(Serializable primaryKey)
		throws NoSuchSymbolConfigurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SymbolConfiguration symbolConfiguration = (SymbolConfiguration)session.get(SymbolConfigurationImpl.class,
					primaryKey);

			if (symbolConfiguration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSymbolConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(symbolConfiguration);
		}
		catch (NoSuchSymbolConfigurationException nsee) {
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
	protected SymbolConfiguration removeImpl(
		SymbolConfiguration symbolConfiguration) throws SystemException {
		symbolConfiguration = toUnwrappedModel(symbolConfiguration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(symbolConfiguration)) {
				symbolConfiguration = (SymbolConfiguration)session.get(SymbolConfigurationImpl.class,
						symbolConfiguration.getPrimaryKeyObj());
			}

			if (symbolConfiguration != null) {
				session.delete(symbolConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (symbolConfiguration != null) {
			clearCache(symbolConfiguration);
		}

		return symbolConfiguration;
	}

	@Override
	public SymbolConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration symbolConfiguration)
		throws SystemException {
		symbolConfiguration = toUnwrappedModel(symbolConfiguration);

		boolean isNew = symbolConfiguration.isNew();

		Session session = null;

		try {
			session = openSession();

			if (symbolConfiguration.isNew()) {
				session.save(symbolConfiguration);

				symbolConfiguration.setNew(false);
			}
			else {
				session.merge(symbolConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SymbolConfigurationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolConfigurationImpl.class, symbolConfiguration.getPrimaryKey(),
			symbolConfiguration);

		clearUniqueFindersCache(symbolConfiguration);
		cacheUniqueFindersCache(symbolConfiguration);

		return symbolConfiguration;
	}

	protected SymbolConfiguration toUnwrappedModel(
		SymbolConfiguration symbolConfiguration) {
		if (symbolConfiguration instanceof SymbolConfigurationImpl) {
			return symbolConfiguration;
		}

		SymbolConfigurationImpl symbolConfigurationImpl = new SymbolConfigurationImpl();

		symbolConfigurationImpl.setNew(symbolConfiguration.isNew());
		symbolConfigurationImpl.setPrimaryKey(symbolConfiguration.getPrimaryKey());

		symbolConfigurationImpl.setSymbolconfigurationId(symbolConfiguration.getSymbolconfigurationId());
		symbolConfigurationImpl.setScope(symbolConfiguration.getScope());
		symbolConfigurationImpl.setEventtype(symbolConfiguration.getEventtype());
		symbolConfigurationImpl.setBasecolor(symbolConfiguration.getBasecolor());
		symbolConfigurationImpl.setSymboltype(symbolConfiguration.getSymboltype());

		return symbolConfigurationImpl;
	}

	/**
	 * Returns the symbol configuration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the symbol configuration
	 * @return the symbol configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException if a symbol configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolConfiguration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSymbolConfigurationException, SystemException {
		SymbolConfiguration symbolConfiguration = fetchByPrimaryKey(primaryKey);

		if (symbolConfiguration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSymbolConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return symbolConfiguration;
	}

	/**
	 * Returns the symbol configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException} if it could not be found.
	 *
	 * @param symbolconfigurationId the primary key of the symbol configuration
	 * @return the symbol configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException if a symbol configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolConfiguration findByPrimaryKey(long symbolconfigurationId)
		throws NoSuchSymbolConfigurationException, SystemException {
		return findByPrimaryKey((Serializable)symbolconfigurationId);
	}

	/**
	 * Returns the symbol configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the symbol configuration
	 * @return the symbol configuration, or <code>null</code> if a symbol configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolConfiguration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SymbolConfiguration symbolConfiguration = (SymbolConfiguration)EntityCacheUtil.getResult(SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				SymbolConfigurationImpl.class, primaryKey);

		if (symbolConfiguration == _nullSymbolConfiguration) {
			return null;
		}

		if (symbolConfiguration == null) {
			Session session = null;

			try {
				session = openSession();

				symbolConfiguration = (SymbolConfiguration)session.get(SymbolConfigurationImpl.class,
						primaryKey);

				if (symbolConfiguration != null) {
					cacheResult(symbolConfiguration);
				}
				else {
					EntityCacheUtil.putResult(SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						SymbolConfigurationImpl.class, primaryKey,
						_nullSymbolConfiguration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SymbolConfigurationModelImpl.ENTITY_CACHE_ENABLED,
					SymbolConfigurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return symbolConfiguration;
	}

	/**
	 * Returns the symbol configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param symbolconfigurationId the primary key of the symbol configuration
	 * @return the symbol configuration, or <code>null</code> if a symbol configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolConfiguration fetchByPrimaryKey(long symbolconfigurationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)symbolconfigurationId);
	}

	/**
	 * Returns all the symbol configurations.
	 *
	 * @return the symbol configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SymbolConfiguration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the symbol configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of symbol configurations
	 * @param end the upper bound of the range of symbol configurations (not inclusive)
	 * @return the range of symbol configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SymbolConfiguration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the symbol configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of symbol configurations
	 * @param end the upper bound of the range of symbol configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of symbol configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SymbolConfiguration> findAll(int start, int end,
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

		List<SymbolConfiguration> list = (List<SymbolConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SYMBOLCONFIGURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SYMBOLCONFIGURATION;

				if (pagination) {
					sql = sql.concat(SymbolConfigurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SymbolConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SymbolConfiguration>(list);
				}
				else {
					list = (List<SymbolConfiguration>)QueryUtil.list(q,
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
	 * Removes all the symbol configurations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SymbolConfiguration symbolConfiguration : findAll()) {
			remove(symbolConfiguration);
		}
	}

	/**
	 * Returns the number of symbol configurations.
	 *
	 * @return the number of symbol configurations
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

				Query q = session.createQuery(_SQL_COUNT_SYMBOLCONFIGURATION);

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
	 * Initializes the symbol configuration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SymbolConfiguration>> listenersList = new ArrayList<ModelListener<SymbolConfiguration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SymbolConfiguration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SymbolConfigurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SYMBOLCONFIGURATION = "SELECT symbolConfiguration FROM SymbolConfiguration symbolConfiguration";
	private static final String _SQL_SELECT_SYMBOLCONFIGURATION_WHERE = "SELECT symbolConfiguration FROM SymbolConfiguration symbolConfiguration WHERE ";
	private static final String _SQL_COUNT_SYMBOLCONFIGURATION = "SELECT COUNT(symbolConfiguration) FROM SymbolConfiguration symbolConfiguration";
	private static final String _SQL_COUNT_SYMBOLCONFIGURATION_WHERE = "SELECT COUNT(symbolConfiguration) FROM SymbolConfiguration symbolConfiguration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "symbolConfiguration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SymbolConfiguration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SymbolConfiguration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SymbolConfigurationPersistenceImpl.class);
	private static SymbolConfiguration _nullSymbolConfiguration = new SymbolConfigurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SymbolConfiguration> toCacheModel() {
				return _nullSymbolConfigurationCacheModel;
			}
		};

	private static CacheModel<SymbolConfiguration> _nullSymbolConfigurationCacheModel =
		new CacheModel<SymbolConfiguration>() {
			@Override
			public SymbolConfiguration toEntityModel() {
				return _nullSymbolConfiguration;
			}
		};
}