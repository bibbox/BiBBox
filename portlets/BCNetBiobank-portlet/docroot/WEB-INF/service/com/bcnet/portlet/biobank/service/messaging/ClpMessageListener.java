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

package com.bcnet.portlet.biobank.service.messaging;

import com.bcnet.portlet.biobank.service.BiobankAtrributeListsMasterLocalServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankAtrributeListsMasterServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankAttributeListsServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankContactLocalServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankContactServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankGeneralInformationServiceUtil;
import com.bcnet.portlet.biobank.service.ClpSerializer;
import com.bcnet.portlet.biobank.service.ContactLocalServiceUtil;
import com.bcnet.portlet.biobank.service.ContactServiceUtil;
import com.bcnet.portlet.biobank.service.CountryLocalServiceUtil;
import com.bcnet.portlet.biobank.service.CountryServiceUtil;
import com.bcnet.portlet.biobank.service.JuristicPersonLocalServiceUtil;
import com.bcnet.portlet.biobank.service.JuristicPersonServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author suyama
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
			BiobankAtrributeListsMasterLocalServiceUtil.clearService();

			BiobankAtrributeListsMasterServiceUtil.clearService();
			BiobankAttributeListsLocalServiceUtil.clearService();

			BiobankAttributeListsServiceUtil.clearService();
			BiobankContactLocalServiceUtil.clearService();

			BiobankContactServiceUtil.clearService();
			BiobankGeneralInformationLocalServiceUtil.clearService();

			BiobankGeneralInformationServiceUtil.clearService();
			ContactLocalServiceUtil.clearService();

			ContactServiceUtil.clearService();
			CountryLocalServiceUtil.clearService();

			CountryServiceUtil.clearService();
			JuristicPersonLocalServiceUtil.clearService();

			JuristicPersonServiceUtil.clearService();
		}
	}
}