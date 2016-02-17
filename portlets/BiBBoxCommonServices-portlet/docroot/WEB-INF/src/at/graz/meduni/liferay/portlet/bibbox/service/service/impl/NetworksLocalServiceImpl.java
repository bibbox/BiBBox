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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.Networks;
import at.graz.meduni.liferay.portlet.bibbox.service.service.base.NetworksLocalServiceBaseImpl;

/**
 * The implementation of the networks local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.service.NetworksLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.NetworksLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.NetworksLocalServiceUtil
 */
public class NetworksLocalServiceImpl extends NetworksLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.service.NetworksLocalServiceUtil} to access the networks local service.
	 */
	
	/**
	 * 
	 * @param organizationId
	 * @return
	 */
	public List<Networks> getNetworkOrganizations(long organizationId) {
		try {
			return networksPersistence.findByNetworkOrganizationsFinder(organizationId);
		} catch (SystemException e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.NetworksLocalServiceImpl::getNetworkOrganizations] Network finder Exception.");
			e.printStackTrace();
		}	
		return null;
	}
	
	/**
	 * 
	 * @param organizationId
	 * @return
	 */
	public List<Networks> getOrganizationNetworkOrganizations(long organizationId) {
		try {
			return networksPersistence.findByOrganizationNetworkOrganizations(organizationId);
		} catch (SystemException e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.NetworksLocalServiceImpl::getNetworkOrganizations] Network finder Exception.");
			e.printStackTrace();
		}	
		return null;
	}
	
	/**
	 * 
	 * @param organizationId
	 * @param networkId
	 * @return
	 */
	public boolean isOrganizationInNetwork(long organizationId, long networkId) {
		try {
			networksPersistence.findByNetworkOrganizationFinder(networkId, organizationId);
			return true;
		} catch (NoSuchNetworksException e) {
			
		} catch (SystemException e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.NetworksLocalServiceImpl::getNetworkOrganizations] Network finder Exception.");
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 * @param networkid
	 * @return
	 */
	public List<Long> getNetworkIdList(long networkid) {
		List<Long> return_list = new ArrayList<Long>();
		return_list.add(networkid);
		List<Networks> networks = getNetworkOrganizations(networkid);
		for(Networks network : networks) {
			return_list.add(network.getOrganizationId());
		}
		return return_list;
	}
	
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
}