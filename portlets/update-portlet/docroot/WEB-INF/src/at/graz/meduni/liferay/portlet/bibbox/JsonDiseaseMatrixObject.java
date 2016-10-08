/**
 * 
 */
package at.graz.meduni.liferay.portlet.bibbox;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import at.graz.meduni.liferay.portlet.bibbox.exception.JsonDiseaseMatrixObjectException;
import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder;
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.model.Networks;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.NetworksLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.util.MessageUtil;
import at.meduni.liferay.portlet.rdconnect.model.SearchIndex;
import at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

/**
 * @author reihsr
 *
 */
public class JsonDiseaseMatrixObject {
	/**
	 * Declare Error Variables
	 */
	String error_date_format_apache_pattern_ = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat error_date_format_apache_ = new SimpleDateFormat(error_date_format_apache_pattern_);
	String class_name_ = "update-portlet::at.graz.meduni.liferay.portlet.bibbox.JsonDiseaseMatrixObject";
	
	long idcardid_ = 0;
	String url_ = "";
	long diseaseid_ = 0;
	String diseasename_ = "";
	String patientcount_ = "";
	String gene_ = "";
	String orphanumber_ = "";
	String icd10_ = "";
	String omim_ = "";
	String synonym_ = "";
	
	Organization organization_ = null;
	DiseaseMatrix diseasmatrix_ = null;
	OrphanetDisorder orphanetdisorder_ = null;
	User user_ = null;
	
	MessageUtil message_ = new MessageUtil();
	
	public JsonDiseaseMatrixObject(User user, long idcardid, String url, long diseaseid, String diseasname, String patientcount, String gene, String orphanumber, String icd10, String omim, String synonym) {
		idcardid_ = idcardid;
		url_ = url;
		diseaseid_ = diseaseid;
		diseasename_ = diseasname;
		patientcount_ = patientcount;
		gene_ = gene;
		orphanumber_ = orphanumber;
		icd10_ = icd10;
		omim_ = omim;
		synonym_ = synonym;
		
		initObjectData();
	}
	
	private void initObjectData() {
		try {
			
			setOrganization();
			organizationCheckPermission();
			formatOrphanumber();
			searchOrphanumberInOrphadata();
			findDiseaseMatrix();
			if(diseasmatrix_ == null) {
				createNewDiseaseMatrixEntry();
			} else {
				updateDiseaseMatrixEntry();
			}
			saveDiseasMatrixChanges();
		} catch (JsonDiseaseMatrixObjectException exception) {
			System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::setOrganization()] Error getting Organization: " + exception.getMessage());
    		exception.printStackTrace();
    		// Exception Handling for information
		}
	}
	
	private void setOrganization() throws JsonDiseaseMatrixObjectException {
		try {
		if(idcardid_ != 0) {
			organization_ = OrganizationLocalServiceUtil.getOrganization(idcardid_);
		} else {
			findOrganizationByUrl();
		}
		} catch(Exception exception) {
			System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::setOrganization()] Error getting Organization: " + exception.getMessage());
    		exception.printStackTrace();
		}
		if(organization_ == null) {
			throw new JsonDiseaseMatrixObjectException("Error no matching Organization found.");
		}
		message_.addMessage("Updating Information for Organization: " + organization_.getOrganizationId() + " - " + organization_.getName());
	}
	
	private void findOrganizationByUrl() throws PortalException, SystemException {
		if(!url_.equals("")) {
			String value = url_.replaceAll("/$", "");
			List<Long> organizationIds = SearchIndexLocalServiceUtil.getOrganizationIdByKeywordAndValue("OrganizationURL", value);
			if(organizationIds.size() > 1) {
				System.err.println("More than one organization found with the same url");
			} else {
				for(long organizationid : organizationIds) {
					organization_ = OrganizationLocalServiceUtil.getOrganization(organizationid);
				}
			}
		}
	}
	
	private void organizationCheckPermission() throws JsonDiseaseMatrixObjectException {
		if(!checkPermission(user_, organization_)) {
			throw new JsonDiseaseMatrixObjectException("No Permisson to edit Organization.");
		}
	}
	
	/**
	 * Check for permissions of the user, also if the user is in a network that can update the reg/bb
	 * @param user
	 * @param organization
	 * @return
	 */
	private boolean checkPermission(User user, Organization organization) {
		if(user != null && organization != null) {
			try {
				List<Long> testorganizations = new ArrayList<Long>();
				testorganizations.add(organization.getOrganizationId());
				System.out.println("Add OrganizationId: " + organization.getOrganizationId());
				List<Networks> networks = NetworksLocalServiceUtil.getOrganizationNetworkOrganizations(organization.getOrganizationId());
				System.out.println("Network Size: " + networks.size());
				for(Networks network : networks) {
					if(!testorganizations.contains(network.getOrganizationnetworkId())) {
						testorganizations.add(network.getOrganizationnetworkId());
						System.out.println("Add OrganizationId: " + network.getOrganizationnetworkId());
					}
				}
				for(long userorganizationid : user.getOrganizationIds()) {
					System.out.println("Test User OrganizationIds: " + userorganizationid);
					if(testorganizations.contains(userorganizationid)) {
						return true;
					}
				}
			} catch (Exception exception) {
				System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::checkPermission(User user, Organization organization)] Error checking Permission for Organization: " + exception.getMessage());
	    		exception.printStackTrace();
			}
		}
		return false;
	}
	
	private void formatOrphanumber() {
		if(!orphanumber_.startsWith("ORPHA")) {
			if(orphanumber_.startsWith("O")) {
				orphanumber_ = orphanumber_.replaceFirst("O", "ORPHA");
			} else {
				orphanumber_ = "ORPHA" + orphanumber_;
			}
		}
	}
	
	private void searchOrphanumberInOrphadata() {
		try {
			orphanetdisorder_ = OrphanetDisorderLocalServiceUtil.getOrphanetDisorderByOrphanumber(getOrphanumberLong());
		} catch(Exception exception) {
			System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::searchOrphanumberInOrphadata()] Error finding OrphanetDisorder entry from orphanumber: " + " - " + exception.getMessage());
    		exception.printStackTrace();
    		message_.addMessage("Could not find Orphanet entry for OrphanetNumber: " + orphanumber_);
		} 
	}
	
	private long getOrphanumberLong() throws NumberFormatException {
		long orphanumber = 0;
		orphanumber = Long.valueOf(orphanumber_.replaceAll("ORPHA", ""));
		return orphanumber;
	}
	
	private void findDiseaseMatrix() {
		if(diseaseid_ != 0) {
			try {
				diseasmatrix_ = DiseaseMatrixLocalServiceUtil.getDiseaseMatrix(diseaseid_);
			} catch(Exception exception) {
				System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::findDiseaseMatrix()] Error finding Disease Matrix entry from diseaseid_: " + diseaseid_ + " - " + exception.getMessage());
	    		exception.printStackTrace();
			}
		} else {
			findDiseaseMatrixByOrphanumber();
			if(diseasmatrix_ == null && !diseasename_.equals("")) {
				findDiseaseMatrixByName();
			}
		}
	}
	
	private void findDiseaseMatrixByOrphanumber() {
		if(!orphanumber_.equals("")) {
			try {
				List<DiseaseMatrix> diseasematrixes = DiseaseMatrixLocalServiceUtil.getDiseaseMatirxByOrganizationAndOrphanumber(organization_.getOrganizationId(), orphanumber_);
				if(diseasematrixes.size() == 1) {
					diseasmatrix_ = diseasematrixes.get(0);
				} else {
					message_.addMessage("Multiple Entrys for OrphanetNumber: " + orphanumber_ + " found");
					selectDiseaseMatrixFromMultipleEntrys(diseasematrixes);
				}
			} catch(Exception exception) {
				System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::findDiseaseMatrixByOrphanumber()] Error finding Disease Matrix entry from orphanumber_: " + orphanumber_ + " - " + exception.getMessage());
	    		exception.printStackTrace();
			}
		}
	}
	
	private void selectDiseaseMatrixFromMultipleEntrys(List<DiseaseMatrix> diseasematrixes) {
		for(DiseaseMatrix diseasematrix : diseasematrixes) {
			if(diseasematrix.getDiseasename().equalsIgnoreCase(diseasename_)) {
				diseasmatrix_ = diseasematrix;
			}
		}
	}
	
	private void findDiseaseMatrixByName() {
		List<SearchIndex> searchindexs = SearchIndexLocalServiceUtil.getSearchIndexByOrganizationKeyValue(organization_.getOrganizationId(), "DiseaseName", diseasename_.trim());
		for(SearchIndex searchindex : searchindexs) {
			try {
				selectSearchIndexDiseaseMatrixResult(searchindex);
			} catch(Exception exception) {
				System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::findDiseaseMatrixByName()] Error getting Disease Matrix entry from SearchIndex: " + exception.getMessage());
		    	exception.printStackTrace();
			}
		}
	}
	
	private void selectSearchIndexDiseaseMatrixResult(SearchIndex searchindex) throws PortalException, SystemException {
		if(searchindex.getValue().equalsIgnoreCase(diseasename_)) {
			diseasmatrix_ = DiseaseMatrixLocalServiceUtil.getDiseaseMatrix(searchindex.getLocationid());
		}
	}
	
	private void createNewDiseaseMatrixEntry() {
		try {
			diseasmatrix_ = DiseaseMatrixLocalServiceUtil.createEmpltyDiseaseMatrix();
			diseasmatrix_.setOrganizationId(organization_.getOrganizationId());
			diseasmatrix_.setDiseasename(diseasename_);
			diseasmatrix_.setPatientcount(patientcount_);
			diseasmatrix_.setGene(gene_);
			diseasmatrix_.setOrphanumber(orphanumber_);
			diseasmatrix_.setIcd10(icd10_);
			diseasmatrix_.setOmim(omim_);
			diseasmatrix_.setSynonym(synonym_);
			diseasmatrix_.setModifieddate(new Date());
			diseasmatrix_.setModifieduser(user_.getFullName());
		} catch (Exception exception) {
			System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::addNewDiseaseMatrixEntry()] Error creating Disease Matrix entry: " + exception.getMessage());
	    	exception.printStackTrace();
		}
	}
	
	private void updateDiseaseMatrixEntry() {
		diseasmatrix_.setOrganizationId(organization_.getOrganizationId());
		diseasmatrix_.setDiseasename(diseasename_);
		diseasmatrix_.setPatientcount(patientcount_);
		diseasmatrix_.setGene(gene_);
		diseasmatrix_.setOrphanumber(orphanumber_);
		diseasmatrix_.setIcd10(icd10_);
		diseasmatrix_.setOmim(omim_);
		diseasmatrix_.setSynonym(synonym_);
		diseasmatrix_.setModifieddate(new Date());
		diseasmatrix_.setModifieduser(user_.getFullName());
	}
	
	private void saveDiseasMatrixChanges() {
		
	}
}
