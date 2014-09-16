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

package at.graz.meduni.liferay.portlet.bbmriat.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrganizationlinkLocalService}.
 *
 * @author Reihs Robert
 * @see OrganizationlinkLocalService
 * @generated
 */
public class OrganizationlinkLocalServiceWrapper
	implements OrganizationlinkLocalService,
		ServiceWrapper<OrganizationlinkLocalService> {
	public OrganizationlinkLocalServiceWrapper(
		OrganizationlinkLocalService organizationlinkLocalService) {
		_organizationlinkLocalService = organizationlinkLocalService;
	}

	/**
	* Adds the organizationlink to the database. Also notifies the appropriate model listeners.
	*
	* @param organizationlink the organizationlink
	* @return the organizationlink that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink addOrganizationlink(
		at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink organizationlink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationlinkLocalService.addOrganizationlink(organizationlink);
	}

	/**
	* Creates a new organizationlink with the primary key. Does not add the organizationlink to the database.
	*
	* @param organizationlinkId the primary key for the new organizationlink
	* @return the new organizationlink
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink createOrganizationlink(
		long organizationlinkId) {
		return _organizationlinkLocalService.createOrganizationlink(organizationlinkId);
	}

	/**
	* Deletes the organizationlink with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param organizationlinkId the primary key of the organizationlink
	* @return the organizationlink that was removed
	* @throws PortalException if a organizationlink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink deleteOrganizationlink(
		long organizationlinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationlinkLocalService.deleteOrganizationlink(organizationlinkId);
	}

	/**
	* Deletes the organizationlink from the database. Also notifies the appropriate model listeners.
	*
	* @param organizationlink the organizationlink
	* @return the organizationlink that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink deleteOrganizationlink(
		at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink organizationlink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationlinkLocalService.deleteOrganizationlink(organizationlink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizationlinkLocalService.dynamicQuery();
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
		return _organizationlinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organizationlinkLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organizationlinkLocalService.dynamicQuery(dynamicQuery, start,
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
		return _organizationlinkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _organizationlinkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink fetchOrganizationlink(
		long organizationlinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationlinkLocalService.fetchOrganizationlink(organizationlinkId);
	}

	/**
	* Returns the organizationlink with the primary key.
	*
	* @param organizationlinkId the primary key of the organizationlink
	* @return the organizationlink
	* @throws PortalException if a organizationlink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink getOrganizationlink(
		long organizationlinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationlinkLocalService.getOrganizationlink(organizationlinkId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationlinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the organizationlinks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organizationlinks
	* @param end the upper bound of the range of organizationlinks (not inclusive)
	* @return the range of organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink> getOrganizationlinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationlinkLocalService.getOrganizationlinks(start, end);
	}

	/**
	* Returns the number of organizationlinks.
	*
	* @return the number of organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOrganizationlinksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationlinkLocalService.getOrganizationlinksCount();
	}

	/**
	* Updates the organizationlink in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param organizationlink the organizationlink
	* @return the organizationlink that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink updateOrganizationlink(
		at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink organizationlink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationlinkLocalService.updateOrganizationlink(organizationlink);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _organizationlinkLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_organizationlinkLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _organizationlinkLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrganizationlinkLocalService getWrappedOrganizationlinkLocalService() {
		return _organizationlinkLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrganizationlinkLocalService(
		OrganizationlinkLocalService organizationlinkLocalService) {
		_organizationlinkLocalService = organizationlinkLocalService;
	}

	@Override
	public OrganizationlinkLocalService getWrappedService() {
		return _organizationlinkLocalService;
	}

	@Override
	public void setWrappedService(
		OrganizationlinkLocalService organizationlinkLocalService) {
		_organizationlinkLocalService = organizationlinkLocalService;
	}

	private OrganizationlinkLocalService _organizationlinkLocalService;
}