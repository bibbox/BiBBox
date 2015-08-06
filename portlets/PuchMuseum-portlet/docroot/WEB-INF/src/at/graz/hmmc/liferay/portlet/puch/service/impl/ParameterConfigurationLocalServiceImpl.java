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

import javax.portlet.ActionRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterConfigurationImpl;
import at.graz.hmmc.liferay.portlet.puch.service.base.ParameterConfigurationLocalServiceBaseImpl;

/**
 * The implementation of the parameter configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.hmmc.liferay.portlet.puch.service.base.ParameterConfigurationLocalServiceBaseImpl
 * @see at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalServiceUtil
 */
public class ParameterConfigurationLocalServiceImpl
	extends ParameterConfigurationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalServiceUtil} to access the parameter configuration local service.
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
	public ParameterConfiguration parameterConfigurationFromRequest(ActionRequest request) {
		try {
			ParameterConfigurationImpl configuration = new ParameterConfigurationImpl();
			long parameterconfigurationId = ParamUtil.getLong(request, "parameterconfigurationId");
			if(parameterconfigurationId == 0) {
				configuration.setParameterconfigurationId(CounterLocalServiceUtil.increment(ParameterConfiguration.class.getName()));
			} else {
				configuration.setParameterconfigurationId(parameterconfigurationId);
			}
			configuration.setDisplaynameshort(ParamUtil.getString(request, "displaynameshort"));
			configuration.setDisplaynamelong(ParamUtil.getString(request, "displaynamelong"));
			configuration.setDatatype(ParamUtil.getString(request, "datatype"));
			configuration.setGroup(ParamUtil.getString(request, "group"));
			configuration.setTab(ParamUtil.getString(request, "tab"));
			configuration.setSummery(ParamUtil.getBoolean(request, "summery"));
			
			configuration.setViewscript(ParamUtil.getString(request, "viewscript"));
			configuration.setViewvisible(ParamUtil.getBoolean(request, "viewvisible"));
			configuration.setViewtip(ParamUtil.getString(request, "viewtip"));
			configuration.setViewtitlecss(ParamUtil.getString(request, "viewtitlecss"));
			configuration.setViewvaluecss(ParamUtil.getString(request, "viewvaluecss"));
			configuration.setViewcss(ParamUtil.getString(request, "viewcss"));
			
			configuration.setEditscript(ParamUtil.getString(request, "editscript"));
			configuration.setEditvisible(ParamUtil.getBoolean(request, "editvisible"));
			configuration.setEdittip(ParamUtil.getString(request, "edittip"));
			configuration.setEdittitlecss(ParamUtil.getString(request, "edittitlecss"));
			configuration.setEdittitlecss(ParamUtil.getString(request, "edittitlecss"));
			configuration.setEditvaluecss(ParamUtil.getString(request, "editvaluecss"));
			configuration.setEditcss(ParamUtil.getString(request, "editcss"));
			configuration.setEditcolumnwidth(ParamUtil.getLong(request, "editcolumnwidth"));
			
			return configuration;
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ParameterConfigurationLocalServiceImpl::parameterConfigurationFromRequest] Error creating ParameterConfiguration.");
			ex.printStackTrace();
		}
		return null;
	}
}