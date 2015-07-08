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

package at.meduni.liferay.portlet.bbmrieric.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BioBank. This utility wraps
 * {@link at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author reihsr
 * @see BioBankLocalService
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.BioBankLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl
 * @generated
 */
public class BioBankLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bio bank to the database. Also notifies the appropriate model listeners.
	*
	* @param bioBank the bio bank
	* @return the bio bank that was added
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank addBioBank(
		at.meduni.liferay.portlet.bbmrieric.model.BioBank bioBank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBioBank(bioBank);
	}

	/**
	* Creates a new bio bank with the primary key. Does not add the bio bank to the database.
	*
	* @param biobankId the primary key for the new bio bank
	* @return the new bio bank
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank createBioBank(
		long biobankId) {
		return getService().createBioBank(biobankId);
	}

	/**
	* Deletes the bio bank with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankId the primary key of the bio bank
	* @return the bio bank that was removed
	* @throws PortalException if a bio bank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank deleteBioBank(
		long biobankId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBioBank(biobankId);
	}

	/**
	* Deletes the bio bank from the database. Also notifies the appropriate model listeners.
	*
	* @param bioBank the bio bank
	* @return the bio bank that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank deleteBioBank(
		at.meduni.liferay.portlet.bbmrieric.model.BioBank bioBank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBioBank(bioBank);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchBioBank(
		long biobankId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBioBank(biobankId);
	}

	/**
	* Returns the bio bank with the primary key.
	*
	* @param biobankId the primary key of the bio bank
	* @return the bio bank
	* @throws PortalException if a bio bank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank getBioBank(
		long biobankId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBioBank(biobankId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bio banks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bio banks
	* @param end the upper bound of the range of bio banks (not inclusive)
	* @return the range of bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> getBioBanks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBioBanks(start, end);
	}

	/**
	* Returns the number of bio banks.
	*
	* @return the number of bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static int getBioBanksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBioBanksCount();
	}

	/**
	* Updates the bio bank in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bioBank the bio bank
	* @return the bio bank that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank updateBioBank(
		at.meduni.liferay.portlet.bbmrieric.model.BioBank bioBank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBioBank(bioBank);
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

	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> notUpdatedBioBank(
		java.lang.String uuid) {
		return getService().notUpdatedBioBank(uuid);
	}

	/**
	* @return
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank createBioBank(
		java.lang.String ldapbiobankID) {
		return getService().createBioBank(ldapbiobankID);
	}

	/**
	* @param ldapbiobankid
	* @return
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank getBioBank(
		java.lang.String ldapbiobankID) {
		return getService().getBioBank(ldapbiobankID);
	}

	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> getBioBankByCountry(
		java.lang.String country) {
		return getService().getBioBankByCountry(country);
	}

	public static java.lang.String getBioBankByCountryInJavaScriptArray(
		java.lang.String country) {
		return getService().getBioBankByCountryInJavaScriptArray(country);
	}

	public static void clearService() {
		_service = null;
	}

	public static BioBankLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BioBankLocalService.class.getName());

			if (invokableLocalService instanceof BioBankLocalService) {
				_service = (BioBankLocalService)invokableLocalService;
			}
			else {
				_service = new BioBankLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BioBankLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BioBankLocalService service) {
	}

	private static BioBankLocalService _service;
}