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

import at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException;
import at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolTypeConfigurationImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolTypeConfigurationModelImpl;

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
 * The persistence implementation for the symbol type configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see SymbolTypeConfigurationPersistence
 * @see SymbolTypeConfigurationUtil
 * @generated
 */
public class SymbolTypeConfigurationPersistenceImpl extends BasePersistenceImpl<SymbolTypeConfiguration>
	implements SymbolTypeConfigurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SymbolTypeConfigurationUtil} to access the symbol type configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SymbolTypeConfigurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolTypeConfigurationModelImpl.FINDER_CACHE_ENABLED,
			SymbolTypeConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolTypeConfigurationModelImpl.FINDER_CACHE_ENABLED,
			SymbolTypeConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolTypeConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_FIELDSYMBOLTYPE = new FinderPath(SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolTypeConfigurationModelImpl.FINDER_CACHE_ENABLED,
			SymbolTypeConfigurationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFieldSymbolType", new String[] { String.class.getName() },
			SymbolTypeConfigurationModelImpl.SYMBOLTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIELDSYMBOLTYPE = new FinderPath(SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolTypeConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFieldSymbolType", new String[] { String.class.getName() });

	/**
	 * Returns the symbol type configuration where symboltype = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException} if it could not be found.
	 *
	 * @param symboltype the symboltype
	 * @return the matching symbol type configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException if a matching symbol type configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolTypeConfiguration findByFieldSymbolType(String symboltype)
		throws NoSuchSymbolTypeConfigurationException, SystemException {
		SymbolTypeConfiguration symbolTypeConfiguration = fetchByFieldSymbolType(symboltype);

		if (symbolTypeConfiguration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("symboltype=");
			msg.append(symboltype);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSymbolTypeConfigurationException(msg.toString());
		}

		return symbolTypeConfiguration;
	}

	/**
	 * Returns the symbol type configuration where symboltype = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param symboltype the symboltype
	 * @return the matching symbol type configuration, or <code>null</code> if a matching symbol type configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolTypeConfiguration fetchByFieldSymbolType(String symboltype)
		throws SystemException {
		return fetchByFieldSymbolType(symboltype, true);
	}

	/**
	 * Returns the symbol type configuration where symboltype = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param symboltype the symboltype
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching symbol type configuration, or <code>null</code> if a matching symbol type configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolTypeConfiguration fetchByFieldSymbolType(String symboltype,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { symboltype };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FIELDSYMBOLTYPE,
					finderArgs, this);
		}

		if (result instanceof SymbolTypeConfiguration) {
			SymbolTypeConfiguration symbolTypeConfiguration = (SymbolTypeConfiguration)result;

			if (!Validator.equals(symboltype,
						symbolTypeConfiguration.getSymboltype())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SYMBOLTYPECONFIGURATION_WHERE);

			boolean bindSymboltype = false;

			if (symboltype == null) {
				query.append(_FINDER_COLUMN_FIELDSYMBOLTYPE_SYMBOLTYPE_1);
			}
			else if (symboltype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIELDSYMBOLTYPE_SYMBOLTYPE_3);
			}
			else {
				bindSymboltype = true;

				query.append(_FINDER_COLUMN_FIELDSYMBOLTYPE_SYMBOLTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSymboltype) {
					qPos.add(symboltype);
				}

				List<SymbolTypeConfiguration> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDSYMBOLTYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SymbolTypeConfigurationPersistenceImpl.fetchByFieldSymbolType(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SymbolTypeConfiguration symbolTypeConfiguration = list.get(0);

					result = symbolTypeConfiguration;

					cacheResult(symbolTypeConfiguration);

					if ((symbolTypeConfiguration.getSymboltype() == null) ||
							!symbolTypeConfiguration.getSymboltype()
														.equals(symboltype)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDSYMBOLTYPE,
							finderArgs, symbolTypeConfiguration);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FIELDSYMBOLTYPE,
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
			return (SymbolTypeConfiguration)result;
		}
	}

	/**
	 * Removes the symbol type configuration where symboltype = &#63; from the database.
	 *
	 * @param symboltype the symboltype
	 * @return the symbol type configuration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolTypeConfiguration removeByFieldSymbolType(String symboltype)
		throws NoSuchSymbolTypeConfigurationException, SystemException {
		SymbolTypeConfiguration symbolTypeConfiguration = findByFieldSymbolType(symboltype);

		return remove(symbolTypeConfiguration);
	}

	/**
	 * Returns the number of symbol type configurations where symboltype = &#63;.
	 *
	 * @param symboltype the symboltype
	 * @return the number of matching symbol type configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFieldSymbolType(String symboltype)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIELDSYMBOLTYPE;

		Object[] finderArgs = new Object[] { symboltype };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SYMBOLTYPECONFIGURATION_WHERE);

			boolean bindSymboltype = false;

			if (symboltype == null) {
				query.append(_FINDER_COLUMN_FIELDSYMBOLTYPE_SYMBOLTYPE_1);
			}
			else if (symboltype.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIELDSYMBOLTYPE_SYMBOLTYPE_3);
			}
			else {
				bindSymboltype = true;

				query.append(_FINDER_COLUMN_FIELDSYMBOLTYPE_SYMBOLTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSymboltype) {
					qPos.add(symboltype);
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

	private static final String _FINDER_COLUMN_FIELDSYMBOLTYPE_SYMBOLTYPE_1 = "symbolTypeConfiguration.symboltype IS NULL";
	private static final String _FINDER_COLUMN_FIELDSYMBOLTYPE_SYMBOLTYPE_2 = "symbolTypeConfiguration.symboltype = ?";
	private static final String _FINDER_COLUMN_FIELDSYMBOLTYPE_SYMBOLTYPE_3 = "(symbolTypeConfiguration.symboltype IS NULL OR symbolTypeConfiguration.symboltype = '')";

	public SymbolTypeConfigurationPersistenceImpl() {
		setModelClass(SymbolTypeConfiguration.class);
	}

	/**
	 * Caches the symbol type configuration in the entity cache if it is enabled.
	 *
	 * @param symbolTypeConfiguration the symbol type configuration
	 */
	@Override
	public void cacheResult(SymbolTypeConfiguration symbolTypeConfiguration) {
		EntityCacheUtil.putResult(SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolTypeConfigurationImpl.class,
			symbolTypeConfiguration.getPrimaryKey(), symbolTypeConfiguration);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDSYMBOLTYPE,
			new Object[] { symbolTypeConfiguration.getSymboltype() },
			symbolTypeConfiguration);

		symbolTypeConfiguration.resetOriginalValues();
	}

	/**
	 * Caches the symbol type configurations in the entity cache if it is enabled.
	 *
	 * @param symbolTypeConfigurations the symbol type configurations
	 */
	@Override
	public void cacheResult(
		List<SymbolTypeConfiguration> symbolTypeConfigurations) {
		for (SymbolTypeConfiguration symbolTypeConfiguration : symbolTypeConfigurations) {
			if (EntityCacheUtil.getResult(
						SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						SymbolTypeConfigurationImpl.class,
						symbolTypeConfiguration.getPrimaryKey()) == null) {
				cacheResult(symbolTypeConfiguration);
			}
			else {
				symbolTypeConfiguration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all symbol type configurations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SymbolTypeConfigurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SymbolTypeConfigurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the symbol type configuration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SymbolTypeConfiguration symbolTypeConfiguration) {
		EntityCacheUtil.removeResult(SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolTypeConfigurationImpl.class,
			symbolTypeConfiguration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(symbolTypeConfiguration);
	}

	@Override
	public void clearCache(
		List<SymbolTypeConfiguration> symbolTypeConfigurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SymbolTypeConfiguration symbolTypeConfiguration : symbolTypeConfigurations) {
			EntityCacheUtil.removeResult(SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				SymbolTypeConfigurationImpl.class,
				symbolTypeConfiguration.getPrimaryKey());

			clearUniqueFindersCache(symbolTypeConfiguration);
		}
	}

	protected void cacheUniqueFindersCache(
		SymbolTypeConfiguration symbolTypeConfiguration) {
		if (symbolTypeConfiguration.isNew()) {
			Object[] args = new Object[] { symbolTypeConfiguration.getSymboltype() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIELDSYMBOLTYPE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDSYMBOLTYPE,
				args, symbolTypeConfiguration);
		}
		else {
			SymbolTypeConfigurationModelImpl symbolTypeConfigurationModelImpl = (SymbolTypeConfigurationModelImpl)symbolTypeConfiguration;

			if ((symbolTypeConfigurationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FIELDSYMBOLTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						symbolTypeConfiguration.getSymboltype()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIELDSYMBOLTYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIELDSYMBOLTYPE,
					args, symbolTypeConfiguration);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SymbolTypeConfiguration symbolTypeConfiguration) {
		SymbolTypeConfigurationModelImpl symbolTypeConfigurationModelImpl = (SymbolTypeConfigurationModelImpl)symbolTypeConfiguration;

		Object[] args = new Object[] { symbolTypeConfiguration.getSymboltype() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELDSYMBOLTYPE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FIELDSYMBOLTYPE, args);

		if ((symbolTypeConfigurationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FIELDSYMBOLTYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					symbolTypeConfigurationModelImpl.getOriginalSymboltype()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELDSYMBOLTYPE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FIELDSYMBOLTYPE,
				args);
		}
	}

	/**
	 * Creates a new symbol type configuration with the primary key. Does not add the symbol type configuration to the database.
	 *
	 * @param symboltypeconfigurationId the primary key for the new symbol type configuration
	 * @return the new symbol type configuration
	 */
	@Override
	public SymbolTypeConfiguration create(long symboltypeconfigurationId) {
		SymbolTypeConfiguration symbolTypeConfiguration = new SymbolTypeConfigurationImpl();

		symbolTypeConfiguration.setNew(true);
		symbolTypeConfiguration.setPrimaryKey(symboltypeconfigurationId);

		return symbolTypeConfiguration;
	}

	/**
	 * Removes the symbol type configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param symboltypeconfigurationId the primary key of the symbol type configuration
	 * @return the symbol type configuration that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException if a symbol type configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolTypeConfiguration remove(long symboltypeconfigurationId)
		throws NoSuchSymbolTypeConfigurationException, SystemException {
		return remove((Serializable)symboltypeconfigurationId);
	}

	/**
	 * Removes the symbol type configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the symbol type configuration
	 * @return the symbol type configuration that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException if a symbol type configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolTypeConfiguration remove(Serializable primaryKey)
		throws NoSuchSymbolTypeConfigurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SymbolTypeConfiguration symbolTypeConfiguration = (SymbolTypeConfiguration)session.get(SymbolTypeConfigurationImpl.class,
					primaryKey);

			if (symbolTypeConfiguration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSymbolTypeConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(symbolTypeConfiguration);
		}
		catch (NoSuchSymbolTypeConfigurationException nsee) {
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
	protected SymbolTypeConfiguration removeImpl(
		SymbolTypeConfiguration symbolTypeConfiguration)
		throws SystemException {
		symbolTypeConfiguration = toUnwrappedModel(symbolTypeConfiguration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(symbolTypeConfiguration)) {
				symbolTypeConfiguration = (SymbolTypeConfiguration)session.get(SymbolTypeConfigurationImpl.class,
						symbolTypeConfiguration.getPrimaryKeyObj());
			}

			if (symbolTypeConfiguration != null) {
				session.delete(symbolTypeConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (symbolTypeConfiguration != null) {
			clearCache(symbolTypeConfiguration);
		}

		return symbolTypeConfiguration;
	}

	@Override
	public SymbolTypeConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration symbolTypeConfiguration)
		throws SystemException {
		symbolTypeConfiguration = toUnwrappedModel(symbolTypeConfiguration);

		boolean isNew = symbolTypeConfiguration.isNew();

		Session session = null;

		try {
			session = openSession();

			if (symbolTypeConfiguration.isNew()) {
				session.save(symbolTypeConfiguration);

				symbolTypeConfiguration.setNew(false);
			}
			else {
				session.merge(symbolTypeConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SymbolTypeConfigurationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SymbolTypeConfigurationImpl.class,
			symbolTypeConfiguration.getPrimaryKey(), symbolTypeConfiguration);

		clearUniqueFindersCache(symbolTypeConfiguration);
		cacheUniqueFindersCache(symbolTypeConfiguration);

		return symbolTypeConfiguration;
	}

	protected SymbolTypeConfiguration toUnwrappedModel(
		SymbolTypeConfiguration symbolTypeConfiguration) {
		if (symbolTypeConfiguration instanceof SymbolTypeConfigurationImpl) {
			return symbolTypeConfiguration;
		}

		SymbolTypeConfigurationImpl symbolTypeConfigurationImpl = new SymbolTypeConfigurationImpl();

		symbolTypeConfigurationImpl.setNew(symbolTypeConfiguration.isNew());
		symbolTypeConfigurationImpl.setPrimaryKey(symbolTypeConfiguration.getPrimaryKey());

		symbolTypeConfigurationImpl.setSymboltypeconfigurationId(symbolTypeConfiguration.getSymboltypeconfigurationId());
		symbolTypeConfigurationImpl.setSymboltype(symbolTypeConfiguration.getSymboltype());
		symbolTypeConfigurationImpl.setTemplate(symbolTypeConfiguration.getTemplate());
		symbolTypeConfigurationImpl.setSymboliconconfiguration(symbolTypeConfiguration.getSymboliconconfiguration());
		symbolTypeConfigurationImpl.setSymboldiscription(symbolTypeConfiguration.getSymboldiscription());

		return symbolTypeConfigurationImpl;
	}

	/**
	 * Returns the symbol type configuration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the symbol type configuration
	 * @return the symbol type configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException if a symbol type configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolTypeConfiguration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSymbolTypeConfigurationException, SystemException {
		SymbolTypeConfiguration symbolTypeConfiguration = fetchByPrimaryKey(primaryKey);

		if (symbolTypeConfiguration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSymbolTypeConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return symbolTypeConfiguration;
	}

	/**
	 * Returns the symbol type configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException} if it could not be found.
	 *
	 * @param symboltypeconfigurationId the primary key of the symbol type configuration
	 * @return the symbol type configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException if a symbol type configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolTypeConfiguration findByPrimaryKey(
		long symboltypeconfigurationId)
		throws NoSuchSymbolTypeConfigurationException, SystemException {
		return findByPrimaryKey((Serializable)symboltypeconfigurationId);
	}

	/**
	 * Returns the symbol type configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the symbol type configuration
	 * @return the symbol type configuration, or <code>null</code> if a symbol type configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolTypeConfiguration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SymbolTypeConfiguration symbolTypeConfiguration = (SymbolTypeConfiguration)EntityCacheUtil.getResult(SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				SymbolTypeConfigurationImpl.class, primaryKey);

		if (symbolTypeConfiguration == _nullSymbolTypeConfiguration) {
			return null;
		}

		if (symbolTypeConfiguration == null) {
			Session session = null;

			try {
				session = openSession();

				symbolTypeConfiguration = (SymbolTypeConfiguration)session.get(SymbolTypeConfigurationImpl.class,
						primaryKey);

				if (symbolTypeConfiguration != null) {
					cacheResult(symbolTypeConfiguration);
				}
				else {
					EntityCacheUtil.putResult(SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						SymbolTypeConfigurationImpl.class, primaryKey,
						_nullSymbolTypeConfiguration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SymbolTypeConfigurationModelImpl.ENTITY_CACHE_ENABLED,
					SymbolTypeConfigurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return symbolTypeConfiguration;
	}

	/**
	 * Returns the symbol type configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param symboltypeconfigurationId the primary key of the symbol type configuration
	 * @return the symbol type configuration, or <code>null</code> if a symbol type configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolTypeConfiguration fetchByPrimaryKey(
		long symboltypeconfigurationId) throws SystemException {
		return fetchByPrimaryKey((Serializable)symboltypeconfigurationId);
	}

	/**
	 * Returns all the symbol type configurations.
	 *
	 * @return the symbol type configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SymbolTypeConfiguration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the symbol type configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolTypeConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of symbol type configurations
	 * @param end the upper bound of the range of symbol type configurations (not inclusive)
	 * @return the range of symbol type configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SymbolTypeConfiguration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the symbol type configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolTypeConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of symbol type configurations
	 * @param end the upper bound of the range of symbol type configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of symbol type configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SymbolTypeConfiguration> findAll(int start, int end,
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

		List<SymbolTypeConfiguration> list = (List<SymbolTypeConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SYMBOLTYPECONFIGURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SYMBOLTYPECONFIGURATION;

				if (pagination) {
					sql = sql.concat(SymbolTypeConfigurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SymbolTypeConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SymbolTypeConfiguration>(list);
				}
				else {
					list = (List<SymbolTypeConfiguration>)QueryUtil.list(q,
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
	 * Removes all the symbol type configurations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SymbolTypeConfiguration symbolTypeConfiguration : findAll()) {
			remove(symbolTypeConfiguration);
		}
	}

	/**
	 * Returns the number of symbol type configurations.
	 *
	 * @return the number of symbol type configurations
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

				Query q = session.createQuery(_SQL_COUNT_SYMBOLTYPECONFIGURATION);

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
	 * Initializes the symbol type configuration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SymbolTypeConfiguration>> listenersList = new ArrayList<ModelListener<SymbolTypeConfiguration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SymbolTypeConfiguration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SymbolTypeConfigurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SYMBOLTYPECONFIGURATION = "SELECT symbolTypeConfiguration FROM SymbolTypeConfiguration symbolTypeConfiguration";
	private static final String _SQL_SELECT_SYMBOLTYPECONFIGURATION_WHERE = "SELECT symbolTypeConfiguration FROM SymbolTypeConfiguration symbolTypeConfiguration WHERE ";
	private static final String _SQL_COUNT_SYMBOLTYPECONFIGURATION = "SELECT COUNT(symbolTypeConfiguration) FROM SymbolTypeConfiguration symbolTypeConfiguration";
	private static final String _SQL_COUNT_SYMBOLTYPECONFIGURATION_WHERE = "SELECT COUNT(symbolTypeConfiguration) FROM SymbolTypeConfiguration symbolTypeConfiguration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "symbolTypeConfiguration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SymbolTypeConfiguration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SymbolTypeConfiguration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SymbolTypeConfigurationPersistenceImpl.class);
	private static SymbolTypeConfiguration _nullSymbolTypeConfiguration = new SymbolTypeConfigurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SymbolTypeConfiguration> toCacheModel() {
				return _nullSymbolTypeConfigurationCacheModel;
			}
		};

	private static CacheModel<SymbolTypeConfiguration> _nullSymbolTypeConfigurationCacheModel =
		new CacheModel<SymbolTypeConfiguration>() {
			@Override
			public SymbolTypeConfiguration toEntityModel() {
				return _nullSymbolTypeConfiguration;
			}
		};
}