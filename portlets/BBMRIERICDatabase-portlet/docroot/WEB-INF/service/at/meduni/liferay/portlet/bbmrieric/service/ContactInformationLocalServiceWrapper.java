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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContactInformationLocalService}.
 *
 * @author reihsr
 * @see ContactInformationLocalService
 * @generated
 */
public class ContactInformationLocalServiceWrapper
	implements ContactInformationLocalService,
		ServiceWrapper<ContactInformationLocalService> {
	public ContactInformationLocalServiceWrapper(
		ContactInformationLocalService contactInformationLocalService) {
		_contactInformationLocalService = contactInformationLocalService;
	}

	/**
	* Adds the contact information to the database. Also notifies the appropriate model listeners.
	*
	* @param contactInformation the contact information
	* @return the contact information that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation addContactInformation(
		at.meduni.liferay.portlet.bbmrieric.model.ContactInformation contactInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.addContactInformation(contactInformation);
	}

	/**
	* Creates a new contact information with the primary key. Does not add the contact information to the database.
	*
	* @param contactinformationId the primary key for the new contact information
	* @return the new contact information
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation createContactInformation(
		long contactinformationId) {
		return _contactInformationLocalService.createContactInformation(contactinformationId);
	}

	/**
	* Deletes the contact information with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactinformationId the primary key of the contact information
	* @return the contact information that was removed
	* @throws PortalException if a contact information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation deleteContactInformation(
		long contactinformationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.deleteContactInformation(contactinformationId);
	}

	/**
	* Deletes the contact information from the database. Also notifies the appropriate model listeners.
	*
	* @param contactInformation the contact information
	* @return the contact information that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation deleteContactInformation(
		at.meduni.liferay.portlet.bbmrieric.model.ContactInformation contactInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.deleteContactInformation(contactInformation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contactInformationLocalService.dynamicQuery();
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
		return _contactInformationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contactInformationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _contactInformationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _contactInformationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _contactInformationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation fetchContactInformation(
		long contactinformationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.fetchContactInformation(contactinformationId);
	}

	/**
	* Returns the contact information with the matching UUID and company.
	*
	* @param uuid the contact information's UUID
	* @param companyId the primary key of the company
	* @return the matching contact information, or <code>null</code> if a matching contact information could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation fetchContactInformationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.fetchContactInformationByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the contact information matching the UUID and group.
	*
	* @param uuid the contact information's UUID
	* @param groupId the primary key of the group
	* @return the matching contact information, or <code>null</code> if a matching contact information could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation fetchContactInformationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.fetchContactInformationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the contact information with the primary key.
	*
	* @param contactinformationId the primary key of the contact information
	* @return the contact information
	* @throws PortalException if a contact information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformation(
		long contactinformationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.getContactInformation(contactinformationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the contact information with the matching UUID and company.
	*
	* @param uuid the contact information's UUID
	* @param companyId the primary key of the company
	* @return the matching contact information
	* @throws PortalException if a matching contact information could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.getContactInformationByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the contact information matching the UUID and group.
	*
	* @param uuid the contact information's UUID
	* @param groupId the primary key of the group
	* @return the matching contact information
	* @throws PortalException if a matching contact information could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.getContactInformationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the contact informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact informations
	* @param end the upper bound of the range of contact informations (not inclusive)
	* @return the range of contact informations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.ContactInformation> getContactInformations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.getContactInformations(start, end);
	}

	/**
	* Returns the number of contact informations.
	*
	* @return the number of contact informations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContactInformationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.getContactInformationsCount();
	}

	/**
	* Updates the contact information in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactInformation the contact information
	* @return the contact information that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation updateContactInformation(
		at.meduni.liferay.portlet.bbmrieric.model.ContactInformation contactInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactInformationLocalService.updateContactInformation(contactInformation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contactInformationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contactInformationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contactInformationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* @param contactinformation
	* @param serviceContext
	* @return
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation addContactInformation(
		at.meduni.liferay.portlet.bbmrieric.model.ContactInformation contactinformation,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _contactInformationLocalService.addContactInformation(contactinformation,
			serviceContext);
	}

	/**
	* @param contactinformationId
	* @param companyId
	* @param groupId
	* @param userId
	* @param contactID
	* @param contactEmail
	* @param contactCountry
	* @param contactFirstName
	* @param contactLastName
	* @param contactPhone
	* @param contactAddress
	* @param contactZIP
	* @param contactCity
	* @param serviceContext
	* @return
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation addContactInformation(
		long contactinformationId, long companyId, long groupId, long userId,
		java.lang.String contactID, java.lang.String contactEmail,
		java.lang.String contactCountry, java.lang.String contactFirstName,
		java.lang.String contactLastName, java.lang.String contactPhone,
		java.lang.String contactAddress, java.lang.String contactZIP,
		java.lang.String contactCity, java.lang.String updateuuid,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _contactInformationLocalService.addContactInformation(contactinformationId,
			companyId, groupId, userId, contactID, contactEmail,
			contactCountry, contactFirstName, contactLastName, contactPhone,
			contactAddress, contactZIP, contactCity, updateuuid, serviceContext);
	}

	/**
	* @param contactinformation
	* @param serviceContext
	* @return
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation updateContactInformation(
		at.meduni.liferay.portlet.bbmrieric.model.ContactInformation contactinformation,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _contactInformationLocalService.updateContactInformation(contactinformation,
			serviceContext);
	}

	/**
	* @param contactinformationId
	* @param companyId
	* @param groupId
	* @param userId
	* @param contactID
	* @param contactEmail
	* @param contactCountry
	* @param contactFirstName
	* @param contactLastName
	* @param contactPhone
	* @param contactAddress
	* @param contactZIP
	* @param contactCity
	* @param serviceContext
	* @return
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation updateContactInformation(
		long contactinformationId, long companyId, long groupId, long userId,
		java.lang.String contactID, java.lang.String contactEmail,
		java.lang.String contactCountry, java.lang.String contactFirstName,
		java.lang.String contactLastName, java.lang.String contactPhone,
		java.lang.String contactAddress, java.lang.String contactZIP,
		java.lang.String contactCity, java.lang.String updateuuid,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _contactInformationLocalService.updateContactInformation(contactinformationId,
			companyId, groupId, userId, contactID, contactEmail,
			contactCountry, contactFirstName, contactLastName, contactPhone,
			contactAddress, contactZIP, contactCity, updateuuid, serviceContext);
	}

	/**
	* Convenience function to get a Object from the LDAP attributes
	* ------
	* Function to convert the LDAP Attributes for ContactInformation
	* into a ContactInformation Object. The function can update an
	* existing object or if NULL is handed to the function a new
	* object is created.
	*
	* @param attrs
	* @param contactinformation
	* @return
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation contactInformationFromLdapAttribute(
		javax.naming.directory.Attributes attrs,
		at.meduni.liferay.portlet.bbmrieric.model.ContactInformation contactinformation) {
		return _contactInformationLocalService.contactInformationFromLdapAttribute(attrs,
			contactinformation);
	}

	/**
	* @param contactinformationId
	* @return
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformationWithLdapUpdate(
		long contactinformationId) {
		return _contactInformationLocalService.getContactInformationWithLdapUpdate(contactinformationId);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformationWithLdapUpdate(
		java.lang.String contactID) {
		return _contactInformationLocalService.getContactInformationWithLdapUpdate(contactID);
	}

	/**
	* @param groupId
	* @param contactID
	* @return
	*/
	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformationByBBMRIERICID(
		long groupId, java.lang.String contactID) {
		return _contactInformationLocalService.getContactInformationByBBMRIERICID(groupId,
			contactID);
	}

	/**
	* @param groupId
	* @param updateuuid
	* @return
	*/
	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.ContactInformation> getLDAPNotUpdatedContactInformation(
		long groupId, java.lang.String updateuuid) {
		return _contactInformationLocalService.getLDAPNotUpdatedContactInformation(groupId,
			updateuuid);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContactInformationLocalService getWrappedContactInformationLocalService() {
		return _contactInformationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContactInformationLocalService(
		ContactInformationLocalService contactInformationLocalService) {
		_contactInformationLocalService = contactInformationLocalService;
	}

	@Override
	public ContactInformationLocalService getWrappedService() {
		return _contactInformationLocalService;
	}

	@Override
	public void setWrappedService(
		ContactInformationLocalService contactInformationLocalService) {
		_contactInformationLocalService = contactInformationLocalService;
	}

	private ContactInformationLocalService _contactInformationLocalService;
}