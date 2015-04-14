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

package at.meduni.liferay.portlet.bbmrieric.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LDAPlogLocalService}.
 *
 * @author reihsr
 * @see LDAPlogLocalService
 * @generated
 */
public class LDAPlogLocalServiceWrapper implements LDAPlogLocalService,
	ServiceWrapper<LDAPlogLocalService> {
	public LDAPlogLocalServiceWrapper(LDAPlogLocalService ldaPlogLocalService) {
		_ldaPlogLocalService = ldaPlogLocalService;
	}

	/**
	* Adds the l d a plog to the database. Also notifies the appropriate model listeners.
	*
	* @param ldaPlog the l d a plog
	* @return the l d a plog that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog addLDAPlog(
		at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog ldaPlog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ldaPlogLocalService.addLDAPlog(ldaPlog);
	}

	/**
	* Creates a new l d a plog with the primary key. Does not add the l d a plog to the database.
	*
	* @param ldaplogId the primary key for the new l d a plog
	* @return the new l d a plog
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog createLDAPlog(
		long ldaplogId) {
		return _ldaPlogLocalService.createLDAPlog(ldaplogId);
	}

	/**
	* Deletes the l d a plog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ldaplogId the primary key of the l d a plog
	* @return the l d a plog that was removed
	* @throws PortalException if a l d a plog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog deleteLDAPlog(
		long ldaplogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ldaPlogLocalService.deleteLDAPlog(ldaplogId);
	}

	/**
	* Deletes the l d a plog from the database. Also notifies the appropriate model listeners.
	*
	* @param ldaPlog the l d a plog
	* @return the l d a plog that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog deleteLDAPlog(
		at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog ldaPlog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ldaPlogLocalService.deleteLDAPlog(ldaPlog);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ldaPlogLocalService.dynamicQuery();
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
		return _ldaPlogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.services.model.impl.LDAPlogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ldaPlogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.services.model.impl.LDAPlogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ldaPlogLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _ldaPlogLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ldaPlogLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog fetchLDAPlog(
		long ldaplogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ldaPlogLocalService.fetchLDAPlog(ldaplogId);
	}

	/**
	* Returns the l d a plog with the primary key.
	*
	* @param ldaplogId the primary key of the l d a plog
	* @return the l d a plog
	* @throws PortalException if a l d a plog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog getLDAPlog(
		long ldaplogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ldaPlogLocalService.getLDAPlog(ldaplogId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ldaPlogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the l d a plogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.services.model.impl.LDAPlogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l d a plogs
	* @param end the upper bound of the range of l d a plogs (not inclusive)
	* @return the range of l d a plogs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog> getLDAPlogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ldaPlogLocalService.getLDAPlogs(start, end);
	}

	/**
	* Returns the number of l d a plogs.
	*
	* @return the number of l d a plogs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLDAPlogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ldaPlogLocalService.getLDAPlogsCount();
	}

	/**
	* Updates the l d a plog in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ldaPlog the l d a plog
	* @return the l d a plog that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog updateLDAPlog(
		at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog ldaPlog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ldaPlogLocalService.updateLDAPlog(ldaPlog);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ldaPlogLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ldaPlogLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ldaPlogLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String getCountrylist() {
		return _ldaPlogLocalService.getCountrylist();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LDAPlogLocalService getWrappedLDAPlogLocalService() {
		return _ldaPlogLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLDAPlogLocalService(
		LDAPlogLocalService ldaPlogLocalService) {
		_ldaPlogLocalService = ldaPlogLocalService;
	}

	@Override
	public LDAPlogLocalService getWrappedService() {
		return _ldaPlogLocalService;
	}

	@Override
	public void setWrappedService(LDAPlogLocalService ldaPlogLocalService) {
		_ldaPlogLocalService = ldaPlogLocalService;
	}

	private LDAPlogLocalService _ldaPlogLocalService;
}