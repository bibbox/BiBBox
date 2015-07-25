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

import at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolTypeConfigurationImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.base.SymbolTypeConfigurationLocalServiceBaseImpl;

/**
 * The implementation of the symbol type configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.base.SymbolTypeConfigurationLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalServiceUtil
 */
public class SymbolTypeConfigurationLocalServiceImpl
	extends SymbolTypeConfigurationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalServiceUtil} to access the symbol type configuration local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 */
	public SymbolTypeConfiguration getSymbolTypeConfigurationBySymbolType(String symboltype) {
		try {
			return symbolTypeConfigurationPersistence.findByFieldSymbolType(symboltype);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [indo] [BiBBoxCommonServicesDatabase-portlet::at.graz.meduni.liferay.portlet.bibbox.service.impl.SymbolTypeConfigurationLocalServiceImpl::getSymbolTypeConfigurationBySymbolType] Info no SymbolTypeConfiguration found for search: (" + symboltype + ".");
		}
		return null; 
	}
	
	public SymbolTypeConfiguration symbolTypeConfigurationFromRequest(ActionRequest request) {
		try {
			SymbolTypeConfigurationImpl symboltypeconfiguration = new SymbolTypeConfigurationImpl();
			long symboltypeconfigurationId = ParamUtil.getLong(request, "symboltypeconfigurationId");
			if(symboltypeconfigurationId == 0) {
				symboltypeconfiguration.setSymboltypeconfigurationId(CounterLocalServiceUtil.increment(SymbolTypeConfiguration.class.getName()));
			} else {
				symboltypeconfiguration.setSymboltypeconfigurationId(symboltypeconfigurationId);
			}
			symboltypeconfiguration.setSymboltype(ParamUtil.getString(request, "symboltype"));
			symboltypeconfiguration.setTemplate(ParamUtil.getString(request, "template"));
			symboltypeconfiguration.setSymboliconconfiguration(ParamUtil.getString(request, "symboliconconfiguration"));
			return symboltypeconfiguration;
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServicesDatabase-portlet::at.graz.meduni.liferay.portlet.bibbox.service.impl.SymbolTypeConfigurationLocalServiceImpl::symbolTypeConfigurationFromRequest] Error creating SymbolTypeConfiguration from request.");
			ex.printStackTrace();
		}
		return null;
	}
}