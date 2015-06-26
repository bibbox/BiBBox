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
 * The extended model interface for the IconConfiguration service. Represents a row in the &quot;bibboxcs.iconconfiguration&quot; database table, with each column mapped to a property of this class.
 *
 * @author reihsr
 * @see IconConfigurationModel
 * @see at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl
 * @generated
 */
public interface IconConfiguration extends IconConfigurationModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* @return
	*/
	public java.lang.String getIconUrl();

	public java.lang.String getHTMLIcon();
}