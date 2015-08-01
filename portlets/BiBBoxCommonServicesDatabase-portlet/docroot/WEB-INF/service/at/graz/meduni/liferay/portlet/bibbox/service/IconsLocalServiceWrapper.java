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
 * Provides a wrapper for {@link IconsLocalService}.
 *
 * @author reihsr
 * @see IconsLocalService
 * @generated
 */
public class IconsLocalServiceWrapper implements IconsLocalService,
	ServiceWrapper<IconsLocalService> {
	public IconsLocalServiceWrapper(IconsLocalService iconsLocalService) {
		_iconsLocalService = iconsLocalService;
	}

	/**
	* Adds the icons to the database. Also notifies the appropriate model listeners.
	*
	* @param icons the icons
	* @return the icons that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.Icons addIcons(
		at.graz.meduni.liferay.portlet.bibbox.model.Icons icons)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iconsLocalService.addIcons(icons);
	}

	/**
	* Creates a new icons with the primary key. Does not add the icons to the database.
	*
	* @param iconsId the primary key for the new icons
	* @return the new icons
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.Icons createIcons(
		long iconsId) {
		return _iconsLocalService.createIcons(iconsId);
	}

	/**
	* Deletes the icons with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param iconsId the primary key of the icons
	* @return the icons that was removed
	* @throws PortalException if a icons with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.Icons deleteIcons(
		long iconsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _iconsLocalService.deleteIcons(iconsId);
	}

	/**
	* Deletes the icons from the database. Also notifies the appropriate model listeners.
	*
	* @param icons the icons
	* @return the icons that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.Icons deleteIcons(
		at.graz.meduni.liferay.portlet.bibbox.model.Icons icons)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iconsLocalService.deleteIcons(icons);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _iconsLocalService.dynamicQuery();
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
		return _iconsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _iconsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _iconsLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _iconsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _iconsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.Icons fetchIcons(
		long iconsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iconsLocalService.fetchIcons(iconsId);
	}

	/**
	* Returns the icons with the primary key.
	*
	* @param iconsId the primary key of the icons
	* @return the icons
	* @throws PortalException if a icons with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.Icons getIcons(
		long iconsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _iconsLocalService.getIcons(iconsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _iconsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the iconses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of iconses
	* @param end the upper bound of the range of iconses (not inclusive)
	* @return the range of iconses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.Icons> getIconses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iconsLocalService.getIconses(start, end);
	}

	/**
	* Returns the number of iconses.
	*
	* @return the number of iconses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getIconsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iconsLocalService.getIconsesCount();
	}

	/**
	* Updates the icons in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param icons the icons
	* @return the icons that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.Icons updateIcons(
		at.graz.meduni.liferay.portlet.bibbox.model.Icons icons)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iconsLocalService.updateIcons(icons);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _iconsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_iconsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _iconsLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.Icons iconsFromRequest(
		javax.portlet.ActionRequest request) {
		return _iconsLocalService.iconsFromRequest(request);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public IconsLocalService getWrappedIconsLocalService() {
		return _iconsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedIconsLocalService(IconsLocalService iconsLocalService) {
		_iconsLocalService = iconsLocalService;
	}

	@Override
	public IconsLocalService getWrappedService() {
		return _iconsLocalService;
	}

	@Override
	public void setWrappedService(IconsLocalService iconsLocalService) {
		_iconsLocalService = iconsLocalService;
	}

	private IconsLocalService _iconsLocalService;
}