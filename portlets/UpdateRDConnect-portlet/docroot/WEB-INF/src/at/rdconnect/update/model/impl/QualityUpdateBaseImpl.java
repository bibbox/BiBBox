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

package at.rdconnect.update.model.impl;

import at.rdconnect.update.model.QualityUpdate;
import at.rdconnect.update.service.QualityUpdateLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the QualityUpdate service. Represents a row in the &quot;rdconnect.u_quality&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QualityUpdateImpl}.
 * </p>
 *
 * @author reihsr
 * @see QualityUpdateImpl
 * @see at.rdconnect.update.model.QualityUpdate
 * @generated
 */
public abstract class QualityUpdateBaseImpl extends QualityUpdateModelImpl
	implements QualityUpdate {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a quality update model instance should use the {@link QualityUpdate} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			QualityUpdateLocalServiceUtil.addQualityUpdate(this);
		}
		else {
			QualityUpdateLocalServiceUtil.updateQualityUpdate(this);
		}
	}
}