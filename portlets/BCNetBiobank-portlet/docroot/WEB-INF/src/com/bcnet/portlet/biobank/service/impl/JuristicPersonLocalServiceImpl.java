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

package com.bcnet.portlet.biobank.service.impl;

import java.util.List;

import com.bcnet.portlet.biobank.NoSuchJuristicPersonException;
import com.bcnet.portlet.biobank.model.JuristicPerson;
import com.bcnet.portlet.biobank.service.base.JuristicPersonLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the juristic person local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.JuristicPersonLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.JuristicPersonLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.JuristicPersonLocalServiceUtil
 */
public class JuristicPersonLocalServiceImpl
extends JuristicPersonLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.JuristicPersonLocalServiceUtil} to access the juristic person local service.
	 */

	public JuristicPerson addJusristicPerson(String name, String url, String address) throws SystemException{

		long juristicPersonId = counterLocalService.increment(JuristicPerson.class.getName());

		JuristicPerson juristicPerson = juristicPersonPersistence.create(juristicPersonId);

		juristicPerson.setName(name);
		juristicPerson.setUrl(url);
		juristicPerson.setAddress(address);

		super.addJuristicPerson(juristicPerson);

		return juristicPerson;
	}

	public JuristicPerson updateJuristicPerson(long juristicPersonId, String name, String url, String address) throws PortalException, SystemException{

		JuristicPerson juristicPerson = juristicPersonPersistence.findByPrimaryKey(juristicPersonId);

		juristicPerson.setName(name);
		juristicPerson.setUrl(url);
		juristicPerson.setAddress(address);

		super.updateJuristicPerson(juristicPerson);

		return juristicPerson;

	}

	public JuristicPerson deleteJuristicPerson(JuristicPerson juristicPerson) throws SystemException{

		return juristicPersonPersistence.remove(juristicPerson);
	}

	public JuristicPerson deleteJuristicPerson(long juristicPersonId) throws SystemException{

		JuristicPerson juristicPerson = juristicPersonPersistence.fetchByPrimaryKey(juristicPersonId);

		return deleteJuristicPerson(juristicPerson);
	}

	public JuristicPerson getJuristicPerson(long juristicPersonId) throws NoSuchJuristicPersonException, SystemException{

		return juristicPersonPersistence.findByPrimaryKey(juristicPersonId);
	}

	public List<JuristicPerson> getAllJuristicPersons() throws SystemException{

		return juristicPersonPersistence.findAll();
	}

	public List<JuristicPerson> getAllJuristicPersons(int start, int end) throws SystemException{

		return juristicPersonPersistence.findAll(start, end);
	}
}