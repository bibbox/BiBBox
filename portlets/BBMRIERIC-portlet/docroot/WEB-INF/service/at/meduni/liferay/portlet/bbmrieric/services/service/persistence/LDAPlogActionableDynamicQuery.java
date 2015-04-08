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

package at.meduni.liferay.portlet.bbmrieric.services.service.persistence;

import at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog;
import at.meduni.liferay.portlet.bbmrieric.services.service.LDAPlogLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author reihsr
 * @generated
 */
public abstract class LDAPlogActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public LDAPlogActionableDynamicQuery() throws SystemException {
		setBaseLocalService(LDAPlogLocalServiceUtil.getService());
		setClass(LDAPlog.class);

		setClassLoader(at.meduni.liferay.portlet.bbmrieric.services.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("ldaplogId");
	}
}