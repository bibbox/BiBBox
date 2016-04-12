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

import at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException;
import at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneLocusImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneLocusModelImpl;

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
 * The persistence implementation for the gene locus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see GeneLocusPersistence
 * @see GeneLocusUtil
 * @generated
 */
public class GeneLocusPersistenceImpl extends BasePersistenceImpl<GeneLocus>
	implements GeneLocusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeneLocusUtil} to access the gene locus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeneLocusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeneLocusModelImpl.ENTITY_CACHE_ENABLED,
			GeneLocusModelImpl.FINDER_CACHE_ENABLED, GeneLocusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeneLocusModelImpl.ENTITY_CACHE_ENABLED,
			GeneLocusModelImpl.FINDER_CACHE_ENABLED, GeneLocusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeneLocusModelImpl.ENTITY_CACHE_ENABLED,
			GeneLocusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GeneLocusPersistenceImpl() {
		setModelClass(GeneLocus.class);
	}

	/**
	 * Caches the gene locus in the entity cache if it is enabled.
	 *
	 * @param geneLocus the gene locus
	 */
	@Override
	public void cacheResult(GeneLocus geneLocus) {
		EntityCacheUtil.putResult(GeneLocusModelImpl.ENTITY_CACHE_ENABLED,
			GeneLocusImpl.class, geneLocus.getPrimaryKey(), geneLocus);

		geneLocus.resetOriginalValues();
	}

	/**
	 * Caches the gene locuses in the entity cache if it is enabled.
	 *
	 * @param geneLocuses the gene locuses
	 */
	@Override
	public void cacheResult(List<GeneLocus> geneLocuses) {
		for (GeneLocus geneLocus : geneLocuses) {
			if (EntityCacheUtil.getResult(
						GeneLocusModelImpl.ENTITY_CACHE_ENABLED,
						GeneLocusImpl.class, geneLocus.getPrimaryKey()) == null) {
				cacheResult(geneLocus);
			}
			else {
				geneLocus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gene locuses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GeneLocusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GeneLocusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gene locus.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GeneLocus geneLocus) {
		EntityCacheUtil.removeResult(GeneLocusModelImpl.ENTITY_CACHE_ENABLED,
			GeneLocusImpl.class, geneLocus.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GeneLocus> geneLocuses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GeneLocus geneLocus : geneLocuses) {
			EntityCacheUtil.removeResult(GeneLocusModelImpl.ENTITY_CACHE_ENABLED,
				GeneLocusImpl.class, geneLocus.getPrimaryKey());
		}
	}

	/**
	 * Creates a new gene locus with the primary key. Does not add the gene locus to the database.
	 *
	 * @param genelocusId the primary key for the new gene locus
	 * @return the new gene locus
	 */
	@Override
	public GeneLocus create(long genelocusId) {
		GeneLocus geneLocus = new GeneLocusImpl();

		geneLocus.setNew(true);
		geneLocus.setPrimaryKey(genelocusId);

		return geneLocus;
	}

	/**
	 * Removes the gene locus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param genelocusId the primary key of the gene locus
	 * @return the gene locus that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException if a gene locus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneLocus remove(long genelocusId)
		throws NoSuchGeneLocusException, SystemException {
		return remove((Serializable)genelocusId);
	}

	/**
	 * Removes the gene locus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gene locus
	 * @return the gene locus that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException if a gene locus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneLocus remove(Serializable primaryKey)
		throws NoSuchGeneLocusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GeneLocus geneLocus = (GeneLocus)session.get(GeneLocusImpl.class,
					primaryKey);

			if (geneLocus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeneLocusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(geneLocus);
		}
		catch (NoSuchGeneLocusException nsee) {
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
	protected GeneLocus removeImpl(GeneLocus geneLocus)
		throws SystemException {
		geneLocus = toUnwrappedModel(geneLocus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(geneLocus)) {
				geneLocus = (GeneLocus)session.get(GeneLocusImpl.class,
						geneLocus.getPrimaryKeyObj());
			}

			if (geneLocus != null) {
				session.delete(geneLocus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (geneLocus != null) {
			clearCache(geneLocus);
		}

		return geneLocus;
	}

	@Override
	public GeneLocus updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus geneLocus)
		throws SystemException {
		geneLocus = toUnwrappedModel(geneLocus);

		boolean isNew = geneLocus.isNew();

		Session session = null;

		try {
			session = openSession();

			if (geneLocus.isNew()) {
				session.save(geneLocus);

				geneLocus.setNew(false);
			}
			else {
				session.merge(geneLocus);
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

		EntityCacheUtil.putResult(GeneLocusModelImpl.ENTITY_CACHE_ENABLED,
			GeneLocusImpl.class, geneLocus.getPrimaryKey(), geneLocus);

		return geneLocus;
	}

	protected GeneLocus toUnwrappedModel(GeneLocus geneLocus) {
		if (geneLocus instanceof GeneLocusImpl) {
			return geneLocus;
		}

		GeneLocusImpl geneLocusImpl = new GeneLocusImpl();

		geneLocusImpl.setNew(geneLocus.isNew());
		geneLocusImpl.setPrimaryKey(geneLocus.getPrimaryKey());

		geneLocusImpl.setGenelocusId(geneLocus.getGenelocusId());
		geneLocusImpl.setGeneId(geneLocus.getGeneId());
		geneLocusImpl.setGenelocus(geneLocus.getGenelocus());
		geneLocusImpl.setGenelocuskey(geneLocus.getGenelocuskey());

		return geneLocusImpl;
	}

	/**
	 * Returns the gene locus with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the gene locus
	 * @return the gene locus
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException if a gene locus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneLocus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeneLocusException, SystemException {
		GeneLocus geneLocus = fetchByPrimaryKey(primaryKey);

		if (geneLocus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeneLocusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return geneLocus;
	}

	/**
	 * Returns the gene locus with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException} if it could not be found.
	 *
	 * @param genelocusId the primary key of the gene locus
	 * @return the gene locus
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException if a gene locus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneLocus findByPrimaryKey(long genelocusId)
		throws NoSuchGeneLocusException, SystemException {
		return findByPrimaryKey((Serializable)genelocusId);
	}

	/**
	 * Returns the gene locus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gene locus
	 * @return the gene locus, or <code>null</code> if a gene locus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneLocus fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GeneLocus geneLocus = (GeneLocus)EntityCacheUtil.getResult(GeneLocusModelImpl.ENTITY_CACHE_ENABLED,
				GeneLocusImpl.class, primaryKey);

		if (geneLocus == _nullGeneLocus) {
			return null;
		}

		if (geneLocus == null) {
			Session session = null;

			try {
				session = openSession();

				geneLocus = (GeneLocus)session.get(GeneLocusImpl.class,
						primaryKey);

				if (geneLocus != null) {
					cacheResult(geneLocus);
				}
				else {
					EntityCacheUtil.putResult(GeneLocusModelImpl.ENTITY_CACHE_ENABLED,
						GeneLocusImpl.class, primaryKey, _nullGeneLocus);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GeneLocusModelImpl.ENTITY_CACHE_ENABLED,
					GeneLocusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return geneLocus;
	}

	/**
	 * Returns the gene locus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param genelocusId the primary key of the gene locus
	 * @return the gene locus, or <code>null</code> if a gene locus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneLocus fetchByPrimaryKey(long genelocusId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)genelocusId);
	}

	/**
	 * Returns all the gene locuses.
	 *
	 * @return the gene locuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneLocus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the gene locuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneLocusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gene locuses
	 * @param end the upper bound of the range of gene locuses (not inclusive)
	 * @return the range of gene locuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneLocus> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the gene locuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneLocusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gene locuses
	 * @param end the upper bound of the range of gene locuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gene locuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneLocus> findAll(int start, int end,
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

		List<GeneLocus> list = (List<GeneLocus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GENELOCUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GENELOCUS;

				if (pagination) {
					sql = sql.concat(GeneLocusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GeneLocus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeneLocus>(list);
				}
				else {
					list = (List<GeneLocus>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the gene locuses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GeneLocus geneLocus : findAll()) {
			remove(geneLocus);
		}
	}

	/**
	 * Returns the number of gene locuses.
	 *
	 * @return the number of gene locuses
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

				Query q = session.createQuery(_SQL_COUNT_GENELOCUS);

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
	 * Initializes the gene locus persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GeneLocus>> listenersList = new ArrayList<ModelListener<GeneLocus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GeneLocus>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GeneLocusImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GENELOCUS = "SELECT geneLocus FROM GeneLocus geneLocus";
	private static final String _SQL_COUNT_GENELOCUS = "SELECT COUNT(geneLocus) FROM GeneLocus geneLocus";
	private static final String _ORDER_BY_ENTITY_ALIAS = "geneLocus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GeneLocus exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GeneLocusPersistenceImpl.class);
	private static GeneLocus _nullGeneLocus = new GeneLocusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GeneLocus> toCacheModel() {
				return _nullGeneLocusCacheModel;
			}
		};

	private static CacheModel<GeneLocus> _nullGeneLocusCacheModel = new CacheModel<GeneLocus>() {
			@Override
			public GeneLocus toEntityModel() {
				return _nullGeneLocus;
			}
		};
}