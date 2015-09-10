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

import at.graz.hmmc.liferay.portlet.puch.model.ObjectImage;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the object image service. This utility wraps {@link ObjectImagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ObjectImagePersistence
 * @see ObjectImagePersistenceImpl
 * @generated
 */
public class ObjectImageUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ObjectImage objectImage) {
		getPersistence().clearCache(objectImage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ObjectImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ObjectImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ObjectImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ObjectImage update(ObjectImage objectImage)
		throws SystemException {
		return getPersistence().update(objectImage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ObjectImage update(ObjectImage objectImage,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(objectImage, serviceContext);
	}

	/**
	* Returns all the object images where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @return the matching object images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> findByObject(
		long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByObject(puchmuseumsobjectId);
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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> findByObject(
		long puchmuseumsobjectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByObject(puchmuseumsobjectId, start, end);
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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> findByObject(
		long puchmuseumsobjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByObject(puchmuseumsobjectId, start, end,
			orderByComparator);
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
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectImage findByObject_First(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByObject_First(puchmuseumsobjectId, orderByComparator);
	}

	/**
	* Returns the first object image in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object image, or <code>null</code> if a matching object image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectImage fetchByObject_First(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByObject_First(puchmuseumsobjectId, orderByComparator);
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
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectImage findByObject_Last(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByObject_Last(puchmuseumsobjectId, orderByComparator);
	}

	/**
	* Returns the last object image in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object image, or <code>null</code> if a matching object image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectImage fetchByObject_Last(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByObject_Last(puchmuseumsobjectId, orderByComparator);
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
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectImage[] findByObject_PrevAndNext(
		long objectimageId, long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByObject_PrevAndNext(objectimageId,
			puchmuseumsobjectId, orderByComparator);
	}

	/**
	* Removes all the object images where puchmuseumsobjectId = &#63; from the database.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByObject(long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByObject(puchmuseumsobjectId);
	}

	/**
	* Returns the number of object images where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @return the number of matching object images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByObject(long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByObject(puchmuseumsobjectId);
	}

	/**
	* Caches the object image in the entity cache if it is enabled.
	*
	* @param objectImage the object image
	*/
	public static void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectImage objectImage) {
		getPersistence().cacheResult(objectImage);
	}

	/**
	* Caches the object images in the entity cache if it is enabled.
	*
	* @param objectImages the object images
	*/
	public static void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> objectImages) {
		getPersistence().cacheResult(objectImages);
	}

	/**
	* Creates a new object image with the primary key. Does not add the object image to the database.
	*
	* @param objectimageId the primary key for the new object image
	* @return the new object image
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectImage create(
		long objectimageId) {
		return getPersistence().create(objectimageId);
	}

	/**
	* Removes the object image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param objectimageId the primary key of the object image
	* @return the object image that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a object image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectImage remove(
		long objectimageId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(objectimageId);
	}

	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectImage updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectImage objectImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(objectImage);
	}

	/**
	* Returns the object image with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException} if it could not be found.
	*
	* @param objectimageId the primary key of the object image
	* @return the object image
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a object image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectImage findByPrimaryKey(
		long objectimageId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(objectimageId);
	}

	/**
	* Returns the object image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param objectimageId the primary key of the object image
	* @return the object image, or <code>null</code> if a object image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.ObjectImage fetchByPrimaryKey(
		long objectimageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(objectimageId);
	}

	/**
	* Returns all the object images.
	*
	* @return the object images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the object images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of object images.
	*
	* @return the number of object images
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ObjectImagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ObjectImagePersistence)PortletBeanLocatorUtil.locate(at.graz.hmmc.liferay.portlet.puch.service.ClpSerializer.getServletContextName(),
					ObjectImagePersistence.class.getName());

			ReferenceRegistry.registerReference(ObjectImageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ObjectImagePersistence persistence) {
	}

	private static ObjectImagePersistence _persistence;
}