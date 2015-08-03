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

package at.graz.hmmc.liferay.portlet.puch.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;

import at.graz.hmmc.liferay.portlet.puch.model.Configuration;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationImpl;
import at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.base.ConfigurationLocalServiceBaseImpl;

/**
 * The implementation of the configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.hmmc.liferay.portlet.puch.service.base.ConfigurationLocalServiceBaseImpl
 * @see at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalServiceUtil
 */
public class ConfigurationLocalServiceImpl
	extends ConfigurationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalServiceUtil} to access the configuration local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public Configuration configurationFromRequest(ActionRequest request) {
		try {
			ConfigurationImpl configuration = new ConfigurationImpl();
			long configurationId = ParamUtil.getLong(request, "configurationId");
			if(configurationId == 0) {
				configuration.setConfigurationId(CounterLocalServiceUtil.increment(Configuration.class.getName()));
			} else {
				configuration.setConfigurationId(configurationId);
			}
			configuration.setScope(ParamUtil.getString(request, "scope"));
			configuration.setOptionkey(ParamUtil.getString(request, "optionkey"));
			configuration.setOptionvalue(ParamUtil.getString(request, "optionvalue"));
			return configuration;
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl::configurationFromRequest] Error creating Configuration.");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param scope
	 * @param value
	 * @return
	 */
	public Configuration getConfigurationOptionValue(String scope, String value) {
		try {
			return configurationPersistence.findByoptionsFinderValue(scope, value);
		} catch(Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl::getConfigurationOptionValue] Cound not find Configuration for (" + scope + ", " + value + ").");
		}
		return null;
	}
	
	/**
	 * 
	 * @param scope
	 * @param key
	 * @return
	 */
	public Configuration getConfigurationOption(String scope, String key) {
		try {
			return configurationPersistence.findByoptionFinder(scope, key);
		} catch(Exception ex) {
			System.out.println("Cound not find Configuration for Parameters (" + scope + " " + key + ")");
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl::getConfigurationOption] Cound not find Configuration for (" + scope + ", " + key + ").");
		}
		return null;
	}
	
	/**
	 * 
	 * @param scope
	 * @param key
	 * @return
	 */
	public List<Configuration> getConfigurationOptions(String scope, String key) {
		try {
			return configurationPersistence.findByoptionsFinderKey(scope, key);
		} catch(Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl::getConfigurationOptions] Cound not find Configuration for (" + scope + ", " + key + ").");
		}
		return null;
	}
	
	/**
	 * 
	 * @param scope
	 * @return
	 */
	public List<Configuration> getConfigurationOptions(String scope) {
		try {
			return configurationPersistence.findByoptionsFinder(scope);
		} catch(Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl::getConfigurationOptions] Cound not find Configuration for (" + scope + ").");
		}
		return null;
	}
	
	/**
	 * 
	 * @param scope
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Configuration> getConfigurationOptions(String scope, int start, int end) {
		try {
			return configurationPersistence.findByoptionsFinder(scope, start, end);
		} catch(Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl::getConfigurationOptions] Cound not find Configuration for (" + scope + ").");
		}
		return null;
	}
	
	/**
	 * 
	 * @param scope
	 * @return
	 */
	public int getConfigurationOptionsCount(String scope) {
		try {
			return configurationPersistence.findByoptionsFinder(scope).size();
		} catch(Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl::getConfigurationOptionsCount] Cound not find Configuration for (" + scope + ").");
		}
		return 0;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public List<Configuration> getConfigurationOptionsForKey(String key) {
		try {
			return configurationPersistence.findByOptionsFinderForKey(key);
		} catch(Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl::getConfigurationOptionsForKey] Cound not find Configuration for (" + key + ").");
		}
		return null;
	}
	
	/**
	 * 
	 * @param scope
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Configuration> getConfigurationOptionsForKey(String key, int start, int end) {
		try {
			return configurationPersistence.findByOptionsFinderForKey(key, start, end);
		} catch(Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl::getConfigurationOptionsForKey] Cound not find Configuration for (" + key + ").");
		}
		return null;
	}
	
	/**
	 * 
	 * @param scope
	 * @return
	 */
	public int getConfigurationOptionsForKeyCount(String key) {
		try {
			return configurationPersistence.findByOptionsFinderForKey(key).size();
		} catch(Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl::getConfigurationOptionsForKeyCount] Cound not find Configuration for (" + key + ").");
		}
		return 0;
	}
}