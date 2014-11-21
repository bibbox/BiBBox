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

package com.bcnet.portlet.biobank.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BiobankAtrributeListsMaster. This utility wraps
 * {@link com.bcnet.portlet.biobank.service.impl.BiobankAtrributeListsMasterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author suyama
 * @see BiobankAtrributeListsMasterLocalService
 * @see com.bcnet.portlet.biobank.service.base.BiobankAtrributeListsMasterLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.impl.BiobankAtrributeListsMasterLocalServiceImpl
 * @generated
 */
public class BiobankAtrributeListsMasterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bcnet.portlet.biobank.service.impl.BiobankAtrributeListsMasterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the biobank atrribute lists master to the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAtrributeListsMaster the biobank atrribute lists master
	* @return the biobank atrribute lists master that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster addBiobankAtrributeListsMaster(
		com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster biobankAtrributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addBiobankAtrributeListsMaster(biobankAtrributeListsMaster);
	}

	/**
	* Creates a new biobank atrribute lists master with the primary key. Does not add the biobank atrribute lists master to the database.
	*
	* @param biobankAttributeListsMasterId the primary key for the new biobank atrribute lists master
	* @return the new biobank atrribute lists master
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster createBiobankAtrributeListsMaster(
		long biobankAttributeListsMasterId) {
		return getService()
				   .createBiobankAtrributeListsMaster(biobankAttributeListsMasterId);
	}

	/**
	* Deletes the biobank atrribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeListsMasterId the primary key of the biobank atrribute lists master
	* @return the biobank atrribute lists master that was removed
	* @throws PortalException if a biobank atrribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster deleteBiobankAtrributeListsMaster(
		long biobankAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBiobankAtrributeListsMaster(biobankAttributeListsMasterId);
	}

	/**
	* Deletes the biobank atrribute lists master from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAtrributeListsMaster the biobank atrribute lists master
	* @return the biobank atrribute lists master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster deleteBiobankAtrributeListsMaster(
		com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster biobankAtrributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBiobankAtrributeListsMaster(biobankAtrributeListsMaster);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAtrributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAtrributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster fetchBiobankAtrributeListsMaster(
		long biobankAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchBiobankAtrributeListsMaster(biobankAttributeListsMasterId);
	}

	/**
	* Returns the biobank atrribute lists master with the primary key.
	*
	* @param biobankAttributeListsMasterId the primary key of the biobank atrribute lists master
	* @return the biobank atrribute lists master
	* @throws PortalException if a biobank atrribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster getBiobankAtrributeListsMaster(
		long biobankAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getBiobankAtrributeListsMaster(biobankAttributeListsMasterId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the biobank atrribute lists masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAtrributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank atrribute lists masters
	* @param end the upper bound of the range of biobank atrribute lists masters (not inclusive)
	* @return the range of biobank atrribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster> getBiobankAtrributeListsMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBiobankAtrributeListsMasters(start, end);
	}

	/**
	* Returns the number of biobank atrribute lists masters.
	*
	* @return the number of biobank atrribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static int getBiobankAtrributeListsMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBiobankAtrributeListsMastersCount();
	}

	/**
	* Updates the biobank atrribute lists master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param biobankAtrributeListsMaster the biobank atrribute lists master
	* @return the biobank atrribute lists master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster updateBiobankAtrributeListsMaster(
		com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster biobankAtrributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBiobankAtrributeListsMaster(biobankAtrributeListsMaster);
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

	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster addBiobankAttributeListsMaster(
		java.lang.String attributeListName, java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addBiobankAttributeListsMaster(attributeListName,
			attributeListValue);
	}

	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster deleteBiobankAttributeListsMaster(
		com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster biobankAtrributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBiobankAttributeListsMaster(biobankAtrributeListsMaster);
	}

	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster deleteBiobankAttributeListsMaster(
		long biobankAtrributeListsMasterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBiobankAttributeListsMaster(biobankAtrributeListsMasterId);
	}

	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster getBiobankAttributeListsMaster(
		long biobankAtrributeListsMasterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getBiobankAttributeListsMaster(biobankAtrributeListsMasterId);
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster> getAllBiobankAtrributeListsMasters()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllBiobankAtrributeListsMasters();
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster> getAllBiobankAtrributeListsMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllBiobankAtrributeListsMasters(start, end);
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster> getBiobankAtrributeListsMasterByAttributeListName(
		java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getBiobankAtrributeListsMasterByAttributeListName(attributeListName);
	}

	public static com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster updateBiobankAttributeListsMaster(
		long biobankAttributeListsMasterId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBiobankAttributeListsMaster(biobankAttributeListsMasterId,
			attributeListName, attributeListValue);
	}

	public static void clearService() {
		_service = null;
	}

	public static BiobankAtrributeListsMasterLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BiobankAtrributeListsMasterLocalService.class.getName());

			if (invokableLocalService instanceof BiobankAtrributeListsMasterLocalService) {
				_service = (BiobankAtrributeListsMasterLocalService)invokableLocalService;
			}
			else {
				_service = new BiobankAtrributeListsMasterLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BiobankAtrributeListsMasterLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BiobankAtrributeListsMasterLocalService service) {
	}

	private static BiobankAtrributeListsMasterLocalService _service;
}