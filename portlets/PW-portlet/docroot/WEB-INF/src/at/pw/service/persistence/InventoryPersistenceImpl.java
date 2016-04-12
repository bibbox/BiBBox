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

package at.pw.service.persistence;

import at.pw.NoSuchInventoryException;

import at.pw.model.Inventory;
import at.pw.model.impl.InventoryImpl;
import at.pw.model.impl.InventoryModelImpl;

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
 * The persistence implementation for the inventory service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see InventoryPersistence
 * @see InventoryUtil
 * @generated
 */
public class InventoryPersistenceImpl extends BasePersistenceImpl<Inventory>
	implements InventoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InventoryUtil} to access the inventory persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InventoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InventoryModelImpl.ENTITY_CACHE_ENABLED,
			InventoryModelImpl.FINDER_CACHE_ENABLED, InventoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InventoryModelImpl.ENTITY_CACHE_ENABLED,
			InventoryModelImpl.FINDER_CACHE_ENABLED, InventoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InventoryModelImpl.ENTITY_CACHE_ENABLED,
			InventoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_WEBCONTENTID = new FinderPath(InventoryModelImpl.ENTITY_CACHE_ENABLED,
			InventoryModelImpl.FINDER_CACHE_ENABLED, InventoryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBywebcontentId",
			new String[] { Long.class.getName() },
			InventoryModelImpl.WEBCONTENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WEBCONTENTID = new FinderPath(InventoryModelImpl.ENTITY_CACHE_ENABLED,
			InventoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBywebcontentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the inventory where webcontentId = &#63; or throws a {@link at.pw.NoSuchInventoryException} if it could not be found.
	 *
	 * @param webcontentId the webcontent ID
	 * @return the matching inventory
	 * @throws at.pw.NoSuchInventoryException if a matching inventory could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Inventory findBywebcontentId(long webcontentId)
		throws NoSuchInventoryException, SystemException {
		Inventory inventory = fetchBywebcontentId(webcontentId);

		if (inventory == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("webcontentId=");
			msg.append(webcontentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchInventoryException(msg.toString());
		}

		return inventory;
	}

	/**
	 * Returns the inventory where webcontentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param webcontentId the webcontent ID
	 * @return the matching inventory, or <code>null</code> if a matching inventory could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Inventory fetchBywebcontentId(long webcontentId)
		throws SystemException {
		return fetchBywebcontentId(webcontentId, true);
	}

	/**
	 * Returns the inventory where webcontentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param webcontentId the webcontent ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching inventory, or <code>null</code> if a matching inventory could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Inventory fetchBywebcontentId(long webcontentId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { webcontentId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_WEBCONTENTID,
					finderArgs, this);
		}

		if (result instanceof Inventory) {
			Inventory inventory = (Inventory)result;

			if ((webcontentId != inventory.getWebcontentId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_INVENTORY_WHERE);

			query.append(_FINDER_COLUMN_WEBCONTENTID_WEBCONTENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(webcontentId);

				List<Inventory> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBCONTENTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"InventoryPersistenceImpl.fetchBywebcontentId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Inventory inventory = list.get(0);

					result = inventory;

					cacheResult(inventory);

					if ((inventory.getWebcontentId() != webcontentId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBCONTENTID,
							finderArgs, inventory);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WEBCONTENTID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Inventory)result;
		}
	}

	/**
	 * Removes the inventory where webcontentId = &#63; from the database.
	 *
	 * @param webcontentId the webcontent ID
	 * @return the inventory that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Inventory removeBywebcontentId(long webcontentId)
		throws NoSuchInventoryException, SystemException {
		Inventory inventory = findBywebcontentId(webcontentId);

		return remove(inventory);
	}

	/**
	 * Returns the number of inventories where webcontentId = &#63;.
	 *
	 * @param webcontentId the webcontent ID
	 * @return the number of matching inventories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBywebcontentId(long webcontentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WEBCONTENTID;

		Object[] finderArgs = new Object[] { webcontentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVENTORY_WHERE);

			query.append(_FINDER_COLUMN_WEBCONTENTID_WEBCONTENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(webcontentId);

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

	private static final String _FINDER_COLUMN_WEBCONTENTID_WEBCONTENTID_2 = "inventory.webcontentId = ?";

	public InventoryPersistenceImpl() {
		setModelClass(Inventory.class);
	}

	/**
	 * Caches the inventory in the entity cache if it is enabled.
	 *
	 * @param inventory the inventory
	 */
	@Override
	public void cacheResult(Inventory inventory) {
		EntityCacheUtil.putResult(InventoryModelImpl.ENTITY_CACHE_ENABLED,
			InventoryImpl.class, inventory.getPrimaryKey(), inventory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBCONTENTID,
			new Object[] { inventory.getWebcontentId() }, inventory);

		inventory.resetOriginalValues();
	}

	/**
	 * Caches the inventories in the entity cache if it is enabled.
	 *
	 * @param inventories the inventories
	 */
	@Override
	public void cacheResult(List<Inventory> inventories) {
		for (Inventory inventory : inventories) {
			if (EntityCacheUtil.getResult(
						InventoryModelImpl.ENTITY_CACHE_ENABLED,
						InventoryImpl.class, inventory.getPrimaryKey()) == null) {
				cacheResult(inventory);
			}
			else {
				inventory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all inventories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InventoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InventoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the inventory.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Inventory inventory) {
		EntityCacheUtil.removeResult(InventoryModelImpl.ENTITY_CACHE_ENABLED,
			InventoryImpl.class, inventory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(inventory);
	}

	@Override
	public void clearCache(List<Inventory> inventories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Inventory inventory : inventories) {
			EntityCacheUtil.removeResult(InventoryModelImpl.ENTITY_CACHE_ENABLED,
				InventoryImpl.class, inventory.getPrimaryKey());

			clearUniqueFindersCache(inventory);
		}
	}

	protected void cacheUniqueFindersCache(Inventory inventory) {
		if (inventory.isNew()) {
			Object[] args = new Object[] { inventory.getWebcontentId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WEBCONTENTID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBCONTENTID, args,
				inventory);
		}
		else {
			InventoryModelImpl inventoryModelImpl = (InventoryModelImpl)inventory;

			if ((inventoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_WEBCONTENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { inventory.getWebcontentId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WEBCONTENTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBCONTENTID,
					args, inventory);
			}
		}
	}

	protected void clearUniqueFindersCache(Inventory inventory) {
		InventoryModelImpl inventoryModelImpl = (InventoryModelImpl)inventory;

		Object[] args = new Object[] { inventory.getWebcontentId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WEBCONTENTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WEBCONTENTID, args);

		if ((inventoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_WEBCONTENTID.getColumnBitmask()) != 0) {
			args = new Object[] { inventoryModelImpl.getOriginalWebcontentId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WEBCONTENTID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WEBCONTENTID, args);
		}
	}

	/**
	 * Creates a new inventory with the primary key. Does not add the inventory to the database.
	 *
	 * @param inventoryId the primary key for the new inventory
	 * @return the new inventory
	 */
	@Override
	public Inventory create(long inventoryId) {
		Inventory inventory = new InventoryImpl();

		inventory.setNew(true);
		inventory.setPrimaryKey(inventoryId);

		return inventory;
	}

	/**
	 * Removes the inventory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inventoryId the primary key of the inventory
	 * @return the inventory that was removed
	 * @throws at.pw.NoSuchInventoryException if a inventory with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Inventory remove(long inventoryId)
		throws NoSuchInventoryException, SystemException {
		return remove((Serializable)inventoryId);
	}

	/**
	 * Removes the inventory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the inventory
	 * @return the inventory that was removed
	 * @throws at.pw.NoSuchInventoryException if a inventory with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Inventory remove(Serializable primaryKey)
		throws NoSuchInventoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Inventory inventory = (Inventory)session.get(InventoryImpl.class,
					primaryKey);

			if (inventory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInventoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(inventory);
		}
		catch (NoSuchInventoryException nsee) {
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
	protected Inventory removeImpl(Inventory inventory)
		throws SystemException {
		inventory = toUnwrappedModel(inventory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(inventory)) {
				inventory = (Inventory)session.get(InventoryImpl.class,
						inventory.getPrimaryKeyObj());
			}

			if (inventory != null) {
				session.delete(inventory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (inventory != null) {
			clearCache(inventory);
		}

		return inventory;
	}

	@Override
	public Inventory updateImpl(at.pw.model.Inventory inventory)
		throws SystemException {
		inventory = toUnwrappedModel(inventory);

		boolean isNew = inventory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (inventory.isNew()) {
				session.save(inventory);

				inventory.setNew(false);
			}
			else {
				session.merge(inventory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !InventoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(InventoryModelImpl.ENTITY_CACHE_ENABLED,
			InventoryImpl.class, inventory.getPrimaryKey(), inventory);

		clearUniqueFindersCache(inventory);
		cacheUniqueFindersCache(inventory);

		return inventory;
	}

	protected Inventory toUnwrappedModel(Inventory inventory) {
		if (inventory instanceof InventoryImpl) {
			return inventory;
		}

		InventoryImpl inventoryImpl = new InventoryImpl();

		inventoryImpl.setNew(inventory.isNew());
		inventoryImpl.setPrimaryKey(inventory.getPrimaryKey());

		inventoryImpl.setInventoryId(inventory.getInventoryId());
		inventoryImpl.setCreateDate(inventory.getCreateDate());
		inventoryImpl.setInventarnummer(inventory.getInventarnummer());
		inventoryImpl.setWebcontentId(inventory.getWebcontentId());
		inventoryImpl.setFolderId(inventory.getFolderId());
		inventoryImpl.setStructureId(inventory.getStructureId());
		inventoryImpl.setStructuretemplateId(inventory.getStructuretemplateId());

		return inventoryImpl;
	}

	/**
	 * Returns the inventory with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the inventory
	 * @return the inventory
	 * @throws at.pw.NoSuchInventoryException if a inventory with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Inventory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInventoryException, SystemException {
		Inventory inventory = fetchByPrimaryKey(primaryKey);

		if (inventory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInventoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return inventory;
	}

	/**
	 * Returns the inventory with the primary key or throws a {@link at.pw.NoSuchInventoryException} if it could not be found.
	 *
	 * @param inventoryId the primary key of the inventory
	 * @return the inventory
	 * @throws at.pw.NoSuchInventoryException if a inventory with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Inventory findByPrimaryKey(long inventoryId)
		throws NoSuchInventoryException, SystemException {
		return findByPrimaryKey((Serializable)inventoryId);
	}

	/**
	 * Returns the inventory with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the inventory
	 * @return the inventory, or <code>null</code> if a inventory with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Inventory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Inventory inventory = (Inventory)EntityCacheUtil.getResult(InventoryModelImpl.ENTITY_CACHE_ENABLED,
				InventoryImpl.class, primaryKey);

		if (inventory == _nullInventory) {
			return null;
		}

		if (inventory == null) {
			Session session = null;

			try {
				session = openSession();

				inventory = (Inventory)session.get(InventoryImpl.class,
						primaryKey);

				if (inventory != null) {
					cacheResult(inventory);
				}
				else {
					EntityCacheUtil.putResult(InventoryModelImpl.ENTITY_CACHE_ENABLED,
						InventoryImpl.class, primaryKey, _nullInventory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InventoryModelImpl.ENTITY_CACHE_ENABLED,
					InventoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return inventory;
	}

	/**
	 * Returns the inventory with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param inventoryId the primary key of the inventory
	 * @return the inventory, or <code>null</code> if a inventory with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Inventory fetchByPrimaryKey(long inventoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)inventoryId);
	}

	/**
	 * Returns all the inventories.
	 *
	 * @return the inventories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Inventory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the inventories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.pw.model.impl.InventoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of inventories
	 * @param end the upper bound of the range of inventories (not inclusive)
	 * @return the range of inventories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Inventory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the inventories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.pw.model.impl.InventoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of inventories
	 * @param end the upper bound of the range of inventories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of inventories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Inventory> findAll(int start, int end,
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

		List<Inventory> list = (List<Inventory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INVENTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INVENTORY;

				if (pagination) {
					sql = sql.concat(InventoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Inventory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Inventory>(list);
				}
				else {
					list = (List<Inventory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the inventories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Inventory inventory : findAll()) {
			remove(inventory);
		}
	}

	/**
	 * Returns the number of inventories.
	 *
	 * @return the number of inventories
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

				Query q = session.createQuery(_SQL_COUNT_INVENTORY);

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
	 * Initializes the inventory persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.pw.model.Inventory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Inventory>> listenersList = new ArrayList<ModelListener<Inventory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Inventory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InventoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INVENTORY = "SELECT inventory FROM Inventory inventory";
	private static final String _SQL_SELECT_INVENTORY_WHERE = "SELECT inventory FROM Inventory inventory WHERE ";
	private static final String _SQL_COUNT_INVENTORY = "SELECT COUNT(inventory) FROM Inventory inventory";
	private static final String _SQL_COUNT_INVENTORY_WHERE = "SELECT COUNT(inventory) FROM Inventory inventory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "inventory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Inventory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Inventory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InventoryPersistenceImpl.class);
	private static Inventory _nullInventory = new InventoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Inventory> toCacheModel() {
				return _nullInventoryCacheModel;
			}
		};

	private static CacheModel<Inventory> _nullInventoryCacheModel = new CacheModel<Inventory>() {
			@Override
			public Inventory toEntityModel() {
				return _nullInventory;
			}
		};
}