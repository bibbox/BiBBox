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
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import at.graz.hmmc.liferay.portlet.puch.model.ObjectImage;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectImageImpl;
import at.graz.hmmc.liferay.portlet.puch.service.base.ObjectImageLocalServiceBaseImpl;

/**
 * The implementation of the object image local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.hmmc.liferay.portlet.puch.service.ObjectImageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.hmmc.liferay.portlet.puch.service.base.ObjectImageLocalServiceBaseImpl
 * @see at.graz.hmmc.liferay.portlet.puch.service.ObjectImageLocalServiceUtil
 */
public class ObjectImageLocalServiceImpl extends ObjectImageLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.hmmc.liferay.portlet.puch.service.ObjectImageLocalServiceUtil} to access the object image local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @param puchmuseumsobjektId
	 * @return
	 */
	public List<ObjectImage> getObjectImagesByObject(long puchmuseumsobjektId) {
		try {
			return objectImagePersistence.findByObject(puchmuseumsobjektId);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.ObjectImageLocalServiceImpl::getObjectImagesByObject] Error get Images for Object " + puchmuseumsobjektId + ".");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param rowimageId
	 * @param processedimageId
	 * @param webimageId
	 * @param userId
	 * @param puchmuseumsobjectId
	 * @return
	 */
	public ObjectImage addObjectImage(long rowimageId, long processedimageId, long webimageId, long userId, long puchmuseumsobjectId) {
		try {
			ObjectImageImpl oibjectimage = new ObjectImageImpl();
			oibjectimage.setObjectimageId(CounterLocalServiceUtil.increment(ObjectImage.class.getName()));
			oibjectimage.setPuchmuseumsobjectId(puchmuseumsobjectId);
			// User Data
			oibjectimage.setCreaterUserId(userId);
			oibjectimage.setModifiedUserId(userId);
			oibjectimage.setCreateDate(new Date());
			oibjectimage.setModifiedDate(new Date());
			// Image Data
			oibjectimage.setDlappimagerawId(rowimageId);
			oibjectimage.setDlappimageprocessedId(processedimageId);
			oibjectimage.setDlappimagewebId(webimageId);
			return oibjectimage;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}