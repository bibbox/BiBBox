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

package at.graz.meduni.liferay.service.messaging;

import at.graz.meduni.liferay.service.ClpSerializer;
import at.graz.meduni.liferay.service.DictionaryDictionaryLinkLocalServiceUtil;
import at.graz.meduni.liferay.service.DictionaryDictionaryLinkServiceUtil;
import at.graz.meduni.liferay.service.DictionaryLocalServiceUtil;
import at.graz.meduni.liferay.service.DictionaryServiceUtil;
import at.graz.meduni.liferay.service.ICD10LocalServiceUtil;
import at.graz.meduni.liferay.service.ICD10ServiceUtil;
import at.graz.meduni.liferay.service.ICDO3LocalServiceUtil;
import at.graz.meduni.liferay.service.ICDO3ServiceUtil;
import at.graz.meduni.liferay.service.SCGLocalServiceUtil;
import at.graz.meduni.liferay.service.SCGServiceUtil;

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
			DictionaryLocalServiceUtil.clearService();

			DictionaryServiceUtil.clearService();
			DictionaryDictionaryLinkLocalServiceUtil.clearService();

			DictionaryDictionaryLinkServiceUtil.clearService();
			ICD10LocalServiceUtil.clearService();

			ICD10ServiceUtil.clearService();
			ICDO3LocalServiceUtil.clearService();

			ICDO3ServiceUtil.clearService();
			SCGLocalServiceUtil.clearService();

			SCGServiceUtil.clearService();
		}
	}
}