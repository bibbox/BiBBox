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

package at.graz.meduni.liferay.portlet.bibbox.service.service.impl;

import javax.portlet.PortletRequest;

import at.graz.meduni.liferay.portlet.bibbox.service.service.base.InvitationLocalServiceBaseImpl;
import at.graz.meduni.liferay.portlet.bibbox.user.Invitation;

/**
 * The implementation of the invitation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.InvitationLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationLocalServiceUtil
 */
public class InvitationLocalServiceImpl extends InvitationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationLocalServiceUtil} to access the invitation local service.
	 */
	
	/**
	 * Convenience method to create a Invitation object out of the request.
	 */
	private Invitation invitationFromRequest(PortletRequest request) {
		return null;
	}
}