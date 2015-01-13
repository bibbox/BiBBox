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

package at.rdconnect.update.service.persistence;

import at.rdconnect.update.NoSuchAddressUpdateException;
import at.rdconnect.update.model.AddressUpdate;
import at.rdconnect.update.model.impl.AddressUpdateImpl;
import at.rdconnect.update.model.impl.AddressUpdateModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the address update service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see AddressUpdatePersistence
 * @see AddressUpdateUtil
 * @generated
 */
public class AddressUpdatePersistenceImpl extends BasePersistenceImpl<AddressUpdate>
	implements AddressUpdatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AddressUpdateUtil} to access the address update persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AddressUpdateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AddressUpdateModelImpl.FINDER_CACHE_ENABLED,
			AddressUpdateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AddressUpdateModelImpl.FINDER_CACHE_ENABLED,
			AddressUpdateImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AddressUpdateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AddressUpdateModelImpl.FINDER_CACHE_ENABLED,
			AddressUpdateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AddressUpdateModelImpl.FINDER_CACHE_ENABLED,
			AddressUpdateImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrganizationId", new String[] { Long.class.getName() },
			AddressUpdateModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AddressUpdateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the address updates where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @return the matching address updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressUpdate> findByOrganizationId(long organizationid)
		throws SystemException {
		return findByOrganizationId(organizationid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address updates where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.AddressUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of address updates
	 * @param end the upper bound of the range of address updates (not inclusive)
	 * @return the range of matching address updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressUpdate> findByOrganizationId(long organizationid,
		int start, int end) throws SystemException {
		return findByOrganizationId(organizationid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the address updates where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.AddressUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of address updates
	 * @param end the upper bound of the range of address updates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressUpdate> findByOrganizationId(long organizationid,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] { organizationid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] {
					organizationid,
					
					start, end, orderByComparator
				};
		}

		List<AddressUpdate> list = (List<AddressUpdate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AddressUpdate addressUpdate : list) {
				if ((organizationid != addressUpdate.getOrganizationid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ADDRESSUPDATE_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddressUpdateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationid);

				if (!pagination) {
					list = (List<AddressUpdate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressUpdate>(list);
				}
				else {
					list = (List<AddressUpdate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first address update in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address update
	 * @throws at.rdconnect.update.NoSuchAddressUpdateException if a matching address update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressUpdate findByOrganizationId_First(long organizationid,
		OrderByComparator orderByComparator)
		throws NoSuchAddressUpdateException, SystemException {
		AddressUpdate addressUpdate = fetchByOrganizationId_First(organizationid,
				orderByComparator);

		if (addressUpdate != null) {
			return addressUpdate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationid=");
		msg.append(organizationid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressUpdateException(msg.toString());
	}

	/**
	 * Returns the first address update in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address update, or <code>null</code> if a matching address update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressUpdate fetchByOrganizationId_First(long organizationid,
		OrderByComparator orderByComparator) throws SystemException {
		List<AddressUpdate> list = findByOrganizationId(organizationid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address update in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address update
	 * @throws at.rdconnect.update.NoSuchAddressUpdateException if a matching address update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressUpdate findByOrganizationId_Last(long organizationid,
		OrderByComparator orderByComparator)
		throws NoSuchAddressUpdateException, SystemException {
		AddressUpdate addressUpdate = fetchByOrganizationId_Last(organizationid,
				orderByComparator);

		if (addressUpdate != null) {
			return addressUpdate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationid=");
		msg.append(organizationid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressUpdateException(msg.toString());
	}

	/**
	 * Returns the last address update in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address update, or <code>null</code> if a matching address update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressUpdate fetchByOrganizationId_Last(long organizationid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(organizationid);

		if (count == 0) {
			return null;
		}

		List<AddressUpdate> list = findByOrganizationId(organizationid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the address updates before and after the current address update in the ordered set where organizationid = &#63;.
	 *
	 * @param addressid the primary key of the current address update
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address update
	 * @throws at.rdconnect.update.NoSuchAddressUpdateException if a address update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressUpdate[] findByOrganizationId_PrevAndNext(long addressid,
		long organizationid, OrderByComparator orderByComparator)
		throws NoSuchAddressUpdateException, SystemException {
		AddressUpdate addressUpdate = findByPrimaryKey(addressid);

		Session session = null;

		try {
			session = openSession();

			AddressUpdate[] array = new AddressUpdateImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session, addressUpdate,
					organizationid, orderByComparator, true);

			array[1] = addressUpdate;

			array[2] = getByOrganizationId_PrevAndNext(session, addressUpdate,
					organizationid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AddressUpdate getByOrganizationId_PrevAndNext(Session session,
		AddressUpdate addressUpdate, long organizationid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADDRESSUPDATE_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AddressUpdateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationid);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addressUpdate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddressUpdate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the address updates where organizationid = &#63; from the database.
	 *
	 * @param organizationid the organizationid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organizationid)
		throws SystemException {
		for (AddressUpdate addressUpdate : findByOrganizationId(
				organizationid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(addressUpdate);
		}
	}

	/**
	 * Returns the number of address updates where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @return the number of matching address updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationId(long organizationid)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { organizationid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADDRESSUPDATE_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationid);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "addressUpdate.organizationid = ?";

	public AddressUpdatePersistenceImpl() {
		setModelClass(AddressUpdate.class);
	}

	/**
	 * Caches the address update in the entity cache if it is enabled.
	 *
	 * @param addressUpdate the address update
	 */
	@Override
	public void cacheResult(AddressUpdate addressUpdate) {
		EntityCacheUtil.putResult(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AddressUpdateImpl.class, addressUpdate.getPrimaryKey(),
			addressUpdate);

		addressUpdate.resetOriginalValues();
	}

	/**
	 * Caches the address updates in the entity cache if it is enabled.
	 *
	 * @param addressUpdates the address updates
	 */
	@Override
	public void cacheResult(List<AddressUpdate> addressUpdates) {
		for (AddressUpdate addressUpdate : addressUpdates) {
			if (EntityCacheUtil.getResult(
						AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
						AddressUpdateImpl.class, addressUpdate.getPrimaryKey()) == null) {
				cacheResult(addressUpdate);
			}
			else {
				addressUpdate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all address updates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AddressUpdateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AddressUpdateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the address update.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AddressUpdate addressUpdate) {
		EntityCacheUtil.removeResult(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AddressUpdateImpl.class, addressUpdate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AddressUpdate> addressUpdates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AddressUpdate addressUpdate : addressUpdates) {
			EntityCacheUtil.removeResult(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
				AddressUpdateImpl.class, addressUpdate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new address update with the primary key. Does not add the address update to the database.
	 *
	 * @param addressid the primary key for the new address update
	 * @return the new address update
	 */
	@Override
	public AddressUpdate create(long addressid) {
		AddressUpdate addressUpdate = new AddressUpdateImpl();

		addressUpdate.setNew(true);
		addressUpdate.setPrimaryKey(addressid);

		return addressUpdate;
	}

	/**
	 * Removes the address update with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressid the primary key of the address update
	 * @return the address update that was removed
	 * @throws at.rdconnect.update.NoSuchAddressUpdateException if a address update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressUpdate remove(long addressid)
		throws NoSuchAddressUpdateException, SystemException {
		return remove((Serializable)addressid);
	}

	/**
	 * Removes the address update with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the address update
	 * @return the address update that was removed
	 * @throws at.rdconnect.update.NoSuchAddressUpdateException if a address update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressUpdate remove(Serializable primaryKey)
		throws NoSuchAddressUpdateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AddressUpdate addressUpdate = (AddressUpdate)session.get(AddressUpdateImpl.class,
					primaryKey);

			if (addressUpdate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddressUpdateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(addressUpdate);
		}
		catch (NoSuchAddressUpdateException nsee) {
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
	protected AddressUpdate removeImpl(AddressUpdate addressUpdate)
		throws SystemException {
		addressUpdate = toUnwrappedModel(addressUpdate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(addressUpdate)) {
				addressUpdate = (AddressUpdate)session.get(AddressUpdateImpl.class,
						addressUpdate.getPrimaryKeyObj());
			}

			if (addressUpdate != null) {
				session.delete(addressUpdate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (addressUpdate != null) {
			clearCache(addressUpdate);
		}

		return addressUpdate;
	}

	@Override
	public AddressUpdate updateImpl(
		at.rdconnect.update.model.AddressUpdate addressUpdate)
		throws SystemException {
		addressUpdate = toUnwrappedModel(addressUpdate);

		boolean isNew = addressUpdate.isNew();

		AddressUpdateModelImpl addressUpdateModelImpl = (AddressUpdateModelImpl)addressUpdate;

		Session session = null;

		try {
			session = openSession();

			if (addressUpdate.isNew()) {
				session.save(addressUpdate);

				addressUpdate.setNew(false);
			}
			else {
				session.merge(addressUpdate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AddressUpdateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((addressUpdateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addressUpdateModelImpl.getOriginalOrganizationid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] { addressUpdateModelImpl.getOrganizationid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
			AddressUpdateImpl.class, addressUpdate.getPrimaryKey(),
			addressUpdate);

		return addressUpdate;
	}

	protected AddressUpdate toUnwrappedModel(AddressUpdate addressUpdate) {
		if (addressUpdate instanceof AddressUpdateImpl) {
			return addressUpdate;
		}

		AddressUpdateImpl addressUpdateImpl = new AddressUpdateImpl();

		addressUpdateImpl.setNew(addressUpdate.isNew());
		addressUpdateImpl.setPrimaryKey(addressUpdate.getPrimaryKey());

		addressUpdateImpl.setAddressid(addressUpdate.getAddressid());
		addressUpdateImpl.setStreet1(addressUpdate.getStreet1());
		addressUpdateImpl.setStreet2(addressUpdate.getStreet2());
		addressUpdateImpl.setStreet3(addressUpdate.getStreet3());
		addressUpdateImpl.setCity(addressUpdate.getCity());
		addressUpdateImpl.setZip(addressUpdate.getZip());
		addressUpdateImpl.setRegionid(addressUpdate.getRegionid());
		addressUpdateImpl.setContryid(addressUpdate.getContryid());
		addressUpdateImpl.setTypeid(addressUpdate.getTypeid());
		addressUpdateImpl.setMailing(addressUpdate.isMailing());
		addressUpdateImpl.setPrimary_ad(addressUpdate.isPrimary_ad());
		addressUpdateImpl.setOrganizationid(addressUpdate.getOrganizationid());

		return addressUpdateImpl;
	}

	/**
	 * Returns the address update with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the address update
	 * @return the address update
	 * @throws at.rdconnect.update.NoSuchAddressUpdateException if a address update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressUpdate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddressUpdateException, SystemException {
		AddressUpdate addressUpdate = fetchByPrimaryKey(primaryKey);

		if (addressUpdate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddressUpdateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return addressUpdate;
	}

	/**
	 * Returns the address update with the primary key or throws a {@link at.rdconnect.update.NoSuchAddressUpdateException} if it could not be found.
	 *
	 * @param addressid the primary key of the address update
	 * @return the address update
	 * @throws at.rdconnect.update.NoSuchAddressUpdateException if a address update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressUpdate findByPrimaryKey(long addressid)
		throws NoSuchAddressUpdateException, SystemException {
		return findByPrimaryKey((Serializable)addressid);
	}

	/**
	 * Returns the address update with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the address update
	 * @return the address update, or <code>null</code> if a address update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressUpdate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AddressUpdate addressUpdate = (AddressUpdate)EntityCacheUtil.getResult(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
				AddressUpdateImpl.class, primaryKey);

		if (addressUpdate == _nullAddressUpdate) {
			return null;
		}

		if (addressUpdate == null) {
			Session session = null;

			try {
				session = openSession();

				addressUpdate = (AddressUpdate)session.get(AddressUpdateImpl.class,
						primaryKey);

				if (addressUpdate != null) {
					cacheResult(addressUpdate);
				}
				else {
					EntityCacheUtil.putResult(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
						AddressUpdateImpl.class, primaryKey, _nullAddressUpdate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AddressUpdateModelImpl.ENTITY_CACHE_ENABLED,
					AddressUpdateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return addressUpdate;
	}

	/**
	 * Returns the address update with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressid the primary key of the address update
	 * @return the address update, or <code>null</code> if a address update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AddressUpdate fetchByPrimaryKey(long addressid)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)addressid);
	}

	/**
	 * Returns all the address updates.
	 *
	 * @return the address updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressUpdate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address updates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.AddressUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of address updates
	 * @param end the upper bound of the range of address updates (not inclusive)
	 * @return the range of address updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressUpdate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the address updates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.AddressUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of address updates
	 * @param end the upper bound of the range of address updates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of address updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AddressUpdate> findAll(int start, int end,
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

		List<AddressUpdate> list = (List<AddressUpdate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADDRESSUPDATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADDRESSUPDATE;

				if (pagination) {
					sql = sql.concat(AddressUpdateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AddressUpdate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AddressUpdate>(list);
				}
				else {
					list = (List<AddressUpdate>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the address updates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AddressUpdate addressUpdate : findAll()) {
			remove(addressUpdate);
		}
	}

	/**
	 * Returns the number of address updates.
	 *
	 * @return the number of address updates
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

				Query q = session.createQuery(_SQL_COUNT_ADDRESSUPDATE);

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
	 * Initializes the address update persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.rdconnect.update.model.AddressUpdate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AddressUpdate>> listenersList = new ArrayList<ModelListener<AddressUpdate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AddressUpdate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AddressUpdateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADDRESSUPDATE = "SELECT addressUpdate FROM AddressUpdate addressUpdate";
	private static final String _SQL_SELECT_ADDRESSUPDATE_WHERE = "SELECT addressUpdate FROM AddressUpdate addressUpdate WHERE ";
	private static final String _SQL_COUNT_ADDRESSUPDATE = "SELECT COUNT(addressUpdate) FROM AddressUpdate addressUpdate";
	private static final String _SQL_COUNT_ADDRESSUPDATE_WHERE = "SELECT COUNT(addressUpdate) FROM AddressUpdate addressUpdate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "addressUpdate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AddressUpdate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AddressUpdate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AddressUpdatePersistenceImpl.class);
	private static AddressUpdate _nullAddressUpdate = new AddressUpdateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AddressUpdate> toCacheModel() {
				return _nullAddressUpdateCacheModel;
			}
		};

	private static CacheModel<AddressUpdate> _nullAddressUpdateCacheModel = new CacheModel<AddressUpdate>() {
			@Override
			public AddressUpdate toEntityModel() {
				return _nullAddressUpdate;
			}
		};
}