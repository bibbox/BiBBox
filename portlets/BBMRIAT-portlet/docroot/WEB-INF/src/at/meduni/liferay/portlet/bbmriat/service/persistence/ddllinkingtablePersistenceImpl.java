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

package at.meduni.liferay.portlet.bbmriat.service.persistence;

import at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException;
import at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable;
import at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableImpl;
import at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl;

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
 * The persistence implementation for the d d l linking table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see DDLLinkingTablePersistence
 * @see DDLLinkingTableUtil
 * @generated
 */
public class DDLLinkingTablePersistenceImpl extends BasePersistenceImpl<DDLLinkingTable>
	implements DDLLinkingTablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DDLLinkingTableUtil} to access the d d l linking table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DDLLinkingTableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
			DDLLinkingTableModelImpl.FINDER_CACHE_ENABLED,
			DDLLinkingTableImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
			DDLLinkingTableModelImpl.FINDER_CACHE_ENABLED,
			DDLLinkingTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
			DDLLinkingTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECORDID = new FinderPath(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
			DDLLinkingTableModelImpl.FINDER_CACHE_ENABLED,
			DDLLinkingTableImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRecordid",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID =
		new FinderPath(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
			DDLLinkingTableModelImpl.FINDER_CACHE_ENABLED,
			DDLLinkingTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRecordid",
			new String[] { Long.class.getName() },
			DDLLinkingTableModelImpl.RECORDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECORDID = new FinderPath(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
			DDLLinkingTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRecordid",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the d d l linking tables where recordid = &#63;.
	 *
	 * @param recordid the recordid
	 * @return the matching d d l linking tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DDLLinkingTable> findByRecordid(long recordid)
		throws SystemException {
		return findByRecordid(recordid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the d d l linking tables where recordid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recordid the recordid
	 * @param start the lower bound of the range of d d l linking tables
	 * @param end the upper bound of the range of d d l linking tables (not inclusive)
	 * @return the range of matching d d l linking tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DDLLinkingTable> findByRecordid(long recordid, int start,
		int end) throws SystemException {
		return findByRecordid(recordid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d d l linking tables where recordid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recordid the recordid
	 * @param start the lower bound of the range of d d l linking tables
	 * @param end the upper bound of the range of d d l linking tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d d l linking tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DDLLinkingTable> findByRecordid(long recordid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID;
			finderArgs = new Object[] { recordid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECORDID;
			finderArgs = new Object[] { recordid, start, end, orderByComparator };
		}

		List<DDLLinkingTable> list = (List<DDLLinkingTable>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DDLLinkingTable ddlLinkingTable : list) {
				if ((recordid != ddlLinkingTable.getRecordid())) {
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

			query.append(_SQL_SELECT_DDLLINKINGTABLE_WHERE);

			query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DDLLinkingTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recordid);

				if (!pagination) {
					list = (List<DDLLinkingTable>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DDLLinkingTable>(list);
				}
				else {
					list = (List<DDLLinkingTable>)QueryUtil.list(q,
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
	 * Returns the first d d l linking table in the ordered set where recordid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d d l linking table
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a matching d d l linking table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable findByRecordid_First(long recordid,
		OrderByComparator orderByComparator)
		throws NoSuchDDLLinkingTableException, SystemException {
		DDLLinkingTable ddlLinkingTable = fetchByRecordid_First(recordid,
				orderByComparator);

		if (ddlLinkingTable != null) {
			return ddlLinkingTable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recordid=");
		msg.append(recordid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDDLLinkingTableException(msg.toString());
	}

	/**
	 * Returns the first d d l linking table in the ordered set where recordid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d d l linking table, or <code>null</code> if a matching d d l linking table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable fetchByRecordid_First(long recordid,
		OrderByComparator orderByComparator) throws SystemException {
		List<DDLLinkingTable> list = findByRecordid(recordid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d d l linking table in the ordered set where recordid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d d l linking table
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a matching d d l linking table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable findByRecordid_Last(long recordid,
		OrderByComparator orderByComparator)
		throws NoSuchDDLLinkingTableException, SystemException {
		DDLLinkingTable ddlLinkingTable = fetchByRecordid_Last(recordid,
				orderByComparator);

		if (ddlLinkingTable != null) {
			return ddlLinkingTable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recordid=");
		msg.append(recordid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDDLLinkingTableException(msg.toString());
	}

	/**
	 * Returns the last d d l linking table in the ordered set where recordid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d d l linking table, or <code>null</code> if a matching d d l linking table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable fetchByRecordid_Last(long recordid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRecordid(recordid);

		if (count == 0) {
			return null;
		}

		List<DDLLinkingTable> list = findByRecordid(recordid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d d l linking tables before and after the current d d l linking table in the ordered set where recordid = &#63;.
	 *
	 * @param ddllinkingtable the primary key of the current d d l linking table
	 * @param recordid the recordid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d d l linking table
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a d d l linking table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable[] findByRecordid_PrevAndNext(long ddllinkingtable,
		long recordid, OrderByComparator orderByComparator)
		throws NoSuchDDLLinkingTableException, SystemException {
		DDLLinkingTable ddlLinkingTable = findByPrimaryKey(ddllinkingtable);

		Session session = null;

		try {
			session = openSession();

			DDLLinkingTable[] array = new DDLLinkingTableImpl[3];

			array[0] = getByRecordid_PrevAndNext(session, ddlLinkingTable,
					recordid, orderByComparator, true);

			array[1] = ddlLinkingTable;

			array[2] = getByRecordid_PrevAndNext(session, ddlLinkingTable,
					recordid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DDLLinkingTable getByRecordid_PrevAndNext(Session session,
		DDLLinkingTable ddlLinkingTable, long recordid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DDLLINKINGTABLE_WHERE);

		query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

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
			query.append(DDLLinkingTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(recordid);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ddlLinkingTable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DDLLinkingTable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d d l linking tables where recordid = &#63; from the database.
	 *
	 * @param recordid the recordid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRecordid(long recordid) throws SystemException {
		for (DDLLinkingTable ddlLinkingTable : findByRecordid(recordid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ddlLinkingTable);
		}
	}

	/**
	 * Returns the number of d d l linking tables where recordid = &#63;.
	 *
	 * @param recordid the recordid
	 * @return the number of matching d d l linking tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRecordid(long recordid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECORDID;

		Object[] finderArgs = new Object[] { recordid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DDLLINKINGTABLE_WHERE);

			query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recordid);

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

	private static final String _FINDER_COLUMN_RECORDID_RECORDID_2 = "ddlLinkingTable.recordid = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECORDSBYRECORDSET =
		new FinderPath(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
			DDLLinkingTableModelImpl.FINDER_CACHE_ENABLED,
			DDLLinkingTableImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRecordsByRecordset",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDSBYRECORDSET =
		new FinderPath(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
			DDLLinkingTableModelImpl.FINDER_CACHE_ENABLED,
			DDLLinkingTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRecordsByRecordset",
			new String[] { Long.class.getName(), Long.class.getName() },
			DDLLinkingTableModelImpl.RECORDID_COLUMN_BITMASK |
			DDLLinkingTableModelImpl.RECORDSETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECORDSBYRECORDSET = new FinderPath(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
			DDLLinkingTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRecordsByRecordset",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the d d l linking tables where recordid = &#63; and recordsetid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param recordsetid the recordsetid
	 * @return the matching d d l linking tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DDLLinkingTable> findByRecordsByRecordset(long recordid,
		long recordsetid) throws SystemException {
		return findByRecordsByRecordset(recordid, recordsetid,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d d l linking tables where recordid = &#63; and recordsetid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recordid the recordid
	 * @param recordsetid the recordsetid
	 * @param start the lower bound of the range of d d l linking tables
	 * @param end the upper bound of the range of d d l linking tables (not inclusive)
	 * @return the range of matching d d l linking tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DDLLinkingTable> findByRecordsByRecordset(long recordid,
		long recordsetid, int start, int end) throws SystemException {
		return findByRecordsByRecordset(recordid, recordsetid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the d d l linking tables where recordid = &#63; and recordsetid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recordid the recordid
	 * @param recordsetid the recordsetid
	 * @param start the lower bound of the range of d d l linking tables
	 * @param end the upper bound of the range of d d l linking tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching d d l linking tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DDLLinkingTable> findByRecordsByRecordset(long recordid,
		long recordsetid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDSBYRECORDSET;
			finderArgs = new Object[] { recordid, recordsetid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECORDSBYRECORDSET;
			finderArgs = new Object[] {
					recordid, recordsetid,
					
					start, end, orderByComparator
				};
		}

		List<DDLLinkingTable> list = (List<DDLLinkingTable>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DDLLinkingTable ddlLinkingTable : list) {
				if ((recordid != ddlLinkingTable.getRecordid()) ||
						(recordsetid != ddlLinkingTable.getRecordsetid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DDLLINKINGTABLE_WHERE);

			query.append(_FINDER_COLUMN_RECORDSBYRECORDSET_RECORDID_2);

			query.append(_FINDER_COLUMN_RECORDSBYRECORDSET_RECORDSETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DDLLinkingTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recordid);

				qPos.add(recordsetid);

				if (!pagination) {
					list = (List<DDLLinkingTable>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DDLLinkingTable>(list);
				}
				else {
					list = (List<DDLLinkingTable>)QueryUtil.list(q,
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
	 * Returns the first d d l linking table in the ordered set where recordid = &#63; and recordsetid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param recordsetid the recordsetid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d d l linking table
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a matching d d l linking table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable findByRecordsByRecordset_First(long recordid,
		long recordsetid, OrderByComparator orderByComparator)
		throws NoSuchDDLLinkingTableException, SystemException {
		DDLLinkingTable ddlLinkingTable = fetchByRecordsByRecordset_First(recordid,
				recordsetid, orderByComparator);

		if (ddlLinkingTable != null) {
			return ddlLinkingTable;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recordid=");
		msg.append(recordid);

		msg.append(", recordsetid=");
		msg.append(recordsetid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDDLLinkingTableException(msg.toString());
	}

	/**
	 * Returns the first d d l linking table in the ordered set where recordid = &#63; and recordsetid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param recordsetid the recordsetid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching d d l linking table, or <code>null</code> if a matching d d l linking table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable fetchByRecordsByRecordset_First(long recordid,
		long recordsetid, OrderByComparator orderByComparator)
		throws SystemException {
		List<DDLLinkingTable> list = findByRecordsByRecordset(recordid,
				recordsetid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last d d l linking table in the ordered set where recordid = &#63; and recordsetid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param recordsetid the recordsetid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d d l linking table
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a matching d d l linking table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable findByRecordsByRecordset_Last(long recordid,
		long recordsetid, OrderByComparator orderByComparator)
		throws NoSuchDDLLinkingTableException, SystemException {
		DDLLinkingTable ddlLinkingTable = fetchByRecordsByRecordset_Last(recordid,
				recordsetid, orderByComparator);

		if (ddlLinkingTable != null) {
			return ddlLinkingTable;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recordid=");
		msg.append(recordid);

		msg.append(", recordsetid=");
		msg.append(recordsetid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDDLLinkingTableException(msg.toString());
	}

	/**
	 * Returns the last d d l linking table in the ordered set where recordid = &#63; and recordsetid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param recordsetid the recordsetid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching d d l linking table, or <code>null</code> if a matching d d l linking table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable fetchByRecordsByRecordset_Last(long recordid,
		long recordsetid, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRecordsByRecordset(recordid, recordsetid);

		if (count == 0) {
			return null;
		}

		List<DDLLinkingTable> list = findByRecordsByRecordset(recordid,
				recordsetid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the d d l linking tables before and after the current d d l linking table in the ordered set where recordid = &#63; and recordsetid = &#63;.
	 *
	 * @param ddllinkingtable the primary key of the current d d l linking table
	 * @param recordid the recordid
	 * @param recordsetid the recordsetid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next d d l linking table
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a d d l linking table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable[] findByRecordsByRecordset_PrevAndNext(
		long ddllinkingtable, long recordid, long recordsetid,
		OrderByComparator orderByComparator)
		throws NoSuchDDLLinkingTableException, SystemException {
		DDLLinkingTable ddlLinkingTable = findByPrimaryKey(ddllinkingtable);

		Session session = null;

		try {
			session = openSession();

			DDLLinkingTable[] array = new DDLLinkingTableImpl[3];

			array[0] = getByRecordsByRecordset_PrevAndNext(session,
					ddlLinkingTable, recordid, recordsetid, orderByComparator,
					true);

			array[1] = ddlLinkingTable;

			array[2] = getByRecordsByRecordset_PrevAndNext(session,
					ddlLinkingTable, recordid, recordsetid, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DDLLinkingTable getByRecordsByRecordset_PrevAndNext(
		Session session, DDLLinkingTable ddlLinkingTable, long recordid,
		long recordsetid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DDLLINKINGTABLE_WHERE);

		query.append(_FINDER_COLUMN_RECORDSBYRECORDSET_RECORDID_2);

		query.append(_FINDER_COLUMN_RECORDSBYRECORDSET_RECORDSETID_2);

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
			query.append(DDLLinkingTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(recordid);

		qPos.add(recordsetid);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ddlLinkingTable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DDLLinkingTable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the d d l linking tables where recordid = &#63; and recordsetid = &#63; from the database.
	 *
	 * @param recordid the recordid
	 * @param recordsetid the recordsetid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRecordsByRecordset(long recordid, long recordsetid)
		throws SystemException {
		for (DDLLinkingTable ddlLinkingTable : findByRecordsByRecordset(
				recordid, recordsetid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(ddlLinkingTable);
		}
	}

	/**
	 * Returns the number of d d l linking tables where recordid = &#63; and recordsetid = &#63;.
	 *
	 * @param recordid the recordid
	 * @param recordsetid the recordsetid
	 * @return the number of matching d d l linking tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRecordsByRecordset(long recordid, long recordsetid)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECORDSBYRECORDSET;

		Object[] finderArgs = new Object[] { recordid, recordsetid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DDLLINKINGTABLE_WHERE);

			query.append(_FINDER_COLUMN_RECORDSBYRECORDSET_RECORDID_2);

			query.append(_FINDER_COLUMN_RECORDSBYRECORDSET_RECORDSETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recordid);

				qPos.add(recordsetid);

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

	private static final String _FINDER_COLUMN_RECORDSBYRECORDSET_RECORDID_2 = "ddlLinkingTable.recordid = ? AND ";
	private static final String _FINDER_COLUMN_RECORDSBYRECORDSET_RECORDSETID_2 = "ddlLinkingTable.recordsetid = ?";

	public DDLLinkingTablePersistenceImpl() {
		setModelClass(DDLLinkingTable.class);
	}

	/**
	 * Caches the d d l linking table in the entity cache if it is enabled.
	 *
	 * @param ddlLinkingTable the d d l linking table
	 */
	@Override
	public void cacheResult(DDLLinkingTable ddlLinkingTable) {
		EntityCacheUtil.putResult(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
			DDLLinkingTableImpl.class, ddlLinkingTable.getPrimaryKey(),
			ddlLinkingTable);

		ddlLinkingTable.resetOriginalValues();
	}

	/**
	 * Caches the d d l linking tables in the entity cache if it is enabled.
	 *
	 * @param ddlLinkingTables the d d l linking tables
	 */
	@Override
	public void cacheResult(List<DDLLinkingTable> ddlLinkingTables) {
		for (DDLLinkingTable ddlLinkingTable : ddlLinkingTables) {
			if (EntityCacheUtil.getResult(
						DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
						DDLLinkingTableImpl.class,
						ddlLinkingTable.getPrimaryKey()) == null) {
				cacheResult(ddlLinkingTable);
			}
			else {
				ddlLinkingTable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all d d l linking tables.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DDLLinkingTableImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DDLLinkingTableImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the d d l linking table.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DDLLinkingTable ddlLinkingTable) {
		EntityCacheUtil.removeResult(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
			DDLLinkingTableImpl.class, ddlLinkingTable.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DDLLinkingTable> ddlLinkingTables) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DDLLinkingTable ddlLinkingTable : ddlLinkingTables) {
			EntityCacheUtil.removeResult(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
				DDLLinkingTableImpl.class, ddlLinkingTable.getPrimaryKey());
		}
	}

	/**
	 * Creates a new d d l linking table with the primary key. Does not add the d d l linking table to the database.
	 *
	 * @param ddllinkingtable the primary key for the new d d l linking table
	 * @return the new d d l linking table
	 */
	@Override
	public DDLLinkingTable create(long ddllinkingtable) {
		DDLLinkingTable ddlLinkingTable = new DDLLinkingTableImpl();

		ddlLinkingTable.setNew(true);
		ddlLinkingTable.setPrimaryKey(ddllinkingtable);

		return ddlLinkingTable;
	}

	/**
	 * Removes the d d l linking table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddllinkingtable the primary key of the d d l linking table
	 * @return the d d l linking table that was removed
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a d d l linking table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable remove(long ddllinkingtable)
		throws NoSuchDDLLinkingTableException, SystemException {
		return remove((Serializable)ddllinkingtable);
	}

	/**
	 * Removes the d d l linking table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the d d l linking table
	 * @return the d d l linking table that was removed
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a d d l linking table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable remove(Serializable primaryKey)
		throws NoSuchDDLLinkingTableException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DDLLinkingTable ddlLinkingTable = (DDLLinkingTable)session.get(DDLLinkingTableImpl.class,
					primaryKey);

			if (ddlLinkingTable == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDDLLinkingTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ddlLinkingTable);
		}
		catch (NoSuchDDLLinkingTableException nsee) {
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
	protected DDLLinkingTable removeImpl(DDLLinkingTable ddlLinkingTable)
		throws SystemException {
		ddlLinkingTable = toUnwrappedModel(ddlLinkingTable);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ddlLinkingTable)) {
				ddlLinkingTable = (DDLLinkingTable)session.get(DDLLinkingTableImpl.class,
						ddlLinkingTable.getPrimaryKeyObj());
			}

			if (ddlLinkingTable != null) {
				session.delete(ddlLinkingTable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ddlLinkingTable != null) {
			clearCache(ddlLinkingTable);
		}

		return ddlLinkingTable;
	}

	@Override
	public DDLLinkingTable updateImpl(
		at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable ddlLinkingTable)
		throws SystemException {
		ddlLinkingTable = toUnwrappedModel(ddlLinkingTable);

		boolean isNew = ddlLinkingTable.isNew();

		DDLLinkingTableModelImpl ddlLinkingTableModelImpl = (DDLLinkingTableModelImpl)ddlLinkingTable;

		Session session = null;

		try {
			session = openSession();

			if (ddlLinkingTable.isNew()) {
				session.save(ddlLinkingTable);

				ddlLinkingTable.setNew(false);
			}
			else {
				session.merge(ddlLinkingTable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DDLLinkingTableModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ddlLinkingTableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ddlLinkingTableModelImpl.getOriginalRecordid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECORDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID,
					args);

				args = new Object[] { ddlLinkingTableModelImpl.getRecordid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECORDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID,
					args);
			}

			if ((ddlLinkingTableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDSBYRECORDSET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ddlLinkingTableModelImpl.getOriginalRecordid(),
						ddlLinkingTableModelImpl.getOriginalRecordsetid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECORDSBYRECORDSET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDSBYRECORDSET,
					args);

				args = new Object[] {
						ddlLinkingTableModelImpl.getRecordid(),
						ddlLinkingTableModelImpl.getRecordsetid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECORDSBYRECORDSET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDSBYRECORDSET,
					args);
			}
		}

		EntityCacheUtil.putResult(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
			DDLLinkingTableImpl.class, ddlLinkingTable.getPrimaryKey(),
			ddlLinkingTable);

		return ddlLinkingTable;
	}

	protected DDLLinkingTable toUnwrappedModel(DDLLinkingTable ddlLinkingTable) {
		if (ddlLinkingTable instanceof DDLLinkingTableImpl) {
			return ddlLinkingTable;
		}

		DDLLinkingTableImpl ddlLinkingTableImpl = new DDLLinkingTableImpl();

		ddlLinkingTableImpl.setNew(ddlLinkingTable.isNew());
		ddlLinkingTableImpl.setPrimaryKey(ddlLinkingTable.getPrimaryKey());

		ddlLinkingTableImpl.setDdllinkingtable(ddlLinkingTable.getDdllinkingtable());
		ddlLinkingTableImpl.setRecordid(ddlLinkingTable.getRecordid());
		ddlLinkingTableImpl.setRecordsetid(ddlLinkingTable.getRecordsetid());
		ddlLinkingTableImpl.setLinkrecordid(ddlLinkingTable.getLinkrecordid());

		return ddlLinkingTableImpl;
	}

	/**
	 * Returns the d d l linking table with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the d d l linking table
	 * @return the d d l linking table
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a d d l linking table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDDLLinkingTableException, SystemException {
		DDLLinkingTable ddlLinkingTable = fetchByPrimaryKey(primaryKey);

		if (ddlLinkingTable == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDDLLinkingTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ddlLinkingTable;
	}

	/**
	 * Returns the d d l linking table with the primary key or throws a {@link at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException} if it could not be found.
	 *
	 * @param ddllinkingtable the primary key of the d d l linking table
	 * @return the d d l linking table
	 * @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a d d l linking table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable findByPrimaryKey(long ddllinkingtable)
		throws NoSuchDDLLinkingTableException, SystemException {
		return findByPrimaryKey((Serializable)ddllinkingtable);
	}

	/**
	 * Returns the d d l linking table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the d d l linking table
	 * @return the d d l linking table, or <code>null</code> if a d d l linking table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DDLLinkingTable ddlLinkingTable = (DDLLinkingTable)EntityCacheUtil.getResult(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
				DDLLinkingTableImpl.class, primaryKey);

		if (ddlLinkingTable == _nullDDLLinkingTable) {
			return null;
		}

		if (ddlLinkingTable == null) {
			Session session = null;

			try {
				session = openSession();

				ddlLinkingTable = (DDLLinkingTable)session.get(DDLLinkingTableImpl.class,
						primaryKey);

				if (ddlLinkingTable != null) {
					cacheResult(ddlLinkingTable);
				}
				else {
					EntityCacheUtil.putResult(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
						DDLLinkingTableImpl.class, primaryKey,
						_nullDDLLinkingTable);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DDLLinkingTableModelImpl.ENTITY_CACHE_ENABLED,
					DDLLinkingTableImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ddlLinkingTable;
	}

	/**
	 * Returns the d d l linking table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ddllinkingtable the primary key of the d d l linking table
	 * @return the d d l linking table, or <code>null</code> if a d d l linking table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DDLLinkingTable fetchByPrimaryKey(long ddllinkingtable)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)ddllinkingtable);
	}

	/**
	 * Returns all the d d l linking tables.
	 *
	 * @return the d d l linking tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DDLLinkingTable> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d d l linking tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d d l linking tables
	 * @param end the upper bound of the range of d d l linking tables (not inclusive)
	 * @return the range of d d l linking tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DDLLinkingTable> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the d d l linking tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d d l linking tables
	 * @param end the upper bound of the range of d d l linking tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of d d l linking tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DDLLinkingTable> findAll(int start, int end,
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

		List<DDLLinkingTable> list = (List<DDLLinkingTable>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DDLLINKINGTABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DDLLINKINGTABLE;

				if (pagination) {
					sql = sql.concat(DDLLinkingTableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DDLLinkingTable>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DDLLinkingTable>(list);
				}
				else {
					list = (List<DDLLinkingTable>)QueryUtil.list(q,
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
	 * Removes all the d d l linking tables from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DDLLinkingTable ddlLinkingTable : findAll()) {
			remove(ddlLinkingTable);
		}
	}

	/**
	 * Returns the number of d d l linking tables.
	 *
	 * @return the number of d d l linking tables
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

				Query q = session.createQuery(_SQL_COUNT_DDLLINKINGTABLE);

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
	 * Initializes the d d l linking table persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DDLLinkingTable>> listenersList = new ArrayList<ModelListener<DDLLinkingTable>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DDLLinkingTable>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DDLLinkingTableImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DDLLINKINGTABLE = "SELECT ddlLinkingTable FROM DDLLinkingTable ddlLinkingTable";
	private static final String _SQL_SELECT_DDLLINKINGTABLE_WHERE = "SELECT ddlLinkingTable FROM DDLLinkingTable ddlLinkingTable WHERE ";
	private static final String _SQL_COUNT_DDLLINKINGTABLE = "SELECT COUNT(ddlLinkingTable) FROM DDLLinkingTable ddlLinkingTable";
	private static final String _SQL_COUNT_DDLLINKINGTABLE_WHERE = "SELECT COUNT(ddlLinkingTable) FROM DDLLinkingTable ddlLinkingTable WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ddlLinkingTable.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DDLLinkingTable exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DDLLinkingTable exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DDLLinkingTablePersistenceImpl.class);
	private static DDLLinkingTable _nullDDLLinkingTable = new DDLLinkingTableImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DDLLinkingTable> toCacheModel() {
				return _nullDDLLinkingTableCacheModel;
			}
		};

	private static CacheModel<DDLLinkingTable> _nullDDLLinkingTableCacheModel = new CacheModel<DDLLinkingTable>() {
			@Override
			public DDLLinkingTable toEntityModel() {
				return _nullDDLLinkingTable;
			}
		};
}