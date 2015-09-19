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

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchLogapiException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.LogapiImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.LogapiModelImpl;

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
 * The persistence implementation for the logapi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see LogapiPersistence
 * @see LogapiUtil
 * @generated
 */
public class LogapiPersistenceImpl extends BasePersistenceImpl<Logapi>
	implements LogapiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LogapiUtil} to access the logapi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LogapiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LogapiModelImpl.ENTITY_CACHE_ENABLED,
			LogapiModelImpl.FINDER_CACHE_ENABLED, LogapiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LogapiModelImpl.ENTITY_CACHE_ENABLED,
			LogapiModelImpl.FINDER_CACHE_ENABLED, LogapiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LogapiModelImpl.ENTITY_CACHE_ENABLED,
			LogapiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LogapiPersistenceImpl() {
		setModelClass(Logapi.class);
	}

	/**
	 * Caches the logapi in the entity cache if it is enabled.
	 *
	 * @param logapi the logapi
	 */
	@Override
	public void cacheResult(Logapi logapi) {
		EntityCacheUtil.putResult(LogapiModelImpl.ENTITY_CACHE_ENABLED,
			LogapiImpl.class, logapi.getPrimaryKey(), logapi);

		logapi.resetOriginalValues();
	}

	/**
	 * Caches the logapis in the entity cache if it is enabled.
	 *
	 * @param logapis the logapis
	 */
	@Override
	public void cacheResult(List<Logapi> logapis) {
		for (Logapi logapi : logapis) {
			if (EntityCacheUtil.getResult(
						LogapiModelImpl.ENTITY_CACHE_ENABLED, LogapiImpl.class,
						logapi.getPrimaryKey()) == null) {
				cacheResult(logapi);
			}
			else {
				logapi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all logapis.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LogapiImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LogapiImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the logapi.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Logapi logapi) {
		EntityCacheUtil.removeResult(LogapiModelImpl.ENTITY_CACHE_ENABLED,
			LogapiImpl.class, logapi.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Logapi> logapis) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Logapi logapi : logapis) {
			EntityCacheUtil.removeResult(LogapiModelImpl.ENTITY_CACHE_ENABLED,
				LogapiImpl.class, logapi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new logapi with the primary key. Does not add the logapi to the database.
	 *
	 * @param logapiId the primary key for the new logapi
	 * @return the new logapi
	 */
	@Override
	public Logapi create(long logapiId) {
		Logapi logapi = new LogapiImpl();

		logapi.setNew(true);
		logapi.setPrimaryKey(logapiId);

		return logapi;
	}

	/**
	 * Removes the logapi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logapiId the primary key of the logapi
	 * @return the logapi that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchLogapiException if a logapi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Logapi remove(long logapiId)
		throws NoSuchLogapiException, SystemException {
		return remove((Serializable)logapiId);
	}

	/**
	 * Removes the logapi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the logapi
	 * @return the logapi that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchLogapiException if a logapi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Logapi remove(Serializable primaryKey)
		throws NoSuchLogapiException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Logapi logapi = (Logapi)session.get(LogapiImpl.class, primaryKey);

			if (logapi == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLogapiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(logapi);
		}
		catch (NoSuchLogapiException nsee) {
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
	protected Logapi removeImpl(Logapi logapi) throws SystemException {
		logapi = toUnwrappedModel(logapi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(logapi)) {
				logapi = (Logapi)session.get(LogapiImpl.class,
						logapi.getPrimaryKeyObj());
			}

			if (logapi != null) {
				session.delete(logapi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (logapi != null) {
			clearCache(logapi);
		}

		return logapi;
	}

	@Override
	public Logapi updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi logapi)
		throws SystemException {
		logapi = toUnwrappedModel(logapi);

		boolean isNew = logapi.isNew();

		Session session = null;

		try {
			session = openSession();

			if (logapi.isNew()) {
				session.save(logapi);

				logapi.setNew(false);
			}
			else {
				session.merge(logapi);
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

		EntityCacheUtil.putResult(LogapiModelImpl.ENTITY_CACHE_ENABLED,
			LogapiImpl.class, logapi.getPrimaryKey(), logapi);

		return logapi;
	}

	protected Logapi toUnwrappedModel(Logapi logapi) {
		if (logapi instanceof LogapiImpl) {
			return logapi;
		}

		LogapiImpl logapiImpl = new LogapiImpl();

		logapiImpl.setNew(logapi.isNew());
		logapiImpl.setPrimaryKey(logapi.getPrimaryKey());

		logapiImpl.setLogapiId(logapi.getLogapiId());
		logapiImpl.setUserId(logapi.getUserId());
		logapiImpl.setUserip(logapi.getUserip());
		logapiImpl.setLogmsg(logapi.getLogmsg());
		logapiImpl.setDate(logapi.getDate());

		return logapiImpl;
	}

	/**
	 * Returns the logapi with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the logapi
	 * @return the logapi
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchLogapiException if a logapi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Logapi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLogapiException, SystemException {
		Logapi logapi = fetchByPrimaryKey(primaryKey);

		if (logapi == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLogapiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return logapi;
	}

	/**
	 * Returns the logapi with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchLogapiException} if it could not be found.
	 *
	 * @param logapiId the primary key of the logapi
	 * @return the logapi
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchLogapiException if a logapi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Logapi findByPrimaryKey(long logapiId)
		throws NoSuchLogapiException, SystemException {
		return findByPrimaryKey((Serializable)logapiId);
	}

	/**
	 * Returns the logapi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the logapi
	 * @return the logapi, or <code>null</code> if a logapi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Logapi fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Logapi logapi = (Logapi)EntityCacheUtil.getResult(LogapiModelImpl.ENTITY_CACHE_ENABLED,
				LogapiImpl.class, primaryKey);

		if (logapi == _nullLogapi) {
			return null;
		}

		if (logapi == null) {
			Session session = null;

			try {
				session = openSession();

				logapi = (Logapi)session.get(LogapiImpl.class, primaryKey);

				if (logapi != null) {
					cacheResult(logapi);
				}
				else {
					EntityCacheUtil.putResult(LogapiModelImpl.ENTITY_CACHE_ENABLED,
						LogapiImpl.class, primaryKey, _nullLogapi);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LogapiModelImpl.ENTITY_CACHE_ENABLED,
					LogapiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return logapi;
	}

	/**
	 * Returns the logapi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logapiId the primary key of the logapi
	 * @return the logapi, or <code>null</code> if a logapi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Logapi fetchByPrimaryKey(long logapiId) throws SystemException {
		return fetchByPrimaryKey((Serializable)logapiId);
	}

	/**
	 * Returns all the logapis.
	 *
	 * @return the logapis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Logapi> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the logapis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.LogapiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of logapis
	 * @param end the upper bound of the range of logapis (not inclusive)
	 * @return the range of logapis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Logapi> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the logapis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.LogapiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of logapis
	 * @param end the upper bound of the range of logapis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of logapis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Logapi> findAll(int start, int end,
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

		List<Logapi> list = (List<Logapi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOGAPI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGAPI;

				if (pagination) {
					sql = sql.concat(LogapiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Logapi>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Logapi>(list);
				}
				else {
					list = (List<Logapi>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the logapis from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Logapi logapi : findAll()) {
			remove(logapi);
		}
	}

	/**
	 * Returns the number of logapis.
	 *
	 * @return the number of logapis
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

				Query q = session.createQuery(_SQL_COUNT_LOGAPI);

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
	 * Initializes the logapi persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Logapi>> listenersList = new ArrayList<ModelListener<Logapi>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Logapi>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LogapiImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LOGAPI = "SELECT logapi FROM Logapi logapi";
	private static final String _SQL_COUNT_LOGAPI = "SELECT COUNT(logapi) FROM Logapi logapi";
	private static final String _ORDER_BY_ENTITY_ALIAS = "logapi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Logapi exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LogapiPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"date"
			});
	private static Logapi _nullLogapi = new LogapiImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Logapi> toCacheModel() {
				return _nullLogapiCacheModel;
			}
		};

	private static CacheModel<Logapi> _nullLogapiCacheModel = new CacheModel<Logapi>() {
			@Override
			public Logapi toEntityModel() {
				return _nullLogapi;
			}
		};
}