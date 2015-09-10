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
import java.util.List;

import at.graz.hmmc.liferay.portlet.puch.model.Configuration;
import at.graz.hmmc.liferay.portlet.puch.model.ObjectData;
import at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration;
import at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.ObjectDataLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalServiceUtil;

/**
 * The extended model implementation for the PuchMuseumsObjekt service. Represents a row in the &quot;puchmuseum.puchmuseumsobjekt&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt} interface.
 * </p>
 *
 * @author reihsr
 */
public class PuchMuseumsObjektImpl extends PuchMuseumsObjektBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a puch museums objekt model instance should use the {@link at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt} interface instead.
	 */
	public PuchMuseumsObjektImpl() {
	}
	
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	public String getHTMLSummery() {
		String returnvalue = "";
		try {
			List<Configuration> configurations = ConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", this.getObjekttyp());
			for(Configuration configuration : configurations) {
				ParameterConfiguration parameterconfig = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(Long.parseLong(configuration.getOptionvalue()));
				if(parameterconfig.getSummery()) {
					ObjectData objectdata = ObjectDataLocalServiceUtil.getObjectDataForObject(this.getPuchmuseumsobjectId(), String.valueOf(parameterconfig.getParameterconfigurationId()));
					if(!returnvalue.equalsIgnoreCase("")) {
						returnvalue += "<br>";
					}
					returnvalue += objectdata.formatValueHTML();
				}
			}
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.model.impl.PuchMuseumsObjektImpl::getHTMLSummery] Error getting Summery for Object.");
			ex.printStackTrace();
		}
		return returnvalue;
	}
}