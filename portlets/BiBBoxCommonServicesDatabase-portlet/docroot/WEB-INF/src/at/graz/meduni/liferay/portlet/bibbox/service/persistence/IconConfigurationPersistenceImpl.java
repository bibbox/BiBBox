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

import at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException;
import at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the icon configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see IconConfigurationPersistence
 * @see IconConfigurationUtil
 * @generated
 */
public class IconConfigurationPersistenceImpl extends BasePersistenceImpl<IconConfiguration>
	implements IconConfigurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IconConfigurationUtil} to access the icon configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IconConfigurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED,
			IconConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED,
			IconConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public IconConfigurationPersistenceImpl() {
		setModelClass(IconConfiguration.class);
	}

	/**
	 * Caches the icon configuration in the entity cache if it is enabled.
	 *
	 * @param iconConfiguration the icon configuration
	 */
	@Override
	public void cacheResult(IconConfiguration iconConfiguration) {
		EntityCacheUtil.putResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationImpl.class, iconConfiguration.getPrimaryKey(),
			iconConfiguration);

		iconConfiguration.resetOriginalValues();
	}

	/**
	 * Caches the icon configurations in the entity cache if it is enabled.
	 *
	 * @param iconConfigurations the icon configurations
	 */
	@Override
	public void cacheResult(List<IconConfiguration> iconConfigurations) {
		for (IconConfiguration iconConfiguration : iconConfigurations) {
			if (EntityCacheUtil.getResult(
						IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						IconConfigurationImpl.class,
						iconConfiguration.getPrimaryKey()) == null) {
				cacheResult(iconConfiguration);
			}
			else {
				iconConfiguration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all icon configurations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(IconConfigurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(IconConfigurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the icon configuration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IconConfiguration iconConfiguration) {
		EntityCacheUtil.removeResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationImpl.class, iconConfiguration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<IconConfiguration> iconConfigurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (IconConfiguration iconConfiguration : iconConfigurations) {
			EntityCacheUtil.removeResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				IconConfigurationImpl.class, iconConfiguration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new icon configuration with the primary key. Does not add the icon configuration to the database.
	 *
	 * @param iconconfigurationId the primary key for the new icon configuration
	 * @return the new icon configuration
	 */
	@Override
	public IconConfiguration create(long iconconfigurationId) {
		IconConfiguration iconConfiguration = new IconConfigurationImpl();

		iconConfiguration.setNew(true);
		iconConfiguration.setPrimaryKey(iconconfigurationId);

		return iconConfiguration;
	}

	/**
	 * Removes the icon configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iconconfigurationId the primary key of the icon configuration
	 * @return the icon configuration that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration remove(long iconconfigurationId)
		throws NoSuchIconConfigurationException, SystemException {
		return remove((Serializable)iconconfigurationId);
	}

	/**
	 * Removes the icon configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the icon configuration
	 * @return the icon configuration that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration remove(Serializable primaryKey)
		throws NoSuchIconConfigurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			IconConfiguration iconConfiguration = (IconConfiguration)session.get(IconConfigurationImpl.class,
					primaryKey);

			if (iconConfiguration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIconConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(iconConfiguration);
		}
		catch (NoSuchIconConfigurationException nsee) {
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
	protected IconConfiguration removeImpl(IconConfiguration iconConfiguration)
		throws SystemException {
		iconConfiguration = toUnwrappedModel(iconConfiguration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(iconConfiguration)) {
				iconConfiguration = (IconConfiguration)session.get(IconConfigurationImpl.class,
						iconConfiguration.getPrimaryKeyObj());
			}

			if (iconConfiguration != null) {
				session.delete(iconConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (iconConfiguration != null) {
			clearCache(iconConfiguration);
		}

		return iconConfiguration;
	}

	@Override
	public IconConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration iconConfiguration)
		throws SystemException {
		iconConfiguration = toUnwrappedModel(iconConfiguration);

		boolean isNew = iconConfiguration.isNew();

		Session session = null;

		try {
			session = openSession();

			if (iconConfiguration.isNew()) {
				session.save(iconConfiguration);

				iconConfiguration.setNew(false);
			}
			else {
				session.merge(iconConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationImpl.class, iconConfiguration.getPrimaryKey(),
			iconConfiguration);

		return iconConfiguration;
	}

	protected IconConfiguration toUnwrappedModel(
		IconConfiguration iconConfiguration) {
		if (iconConfiguration instanceof IconConfigurationImpl) {
			return iconConfiguration;
		}

		IconConfigurationImpl iconConfigurationImpl = new IconConfigurationImpl();

		iconConfigurationImpl.setNew(iconConfiguration.isNew());
		iconConfigurationImpl.setPrimaryKey(iconConfiguration.getPrimaryKey());

		iconConfigurationImpl.setIconconfigurationId(iconConfiguration.getIconconfigurationId());
		iconConfigurationImpl.setSymbolconfigurationId(iconConfiguration.getSymbolconfigurationId());
		iconConfigurationImpl.setPosition(iconConfiguration.getPosition());
		iconConfigurationImpl.setKey(iconConfiguration.getKey());
		iconConfigurationImpl.setImage(iconConfiguration.getImage());
		iconConfigurationImpl.setElementcolor(iconConfiguration.getElementcolor());

		return iconConfigurationImpl;
	}

	/**
	 * Returns the icon configuration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the icon configuration
	 * @return the icon configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIconConfigurationException, SystemException {
		IconConfiguration iconConfiguration = fetchByPrimaryKey(primaryKey);

		if (iconConfiguration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIconConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return iconConfiguration;
	}

	/**
	 * Returns the icon configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException} if it could not be found.
	 *
	 * @param iconconfigurationId the primary key of the icon configuration
	 * @return the icon configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration findByPrimaryKey(long iconconfigurationId)
		throws NoSuchIconConfigurationException, SystemException {
		return findByPrimaryKey((Serializable)iconconfigurationId);
	}

	/**
	 * Returns the icon configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the icon configuration
	 * @return the icon configuration, or <code>null</code> if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		IconConfiguration iconConfiguration = (IconConfiguration)EntityCacheUtil.getResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				IconConfigurationImpl.class, primaryKey);

		if (iconConfiguration == _nullIconConfiguration) {
			return null;
		}

		if (iconConfiguration == null) {
			Session session = null;

			try {
				session = openSession();

				iconConfiguration = (IconConfiguration)session.get(IconConfigurationImpl.class,
						primaryKey);

				if (iconConfiguration != null) {
					cacheResult(iconConfiguration);
				}
				else {
					EntityCacheUtil.putResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						IconConfigurationImpl.class, primaryKey,
						_nullIconConfiguration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
					IconConfigurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return iconConfiguration;
	}

	/**
	 * Returns the icon configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iconconfigurationId the primary key of the icon configuration
	 * @return the icon configuration, or <code>null</code> if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration fetchByPrimaryKey(long iconconfigurationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)iconconfigurationId);
	}

	/**
	 * Returns all the icon configurations.
	 *
	 * @return the icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IconConfiguration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the icon configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of icon configurations
	 * @param end the upper bound of the range of icon configurations (not inclusive)
	 * @return the range of icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IconConfiguration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the icon configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of icon configurations
	 * @param end the upper bound of the range of icon configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IconConfiguration> findAll(int start, int end,
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

		List<IconConfiguration> list = (List<IconConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ICONCONFIGURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ICONCONFIGURATION;

				if (pagination) {
					sql = sql.concat(IconConfigurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<IconConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IconConfiguration>(list);
				}
				else {
					list = (List<IconConfiguration>)QueryUtil.list(q,
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
	 * Removes all the icon configurations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (IconConfiguration iconConfiguration : findAll()) {
			remove(iconConfiguration);
		}
	}

	/**
	 * Returns the number of icon configurations.
	 *
	 * @return the number of icon configurations
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

				Query q = session.createQuery(_SQL_COUNT_ICONCONFIGURATION);

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
	 * Initializes the icon configuration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<IconConfiguration>> listenersList = new ArrayList<ModelListener<IconConfiguration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<IconConfiguration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(IconConfigurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ICONCONFIGURATION = "SELECT iconConfiguration FROM IconConfiguration iconConfiguration";
	private static final String _SQL_COUNT_ICONCONFIGURATION = "SELECT COUNT(iconConfiguration) FROM IconConfiguration iconConfiguration";
	private static final String _ORDER_BY_ENTITY_ALIAS = "iconConfiguration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No IconConfiguration exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(IconConfigurationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"key"
			});
	private static IconConfiguration _nullIconConfiguration = new IconConfigurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<IconConfiguration> toCacheModel() {
				return _nullIconConfigurationCacheModel;
			}
		};

	private static CacheModel<IconConfiguration> _nullIconConfigurationCacheModel =
		new CacheModel<IconConfiguration>() {
			@Override
			public IconConfiguration toEntityModel() {
				return _nullIconConfiguration;
			}
		};
}