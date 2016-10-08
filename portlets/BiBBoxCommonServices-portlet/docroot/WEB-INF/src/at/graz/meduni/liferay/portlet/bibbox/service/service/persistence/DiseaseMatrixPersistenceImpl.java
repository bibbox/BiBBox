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

package at.graz.meduni.liferay.portlet.bibbox.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl;

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
 * The persistence implementation for the disease matrix service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DiseaseMatrixPersistence
 * @see DiseaseMatrixUtil
 * @generated
 */
public class DiseaseMatrixPersistenceImpl extends BasePersistenceImpl<DiseaseMatrix>
	implements DiseaseMatrixPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DiseaseMatrixUtil} to access the disease matrix persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DiseaseMatrixImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseMatrixModelImpl.FINDER_CACHE_ENABLED,
			DiseaseMatrixImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseMatrixModelImpl.FINDER_CACHE_ENABLED,
			DiseaseMatrixImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseMatrixModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONFINDER =
		new FinderPath(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseMatrixModelImpl.FINDER_CACHE_ENABLED,
			DiseaseMatrixImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationFinder",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONFINDER =
		new FinderPath(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseMatrixModelImpl.FINDER_CACHE_ENABLED,
			DiseaseMatrixImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrganizationFinder", new String[] { Long.class.getName() },
			DiseaseMatrixModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONFINDER = new FinderPath(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseMatrixModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationFinder", new String[] { Long.class.getName() });

	/**
	 * Returns all the disease matrixs where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching disease matrixs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseMatrix> findByOrganizationFinder(long organizationId)
		throws SystemException {
		return findByOrganizationFinder(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disease matrixs where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of disease matrixs
	 * @param end the upper bound of the range of disease matrixs (not inclusive)
	 * @return the range of matching disease matrixs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseMatrix> findByOrganizationFinder(long organizationId,
		int start, int end) throws SystemException {
		return findByOrganizationFinder(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disease matrixs where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of disease matrixs
	 * @param end the upper bound of the range of disease matrixs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disease matrixs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseMatrix> findByOrganizationFinder(long organizationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONFINDER;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONFINDER;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<DiseaseMatrix> list = (List<DiseaseMatrix>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DiseaseMatrix diseaseMatrix : list) {
				if ((organizationId != diseaseMatrix.getOrganizationId())) {
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

			query.append(_SQL_SELECT_DISEASEMATRIX_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONFINDER_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DiseaseMatrixModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<DiseaseMatrix>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DiseaseMatrix>(list);
				}
				else {
					list = (List<DiseaseMatrix>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first disease matrix in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disease matrix
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a matching disease matrix could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix findByOrganizationFinder_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchDiseaseMatrixException, SystemException {
		DiseaseMatrix diseaseMatrix = fetchByOrganizationFinder_First(organizationId,
				orderByComparator);

		if (diseaseMatrix != null) {
			return diseaseMatrix;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDiseaseMatrixException(msg.toString());
	}

	/**
	 * Returns the first disease matrix in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disease matrix, or <code>null</code> if a matching disease matrix could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix fetchByOrganizationFinder_First(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DiseaseMatrix> list = findByOrganizationFinder(organizationId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disease matrix in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disease matrix
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a matching disease matrix could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix findByOrganizationFinder_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchDiseaseMatrixException, SystemException {
		DiseaseMatrix diseaseMatrix = fetchByOrganizationFinder_Last(organizationId,
				orderByComparator);

		if (diseaseMatrix != null) {
			return diseaseMatrix;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDiseaseMatrixException(msg.toString());
	}

	/**
	 * Returns the last disease matrix in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disease matrix, or <code>null</code> if a matching disease matrix could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix fetchByOrganizationFinder_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationFinder(organizationId);

		if (count == 0) {
			return null;
		}

		List<DiseaseMatrix> list = findByOrganizationFinder(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disease matrixs before and after the current disease matrix in the ordered set where organizationId = &#63;.
	 *
	 * @param diseasematrixId the primary key of the current disease matrix
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disease matrix
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a disease matrix with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix[] findByOrganizationFinder_PrevAndNext(
		long diseasematrixId, long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchDiseaseMatrixException, SystemException {
		DiseaseMatrix diseaseMatrix = findByPrimaryKey(diseasematrixId);

		Session session = null;

		try {
			session = openSession();

			DiseaseMatrix[] array = new DiseaseMatrixImpl[3];

			array[0] = getByOrganizationFinder_PrevAndNext(session,
					diseaseMatrix, organizationId, orderByComparator, true);

			array[1] = diseaseMatrix;

			array[2] = getByOrganizationFinder_PrevAndNext(session,
					diseaseMatrix, organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DiseaseMatrix getByOrganizationFinder_PrevAndNext(
		Session session, DiseaseMatrix diseaseMatrix, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISEASEMATRIX_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONFINDER_ORGANIZATIONID_2);

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
			query.append(DiseaseMatrixModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(diseaseMatrix);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DiseaseMatrix> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disease matrixs where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationFinder(long organizationId)
		throws SystemException {
		for (DiseaseMatrix diseaseMatrix : findByOrganizationFinder(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(diseaseMatrix);
		}
	}

	/**
	 * Returns the number of disease matrixs where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching disease matrixs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationFinder(long organizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONFINDER;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DISEASEMATRIX_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONFINDER_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONFINDER_ORGANIZATIONID_2 =
		"diseaseMatrix.organizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONANDORPHANUMBER =
		new FinderPath(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseMatrixModelImpl.FINDER_CACHE_ENABLED,
			DiseaseMatrixImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationAndOrphanumber",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDORPHANUMBER =
		new FinderPath(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseMatrixModelImpl.FINDER_CACHE_ENABLED,
			DiseaseMatrixImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrganizationAndOrphanumber",
			new String[] { Long.class.getName(), String.class.getName() },
			DiseaseMatrixModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			DiseaseMatrixModelImpl.ORPHANUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONANDORPHANUMBER =
		new FinderPath(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseMatrixModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationAndOrphanumber",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the disease matrixs where organizationId = &#63; and orphanumber = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orphanumber the orphanumber
	 * @return the matching disease matrixs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseMatrix> findByOrganizationAndOrphanumber(
		long organizationId, String orphanumber) throws SystemException {
		return findByOrganizationAndOrphanumber(organizationId, orphanumber,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disease matrixs where organizationId = &#63; and orphanumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param orphanumber the orphanumber
	 * @param start the lower bound of the range of disease matrixs
	 * @param end the upper bound of the range of disease matrixs (not inclusive)
	 * @return the range of matching disease matrixs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseMatrix> findByOrganizationAndOrphanumber(
		long organizationId, String orphanumber, int start, int end)
		throws SystemException {
		return findByOrganizationAndOrphanumber(organizationId, orphanumber,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the disease matrixs where organizationId = &#63; and orphanumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param orphanumber the orphanumber
	 * @param start the lower bound of the range of disease matrixs
	 * @param end the upper bound of the range of disease matrixs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disease matrixs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseMatrix> findByOrganizationAndOrphanumber(
		long organizationId, String orphanumber, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDORPHANUMBER;
			finderArgs = new Object[] { organizationId, orphanumber };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONANDORPHANUMBER;
			finderArgs = new Object[] {
					organizationId, orphanumber,
					
					start, end, orderByComparator
				};
		}

		List<DiseaseMatrix> list = (List<DiseaseMatrix>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DiseaseMatrix diseaseMatrix : list) {
				if ((organizationId != diseaseMatrix.getOrganizationId()) ||
						!Validator.equals(orphanumber,
							diseaseMatrix.getOrphanumber())) {
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

			query.append(_SQL_SELECT_DISEASEMATRIX_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORGANIZATIONID_2);

			boolean bindOrphanumber = false;

			if (orphanumber == null) {
				query.append(_FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORPHANUMBER_1);
			}
			else if (orphanumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORPHANUMBER_3);
			}
			else {
				bindOrphanumber = true;

				query.append(_FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORPHANUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DiseaseMatrixModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (bindOrphanumber) {
					qPos.add(orphanumber);
				}

				if (!pagination) {
					list = (List<DiseaseMatrix>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DiseaseMatrix>(list);
				}
				else {
					list = (List<DiseaseMatrix>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first disease matrix in the ordered set where organizationId = &#63; and orphanumber = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orphanumber the orphanumber
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disease matrix
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a matching disease matrix could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix findByOrganizationAndOrphanumber_First(
		long organizationId, String orphanumber,
		OrderByComparator orderByComparator)
		throws NoSuchDiseaseMatrixException, SystemException {
		DiseaseMatrix diseaseMatrix = fetchByOrganizationAndOrphanumber_First(organizationId,
				orphanumber, orderByComparator);

		if (diseaseMatrix != null) {
			return diseaseMatrix;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", orphanumber=");
		msg.append(orphanumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDiseaseMatrixException(msg.toString());
	}

	/**
	 * Returns the first disease matrix in the ordered set where organizationId = &#63; and orphanumber = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orphanumber the orphanumber
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disease matrix, or <code>null</code> if a matching disease matrix could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix fetchByOrganizationAndOrphanumber_First(
		long organizationId, String orphanumber,
		OrderByComparator orderByComparator) throws SystemException {
		List<DiseaseMatrix> list = findByOrganizationAndOrphanumber(organizationId,
				orphanumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disease matrix in the ordered set where organizationId = &#63; and orphanumber = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orphanumber the orphanumber
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disease matrix
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a matching disease matrix could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix findByOrganizationAndOrphanumber_Last(
		long organizationId, String orphanumber,
		OrderByComparator orderByComparator)
		throws NoSuchDiseaseMatrixException, SystemException {
		DiseaseMatrix diseaseMatrix = fetchByOrganizationAndOrphanumber_Last(organizationId,
				orphanumber, orderByComparator);

		if (diseaseMatrix != null) {
			return diseaseMatrix;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", orphanumber=");
		msg.append(orphanumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDiseaseMatrixException(msg.toString());
	}

	/**
	 * Returns the last disease matrix in the ordered set where organizationId = &#63; and orphanumber = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orphanumber the orphanumber
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disease matrix, or <code>null</code> if a matching disease matrix could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix fetchByOrganizationAndOrphanumber_Last(
		long organizationId, String orphanumber,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationAndOrphanumber(organizationId,
				orphanumber);

		if (count == 0) {
			return null;
		}

		List<DiseaseMatrix> list = findByOrganizationAndOrphanumber(organizationId,
				orphanumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disease matrixs before and after the current disease matrix in the ordered set where organizationId = &#63; and orphanumber = &#63;.
	 *
	 * @param diseasematrixId the primary key of the current disease matrix
	 * @param organizationId the organization ID
	 * @param orphanumber the orphanumber
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disease matrix
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a disease matrix with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix[] findByOrganizationAndOrphanumber_PrevAndNext(
		long diseasematrixId, long organizationId, String orphanumber,
		OrderByComparator orderByComparator)
		throws NoSuchDiseaseMatrixException, SystemException {
		DiseaseMatrix diseaseMatrix = findByPrimaryKey(diseasematrixId);

		Session session = null;

		try {
			session = openSession();

			DiseaseMatrix[] array = new DiseaseMatrixImpl[3];

			array[0] = getByOrganizationAndOrphanumber_PrevAndNext(session,
					diseaseMatrix, organizationId, orphanumber,
					orderByComparator, true);

			array[1] = diseaseMatrix;

			array[2] = getByOrganizationAndOrphanumber_PrevAndNext(session,
					diseaseMatrix, organizationId, orphanumber,
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

	protected DiseaseMatrix getByOrganizationAndOrphanumber_PrevAndNext(
		Session session, DiseaseMatrix diseaseMatrix, long organizationId,
		String orphanumber, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISEASEMATRIX_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORGANIZATIONID_2);

		boolean bindOrphanumber = false;

		if (orphanumber == null) {
			query.append(_FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORPHANUMBER_1);
		}
		else if (orphanumber.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORPHANUMBER_3);
		}
		else {
			bindOrphanumber = true;

			query.append(_FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORPHANUMBER_2);
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
			query.append(DiseaseMatrixModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (bindOrphanumber) {
			qPos.add(orphanumber);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(diseaseMatrix);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DiseaseMatrix> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disease matrixs where organizationId = &#63; and orphanumber = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param orphanumber the orphanumber
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationAndOrphanumber(long organizationId,
		String orphanumber) throws SystemException {
		for (DiseaseMatrix diseaseMatrix : findByOrganizationAndOrphanumber(
				organizationId, orphanumber, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(diseaseMatrix);
		}
	}

	/**
	 * Returns the number of disease matrixs where organizationId = &#63; and orphanumber = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orphanumber the orphanumber
	 * @return the number of matching disease matrixs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationAndOrphanumber(long organizationId,
		String orphanumber) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONANDORPHANUMBER;

		Object[] finderArgs = new Object[] { organizationId, orphanumber };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DISEASEMATRIX_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORGANIZATIONID_2);

			boolean bindOrphanumber = false;

			if (orphanumber == null) {
				query.append(_FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORPHANUMBER_1);
			}
			else if (orphanumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORPHANUMBER_3);
			}
			else {
				bindOrphanumber = true;

				query.append(_FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORPHANUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (bindOrphanumber) {
					qPos.add(orphanumber);
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

	private static final String _FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORGANIZATIONID_2 =
		"diseaseMatrix.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORPHANUMBER_1 =
		"diseaseMatrix.orphanumber IS NULL";
	private static final String _FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORPHANUMBER_2 =
		"diseaseMatrix.orphanumber = ?";
	private static final String _FINDER_COLUMN_ORGANIZATIONANDORPHANUMBER_ORPHANUMBER_3 =
		"(diseaseMatrix.orphanumber IS NULL OR diseaseMatrix.orphanumber = '')";

	public DiseaseMatrixPersistenceImpl() {
		setModelClass(DiseaseMatrix.class);
	}

	/**
	 * Caches the disease matrix in the entity cache if it is enabled.
	 *
	 * @param diseaseMatrix the disease matrix
	 */
	@Override
	public void cacheResult(DiseaseMatrix diseaseMatrix) {
		EntityCacheUtil.putResult(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseMatrixImpl.class, diseaseMatrix.getPrimaryKey(),
			diseaseMatrix);

		diseaseMatrix.resetOriginalValues();
	}

	/**
	 * Caches the disease matrixs in the entity cache if it is enabled.
	 *
	 * @param diseaseMatrixs the disease matrixs
	 */
	@Override
	public void cacheResult(List<DiseaseMatrix> diseaseMatrixs) {
		for (DiseaseMatrix diseaseMatrix : diseaseMatrixs) {
			if (EntityCacheUtil.getResult(
						DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
						DiseaseMatrixImpl.class, diseaseMatrix.getPrimaryKey()) == null) {
				cacheResult(diseaseMatrix);
			}
			else {
				diseaseMatrix.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all disease matrixs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DiseaseMatrixImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DiseaseMatrixImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the disease matrix.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DiseaseMatrix diseaseMatrix) {
		EntityCacheUtil.removeResult(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseMatrixImpl.class, diseaseMatrix.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DiseaseMatrix> diseaseMatrixs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DiseaseMatrix diseaseMatrix : diseaseMatrixs) {
			EntityCacheUtil.removeResult(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
				DiseaseMatrixImpl.class, diseaseMatrix.getPrimaryKey());
		}
	}

	/**
	 * Creates a new disease matrix with the primary key. Does not add the disease matrix to the database.
	 *
	 * @param diseasematrixId the primary key for the new disease matrix
	 * @return the new disease matrix
	 */
	@Override
	public DiseaseMatrix create(long diseasematrixId) {
		DiseaseMatrix diseaseMatrix = new DiseaseMatrixImpl();

		diseaseMatrix.setNew(true);
		diseaseMatrix.setPrimaryKey(diseasematrixId);

		return diseaseMatrix;
	}

	/**
	 * Removes the disease matrix with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param diseasematrixId the primary key of the disease matrix
	 * @return the disease matrix that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a disease matrix with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix remove(long diseasematrixId)
		throws NoSuchDiseaseMatrixException, SystemException {
		return remove((Serializable)diseasematrixId);
	}

	/**
	 * Removes the disease matrix with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the disease matrix
	 * @return the disease matrix that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a disease matrix with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix remove(Serializable primaryKey)
		throws NoSuchDiseaseMatrixException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DiseaseMatrix diseaseMatrix = (DiseaseMatrix)session.get(DiseaseMatrixImpl.class,
					primaryKey);

			if (diseaseMatrix == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDiseaseMatrixException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(diseaseMatrix);
		}
		catch (NoSuchDiseaseMatrixException nsee) {
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
	protected DiseaseMatrix removeImpl(DiseaseMatrix diseaseMatrix)
		throws SystemException {
		diseaseMatrix = toUnwrappedModel(diseaseMatrix);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(diseaseMatrix)) {
				diseaseMatrix = (DiseaseMatrix)session.get(DiseaseMatrixImpl.class,
						diseaseMatrix.getPrimaryKeyObj());
			}

			if (diseaseMatrix != null) {
				session.delete(diseaseMatrix);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (diseaseMatrix != null) {
			clearCache(diseaseMatrix);
		}

		return diseaseMatrix;
	}

	@Override
	public DiseaseMatrix updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseaseMatrix)
		throws SystemException {
		diseaseMatrix = toUnwrappedModel(diseaseMatrix);

		boolean isNew = diseaseMatrix.isNew();

		DiseaseMatrixModelImpl diseaseMatrixModelImpl = (DiseaseMatrixModelImpl)diseaseMatrix;

		Session session = null;

		try {
			session = openSession();

			if (diseaseMatrix.isNew()) {
				session.save(diseaseMatrix);

				diseaseMatrix.setNew(false);
			}
			else {
				session.merge(diseaseMatrix);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DiseaseMatrixModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((diseaseMatrixModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONFINDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						diseaseMatrixModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONFINDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONFINDER,
					args);

				args = new Object[] { diseaseMatrixModelImpl.getOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONFINDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONFINDER,
					args);
			}

			if ((diseaseMatrixModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDORPHANUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						diseaseMatrixModelImpl.getOriginalOrganizationId(),
						diseaseMatrixModelImpl.getOriginalOrphanumber()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONANDORPHANUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDORPHANUMBER,
					args);

				args = new Object[] {
						diseaseMatrixModelImpl.getOrganizationId(),
						diseaseMatrixModelImpl.getOrphanumber()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONANDORPHANUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDORPHANUMBER,
					args);
			}
		}

		EntityCacheUtil.putResult(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
			DiseaseMatrixImpl.class, diseaseMatrix.getPrimaryKey(),
			diseaseMatrix);

		return diseaseMatrix;
	}

	protected DiseaseMatrix toUnwrappedModel(DiseaseMatrix diseaseMatrix) {
		if (diseaseMatrix instanceof DiseaseMatrixImpl) {
			return diseaseMatrix;
		}

		DiseaseMatrixImpl diseaseMatrixImpl = new DiseaseMatrixImpl();

		diseaseMatrixImpl.setNew(diseaseMatrix.isNew());
		diseaseMatrixImpl.setPrimaryKey(diseaseMatrix.getPrimaryKey());

		diseaseMatrixImpl.setDiseasematrixId(diseaseMatrix.getDiseasematrixId());
		diseaseMatrixImpl.setOrganizationId(diseaseMatrix.getOrganizationId());
		diseaseMatrixImpl.setDiseasename(diseaseMatrix.getDiseasename());
		diseaseMatrixImpl.setPatientcount(diseaseMatrix.getPatientcount());
		diseaseMatrixImpl.setGene(diseaseMatrix.getGene());
		diseaseMatrixImpl.setOrphanumber(diseaseMatrix.getOrphanumber());
		diseaseMatrixImpl.setIcd10(diseaseMatrix.getIcd10());
		diseaseMatrixImpl.setOmim(diseaseMatrix.getOmim());
		diseaseMatrixImpl.setSynonym(diseaseMatrix.getSynonym());
		diseaseMatrixImpl.setModifieddate(diseaseMatrix.getModifieddate());
		diseaseMatrixImpl.setModifieduser(diseaseMatrix.getModifieduser());

		return diseaseMatrixImpl;
	}

	/**
	 * Returns the disease matrix with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the disease matrix
	 * @return the disease matrix
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a disease matrix with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDiseaseMatrixException, SystemException {
		DiseaseMatrix diseaseMatrix = fetchByPrimaryKey(primaryKey);

		if (diseaseMatrix == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDiseaseMatrixException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return diseaseMatrix;
	}

	/**
	 * Returns the disease matrix with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException} if it could not be found.
	 *
	 * @param diseasematrixId the primary key of the disease matrix
	 * @return the disease matrix
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a disease matrix with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix findByPrimaryKey(long diseasematrixId)
		throws NoSuchDiseaseMatrixException, SystemException {
		return findByPrimaryKey((Serializable)diseasematrixId);
	}

	/**
	 * Returns the disease matrix with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the disease matrix
	 * @return the disease matrix, or <code>null</code> if a disease matrix with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DiseaseMatrix diseaseMatrix = (DiseaseMatrix)EntityCacheUtil.getResult(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
				DiseaseMatrixImpl.class, primaryKey);

		if (diseaseMatrix == _nullDiseaseMatrix) {
			return null;
		}

		if (diseaseMatrix == null) {
			Session session = null;

			try {
				session = openSession();

				diseaseMatrix = (DiseaseMatrix)session.get(DiseaseMatrixImpl.class,
						primaryKey);

				if (diseaseMatrix != null) {
					cacheResult(diseaseMatrix);
				}
				else {
					EntityCacheUtil.putResult(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
						DiseaseMatrixImpl.class, primaryKey, _nullDiseaseMatrix);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DiseaseMatrixModelImpl.ENTITY_CACHE_ENABLED,
					DiseaseMatrixImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return diseaseMatrix;
	}

	/**
	 * Returns the disease matrix with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param diseasematrixId the primary key of the disease matrix
	 * @return the disease matrix, or <code>null</code> if a disease matrix with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DiseaseMatrix fetchByPrimaryKey(long diseasematrixId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)diseasematrixId);
	}

	/**
	 * Returns all the disease matrixs.
	 *
	 * @return the disease matrixs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseMatrix> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disease matrixs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of disease matrixs
	 * @param end the upper bound of the range of disease matrixs (not inclusive)
	 * @return the range of disease matrixs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseMatrix> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the disease matrixs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of disease matrixs
	 * @param end the upper bound of the range of disease matrixs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of disease matrixs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DiseaseMatrix> findAll(int start, int end,
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

		List<DiseaseMatrix> list = (List<DiseaseMatrix>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DISEASEMATRIX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DISEASEMATRIX;

				if (pagination) {
					sql = sql.concat(DiseaseMatrixModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DiseaseMatrix>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DiseaseMatrix>(list);
				}
				else {
					list = (List<DiseaseMatrix>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the disease matrixs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DiseaseMatrix diseaseMatrix : findAll()) {
			remove(diseaseMatrix);
		}
	}

	/**
	 * Returns the number of disease matrixs.
	 *
	 * @return the number of disease matrixs
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

				Query q = session.createQuery(_SQL_COUNT_DISEASEMATRIX);

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
	 * Initializes the disease matrix persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DiseaseMatrix>> listenersList = new ArrayList<ModelListener<DiseaseMatrix>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DiseaseMatrix>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DiseaseMatrixImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DISEASEMATRIX = "SELECT diseaseMatrix FROM DiseaseMatrix diseaseMatrix";
	private static final String _SQL_SELECT_DISEASEMATRIX_WHERE = "SELECT diseaseMatrix FROM DiseaseMatrix diseaseMatrix WHERE ";
	private static final String _SQL_COUNT_DISEASEMATRIX = "SELECT COUNT(diseaseMatrix) FROM DiseaseMatrix diseaseMatrix";
	private static final String _SQL_COUNT_DISEASEMATRIX_WHERE = "SELECT COUNT(diseaseMatrix) FROM DiseaseMatrix diseaseMatrix WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "diseaseMatrix.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DiseaseMatrix exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DiseaseMatrix exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DiseaseMatrixPersistenceImpl.class);
	private static DiseaseMatrix _nullDiseaseMatrix = new DiseaseMatrixImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DiseaseMatrix> toCacheModel() {
				return _nullDiseaseMatrixCacheModel;
			}
		};

	private static CacheModel<DiseaseMatrix> _nullDiseaseMatrixCacheModel = new CacheModel<DiseaseMatrix>() {
			@Override
			public DiseaseMatrix toEntityModel() {
				return _nullDiseaseMatrix;
			}
		};
}