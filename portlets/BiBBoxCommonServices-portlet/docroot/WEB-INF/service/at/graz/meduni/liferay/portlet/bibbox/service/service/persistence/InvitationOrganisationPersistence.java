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

import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the invitation organisation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see InvitationOrganisationPersistenceImpl
 * @see InvitationOrganisationUtil
 * @generated
 */
public interface InvitationOrganisationPersistence extends BasePersistence<InvitationOrganisation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InvitationOrganisationUtil} to access the invitation organisation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the invitation organisations where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @return the matching invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> findByOrganisation(
		long organisationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the invitation organisations where organisationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organisationId the organisation ID
	* @param start the lower bound of the range of invitation organisations
	* @param end the upper bound of the range of invitation organisations (not inclusive)
	* @return the range of matching invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> findByOrganisation(
		long organisationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the invitation organisations where organisationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organisationId the organisation ID
	* @param start the lower bound of the range of invitation organisations
	* @param end the upper bound of the range of invitation organisations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> findByOrganisation(
		long organisationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first invitation organisation in the ordered set where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitation organisation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a matching invitation organisation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation findByOrganisation_First(
		long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first invitation organisation in the ordered set where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitation organisation, or <code>null</code> if a matching invitation organisation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation fetchByOrganisation_First(
		long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last invitation organisation in the ordered set where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitation organisation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a matching invitation organisation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation findByOrganisation_Last(
		long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last invitation organisation in the ordered set where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitation organisation, or <code>null</code> if a matching invitation organisation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation fetchByOrganisation_Last(
		long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the invitation organisations before and after the current invitation organisation in the ordered set where organisationId = &#63;.
	*
	* @param invitationOrganisationId the primary key of the current invitation organisation
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invitation organisation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a invitation organisation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation[] findByOrganisation_PrevAndNext(
		long invitationOrganisationId, long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the invitation organisations where organisationId = &#63; from the database.
	*
	* @param organisationId the organisation ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganisation(long organisationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invitation organisations where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @return the number of matching invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganisation(long organisationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the invitation organisations where invitationId = &#63;.
	*
	* @param invitationId the invitation ID
	* @return the matching invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> findByInvitationOrganisations(
		long invitationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the invitation organisations where invitationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param invitationId the invitation ID
	* @param start the lower bound of the range of invitation organisations
	* @param end the upper bound of the range of invitation organisations (not inclusive)
	* @return the range of matching invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> findByInvitationOrganisations(
		long invitationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the invitation organisations where invitationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param invitationId the invitation ID
	* @param start the lower bound of the range of invitation organisations
	* @param end the upper bound of the range of invitation organisations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> findByInvitationOrganisations(
		long invitationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first invitation organisation in the ordered set where invitationId = &#63;.
	*
	* @param invitationId the invitation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitation organisation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a matching invitation organisation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation findByInvitationOrganisations_First(
		long invitationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first invitation organisation in the ordered set where invitationId = &#63;.
	*
	* @param invitationId the invitation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitation organisation, or <code>null</code> if a matching invitation organisation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation fetchByInvitationOrganisations_First(
		long invitationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last invitation organisation in the ordered set where invitationId = &#63;.
	*
	* @param invitationId the invitation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitation organisation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a matching invitation organisation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation findByInvitationOrganisations_Last(
		long invitationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last invitation organisation in the ordered set where invitationId = &#63;.
	*
	* @param invitationId the invitation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitation organisation, or <code>null</code> if a matching invitation organisation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation fetchByInvitationOrganisations_Last(
		long invitationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the invitation organisations before and after the current invitation organisation in the ordered set where invitationId = &#63;.
	*
	* @param invitationOrganisationId the primary key of the current invitation organisation
	* @param invitationId the invitation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invitation organisation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a invitation organisation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation[] findByInvitationOrganisations_PrevAndNext(
		long invitationOrganisationId, long invitationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the invitation organisations where invitationId = &#63; from the database.
	*
	* @param invitationId the invitation ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByInvitationOrganisations(long invitationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invitation organisations where invitationId = &#63;.
	*
	* @param invitationId the invitation ID
	* @return the number of matching invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	public int countByInvitationOrganisations(long invitationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the invitation organisation in the entity cache if it is enabled.
	*
	* @param invitationOrganisation the invitation organisation
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation invitationOrganisation);

	/**
	* Caches the invitation organisations in the entity cache if it is enabled.
	*
	* @param invitationOrganisations the invitation organisations
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> invitationOrganisations);

	/**
	* Creates a new invitation organisation with the primary key. Does not add the invitation organisation to the database.
	*
	* @param invitationOrganisationId the primary key for the new invitation organisation
	* @return the new invitation organisation
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation create(
		long invitationOrganisationId);

	/**
	* Removes the invitation organisation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invitationOrganisationId the primary key of the invitation organisation
	* @return the invitation organisation that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a invitation organisation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation remove(
		long invitationOrganisationId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation invitationOrganisation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the invitation organisation with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException} if it could not be found.
	*
	* @param invitationOrganisationId the primary key of the invitation organisation
	* @return the invitation organisation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException if a invitation organisation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation findByPrimaryKey(
		long invitationOrganisationId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the invitation organisation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param invitationOrganisationId the primary key of the invitation organisation
	* @return the invitation organisation, or <code>null</code> if a invitation organisation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation fetchByPrimaryKey(
		long invitationOrganisationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the invitation organisations.
	*
	* @return the invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the invitation organisations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invitation organisations
	* @param end the upper bound of the range of invitation organisations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the invitation organisations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invitation organisations.
	*
	* @return the number of invitation organisations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}