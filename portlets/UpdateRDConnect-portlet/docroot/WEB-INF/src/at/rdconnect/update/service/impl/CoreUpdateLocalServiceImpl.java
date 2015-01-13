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

package at.rdconnect.update.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import at.rdconnect.update.model.CoreUpdate;
import at.rdconnect.update.service.base.CoreUpdateLocalServiceBaseImpl;

/**
 * The implementation of the core update local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.rdconnect.update.service.CoreUpdateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.rdconnect.update.service.base.CoreUpdateLocalServiceBaseImpl
 * @see at.rdconnect.update.service.CoreUpdateLocalServiceUtil
 */
public class CoreUpdateLocalServiceImpl extends CoreUpdateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.rdconnect.update.service.CoreUpdateLocalServiceUtil} to access the core update local service.
	 */
	public List<CoreUpdate> getCoreUpdateByOrganization(long organizationid) throws SystemException {
		return coreUpdatePersistence.findByOrganizationId(organizationid);
	}
}