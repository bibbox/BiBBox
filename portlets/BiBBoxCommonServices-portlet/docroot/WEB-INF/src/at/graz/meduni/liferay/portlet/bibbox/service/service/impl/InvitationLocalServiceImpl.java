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

import java.util.Date;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.service.base.InvitationLocalServiceBaseImpl;

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
	public Invitation invitationFromRequest(PortletRequest request) {
		InvitationImpl invitation = new InvitationImpl();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		invitation.setInvitationId(ParamUtil.getLong(request, "invitationId"));
		invitation.setName(ParamUtil.getString(request, "name"));
		invitation.setSubject(ParamUtil.getString(request, "subject"));
		invitation.setBody(ParamUtil.getString(request, "body"));
		invitation.setStatus(ParamUtil.getLong(request, "status"));
		invitation.setLastchanged(new Date());
		invitation.setLastchanger(themeDisplay.getUserId());
		
		return invitation;
	}
	
	/**
	 * Return Status from String
	 * Status:
	 *  0 ... Error
	 *  1 ... Saved
	 *  5 ... Simulated
	 * 10 ... Send
	 */
	public long getStatusFromString(String string_status) {
		long status = 0;
		if(string_status.equalsIgnoreCase("saved")) {
			return 1;
		}
		if(string_status.equalsIgnoreCase("simulated")) {
			return 5;
		}
		if(string_status.equalsIgnoreCase("send")) {
			return 10;
		}
		return 0;
	}

}