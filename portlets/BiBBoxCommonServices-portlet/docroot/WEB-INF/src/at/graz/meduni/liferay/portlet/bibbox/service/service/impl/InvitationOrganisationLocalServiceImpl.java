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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsUtil;

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
	public List<InvitationOrganisation> getInvitationOrganisationByStatus(boolean rejacted) throws SystemException {
		/*DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(Invitation.class, "subQuery", PortalClassLoaderUtil.getClassLoader())
				.setProjection(ProjectionFactoryUtil.property("subQuery.invitationId"))
				.add(PropertyFactoryUtil.forName("subQuery.invitationId").eqProperty("answerdQuery.invitationId"))
				.add(PropertyFactoryUtil.forName("subQuery.invitationsend").isNotNull());
		
		DynamicQuery answerdQuery = DynamicQueryFactoryUtil.forClass(InvitationOrganisation.class, "answerdQuery", PortalClassLoaderUtil.getClassLoader())
				.add(PropertyFactoryUtil.forName("subQuery.invitationId").eq(subQuery));*/
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(InvitationOrganisation.class);
		Criterion criterion = null;
		if(rejacted) {
			criterion = RestrictionsFactoryUtil.isNotNull("reactdate");
			dynamicQuery.addOrder(OrderFactoryUtil.desc("reactdate"));
		} else {
			criterion = RestrictionsFactoryUtil.isNull("reactdate");
		}
		dynamicQuery.addOrder(OrderFactoryUtil.desc("invitationOrganisationId"));
		
		//dynamicQuery.setProjection(ProjectionFactoryUtil.groupProperty("organisationId"));
		
		dynamicQuery.add(criterion);
		
		List<InvitationOrganisation> invitationorganisation = InvitationOrganisationLocalServiceUtil.dynamicQuery(dynamicQuery);
		return invitationorganisation;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getInvitationStatisticsInvitationsSend() {
		String date = "";
		int count = 0;
		try {
			Connection connection = connectDatabase();
			String sql_grouped = "SELECT EXTRACT(YEAR FROM  DATE(inv.invitationsend)) date_year, EXTRACT(MONTH FROM  DATE(inv.invitationsend)) date_month, EXTRACT(DAY FROM  DATE(inv.invitationsend)) date_day, COUNT(*) FROM bibboxcs.invitation inv JOIN bibboxcs.invitation_organisation invor ON inv.invitationid = invor.invitationid WHERE inv.status >= 10 GROUP BY DATE(inv.invitationsend) ORDER BY DATE(inv.invitationsend);";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(sql_grouped);
			String prefix = "";
			while(resultset.next()) {
				count += resultset.getInt("count");
				date += prefix + "[Date.UTC(" + resultset.getString("date_year") + ",  " + (Integer.parseInt(resultset.getString("date_month")) -1) + ",  " + resultset.getString("date_day") + "), " + count + "   ]";
				prefix = ",";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getInvitationStatisticsReacted() {
		String date = "";
		int count = 0;
		try {
			Connection connection = connectDatabase();
			String sql_grouped = "SELECT EXTRACT(YEAR FROM  DATE(reactdate)) date_year, EXTRACT(MONTH FROM  DATE(reactdate)) date_month, EXTRACT(DAY FROM  DATE(reactdate)) date_day, COUNT(*) FROM bibboxcs.invitation_organisation WHERE reactdate IS NOT NULL GROUP BY DATE(reactdate) ORDER BY DATE(reactdate);";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(sql_grouped);
			String prefix = "";
			while(resultset.next()) {
				count += resultset.getInt("count");
				date += prefix + "[Date.UTC(" + resultset.getString("date_year") + ",  " + (Integer.parseInt(resultset.getString("date_month")) -1) + ",  " + resultset.getString("date_day") + "), " + count + "   ]";
				prefix = ",";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getInvitationStatisticsRejected() {
		String date = "";
		int count = 0;
		try {
			Connection connection = connectDatabase();
			String sql_grouped = "SELECT EXTRACT(YEAR FROM  DATE(rejectdate)) date_year, EXTRACT(MONTH FROM  DATE(rejectdate)) date_month, EXTRACT(DAY FROM  DATE(rejectdate)) date_day, COUNT(*) FROM bibboxcs.invitation_organisation WHERE rejectdate IS NOT NULL GROUP BY DATE(rejectdate) ORDER BY DATE(rejectdate);";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(sql_grouped);
			String prefix = "";
			while(resultset.next()) {
				count += resultset.getInt("count");
				date += prefix + "[Date.UTC(" + resultset.getString("date_year") + ",  " + (Integer.parseInt(resultset.getString("date_month")) -1) + ",  " + resultset.getString("date_day") + "), " + count + "   ]";
				prefix = ",";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}
	
	/**
	 * Connect to the liferay Database
	 * @return sql Connection
	 */
	private Connection connectDatabase() {

		try { 
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return null;
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(PropsUtil.get("jdbc.default.url"), PropsUtil.get("jdbc.default.username"),PropsUtil.get("jdbc.default.password"));
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
 
		if (connection != null) {
			System.out.println("Connected to database");
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
	}
}