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
 * Provides a wrapper for {@link TransaktionLocalService}.
 *
 * @author reihsr
 * @see TransaktionLocalService
 * @generated
 */
public class TransaktionLocalServiceWrapper implements TransaktionLocalService,
	ServiceWrapper<TransaktionLocalService> {
	public TransaktionLocalServiceWrapper(
		TransaktionLocalService transaktionLocalService) {
		_transaktionLocalService = transaktionLocalService;
	}

	/**
	* Adds the transaktion to the database. Also notifies the appropriate model listeners.
	*
	* @param transaktion the transaktion
	* @return the transaktion that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion addTransaktion(
		at.graz.hmmc.liferay.portlet.puch.model.Transaktion transaktion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktionLocalService.addTransaktion(transaktion);
	}

	/**
	* Creates a new transaktion with the primary key. Does not add the transaktion to the database.
	*
	* @param transaktionId the primary key for the new transaktion
	* @return the new transaktion
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion createTransaktion(
		long transaktionId) {
		return _transaktionLocalService.createTransaktion(transaktionId);
	}

	/**
	* Deletes the transaktion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transaktionId the primary key of the transaktion
	* @return the transaktion that was removed
	* @throws PortalException if a transaktion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion deleteTransaktion(
		long transaktionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _transaktionLocalService.deleteTransaktion(transaktionId);
	}

	/**
	* Deletes the transaktion from the database. Also notifies the appropriate model listeners.
	*
	* @param transaktion the transaktion
	* @return the transaktion that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion deleteTransaktion(
		at.graz.hmmc.liferay.portlet.puch.model.Transaktion transaktion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktionLocalService.deleteTransaktion(transaktion);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _transaktionLocalService.dynamicQuery();
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
		return _transaktionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _transaktionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _transaktionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _transaktionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _transaktionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion fetchTransaktion(
		long transaktionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktionLocalService.fetchTransaktion(transaktionId);
	}

	/**
	* Returns the transaktion with the primary key.
	*
	* @param transaktionId the primary key of the transaktion
	* @return the transaktion
	* @throws PortalException if a transaktion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion getTransaktion(
		long transaktionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _transaktionLocalService.getTransaktion(transaktionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _transaktionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the transaktions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of transaktions
	* @param end the upper bound of the range of transaktions (not inclusive)
	* @return the range of transaktions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> getTransaktions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktionLocalService.getTransaktions(start, end);
	}

	/**
	* Returns the number of transaktions.
	*
	* @return the number of transaktions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTransaktionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktionLocalService.getTransaktionsCount();
	}

	/**
	* Updates the transaktion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param transaktion the transaktion
	* @return the transaktion that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion updateTransaktion(
		at.graz.hmmc.liferay.portlet.puch.model.Transaktion transaktion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktionLocalService.updateTransaktion(transaktion);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _transaktionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_transaktionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _transaktionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TransaktionLocalService getWrappedTransaktionLocalService() {
		return _transaktionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTransaktionLocalService(
		TransaktionLocalService transaktionLocalService) {
		_transaktionLocalService = transaktionLocalService;
	}

	@Override
	public TransaktionLocalService getWrappedService() {
		return _transaktionLocalService;
	}

	@Override
	public void setWrappedService(
		TransaktionLocalService transaktionLocalService) {
		_transaktionLocalService = transaktionLocalService;
	}

	private TransaktionLocalService _transaktionLocalService;
}