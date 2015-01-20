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

package at.rdconnect.update.service.messaging;

import at.rdconnect.update.service.AccessibilityUpdateLocalServiceUtil;
import at.rdconnect.update.service.AccessibilityUpdateServiceUtil;
import at.rdconnect.update.service.AddressUpdateLocalServiceUtil;
import at.rdconnect.update.service.AddressUpdateServiceUtil;
import at.rdconnect.update.service.ClpSerializer;
import at.rdconnect.update.service.CoreUpdateLocalServiceUtil;
import at.rdconnect.update.service.CoreUpdateServiceUtil;
import at.rdconnect.update.service.QualityUpdateLocalServiceUtil;
import at.rdconnect.update.service.QualityUpdateServiceUtil;

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
			AccessibilityUpdateLocalServiceUtil.clearService();

			AccessibilityUpdateServiceUtil.clearService();
			AddressUpdateLocalServiceUtil.clearService();

			AddressUpdateServiceUtil.clearService();
			CoreUpdateLocalServiceUtil.clearService();

			CoreUpdateServiceUtil.clearService();
			QualityUpdateLocalServiceUtil.clearService();

			QualityUpdateServiceUtil.clearService();
		}
	}
}