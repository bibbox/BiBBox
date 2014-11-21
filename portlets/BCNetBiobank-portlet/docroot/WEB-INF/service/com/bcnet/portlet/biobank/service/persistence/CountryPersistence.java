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

import com.bcnet.portlet.biobank.model.Country;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see CountryPersistenceImpl
 * @see CountryUtil
 * @generated
 */
public interface CountryPersistence extends BasePersistence<Country> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CountryUtil} to access the country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the country in the entity cache if it is enabled.
	*
	* @param country the country
	*/
	public void cacheResult(com.bcnet.portlet.biobank.model.Country country);

	/**
	* Caches the countries in the entity cache if it is enabled.
	*
	* @param countries the countries
	*/
	public void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.Country> countries);

	/**
	* Creates a new country with the primary key. Does not add the country to the database.
	*
	* @param countryCode the primary key for the new country
	* @return the new country
	*/
	public com.bcnet.portlet.biobank.model.Country create(
		java.lang.String countryCode);

	/**
	* Removes the country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param countryCode the primary key of the country
	* @return the country that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchCountryException if a country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Country remove(
		java.lang.String countryCode)
		throws com.bcnet.portlet.biobank.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bcnet.portlet.biobank.model.Country updateImpl(
		com.bcnet.portlet.biobank.model.Country country)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the country with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchCountryException} if it could not be found.
	*
	* @param countryCode the primary key of the country
	* @return the country
	* @throws com.bcnet.portlet.biobank.NoSuchCountryException if a country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Country findByPrimaryKey(
		java.lang.String countryCode)
		throws com.bcnet.portlet.biobank.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the country with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param countryCode the primary key of the country
	* @return the country, or <code>null</code> if a country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Country fetchByPrimaryKey(
		java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the countries.
	*
	* @return the countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.Country> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.CountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of countries
	* @param end the upper bound of the range of countries (not inclusive)
	* @return the range of countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.Country> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.CountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of countries
	* @param end the upper bound of the range of countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.Country> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the countries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of countries.
	*
	* @return the number of countries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}