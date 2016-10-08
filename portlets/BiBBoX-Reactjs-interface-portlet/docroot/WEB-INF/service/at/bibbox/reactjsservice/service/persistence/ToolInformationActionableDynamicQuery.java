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

package at.bibbox.reactjsservice.service.persistence;

import at.bibbox.reactjsservice.model.ToolInformation;
import at.bibbox.reactjsservice.service.ToolInformationLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author reihsr
 * @generated
 */
public abstract class ToolInformationActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ToolInformationActionableDynamicQuery() throws SystemException {
		setBaseLocalService(ToolInformationLocalServiceUtil.getService());
		setClass(ToolInformation.class);

		setClassLoader(at.bibbox.reactjsservice.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("toolInformationId");
	}
}