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

package at.graz.meduni.liferay.portlet.bibbox.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchidcardException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.idcard;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.idcardImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.idcardModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the idcard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see idcardPersistence
 * @see idcardUtil
 * @generated
 */
public class idcardPersistenceImpl extends BasePersistenceImpl<idcard>
	implements idcardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link idcardUtil} to access the idcard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = idcardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(idcardModelImpl.ENTITY_CACHE_ENABLED,
			idcardModelImpl.FINDER_CACHE_ENABLED, idcardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(idcardModelImpl.ENTITY_CACHE_ENABLED,
			idcardModelImpl.FINDER_CACHE_ENABLED, idcardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(idcardModelImpl.ENTITY_CACHE_ENABLED,
			idcardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public idcardPersistenceImpl() {
		setModelClass(idcard.class);
	}

	/**
	 * Caches the idcard in the entity cache if it is enabled.
	 *
	 * @param idcard the idcard
	 */
	@Override
	public void cacheResult(idcard idcard) {
		EntityCacheUtil.putResult(idcardModelImpl.ENTITY_CACHE_ENABLED,
			idcardImpl.class, idcard.getPrimaryKey(), idcard);

		idcard.resetOriginalValues();
	}

	/**
	 * Caches the idcards in the entity cache if it is enabled.
	 *
	 * @param idcards the idcards
	 */
	@Override
	public void cacheResult(List<idcard> idcards) {
		for (idcard idcard : idcards) {
			if (EntityCacheUtil.getResult(
						idcardModelImpl.ENTITY_CACHE_ENABLED, idcardImpl.class,
						idcard.getPrimaryKey()) == null) {
				cacheResult(idcard);
			}
			else {
				idcard.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all idcards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(idcardImpl.class.getName());
		}

		EntityCacheUtil.clearCache(idcardImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the idcard.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(idcard idcard) {
		EntityCacheUtil.removeResult(idcardModelImpl.ENTITY_CACHE_ENABLED,
			idcardImpl.class, idcard.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<idcard> idcards) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (idcard idcard : idcards) {
			EntityCacheUtil.removeResult(idcardModelImpl.ENTITY_CACHE_ENABLED,
				idcardImpl.class, idcard.getPrimaryKey());
		}
	}

	/**
	 * Creates a new idcard with the primary key. Does not add the idcard to the database.
	 *
	 * @param idcardId the primary key for the new idcard
	 * @return the new idcard
	 */
	@Override
	public idcard create(long idcardId) {
		idcard idcard = new idcardImpl();

		idcard.setNew(true);
		idcard.setPrimaryKey(idcardId);

		return idcard;
	}

	/**
	 * Removes the idcard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idcardId the primary key of the idcard
	 * @return the idcard that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchidcardException if a idcard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public idcard remove(long idcardId)
		throws NoSuchidcardException, SystemException {
		return remove((Serializable)idcardId);
	}

	/**
	 * Removes the idcard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the idcard
	 * @return the idcard that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchidcardException if a idcard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public idcard remove(Serializable primaryKey)
		throws NoSuchidcardException, SystemException {
		Session session = null;

		try {
			session = openSession();

			idcard idcard = (idcard)session.get(idcardImpl.class, primaryKey);

			if (idcard == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchidcardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(idcard);
		}
		catch (NoSuchidcardException nsee) {
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
	protected idcard removeImpl(idcard idcard) throws SystemException {
		idcard = toUnwrappedModel(idcard);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(idcard)) {
				idcard = (idcard)session.get(idcardImpl.class,
						idcard.getPrimaryKeyObj());
			}

			if (idcard != null) {
				session.delete(idcard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (idcard != null) {
			clearCache(idcard);
		}

		return idcard;
	}

	@Override
	public idcard updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.idcard idcard)
		throws SystemException {
		idcard = toUnwrappedModel(idcard);

		boolean isNew = idcard.isNew();

		Session session = null;

		try {
			session = openSession();

			if (idcard.isNew()) {
				session.save(idcard);

				idcard.setNew(false);
			}
			else {
				session.merge(idcard);
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

		EntityCacheUtil.putResult(idcardModelImpl.ENTITY_CACHE_ENABLED,
			idcardImpl.class, idcard.getPrimaryKey(), idcard);

		return idcard;
	}

	protected idcard toUnwrappedModel(idcard idcard) {
		if (idcard instanceof idcardImpl) {
			return idcard;
		}

		idcardImpl idcardImpl = new idcardImpl();

		idcardImpl.setNew(idcard.isNew());
		idcardImpl.setPrimaryKey(idcard.getPrimaryKey());

		idcardImpl.setIdcardId(idcard.getIdcardId());
		idcardImpl.setUserId(idcard.getUserId());
		idcardImpl.setUserip(idcard.getUserip());
		idcardImpl.setLogmsg(idcard.getLogmsg());
		idcardImpl.setDate(idcard.getDate());

		return idcardImpl;
	}

	/**
	 * Returns the idcard with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the idcard
	 * @return the idcard
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchidcardException if a idcard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public idcard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchidcardException, SystemException {
		idcard idcard = fetchByPrimaryKey(primaryKey);

		if (idcard == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchidcardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return idcard;
	}

	/**
	 * Returns the idcard with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchidcardException} if it could not be found.
	 *
	 * @param idcardId the primary key of the idcard
	 * @return the idcard
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchidcardException if a idcard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public idcard findByPrimaryKey(long idcardId)
		throws NoSuchidcardException, SystemException {
		return findByPrimaryKey((Serializable)idcardId);
	}

	/**
	 * Returns the idcard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the idcard
	 * @return the idcard, or <code>null</code> if a idcard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public idcard fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		idcard idcard = (idcard)EntityCacheUtil.getResult(idcardModelImpl.ENTITY_CACHE_ENABLED,
				idcardImpl.class, primaryKey);

		if (idcard == _nullidcard) {
			return null;
		}

		if (idcard == null) {
			Session session = null;

			try {
				session = openSession();

				idcard = (idcard)session.get(idcardImpl.class, primaryKey);

				if (idcard != null) {
					cacheResult(idcard);
				}
				else {
					EntityCacheUtil.putResult(idcardModelImpl.ENTITY_CACHE_ENABLED,
						idcardImpl.class, primaryKey, _nullidcard);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(idcardModelImpl.ENTITY_CACHE_ENABLED,
					idcardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return idcard;
	}

	/**
	 * Returns the idcard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idcardId the primary key of the idcard
	 * @return the idcard, or <code>null</code> if a idcard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public idcard fetchByPrimaryKey(long idcardId) throws SystemException {
		return fetchByPrimaryKey((Serializable)idcardId);
	}

	/**
	 * Returns all the idcards.
	 *
	 * @return the idcards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<idcard> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the idcards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.idcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of idcards
	 * @param end the upper bound of the range of idcards (not inclusive)
	 * @return the range of idcards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<idcard> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the idcards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.idcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of idcards
	 * @param end the upper bound of the range of idcards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of idcards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<idcard> findAll(int start, int end,
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

		List<idcard> list = (List<idcard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IDCARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IDCARD;

				if (pagination) {
					sql = sql.concat(idcardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<idcard>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<idcard>(list);
				}
				else {
					list = (List<idcard>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the idcards from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (idcard idcard : findAll()) {
			remove(idcard);
		}
	}

	/**
	 * Returns the number of idcards.
	 *
	 * @return the number of idcards
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

				Query q = session.createQuery(_SQL_COUNT_IDCARD);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the idcard persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.service.model.idcard")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<idcard>> listenersList = new ArrayList<ModelListener<idcard>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<idcard>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(idcardImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_IDCARD = "SELECT idcard FROM idcard idcard";
	private static final String _SQL_COUNT_IDCARD = "SELECT COUNT(idcard) FROM idcard idcard";
	private static final String _ORDER_BY_ENTITY_ALIAS = "idcard.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No idcard exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(idcardPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"date"
			});
	private static idcard _nullidcard = new idcardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<idcard> toCacheModel() {
				return _nullidcardCacheModel;
			}
		};

	private static CacheModel<idcard> _nullidcardCacheModel = new CacheModel<idcard>() {
			@Override
			public idcard toEntityModel() {
				return _nullidcard;
			}
		};
}