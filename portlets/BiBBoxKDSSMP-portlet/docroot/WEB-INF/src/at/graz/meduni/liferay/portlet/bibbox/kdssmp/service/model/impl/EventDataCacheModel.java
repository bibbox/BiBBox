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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EventData in entity cache.
 *
 * @author reihsr
 * @see EventData
 * @generated
 */
public class EventDataCacheModel implements CacheModel<EventData>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{eventdataId=");
		sb.append(eventdataId);
		sb.append(", eventlayoutId=");
		sb.append(eventlayoutId);
		sb.append(", patientId=");
		sb.append(patientId);
		sb.append(", ontology=");
		sb.append(ontology);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventData toEntityModel() {
		EventDataImpl eventDataImpl = new EventDataImpl();

		eventDataImpl.setEventdataId(eventdataId);
		eventDataImpl.setEventlayoutId(eventlayoutId);
		eventDataImpl.setPatientId(patientId);

		if (ontology == null) {
			eventDataImpl.setOntology(StringPool.BLANK);
		}
		else {
			eventDataImpl.setOntology(ontology);
		}

		if (value == null) {
			eventDataImpl.setValue(StringPool.BLANK);
		}
		else {
			eventDataImpl.setValue(value);
		}

		eventDataImpl.resetOriginalValues();

		return eventDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventdataId = objectInput.readLong();
		eventlayoutId = objectInput.readLong();
		patientId = objectInput.readLong();
		ontology = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eventdataId);
		objectOutput.writeLong(eventlayoutId);
		objectOutput.writeLong(patientId);

		if (ontology == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ontology);
		}

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long eventdataId;
	public long eventlayoutId;
	public long patientId;
	public String ontology;
	public String value;
}