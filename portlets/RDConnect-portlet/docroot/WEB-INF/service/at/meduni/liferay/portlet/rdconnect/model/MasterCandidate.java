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

package at.meduni.liferay.portlet.rdconnect.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the MasterCandidate service. Represents a row in the &quot;rdconnect.master_candidate&quot; database table, with each column mapped to a property of this class.
 *
 * @author Robert Reihs
 * @see MasterCandidateModel
 * @see at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateImpl
 * @see at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateModelImpl
 * @generated
 */
public interface MasterCandidate extends MasterCandidateModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.liferay.portlet.dynamicdatamapping.storage.Fields getFieldsForDDLRecord(
		com.liferay.portlet.dynamicdatamapping.storage.Fields fields,
		java.lang.String record_set_name);
}