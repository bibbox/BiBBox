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
 * Provides a wrapper for {@link InvitationLocalService}.
 *
 * @author reihsr
 * @see InvitationLocalService
 * @generated
 */
public class InvitationLocalServiceWrapper implements InvitationLocalService,
	ServiceWrapper<InvitationLocalService> {
	public InvitationLocalServiceWrapper(
		InvitationLocalService invitationLocalService) {
		_invitationLocalService = invitationLocalService;
	}

	/**
	* Adds the invitation to the database. Also notifies the appropriate model listeners.
	*
	* @param invitation the invitation
	* @return the invitation that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation addInvitation(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationLocalService.addInvitation(invitation);
	}

	/**
	* Creates a new invitation with the primary key. Does not add the invitation to the database.
	*
	* @param invitationId the primary key for the new invitation
	* @return the new invitation
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation createInvitation(
		long invitationId) {
		return _invitationLocalService.createInvitation(invitationId);
	}

	/**
	* Deletes the invitation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invitationId the primary key of the invitation
	* @return the invitation that was removed
	* @throws PortalException if a invitation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation deleteInvitation(
		long invitationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invitationLocalService.deleteInvitation(invitationId);
	}

	/**
	* Deletes the invitation from the database. Also notifies the appropriate model listeners.
	*
	* @param invitation the invitation
	* @return the invitation that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation deleteInvitation(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationLocalService.deleteInvitation(invitation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _invitationLocalService.dynamicQuery();
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
		return _invitationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _invitationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _invitationLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _invitationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _invitationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation fetchInvitation(
		long invitationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationLocalService.fetchInvitation(invitationId);
	}

	/**
	* Returns the invitation with the primary key.
	*
	* @param invitationId the primary key of the invitation
	* @return the invitation
	* @throws PortalException if a invitation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation getInvitation(
		long invitationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invitationLocalService.getInvitation(invitationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invitationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the invitations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invitations
	* @param end the upper bound of the range of invitations (not inclusive)
	* @return the range of invitations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> getInvitations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationLocalService.getInvitations(start, end);
	}

	/**
	* Returns the number of invitations.
	*
	* @return the number of invitations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getInvitationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationLocalService.getInvitationsCount();
	}

	/**
	* Updates the invitation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param invitation the invitation
	* @return the invitation that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation updateInvitation(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationLocalService.updateInvitation(invitation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _invitationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_invitationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _invitationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Convenience method to create a Invitation object out of the request.
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitationFromRequest(
		javax.portlet.PortletRequest request) {
		return _invitationLocalService.invitationFromRequest(request);
	}

	/**
	* Returns a filtered list of invitations
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> getMyFilteredInvitations(
		java.lang.String filter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationLocalService.getMyFilteredInvitations(filter);
	}

	/**
	* Returns the number of filtered invitations
	*/
	@Override
	public int getMyFilteredInvitationsCount(java.lang.String filter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationLocalService.getMyFilteredInvitationsCount(filter);
	}

	/**
	* Return Status from String
	* Status:
	*  0 ... Error
	*  1 ... Saved
	*  5 ... Simulated
	* 10 ... Send
	* 20 ... Request Panel Assessment
	* 30 ... Biobank Published
	*/
	@Override
	public long getStatusFromString(java.lang.String string_status) {
		return _invitationLocalService.getStatusFromString(string_status);
	}

	@Override
	public java.lang.String getStatusFromLong(long status) {
		return _invitationLocalService.getStatusFromLong(status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public InvitationLocalService getWrappedInvitationLocalService() {
		return _invitationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedInvitationLocalService(
		InvitationLocalService invitationLocalService) {
		_invitationLocalService = invitationLocalService;
	}

	@Override
	public InvitationLocalService getWrappedService() {
		return _invitationLocalService;
	}

	@Override
	public void setWrappedService(InvitationLocalService invitationLocalService) {
		_invitationLocalService = invitationLocalService;
	}

	private InvitationLocalService _invitationLocalService;
}