package at.graz.meduni.liferay.portlet.rdconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.model.Website;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WebsiteLocalServiceUtil;

public class RDConnectSearchSchedule implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		String uuid = PortalUUIDUtil.generate();
		System.out.println("----------------------");
		System.out.println("RDConnectSearchSchedule Start: " + uuid);
		System.out.println(new Date().toString());
		// DB Statements
		String sql_organizationtype = "SELECT data_ FROM expandovalue WHERE classpk = ?;";
		String sql_select_searchid = "SELECT searchid FROM rdconnect.searchindex_rdconnect WHERE organisationid = ?;";
		String sql_update_searchindex = "UPDATE rdconnect.searchindex_rdconnect SET locationid=?, location=?, key_=?, value=? WHERE searchid=?;";
		String sql_insert_searchindex = "INSERT INTO rdconnect.searchindex_rdconnect(searchid,organisationid, locationid, location, key_, value) VALUES (nextval('rdconnect.searchindex_rdconnect_searchid_seq'),?, ?, ?, ?, ?);";
		String sql_delete_searchindex = "DELETE FROM rdconnect.searchindex_rdconnect WHERE searchid=?;";
		Connection connection = connectDatabase();
		PreparedStatement statement_organizationtype = null;
		PreparedStatement statement_select_searchid = null;
		PreparedStatement statement_update_searchindex = null;
		PreparedStatement statement_insert_searchindex = null;
		PreparedStatement statement_delete_searchindex = null;
		try {
			statement_organizationtype = connection.prepareStatement(sql_organizationtype);
			statement_select_searchid = connection.prepareStatement(sql_select_searchid);
			statement_update_searchindex = connection.prepareStatement(sql_update_searchindex);
			statement_insert_searchindex = connection.prepareStatement(sql_insert_searchindex);
			statement_delete_searchindex = connection.prepareStatement(sql_delete_searchindex);
		} catch (SQLException e) {
			System.err.println("RDConnectSearchScheduler::RDConnectSearchSchedule::receive->PreparedStatements");
			e.printStackTrace();
		}
		
		try {
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(Long.parseLong("10154"), Long.parseLong("10709"));
			System.out.println("Indexing n: " + organizations.size() + " Organizations");
			for(Organization organization : organizations) {
				//System.out.print(organization.getName());
				HashSet<RDConnectSearchIndexObject> organizationindex = new HashSet<RDConnectSearchIndexObject>();
				organizationindex.addAll(getIndexFromOrganization(organization.getOrganizationId(), organization, statement_organizationtype));
				organizationindex.addAll(getIndexFromDisease(organization.getOrganizationId()));
				
				updateIndexForOrganisation(organization.getOrganizationId(), organizationindex, statement_select_searchid, statement_update_searchindex, statement_insert_searchindex, statement_delete_searchindex);
			}
		} catch (SystemException e) {
			System.err.println("RDConnectSearchScheduler::RDConnectSearchSchedule::receive->CreateIndex");
			e.printStackTrace();
		}
		
		System.out.println("RDConnectSearchSchedule Done: " + uuid);
		System.out.println(new Date().toString());
		System.out.println("----------------------");
	}

	/**
	 * 
	 * @param organizationindex
	 * @param statement_select_searchid
	 * @param statement_update_searchindex
	 * @param statement_insert_searchindex
	 * @param statement_delete_searchindex
	 */
	private void updateIndexForOrganisation(long organizationId, HashSet<RDConnectSearchIndexObject> organizationindex, PreparedStatement statement_select_searchid,
			PreparedStatement statement_update_searchindex, PreparedStatement statement_insert_searchindex, PreparedStatement statement_delete_searchindex) {
		try {
			// Cleate list with all existing searchIds
			HashSet<Long> searchids = new HashSet<Long>();
			statement_select_searchid.clearParameters();
			statement_select_searchid.setLong(1, organizationId);
			statement_select_searchid.executeQuery();
			ResultSet resultset = statement_select_searchid.getResultSet();
			while(resultset.next()) {
				searchids.add(resultset.getLong("searchid"));
			}
			Iterator searchidsiterator = searchids.iterator();
			// Update/Insert the index
			for(RDConnectSearchIndexObject index : organizationindex) {
				/*if(index.getValue().equalsIgnoreCase("OrganizationURL")) {
					System.out.println("insert Index:" + "OrganizationURL=" + index.getKey());
				}*/
				if(searchidsiterator.hasNext()) {
					// Update
					statement_update_searchindex.clearParameters();
					statement_update_searchindex.setLong(1, index.getLocationId());
					statement_update_searchindex.setString(2, index.getLocation());
					statement_update_searchindex.setString(3, index.getKey());
					statement_update_searchindex.setString(4, index.getValue());
					statement_update_searchindex.setLong(5, Long.parseLong(searchidsiterator.next().toString()));
					statement_update_searchindex.execute();
				} else {
					// Insert
					statement_insert_searchindex.clearParameters();
					statement_insert_searchindex.setLong(1, index.getOrganizationId());
					statement_insert_searchindex.setLong(2, index.getLocationId());
					statement_insert_searchindex.setString(3, index.getLocation());
					statement_insert_searchindex.setString(4, index.getKey());
					statement_insert_searchindex.setString(5, index.getValue());
					statement_insert_searchindex.execute();
				}
			}
			while(searchidsiterator.hasNext()) {
				statement_delete_searchindex.clearParameters();
				statement_delete_searchindex.setLong(1, Long.parseLong(searchidsiterator.next().toString()));
				statement_delete_searchindex.execute();
			}
			
		} catch (SQLException e) {
			System.err.println("RDConnectSearchScheduler::RDConnectSearchSchedule::updateIndexForOrganisation");
			e.printStackTrace();
		}
	}

	/**
	 * Get all index elements for diseases
	 * @param organizationId
	 * @return
	 */
	private HashSet<RDConnectSearchIndexObject> getIndexFromDisease(long organizationId) {
		HashSet<RDConnectSearchIndexObject> returnvalue = new HashSet<RDConnectSearchIndexObject>();
		try {
			for(DiseaseMatrix diseasematrix : DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organizationId, -1, -1)) {
				// DiseaseName
				RDConnectSearchIndexObject organizationdiseasename = new RDConnectSearchIndexObject();
				organizationdiseasename.setOrganizationId(organizationId);
				organizationdiseasename.setLocationId(diseasematrix.getDiseasematrixId());
				organizationdiseasename.setLocation("Diseases");
				organizationdiseasename.setKey("DiseaseName");
				organizationdiseasename.setValue(diseasematrix.getDiseasename());
				returnvalue.add(organizationdiseasename);
				// PatientCount
				RDConnectSearchIndexObject organizationdiseasecount = new RDConnectSearchIndexObject();
				organizationdiseasecount.setOrganizationId(organizationId);
				organizationdiseasecount.setLocationId(diseasematrix.getDiseasematrixId());
				organizationdiseasecount.setLocation("Diseases");
				organizationdiseasecount.setKey("PatientCount");
				organizationdiseasecount.setValue(diseasematrix.getPatientcount());
				returnvalue.add(organizationdiseasecount);
				// PatientGene
				RDConnectSearchIndexObject organizationdiseasegene = new RDConnectSearchIndexObject();
				organizationdiseasegene.setOrganizationId(organizationId);
				organizationdiseasegene.setLocationId(diseasematrix.getDiseasematrixId());
				organizationdiseasegene.setLocation("Diseases");
				organizationdiseasegene.setKey("Gene");
				organizationdiseasegene.setValue(diseasematrix.getGene());
				returnvalue.add(organizationdiseasegene);
				// PatientOrhacode
				RDConnectSearchIndexObject organizationorhacode = new RDConnectSearchIndexObject();
				organizationorhacode.setOrganizationId(organizationId);
				organizationorhacode.setLocationId(diseasematrix.getDiseasematrixId());
				organizationorhacode.setLocation("Diseases");
				organizationorhacode.setKey("Orpha");
				organizationorhacode.setValue(diseasematrix.getOrphanumber());
				returnvalue.add(organizationorhacode);
				// PatientICD10
				RDConnectSearchIndexObject organizationic10 = new RDConnectSearchIndexObject();
				organizationic10.setOrganizationId(organizationId);
				organizationic10.setLocationId(diseasematrix.getDiseasematrixId());
				organizationic10.setLocation("Diseases");
				organizationic10.setKey("ICD10");
				organizationic10.setValue(diseasematrix.getIcd10());
				returnvalue.add(organizationic10);
				// PatientOmim
				RDConnectSearchIndexObject organizationomim = new RDConnectSearchIndexObject();
				organizationomim.setOrganizationId(organizationId);
				organizationomim.setLocationId(diseasematrix.getDiseasematrixId());
				organizationomim.setLocation("Diseases");
				organizationomim.setKey("OMIM");
				organizationomim.setValue(diseasematrix.getOmim());
				returnvalue.add(organizationomim);
				// PatientSynonym
				RDConnectSearchIndexObject organizationsynonym = new RDConnectSearchIndexObject();
				organizationsynonym.setOrganizationId(organizationId);
				organizationsynonym.setLocationId(diseasematrix.getDiseasematrixId());
				organizationsynonym.setLocation("Diseases");
				organizationsynonym.setKey("DiseasesSynonym");
				organizationsynonym.setValue(diseasematrix.getSynonym());
				returnvalue.add(organizationsynonym);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnvalue;
	}
	
	/**
	 * Get all index elements from organization
	 * -Organization Name
	 * -Address
	 * -User
	 * -Type
	 */
	private HashSet<RDConnectSearchIndexObject> getIndexFromOrganization(long organizationId, Organization organization, PreparedStatement statement_organizationtype) {
		HashSet<RDConnectSearchIndexObject> returnvalue = new HashSet<RDConnectSearchIndexObject>();
		// OrganizationName
		RDConnectSearchIndexObject organizationindex = new RDConnectSearchIndexObject();
		organizationindex.setOrganizationId(organizationId);
		organizationindex.setLocationId(organizationId);
		organizationindex.setLocation("Organization");
		organizationindex.setKey("OrganizationName");
		organizationindex.setValue(organization.getName());
		returnvalue.add(organizationindex);
		// OrganizationType
		String type = "";
		try {
			statement_organizationtype.clearParameters();
			statement_organizationtype.setLong(1, organizationId);
			ResultSet result = statement_organizationtype.executeQuery();
			while(result.next()) {
				type = result.getString("data_");
			}
		} catch (SQLException e1) {
			System.err.println("RDConnectSearchScheduler::RDConnectSearchSchedule::getIndexFromOrganization->OrganizationType");
			e1.printStackTrace();
		}
		RDConnectSearchIndexObject organizationtype = new RDConnectSearchIndexObject();
		organizationtype.setOrganizationId(organizationId);
		organizationtype.setLocationId(organizationId);
		organizationtype.setLocation("Organization");
		organizationtype.setKey("Type");
		organizationtype.setValue(type);
		returnvalue.add(organizationtype);
		// OrganizationAddress
		RDConnectSearchIndexObject organizationcountry = null;
		try {
			for(Address address : organization.getAddresses()) {
				RDConnectSearchIndexObject organizationaddress = new RDConnectSearchIndexObject();
				organizationaddress.setOrganizationId(organizationId);
				organizationaddress.setLocationId(address.getAddressId());
				organizationaddress.setLocation("Address");
				organizationaddress.setKey("Street");
				organizationaddress.setValue(address.getStreet1() + "<br>" + address.getStreet2() + "<br>" + address.getStreet3() + "<br>" + address.getZip() + " " + address.getCity()  + "<br>" + address.getCountry().getNameCurrentValue());
				returnvalue.add(organizationaddress);
				if(organizationcountry == null) {
					organizationcountry = organizationaddress;
					organizationcountry.setKey("Country");
					organizationcountry.setValue(address.getCountry().getNameCurrentValue());
					returnvalue.add(organizationcountry);
				}
			}
		} catch (SystemException e) {
			System.err.println("RDConnectSearchScheduler::RDConnectSearchSchedule::getIndexFromOrganization->OrganizationAddress");
			e.printStackTrace();
		}
		// OrganizationUser
		try {
			for(User user : UserLocalServiceUtil.getOrganizationUsers(organizationId)) {
				RDConnectSearchIndexObject organizationuser = new RDConnectSearchIndexObject();
				organizationuser.setOrganizationId(organizationId);
				organizationuser.setLocationId(user.getUserId());
				organizationuser.setLocation("User");
				organizationuser.setKey("UserName");
				organizationuser.setValue(user.getFullName());
				returnvalue.add(organizationuser);
			}
		} catch (SystemException e) {
			System.err.println("RDConnectSearchScheduler::RDConnectSearchSchedule::getIndexFromOrganization->OrganizationUser");
			e.printStackTrace();
		}
		// OrganizationURL
		try {
			List<Website> websites = WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
			for(Website website : websites) {
				RDConnectSearchIndexObject organizationurl = new RDConnectSearchIndexObject();
				organizationurl.setOrganizationId(organizationId);
				organizationurl.setLocationId(website.getWebsiteId());
				organizationurl.setLocation("Organization");
				organizationurl.setKey("OrganizationURL");
				organizationurl.setValue(website.getUrl());
				returnvalue.add(organizationurl);
				//System.out.println("create Index:" + "OrganizationURL=" + website.getUrl());
			}
		} catch (SystemException e) {
			System.err.println("RDConnectSearchScheduler::RDConnectSearchSchedule::getIndexFromOrganization->OrganizationURL");
			e.printStackTrace();
		}
		return returnvalue;
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
