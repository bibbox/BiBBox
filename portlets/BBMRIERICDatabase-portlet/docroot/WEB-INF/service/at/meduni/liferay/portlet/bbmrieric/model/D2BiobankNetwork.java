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
 * The extended model interface for the D2BiobankNetwork service. Represents a row in the &quot;bbmrieric.d2biobanknetwork&quot; database table, with each column mapped to a property of this class.
 *
 * @author reihsr
 * @see D2BiobankNetworkModel
 * @see at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkImpl
 * @see at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkModelImpl
 * @generated
 */
public interface D2BiobankNetwork extends D2BiobankNetworkModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformation();

	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> getAssosiatedNetworks();

	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Biobank> getAssosiatedBiobanks();

	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getAssosiatedCollections();

	/**
	* @return
	*/
	public java.lang.String getBiobankNetworkJavascriptTable();
}