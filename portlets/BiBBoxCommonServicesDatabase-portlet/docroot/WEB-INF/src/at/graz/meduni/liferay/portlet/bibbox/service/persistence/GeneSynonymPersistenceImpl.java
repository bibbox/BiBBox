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

import at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException;
import at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneSynonymImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneSynonymModelImpl;

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
 * The persistence implementation for the gene synonym service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see GeneSynonymPersistence
 * @see GeneSynonymUtil
 * @generated
 */
public class GeneSynonymPersistenceImpl extends BasePersistenceImpl<GeneSynonym>
	implements GeneSynonymPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeneSynonymUtil} to access the gene synonym persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeneSynonymImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeneSynonymModelImpl.ENTITY_CACHE_ENABLED,
			GeneSynonymModelImpl.FINDER_CACHE_ENABLED, GeneSynonymImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeneSynonymModelImpl.ENTITY_CACHE_ENABLED,
			GeneSynonymModelImpl.FINDER_CACHE_ENABLED, GeneSynonymImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeneSynonymModelImpl.ENTITY_CACHE_ENABLED,
			GeneSynonymModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GeneSynonymPersistenceImpl() {
		setModelClass(GeneSynonym.class);
	}

	/**
	 * Caches the gene synonym in the entity cache if it is enabled.
	 *
	 * @param geneSynonym the gene synonym
	 */
	@Override
	public void cacheResult(GeneSynonym geneSynonym) {
		EntityCacheUtil.putResult(GeneSynonymModelImpl.ENTITY_CACHE_ENABLED,
			GeneSynonymImpl.class, geneSynonym.getPrimaryKey(), geneSynonym);

		geneSynonym.resetOriginalValues();
	}

	/**
	 * Caches the gene synonyms in the entity cache if it is enabled.
	 *
	 * @param geneSynonyms the gene synonyms
	 */
	@Override
	public void cacheResult(List<GeneSynonym> geneSynonyms) {
		for (GeneSynonym geneSynonym : geneSynonyms) {
			if (EntityCacheUtil.getResult(
						GeneSynonymModelImpl.ENTITY_CACHE_ENABLED,
						GeneSynonymImpl.class, geneSynonym.getPrimaryKey()) == null) {
				cacheResult(geneSynonym);
			}
			else {
				geneSynonym.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gene synonyms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GeneSynonymImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GeneSynonymImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gene synonym.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GeneSynonym geneSynonym) {
		EntityCacheUtil.removeResult(GeneSynonymModelImpl.ENTITY_CACHE_ENABLED,
			GeneSynonymImpl.class, geneSynonym.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GeneSynonym> geneSynonyms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GeneSynonym geneSynonym : geneSynonyms) {
			EntityCacheUtil.removeResult(GeneSynonymModelImpl.ENTITY_CACHE_ENABLED,
				GeneSynonymImpl.class, geneSynonym.getPrimaryKey());
		}
	}

	/**
	 * Creates a new gene synonym with the primary key. Does not add the gene synonym to the database.
	 *
	 * @param genesynonymId the primary key for the new gene synonym
	 * @return the new gene synonym
	 */
	@Override
	public GeneSynonym create(long genesynonymId) {
		GeneSynonym geneSynonym = new GeneSynonymImpl();

		geneSynonym.setNew(true);
		geneSynonym.setPrimaryKey(genesynonymId);

		return geneSynonym;
	}

	/**
	 * Removes the gene synonym with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param genesynonymId the primary key of the gene synonym
	 * @return the gene synonym that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException if a gene synonym with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneSynonym remove(long genesynonymId)
		throws NoSuchGeneSynonymException, SystemException {
		return remove((Serializable)genesynonymId);
	}

	/**
	 * Removes the gene synonym with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gene synonym
	 * @return the gene synonym that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException if a gene synonym with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneSynonym remove(Serializable primaryKey)
		throws NoSuchGeneSynonymException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GeneSynonym geneSynonym = (GeneSynonym)session.get(GeneSynonymImpl.class,
					primaryKey);

			if (geneSynonym == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeneSynonymException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(geneSynonym);
		}
		catch (NoSuchGeneSynonymException nsee) {
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
	protected GeneSynonym removeImpl(GeneSynonym geneSynonym)
		throws SystemException {
		geneSynonym = toUnwrappedModel(geneSynonym);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(geneSynonym)) {
				geneSynonym = (GeneSynonym)session.get(GeneSynonymImpl.class,
						geneSynonym.getPrimaryKeyObj());
			}

			if (geneSynonym != null) {
				session.delete(geneSynonym);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (geneSynonym != null) {
			clearCache(geneSynonym);
		}

		return geneSynonym;
	}

	@Override
	public GeneSynonym updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym geneSynonym)
		throws SystemException {
		geneSynonym = toUnwrappedModel(geneSynonym);

		boolean isNew = geneSynonym.isNew();

		Session session = null;

		try {
			session = openSession();

			if (geneSynonym.isNew()) {
				session.save(geneSynonym);

				geneSynonym.setNew(false);
			}
			else {
				session.merge(geneSynonym);
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

		EntityCacheUtil.putResult(GeneSynonymModelImpl.ENTITY_CACHE_ENABLED,
			GeneSynonymImpl.class, geneSynonym.getPrimaryKey(), geneSynonym);

		return geneSynonym;
	}

	protected GeneSynonym toUnwrappedModel(GeneSynonym geneSynonym) {
		if (geneSynonym instanceof GeneSynonymImpl) {
			return geneSynonym;
		}

		GeneSynonymImpl geneSynonymImpl = new GeneSynonymImpl();

		geneSynonymImpl.setNew(geneSynonym.isNew());
		geneSynonymImpl.setPrimaryKey(geneSynonym.getPrimaryKey());

		geneSynonymImpl.setGenesynonymId(geneSynonym.getGenesynonymId());
		geneSynonymImpl.setGeneId(geneSynonym.getGeneId());
		geneSynonymImpl.setSynonym(geneSynonym.getSynonym());

		return geneSynonymImpl;
	}

	/**
	 * Returns the gene synonym with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the gene synonym
	 * @return the gene synonym
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException if a gene synonym with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneSynonym findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeneSynonymException, SystemException {
		GeneSynonym geneSynonym = fetchByPrimaryKey(primaryKey);

		if (geneSynonym == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeneSynonymException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return geneSynonym;
	}

	/**
	 * Returns the gene synonym with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException} if it could not be found.
	 *
	 * @param genesynonymId the primary key of the gene synonym
	 * @return the gene synonym
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException if a gene synonym with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneSynonym findByPrimaryKey(long genesynonymId)
		throws NoSuchGeneSynonymException, SystemException {
		return findByPrimaryKey((Serializable)genesynonymId);
	}

	/**
	 * Returns the gene synonym with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gene synonym
	 * @return the gene synonym, or <code>null</code> if a gene synonym with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneSynonym fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GeneSynonym geneSynonym = (GeneSynonym)EntityCacheUtil.getResult(GeneSynonymModelImpl.ENTITY_CACHE_ENABLED,
				GeneSynonymImpl.class, primaryKey);

		if (geneSynonym == _nullGeneSynonym) {
			return null;
		}

		if (geneSynonym == null) {
			Session session = null;

			try {
				session = openSession();

				geneSynonym = (GeneSynonym)session.get(GeneSynonymImpl.class,
						primaryKey);

				if (geneSynonym != null) {
					cacheResult(geneSynonym);
				}
				else {
					EntityCacheUtil.putResult(GeneSynonymModelImpl.ENTITY_CACHE_ENABLED,
						GeneSynonymImpl.class, primaryKey, _nullGeneSynonym);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GeneSynonymModelImpl.ENTITY_CACHE_ENABLED,
					GeneSynonymImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return geneSynonym;
	}

	/**
	 * Returns the gene synonym with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param genesynonymId the primary key of the gene synonym
	 * @return the gene synonym, or <code>null</code> if a gene synonym with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneSynonym fetchByPrimaryKey(long genesynonymId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)genesynonymId);
	}

	/**
	 * Returns all the gene synonyms.
	 *
	 * @return the gene synonyms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneSynonym> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the gene synonyms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gene synonyms
	 * @param end the upper bound of the range of gene synonyms (not inclusive)
	 * @return the range of gene synonyms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneSynonym> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the gene synonyms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gene synonyms
	 * @param end the upper bound of the range of gene synonyms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gene synonyms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneSynonym> findAll(int start, int end,
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

		List<GeneSynonym> list = (List<GeneSynonym>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GENESYNONYM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GENESYNONYM;

				if (pagination) {
					sql = sql.concat(GeneSynonymModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GeneSynonym>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeneSynonym>(list);
				}
				else {
					list = (List<GeneSynonym>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the gene synonyms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GeneSynonym geneSynonym : findAll()) {
			remove(geneSynonym);
		}
	}

	/**
	 * Returns the number of gene synonyms.
	 *
	 * @return the number of gene synonyms
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

				Query q = session.createQuery(_SQL_COUNT_GENESYNONYM);

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
	 * Initializes the gene synonym persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GeneSynonym>> listenersList = new ArrayList<ModelListener<GeneSynonym>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GeneSynonym>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GeneSynonymImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GENESYNONYM = "SELECT geneSynonym FROM GeneSynonym geneSynonym";
	private static final String _SQL_COUNT_GENESYNONYM = "SELECT COUNT(geneSynonym) FROM GeneSynonym geneSynonym";
	private static final String _ORDER_BY_ENTITY_ALIAS = "geneSynonym.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GeneSynonym exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GeneSynonymPersistenceImpl.class);
	private static GeneSynonym _nullGeneSynonym = new GeneSynonymImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GeneSynonym> toCacheModel() {
				return _nullGeneSynonymCacheModel;
			}
		};

	private static CacheModel<GeneSynonym> _nullGeneSynonymCacheModel = new CacheModel<GeneSynonym>() {
			@Override
			public GeneSynonym toEntityModel() {
				return _nullGeneSynonym;
			}
		};
}