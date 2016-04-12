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

import at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException;
import at.graz.meduni.liferay.portlet.bibbox.model.Gene;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneModelImpl;

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
 * The persistence implementation for the gene service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see GenePersistence
 * @see GeneUtil
 * @generated
 */
public class GenePersistenceImpl extends BasePersistenceImpl<Gene>
	implements GenePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeneUtil} to access the gene persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeneModelImpl.ENTITY_CACHE_ENABLED,
			GeneModelImpl.FINDER_CACHE_ENABLED, GeneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeneModelImpl.ENTITY_CACHE_ENABLED,
			GeneModelImpl.FINDER_CACHE_ENABLED, GeneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeneModelImpl.ENTITY_CACHE_ENABLED,
			GeneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GenePersistenceImpl() {
		setModelClass(Gene.class);
	}

	/**
	 * Caches the gene in the entity cache if it is enabled.
	 *
	 * @param gene the gene
	 */
	@Override
	public void cacheResult(Gene gene) {
		EntityCacheUtil.putResult(GeneModelImpl.ENTITY_CACHE_ENABLED,
			GeneImpl.class, gene.getPrimaryKey(), gene);

		gene.resetOriginalValues();
	}

	/**
	 * Caches the genes in the entity cache if it is enabled.
	 *
	 * @param genes the genes
	 */
	@Override
	public void cacheResult(List<Gene> genes) {
		for (Gene gene : genes) {
			if (EntityCacheUtil.getResult(GeneModelImpl.ENTITY_CACHE_ENABLED,
						GeneImpl.class, gene.getPrimaryKey()) == null) {
				cacheResult(gene);
			}
			else {
				gene.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all genes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GeneImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GeneImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gene.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Gene gene) {
		EntityCacheUtil.removeResult(GeneModelImpl.ENTITY_CACHE_ENABLED,
			GeneImpl.class, gene.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Gene> genes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Gene gene : genes) {
			EntityCacheUtil.removeResult(GeneModelImpl.ENTITY_CACHE_ENABLED,
				GeneImpl.class, gene.getPrimaryKey());
		}
	}

	/**
	 * Creates a new gene with the primary key. Does not add the gene to the database.
	 *
	 * @param geneId the primary key for the new gene
	 * @return the new gene
	 */
	@Override
	public Gene create(long geneId) {
		Gene gene = new GeneImpl();

		gene.setNew(true);
		gene.setPrimaryKey(geneId);

		return gene;
	}

	/**
	 * Removes the gene with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geneId the primary key of the gene
	 * @return the gene that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException if a gene with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gene remove(long geneId) throws NoSuchGeneException, SystemException {
		return remove((Serializable)geneId);
	}

	/**
	 * Removes the gene with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gene
	 * @return the gene that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException if a gene with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gene remove(Serializable primaryKey)
		throws NoSuchGeneException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Gene gene = (Gene)session.get(GeneImpl.class, primaryKey);

			if (gene == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gene);
		}
		catch (NoSuchGeneException nsee) {
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
	protected Gene removeImpl(Gene gene) throws SystemException {
		gene = toUnwrappedModel(gene);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gene)) {
				gene = (Gene)session.get(GeneImpl.class, gene.getPrimaryKeyObj());
			}

			if (gene != null) {
				session.delete(gene);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gene != null) {
			clearCache(gene);
		}

		return gene;
	}

	@Override
	public Gene updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.Gene gene)
		throws SystemException {
		gene = toUnwrappedModel(gene);

		boolean isNew = gene.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gene.isNew()) {
				session.save(gene);

				gene.setNew(false);
			}
			else {
				session.merge(gene);
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

		EntityCacheUtil.putResult(GeneModelImpl.ENTITY_CACHE_ENABLED,
			GeneImpl.class, gene.getPrimaryKey(), gene);

		return gene;
	}

	protected Gene toUnwrappedModel(Gene gene) {
		if (gene instanceof GeneImpl) {
			return gene;
		}

		GeneImpl geneImpl = new GeneImpl();

		geneImpl.setNew(gene.isNew());
		geneImpl.setPrimaryKey(gene.getPrimaryKey());

		geneImpl.setGeneId(gene.getGeneId());
		geneImpl.setOrphanetdisorderId(gene.getOrphanetdisorderId());
		geneImpl.setSymbol(gene.getSymbol());
		geneImpl.setDescription(gene.getDescription());
		geneImpl.setGeneorphanumber(gene.getGeneorphanumber());
		geneImpl.setGenetype(gene.getGenetype());
		geneImpl.setGenetypeorphanumber(gene.getGenetypeorphanumber());
		geneImpl.setGenetypename(gene.getGenetypename());
		geneImpl.setDisordergeneassociationtype(gene.getDisordergeneassociationtype());
		geneImpl.setDisordergeneassociationtypename(gene.getDisordergeneassociationtypename());
		geneImpl.setDisordergeneassociationstatus(gene.getDisordergeneassociationstatus());
		geneImpl.setDisordergeneassociationstatusname(gene.getDisordergeneassociationstatusname());

		return geneImpl;
	}

	/**
	 * Returns the gene with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the gene
	 * @return the gene
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException if a gene with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gene findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeneException, SystemException {
		Gene gene = fetchByPrimaryKey(primaryKey);

		if (gene == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gene;
	}

	/**
	 * Returns the gene with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException} if it could not be found.
	 *
	 * @param geneId the primary key of the gene
	 * @return the gene
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException if a gene with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gene findByPrimaryKey(long geneId)
		throws NoSuchGeneException, SystemException {
		return findByPrimaryKey((Serializable)geneId);
	}

	/**
	 * Returns the gene with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gene
	 * @return the gene, or <code>null</code> if a gene with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gene fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Gene gene = (Gene)EntityCacheUtil.getResult(GeneModelImpl.ENTITY_CACHE_ENABLED,
				GeneImpl.class, primaryKey);

		if (gene == _nullGene) {
			return null;
		}

		if (gene == null) {
			Session session = null;

			try {
				session = openSession();

				gene = (Gene)session.get(GeneImpl.class, primaryKey);

				if (gene != null) {
					cacheResult(gene);
				}
				else {
					EntityCacheUtil.putResult(GeneModelImpl.ENTITY_CACHE_ENABLED,
						GeneImpl.class, primaryKey, _nullGene);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GeneModelImpl.ENTITY_CACHE_ENABLED,
					GeneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gene;
	}

	/**
	 * Returns the gene with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param geneId the primary key of the gene
	 * @return the gene, or <code>null</code> if a gene with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gene fetchByPrimaryKey(long geneId) throws SystemException {
		return fetchByPrimaryKey((Serializable)geneId);
	}

	/**
	 * Returns all the genes.
	 *
	 * @return the genes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Gene> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the genes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of genes
	 * @param end the upper bound of the range of genes (not inclusive)
	 * @return the range of genes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Gene> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the genes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of genes
	 * @param end the upper bound of the range of genes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of genes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Gene> findAll(int start, int end,
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

		List<Gene> list = (List<Gene>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GENE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GENE;

				if (pagination) {
					sql = sql.concat(GeneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Gene>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Gene>(list);
				}
				else {
					list = (List<Gene>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the genes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Gene gene : findAll()) {
			remove(gene);
		}
	}

	/**
	 * Returns the number of genes.
	 *
	 * @return the number of genes
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

				Query q = session.createQuery(_SQL_COUNT_GENE);

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
	 * Initializes the gene persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.Gene")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Gene>> listenersList = new ArrayList<ModelListener<Gene>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Gene>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GeneImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GENE = "SELECT gene FROM Gene gene";
	private static final String _SQL_COUNT_GENE = "SELECT COUNT(gene) FROM Gene gene";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gene.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Gene exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GenePersistenceImpl.class);
	private static Gene _nullGene = new GeneImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Gene> toCacheModel() {
				return _nullGeneCacheModel;
			}
		};

	private static CacheModel<Gene> _nullGeneCacheModel = new CacheModel<Gene>() {
			@Override
			public Gene toEntityModel() {
				return _nullGene;
			}
		};
}