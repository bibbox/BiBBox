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

package at.bibbox.reactjsservice.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ToolInformationLocalService}.
 *
 * @author reihsr
 * @see ToolInformationLocalService
 * @generated
 */
public class ToolInformationLocalServiceWrapper
	implements ToolInformationLocalService,
		ServiceWrapper<ToolInformationLocalService> {
	public ToolInformationLocalServiceWrapper(
		ToolInformationLocalService toolInformationLocalService) {
		_toolInformationLocalService = toolInformationLocalService;
	}

	/**
	* Adds the tool information to the database. Also notifies the appropriate model listeners.
	*
	* @param toolInformation the tool information
	* @return the tool information that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.bibbox.reactjsservice.model.ToolInformation addToolInformation(
		at.bibbox.reactjsservice.model.ToolInformation toolInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _toolInformationLocalService.addToolInformation(toolInformation);
	}

	/**
	* Creates a new tool information with the primary key. Does not add the tool information to the database.
	*
	* @param toolInformationId the primary key for the new tool information
	* @return the new tool information
	*/
	@Override
	public at.bibbox.reactjsservice.model.ToolInformation createToolInformation(
		long toolInformationId) {
		return _toolInformationLocalService.createToolInformation(toolInformationId);
	}

	/**
	* Deletes the tool information with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param toolInformationId the primary key of the tool information
	* @return the tool information that was removed
	* @throws PortalException if a tool information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.bibbox.reactjsservice.model.ToolInformation deleteToolInformation(
		long toolInformationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _toolInformationLocalService.deleteToolInformation(toolInformationId);
	}

	/**
	* Deletes the tool information from the database. Also notifies the appropriate model listeners.
	*
	* @param toolInformation the tool information
	* @return the tool information that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.bibbox.reactjsservice.model.ToolInformation deleteToolInformation(
		at.bibbox.reactjsservice.model.ToolInformation toolInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _toolInformationLocalService.deleteToolInformation(toolInformation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _toolInformationLocalService.dynamicQuery();
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
		return _toolInformationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.bibbox.reactjsservice.model.impl.ToolInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _toolInformationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.bibbox.reactjsservice.model.impl.ToolInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _toolInformationLocalService.dynamicQuery(dynamicQuery, start,
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
		return _toolInformationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _toolInformationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.bibbox.reactjsservice.model.ToolInformation fetchToolInformation(
		long toolInformationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _toolInformationLocalService.fetchToolInformation(toolInformationId);
	}

	/**
	* Returns the tool information with the primary key.
	*
	* @param toolInformationId the primary key of the tool information
	* @return the tool information
	* @throws PortalException if a tool information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.bibbox.reactjsservice.model.ToolInformation getToolInformation(
		long toolInformationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _toolInformationLocalService.getToolInformation(toolInformationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _toolInformationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tool informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.bibbox.reactjsservice.model.impl.ToolInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tool informations
	* @param end the upper bound of the range of tool informations (not inclusive)
	* @return the range of tool informations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.bibbox.reactjsservice.model.ToolInformation> getToolInformations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _toolInformationLocalService.getToolInformations(start, end);
	}

	/**
	* Returns the number of tool informations.
	*
	* @return the number of tool informations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getToolInformationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _toolInformationLocalService.getToolInformationsCount();
	}

	/**
	* Updates the tool information in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param toolInformation the tool information
	* @return the tool information that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.bibbox.reactjsservice.model.ToolInformation updateToolInformation(
		at.bibbox.reactjsservice.model.ToolInformation toolInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _toolInformationLocalService.updateToolInformation(toolInformation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _toolInformationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_toolInformationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _toolInformationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ToolInformationLocalService getWrappedToolInformationLocalService() {
		return _toolInformationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedToolInformationLocalService(
		ToolInformationLocalService toolInformationLocalService) {
		_toolInformationLocalService = toolInformationLocalService;
	}

	@Override
	public ToolInformationLocalService getWrappedService() {
		return _toolInformationLocalService;
	}

	@Override
	public void setWrappedService(
		ToolInformationLocalService toolInformationLocalService) {
		_toolInformationLocalService = toolInformationLocalService;
	}

	private ToolInformationLocalService _toolInformationLocalService;
}