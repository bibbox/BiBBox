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

package com.bcnet.portlet.biobank.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CountryLocalService}.
 *
 * @author suyama
 * @see CountryLocalService
 * @generated
 */
public class CountryLocalServiceWrapper implements CountryLocalService,
	ServiceWrapper<CountryLocalService> {
	public CountryLocalServiceWrapper(CountryLocalService countryLocalService) {
		_countryLocalService = countryLocalService;
	}

	/**
	* Adds the country to the database. Also notifies the appropriate model listeners.
	*
	* @param country the country
	* @return the country that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.Country addCountry(
		com.bcnet.portlet.biobank.model.Country country)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.addCountry(country);
	}

	/**
	* Creates a new country with the primary key. Does not add the country to the database.
	*
	* @param countryCode the primary key for the new country
	* @return the new country
	*/
	@Override
	public com.bcnet.portlet.biobank.model.Country createCountry(
		java.lang.String countryCode) {
		return _countryLocalService.createCountry(countryCode);
	}

	/**
	* Deletes the country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param countryCode the primary key of the country
	* @return the country that was removed
	* @throws PortalException if a country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.Country deleteCountry(
		java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.deleteCountry(countryCode);
	}

	/**
	* Deletes the country from the database. Also notifies the appropriate model listeners.
	*
	* @param country the country
	* @return the country that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.Country deleteCountry(
		com.bcnet.portlet.biobank.model.Country country)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.deleteCountry(country);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _countryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.CountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.CountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.bcnet.portlet.biobank.model.Country fetchCountry(
		java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.fetchCountry(countryCode);
	}

	/**
	* Returns the country with the primary key.
	*
	* @param countryCode the primary key of the country
	* @return the country
	* @throws PortalException if a country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.Country getCountry(
		java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.getCountry(countryCode);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.Country> getCountries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.getCountries(start, end);
	}

	/**
	* Returns the number of countries.
	*
	* @return the number of countries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCountriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.getCountriesCount();
	}

	/**
	* Updates the country in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param country the country
	* @return the country that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.Country updateCountry(
		com.bcnet.portlet.biobank.model.Country country)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.updateCountry(country);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _countryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_countryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _countryLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.Country> getAllCountries()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryLocalService.getAllCountries();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CountryLocalService getWrappedCountryLocalService() {
		return _countryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCountryLocalService(
		CountryLocalService countryLocalService) {
		_countryLocalService = countryLocalService;
	}

	@Override
	public CountryLocalService getWrappedService() {
		return _countryLocalService;
	}

	@Override
	public void setWrappedService(CountryLocalService countryLocalService) {
		_countryLocalService = countryLocalService;
	}

	private CountryLocalService _countryLocalService;
}