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

import com.bcnet.portlet.biobank.NoSuchBiobankContactException;
import com.bcnet.portlet.biobank.model.BiobankContact;
import com.bcnet.portlet.biobank.model.impl.BiobankContactImpl;
import com.bcnet.portlet.biobank.model.impl.BiobankContactModelImpl;

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
 * The persistence implementation for the biobank contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankContactPersistence
 * @see BiobankContactUtil
 * @generated
 */
public class BiobankContactPersistenceImpl extends BasePersistenceImpl<BiobankContact>
	implements BiobankContactPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BiobankContactUtil} to access the biobank contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BiobankContactImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BiobankContactModelImpl.ENTITY_CACHE_ENABLED,
			BiobankContactModelImpl.FINDER_CACHE_ENABLED,
			BiobankContactImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BiobankContactModelImpl.ENTITY_CACHE_ENABLED,
			BiobankContactModelImpl.FINDER_CACHE_ENABLED,
			BiobankContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BiobankContactModelImpl.ENTITY_CACHE_ENABLED,
			BiobankContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BiobankContactPersistenceImpl() {
		setModelClass(BiobankContact.class);
	}

	/**
	 * Caches the biobank contact in the entity cache if it is enabled.
	 *
	 * @param biobankContact the biobank contact
	 */
	@Override
	public void cacheResult(BiobankContact biobankContact) {
		EntityCacheUtil.putResult(BiobankContactModelImpl.ENTITY_CACHE_ENABLED,
			BiobankContactImpl.class, biobankContact.getPrimaryKey(),
			biobankContact);

		biobankContact.resetOriginalValues();
	}

	/**
	 * Caches the biobank contacts in the entity cache if it is enabled.
	 *
	 * @param biobankContacts the biobank contacts
	 */
	@Override
	public void cacheResult(List<BiobankContact> biobankContacts) {
		for (BiobankContact biobankContact : biobankContacts) {
			if (EntityCacheUtil.getResult(
						BiobankContactModelImpl.ENTITY_CACHE_ENABLED,
						BiobankContactImpl.class, biobankContact.getPrimaryKey()) == null) {
				cacheResult(biobankContact);
			}
			else {
				biobankContact.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all biobank contacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BiobankContactImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BiobankContactImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the biobank contact.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BiobankContact biobankContact) {
		EntityCacheUtil.removeResult(BiobankContactModelImpl.ENTITY_CACHE_ENABLED,
			BiobankContactImpl.class, biobankContact.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BiobankContact> biobankContacts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BiobankContact biobankContact : biobankContacts) {
			EntityCacheUtil.removeResult(BiobankContactModelImpl.ENTITY_CACHE_ENABLED,
				BiobankContactImpl.class, biobankContact.getPrimaryKey());
		}
	}

	/**
	 * Creates a new biobank contact with the primary key. Does not add the biobank contact to the database.
	 *
	 * @param biobankContactPK the primary key for the new biobank contact
	 * @return the new biobank contact
	 */
	@Override
	public BiobankContact create(BiobankContactPK biobankContactPK) {
		BiobankContact biobankContact = new BiobankContactImpl();

		biobankContact.setNew(true);
		biobankContact.setPrimaryKey(biobankContactPK);

		return biobankContact;
	}

	/**
	 * Removes the biobank contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param biobankContactPK the primary key of the biobank contact
	 * @return the biobank contact that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankContactException if a biobank contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankContact remove(BiobankContactPK biobankContactPK)
		throws NoSuchBiobankContactException, SystemException {
		return remove((Serializable)biobankContactPK);
	}

	/**
	 * Removes the biobank contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the biobank contact
	 * @return the biobank contact that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankContactException if a biobank contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankContact remove(Serializable primaryKey)
		throws NoSuchBiobankContactException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BiobankContact biobankContact = (BiobankContact)session.get(BiobankContactImpl.class,
					primaryKey);

			if (biobankContact == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBiobankContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(biobankContact);
		}
		catch (NoSuchBiobankContactException nsee) {
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
	protected BiobankContact removeImpl(BiobankContact biobankContact)
		throws SystemException {
		biobankContact = toUnwrappedModel(biobankContact);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(biobankContact)) {
				biobankContact = (BiobankContact)session.get(BiobankContactImpl.class,
						biobankContact.getPrimaryKeyObj());
			}

			if (biobankContact != null) {
				session.delete(biobankContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (biobankContact != null) {
			clearCache(biobankContact);
		}

		return biobankContact;
	}

	@Override
	public BiobankContact updateImpl(
		com.bcnet.portlet.biobank.model.BiobankContact biobankContact)
		throws SystemException {
		biobankContact = toUnwrappedModel(biobankContact);

		boolean isNew = biobankContact.isNew();

		Session session = null;

		try {
			session = openSession();

			if (biobankContact.isNew()) {
				session.save(biobankContact);

				biobankContact.setNew(false);
			}
			else {
				session.merge(biobankContact);
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

		EntityCacheUtil.putResult(BiobankContactModelImpl.ENTITY_CACHE_ENABLED,
			BiobankContactImpl.class, biobankContact.getPrimaryKey(),
			biobankContact);

		return biobankContact;
	}

	protected BiobankContact toUnwrappedModel(BiobankContact biobankContact) {
		if (biobankContact instanceof BiobankContactImpl) {
			return biobankContact;
		}

		BiobankContactImpl biobankContactImpl = new BiobankContactImpl();

		biobankContactImpl.setNew(biobankContact.isNew());
		biobankContactImpl.setPrimaryKey(biobankContact.getPrimaryKey());

		biobankContactImpl.setBiobankDbId(biobankContact.getBiobankDbId());
		biobankContactImpl.setContactId(biobankContact.getContactId());

		return biobankContactImpl;
	}

	/**
	 * Returns the biobank contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank contact
	 * @return the biobank contact
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankContactException if a biobank contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankContact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBiobankContactException, SystemException {
		BiobankContact biobankContact = fetchByPrimaryKey(primaryKey);

		if (biobankContact == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBiobankContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return biobankContact;
	}

	/**
	 * Returns the biobank contact with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankContactException} if it could not be found.
	 *
	 * @param biobankContactPK the primary key of the biobank contact
	 * @return the biobank contact
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankContactException if a biobank contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankContact findByPrimaryKey(BiobankContactPK biobankContactPK)
		throws NoSuchBiobankContactException, SystemException {
		return findByPrimaryKey((Serializable)biobankContactPK);
	}

	/**
	 * Returns the biobank contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank contact
	 * @return the biobank contact, or <code>null</code> if a biobank contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankContact fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BiobankContact biobankContact = (BiobankContact)EntityCacheUtil.getResult(BiobankContactModelImpl.ENTITY_CACHE_ENABLED,
				BiobankContactImpl.class, primaryKey);

		if (biobankContact == _nullBiobankContact) {
			return null;
		}

		if (biobankContact == null) {
			Session session = null;

			try {
				session = openSession();

				biobankContact = (BiobankContact)session.get(BiobankContactImpl.class,
						primaryKey);

				if (biobankContact != null) {
					cacheResult(biobankContact);
				}
				else {
					EntityCacheUtil.putResult(BiobankContactModelImpl.ENTITY_CACHE_ENABLED,
						BiobankContactImpl.class, primaryKey,
						_nullBiobankContact);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BiobankContactModelImpl.ENTITY_CACHE_ENABLED,
					BiobankContactImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return biobankContact;
	}

	/**
	 * Returns the biobank contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param biobankContactPK the primary key of the biobank contact
	 * @return the biobank contact, or <code>null</code> if a biobank contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankContact fetchByPrimaryKey(BiobankContactPK biobankContactPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)biobankContactPK);
	}

	/**
	 * Returns all the biobank contacts.
	 *
	 * @return the biobank contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankContact> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the biobank contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of biobank contacts
	 * @param end the upper bound of the range of biobank contacts (not inclusive)
	 * @return the range of biobank contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankContact> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the biobank contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of biobank contacts
	 * @param end the upper bound of the range of biobank contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of biobank contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankContact> findAll(int start, int end,
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

		List<BiobankContact> list = (List<BiobankContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BIOBANKCONTACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BIOBANKCONTACT;

				if (pagination) {
					sql = sql.concat(BiobankContactModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BiobankContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BiobankContact>(list);
				}
				else {
					list = (List<BiobankContact>)QueryUtil.list(q,
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
	 * Removes all the biobank contacts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BiobankContact biobankContact : findAll()) {
			remove(biobankContact);
		}
	}

	/**
	 * Returns the number of biobank contacts.
	 *
	 * @return the number of biobank contacts
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

				Query q = session.createQuery(_SQL_COUNT_BIOBANKCONTACT);

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
	 * Initializes the biobank contact persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.BiobankContact")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BiobankContact>> listenersList = new ArrayList<ModelListener<BiobankContact>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BiobankContact>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BiobankContactImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BIOBANKCONTACT = "SELECT biobankContact FROM BiobankContact biobankContact";
	private static final String _SQL_COUNT_BIOBANKCONTACT = "SELECT COUNT(biobankContact) FROM BiobankContact biobankContact";
	private static final String _ORDER_BY_ENTITY_ALIAS = "biobankContact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BiobankContact exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BiobankContactPersistenceImpl.class);
	private static BiobankContact _nullBiobankContact = new BiobankContactImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BiobankContact> toCacheModel() {
				return _nullBiobankContactCacheModel;
			}
		};

	private static CacheModel<BiobankContact> _nullBiobankContactCacheModel = new CacheModel<BiobankContact>() {
			@Override
			public BiobankContact toEntityModel() {
				return _nullBiobankContact;
			}
		};
}