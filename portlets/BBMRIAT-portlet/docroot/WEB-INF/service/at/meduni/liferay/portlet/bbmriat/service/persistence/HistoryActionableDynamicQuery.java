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

package at.meduni.liferay.portlet.bbmriat.service.persistence;

import at.meduni.liferay.portlet.bbmriat.model.History;
import at.meduni.liferay.portlet.bbmriat.service.HistoryLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Robert Reihs
 * @generated
 */
public abstract class HistoryActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public HistoryActionableDynamicQuery() throws SystemException {
		setBaseLocalService(HistoryLocalServiceUtil.getService());
		setClass(History.class);

		setClassLoader(at.meduni.liferay.portlet.bbmriat.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("historyId");
	}
}