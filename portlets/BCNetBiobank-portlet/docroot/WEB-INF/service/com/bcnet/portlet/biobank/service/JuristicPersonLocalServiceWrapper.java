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
 * Provides a wrapper for {@link JuristicPersonLocalService}.
 *
 * @author suyama
 * @see JuristicPersonLocalService
 * @generated
 */
public class JuristicPersonLocalServiceWrapper
	implements JuristicPersonLocalService,
		ServiceWrapper<JuristicPersonLocalService> {
	public JuristicPersonLocalServiceWrapper(
		JuristicPersonLocalService juristicPersonLocalService) {
		_juristicPersonLocalService = juristicPersonLocalService;
	}

	/**
	* Adds the juristic person to the database. Also notifies the appropriate model listeners.
	*
	* @param juristicPerson the juristic person
	* @return the juristic person that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson addJuristicPerson(
		com.bcnet.portlet.biobank.model.JuristicPerson juristicPerson)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.addJuristicPerson(juristicPerson);
	}

	/**
	* Creates a new juristic person with the primary key. Does not add the juristic person to the database.
	*
	* @param juristicPersonId the primary key for the new juristic person
	* @return the new juristic person
	*/
	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson createJuristicPerson(
		long juristicPersonId) {
		return _juristicPersonLocalService.createJuristicPerson(juristicPersonId);
	}

	/**
	* Deletes the juristic person with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param juristicPersonId the primary key of the juristic person
	* @return the juristic person that was removed
	* @throws PortalException if a juristic person with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson deleteJuristicPerson(
		long juristicPersonId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.deleteJuristicPerson(juristicPersonId);
	}

	/**
	* Deletes the juristic person from the database. Also notifies the appropriate model listeners.
	*
	* @param juristicPerson the juristic person
	* @return the juristic person that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson deleteJuristicPerson(
		com.bcnet.portlet.biobank.model.JuristicPerson juristicPerson)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.deleteJuristicPerson(juristicPerson);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _juristicPersonLocalService.dynamicQuery();
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
		return _juristicPersonLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.JuristicPersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _juristicPersonLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.JuristicPersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _juristicPersonLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _juristicPersonLocalService.dynamicQueryCount(dynamicQuery);
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
		return _juristicPersonLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson fetchJuristicPerson(
		long juristicPersonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.fetchJuristicPerson(juristicPersonId);
	}

	/**
	* Returns the juristic person with the primary key.
	*
	* @param juristicPersonId the primary key of the juristic person
	* @return the juristic person
	* @throws PortalException if a juristic person with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws com.bcnet.portlet.biobank.NoSuchJuristicPersonException
	*/
	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson getJuristicPerson(
		long juristicPersonId)
		throws com.bcnet.portlet.biobank.NoSuchJuristicPersonException,
			com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.getJuristicPerson(juristicPersonId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the juristic persons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.JuristicPersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of juristic persons
	* @param end the upper bound of the range of juristic persons (not inclusive)
	* @return the range of juristic persons
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.JuristicPerson> getJuristicPersons(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.getJuristicPersons(start, end);
	}

	/**
	* Returns the number of juristic persons.
	*
	* @return the number of juristic persons
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJuristicPersonsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.getJuristicPersonsCount();
	}

	/**
	* Updates the juristic person in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param juristicPerson the juristic person
	* @return the juristic person that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson updateJuristicPerson(
		com.bcnet.portlet.biobank.model.JuristicPerson juristicPerson)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.updateJuristicPerson(juristicPerson);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _juristicPersonLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_juristicPersonLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _juristicPersonLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson addJusristicPerson(
		java.lang.String name, java.lang.String url, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.addJusristicPerson(name, url, address);
	}

	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson updateJuristicPerson(
		long juristicPersonId, java.lang.String name, java.lang.String url,
		java.lang.String address)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.updateJuristicPerson(juristicPersonId,
			name, url, address);
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.JuristicPerson> getAllJuristicPersons()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.getAllJuristicPersons();
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.JuristicPerson> getAllJuristicPersons(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _juristicPersonLocalService.getAllJuristicPersons(start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public JuristicPersonLocalService getWrappedJuristicPersonLocalService() {
		return _juristicPersonLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedJuristicPersonLocalService(
		JuristicPersonLocalService juristicPersonLocalService) {
		_juristicPersonLocalService = juristicPersonLocalService;
	}

	@Override
	public JuristicPersonLocalService getWrappedService() {
		return _juristicPersonLocalService;
	}

	@Override
	public void setWrappedService(
		JuristicPersonLocalService juristicPersonLocalService) {
		_juristicPersonLocalService = juristicPersonLocalService;
	}

	private JuristicPersonLocalService _juristicPersonLocalService;
}