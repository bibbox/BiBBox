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

import at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException;
import at.meduni.liferay.portlet.rdconnect.model.RDCRecommender;
import at.meduni.liferay.portlet.rdconnect.model.impl.RDCRecommenderImpl;
import at.meduni.liferay.portlet.rdconnect.model.impl.RDCRecommenderModelImpl;

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
 * The persistence implementation for the r d c recommender service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see RDCRecommenderPersistence
 * @see RDCRecommenderUtil
 * @generated
 */
public class RDCRecommenderPersistenceImpl extends BasePersistenceImpl<RDCRecommender>
	implements RDCRecommenderPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RDCRecommenderUtil} to access the r d c recommender persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RDCRecommenderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
			RDCRecommenderModelImpl.FINDER_CACHE_ENABLED,
			RDCRecommenderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
			RDCRecommenderModelImpl.FINDER_CACHE_ENABLED,
			RDCRecommenderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
			RDCRecommenderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_RECOMMENDATION = new FinderPath(RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
			RDCRecommenderModelImpl.FINDER_CACHE_ENABLED,
			RDCRecommenderImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByRecommendation",
			new String[] { Long.class.getName(), Long.class.getName() },
			RDCRecommenderModelImpl.ORGANISATIONID_COLUMN_BITMASK |
			RDCRecommenderModelImpl.RECOMMENDEDORGANISATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECOMMENDATION = new FinderPath(RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
			RDCRecommenderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRecommendation",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the r d c recommender where organisationId = &#63; and recommendedorganisationId = &#63; or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException} if it could not be found.
	 *
	 * @param organisationId the organisation ID
	 * @param recommendedorganisationId the recommendedorganisation ID
	 * @return the matching r d c recommender
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException if a matching r d c recommender could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCRecommender findByRecommendation(long organisationId,
		long recommendedorganisationId)
		throws NoSuchRDCRecommenderException, SystemException {
		RDCRecommender rdcRecommender = fetchByRecommendation(organisationId,
				recommendedorganisationId);

		if (rdcRecommender == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("organisationId=");
			msg.append(organisationId);

			msg.append(", recommendedorganisationId=");
			msg.append(recommendedorganisationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRDCRecommenderException(msg.toString());
		}

		return rdcRecommender;
	}

	/**
	 * Returns the r d c recommender where organisationId = &#63; and recommendedorganisationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organisationId the organisation ID
	 * @param recommendedorganisationId the recommendedorganisation ID
	 * @return the matching r d c recommender, or <code>null</code> if a matching r d c recommender could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCRecommender fetchByRecommendation(long organisationId,
		long recommendedorganisationId) throws SystemException {
		return fetchByRecommendation(organisationId, recommendedorganisationId,
			true);
	}

	/**
	 * Returns the r d c recommender where organisationId = &#63; and recommendedorganisationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organisationId the organisation ID
	 * @param recommendedorganisationId the recommendedorganisation ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching r d c recommender, or <code>null</code> if a matching r d c recommender could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCRecommender fetchByRecommendation(long organisationId,
		long recommendedorganisationId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				organisationId, recommendedorganisationId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RECOMMENDATION,
					finderArgs, this);
		}

		if (result instanceof RDCRecommender) {
			RDCRecommender rdcRecommender = (RDCRecommender)result;

			if ((organisationId != rdcRecommender.getOrganisationId()) ||
					(recommendedorganisationId != rdcRecommender.getRecommendedorganisationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RDCRECOMMENDER_WHERE);

			query.append(_FINDER_COLUMN_RECOMMENDATION_ORGANISATIONID_2);

			query.append(_FINDER_COLUMN_RECOMMENDATION_RECOMMENDEDORGANISATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationId);

				qPos.add(recommendedorganisationId);

				List<RDCRecommender> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECOMMENDATION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"RDCRecommenderPersistenceImpl.fetchByRecommendation(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					RDCRecommender rdcRecommender = list.get(0);

					result = rdcRecommender;

					cacheResult(rdcRecommender);

					if ((rdcRecommender.getOrganisationId() != organisationId) ||
							(rdcRecommender.getRecommendedorganisationId() != recommendedorganisationId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECOMMENDATION,
							finderArgs, rdcRecommender);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RECOMMENDATION,
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
			return (RDCRecommender)result;
		}
	}

	/**
	 * Removes the r d c recommender where organisationId = &#63; and recommendedorganisationId = &#63; from the database.
	 *
	 * @param organisationId the organisation ID
	 * @param recommendedorganisationId the recommendedorganisation ID
	 * @return the r d c recommender that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCRecommender removeByRecommendation(long organisationId,
		long recommendedorganisationId)
		throws NoSuchRDCRecommenderException, SystemException {
		RDCRecommender rdcRecommender = findByRecommendation(organisationId,
				recommendedorganisationId);

		return remove(rdcRecommender);
	}

	/**
	 * Returns the number of r d c recommenders where organisationId = &#63; and recommendedorganisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param recommendedorganisationId the recommendedorganisation ID
	 * @return the number of matching r d c recommenders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRecommendation(long organisationId,
		long recommendedorganisationId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECOMMENDATION;

		Object[] finderArgs = new Object[] {
				organisationId, recommendedorganisationId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RDCRECOMMENDER_WHERE);

			query.append(_FINDER_COLUMN_RECOMMENDATION_ORGANISATIONID_2);

			query.append(_FINDER_COLUMN_RECOMMENDATION_RECOMMENDEDORGANISATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationId);

				qPos.add(recommendedorganisationId);

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

	private static final String _FINDER_COLUMN_RECOMMENDATION_ORGANISATIONID_2 = "rdcRecommender.organisationId = ? AND ";
	private static final String _FINDER_COLUMN_RECOMMENDATION_RECOMMENDEDORGANISATIONID_2 =
		"rdcRecommender.recommendedorganisationId = ?";

	public RDCRecommenderPersistenceImpl() {
		setModelClass(RDCRecommender.class);
	}

	/**
	 * Caches the r d c recommender in the entity cache if it is enabled.
	 *
	 * @param rdcRecommender the r d c recommender
	 */
	@Override
	public void cacheResult(RDCRecommender rdcRecommender) {
		EntityCacheUtil.putResult(RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
			RDCRecommenderImpl.class, rdcRecommender.getPrimaryKey(),
			rdcRecommender);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECOMMENDATION,
			new Object[] {
				rdcRecommender.getOrganisationId(),
				rdcRecommender.getRecommendedorganisationId()
			}, rdcRecommender);

		rdcRecommender.resetOriginalValues();
	}

	/**
	 * Caches the r d c recommenders in the entity cache if it is enabled.
	 *
	 * @param rdcRecommenders the r d c recommenders
	 */
	@Override
	public void cacheResult(List<RDCRecommender> rdcRecommenders) {
		for (RDCRecommender rdcRecommender : rdcRecommenders) {
			if (EntityCacheUtil.getResult(
						RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
						RDCRecommenderImpl.class, rdcRecommender.getPrimaryKey()) == null) {
				cacheResult(rdcRecommender);
			}
			else {
				rdcRecommender.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all r d c recommenders.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RDCRecommenderImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RDCRecommenderImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the r d c recommender.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RDCRecommender rdcRecommender) {
		EntityCacheUtil.removeResult(RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
			RDCRecommenderImpl.class, rdcRecommender.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(rdcRecommender);
	}

	@Override
	public void clearCache(List<RDCRecommender> rdcRecommenders) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RDCRecommender rdcRecommender : rdcRecommenders) {
			EntityCacheUtil.removeResult(RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
				RDCRecommenderImpl.class, rdcRecommender.getPrimaryKey());

			clearUniqueFindersCache(rdcRecommender);
		}
	}

	protected void cacheUniqueFindersCache(RDCRecommender rdcRecommender) {
		if (rdcRecommender.isNew()) {
			Object[] args = new Object[] {
					rdcRecommender.getOrganisationId(),
					rdcRecommender.getRecommendedorganisationId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECOMMENDATION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECOMMENDATION,
				args, rdcRecommender);
		}
		else {
			RDCRecommenderModelImpl rdcRecommenderModelImpl = (RDCRecommenderModelImpl)rdcRecommender;

			if ((rdcRecommenderModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RECOMMENDATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rdcRecommender.getOrganisationId(),
						rdcRecommender.getRecommendedorganisationId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECOMMENDATION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECOMMENDATION,
					args, rdcRecommender);
			}
		}
	}

	protected void clearUniqueFindersCache(RDCRecommender rdcRecommender) {
		RDCRecommenderModelImpl rdcRecommenderModelImpl = (RDCRecommenderModelImpl)rdcRecommender;

		Object[] args = new Object[] {
				rdcRecommender.getOrganisationId(),
				rdcRecommender.getRecommendedorganisationId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECOMMENDATION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RECOMMENDATION, args);

		if ((rdcRecommenderModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RECOMMENDATION.getColumnBitmask()) != 0) {
			args = new Object[] {
					rdcRecommenderModelImpl.getOriginalOrganisationId(),
					rdcRecommenderModelImpl.getOriginalRecommendedorganisationId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECOMMENDATION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RECOMMENDATION,
				args);
		}
	}

	/**
	 * Creates a new r d c recommender with the primary key. Does not add the r d c recommender to the database.
	 *
	 * @param rdcrecommenderid the primary key for the new r d c recommender
	 * @return the new r d c recommender
	 */
	@Override
	public RDCRecommender create(long rdcrecommenderid) {
		RDCRecommender rdcRecommender = new RDCRecommenderImpl();

		rdcRecommender.setNew(true);
		rdcRecommender.setPrimaryKey(rdcrecommenderid);

		return rdcRecommender;
	}

	/**
	 * Removes the r d c recommender with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rdcrecommenderid the primary key of the r d c recommender
	 * @return the r d c recommender that was removed
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException if a r d c recommender with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCRecommender remove(long rdcrecommenderid)
		throws NoSuchRDCRecommenderException, SystemException {
		return remove((Serializable)rdcrecommenderid);
	}

	/**
	 * Removes the r d c recommender with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the r d c recommender
	 * @return the r d c recommender that was removed
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException if a r d c recommender with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCRecommender remove(Serializable primaryKey)
		throws NoSuchRDCRecommenderException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RDCRecommender rdcRecommender = (RDCRecommender)session.get(RDCRecommenderImpl.class,
					primaryKey);

			if (rdcRecommender == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRDCRecommenderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rdcRecommender);
		}
		catch (NoSuchRDCRecommenderException nsee) {
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
	protected RDCRecommender removeImpl(RDCRecommender rdcRecommender)
		throws SystemException {
		rdcRecommender = toUnwrappedModel(rdcRecommender);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rdcRecommender)) {
				rdcRecommender = (RDCRecommender)session.get(RDCRecommenderImpl.class,
						rdcRecommender.getPrimaryKeyObj());
			}

			if (rdcRecommender != null) {
				session.delete(rdcRecommender);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rdcRecommender != null) {
			clearCache(rdcRecommender);
		}

		return rdcRecommender;
	}

	@Override
	public RDCRecommender updateImpl(
		at.meduni.liferay.portlet.rdconnect.model.RDCRecommender rdcRecommender)
		throws SystemException {
		rdcRecommender = toUnwrappedModel(rdcRecommender);

		boolean isNew = rdcRecommender.isNew();

		Session session = null;

		try {
			session = openSession();

			if (rdcRecommender.isNew()) {
				session.save(rdcRecommender);

				rdcRecommender.setNew(false);
			}
			else {
				session.merge(rdcRecommender);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RDCRecommenderModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
			RDCRecommenderImpl.class, rdcRecommender.getPrimaryKey(),
			rdcRecommender);

		clearUniqueFindersCache(rdcRecommender);
		cacheUniqueFindersCache(rdcRecommender);

		return rdcRecommender;
	}

	protected RDCRecommender toUnwrappedModel(RDCRecommender rdcRecommender) {
		if (rdcRecommender instanceof RDCRecommenderImpl) {
			return rdcRecommender;
		}

		RDCRecommenderImpl rdcRecommenderImpl = new RDCRecommenderImpl();

		rdcRecommenderImpl.setNew(rdcRecommender.isNew());
		rdcRecommenderImpl.setPrimaryKey(rdcRecommender.getPrimaryKey());

		rdcRecommenderImpl.setRdcrecommenderid(rdcRecommender.getRdcrecommenderid());
		rdcRecommenderImpl.setOrganisationId(rdcRecommender.getOrganisationId());
		rdcRecommenderImpl.setRecommendedorganisationId(rdcRecommender.getRecommendedorganisationId());
		rdcRecommenderImpl.setRecommendervalue(rdcRecommender.getRecommendervalue());

		return rdcRecommenderImpl;
	}

	/**
	 * Returns the r d c recommender with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the r d c recommender
	 * @return the r d c recommender
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException if a r d c recommender with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCRecommender findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRDCRecommenderException, SystemException {
		RDCRecommender rdcRecommender = fetchByPrimaryKey(primaryKey);

		if (rdcRecommender == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRDCRecommenderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rdcRecommender;
	}

	/**
	 * Returns the r d c recommender with the primary key or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException} if it could not be found.
	 *
	 * @param rdcrecommenderid the primary key of the r d c recommender
	 * @return the r d c recommender
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException if a r d c recommender with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCRecommender findByPrimaryKey(long rdcrecommenderid)
		throws NoSuchRDCRecommenderException, SystemException {
		return findByPrimaryKey((Serializable)rdcrecommenderid);
	}

	/**
	 * Returns the r d c recommender with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the r d c recommender
	 * @return the r d c recommender, or <code>null</code> if a r d c recommender with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCRecommender fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RDCRecommender rdcRecommender = (RDCRecommender)EntityCacheUtil.getResult(RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
				RDCRecommenderImpl.class, primaryKey);

		if (rdcRecommender == _nullRDCRecommender) {
			return null;
		}

		if (rdcRecommender == null) {
			Session session = null;

			try {
				session = openSession();

				rdcRecommender = (RDCRecommender)session.get(RDCRecommenderImpl.class,
						primaryKey);

				if (rdcRecommender != null) {
					cacheResult(rdcRecommender);
				}
				else {
					EntityCacheUtil.putResult(RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
						RDCRecommenderImpl.class, primaryKey,
						_nullRDCRecommender);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RDCRecommenderModelImpl.ENTITY_CACHE_ENABLED,
					RDCRecommenderImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rdcRecommender;
	}

	/**
	 * Returns the r d c recommender with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rdcrecommenderid the primary key of the r d c recommender
	 * @return the r d c recommender, or <code>null</code> if a r d c recommender with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDCRecommender fetchByPrimaryKey(long rdcrecommenderid)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)rdcrecommenderid);
	}

	/**
	 * Returns all the r d c recommenders.
	 *
	 * @return the r d c recommenders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDCRecommender> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the r d c recommenders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.RDCRecommenderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of r d c recommenders
	 * @param end the upper bound of the range of r d c recommenders (not inclusive)
	 * @return the range of r d c recommenders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDCRecommender> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d c recommenders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.RDCRecommenderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of r d c recommenders
	 * @param end the upper bound of the range of r d c recommenders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of r d c recommenders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDCRecommender> findAll(int start, int end,
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

		List<RDCRecommender> list = (List<RDCRecommender>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RDCRECOMMENDER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RDCRECOMMENDER;

				if (pagination) {
					sql = sql.concat(RDCRecommenderModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RDCRecommender>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDCRecommender>(list);
				}
				else {
					list = (List<RDCRecommender>)QueryUtil.list(q,
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
	 * Removes all the r d c recommenders from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RDCRecommender rdcRecommender : findAll()) {
			remove(rdcRecommender);
		}
	}

	/**
	 * Returns the number of r d c recommenders.
	 *
	 * @return the number of r d c recommenders
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

				Query q = session.createQuery(_SQL_COUNT_RDCRECOMMENDER);

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
	 * Initializes the r d c recommender persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.rdconnect.model.RDCRecommender")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RDCRecommender>> listenersList = new ArrayList<ModelListener<RDCRecommender>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RDCRecommender>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RDCRecommenderImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RDCRECOMMENDER = "SELECT rdcRecommender FROM RDCRecommender rdcRecommender";
	private static final String _SQL_SELECT_RDCRECOMMENDER_WHERE = "SELECT rdcRecommender FROM RDCRecommender rdcRecommender WHERE ";
	private static final String _SQL_COUNT_RDCRECOMMENDER = "SELECT COUNT(rdcRecommender) FROM RDCRecommender rdcRecommender";
	private static final String _SQL_COUNT_RDCRECOMMENDER_WHERE = "SELECT COUNT(rdcRecommender) FROM RDCRecommender rdcRecommender WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rdcRecommender.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RDCRecommender exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RDCRecommender exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RDCRecommenderPersistenceImpl.class);
	private static RDCRecommender _nullRDCRecommender = new RDCRecommenderImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RDCRecommender> toCacheModel() {
				return _nullRDCRecommenderCacheModel;
			}
		};

	private static CacheModel<RDCRecommender> _nullRDCRecommenderCacheModel = new CacheModel<RDCRecommender>() {
			@Override
			public RDCRecommender toEntityModel() {
				return _nullRDCRecommender;
			}
		};
}