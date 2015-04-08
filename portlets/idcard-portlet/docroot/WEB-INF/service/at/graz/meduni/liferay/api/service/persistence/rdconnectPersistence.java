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

package at.graz.meduni.liferay.api.service.persistence;

import at.graz.meduni.liferay.api.model.rdconnect;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the rdconnect service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see rdconnectPersistenceImpl
 * @see rdconnectUtil
 * @generated
 */
public interface rdconnectPersistence extends BasePersistence<rdconnect> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link rdconnectUtil} to access the rdconnect persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rdconnects where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching rdconnects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.api.model.rdconnect> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rdconnects where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.api.model.impl.rdconnectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of rdconnects
	* @param end the upper bound of the range of rdconnects (not inclusive)
	* @return the range of matching rdconnects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.api.model.rdconnect> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rdconnects where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.api.model.impl.rdconnectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of rdconnects
	* @param end the upper bound of the range of rdconnects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rdconnects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.api.model.rdconnect> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rdconnect in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rdconnect
	* @throws at.graz.meduni.liferay.api.NoSuchrdconnectException if a matching rdconnect could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.api.model.rdconnect findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.api.NoSuchrdconnectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rdconnect in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rdconnect, or <code>null</code> if a matching rdconnect could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.api.model.rdconnect fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rdconnect in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rdconnect
	* @throws at.graz.meduni.liferay.api.NoSuchrdconnectException if a matching rdconnect could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.api.model.rdconnect findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.api.NoSuchrdconnectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rdconnect in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rdconnect, or <code>null</code> if a matching rdconnect could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.api.model.rdconnect fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rdconnects before and after the current rdconnect in the ordered set where userId = &#63;.
	*
	* @param idcardapilogId the primary key of the current rdconnect
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rdconnect
	* @throws at.graz.meduni.liferay.api.NoSuchrdconnectException if a rdconnect with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.api.model.rdconnect[] findByUserId_PrevAndNext(
		long idcardapilogId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.api.NoSuchrdconnectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rdconnects where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rdconnects where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching rdconnects
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the rdconnect in the entity cache if it is enabled.
	*
	* @param rdconnect the rdconnect
	*/
	public void cacheResult(
		at.graz.meduni.liferay.api.model.rdconnect rdconnect);

	/**
	* Caches the rdconnects in the entity cache if it is enabled.
	*
	* @param rdconnects the rdconnects
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.api.model.rdconnect> rdconnects);

	/**
	* Creates a new rdconnect with the primary key. Does not add the rdconnect to the database.
	*
	* @param idcardapilogId the primary key for the new rdconnect
	* @return the new rdconnect
	*/
	public at.graz.meduni.liferay.api.model.rdconnect create(
		long idcardapilogId);

	/**
	* Removes the rdconnect with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idcardapilogId the primary key of the rdconnect
	* @return the rdconnect that was removed
	* @throws at.graz.meduni.liferay.api.NoSuchrdconnectException if a rdconnect with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.api.model.rdconnect remove(
		long idcardapilogId)
		throws at.graz.meduni.liferay.api.NoSuchrdconnectException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.api.model.rdconnect updateImpl(
		at.graz.meduni.liferay.api.model.rdconnect rdconnect)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rdconnect with the primary key or throws a {@link at.graz.meduni.liferay.api.NoSuchrdconnectException} if it could not be found.
	*
	* @param idcardapilogId the primary key of the rdconnect
	* @return the rdconnect
	* @throws at.graz.meduni.liferay.api.NoSuchrdconnectException if a rdconnect with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.api.model.rdconnect findByPrimaryKey(
		long idcardapilogId)
		throws at.graz.meduni.liferay.api.NoSuchrdconnectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rdconnect with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idcardapilogId the primary key of the rdconnect
	* @return the rdconnect, or <code>null</code> if a rdconnect with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.api.model.rdconnect fetchByPrimaryKey(
		long idcardapilogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rdconnects.
	*
	* @return the rdconnects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.api.model.rdconnect> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rdconnects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.api.model.impl.rdconnectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rdconnects
	* @param end the upper bound of the range of rdconnects (not inclusive)
	* @return the range of rdconnects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.api.model.rdconnect> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rdconnects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.api.model.impl.rdconnectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rdconnects
	* @param end the upper bound of the range of rdconnects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rdconnects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.api.model.rdconnect> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rdconnects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rdconnects.
	*
	* @return the number of rdconnects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}