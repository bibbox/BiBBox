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

package at.graz.meduni.liferay.portlet.saat.service.persistence;

import at.graz.meduni.liferay.portlet.saat.model.ICDO3;
import at.graz.meduni.liferay.portlet.saat.service.ICDO3LocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author reihsr
 * @generated
 */
public abstract class ICDO3ActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ICDO3ActionableDynamicQuery() throws SystemException {
		setBaseLocalService(ICDO3LocalServiceUtil.getService());
		setClass(ICDO3.class);

		setClassLoader(at.graz.meduni.liferay.portlet.saat.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("icdo3Id");
	}
}