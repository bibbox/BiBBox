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

import at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException;
import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderModelImpl;

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
 * The persistence implementation for the orphanet disorder service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see OrphanetDisorderPersistence
 * @see OrphanetDisorderUtil
 * @generated
 */
public class OrphanetDisorderPersistenceImpl extends BasePersistenceImpl<OrphanetDisorder>
	implements OrphanetDisorderPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrphanetDisorderUtil} to access the orphanet disorder persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrphanetDisorderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetDisorderModelImpl.FINDER_CACHE_ENABLED,
			OrphanetDisorderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetDisorderModelImpl.FINDER_CACHE_ENABLED,
			OrphanetDisorderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetDisorderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ORPHANUMBER = new FinderPath(OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetDisorderModelImpl.FINDER_CACHE_ENABLED,
			OrphanetDisorderImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByOrphaNumber", new String[] { Long.class.getName() },
			OrphanetDisorderModelImpl.ORPHANUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORPHANUMBER = new FinderPath(OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetDisorderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrphaNumber",
			new String[] { Long.class.getName() });

	/**
	 * Returns the orphanet disorder where orphanumber = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException} if it could not be found.
	 *
	 * @param orphanumber the orphanumber
	 * @return the matching orphanet disorder
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException if a matching orphanet disorder could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetDisorder findByOrphaNumber(long orphanumber)
		throws NoSuchOrphanetDisorderException, SystemException {
		OrphanetDisorder orphanetDisorder = fetchByOrphaNumber(orphanumber);

		if (orphanetDisorder == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("orphanumber=");
			msg.append(orphanumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrphanetDisorderException(msg.toString());
		}

		return orphanetDisorder;
	}

	/**
	 * Returns the orphanet disorder where orphanumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param orphanumber the orphanumber
	 * @return the matching orphanet disorder, or <code>null</code> if a matching orphanet disorder could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetDisorder fetchByOrphaNumber(long orphanumber)
		throws SystemException {
		return fetchByOrphaNumber(orphanumber, true);
	}

	/**
	 * Returns the orphanet disorder where orphanumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param orphanumber the orphanumber
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching orphanet disorder, or <code>null</code> if a matching orphanet disorder could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetDisorder fetchByOrphaNumber(long orphanumber,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { orphanumber };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ORPHANUMBER,
					finderArgs, this);
		}

		if (result instanceof OrphanetDisorder) {
			OrphanetDisorder orphanetDisorder = (OrphanetDisorder)result;

			if ((orphanumber != orphanetDisorder.getOrphanumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ORPHANETDISORDER_WHERE);

			query.append(_FINDER_COLUMN_ORPHANUMBER_ORPHANUMBER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orphanumber);

				List<OrphanetDisorder> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORPHANUMBER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"OrphanetDisorderPersistenceImpl.fetchByOrphaNumber(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					OrphanetDisorder orphanetDisorder = list.get(0);

					result = orphanetDisorder;

					cacheResult(orphanetDisorder);

					if ((orphanetDisorder.getOrphanumber() != orphanumber)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORPHANUMBER,
							finderArgs, orphanetDisorder);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORPHANUMBER,
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
			return (OrphanetDisorder)result;
		}
	}

	/**
	 * Removes the orphanet disorder where orphanumber = &#63; from the database.
	 *
	 * @param orphanumber the orphanumber
	 * @return the orphanet disorder that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetDisorder removeByOrphaNumber(long orphanumber)
		throws NoSuchOrphanetDisorderException, SystemException {
		OrphanetDisorder orphanetDisorder = findByOrphaNumber(orphanumber);

		return remove(orphanetDisorder);
	}

	/**
	 * Returns the number of orphanet disorders where orphanumber = &#63;.
	 *
	 * @param orphanumber the orphanumber
	 * @return the number of matching orphanet disorders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrphaNumber(long orphanumber) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORPHANUMBER;

		Object[] finderArgs = new Object[] { orphanumber };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORPHANETDISORDER_WHERE);

			query.append(_FINDER_COLUMN_ORPHANUMBER_ORPHANUMBER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orphanumber);

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

	private static final String _FINDER_COLUMN_ORPHANUMBER_ORPHANUMBER_2 = "orphanetDisorder.orphanumber = ?";

	public OrphanetDisorderPersistenceImpl() {
		setModelClass(OrphanetDisorder.class);
	}

	/**
	 * Caches the orphanet disorder in the entity cache if it is enabled.
	 *
	 * @param orphanetDisorder the orphanet disorder
	 */
	@Override
	public void cacheResult(OrphanetDisorder orphanetDisorder) {
		EntityCacheUtil.putResult(OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetDisorderImpl.class, orphanetDisorder.getPrimaryKey(),
			orphanetDisorder);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORPHANUMBER,
			new Object[] { orphanetDisorder.getOrphanumber() }, orphanetDisorder);

		orphanetDisorder.resetOriginalValues();
	}

	/**
	 * Caches the orphanet disorders in the entity cache if it is enabled.
	 *
	 * @param orphanetDisorders the orphanet disorders
	 */
	@Override
	public void cacheResult(List<OrphanetDisorder> orphanetDisorders) {
		for (OrphanetDisorder orphanetDisorder : orphanetDisorders) {
			if (EntityCacheUtil.getResult(
						OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
						OrphanetDisorderImpl.class,
						orphanetDisorder.getPrimaryKey()) == null) {
				cacheResult(orphanetDisorder);
			}
			else {
				orphanetDisorder.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all orphanet disorders.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrphanetDisorderImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrphanetDisorderImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the orphanet disorder.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrphanetDisorder orphanetDisorder) {
		EntityCacheUtil.removeResult(OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetDisorderImpl.class, orphanetDisorder.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(orphanetDisorder);
	}

	@Override
	public void clearCache(List<OrphanetDisorder> orphanetDisorders) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrphanetDisorder orphanetDisorder : orphanetDisorders) {
			EntityCacheUtil.removeResult(OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
				OrphanetDisorderImpl.class, orphanetDisorder.getPrimaryKey());

			clearUniqueFindersCache(orphanetDisorder);
		}
	}

	protected void cacheUniqueFindersCache(OrphanetDisorder orphanetDisorder) {
		if (orphanetDisorder.isNew()) {
			Object[] args = new Object[] { orphanetDisorder.getOrphanumber() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORPHANUMBER, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORPHANUMBER, args,
				orphanetDisorder);
		}
		else {
			OrphanetDisorderModelImpl orphanetDisorderModelImpl = (OrphanetDisorderModelImpl)orphanetDisorder;

			if ((orphanetDisorderModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ORPHANUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { orphanetDisorder.getOrphanumber() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORPHANUMBER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORPHANUMBER,
					args, orphanetDisorder);
			}
		}
	}

	protected void clearUniqueFindersCache(OrphanetDisorder orphanetDisorder) {
		OrphanetDisorderModelImpl orphanetDisorderModelImpl = (OrphanetDisorderModelImpl)orphanetDisorder;

		Object[] args = new Object[] { orphanetDisorder.getOrphanumber() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORPHANUMBER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORPHANUMBER, args);

		if ((orphanetDisorderModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ORPHANUMBER.getColumnBitmask()) != 0) {
			args = new Object[] {
					orphanetDisorderModelImpl.getOriginalOrphanumber()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORPHANUMBER, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORPHANUMBER, args);
		}
	}

	/**
	 * Creates a new orphanet disorder with the primary key. Does not add the orphanet disorder to the database.
	 *
	 * @param orphanetdisorderId the primary key for the new orphanet disorder
	 * @return the new orphanet disorder
	 */
	@Override
	public OrphanetDisorder create(long orphanetdisorderId) {
		OrphanetDisorder orphanetDisorder = new OrphanetDisorderImpl();

		orphanetDisorder.setNew(true);
		orphanetDisorder.setPrimaryKey(orphanetdisorderId);

		return orphanetDisorder;
	}

	/**
	 * Removes the orphanet disorder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orphanetdisorderId the primary key of the orphanet disorder
	 * @return the orphanet disorder that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException if a orphanet disorder with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetDisorder remove(long orphanetdisorderId)
		throws NoSuchOrphanetDisorderException, SystemException {
		return remove((Serializable)orphanetdisorderId);
	}

	/**
	 * Removes the orphanet disorder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the orphanet disorder
	 * @return the orphanet disorder that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException if a orphanet disorder with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetDisorder remove(Serializable primaryKey)
		throws NoSuchOrphanetDisorderException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrphanetDisorder orphanetDisorder = (OrphanetDisorder)session.get(OrphanetDisorderImpl.class,
					primaryKey);

			if (orphanetDisorder == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrphanetDisorderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(orphanetDisorder);
		}
		catch (NoSuchOrphanetDisorderException nsee) {
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
	protected OrphanetDisorder removeImpl(OrphanetDisorder orphanetDisorder)
		throws SystemException {
		orphanetDisorder = toUnwrappedModel(orphanetDisorder);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(orphanetDisorder)) {
				orphanetDisorder = (OrphanetDisorder)session.get(OrphanetDisorderImpl.class,
						orphanetDisorder.getPrimaryKeyObj());
			}

			if (orphanetDisorder != null) {
				session.delete(orphanetDisorder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (orphanetDisorder != null) {
			clearCache(orphanetDisorder);
		}

		return orphanetDisorder;
	}

	@Override
	public OrphanetDisorder updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder orphanetDisorder)
		throws SystemException {
		orphanetDisorder = toUnwrappedModel(orphanetDisorder);

		boolean isNew = orphanetDisorder.isNew();

		Session session = null;

		try {
			session = openSession();

			if (orphanetDisorder.isNew()) {
				session.save(orphanetDisorder);

				orphanetDisorder.setNew(false);
			}
			else {
				session.merge(orphanetDisorder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrphanetDisorderModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetDisorderImpl.class, orphanetDisorder.getPrimaryKey(),
			orphanetDisorder);

		clearUniqueFindersCache(orphanetDisorder);
		cacheUniqueFindersCache(orphanetDisorder);

		return orphanetDisorder;
	}

	protected OrphanetDisorder toUnwrappedModel(
		OrphanetDisorder orphanetDisorder) {
		if (orphanetDisorder instanceof OrphanetDisorderImpl) {
			return orphanetDisorder;
		}

		OrphanetDisorderImpl orphanetDisorderImpl = new OrphanetDisorderImpl();

		orphanetDisorderImpl.setNew(orphanetDisorder.isNew());
		orphanetDisorderImpl.setPrimaryKey(orphanetDisorder.getPrimaryKey());

		orphanetDisorderImpl.setOrphanetdisorderId(orphanetDisorder.getOrphanetdisorderId());
		orphanetDisorderImpl.setOrphanumber(orphanetDisorder.getOrphanumber());
		orphanetDisorderImpl.setOrpahnetlink(orphanetDisorder.getOrpahnetlink());
		orphanetDisorderImpl.setDiseasename(orphanetDisorder.getDiseasename());

		return orphanetDisorderImpl;
	}

	/**
	 * Returns the orphanet disorder with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the orphanet disorder
	 * @return the orphanet disorder
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException if a orphanet disorder with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetDisorder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrphanetDisorderException, SystemException {
		OrphanetDisorder orphanetDisorder = fetchByPrimaryKey(primaryKey);

		if (orphanetDisorder == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrphanetDisorderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return orphanetDisorder;
	}

	/**
	 * Returns the orphanet disorder with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException} if it could not be found.
	 *
	 * @param orphanetdisorderId the primary key of the orphanet disorder
	 * @return the orphanet disorder
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException if a orphanet disorder with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetDisorder findByPrimaryKey(long orphanetdisorderId)
		throws NoSuchOrphanetDisorderException, SystemException {
		return findByPrimaryKey((Serializable)orphanetdisorderId);
	}

	/**
	 * Returns the orphanet disorder with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the orphanet disorder
	 * @return the orphanet disorder, or <code>null</code> if a orphanet disorder with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetDisorder fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OrphanetDisorder orphanetDisorder = (OrphanetDisorder)EntityCacheUtil.getResult(OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
				OrphanetDisorderImpl.class, primaryKey);

		if (orphanetDisorder == _nullOrphanetDisorder) {
			return null;
		}

		if (orphanetDisorder == null) {
			Session session = null;

			try {
				session = openSession();

				orphanetDisorder = (OrphanetDisorder)session.get(OrphanetDisorderImpl.class,
						primaryKey);

				if (orphanetDisorder != null) {
					cacheResult(orphanetDisorder);
				}
				else {
					EntityCacheUtil.putResult(OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
						OrphanetDisorderImpl.class, primaryKey,
						_nullOrphanetDisorder);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrphanetDisorderModelImpl.ENTITY_CACHE_ENABLED,
					OrphanetDisorderImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return orphanetDisorder;
	}

	/**
	 * Returns the orphanet disorder with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orphanetdisorderId the primary key of the orphanet disorder
	 * @return the orphanet disorder, or <code>null</code> if a orphanet disorder with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetDisorder fetchByPrimaryKey(long orphanetdisorderId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)orphanetdisorderId);
	}

	/**
	 * Returns all the orphanet disorders.
	 *
	 * @return the orphanet disorders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetDisorder> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the orphanet disorders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of orphanet disorders
	 * @param end the upper bound of the range of orphanet disorders (not inclusive)
	 * @return the range of orphanet disorders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetDisorder> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the orphanet disorders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of orphanet disorders
	 * @param end the upper bound of the range of orphanet disorders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of orphanet disorders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetDisorder> findAll(int start, int end,
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

		List<OrphanetDisorder> list = (List<OrphanetDisorder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORPHANETDISORDER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORPHANETDISORDER;

				if (pagination) {
					sql = sql.concat(OrphanetDisorderModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OrphanetDisorder>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrphanetDisorder>(list);
				}
				else {
					list = (List<OrphanetDisorder>)QueryUtil.list(q,
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
	 * Removes all the orphanet disorders from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OrphanetDisorder orphanetDisorder : findAll()) {
			remove(orphanetDisorder);
		}
	}

	/**
	 * Returns the number of orphanet disorders.
	 *
	 * @return the number of orphanet disorders
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

				Query q = session.createQuery(_SQL_COUNT_ORPHANETDISORDER);

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
	 * Initializes the orphanet disorder persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrphanetDisorder>> listenersList = new ArrayList<ModelListener<OrphanetDisorder>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrphanetDisorder>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrphanetDisorderImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORPHANETDISORDER = "SELECT orphanetDisorder FROM OrphanetDisorder orphanetDisorder";
	private static final String _SQL_SELECT_ORPHANETDISORDER_WHERE = "SELECT orphanetDisorder FROM OrphanetDisorder orphanetDisorder WHERE ";
	private static final String _SQL_COUNT_ORPHANETDISORDER = "SELECT COUNT(orphanetDisorder) FROM OrphanetDisorder orphanetDisorder";
	private static final String _SQL_COUNT_ORPHANETDISORDER_WHERE = "SELECT COUNT(orphanetDisorder) FROM OrphanetDisorder orphanetDisorder WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "orphanetDisorder.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrphanetDisorder exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OrphanetDisorder exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrphanetDisorderPersistenceImpl.class);
	private static OrphanetDisorder _nullOrphanetDisorder = new OrphanetDisorderImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OrphanetDisorder> toCacheModel() {
				return _nullOrphanetDisorderCacheModel;
			}
		};

	private static CacheModel<OrphanetDisorder> _nullOrphanetDisorderCacheModel = new CacheModel<OrphanetDisorder>() {
			@Override
			public OrphanetDisorder toEntityModel() {
				return _nullOrphanetDisorder;
			}
		};
}