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

import java.util.LinkedHashMap;

import at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.base.SymbolConfigurationLocalServiceBaseImpl;

/**
 * The implementation of the symbol configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.base.SymbolConfigurationLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalServiceUtil
 */
public class SymbolConfigurationLocalServiceImpl
	extends SymbolConfigurationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalServiceUtil} to access the symbol configuration local service.
	 */
	public String getSymbol(String scope, String eventtype, LinkedHashMap<String, String> icons) {
		String symbol = "";
		try {
			SymbolConfiguration symbolconfig = symbolConfigurationPersistence.findByFieldSymbol(scope, eventtype);
			SymbolTypeConfiguration symboltype = SymbolTypeConfigurationLocalServiceUtil.getSymbolTypeConfigurationBySymbolType(symbolconfig.getSymboltype());
			symbol = symboltype.getTemplate();
		} catch (Exception ex) {
			
		}
		return symbol;
	}
}