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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KdssmpPatientLocalService}.
 *
 * @author reihsr
 * @see KdssmpPatientLocalService
 * @generated
 */
public class KdssmpPatientLocalServiceWrapper
	implements KdssmpPatientLocalService,
		ServiceWrapper<KdssmpPatientLocalService> {
	public KdssmpPatientLocalServiceWrapper(
		KdssmpPatientLocalService kdssmpPatientLocalService) {
		_kdssmpPatientLocalService = kdssmpPatientLocalService;
	}

	/**
	* Adds the kdssmp patient to the database. Also notifies the appropriate model listeners.
	*
	* @param kdssmpPatient the kdssmp patient
	* @return the kdssmp patient that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient addKdssmpPatient(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient kdssmpPatient)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpPatientLocalService.addKdssmpPatient(kdssmpPatient);
	}

	/**
	* Creates a new kdssmp patient with the primary key. Does not add the kdssmp patient to the database.
	*
	* @param patientId the primary key for the new kdssmp patient
	* @return the new kdssmp patient
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient createKdssmpPatient(
		long patientId) {
		return _kdssmpPatientLocalService.createKdssmpPatient(patientId);
	}

	/**
	* Deletes the kdssmp patient with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patientId the primary key of the kdssmp patient
	* @return the kdssmp patient that was removed
	* @throws PortalException if a kdssmp patient with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient deleteKdssmpPatient(
		long patientId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpPatientLocalService.deleteKdssmpPatient(patientId);
	}

	/**
	* Deletes the kdssmp patient from the database. Also notifies the appropriate model listeners.
	*
	* @param kdssmpPatient the kdssmp patient
	* @return the kdssmp patient that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient deleteKdssmpPatient(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient kdssmpPatient)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpPatientLocalService.deleteKdssmpPatient(kdssmpPatient);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _kdssmpPatientLocalService.dynamicQuery();
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
		return _kdssmpPatientLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpPatientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kdssmpPatientLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpPatientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kdssmpPatientLocalService.dynamicQuery(dynamicQuery, start,
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
		return _kdssmpPatientLocalService.dynamicQueryCount(dynamicQuery);
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
		return _kdssmpPatientLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient fetchKdssmpPatient(
		long patientId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpPatientLocalService.fetchKdssmpPatient(patientId);
	}

	/**
	* Returns the kdssmp patient with the primary key.
	*
	* @param patientId the primary key of the kdssmp patient
	* @return the kdssmp patient
	* @throws PortalException if a kdssmp patient with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient getKdssmpPatient(
		long patientId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpPatientLocalService.getKdssmpPatient(patientId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpPatientLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the kdssmp patients.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpPatientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kdssmp patients
	* @param end the upper bound of the range of kdssmp patients (not inclusive)
	* @return the range of kdssmp patients
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient> getKdssmpPatients(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpPatientLocalService.getKdssmpPatients(start, end);
	}

	/**
	* Returns the number of kdssmp patients.
	*
	* @return the number of kdssmp patients
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getKdssmpPatientsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpPatientLocalService.getKdssmpPatientsCount();
	}

	/**
	* Updates the kdssmp patient in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kdssmpPatient the kdssmp patient
	* @return the kdssmp patient that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient updateKdssmpPatient(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient kdssmpPatient)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpPatientLocalService.updateKdssmpPatient(kdssmpPatient);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _kdssmpPatientLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_kdssmpPatientLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _kdssmpPatientLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* @param firstname
	* @param lastname
	* @param dob
	* @param dod
	* @param gender
	* @return
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient createKdssmpPatient(
		java.lang.String firstname, java.lang.String lastname,
		java.util.Date dob, java.util.Date dod, java.lang.String gender,
		long organizationid) {
		return _kdssmpPatientLocalService.createKdssmpPatient(firstname,
			lastname, dob, dod, gender, organizationid);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient getPatientForOrganization(
		long organizationId) {
		return _kdssmpPatientLocalService.getPatientForOrganization(organizationId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public KdssmpPatientLocalService getWrappedKdssmpPatientLocalService() {
		return _kdssmpPatientLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedKdssmpPatientLocalService(
		KdssmpPatientLocalService kdssmpPatientLocalService) {
		_kdssmpPatientLocalService = kdssmpPatientLocalService;
	}

	@Override
	public KdssmpPatientLocalService getWrappedService() {
		return _kdssmpPatientLocalService;
	}

	@Override
	public void setWrappedService(
		KdssmpPatientLocalService kdssmpPatientLocalService) {
		_kdssmpPatientLocalService = kdssmpPatientLocalService;
	}

	private KdssmpPatientLocalService _kdssmpPatientLocalService;
}