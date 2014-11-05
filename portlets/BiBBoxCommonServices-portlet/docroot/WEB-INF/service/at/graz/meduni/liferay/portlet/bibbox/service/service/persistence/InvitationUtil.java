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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the invitation service. This utility wraps {@link InvitationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see InvitationPersistence
 * @see InvitationPersistenceImpl
 * @generated
 */
public class InvitationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Invitation invitation) {
		getPersistence().clearCache(invitation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Invitation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Invitation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Invitation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Invitation update(Invitation invitation)
		throws SystemException {
		return getPersistence().update(invitation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Invitation update(Invitation invitation,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(invitation, serviceContext);
	}

	/**
	* Returns all the invitations where status = &#63;.
	*
	* @param status the status
	* @return the matching invitations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> findByStatus(
		long status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the invitations where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of invitations
	* @param end the upper bound of the range of invitations (not inclusive)
	* @return the range of matching invitations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> findByStatus(
		long status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the invitations where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of invitations
	* @param end the upper bound of the range of invitations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invitations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> findByStatus(
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first invitation in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a matching invitation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation findByStatus_First(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first invitation in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitation, or <code>null</code> if a matching invitation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation fetchByStatus_First(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last invitation in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a matching invitation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation findByStatus_Last(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last invitation in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitation, or <code>null</code> if a matching invitation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation fetchByStatus_Last(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the invitations before and after the current invitation in the ordered set where status = &#63;.
	*
	* @param invitationId the primary key of the current invitation
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invitation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation[] findByStatus_PrevAndNext(
		long invitationId, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus_PrevAndNext(invitationId, status,
			orderByComparator);
	}

	/**
	* Returns all the invitations that the user has permission to view where status = &#63;.
	*
	* @param status the status
	* @return the matching invitations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> filterFindByStatus(
		long status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByStatus(status);
	}

	/**
	* Returns a range of all the invitations that the user has permission to view where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of invitations
	* @param end the upper bound of the range of invitations (not inclusive)
	* @return the range of matching invitations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> filterFindByStatus(
		long status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the invitations that the user has permissions to view where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of invitations
	* @param end the upper bound of the range of invitations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invitations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> filterFindByStatus(
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the invitations before and after the current invitation in the ordered set of invitations that the user has permission to view where status = &#63;.
	*
	* @param invitationId the primary key of the current invitation
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invitation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation[] filterFindByStatus_PrevAndNext(
		long invitationId, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatus_PrevAndNext(invitationId, status,
			orderByComparator);
	}

	/**
	* Removes all the invitations where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of invitations where status = &#63;.
	*
	* @param status the status
	* @return the number of matching invitations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns the number of invitations that the user has permission to view where status = &#63;.
	*
	* @param status the status
	* @return the number of matching invitations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByStatus(long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByStatus(status);
	}

	/**
	* Returns all the invitations where filter = &#63;.
	*
	* @param filter the filter
	* @return the matching invitations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> findByFilter(
		java.lang.String filter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFilter(filter);
	}

	/**
	* Returns a range of all the invitations where filter = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filter the filter
	* @param start the lower bound of the range of invitations
	* @param end the upper bound of the range of invitations (not inclusive)
	* @return the range of matching invitations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> findByFilter(
		java.lang.String filter, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFilter(filter, start, end);
	}

	/**
	* Returns an ordered range of all the invitations where filter = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filter the filter
	* @param start the lower bound of the range of invitations
	* @param end the upper bound of the range of invitations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invitations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> findByFilter(
		java.lang.String filter, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilter(filter, start, end, orderByComparator);
	}

	/**
	* Returns the first invitation in the ordered set where filter = &#63;.
	*
	* @param filter the filter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a matching invitation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation findByFilter_First(
		java.lang.String filter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFilter_First(filter, orderByComparator);
	}

	/**
	* Returns the first invitation in the ordered set where filter = &#63;.
	*
	* @param filter the filter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invitation, or <code>null</code> if a matching invitation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation fetchByFilter_First(
		java.lang.String filter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFilter_First(filter, orderByComparator);
	}

	/**
	* Returns the last invitation in the ordered set where filter = &#63;.
	*
	* @param filter the filter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a matching invitation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation findByFilter_Last(
		java.lang.String filter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFilter_Last(filter, orderByComparator);
	}

	/**
	* Returns the last invitation in the ordered set where filter = &#63;.
	*
	* @param filter the filter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invitation, or <code>null</code> if a matching invitation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation fetchByFilter_Last(
		java.lang.String filter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFilter_Last(filter, orderByComparator);
	}

	/**
	* Returns the invitations before and after the current invitation in the ordered set where filter = &#63;.
	*
	* @param invitationId the primary key of the current invitation
	* @param filter the filter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invitation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation[] findByFilter_PrevAndNext(
		long invitationId, java.lang.String filter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFilter_PrevAndNext(invitationId, filter,
			orderByComparator);
	}

	/**
	* Returns all the invitations that the user has permission to view where filter = &#63;.
	*
	* @param filter the filter
	* @return the matching invitations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> filterFindByFilter(
		java.lang.String filter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByFilter(filter);
	}

	/**
	* Returns a range of all the invitations that the user has permission to view where filter = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filter the filter
	* @param start the lower bound of the range of invitations
	* @param end the upper bound of the range of invitations (not inclusive)
	* @return the range of matching invitations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> filterFindByFilter(
		java.lang.String filter, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByFilter(filter, start, end);
	}

	/**
	* Returns an ordered range of all the invitations that the user has permissions to view where filter = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filter the filter
	* @param start the lower bound of the range of invitations
	* @param end the upper bound of the range of invitations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invitations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> filterFindByFilter(
		java.lang.String filter, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByFilter(filter, start, end, orderByComparator);
	}

	/**
	* Returns the invitations before and after the current invitation in the ordered set of invitations that the user has permission to view where filter = &#63;.
	*
	* @param invitationId the primary key of the current invitation
	* @param filter the filter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invitation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation[] filterFindByFilter_PrevAndNext(
		long invitationId, java.lang.String filter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByFilter_PrevAndNext(invitationId, filter,
			orderByComparator);
	}

	/**
	* Removes all the invitations where filter = &#63; from the database.
	*
	* @param filter the filter
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFilter(java.lang.String filter)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFilter(filter);
	}

	/**
	* Returns the number of invitations where filter = &#63;.
	*
	* @param filter the filter
	* @return the number of matching invitations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFilter(java.lang.String filter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFilter(filter);
	}

	/**
	* Returns the number of invitations that the user has permission to view where filter = &#63;.
	*
	* @param filter the filter
	* @return the number of matching invitations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByFilter(java.lang.String filter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByFilter(filter);
	}

	/**
	* Returns the invitation where invitationId = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException} if it could not be found.
	*
	* @param invitationId the invitation ID
	* @return the matching invitation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a matching invitation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation findByInvitation(
		long invitationId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByInvitation(invitationId);
	}

	/**
	* Returns the invitation where invitationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param invitationId the invitation ID
	* @return the matching invitation, or <code>null</code> if a matching invitation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation fetchByInvitation(
		long invitationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByInvitation(invitationId);
	}

	/**
	* Returns the invitation where invitationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param invitationId the invitation ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching invitation, or <code>null</code> if a matching invitation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation fetchByInvitation(
		long invitationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByInvitation(invitationId, retrieveFromCache);
	}

	/**
	* Removes the invitation where invitationId = &#63; from the database.
	*
	* @param invitationId the invitation ID
	* @return the invitation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation removeByInvitation(
		long invitationId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByInvitation(invitationId);
	}

	/**
	* Returns the number of invitations where invitationId = &#63;.
	*
	* @param invitationId the invitation ID
	* @return the number of matching invitations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByInvitation(long invitationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByInvitation(invitationId);
	}

	/**
	* Caches the invitation in the entity cache if it is enabled.
	*
	* @param invitation the invitation
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation) {
		getPersistence().cacheResult(invitation);
	}

	/**
	* Caches the invitations in the entity cache if it is enabled.
	*
	* @param invitations the invitations
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> invitations) {
		getPersistence().cacheResult(invitations);
	}

	/**
	* Creates a new invitation with the primary key. Does not add the invitation to the database.
	*
	* @param invitationId the primary key for the new invitation
	* @return the new invitation
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation create(
		long invitationId) {
		return getPersistence().create(invitationId);
	}

	/**
	* Removes the invitation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invitationId the primary key of the invitation
	* @return the invitation that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation remove(
		long invitationId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(invitationId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(invitation);
	}

	/**
	* Returns the invitation with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException} if it could not be found.
	*
	* @param invitationId the primary key of the invitation
	* @return the invitation
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation findByPrimaryKey(
		long invitationId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(invitationId);
	}

	/**
	* Returns the invitation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param invitationId the primary key of the invitation
	* @return the invitation, or <code>null</code> if a invitation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation fetchByPrimaryKey(
		long invitationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(invitationId);
	}

	/**
	* Returns all the invitations.
	*
	* @return the invitations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the invitations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of invitations.
	*
	* @return the number of invitations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static InvitationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (InvitationPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer.getServletContextName(),
					InvitationPersistence.class.getName());

			ReferenceRegistry.registerReference(InvitationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(InvitationPersistence persistence) {
	}

	private static InvitationPersistence _persistence;
}