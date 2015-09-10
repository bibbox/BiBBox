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

package at.graz.hmmc.liferay.portlet.puch.model.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration;
import at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalServiceUtil;

/**
 * The extended model implementation for the TransaktionData service. Represents a row in the &quot;puchmuseum.transaktiondata&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.hmmc.liferay.portlet.puch.model.TransaktionData} interface.
 * </p>
 *
 * @author reihsr
 */
public class TransaktionDataImpl extends TransaktionDataBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a transaktion data model instance should use the {@link at.graz.hmmc.liferay.portlet.puch.model.TransaktionData} interface instead.
	 */
	public TransaktionDataImpl() {
	}
	
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	public String formatValueHTML() {
		try {
			ParameterConfiguration parameterconfig = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(Long.parseLong(this.getObjectkey()));
			ScriptEngineManager manager = new ScriptEngineManager();
		    ScriptEngine engine = manager.getEngineByName("javascript");
		    engine.put("optionvalue", this.getObjectvalue());
		    if(parameterconfig.getViewscript().equalsIgnoreCase("")) {
		    	return this.getObjectvalue();
		    }
		    engine.eval(parameterconfig.getViewscript());
		    String formatedstring = (String) engine.get("output");
		    return formatedstring;
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataImpl::formatValueHTML] Error formating TransaktionData Value.");
			ex.printStackTrace();
		}
		return this.getObjectvalue();
	}
}