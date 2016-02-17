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

package at.graz.meduni.liferay.portlet.bibbox.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NetworksLocalService}.
 *
 * @author reihsr
 * @see NetworksLocalService
 * @generated
 */
public class NetworksLocalServiceWrapper implements NetworksLocalService,
	ServiceWrapper<NetworksLocalService> {
	public NetworksLocalServiceWrapper(
		NetworksLocalService networksLocalService) {
		_networksLocalService = networksLocalService;
	}

	/**
	* Adds the networks to the database. Also notifies the appropriate model listeners.
	*
	* @param networks the networks
	* @return the networks that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks addNetworks(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Networks networks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _networksLocalService.addNetworks(networks);
	}

	/**
	* Creates a new networks with the primary key. Does not add the networks to the database.
	*
	* @param networkId the primary key for the new networks
	* @return the new networks
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks createNetworks(
		long networkId) {
		return _networksLocalService.createNetworks(networkId);
	}

	/**
	* Deletes the networks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param networkId the primary key of the networks
	* @return the networks that was removed
	* @throws PortalException if a networks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks deleteNetworks(
		long networkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _networksLocalService.deleteNetworks(networkId);
	}

	/**
	* Deletes the networks from the database. Also notifies the appropriate model listeners.
	*
	* @param networks the networks
	* @return the networks that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks deleteNetworks(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Networks networks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _networksLocalService.deleteNetworks(networks);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _networksLocalService.dynamicQuery();
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
		return _networksLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.NetworksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _networksLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.NetworksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _networksLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _networksLocalService.dynamicQueryCount(dynamicQuery);
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
		return _networksLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks fetchNetworks(
		long networkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _networksLocalService.fetchNetworks(networkId);
	}

	/**
	* Returns the networks with the primary key.
	*
	* @param networkId the primary key of the networks
	* @return the networks
	* @throws PortalException if a networks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks getNetworks(
		long networkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _networksLocalService.getNetworks(networkId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _networksLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> getNetworkses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _networksLocalService.getNetworkses(start, end);
	}

	/**
	* Returns the number of networkses.
	*
	* @return the number of networkses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getNetworksesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _networksLocalService.getNetworksesCount();
	}

	/**
	* Updates the networks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param networks the networks
	* @return the networks that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks updateNetworks(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Networks networks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _networksLocalService.updateNetworks(networks);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _networksLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_networksLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _networksLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* @param organizationId
	* @return
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> getNetworkOrganizations(
		long organizationId) {
		return _networksLocalService.getNetworkOrganizations(organizationId);
	}

	/**
	* @param organizationId
	* @return
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> getOrganizationNetworkOrganizations(
		long organizationId) {
		return _networksLocalService.getOrganizationNetworkOrganizations(organizationId);
	}

	/**
	* @param organizationId
	* @param networkId
	* @return
	*/
	@Override
	public boolean isOrganizationInNetwork(long organizationId, long networkId) {
		return _networksLocalService.isOrganizationInNetwork(organizationId,
			networkId);
	}

	/**
	* @param networkid
	* @return
	*/
	@Override
	public java.util.List<java.lang.Long> getNetworkIdList(long networkid) {
		return _networksLocalService.getNetworkIdList(networkid);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NetworksLocalService getWrappedNetworksLocalService() {
		return _networksLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNetworksLocalService(
		NetworksLocalService networksLocalService) {
		_networksLocalService = networksLocalService;
	}

	@Override
	public NetworksLocalService getWrappedService() {
		return _networksLocalService;
	}

	@Override
	public void setWrappedService(NetworksLocalService networksLocalService) {
		_networksLocalService = networksLocalService;
	}

	private NetworksLocalService _networksLocalService;
}