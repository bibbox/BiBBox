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

package at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.SystemException;

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventImpl;
import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.base.RDConnectEventLocalServiceBaseImpl;

/**
 * The implementation of the r d connect event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.base.RDConnectEventLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventLocalServiceUtil
 */
public class RDConnectEventLocalServiceImpl
	extends RDConnectEventLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventLocalServiceUtil} to access the r d connect event local service.
	 */
	public void createEvent(Date eventdate, long organizationId, long userId, String shorttext, String longtext, String link, String restricted) {
		RDConnectEventImpl rdconnectevent = new RDConnectEventImpl();
		rdconnectevent.setEventdate(eventdate);
		rdconnectevent.setOrganizationId(organizationId);
		rdconnectevent.setUserId(userId);
		rdconnectevent.setShorttext(shorttext);
		rdconnectevent.setLongtext(longtext);
		rdconnectevent.setLink(link);
		rdconnectevent.setRestricted(restricted);
		try {
			RDConnectEventLocalServiceUtil.addRDConnectEvent(rdconnectevent);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}