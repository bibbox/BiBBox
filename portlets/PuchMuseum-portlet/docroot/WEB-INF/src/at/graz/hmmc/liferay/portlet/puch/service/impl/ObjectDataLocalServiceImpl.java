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

package at.graz.hmmc.liferay.portlet.puch.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import at.graz.hmmc.liferay.portlet.puch.model.ObjectData;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataImpl;
import at.graz.hmmc.liferay.portlet.puch.service.base.ObjectDataLocalServiceBaseImpl;

/**
 * The implementation of the object data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.hmmc.liferay.portlet.puch.service.ObjectDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.hmmc.liferay.portlet.puch.service.base.ObjectDataLocalServiceBaseImpl
 * @see at.graz.hmmc.liferay.portlet.puch.service.ObjectDataLocalServiceUtil
 */
public class ObjectDataLocalServiceImpl extends ObjectDataLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.hmmc.liferay.portlet.puch.service.ObjectDataLocalServiceUtil} to access the object data local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public ObjectData objectDataFromRequest(ActionRequest request) {
		try {
			ObjectDataImpl objectdata = new ObjectDataImpl();
			long objectdataId = ParamUtil.getLong(request, "objectdataId");
			if(objectdataId == 0) {
				objectdata.setObjectdataId(CounterLocalServiceUtil.increment(ObjectData.class.getName()));
			} else {
				objectdata.setObjectdataId(objectdataId);
			}
			objectdata.setPuchmuseumsobjectId(ParamUtil.getLong(request, "puchmuseumsobjectId"));
			objectdata.setObjectkey(ParamUtil.getString(request, "objectkey"));
			objectdata.setObjectvalue(ParamUtil.getString(request, "objectvalue"));
			return objectdata;
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ObjectDataLocalServiceImpl::objectDataFromRequest] Error creating ObjectData.");
			ex.printStackTrace();
		}
		return null;
	}
	
	public ObjectData addObjectData(long puchmuseumsobjectId, String objectkey, String objectvalue) {
		try {
			ObjectDataImpl objectdata = new ObjectDataImpl();
			objectdata.setObjectdataId(CounterLocalServiceUtil.increment(ObjectData.class.getName()));
			objectdata.setPuchmuseumsobjectId(puchmuseumsobjectId);
			objectdata.setObjectkey(objectkey);
			objectdata.setObjectvalue(objectvalue);
			return objectdata;
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ObjectDataLocalServiceImpl::addObjectData] Error creating new Object (" + puchmuseumsobjectId + ", " + objectkey + ", " + objectvalue + ").");
			ex.printStackTrace();
		}
		return null;
	}
	
	public ObjectData getObjectDataForObject(long puchmuseumsobjectId, String objectkey) {
		try {
			return objectDataPersistence.findByDataByOntology(puchmuseumsobjectId, objectkey);
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ObjectDataLocalServiceImpl::getObjectDataForObject] No ObjectData exist for (" + puchmuseumsobjectId + ", " + objectkey + ").");
		}
		return null;
	}
}