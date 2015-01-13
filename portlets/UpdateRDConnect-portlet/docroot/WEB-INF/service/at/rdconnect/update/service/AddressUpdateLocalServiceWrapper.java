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

package at.rdconnect.update.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AddressUpdateLocalService}.
 *
 * @author reihsr
 * @see AddressUpdateLocalService
 * @generated
 */
public class AddressUpdateLocalServiceWrapper
	implements AddressUpdateLocalService,
		ServiceWrapper<AddressUpdateLocalService> {
	public AddressUpdateLocalServiceWrapper(
		AddressUpdateLocalService addressUpdateLocalService) {
		_addressUpdateLocalService = addressUpdateLocalService;
	}

	/**
	* Adds the address update to the database. Also notifies the appropriate model listeners.
	*
	* @param addressUpdate the address update
	* @return the address update that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.rdconnect.update.model.AddressUpdate addAddressUpdate(
		at.rdconnect.update.model.AddressUpdate addressUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressUpdateLocalService.addAddressUpdate(addressUpdate);
	}

	/**
	* Creates a new address update with the primary key. Does not add the address update to the database.
	*
	* @param addressid the primary key for the new address update
	* @return the new address update
	*/
	@Override
	public at.rdconnect.update.model.AddressUpdate createAddressUpdate(
		long addressid) {
		return _addressUpdateLocalService.createAddressUpdate(addressid);
	}

	/**
	* Deletes the address update with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressid the primary key of the address update
	* @return the address update that was removed
	* @throws PortalException if a address update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.rdconnect.update.model.AddressUpdate deleteAddressUpdate(
		long addressid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressUpdateLocalService.deleteAddressUpdate(addressid);
	}

	/**
	* Deletes the address update from the database. Also notifies the appropriate model listeners.
	*
	* @param addressUpdate the address update
	* @return the address update that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.rdconnect.update.model.AddressUpdate deleteAddressUpdate(
		at.rdconnect.update.model.AddressUpdate addressUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressUpdateLocalService.deleteAddressUpdate(addressUpdate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _addressUpdateLocalService.dynamicQuery();
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
		return _addressUpdateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.AddressUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _addressUpdateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.AddressUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _addressUpdateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _addressUpdateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _addressUpdateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.rdconnect.update.model.AddressUpdate fetchAddressUpdate(
		long addressid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressUpdateLocalService.fetchAddressUpdate(addressid);
	}

	/**
	* Returns the address update with the primary key.
	*
	* @param addressid the primary key of the address update
	* @return the address update
	* @throws PortalException if a address update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.rdconnect.update.model.AddressUpdate getAddressUpdate(
		long addressid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressUpdateLocalService.getAddressUpdate(addressid);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _addressUpdateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the address updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.AddressUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of address updates
	* @param end the upper bound of the range of address updates (not inclusive)
	* @return the range of address updates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.rdconnect.update.model.AddressUpdate> getAddressUpdates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressUpdateLocalService.getAddressUpdates(start, end);
	}

	/**
	* Returns the number of address updates.
	*
	* @return the number of address updates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAddressUpdatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressUpdateLocalService.getAddressUpdatesCount();
	}

	/**
	* Updates the address update in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param addressUpdate the address update
	* @return the address update that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.rdconnect.update.model.AddressUpdate updateAddressUpdate(
		at.rdconnect.update.model.AddressUpdate addressUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _addressUpdateLocalService.updateAddressUpdate(addressUpdate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _addressUpdateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_addressUpdateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _addressUpdateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AddressUpdateLocalService getWrappedAddressUpdateLocalService() {
		return _addressUpdateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAddressUpdateLocalService(
		AddressUpdateLocalService addressUpdateLocalService) {
		_addressUpdateLocalService = addressUpdateLocalService;
	}

	@Override
	public AddressUpdateLocalService getWrappedService() {
		return _addressUpdateLocalService;
	}

	@Override
	public void setWrappedService(
		AddressUpdateLocalService addressUpdateLocalService) {
		_addressUpdateLocalService = addressUpdateLocalService;
	}

	private AddressUpdateLocalService _addressUpdateLocalService;
}