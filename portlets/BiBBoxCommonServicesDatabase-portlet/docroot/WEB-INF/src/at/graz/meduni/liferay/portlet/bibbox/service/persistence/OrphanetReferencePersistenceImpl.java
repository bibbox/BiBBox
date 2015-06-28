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

import at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException;
import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl;

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
 * The persistence implementation for the orphanet reference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see OrphanetReferencePersistence
 * @see OrphanetReferenceUtil
 * @generated
 */
public class OrphanetReferencePersistenceImpl extends BasePersistenceImpl<OrphanetReference>
	implements OrphanetReferencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrphanetReferenceUtil} to access the orphanet reference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrphanetReferenceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceModelImpl.FINDER_CACHE_ENABLED,
			OrphanetReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceModelImpl.FINDER_CACHE_ENABLED,
			OrphanetReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OrphanetReferencePersistenceImpl() {
		setModelClass(OrphanetReference.class);
	}

	/**
	 * Caches the orphanet reference in the entity cache if it is enabled.
	 *
	 * @param orphanetReference the orphanet reference
	 */
	@Override
	public void cacheResult(OrphanetReference orphanetReference) {
		EntityCacheUtil.putResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceImpl.class, orphanetReference.getPrimaryKey(),
			orphanetReference);

		orphanetReference.resetOriginalValues();
	}

	/**
	 * Caches the orphanet references in the entity cache if it is enabled.
	 *
	 * @param orphanetReferences the orphanet references
	 */
	@Override
	public void cacheResult(List<OrphanetReference> orphanetReferences) {
		for (OrphanetReference orphanetReference : orphanetReferences) {
			if (EntityCacheUtil.getResult(
						OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
						OrphanetReferenceImpl.class,
						orphanetReference.getPrimaryKey()) == null) {
				cacheResult(orphanetReference);
			}
			else {
				orphanetReference.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all orphanet references.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrphanetReferenceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrphanetReferenceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the orphanet reference.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrphanetReference orphanetReference) {
		EntityCacheUtil.removeResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceImpl.class, orphanetReference.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OrphanetReference> orphanetReferences) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrphanetReference orphanetReference : orphanetReferences) {
			EntityCacheUtil.removeResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
				OrphanetReferenceImpl.class, orphanetReference.getPrimaryKey());
		}
	}

	/**
	 * Creates a new orphanet reference with the primary key. Does not add the orphanet reference to the database.
	 *
	 * @param orphanetreferenceId the primary key for the new orphanet reference
	 * @return the new orphanet reference
	 */
	@Override
	public OrphanetReference create(long orphanetreferenceId) {
		OrphanetReference orphanetReference = new OrphanetReferenceImpl();

		orphanetReference.setNew(true);
		orphanetReference.setPrimaryKey(orphanetreferenceId);

		return orphanetReference;
	}

	/**
	 * Removes the orphanet reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orphanetreferenceId the primary key of the orphanet reference
	 * @return the orphanet reference that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference remove(long orphanetreferenceId)
		throws NoSuchOrphanetReferenceException, SystemException {
		return remove((Serializable)orphanetreferenceId);
	}

	/**
	 * Removes the orphanet reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the orphanet reference
	 * @return the orphanet reference that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference remove(Serializable primaryKey)
		throws NoSuchOrphanetReferenceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrphanetReference orphanetReference = (OrphanetReference)session.get(OrphanetReferenceImpl.class,
					primaryKey);

			if (orphanetReference == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrphanetReferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(orphanetReference);
		}
		catch (NoSuchOrphanetReferenceException nsee) {
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
	protected OrphanetReference removeImpl(OrphanetReference orphanetReference)
		throws SystemException {
		orphanetReference = toUnwrappedModel(orphanetReference);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(orphanetReference)) {
				orphanetReference = (OrphanetReference)session.get(OrphanetReferenceImpl.class,
						orphanetReference.getPrimaryKeyObj());
			}

			if (orphanetReference != null) {
				session.delete(orphanetReference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (orphanetReference != null) {
			clearCache(orphanetReference);
		}

		return orphanetReference;
	}

	@Override
	public OrphanetReference updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference orphanetReference)
		throws SystemException {
		orphanetReference = toUnwrappedModel(orphanetReference);

		boolean isNew = orphanetReference.isNew();

		Session session = null;

		try {
			session = openSession();

			if (orphanetReference.isNew()) {
				session.save(orphanetReference);

				orphanetReference.setNew(false);
			}
			else {
				session.merge(orphanetReference);
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

		EntityCacheUtil.putResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceImpl.class, orphanetReference.getPrimaryKey(),
			orphanetReference);

		return orphanetReference;
	}

	protected OrphanetReference toUnwrappedModel(
		OrphanetReference orphanetReference) {
		if (orphanetReference instanceof OrphanetReferenceImpl) {
			return orphanetReference;
		}

		OrphanetReferenceImpl orphanetReferenceImpl = new OrphanetReferenceImpl();

		orphanetReferenceImpl.setNew(orphanetReference.isNew());
		orphanetReferenceImpl.setPrimaryKey(orphanetReference.getPrimaryKey());

		orphanetReferenceImpl.setOrphanetreferenceId(orphanetReference.getOrphanetreferenceId());
		orphanetReferenceImpl.setOrphanetdisorderId(orphanetReference.getOrphanetdisorderId());
		orphanetReferenceImpl.setSource(orphanetReference.getSource());
		orphanetReferenceImpl.setReference(orphanetReference.getReference());
		orphanetReferenceImpl.setDisordermappingrelation(orphanetReference.getDisordermappingrelation());
		orphanetReferenceImpl.setDisordermappingrelationorphanumber(orphanetReference.getDisordermappingrelationorphanumber());
		orphanetReferenceImpl.setDisordermappingrelationname(orphanetReference.getDisordermappingrelationname());
		orphanetReferenceImpl.setDisordermappingicdrelation(orphanetReference.getDisordermappingicdrelation());
		orphanetReferenceImpl.setDisordermappingicdrelationorphanumber(orphanetReference.getDisordermappingicdrelationorphanumber());
		orphanetReferenceImpl.setDisordermappingicdrelationname(orphanetReference.getDisordermappingicdrelationname());
		orphanetReferenceImpl.setDisordermappingvalidationstatus(orphanetReference.getDisordermappingvalidationstatus());
		orphanetReferenceImpl.setDisordermappingvalidationstatusorphanumber(orphanetReference.getDisordermappingvalidationstatusorphanumber());
		orphanetReferenceImpl.setDisordermappingvalidationstatusname(orphanetReference.getDisordermappingvalidationstatusname());

		return orphanetReferenceImpl;
	}

	/**
	 * Returns the orphanet reference with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the orphanet reference
	 * @return the orphanet reference
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrphanetReferenceException, SystemException {
		OrphanetReference orphanetReference = fetchByPrimaryKey(primaryKey);

		if (orphanetReference == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrphanetReferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return orphanetReference;
	}

	/**
	 * Returns the orphanet reference with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException} if it could not be found.
	 *
	 * @param orphanetreferenceId the primary key of the orphanet reference
	 * @return the orphanet reference
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference findByPrimaryKey(long orphanetreferenceId)
		throws NoSuchOrphanetReferenceException, SystemException {
		return findByPrimaryKey((Serializable)orphanetreferenceId);
	}

	/**
	 * Returns the orphanet reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the orphanet reference
	 * @return the orphanet reference, or <code>null</code> if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OrphanetReference orphanetReference = (OrphanetReference)EntityCacheUtil.getResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
				OrphanetReferenceImpl.class, primaryKey);

		if (orphanetReference == _nullOrphanetReference) {
			return null;
		}

		if (orphanetReference == null) {
			Session session = null;

			try {
				session = openSession();

				orphanetReference = (OrphanetReference)session.get(OrphanetReferenceImpl.class,
						primaryKey);

				if (orphanetReference != null) {
					cacheResult(orphanetReference);
				}
				else {
					EntityCacheUtil.putResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
						OrphanetReferenceImpl.class, primaryKey,
						_nullOrphanetReference);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
					OrphanetReferenceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return orphanetReference;
	}

	/**
	 * Returns the orphanet reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orphanetreferenceId the primary key of the orphanet reference
	 * @return the orphanet reference, or <code>null</code> if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference fetchByPrimaryKey(long orphanetreferenceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)orphanetreferenceId);
	}

	/**
	 * Returns all the orphanet references.
	 *
	 * @return the orphanet references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetReference> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the orphanet references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of orphanet references
	 * @param end the upper bound of the range of orphanet references (not inclusive)
	 * @return the range of orphanet references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetReference> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the orphanet references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of orphanet references
	 * @param end the upper bound of the range of orphanet references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of orphanet references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetReference> findAll(int start, int end,
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

		List<OrphanetReference> list = (List<OrphanetReference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORPHANETREFERENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORPHANETREFERENCE;

				if (pagination) {
					sql = sql.concat(OrphanetReferenceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OrphanetReference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrphanetReference>(list);
				}
				else {
					list = (List<OrphanetReference>)QueryUtil.list(q,
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
	 * Removes all the orphanet references from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OrphanetReference orphanetReference : findAll()) {
			remove(orphanetReference);
		}
	}

	/**
	 * Returns the number of orphanet references.
	 *
	 * @return the number of orphanet references
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

				Query q = session.createQuery(_SQL_COUNT_ORPHANETREFERENCE);

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
	 * Initializes the orphanet reference persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrphanetReference>> listenersList = new ArrayList<ModelListener<OrphanetReference>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrphanetReference>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrphanetReferenceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORPHANETREFERENCE = "SELECT orphanetReference FROM OrphanetReference orphanetReference";
	private static final String _SQL_COUNT_ORPHANETREFERENCE = "SELECT COUNT(orphanetReference) FROM OrphanetReference orphanetReference";
	private static final String _ORDER_BY_ENTITY_ALIAS = "orphanetReference.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrphanetReference exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrphanetReferencePersistenceImpl.class);
	private static OrphanetReference _nullOrphanetReference = new OrphanetReferenceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OrphanetReference> toCacheModel() {
				return _nullOrphanetReferenceCacheModel;
			}
		};

	private static CacheModel<OrphanetReference> _nullOrphanetReferenceCacheModel =
		new CacheModel<OrphanetReference>() {
			@Override
			public OrphanetReference toEntityModel() {
				return _nullOrphanetReference;
			}
		};
}