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

package at.graz.meduni.liferay.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.PersistedModel;

import at.graz.meduni.liferay.model.Dictionary;
import at.graz.meduni.liferay.service.base.DictionaryLocalServiceBaseImpl;
import at.graz.meduni.liferay.service.persistence.DictionaryPersistence;

/**
 * The implementation of the dictionary local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.service.DictionaryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.service.base.DictionaryLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.service.DictionaryLocalServiceUtil
 */
public class DictionaryLocalServiceImpl extends DictionaryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.service.DictionaryLocalServiceUtil} to access the dictionary local service.
	 */
	
	public List<Dictionary> getRootNodes() {
		try {
			return dictionaryPersistence.findByRootNodes(true);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}