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

package at.graz.meduni.liferay.portlet.bibbox.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the invitation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see InvitationPersistenceImpl
 * @see InvitationUtil
 * @generated
 */
public interface InvitationPersistence extends BasePersistence<Invitation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InvitationUtil} to access the invitation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the invitation in the entity cache if it is enabled.
	*
	* @param invitation the invitation
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation);

	/**
	* Caches the invitations in the entity cache if it is enabled.
	*
	* @param invitations the invitations
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> invitations);

	/**
	* Creates a new invitation with the primary key. Does not add the invitation to the database.
	*
	* @param invitationID the primary key for the new invitation
	* @return the new invitation
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation create(
		long invitationID);

	/**
	* Removes the invitation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invitationID the primary key of the invitation
	* @return the invitation that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation remove(
		long invitationID)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the invitation with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException} if it could not be found.
	*
	* @param invitationID the primary key of the invitation
	* @return the invitation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation findByPrimaryKey(
		long invitationID)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the invitation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param invitationID the primary key of the invitation
	* @return the invitation, or <code>null</code> if a invitation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation fetchByPrimaryKey(
		long invitationID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the invitations.
	*
	* @return the invitations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the invitations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invitations
	* @param end the upper bound of the range of invitations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of invitations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the invitations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invitations.
	*
	* @return the number of invitations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}