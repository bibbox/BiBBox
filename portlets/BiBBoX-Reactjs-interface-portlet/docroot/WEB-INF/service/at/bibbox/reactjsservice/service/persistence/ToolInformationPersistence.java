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

package at.bibbox.reactjsservice.service.persistence;

import at.bibbox.reactjsservice.model.ToolInformation;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the tool information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ToolInformationPersistenceImpl
 * @see ToolInformationUtil
 * @generated
 */
public interface ToolInformationPersistence extends BasePersistence<ToolInformation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ToolInformationUtil} to access the tool information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tool informations where category = &#63;.
	*
	* @param category the category
	* @return the matching tool informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.bibbox.reactjsservice.model.ToolInformation> findByCategory(
		java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tool informations where category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.bibbox.reactjsservice.model.impl.ToolInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param start the lower bound of the range of tool informations
	* @param end the upper bound of the range of tool informations (not inclusive)
	* @return the range of matching tool informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.bibbox.reactjsservice.model.ToolInformation> findByCategory(
		java.lang.String category, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tool informations where category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.bibbox.reactjsservice.model.impl.ToolInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param start the lower bound of the range of tool informations
	* @param end the upper bound of the range of tool informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tool informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.bibbox.reactjsservice.model.ToolInformation> findByCategory(
		java.lang.String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tool information in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tool information
	* @throws at.bibbox.reactjsservice.NoSuchToolInformationException if a matching tool information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.bibbox.reactjsservice.model.ToolInformation findByCategory_First(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.bibbox.reactjsservice.NoSuchToolInformationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tool information in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tool information, or <code>null</code> if a matching tool information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.bibbox.reactjsservice.model.ToolInformation fetchByCategory_First(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tool information in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tool information
	* @throws at.bibbox.reactjsservice.NoSuchToolInformationException if a matching tool information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.bibbox.reactjsservice.model.ToolInformation findByCategory_Last(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.bibbox.reactjsservice.NoSuchToolInformationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tool information in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tool information, or <code>null</code> if a matching tool information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.bibbox.reactjsservice.model.ToolInformation fetchByCategory_Last(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tool informations before and after the current tool information in the ordered set where category = &#63;.
	*
	* @param toolInformationId the primary key of the current tool information
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tool information
	* @throws at.bibbox.reactjsservice.NoSuchToolInformationException if a tool information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.bibbox.reactjsservice.model.ToolInformation[] findByCategory_PrevAndNext(
		long toolInformationId, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.bibbox.reactjsservice.NoSuchToolInformationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tool informations where category = &#63; from the database.
	*
	* @param category the category
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tool informations where category = &#63;.
	*
	* @param category the category
	* @return the number of matching tool informations
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the tool information in the entity cache if it is enabled.
	*
	* @param toolInformation the tool information
	*/
	public void cacheResult(
		at.bibbox.reactjsservice.model.ToolInformation toolInformation);

	/**
	* Caches the tool informations in the entity cache if it is enabled.
	*
	* @param toolInformations the tool informations
	*/
	public void cacheResult(
		java.util.List<at.bibbox.reactjsservice.model.ToolInformation> toolInformations);

	/**
	* Creates a new tool information with the primary key. Does not add the tool information to the database.
	*
	* @param toolInformationId the primary key for the new tool information
	* @return the new tool information
	*/
	public at.bibbox.reactjsservice.model.ToolInformation create(
		long toolInformationId);

	/**
	* Removes the tool information with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param toolInformationId the primary key of the tool information
	* @return the tool information that was removed
	* @throws at.bibbox.reactjsservice.NoSuchToolInformationException if a tool information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.bibbox.reactjsservice.model.ToolInformation remove(
		long toolInformationId)
		throws at.bibbox.reactjsservice.NoSuchToolInformationException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.bibbox.reactjsservice.model.ToolInformation updateImpl(
		at.bibbox.reactjsservice.model.ToolInformation toolInformation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tool information with the primary key or throws a {@link at.bibbox.reactjsservice.NoSuchToolInformationException} if it could not be found.
	*
	* @param toolInformationId the primary key of the tool information
	* @return the tool information
	* @throws at.bibbox.reactjsservice.NoSuchToolInformationException if a tool information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.bibbox.reactjsservice.model.ToolInformation findByPrimaryKey(
		long toolInformationId)
		throws at.bibbox.reactjsservice.NoSuchToolInformationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tool information with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param toolInformationId the primary key of the tool information
	* @return the tool information, or <code>null</code> if a tool information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.bibbox.reactjsservice.model.ToolInformation fetchByPrimaryKey(
		long toolInformationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tool informations.
	*
	* @return the tool informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.bibbox.reactjsservice.model.ToolInformation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tool informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.bibbox.reactjsservice.model.impl.ToolInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tool informations
	* @param end the upper bound of the range of tool informations (not inclusive)
	* @return the range of tool informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.bibbox.reactjsservice.model.ToolInformation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tool informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.bibbox.reactjsservice.model.impl.ToolInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tool informations
	* @param end the upper bound of the range of tool informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tool informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.bibbox.reactjsservice.model.ToolInformation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tool informations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tool informations.
	*
	* @return the number of tool informations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}