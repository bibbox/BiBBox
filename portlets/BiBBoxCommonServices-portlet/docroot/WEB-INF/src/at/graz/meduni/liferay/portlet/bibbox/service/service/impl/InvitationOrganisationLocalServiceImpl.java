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

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation;
import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation;
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.base.InvitationOrganisationLocalServiceBaseImpl;

/**
 * The implementation of the invitation organisation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.InvitationOrganisationLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil
 */
public class InvitationOrganisationLocalServiceImpl
	extends InvitationOrganisationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil} to access the invitation organisation local service.
	 */
	
	/**
	 * Gets the number of organizations for invitation
	 */
	public int getOrganisationByInvitationCount(long invitationId) throws SystemException {
		return invitationOrganisationPersistence.countByInvitationOrganisations(invitationId);
	}
	
	/**
	 * Get organizations by invitation
	 */
	public List<InvitationOrganisation> getOrganisationByInvitation(long invitationId) throws SystemException {
		return invitationOrganisationPersistence.findByInvitationOrganisations(invitationId);
	}
	
	/**
	 * Get organizations by organisationId
	 */
	public List<InvitationOrganisation> getInvitationsByOrganisation(long organisationId) throws SystemException {
		return invitationOrganisationPersistence.findByOrganisation(organisationId);
	}
	
	/**
	 * Get organizations by status
	 */
	public List<InvitationOrganisation> getInvitationsByStatus(long status) throws SystemException {
		return invitationOrganisationPersistence.findByStatus(status);
	}
	
	/**
	 * Get organizations by invitation
	 */
	public InvitationOrganisation getInvitationOrganisation(long invitationId, long organisationId) throws SystemException {
		try {
			return invitationOrganisationPersistence.findByInvitationIdAndOrganisationId(invitationId, organisationId);
		} catch (NoSuchInvitationOrganisationException e) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("BiBBox Exception in InvitationOrganisationLocalServiceImpl::getInvitationOrganisation");
			//e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get organizations responded by invitation
	 */
	public String getInvitationRespons(long invitationId) throws SystemException {
		List<InvitationOrganisation> invitationorganisations = invitationOrganisationPersistence.findByInvitationOrganisations(invitationId);
		int respons = 0;
		int rejected = 0;
		for(InvitationOrganisation invitationorganisation : invitationorganisations) {
			if(invitationorganisation.getReactdate() != null) {
				respons ++;
			}
			if(invitationorganisation.getRejectdate() != null) {
				rejected ++;
			}
		}
		return "" + respons + "/" + rejected;
	}
	
	/**
	 * @throws SystemException 
	 */
	public List<InvitationOrganisation> getInvitationOrganisationByStatus() throws SystemException {
		/*DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(Invitation.class, "subQuery", PortalClassLoaderUtil.getClassLoader())
				.setProjection(ProjectionFactoryUtil.property("subQuery.invitationId"))
				.add(PropertyFactoryUtil.forName("subQuery.invitationId").eqProperty("answerdQuery.invitationId"))
				.add(PropertyFactoryUtil.forName("subQuery.invitationsend").isNotNull());
		
		DynamicQuery answerdQuery = DynamicQueryFactoryUtil.forClass(InvitationOrganisation.class, "answerdQuery", PortalClassLoaderUtil.getClassLoader())
				.add(PropertyFactoryUtil.forName("subQuery.invitationId").eq(subQuery));*/
		
		List<InvitationOrganisation> invitationorganisation = InvitationOrganisationLocalServiceUtil.dynamicQuery(answerdQuery);
		return invitationorganisation;
	}
}