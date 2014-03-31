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

package at.meduni.liferay.portlet.rdconnect.service.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;

import at.meduni.liferay.portlet.rdconnect.model.Candidate;
import at.meduni.liferay.portlet.rdconnect.model.MasterCandidate;
import at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateImpl;
import at.meduni.liferay.portlet.rdconnect.service.CandidateLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.service.base.MasterCandidateLocalServiceBaseImpl;

/**
 * The implementation of the master candidate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robert Reihs
 * @see at.meduni.liferay.portlet.rdconnect.service.base.MasterCandidateLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalServiceUtil
 */
public class MasterCandidateLocalServiceImpl
	extends MasterCandidateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalServiceUtil} to access the master candidate local service.
	 */
	public List<MasterCandidate> getFilterdCandidates(long organisationId) throws SystemException {
		return masterCandidatePersistence.findByOrganisationId(organisationId);
	}
	
	public List<MasterCandidate> getFilterdCandidates(String searchstring, String country, String type, String state) throws SystemException {
		if(country.equals("all")) {
			country = "";
		}
		if(type.equals("all")) {
			type = "";
		} else {
			if(type.equals("Registry"))
				type = "Registr";
		}
		if(state.equals("all")) {
			state = "";
		}
		
		List<MasterCandidate> mastercandidate = null;
		
		try {
			// Dynamic Query for search
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MasterCandidateImpl.class);
					
			Criterion criterion = null;
			Criterion criterion_stringsearch_grouped = null;
			
			String[] searchstringarray = searchstring.split(" ");
			
			for (String searchstringsplit : searchstringarray) {
				Criterion criterion_stringsearch = RestrictionsFactoryUtil.ilike("diseasesfreetext", StringPool.PERCENT + searchstringsplit + StringPool.PERCENT);
				criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("diseasescodes", StringPool.PERCENT + searchstringsplit + StringPool.PERCENT));
				criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + searchstringsplit + StringPool.PERCENT));
				criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("candidatesubtype", StringPool.PERCENT + searchstringsplit + StringPool.PERCENT));
				criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("country", StringPool.PERCENT + searchstringsplit + StringPool.PERCENT));
				criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("candidatetype", StringPool.PERCENT + searchstringsplit + StringPool.PERCENT));
				criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("url", StringPool.PERCENT + searchstringsplit + StringPool.PERCENT));
				criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("contactperson", StringPool.PERCENT + searchstringsplit + StringPool.PERCENT));
				criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("comment", StringPool.PERCENT + searchstringsplit + StringPool.PERCENT));
				criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("address", StringPool.PERCENT + searchstringsplit + StringPool.PERCENT));
				criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("mail", StringPool.PERCENT + searchstringsplit + StringPool.PERCENT));
				criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("head", StringPool.PERCENT + searchstringsplit + StringPool.PERCENT));
				try {
					long searchlong = Long.valueOf(searchstringsplit);
					criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.eq("masterCandidateId", searchlong));
				} catch (Exception e) {
					
				}
				if(criterion_stringsearch_grouped == null) {
					criterion_stringsearch_grouped = criterion_stringsearch;
				} else {
					criterion_stringsearch_grouped = RestrictionsFactoryUtil.or(criterion_stringsearch_grouped, criterion_stringsearch);
				}
			}
					
			criterion = RestrictionsFactoryUtil.ilike("country", StringPool.PERCENT + country + StringPool.PERCENT);
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.ilike("candidatetype", StringPool.PERCENT + type + StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.and(criterion, criterion_stringsearch_grouped);
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.ilike("state", StringPool.PERCENT + state + StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.sqlRestriction("state_ NOT ILIKE 'x'"));
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.sqlRestriction("state_ NOT ILIKE '0'"));
					
			dynamicQuery.add(criterion);
			
			Order countryOrder = OrderFactoryUtil.asc("country");
			Order joinIdOrder = OrderFactoryUtil.asc("joinId");
			Order nameOrder = OrderFactoryUtil.asc("name");
			 
			dynamicQuery.addOrder(countryOrder);
			dynamicQuery.addOrder(joinIdOrder);
			dynamicQuery.addOrder(nameOrder);
			
			
			mastercandidate = MasterCandidateLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mastercandidate;	
	}
}