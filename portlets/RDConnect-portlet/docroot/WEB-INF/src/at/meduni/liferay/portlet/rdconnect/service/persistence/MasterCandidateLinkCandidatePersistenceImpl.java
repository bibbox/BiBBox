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

package at.meduni.liferay.portlet.rdconnect.service.persistence;

import at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException;
import at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate;
import at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateLinkCandidateImpl;
import at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateLinkCandidateModelImpl;

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
 * The persistence implementation for the master candidate link candidate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see MasterCandidateLinkCandidatePersistence
 * @see MasterCandidateLinkCandidateUtil
 * @generated
 */
public class MasterCandidateLinkCandidatePersistenceImpl
	extends BasePersistenceImpl<MasterCandidateLinkCandidate>
	implements MasterCandidateLinkCandidatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MasterCandidateLinkCandidateUtil} to access the master candidate link candidate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MasterCandidateLinkCandidateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MasterCandidateLinkCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateLinkCandidateModelImpl.FINDER_CACHE_ENABLED,
			MasterCandidateLinkCandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MasterCandidateLinkCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateLinkCandidateModelImpl.FINDER_CACHE_ENABLED,
			MasterCandidateLinkCandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MasterCandidateLinkCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateLinkCandidateModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public MasterCandidateLinkCandidatePersistenceImpl() {
		setModelClass(MasterCandidateLinkCandidate.class);
	}

	/**
	 * Caches the master candidate link candidate in the entity cache if it is enabled.
	 *
	 * @param masterCandidateLinkCandidate the master candidate link candidate
	 */
	@Override
	public void cacheResult(
		MasterCandidateLinkCandidate masterCandidateLinkCandidate) {
		EntityCacheUtil.putResult(MasterCandidateLinkCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateLinkCandidateImpl.class,
			masterCandidateLinkCandidate.getPrimaryKey(),
			masterCandidateLinkCandidate);

		masterCandidateLinkCandidate.resetOriginalValues();
	}

	/**
	 * Caches the master candidate link candidates in the entity cache if it is enabled.
	 *
	 * @param masterCandidateLinkCandidates the master candidate link candidates
	 */
	@Override
	public void cacheResult(
		List<MasterCandidateLinkCandidate> masterCandidateLinkCandidates) {
		for (MasterCandidateLinkCandidate masterCandidateLinkCandidate : masterCandidateLinkCandidates) {
			if (EntityCacheUtil.getResult(
						MasterCandidateLinkCandidateModelImpl.ENTITY_CACHE_ENABLED,
						MasterCandidateLinkCandidateImpl.class,
						masterCandidateLinkCandidate.getPrimaryKey()) == null) {
				cacheResult(masterCandidateLinkCandidate);
			}
			else {
				masterCandidateLinkCandidate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all master candidate link candidates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MasterCandidateLinkCandidateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MasterCandidateLinkCandidateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master candidate link candidate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		MasterCandidateLinkCandidate masterCandidateLinkCandidate) {
		EntityCacheUtil.removeResult(MasterCandidateLinkCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateLinkCandidateImpl.class,
			masterCandidateLinkCandidate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<MasterCandidateLinkCandidate> masterCandidateLinkCandidates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MasterCandidateLinkCandidate masterCandidateLinkCandidate : masterCandidateLinkCandidates) {
			EntityCacheUtil.removeResult(MasterCandidateLinkCandidateModelImpl.ENTITY_CACHE_ENABLED,
				MasterCandidateLinkCandidateImpl.class,
				masterCandidateLinkCandidate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new master candidate link candidate with the primary key. Does not add the master candidate link candidate to the database.
	 *
	 * @param linkId the primary key for the new master candidate link candidate
	 * @return the new master candidate link candidate
	 */
	@Override
	public MasterCandidateLinkCandidate create(long linkId) {
		MasterCandidateLinkCandidate masterCandidateLinkCandidate = new MasterCandidateLinkCandidateImpl();

		masterCandidateLinkCandidate.setNew(true);
		masterCandidateLinkCandidate.setPrimaryKey(linkId);

		return masterCandidateLinkCandidate;
	}

	/**
	 * Removes the master candidate link candidate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linkId the primary key of the master candidate link candidate
	 * @return the master candidate link candidate that was removed
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException if a master candidate link candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidateLinkCandidate remove(long linkId)
		throws NoSuchMasterCandidateLinkCandidateException, SystemException {
		return remove((Serializable)linkId);
	}

	/**
	 * Removes the master candidate link candidate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master candidate link candidate
	 * @return the master candidate link candidate that was removed
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException if a master candidate link candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidateLinkCandidate remove(Serializable primaryKey)
		throws NoSuchMasterCandidateLinkCandidateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MasterCandidateLinkCandidate masterCandidateLinkCandidate = (MasterCandidateLinkCandidate)session.get(MasterCandidateLinkCandidateImpl.class,
					primaryKey);

			if (masterCandidateLinkCandidate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterCandidateLinkCandidateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(masterCandidateLinkCandidate);
		}
		catch (NoSuchMasterCandidateLinkCandidateException nsee) {
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
	protected MasterCandidateLinkCandidate removeImpl(
		MasterCandidateLinkCandidate masterCandidateLinkCandidate)
		throws SystemException {
		masterCandidateLinkCandidate = toUnwrappedModel(masterCandidateLinkCandidate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterCandidateLinkCandidate)) {
				masterCandidateLinkCandidate = (MasterCandidateLinkCandidate)session.get(MasterCandidateLinkCandidateImpl.class,
						masterCandidateLinkCandidate.getPrimaryKeyObj());
			}

			if (masterCandidateLinkCandidate != null) {
				session.delete(masterCandidateLinkCandidate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (masterCandidateLinkCandidate != null) {
			clearCache(masterCandidateLinkCandidate);
		}

		return masterCandidateLinkCandidate;
	}

	@Override
	public MasterCandidateLinkCandidate updateImpl(
		at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate masterCandidateLinkCandidate)
		throws SystemException {
		masterCandidateLinkCandidate = toUnwrappedModel(masterCandidateLinkCandidate);

		boolean isNew = masterCandidateLinkCandidate.isNew();

		Session session = null;

		try {
			session = openSession();

			if (masterCandidateLinkCandidate.isNew()) {
				session.save(masterCandidateLinkCandidate);

				masterCandidateLinkCandidate.setNew(false);
			}
			else {
				session.merge(masterCandidateLinkCandidate);
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

		EntityCacheUtil.putResult(MasterCandidateLinkCandidateModelImpl.ENTITY_CACHE_ENABLED,
			MasterCandidateLinkCandidateImpl.class,
			masterCandidateLinkCandidate.getPrimaryKey(),
			masterCandidateLinkCandidate);

		return masterCandidateLinkCandidate;
	}

	protected MasterCandidateLinkCandidate toUnwrappedModel(
		MasterCandidateLinkCandidate masterCandidateLinkCandidate) {
		if (masterCandidateLinkCandidate instanceof MasterCandidateLinkCandidateImpl) {
			return masterCandidateLinkCandidate;
		}

		MasterCandidateLinkCandidateImpl masterCandidateLinkCandidateImpl = new MasterCandidateLinkCandidateImpl();

		masterCandidateLinkCandidateImpl.setNew(masterCandidateLinkCandidate.isNew());
		masterCandidateLinkCandidateImpl.setPrimaryKey(masterCandidateLinkCandidate.getPrimaryKey());

		masterCandidateLinkCandidateImpl.setLinkId(masterCandidateLinkCandidate.getLinkId());
		masterCandidateLinkCandidateImpl.setCandidateId(masterCandidateLinkCandidate.getCandidateId());
		masterCandidateLinkCandidateImpl.setMasterCandidateId(masterCandidateLinkCandidate.getMasterCandidateId());

		return masterCandidateLinkCandidateImpl;
	}

	/**
	 * Returns the master candidate link candidate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the master candidate link candidate
	 * @return the master candidate link candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException if a master candidate link candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidateLinkCandidate findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchMasterCandidateLinkCandidateException, SystemException {
		MasterCandidateLinkCandidate masterCandidateLinkCandidate = fetchByPrimaryKey(primaryKey);

		if (masterCandidateLinkCandidate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterCandidateLinkCandidateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return masterCandidateLinkCandidate;
	}

	/**
	 * Returns the master candidate link candidate with the primary key or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException} if it could not be found.
	 *
	 * @param linkId the primary key of the master candidate link candidate
	 * @return the master candidate link candidate
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException if a master candidate link candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidateLinkCandidate findByPrimaryKey(long linkId)
		throws NoSuchMasterCandidateLinkCandidateException, SystemException {
		return findByPrimaryKey((Serializable)linkId);
	}

	/**
	 * Returns the master candidate link candidate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master candidate link candidate
	 * @return the master candidate link candidate, or <code>null</code> if a master candidate link candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidateLinkCandidate fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		MasterCandidateLinkCandidate masterCandidateLinkCandidate = (MasterCandidateLinkCandidate)EntityCacheUtil.getResult(MasterCandidateLinkCandidateModelImpl.ENTITY_CACHE_ENABLED,
				MasterCandidateLinkCandidateImpl.class, primaryKey);

		if (masterCandidateLinkCandidate == _nullMasterCandidateLinkCandidate) {
			return null;
		}

		if (masterCandidateLinkCandidate == null) {
			Session session = null;

			try {
				session = openSession();

				masterCandidateLinkCandidate = (MasterCandidateLinkCandidate)session.get(MasterCandidateLinkCandidateImpl.class,
						primaryKey);

				if (masterCandidateLinkCandidate != null) {
					cacheResult(masterCandidateLinkCandidate);
				}
				else {
					EntityCacheUtil.putResult(MasterCandidateLinkCandidateModelImpl.ENTITY_CACHE_ENABLED,
						MasterCandidateLinkCandidateImpl.class, primaryKey,
						_nullMasterCandidateLinkCandidate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MasterCandidateLinkCandidateModelImpl.ENTITY_CACHE_ENABLED,
					MasterCandidateLinkCandidateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return masterCandidateLinkCandidate;
	}

	/**
	 * Returns the master candidate link candidate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linkId the primary key of the master candidate link candidate
	 * @return the master candidate link candidate, or <code>null</code> if a master candidate link candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterCandidateLinkCandidate fetchByPrimaryKey(long linkId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)linkId);
	}

	/**
	 * Returns all the master candidate link candidates.
	 *
	 * @return the master candidate link candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterCandidateLinkCandidate> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master candidate link candidates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateLinkCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of master candidate link candidates
	 * @param end the upper bound of the range of master candidate link candidates (not inclusive)
	 * @return the range of master candidate link candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterCandidateLinkCandidate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master candidate link candidates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateLinkCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of master candidate link candidates
	 * @param end the upper bound of the range of master candidate link candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master candidate link candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterCandidateLinkCandidate> findAll(int start, int end,
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

		List<MasterCandidateLinkCandidate> list = (List<MasterCandidateLinkCandidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MASTERCANDIDATELINKCANDIDATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERCANDIDATELINKCANDIDATE;

				if (pagination) {
					sql = sql.concat(MasterCandidateLinkCandidateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MasterCandidateLinkCandidate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterCandidateLinkCandidate>(list);
				}
				else {
					list = (List<MasterCandidateLinkCandidate>)QueryUtil.list(q,
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
	 * Removes all the master candidate link candidates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MasterCandidateLinkCandidate masterCandidateLinkCandidate : findAll()) {
			remove(masterCandidateLinkCandidate);
		}
	}

	/**
	 * Returns the number of master candidate link candidates.
	 *
	 * @return the number of master candidate link candidates
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

				Query q = session.createQuery(_SQL_COUNT_MASTERCANDIDATELINKCANDIDATE);

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
	 * Initializes the master candidate link candidate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MasterCandidateLinkCandidate>> listenersList = new ArrayList<ModelListener<MasterCandidateLinkCandidate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MasterCandidateLinkCandidate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MasterCandidateLinkCandidateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MASTERCANDIDATELINKCANDIDATE = "SELECT masterCandidateLinkCandidate FROM MasterCandidateLinkCandidate masterCandidateLinkCandidate";
	private static final String _SQL_COUNT_MASTERCANDIDATELINKCANDIDATE = "SELECT COUNT(masterCandidateLinkCandidate) FROM MasterCandidateLinkCandidate masterCandidateLinkCandidate";
	private static final String _ORDER_BY_ENTITY_ALIAS = "masterCandidateLinkCandidate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MasterCandidateLinkCandidate exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MasterCandidateLinkCandidatePersistenceImpl.class);
	private static MasterCandidateLinkCandidate _nullMasterCandidateLinkCandidate =
		new MasterCandidateLinkCandidateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MasterCandidateLinkCandidate> toCacheModel() {
				return _nullMasterCandidateLinkCandidateCacheModel;
			}
		};

	private static CacheModel<MasterCandidateLinkCandidate> _nullMasterCandidateLinkCandidateCacheModel =
		new CacheModel<MasterCandidateLinkCandidate>() {
			@Override
			public MasterCandidateLinkCandidate toEntityModel() {
				return _nullMasterCandidateLinkCandidate;
			}
		};
}