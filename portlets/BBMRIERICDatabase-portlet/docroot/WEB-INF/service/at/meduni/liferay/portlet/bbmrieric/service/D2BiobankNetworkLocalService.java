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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for D2BiobankNetwork. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author reihsr
 * @see D2BiobankNetworkLocalServiceUtil
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.D2BiobankNetworkLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankNetworkLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface D2BiobankNetworkLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link D2BiobankNetworkLocalServiceUtil} to access the d2 biobank network local service. Add custom service methods to {@link at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankNetworkLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the d2 biobank network to the database. Also notifies the appropriate model listeners.
	*
	* @param d2BiobankNetwork the d2 biobank network
	* @return the d2 biobank network that was added
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork addD2BiobankNetwork(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork d2BiobankNetwork)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new d2 biobank network with the primary key. Does not add the d2 biobank network to the database.
	*
	* @param d2biobanknetworkId the primary key for the new d2 biobank network
	* @return the new d2 biobank network
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork createD2BiobankNetwork(
		long d2biobanknetworkId);

	/**
	* Deletes the d2 biobank network with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param d2biobanknetworkId the primary key of the d2 biobank network
	* @return the d2 biobank network that was removed
	* @throws PortalException if a d2 biobank network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork deleteD2BiobankNetwork(
		long d2biobanknetworkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the d2 biobank network from the database. Also notifies the appropriate model listeners.
	*
	* @param d2BiobankNetwork the d2 biobank network
	* @return the d2 biobank network that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork deleteD2BiobankNetwork(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork d2BiobankNetwork)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchD2BiobankNetwork(
		long d2biobanknetworkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network with the matching UUID and company.
	*
	* @param uuid the d2 biobank network's UUID
	* @param companyId the primary key of the company
	* @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchD2BiobankNetworkByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network matching the UUID and group.
	*
	* @param uuid the d2 biobank network's UUID
	* @param groupId the primary key of the group
	* @return the matching d2 biobank network, or <code>null</code> if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork fetchD2BiobankNetworkByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network with the primary key.
	*
	* @param d2biobanknetworkId the primary key of the d2 biobank network
	* @return the d2 biobank network
	* @throws PortalException if a d2 biobank network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork getD2BiobankNetwork(
		long d2biobanknetworkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network with the matching UUID and company.
	*
	* @param uuid the d2 biobank network's UUID
	* @param companyId the primary key of the company
	* @return the matching d2 biobank network
	* @throws PortalException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork getD2BiobankNetworkByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d2 biobank network matching the UUID and group.
	*
	* @param uuid the d2 biobank network's UUID
	* @param groupId the primary key of the group
	* @return the matching d2 biobank network
	* @throws PortalException if a matching d2 biobank network could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork getD2BiobankNetworkByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d2 biobank networks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d2 biobank networks
	* @param end the upper bound of the range of d2 biobank networks (not inclusive)
	* @return the range of d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> getD2BiobankNetworks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d2 biobank networks.
	*
	* @return the number of d2 biobank networks
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getD2BiobankNetworksCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the d2 biobank network in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param d2BiobankNetwork the d2 biobank network
	* @return the d2 biobank network that was updated
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork updateD2BiobankNetwork(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork d2BiobankNetwork)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* @param biobanknetwork
	* @param serviceContext
	* @return
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork addD2BiobankNetwork(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork biobanknetwork,
		com.liferay.portal.service.ServiceContext serviceContext);

	/**
	* @param d2biobanknetworkId
	* @param companyId
	* @param groupId
	* @param userId
	* @param ldapupdateuuid
	* @param contactIDRef
	* @param contactPriority
	* @param bbmriBiobankNetworkID
	* @param biobankNetworkName
	* @param biobankNetworkCommonCollectionFocus
	* @param biobankNetworkCommonCharter
	* @param biobankNetworkCommonSOPs
	* @param biobankNetworkCommonDataAccessPolicy
	* @param biobankNetworkCommonSampleAccessPolicy
	* @param biobankNetworkCommonMTA
	* @param biobankNetworkCommonRepresentation
	* @param biobankNetworkCommonURL
	* @param biobankNetworkIDRef
	* @param geoLatitude
	* @param geoLongitude
	* @param biobankNetworkAcronym
	* @param biobankNetworkDescription
	* @param biobankNetworkURL
	* @param biobankNetworkJuridicalPerson
	* @param serviceContext
	* @return
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork addD2BiobankNetwork(
		long d2biobanknetworkId, long companyId, long groupId, long userId,
		java.lang.String ldapupdateuuid, java.lang.String contactIDRef,
		long contactPriority, java.lang.String bbmriBiobankNetworkID,
		java.lang.String biobankNetworkName,
		boolean biobankNetworkCommonCollectionFocus,
		boolean biobankNetworkCommonCharter, boolean biobankNetworkCommonSOPs,
		boolean biobankNetworkCommonDataAccessPolicy,
		boolean biobankNetworkCommonSampleAccessPolicy,
		boolean biobankNetworkCommonMTA,
		boolean biobankNetworkCommonRepresentation,
		boolean biobankNetworkCommonURL, java.lang.String biobankNetworkIDRef,
		java.lang.String geoLatitude, java.lang.String geoLongitude,
		java.lang.String biobankNetworkAcronym,
		java.lang.String biobankNetworkDescription,
		java.lang.String biobankNetworkURL,
		java.lang.String biobankNetworkJuridicalPerson,
		com.liferay.portal.service.ServiceContext serviceContext);

	/**
	* @param groupId
	* @param ldapupdateuuid
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> getLDAPNotUpdatedNetworks(
		long groupId, java.lang.String ldapupdateuuid);

	/**
	* @param groupId
	* @param bbmribiobanknetworkID
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork getD2BiobankNetworkByBBMRIERICID(
		long groupId, java.lang.String bbmribiobanknetworkID);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork getD2BiobankNetworkFromLDAP(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork d2biobanknetwork,
		javax.naming.directory.Attributes attrs);

	/**
	* @param newbiobank
	* @param serviceContext
	* @return
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork updateD2BiobankNetwork(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork d2biobanknetwork,
		com.liferay.portal.service.ServiceContext serviceContext);

	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork updateD2BiobankNetwork(
		long d2biobanknetworkId, long companyId, long groupId, long userId,
		java.lang.String ldapupdateuuid, java.lang.String contactIDRef,
		long contactPriority, java.lang.String bbmriBiobankNetworkID,
		java.lang.String biobankNetworkName,
		boolean biobankNetworkCommonCollectionFocus,
		boolean biobankNetworkCommonCharter, boolean biobankNetworkCommonSOPs,
		boolean biobankNetworkCommonDataAccessPolicy,
		boolean biobankNetworkCommonSampleAccessPolicy,
		boolean biobankNetworkCommonMTA,
		boolean biobankNetworkCommonRepresentation,
		boolean biobankNetworkCommonURL, java.lang.String biobankNetworkIDRef,
		java.lang.String geoLatitude, java.lang.String geoLongitude,
		java.lang.String biobankNetworkAcronym,
		java.lang.String biobankNetworkDescription,
		java.lang.String biobankNetworkURL,
		java.lang.String biobankNetworkJuridicalPerson,
		com.liferay.portal.service.ServiceContext serviceContext);
}