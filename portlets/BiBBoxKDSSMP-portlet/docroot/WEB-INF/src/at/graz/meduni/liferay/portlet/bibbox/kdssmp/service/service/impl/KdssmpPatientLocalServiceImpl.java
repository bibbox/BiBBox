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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpPatientImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpPatientLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base.KdssmpPatientLocalServiceBaseImpl;

/**
 * The implementation of the kdssmp patient local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpPatientLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base.KdssmpPatientLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpPatientLocalServiceUtil
 */
public class KdssmpPatientLocalServiceImpl
	extends KdssmpPatientLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpPatientLocalServiceUtil} to access the kdssmp patient local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param dob
	 * @param dod
	 * @param gender
	 * @return
	 */
	public KdssmpPatient createKdssmpPatient(String firstname, String lastname, Date dob, Date dod, String gender, long organizationid) {
		try {
			KdssmpPatientImpl kdssmppatient = new KdssmpPatientImpl();
			kdssmppatient.setPatientId(CounterLocalServiceUtil.increment(KdssmpPatient.class.getName()));
			kdssmppatient.setFirstname(firstname);
			kdssmppatient.setLastname(lastname);
			kdssmppatient.setDateofbirth(dob);
			kdssmppatient.setDateofdeath(dod);
			kdssmppatient.setGender(gender);
			kdssmppatient.setOrganizationId(organizationid);
			return KdssmpPatientLocalServiceUtil.addKdssmpPatient(kdssmppatient);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxKDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.impl.KdssmpPatientLocalServiceImpl::createKdssmpPatient] ERROR creating new Patient with parameters: (" + firstname +", " + lastname +", " + dob +", " + dod +", " + gender + ").");
			ex.printStackTrace();
		}
		return null;
	}
	
	public KdssmpPatient getPatientForOrganization(long organizationId) {
		try {
			return kdssmpPatientPersistence.findByOrganization(organizationId);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxKDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.impl.KdssmpPatientLocalServiceImpl::getPatientForOrganization] ERROR getting pationt for the organization: (" + organizationId + ").");
			ex.printStackTrace();
		}
		return null;
	}
}