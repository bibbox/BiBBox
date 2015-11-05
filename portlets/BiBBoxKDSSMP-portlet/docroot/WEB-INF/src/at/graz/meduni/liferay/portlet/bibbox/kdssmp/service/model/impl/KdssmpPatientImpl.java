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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventLocalServiceUtil;

/**
 * The extended model implementation for the KdssmpPatient service. Represents a row in the &quot;kdssmp.patient&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient} interface.
 * </p>
 *
 * @author reihsr
 */
public class KdssmpPatientImpl extends KdssmpPatientBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a kdssmp patient model instance should use the {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient} interface instead.
	 */
	public KdssmpPatientImpl() {
	}
	
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public int getNumberOfEvents() {
		try {
			return EventLocalServiceUtil.getEventsForPatient(this.getPatientId()).size();
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxkDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpPatientImpl::getNumberOfEvents] Error getting Eventcount for patient " + this.getPatientId() + ".");
		}
		return 0;
	}
}