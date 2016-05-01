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

package at.meduni.liferay.portlet.rdconnect.model.impl;

import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

/**
 * The extended model implementation for the MasterCandidate service. Represents a row in the &quot;rdconnect.master_candidate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.rdconnect.model.MasterCandidate} interface.
 * </p>
 *
 * @author Robert Reihs
 */
public class MasterCandidateImpl extends MasterCandidateBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a master candidate model instance should use the {@link at.meduni.liferay.portlet.rdconnect.model.MasterCandidate} interface instead.
	 */
	public MasterCandidateImpl() {
	}
	
	public Fields getFieldsForDDLRecord(Fields fields, String record_set_name) {
		if(record_set_name.equalsIgnoreCase("core")) {
			getFieldsForCore(fields);
		}
		if(record_set_name.equalsIgnoreCase("bb_core")) {
			getFieldsForCore(fields);
		}
		return fields;
	}
	
	private Fields getFieldsForCore(Fields fields) {
		Field field_acronym = new Field("acronym", this.getCandidatesubtype());
		fields.put(field_acronym);
		Field field_description = new Field("Description", "");
		fields.put(field_description);
		Field field_countryCode = new Field("countryCode", this.getCountry());
		fields.put(field_countryCode);
		return fields;
	}
}