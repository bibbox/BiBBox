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

package at.graz.meduni.liferay.service.persistence;

import at.graz.meduni.liferay.model.Dictionary;
import at.graz.meduni.liferay.service.DictionaryLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author reihsr
 * @generated
 */
public abstract class DictionaryActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public DictionaryActionableDynamicQuery() throws SystemException {
		setBaseLocalService(DictionaryLocalServiceUtil.getService());
		setClass(Dictionary.class);

		setClassLoader(at.graz.meduni.liferay.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("dictionary_id");
	}
}