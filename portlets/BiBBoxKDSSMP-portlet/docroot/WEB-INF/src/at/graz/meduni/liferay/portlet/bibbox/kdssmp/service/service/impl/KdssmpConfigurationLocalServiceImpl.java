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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base.KdssmpConfigurationLocalServiceBaseImpl;

/**
 * The implementation of the kdssmp configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpConfigurationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base.KdssmpConfigurationLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpConfigurationLocalServiceUtil
 */
public class KdssmpConfigurationLocalServiceImpl
	extends KdssmpConfigurationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpConfigurationLocalServiceUtil} to access the kdssmp configuration local service.
	 */
	public KdssmpConfiguration getConfigurationOption(String scope, String key) throws NoSuchKdssmpConfigurationException, SystemException {
		return kdssmpConfigurationPersistence.findByoptionfinder(scope, key);
	}
	
	public List<KdssmpConfiguration> getConfigurationOptions(String scope) throws NoSuchKdssmpConfigurationException, SystemException {
		return kdssmpConfigurationPersistence.findByoptionsfinder(scope);
	}
}