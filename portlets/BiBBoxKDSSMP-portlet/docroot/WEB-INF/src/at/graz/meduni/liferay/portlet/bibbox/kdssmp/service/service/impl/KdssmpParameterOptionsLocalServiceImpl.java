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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base.KdssmpParameterOptionsLocalServiceBaseImpl;

/**
 * The implementation of the kdssmp parameter options local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpParameterOptionsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base.KdssmpParameterOptionsLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpParameterOptionsLocalServiceUtil
 */
public class KdssmpParameterOptionsLocalServiceImpl
	extends KdssmpParameterOptionsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpParameterOptionsLocalServiceUtil} to access the kdssmp parameter options local service.
	 */
	public List<KdssmpParameterOptions> getOptions(long parameterconfigurationId) {
		try {
			return kdssmpParameterOptionsPersistence.findByOptions(parameterconfigurationId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}