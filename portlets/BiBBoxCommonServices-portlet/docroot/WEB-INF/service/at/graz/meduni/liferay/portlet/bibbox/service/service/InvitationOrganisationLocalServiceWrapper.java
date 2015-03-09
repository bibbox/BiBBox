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
 * Provides a wrapper for {@link InvitationOrganisationLocalService}.
 *
 * @author reihsr
 * @see InvitationOrganisationLocalService
 * @generated
 */
public class InvitationOrganisationLocalServiceWrapper
	implements InvitationOrganisationLocalService,
		ServiceWrapper<InvitationOrganisationLocalService> {
	public InvitationOrganisationLocalServiceWrapper(
		InvitationOrganisationLocalService invitationOrganisationLocalService) {
		_invitationOrganisationLocalService = invitationOrganisationLocalService;
	}

	/**
	* Adds the invitation organisation to the database. Also notifies the appropriate model listeners.
	*
	* @param invitationOrganisation the invitation organisation
	* @return the invitation organisation that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation addInvitationOrganisation(
		at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation invitationOrganisation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.addInvitationOrganisation(invitationOrganisation);
	}

	/**
	* Creates a new invitation organisation with the primary key. Does not add the invitation organisation to the database.
	*
	* @param invitationOrganisationId the primary key for the new invitation organisation
	* @return the new invitation organisation
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation createInvitationOrganisation(
		long invitationOrganisationId) {
		return _invitationOrganisationLocalService.createInvitationOrganisation(invitationOrganisationId);
	}

	/**
	* Deletes the invitation organisation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invitationOrganisationId the primary key of the invitation organisation
	* @return the invitation organisation that was removed
	* @throws PortalException if a invitation organisation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation deleteInvitationOrganisation(
		long invitationOrganisationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.deleteInvitationOrganisation(invitationOrganisationId);
	}

	/**
	* Deletes the invitation organisation from the database. Also notifies the appropriate model listeners.
	*
	* @param invitationOrganisation the invitation organisation
	* @return the invitation organisation that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation deleteInvitationOrganisation(
		at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation invitationOrganisation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.deleteInvitationOrganisation(invitationOrganisation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _invitationOrganisationLocalService.dynamicQuery();
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
		return _invitationOrganisationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _invitationOrganisationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _invitationOrganisationLocalService.dynamicQuery(dynamicQuery,
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
		return _invitationOrganisationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _invitationOrganisationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation fetchInvitationOrganisation(
		long invitationOrganisationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.fetchInvitationOrganisation(invitationOrganisationId);
	}

	/**
	* Returns the invitation organisation with the primary key.
	*
	* @param invitationOrganisationId the primary key of the invitation organisation
	* @return the invitation organisation
	* @throws PortalException if a invitation organisation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation getInvitationOrganisation(
		long invitationOrganisationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.getInvitationOrganisation(invitationOrganisationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the invitation organisations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invitation organisations
	* @param end the upper bound of the range of invitation organisations (not inclusive)
	* @return the range of invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> getInvitationOrganisations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.getInvitationOrganisations(start,
			end);
	}

	/**
	* Returns the number of invitation organisations.
	*
	* @return the number of invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getInvitationOrganisationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.getInvitationOrganisationsCount();
	}

	/**
	* Updates the invitation organisation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param invitationOrganisation the invitation organisation
	* @return the invitation organisation that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation updateInvitationOrganisation(
		at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation invitationOrganisation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.updateInvitationOrganisation(invitationOrganisation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _invitationOrganisationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_invitationOrganisationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _invitationOrganisationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Gets the number of organizations for invitation
	*/
	@Override
	public int getOrganisationByInvitationCount(long invitationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.getOrganisationByInvitationCount(invitationId);
	}

	/**
	* Get organizations by invitation
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> getOrganisationByInvitation(
		long invitationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.getOrganisationByInvitation(invitationId);
	}

	/**
	* Get organizations by organisationId
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> getInvitationsByOrganisation(
		long organisationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.getInvitationsByOrganisation(organisationId);
	}

	/**
	* Get organizations by status
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> getInvitationsByStatus(
		long status) throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.getInvitationsByStatus(status);
	}

	/**
	* Get organizations by invitation
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation getInvitationOrganisation(
		long invitationId, long organisationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.getInvitationOrganisation(invitationId,
			organisationId);
	}

	/**
	* Get organizations responded by invitation
	*/
	@Override
	public java.lang.String getInvitationRespons(long invitationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.getInvitationRespons(invitationId);
	}

	/**
	* @throws SystemException
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> getInvitationOrganisationByStatus(
		boolean rejacted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisationLocalService.getInvitationOrganisationByStatus(rejacted);
	}

	/**
	* @return
	*/
	@Override
	public java.lang.String getInvitationStatisticsInvitationsSend() {
		return _invitationOrganisationLocalService.getInvitationStatisticsInvitationsSend();
	}

	/**
	* @return
	*/
	@Override
	public java.lang.String getInvitationStatisticsReacted() {
		return _invitationOrganisationLocalService.getInvitationStatisticsReacted();
	}

	/**
	* @return
	*/
	@Override
	public java.lang.String getInvitationStatisticsRejected() {
		return _invitationOrganisationLocalService.getInvitationStatisticsRejected();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public InvitationOrganisationLocalService getWrappedInvitationOrganisationLocalService() {
		return _invitationOrganisationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedInvitationOrganisationLocalService(
		InvitationOrganisationLocalService invitationOrganisationLocalService) {
		_invitationOrganisationLocalService = invitationOrganisationLocalService;
	}

	@Override
	public InvitationOrganisationLocalService getWrappedService() {
		return _invitationOrganisationLocalService;
	}

	@Override
	public void setWrappedService(
		InvitationOrganisationLocalService invitationOrganisationLocalService) {
		_invitationOrganisationLocalService = invitationOrganisationLocalService;
	}

	private InvitationOrganisationLocalService _invitationOrganisationLocalService;
}