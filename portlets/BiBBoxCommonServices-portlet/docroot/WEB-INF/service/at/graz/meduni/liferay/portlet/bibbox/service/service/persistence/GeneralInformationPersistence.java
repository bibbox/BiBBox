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

import at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the general information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see GeneralInformationPersistenceImpl
 * @see GeneralInformationUtil
 * @generated
 */
public interface GeneralInformationPersistence extends BasePersistence<GeneralInformation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GeneralInformationUtil} to access the general information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the general information where organizationId = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException} if it could not be found.
	*
	* @param organizationId the organization ID
	* @return the matching general information
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException if a matching general information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation findByOrganizationFinder(
		long organizationId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the general information where organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param organizationId the organization ID
	* @return the matching general information, or <code>null</code> if a matching general information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation fetchByOrganizationFinder(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the general information where organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching general information, or <code>null</code> if a matching general information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation fetchByOrganizationFinder(
		long organizationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the general information where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @return the general information that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation removeByOrganizationFinder(
		long organizationId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of general informations where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching general informations
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganizationFinder(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the general information in the entity cache if it is enabled.
	*
	* @param generalInformation the general information
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation generalInformation);

	/**
	* Caches the general informations in the entity cache if it is enabled.
	*
	* @param generalInformations the general informations
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation> generalInformations);

	/**
	* Creates a new general information with the primary key. Does not add the general information to the database.
	*
	* @param generalinformationId the primary key for the new general information
	* @return the new general information
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation create(
		long generalinformationId);

	/**
	* Removes the general information with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param generalinformationId the primary key of the general information
	* @return the general information that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException if a general information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation remove(
		long generalinformationId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation generalInformation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the general information with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException} if it could not be found.
	*
	* @param generalinformationId the primary key of the general information
	* @return the general information
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException if a general information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation findByPrimaryKey(
		long generalinformationId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the general information with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param generalinformationId the primary key of the general information
	* @return the general information, or <code>null</code> if a general information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation fetchByPrimaryKey(
		long generalinformationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the general informations.
	*
	* @return the general informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the general informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.GeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of general informations
	* @param end the upper bound of the range of general informations (not inclusive)
	* @return the range of general informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the general informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.GeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of general informations
	* @param end the upper bound of the range of general informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of general informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the general informations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of general informations.
	*
	* @return the number of general informations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}