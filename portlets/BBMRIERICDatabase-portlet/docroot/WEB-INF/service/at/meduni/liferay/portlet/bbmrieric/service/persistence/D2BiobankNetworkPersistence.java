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

package at.meduni.liferay.portlet.bbmrieric.service.persistence;

import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the d2 biobank network service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see D2BiobankNetworkPersistenceImpl
 * @see D2BiobankNetworkUtil
 * @generated
 */
public interface D2BiobankNetworkPersistence extends BasePersistence<D2BiobankNetwork> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link D2BiobankNetworkUtil} to access the d2 biobank network persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the d2 biobank networks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d2 biobank networks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of d2 biobank networks
	* @param end the upper bound of the range of d2 biobank networks (not inclusive)
	* @return the range of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d2 biobank networks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of d2 biobank networks
	* @param end the upper bound of the range of d2 biobank networks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank networks before and after the current d2 biobank network in the ordered set where uuid = &#63;.
	*
	* @param d2biobanknetworkId the primary key of the current d2 biobank network
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork[] findByUuid_PrevAndNext(
		long d2biobanknetworkId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d2 biobank networks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank networks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network where uuid = &#63; and groupId = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByUUID_G(
		java.lang.String uuid, long groupId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the d2 biobank network where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the d2 biobank network that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank networks where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d2 biobank networks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d2 biobank networks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of d2 biobank networks
	* @param end the upper bound of the range of d2 biobank networks (not inclusive)
	* @return the range of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d2 biobank networks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of d2 biobank networks
	* @param end the upper bound of the range of d2 biobank networks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank networks before and after the current d2 biobank network in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param d2biobanknetworkId the primary key of the current d2 biobank network
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork[] findByUuid_C_PrevAndNext(
		long d2biobanknetworkId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d2 biobank networks where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank networks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @return the matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByNotUUID(
		long groupId, java.lang.String updateuuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param start the lower bound of the range of d2 biobank networks
	* @param end the upper bound of the range of d2 biobank networks (not inclusive)
	* @return the range of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByNotUUID(
		long groupId, java.lang.String updateuuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param start the lower bound of the range of d2 biobank networks
	* @param end the upper bound of the range of d2 biobank networks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByNotUUID(
		long groupId, java.lang.String updateuuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByNotUUID_First(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByNotUUID_First(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByNotUUID_Last(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByNotUUID_Last(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank networks before and after the current d2 biobank network in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param d2biobanknetworkId the primary key of the current d2 biobank network
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork[] findByNotUUID_PrevAndNext(
		long d2biobanknetworkId, long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63; from the database.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNotUUID(long groupId, java.lang.String updateuuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @return the number of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public int countByNotUUID(long groupId, java.lang.String updateuuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network where groupId = &#63; and bbmriBiobankNetworkID = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException} if it could not be found.
	*
	* @param groupId the group ID
	* @param bbmriBiobankNetworkID the bbmri biobank network i d
	* @return the matching d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByBiobankNetworkBBMRIERICID(
		long groupId, java.lang.String bbmriBiobankNetworkID)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network where groupId = &#63; and bbmriBiobankNetworkID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param bbmriBiobankNetworkID the bbmri biobank network i d
	* @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByBiobankNetworkBBMRIERICID(
		long groupId, java.lang.String bbmriBiobankNetworkID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network where groupId = &#63; and bbmriBiobankNetworkID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param bbmriBiobankNetworkID the bbmri biobank network i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByBiobankNetworkBBMRIERICID(
		long groupId, java.lang.String bbmriBiobankNetworkID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the d2 biobank network where groupId = &#63; and bbmriBiobankNetworkID = &#63; from the database.
	*
	* @param groupId the group ID
	* @param bbmriBiobankNetworkID the bbmri biobank network i d
	* @return the d2 biobank network that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork removeByBiobankNetworkBBMRIERICID(
		long groupId, java.lang.String bbmriBiobankNetworkID)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank networks where groupId = &#63; and bbmriBiobankNetworkID = &#63;.
	*
	* @param groupId the group ID
	* @param bbmriBiobankNetworkID the bbmri biobank network i d
	* @return the number of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public int countByBiobankNetworkBBMRIERICID(long groupId,
		java.lang.String bbmriBiobankNetworkID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the d2 biobank network in the entity cache if it is enabled.
	*
	* @param d2BiobankNetwork the d2 biobank network
	*/
	public void cacheResult(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork d2BiobankNetwork);

	/**
	* Caches the d2 biobank networks in the entity cache if it is enabled.
	*
	* @param d2BiobankNetworks the d2 biobank networks
	*/
	public void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> d2BiobankNetworks);

	/**
	* Creates a new d2 biobank network with the primary key. Does not add the d2 biobank network to the database.
	*
	* @param d2biobanknetworkId the primary key for the new d2 biobank network
	* @return the new d2 biobank network
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork create(
		long d2biobanknetworkId);

	/**
	* Removes the d2 biobank network with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param d2biobanknetworkId the primary key of the d2 biobank network
	* @return the d2 biobank network that was removed
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork remove(
		long d2biobanknetworkId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork d2BiobankNetwork)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException} if it could not be found.
	*
	* @param d2biobanknetworkId the primary key of the d2 biobank network
	* @return the d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByPrimaryKey(
		long d2biobanknetworkId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param d2biobanknetworkId the primary key of the d2 biobank network
	* @return the d2 biobank network, or <code>null</code> if a d2 biobank network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByPrimaryKey(
		long d2biobanknetworkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d2 biobank networks.
	*
	* @return the d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d2 biobank networks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d2 biobank networks
	* @param end the upper bound of the range of d2 biobank networks (not inclusive)
	* @return the range of d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d2 biobank networks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d2 biobank networks
	* @param end the upper bound of the range of d2 biobank networks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d2 biobank networks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank networks.
	*
	* @return the number of d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}