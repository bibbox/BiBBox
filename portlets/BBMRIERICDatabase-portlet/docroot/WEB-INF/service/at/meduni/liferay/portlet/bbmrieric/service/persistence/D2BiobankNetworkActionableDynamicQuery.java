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

package at.meduni.liferay.portlet.bbmrieric.service.persistence;

import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author reihsr
 * @generated
 */
public abstract class D2BiobankNetworkActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public D2BiobankNetworkActionableDynamicQuery() throws SystemException {
		setBaseLocalService(D2BiobankNetworkLocalServiceUtil.getService());
		setClass(D2BiobankNetwork.class);

		setClassLoader(at.meduni.liferay.portlet.bbmrieric.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("d2biobanknetworkId");
	}
}