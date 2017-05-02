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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.DDLConfigurationImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.base.DDLConfigurationLocalServiceBaseImpl;

/**
 * The implementation of the d d l configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.base.DDLConfigurationLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalServiceUtil
 */
public class DDLConfigurationLocalServiceImpl
	extends DDLConfigurationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalServiceUtil} to access the d d l configuration local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 */
	public DDLConfiguration getDDLConfigurationForField(long ddmstructureId, String fieldname) {
		try {
			return ddlConfigurationPersistence.findByFieldOptions(ddmstructureId, fieldname);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxCommonServicesDatabase-portlet::at.graz.meduni.liferay.portlet.bibbox.service.impl.DDLConfigurationLocalServiceImpl::getDDLConfigurationForField] Could not find DDLConfigurationForField (" + ddmstructureId + ", " + fieldname + ").");
		}
		
		try {
			DDLConfiguration new_ddlconfiguration = createDDLConfiguration();
			new_ddlconfiguration.setDdmstructureId(ddmstructureId);
			new_ddlconfiguration.setFieldname(fieldname);
			DDLConfigurationLocalServiceUtil.addDDLConfiguration(new_ddlconfiguration);
			return new_ddlconfiguration;
		} catch (SystemException e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServicesDatabase-portlet::at.graz.meduni.liferay.portlet.bibbox.service.impl.DDLConfigurationLocalServiceImpl::getDDLConfigurationForField] Could not create DDLConfiguration with ddmstructureId: " + ddmstructureId + " and fieldname: " + fieldname + ".");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public DDLConfiguration createDDLConfiguration() {
		try {
			DDLConfigurationImpl ddlconfiguration = new DDLConfigurationImpl();
			ddlconfiguration.setDdlconfigurationId(CounterLocalServiceUtil.increment());
			return ddlconfiguration;
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServicesDatabase-portlet::at.graz.meduni.liferay.portlet.bibbox.service.impl.DDLConfigurationLocalServiceImpl::createDDLConfiguration] Error creating DDLConfiguration.");
			ex.printStackTrace();
		}
		return null;
	}
}