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

import at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration;
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
	/**
	 * 
	 */
	public String getSymbol(String scope, String eventtype, LinkedHashMap<String, String> icons) {
		String symbol = "";
		try {
			SymbolConfiguration symbolconfig = symbolConfigurationPersistence.findByFieldSymbol(scope, eventtype);
			SymbolTypeConfiguration symboltype = SymbolTypeConfigurationLocalServiceUtil.getSymbolTypeConfigurationBySymbolType(symbolconfig.getSymboltype());
			symbol = symboltype.getTemplate();
			
			// Substitution
			symbol = symbol.replaceAll("§basecoler§", symbolconfig.getBasecolor());
			symbol = symbol.replaceAll("§link§", getStringFromMap(icons, "link"));
			symbol = symbol.replaceAll("§date§", getStringFromMap(icons, "date"));
			
			symbol = symbol.replaceAll("§ASUMMETY§", getStringFromMap(icons, "ASUMMETY"));
			symbol = symbol.replaceAll("§ACODE§", getStringFromMap(icons, "ACODE"));
			
			symbol = replaceIconStrings(symbol, "A1", "A1", symbolconfig, icons);
			symbol = replaceIconStrings(symbol, "A2", "A2", symbolconfig, icons);
			
			if(getStringFromMap(icons, "A4").startsWith("TEXT:")) {
				symbol = symbol.replaceAll("§A4-1§", getStringFromMap(icons, "A4").replaceAll("TEXT:", ""));
			} else {
				int a4counter = 1;
				for(String a4 : getStringFromMap(icons, "A4").split("§")) {
					symbol = replaceIconStrings(symbol, "A4", "A4-" + a4counter, symbolconfig, icons);
				}
				a4counter ++;
			}
			
		} catch (Exception ex) {
			System.err.println("ERROR: getSymbol");
			ex.printStackTrace();
		}
		symbol = replaceRemainingPlacholders(symbol);
		return symbol;
	}
	
	private String replaceIconStrings(String symbol, String positionkey, String replacepositionkey, SymbolConfiguration symbolconfig, LinkedHashMap<String, String> icons) {
		IconConfiguration iconconfiguration = symbolconfig.getIconsForKeyPosition(getStringFromMap(icons, positionkey), positionkey);
		if(iconconfiguration != null) {
			symbol = symbol.replaceAll("§" + replacepositionkey + "§", iconconfiguration.getHTMLIcon());
			String a2elementcolor = iconconfiguration.getElementcolor();
			if(a2elementcolor.equalsIgnoreCase("")) {
				a2elementcolor = symbolconfig.getBasecolor();
			}
			symbol = symbol.replaceAll("§" + replacepositionkey + "ELEMENTCOLOR§", a2elementcolor);
		} else {
			System.out.println("iconconfiguration Null");
		}
		return symbol;
	}
	
	private String getStringFromMap(LinkedHashMap<String, String> icons, String key) {
		String returnvalue = "";
		if(icons.containsKey(key)) {
			returnvalue = icons.get(key);
		}
		return returnvalue;
	}
	
	private String replaceRemainingPlacholders(String template) {
		template = template.replaceAll("§link§", "");
		template = template.replaceAll("§date§", "");
		template = template.replaceAll("§basecoler§", "");
		template = template.replaceAll("§ACODE§", "");
		template = template.replaceAll("§ASUMMETY§", "");
		template = template.replaceAll("§A1§", "");
		template = template.replaceAll("§A2§", "");
		template = template.replaceAll("§A2ELEMENTCOLOR§", "");
		template = template.replaceAll("§A3§", "");
		template = template.replaceAll("§A4§", "");
		template = template.replaceAll("§A4-1§", "");
		template = template.replaceAll("§A4-2§", "");
		template = template.replaceAll("§A4-3§", "");
		template = template.replaceAll("§A4-4§", "");
		return template;
	}
}