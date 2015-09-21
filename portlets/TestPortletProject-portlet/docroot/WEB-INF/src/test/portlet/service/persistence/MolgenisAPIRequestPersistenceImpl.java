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

package test.portlet.service.persistence;

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

import test.portlet.NoSuchMolgenisAPIRequestException;

import test.portlet.model.MolgenisAPIRequest;
import test.portlet.model.impl.MolgenisAPIRequestImpl;
import test.portlet.model.impl.MolgenisAPIRequestModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the molgenis a p i request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see MolgenisAPIRequestPersistence
 * @see MolgenisAPIRequestUtil
 * @generated
 */
public class MolgenisAPIRequestPersistenceImpl extends BasePersistenceImpl<MolgenisAPIRequest>
	implements MolgenisAPIRequestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MolgenisAPIRequestUtil} to access the molgenis a p i request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MolgenisAPIRequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MolgenisAPIRequestModelImpl.ENTITY_CACHE_ENABLED,
			MolgenisAPIRequestModelImpl.FINDER_CACHE_ENABLED,
			MolgenisAPIRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MolgenisAPIRequestModelImpl.ENTITY_CACHE_ENABLED,
			MolgenisAPIRequestModelImpl.FINDER_CACHE_ENABLED,
			MolgenisAPIRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MolgenisAPIRequestModelImpl.ENTITY_CACHE_ENABLED,
			MolgenisAPIRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MolgenisAPIRequestPersistenceImpl() {
		setModelClass(MolgenisAPIRequest.class);
	}

	/**
	 * Caches the molgenis a p i request in the entity cache if it is enabled.
	 *
	 * @param molgenisAPIRequest the molgenis a p i request
	 */
	@Override
	public void cacheResult(MolgenisAPIRequest molgenisAPIRequest) {
		EntityCacheUtil.putResult(MolgenisAPIRequestModelImpl.ENTITY_CACHE_ENABLED,
			MolgenisAPIRequestImpl.class, molgenisAPIRequest.getPrimaryKey(),
			molgenisAPIRequest);

		molgenisAPIRequest.resetOriginalValues();
	}

	/**
	 * Caches the molgenis a p i requests in the entity cache if it is enabled.
	 *
	 * @param molgenisAPIRequests the molgenis a p i requests
	 */
	@Override
	public void cacheResult(List<MolgenisAPIRequest> molgenisAPIRequests) {
		for (MolgenisAPIRequest molgenisAPIRequest : molgenisAPIRequests) {
			if (EntityCacheUtil.getResult(
						MolgenisAPIRequestModelImpl.ENTITY_CACHE_ENABLED,
						MolgenisAPIRequestImpl.class,
						molgenisAPIRequest.getPrimaryKey()) == null) {
				cacheResult(molgenisAPIRequest);
			}
			else {
				molgenisAPIRequest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all molgenis a p i requests.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MolgenisAPIRequestImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MolgenisAPIRequestImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the molgenis a p i request.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MolgenisAPIRequest molgenisAPIRequest) {
		EntityCacheUtil.removeResult(MolgenisAPIRequestModelImpl.ENTITY_CACHE_ENABLED,
			MolgenisAPIRequestImpl.class, molgenisAPIRequest.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MolgenisAPIRequest> molgenisAPIRequests) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MolgenisAPIRequest molgenisAPIRequest : molgenisAPIRequests) {
			EntityCacheUtil.removeResult(MolgenisAPIRequestModelImpl.ENTITY_CACHE_ENABLED,
				MolgenisAPIRequestImpl.class, molgenisAPIRequest.getPrimaryKey());
		}
	}

	/**
	 * Creates a new molgenis a p i request with the primary key. Does not add the molgenis a p i request to the database.
	 *
	 * @param molgenisapirequestId the primary key for the new molgenis a p i request
	 * @return the new molgenis a p i request
	 */
	@Override
	public MolgenisAPIRequest create(long molgenisapirequestId) {
		MolgenisAPIRequest molgenisAPIRequest = new MolgenisAPIRequestImpl();

		molgenisAPIRequest.setNew(true);
		molgenisAPIRequest.setPrimaryKey(molgenisapirequestId);

		return molgenisAPIRequest;
	}

	/**
	 * Removes the molgenis a p i request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param molgenisapirequestId the primary key of the molgenis a p i request
	 * @return the molgenis a p i request that was removed
	 * @throws test.portlet.NoSuchMolgenisAPIRequestException if a molgenis a p i request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MolgenisAPIRequest remove(long molgenisapirequestId)
		throws NoSuchMolgenisAPIRequestException, SystemException {
		return remove((Serializable)molgenisapirequestId);
	}

	/**
	 * Removes the molgenis a p i request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the molgenis a p i request
	 * @return the molgenis a p i request that was removed
	 * @throws test.portlet.NoSuchMolgenisAPIRequestException if a molgenis a p i request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MolgenisAPIRequest remove(Serializable primaryKey)
		throws NoSuchMolgenisAPIRequestException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MolgenisAPIRequest molgenisAPIRequest = (MolgenisAPIRequest)session.get(MolgenisAPIRequestImpl.class,
					primaryKey);

			if (molgenisAPIRequest == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMolgenisAPIRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(molgenisAPIRequest);
		}
		catch (NoSuchMolgenisAPIRequestException nsee) {
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
	protected MolgenisAPIRequest removeImpl(
		MolgenisAPIRequest molgenisAPIRequest) throws SystemException {
		molgenisAPIRequest = toUnwrappedModel(molgenisAPIRequest);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(molgenisAPIRequest)) {
				molgenisAPIRequest = (MolgenisAPIRequest)session.get(MolgenisAPIRequestImpl.class,
						molgenisAPIRequest.getPrimaryKeyObj());
			}

			if (molgenisAPIRequest != null) {
				session.delete(molgenisAPIRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (molgenisAPIRequest != null) {
			clearCache(molgenisAPIRequest);
		}

		return molgenisAPIRequest;
	}

	@Override
	public MolgenisAPIRequest updateImpl(
		test.portlet.model.MolgenisAPIRequest molgenisAPIRequest)
		throws SystemException {
		molgenisAPIRequest = toUnwrappedModel(molgenisAPIRequest);

		boolean isNew = molgenisAPIRequest.isNew();

		Session session = null;

		try {
			session = openSession();

			if (molgenisAPIRequest.isNew()) {
				session.save(molgenisAPIRequest);

				molgenisAPIRequest.setNew(false);
			}
			else {
				session.merge(molgenisAPIRequest);
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

		EntityCacheUtil.putResult(MolgenisAPIRequestModelImpl.ENTITY_CACHE_ENABLED,
			MolgenisAPIRequestImpl.class, molgenisAPIRequest.getPrimaryKey(),
			molgenisAPIRequest);

		return molgenisAPIRequest;
	}

	protected MolgenisAPIRequest toUnwrappedModel(
		MolgenisAPIRequest molgenisAPIRequest) {
		if (molgenisAPIRequest instanceof MolgenisAPIRequestImpl) {
			return molgenisAPIRequest;
		}

		MolgenisAPIRequestImpl molgenisAPIRequestImpl = new MolgenisAPIRequestImpl();

		molgenisAPIRequestImpl.setNew(molgenisAPIRequest.isNew());
		molgenisAPIRequestImpl.setPrimaryKey(molgenisAPIRequest.getPrimaryKey());

		molgenisAPIRequestImpl.setMolgenisapirequestId(molgenisAPIRequest.getMolgenisapirequestId());

		return molgenisAPIRequestImpl;
	}

	/**
	 * Returns the molgenis a p i request with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the molgenis a p i request
	 * @return the molgenis a p i request
	 * @throws test.portlet.NoSuchMolgenisAPIRequestException if a molgenis a p i request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MolgenisAPIRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMolgenisAPIRequestException, SystemException {
		MolgenisAPIRequest molgenisAPIRequest = fetchByPrimaryKey(primaryKey);

		if (molgenisAPIRequest == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMolgenisAPIRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return molgenisAPIRequest;
	}

	/**
	 * Returns the molgenis a p i request with the primary key or throws a {@link test.portlet.NoSuchMolgenisAPIRequestException} if it could not be found.
	 *
	 * @param molgenisapirequestId the primary key of the molgenis a p i request
	 * @return the molgenis a p i request
	 * @throws test.portlet.NoSuchMolgenisAPIRequestException if a molgenis a p i request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MolgenisAPIRequest findByPrimaryKey(long molgenisapirequestId)
		throws NoSuchMolgenisAPIRequestException, SystemException {
		return findByPrimaryKey((Serializable)molgenisapirequestId);
	}

	/**
	 * Returns the molgenis a p i request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the molgenis a p i request
	 * @return the molgenis a p i request, or <code>null</code> if a molgenis a p i request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MolgenisAPIRequest fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MolgenisAPIRequest molgenisAPIRequest = (MolgenisAPIRequest)EntityCacheUtil.getResult(MolgenisAPIRequestModelImpl.ENTITY_CACHE_ENABLED,
				MolgenisAPIRequestImpl.class, primaryKey);

		if (molgenisAPIRequest == _nullMolgenisAPIRequest) {
			return null;
		}

		if (molgenisAPIRequest == null) {
			Session session = null;

			try {
				session = openSession();

				molgenisAPIRequest = (MolgenisAPIRequest)session.get(MolgenisAPIRequestImpl.class,
						primaryKey);

				if (molgenisAPIRequest != null) {
					cacheResult(molgenisAPIRequest);
				}
				else {
					EntityCacheUtil.putResult(MolgenisAPIRequestModelImpl.ENTITY_CACHE_ENABLED,
						MolgenisAPIRequestImpl.class, primaryKey,
						_nullMolgenisAPIRequest);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MolgenisAPIRequestModelImpl.ENTITY_CACHE_ENABLED,
					MolgenisAPIRequestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return molgenisAPIRequest;
	}

	/**
	 * Returns the molgenis a p i request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param molgenisapirequestId the primary key of the molgenis a p i request
	 * @return the molgenis a p i request, or <code>null</code> if a molgenis a p i request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MolgenisAPIRequest fetchByPrimaryKey(long molgenisapirequestId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)molgenisapirequestId);
	}

	/**
	 * Returns all the molgenis a p i requests.
	 *
	 * @return the molgenis a p i requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MolgenisAPIRequest> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the molgenis a p i requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link test.portlet.model.impl.MolgenisAPIRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of molgenis a p i requests
	 * @param end the upper bound of the range of molgenis a p i requests (not inclusive)
	 * @return the range of molgenis a p i requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MolgenisAPIRequest> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the molgenis a p i requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link test.portlet.model.impl.MolgenisAPIRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of molgenis a p i requests
	 * @param end the upper bound of the range of molgenis a p i requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of molgenis a p i requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MolgenisAPIRequest> findAll(int start, int end,
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

		List<MolgenisAPIRequest> list = (List<MolgenisAPIRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MOLGENISAPIREQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MOLGENISAPIREQUEST;

				if (pagination) {
					sql = sql.concat(MolgenisAPIRequestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MolgenisAPIRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MolgenisAPIRequest>(list);
				}
				else {
					list = (List<MolgenisAPIRequest>)QueryUtil.list(q,
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
	 * Removes all the molgenis a p i requests from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MolgenisAPIRequest molgenisAPIRequest : findAll()) {
			remove(molgenisAPIRequest);
		}
	}

	/**
	 * Returns the number of molgenis a p i requests.
	 *
	 * @return the number of molgenis a p i requests
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

				Query q = session.createQuery(_SQL_COUNT_MOLGENISAPIREQUEST);

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
	 * Initializes the molgenis a p i request persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.test.portlet.model.MolgenisAPIRequest")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MolgenisAPIRequest>> listenersList = new ArrayList<ModelListener<MolgenisAPIRequest>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MolgenisAPIRequest>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MolgenisAPIRequestImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MOLGENISAPIREQUEST = "SELECT molgenisAPIRequest FROM MolgenisAPIRequest molgenisAPIRequest";
	private static final String _SQL_COUNT_MOLGENISAPIREQUEST = "SELECT COUNT(molgenisAPIRequest) FROM MolgenisAPIRequest molgenisAPIRequest";
	private static final String _ORDER_BY_ENTITY_ALIAS = "molgenisAPIRequest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MolgenisAPIRequest exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MolgenisAPIRequestPersistenceImpl.class);
	private static MolgenisAPIRequest _nullMolgenisAPIRequest = new MolgenisAPIRequestImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MolgenisAPIRequest> toCacheModel() {
				return _nullMolgenisAPIRequestCacheModel;
			}
		};

	private static CacheModel<MolgenisAPIRequest> _nullMolgenisAPIRequestCacheModel =
		new CacheModel<MolgenisAPIRequest>() {
			@Override
			public MolgenisAPIRequest toEntityModel() {
				return _nullMolgenisAPIRequest;
			}
		};
}