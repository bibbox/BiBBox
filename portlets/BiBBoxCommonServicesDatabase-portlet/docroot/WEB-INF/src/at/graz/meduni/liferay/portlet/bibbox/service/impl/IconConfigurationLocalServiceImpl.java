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

package at.graz.meduni.liferay.portlet.bibbox.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.service.base.IconConfigurationLocalServiceBaseImpl;

/**
 * The implementation of the icon configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.base.IconConfigurationLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalServiceUtil
 */
public class IconConfigurationLocalServiceImpl
	extends IconConfigurationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalServiceUtil} to access the icon configuration local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @return
	 */
	public List<IconConfiguration> getIconsForPosition(long symbolconfigurationId, String position) {
		try {
			return iconConfigurationPersistence.findByIconsPosition(symbolconfigurationId, position);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServicesDatabase-portlet::at.graz.meduni.liferay.portlet.bibbox.service.impl.IconConfigurationLocalServiceImpl::getIconsForPosition] Info no IconConfigurations found for search: (" + symbolconfigurationId + ", " + position + ".");
		}
		return null; 
	}
	
	/**
	 * 
	 * @return
	 */
	public List<IconConfiguration> getIconsForKey(long symbolconfigurationId, String key) {
		try {
			return iconConfigurationPersistence.findByIconsKey(symbolconfigurationId, key);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServicesDatabase-portlet::at.graz.meduni.liferay.portlet.bibbox.service.impl.IconConfigurationLocalServiceImpl::getIconsForKey] Info no IconConfigurations found for search: (" + symbolconfigurationId + ", " + key + ".");
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public IconConfiguration getIconsForKeyPosition(long symbolconfigurationId, String key, String position) {
		try {
			return iconConfigurationPersistence.findByIconsKeyPosition(symbolconfigurationId, key, position);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServicesDatabase-portlet::at.graz.meduni.liferay.portlet.bibbox.service.impl.IconConfigurationLocalServiceImpl::getIconsForKeyPosition] Info no IconConfigurations found for search: (" + symbolconfigurationId + ", " + key + ", " + position + ".");
		}
		return null; 
	}
}