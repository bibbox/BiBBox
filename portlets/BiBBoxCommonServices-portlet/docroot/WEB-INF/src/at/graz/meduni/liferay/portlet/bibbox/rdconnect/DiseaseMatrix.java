package at.graz.meduni.liferay.portlet.bibbox.rdconnect;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DiseaseMatrix
 */
public class DiseaseMatrix extends MVCPortlet {
	/**
	 * Adds a new DiseaseMatrix to the database
	 * 
	 */
	public void addDiseaseMatrix(ActionRequest request, ActionResponse response)
		throws Exception {

		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrix = DiseaseMatrixLocalServiceUtil.diseaseMatrixFromRequest(request);
		DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix);

		sendRedirect(request, response);
	}

	
	/**
	 * Updates the database record of an existing DiseaseMatrix.
	 *
	 */
	public void updateDiseaseMatrix(ActionRequest request, ActionResponse response)
		throws Exception {

		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrix = DiseaseMatrixLocalServiceUtil.diseaseMatrixFromRequest(request);
		DiseaseMatrixLocalServiceUtil.updateDiseaseMatrix(diseasematrix);
		sendRedirect(request, response);
	}

}
