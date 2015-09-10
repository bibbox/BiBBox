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

import at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException;
import at.graz.hmmc.liferay.portlet.puch.model.ObjectImage;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectImageImpl;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectImageModelImpl;

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
 * The persistence implementation for the object image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ObjectImagePersistence
 * @see ObjectImageUtil
 * @generated
 */
public class ObjectImagePersistenceImpl extends BasePersistenceImpl<ObjectImage>
	implements ObjectImagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ObjectImageUtil} to access the object image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ObjectImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
			ObjectImageModelImpl.FINDER_CACHE_ENABLED, ObjectImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
			ObjectImageModelImpl.FINDER_CACHE_ENABLED, ObjectImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
			ObjectImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECT = new FinderPath(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
			ObjectImageModelImpl.FINDER_CACHE_ENABLED, ObjectImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByObject",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECT =
		new FinderPath(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
			ObjectImageModelImpl.FINDER_CACHE_ENABLED, ObjectImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByObject",
			new String[] { Long.class.getName() },
			ObjectImageModelImpl.PUCHMUSEUMSOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OBJECT = new FinderPath(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
			ObjectImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByObject",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the object images where puchmuseumsobjectId = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @return the matching object images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectImage> findByObject(long puchmuseumsobjectId)
		throws SystemException {
		return findByObject(puchmuseumsobjectId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the object images where puchmuseumsobjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param start the lower bound of the range of object images
	 * @param end the upper bound of the range of object images (not inclusive)
	 * @return the range of matching object images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectImage> findByObject(long puchmuseumsobjectId, int start,
		int end) throws SystemException {
		return findByObject(puchmuseumsobjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the object images where puchmuseumsobjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param start the lower bound of the range of object images
	 * @param end the upper bound of the range of object images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching object images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectImage> findByObject(long puchmuseumsobjectId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECT;
			finderArgs = new Object[] { puchmuseumsobjectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECT;
			finderArgs = new Object[] {
					puchmuseumsobjectId,
					
					start, end, orderByComparator
				};
		}

		List<ObjectImage> list = (List<ObjectImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ObjectImage objectImage : list) {
				if ((puchmuseumsobjectId != objectImage.getPuchmuseumsobjectId())) {
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

			query.append(_SQL_SELECT_OBJECTIMAGE_WHERE);

			query.append(_FINDER_COLUMN_OBJECT_PUCHMUSEUMSOBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ObjectImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(puchmuseumsobjectId);

				if (!pagination) {
					list = (List<ObjectImage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ObjectImage>(list);
				}
				else {
					list = (List<ObjectImage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first object image in the ordered set where puchmuseumsobjectId = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching object image
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a matching object image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectImage findByObject_First(long puchmuseumsobjectId,
		OrderByComparator orderByComparator)
		throws NoSuchObjectImageException, SystemException {
		ObjectImage objectImage = fetchByObject_First(puchmuseumsobjectId,
				orderByComparator);

		if (objectImage != null) {
			return objectImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("puchmuseumsobjectId=");
		msg.append(puchmuseumsobjectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchObjectImageException(msg.toString());
	}

	/**
	 * Returns the first object image in the ordered set where puchmuseumsobjectId = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching object image, or <code>null</code> if a matching object image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectImage fetchByObject_First(long puchmuseumsobjectId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ObjectImage> list = findByObject(puchmuseumsobjectId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last object image in the ordered set where puchmuseumsobjectId = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching object image
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a matching object image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectImage findByObject_Last(long puchmuseumsobjectId,
		OrderByComparator orderByComparator)
		throws NoSuchObjectImageException, SystemException {
		ObjectImage objectImage = fetchByObject_Last(puchmuseumsobjectId,
				orderByComparator);

		if (objectImage != null) {
			return objectImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("puchmuseumsobjectId=");
		msg.append(puchmuseumsobjectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchObjectImageException(msg.toString());
	}

	/**
	 * Returns the last object image in the ordered set where puchmuseumsobjectId = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching object image, or <code>null</code> if a matching object image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectImage fetchByObject_Last(long puchmuseumsobjectId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByObject(puchmuseumsobjectId);

		if (count == 0) {
			return null;
		}

		List<ObjectImage> list = findByObject(puchmuseumsobjectId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the object images before and after the current object image in the ordered set where puchmuseumsobjectId = &#63;.
	 *
	 * @param objectimageId the primary key of the current object image
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next object image
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a object image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectImage[] findByObject_PrevAndNext(long objectimageId,
		long puchmuseumsobjectId, OrderByComparator orderByComparator)
		throws NoSuchObjectImageException, SystemException {
		ObjectImage objectImage = findByPrimaryKey(objectimageId);

		Session session = null;

		try {
			session = openSession();

			ObjectImage[] array = new ObjectImageImpl[3];

			array[0] = getByObject_PrevAndNext(session, objectImage,
					puchmuseumsobjectId, orderByComparator, true);

			array[1] = objectImage;

			array[2] = getByObject_PrevAndNext(session, objectImage,
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

	protected ObjectImage getByObject_PrevAndNext(Session session,
		ObjectImage objectImage, long puchmuseumsobjectId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OBJECTIMAGE_WHERE);

		query.append(_FINDER_COLUMN_OBJECT_PUCHMUSEUMSOBJECTID_2);

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
			query.append(ObjectImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(puchmuseumsobjectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(objectImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ObjectImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the object images where puchmuseumsobjectId = &#63; from the database.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByObject(long puchmuseumsobjectId)
		throws SystemException {
		for (ObjectImage objectImage : findByObject(puchmuseumsobjectId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(objectImage);
		}
	}

	/**
	 * Returns the number of object images where puchmuseumsobjectId = &#63;.
	 *
	 * @param puchmuseumsobjectId the puchmuseumsobject ID
	 * @return the number of matching object images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByObject(long puchmuseumsobjectId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OBJECT;

		Object[] finderArgs = new Object[] { puchmuseumsobjectId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OBJECTIMAGE_WHERE);

			query.append(_FINDER_COLUMN_OBJECT_PUCHMUSEUMSOBJECTID_2);

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

	private static final String _FINDER_COLUMN_OBJECT_PUCHMUSEUMSOBJECTID_2 = "objectImage.puchmuseumsobjectId = ?";

	public ObjectImagePersistenceImpl() {
		setModelClass(ObjectImage.class);
	}

	/**
	 * Caches the object image in the entity cache if it is enabled.
	 *
	 * @param objectImage the object image
	 */
	@Override
	public void cacheResult(ObjectImage objectImage) {
		EntityCacheUtil.putResult(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
			ObjectImageImpl.class, objectImage.getPrimaryKey(), objectImage);

		objectImage.resetOriginalValues();
	}

	/**
	 * Caches the object images in the entity cache if it is enabled.
	 *
	 * @param objectImages the object images
	 */
	@Override
	public void cacheResult(List<ObjectImage> objectImages) {
		for (ObjectImage objectImage : objectImages) {
			if (EntityCacheUtil.getResult(
						ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
						ObjectImageImpl.class, objectImage.getPrimaryKey()) == null) {
				cacheResult(objectImage);
			}
			else {
				objectImage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all object images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ObjectImageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ObjectImageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the object image.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ObjectImage objectImage) {
		EntityCacheUtil.removeResult(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
			ObjectImageImpl.class, objectImage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ObjectImage> objectImages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ObjectImage objectImage : objectImages) {
			EntityCacheUtil.removeResult(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
				ObjectImageImpl.class, objectImage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new object image with the primary key. Does not add the object image to the database.
	 *
	 * @param objectimageId the primary key for the new object image
	 * @return the new object image
	 */
	@Override
	public ObjectImage create(long objectimageId) {
		ObjectImage objectImage = new ObjectImageImpl();

		objectImage.setNew(true);
		objectImage.setPrimaryKey(objectimageId);

		return objectImage;
	}

	/**
	 * Removes the object image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param objectimageId the primary key of the object image
	 * @return the object image that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a object image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectImage remove(long objectimageId)
		throws NoSuchObjectImageException, SystemException {
		return remove((Serializable)objectimageId);
	}

	/**
	 * Removes the object image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the object image
	 * @return the object image that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a object image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectImage remove(Serializable primaryKey)
		throws NoSuchObjectImageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ObjectImage objectImage = (ObjectImage)session.get(ObjectImageImpl.class,
					primaryKey);

			if (objectImage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchObjectImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(objectImage);
		}
		catch (NoSuchObjectImageException nsee) {
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
	protected ObjectImage removeImpl(ObjectImage objectImage)
		throws SystemException {
		objectImage = toUnwrappedModel(objectImage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(objectImage)) {
				objectImage = (ObjectImage)session.get(ObjectImageImpl.class,
						objectImage.getPrimaryKeyObj());
			}

			if (objectImage != null) {
				session.delete(objectImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (objectImage != null) {
			clearCache(objectImage);
		}

		return objectImage;
	}

	@Override
	public ObjectImage updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectImage objectImage)
		throws SystemException {
		objectImage = toUnwrappedModel(objectImage);

		boolean isNew = objectImage.isNew();

		ObjectImageModelImpl objectImageModelImpl = (ObjectImageModelImpl)objectImage;

		Session session = null;

		try {
			session = openSession();

			if (objectImage.isNew()) {
				session.save(objectImage);

				objectImage.setNew(false);
			}
			else {
				session.merge(objectImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ObjectImageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((objectImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						objectImageModelImpl.getOriginalPuchmuseumsobjectId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJECT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECT,
					args);

				args = new Object[] {
						objectImageModelImpl.getPuchmuseumsobjectId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJECT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECT,
					args);
			}
		}

		EntityCacheUtil.putResult(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
			ObjectImageImpl.class, objectImage.getPrimaryKey(), objectImage);

		return objectImage;
	}

	protected ObjectImage toUnwrappedModel(ObjectImage objectImage) {
		if (objectImage instanceof ObjectImageImpl) {
			return objectImage;
		}

		ObjectImageImpl objectImageImpl = new ObjectImageImpl();

		objectImageImpl.setNew(objectImage.isNew());
		objectImageImpl.setPrimaryKey(objectImage.getPrimaryKey());

		objectImageImpl.setObjectimageId(objectImage.getObjectimageId());
		objectImageImpl.setPuchmuseumsobjectId(objectImage.getPuchmuseumsobjectId());
		objectImageImpl.setCreaterUserId(objectImage.getCreaterUserId());
		objectImageImpl.setCreateDate(objectImage.getCreateDate());
		objectImageImpl.setModifiedUserId(objectImage.getModifiedUserId());
		objectImageImpl.setModifiedDate(objectImage.getModifiedDate());
		objectImageImpl.setDlappimagerawId(objectImage.getDlappimagerawId());
		objectImageImpl.setDlappimageprocessedId(objectImage.getDlappimageprocessedId());
		objectImageImpl.setDlappimagewebId(objectImage.getDlappimagewebId());

		return objectImageImpl;
	}

	/**
	 * Returns the object image with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the object image
	 * @return the object image
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a object image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectImage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchObjectImageException, SystemException {
		ObjectImage objectImage = fetchByPrimaryKey(primaryKey);

		if (objectImage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchObjectImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return objectImage;
	}

	/**
	 * Returns the object image with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException} if it could not be found.
	 *
	 * @param objectimageId the primary key of the object image
	 * @return the object image
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a object image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectImage findByPrimaryKey(long objectimageId)
		throws NoSuchObjectImageException, SystemException {
		return findByPrimaryKey((Serializable)objectimageId);
	}

	/**
	 * Returns the object image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the object image
	 * @return the object image, or <code>null</code> if a object image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectImage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ObjectImage objectImage = (ObjectImage)EntityCacheUtil.getResult(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
				ObjectImageImpl.class, primaryKey);

		if (objectImage == _nullObjectImage) {
			return null;
		}

		if (objectImage == null) {
			Session session = null;

			try {
				session = openSession();

				objectImage = (ObjectImage)session.get(ObjectImageImpl.class,
						primaryKey);

				if (objectImage != null) {
					cacheResult(objectImage);
				}
				else {
					EntityCacheUtil.putResult(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
						ObjectImageImpl.class, primaryKey, _nullObjectImage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ObjectImageModelImpl.ENTITY_CACHE_ENABLED,
					ObjectImageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return objectImage;
	}

	/**
	 * Returns the object image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param objectimageId the primary key of the object image
	 * @return the object image, or <code>null</code> if a object image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectImage fetchByPrimaryKey(long objectimageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)objectimageId);
	}

	/**
	 * Returns all the object images.
	 *
	 * @return the object images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectImage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the object images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of object images
	 * @param end the upper bound of the range of object images (not inclusive)
	 * @return the range of object images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectImage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the object images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of object images
	 * @param end the upper bound of the range of object images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of object images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectImage> findAll(int start, int end,
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

		List<ObjectImage> list = (List<ObjectImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OBJECTIMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OBJECTIMAGE;

				if (pagination) {
					sql = sql.concat(ObjectImageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ObjectImage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ObjectImage>(list);
				}
				else {
					list = (List<ObjectImage>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the object images from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ObjectImage objectImage : findAll()) {
			remove(objectImage);
		}
	}

	/**
	 * Returns the number of object images.
	 *
	 * @return the number of object images
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

				Query q = session.createQuery(_SQL_COUNT_OBJECTIMAGE);

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
	 * Initializes the object image persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.hmmc.liferay.portlet.puch.model.ObjectImage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ObjectImage>> listenersList = new ArrayList<ModelListener<ObjectImage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ObjectImage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ObjectImageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OBJECTIMAGE = "SELECT objectImage FROM ObjectImage objectImage";
	private static final String _SQL_SELECT_OBJECTIMAGE_WHERE = "SELECT objectImage FROM ObjectImage objectImage WHERE ";
	private static final String _SQL_COUNT_OBJECTIMAGE = "SELECT COUNT(objectImage) FROM ObjectImage objectImage";
	private static final String _SQL_COUNT_OBJECTIMAGE_WHERE = "SELECT COUNT(objectImage) FROM ObjectImage objectImage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "objectImage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ObjectImage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ObjectImage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ObjectImagePersistenceImpl.class);
	private static ObjectImage _nullObjectImage = new ObjectImageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ObjectImage> toCacheModel() {
				return _nullObjectImageCacheModel;
			}
		};

	private static CacheModel<ObjectImage> _nullObjectImageCacheModel = new CacheModel<ObjectImage>() {
			@Override
			public ObjectImage toEntityModel() {
				return _nullObjectImage;
			}
		};
}