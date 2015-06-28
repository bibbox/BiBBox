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

import at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException;
import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymModelImpl;

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
 * The persistence implementation for the orphanet synonym service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see OrphanetSynonymPersistence
 * @see OrphanetSynonymUtil
 * @generated
 */
public class OrphanetSynonymPersistenceImpl extends BasePersistenceImpl<OrphanetSynonym>
	implements OrphanetSynonymPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrphanetSynonymUtil} to access the orphanet synonym persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrphanetSynonymImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrphanetSynonymModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetSynonymModelImpl.FINDER_CACHE_ENABLED,
			OrphanetSynonymImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrphanetSynonymModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetSynonymModelImpl.FINDER_CACHE_ENABLED,
			OrphanetSynonymImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrphanetSynonymModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetSynonymModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OrphanetSynonymPersistenceImpl() {
		setModelClass(OrphanetSynonym.class);
	}

	/**
	 * Caches the orphanet synonym in the entity cache if it is enabled.
	 *
	 * @param orphanetSynonym the orphanet synonym
	 */
	@Override
	public void cacheResult(OrphanetSynonym orphanetSynonym) {
		EntityCacheUtil.putResult(OrphanetSynonymModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetSynonymImpl.class, orphanetSynonym.getPrimaryKey(),
			orphanetSynonym);

		orphanetSynonym.resetOriginalValues();
	}

	/**
	 * Caches the orphanet synonyms in the entity cache if it is enabled.
	 *
	 * @param orphanetSynonyms the orphanet synonyms
	 */
	@Override
	public void cacheResult(List<OrphanetSynonym> orphanetSynonyms) {
		for (OrphanetSynonym orphanetSynonym : orphanetSynonyms) {
			if (EntityCacheUtil.getResult(
						OrphanetSynonymModelImpl.ENTITY_CACHE_ENABLED,
						OrphanetSynonymImpl.class,
						orphanetSynonym.getPrimaryKey()) == null) {
				cacheResult(orphanetSynonym);
			}
			else {
				orphanetSynonym.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all orphanet synonyms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrphanetSynonymImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrphanetSynonymImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the orphanet synonym.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrphanetSynonym orphanetSynonym) {
		EntityCacheUtil.removeResult(OrphanetSynonymModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetSynonymImpl.class, orphanetSynonym.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OrphanetSynonym> orphanetSynonyms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrphanetSynonym orphanetSynonym : orphanetSynonyms) {
			EntityCacheUtil.removeResult(OrphanetSynonymModelImpl.ENTITY_CACHE_ENABLED,
				OrphanetSynonymImpl.class, orphanetSynonym.getPrimaryKey());
		}
	}

	/**
	 * Creates a new orphanet synonym with the primary key. Does not add the orphanet synonym to the database.
	 *
	 * @param orphanetsynonymId the primary key for the new orphanet synonym
	 * @return the new orphanet synonym
	 */
	@Override
	public OrphanetSynonym create(long orphanetsynonymId) {
		OrphanetSynonym orphanetSynonym = new OrphanetSynonymImpl();

		orphanetSynonym.setNew(true);
		orphanetSynonym.setPrimaryKey(orphanetsynonymId);

		return orphanetSynonym;
	}

	/**
	 * Removes the orphanet synonym with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orphanetsynonymId the primary key of the orphanet synonym
	 * @return the orphanet synonym that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a orphanet synonym with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetSynonym remove(long orphanetsynonymId)
		throws NoSuchOrphanetSynonymException, SystemException {
		return remove((Serializable)orphanetsynonymId);
	}

	/**
	 * Removes the orphanet synonym with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the orphanet synonym
	 * @return the orphanet synonym that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a orphanet synonym with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetSynonym remove(Serializable primaryKey)
		throws NoSuchOrphanetSynonymException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrphanetSynonym orphanetSynonym = (OrphanetSynonym)session.get(OrphanetSynonymImpl.class,
					primaryKey);

			if (orphanetSynonym == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrphanetSynonymException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(orphanetSynonym);
		}
		catch (NoSuchOrphanetSynonymException nsee) {
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
	protected OrphanetSynonym removeImpl(OrphanetSynonym orphanetSynonym)
		throws SystemException {
		orphanetSynonym = toUnwrappedModel(orphanetSynonym);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(orphanetSynonym)) {
				orphanetSynonym = (OrphanetSynonym)session.get(OrphanetSynonymImpl.class,
						orphanetSynonym.getPrimaryKeyObj());
			}

			if (orphanetSynonym != null) {
				session.delete(orphanetSynonym);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (orphanetSynonym != null) {
			clearCache(orphanetSynonym);
		}

		return orphanetSynonym;
	}

	@Override
	public OrphanetSynonym updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym orphanetSynonym)
		throws SystemException {
		orphanetSynonym = toUnwrappedModel(orphanetSynonym);

		boolean isNew = orphanetSynonym.isNew();

		Session session = null;

		try {
			session = openSession();

			if (orphanetSynonym.isNew()) {
				session.save(orphanetSynonym);

				orphanetSynonym.setNew(false);
			}
			else {
				session.merge(orphanetSynonym);
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

		EntityCacheUtil.putResult(OrphanetSynonymModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetSynonymImpl.class, orphanetSynonym.getPrimaryKey(),
			orphanetSynonym);

		return orphanetSynonym;
	}

	protected OrphanetSynonym toUnwrappedModel(OrphanetSynonym orphanetSynonym) {
		if (orphanetSynonym instanceof OrphanetSynonymImpl) {
			return orphanetSynonym;
		}

		OrphanetSynonymImpl orphanetSynonymImpl = new OrphanetSynonymImpl();

		orphanetSynonymImpl.setNew(orphanetSynonym.isNew());
		orphanetSynonymImpl.setPrimaryKey(orphanetSynonym.getPrimaryKey());

		orphanetSynonymImpl.setOrphanetsynonymId(orphanetSynonym.getOrphanetsynonymId());
		orphanetSynonymImpl.setOrphanetdisorderId(orphanetSynonym.getOrphanetdisorderId());
		orphanetSynonymImpl.setSynonym(orphanetSynonym.getSynonym());

		return orphanetSynonymImpl;
	}

	/**
	 * Returns the orphanet synonym with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the orphanet synonym
	 * @return the orphanet synonym
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a orphanet synonym with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetSynonym findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrphanetSynonymException, SystemException {
		OrphanetSynonym orphanetSynonym = fetchByPrimaryKey(primaryKey);

		if (orphanetSynonym == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrphanetSynonymException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return orphanetSynonym;
	}

	/**
	 * Returns the orphanet synonym with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException} if it could not be found.
	 *
	 * @param orphanetsynonymId the primary key of the orphanet synonym
	 * @return the orphanet synonym
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a orphanet synonym with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetSynonym findByPrimaryKey(long orphanetsynonymId)
		throws NoSuchOrphanetSynonymException, SystemException {
		return findByPrimaryKey((Serializable)orphanetsynonymId);
	}

	/**
	 * Returns the orphanet synonym with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the orphanet synonym
	 * @return the orphanet synonym, or <code>null</code> if a orphanet synonym with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetSynonym fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OrphanetSynonym orphanetSynonym = (OrphanetSynonym)EntityCacheUtil.getResult(OrphanetSynonymModelImpl.ENTITY_CACHE_ENABLED,
				OrphanetSynonymImpl.class, primaryKey);

		if (orphanetSynonym == _nullOrphanetSynonym) {
			return null;
		}

		if (orphanetSynonym == null) {
			Session session = null;

			try {
				session = openSession();

				orphanetSynonym = (OrphanetSynonym)session.get(OrphanetSynonymImpl.class,
						primaryKey);

				if (orphanetSynonym != null) {
					cacheResult(orphanetSynonym);
				}
				else {
					EntityCacheUtil.putResult(OrphanetSynonymModelImpl.ENTITY_CACHE_ENABLED,
						OrphanetSynonymImpl.class, primaryKey,
						_nullOrphanetSynonym);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrphanetSynonymModelImpl.ENTITY_CACHE_ENABLED,
					OrphanetSynonymImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return orphanetSynonym;
	}

	/**
	 * Returns the orphanet synonym with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orphanetsynonymId the primary key of the orphanet synonym
	 * @return the orphanet synonym, or <code>null</code> if a orphanet synonym with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetSynonym fetchByPrimaryKey(long orphanetsynonymId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)orphanetsynonymId);
	}

	/**
	 * Returns all the orphanet synonyms.
	 *
	 * @return the orphanet synonyms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetSynonym> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the orphanet synonyms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of orphanet synonyms
	 * @param end the upper bound of the range of orphanet synonyms (not inclusive)
	 * @return the range of orphanet synonyms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetSynonym> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the orphanet synonyms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of orphanet synonyms
	 * @param end the upper bound of the range of orphanet synonyms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of orphanet synonyms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetSynonym> findAll(int start, int end,
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

		List<OrphanetSynonym> list = (List<OrphanetSynonym>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORPHANETSYNONYM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORPHANETSYNONYM;

				if (pagination) {
					sql = sql.concat(OrphanetSynonymModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OrphanetSynonym>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrphanetSynonym>(list);
				}
				else {
					list = (List<OrphanetSynonym>)QueryUtil.list(q,
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
	 * Removes all the orphanet synonyms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OrphanetSynonym orphanetSynonym : findAll()) {
			remove(orphanetSynonym);
		}
	}

	/**
	 * Returns the number of orphanet synonyms.
	 *
	 * @return the number of orphanet synonyms
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

				Query q = session.createQuery(_SQL_COUNT_ORPHANETSYNONYM);

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
	 * Initializes the orphanet synonym persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrphanetSynonym>> listenersList = new ArrayList<ModelListener<OrphanetSynonym>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrphanetSynonym>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrphanetSynonymImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORPHANETSYNONYM = "SELECT orphanetSynonym FROM OrphanetSynonym orphanetSynonym";
	private static final String _SQL_COUNT_ORPHANETSYNONYM = "SELECT COUNT(orphanetSynonym) FROM OrphanetSynonym orphanetSynonym";
	private static final String _ORDER_BY_ENTITY_ALIAS = "orphanetSynonym.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrphanetSynonym exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrphanetSynonymPersistenceImpl.class);
	private static OrphanetSynonym _nullOrphanetSynonym = new OrphanetSynonymImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OrphanetSynonym> toCacheModel() {
				return _nullOrphanetSynonymCacheModel;
			}
		};

	private static CacheModel<OrphanetSynonym> _nullOrphanetSynonymCacheModel = new CacheModel<OrphanetSynonym>() {
			@Override
			public OrphanetSynonym toEntityModel() {
				return _nullOrphanetSynonym;
			}
		};
}