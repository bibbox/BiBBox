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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the networks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see NetworksPersistenceImpl
 * @see NetworksUtil
 * @generated
 */
public interface NetworksPersistence extends BasePersistence<Networks> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NetworksUtil} to access the networks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the networks in the entity cache if it is enabled.
	*
	* @param networks the networks
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Networks networks);

	/**
	* Caches the networkses in the entity cache if it is enabled.
	*
	* @param networkses the networkses
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> networkses);

	/**
	* Creates a new networks with the primary key. Does not add the networks to the database.
	*
	* @param networkId the primary key for the new networks
	* @return the new networks
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks create(
		long networkId);

	/**
	* Removes the networks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param networkId the primary key of the networks
	* @return the networks that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException if a networks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks remove(
		long networkId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Networks networks)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the networks with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException} if it could not be found.
	*
	* @param networkId the primary key of the networks
	* @return the networks
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException if a networks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks findByPrimaryKey(
		long networkId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the networks with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param networkId the primary key of the networks
	* @return the networks, or <code>null</code> if a networks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks fetchByPrimaryKey(
		long networkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the networkses.
	*
	* @return the networkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the networkses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of networkses.
	*
	* @return the number of networkses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}