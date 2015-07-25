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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base.KdssmpConfigurationLocalServiceBaseImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration;

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
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @param scope
	 * @param key
	 * @return
	 * @throws NoSuchKdssmpConfigurationException
	 * @throws SystemException 
	 */
	public KdssmpConfiguration getConfigurationOption(String scope, String key) throws NoSuchKdssmpConfigurationException, SystemException {
		try {
			return kdssmpConfigurationPersistence.findByoptionfinder(scope, key);
		} catch(Exception ex) {
			System.out.println("Cound not find Configuration for Parameters (" + scope + " " + key + ")");
		}
		return null;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public KdssmpConfiguration symbolKdssmpConfigurationFromRequest(ActionRequest request) {
		try {
			KdssmpConfigurationImpl kdssmpconfiguration = new KdssmpConfigurationImpl();
			long configurationId = ParamUtil.getLong(request, "configurationId");
			if(configurationId == 0) {
				kdssmpconfiguration.setConfigurationId(CounterLocalServiceUtil.increment(KdssmpConfiguration.class.getName()));
			} else {
				kdssmpconfiguration.setConfigurationId(configurationId);
			}
			System.out.println(kdssmpconfiguration.getConfigurationId() + " - " + ParamUtil.getString(request, "scope") + " - " + ParamUtil.getString(request, "optionkey") + " - " + ParamUtil.getString(request, "optionvalue"));
			kdssmpconfiguration.setScope(ParamUtil.getString(request, "scope"));
			kdssmpconfiguration.setOptionkey(ParamUtil.getString(request, "optionkey"));
			kdssmpconfiguration.setOptionvalue(ParamUtil.getString(request, "optionvalue"));
			return kdssmpconfiguration;
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxKDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.impl.KdssmpConfigurationLocalServiceImpl::symbolKdssmpConfigurationFromRequest] Error creating KDSSMPConfiguration.");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param scope
	 * @param value
	 * @return
	 * @throws NoSuchKdssmpConfigurationException
	 * @throws SystemException
	 */
	public KdssmpConfiguration getConfigurationOptionValue(String scope, String value) throws NoSuchKdssmpConfigurationException, SystemException {
		return kdssmpConfigurationPersistence.findByoptionsfindervalue(scope, value);
	}
	
	/**
	 * 
	 * @param scope
	 * @param key
	 * @return
	 * @throws NoSuchKdssmpConfigurationException
	 * @throws SystemException
	 */
	public List<KdssmpConfiguration> getConfigurationOptions(String scope, String key) throws NoSuchKdssmpConfigurationException, SystemException {
		return kdssmpConfigurationPersistence.findByoptionsfinderkey(scope, key);
	}
	
	/**
	 * 
	 * @param scope
	 * @return
	 * @throws NoSuchKdssmpConfigurationException
	 * @throws SystemException
	 */
	public List<KdssmpConfiguration> getConfigurationOptions(String scope) throws NoSuchKdssmpConfigurationException, SystemException {
		return kdssmpConfigurationPersistence.findByoptionsfinder(scope);
	}
}