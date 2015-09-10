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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the object image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ObjectImagePersistenceImpl
 * @see ObjectImageUtil
 * @generated
 */
public interface ObjectImagePersistence extends BasePersistence<ObjectImage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ObjectImageUtil} to access the object image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the object images where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @return the matching object images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> findByObject(
		long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> findByObject(
		long puchmuseumsobjectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> findByObject(
		long puchmuseumsobjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first object image in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object image
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a matching object image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectImage findByObject_First(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first object image in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object image, or <code>null</code> if a matching object image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectImage fetchByObject_First(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last object image in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object image
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a matching object image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectImage findByObject_Last(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last object image in the ordered set where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object image, or <code>null</code> if a matching object image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectImage fetchByObject_Last(
		long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectImage[] findByObject_PrevAndNext(
		long objectimageId, long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the object images where puchmuseumsobjectId = &#63; from the database.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByObject(long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of object images where puchmuseumsobjectId = &#63;.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @return the number of matching object images
	* @throws SystemException if a system exception occurred
	*/
	public int countByObject(long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the object image in the entity cache if it is enabled.
	*
	* @param objectImage the object image
	*/
	public void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectImage objectImage);

	/**
	* Caches the object images in the entity cache if it is enabled.
	*
	* @param objectImages the object images
	*/
	public void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> objectImages);

	/**
	* Creates a new object image with the primary key. Does not add the object image to the database.
	*
	* @param objectimageId the primary key for the new object image
	* @return the new object image
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectImage create(
		long objectimageId);

	/**
	* Removes the object image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param objectimageId the primary key of the object image
	* @return the object image that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a object image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectImage remove(
		long objectimageId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.hmmc.liferay.portlet.puch.model.ObjectImage updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectImage objectImage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object image with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException} if it could not be found.
	*
	* @param objectimageId the primary key of the object image
	* @return the object image
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException if a object image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectImage findByPrimaryKey(
		long objectimageId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchObjectImageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param objectimageId the primary key of the object image
	* @return the object image, or <code>null</code> if a object image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectImage fetchByPrimaryKey(
		long objectimageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the object images.
	*
	* @return the object images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the object images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of object images.
	*
	* @return the number of object images
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}