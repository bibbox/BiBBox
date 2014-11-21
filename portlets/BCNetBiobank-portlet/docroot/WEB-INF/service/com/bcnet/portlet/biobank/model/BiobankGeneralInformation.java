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

package com.bcnet.portlet.biobank.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the BiobankGeneralInformation service. Represents a row in the &quot;biobank&quot; database table, with each column mapped to a property of this class.
 *
 * @author suyama
 * @see BiobankGeneralInformationModel
 * @see com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationImpl
 * @see com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationModelImpl
 * @generated
 */
public interface BiobankGeneralInformation
	extends BiobankGeneralInformationModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getBiobankName();

	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> getBiobankAttributeLists();
}