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

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base.EventLocalServiceBaseImpl;

/**
 * The implementation of the event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base.EventLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventLocalServiceUtil
 */
public class EventLocalServiceImpl extends EventLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventLocalServiceUtil} to access the event local service.
	 */
	public Event createNewEvent(long layoutId, long patientId, Date eventdate, String eventtype) {
		Event event = null;
		try {
			event = new EventImpl();
			event.setEventId(CounterLocalServiceUtil.increment(Event.class.getName()));
			event.setPatientId(patientId);
			event.setEventdate(eventdate);
			event.setEventtype(eventtype);
			event.setLayoutId(layoutId);
			event.setStatus("open");
			event = EventLocalServiceUtil.addEvent(event);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return event;
	}
	
	public List<Event> getEventsForPatient(long patientId) throws SystemException {
		return eventPersistence.findByPatient(patientId);
	}
	
	public Event getEventForLayout(long plid) {
		try {
			return eventPersistence.findByLayoutId(plid);
		} catch(Exception ex) {
			
		}
		return null;
	}
}