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

package test.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MolgenisAPIRequestLocalService}.
 *
 * @author reihsr
 * @see MolgenisAPIRequestLocalService
 * @generated
 */
public class MolgenisAPIRequestLocalServiceWrapper
	implements MolgenisAPIRequestLocalService,
		ServiceWrapper<MolgenisAPIRequestLocalService> {
	public MolgenisAPIRequestLocalServiceWrapper(
		MolgenisAPIRequestLocalService molgenisAPIRequestLocalService) {
		_molgenisAPIRequestLocalService = molgenisAPIRequestLocalService;
	}

	/**
	* Adds the molgenis a p i request to the database. Also notifies the appropriate model listeners.
	*
	* @param molgenisAPIRequest the molgenis a p i request
	* @return the molgenis a p i request that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public test.portlet.model.MolgenisAPIRequest addMolgenisAPIRequest(
		test.portlet.model.MolgenisAPIRequest molgenisAPIRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _molgenisAPIRequestLocalService.addMolgenisAPIRequest(molgenisAPIRequest);
	}

	/**
	* Creates a new molgenis a p i request with the primary key. Does not add the molgenis a p i request to the database.
	*
	* @param molgenisapirequestId the primary key for the new molgenis a p i request
	* @return the new molgenis a p i request
	*/
	@Override
	public test.portlet.model.MolgenisAPIRequest createMolgenisAPIRequest(
		long molgenisapirequestId) {
		return _molgenisAPIRequestLocalService.createMolgenisAPIRequest(molgenisapirequestId);
	}

	/**
	* Deletes the molgenis a p i request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param molgenisapirequestId the primary key of the molgenis a p i request
	* @return the molgenis a p i request that was removed
	* @throws PortalException if a molgenis a p i request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public test.portlet.model.MolgenisAPIRequest deleteMolgenisAPIRequest(
		long molgenisapirequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _molgenisAPIRequestLocalService.deleteMolgenisAPIRequest(molgenisapirequestId);
	}

	/**
	* Deletes the molgenis a p i request from the database. Also notifies the appropriate model listeners.
	*
	* @param molgenisAPIRequest the molgenis a p i request
	* @return the molgenis a p i request that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public test.portlet.model.MolgenisAPIRequest deleteMolgenisAPIRequest(
		test.portlet.model.MolgenisAPIRequest molgenisAPIRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _molgenisAPIRequestLocalService.deleteMolgenisAPIRequest(molgenisAPIRequest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _molgenisAPIRequestLocalService.dynamicQuery();
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
		return _molgenisAPIRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link test.portlet.model.impl.MolgenisAPIRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _molgenisAPIRequestLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link test.portlet.model.impl.MolgenisAPIRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _molgenisAPIRequestLocalService.dynamicQuery(dynamicQuery,
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
		return _molgenisAPIRequestLocalService.dynamicQueryCount(dynamicQuery);
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
		return _molgenisAPIRequestLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public test.portlet.model.MolgenisAPIRequest fetchMolgenisAPIRequest(
		long molgenisapirequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _molgenisAPIRequestLocalService.fetchMolgenisAPIRequest(molgenisapirequestId);
	}

	/**
	* Returns the molgenis a p i request with the primary key.
	*
	* @param molgenisapirequestId the primary key of the molgenis a p i request
	* @return the molgenis a p i request
	* @throws PortalException if a molgenis a p i request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public test.portlet.model.MolgenisAPIRequest getMolgenisAPIRequest(
		long molgenisapirequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _molgenisAPIRequestLocalService.getMolgenisAPIRequest(molgenisapirequestId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _molgenisAPIRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the molgenis a p i requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link test.portlet.model.impl.MolgenisAPIRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of molgenis a p i requests
	* @param end the upper bound of the range of molgenis a p i requests (not inclusive)
	* @return the range of molgenis a p i requests
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<test.portlet.model.MolgenisAPIRequest> getMolgenisAPIRequests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _molgenisAPIRequestLocalService.getMolgenisAPIRequests(start, end);
	}

	/**
	* Returns the number of molgenis a p i requests.
	*
	* @return the number of molgenis a p i requests
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMolgenisAPIRequestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _molgenisAPIRequestLocalService.getMolgenisAPIRequestsCount();
	}

	/**
	* Updates the molgenis a p i request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param molgenisAPIRequest the molgenis a p i request
	* @return the molgenis a p i request that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public test.portlet.model.MolgenisAPIRequest updateMolgenisAPIRequest(
		test.portlet.model.MolgenisAPIRequest molgenisAPIRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _molgenisAPIRequestLocalService.updateMolgenisAPIRequest(molgenisAPIRequest);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _molgenisAPIRequestLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_molgenisAPIRequestLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _molgenisAPIRequestLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.lang.String getAgregatedJsonFromMolgenis() {
		return _molgenisAPIRequestLocalService.getAgregatedJsonFromMolgenis();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MolgenisAPIRequestLocalService getWrappedMolgenisAPIRequestLocalService() {
		return _molgenisAPIRequestLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMolgenisAPIRequestLocalService(
		MolgenisAPIRequestLocalService molgenisAPIRequestLocalService) {
		_molgenisAPIRequestLocalService = molgenisAPIRequestLocalService;
	}

	@Override
	public MolgenisAPIRequestLocalService getWrappedService() {
		return _molgenisAPIRequestLocalService;
	}

	@Override
	public void setWrappedService(
		MolgenisAPIRequestLocalService molgenisAPIRequestLocalService) {
		_molgenisAPIRequestLocalService = molgenisAPIRequestLocalService;
	}

	private MolgenisAPIRequestLocalService _molgenisAPIRequestLocalService;
}