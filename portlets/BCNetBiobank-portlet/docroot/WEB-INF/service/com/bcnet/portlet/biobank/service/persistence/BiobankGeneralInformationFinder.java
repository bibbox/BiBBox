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

package com.bcnet.portlet.biobank.service.persistence;

/**
 * @author suyama
 */
public interface BiobankGeneralInformationFinder {
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> findByIdAcronymNameCountry(
		java.lang.String code, java.lang.String acronym, java.lang.String name,
		java.lang.String countryCode, int begin, int end);

	public int countByIdAcronymNameCountry(java.lang.String code,
		java.lang.String acronym, java.lang.String name,
		java.lang.String countryCode);

	public java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> findBiobanksByKeywordsCountry(
		java.lang.String[] partskeywords, java.lang.String countryCode,
		int begin, int end);
}