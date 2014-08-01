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

package com.inkwell.internet.productregistration.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PRRegistration. This utility wraps
 * {@link com.inkwell.internet.productregistration.service.impl.PRRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Rich Sezov
 * @see PRRegistrationLocalService
 * @see com.inkwell.internet.productregistration.service.base.PRRegistrationLocalServiceBaseImpl
 * @see com.inkwell.internet.productregistration.service.impl.PRRegistrationLocalServiceImpl
 * @generated
 */
public class PRRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.inkwell.internet.productregistration.service.impl.PRRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the p r registration to the database. Also notifies the appropriate model listeners.
	*
	* @param prRegistration the p r registration
	* @return the p r registration that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration addPRRegistration(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPRRegistration(prRegistration);
	}

	/**
	* Creates a new p r registration with the primary key. Does not add the p r registration to the database.
	*
	* @param registrationId the primary key for the new p r registration
	* @return the new p r registration
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration createPRRegistration(
		long registrationId) {
		return getService().createPRRegistration(registrationId);
	}

	/**
	* Deletes the p r registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationId the primary key of the p r registration
	* @return the p r registration that was removed
	* @throws PortalException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration deletePRRegistration(
		long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePRRegistration(registrationId);
	}

	/**
	* Deletes the p r registration from the database. Also notifies the appropriate model listeners.
	*
	* @param prRegistration the p r registration
	* @return the p r registration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration deletePRRegistration(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePRRegistration(prRegistration);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.inkwell.internet.productregistration.model.PRRegistration fetchPRRegistration(
		long registrationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPRRegistration(registrationId);
	}

	/**
	* Returns the p r registration with the primary key.
	*
	* @param registrationId the primary key of the p r registration
	* @return the p r registration
	* @throws PortalException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration getPRRegistration(
		long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRRegistration(registrationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the p r registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @return the range of p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> getPRRegistrations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRRegistrations(start, end);
	}

	/**
	* Returns the number of p r registrations.
	*
	* @return the number of p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int getPRRegistrationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRRegistrationsCount();
	}

	/**
	* Updates the p r registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param prRegistration the p r registration
	* @return the p r registration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration updatePRRegistration(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePRRegistration(prRegistration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Adds a newly created registration to the database.
	*
	* @param reg
	* @return
	* @throws SystemException
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration addRegistration(
		com.inkwell.internet.productregistration.model.PRRegistration reg)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addRegistration(reg);
	}

	/**
	* Gets all registrations out of the database.
	*
	* @return
	* @throws SystemException
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> getAllRegistrations(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllRegistrations(groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PRRegistrationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PRRegistrationLocalService.class.getName());

			if (invokableLocalService instanceof PRRegistrationLocalService) {
				_service = (PRRegistrationLocalService)invokableLocalService;
			}
			else {
				_service = new PRRegistrationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PRRegistrationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PRRegistrationLocalService service) {
	}

	private static PRRegistrationLocalService _service;
}