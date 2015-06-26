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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchEventDataException;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.EventDataImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventDataLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base.EventDataLocalServiceBaseImpl;

/**
 * The implementation of the event data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base.EventDataLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventDataLocalServiceUtil
 */
public class EventDataLocalServiceImpl extends EventDataLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventDataLocalServiceUtil} to access the event data local service.
	 */
	public EventData createNewEventData(long eventId, long patientId, String key, String value) {
		EventDataImpl eventdata = null;
		try {
			eventdata = new EventDataImpl();
			eventdata.setEventdataId(CounterLocalServiceUtil.increment(EventData.class.getName()));
			//eventdata.setEventlayoutId(eventId);
			eventdata.setPatientId(patientId);
			eventdata.setOntology(key);
			eventdata.setValue(value);
			
			return EventDataLocalServiceUtil.addEventData(eventdata);
		} catch(Exception ex) {
			System.err.println("ERROR: EventDataLocalServiceImpl::createNewEventData()");
			ex.printStackTrace();
		}
		return null;
	}
	
	public EventData getEventDataByOntology(long eventlayoutId, String ontology) {
		try {
			return eventDataPersistence.findByDataByOntology(eventlayoutId, ontology);
		} catch (NoSuchEventDataException e) {
			// TODO Auto-generated catch block
			System.err.println("No Data for event found.");
			//e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}