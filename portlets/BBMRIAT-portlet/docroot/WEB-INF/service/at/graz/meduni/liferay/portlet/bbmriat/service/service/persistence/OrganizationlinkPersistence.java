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

package at.graz.meduni.liferay.portlet.bbmriat.service.service.persistence;

import at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the organizationlink service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Reihs Robert
 * @see OrganizationlinkPersistenceImpl
 * @see OrganizationlinkUtil
 * @generated
 */
public interface OrganizationlinkPersistence extends BasePersistence<Organizationlink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrganizationlinkUtil} to access the organizationlink persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the organizationlinks where parentorganizationId = &#63;.
	*
	* @param parentorganizationId the parentorganization ID
	* @return the matching organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink> findByParentorganization(
		long parentorganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the organizationlinks where parentorganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentorganizationId the parentorganization ID
	* @param start the lower bound of the range of organizationlinks
	* @param end the upper bound of the range of organizationlinks (not inclusive)
	* @return the range of matching organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink> findByParentorganization(
		long parentorganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the organizationlinks where parentorganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentorganizationId the parentorganization ID
	* @param start the lower bound of the range of organizationlinks
	* @param end the upper bound of the range of organizationlinks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink> findByParentorganization(
		long parentorganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first organizationlink in the ordered set where parentorganizationId = &#63;.
	*
	* @param parentorganizationId the parentorganization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizationlink
	* @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a matching organizationlink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink findByParentorganization_First(
		long parentorganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first organizationlink in the ordered set where parentorganizationId = &#63;.
	*
	* @param parentorganizationId the parentorganization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizationlink, or <code>null</code> if a matching organizationlink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink fetchByParentorganization_First(
		long parentorganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last organizationlink in the ordered set where parentorganizationId = &#63;.
	*
	* @param parentorganizationId the parentorganization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizationlink
	* @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a matching organizationlink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink findByParentorganization_Last(
		long parentorganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last organizationlink in the ordered set where parentorganizationId = &#63;.
	*
	* @param parentorganizationId the parentorganization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizationlink, or <code>null</code> if a matching organizationlink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink fetchByParentorganization_Last(
		long parentorganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizationlinks before and after the current organizationlink in the ordered set where parentorganizationId = &#63;.
	*
	* @param organizationlinkId the primary key of the current organizationlink
	* @param parentorganizationId the parentorganization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next organizationlink
	* @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a organizationlink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink[] findByParentorganization_PrevAndNext(
		long organizationlinkId, long parentorganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the organizationlinks where parentorganizationId = &#63; from the database.
	*
	* @param parentorganizationId the parentorganization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentorganization(long parentorganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organizationlinks where parentorganizationId = &#63;.
	*
	* @param parentorganizationId the parentorganization ID
	* @return the number of matching organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentorganization(long parentorganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the organizationlinks where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink> findByOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the organizationlinks where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of organizationlinks
	* @param end the upper bound of the range of organizationlinks (not inclusive)
	* @return the range of matching organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink> findByOrganization(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the organizationlinks where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of organizationlinks
	* @param end the upper bound of the range of organizationlinks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink> findByOrganization(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first organizationlink in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizationlink
	* @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a matching organizationlink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink findByOrganization_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first organizationlink in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizationlink, or <code>null</code> if a matching organizationlink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink fetchByOrganization_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last organizationlink in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizationlink
	* @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a matching organizationlink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink findByOrganization_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last organizationlink in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizationlink, or <code>null</code> if a matching organizationlink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink fetchByOrganization_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizationlinks before and after the current organizationlink in the ordered set where organizationId = &#63;.
	*
	* @param organizationlinkId the primary key of the current organizationlink
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next organizationlink
	* @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a organizationlink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink[] findByOrganization_PrevAndNext(
		long organizationlinkId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the organizationlinks where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganization(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organizationlinks where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganization(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the organizationlink in the entity cache if it is enabled.
	*
	* @param organizationlink the organizationlink
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink organizationlink);

	/**
	* Caches the organizationlinks in the entity cache if it is enabled.
	*
	* @param organizationlinks the organizationlinks
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink> organizationlinks);

	/**
	* Creates a new organizationlink with the primary key. Does not add the organizationlink to the database.
	*
	* @param organizationlinkId the primary key for the new organizationlink
	* @return the new organizationlink
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink create(
		long organizationlinkId);

	/**
	* Removes the organizationlink with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param organizationlinkId the primary key of the organizationlink
	* @return the organizationlink that was removed
	* @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a organizationlink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink remove(
		long organizationlinkId)
		throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink updateImpl(
		at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink organizationlink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizationlink with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException} if it could not be found.
	*
	* @param organizationlinkId the primary key of the organizationlink
	* @return the organizationlink
	* @throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException if a organizationlink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink findByPrimaryKey(
		long organizationlinkId)
		throws at.graz.meduni.liferay.portlet.bbmriat.service.NoSuchOrganizationlinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizationlink with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param organizationlinkId the primary key of the organizationlink
	* @return the organizationlink, or <code>null</code> if a organizationlink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink fetchByPrimaryKey(
		long organizationlinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the organizationlinks.
	*
	* @return the organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the organizationlinks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organizationlinks
	* @param end the upper bound of the range of organizationlinks (not inclusive)
	* @return the range of organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the organizationlinks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organizationlinks
	* @param end the upper bound of the range of organizationlinks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the organizationlinks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organizationlinks.
	*
	* @return the number of organizationlinks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}