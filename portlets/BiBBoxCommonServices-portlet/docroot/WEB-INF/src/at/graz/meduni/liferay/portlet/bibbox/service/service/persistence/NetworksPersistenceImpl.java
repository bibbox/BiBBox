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

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.Networks;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.NetworksImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.NetworksModelImpl;

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
 * The persistence implementation for the networks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see NetworksPersistence
 * @see NetworksUtil
 * @generated
 */
public class NetworksPersistenceImpl extends BasePersistenceImpl<Networks>
	implements NetworksPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NetworksUtil} to access the networks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NetworksImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NetworksModelImpl.ENTITY_CACHE_ENABLED,
			NetworksModelImpl.FINDER_CACHE_ENABLED, NetworksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NetworksModelImpl.ENTITY_CACHE_ENABLED,
			NetworksModelImpl.FINDER_CACHE_ENABLED, NetworksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NetworksModelImpl.ENTITY_CACHE_ENABLED,
			NetworksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public NetworksPersistenceImpl() {
		setModelClass(Networks.class);
	}

	/**
	 * Caches the networks in the entity cache if it is enabled.
	 *
	 * @param networks the networks
	 */
	@Override
	public void cacheResult(Networks networks) {
		EntityCacheUtil.putResult(NetworksModelImpl.ENTITY_CACHE_ENABLED,
			NetworksImpl.class, networks.getPrimaryKey(), networks);

		networks.resetOriginalValues();
	}

	/**
	 * Caches the networkses in the entity cache if it is enabled.
	 *
	 * @param networkses the networkses
	 */
	@Override
	public void cacheResult(List<Networks> networkses) {
		for (Networks networks : networkses) {
			if (EntityCacheUtil.getResult(
						NetworksModelImpl.ENTITY_CACHE_ENABLED,
						NetworksImpl.class, networks.getPrimaryKey()) == null) {
				cacheResult(networks);
			}
			else {
				networks.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all networkses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NetworksImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NetworksImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the networks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Networks networks) {
		EntityCacheUtil.removeResult(NetworksModelImpl.ENTITY_CACHE_ENABLED,
			NetworksImpl.class, networks.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Networks> networkses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Networks networks : networkses) {
			EntityCacheUtil.removeResult(NetworksModelImpl.ENTITY_CACHE_ENABLED,
				NetworksImpl.class, networks.getPrimaryKey());
		}
	}

	/**
	 * Creates a new networks with the primary key. Does not add the networks to the database.
	 *
	 * @param networkId the primary key for the new networks
	 * @return the new networks
	 */
	@Override
	public Networks create(long networkId) {
		Networks networks = new NetworksImpl();

		networks.setNew(true);
		networks.setPrimaryKey(networkId);

		return networks;
	}

	/**
	 * Removes the networks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param networkId the primary key of the networks
	 * @return the networks that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException if a networks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Networks remove(long networkId)
		throws NoSuchNetworksException, SystemException {
		return remove((Serializable)networkId);
	}

	/**
	 * Removes the networks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the networks
	 * @return the networks that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException if a networks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Networks remove(Serializable primaryKey)
		throws NoSuchNetworksException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Networks networks = (Networks)session.get(NetworksImpl.class,
					primaryKey);

			if (networks == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNetworksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(networks);
		}
		catch (NoSuchNetworksException nsee) {
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
	protected Networks removeImpl(Networks networks) throws SystemException {
		networks = toUnwrappedModel(networks);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(networks)) {
				networks = (Networks)session.get(NetworksImpl.class,
						networks.getPrimaryKeyObj());
			}

			if (networks != null) {
				session.delete(networks);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (networks != null) {
			clearCache(networks);
		}

		return networks;
	}

	@Override
	public Networks updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Networks networks)
		throws SystemException {
		networks = toUnwrappedModel(networks);

		boolean isNew = networks.isNew();

		Session session = null;

		try {
			session = openSession();

			if (networks.isNew()) {
				session.save(networks);

				networks.setNew(false);
			}
			else {
				session.merge(networks);
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

		EntityCacheUtil.putResult(NetworksModelImpl.ENTITY_CACHE_ENABLED,
			NetworksImpl.class, networks.getPrimaryKey(), networks);

		return networks;
	}

	protected Networks toUnwrappedModel(Networks networks) {
		if (networks instanceof NetworksImpl) {
			return networks;
		}

		NetworksImpl networksImpl = new NetworksImpl();

		networksImpl.setNew(networks.isNew());
		networksImpl.setPrimaryKey(networks.getPrimaryKey());

		networksImpl.setNetworkId(networks.getNetworkId());
		networksImpl.setOrganizationnetworkId(networks.getOrganizationnetworkId());
		networksImpl.setOrganizationId(networks.getOrganizationId());
		networksImpl.setRelation(networks.getRelation());
		networksImpl.setYearofestablishment(networks.getYearofestablishment());

		return networksImpl;
	}

	/**
	 * Returns the networks with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the networks
	 * @return the networks
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException if a networks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Networks findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNetworksException, SystemException {
		Networks networks = fetchByPrimaryKey(primaryKey);

		if (networks == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNetworksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return networks;
	}

	/**
	 * Returns the networks with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException} if it could not be found.
	 *
	 * @param networkId the primary key of the networks
	 * @return the networks
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException if a networks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Networks findByPrimaryKey(long networkId)
		throws NoSuchNetworksException, SystemException {
		return findByPrimaryKey((Serializable)networkId);
	}

	/**
	 * Returns the networks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the networks
	 * @return the networks, or <code>null</code> if a networks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Networks fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Networks networks = (Networks)EntityCacheUtil.getResult(NetworksModelImpl.ENTITY_CACHE_ENABLED,
				NetworksImpl.class, primaryKey);

		if (networks == _nullNetworks) {
			return null;
		}

		if (networks == null) {
			Session session = null;

			try {
				session = openSession();

				networks = (Networks)session.get(NetworksImpl.class, primaryKey);

				if (networks != null) {
					cacheResult(networks);
				}
				else {
					EntityCacheUtil.putResult(NetworksModelImpl.ENTITY_CACHE_ENABLED,
						NetworksImpl.class, primaryKey, _nullNetworks);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NetworksModelImpl.ENTITY_CACHE_ENABLED,
					NetworksImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return networks;
	}

	/**
	 * Returns the networks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param networkId the primary key of the networks
	 * @return the networks, or <code>null</code> if a networks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Networks fetchByPrimaryKey(long networkId) throws SystemException {
		return fetchByPrimaryKey((Serializable)networkId);
	}

	/**
	 * Returns all the networkses.
	 *
	 * @return the networkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Networks> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the networkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.NetworksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of networkses
	 * @param end the upper bound of the range of networkses (not inclusive)
	 * @return the range of networkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Networks> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the networkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.NetworksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of networkses
	 * @param end the upper bound of the range of networkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of networkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Networks> findAll(int start, int end,
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

		List<Networks> list = (List<Networks>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NETWORKS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NETWORKS;

				if (pagination) {
					sql = sql.concat(NetworksModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Networks>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Networks>(list);
				}
				else {
					list = (List<Networks>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the networkses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Networks networks : findAll()) {
			remove(networks);
		}
	}

	/**
	 * Returns the number of networkses.
	 *
	 * @return the number of networkses
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

				Query q = session.createQuery(_SQL_COUNT_NETWORKS);

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
	 * Initializes the networks persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.service.model.Networks")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Networks>> listenersList = new ArrayList<ModelListener<Networks>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Networks>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NetworksImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NETWORKS = "SELECT networks FROM Networks networks";
	private static final String _SQL_COUNT_NETWORKS = "SELECT COUNT(networks) FROM Networks networks";
	private static final String _ORDER_BY_ENTITY_ALIAS = "networks.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Networks exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NetworksPersistenceImpl.class);
	private static Networks _nullNetworks = new NetworksImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Networks> toCacheModel() {
				return _nullNetworksCacheModel;
			}
		};

	private static CacheModel<Networks> _nullNetworksCacheModel = new CacheModel<Networks>() {
			@Override
			public Networks toEntityModel() {
				return _nullNetworks;
			}
		};
}