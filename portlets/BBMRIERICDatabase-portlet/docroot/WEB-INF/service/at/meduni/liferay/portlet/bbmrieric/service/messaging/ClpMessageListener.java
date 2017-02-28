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

package at.meduni.liferay.portlet.bbmrieric.service.messaging;

import at.meduni.liferay.portlet.bbmrieric.service.BioBankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.ClpSerializer;
import at.meduni.liferay.portlet.bbmrieric.service.ContactInformationLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLinkLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2CollectionServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.DiseaseDiscriptionLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.SearchIndexLocalServiceUtil;

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
			BioBankLocalServiceUtil.clearService();

			ContactInformationLocalServiceUtil.clearService();

			D2BiobankLocalServiceUtil.clearService();

			D2BiobankServiceUtil.clearService();
			D2BiobankNetworkLocalServiceUtil.clearService();

			D2BiobankNetworkLinkLocalServiceUtil.clearService();

			D2CollectionLocalServiceUtil.clearService();

			D2CollectionServiceUtil.clearService();
			DiseaseDiscriptionLocalServiceUtil.clearService();

			SearchIndexLocalServiceUtil.clearService();
		}
	}
}