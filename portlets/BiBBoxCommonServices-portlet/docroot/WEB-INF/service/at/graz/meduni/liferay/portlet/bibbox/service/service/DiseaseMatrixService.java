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
 * Provides the remote service interface for DiseaseMatrix. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author reihsr
 * @see DiseaseMatrixServiceUtil
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.DiseaseMatrixServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.impl.DiseaseMatrixServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface DiseaseMatrixService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DiseaseMatrixServiceUtil} to access the disease matrix remote service. Add custom service methods to {@link at.graz.meduni.liferay.portlet.bibbox.service.service.impl.DiseaseMatrixServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public void updatediseasematrix(long organizationId,
		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix matrix);

	public void updatediseasematrixs(long organizationId,
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> matrixs);

	public com.liferay.portal.kernel.json.JSONObject regbb(long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix getDiseaseMatrix(
		long organizationId);
}