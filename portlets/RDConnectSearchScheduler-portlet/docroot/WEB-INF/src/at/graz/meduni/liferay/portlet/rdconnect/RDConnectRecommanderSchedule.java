package at.graz.meduni.liferay.portlet.rdconnect;

import java.util.Date;
import java.util.List;

import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;

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
					long recommendervalue = 0;
					long diseaserecommandervalue = calucateDiseaseRecommanderValue(organization.getOrganizationId(), organizationrecommanded.getOrganizationId());
					calucateRecommanderValue(diseaserecommandervalue);
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
	private long calucateRecommanderValue(long diseaserecommandervalue) {
		return diseaserecommandervalue;
	}
	
	/**
	 * Calculates the DiseaseRecommanderValue for the organizations
	 * 
	 * @param organizationId
	 * @param organizationrecommandedId
	 * @return
	 */
	private long calucateDiseaseRecommanderValue(long organizationId, long organizationrecommandedId) {
		long recommandervalue = 0;
		try {
			List<DiseaseMatrix> diseasematrixes = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organizationId, -1, -1);
			List<DiseaseMatrix> diseasematrixrecommanderes = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organizationrecommandedId, -1, -1);
			for(DiseaseMatrix diseasematrix : diseasematrixes) {
				for(DiseaseMatrix diseasematrixrecommander : diseasematrixrecommanderes) {
					if(diseasematrix.getDiseasename().equals(diseasematrixrecommander.getDiseasename()) ||
							diseasematrix.getGene().equals(diseasematrixrecommander.getGene()) ||
							diseasematrix.getOrphanumber().equals(diseasematrixrecommander.getOrphanumber()) ||
							diseasematrix.getOrphanumber().equals(diseasematrixrecommander.getOrphanumber()) ||) {
						
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("ERROR: RDConnectRecommanderSchedule::calucateDiseaseRecommanderValue(long organizationId, long organizationrecommandedId)");
			ex.printStackTrace();
		}
		return recommandervalue;
	}

}
