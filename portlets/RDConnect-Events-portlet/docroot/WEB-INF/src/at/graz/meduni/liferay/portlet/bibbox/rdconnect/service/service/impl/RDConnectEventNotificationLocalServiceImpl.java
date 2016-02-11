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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException;
import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification;
import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.base.RDConnectEventNotificationLocalServiceBaseImpl;

/**
 * The implementation of the r d connect event notification local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventNotificationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.base.RDConnectEventNotificationLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventNotificationLocalServiceUtil
 */
public class RDConnectEventNotificationLocalServiceImpl
	extends RDConnectEventNotificationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventNotificationLocalServiceUtil} to access the r d connect event notification local service.
	 */
	
	public List<RDConnectEventNotification> getRDConnectEventNotificationForUser(long userId) {
		return null;
	}
	
	public boolean isEventNotificationSetForUser(long userId, String notificationtype) {
		boolean return_value = false;
		try {
			RDConnectEventNotification notification = rdConnectEventNotificationPersistence.findByEventNotificationForUser(notificationtype, userId);
			return_value = notification.getNotificationselected();
		} catch (NoSuchRDConnectEventNotificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return return_value;
	}
	
	public RDConnectEventNotification updateRDConnectEventNotification(long eventnotificationId, long userId, String notificationtype) {
		if(eventnotificationId == 0) {
			addRDConnectEventNotification();
		} else {
			
		}
		return null;
	}
	
	private RDConnectEventNotification addRDConnectEventNotification() {
		return null;
	}
}