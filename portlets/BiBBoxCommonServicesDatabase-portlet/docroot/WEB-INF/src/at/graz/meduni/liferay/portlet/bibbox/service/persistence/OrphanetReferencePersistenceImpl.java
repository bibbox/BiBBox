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

import at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException;
import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl;

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
 * The persistence implementation for the orphanet reference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see OrphanetReferencePersistence
 * @see OrphanetReferenceUtil
 * @generated
 */
public class OrphanetReferencePersistenceImpl extends BasePersistenceImpl<OrphanetReference>
	implements OrphanetReferencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrphanetReferenceUtil} to access the orphanet reference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrphanetReferenceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceModelImpl.FINDER_CACHE_ENABLED,
			OrphanetReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceModelImpl.FINDER_CACHE_ENABLED,
			OrphanetReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORPHANETDISORDERIDANDSOURCE =
		new FinderPath(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceModelImpl.FINDER_CACHE_ENABLED,
			OrphanetReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrphanetDisorderIdAndSource",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORPHANETDISORDERIDANDSOURCE =
		new FinderPath(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceModelImpl.FINDER_CACHE_ENABLED,
			OrphanetReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrphanetDisorderIdAndSource",
			new String[] { Long.class.getName(), String.class.getName() },
			OrphanetReferenceModelImpl.ORPHANETDISORDERID_COLUMN_BITMASK |
			OrphanetReferenceModelImpl.SOURCE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORPHANETDISORDERIDANDSOURCE =
		new FinderPath(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrphanetDisorderIdAndSource",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the orphanet references where orphanetdisorderId = &#63; and source = &#63;.
	 *
	 * @param orphanetdisorderId the orphanetdisorder ID
	 * @param source the source
	 * @return the matching orphanet references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetReference> findByOrphanetDisorderIdAndSource(
		long orphanetdisorderId, String source) throws SystemException {
		return findByOrphanetDisorderIdAndSource(orphanetdisorderId, source,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the orphanet references where orphanetdisorderId = &#63; and source = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orphanetdisorderId the orphanetdisorder ID
	 * @param source the source
	 * @param start the lower bound of the range of orphanet references
	 * @param end the upper bound of the range of orphanet references (not inclusive)
	 * @return the range of matching orphanet references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetReference> findByOrphanetDisorderIdAndSource(
		long orphanetdisorderId, String source, int start, int end)
		throws SystemException {
		return findByOrphanetDisorderIdAndSource(orphanetdisorderId, source,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the orphanet references where orphanetdisorderId = &#63; and source = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orphanetdisorderId the orphanetdisorder ID
	 * @param source the source
	 * @param start the lower bound of the range of orphanet references
	 * @param end the upper bound of the range of orphanet references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching orphanet references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetReference> findByOrphanetDisorderIdAndSource(
		long orphanetdisorderId, String source, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORPHANETDISORDERIDANDSOURCE;
			finderArgs = new Object[] { orphanetdisorderId, source };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORPHANETDISORDERIDANDSOURCE;
			finderArgs = new Object[] {
					orphanetdisorderId, source,
					
					start, end, orderByComparator
				};
		}

		List<OrphanetReference> list = (List<OrphanetReference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OrphanetReference orphanetReference : list) {
				if ((orphanetdisorderId != orphanetReference.getOrphanetdisorderId()) ||
						!Validator.equals(source, orphanetReference.getSource())) {
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

			query.append(_SQL_SELECT_ORPHANETREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_ORPHANETDISORDERID_2);

			boolean bindSource = false;

			if (source == null) {
				query.append(_FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_SOURCE_1);
			}
			else if (source.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_SOURCE_3);
			}
			else {
				bindSource = true;

				query.append(_FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_SOURCE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrphanetReferenceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orphanetdisorderId);

				if (bindSource) {
					qPos.add(source);
				}

				if (!pagination) {
					list = (List<OrphanetReference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrphanetReference>(list);
				}
				else {
					list = (List<OrphanetReference>)QueryUtil.list(q,
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
	 * Returns the first orphanet reference in the ordered set where orphanetdisorderId = &#63; and source = &#63;.
	 *
	 * @param orphanetdisorderId the orphanetdisorder ID
	 * @param source the source
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching orphanet reference
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a matching orphanet reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference findByOrphanetDisorderIdAndSource_First(
		long orphanetdisorderId, String source,
		OrderByComparator orderByComparator)
		throws NoSuchOrphanetReferenceException, SystemException {
		OrphanetReference orphanetReference = fetchByOrphanetDisorderIdAndSource_First(orphanetdisorderId,
				source, orderByComparator);

		if (orphanetReference != null) {
			return orphanetReference;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orphanetdisorderId=");
		msg.append(orphanetdisorderId);

		msg.append(", source=");
		msg.append(source);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrphanetReferenceException(msg.toString());
	}

	/**
	 * Returns the first orphanet reference in the ordered set where orphanetdisorderId = &#63; and source = &#63;.
	 *
	 * @param orphanetdisorderId the orphanetdisorder ID
	 * @param source the source
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching orphanet reference, or <code>null</code> if a matching orphanet reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference fetchByOrphanetDisorderIdAndSource_First(
		long orphanetdisorderId, String source,
		OrderByComparator orderByComparator) throws SystemException {
		List<OrphanetReference> list = findByOrphanetDisorderIdAndSource(orphanetdisorderId,
				source, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last orphanet reference in the ordered set where orphanetdisorderId = &#63; and source = &#63;.
	 *
	 * @param orphanetdisorderId the orphanetdisorder ID
	 * @param source the source
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching orphanet reference
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a matching orphanet reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference findByOrphanetDisorderIdAndSource_Last(
		long orphanetdisorderId, String source,
		OrderByComparator orderByComparator)
		throws NoSuchOrphanetReferenceException, SystemException {
		OrphanetReference orphanetReference = fetchByOrphanetDisorderIdAndSource_Last(orphanetdisorderId,
				source, orderByComparator);

		if (orphanetReference != null) {
			return orphanetReference;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orphanetdisorderId=");
		msg.append(orphanetdisorderId);

		msg.append(", source=");
		msg.append(source);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrphanetReferenceException(msg.toString());
	}

	/**
	 * Returns the last orphanet reference in the ordered set where orphanetdisorderId = &#63; and source = &#63;.
	 *
	 * @param orphanetdisorderId the orphanetdisorder ID
	 * @param source the source
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching orphanet reference, or <code>null</code> if a matching orphanet reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference fetchByOrphanetDisorderIdAndSource_Last(
		long orphanetdisorderId, String source,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrphanetDisorderIdAndSource(orphanetdisorderId,
				source);

		if (count == 0) {
			return null;
		}

		List<OrphanetReference> list = findByOrphanetDisorderIdAndSource(orphanetdisorderId,
				source, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the orphanet references before and after the current orphanet reference in the ordered set where orphanetdisorderId = &#63; and source = &#63;.
	 *
	 * @param orphanetreferenceId the primary key of the current orphanet reference
	 * @param orphanetdisorderId the orphanetdisorder ID
	 * @param source the source
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next orphanet reference
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference[] findByOrphanetDisorderIdAndSource_PrevAndNext(
		long orphanetreferenceId, long orphanetdisorderId, String source,
		OrderByComparator orderByComparator)
		throws NoSuchOrphanetReferenceException, SystemException {
		OrphanetReference orphanetReference = findByPrimaryKey(orphanetreferenceId);

		Session session = null;

		try {
			session = openSession();

			OrphanetReference[] array = new OrphanetReferenceImpl[3];

			array[0] = getByOrphanetDisorderIdAndSource_PrevAndNext(session,
					orphanetReference, orphanetdisorderId, source,
					orderByComparator, true);

			array[1] = orphanetReference;

			array[2] = getByOrphanetDisorderIdAndSource_PrevAndNext(session,
					orphanetReference, orphanetdisorderId, source,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OrphanetReference getByOrphanetDisorderIdAndSource_PrevAndNext(
		Session session, OrphanetReference orphanetReference,
		long orphanetdisorderId, String source,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORPHANETREFERENCE_WHERE);

		query.append(_FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_ORPHANETDISORDERID_2);

		boolean bindSource = false;

		if (source == null) {
			query.append(_FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_SOURCE_1);
		}
		else if (source.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_SOURCE_3);
		}
		else {
			bindSource = true;

			query.append(_FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_SOURCE_2);
		}

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
			query.append(OrphanetReferenceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(orphanetdisorderId);

		if (bindSource) {
			qPos.add(source);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(orphanetReference);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OrphanetReference> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the orphanet references where orphanetdisorderId = &#63; and source = &#63; from the database.
	 *
	 * @param orphanetdisorderId the orphanetdisorder ID
	 * @param source the source
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrphanetDisorderIdAndSource(long orphanetdisorderId,
		String source) throws SystemException {
		for (OrphanetReference orphanetReference : findByOrphanetDisorderIdAndSource(
				orphanetdisorderId, source, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(orphanetReference);
		}
	}

	/**
	 * Returns the number of orphanet references where orphanetdisorderId = &#63; and source = &#63;.
	 *
	 * @param orphanetdisorderId the orphanetdisorder ID
	 * @param source the source
	 * @return the number of matching orphanet references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrphanetDisorderIdAndSource(long orphanetdisorderId,
		String source) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORPHANETDISORDERIDANDSOURCE;

		Object[] finderArgs = new Object[] { orphanetdisorderId, source };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ORPHANETREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_ORPHANETDISORDERID_2);

			boolean bindSource = false;

			if (source == null) {
				query.append(_FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_SOURCE_1);
			}
			else if (source.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_SOURCE_3);
			}
			else {
				bindSource = true;

				query.append(_FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_SOURCE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orphanetdisorderId);

				if (bindSource) {
					qPos.add(source);
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

	private static final String _FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_ORPHANETDISORDERID_2 =
		"orphanetReference.orphanetdisorderId = ? AND ";
	private static final String _FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_SOURCE_1 =
		"orphanetReference.source IS NULL";
	private static final String _FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_SOURCE_2 =
		"orphanetReference.source = ?";
	private static final String _FINDER_COLUMN_ORPHANETDISORDERIDANDSOURCE_SOURCE_3 =
		"(orphanetReference.source IS NULL OR orphanetReference.source = '')";

	public OrphanetReferencePersistenceImpl() {
		setModelClass(OrphanetReference.class);
	}

	/**
	 * Caches the orphanet reference in the entity cache if it is enabled.
	 *
	 * @param orphanetReference the orphanet reference
	 */
	@Override
	public void cacheResult(OrphanetReference orphanetReference) {
		EntityCacheUtil.putResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceImpl.class, orphanetReference.getPrimaryKey(),
			orphanetReference);

		orphanetReference.resetOriginalValues();
	}

	/**
	 * Caches the orphanet references in the entity cache if it is enabled.
	 *
	 * @param orphanetReferences the orphanet references
	 */
	@Override
	public void cacheResult(List<OrphanetReference> orphanetReferences) {
		for (OrphanetReference orphanetReference : orphanetReferences) {
			if (EntityCacheUtil.getResult(
						OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
						OrphanetReferenceImpl.class,
						orphanetReference.getPrimaryKey()) == null) {
				cacheResult(orphanetReference);
			}
			else {
				orphanetReference.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all orphanet references.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrphanetReferenceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrphanetReferenceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the orphanet reference.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrphanetReference orphanetReference) {
		EntityCacheUtil.removeResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceImpl.class, orphanetReference.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OrphanetReference> orphanetReferences) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrphanetReference orphanetReference : orphanetReferences) {
			EntityCacheUtil.removeResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
				OrphanetReferenceImpl.class, orphanetReference.getPrimaryKey());
		}
	}

	/**
	 * Creates a new orphanet reference with the primary key. Does not add the orphanet reference to the database.
	 *
	 * @param orphanetreferenceId the primary key for the new orphanet reference
	 * @return the new orphanet reference
	 */
	@Override
	public OrphanetReference create(long orphanetreferenceId) {
		OrphanetReference orphanetReference = new OrphanetReferenceImpl();

		orphanetReference.setNew(true);
		orphanetReference.setPrimaryKey(orphanetreferenceId);

		return orphanetReference;
	}

	/**
	 * Removes the orphanet reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orphanetreferenceId the primary key of the orphanet reference
	 * @return the orphanet reference that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference remove(long orphanetreferenceId)
		throws NoSuchOrphanetReferenceException, SystemException {
		return remove((Serializable)orphanetreferenceId);
	}

	/**
	 * Removes the orphanet reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the orphanet reference
	 * @return the orphanet reference that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference remove(Serializable primaryKey)
		throws NoSuchOrphanetReferenceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrphanetReference orphanetReference = (OrphanetReference)session.get(OrphanetReferenceImpl.class,
					primaryKey);

			if (orphanetReference == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrphanetReferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(orphanetReference);
		}
		catch (NoSuchOrphanetReferenceException nsee) {
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
	protected OrphanetReference removeImpl(OrphanetReference orphanetReference)
		throws SystemException {
		orphanetReference = toUnwrappedModel(orphanetReference);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(orphanetReference)) {
				orphanetReference = (OrphanetReference)session.get(OrphanetReferenceImpl.class,
						orphanetReference.getPrimaryKeyObj());
			}

			if (orphanetReference != null) {
				session.delete(orphanetReference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (orphanetReference != null) {
			clearCache(orphanetReference);
		}

		return orphanetReference;
	}

	@Override
	public OrphanetReference updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference orphanetReference)
		throws SystemException {
		orphanetReference = toUnwrappedModel(orphanetReference);

		boolean isNew = orphanetReference.isNew();

		OrphanetReferenceModelImpl orphanetReferenceModelImpl = (OrphanetReferenceModelImpl)orphanetReference;

		Session session = null;

		try {
			session = openSession();

			if (orphanetReference.isNew()) {
				session.save(orphanetReference);

				orphanetReference.setNew(false);
			}
			else {
				session.merge(orphanetReference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrphanetReferenceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((orphanetReferenceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORPHANETDISORDERIDANDSOURCE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						orphanetReferenceModelImpl.getOriginalOrphanetdisorderId(),
						orphanetReferenceModelImpl.getOriginalSource()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORPHANETDISORDERIDANDSOURCE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORPHANETDISORDERIDANDSOURCE,
					args);

				args = new Object[] {
						orphanetReferenceModelImpl.getOrphanetdisorderId(),
						orphanetReferenceModelImpl.getSource()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORPHANETDISORDERIDANDSOURCE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORPHANETDISORDERIDANDSOURCE,
					args);
			}
		}

		EntityCacheUtil.putResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
			OrphanetReferenceImpl.class, orphanetReference.getPrimaryKey(),
			orphanetReference);

		return orphanetReference;
	}

	protected OrphanetReference toUnwrappedModel(
		OrphanetReference orphanetReference) {
		if (orphanetReference instanceof OrphanetReferenceImpl) {
			return orphanetReference;
		}

		OrphanetReferenceImpl orphanetReferenceImpl = new OrphanetReferenceImpl();

		orphanetReferenceImpl.setNew(orphanetReference.isNew());
		orphanetReferenceImpl.setPrimaryKey(orphanetReference.getPrimaryKey());

		orphanetReferenceImpl.setOrphanetreferenceId(orphanetReference.getOrphanetreferenceId());
		orphanetReferenceImpl.setOrphanetdisorderId(orphanetReference.getOrphanetdisorderId());
		orphanetReferenceImpl.setSource(orphanetReference.getSource());
		orphanetReferenceImpl.setReference(orphanetReference.getReference());
		orphanetReferenceImpl.setDisordermappingrelation(orphanetReference.getDisordermappingrelation());
		orphanetReferenceImpl.setDisordermappingrelationorphanumber(orphanetReference.getDisordermappingrelationorphanumber());
		orphanetReferenceImpl.setDisordermappingrelationname(orphanetReference.getDisordermappingrelationname());
		orphanetReferenceImpl.setDisordermappingicdrelation(orphanetReference.getDisordermappingicdrelation());
		orphanetReferenceImpl.setDisordermappingicdrelationorphanumber(orphanetReference.getDisordermappingicdrelationorphanumber());
		orphanetReferenceImpl.setDisordermappingicdrelationname(orphanetReference.getDisordermappingicdrelationname());
		orphanetReferenceImpl.setDisordermappingvalidationstatus(orphanetReference.getDisordermappingvalidationstatus());
		orphanetReferenceImpl.setDisordermappingvalidationstatusorphanumber(orphanetReference.getDisordermappingvalidationstatusorphanumber());
		orphanetReferenceImpl.setDisordermappingvalidationstatusname(orphanetReference.getDisordermappingvalidationstatusname());

		return orphanetReferenceImpl;
	}

	/**
	 * Returns the orphanet reference with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the orphanet reference
	 * @return the orphanet reference
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrphanetReferenceException, SystemException {
		OrphanetReference orphanetReference = fetchByPrimaryKey(primaryKey);

		if (orphanetReference == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrphanetReferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return orphanetReference;
	}

	/**
	 * Returns the orphanet reference with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException} if it could not be found.
	 *
	 * @param orphanetreferenceId the primary key of the orphanet reference
	 * @return the orphanet reference
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference findByPrimaryKey(long orphanetreferenceId)
		throws NoSuchOrphanetReferenceException, SystemException {
		return findByPrimaryKey((Serializable)orphanetreferenceId);
	}

	/**
	 * Returns the orphanet reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the orphanet reference
	 * @return the orphanet reference, or <code>null</code> if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OrphanetReference orphanetReference = (OrphanetReference)EntityCacheUtil.getResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
				OrphanetReferenceImpl.class, primaryKey);

		if (orphanetReference == _nullOrphanetReference) {
			return null;
		}

		if (orphanetReference == null) {
			Session session = null;

			try {
				session = openSession();

				orphanetReference = (OrphanetReference)session.get(OrphanetReferenceImpl.class,
						primaryKey);

				if (orphanetReference != null) {
					cacheResult(orphanetReference);
				}
				else {
					EntityCacheUtil.putResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
						OrphanetReferenceImpl.class, primaryKey,
						_nullOrphanetReference);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrphanetReferenceModelImpl.ENTITY_CACHE_ENABLED,
					OrphanetReferenceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return orphanetReference;
	}

	/**
	 * Returns the orphanet reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orphanetreferenceId the primary key of the orphanet reference
	 * @return the orphanet reference, or <code>null</code> if a orphanet reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrphanetReference fetchByPrimaryKey(long orphanetreferenceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)orphanetreferenceId);
	}

	/**
	 * Returns all the orphanet references.
	 *
	 * @return the orphanet references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetReference> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the orphanet references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of orphanet references
	 * @param end the upper bound of the range of orphanet references (not inclusive)
	 * @return the range of orphanet references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetReference> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the orphanet references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of orphanet references
	 * @param end the upper bound of the range of orphanet references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of orphanet references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrphanetReference> findAll(int start, int end,
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

		List<OrphanetReference> list = (List<OrphanetReference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORPHANETREFERENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORPHANETREFERENCE;

				if (pagination) {
					sql = sql.concat(OrphanetReferenceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OrphanetReference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrphanetReference>(list);
				}
				else {
					list = (List<OrphanetReference>)QueryUtil.list(q,
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
	 * Removes all the orphanet references from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OrphanetReference orphanetReference : findAll()) {
			remove(orphanetReference);
		}
	}

	/**
	 * Returns the number of orphanet references.
	 *
	 * @return the number of orphanet references
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

				Query q = session.createQuery(_SQL_COUNT_ORPHANETREFERENCE);

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
	 * Initializes the orphanet reference persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrphanetReference>> listenersList = new ArrayList<ModelListener<OrphanetReference>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrphanetReference>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrphanetReferenceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORPHANETREFERENCE = "SELECT orphanetReference FROM OrphanetReference orphanetReference";
	private static final String _SQL_SELECT_ORPHANETREFERENCE_WHERE = "SELECT orphanetReference FROM OrphanetReference orphanetReference WHERE ";
	private static final String _SQL_COUNT_ORPHANETREFERENCE = "SELECT COUNT(orphanetReference) FROM OrphanetReference orphanetReference";
	private static final String _SQL_COUNT_ORPHANETREFERENCE_WHERE = "SELECT COUNT(orphanetReference) FROM OrphanetReference orphanetReference WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "orphanetReference.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrphanetReference exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OrphanetReference exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrphanetReferencePersistenceImpl.class);
	private static OrphanetReference _nullOrphanetReference = new OrphanetReferenceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OrphanetReference> toCacheModel() {
				return _nullOrphanetReferenceCacheModel;
			}
		};

	private static CacheModel<OrphanetReference> _nullOrphanetReferenceCacheModel =
		new CacheModel<OrphanetReference>() {
			@Override
			public OrphanetReference toEntityModel() {
				return _nullOrphanetReference;
			}
		};
}