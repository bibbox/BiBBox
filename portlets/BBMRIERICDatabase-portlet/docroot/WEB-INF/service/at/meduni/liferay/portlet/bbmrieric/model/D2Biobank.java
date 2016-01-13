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

package at.meduni.liferay.portlet.bbmrieric.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the D2Biobank service. Represents a row in the &quot;bbmrieric.d2biobank&quot; database table, with each column mapped to a property of this class.
 *
 * @author reihsr
 * @see D2BiobankModel
 * @see at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankImpl
 * @see at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl
 * @generated
 */
public interface D2Biobank extends D2BiobankModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformation();

	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getCollections();

	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getRootCollections();

	public int getCollectionsCount();

	/**
	* @return
	*/
	public java.lang.String getBiobankJavascriptTable();

	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> getNetworksWhereBiobankIsMember();
}