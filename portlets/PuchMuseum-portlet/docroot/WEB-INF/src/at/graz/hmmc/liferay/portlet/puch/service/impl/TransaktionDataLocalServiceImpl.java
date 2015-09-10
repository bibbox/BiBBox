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

import at.graz.hmmc.liferay.portlet.puch.model.TransaktionData;
import at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataImpl;
import at.graz.hmmc.liferay.portlet.puch.service.base.TransaktionDataLocalServiceBaseImpl;

/**
 * The implementation of the transaktion data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.hmmc.liferay.portlet.puch.service.TransaktionDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.hmmc.liferay.portlet.puch.service.base.TransaktionDataLocalServiceBaseImpl
 * @see at.graz.hmmc.liferay.portlet.puch.service.TransaktionDataLocalServiceUtil
 */
public class TransaktionDataLocalServiceImpl
	extends TransaktionDataLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.hmmc.liferay.portlet.puch.service.TransaktionDataLocalServiceUtil} to access the transaktion data local service.
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
	public TransaktionData transaktionDataFromRequest(ActionRequest request) {
		try {
			TransaktionDataImpl transaktiondata = new TransaktionDataImpl();
			long transaktiondataId = ParamUtil.getLong(request, "transaktiondataId");
			if(transaktiondataId == 0) {
				transaktiondata.setTransaktiondataId(CounterLocalServiceUtil.increment(TransaktionData.class.getName()));
			} else {
				transaktiondata.setTransaktiondataId(transaktiondataId);
			}
			transaktiondata.setTransaktionId(ParamUtil.getLong(request, "transaktionId"));
			transaktiondata.setPuchmuseumsobjectId(ParamUtil.getLong(request, "puchmuseumsobjectId"));
			transaktiondata.setObjectkey(ParamUtil.getString(request, "objectkey"));
			transaktiondata.setObjectvalue(ParamUtil.getString(request, "objectvalue"));
			return transaktiondata;
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.TransaktionDataLocalServiceImpl::transaktionDataFromRequest] Error creating TransaktionData.");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param transaktionId
	 * @param puchmuseumsobjectId
	 * @param objectkey
	 * @param objectvalue
	 * @return
	 */
	public TransaktionData addTransaktionData(long transaktionId, long puchmuseumsobjectId, String objectkey, String objectvalue) {
		try {
			TransaktionDataImpl transaktiondata = new TransaktionDataImpl();
			transaktiondata.setTransaktiondataId(CounterLocalServiceUtil.increment(TransaktionData.class.getName()));
			transaktiondata.setTransaktionId(transaktionId);
			transaktiondata.setPuchmuseumsobjectId(puchmuseumsobjectId);
			transaktiondata.setObjectkey(objectkey);
			transaktiondata.setObjectvalue(objectvalue);
			return transaktiondata;
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.TransaktionDataLocalServiceImpl::addTransaktionData] Error creating new Object (" + transaktionId + ", " + puchmuseumsobjectId + ", " + objectkey + ", " + objectvalue + ").");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param transaktionId
	 * @param objectkey
	 * @return
	 */
	public TransaktionData getTransaktionDataForObject(long transaktionId, String objectkey) {
		try {
			return transaktionDataPersistence.findByDataByOntology(transaktionId, objectkey);
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.TransaktionDataLocalServiceImpl::getTransaktionDataForObject] No ObjectData exist for (" + transaktionId + ", " + objectkey + ").");
		}
		return null;
	}
}