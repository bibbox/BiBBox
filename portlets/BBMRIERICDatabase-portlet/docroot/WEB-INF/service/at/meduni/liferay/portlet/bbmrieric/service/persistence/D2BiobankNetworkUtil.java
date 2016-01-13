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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the d2 biobank network service. This utility wraps {@link D2BiobankNetworkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see D2BiobankNetworkPersistence
 * @see D2BiobankNetworkPersistenceImpl
 * @generated
 */
public class D2BiobankNetworkUtil {
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
	public static void clearCache(D2BiobankNetwork d2BiobankNetwork) {
		getPersistence().clearCache(d2BiobankNetwork);
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
	public static List<D2BiobankNetwork> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<D2BiobankNetwork> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<D2BiobankNetwork> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static D2BiobankNetwork update(D2BiobankNetwork d2BiobankNetwork)
		throws SystemException {
		return getPersistence().update(d2BiobankNetwork);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static D2BiobankNetwork update(D2BiobankNetwork d2BiobankNetwork,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(d2BiobankNetwork, serviceContext);
	}

	/**
	* Returns all the d2 biobank networks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first d2 biobank network in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first d2 biobank network in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last d2 biobank network in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last d2 biobank network in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork[] findByUuid_PrevAndNext(
		long d2biobanknetworkId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(d2biobanknetworkId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the d2 biobank networks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of d2 biobank networks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the d2 biobank network where uuid = &#63; and groupId = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByUUID_G(
		java.lang.String uuid, long groupId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the d2 biobank network where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the d2 biobank network where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the d2 biobank network where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the d2 biobank network that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of d2 biobank networks where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the d2 biobank networks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first d2 biobank network in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last d2 biobank network in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork[] findByUuid_C_PrevAndNext(
		long d2biobanknetworkId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(d2biobanknetworkId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the d2 biobank networks where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of d2 biobank networks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @return the matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByNotUUID(
		long groupId, java.lang.String updateuuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotUUID(groupId, updateuuid);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByNotUUID(
		long groupId, java.lang.String updateuuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotUUID(groupId, updateuuid, start, end);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findByNotUUID(
		long groupId, java.lang.String updateuuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotUUID(groupId, updateuuid, start, end,
			orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByNotUUID_First(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotUUID_First(groupId, updateuuid, orderByComparator);
	}

	/**
	* Returns the first d2 biobank network in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByNotUUID_First(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNotUUID_First(groupId, updateuuid, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByNotUUID_Last(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotUUID_Last(groupId, updateuuid, orderByComparator);
	}

	/**
	* Returns the last d2 biobank network in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByNotUUID_Last(
		long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNotUUID_Last(groupId, updateuuid, orderByComparator);
	}

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
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork[] findByNotUUID_PrevAndNext(
		long d2biobanknetworkId, long groupId, java.lang.String updateuuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotUUID_PrevAndNext(d2biobanknetworkId, groupId,
			updateuuid, orderByComparator);
	}

	/**
	* Removes all the d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63; from the database.
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
	* Returns the number of d2 biobank networks where groupId = &#63; and updateuuid &ne; &#63;.
	*
	* @param groupId the group ID
	* @param updateuuid the updateuuid
	* @return the number of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNotUUID(long groupId, java.lang.String updateuuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNotUUID(groupId, updateuuid);
	}

	/**
	* Returns the d2 biobank network where groupId = &#63; and bbmriBiobankNetworkID = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException} if it could not be found.
	*
	* @param groupId the group ID
	* @param bbmriBiobankNetworkID the bbmri biobank network i d
	* @return the matching d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByBiobankNetworkBBMRIERICID(
		long groupId, java.lang.String bbmriBiobankNetworkID)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBiobankNetworkBBMRIERICID(groupId,
			bbmriBiobankNetworkID);
	}

	/**
	* Returns the d2 biobank network where groupId = &#63; and bbmriBiobankNetworkID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param bbmriBiobankNetworkID the bbmri biobank network i d
	* @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByBiobankNetworkBBMRIERICID(
		long groupId, java.lang.String bbmriBiobankNetworkID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBiobankNetworkBBMRIERICID(groupId,
			bbmriBiobankNetworkID);
	}

	/**
	* Returns the d2 biobank network where groupId = &#63; and bbmriBiobankNetworkID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param bbmriBiobankNetworkID the bbmri biobank network i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByBiobankNetworkBBMRIERICID(
		long groupId, java.lang.String bbmriBiobankNetworkID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBiobankNetworkBBMRIERICID(groupId,
			bbmriBiobankNetworkID, retrieveFromCache);
	}

	/**
	* Removes the d2 biobank network where groupId = &#63; and bbmriBiobankNetworkID = &#63; from the database.
	*
	* @param groupId the group ID
	* @param bbmriBiobankNetworkID the bbmri biobank network i d
	* @return the d2 biobank network that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork removeByBiobankNetworkBBMRIERICID(
		long groupId, java.lang.String bbmriBiobankNetworkID)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByBiobankNetworkBBMRIERICID(groupId,
			bbmriBiobankNetworkID);
	}

	/**
	* Returns the number of d2 biobank networks where groupId = &#63; and bbmriBiobankNetworkID = &#63;.
	*
	* @param groupId the group ID
	* @param bbmriBiobankNetworkID the bbmri biobank network i d
	* @return the number of matching d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBiobankNetworkBBMRIERICID(long groupId,
		java.lang.String bbmriBiobankNetworkID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByBiobankNetworkBBMRIERICID(groupId,
			bbmriBiobankNetworkID);
	}

	/**
	* Caches the d2 biobank network in the entity cache if it is enabled.
	*
	* @param d2BiobankNetwork the d2 biobank network
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork d2BiobankNetwork) {
		getPersistence().cacheResult(d2BiobankNetwork);
	}

	/**
	* Caches the d2 biobank networks in the entity cache if it is enabled.
	*
	* @param d2BiobankNetworks the d2 biobank networks
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> d2BiobankNetworks) {
		getPersistence().cacheResult(d2BiobankNetworks);
	}

	/**
	* Creates a new d2 biobank network with the primary key. Does not add the d2 biobank network to the database.
	*
	* @param d2biobanknetworkId the primary key for the new d2 biobank network
	* @return the new d2 biobank network
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork create(
		long d2biobanknetworkId) {
		return getPersistence().create(d2biobanknetworkId);
	}

	/**
	* Removes the d2 biobank network with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param d2biobanknetworkId the primary key of the d2 biobank network
	* @return the d2 biobank network that was removed
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork remove(
		long d2biobanknetworkId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(d2biobanknetworkId);
	}

	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork d2BiobankNetwork)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(d2BiobankNetwork);
	}

	/**
	* Returns the d2 biobank network with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException} if it could not be found.
	*
	* @param d2biobanknetworkId the primary key of the d2 biobank network
	* @return the d2 biobank network
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException if a d2 biobank network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork findByPrimaryKey(
		long d2biobanknetworkId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchD2BiobankNetworkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(d2biobanknetworkId);
	}

	/**
	* Returns the d2 biobank network with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param d2biobanknetworkId the primary key of the d2 biobank network
	* @return the d2 biobank network, or <code>null</code> if a d2 biobank network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchByPrimaryKey(
		long d2biobanknetworkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(d2biobanknetworkId);
	}

	/**
	* Returns all the d2 biobank networks.
	*
	* @return the d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the d2 biobank networks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of d2 biobank networks.
	*
	* @return the number of d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static D2BiobankNetworkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (D2BiobankNetworkPersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.bbmrieric.service.ClpSerializer.getServletContextName(),
					D2BiobankNetworkPersistence.class.getName());

			ReferenceRegistry.registerReference(D2BiobankNetworkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(D2BiobankNetworkPersistence persistence) {
	}

	private static D2BiobankNetworkPersistence _persistence;
}