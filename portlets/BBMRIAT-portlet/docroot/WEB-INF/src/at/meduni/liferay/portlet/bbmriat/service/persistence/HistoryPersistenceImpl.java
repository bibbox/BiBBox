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

package at.meduni.liferay.portlet.bbmriat.service.persistence;

import at.meduni.liferay.portlet.bbmriat.NoSuchHistoryException;
import at.meduni.liferay.portlet.bbmriat.model.History;
import at.meduni.liferay.portlet.bbmriat.model.impl.HistoryImpl;
import at.meduni.liferay.portlet.bbmriat.model.impl.HistoryModelImpl;

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
 * The persistence implementation for the history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see HistoryPersistence
 * @see HistoryUtil
 * @generated
 */
public class HistoryPersistenceImpl extends BasePersistenceImpl<History>
	implements HistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HistoryUtil} to access the history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryModelImpl.FINDER_CACHE_ENABLED, HistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryModelImpl.FINDER_CACHE_ENABLED, HistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public HistoryPersistenceImpl() {
		setModelClass(History.class);
	}

	/**
	 * Caches the history in the entity cache if it is enabled.
	 *
	 * @param history the history
	 */
	@Override
	public void cacheResult(History history) {
		EntityCacheUtil.putResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryImpl.class, history.getPrimaryKey(), history);

		history.resetOriginalValues();
	}

	/**
	 * Caches the histories in the entity cache if it is enabled.
	 *
	 * @param histories the histories
	 */
	@Override
	public void cacheResult(List<History> histories) {
		for (History history : histories) {
			if (EntityCacheUtil.getResult(
						HistoryModelImpl.ENTITY_CACHE_ENABLED,
						HistoryImpl.class, history.getPrimaryKey()) == null) {
				cacheResult(history);
			}
			else {
				history.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(History history) {
		EntityCacheUtil.removeResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryImpl.class, history.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<History> histories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (History history : histories) {
			EntityCacheUtil.removeResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
				HistoryImpl.class, history.getPrimaryKey());
		}
	}

	/**
	 * Creates a new history with the primary key. Does not add the history to the database.
	 *
	 * @param historyId the primary key for the new history
	 * @return the new history
	 */
	@Override
	public History create(long historyId) {
		History history = new HistoryImpl();

		history.setNew(true);
		history.setPrimaryKey(historyId);

		return history;
	}

	/**
	 * Removes the history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyId the primary key of the history
	 * @return the history that was removed
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchHistoryException if a history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public History remove(long historyId)
		throws NoSuchHistoryException, SystemException {
		return remove((Serializable)historyId);
	}

	/**
	 * Removes the history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the history
	 * @return the history that was removed
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchHistoryException if a history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public History remove(Serializable primaryKey)
		throws NoSuchHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			History history = (History)session.get(HistoryImpl.class, primaryKey);

			if (history == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(history);
		}
		catch (NoSuchHistoryException nsee) {
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
	protected History removeImpl(History history) throws SystemException {
		history = toUnwrappedModel(history);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(history)) {
				history = (History)session.get(HistoryImpl.class,
						history.getPrimaryKeyObj());
			}

			if (history != null) {
				session.delete(history);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (history != null) {
			clearCache(history);
		}

		return history;
	}

	@Override
	public History updateImpl(
		at.meduni.liferay.portlet.bbmriat.model.History history)
		throws SystemException {
		history = toUnwrappedModel(history);

		boolean isNew = history.isNew();

		Session session = null;

		try {
			session = openSession();

			if (history.isNew()) {
				session.save(history);

				history.setNew(false);
			}
			else {
				session.merge(history);
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

		EntityCacheUtil.putResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryImpl.class, history.getPrimaryKey(), history);

		return history;
	}

	protected History toUnwrappedModel(History history) {
		if (history instanceof HistoryImpl) {
			return history;
		}

		HistoryImpl historyImpl = new HistoryImpl();

		historyImpl.setNew(history.isNew());
		historyImpl.setPrimaryKey(history.getPrimaryKey());

		historyImpl.setHistoryId(history.getHistoryId());
		historyImpl.setAction(history.getAction());
		historyImpl.setTime(history.getTime());
		historyImpl.setHisto_id(history.getHisto_id());
		historyImpl.setWorkplace_id(history.getWorkplace_id());
		historyImpl.setOrder_id(history.getOrder_id());

		return historyImpl;
	}

	/**
	 * Returns the history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the history
	 * @return the history
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchHistoryException if a history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public History findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHistoryException, SystemException {
		History history = fetchByPrimaryKey(primaryKey);

		if (history == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return history;
	}

	/**
	 * Returns the history with the primary key or throws a {@link at.meduni.liferay.portlet.bbmriat.NoSuchHistoryException} if it could not be found.
	 *
	 * @param historyId the primary key of the history
	 * @return the history
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchHistoryException if a history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public History findByPrimaryKey(long historyId)
		throws NoSuchHistoryException, SystemException {
		return findByPrimaryKey((Serializable)historyId);
	}

	/**
	 * Returns the history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the history
	 * @return the history, or <code>null</code> if a history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public History fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		History history = (History)EntityCacheUtil.getResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
				HistoryImpl.class, primaryKey);

		if (history == _nullHistory) {
			return null;
		}

		if (history == null) {
			Session session = null;

			try {
				session = openSession();

				history = (History)session.get(HistoryImpl.class, primaryKey);

				if (history != null) {
					cacheResult(history);
				}
				else {
					EntityCacheUtil.putResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
						HistoryImpl.class, primaryKey, _nullHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
					HistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return history;
	}

	/**
	 * Returns the history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param historyId the primary key of the history
	 * @return the history, or <code>null</code> if a history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public History fetchByPrimaryKey(long historyId) throws SystemException {
		return fetchByPrimaryKey((Serializable)historyId);
	}

	/**
	 * Returns all the histories.
	 *
	 * @return the histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<History> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of histories
	 * @param end the upper bound of the range of histories (not inclusive)
	 * @return the range of histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<History> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of histories
	 * @param end the upper bound of the range of histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<History> findAll(int start, int end,
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

		List<History> list = (List<History>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HISTORY;

				if (pagination) {
					sql = sql.concat(HistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<History>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<History>(list);
				}
				else {
					list = (List<History>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (History history : findAll()) {
			remove(history);
		}
	}

	/**
	 * Returns the number of histories.
	 *
	 * @return the number of histories
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

				Query q = session.createQuery(_SQL_COUNT_HISTORY);

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
	 * Initializes the history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.bbmriat.model.History")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<History>> listenersList = new ArrayList<ModelListener<History>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<History>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_HISTORY = "SELECT history FROM History history";
	private static final String _SQL_COUNT_HISTORY = "SELECT COUNT(history) FROM History history";
	private static final String _ORDER_BY_ENTITY_ALIAS = "history.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No History exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HistoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"historyId", "time"
			});
	private static History _nullHistory = new HistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<History> toCacheModel() {
				return _nullHistoryCacheModel;
			}
		};

	private static CacheModel<History> _nullHistoryCacheModel = new CacheModel<History>() {
			@Override
			public History toEntityModel() {
				return _nullHistory;
			}
		};
}