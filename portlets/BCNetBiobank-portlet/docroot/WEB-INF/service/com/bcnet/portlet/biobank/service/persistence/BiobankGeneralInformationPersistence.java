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

package com.bcnet.portlet.biobank.service.persistence;

import com.bcnet.portlet.biobank.model.BiobankGeneralInformation;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the biobank general information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankGeneralInformationPersistenceImpl
 * @see BiobankGeneralInformationUtil
 * @generated
 */
public interface BiobankGeneralInformationPersistence extends BasePersistence<BiobankGeneralInformation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BiobankGeneralInformationUtil} to access the biobank general information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the biobank general information in the entity cache if it is enabled.
	*
	* @param biobankGeneralInformation the biobank general information
	*/
	public void cacheResult(
		com.bcnet.portlet.biobank.model.BiobankGeneralInformation biobankGeneralInformation);

	/**
	* Caches the biobank general informations in the entity cache if it is enabled.
	*
	* @param biobankGeneralInformations the biobank general informations
	*/
	public void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> biobankGeneralInformations);

	/**
	* Creates a new biobank general information with the primary key. Does not add the biobank general information to the database.
	*
	* @param biobankDbId the primary key for the new biobank general information
	* @return the new biobank general information
	*/
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation create(
		long biobankDbId);

	/**
	* Removes the biobank general information with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankDbId the primary key of the biobank general information
	* @return the biobank general information that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException if a biobank general information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation remove(
		long biobankDbId)
		throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation updateImpl(
		com.bcnet.portlet.biobank.model.BiobankGeneralInformation biobankGeneralInformation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the biobank general information with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException} if it could not be found.
	*
	* @param biobankDbId the primary key of the biobank general information
	* @return the biobank general information
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException if a biobank general information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation findByPrimaryKey(
		long biobankDbId)
		throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the biobank general information with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param biobankDbId the primary key of the biobank general information
	* @return the biobank general information, or <code>null</code> if a biobank general information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation fetchByPrimaryKey(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the biobank general informations.
	*
	* @return the biobank general informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the biobank general informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank general informations
	* @param end the upper bound of the range of biobank general informations (not inclusive)
	* @return the range of biobank general informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the biobank general informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank general informations
	* @param end the upper bound of the range of biobank general informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of biobank general informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the biobank general informations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of biobank general informations.
	*
	* @return the number of biobank general informations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}