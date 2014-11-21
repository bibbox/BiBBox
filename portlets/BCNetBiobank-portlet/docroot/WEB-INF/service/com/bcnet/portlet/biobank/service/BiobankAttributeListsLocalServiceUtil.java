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
 * Provides the local service utility for BiobankAttributeLists. This utility wraps
 * {@link com.bcnet.portlet.biobank.service.impl.BiobankAttributeListsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author suyama
 * @see BiobankAttributeListsLocalService
 * @see com.bcnet.portlet.biobank.service.base.BiobankAttributeListsLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.impl.BiobankAttributeListsLocalServiceImpl
 * @generated
 */
public class BiobankAttributeListsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bcnet.portlet.biobank.service.impl.BiobankAttributeListsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the biobank attribute lists to the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeLists the biobank attribute lists
	* @return the biobank attribute lists that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists addBiobankAttributeLists(
		com.bcnet.portlet.biobank.model.BiobankAttributeLists biobankAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBiobankAttributeLists(biobankAttributeLists);
	}

	/**
	* Creates a new biobank attribute lists with the primary key. Does not add the biobank attribute lists to the database.
	*
	* @param biobankAttributeListsId the primary key for the new biobank attribute lists
	* @return the new biobank attribute lists
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists createBiobankAttributeLists(
		long biobankAttributeListsId) {
		return getService().createBiobankAttributeLists(biobankAttributeListsId);
	}

	/**
	* Deletes the biobank attribute lists with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeListsId the primary key of the biobank attribute lists
	* @return the biobank attribute lists that was removed
	* @throws PortalException if a biobank attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists deleteBiobankAttributeLists(
		long biobankAttributeListsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBiobankAttributeLists(biobankAttributeListsId);
	}

	/**
	* Deletes the biobank attribute lists from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeLists the biobank attribute lists
	* @return the biobank attribute lists that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists deleteBiobankAttributeLists(
		com.bcnet.portlet.biobank.model.BiobankAttributeLists biobankAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBiobankAttributeLists(biobankAttributeLists);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists fetchBiobankAttributeLists(
		long biobankAttributeListsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBiobankAttributeLists(biobankAttributeListsId);
	}

	/**
	* Returns the biobank attribute lists with the primary key.
	*
	* @param biobankAttributeListsId the primary key of the biobank attribute lists
	* @return the biobank attribute lists
	* @throws PortalException if a biobank attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists getBiobankAttributeLists(
		long biobankAttributeListsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBiobankAttributeLists(biobankAttributeListsId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the biobank attribute listses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank attribute listses
	* @param end the upper bound of the range of biobank attribute listses (not inclusive)
	* @return the range of biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> getBiobankAttributeListses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBiobankAttributeListses(start, end);
	}

	/**
	* Returns the number of biobank attribute listses.
	*
	* @return the number of biobank attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static int getBiobankAttributeListsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBiobankAttributeListsesCount();
	}

	/**
	* Updates the biobank attribute lists in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeLists the biobank attribute lists
	* @return the biobank attribute lists that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists updateBiobankAttributeLists(
		com.bcnet.portlet.biobank.model.BiobankAttributeLists biobankAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBiobankAttributeLists(biobankAttributeLists);
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

	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists addBiobankAttributeLists(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addBiobankAttributeLists(biobankDbId, attributeListName,
			attributeListValue);
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> getBiobankAtrributeListsByBiobankDbId(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBiobankAtrributeListsByBiobankDbId(biobankDbId);
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> getBiobankAtrributeListsByBiobankDbId_AttributeListName(
		long biobankDbId, java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getBiobankAtrributeListsByBiobankDbId_AttributeListName(biobankDbId,
			attributeListName);
	}

	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists getBiobankAtrributeListsByBiobankDbId_AttributeListName_AttributeListValue(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getBiobankAtrributeListsByBiobankDbId_AttributeListName_AttributeListValue(biobankDbId,
			attributeListName, attributeListValue);
	}

	public static com.bcnet.portlet.biobank.model.BiobankAttributeLists deleteBiobankAttributeLists(
		long biobankDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBiobankAttributeLists(biobankDbId, attributeListName,
			attributeListValue);
	}

	public static void clearService() {
		_service = null;
	}

	public static BiobankAttributeListsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BiobankAttributeListsLocalService.class.getName());

			if (invokableLocalService instanceof BiobankAttributeListsLocalService) {
				_service = (BiobankAttributeListsLocalService)invokableLocalService;
			}
			else {
				_service = new BiobankAttributeListsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BiobankAttributeListsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BiobankAttributeListsLocalService service) {
	}

	private static BiobankAttributeListsLocalService _service;
}