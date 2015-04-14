package at.graz.meduni.liferay.portlet.rdconnect;

import java.util.Date;
import java.util.List;

import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.service.RDCRecommenderLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.model.RDCRecommender;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

public class RDConnectRecommanderSchedule implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		System.out.println("----------------------");
		System.out.println("RDConnectRecommanderSchedule Start");
		System.out.println(new Date().toString());
		
		try {
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(Long.parseLong("10154"), Long.parseLong("10709"));
			for(Organization organization : organizations) {
				for(Organization organizationrecommanded : organizations) {
					double recommendervalue = 0;
					double diseaserecommandervalue = calucateDiseaseRecommanderValue(organization.getOrganizationId(), organizationrecommanded.getOrganizationId());
					recommendervalue = calucateRecommanderValue(diseaserecommandervalue);
					RDCRecommender recommander = RDCRecommenderLocalServiceUtil.getRDCRecommender(organization.getOrganizationId(), organizationrecommanded.getOrganizationId());
					if(recommander != null) {
						recommander.setRecommendervalue(recommendervalue);
						RDCRecommenderLocalServiceUtil.updateRDCRecommender(recommander);
					} else {
						RDCRecommenderLocalServiceUtil.addRDCRecommender(organization.getOrganizationId(), organizationrecommanded.getOrganizationId(), recommendervalue);
					}
				}
			}
		} catch(Exception ex) {
			System.out.println("ERROR: RDConnectRecommanderSchedule::receive(Message message)");
			ex.printStackTrace();
		}
		
		System.out.println("RDConnectRecommanderSchedule Done");
		System.out.println(new Date().toString());
		System.out.println("----------------------");
	}
	
	/**
	 * Calculate the RecommanderValue of all part values
	 * 
	 * @param diseaserecommandervalue
	 * @return
	 */
	private double calucateRecommanderValue(double diseaserecommandervalue) {
		return diseaserecommandervalue;
	}
	
	/**
	 * Calculates the DiseaseRecommanderValue for the organizations
	 * 
	 * @param organizationId
	 * @param organizationrecommandedId
	 * @return
	 */
	private double calucateDiseaseRecommanderValue(long organizationId, long organizationrecommandedId) {
		double recommandervalue = 0;
		int counter = 0;
		try {
			List<DiseaseMatrix> diseasematrixes = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organizationId, -1, -1);
			List<DiseaseMatrix> diseasematrixrecommanderes = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organizationrecommandedId, -1, -1);
			for(DiseaseMatrix diseasematrix : diseasematrixes) {
				for(DiseaseMatrix diseasematrixrecommander : diseasematrixrecommanderes) {
					if((diseasematrix.getDiseasename().equals(diseasematrixrecommander.getDiseasename()) && !diseasematrix.getDiseasename().equals("")) ||
							(diseasematrix.getGene().equals(diseasematrixrecommander.getGene()) && !diseasematrix.getGene().equals("")) ||
							(diseasematrix.getOrphanumber().equals(diseasematrixrecommander.getOrphanumber()) && !diseasematrix.getOrphanumber().equals("")) ||
							(diseasematrix.getIcd10().equals(diseasematrixrecommander.getIcd10()) && !diseasematrix.getIcd10().equals("")) ||
							(diseasematrix.getOmim().equals(diseasematrixrecommander.getOmim())&& !diseasematrix.getOmim().equals("")) ) {
						recommandervalue ++;	
					}
				}
				counter ++;
			}
		} catch (Exception ex) {
			System.out.println("ERROR: RDConnectRecommanderSchedule::calucateDiseaseRecommanderValue(long organizationId, long organizationrecommandedId)");
			ex.printStackTrace();
		}
		if(counter == 0) {
			return 0;
		}
		return recommandervalue/counter;
	}

}
