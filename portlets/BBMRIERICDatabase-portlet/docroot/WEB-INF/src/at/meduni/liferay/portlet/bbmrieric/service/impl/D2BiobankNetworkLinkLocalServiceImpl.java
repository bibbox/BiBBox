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

package at.meduni.liferay.portlet.bbmrieric.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork;
import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLinkLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.base.D2BiobankNetworkLinkLocalServiceBaseImpl;

/**
 * The implementation of the d2 biobank network link local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLinkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.D2BiobankNetworkLinkLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLinkLocalServiceUtil
 */
public class D2BiobankNetworkLinkLocalServiceImpl
	extends D2BiobankNetworkLinkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLinkLocalServiceUtil} to access the d2 biobank network link local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	String classpath_ = "BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankNetworkLinkLocalServiceImpl";
	
	/**
	 * 
	 * @param biobankId
	 * @return
	 */
	public D2BiobankNetworkLink getD2BiobankNetworkLink(long d2biobanknetworkId, long d2linkId, String d2linktype) {
		try {
			return d2BiobankNetworkLinkPersistence.findByNetworkLinkByChild(d2biobanknetworkId, d2linkId, d2linktype);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [" + classpath_ + "::getD2BiobankNetwork] .");
		}
		return null;
	}
	
	/**
	 * 
	 */
	public D2BiobankNetworkLink addD2BiobankNetworkLink(long d2biobanknetworkId, long d2linkId, String d2linktype, long groupId, String updateuuid) {
		try {
			long d2biobanknetworklinkId = counterLocalService.increment();
			D2BiobankNetworkLink d2biobanknetworklink = d2BiobankNetworkLinkPersistence.create(d2biobanknetworklinkId);
			d2biobanknetworklink.setD2biobanknetworkId(d2biobanknetworkId);
			d2biobanknetworklink.setD2linkId(d2linkId);
			d2biobanknetworklink.setD2linktype(d2linktype);
			d2biobanknetworklink.setUpdateuuid(updateuuid);
			d2biobanknetworklink.setGroupId(groupId);
			return D2BiobankNetworkLinkLocalServiceUtil.updateD2BiobankNetworkLink(d2biobanknetworklink);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [" + classpath_ + "::getD2BiobankNetwork] .");
		}
		return null;
	}
	
	/**
	 * 
	 * @param groupId
	 * @param uuid
	 * @return
	 */
	public List<D2BiobankNetworkLink> getLDAPNotUpdatedNetworkLinks(long groupId, String uuid) {
		try {
			return d2BiobankNetworkLinkPersistence.findByNotUUID(groupId, uuid);
		} catch (SystemException e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::getLDAPNotUpdatedNetworkLinks] Error getting Network Link List with not updateId: " + uuid + ".");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 */
	public List<D2BiobankNetworkLink> getNetworkLinksForChilde(long d2linkId, String d2linktype) {
		try {
			return d2BiobankNetworkLinkPersistence.findByNetworkLinksForChild(d2linkId, d2linktype);
		} catch (SystemException e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::getNetworkLinksForChilde] Error getting Network Link List for Childe: " + d2linktype + " - " + d2linkId + ".");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 */
	public List<D2BiobankNetworkLink> getChildForNetworkLinks(long d2biobanknetworkId, String d2linktype) {
		try {
			return d2BiobankNetworkLinkPersistence.findByChildForNetworkLinks(d2biobanknetworkId, d2linktype);
		} catch (SystemException e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::getChildForNetworkLinks] Error getting Child List for Network Link: " + d2linktype + " - " + d2biobanknetworkId + ".");
			e.printStackTrace();
		}
		return null;
	}
}