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
 * Provides the local service utility for D2Biobank. This utility wraps
 * {@link at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author reihsr
 * @see D2BiobankLocalService
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.D2BiobankLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankLocalServiceImpl
 * @generated
 */
public class D2BiobankLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the d2 biobank to the database. Also notifies the appropriate model listeners.
	*
	* @param d2Biobank the d2 biobank
	* @return the d2 biobank that was added
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank addD2Biobank(
		at.meduni.liferay.portlet.bbmrieric.model.D2Biobank d2Biobank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addD2Biobank(d2Biobank);
	}

	/**
	* Creates a new d2 biobank with the primary key. Does not add the d2 biobank to the database.
	*
	* @param biobankId the primary key for the new d2 biobank
	* @return the new d2 biobank
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank createD2Biobank(
		long biobankId) {
		return getService().createD2Biobank(biobankId);
	}

	/**
	* Deletes the d2 biobank with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankId the primary key of the d2 biobank
	* @return the d2 biobank that was removed
	* @throws PortalException if a d2 biobank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank deleteD2Biobank(
		long biobankId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteD2Biobank(biobankId);
	}

	/**
	* Deletes the d2 biobank from the database. Also notifies the appropriate model listeners.
	*
	* @param d2Biobank the d2 biobank
	* @return the d2 biobank that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank deleteD2Biobank(
		at.meduni.liferay.portlet.bbmrieric.model.D2Biobank d2Biobank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteD2Biobank(d2Biobank);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank fetchD2Biobank(
		long biobankId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchD2Biobank(biobankId);
	}

	/**
	* Returns the d2 biobank with the matching UUID and company.
	*
	* @param uuid the d2 biobank's UUID
	* @param companyId the primary key of the company
	* @return the matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank fetchD2BiobankByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchD2BiobankByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the d2 biobank matching the UUID and group.
	*
	* @param uuid the d2 biobank's UUID
	* @param groupId the primary key of the group
	* @return the matching d2 biobank, or <code>null</code> if a matching d2 biobank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank fetchD2BiobankByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchD2BiobankByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the d2 biobank with the primary key.
	*
	* @param biobankId the primary key of the d2 biobank
	* @return the d2 biobank
	* @throws PortalException if a d2 biobank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank getD2Biobank(
		long biobankId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getD2Biobank(biobankId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the d2 biobank with the matching UUID and company.
	*
	* @param uuid the d2 biobank's UUID
	* @param companyId the primary key of the company
	* @return the matching d2 biobank
	* @throws PortalException if a matching d2 biobank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank getD2BiobankByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getD2BiobankByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the d2 biobank matching the UUID and group.
	*
	* @param uuid the d2 biobank's UUID
	* @param groupId the primary key of the group
	* @return the matching d2 biobank
	* @throws PortalException if a matching d2 biobank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank getD2BiobankByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getD2BiobankByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the d2 biobanks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d2 biobanks
	* @param end the upper bound of the range of d2 biobanks (not inclusive)
	* @return the range of d2 biobanks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Biobank> getD2Biobanks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getD2Biobanks(start, end);
	}

	/**
	* Returns the number of d2 biobanks.
	*
	* @return the number of d2 biobanks
	* @throws SystemException if a system exception occurred
	*/
	public static int getD2BiobanksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getD2BiobanksCount();
	}

	/**
	* Updates the d2 biobank in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param d2Biobank the d2 biobank
	* @return the d2 biobank that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank updateD2Biobank(
		at.meduni.liferay.portlet.bbmrieric.model.D2Biobank d2Biobank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateD2Biobank(d2Biobank);
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

	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank d2BiobankFromRequest(
		javax.portlet.ActionRequest request) {
		return getService().d2BiobankFromRequest(request);
	}

	/**
	* @param groupId
	* @return
	* @throws SystemException
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Biobank> getD2Biobanks(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getD2Biobanks(groupId);
	}

	/**
	* @param groupId
	* @param start
	* @param end
	* @return
	* @throws SystemException
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Biobank> getD2Biobanks(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getD2Biobanks(groupId, start, end);
	}

	/**
	* @param groupId
	* @param bbmribiobankID
	* @return
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank getD2BiobankByBBMRIERICID(
		long groupId, java.lang.String bbmribiobankID) {
		return getService().getD2BiobankByBBMRIERICID(groupId, bbmribiobankID);
	}

	/**
	* @param newbiobank
	* @param serviceContext
	* @return
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank addD2Biobank(
		at.meduni.liferay.portlet.bbmrieric.model.D2Biobank newbiobank,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().addD2Biobank(newbiobank, serviceContext);
	}

	/**
	* @param biobankId
	* @param serviceContext
	* @return
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank addD2Biobank(
		long biobankId, long companyId, long groupId, long userId,
		java.lang.String biobankName, java.lang.String ldapbiobankID,
		java.lang.String ldapupdateuuid, java.lang.String contactIDRef,
		long contactPriority, java.lang.String biobankJurisdicalPerson,
		java.lang.String biobankCountry, boolean biobankPartnerCharterSigned,
		java.lang.String bioresourceReference,
		java.lang.String biobankNetworkIDRef, java.lang.String geoLatitude,
		java.lang.String geoLongitude, boolean collaborationPartnersCommercial,
		boolean collaborationPartnersNonforprofit,
		boolean biobankITSupportAvailable, long biobankITStaffSize,
		boolean biobankISAvailable, boolean biobankHISAvailable,
		java.lang.String biobankAcronym, java.lang.String biobankDescription,
		java.lang.String biobankURL, java.lang.String biobankHeadFirstName,
		java.lang.String biobankHeadLastName, java.lang.String biobankHeadRole,
		boolean biobankClinical, boolean biobankPopulation,
		boolean biobankResearchStudy, boolean biobankNonHuman,
		boolean biobankCollection, java.lang.String biobankType,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addD2Biobank(biobankId, companyId, groupId, userId,
			biobankName, ldapbiobankID, ldapupdateuuid, contactIDRef,
			contactPriority, biobankJurisdicalPerson, biobankCountry,
			biobankPartnerCharterSigned, bioresourceReference,
			biobankNetworkIDRef, geoLatitude, geoLongitude,
			collaborationPartnersCommercial, collaborationPartnersNonforprofit,
			biobankITSupportAvailable, biobankITStaffSize, biobankISAvailable,
			biobankHISAvailable, biobankAcronym, biobankDescription,
			biobankURL, biobankHeadFirstName, biobankHeadLastName,
			biobankHeadRole, biobankClinical, biobankPopulation,
			biobankResearchStudy, biobankNonHuman, biobankCollection,
			biobankType, serviceContext);
	}

	/**
	* @param newbiobank
	* @param serviceContext
	* @return
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank updateD2Biobank(
		at.meduni.liferay.portlet.bbmrieric.model.D2Biobank d2biobank,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().updateD2Biobank(d2biobank, serviceContext);
	}

	/**
	* @param biobankId
	* @param serviceContext
	* @return
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank updateD2Biobank(
		long biobankId, long userId, java.lang.String biobankName,
		java.lang.String ldapbiobankID, java.lang.String ldapupdateuuid,
		java.lang.String contactIDRef, long contactPriority,
		java.lang.String biobankJurisdicalPerson,
		java.lang.String biobankCountry, boolean biobankPartnerCharterSigned,
		java.lang.String bioresourceReference,
		java.lang.String biobankNetworkIDRef, java.lang.String geoLatitude,
		java.lang.String geoLongitude, boolean collaborationPartnersCommercial,
		boolean collaborationPartnersNonforprofit,
		boolean biobankITSupportAvailable, long biobankITStaffSize,
		boolean biobankISAvailable, boolean biobankHISAvailable,
		java.lang.String biobankAcronym, java.lang.String biobankDescription,
		java.lang.String biobankURL, java.lang.String biobankHeadFirstName,
		java.lang.String biobankHeadLastName, java.lang.String biobankHeadRole,
		boolean biobankClinical, boolean biobankPopulation,
		boolean biobankResearchStudy, boolean biobankNonHuman,
		boolean biobankCollection, java.lang.String biobankType,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateD2Biobank(biobankId, userId, biobankName,
			ldapbiobankID, ldapupdateuuid, contactIDRef, contactPriority,
			biobankJurisdicalPerson, biobankCountry,
			biobankPartnerCharterSigned, bioresourceReference,
			biobankNetworkIDRef, geoLatitude, geoLongitude,
			collaborationPartnersCommercial, collaborationPartnersNonforprofit,
			biobankITSupportAvailable, biobankITStaffSize, biobankISAvailable,
			biobankHISAvailable, biobankAcronym, biobankDescription,
			biobankURL, biobankHeadFirstName, biobankHeadLastName,
			biobankHeadRole, biobankClinical, biobankPopulation,
			biobankResearchStudy, biobankNonHuman, biobankCollection,
			biobankType, serviceContext);
	}

	/**
	* @param biobankId
	* @param serviceContext
	* @return
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank deleteD2Biobank(
		long biobankId, com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().deleteD2Biobank(biobankId, serviceContext);
	}

	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Biobank> getD2Biobanks(
		java.lang.String keyword, java.lang.String country,
		java.lang.String materialtype, java.lang.String diagnosisavailable,
		java.lang.String biobanksize, java.lang.String typeofbiobank,
		java.lang.String typeofcollection) {
		return getService()
				   .getD2Biobanks(keyword, country, materialtype,
			diagnosisavailable, biobanksize, typeofbiobank, typeofcollection);
	}

	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Biobank> getLDAPNotUpdatedBiobanks(
		long groupId, java.lang.String ldapupdateuuid) {
		return getService().getLDAPNotUpdatedBiobanks(groupId, ldapupdateuuid);
	}

	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank getBiobankWithLdapUpdate(
		long biobankId) {
		return getService().getBiobankWithLdapUpdate(biobankId);
	}

	public static at.meduni.liferay.portlet.bbmrieric.model.D2Biobank getD2BiobankFromLDAP(
		at.meduni.liferay.portlet.bbmrieric.model.D2Biobank d2biobank,
		javax.naming.directory.Attributes attrs, boolean contact) {
		return getService().getD2BiobankFromLDAP(d2biobank, attrs, contact);
	}

	public static void clearService() {
		_service = null;
	}

	public static D2BiobankLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					D2BiobankLocalService.class.getName());

			if (invokableLocalService instanceof D2BiobankLocalService) {
				_service = (D2BiobankLocalService)invokableLocalService;
			}
			else {
				_service = new D2BiobankLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(D2BiobankLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(D2BiobankLocalService service) {
	}

	private static D2BiobankLocalService _service;
}