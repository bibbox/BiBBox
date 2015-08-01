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

package at.graz.hmmc.liferay.portlet.puch.service.persistence;

import at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException;
import at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt;
import at.graz.hmmc.liferay.portlet.puch.model.impl.PuchMuseumsObjektImpl;
import at.graz.hmmc.liferay.portlet.puch.model.impl.PuchMuseumsObjektModelImpl;

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
 * The persistence implementation for the puch museums objekt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see PuchMuseumsObjektPersistence
 * @see PuchMuseumsObjektUtil
 * @generated
 */
public class PuchMuseumsObjektPersistenceImpl extends BasePersistenceImpl<PuchMuseumsObjekt>
	implements PuchMuseumsObjektPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PuchMuseumsObjektUtil} to access the puch museums objekt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PuchMuseumsObjektImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PuchMuseumsObjektModelImpl.ENTITY_CACHE_ENABLED,
			PuchMuseumsObjektModelImpl.FINDER_CACHE_ENABLED,
			PuchMuseumsObjektImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PuchMuseumsObjektModelImpl.ENTITY_CACHE_ENABLED,
			PuchMuseumsObjektModelImpl.FINDER_CACHE_ENABLED,
			PuchMuseumsObjektImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PuchMuseumsObjektModelImpl.ENTITY_CACHE_ENABLED,
			PuchMuseumsObjektModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PuchMuseumsObjektPersistenceImpl() {
		setModelClass(PuchMuseumsObjekt.class);
	}

	/**
	 * Caches the puch museums objekt in the entity cache if it is enabled.
	 *
	 * @param puchMuseumsObjekt the puch museums objekt
	 */
	@Override
	public void cacheResult(PuchMuseumsObjekt puchMuseumsObjekt) {
		EntityCacheUtil.putResult(PuchMuseumsObjektModelImpl.ENTITY_CACHE_ENABLED,
			PuchMuseumsObjektImpl.class, puchMuseumsObjekt.getPrimaryKey(),
			puchMuseumsObjekt);

		puchMuseumsObjekt.resetOriginalValues();
	}

	/**
	 * Caches the puch museums objekts in the entity cache if it is enabled.
	 *
	 * @param puchMuseumsObjekts the puch museums objekts
	 */
	@Override
	public void cacheResult(List<PuchMuseumsObjekt> puchMuseumsObjekts) {
		for (PuchMuseumsObjekt puchMuseumsObjekt : puchMuseumsObjekts) {
			if (EntityCacheUtil.getResult(
						PuchMuseumsObjektModelImpl.ENTITY_CACHE_ENABLED,
						PuchMuseumsObjektImpl.class,
						puchMuseumsObjekt.getPrimaryKey()) == null) {
				cacheResult(puchMuseumsObjekt);
			}
			else {
				puchMuseumsObjekt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all puch museums objekts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PuchMuseumsObjektImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PuchMuseumsObjektImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the puch museums objekt.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PuchMuseumsObjekt puchMuseumsObjekt) {
		EntityCacheUtil.removeResult(PuchMuseumsObjektModelImpl.ENTITY_CACHE_ENABLED,
			PuchMuseumsObjektImpl.class, puchMuseumsObjekt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PuchMuseumsObjekt> puchMuseumsObjekts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PuchMuseumsObjekt puchMuseumsObjekt : puchMuseumsObjekts) {
			EntityCacheUtil.removeResult(PuchMuseumsObjektModelImpl.ENTITY_CACHE_ENABLED,
				PuchMuseumsObjektImpl.class, puchMuseumsObjekt.getPrimaryKey());
		}
	}

	/**
	 * Creates a new puch museums objekt with the primary key. Does not add the puch museums objekt to the database.
	 *
	 * @param puchmuseumsobjectId the primary key for the new puch museums objekt
	 * @return the new puch museums objekt
	 */
	@Override
	public PuchMuseumsObjekt create(long puchmuseumsobjectId) {
		PuchMuseumsObjekt puchMuseumsObjekt = new PuchMuseumsObjektImpl();

		puchMuseumsObjekt.setNew(true);
		puchMuseumsObjekt.setPrimaryKey(puchmuseumsobjectId);

		return puchMuseumsObjekt;
	}

	/**
	 * Removes the puch museums objekt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param puchmuseumsobjectId the primary key of the puch museums objekt
	 * @return the puch museums objekt that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException if a puch museums objekt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PuchMuseumsObjekt remove(long puchmuseumsobjectId)
		throws NoSuchPuchMuseumsObjektException, SystemException {
		return remove((Serializable)puchmuseumsobjectId);
	}

	/**
	 * Removes the puch museums objekt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the puch museums objekt
	 * @return the puch museums objekt that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException if a puch museums objekt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PuchMuseumsObjekt remove(Serializable primaryKey)
		throws NoSuchPuchMuseumsObjektException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PuchMuseumsObjekt puchMuseumsObjekt = (PuchMuseumsObjekt)session.get(PuchMuseumsObjektImpl.class,
					primaryKey);

			if (puchMuseumsObjekt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPuchMuseumsObjektException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(puchMuseumsObjekt);
		}
		catch (NoSuchPuchMuseumsObjektException nsee) {
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
	protected PuchMuseumsObjekt removeImpl(PuchMuseumsObjekt puchMuseumsObjekt)
		throws SystemException {
		puchMuseumsObjekt = toUnwrappedModel(puchMuseumsObjekt);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(puchMuseumsObjekt)) {
				puchMuseumsObjekt = (PuchMuseumsObjekt)session.get(PuchMuseumsObjektImpl.class,
						puchMuseumsObjekt.getPrimaryKeyObj());
			}

			if (puchMuseumsObjekt != null) {
				session.delete(puchMuseumsObjekt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (puchMuseumsObjekt != null) {
			clearCache(puchMuseumsObjekt);
		}

		return puchMuseumsObjekt;
	}

	@Override
	public PuchMuseumsObjekt updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt puchMuseumsObjekt)
		throws SystemException {
		puchMuseumsObjekt = toUnwrappedModel(puchMuseumsObjekt);

		boolean isNew = puchMuseumsObjekt.isNew();

		Session session = null;

		try {
			session = openSession();

			if (puchMuseumsObjekt.isNew()) {
				session.save(puchMuseumsObjekt);

				puchMuseumsObjekt.setNew(false);
			}
			else {
				session.merge(puchMuseumsObjekt);
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

		EntityCacheUtil.putResult(PuchMuseumsObjektModelImpl.ENTITY_CACHE_ENABLED,
			PuchMuseumsObjektImpl.class, puchMuseumsObjekt.getPrimaryKey(),
			puchMuseumsObjekt);

		return puchMuseumsObjekt;
	}

	protected PuchMuseumsObjekt toUnwrappedModel(
		PuchMuseumsObjekt puchMuseumsObjekt) {
		if (puchMuseumsObjekt instanceof PuchMuseumsObjektImpl) {
			return puchMuseumsObjekt;
		}

		PuchMuseumsObjektImpl puchMuseumsObjektImpl = new PuchMuseumsObjektImpl();

		puchMuseumsObjektImpl.setNew(puchMuseumsObjekt.isNew());
		puchMuseumsObjektImpl.setPrimaryKey(puchMuseumsObjekt.getPrimaryKey());

		puchMuseumsObjektImpl.setPuchmuseumsobjectId(puchMuseumsObjekt.getPuchmuseumsobjectId());
		puchMuseumsObjektImpl.setCreaterUserId(puchMuseumsObjekt.getCreaterUserId());
		puchMuseumsObjektImpl.setCreateDate(puchMuseumsObjekt.getCreateDate());
		puchMuseumsObjektImpl.setModifiedUserId(puchMuseumsObjekt.getModifiedUserId());
		puchMuseumsObjektImpl.setModifiedDate(puchMuseumsObjekt.getModifiedDate());
		puchMuseumsObjektImpl.setObjekttyp(puchMuseumsObjekt.getObjekttyp());
		puchMuseumsObjektImpl.setObjektid(puchMuseumsObjekt.getObjektid());
		puchMuseumsObjektImpl.setFolder(puchMuseumsObjekt.getFolder());

		return puchMuseumsObjektImpl;
	}

	/**
	 * Returns the puch museums objekt with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the puch museums objekt
	 * @return the puch museums objekt
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException if a puch museums objekt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PuchMuseumsObjekt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPuchMuseumsObjektException, SystemException {
		PuchMuseumsObjekt puchMuseumsObjekt = fetchByPrimaryKey(primaryKey);

		if (puchMuseumsObjekt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPuchMuseumsObjektException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return puchMuseumsObjekt;
	}

	/**
	 * Returns the puch museums objekt with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException} if it could not be found.
	 *
	 * @param puchmuseumsobjectId the primary key of the puch museums objekt
	 * @return the puch museums objekt
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException if a puch museums objekt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PuchMuseumsObjekt findByPrimaryKey(long puchmuseumsobjectId)
		throws NoSuchPuchMuseumsObjektException, SystemException {
		return findByPrimaryKey((Serializable)puchmuseumsobjectId);
	}

	/**
	 * Returns the puch museums objekt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the puch museums objekt
	 * @return the puch museums objekt, or <code>null</code> if a puch museums objekt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PuchMuseumsObjekt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PuchMuseumsObjekt puchMuseumsObjekt = (PuchMuseumsObjekt)EntityCacheUtil.getResult(PuchMuseumsObjektModelImpl.ENTITY_CACHE_ENABLED,
				PuchMuseumsObjektImpl.class, primaryKey);

		if (puchMuseumsObjekt == _nullPuchMuseumsObjekt) {
			return null;
		}

		if (puchMuseumsObjekt == null) {
			Session session = null;

			try {
				session = openSession();

				puchMuseumsObjekt = (PuchMuseumsObjekt)session.get(PuchMuseumsObjektImpl.class,
						primaryKey);

				if (puchMuseumsObjekt != null) {
					cacheResult(puchMuseumsObjekt);
				}
				else {
					EntityCacheUtil.putResult(PuchMuseumsObjektModelImpl.ENTITY_CACHE_ENABLED,
						PuchMuseumsObjektImpl.class, primaryKey,
						_nullPuchMuseumsObjekt);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PuchMuseumsObjektModelImpl.ENTITY_CACHE_ENABLED,
					PuchMuseumsObjektImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return puchMuseumsObjekt;
	}

	/**
	 * Returns the puch museums objekt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param puchmuseumsobjectId the primary key of the puch museums objekt
	 * @return the puch museums objekt, or <code>null</code> if a puch museums objekt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PuchMuseumsObjekt fetchByPrimaryKey(long puchmuseumsobjectId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)puchmuseumsobjectId);
	}

	/**
	 * Returns all the puch museums objekts.
	 *
	 * @return the puch museums objekts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PuchMuseumsObjekt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the puch museums objekts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PuchMuseumsObjektModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of puch museums objekts
	 * @param end the upper bound of the range of puch museums objekts (not inclusive)
	 * @return the range of puch museums objekts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PuchMuseumsObjekt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the puch museums objekts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PuchMuseumsObjektModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of puch museums objekts
	 * @param end the upper bound of the range of puch museums objekts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of puch museums objekts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PuchMuseumsObjekt> findAll(int start, int end,
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

		List<PuchMuseumsObjekt> list = (List<PuchMuseumsObjekt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUCHMUSEUMSOBJEKT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUCHMUSEUMSOBJEKT;

				if (pagination) {
					sql = sql.concat(PuchMuseumsObjektModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PuchMuseumsObjekt>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PuchMuseumsObjekt>(list);
				}
				else {
					list = (List<PuchMuseumsObjekt>)QueryUtil.list(q,
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
	 * Removes all the puch museums objekts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PuchMuseumsObjekt puchMuseumsObjekt : findAll()) {
			remove(puchMuseumsObjekt);
		}
	}

	/**
	 * Returns the number of puch museums objekts.
	 *
	 * @return the number of puch museums objekts
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

				Query q = session.createQuery(_SQL_COUNT_PUCHMUSEUMSOBJEKT);

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
	 * Initializes the puch museums objekt persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PuchMuseumsObjekt>> listenersList = new ArrayList<ModelListener<PuchMuseumsObjekt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PuchMuseumsObjekt>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PuchMuseumsObjektImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PUCHMUSEUMSOBJEKT = "SELECT puchMuseumsObjekt FROM PuchMuseumsObjekt puchMuseumsObjekt";
	private static final String _SQL_COUNT_PUCHMUSEUMSOBJEKT = "SELECT COUNT(puchMuseumsObjekt) FROM PuchMuseumsObjekt puchMuseumsObjekt";
	private static final String _ORDER_BY_ENTITY_ALIAS = "puchMuseumsObjekt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PuchMuseumsObjekt exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PuchMuseumsObjektPersistenceImpl.class);
	private static PuchMuseumsObjekt _nullPuchMuseumsObjekt = new PuchMuseumsObjektImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PuchMuseumsObjekt> toCacheModel() {
				return _nullPuchMuseumsObjektCacheModel;
			}
		};

	private static CacheModel<PuchMuseumsObjekt> _nullPuchMuseumsObjektCacheModel =
		new CacheModel<PuchMuseumsObjekt>() {
			@Override
			public PuchMuseumsObjekt toEntityModel() {
				return _nullPuchMuseumsObjekt;
			}
		};
}