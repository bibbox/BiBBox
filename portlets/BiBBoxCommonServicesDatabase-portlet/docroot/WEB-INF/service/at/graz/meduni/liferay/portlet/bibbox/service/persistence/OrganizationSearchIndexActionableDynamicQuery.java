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

package at.graz.meduni.liferay.portlet.bibbox.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex;
import at.graz.meduni.liferay.portlet.bibbox.service.OrganizationSearchIndexLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author reihsr
 * @generated
 */
public abstract class OrganizationSearchIndexActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public OrganizationSearchIndexActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(OrganizationSearchIndexLocalServiceUtil.getService());
		setClass(OrganizationSearchIndex.class);

		setClassLoader(at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("searchid");
	}
}