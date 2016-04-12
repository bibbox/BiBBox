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
import java.util.List;

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.base.OrphanetReferenceLocalServiceBaseImpl;

/**
 * The implementation of the orphanet reference local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.base.OrphanetReferenceLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceLocalServiceUtil
 */
public class OrphanetReferenceLocalServiceImpl
	extends OrphanetReferenceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceLocalServiceUtil} to access the orphanet reference local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 */
	public OrphanetReference createOrphanetReference(long orphanetreferenceId, long orphanetdisorderId) {
		try {
			OrphanetReferenceImpl orphanetreference = new OrphanetReferenceImpl();
			orphanetreference.setOrphanetreferenceId(orphanetreferenceId);
			orphanetreference.setOrphanetdisorderId(orphanetdisorderId);
			return OrphanetReferenceLocalServiceUtil.addOrphanetReference(orphanetreference);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServicesDatabase-portlet::at.graz.meduni.liferay.portlet.bibbox.service.impl.OrphanetReferenceLocalServiceImpl::createOrphanetReference] Error creating new OrphanetReference.");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param orphanetdisorderId
	 * @param source
	 * @return
	 */
	public List<OrphanetReference> getOrphanetReferenceByOrpahnetDisorderIdAndSource(long orphanetdisorderId, String source) {
		try {
			return orphanetReferencePersistence.findByOrphanetDisorderIdAndSource(orphanetdisorderId, source);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServicesDatabase-portlet::at.graz.meduni.liferay.portlet.bibbox.service.impl.OrphanetReferenceLocalServiceImpl::getOrphanetReferenceByOrpahnetDisorderIdAndSource] Error getting OrphanetReference.");
			ex.printStackTrace();
		}
		return null;
	}
}