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

import at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException;
import at.meduni.liferay.portlet.rdconnect.model.AQRRating;
import at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingImpl;
import at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingModelImpl;

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
 * The persistence implementation for the a q r rating service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see AQRRatingPersistence
 * @see AQRRatingUtil
 * @generated
 */
public class AQRRatingPersistenceImpl extends BasePersistenceImpl<AQRRating>
	implements AQRRatingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AQRRatingUtil} to access the a q r rating persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AQRRatingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
			AQRRatingModelImpl.FINDER_CACHE_ENABLED, AQRRatingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
			AQRRatingModelImpl.FINDER_CACHE_ENABLED, AQRRatingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
			AQRRatingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTER = new FinderPath(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
			AQRRatingModelImpl.FINDER_CACHE_ENABLED, AQRRatingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMaster",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTER =
		new FinderPath(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
			AQRRatingModelImpl.FINDER_CACHE_ENABLED, AQRRatingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMaster",
			new String[] { Long.class.getName() },
			AQRRatingModelImpl.MASTERCANDIDATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASTER = new FinderPath(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
			AQRRatingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaster",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the a q r ratings where masterCandidateId = &#63;.
	 *
	 * @param masterCandidateId the master candidate ID
	 * @return the matching a q r ratings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AQRRating> findByMaster(long masterCandidateId)
		throws SystemException {
		return findByMaster(masterCandidateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a q r ratings where masterCandidateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterCandidateId the master candidate ID
	 * @param start the lower bound of the range of a q r ratings
	 * @param end the upper bound of the range of a q r ratings (not inclusive)
	 * @return the range of matching a q r ratings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AQRRating> findByMaster(long masterCandidateId, int start,
		int end) throws SystemException {
		return findByMaster(masterCandidateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a q r ratings where masterCandidateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterCandidateId the master candidate ID
	 * @param start the lower bound of the range of a q r ratings
	 * @param end the upper bound of the range of a q r ratings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a q r ratings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AQRRating> findByMaster(long masterCandidateId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTER;
			finderArgs = new Object[] { masterCandidateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTER;
			finderArgs = new Object[] {
					masterCandidateId,
					
					start, end, orderByComparator
				};
		}

		List<AQRRating> list = (List<AQRRating>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AQRRating aqrRating : list) {
				if ((masterCandidateId != aqrRating.getMasterCandidateId())) {
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

			query.append(_SQL_SELECT_AQRRATING_WHERE);

			query.append(_FINDER_COLUMN_MASTER_MASTERCANDIDATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AQRRatingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterCandidateId);

				if (!pagination) {
					list = (List<AQRRating>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AQRRating>(list);
				}
				else {
					list = (List<AQRRating>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first a q r rating in the ordered set where masterCandidateId = &#63;.
	 *
	 * @param masterCandidateId the master candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a q r rating
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException if a matching a q r rating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AQRRating findByMaster_First(long masterCandidateId,
		OrderByComparator orderByComparator)
		throws NoSuchAQRRatingException, SystemException {
		AQRRating aqrRating = fetchByMaster_First(masterCandidateId,
				orderByComparator);

		if (aqrRating != null) {
			return aqrRating;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterCandidateId=");
		msg.append(masterCandidateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAQRRatingException(msg.toString());
	}

	/**
	 * Returns the first a q r rating in the ordered set where masterCandidateId = &#63;.
	 *
	 * @param masterCandidateId the master candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a q r rating, or <code>null</code> if a matching a q r rating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AQRRating fetchByMaster_First(long masterCandidateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AQRRating> list = findByMaster(masterCandidateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a q r rating in the ordered set where masterCandidateId = &#63;.
	 *
	 * @param masterCandidateId the master candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a q r rating
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException if a matching a q r rating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AQRRating findByMaster_Last(long masterCandidateId,
		OrderByComparator orderByComparator)
		throws NoSuchAQRRatingException, SystemException {
		AQRRating aqrRating = fetchByMaster_Last(masterCandidateId,
				orderByComparator);

		if (aqrRating != null) {
			return aqrRating;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterCandidateId=");
		msg.append(masterCandidateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAQRRatingException(msg.toString());
	}

	/**
	 * Returns the last a q r rating in the ordered set where masterCandidateId = &#63;.
	 *
	 * @param masterCandidateId the master candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a q r rating, or <code>null</code> if a matching a q r rating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AQRRating fetchByMaster_Last(long masterCandidateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMaster(masterCandidateId);

		if (count == 0) {
			return null;
		}

		List<AQRRating> list = findByMaster(masterCandidateId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a q r ratings before and after the current a q r rating in the ordered set where masterCandidateId = &#63;.
	 *
	 * @param aqrId the primary key of the current a q r rating
	 * @param masterCandidateId the master candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a q r rating
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException if a a q r rating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AQRRating[] findByMaster_PrevAndNext(long aqrId,
		long masterCandidateId, OrderByComparator orderByComparator)
		throws NoSuchAQRRatingException, SystemException {
		AQRRating aqrRating = findByPrimaryKey(aqrId);

		Session session = null;

		try {
			session = openSession();

			AQRRating[] array = new AQRRatingImpl[3];

			array[0] = getByMaster_PrevAndNext(session, aqrRating,
					masterCandidateId, orderByComparator, true);

			array[1] = aqrRating;

			array[2] = getByMaster_PrevAndNext(session, aqrRating,
					masterCandidateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AQRRating getByMaster_PrevAndNext(Session session,
		AQRRating aqrRating, long masterCandidateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AQRRATING_WHERE);

		query.append(_FINDER_COLUMN_MASTER_MASTERCANDIDATEID_2);

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
			query.append(AQRRatingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(masterCandidateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(aqrRating);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AQRRating> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a q r ratings where masterCandidateId = &#63; from the database.
	 *
	 * @param masterCandidateId the master candidate ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMaster(long masterCandidateId)
		throws SystemException {
		for (AQRRating aqrRating : findByMaster(masterCandidateId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(aqrRating);
		}
	}

	/**
	 * Returns the number of a q r ratings where masterCandidateId = &#63;.
	 *
	 * @param masterCandidateId the master candidate ID
	 * @return the number of matching a q r ratings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMaster(long masterCandidateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MASTER;

		Object[] finderArgs = new Object[] { masterCandidateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AQRRATING_WHERE);

			query.append(_FINDER_COLUMN_MASTER_MASTERCANDIDATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterCandidateId);

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

	private static final String _FINDER_COLUMN_MASTER_MASTERCANDIDATEID_2 = "aqrRating.masterCandidateId = ?";

	public AQRRatingPersistenceImpl() {
		setModelClass(AQRRating.class);
	}

	/**
	 * Caches the a q r rating in the entity cache if it is enabled.
	 *
	 * @param aqrRating the a q r rating
	 */
	@Override
	public void cacheResult(AQRRating aqrRating) {
		EntityCacheUtil.putResult(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
			AQRRatingImpl.class, aqrRating.getPrimaryKey(), aqrRating);

		aqrRating.resetOriginalValues();
	}

	/**
	 * Caches the a q r ratings in the entity cache if it is enabled.
	 *
	 * @param aqrRatings the a q r ratings
	 */
	@Override
	public void cacheResult(List<AQRRating> aqrRatings) {
		for (AQRRating aqrRating : aqrRatings) {
			if (EntityCacheUtil.getResult(
						AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
						AQRRatingImpl.class, aqrRating.getPrimaryKey()) == null) {
				cacheResult(aqrRating);
			}
			else {
				aqrRating.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all a q r ratings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AQRRatingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AQRRatingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the a q r rating.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AQRRating aqrRating) {
		EntityCacheUtil.removeResult(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
			AQRRatingImpl.class, aqrRating.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AQRRating> aqrRatings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AQRRating aqrRating : aqrRatings) {
			EntityCacheUtil.removeResult(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
				AQRRatingImpl.class, aqrRating.getPrimaryKey());
		}
	}

	/**
	 * Creates a new a q r rating with the primary key. Does not add the a q r rating to the database.
	 *
	 * @param aqrId the primary key for the new a q r rating
	 * @return the new a q r rating
	 */
	@Override
	public AQRRating create(long aqrId) {
		AQRRating aqrRating = new AQRRatingImpl();

		aqrRating.setNew(true);
		aqrRating.setPrimaryKey(aqrId);

		return aqrRating;
	}

	/**
	 * Removes the a q r rating with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param aqrId the primary key of the a q r rating
	 * @return the a q r rating that was removed
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException if a a q r rating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AQRRating remove(long aqrId)
		throws NoSuchAQRRatingException, SystemException {
		return remove((Serializable)aqrId);
	}

	/**
	 * Removes the a q r rating with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the a q r rating
	 * @return the a q r rating that was removed
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException if a a q r rating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AQRRating remove(Serializable primaryKey)
		throws NoSuchAQRRatingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AQRRating aqrRating = (AQRRating)session.get(AQRRatingImpl.class,
					primaryKey);

			if (aqrRating == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAQRRatingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(aqrRating);
		}
		catch (NoSuchAQRRatingException nsee) {
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
	protected AQRRating removeImpl(AQRRating aqrRating)
		throws SystemException {
		aqrRating = toUnwrappedModel(aqrRating);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(aqrRating)) {
				aqrRating = (AQRRating)session.get(AQRRatingImpl.class,
						aqrRating.getPrimaryKeyObj());
			}

			if (aqrRating != null) {
				session.delete(aqrRating);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (aqrRating != null) {
			clearCache(aqrRating);
		}

		return aqrRating;
	}

	@Override
	public AQRRating updateImpl(
		at.meduni.liferay.portlet.rdconnect.model.AQRRating aqrRating)
		throws SystemException {
		aqrRating = toUnwrappedModel(aqrRating);

		boolean isNew = aqrRating.isNew();

		AQRRatingModelImpl aqrRatingModelImpl = (AQRRatingModelImpl)aqrRating;

		Session session = null;

		try {
			session = openSession();

			if (aqrRating.isNew()) {
				session.save(aqrRating);

				aqrRating.setNew(false);
			}
			else {
				session.merge(aqrRating);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AQRRatingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((aqrRatingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						aqrRatingModelImpl.getOriginalMasterCandidateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTER,
					args);

				args = new Object[] { aqrRatingModelImpl.getMasterCandidateId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTER,
					args);
			}
		}

		EntityCacheUtil.putResult(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
			AQRRatingImpl.class, aqrRating.getPrimaryKey(), aqrRating);

		return aqrRating;
	}

	protected AQRRating toUnwrappedModel(AQRRating aqrRating) {
		if (aqrRating instanceof AQRRatingImpl) {
			return aqrRating;
		}

		AQRRatingImpl aqrRatingImpl = new AQRRatingImpl();

		aqrRatingImpl.setNew(aqrRating.isNew());
		aqrRatingImpl.setPrimaryKey(aqrRating.getPrimaryKey());

		aqrRatingImpl.setAqrId(aqrRating.getAqrId());
		aqrRatingImpl.setAccessability(aqrRating.getAccessability());
		aqrRatingImpl.setQuality(aqrRating.getQuality());
		aqrRatingImpl.setRelevance(aqrRating.getRelevance());
		aqrRatingImpl.setMasterCandidateId(aqrRating.getMasterCandidateId());
		aqrRatingImpl.setAqrrater(aqrRating.getAqrrater());
		aqrRatingImpl.setRatingtype(aqrRating.getRatingtype());

		return aqrRatingImpl;
	}

	/**
	 * Returns the a q r rating with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the a q r rating
	 * @return the a q r rating
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException if a a q r rating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AQRRating findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAQRRatingException, SystemException {
		AQRRating aqrRating = fetchByPrimaryKey(primaryKey);

		if (aqrRating == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAQRRatingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return aqrRating;
	}

	/**
	 * Returns the a q r rating with the primary key or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException} if it could not be found.
	 *
	 * @param aqrId the primary key of the a q r rating
	 * @return the a q r rating
	 * @throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException if a a q r rating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AQRRating findByPrimaryKey(long aqrId)
		throws NoSuchAQRRatingException, SystemException {
		return findByPrimaryKey((Serializable)aqrId);
	}

	/**
	 * Returns the a q r rating with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the a q r rating
	 * @return the a q r rating, or <code>null</code> if a a q r rating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AQRRating fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AQRRating aqrRating = (AQRRating)EntityCacheUtil.getResult(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
				AQRRatingImpl.class, primaryKey);

		if (aqrRating == _nullAQRRating) {
			return null;
		}

		if (aqrRating == null) {
			Session session = null;

			try {
				session = openSession();

				aqrRating = (AQRRating)session.get(AQRRatingImpl.class,
						primaryKey);

				if (aqrRating != null) {
					cacheResult(aqrRating);
				}
				else {
					EntityCacheUtil.putResult(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
						AQRRatingImpl.class, primaryKey, _nullAQRRating);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AQRRatingModelImpl.ENTITY_CACHE_ENABLED,
					AQRRatingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return aqrRating;
	}

	/**
	 * Returns the a q r rating with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param aqrId the primary key of the a q r rating
	 * @return the a q r rating, or <code>null</code> if a a q r rating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AQRRating fetchByPrimaryKey(long aqrId) throws SystemException {
		return fetchByPrimaryKey((Serializable)aqrId);
	}

	/**
	 * Returns all the a q r ratings.
	 *
	 * @return the a q r ratings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AQRRating> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a q r ratings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a q r ratings
	 * @param end the upper bound of the range of a q r ratings (not inclusive)
	 * @return the range of a q r ratings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AQRRating> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the a q r ratings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a q r ratings
	 * @param end the upper bound of the range of a q r ratings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of a q r ratings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AQRRating> findAll(int start, int end,
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

		List<AQRRating> list = (List<AQRRating>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AQRRATING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AQRRATING;

				if (pagination) {
					sql = sql.concat(AQRRatingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AQRRating>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AQRRating>(list);
				}
				else {
					list = (List<AQRRating>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the a q r ratings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AQRRating aqrRating : findAll()) {
			remove(aqrRating);
		}
	}

	/**
	 * Returns the number of a q r ratings.
	 *
	 * @return the number of a q r ratings
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

				Query q = session.createQuery(_SQL_COUNT_AQRRATING);

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
	 * Initializes the a q r rating persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.rdconnect.model.AQRRating")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AQRRating>> listenersList = new ArrayList<ModelListener<AQRRating>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AQRRating>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AQRRatingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_AQRRATING = "SELECT aqrRating FROM AQRRating aqrRating";
	private static final String _SQL_SELECT_AQRRATING_WHERE = "SELECT aqrRating FROM AQRRating aqrRating WHERE ";
	private static final String _SQL_COUNT_AQRRATING = "SELECT COUNT(aqrRating) FROM AQRRating aqrRating";
	private static final String _SQL_COUNT_AQRRATING_WHERE = "SELECT COUNT(aqrRating) FROM AQRRating aqrRating WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "aqrRating.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AQRRating exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AQRRating exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AQRRatingPersistenceImpl.class);
	private static AQRRating _nullAQRRating = new AQRRatingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AQRRating> toCacheModel() {
				return _nullAQRRatingCacheModel;
			}
		};

	private static CacheModel<AQRRating> _nullAQRRatingCacheModel = new CacheModel<AQRRating>() {
			@Override
			public AQRRating toEntityModel() {
				return _nullAQRRating;
			}
		};
}