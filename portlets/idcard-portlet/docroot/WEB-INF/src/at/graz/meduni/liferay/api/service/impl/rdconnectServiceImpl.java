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

package at.graz.meduni.liferay.api.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import at.graz.meduni.liferay.api.model.rdconnect;
import at.graz.meduni.liferay.api.service.rdconnectLocalServiceUtil;
import at.graz.meduni.liferay.api.service.base.rdconnectServiceBaseImpl;

/**
 * The implementation of the rdconnect remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.api.service.rdconnectService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.api.service.base.rdconnectServiceBaseImpl
 * @see at.graz.meduni.liferay.api.service.rdconnectServiceUtil
 */
public class rdconnectServiceImpl extends rdconnectServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.api.service.rdconnectServiceUtil} to access the rdconnect remote service.
	 */
	public rdconnect getRdconnect() throws PortalException, SystemException {
		return rdconnectLocalServiceUtil.getrdconnect(1);
	}
	
	public JSONObject regbbs() {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("xyz", "12345");
		return json;
	}
}