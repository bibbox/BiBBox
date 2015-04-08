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

package at.meduni.liferay.portlet.rdconnect.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess;
import at.meduni.liferay.portlet.rdconnect.model.impl.RDCOrganizationUserAccessImpl;
import at.meduni.liferay.portlet.rdconnect.service.base.RDCOrganizationUserAccessLocalServiceBaseImpl;

/**
 * The implementation of the r d c organization user access local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.rdconnect.service.RDCOrganizationUserAccessLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robert Reihs
 * @see at.meduni.liferay.portlet.rdconnect.service.base.RDCOrganizationUserAccessLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.rdconnect.service.RDCOrganizationUserAccessLocalServiceUtil
 */
public class RDCOrganizationUserAccessLocalServiceImpl
	extends RDCOrganizationUserAccessLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.rdconnect.service.RDCOrganizationUserAccessLocalServiceUtil} to access the r d c organization user access local service.
	 */
	public RDCOrganizationUserAccess addRDCOrganizationUserAccess(long organizationid, long userid, long ipaddress) throws SystemException {
		RDCOrganizationUserAccessImpl rdcorganizationuseraccess = new RDCOrganizationUserAccessImpl();
		
		rdcorganizationuseraccess.setRdcorganizationuseraccessId(CounterLocalServiceUtil.increment(RDCOrganizationUserAccess.class.getName()));
		rdcorganizationuseraccess.setOrganisationId(organizationid);
		rdcorganizationuseraccess.setUserId(userid);
		rdcorganizationuseraccess.setIpaddress(ipaddress);
		rdcorganizationuseraccess.setLastaccess(new Date());
		
		return super.addRDCOrganizationUserAccess(rdcorganizationuseraccess);
	}
	
	public int countRDCOrganizationUserAccess(long organizationId) {
		try {
			List<RDCOrganizationUserAccess> rdcorganizationuseraccesses = rdcOrganizationUserAccessPersistence.findByOrganizationId(organizationId);
			if(rdcorganizationuseraccesses != null) {
				return rdcorganizationuseraccesses.size();
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}