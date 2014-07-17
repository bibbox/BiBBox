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

package at.meduni.graz.patho.haybaeck.service.persistence;

import at.meduni.graz.patho.haybaeck.model.TMA;
import at.meduni.graz.patho.haybaeck.service.TMALocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author reihsr
 * @generated
 */
public abstract class TMAActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public TMAActionableDynamicQuery() throws SystemException {
		setBaseLocalService(TMALocalServiceUtil.getService());
		setClass(TMA.class);

		setClassLoader(at.meduni.graz.patho.haybaeck.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("tma_Id");
	}
}