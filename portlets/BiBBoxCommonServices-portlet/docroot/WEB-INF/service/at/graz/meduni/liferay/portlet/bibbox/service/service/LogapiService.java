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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for Logapi. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author reihsr
 * @see LogapiServiceUtil
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.LogapiServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LogapiService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LogapiServiceUtil} to access the logapi remote service. Add custom service methods to {@link at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

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
	* @return
	*/
	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "getapiversion", method = "GET")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getAPIVersion();

	/**
	* @return
	*/
	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "regbbs", method = "POST")
	public com.liferay.portal.kernel.json.JSONArray regbbs(
		java.lang.String data);

	/**
	* @return
	*/
	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "rdconnectbiobanksregistries", method = "POST")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getRDConnectBiobanks();

	/**
	* @return
	*/
	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "rdconnectbiobanksregistries", method = "POST")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getRDConnectBiobanks(
		java.lang.Integer start);

	/**
	* @return
	*/
	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "rdconnectcollections", method = "POST")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getRDConnectCollections();

	/**
	* @return
	*/
	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "rdconnectcollections", method = "POST")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getRDConnectCollections(
		java.lang.Integer start);

	/**
	* @return
	*/
	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "regbbs", method = "GET")
	public com.liferay.portal.kernel.json.JSONArray regbbs();

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "findorganizationbyname", method = "GET")
	public com.liferay.portal.kernel.json.JSONArray findorganizationbyname(
		java.lang.String organizationname);

	/**
	* @return
	*/
	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "regs", method = "GET")
	public com.liferay.portal.kernel.json.JSONArray regs();

	/**
	* @return
	*/
	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "bbs", method = "GET")
	public com.liferay.portal.kernel.json.JSONArray bbs();

	/**
	* @param organizationId
	* @return
	*/
	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "regbb", method = "GET")
	public com.liferay.portal.kernel.json.JSONObject regbb(long organizationId);

	/**
	* @param organizationId
	* @return
	*/
	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "regbb", method = "GET")
	public com.liferay.portal.kernel.json.JSONObject regbb(
		long organizationId, long collectionId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "regbb", method = "GET")
	public com.liferay.portal.kernel.json.JSONObject regbb(java.lang.String id);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "getidcard", method = "GET")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getIdCard(long organizationId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "testmethode", method = "POST")
	public void testMethode(java.lang.String jason);
}