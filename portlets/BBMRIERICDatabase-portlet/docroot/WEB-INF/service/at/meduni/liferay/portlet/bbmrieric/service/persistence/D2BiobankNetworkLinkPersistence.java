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

import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the d2 biobank network link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see D2BiobankNetworkLinkPersistenceImpl
 * @see D2BiobankNetworkLinkUtil
 * @generated
 */
public interface D2BiobankNetworkLinkPersistence extends BasePersistence<D2BiobankNetworkLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link D2BiobankNetworkLinkUtil} to access the d2 biobank network link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the d2 biobank network links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d2 biobank network links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of d2 biobank network links
	* @param end the upper bound of the range of d2 biobank network links (not inclusive)
	* @return the range of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d2 biobank network links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of d2 biobank network links
	* @param end the upper bound of the range of d2 biobank network links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network links before and after the current d2 biobank network link in the ordered set where uuid = &#63;.
	*
	* @param d2biobanknetworklinkId the primary key of the current d2 biobank network link
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink[] findByUuid_PrevAndNext(
		long d2biobanknetworklinkId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d2 biobank network links where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank network links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network link where uuid = &#63; and groupId = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByUUID_G(
		java.lang.String uuid, long groupId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the d2 biobank network link where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the d2 biobank network link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank network links where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d2 biobank network links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d2 biobank network links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of d2 biobank network links
	* @param end the upper bound of the range of d2 biobank network links (not inclusive)
	* @return the range of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d2 biobank network links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of d2 biobank network links
	* @param end the upper bound of the range of d2 biobank network links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network links before and after the current d2 biobank network link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param d2biobanknetworklinkId the primary key of the current d2 biobank network link
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink[] findByUuid_C_PrevAndNext(
		long d2biobanknetworklinkId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d2 biobank network links where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank network links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network link where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException} if it could not be found.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @return the matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByNetworkLinkByChild(
		long d2biobanknetworkId, long d2linkId, java.lang.String d2linktype)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network link where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @return the matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByNetworkLinkByChild(
		long d2biobanknetworkId, long d2linkId, java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network link where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByNetworkLinkByChild(
		long d2biobanknetworkId, long d2linkId, java.lang.String d2linktype,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the d2 biobank network link where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63; from the database.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @return the d2 biobank network link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink removeByNetworkLinkByChild(
		long d2biobanknetworkId, long d2linkId, java.lang.String d2linktype)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank network links where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public int countByNetworkLinkByChild(long d2biobanknetworkId,
		long d2linkId, java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d2 biobank network links where d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @return the matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByNetworkLinksForChild(
		long d2linkId, java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d2 biobank network links where d2linkId = &#63; and d2linktype = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @param start the lower bound of the range of d2 biobank network links
	* @param end the upper bound of the range of d2 biobank network links (not inclusive)
	* @return the range of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByNetworkLinksForChild(
		long d2linkId, java.lang.String d2linktype, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d2 biobank network links where d2linkId = &#63; and d2linktype = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @param start the lower bound of the range of d2 biobank network links
	* @param end the upper bound of the range of d2 biobank network links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByNetworkLinksForChild(
		long d2linkId, java.lang.String d2linktype, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network link in the ordered set where d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByNetworkLinksForChild_First(
		long d2linkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network link in the ordered set where d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByNetworkLinksForChild_First(
		long d2linkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network link in the ordered set where d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByNetworkLinksForChild_Last(
		long d2linkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network link in the ordered set where d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByNetworkLinksForChild_Last(
		long d2linkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network links before and after the current d2 biobank network link in the ordered set where d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworklinkId the primary key of the current d2 biobank network link
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink[] findByNetworkLinksForChild_PrevAndNext(
		long d2biobanknetworklinkId, long d2linkId,
		java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d2 biobank network links where d2linkId = &#63; and d2linktype = &#63; from the database.
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNetworkLinksForChild(long d2linkId,
		java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank network links where d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public int countByNetworkLinksForChild(long d2linkId,
		java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @return the matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByChildForNetworkLinks(
		long d2biobanknetworkId, java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @param start the lower bound of the range of d2 biobank network links
	* @param end the upper bound of the range of d2 biobank network links (not inclusive)
	* @return the range of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByChildForNetworkLinks(
		long d2biobanknetworkId, java.lang.String d2linktype, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @param start the lower bound of the range of d2 biobank network links
	* @param end the upper bound of the range of d2 biobank network links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByChildForNetworkLinks(
		long d2biobanknetworkId, java.lang.String d2linktype, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network link in the ordered set where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByChildForNetworkLinks_First(
		long d2biobanknetworkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network link in the ordered set where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByChildForNetworkLinks_First(
		long d2biobanknetworkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network link in the ordered set where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByChildForNetworkLinks_Last(
		long d2biobanknetworkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network link in the ordered set where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByChildForNetworkLinks_Last(
		long d2biobanknetworkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network links before and after the current d2 biobank network link in the ordered set where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworklinkId the primary key of the current d2 biobank network link
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink[] findByChildForNetworkLinks_PrevAndNext(
		long d2biobanknetworklinkId, long d2biobanknetworkId,
		java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63; from the database.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @throws SystemException if a system exception occurred
	*/
	public void removeByChildForNetworkLinks(long d2biobanknetworkId,
		java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public int countByChildForNetworkLinks(long d2biobanknetworkId,
		java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @return the matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByNotUUID(
		long groupId, java.lang.String updateuuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param start the lower bound of the range of d2 biobank network links
	* @param end the upper bound of the range of d2 biobank network links (not inclusive)
	* @return the range of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByNotUUID(
		long groupId, java.lang.String updateuuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param start the lower bound of the range of d2 biobank network links
	* @param end the upper bound of the range of d2 biobank network links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByNotUUID(
		long groupId, java.lang.String updateuuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network link in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByNotUUID_First(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d2 biobank network link in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByNotUUID_First(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network link in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByNotUUID_Last(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d2 biobank network link in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByNotUUID_Last(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network links before and after the current d2 biobank network link in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param d2biobanknetworklinkId the primary key of the current d2 biobank network link
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink[] findByNotUUID_PrevAndNext(
		long d2biobanknetworklinkId, long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63; from the database.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNotUUID(long groupId, java.lang.String updateuuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public int countByNotUUID(long groupId, java.lang.String updateuuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the d2 biobank network link in the entity cache if it is enabled.
	*
	* @param d2BiobankNetworkLink the d2 biobank network link
	*/
	public void cacheResult(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink d2BiobankNetworkLink);

	/**
	* Caches the d2 biobank network links in the entity cache if it is enabled.
	*
	* @param d2BiobankNetworkLinks the d2 biobank network links
	*/
	public void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> d2BiobankNetworkLinks);

	/**
	* Creates a new d2 biobank network link with the primary key. Does not add the d2 biobank network link to the database.
	*
	* @param d2biobanknetworklinkId the primary key for the new d2 biobank network link
	* @return the new d2 biobank network link
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink create(
		long d2biobanknetworklinkId);

	/**
	* Removes the d2 biobank network link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param d2biobanknetworklinkId the primary key of the d2 biobank network link
	* @return the d2 biobank network link that was removed
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink remove(
		long d2biobanknetworklinkId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink d2BiobankNetworkLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network link with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException} if it could not be found.
	*
	* @param d2biobanknetworklinkId the primary key of the d2 biobank network link
	* @return the d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByPrimaryKey(
		long d2biobanknetworklinkId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param d2biobanknetworklinkId the primary key of the d2 biobank network link
	* @return the d2 biobank network link, or <code>null</code> if a d2 biobank network link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByPrimaryKey(
		long d2biobanknetworklinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d2 biobank network links.
	*
	* @return the d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d2 biobank network links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d2 biobank network links
	* @param end the upper bound of the range of d2 biobank network links (not inclusive)
	* @return the range of d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d2 biobank network links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d2 biobank network links
	* @param end the upper bound of the range of d2 biobank network links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d2 biobank network links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank network links.
	*
	* @return the number of d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}