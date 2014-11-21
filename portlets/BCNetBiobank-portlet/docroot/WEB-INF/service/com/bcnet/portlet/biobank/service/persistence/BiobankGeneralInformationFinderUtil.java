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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author suyama
 */
public class BiobankGeneralInformationFinderUtil {
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> findByIdAcronymNameCountry(
		java.lang.String code, java.lang.String acronym, java.lang.String name,
		java.lang.String countryCode, int begin, int end) {
		return getFinder()
				   .findByIdAcronymNameCountry(code, acronym, name,
			countryCode, begin, end);
	}

	public static int countByIdAcronymNameCountry(java.lang.String code,
		java.lang.String acronym, java.lang.String name,
		java.lang.String countryCode) {
		return getFinder()
				   .countByIdAcronymNameCountry(code, acronym, name, countryCode);
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> findBiobanksByKeywordsCountry(
		java.lang.String[] partskeywords, java.lang.String countryCode,
		int begin, int end) {
		return getFinder()
				   .findBiobanksByKeywordsCountry(partskeywords, countryCode,
			begin, end);
	}

	public static BiobankGeneralInformationFinder getFinder() {
		if (_finder == null) {
			_finder = (BiobankGeneralInformationFinder)PortletBeanLocatorUtil.locate(com.bcnet.portlet.biobank.service.ClpSerializer.getServletContextName(),
					BiobankGeneralInformationFinder.class.getName());

			ReferenceRegistry.registerReference(BiobankGeneralInformationFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BiobankGeneralInformationFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BiobankGeneralInformationFinderUtil.class,
			"_finder");
	}

	private static BiobankGeneralInformationFinder _finder;
}