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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import at.graz.hmmc.liferay.portlet.puch.model.Configuration;
import at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationImpl;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationImpl;
import at.graz.hmmc.liferay.portlet.puch.service.base.ParameterOptionsConfigurationLocalServiceBaseImpl;

/**
 * The implementation of the parameter options configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.hmmc.liferay.portlet.puch.service.ParameterOptionsConfigurationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.hmmc.liferay.portlet.puch.service.base.ParameterOptionsConfigurationLocalServiceBaseImpl
 * @see at.graz.hmmc.liferay.portlet.puch.service.ParameterOptionsConfigurationLocalServiceUtil
 */
public class ParameterOptionsConfigurationLocalServiceImpl
	extends ParameterOptionsConfigurationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.hmmc.liferay.portlet.puch.service.ParameterOptionsConfigurationLocalServiceUtil} to access the parameter options configuration local service.
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
	public ParameterOptionsConfiguration parameterOptionsConfigurationFromRequest(ActionRequest request) {
		try {
			ParameterOptionsConfigurationImpl configuration = new ParameterOptionsConfigurationImpl();
			long parameteroptionsconfigurationId = ParamUtil.getLong(request, "parameteroptionsconfigurationId");
			if(parameteroptionsconfigurationId == 0) {
				configuration.setParameteroptionsconfigurationId(CounterLocalServiceUtil.increment(ParameterOptionsConfiguration.class.getName()));
			} else {
				configuration.setParameteroptionsconfigurationId(parameteroptionsconfigurationId);
			}
			configuration.setParameterconfigurationId(ParamUtil.getLong(request, "parameterconfigurationId"));
			configuration.setOptionkey(ParamUtil.getString(request, "optionkey"));
			configuration.setOptionvalue(ParamUtil.getString(request, "optionvalue"));
			return configuration;
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ParameterOptionsConfigurationLocalServiceImpl::parameterOptionsConfigurationFromRequest] Error creating ParameterOptionsConfiguration.");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 */
	public List<ParameterOptionsConfiguration> getParameterOptionsConfigurationForParameterConfiguration(long parameterconfigurationId) {
		try {
			return parameterOptionsConfigurationPersistence.findByOptionsForParameter(parameterconfigurationId);
		} catch(Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ParameterOptionsConfigurationLocalServiceImpl::getParameterOptionsConfigurationForParameterConfiguration] Cound not find ParameterOptionsConfiguration for (" + parameterconfigurationId + ").");
		}
		return null;
	}
}