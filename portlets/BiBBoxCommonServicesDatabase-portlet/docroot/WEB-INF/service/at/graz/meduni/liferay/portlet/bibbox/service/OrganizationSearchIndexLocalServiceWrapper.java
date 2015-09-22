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

package at.graz.meduni.liferay.portlet.bibbox.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrganizationSearchIndexLocalService}.
 *
 * @author reihsr
 * @see OrganizationSearchIndexLocalService
 * @generated
 */
public class OrganizationSearchIndexLocalServiceWrapper
	implements OrganizationSearchIndexLocalService,
		ServiceWrapper<OrganizationSearchIndexLocalService> {
	public OrganizationSearchIndexLocalServiceWrapper(
		OrganizationSearchIndexLocalService organizationSearchIndexLocalService) {
		_organizationSearchIndexLocalService = organizationSearchIndexLocalService;
	}

	/**
	* Adds the organization search index to the database. Also notifies the appropriate model listeners.
	*
	* @param organizationSearchIndex the organization search index
	* @return the organization search index that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex addOrganizationSearchIndex(
		at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex organizationSearchIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationSearchIndexLocalService.addOrganizationSearchIndex(organizationSearchIndex);
	}

	/**
	* Creates a new organization search index with the primary key. Does not add the organization search index to the database.
	*
	* @param searchid the primary key for the new organization search index
	* @return the new organization search index
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex createOrganizationSearchIndex(
		long searchid) {
		return _organizationSearchIndexLocalService.createOrganizationSearchIndex(searchid);
	}

	/**
	* Deletes the organization search index with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchid the primary key of the organization search index
	* @return the organization search index that was removed
	* @throws PortalException if a organization search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex deleteOrganizationSearchIndex(
		long searchid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationSearchIndexLocalService.deleteOrganizationSearchIndex(searchid);
	}

	/**
	* Deletes the organization search index from the database. Also notifies the appropriate model listeners.
	*
	* @param organizationSearchIndex the organization search index
	* @return the organization search index that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex deleteOrganizationSearchIndex(
		at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex organizationSearchIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationSearchIndexLocalService.deleteOrganizationSearchIndex(organizationSearchIndex);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizationSearchIndexLocalService.dynamicQuery();
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
		return _organizationSearchIndexLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organizationSearchIndexLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organizationSearchIndexLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _organizationSearchIndexLocalService.dynamicQueryCount(dynamicQuery);
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
		return _organizationSearchIndexLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex fetchOrganizationSearchIndex(
		long searchid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationSearchIndexLocalService.fetchOrganizationSearchIndex(searchid);
	}

	/**
	* Returns the organization search index with the primary key.
	*
	* @param searchid the primary key of the organization search index
	* @return the organization search index
	* @throws PortalException if a organization search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex getOrganizationSearchIndex(
		long searchid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationSearchIndexLocalService.getOrganizationSearchIndex(searchid);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizationSearchIndexLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the organization search indexs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organization search indexs
	* @param end the upper bound of the range of organization search indexs (not inclusive)
	* @return the range of organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> getOrganizationSearchIndexs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationSearchIndexLocalService.getOrganizationSearchIndexs(start,
			end);
	}

	/**
	* Returns the number of organization search indexs.
	*
	* @return the number of organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOrganizationSearchIndexsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationSearchIndexLocalService.getOrganizationSearchIndexsCount();
	}

	/**
	* Updates the organization search index in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param organizationSearchIndex the organization search index
	* @return the organization search index that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex updateOrganizationSearchIndex(
		at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex organizationSearchIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizationSearchIndexLocalService.updateOrganizationSearchIndex(organizationSearchIndex);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _organizationSearchIndexLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_organizationSearchIndexLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _organizationSearchIndexLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.lang.String getSearchIndexValueByKey(java.lang.String keyword,
		long organizationId) {
		return _organizationSearchIndexLocalService.getSearchIndexValueByKey(keyword,
			organizationId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrganizationSearchIndexLocalService getWrappedOrganizationSearchIndexLocalService() {
		return _organizationSearchIndexLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrganizationSearchIndexLocalService(
		OrganizationSearchIndexLocalService organizationSearchIndexLocalService) {
		_organizationSearchIndexLocalService = organizationSearchIndexLocalService;
	}

	@Override
	public OrganizationSearchIndexLocalService getWrappedService() {
		return _organizationSearchIndexLocalService;
	}

	@Override
	public void setWrappedService(
		OrganizationSearchIndexLocalService organizationSearchIndexLocalService) {
		_organizationSearchIndexLocalService = organizationSearchIndexLocalService;
	}

	private OrganizationSearchIndexLocalService _organizationSearchIndexLocalService;
}