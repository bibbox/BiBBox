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

package at.graz.meduni.liferay.portlet.bibbox.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigModelImpl;

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
 * The persistence implementation for the importer config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ImporterConfigPersistence
 * @see ImporterConfigUtil
 * @generated
 */
public class ImporterConfigPersistenceImpl extends BasePersistenceImpl<ImporterConfig>
	implements ImporterConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ImporterConfigUtil} to access the importer config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ImporterConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigModelImpl.FINDER_CACHE_ENABLED,
			ImporterConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigModelImpl.FINDER_CACHE_ENABLED,
			ImporterConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_IMPORTERCONFIG = new FinderPath(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigModelImpl.FINDER_CACHE_ENABLED,
			ImporterConfigImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByImporterConfig",
			new String[] { String.class.getName(), String.class.getName() },
			ImporterConfigModelImpl.SCOPE_COLUMN_BITMASK |
			ImporterConfigModelImpl.ELEMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IMPORTERCONFIG = new FinderPath(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByImporterConfig",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the importer config where scope = &#63; and elementId = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException} if it could not be found.
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @return the matching importer config
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a matching importer config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig findByImporterConfig(String scope, String elementId)
		throws NoSuchImporterConfigException, SystemException {
		ImporterConfig importerConfig = fetchByImporterConfig(scope, elementId);

		if (importerConfig == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("scope=");
			msg.append(scope);

			msg.append(", elementId=");
			msg.append(elementId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchImporterConfigException(msg.toString());
		}

		return importerConfig;
	}

	/**
	 * Returns the importer config where scope = &#63; and elementId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @return the matching importer config, or <code>null</code> if a matching importer config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig fetchByImporterConfig(String scope, String elementId)
		throws SystemException {
		return fetchByImporterConfig(scope, elementId, true);
	}

	/**
	 * Returns the importer config where scope = &#63; and elementId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching importer config, or <code>null</code> if a matching importer config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig fetchByImporterConfig(String scope, String elementId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { scope, elementId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_IMPORTERCONFIG,
					finderArgs, this);
		}

		if (result instanceof ImporterConfig) {
			ImporterConfig importerConfig = (ImporterConfig)result;

			if (!Validator.equals(scope, importerConfig.getScope()) ||
					!Validator.equals(elementId, importerConfig.getElementId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_IMPORTERCONFIG_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_2);
			}

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_2);
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

				if (bindElementId) {
					qPos.add(elementId);
				}

				List<ImporterConfig> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMPORTERCONFIG,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ImporterConfigPersistenceImpl.fetchByImporterConfig(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ImporterConfig importerConfig = list.get(0);

					result = importerConfig;

					cacheResult(importerConfig);

					if ((importerConfig.getScope() == null) ||
							!importerConfig.getScope().equals(scope) ||
							(importerConfig.getElementId() == null) ||
							!importerConfig.getElementId().equals(elementId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMPORTERCONFIG,
							finderArgs, importerConfig);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IMPORTERCONFIG,
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
			return (ImporterConfig)result;
		}
	}

	/**
	 * Removes the importer config where scope = &#63; and elementId = &#63; from the database.
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @return the importer config that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig removeByImporterConfig(String scope, String elementId)
		throws NoSuchImporterConfigException, SystemException {
		ImporterConfig importerConfig = findByImporterConfig(scope, elementId);

		return remove(importerConfig);
	}

	/**
	 * Returns the number of importer configs where scope = &#63; and elementId = &#63;.
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @return the number of matching importer configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByImporterConfig(String scope, String elementId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IMPORTERCONFIG;

		Object[] finderArgs = new Object[] { scope, elementId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IMPORTERCONFIG_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_2);
			}

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_2);
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

				if (bindElementId) {
					qPos.add(elementId);
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

	private static final String _FINDER_COLUMN_IMPORTERCONFIG_SCOPE_1 = "importerConfig.scope IS NULL AND ";
	private static final String _FINDER_COLUMN_IMPORTERCONFIG_SCOPE_2 = "importerConfig.scope = ? AND ";
	private static final String _FINDER_COLUMN_IMPORTERCONFIG_SCOPE_3 = "(importerConfig.scope IS NULL OR importerConfig.scope = '') AND ";
	private static final String _FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_1 = "importerConfig.elementId IS NULL";
	private static final String _FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_2 = "importerConfig.elementId = ?";
	private static final String _FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_3 = "(importerConfig.elementId IS NULL OR importerConfig.elementId = '')";

	public ImporterConfigPersistenceImpl() {
		setModelClass(ImporterConfig.class);
	}

	/**
	 * Caches the importer config in the entity cache if it is enabled.
	 *
	 * @param importerConfig the importer config
	 */
	@Override
	public void cacheResult(ImporterConfig importerConfig) {
		EntityCacheUtil.putResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigImpl.class, importerConfig.getPrimaryKey(),
			importerConfig);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMPORTERCONFIG,
			new Object[] {
				importerConfig.getScope(), importerConfig.getElementId()
			}, importerConfig);

		importerConfig.resetOriginalValues();
	}

	/**
	 * Caches the importer configs in the entity cache if it is enabled.
	 *
	 * @param importerConfigs the importer configs
	 */
	@Override
	public void cacheResult(List<ImporterConfig> importerConfigs) {
		for (ImporterConfig importerConfig : importerConfigs) {
			if (EntityCacheUtil.getResult(
						ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
						ImporterConfigImpl.class, importerConfig.getPrimaryKey()) == null) {
				cacheResult(importerConfig);
			}
			else {
				importerConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all importer configs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ImporterConfigImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ImporterConfigImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the importer config.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ImporterConfig importerConfig) {
		EntityCacheUtil.removeResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigImpl.class, importerConfig.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(importerConfig);
	}

	@Override
	public void clearCache(List<ImporterConfig> importerConfigs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ImporterConfig importerConfig : importerConfigs) {
			EntityCacheUtil.removeResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
				ImporterConfigImpl.class, importerConfig.getPrimaryKey());

			clearUniqueFindersCache(importerConfig);
		}
	}

	protected void cacheUniqueFindersCache(ImporterConfig importerConfig) {
		if (importerConfig.isNew()) {
			Object[] args = new Object[] {
					importerConfig.getScope(), importerConfig.getElementId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IMPORTERCONFIG,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMPORTERCONFIG,
				args, importerConfig);
		}
		else {
			ImporterConfigModelImpl importerConfigModelImpl = (ImporterConfigModelImpl)importerConfig;

			if ((importerConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_IMPORTERCONFIG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importerConfig.getScope(), importerConfig.getElementId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IMPORTERCONFIG,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMPORTERCONFIG,
					args, importerConfig);
			}
		}
	}

	protected void clearUniqueFindersCache(ImporterConfig importerConfig) {
		ImporterConfigModelImpl importerConfigModelImpl = (ImporterConfigModelImpl)importerConfig;

		Object[] args = new Object[] {
				importerConfig.getScope(), importerConfig.getElementId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMPORTERCONFIG, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IMPORTERCONFIG, args);

		if ((importerConfigModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_IMPORTERCONFIG.getColumnBitmask()) != 0) {
			args = new Object[] {
					importerConfigModelImpl.getOriginalScope(),
					importerConfigModelImpl.getOriginalElementId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMPORTERCONFIG,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IMPORTERCONFIG,
				args);
		}
	}

	/**
	 * Creates a new importer config with the primary key. Does not add the importer config to the database.
	 *
	 * @param importerconfigId the primary key for the new importer config
	 * @return the new importer config
	 */
	@Override
	public ImporterConfig create(long importerconfigId) {
		ImporterConfig importerConfig = new ImporterConfigImpl();

		importerConfig.setNew(true);
		importerConfig.setPrimaryKey(importerconfigId);

		return importerConfig;
	}

	/**
	 * Removes the importer config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param importerconfigId the primary key of the importer config
	 * @return the importer config that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig remove(long importerconfigId)
		throws NoSuchImporterConfigException, SystemException {
		return remove((Serializable)importerconfigId);
	}

	/**
	 * Removes the importer config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the importer config
	 * @return the importer config that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig remove(Serializable primaryKey)
		throws NoSuchImporterConfigException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ImporterConfig importerConfig = (ImporterConfig)session.get(ImporterConfigImpl.class,
					primaryKey);

			if (importerConfig == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImporterConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(importerConfig);
		}
		catch (NoSuchImporterConfigException nsee) {
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
	protected ImporterConfig removeImpl(ImporterConfig importerConfig)
		throws SystemException {
		importerConfig = toUnwrappedModel(importerConfig);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(importerConfig)) {
				importerConfig = (ImporterConfig)session.get(ImporterConfigImpl.class,
						importerConfig.getPrimaryKeyObj());
			}

			if (importerConfig != null) {
				session.delete(importerConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (importerConfig != null) {
			clearCache(importerConfig);
		}

		return importerConfig;
	}

	@Override
	public ImporterConfig updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig importerConfig)
		throws SystemException {
		importerConfig = toUnwrappedModel(importerConfig);

		boolean isNew = importerConfig.isNew();

		Session session = null;

		try {
			session = openSession();

			if (importerConfig.isNew()) {
				session.save(importerConfig);

				importerConfig.setNew(false);
			}
			else {
				session.merge(importerConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ImporterConfigModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigImpl.class, importerConfig.getPrimaryKey(),
			importerConfig);

		clearUniqueFindersCache(importerConfig);
		cacheUniqueFindersCache(importerConfig);

		return importerConfig;
	}

	protected ImporterConfig toUnwrappedModel(ImporterConfig importerConfig) {
		if (importerConfig instanceof ImporterConfigImpl) {
			return importerConfig;
		}

		ImporterConfigImpl importerConfigImpl = new ImporterConfigImpl();

		importerConfigImpl.setNew(importerConfig.isNew());
		importerConfigImpl.setPrimaryKey(importerConfig.getPrimaryKey());

		importerConfigImpl.setImporterconfigId(importerConfig.getImporterconfigId());
		importerConfigImpl.setScope(importerConfig.getScope());
		importerConfigImpl.setElementId(importerConfig.getElementId());
		importerConfigImpl.setElementvalue(importerConfig.getElementvalue());

		return importerConfigImpl;
	}

	/**
	 * Returns the importer config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the importer config
	 * @return the importer config
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImporterConfigException, SystemException {
		ImporterConfig importerConfig = fetchByPrimaryKey(primaryKey);

		if (importerConfig == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImporterConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return importerConfig;
	}

	/**
	 * Returns the importer config with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException} if it could not be found.
	 *
	 * @param importerconfigId the primary key of the importer config
	 * @return the importer config
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig findByPrimaryKey(long importerconfigId)
		throws NoSuchImporterConfigException, SystemException {
		return findByPrimaryKey((Serializable)importerconfigId);
	}

	/**
	 * Returns the importer config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the importer config
	 * @return the importer config, or <code>null</code> if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ImporterConfig importerConfig = (ImporterConfig)EntityCacheUtil.getResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
				ImporterConfigImpl.class, primaryKey);

		if (importerConfig == _nullImporterConfig) {
			return null;
		}

		if (importerConfig == null) {
			Session session = null;

			try {
				session = openSession();

				importerConfig = (ImporterConfig)session.get(ImporterConfigImpl.class,
						primaryKey);

				if (importerConfig != null) {
					cacheResult(importerConfig);
				}
				else {
					EntityCacheUtil.putResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
						ImporterConfigImpl.class, primaryKey,
						_nullImporterConfig);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
					ImporterConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return importerConfig;
	}

	/**
	 * Returns the importer config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param importerconfigId the primary key of the importer config
	 * @return the importer config, or <code>null</code> if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig fetchByPrimaryKey(long importerconfigId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)importerconfigId);
	}

	/**
	 * Returns all the importer configs.
	 *
	 * @return the importer configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImporterConfig> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the importer configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of importer configs
	 * @param end the upper bound of the range of importer configs (not inclusive)
	 * @return the range of importer configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImporterConfig> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the importer configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of importer configs
	 * @param end the upper bound of the range of importer configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of importer configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImporterConfig> findAll(int start, int end,
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

		List<ImporterConfig> list = (List<ImporterConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IMPORTERCONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMPORTERCONFIG;

				if (pagination) {
					sql = sql.concat(ImporterConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ImporterConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ImporterConfig>(list);
				}
				else {
					list = (List<ImporterConfig>)QueryUtil.list(q,
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
	 * Removes all the importer configs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ImporterConfig importerConfig : findAll()) {
			remove(importerConfig);
		}
	}

	/**
	 * Returns the number of importer configs.
	 *
	 * @return the number of importer configs
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

				Query q = session.createQuery(_SQL_COUNT_IMPORTERCONFIG);

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
	 * Initializes the importer config persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ImporterConfig>> listenersList = new ArrayList<ModelListener<ImporterConfig>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ImporterConfig>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ImporterConfigImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_IMPORTERCONFIG = "SELECT importerConfig FROM ImporterConfig importerConfig";
	private static final String _SQL_SELECT_IMPORTERCONFIG_WHERE = "SELECT importerConfig FROM ImporterConfig importerConfig WHERE ";
	private static final String _SQL_COUNT_IMPORTERCONFIG = "SELECT COUNT(importerConfig) FROM ImporterConfig importerConfig";
	private static final String _SQL_COUNT_IMPORTERCONFIG_WHERE = "SELECT COUNT(importerConfig) FROM ImporterConfig importerConfig WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "importerConfig.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ImporterConfig exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ImporterConfig exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ImporterConfigPersistenceImpl.class);
	private static ImporterConfig _nullImporterConfig = new ImporterConfigImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ImporterConfig> toCacheModel() {
				return _nullImporterConfigCacheModel;
			}
		};

	private static CacheModel<ImporterConfig> _nullImporterConfigCacheModel = new CacheModel<ImporterConfig>() {
			@Override
			public ImporterConfig toEntityModel() {
				return _nullImporterConfig;
			}
		};
}