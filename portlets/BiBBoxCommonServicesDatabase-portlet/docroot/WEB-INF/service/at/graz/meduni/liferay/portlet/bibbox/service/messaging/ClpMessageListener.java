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

package at.graz.meduni.liferay.portlet.bibbox.service.messaging;

import at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author reihsr
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			DDLConfigurationLocalServiceUtil.clearService();

			DDLConfigurationServiceUtil.clearService();
			IconConfigurationLocalServiceUtil.clearService();

			IconConfigurationServiceUtil.clearService();
			SymbolConfigurationLocalServiceUtil.clearService();

			SymbolConfigurationServiceUtil.clearService();
			SymbolTypeConfigurationLocalServiceUtil.clearService();

			SymbolTypeConfigurationServiceUtil.clearService();
		}
	}
}