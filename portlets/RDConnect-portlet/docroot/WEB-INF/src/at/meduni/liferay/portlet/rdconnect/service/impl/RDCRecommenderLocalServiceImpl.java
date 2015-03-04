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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

import at.meduni.liferay.portlet.rdconnect.model.RDCRecommender;
import at.meduni.liferay.portlet.rdconnect.model.impl.RDCRecommenderImpl;
import at.meduni.liferay.portlet.rdconnect.service.RDCRecommenderLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.service.base.RDCRecommenderLocalServiceBaseImpl;
import at.meduni.liferay.portlet.rdconnect.service.persistence.RDCRecommenderPersistence;

/**
 * The implementation of the r d c recommender local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.rdconnect.service.RDCRecommenderLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robert Reihs
 * @see at.meduni.liferay.portlet.rdconnect.service.base.RDCRecommenderLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.rdconnect.service.RDCRecommenderLocalServiceUtil
 */
public class RDCRecommenderLocalServiceImpl
	extends RDCRecommenderLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.rdconnect.service.RDCRecommenderLocalServiceUtil} to access the r d c recommender local service.
	 */
	public RDCRecommender getRDCRecommender(long organizationId, long organizationrecommandedId) {
		try {
			return rdcRecommenderPersistence.findByRecommendation(organizationId, organizationrecommandedId);
		} catch (Exception ex) {
			//ex.printStackTrace();
		}
		return null;
	}
	
	public RDCRecommender addRDCRecommender(long organizationId, long organizationrecommandedId, double recommendervalue) throws SystemException {
		long rdcrecommenderId = CounterLocalServiceUtil.increment(RDCRecommender.class.getName());
		RDCRecommenderImpl rdcrecommender = new RDCRecommenderImpl();
		rdcrecommender.setRdcrecommenderid(rdcrecommenderId);
		rdcrecommender.setOrganisationId(organizationId);
		rdcrecommender.setRecommendedorganisationId(organizationrecommandedId);
		rdcrecommender.setRecommendervalue(recommendervalue);
		return super.addRDCRecommender(rdcrecommender);
	}
	
	/**
	 * Returns a number of Recommandations for a user
	 * 
	 * @param userId
	 * @return
	 */
	public List<RDCRecommender> getReconnandationsForUser(long userId) {
		try {
			List<Organization> organizations = OrganizationLocalServiceUtil.getUserOrganizations(userId);
			//System.out.println("Number of Organizations for user: " + organizations.size());
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RDCRecommender.class);
			Criterion criterion = null;
			for(Organization organization : organizations) {
				if(criterion == null) {
					criterion = RestrictionsFactoryUtil.eq("organisationId", organization.getOrganizationId());
					//criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("recommendedorganisationId", organization.getOrganizationId()));
				} else {
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.eq("organisationId", organization.getOrganizationId()));
					//criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("recommendedorganisationId", organization.getOrganizationId()));
				}
			}
			if(criterion == null) {
				return null;
			}
			//System.out.println("Criterion" + criterion.toString());
			dynamicQuery.add(criterion);
			Order recommendervalueOrder = OrderFactoryUtil.desc("recommendervalue");
			dynamicQuery.addOrder(recommendervalueOrder);
			List<RDCRecommender> rdcrecommenders = RDCRecommenderLocalServiceUtil.dynamicQuery(dynamicQuery);
			return rdcrecommenders;
		} catch(Exception ex) {
			System.out.println("ERROR: RDCRecommenderLocalServiceImpl::getReconnandationsForUser");
			ex.printStackTrace();
		}
		return null;
	}
}