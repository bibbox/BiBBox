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

import javax.portlet.ActionRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import at.graz.meduni.liferay.portlet.bibbox.model.Icons;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.IconsImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.base.IconsLocalServiceBaseImpl;

/**
 * The implementation of the icons local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.base.IconsLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalServiceUtil
 */
public class IconsLocalServiceImpl extends IconsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalServiceUtil} to access the icons local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	
	public Icons iconsFromRequest(ActionRequest request) {
		try {
			IconsImpl icon = new IconsImpl();
			long iconsId = ParamUtil.getLong(request, "iconsId");
			if(iconsId == 0) {
				icon.setIconsId(CounterLocalServiceUtil.increment(Icons.class.getName()));
			} else {
				icon.setIconsId(iconsId);
			}
			icon.setIconurl(ParamUtil.getString(request, "iconurl"));
			icon.setGroup(ParamUtil.getString(request, "group"));
			return icon;
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServicesDatabase-portlet::at.graz.meduni.liferay.portlet.bibbox.service.impl.IconsLocalServiceImpl::iconsFromRequest] Error updating KDSSMPConfiguration.");
			ex.printStackTrace();
		}
		return null;
	}
}