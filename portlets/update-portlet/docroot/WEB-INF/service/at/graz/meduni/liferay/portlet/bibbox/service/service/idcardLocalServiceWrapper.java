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
 * Provides a wrapper for {@link idcardLocalService}.
 *
 * @author reihsr
 * @see idcardLocalService
 * @generated
 */
public class idcardLocalServiceWrapper implements idcardLocalService,
	ServiceWrapper<idcardLocalService> {
	public idcardLocalServiceWrapper(idcardLocalService idcardLocalService) {
		_idcardLocalService = idcardLocalService;
	}

	/**
	* Adds the idcard to the database. Also notifies the appropriate model listeners.
	*
	* @param idcard the idcard
	* @return the idcard that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.idcard addidcard(
		at.graz.meduni.liferay.portlet.bibbox.service.model.idcard idcard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _idcardLocalService.addidcard(idcard);
	}

	/**
	* Creates a new idcard with the primary key. Does not add the idcard to the database.
	*
	* @param idcardId the primary key for the new idcard
	* @return the new idcard
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.idcard createidcard(
		long idcardId) {
		return _idcardLocalService.createidcard(idcardId);
	}

	/**
	* Deletes the idcard with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idcardId the primary key of the idcard
	* @return the idcard that was removed
	* @throws PortalException if a idcard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.idcard deleteidcard(
		long idcardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _idcardLocalService.deleteidcard(idcardId);
	}

	/**
	* Deletes the idcard from the database. Also notifies the appropriate model listeners.
	*
	* @param idcard the idcard
	* @return the idcard that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.idcard deleteidcard(
		at.graz.meduni.liferay.portlet.bibbox.service.model.idcard idcard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _idcardLocalService.deleteidcard(idcard);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _idcardLocalService.dynamicQuery();
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
		return _idcardLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.idcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _idcardLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.idcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _idcardLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _idcardLocalService.dynamicQueryCount(dynamicQuery);
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
		return _idcardLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.idcard fetchidcard(
		long idcardId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _idcardLocalService.fetchidcard(idcardId);
	}

	/**
	* Returns the idcard with the primary key.
	*
	* @param idcardId the primary key of the idcard
	* @return the idcard
	* @throws PortalException if a idcard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.idcard getidcard(
		long idcardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _idcardLocalService.getidcard(idcardId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _idcardLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the idcards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.idcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of idcards
	* @param end the upper bound of the range of idcards (not inclusive)
	* @return the range of idcards
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.idcard> getidcards(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _idcardLocalService.getidcards(start, end);
	}

	/**
	* Returns the number of idcards.
	*
	* @return the number of idcards
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getidcardsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _idcardLocalService.getidcardsCount();
	}

	/**
	* Updates the idcard in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param idcard the idcard
	* @return the idcard that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.idcard updateidcard(
		at.graz.meduni.liferay.portlet.bibbox.service.model.idcard idcard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _idcardLocalService.updateidcard(idcard);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _idcardLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_idcardLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _idcardLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public idcardLocalService getWrappedidcardLocalService() {
		return _idcardLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedidcardLocalService(
		idcardLocalService idcardLocalService) {
		_idcardLocalService = idcardLocalService;
	}

	@Override
	public idcardLocalService getWrappedService() {
		return _idcardLocalService;
	}

	@Override
	public void setWrappedService(idcardLocalService idcardLocalService) {
		_idcardLocalService = idcardLocalService;
	}

	private idcardLocalService _idcardLocalService;
}