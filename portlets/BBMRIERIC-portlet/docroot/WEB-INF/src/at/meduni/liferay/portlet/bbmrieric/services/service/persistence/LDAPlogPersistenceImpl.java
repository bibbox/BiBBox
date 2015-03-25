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

package at.meduni.liferay.portlet.bbmrieric.services.service.persistence;

import at.meduni.liferay.portlet.bbmrieric.services.NoSuchlogException;
import at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog;
import at.meduni.liferay.portlet.bbmrieric.services.model.impl.LDAPlogImpl;
import at.meduni.liferay.portlet.bbmrieric.services.model.impl.LDAPlogModelImpl;

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
 * The persistence implementation for the l d a plog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see LDAPlogPersistence
 * @see LDAPlogUtil
 * @generated
 */
public class LDAPlogPersistenceImpl extends BasePersistenceImpl<LDAPlog>
	implements LDAPlogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LDAPlogUtil} to access the l d a plog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LDAPlogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LDAPlogModelImpl.ENTITY_CACHE_ENABLED,
			LDAPlogModelImpl.FINDER_CACHE_ENABLED, LDAPlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LDAPlogModelImpl.ENTITY_CACHE_ENABLED,
			LDAPlogModelImpl.FINDER_CACHE_ENABLED, LDAPlogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LDAPlogModelImpl.ENTITY_CACHE_ENABLED,
			LDAPlogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LDAPlogPersistenceImpl() {
		setModelClass(LDAPlog.class);
	}

	/**
	 * Caches the l d a plog in the entity cache if it is enabled.
	 *
	 * @param ldaPlog the l d a plog
	 */
	@Override
	public void cacheResult(LDAPlog ldaPlog) {
		EntityCacheUtil.putResult(LDAPlogModelImpl.ENTITY_CACHE_ENABLED,
			LDAPlogImpl.class, ldaPlog.getPrimaryKey(), ldaPlog);

		ldaPlog.resetOriginalValues();
	}

	/**
	 * Caches the l d a plogs in the entity cache if it is enabled.
	 *
	 * @param ldaPlogs the l d a plogs
	 */
	@Override
	public void cacheResult(List<LDAPlog> ldaPlogs) {
		for (LDAPlog ldaPlog : ldaPlogs) {
			if (EntityCacheUtil.getResult(
						LDAPlogModelImpl.ENTITY_CACHE_ENABLED,
						LDAPlogImpl.class, ldaPlog.getPrimaryKey()) == null) {
				cacheResult(ldaPlog);
			}
			else {
				ldaPlog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l d a plogs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LDAPlogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LDAPlogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l d a plog.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LDAPlog ldaPlog) {
		EntityCacheUtil.removeResult(LDAPlogModelImpl.ENTITY_CACHE_ENABLED,
			LDAPlogImpl.class, ldaPlog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LDAPlog> ldaPlogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LDAPlog ldaPlog : ldaPlogs) {
			EntityCacheUtil.removeResult(LDAPlogModelImpl.ENTITY_CACHE_ENABLED,
				LDAPlogImpl.class, ldaPlog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new l d a plog with the primary key. Does not add the l d a plog to the database.
	 *
	 * @param ldaplogId the primary key for the new l d a plog
	 * @return the new l d a plog
	 */
	@Override
	public LDAPlog create(long ldaplogId) {
		LDAPlog ldaPlog = new LDAPlogImpl();

		ldaPlog.setNew(true);
		ldaPlog.setPrimaryKey(ldaplogId);

		return ldaPlog;
	}

	/**
	 * Removes the l d a plog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ldaplogId the primary key of the l d a plog
	 * @return the l d a plog that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.services.NoSuchlogException if a l d a plog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LDAPlog remove(long ldaplogId)
		throws NoSuchlogException, SystemException {
		return remove((Serializable)ldaplogId);
	}

	/**
	 * Removes the l d a plog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l d a plog
	 * @return the l d a plog that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.services.NoSuchlogException if a l d a plog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LDAPlog remove(Serializable primaryKey)
		throws NoSuchlogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LDAPlog ldaPlog = (LDAPlog)session.get(LDAPlogImpl.class, primaryKey);

			if (ldaPlog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ldaPlog);
		}
		catch (NoSuchlogException nsee) {
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
	protected LDAPlog removeImpl(LDAPlog ldaPlog) throws SystemException {
		ldaPlog = toUnwrappedModel(ldaPlog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ldaPlog)) {
				ldaPlog = (LDAPlog)session.get(LDAPlogImpl.class,
						ldaPlog.getPrimaryKeyObj());
			}

			if (ldaPlog != null) {
				session.delete(ldaPlog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ldaPlog != null) {
			clearCache(ldaPlog);
		}

		return ldaPlog;
	}

	@Override
	public LDAPlog updateImpl(
		at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog ldaPlog)
		throws SystemException {
		ldaPlog = toUnwrappedModel(ldaPlog);

		boolean isNew = ldaPlog.isNew();

		Session session = null;

		try {
			session = openSession();

			if (ldaPlog.isNew()) {
				session.save(ldaPlog);

				ldaPlog.setNew(false);
			}
			else {
				session.merge(ldaPlog);
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

		EntityCacheUtil.putResult(LDAPlogModelImpl.ENTITY_CACHE_ENABLED,
			LDAPlogImpl.class, ldaPlog.getPrimaryKey(), ldaPlog);

		return ldaPlog;
	}

	protected LDAPlog toUnwrappedModel(LDAPlog ldaPlog) {
		if (ldaPlog instanceof LDAPlogImpl) {
			return ldaPlog;
		}

		LDAPlogImpl ldaPlogImpl = new LDAPlogImpl();

		ldaPlogImpl.setNew(ldaPlog.isNew());
		ldaPlogImpl.setPrimaryKey(ldaPlog.getPrimaryKey());

		ldaPlogImpl.setLdaplogId(ldaPlog.getLdaplogId());

		return ldaPlogImpl;
	}

	/**
	 * Returns the l d a plog with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l d a plog
	 * @return the l d a plog
	 * @throws at.meduni.liferay.portlet.bbmrieric.services.NoSuchlogException if a l d a plog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LDAPlog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchlogException, SystemException {
		LDAPlog ldaPlog = fetchByPrimaryKey(primaryKey);

		if (ldaPlog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ldaPlog;
	}

	/**
	 * Returns the l d a plog with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.services.NoSuchlogException} if it could not be found.
	 *
	 * @param ldaplogId the primary key of the l d a plog
	 * @return the l d a plog
	 * @throws at.meduni.liferay.portlet.bbmrieric.services.NoSuchlogException if a l d a plog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LDAPlog findByPrimaryKey(long ldaplogId)
		throws NoSuchlogException, SystemException {
		return findByPrimaryKey((Serializable)ldaplogId);
	}

	/**
	 * Returns the l d a plog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l d a plog
	 * @return the l d a plog, or <code>null</code> if a l d a plog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LDAPlog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LDAPlog ldaPlog = (LDAPlog)EntityCacheUtil.getResult(LDAPlogModelImpl.ENTITY_CACHE_ENABLED,
				LDAPlogImpl.class, primaryKey);

		if (ldaPlog == _nullLDAPlog) {
			return null;
		}

		if (ldaPlog == null) {
			Session session = null;

			try {
				session = openSession();

				ldaPlog = (LDAPlog)session.get(LDAPlogImpl.class, primaryKey);

				if (ldaPlog != null) {
					cacheResult(ldaPlog);
				}
				else {
					EntityCacheUtil.putResult(LDAPlogModelImpl.ENTITY_CACHE_ENABLED,
						LDAPlogImpl.class, primaryKey, _nullLDAPlog);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LDAPlogModelImpl.ENTITY_CACHE_ENABLED,
					LDAPlogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ldaPlog;
	}

	/**
	 * Returns the l d a plog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ldaplogId the primary key of the l d a plog
	 * @return the l d a plog, or <code>null</code> if a l d a plog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LDAPlog fetchByPrimaryKey(long ldaplogId) throws SystemException {
		return fetchByPrimaryKey((Serializable)ldaplogId);
	}

	/**
	 * Returns all the l d a plogs.
	 *
	 * @return the l d a plogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LDAPlog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l d a plogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.services.model.impl.LDAPlogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l d a plogs
	 * @param end the upper bound of the range of l d a plogs (not inclusive)
	 * @return the range of l d a plogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LDAPlog> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l d a plogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.services.model.impl.LDAPlogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l d a plogs
	 * @param end the upper bound of the range of l d a plogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l d a plogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LDAPlog> findAll(int start, int end,
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

		List<LDAPlog> list = (List<LDAPlog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LDAPLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LDAPLOG;

				if (pagination) {
					sql = sql.concat(LDAPlogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LDAPlog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LDAPlog>(list);
				}
				else {
					list = (List<LDAPlog>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the l d a plogs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LDAPlog ldaPlog : findAll()) {
			remove(ldaPlog);
		}
	}

	/**
	 * Returns the number of l d a plogs.
	 *
	 * @return the number of l d a plogs
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

				Query q = session.createQuery(_SQL_COUNT_LDAPLOG);

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
	 * Initializes the l d a plog persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LDAPlog>> listenersList = new ArrayList<ModelListener<LDAPlog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LDAPlog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LDAPlogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LDAPLOG = "SELECT ldaPlog FROM LDAPlog ldaPlog";
	private static final String _SQL_COUNT_LDAPLOG = "SELECT COUNT(ldaPlog) FROM LDAPlog ldaPlog";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ldaPlog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LDAPlog exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LDAPlogPersistenceImpl.class);
	private static LDAPlog _nullLDAPlog = new LDAPlogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LDAPlog> toCacheModel() {
				return _nullLDAPlogCacheModel;
			}
		};

	private static CacheModel<LDAPlog> _nullLDAPlogCacheModel = new CacheModel<LDAPlog>() {
			@Override
			public LDAPlog toEntityModel() {
				return _nullLDAPlog;
			}
		};
}