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

package at.graz.meduni.liferay.portlet.bibbox.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.base.OrphanetSynonymLocalServiceBaseImpl;

/**
 * The implementation of the orphanet synonym local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.base.OrphanetSynonymLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymLocalServiceUtil
 */
public class OrphanetSynonymLocalServiceImpl
	extends OrphanetSynonymLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymLocalServiceUtil} to access the orphanet synonym local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 */
	public OrphanetSynonym createOrphanetSynonym(String synonym, long orphanetdisorderId) {
		try {
			OrphanetSynonymImpl orphanetsynonym = new OrphanetSynonymImpl();
			orphanetsynonym.setOrphanetsynonymId(CounterLocalServiceUtil.increment(OrphanetSynonym.class.getName()));
			orphanetsynonym.setOrphanetdisorderId(orphanetdisorderId);
			orphanetsynonym.setSynonym(synonym);
			return OrphanetSynonymLocalServiceUtil.addOrphanetSynonym(orphanetsynonym);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServicesDatabase-portlet::at.graz.meduni.liferay.portlet.bibbox.service.impl.OrphanetSynonymLocalServiceImpl::createOrphanetSynonym] Error creating new OrphanetSynonym.");
			ex.printStackTrace();
		}
		return null;
	}
}