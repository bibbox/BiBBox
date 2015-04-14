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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpRulesException;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpRulesImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpRulesModelImpl;

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
 * The persistence implementation for the kdssmp rules service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see KdssmpRulesPersistence
 * @see KdssmpRulesUtil
 * @generated
 */
public class KdssmpRulesPersistenceImpl extends BasePersistenceImpl<KdssmpRules>
	implements KdssmpRulesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KdssmpRulesUtil} to access the kdssmp rules persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KdssmpRulesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KdssmpRulesModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpRulesModelImpl.FINDER_CACHE_ENABLED, KdssmpRulesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KdssmpRulesModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpRulesModelImpl.FINDER_CACHE_ENABLED, KdssmpRulesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KdssmpRulesModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpRulesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public KdssmpRulesPersistenceImpl() {
		setModelClass(KdssmpRules.class);
	}

	/**
	 * Caches the kdssmp rules in the entity cache if it is enabled.
	 *
	 * @param kdssmpRules the kdssmp rules
	 */
	@Override
	public void cacheResult(KdssmpRules kdssmpRules) {
		EntityCacheUtil.putResult(KdssmpRulesModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpRulesImpl.class, kdssmpRules.getPrimaryKey(), kdssmpRules);

		kdssmpRules.resetOriginalValues();
	}

	/**
	 * Caches the kdssmp ruleses in the entity cache if it is enabled.
	 *
	 * @param kdssmpRuleses the kdssmp ruleses
	 */
	@Override
	public void cacheResult(List<KdssmpRules> kdssmpRuleses) {
		for (KdssmpRules kdssmpRules : kdssmpRuleses) {
			if (EntityCacheUtil.getResult(
						KdssmpRulesModelImpl.ENTITY_CACHE_ENABLED,
						KdssmpRulesImpl.class, kdssmpRules.getPrimaryKey()) == null) {
				cacheResult(kdssmpRules);
			}
			else {
				kdssmpRules.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kdssmp ruleses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(KdssmpRulesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(KdssmpRulesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kdssmp rules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KdssmpRules kdssmpRules) {
		EntityCacheUtil.removeResult(KdssmpRulesModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpRulesImpl.class, kdssmpRules.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<KdssmpRules> kdssmpRuleses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KdssmpRules kdssmpRules : kdssmpRuleses) {
			EntityCacheUtil.removeResult(KdssmpRulesModelImpl.ENTITY_CACHE_ENABLED,
				KdssmpRulesImpl.class, kdssmpRules.getPrimaryKey());
		}
	}

	/**
	 * Creates a new kdssmp rules with the primary key. Does not add the kdssmp rules to the database.
	 *
	 * @param ruleId the primary key for the new kdssmp rules
	 * @return the new kdssmp rules
	 */
	@Override
	public KdssmpRules create(long ruleId) {
		KdssmpRules kdssmpRules = new KdssmpRulesImpl();

		kdssmpRules.setNew(true);
		kdssmpRules.setPrimaryKey(ruleId);

		return kdssmpRules;
	}

	/**
	 * Removes the kdssmp rules with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleId the primary key of the kdssmp rules
	 * @return the kdssmp rules that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpRulesException if a kdssmp rules with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpRules remove(long ruleId)
		throws NoSuchKdssmpRulesException, SystemException {
		return remove((Serializable)ruleId);
	}

	/**
	 * Removes the kdssmp rules with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kdssmp rules
	 * @return the kdssmp rules that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpRulesException if a kdssmp rules with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpRules remove(Serializable primaryKey)
		throws NoSuchKdssmpRulesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KdssmpRules kdssmpRules = (KdssmpRules)session.get(KdssmpRulesImpl.class,
					primaryKey);

			if (kdssmpRules == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKdssmpRulesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(kdssmpRules);
		}
		catch (NoSuchKdssmpRulesException nsee) {
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
	protected KdssmpRules removeImpl(KdssmpRules kdssmpRules)
		throws SystemException {
		kdssmpRules = toUnwrappedModel(kdssmpRules);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kdssmpRules)) {
				kdssmpRules = (KdssmpRules)session.get(KdssmpRulesImpl.class,
						kdssmpRules.getPrimaryKeyObj());
			}

			if (kdssmpRules != null) {
				session.delete(kdssmpRules);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kdssmpRules != null) {
			clearCache(kdssmpRules);
		}

		return kdssmpRules;
	}

	@Override
	public KdssmpRules updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules kdssmpRules)
		throws SystemException {
		kdssmpRules = toUnwrappedModel(kdssmpRules);

		boolean isNew = kdssmpRules.isNew();

		Session session = null;

		try {
			session = openSession();

			if (kdssmpRules.isNew()) {
				session.save(kdssmpRules);

				kdssmpRules.setNew(false);
			}
			else {
				session.merge(kdssmpRules);
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

		EntityCacheUtil.putResult(KdssmpRulesModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpRulesImpl.class, kdssmpRules.getPrimaryKey(), kdssmpRules);

		return kdssmpRules;
	}

	protected KdssmpRules toUnwrappedModel(KdssmpRules kdssmpRules) {
		if (kdssmpRules instanceof KdssmpRulesImpl) {
			return kdssmpRules;
		}

		KdssmpRulesImpl kdssmpRulesImpl = new KdssmpRulesImpl();

		kdssmpRulesImpl.setNew(kdssmpRules.isNew());
		kdssmpRulesImpl.setPrimaryKey(kdssmpRules.getPrimaryKey());

		kdssmpRulesImpl.setRuleId(kdssmpRules.getRuleId());
		kdssmpRulesImpl.setRule(kdssmpRules.getRule());

		return kdssmpRulesImpl;
	}

	/**
	 * Returns the kdssmp rules with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the kdssmp rules
	 * @return the kdssmp rules
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpRulesException if a kdssmp rules with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpRules findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKdssmpRulesException, SystemException {
		KdssmpRules kdssmpRules = fetchByPrimaryKey(primaryKey);

		if (kdssmpRules == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKdssmpRulesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return kdssmpRules;
	}

	/**
	 * Returns the kdssmp rules with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpRulesException} if it could not be found.
	 *
	 * @param ruleId the primary key of the kdssmp rules
	 * @return the kdssmp rules
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpRulesException if a kdssmp rules with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpRules findByPrimaryKey(long ruleId)
		throws NoSuchKdssmpRulesException, SystemException {
		return findByPrimaryKey((Serializable)ruleId);
	}

	/**
	 * Returns the kdssmp rules with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kdssmp rules
	 * @return the kdssmp rules, or <code>null</code> if a kdssmp rules with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpRules fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		KdssmpRules kdssmpRules = (KdssmpRules)EntityCacheUtil.getResult(KdssmpRulesModelImpl.ENTITY_CACHE_ENABLED,
				KdssmpRulesImpl.class, primaryKey);

		if (kdssmpRules == _nullKdssmpRules) {
			return null;
		}

		if (kdssmpRules == null) {
			Session session = null;

			try {
				session = openSession();

				kdssmpRules = (KdssmpRules)session.get(KdssmpRulesImpl.class,
						primaryKey);

				if (kdssmpRules != null) {
					cacheResult(kdssmpRules);
				}
				else {
					EntityCacheUtil.putResult(KdssmpRulesModelImpl.ENTITY_CACHE_ENABLED,
						KdssmpRulesImpl.class, primaryKey, _nullKdssmpRules);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(KdssmpRulesModelImpl.ENTITY_CACHE_ENABLED,
					KdssmpRulesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return kdssmpRules;
	}

	/**
	 * Returns the kdssmp rules with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleId the primary key of the kdssmp rules
	 * @return the kdssmp rules, or <code>null</code> if a kdssmp rules with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpRules fetchByPrimaryKey(long ruleId) throws SystemException {
		return fetchByPrimaryKey((Serializable)ruleId);
	}

	/**
	 * Returns all the kdssmp ruleses.
	 *
	 * @return the kdssmp ruleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpRules> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kdssmp ruleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpRulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kdssmp ruleses
	 * @param end the upper bound of the range of kdssmp ruleses (not inclusive)
	 * @return the range of kdssmp ruleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpRules> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the kdssmp ruleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpRulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kdssmp ruleses
	 * @param end the upper bound of the range of kdssmp ruleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kdssmp ruleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpRules> findAll(int start, int end,
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

		List<KdssmpRules> list = (List<KdssmpRules>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KDSSMPRULES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KDSSMPRULES;

				if (pagination) {
					sql = sql.concat(KdssmpRulesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<KdssmpRules>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<KdssmpRules>(list);
				}
				else {
					list = (List<KdssmpRules>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the kdssmp ruleses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (KdssmpRules kdssmpRules : findAll()) {
			remove(kdssmpRules);
		}
	}

	/**
	 * Returns the number of kdssmp ruleses.
	 *
	 * @return the number of kdssmp ruleses
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

				Query q = session.createQuery(_SQL_COUNT_KDSSMPRULES);

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
	 * Initializes the kdssmp rules persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<KdssmpRules>> listenersList = new ArrayList<ModelListener<KdssmpRules>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<KdssmpRules>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(KdssmpRulesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_KDSSMPRULES = "SELECT kdssmpRules FROM KdssmpRules kdssmpRules";
	private static final String _SQL_COUNT_KDSSMPRULES = "SELECT COUNT(kdssmpRules) FROM KdssmpRules kdssmpRules";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kdssmpRules.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KdssmpRules exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(KdssmpRulesPersistenceImpl.class);
	private static KdssmpRules _nullKdssmpRules = new KdssmpRulesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<KdssmpRules> toCacheModel() {
				return _nullKdssmpRulesCacheModel;
			}
		};

	private static CacheModel<KdssmpRules> _nullKdssmpRulesCacheModel = new CacheModel<KdssmpRules>() {
			@Override
			public KdssmpRules toEntityModel() {
				return _nullKdssmpRules;
			}
		};
}