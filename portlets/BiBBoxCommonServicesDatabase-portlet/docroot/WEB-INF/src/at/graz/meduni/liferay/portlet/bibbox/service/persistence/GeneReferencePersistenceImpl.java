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

import at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneReferenceException;
import at.graz.meduni.liferay.portlet.bibbox.model.GeneReference;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneReferenceImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneReferenceModelImpl;

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
 * The persistence implementation for the gene reference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see GeneReferencePersistence
 * @see GeneReferenceUtil
 * @generated
 */
public class GeneReferencePersistenceImpl extends BasePersistenceImpl<GeneReference>
	implements GeneReferencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeneReferenceUtil} to access the gene reference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeneReferenceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeneReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GeneReferenceModelImpl.FINDER_CACHE_ENABLED,
			GeneReferenceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeneReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GeneReferenceModelImpl.FINDER_CACHE_ENABLED,
			GeneReferenceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeneReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GeneReferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GeneReferencePersistenceImpl() {
		setModelClass(GeneReference.class);
	}

	/**
	 * Caches the gene reference in the entity cache if it is enabled.
	 *
	 * @param geneReference the gene reference
	 */
	@Override
	public void cacheResult(GeneReference geneReference) {
		EntityCacheUtil.putResult(GeneReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GeneReferenceImpl.class, geneReference.getPrimaryKey(),
			geneReference);

		geneReference.resetOriginalValues();
	}

	/**
	 * Caches the gene references in the entity cache if it is enabled.
	 *
	 * @param geneReferences the gene references
	 */
	@Override
	public void cacheResult(List<GeneReference> geneReferences) {
		for (GeneReference geneReference : geneReferences) {
			if (EntityCacheUtil.getResult(
						GeneReferenceModelImpl.ENTITY_CACHE_ENABLED,
						GeneReferenceImpl.class, geneReference.getPrimaryKey()) == null) {
				cacheResult(geneReference);
			}
			else {
				geneReference.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gene references.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GeneReferenceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GeneReferenceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gene reference.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GeneReference geneReference) {
		EntityCacheUtil.removeResult(GeneReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GeneReferenceImpl.class, geneReference.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GeneReference> geneReferences) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GeneReference geneReference : geneReferences) {
			EntityCacheUtil.removeResult(GeneReferenceModelImpl.ENTITY_CACHE_ENABLED,
				GeneReferenceImpl.class, geneReference.getPrimaryKey());
		}
	}

	/**
	 * Creates a new gene reference with the primary key. Does not add the gene reference to the database.
	 *
	 * @param genereferenceId the primary key for the new gene reference
	 * @return the new gene reference
	 */
	@Override
	public GeneReference create(long genereferenceId) {
		GeneReference geneReference = new GeneReferenceImpl();

		geneReference.setNew(true);
		geneReference.setPrimaryKey(genereferenceId);

		return geneReference;
	}

	/**
	 * Removes the gene reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param genereferenceId the primary key of the gene reference
	 * @return the gene reference that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneReferenceException if a gene reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneReference remove(long genereferenceId)
		throws NoSuchGeneReferenceException, SystemException {
		return remove((Serializable)genereferenceId);
	}

	/**
	 * Removes the gene reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gene reference
	 * @return the gene reference that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneReferenceException if a gene reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneReference remove(Serializable primaryKey)
		throws NoSuchGeneReferenceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GeneReference geneReference = (GeneReference)session.get(GeneReferenceImpl.class,
					primaryKey);

			if (geneReference == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeneReferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(geneReference);
		}
		catch (NoSuchGeneReferenceException nsee) {
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
	protected GeneReference removeImpl(GeneReference geneReference)
		throws SystemException {
		geneReference = toUnwrappedModel(geneReference);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(geneReference)) {
				geneReference = (GeneReference)session.get(GeneReferenceImpl.class,
						geneReference.getPrimaryKeyObj());
			}

			if (geneReference != null) {
				session.delete(geneReference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (geneReference != null) {
			clearCache(geneReference);
		}

		return geneReference;
	}

	@Override
	public GeneReference updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneReference geneReference)
		throws SystemException {
		geneReference = toUnwrappedModel(geneReference);

		boolean isNew = geneReference.isNew();

		Session session = null;

		try {
			session = openSession();

			if (geneReference.isNew()) {
				session.save(geneReference);

				geneReference.setNew(false);
			}
			else {
				session.merge(geneReference);
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

		EntityCacheUtil.putResult(GeneReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GeneReferenceImpl.class, geneReference.getPrimaryKey(),
			geneReference);

		return geneReference;
	}

	protected GeneReference toUnwrappedModel(GeneReference geneReference) {
		if (geneReference instanceof GeneReferenceImpl) {
			return geneReference;
		}

		GeneReferenceImpl geneReferenceImpl = new GeneReferenceImpl();

		geneReferenceImpl.setNew(geneReference.isNew());
		geneReferenceImpl.setPrimaryKey(geneReference.getPrimaryKey());

		geneReferenceImpl.setGenereferenceId(geneReference.getGenereferenceId());
		geneReferenceImpl.setGeneId(geneReference.getGeneId());
		geneReferenceImpl.setSource(geneReference.getSource());
		geneReferenceImpl.setReference(geneReference.getReference());

		return geneReferenceImpl;
	}

	/**
	 * Returns the gene reference with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the gene reference
	 * @return the gene reference
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneReferenceException if a gene reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneReference findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeneReferenceException, SystemException {
		GeneReference geneReference = fetchByPrimaryKey(primaryKey);

		if (geneReference == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeneReferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return geneReference;
	}

	/**
	 * Returns the gene reference with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneReferenceException} if it could not be found.
	 *
	 * @param genereferenceId the primary key of the gene reference
	 * @return the gene reference
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneReferenceException if a gene reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneReference findByPrimaryKey(long genereferenceId)
		throws NoSuchGeneReferenceException, SystemException {
		return findByPrimaryKey((Serializable)genereferenceId);
	}

	/**
	 * Returns the gene reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gene reference
	 * @return the gene reference, or <code>null</code> if a gene reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneReference fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GeneReference geneReference = (GeneReference)EntityCacheUtil.getResult(GeneReferenceModelImpl.ENTITY_CACHE_ENABLED,
				GeneReferenceImpl.class, primaryKey);

		if (geneReference == _nullGeneReference) {
			return null;
		}

		if (geneReference == null) {
			Session session = null;

			try {
				session = openSession();

				geneReference = (GeneReference)session.get(GeneReferenceImpl.class,
						primaryKey);

				if (geneReference != null) {
					cacheResult(geneReference);
				}
				else {
					EntityCacheUtil.putResult(GeneReferenceModelImpl.ENTITY_CACHE_ENABLED,
						GeneReferenceImpl.class, primaryKey, _nullGeneReference);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GeneReferenceModelImpl.ENTITY_CACHE_ENABLED,
					GeneReferenceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return geneReference;
	}

	/**
	 * Returns the gene reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param genereferenceId the primary key of the gene reference
	 * @return the gene reference, or <code>null</code> if a gene reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneReference fetchByPrimaryKey(long genereferenceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)genereferenceId);
	}

	/**
	 * Returns all the gene references.
	 *
	 * @return the gene references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneReference> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the gene references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gene references
	 * @param end the upper bound of the range of gene references (not inclusive)
	 * @return the range of gene references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneReference> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the gene references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gene references
	 * @param end the upper bound of the range of gene references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gene references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneReference> findAll(int start, int end,
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

		List<GeneReference> list = (List<GeneReference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GENEREFERENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GENEREFERENCE;

				if (pagination) {
					sql = sql.concat(GeneReferenceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GeneReference>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeneReference>(list);
				}
				else {
					list = (List<GeneReference>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the gene references from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GeneReference geneReference : findAll()) {
			remove(geneReference);
		}
	}

	/**
	 * Returns the number of gene references.
	 *
	 * @return the number of gene references
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

				Query q = session.createQuery(_SQL_COUNT_GENEREFERENCE);

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
	 * Initializes the gene reference persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.GeneReference")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GeneReference>> listenersList = new ArrayList<ModelListener<GeneReference>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GeneReference>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GeneReferenceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GENEREFERENCE = "SELECT geneReference FROM GeneReference geneReference";
	private static final String _SQL_COUNT_GENEREFERENCE = "SELECT COUNT(geneReference) FROM GeneReference geneReference";
	private static final String _ORDER_BY_ENTITY_ALIAS = "geneReference.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GeneReference exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GeneReferencePersistenceImpl.class);
	private static GeneReference _nullGeneReference = new GeneReferenceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GeneReference> toCacheModel() {
				return _nullGeneReferenceCacheModel;
			}
		};

	private static CacheModel<GeneReference> _nullGeneReferenceCacheModel = new CacheModel<GeneReference>() {
			@Override
			public GeneReference toEntityModel() {
				return _nullGeneReference;
			}
		};
}