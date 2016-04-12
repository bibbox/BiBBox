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

package at.graz.meduni.liferay.portlet.bibbox.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the OrphanetDisorder service. Represents a row in the &quot;ontologies.orphanetdisorder&quot; database table, with each column mapped to a property of this class.
 *
 * @author reihsr
 * @see OrphanetDisorderModel
 * @see at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderModelImpl
 * @generated
 */
public interface OrphanetDisorder extends OrphanetDisorderModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getICD10();

	public java.lang.String getOMIM();

	public java.lang.String getSynonym();
}