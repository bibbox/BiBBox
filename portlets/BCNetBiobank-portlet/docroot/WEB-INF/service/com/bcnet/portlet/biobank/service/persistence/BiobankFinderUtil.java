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
public class BiobankFinderUtil {
	public static java.util.List<com.bcnet.portlet.biobank.model.Biobank> findByCodeAcronymNameCountry(
		java.lang.String code, java.lang.String acronym, java.lang.String name,
		java.lang.String countryCode, int begin, int end) {
		return getFinder()
				   .findByCodeAcronymNameCountry(code, acronym, name,
			countryCode, begin, end);
	}

	public static int countByCodeAcronymNameCountry(java.lang.String code,
		java.lang.String acronym, java.lang.String name,
		java.lang.String countryCode) {
		return getFinder()
				   .countByCodeAcronymNameCountry(code, acronym, name,
			countryCode);
	}

	public static BiobankFinder getFinder() {
		if (_finder == null) {
			_finder = (BiobankFinder)PortletBeanLocatorUtil.locate(com.bcnet.portlet.biobank.service.ClpSerializer.getServletContextName(),
					BiobankFinder.class.getName());

			ReferenceRegistry.registerReference(BiobankFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BiobankFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BiobankFinderUtil.class, "_finder");
	}

	private static BiobankFinder _finder;
}