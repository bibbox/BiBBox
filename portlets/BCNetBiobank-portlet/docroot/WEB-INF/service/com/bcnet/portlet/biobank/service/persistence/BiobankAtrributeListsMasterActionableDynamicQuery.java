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

package com.bcnet.portlet.biobank.service.persistence;

import com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster;
import com.bcnet.portlet.biobank.service.BiobankAtrributeListsMasterLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author suyama
 * @generated
 */
public abstract class BiobankAtrributeListsMasterActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public BiobankAtrributeListsMasterActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(BiobankAtrributeListsMasterLocalServiceUtil.getService());
		setClass(BiobankAtrributeListsMaster.class);

		setClassLoader(com.bcnet.portlet.biobank.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("biobankAttributeListsMasterId");
	}
}