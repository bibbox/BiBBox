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

import com.liferay.counter.service.CounterLocalServiceUtil;

import at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt;
import at.graz.hmmc.liferay.portlet.puch.model.impl.PuchMuseumsObjektImpl;
import at.graz.hmmc.liferay.portlet.puch.service.base.PuchMuseumsObjektLocalServiceBaseImpl;

/**
 * The implementation of the puch museums objekt local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.hmmc.liferay.portlet.puch.service.PuchMuseumsObjektLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.hmmc.liferay.portlet.puch.service.base.PuchMuseumsObjektLocalServiceBaseImpl
 * @see at.graz.hmmc.liferay.portlet.puch.service.PuchMuseumsObjektLocalServiceUtil
 */
public class PuchMuseumsObjektLocalServiceImpl
	extends PuchMuseumsObjektLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.hmmc.liferay.portlet.puch.service.PuchMuseumsObjektLocalServiceUtil} to access the puch museums objekt local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	public PuchMuseumsObjekt addPuchMuseumsObjekt(String objekttyp, long userId) {
		try {
			PuchMuseumsObjektImpl puchmuseumsobjekt = new PuchMuseumsObjektImpl();
			puchmuseumsobjekt.setPuchmuseumsobjectId(CounterLocalServiceUtil.increment(PuchMuseumsObjekt.class.getName()));
			puchmuseumsobjekt.setObjekttyp(objekttyp);
			puchmuseumsobjekt.setCreateDate(new Date());
			puchmuseumsobjekt.setModifiedDate(new Date());
			puchmuseumsobjekt.setModifiedUserId(userId);
			puchmuseumsobjekt.setCreaterUserId(userId);
			return puchmuseumsobjekt;
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.PuchMuseumsObjektLocalServiceImpl::addPuchMuseumsObjekt] Error creating new Object (" + objekttyp+ ").");
			ex.printStackTrace();
		}
		return null;
	}
}