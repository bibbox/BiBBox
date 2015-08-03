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

import at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException;
import at.graz.hmmc.liferay.portlet.puch.model.ObjectData;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataImpl;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataModelImpl;

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
 * The persistence implementation for the object data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ObjectDataPersistence
 * @see ObjectDataUtil
 * @generated
 */
public class ObjectDataPersistenceImpl extends BasePersistenceImpl<ObjectData>
	implements ObjectDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ObjectDataUtil} to access the object data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ObjectDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
			ObjectDataModelImpl.FINDER_CACHE_ENABLED, ObjectDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
			ObjectDataModelImpl.FINDER_CACHE_ENABLED, ObjectDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
			ObjectDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENT = new FinderPath(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
			ObjectDataModelImpl.FINDER_CACHE_ENABLED, ObjectDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEvent",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENT = new FinderPath(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
			ObjectDataModelImpl.FINDER_CACHE_ENABLED, ObjectDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEvent",
			new String[] { Long.class.getName() },
			ObjectDataModelImpl.PUCHMUSEUMSOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENT = new FinderPath(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
			ObjectDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEvent",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the object datas where puchmuseumsobjectId = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @return the matching object datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectData> findByEvent(long puchmuseumsobjectId)
		throws SystemException {
		return findByEvent(puchmuseumsobjectId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the object datas where puchmuseumsobjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param start the lower bound of the range of object datas
	 * @param end the upper bound of the range of object datas (not inclusive)
	 * @return the range of matching object datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectData> findByEvent(long puchmuseumsobjectId, int start,
		int end) throws SystemException {
		return findByEvent(puchmuseumsobjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the object datas where puchmuseumsobjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param start the lower bound of the range of object datas
	 * @param end the upper bound of the range of object datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching object datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectData> findByEvent(long puchmuseumsobjectId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENT;
			finderArgs = new Object[] { puchmuseumsobjectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENT;
			finderArgs = new Object[] {
					puchmuseumsobjectId,
					
					start, end, orderByComparator
				};
		}

		List<ObjectData> list = (List<ObjectData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ObjectData objectData : list) {
				if ((puchmuseumsobjectId != objectData.getPuchmuseumsobjectId())) {
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

			query.append(_SQL_SELECT_OBJECTDATA_WHERE);

			query.append(_FINDER_COLUMN_EVENT_PUCHMUSEUMSOBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ObjectDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(puchmuseumsobjectId);

				if (!pagination) {
					list = (List<ObjectData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ObjectData>(list);
				}
				else {
					list = (List<ObjectData>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first object data in the ordered set where puchmuseumsobjectId = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching object data
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a matching object data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData findByEvent_First(long puchmuseumsobjectId,
		OrderByComparator orderByComparator)
		throws NoSuchObjectDataException, SystemException {
		ObjectData objectData = fetchByEvent_First(puchmuseumsobjectId,
				orderByComparator);

		if (objectData != null) {
			return objectData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("puchmuseumsobjectId=");
		msg.append(puchmuseumsobjectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchObjectDataException(msg.toString());
	}

	/**
	 * Returns the first object data in the ordered set where puchmuseumsobjectId = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching object data, or <code>null</code> if a matching object data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData fetchByEvent_First(long puchmuseumsobjectId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ObjectData> list = findByEvent(puchmuseumsobjectId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last object data in the ordered set where puchmuseumsobjectId = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching object data
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a matching object data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData findByEvent_Last(long puchmuseumsobjectId,
		OrderByComparator orderByComparator)
		throws NoSuchObjectDataException, SystemException {
		ObjectData objectData = fetchByEvent_Last(puchmuseumsobjectId,
				orderByComparator);

		if (objectData != null) {
			return objectData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("puchmuseumsobjectId=");
		msg.append(puchmuseumsobjectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchObjectDataException(msg.toString());
	}

	/**
	 * Returns the last object data in the ordered set where puchmuseumsobjectId = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching object data, or <code>null</code> if a matching object data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData fetchByEvent_Last(long puchmuseumsobjectId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEvent(puchmuseumsobjectId);

		if (count == 0) {
			return null;
		}

		List<ObjectData> list = findByEvent(puchmuseumsobjectId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the object datas before and after the current object data in the ordered set where puchmuseumsobjectId = &#63;.
	 *
	 * @param objectdataId the primary key of the current object data
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next object data
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a object data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData[] findByEvent_PrevAndNext(long objectdataId,
		long puchmuseumsobjectId, OrderByComparator orderByComparator)
		throws NoSuchObjectDataException, SystemException {
		ObjectData objectData = findByPrimaryKey(objectdataId);

		Session session = null;

		try {
			session = openSession();

			ObjectData[] array = new ObjectDataImpl[3];

			array[0] = getByEvent_PrevAndNext(session, objectData,
					puchmuseumsobjectId, orderByComparator, true);

			array[1] = objectData;

			array[2] = getByEvent_PrevAndNext(session, objectData,
					puchmuseumsobjectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ObjectData getByEvent_PrevAndNext(Session session,
		ObjectData objectData, long puchmuseumsobjectId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OBJECTDATA_WHERE);

		query.append(_FINDER_COLUMN_EVENT_PUCHMUSEUMSOBJECTID_2);

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
			query.append(ObjectDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(puchmuseumsobjectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(objectData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ObjectData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the object datas where puchmuseumsobjectId = &#63; from the database.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEvent(long puchmuseumsobjectId)
		throws SystemException {
		for (ObjectData objectData : findByEvent(puchmuseumsobjectId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(objectData);
		}
	}

	/**
	 * Returns the number of object datas where puchmuseumsobjectId = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @return the number of matching object datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEvent(long puchmuseumsobjectId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENT;

		Object[] finderArgs = new Object[] { puchmuseumsobjectId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OBJECTDATA_WHERE);

			query.append(_FINDER_COLUMN_EVENT_PUCHMUSEUMSOBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(puchmuseumsobjectId);

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

	private static final String _FINDER_COLUMN_EVENT_PUCHMUSEUMSOBJECTID_2 = "objectData.puchmuseumsobjectId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_DATABYONTOLOGY = new FinderPath(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
			ObjectDataModelImpl.FINDER_CACHE_ENABLED, ObjectDataImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDataByOntology",
			new String[] { Long.class.getName(), String.class.getName() },
			ObjectDataModelImpl.PUCHMUSEUMSOBJECTID_COLUMN_BITMASK |
			ObjectDataModelImpl.OBJECTKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DATABYONTOLOGY = new FinderPath(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
			ObjectDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataByOntology",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the object data where puchmuseumsobjectId = &#63; and objectkey = &#63; or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException} if it could not be found.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param objectkey the objectkey
	 * @return the matching object data
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a matching object data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData findByDataByOntology(long puchmuseumsobjectId,
		String objectkey) throws NoSuchObjectDataException, SystemException {
		ObjectData objectData = fetchByDataByOntology(puchmuseumsobjectId,
				objectkey);

		if (objectData == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("puchmuseumsobjectId=");
			msg.append(puchmuseumsobjectId);

			msg.append(", objectkey=");
			msg.append(objectkey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchObjectDataException(msg.toString());
		}

		return objectData;
	}

	/**
	 * Returns the object data where puchmuseumsobjectId = &#63; and objectkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param objectkey the objectkey
	 * @return the matching object data, or <code>null</code> if a matching object data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData fetchByDataByOntology(long puchmuseumsobjectId,
		String objectkey) throws SystemException {
		return fetchByDataByOntology(puchmuseumsobjectId, objectkey, true);
	}

	/**
	 * Returns the object data where puchmuseumsobjectId = &#63; and objectkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param objectkey the objectkey
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching object data, or <code>null</code> if a matching object data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData fetchByDataByOntology(long puchmuseumsobjectId,
		String objectkey, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { puchmuseumsobjectId, objectkey };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
					finderArgs, this);
		}

		if (result instanceof ObjectData) {
			ObjectData objectData = (ObjectData)result;

			if ((puchmuseumsobjectId != objectData.getPuchmuseumsobjectId()) ||
					!Validator.equals(objectkey, objectData.getObjectkey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_OBJECTDATA_WHERE);

			query.append(_FINDER_COLUMN_DATABYONTOLOGY_PUCHMUSEUMSOBJECTID_2);

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

				qPos.add(puchmuseumsobjectId);

				if (bindObjectkey) {
					qPos.add(objectkey);
				}

				List<ObjectData> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ObjectDataPersistenceImpl.fetchByDataByOntology(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ObjectData objectData = list.get(0);

					result = objectData;

					cacheResult(objectData);

					if ((objectData.getPuchmuseumsobjectId() != puchmuseumsobjectId) ||
							(objectData.getObjectkey() == null) ||
							!objectData.getObjectkey().equals(objectkey)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
							finderArgs, objectData);
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
			return (ObjectData)result;
		}
	}

	/**
	 * Removes the object data where puchmuseumsobjectId = &#63; and objectkey = &#63; from the database.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param objectkey the objectkey
	 * @return the object data that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData removeByDataByOntology(long puchmuseumsobjectId,
		String objectkey) throws NoSuchObjectDataException, SystemException {
		ObjectData objectData = findByDataByOntology(puchmuseumsobjectId,
				objectkey);

		return remove(objectData);
	}

	/**
	 * Returns the number of object datas where puchmuseumsobjectId = &#63; and objectkey = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param objectkey the objectkey
	 * @return the number of matching object datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDataByOntology(long puchmuseumsobjectId, String objectkey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DATABYONTOLOGY;

		Object[] finderArgs = new Object[] { puchmuseumsobjectId, objectkey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OBJECTDATA_WHERE);

			query.append(_FINDER_COLUMN_DATABYONTOLOGY_PUCHMUSEUMSOBJECTID_2);

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

				qPos.add(puchmuseumsobjectId);

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

	private static final String _FINDER_COLUMN_DATABYONTOLOGY_PUCHMUSEUMSOBJECTID_2 =
		"objectData.puchmuseumsobjectId = ? AND ";
	private static final String _FINDER_COLUMN_DATABYONTOLOGY_OBJECTKEY_1 = "objectData.objectkey IS NULL";
	private static final String _FINDER_COLUMN_DATABYONTOLOGY_OBJECTKEY_2 = "objectData.objectkey = ?";
	private static final String _FINDER_COLUMN_DATABYONTOLOGY_OBJECTKEY_3 = "(objectData.objectkey IS NULL OR objectData.objectkey = '')";

	public ObjectDataPersistenceImpl() {
		setModelClass(ObjectData.class);
	}

	/**
	 * Caches the object data in the entity cache if it is enabled.
	 *
	 * @param objectData the object data
	 */
	@Override
	public void cacheResult(ObjectData objectData) {
		EntityCacheUtil.putResult(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
			ObjectDataImpl.class, objectData.getPrimaryKey(), objectData);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
			new Object[] {
				objectData.getPuchmuseumsobjectId(), objectData.getObjectkey()
			}, objectData);

		objectData.resetOriginalValues();
	}

	/**
	 * Caches the object datas in the entity cache if it is enabled.
	 *
	 * @param objectDatas the object datas
	 */
	@Override
	public void cacheResult(List<ObjectData> objectDatas) {
		for (ObjectData objectData : objectDatas) {
			if (EntityCacheUtil.getResult(
						ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
						ObjectDataImpl.class, objectData.getPrimaryKey()) == null) {
				cacheResult(objectData);
			}
			else {
				objectData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all object datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ObjectDataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ObjectDataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the object data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ObjectData objectData) {
		EntityCacheUtil.removeResult(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
			ObjectDataImpl.class, objectData.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(objectData);
	}

	@Override
	public void clearCache(List<ObjectData> objectDatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ObjectData objectData : objectDatas) {
			EntityCacheUtil.removeResult(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
				ObjectDataImpl.class, objectData.getPrimaryKey());

			clearUniqueFindersCache(objectData);
		}
	}

	protected void cacheUniqueFindersCache(ObjectData objectData) {
		if (objectData.isNew()) {
			Object[] args = new Object[] {
					objectData.getPuchmuseumsobjectId(),
					objectData.getObjectkey()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATABYONTOLOGY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
				args, objectData);
		}
		else {
			ObjectDataModelImpl objectDataModelImpl = (ObjectDataModelImpl)objectData;

			if ((objectDataModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DATABYONTOLOGY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						objectData.getPuchmuseumsobjectId(),
						objectData.getObjectkey()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATABYONTOLOGY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
					args, objectData);
			}
		}
	}

	protected void clearUniqueFindersCache(ObjectData objectData) {
		ObjectDataModelImpl objectDataModelImpl = (ObjectDataModelImpl)objectData;

		Object[] args = new Object[] {
				objectData.getPuchmuseumsobjectId(), objectData.getObjectkey()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATABYONTOLOGY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY, args);

		if ((objectDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DATABYONTOLOGY.getColumnBitmask()) != 0) {
			args = new Object[] {
					objectDataModelImpl.getOriginalPuchmuseumsobjectId(),
					objectDataModelImpl.getOriginalObjectkey()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATABYONTOLOGY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DATABYONTOLOGY,
				args);
		}
	}

	/**
	 * Creates a new object data with the primary key. Does not add the object data to the database.
	 *
	 * @param objectdataId the primary key for the new object data
	 * @return the new object data
	 */
	@Override
	public ObjectData create(long objectdataId) {
		ObjectData objectData = new ObjectDataImpl();

		objectData.setNew(true);
		objectData.setPrimaryKey(objectdataId);

		return objectData;
	}

	/**
	 * Removes the object data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param objectdataId the primary key of the object data
	 * @return the object data that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a object data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData remove(long objectdataId)
		throws NoSuchObjectDataException, SystemException {
		return remove((Serializable)objectdataId);
	}

	/**
	 * Removes the object data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the object data
	 * @return the object data that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a object data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData remove(Serializable primaryKey)
		throws NoSuchObjectDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ObjectData objectData = (ObjectData)session.get(ObjectDataImpl.class,
					primaryKey);

			if (objectData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchObjectDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(objectData);
		}
		catch (NoSuchObjectDataException nsee) {
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
	protected ObjectData removeImpl(ObjectData objectData)
		throws SystemException {
		objectData = toUnwrappedModel(objectData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(objectData)) {
				objectData = (ObjectData)session.get(ObjectDataImpl.class,
						objectData.getPrimaryKeyObj());
			}

			if (objectData != null) {
				session.delete(objectData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (objectData != null) {
			clearCache(objectData);
		}

		return objectData;
	}

	@Override
	public ObjectData updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectData objectData)
		throws SystemException {
		objectData = toUnwrappedModel(objectData);

		boolean isNew = objectData.isNew();

		ObjectDataModelImpl objectDataModelImpl = (ObjectDataModelImpl)objectData;

		Session session = null;

		try {
			session = openSession();

			if (objectData.isNew()) {
				session.save(objectData);

				objectData.setNew(false);
			}
			else {
				session.merge(objectData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ObjectDataModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((objectDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						objectDataModelImpl.getOriginalPuchmuseumsobjectId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENT,
					args);

				args = new Object[] { objectDataModelImpl.getPuchmuseumsobjectId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENT,
					args);
			}
		}

		EntityCacheUtil.putResult(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
			ObjectDataImpl.class, objectData.getPrimaryKey(), objectData);

		clearUniqueFindersCache(objectData);
		cacheUniqueFindersCache(objectData);

		return objectData;
	}

	protected ObjectData toUnwrappedModel(ObjectData objectData) {
		if (objectData instanceof ObjectDataImpl) {
			return objectData;
		}

		ObjectDataImpl objectDataImpl = new ObjectDataImpl();

		objectDataImpl.setNew(objectData.isNew());
		objectDataImpl.setPrimaryKey(objectData.getPrimaryKey());

		objectDataImpl.setObjectdataId(objectData.getObjectdataId());
		objectDataImpl.setPuchmuseumsobjectId(objectData.getPuchmuseumsobjectId());
		objectDataImpl.setObjectkey(objectData.getObjectkey());
		objectDataImpl.setObjectvalue(objectData.getObjectvalue());

		return objectDataImpl;
	}

	/**
	 * Returns the object data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the object data
	 * @return the object data
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a object data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchObjectDataException, SystemException {
		ObjectData objectData = fetchByPrimaryKey(primaryKey);

		if (objectData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchObjectDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return objectData;
	}

	/**
	 * Returns the object data with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException} if it could not be found.
	 *
	 * @param objectdataId the primary key of the object data
	 * @return the object data
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException if a object data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData findByPrimaryKey(long objectdataId)
		throws NoSuchObjectDataException, SystemException {
		return findByPrimaryKey((Serializable)objectdataId);
	}

	/**
	 * Returns the object data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the object data
	 * @return the object data, or <code>null</code> if a object data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ObjectData objectData = (ObjectData)EntityCacheUtil.getResult(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
				ObjectDataImpl.class, primaryKey);

		if (objectData == _nullObjectData) {
			return null;
		}

		if (objectData == null) {
			Session session = null;

			try {
				session = openSession();

				objectData = (ObjectData)session.get(ObjectDataImpl.class,
						primaryKey);

				if (objectData != null) {
					cacheResult(objectData);
				}
				else {
					EntityCacheUtil.putResult(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
						ObjectDataImpl.class, primaryKey, _nullObjectData);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ObjectDataModelImpl.ENTITY_CACHE_ENABLED,
					ObjectDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return objectData;
	}

	/**
	 * Returns the object data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param objectdataId the primary key of the object data
	 * @return the object data, or <code>null</code> if a object data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectData fetchByPrimaryKey(long objectdataId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)objectdataId);
	}

	/**
	 * Returns all the object datas.
	 *
	 * @return the object datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the object datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of object datas
	 * @param end the upper bound of the range of object datas (not inclusive)
	 * @return the range of object datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the object datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of object datas
	 * @param end the upper bound of the range of object datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of object datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectData> findAll(int start, int end,
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

		List<ObjectData> list = (List<ObjectData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OBJECTDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OBJECTDATA;

				if (pagination) {
					sql = sql.concat(ObjectDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ObjectData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ObjectData>(list);
				}
				else {
					list = (List<ObjectData>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the object datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ObjectData objectData : findAll()) {
			remove(objectData);
		}
	}

	/**
	 * Returns the number of object datas.
	 *
	 * @return the number of object datas
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

				Query q = session.createQuery(_SQL_COUNT_OBJECTDATA);

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
	 * Initializes the object data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.hmmc.liferay.portlet.puch.model.ObjectData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ObjectData>> listenersList = new ArrayList<ModelListener<ObjectData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ObjectData>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ObjectDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OBJECTDATA = "SELECT objectData FROM ObjectData objectData";
	private static final String _SQL_SELECT_OBJECTDATA_WHERE = "SELECT objectData FROM ObjectData objectData WHERE ";
	private static final String _SQL_COUNT_OBJECTDATA = "SELECT COUNT(objectData) FROM ObjectData objectData";
	private static final String _SQL_COUNT_OBJECTDATA_WHERE = "SELECT COUNT(objectData) FROM ObjectData objectData WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "objectData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ObjectData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ObjectData exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ObjectDataPersistenceImpl.class);
	private static ObjectData _nullObjectData = new ObjectDataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ObjectData> toCacheModel() {
				return _nullObjectDataCacheModel;
			}
		};

	private static CacheModel<ObjectData> _nullObjectDataCacheModel = new CacheModel<ObjectData>() {
			@Override
			public ObjectData toEntityModel() {
				return _nullObjectData;
			}
		};
}