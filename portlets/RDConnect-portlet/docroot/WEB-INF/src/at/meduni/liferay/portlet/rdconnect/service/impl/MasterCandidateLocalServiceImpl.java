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
		
		// Dynamic Query for search
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MasterCandidate.class);
				
		Criterion criterion = null;
				
		Criterion criterion_stringsearch = RestrictionsFactoryUtil.ilike("diseasesfreetext", StringPool.PERCENT + searchstring + StringPool.PERCENT);
		criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("diseasescodes", StringPool.PERCENT + searchstring + StringPool.PERCENT));
		criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + searchstring + StringPool.PERCENT));
		criterion_stringsearch = RestrictionsFactoryUtil.or(criterion_stringsearch, RestrictionsFactoryUtil.ilike("candidatesubtype", StringPool.PERCENT + searchstring + StringPool.PERCENT));
				
		criterion = RestrictionsFactoryUtil.ilike("country", StringPool.PERCENT + country + StringPool.PERCENT);
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.ilike("candidatetype", StringPool.PERCENT + type + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.and(criterion, criterion_stringsearch);
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.ilike("state", StringPool.PERCENT + state + StringPool.PERCENT));
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.sqlRestriction("state_ NOT ILIKE 'x'"));
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.sqlRestriction("state_ NOT ILIKE '0'"));
				
		dynamicQuery.add(criterion);
		
		Order countryOrder = OrderFactoryUtil.asc("country");
		Order joinIdOrder = OrderFactoryUtil.asc("joinId");
		Order nameOrder = OrderFactoryUtil.asc("name");
		//Order candidateidOrder = OrderFactoryUtil.asc("candidateId");
		//Order masteridOrder = OrderFactoryUtil.desc("masterId");
		 
		dynamicQuery.addOrder(countryOrder);
		dynamicQuery.addOrder(joinIdOrder);
		dynamicQuery.addOrder(nameOrder);
		
		List<MasterCandidate> mastercandidate = MasterCandidateLocalServiceUtil.dynamicQuery(dynamicQuery);

		//List<MasterCandidate> mastercandidate = masterCandidatePersistence.findByCNST(country, name, type);
		return mastercandidate;	
	}
}