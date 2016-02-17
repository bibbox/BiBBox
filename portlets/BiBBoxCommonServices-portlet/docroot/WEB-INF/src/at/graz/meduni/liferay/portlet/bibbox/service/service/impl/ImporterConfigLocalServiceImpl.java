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

package at.graz.meduni.liferay.portlet.bibbox.service.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.service.base.ImporterConfigLocalServiceBaseImpl;

/**
 * The implementation of the importer config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.service.ImporterConfigLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.ImporterConfigLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.ImporterConfigLocalServiceUtil
 */
public class ImporterConfigLocalServiceImpl
	extends ImporterConfigLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.service.ImporterConfigLocalServiceUtil} to access the importer config local service.
	 */
	
	public String getPredicate(String scope, String elementId) {
		try {
			return importerConfigPersistence.findByImporterConfig(scope, elementId).getElementvalue();
		} catch (NoSuchImporterConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public void setPredicate(String scope, String elementId, String elementvalue) {
		ImporterConfig importerconfig = null;
		try {
			importerconfig = importerConfigPersistence.findByImporterConfig(scope, elementId);
			importerconfig.setElementvalue(elementvalue);
		} catch (NoSuchImporterConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(importerconfig == null) {
			importerconfig = new ImporterConfigImpl();
			try {
				importerconfig.setImporterconfigId(CounterLocalServiceUtil.increment());
				importerconfig.setScope(scope);
				importerconfig.setElementId(elementId);
				importerconfig.setElementvalue(elementvalue);
				importerconfig = super.addImporterConfig(importerconfig);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}