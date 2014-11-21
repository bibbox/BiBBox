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
 * Provides the local service utility for Biobank. This utility wraps
 * {@link com.bcnet.portlet.biobank.service.impl.BiobankLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author suyama
 * @see BiobankLocalService
 * @see com.bcnet.portlet.biobank.service.base.BiobankLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.impl.BiobankLocalServiceImpl
 * @generated
 */
public class BiobankLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bcnet.portlet.biobank.service.impl.BiobankLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the biobank to the database. Also notifies the appropriate model listeners.
	*
	* @param biobank the biobank
	* @return the biobank that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Biobank addBiobank(
		com.bcnet.portlet.biobank.model.Biobank biobank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBiobank(biobank);
	}

	/**
	* Creates a new biobank with the primary key. Does not add the biobank to the database.
	*
	* @param biobankDbId the primary key for the new biobank
	* @return the new biobank
	*/
	public static com.bcnet.portlet.biobank.model.Biobank createBiobank(
		long biobankDbId) {
		return getService().createBiobank(biobankDbId);
	}

	/**
	* Deletes the biobank with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankDbId the primary key of the biobank
	* @return the biobank that was removed
	* @throws PortalException if a biobank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Biobank deleteBiobank(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBiobank(biobankDbId);
	}

	/**
	* Deletes the biobank from the database. Also notifies the appropriate model listeners.
	*
	* @param biobank the biobank
	* @return the biobank that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Biobank deleteBiobank(
		com.bcnet.portlet.biobank.model.Biobank biobank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBiobank(biobank);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.bcnet.portlet.biobank.model.Biobank fetchBiobank(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBiobank(biobankDbId);
	}

	/**
	* Returns the biobank with the primary key.
	*
	* @param biobankDbId the primary key of the biobank
	* @return the biobank
	* @throws PortalException if a biobank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Biobank getBiobank(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBiobank(biobankDbId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the biobanks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobanks
	* @param end the upper bound of the range of biobanks (not inclusive)
	* @return the range of biobanks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.Biobank> getBiobanks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBiobanks(start, end);
	}

	/**
	* Returns the number of biobanks.
	*
	* @return the number of biobanks
	* @throws SystemException if a system exception occurred
	*/
	public static int getBiobanksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBiobanksCount();
	}

	/**
	* Updates the biobank in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param biobank the biobank
	* @return the biobank that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Biobank updateBiobank(
		com.bcnet.portlet.biobank.model.Biobank biobank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBiobank(biobank);
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

	public static com.bcnet.portlet.biobank.model.Biobank addBiobank(
		java.lang.String biobankId, java.lang.String acronym,
		java.lang.String name, java.lang.String url, long juristicPersonId,
		java.lang.String countryCode, java.lang.String description,
		boolean backup, boolean trainingCourses)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addBiobank(biobankId, acronym, name, url, juristicPersonId,
			countryCode, description, backup, trainingCourses);
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.Biobank> getAllBiobanks()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllBiobanks();
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.Biobank> getAllBiobanks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllBiobanks(start, end);
	}

	public static com.bcnet.portlet.biobank.model.Biobank updateBiobank(
		long biobankDbId, java.lang.String biobankId, java.lang.String acronym,
		java.lang.String name, java.lang.String url, long juristicPersonId,
		java.lang.String countryCode, java.lang.String description,
		boolean backup, boolean trainingCourses)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBiobank(biobankDbId, biobankId, acronym, name, url,
			juristicPersonId, countryCode, description, backup, trainingCourses);
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.Biobank> findBiobanksByIdentity(
		java.lang.String biobankId, java.lang.String acronym,
		java.lang.String name, java.lang.String countryCode, int begin, int end) {
		return getService()
				   .findBiobanksByIdentity(biobankId, acronym, name,
			countryCode, begin, end);
	}

	public static int findBiobanksCountByIdentity(java.lang.String biobankId,
		java.lang.String acronym, java.lang.String name,
		java.lang.String countryCode) {
		return getService()
				   .findBiobanksCountByIdentity(biobankId, acronym, name,
			countryCode);
	}

	public static void clearService() {
		_service = null;
	}

	public static BiobankLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BiobankLocalService.class.getName());

			if (invokableLocalService instanceof BiobankLocalService) {
				_service = (BiobankLocalService)invokableLocalService;
			}
			else {
				_service = new BiobankLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BiobankLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BiobankLocalService service) {
	}

	private static BiobankLocalService _service;
}