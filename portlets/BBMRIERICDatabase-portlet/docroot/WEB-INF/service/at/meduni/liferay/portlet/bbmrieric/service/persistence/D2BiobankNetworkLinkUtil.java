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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the d2 biobank network link service. This utility wraps {@link D2BiobankNetworkLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see D2BiobankNetworkLinkPersistence
 * @see D2BiobankNetworkLinkPersistenceImpl
 * @generated
 */
public class D2BiobankNetworkLinkUtil {
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
	public static void clearCache(D2BiobankNetworkLink d2BiobankNetworkLink) {
		getPersistence().clearCache(d2BiobankNetworkLink);
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
	public static List<D2BiobankNetworkLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<D2BiobankNetworkLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<D2BiobankNetworkLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static D2BiobankNetworkLink update(
		D2BiobankNetworkLink d2BiobankNetworkLink) throws SystemException {
		return getPersistence().update(d2BiobankNetworkLink);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static D2BiobankNetworkLink update(
		D2BiobankNetworkLink d2BiobankNetworkLink, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(d2BiobankNetworkLink, serviceContext);
	}

	/**
	* Returns all the d2 biobank network links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first d2 biobank network link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first d2 biobank network link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last d2 biobank network link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last d2 biobank network link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink[] findByUuid_PrevAndNext(
		long d2biobanknetworklinkId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(d2biobanknetworklinkId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the d2 biobank network links where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of d2 biobank network links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the d2 biobank network link where uuid = &#63; and groupId = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByUUID_G(
		java.lang.String uuid, long groupId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the d2 biobank network link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the d2 biobank network link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the d2 biobank network link where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the d2 biobank network link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of d2 biobank network links where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the d2 biobank network links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first d2 biobank network link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last d2 biobank network link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink[] findByUuid_C_PrevAndNext(
		long d2biobanknetworklinkId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(d2biobanknetworklinkId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the d2 biobank network links where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of d2 biobank network links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByNetworkLinkByChild(
		long d2biobanknetworkId, long d2linkId, java.lang.String d2linktype)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkLinkByChild(d2biobanknetworkId, d2linkId,
			d2linktype);
	}

	/**
	* Returns the d2 biobank network link where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @return the matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByNetworkLinkByChild(
		long d2biobanknetworkId, long d2linkId, java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNetworkLinkByChild(d2biobanknetworkId, d2linkId,
			d2linktype);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByNetworkLinkByChild(
		long d2biobanknetworkId, long d2linkId, java.lang.String d2linktype,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNetworkLinkByChild(d2biobanknetworkId, d2linkId,
			d2linktype, retrieveFromCache);
	}

	/**
	* Removes the d2 biobank network link where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63; from the database.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @return the d2 biobank network link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink removeByNetworkLinkByChild(
		long d2biobanknetworkId, long d2linkId, java.lang.String d2linktype)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByNetworkLinkByChild(d2biobanknetworkId, d2linkId,
			d2linktype);
	}

	/**
	* Returns the number of d2 biobank network links where d2biobanknetworkId = &#63; and d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNetworkLinkByChild(long d2biobanknetworkId,
		long d2linkId, java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByNetworkLinkByChild(d2biobanknetworkId, d2linkId,
			d2linktype);
	}

	/**
	* Returns all the d2 biobank network links where d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @return the matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByNetworkLinksForChild(
		long d2linkId, java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNetworkLinksForChild(d2linkId, d2linktype);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByNetworkLinksForChild(
		long d2linkId, java.lang.String d2linktype, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkLinksForChild(d2linkId, d2linktype, start, end);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByNetworkLinksForChild(
		long d2linkId, java.lang.String d2linktype, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkLinksForChild(d2linkId, d2linktype, start,
			end, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByNetworkLinksForChild_First(
		long d2linkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkLinksForChild_First(d2linkId, d2linktype,
			orderByComparator);
	}

	/**
	* Returns the first d2 biobank network link in the ordered set where d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByNetworkLinksForChild_First(
		long d2linkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNetworkLinksForChild_First(d2linkId, d2linktype,
			orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByNetworkLinksForChild_Last(
		long d2linkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkLinksForChild_Last(d2linkId, d2linktype,
			orderByComparator);
	}

	/**
	* Returns the last d2 biobank network link in the ordered set where d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByNetworkLinksForChild_Last(
		long d2linkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNetworkLinksForChild_Last(d2linkId, d2linktype,
			orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink[] findByNetworkLinksForChild_PrevAndNext(
		long d2biobanknetworklinkId, long d2linkId,
		java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkLinksForChild_PrevAndNext(d2biobanknetworklinkId,
			d2linkId, d2linktype, orderByComparator);
	}

	/**
	* Removes all the d2 biobank network links where d2linkId = &#63; and d2linktype = &#63; from the database.
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNetworkLinksForChild(long d2linkId,
		java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNetworkLinksForChild(d2linkId, d2linktype);
	}

	/**
	* Returns the number of d2 biobank network links where d2linkId = &#63; and d2linktype = &#63;.
	*
	* @param d2linkId the d2link ID
	* @param d2linktype the d2linktype
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNetworkLinksForChild(long d2linkId,
		java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNetworkLinksForChild(d2linkId, d2linktype);
	}

	/**
	* Returns all the d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @return the matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByChildForNetworkLinks(
		long d2biobanknetworkId, java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChildForNetworkLinks(d2biobanknetworkId, d2linktype);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByChildForNetworkLinks(
		long d2biobanknetworkId, java.lang.String d2linktype, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChildForNetworkLinks(d2biobanknetworkId, d2linktype,
			start, end);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByChildForNetworkLinks(
		long d2biobanknetworkId, java.lang.String d2linktype, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChildForNetworkLinks(d2biobanknetworkId, d2linktype,
			start, end, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByChildForNetworkLinks_First(
		long d2biobanknetworkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChildForNetworkLinks_First(d2biobanknetworkId,
			d2linktype, orderByComparator);
	}

	/**
	* Returns the first d2 biobank network link in the ordered set where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByChildForNetworkLinks_First(
		long d2biobanknetworkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByChildForNetworkLinks_First(d2biobanknetworkId,
			d2linktype, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByChildForNetworkLinks_Last(
		long d2biobanknetworkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChildForNetworkLinks_Last(d2biobanknetworkId,
			d2linktype, orderByComparator);
	}

	/**
	* Returns the last d2 biobank network link in the ordered set where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByChildForNetworkLinks_Last(
		long d2biobanknetworkId, java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByChildForNetworkLinks_Last(d2biobanknetworkId,
			d2linktype, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink[] findByChildForNetworkLinks_PrevAndNext(
		long d2biobanknetworklinkId, long d2biobanknetworkId,
		java.lang.String d2linktype,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChildForNetworkLinks_PrevAndNext(d2biobanknetworklinkId,
			d2biobanknetworkId, d2linktype, orderByComparator);
	}

	/**
	* Removes all the d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63; from the database.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByChildForNetworkLinks(long d2biobanknetworkId,
		java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByChildForNetworkLinks(d2biobanknetworkId, d2linktype);
	}

	/**
	* Returns the number of d2 biobank network links where d2biobanknetworkId = &#63; and d2linktype = &#63;.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID
	* @param d2linktype the d2linktype
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChildForNetworkLinks(long d2biobanknetworkId,
		java.lang.String d2linktype)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByChildForNetworkLinks(d2biobanknetworkId, d2linktype);
	}

	/**
	* Returns all the d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @return the matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByNotUUID(
		long groupId, java.lang.String updateuuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotUUID(groupId, updateuuid);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByNotUUID(
		long groupId, java.lang.String updateuuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotUUID(groupId, updateuuid, start, end);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findByNotUUID(
		long groupId, java.lang.String updateuuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotUUID(groupId, updateuuid, start, end,
			orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByNotUUID_First(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotUUID_First(groupId, updateuuid, orderByComparator);
	}

	/**
	* Returns the first d2 biobank network link in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByNotUUID_First(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNotUUID_First(groupId, updateuuid, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByNotUUID_Last(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotUUID_Last(groupId, updateuuid, orderByComparator);
	}

	/**
	* Returns the last d2 biobank network link in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network link, or <code>null</code> if a matching d2 biobank network link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByNotUUID_Last(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNotUUID_Last(groupId, updateuuid, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink[] findByNotUUID_PrevAndNext(
		long d2biobanknetworklinkId, long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotUUID_PrevAndNext(d2biobanknetworklinkId, groupId,
			updateuuid, orderByComparator);
	}

	/**
	* Removes all the d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63; from the database.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNotUUID(long groupId, java.lang.String updateuuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNotUUID(groupId, updateuuid);
	}

	/**
	* Returns the number of d2 biobank network links where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @return the number of matching d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNotUUID(long groupId, java.lang.String updateuuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNotUUID(groupId, updateuuid);
	}

	/**
	* Caches the d2 biobank network link in the entity cache if it is enabled.
	*
	* @param d2BiobankNetworkLink the d2 biobank network link
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink d2BiobankNetworkLink) {
		getPersistence().cacheResult(d2BiobankNetworkLink);
	}

	/**
	* Caches the d2 biobank network links in the entity cache if it is enabled.
	*
	* @param d2BiobankNetworkLinks the d2 biobank network links
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> d2BiobankNetworkLinks) {
		getPersistence().cacheResult(d2BiobankNetworkLinks);
	}

	/**
	* Creates a new d2 biobank network link with the primary key. Does not add the d2 biobank network link to the database.
	*
	* @param d2biobanknetworklinkId the primary key for the new d2 biobank network link
	* @return the new d2 biobank network link
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink create(
		long d2biobanknetworklinkId) {
		return getPersistence().create(d2biobanknetworklinkId);
	}

	/**
	* Removes the d2 biobank network link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param d2biobanknetworklinkId the primary key of the d2 biobank network link
	* @return the d2 biobank network link that was removed
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink remove(
		long d2biobanknetworklinkId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(d2biobanknetworklinkId);
	}

	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink d2BiobankNetworkLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(d2BiobankNetworkLink);
	}

	/**
	* Returns the d2 biobank network link with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException} if it could not be found.
	*
	* @param d2biobanknetworklinkId the primary key of the d2 biobank network link
	* @return the d2 biobank network link
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException if a d2 biobank network link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink findByPrimaryKey(
		long d2biobanknetworklinkId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(d2biobanknetworklinkId);
	}

	/**
	* Returns the d2 biobank network link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param d2biobanknetworklinkId the primary key of the d2 biobank network link
	* @return the d2 biobank network link, or <code>null</code> if a d2 biobank network link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink fetchByPrimaryKey(
		long d2biobanknetworklinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(d2biobanknetworklinkId);
	}

	/**
	* Returns all the d2 biobank network links.
	*
	* @return the d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the d2 biobank network links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of d2 biobank network links.
	*
	* @return the number of d2 biobank network links
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static D2BiobankNetworkLinkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (D2BiobankNetworkLinkPersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.bbmrieric.service.ClpSerializer.getServletContextName(),
					D2BiobankNetworkLinkPersistence.class.getName());

			ReferenceRegistry.registerReference(D2BiobankNetworkLinkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(D2BiobankNetworkLinkPersistence persistence) {
	}

	private static D2BiobankNetworkLinkPersistence _persistence;
}