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

import at.graz.meduni.liferay.portlet.bibbox.service.model.Networks;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the networks service. This utility wraps {@link NetworksPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see NetworksPersistence
 * @see NetworksPersistenceImpl
 * @generated
 */
public class NetworksUtil {
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
	public static void clearCache(Networks networks) {
		getPersistence().clearCache(networks);
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
	public static List<Networks> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Networks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Networks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Networks update(Networks networks) throws SystemException {
		return getPersistence().update(networks);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Networks update(Networks networks,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(networks, serviceContext);
	}

	/**
	* Returns all the networkses where organizationnetworkId = &#63;.
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @return the matching networkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> findByNetworkOrganizationsFinder(
		long organizationnetworkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkOrganizationsFinder(organizationnetworkId);
	}

	/**
	* Returns a range of all the networkses where organizationnetworkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.NetworksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @param start the lower bound of the range of networkses
	* @param end the upper bound of the range of networkses (not inclusive)
	* @return the range of matching networkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> findByNetworkOrganizationsFinder(
		long organizationnetworkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkOrganizationsFinder(organizationnetworkId,
			start, end);
	}

	/**
	* Returns an ordered range of all the networkses where organizationnetworkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.NetworksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @param start the lower bound of the range of networkses
	* @param end the upper bound of the range of networkses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching networkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> findByNetworkOrganizationsFinder(
		long organizationnetworkId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkOrganizationsFinder(organizationnetworkId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first networks in the ordered set where organizationnetworkId = &#63;.
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching networks
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException if a matching networks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks findByNetworkOrganizationsFinder_First(
		long organizationnetworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkOrganizationsFinder_First(organizationnetworkId,
			orderByComparator);
	}

	/**
	* Returns the first networks in the ordered set where organizationnetworkId = &#63;.
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching networks, or <code>null</code> if a matching networks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks fetchByNetworkOrganizationsFinder_First(
		long organizationnetworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNetworkOrganizationsFinder_First(organizationnetworkId,
			orderByComparator);
	}

	/**
	* Returns the last networks in the ordered set where organizationnetworkId = &#63;.
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching networks
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException if a matching networks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks findByNetworkOrganizationsFinder_Last(
		long organizationnetworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkOrganizationsFinder_Last(organizationnetworkId,
			orderByComparator);
	}

	/**
	* Returns the last networks in the ordered set where organizationnetworkId = &#63;.
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching networks, or <code>null</code> if a matching networks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks fetchByNetworkOrganizationsFinder_Last(
		long organizationnetworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNetworkOrganizationsFinder_Last(organizationnetworkId,
			orderByComparator);
	}

	/**
	* Returns the networkses before and after the current networks in the ordered set where organizationnetworkId = &#63;.
	*
	* @param networkId the primary key of the current networks
	* @param organizationnetworkId the organizationnetwork ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next networks
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException if a networks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks[] findByNetworkOrganizationsFinder_PrevAndNext(
		long networkId, long organizationnetworkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkOrganizationsFinder_PrevAndNext(networkId,
			organizationnetworkId, orderByComparator);
	}

	/**
	* Removes all the networkses where organizationnetworkId = &#63; from the database.
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNetworkOrganizationsFinder(
		long organizationnetworkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByNetworkOrganizationsFinder(organizationnetworkId);
	}

	/**
	* Returns the number of networkses where organizationnetworkId = &#63;.
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @return the number of matching networkses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNetworkOrganizationsFinder(
		long organizationnetworkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByNetworkOrganizationsFinder(organizationnetworkId);
	}

	/**
	* Returns the networks where organizationnetworkId = &#63; and organizationId = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException} if it could not be found.
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @param organizationId the organization ID
	* @return the matching networks
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException if a matching networks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks findByNetworkOrganizationFinder(
		long organizationnetworkId, long organizationId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNetworkOrganizationFinder(organizationnetworkId,
			organizationId);
	}

	/**
	* Returns the networks where organizationnetworkId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @param organizationId the organization ID
	* @return the matching networks, or <code>null</code> if a matching networks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks fetchByNetworkOrganizationFinder(
		long organizationnetworkId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNetworkOrganizationFinder(organizationnetworkId,
			organizationId);
	}

	/**
	* Returns the networks where organizationnetworkId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching networks, or <code>null</code> if a matching networks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks fetchByNetworkOrganizationFinder(
		long organizationnetworkId, long organizationId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNetworkOrganizationFinder(organizationnetworkId,
			organizationId, retrieveFromCache);
	}

	/**
	* Removes the networks where organizationnetworkId = &#63; and organizationId = &#63; from the database.
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @param organizationId the organization ID
	* @return the networks that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks removeByNetworkOrganizationFinder(
		long organizationnetworkId, long organizationId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByNetworkOrganizationFinder(organizationnetworkId,
			organizationId);
	}

	/**
	* Returns the number of networkses where organizationnetworkId = &#63; and organizationId = &#63;.
	*
	* @param organizationnetworkId the organizationnetwork ID
	* @param organizationId the organization ID
	* @return the number of matching networkses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNetworkOrganizationFinder(
		long organizationnetworkId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByNetworkOrganizationFinder(organizationnetworkId,
			organizationId);
	}

	/**
	* Caches the networks in the entity cache if it is enabled.
	*
	* @param networks the networks
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Networks networks) {
		getPersistence().cacheResult(networks);
	}

	/**
	* Caches the networkses in the entity cache if it is enabled.
	*
	* @param networkses the networkses
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> networkses) {
		getPersistence().cacheResult(networkses);
	}

	/**
	* Creates a new networks with the primary key. Does not add the networks to the database.
	*
	* @param networkId the primary key for the new networks
	* @return the new networks
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks create(
		long networkId) {
		return getPersistence().create(networkId);
	}

	/**
	* Removes the networks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param networkId the primary key of the networks
	* @return the networks that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException if a networks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks remove(
		long networkId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(networkId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Networks networks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(networks);
	}

	/**
	* Returns the networks with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException} if it could not be found.
	*
	* @param networkId the primary key of the networks
	* @return the networks
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException if a networks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks findByPrimaryKey(
		long networkId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(networkId);
	}

	/**
	* Returns the networks with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param networkId the primary key of the networks
	* @return the networks, or <code>null</code> if a networks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Networks fetchByPrimaryKey(
		long networkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(networkId);
	}

	/**
	* Returns all the networkses.
	*
	* @return the networkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the networkses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.NetworksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of networkses
	* @param end the upper bound of the range of networkses (not inclusive)
	* @return the range of networkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the networkses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.NetworksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of networkses
	* @param end the upper bound of the range of networkses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of networkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the networkses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of networkses.
	*
	* @return the number of networkses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NetworksPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NetworksPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer.getServletContextName(),
					NetworksPersistence.class.getName());

			ReferenceRegistry.registerReference(NetworksUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(NetworksPersistence persistence) {
	}

	private static NetworksPersistence _persistence;
}