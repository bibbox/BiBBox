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
 * Provides a wrapper for {@link OrphanetDisorderLocalService}.
 *
 * @author reihsr
 * @see OrphanetDisorderLocalService
 * @generated
 */
public class OrphanetDisorderLocalServiceWrapper
	implements OrphanetDisorderLocalService,
		ServiceWrapper<OrphanetDisorderLocalService> {
	public OrphanetDisorderLocalServiceWrapper(
		OrphanetDisorderLocalService orphanetDisorderLocalService) {
		_orphanetDisorderLocalService = orphanetDisorderLocalService;
	}

	/**
	* Adds the orphanet disorder to the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetDisorder the orphanet disorder
	* @return the orphanet disorder that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder addOrphanetDisorder(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder orphanetDisorder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orphanetDisorderLocalService.addOrphanetDisorder(orphanetDisorder);
	}

	/**
	* Creates a new orphanet disorder with the primary key. Does not add the orphanet disorder to the database.
	*
	* @param orphanetdisorderId the primary key for the new orphanet disorder
	* @return the new orphanet disorder
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder createOrphanetDisorder(
		long orphanetdisorderId) {
		return _orphanetDisorderLocalService.createOrphanetDisorder(orphanetdisorderId);
	}

	/**
	* Deletes the orphanet disorder with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetdisorderId the primary key of the orphanet disorder
	* @return the orphanet disorder that was removed
	* @throws PortalException if a orphanet disorder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder deleteOrphanetDisorder(
		long orphanetdisorderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orphanetDisorderLocalService.deleteOrphanetDisorder(orphanetdisorderId);
	}

	/**
	* Deletes the orphanet disorder from the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetDisorder the orphanet disorder
	* @return the orphanet disorder that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder deleteOrphanetDisorder(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder orphanetDisorder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orphanetDisorderLocalService.deleteOrphanetDisorder(orphanetDisorder);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _orphanetDisorderLocalService.dynamicQuery();
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
		return _orphanetDisorderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _orphanetDisorderLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _orphanetDisorderLocalService.dynamicQuery(dynamicQuery, start,
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
		return _orphanetDisorderLocalService.dynamicQueryCount(dynamicQuery);
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
		return _orphanetDisorderLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder fetchOrphanetDisorder(
		long orphanetdisorderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orphanetDisorderLocalService.fetchOrphanetDisorder(orphanetdisorderId);
	}

	/**
	* Returns the orphanet disorder with the primary key.
	*
	* @param orphanetdisorderId the primary key of the orphanet disorder
	* @return the orphanet disorder
	* @throws PortalException if a orphanet disorder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder getOrphanetDisorder(
		long orphanetdisorderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orphanetDisorderLocalService.getOrphanetDisorder(orphanetdisorderId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orphanetDisorderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the orphanet disorders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orphanet disorders
	* @param end the upper bound of the range of orphanet disorders (not inclusive)
	* @return the range of orphanet disorders
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder> getOrphanetDisorders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orphanetDisorderLocalService.getOrphanetDisorders(start, end);
	}

	/**
	* Returns the number of orphanet disorders.
	*
	* @return the number of orphanet disorders
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOrphanetDisordersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orphanetDisorderLocalService.getOrphanetDisordersCount();
	}

	/**
	* Updates the orphanet disorder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orphanetDisorder the orphanet disorder
	* @return the orphanet disorder that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder updateOrphanetDisorder(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder orphanetDisorder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orphanetDisorderLocalService.updateOrphanetDisorder(orphanetDisorder);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _orphanetDisorderLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_orphanetDisorderLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _orphanetDisorderLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrphanetDisorderLocalService getWrappedOrphanetDisorderLocalService() {
		return _orphanetDisorderLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrphanetDisorderLocalService(
		OrphanetDisorderLocalService orphanetDisorderLocalService) {
		_orphanetDisorderLocalService = orphanetDisorderLocalService;
	}

	@Override
	public OrphanetDisorderLocalService getWrappedService() {
		return _orphanetDisorderLocalService;
	}

	@Override
	public void setWrappedService(
		OrphanetDisorderLocalService orphanetDisorderLocalService) {
		_orphanetDisorderLocalService = orphanetDisorderLocalService;
	}

	private OrphanetDisorderLocalService _orphanetDisorderLocalService;
}