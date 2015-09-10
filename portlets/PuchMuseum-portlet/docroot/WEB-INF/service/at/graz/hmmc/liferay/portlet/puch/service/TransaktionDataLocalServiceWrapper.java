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

package at.graz.hmmc.liferay.portlet.puch.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TransaktionDataLocalService}.
 *
 * @author reihsr
 * @see TransaktionDataLocalService
 * @generated
 */
public class TransaktionDataLocalServiceWrapper
	implements TransaktionDataLocalService,
		ServiceWrapper<TransaktionDataLocalService> {
	public TransaktionDataLocalServiceWrapper(
		TransaktionDataLocalService transaktionDataLocalService) {
		_transaktionDataLocalService = transaktionDataLocalService;
	}

	/**
	* Adds the transaktion data to the database. Also notifies the appropriate model listeners.
	*
	* @param transaktionData the transaktion data
	* @return the transaktion data that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData addTransaktionData(
		at.graz.hmmc.liferay.portlet.puch.model.TransaktionData transaktionData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktionDataLocalService.addTransaktionData(transaktionData);
	}

	/**
	* Creates a new transaktion data with the primary key. Does not add the transaktion data to the database.
	*
	* @param transaktiondataId the primary key for the new transaktion data
	* @return the new transaktion data
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData createTransaktionData(
		long transaktiondataId) {
		return _transaktionDataLocalService.createTransaktionData(transaktiondataId);
	}

	/**
	* Deletes the transaktion data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transaktiondataId the primary key of the transaktion data
	* @return the transaktion data that was removed
	* @throws PortalException if a transaktion data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData deleteTransaktionData(
		long transaktiondataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _transaktionDataLocalService.deleteTransaktionData(transaktiondataId);
	}

	/**
	* Deletes the transaktion data from the database. Also notifies the appropriate model listeners.
	*
	* @param transaktionData the transaktion data
	* @return the transaktion data that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData deleteTransaktionData(
		at.graz.hmmc.liferay.portlet.puch.model.TransaktionData transaktionData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktionDataLocalService.deleteTransaktionData(transaktionData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _transaktionDataLocalService.dynamicQuery();
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
		return _transaktionDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _transaktionDataLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _transaktionDataLocalService.dynamicQuery(dynamicQuery, start,
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
		return _transaktionDataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _transaktionDataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData fetchTransaktionData(
		long transaktiondataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktionDataLocalService.fetchTransaktionData(transaktiondataId);
	}

	/**
	* Returns the transaktion data with the primary key.
	*
	* @param transaktiondataId the primary key of the transaktion data
	* @return the transaktion data
	* @throws PortalException if a transaktion data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData getTransaktionData(
		long transaktiondataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _transaktionDataLocalService.getTransaktionData(transaktiondataId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _transaktionDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the transaktion datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of transaktion datas
	* @param end the upper bound of the range of transaktion datas (not inclusive)
	* @return the range of transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> getTransaktionDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktionDataLocalService.getTransaktionDatas(start, end);
	}

	/**
	* Returns the number of transaktion datas.
	*
	* @return the number of transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTransaktionDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktionDataLocalService.getTransaktionDatasCount();
	}

	/**
	* Updates the transaktion data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param transaktionData the transaktion data
	* @return the transaktion data that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData updateTransaktionData(
		at.graz.hmmc.liferay.portlet.puch.model.TransaktionData transaktionData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktionDataLocalService.updateTransaktionData(transaktionData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _transaktionDataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_transaktionDataLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _transaktionDataLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* @param request
	* @return
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData transaktionDataFromRequest(
		javax.portlet.ActionRequest request) {
		return _transaktionDataLocalService.transaktionDataFromRequest(request);
	}

	/**
	* @param transaktionId
	* @param puchmuseumsobjectId
	* @param objectkey
	* @param objectvalue
	* @return
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData addTransaktionData(
		long transaktionId, long puchmuseumsobjectId,
		java.lang.String objectkey, java.lang.String objectvalue) {
		return _transaktionDataLocalService.addTransaktionData(transaktionId,
			puchmuseumsobjectId, objectkey, objectvalue);
	}

	/**
	* @param transaktionId
	* @param objectkey
	* @return
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData getTransaktionDataForObject(
		long transaktionId, java.lang.String objectkey) {
		return _transaktionDataLocalService.getTransaktionDataForObject(transaktionId,
			objectkey);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TransaktionDataLocalService getWrappedTransaktionDataLocalService() {
		return _transaktionDataLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTransaktionDataLocalService(
		TransaktionDataLocalService transaktionDataLocalService) {
		_transaktionDataLocalService = transaktionDataLocalService;
	}

	@Override
	public TransaktionDataLocalService getWrappedService() {
		return _transaktionDataLocalService;
	}

	@Override
	public void setWrappedService(
		TransaktionDataLocalService transaktionDataLocalService) {
		_transaktionDataLocalService = transaktionDataLocalService;
	}

	private TransaktionDataLocalService _transaktionDataLocalService;
}