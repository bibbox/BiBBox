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

package com.bcnet.portlet.biobank.service.persistence;

import com.bcnet.portlet.biobank.NoSuchJuristicPersonException;
import com.bcnet.portlet.biobank.model.JuristicPerson;
import com.bcnet.portlet.biobank.model.impl.JuristicPersonImpl;
import com.bcnet.portlet.biobank.model.impl.JuristicPersonModelImpl;

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
 * The persistence implementation for the juristic person service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see JuristicPersonPersistence
 * @see JuristicPersonUtil
 * @generated
 */
public class JuristicPersonPersistenceImpl extends BasePersistenceImpl<JuristicPerson>
	implements JuristicPersonPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JuristicPersonUtil} to access the juristic person persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JuristicPersonImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JuristicPersonModelImpl.ENTITY_CACHE_ENABLED,
			JuristicPersonModelImpl.FINDER_CACHE_ENABLED,
			JuristicPersonImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JuristicPersonModelImpl.ENTITY_CACHE_ENABLED,
			JuristicPersonModelImpl.FINDER_CACHE_ENABLED,
			JuristicPersonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JuristicPersonModelImpl.ENTITY_CACHE_ENABLED,
			JuristicPersonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public JuristicPersonPersistenceImpl() {
		setModelClass(JuristicPerson.class);
	}

	/**
	 * Caches the juristic person in the entity cache if it is enabled.
	 *
	 * @param juristicPerson the juristic person
	 */
	@Override
	public void cacheResult(JuristicPerson juristicPerson) {
		EntityCacheUtil.putResult(JuristicPersonModelImpl.ENTITY_CACHE_ENABLED,
			JuristicPersonImpl.class, juristicPerson.getPrimaryKey(),
			juristicPerson);

		juristicPerson.resetOriginalValues();
	}

	/**
	 * Caches the juristic persons in the entity cache if it is enabled.
	 *
	 * @param juristicPersons the juristic persons
	 */
	@Override
	public void cacheResult(List<JuristicPerson> juristicPersons) {
		for (JuristicPerson juristicPerson : juristicPersons) {
			if (EntityCacheUtil.getResult(
						JuristicPersonModelImpl.ENTITY_CACHE_ENABLED,
						JuristicPersonImpl.class, juristicPerson.getPrimaryKey()) == null) {
				cacheResult(juristicPerson);
			}
			else {
				juristicPerson.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all juristic persons.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JuristicPersonImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JuristicPersonImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the juristic person.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JuristicPerson juristicPerson) {
		EntityCacheUtil.removeResult(JuristicPersonModelImpl.ENTITY_CACHE_ENABLED,
			JuristicPersonImpl.class, juristicPerson.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<JuristicPerson> juristicPersons) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JuristicPerson juristicPerson : juristicPersons) {
			EntityCacheUtil.removeResult(JuristicPersonModelImpl.ENTITY_CACHE_ENABLED,
				JuristicPersonImpl.class, juristicPerson.getPrimaryKey());
		}
	}

	/**
	 * Creates a new juristic person with the primary key. Does not add the juristic person to the database.
	 *
	 * @param juristicPersonId the primary key for the new juristic person
	 * @return the new juristic person
	 */
	@Override
	public JuristicPerson create(long juristicPersonId) {
		JuristicPerson juristicPerson = new JuristicPersonImpl();

		juristicPerson.setNew(true);
		juristicPerson.setPrimaryKey(juristicPersonId);

		return juristicPerson;
	}

	/**
	 * Removes the juristic person with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param juristicPersonId the primary key of the juristic person
	 * @return the juristic person that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchJuristicPersonException if a juristic person with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JuristicPerson remove(long juristicPersonId)
		throws NoSuchJuristicPersonException, SystemException {
		return remove((Serializable)juristicPersonId);
	}

	/**
	 * Removes the juristic person with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the juristic person
	 * @return the juristic person that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchJuristicPersonException if a juristic person with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JuristicPerson remove(Serializable primaryKey)
		throws NoSuchJuristicPersonException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JuristicPerson juristicPerson = (JuristicPerson)session.get(JuristicPersonImpl.class,
					primaryKey);

			if (juristicPerson == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJuristicPersonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(juristicPerson);
		}
		catch (NoSuchJuristicPersonException nsee) {
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
	protected JuristicPerson removeImpl(JuristicPerson juristicPerson)
		throws SystemException {
		juristicPerson = toUnwrappedModel(juristicPerson);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(juristicPerson)) {
				juristicPerson = (JuristicPerson)session.get(JuristicPersonImpl.class,
						juristicPerson.getPrimaryKeyObj());
			}

			if (juristicPerson != null) {
				session.delete(juristicPerson);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (juristicPerson != null) {
			clearCache(juristicPerson);
		}

		return juristicPerson;
	}

	@Override
	public JuristicPerson updateImpl(
		com.bcnet.portlet.biobank.model.JuristicPerson juristicPerson)
		throws SystemException {
		juristicPerson = toUnwrappedModel(juristicPerson);

		boolean isNew = juristicPerson.isNew();

		Session session = null;

		try {
			session = openSession();

			if (juristicPerson.isNew()) {
				session.save(juristicPerson);

				juristicPerson.setNew(false);
			}
			else {
				session.merge(juristicPerson);
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

		EntityCacheUtil.putResult(JuristicPersonModelImpl.ENTITY_CACHE_ENABLED,
			JuristicPersonImpl.class, juristicPerson.getPrimaryKey(),
			juristicPerson);

		return juristicPerson;
	}

	protected JuristicPerson toUnwrappedModel(JuristicPerson juristicPerson) {
		if (juristicPerson instanceof JuristicPersonImpl) {
			return juristicPerson;
		}

		JuristicPersonImpl juristicPersonImpl = new JuristicPersonImpl();

		juristicPersonImpl.setNew(juristicPerson.isNew());
		juristicPersonImpl.setPrimaryKey(juristicPerson.getPrimaryKey());

		juristicPersonImpl.setJuristicPersonId(juristicPerson.getJuristicPersonId());
		juristicPersonImpl.setName(juristicPerson.getName());
		juristicPersonImpl.setUrl(juristicPerson.getUrl());
		juristicPersonImpl.setAddress(juristicPerson.getAddress());

		return juristicPersonImpl;
	}

	/**
	 * Returns the juristic person with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the juristic person
	 * @return the juristic person
	 * @throws com.bcnet.portlet.biobank.NoSuchJuristicPersonException if a juristic person with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JuristicPerson findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJuristicPersonException, SystemException {
		JuristicPerson juristicPerson = fetchByPrimaryKey(primaryKey);

		if (juristicPerson == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJuristicPersonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return juristicPerson;
	}

	/**
	 * Returns the juristic person with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchJuristicPersonException} if it could not be found.
	 *
	 * @param juristicPersonId the primary key of the juristic person
	 * @return the juristic person
	 * @throws com.bcnet.portlet.biobank.NoSuchJuristicPersonException if a juristic person with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JuristicPerson findByPrimaryKey(long juristicPersonId)
		throws NoSuchJuristicPersonException, SystemException {
		return findByPrimaryKey((Serializable)juristicPersonId);
	}

	/**
	 * Returns the juristic person with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the juristic person
	 * @return the juristic person, or <code>null</code> if a juristic person with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JuristicPerson fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		JuristicPerson juristicPerson = (JuristicPerson)EntityCacheUtil.getResult(JuristicPersonModelImpl.ENTITY_CACHE_ENABLED,
				JuristicPersonImpl.class, primaryKey);

		if (juristicPerson == _nullJuristicPerson) {
			return null;
		}

		if (juristicPerson == null) {
			Session session = null;

			try {
				session = openSession();

				juristicPerson = (JuristicPerson)session.get(JuristicPersonImpl.class,
						primaryKey);

				if (juristicPerson != null) {
					cacheResult(juristicPerson);
				}
				else {
					EntityCacheUtil.putResult(JuristicPersonModelImpl.ENTITY_CACHE_ENABLED,
						JuristicPersonImpl.class, primaryKey,
						_nullJuristicPerson);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JuristicPersonModelImpl.ENTITY_CACHE_ENABLED,
					JuristicPersonImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return juristicPerson;
	}

	/**
	 * Returns the juristic person with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param juristicPersonId the primary key of the juristic person
	 * @return the juristic person, or <code>null</code> if a juristic person with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JuristicPerson fetchByPrimaryKey(long juristicPersonId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)juristicPersonId);
	}

	/**
	 * Returns all the juristic persons.
	 *
	 * @return the juristic persons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JuristicPerson> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the juristic persons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.JuristicPersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of juristic persons
	 * @param end the upper bound of the range of juristic persons (not inclusive)
	 * @return the range of juristic persons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JuristicPerson> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the juristic persons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.JuristicPersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of juristic persons
	 * @param end the upper bound of the range of juristic persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of juristic persons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JuristicPerson> findAll(int start, int end,
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

		List<JuristicPerson> list = (List<JuristicPerson>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JURISTICPERSON);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JURISTICPERSON;

				if (pagination) {
					sql = sql.concat(JuristicPersonModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JuristicPerson>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JuristicPerson>(list);
				}
				else {
					list = (List<JuristicPerson>)QueryUtil.list(q,
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
	 * Removes all the juristic persons from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (JuristicPerson juristicPerson : findAll()) {
			remove(juristicPerson);
		}
	}

	/**
	 * Returns the number of juristic persons.
	 *
	 * @return the number of juristic persons
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

				Query q = session.createQuery(_SQL_COUNT_JURISTICPERSON);

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
	 * Initializes the juristic person persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.JuristicPerson")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JuristicPerson>> listenersList = new ArrayList<ModelListener<JuristicPerson>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JuristicPerson>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JuristicPersonImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JURISTICPERSON = "SELECT juristicPerson FROM JuristicPerson juristicPerson";
	private static final String _SQL_COUNT_JURISTICPERSON = "SELECT COUNT(juristicPerson) FROM JuristicPerson juristicPerson";
	private static final String _ORDER_BY_ENTITY_ALIAS = "juristicPerson.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JuristicPerson exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JuristicPersonPersistenceImpl.class);
	private static JuristicPerson _nullJuristicPerson = new JuristicPersonImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JuristicPerson> toCacheModel() {
				return _nullJuristicPersonCacheModel;
			}
		};

	private static CacheModel<JuristicPerson> _nullJuristicPersonCacheModel = new CacheModel<JuristicPerson>() {
			@Override
			public JuristicPerson toEntityModel() {
				return _nullJuristicPerson;
			}
		};
}