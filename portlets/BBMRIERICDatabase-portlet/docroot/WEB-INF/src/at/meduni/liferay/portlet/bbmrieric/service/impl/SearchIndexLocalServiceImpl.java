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

import com.liferay.counter.service.CounterLocalServiceUtil;

import at.meduni.liferay.portlet.bbmrieric.model.SearchIndex;
import at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexImpl;
import at.meduni.liferay.portlet.bbmrieric.service.SearchIndexLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.base.SearchIndexLocalServiceBaseImpl;
import at.meduni.liferay.portlet.bbmrieric.service.persistence.SearchIndexPersistence;

/**
 * The implementation of the search index local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.service.SearchIndexLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.SearchIndexLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.SearchIndexLocalServiceUtil
 */
public class SearchIndexLocalServiceImpl extends SearchIndexLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.bbmrieric.service.SearchIndexLocalServiceUtil} to access the search index local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @param organizationid
	 * @param key
	 * @param value
	 * @param uuid
	 * @return
	 */
	public SearchIndex createSearchIndex(long organizationid, String key, String value, String uuid) {
		try {
			SearchIndexImpl searchindex = new SearchIndexImpl();
			searchindex.setSearchid(CounterLocalServiceUtil.increment(SearchIndex.class.getName()));
			searchindex.setOrganisationid(organizationid);
			searchindex.setSearchindexkey(key);
			searchindex.setSearchindexvalue(value);
			searchindex.setUUID(uuid);
			return SearchIndexLocalServiceUtil.addSearchIndex(searchindex);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.SearchIndexLocalServiceImpl::createSearchIndex] Error creating SearchIndex with (" + organizationid + ", " + key + ", " + value + ", " + uuid + ").");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param organizationid
	 * @param key
	 * @return
	 */
	public SearchIndex getSearchIndex(long organizationid, String key) {
		try {
			return searchIndexPersistence.findBySearchIndex(organizationid, key);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.SearchIndexLocalServiceImpl::getSearchIndex] Could not find SearchIndex with (" + organizationid + ", " + key + ").");
		}
		return null;
	}
	
	/**
	 * 
	 * @param organisationid
	 * @return
	 */
	public List<SearchIndex> getSearchIndexForOrganization(long organisationid) {
		try {
			return searchIndexPersistence.findBySearchIndexByOrganization(organisationid);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.SearchIndexLocalServiceImpl::getSearchIndexForOrganization] Could not find SearchIndex for Organization (" + organisationid + ").");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param uuid
	 * @return
	 */
	public List<SearchIndex> notUpdatedSearchIndex(String uuid) {
		try {
			return searchIndexPersistence.findByNotUUID(uuid);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.SearchIndexLocalServiceImpl::notUpdatedSearchIndex] Could not find SearchIndex with not having (" + uuid + ").");
		}
		return null;
	}
}