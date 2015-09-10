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

package at.graz.hmmc.liferay.portlet.puch.service.persistence;

import at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException;
import at.graz.hmmc.liferay.portlet.puch.model.TransaktionData;
import at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataImpl;
import at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the transaktion data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see TransaktionDataPersistence
 * @see TransaktionDataUtil
 * @generated
 */
public class TransaktionDataPersistenceImpl extends BasePersistenceImpl<TransaktionData>
	implements TransaktionDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TransaktionDataUtil} to access the transaktion data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TransaktionDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionDataModelImpl.FINDER_CACHE_ENABLED,
			TransaktionDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionDataModelImpl.FINDER_CACHE_ENABLED,
			TransaktionDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANSACTION =
		new FinderPath(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionDataModelImpl.FINDER_CACHE_ENABLED,
			TransaktionDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTransaction",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTION =
		new FinderPath(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionDataModelImpl.FINDER_CACHE_ENABLED,
			TransaktionDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTransaction",
			new String[] { Long.class.getName() },
			TransaktionDataModelImpl.TRANSAKTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANSACTION = new FinderPath(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTransaction",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the transaktion datas where transaktionId = &#63;.
	 *
	 * @param transaktionId the transaktion ID
	 * @return the matching transaktion datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TransaktionData> findByTransaction(long transaktionId)
		throws SystemException {
		return findByTransaction(transaktionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the transaktion datas where transaktionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param transaktionId the transaktion ID
	 * @param start the lower bound of the range of transaktion datas
	 * @param end the upper bound of the range of transaktion datas (not inclusive)
	 * @return the range of matching transaktion datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TransaktionData> findByTransaction(long transaktionId,
		int start, int end) throws SystemException {
		return findByTransaction(transaktionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the transaktion datas where transaktionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param transaktionId the transaktion ID
	 * @param start the lower bound of the range of transaktion datas
	 * @param end the upper bound of the range of transaktion datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching transaktion datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TransaktionData> findByTransaction(long transaktionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTION;
			finderArgs = new Object[] { transaktionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANSACTION;
			finderArgs = new Object[] {
					transaktionId,
					
					start, end, orderByComparator
				};
		}

		List<TransaktionData> list = (List<TransaktionData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TransaktionData transaktionData : list) {
				if ((transaktionId != transaktionData.getTransaktionId())) {
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

			query.append(_SQL_SELECT_TRANSAKTIONDATA_WHERE);

			query.append(_FINDER_COLUMN_TRANSACTION_TRANSAKTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TransaktionDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(transaktionId);

				if (!pagination) {
					list = (List<TransaktionData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TransaktionData>(list);
				}
				else {
					list = (List<TransaktionData>)QueryUtil.list(q,
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
	 * Returns the first transaktion data in the ordered set where transaktionId = &#63;.
	 *
	 * @param transaktionId the transaktion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transaktion data
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a matching transaktion data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData findByTransaction_First(long transaktionId,
		OrderByComparator orderByComparator)
		throws NoSuchTransaktionDataException, SystemException {
		TransaktionData transaktionData = fetchByTransaction_First(transaktionId,
				orderByComparator);

		if (transaktionData != null) {
			return transaktionData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("transaktionId=");
		msg.append(transaktionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTransaktionDataException(msg.toString());
	}

	/**
	 * Returns the first transaktion data in the ordered set where transaktionId = &#63;.
	 *
	 * @param transaktionId the transaktion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching transaktion data, or <code>null</code> if a matching transaktion data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData fetchByTransaction_First(long transaktionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TransaktionData> list = findByTransaction(transaktionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last transaktion data in the ordered set where transaktionId = &#63;.
	 *
	 * @param transaktionId the transaktion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transaktion data
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a matching transaktion data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData findByTransaction_Last(long transaktionId,
		OrderByComparator orderByComparator)
		throws NoSuchTransaktionDataException, SystemException {
		TransaktionData transaktionData = fetchByTransaction_Last(transaktionId,
				orderByComparator);

		if (transaktionData != null) {
			return transaktionData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("transaktionId=");
		msg.append(transaktionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTransaktionDataException(msg.toString());
	}

	/**
	 * Returns the last transaktion data in the ordered set where transaktionId = &#63;.
	 *
	 * @param transaktionId the transaktion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching transaktion data, or <code>null</code> if a matching transaktion data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData fetchByTransaction_Last(long transaktionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTransaction(transaktionId);

		if (count == 0) {
			return null;
		}

		List<TransaktionData> list = findByTransaction(transaktionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the transaktion datas before and after the current transaktion data in the ordered set where transaktionId = &#63;.
	 *
	 * @param transaktiondataId the primary key of the current transaktion data
	 * @param transaktionId the transaktion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next transaktion data
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a transaktion data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData[] findByTransaction_PrevAndNext(
		long transaktiondataId, long transaktionId,
		OrderByComparator orderByComparator)
		throws NoSuchTransaktionDataException, SystemException {
		TransaktionData transaktionData = findByPrimaryKey(transaktiondataId);

		Session session = null;

		try {
			session = openSession();

			TransaktionData[] array = new TransaktionDataImpl[3];

			array[0] = getByTransaction_PrevAndNext(session, transaktionData,
					transaktionId, orderByComparator, true);

			array[1] = transaktionData;

			array[2] = getByTransaction_PrevAndNext(session, transaktionData,
					transaktionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TransaktionData getByTransaction_PrevAndNext(Session session,
		TransaktionData transaktionData, long transaktionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRANSAKTIONDATA_WHERE);

		query.append(_FINDER_COLUMN_TRANSACTION_TRANSAKTIONID_2);

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
			query.append(TransaktionDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(transaktionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(transaktionData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TransaktionData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the transaktion datas where transaktionId = &#63; from the database.
	 *
	 * @param transaktionId the transaktion ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTransaction(long transaktionId)
		throws SystemException {
		for (TransaktionData transaktionData : findByTransaction(
				transaktionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(transaktionData);
		}
	}

	/**
	 * Returns the number of transaktion datas where transaktionId = &#63;.
	 *
	 * @param transaktionId the transaktion ID
	 * @return the number of matching transaktion datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTransaction(long transaktionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TRANSACTION;

		Object[] finderArgs = new Object[] { transaktionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANSAKTIONDATA_WHERE);

			query.append(_FINDER_COLUMN_TRANSACTION_TRANSAKTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(transaktionId);

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

	private static final String _FINDER_COLUMN_TRANSACTION_TRANSAKTIONID_2 = "transaktionData.transaktionId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_DATABYONTOLOGY = new FinderPath(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionDataModelImpl.FINDER_CACHE_ENABLED,
			TransaktionDataImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByDataByOntology",
			new String[] { Long.class.getName(), String.class.getName() },
			TransaktionDataModelImpl.TRANSAKTIONID_COLUMN_BITMASK |
			TransaktionDataModelImpl.OBJECTKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DATABYONTOLOGY = new FinderPath(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataByOntology",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the transaktion data where transaktionId = &#63; and objectkey = &#63; or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException} if it could not be found.
	 *
	 * @param transaktionId the transaktion ID
	 * @param objectkey the objectkey
	 * @return the matching transaktion data
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a matching transaktion data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData findByDataByOntology(long transaktionId,
		String objectkey)
		throws NoSuchTransaktionDataException, SystemException {
		TransaktionData transaktionData = fetchByDataByOntology(transaktionId,
				objectkey);

		if (transaktionData == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("transaktionId=");
			msg.append(transaktionId);

			msg.append(", objectkey=");
			msg.append(objectkey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTransaktionDataException(msg.toString());
		}

		return transaktionData;
	}

	/**
	 * Returns the transaktion data where transaktionId = &#63; and objectkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param transaktionId the transaktion ID
	 * @param objectkey the objectkey
	 * @return the matching transaktion data, or <code>null</code> if a matching transaktion data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData fetchByDataByOntology(long transaktionId,
		String objectkey) throws SystemException {
		return fetchByDataByOntology(transaktionId, objectkey, true);
	}

	/**
	 * Returns the transaktion data where transaktionId = &#63; and objectkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param transaktionId the transaktion ID
	 * @param objectkey the objectkey
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching transaktion data, or <code>null</code> if a matching transaktion data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData fetchByDataByOntology(long transaktionId,
		String objectkey, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { transaktionId, objectkey };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
					finderArgs, this);
		}

		if (result instanceof TransaktionData) {
			TransaktionData transaktionData = (TransaktionData)result;

			if ((transaktionId != transaktionData.getTransaktionId()) ||
					!Validator.equals(objectkey, transaktionData.getObjectkey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TRANSAKTIONDATA_WHERE);

			query.append(_FINDER_COLUMN_DATABYONTOLOGY_TRANSAKTIONID_2);

			boolean bindObjectkey = false;

			if (objectkey == null) {
				query.append(_FINDER_COLUMN_DATABYONTOLOGY_OBJECTKEY_1);
			}
			else if (objectkey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DATABYONTOLOGY_OBJECTKEY_3);
			}
			else {
				bindObjectkey = true;

				query.append(_FINDER_COLUMN_DATABYONTOLOGY_OBJECTKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(transaktionId);

				if (bindObjectkey) {
					qPos.add(objectkey);
				}

				List<TransaktionData> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TransaktionDataPersistenceImpl.fetchByDataByOntology(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TransaktionData transaktionData = list.get(0);

					result = transaktionData;

					cacheResult(transaktionData);

					if ((transaktionData.getTransaktionId() != transaktionId) ||
							(transaktionData.getObjectkey() == null) ||
							!transaktionData.getObjectkey().equals(objectkey)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
							finderArgs, transaktionData);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
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
			return (TransaktionData)result;
		}
	}

	/**
	 * Removes the transaktion data where transaktionId = &#63; and objectkey = &#63; from the database.
	 *
	 * @param transaktionId the transaktion ID
	 * @param objectkey the objectkey
	 * @return the transaktion data that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData removeByDataByOntology(long transaktionId,
		String objectkey)
		throws NoSuchTransaktionDataException, SystemException {
		TransaktionData transaktionData = findByDataByOntology(transaktionId,
				objectkey);

		return remove(transaktionData);
	}

	/**
	 * Returns the number of transaktion datas where transaktionId = &#63; and objectkey = &#63;.
	 *
	 * @param transaktionId the transaktion ID
	 * @param objectkey the objectkey
	 * @return the number of matching transaktion datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDataByOntology(long transaktionId, String objectkey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DATABYONTOLOGY;

		Object[] finderArgs = new Object[] { transaktionId, objectkey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRANSAKTIONDATA_WHERE);

			query.append(_FINDER_COLUMN_DATABYONTOLOGY_TRANSAKTIONID_2);

			boolean bindObjectkey = false;

			if (objectkey == null) {
				query.append(_FINDER_COLUMN_DATABYONTOLOGY_OBJECTKEY_1);
			}
			else if (objectkey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DATABYONTOLOGY_OBJECTKEY_3);
			}
			else {
				bindObjectkey = true;

				query.append(_FINDER_COLUMN_DATABYONTOLOGY_OBJECTKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(transaktionId);

				if (bindObjectkey) {
					qPos.add(objectkey);
				}

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

	private static final String _FINDER_COLUMN_DATABYONTOLOGY_TRANSAKTIONID_2 = "transaktionData.transaktionId = ? AND ";
	private static final String _FINDER_COLUMN_DATABYONTOLOGY_OBJECTKEY_1 = "transaktionData.objectkey IS NULL";
	private static final String _FINDER_COLUMN_DATABYONTOLOGY_OBJECTKEY_2 = "transaktionData.objectkey = ?";
	private static final String _FINDER_COLUMN_DATABYONTOLOGY_OBJECTKEY_3 = "(transaktionData.objectkey IS NULL OR transaktionData.objectkey = '')";

	public TransaktionDataPersistenceImpl() {
		setModelClass(TransaktionData.class);
	}

	/**
	 * Caches the transaktion data in the entity cache if it is enabled.
	 *
	 * @param transaktionData the transaktion data
	 */
	@Override
	public void cacheResult(TransaktionData transaktionData) {
		EntityCacheUtil.putResult(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionDataImpl.class, transaktionData.getPrimaryKey(),
			transaktionData);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
			new Object[] {
				transaktionData.getTransaktionId(),
				transaktionData.getObjectkey()
			}, transaktionData);

		transaktionData.resetOriginalValues();
	}

	/**
	 * Caches the transaktion datas in the entity cache if it is enabled.
	 *
	 * @param transaktionDatas the transaktion datas
	 */
	@Override
	public void cacheResult(List<TransaktionData> transaktionDatas) {
		for (TransaktionData transaktionData : transaktionDatas) {
			if (EntityCacheUtil.getResult(
						TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
						TransaktionDataImpl.class,
						transaktionData.getPrimaryKey()) == null) {
				cacheResult(transaktionData);
			}
			else {
				transaktionData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all transaktion datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TransaktionDataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TransaktionDataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the transaktion data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TransaktionData transaktionData) {
		EntityCacheUtil.removeResult(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionDataImpl.class, transaktionData.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(transaktionData);
	}

	@Override
	public void clearCache(List<TransaktionData> transaktionDatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TransaktionData transaktionData : transaktionDatas) {
			EntityCacheUtil.removeResult(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
				TransaktionDataImpl.class, transaktionData.getPrimaryKey());

			clearUniqueFindersCache(transaktionData);
		}
	}

	protected void cacheUniqueFindersCache(TransaktionData transaktionData) {
		if (transaktionData.isNew()) {
			Object[] args = new Object[] {
					transaktionData.getTransaktionId(),
					transaktionData.getObjectkey()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATABYONTOLOGY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
				args, transaktionData);
		}
		else {
			TransaktionDataModelImpl transaktionDataModelImpl = (TransaktionDataModelImpl)transaktionData;

			if ((transaktionDataModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DATABYONTOLOGY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						transaktionData.getTransaktionId(),
						transaktionData.getObjectkey()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATABYONTOLOGY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
					args, transaktionData);
			}
		}
	}

	protected void clearUniqueFindersCache(TransaktionData transaktionData) {
		TransaktionDataModelImpl transaktionDataModelImpl = (TransaktionDataModelImpl)transaktionData;

		Object[] args = new Object[] {
				transaktionData.getTransaktionId(),
				transaktionData.getObjectkey()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATABYONTOLOGY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY, args);

		if ((transaktionDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DATABYONTOLOGY.getColumnBitmask()) != 0) {
			args = new Object[] {
					transaktionDataModelImpl.getOriginalTransaktionId(),
					transaktionDataModelImpl.getOriginalObjectkey()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATABYONTOLOGY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
				args);
		}
	}

	/**
	 * Creates a new transaktion data with the primary key. Does not add the transaktion data to the database.
	 *
	 * @param transaktiondataId the primary key for the new transaktion data
	 * @return the new transaktion data
	 */
	@Override
	public TransaktionData create(long transaktiondataId) {
		TransaktionData transaktionData = new TransaktionDataImpl();

		transaktionData.setNew(true);
		transaktionData.setPrimaryKey(transaktiondataId);

		return transaktionData;
	}

	/**
	 * Removes the transaktion data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transaktiondataId the primary key of the transaktion data
	 * @return the transaktion data that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a transaktion data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData remove(long transaktiondataId)
		throws NoSuchTransaktionDataException, SystemException {
		return remove((Serializable)transaktiondataId);
	}

	/**
	 * Removes the transaktion data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the transaktion data
	 * @return the transaktion data that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a transaktion data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData remove(Serializable primaryKey)
		throws NoSuchTransaktionDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TransaktionData transaktionData = (TransaktionData)session.get(TransaktionDataImpl.class,
					primaryKey);

			if (transaktionData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTransaktionDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(transaktionData);
		}
		catch (NoSuchTransaktionDataException nsee) {
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
	protected TransaktionData removeImpl(TransaktionData transaktionData)
		throws SystemException {
		transaktionData = toUnwrappedModel(transaktionData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(transaktionData)) {
				transaktionData = (TransaktionData)session.get(TransaktionDataImpl.class,
						transaktionData.getPrimaryKeyObj());
			}

			if (transaktionData != null) {
				session.delete(transaktionData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (transaktionData != null) {
			clearCache(transaktionData);
		}

		return transaktionData;
	}

	@Override
	public TransaktionData updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.TransaktionData transaktionData)
		throws SystemException {
		transaktionData = toUnwrappedModel(transaktionData);

		boolean isNew = transaktionData.isNew();

		TransaktionDataModelImpl transaktionDataModelImpl = (TransaktionDataModelImpl)transaktionData;

		Session session = null;

		try {
			session = openSession();

			if (transaktionData.isNew()) {
				session.save(transaktionData);

				transaktionData.setNew(false);
			}
			else {
				session.merge(transaktionData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TransaktionDataModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((transaktionDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						transaktionDataModelImpl.getOriginalTransaktionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANSACTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTION,
					args);

				args = new Object[] { transaktionDataModelImpl.getTransaktionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANSACTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTION,
					args);
			}
		}

		EntityCacheUtil.putResult(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
			TransaktionDataImpl.class, transaktionData.getPrimaryKey(),
			transaktionData);

		clearUniqueFindersCache(transaktionData);
		cacheUniqueFindersCache(transaktionData);

		return transaktionData;
	}

	protected TransaktionData toUnwrappedModel(TransaktionData transaktionData) {
		if (transaktionData instanceof TransaktionDataImpl) {
			return transaktionData;
		}

		TransaktionDataImpl transaktionDataImpl = new TransaktionDataImpl();

		transaktionDataImpl.setNew(transaktionData.isNew());
		transaktionDataImpl.setPrimaryKey(transaktionData.getPrimaryKey());

		transaktionDataImpl.setTransaktiondataId(transaktionData.getTransaktiondataId());
		transaktionDataImpl.setPuchmuseumsobjectId(transaktionData.getPuchmuseumsobjectId());
		transaktionDataImpl.setTransaktionId(transaktionData.getTransaktionId());
		transaktionDataImpl.setObjectkey(transaktionData.getObjectkey());
		transaktionDataImpl.setObjectvalue(transaktionData.getObjectvalue());

		return transaktionDataImpl;
	}

	/**
	 * Returns the transaktion data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the transaktion data
	 * @return the transaktion data
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a transaktion data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTransaktionDataException, SystemException {
		TransaktionData transaktionData = fetchByPrimaryKey(primaryKey);

		if (transaktionData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTransaktionDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return transaktionData;
	}

	/**
	 * Returns the transaktion data with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException} if it could not be found.
	 *
	 * @param transaktiondataId the primary key of the transaktion data
	 * @return the transaktion data
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a transaktion data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData findByPrimaryKey(long transaktiondataId)
		throws NoSuchTransaktionDataException, SystemException {
		return findByPrimaryKey((Serializable)transaktiondataId);
	}

	/**
	 * Returns the transaktion data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the transaktion data
	 * @return the transaktion data, or <code>null</code> if a transaktion data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TransaktionData transaktionData = (TransaktionData)EntityCacheUtil.getResult(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
				TransaktionDataImpl.class, primaryKey);

		if (transaktionData == _nullTransaktionData) {
			return null;
		}

		if (transaktionData == null) {
			Session session = null;

			try {
				session = openSession();

				transaktionData = (TransaktionData)session.get(TransaktionDataImpl.class,
						primaryKey);

				if (transaktionData != null) {
					cacheResult(transaktionData);
				}
				else {
					EntityCacheUtil.putResult(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
						TransaktionDataImpl.class, primaryKey,
						_nullTransaktionData);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TransaktionDataModelImpl.ENTITY_CACHE_ENABLED,
					TransaktionDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return transaktionData;
	}

	/**
	 * Returns the transaktion data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transaktiondataId the primary key of the transaktion data
	 * @return the transaktion data, or <code>null</code> if a transaktion data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TransaktionData fetchByPrimaryKey(long transaktiondataId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)transaktiondataId);
	}

	/**
	 * Returns all the transaktion datas.
	 *
	 * @return the transaktion datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TransaktionData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the transaktion datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaktion datas
	 * @param end the upper bound of the range of transaktion datas (not inclusive)
	 * @return the range of transaktion datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TransaktionData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the transaktion datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaktion datas
	 * @param end the upper bound of the range of transaktion datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of transaktion datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TransaktionData> findAll(int start, int end,
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

		List<TransaktionData> list = (List<TransaktionData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRANSAKTIONDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRANSAKTIONDATA;

				if (pagination) {
					sql = sql.concat(TransaktionDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TransaktionData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TransaktionData>(list);
				}
				else {
					list = (List<TransaktionData>)QueryUtil.list(q,
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
	 * Removes all the transaktion datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TransaktionData transaktionData : findAll()) {
			remove(transaktionData);
		}
	}

	/**
	 * Returns the number of transaktion datas.
	 *
	 * @return the number of transaktion datas
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

				Query q = session.createQuery(_SQL_COUNT_TRANSAKTIONDATA);

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
	 * Initializes the transaktion data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.hmmc.liferay.portlet.puch.model.TransaktionData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TransaktionData>> listenersList = new ArrayList<ModelListener<TransaktionData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TransaktionData>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TransaktionDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TRANSAKTIONDATA = "SELECT transaktionData FROM TransaktionData transaktionData";
	private static final String _SQL_SELECT_TRANSAKTIONDATA_WHERE = "SELECT transaktionData FROM TransaktionData transaktionData WHERE ";
	private static final String _SQL_COUNT_TRANSAKTIONDATA = "SELECT COUNT(transaktionData) FROM TransaktionData transaktionData";
	private static final String _SQL_COUNT_TRANSAKTIONDATA_WHERE = "SELECT COUNT(transaktionData) FROM TransaktionData transaktionData WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "transaktionData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TransaktionData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TransaktionData exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TransaktionDataPersistenceImpl.class);
	private static TransaktionData _nullTransaktionData = new TransaktionDataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TransaktionData> toCacheModel() {
				return _nullTransaktionDataCacheModel;
			}
		};

	private static CacheModel<TransaktionData> _nullTransaktionDataCacheModel = new CacheModel<TransaktionData>() {
			@Override
			public TransaktionData toEntityModel() {
				return _nullTransaktionData;
			}
		};
}