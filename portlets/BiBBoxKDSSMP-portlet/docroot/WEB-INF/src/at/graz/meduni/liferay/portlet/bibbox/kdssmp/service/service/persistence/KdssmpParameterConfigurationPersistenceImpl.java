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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterConfigurationException;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterConfigurationImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterConfigurationModelImpl;

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

/**
 * The persistence implementation for the kdssmp parameter configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see KdssmpParameterConfigurationPersistence
 * @see KdssmpParameterConfigurationUtil
 * @generated
 */
public class KdssmpParameterConfigurationPersistenceImpl
	extends BasePersistenceImpl<KdssmpParameterConfiguration>
	implements KdssmpParameterConfigurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KdssmpParameterConfigurationUtil} to access the kdssmp parameter configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KdssmpParameterConfigurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KdssmpParameterConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterConfigurationModelImpl.FINDER_CACHE_ENABLED,
			KdssmpParameterConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KdssmpParameterConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterConfigurationModelImpl.FINDER_CACHE_ENABLED,
			KdssmpParameterConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KdssmpParameterConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterConfigurationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public KdssmpParameterConfigurationPersistenceImpl() {
		setModelClass(KdssmpParameterConfiguration.class);
	}

	/**
	 * Caches the kdssmp parameter configuration in the entity cache if it is enabled.
	 *
	 * @param kdssmpParameterConfiguration the kdssmp parameter configuration
	 */
	@Override
	public void cacheResult(
		KdssmpParameterConfiguration kdssmpParameterConfiguration) {
		EntityCacheUtil.putResult(KdssmpParameterConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterConfigurationImpl.class,
			kdssmpParameterConfiguration.getPrimaryKey(),
			kdssmpParameterConfiguration);

		kdssmpParameterConfiguration.resetOriginalValues();
	}

	/**
	 * Caches the kdssmp parameter configurations in the entity cache if it is enabled.
	 *
	 * @param kdssmpParameterConfigurations the kdssmp parameter configurations
	 */
	@Override
	public void cacheResult(
		List<KdssmpParameterConfiguration> kdssmpParameterConfigurations) {
		for (KdssmpParameterConfiguration kdssmpParameterConfiguration : kdssmpParameterConfigurations) {
			if (EntityCacheUtil.getResult(
						KdssmpParameterConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						KdssmpParameterConfigurationImpl.class,
						kdssmpParameterConfiguration.getPrimaryKey()) == null) {
				cacheResult(kdssmpParameterConfiguration);
			}
			else {
				kdssmpParameterConfiguration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kdssmp parameter configurations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(KdssmpParameterConfigurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(KdssmpParameterConfigurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kdssmp parameter configuration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		KdssmpParameterConfiguration kdssmpParameterConfiguration) {
		EntityCacheUtil.removeResult(KdssmpParameterConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterConfigurationImpl.class,
			kdssmpParameterConfiguration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<KdssmpParameterConfiguration> kdssmpParameterConfigurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KdssmpParameterConfiguration kdssmpParameterConfiguration : kdssmpParameterConfigurations) {
			EntityCacheUtil.removeResult(KdssmpParameterConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				KdssmpParameterConfigurationImpl.class,
				kdssmpParameterConfiguration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new kdssmp parameter configuration with the primary key. Does not add the kdssmp parameter configuration to the database.
	 *
	 * @param parameterconfigurationId the primary key for the new kdssmp parameter configuration
	 * @return the new kdssmp parameter configuration
	 */
	@Override
	public KdssmpParameterConfiguration create(long parameterconfigurationId) {
		KdssmpParameterConfiguration kdssmpParameterConfiguration = new KdssmpParameterConfigurationImpl();

		kdssmpParameterConfiguration.setNew(true);
		kdssmpParameterConfiguration.setPrimaryKey(parameterconfigurationId);

		return kdssmpParameterConfiguration;
	}

	/**
	 * Removes the kdssmp parameter configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parameterconfigurationId the primary key of the kdssmp parameter configuration
	 * @return the kdssmp parameter configuration that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterConfigurationException if a kdssmp parameter configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterConfiguration remove(long parameterconfigurationId)
		throws NoSuchKdssmpParameterConfigurationException, SystemException {
		return remove((Serializable)parameterconfigurationId);
	}

	/**
	 * Removes the kdssmp parameter configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kdssmp parameter configuration
	 * @return the kdssmp parameter configuration that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterConfigurationException if a kdssmp parameter configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterConfiguration remove(Serializable primaryKey)
		throws NoSuchKdssmpParameterConfigurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KdssmpParameterConfiguration kdssmpParameterConfiguration = (KdssmpParameterConfiguration)session.get(KdssmpParameterConfigurationImpl.class,
					primaryKey);

			if (kdssmpParameterConfiguration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKdssmpParameterConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(kdssmpParameterConfiguration);
		}
		catch (NoSuchKdssmpParameterConfigurationException nsee) {
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
	protected KdssmpParameterConfiguration removeImpl(
		KdssmpParameterConfiguration kdssmpParameterConfiguration)
		throws SystemException {
		kdssmpParameterConfiguration = toUnwrappedModel(kdssmpParameterConfiguration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kdssmpParameterConfiguration)) {
				kdssmpParameterConfiguration = (KdssmpParameterConfiguration)session.get(KdssmpParameterConfigurationImpl.class,
						kdssmpParameterConfiguration.getPrimaryKeyObj());
			}

			if (kdssmpParameterConfiguration != null) {
				session.delete(kdssmpParameterConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kdssmpParameterConfiguration != null) {
			clearCache(kdssmpParameterConfiguration);
		}

		return kdssmpParameterConfiguration;
	}

	@Override
	public KdssmpParameterConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration kdssmpParameterConfiguration)
		throws SystemException {
		kdssmpParameterConfiguration = toUnwrappedModel(kdssmpParameterConfiguration);

		boolean isNew = kdssmpParameterConfiguration.isNew();

		Session session = null;

		try {
			session = openSession();

			if (kdssmpParameterConfiguration.isNew()) {
				session.save(kdssmpParameterConfiguration);

				kdssmpParameterConfiguration.setNew(false);
			}
			else {
				session.merge(kdssmpParameterConfiguration);
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

		EntityCacheUtil.putResult(KdssmpParameterConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpParameterConfigurationImpl.class,
			kdssmpParameterConfiguration.getPrimaryKey(),
			kdssmpParameterConfiguration);

		return kdssmpParameterConfiguration;
	}

	protected KdssmpParameterConfiguration toUnwrappedModel(
		KdssmpParameterConfiguration kdssmpParameterConfiguration) {
		if (kdssmpParameterConfiguration instanceof KdssmpParameterConfigurationImpl) {
			return kdssmpParameterConfiguration;
		}

		KdssmpParameterConfigurationImpl kdssmpParameterConfigurationImpl = new KdssmpParameterConfigurationImpl();

		kdssmpParameterConfigurationImpl.setNew(kdssmpParameterConfiguration.isNew());
		kdssmpParameterConfigurationImpl.setPrimaryKey(kdssmpParameterConfiguration.getPrimaryKey());

		kdssmpParameterConfigurationImpl.setParameterconfigurationId(kdssmpParameterConfiguration.getParameterconfigurationId());
		kdssmpParameterConfigurationImpl.setDisplayname(kdssmpParameterConfiguration.getDisplayname());
		kdssmpParameterConfigurationImpl.setDatatype(kdssmpParameterConfiguration.getDatatype());
		kdssmpParameterConfigurationImpl.setValuerange(kdssmpParameterConfiguration.getValuerange());
		kdssmpParameterConfigurationImpl.setDisplayoptions(kdssmpParameterConfiguration.getDisplayoptions());
		kdssmpParameterConfigurationImpl.setVisible(kdssmpParameterConfiguration.getVisible());
		kdssmpParameterConfigurationImpl.setComputed(kdssmpParameterConfiguration.getComputed());
		kdssmpParameterConfigurationImpl.setConfirmationscript(kdssmpParameterConfiguration.getConfirmationscript());

		return kdssmpParameterConfigurationImpl;
	}

	/**
	 * Returns the kdssmp parameter configuration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the kdssmp parameter configuration
	 * @return the kdssmp parameter configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterConfigurationException if a kdssmp parameter configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterConfiguration findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchKdssmpParameterConfigurationException, SystemException {
		KdssmpParameterConfiguration kdssmpParameterConfiguration = fetchByPrimaryKey(primaryKey);

		if (kdssmpParameterConfiguration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKdssmpParameterConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return kdssmpParameterConfiguration;
	}

	/**
	 * Returns the kdssmp parameter configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterConfigurationException} if it could not be found.
	 *
	 * @param parameterconfigurationId the primary key of the kdssmp parameter configuration
	 * @return the kdssmp parameter configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterConfigurationException if a kdssmp parameter configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterConfiguration findByPrimaryKey(
		long parameterconfigurationId)
		throws NoSuchKdssmpParameterConfigurationException, SystemException {
		return findByPrimaryKey((Serializable)parameterconfigurationId);
	}

	/**
	 * Returns the kdssmp parameter configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kdssmp parameter configuration
	 * @return the kdssmp parameter configuration, or <code>null</code> if a kdssmp parameter configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterConfiguration fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		KdssmpParameterConfiguration kdssmpParameterConfiguration = (KdssmpParameterConfiguration)EntityCacheUtil.getResult(KdssmpParameterConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				KdssmpParameterConfigurationImpl.class, primaryKey);

		if (kdssmpParameterConfiguration == _nullKdssmpParameterConfiguration) {
			return null;
		}

		if (kdssmpParameterConfiguration == null) {
			Session session = null;

			try {
				session = openSession();

				kdssmpParameterConfiguration = (KdssmpParameterConfiguration)session.get(KdssmpParameterConfigurationImpl.class,
						primaryKey);

				if (kdssmpParameterConfiguration != null) {
					cacheResult(kdssmpParameterConfiguration);
				}
				else {
					EntityCacheUtil.putResult(KdssmpParameterConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						KdssmpParameterConfigurationImpl.class, primaryKey,
						_nullKdssmpParameterConfiguration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(KdssmpParameterConfigurationModelImpl.ENTITY_CACHE_ENABLED,
					KdssmpParameterConfigurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return kdssmpParameterConfiguration;
	}

	/**
	 * Returns the kdssmp parameter configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parameterconfigurationId the primary key of the kdssmp parameter configuration
	 * @return the kdssmp parameter configuration, or <code>null</code> if a kdssmp parameter configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpParameterConfiguration fetchByPrimaryKey(
		long parameterconfigurationId) throws SystemException {
		return fetchByPrimaryKey((Serializable)parameterconfigurationId);
	}

	/**
	 * Returns all the kdssmp parameter configurations.
	 *
	 * @return the kdssmp parameter configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpParameterConfiguration> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kdssmp parameter configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kdssmp parameter configurations
	 * @param end the upper bound of the range of kdssmp parameter configurations (not inclusive)
	 * @return the range of kdssmp parameter configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpParameterConfiguration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the kdssmp parameter configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kdssmp parameter configurations
	 * @param end the upper bound of the range of kdssmp parameter configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kdssmp parameter configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpParameterConfiguration> findAll(int start, int end,
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

		List<KdssmpParameterConfiguration> list = (List<KdssmpParameterConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KDSSMPPARAMETERCONFIGURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KDSSMPPARAMETERCONFIGURATION;

				if (pagination) {
					sql = sql.concat(KdssmpParameterConfigurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<KdssmpParameterConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<KdssmpParameterConfiguration>(list);
				}
				else {
					list = (List<KdssmpParameterConfiguration>)QueryUtil.list(q,
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
	 * Removes all the kdssmp parameter configurations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (KdssmpParameterConfiguration kdssmpParameterConfiguration : findAll()) {
			remove(kdssmpParameterConfiguration);
		}
	}

	/**
	 * Returns the number of kdssmp parameter configurations.
	 *
	 * @return the number of kdssmp parameter configurations
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

				Query q = session.createQuery(_SQL_COUNT_KDSSMPPARAMETERCONFIGURATION);

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
	 * Initializes the kdssmp parameter configuration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<KdssmpParameterConfiguration>> listenersList = new ArrayList<ModelListener<KdssmpParameterConfiguration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<KdssmpParameterConfiguration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(KdssmpParameterConfigurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_KDSSMPPARAMETERCONFIGURATION = "SELECT kdssmpParameterConfiguration FROM KdssmpParameterConfiguration kdssmpParameterConfiguration";
	private static final String _SQL_COUNT_KDSSMPPARAMETERCONFIGURATION = "SELECT COUNT(kdssmpParameterConfiguration) FROM KdssmpParameterConfiguration kdssmpParameterConfiguration";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kdssmpParameterConfiguration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KdssmpParameterConfiguration exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(KdssmpParameterConfigurationPersistenceImpl.class);
	private static KdssmpParameterConfiguration _nullKdssmpParameterConfiguration =
		new KdssmpParameterConfigurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<KdssmpParameterConfiguration> toCacheModel() {
				return _nullKdssmpParameterConfigurationCacheModel;
			}
		};

	private static CacheModel<KdssmpParameterConfiguration> _nullKdssmpParameterConfigurationCacheModel =
		new CacheModel<KdssmpParameterConfiguration>() {
			@Override
			public KdssmpParameterConfiguration toEntityModel() {
				return _nullKdssmpParameterConfiguration;
			}
		};
}