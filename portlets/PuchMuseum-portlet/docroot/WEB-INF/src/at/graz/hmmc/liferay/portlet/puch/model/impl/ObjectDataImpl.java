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

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

import at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration;
import at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalServiceUtil;

/**
 * The extended model implementation for the ObjectData service. Represents a row in the &quot;puchmuseum.objectdata&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.hmmc.liferay.portlet.puch.model.ObjectData} interface.
 * </p>
 *
 * @author reihsr
 */
public class ObjectDataImpl extends ObjectDataBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a object data model instance should use the {@link at.graz.hmmc.liferay.portlet.puch.model.ObjectData} interface instead.
	 */
	public ObjectDataImpl() {
	}
	
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	public String formatValueHTML() {
		try {
			String formatedstring = "";
			ParameterConfiguration parameterconfig = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(Long.parseLong(this.getObjectkey()));
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("javascript");
			engine.put("optionvalue", this.getObjectvalue());
			if(parameterconfig.getViewscript().equalsIgnoreCase("")) {
			  	return this.getObjectvalue();
			}
			engine.eval(parameterconfig.getViewscript());
			formatedstring = (String) engine.get("output");

		    return formatedstring;
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataImpl::formatValueHTML] Error formating ObjectData Value.");
			ex.printStackTrace();
		}
		return this.getObjectvalue();
	}
}