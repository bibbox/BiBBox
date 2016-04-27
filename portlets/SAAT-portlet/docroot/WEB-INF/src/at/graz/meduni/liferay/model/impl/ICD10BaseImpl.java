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

package at.graz.meduni.liferay.model.impl;

import at.graz.meduni.liferay.model.ICD10;
import at.graz.meduni.liferay.service.ICD10LocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ICD10 service. Represents a row in the &quot;code_icd10&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ICD10Impl}.
 * </p>
 *
 * @author reihsr
 * @see ICD10Impl
 * @see at.graz.meduni.liferay.model.ICD10
 * @generated
 */
public abstract class ICD10BaseImpl extends ICD10ModelImpl implements ICD10 {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a i c d10 model instance should use the {@link ICD10} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ICD10LocalServiceUtil.addICD10(this);
		}
		else {
			ICD10LocalServiceUtil.updateICD10(this);
		}
	}
}