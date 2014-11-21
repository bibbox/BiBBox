package com.bcnet.portlet.biobank;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.bcnet.portlet.biobank.model.BiobankAttributeLists;
import com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BiobankAttributeListsPortlet
 */
public class BiobankAttributeListsPortlet extends MVCPortlet {

	public void addBiobankAttributeLists(ActionRequest request,
            ActionResponse response) throws SystemException, IOException{
        
        editBiobankAttributeListsTypeOfRepository(request, response);
        editBiobankAttributeListsDataManagement(request, response);
        editBiobankAttributeListsDatabase(request, response);
        editBiobankAttributeListsStorageFacility(request, response);
        editBiobankAttributeListsMonitoring(request, response);
        editBiobankAttributeListsGeneticPlatform(request, response);
        editBiobankAttributeListsProteomicsPlatform(request, response);
        editBiobankAttributeListsMetabolomicsPlatform(request, response);
        editBiobankAttributeListsEpigenomicsPlatform(request, response);
        editBiobankAttributeListsBioinformaticsDataAnalysisService(request, response);
        editBiobankAttributeListsComplementaryServices(request, response);
        editBiobankAttributeListsAutomationServices(request, response);
        editBiobankAttributeListsAvailableDocuments(request, response);
        
        sendRedirect(request, response);
    }


	private void editBiobankAttributeListsTypeOfRepository(ActionRequest request,
			ActionResponse response) throws SystemException{
		
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
        String[] availabletor = ParamUtil.getParameterValues(request, "availabletor");
        String[] selectedtor = ParamUtil.getParameterValues(request, "selectedtor");
        
        editBiobankAttributeLists(biobankDbId, availabletor, selectedtor);
		
	}
	
	
	private void editBiobankAttributeListsDataManagement(ActionRequest request,
			ActionResponse response) throws SystemException{
		
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
        String[] availabledm = ParamUtil.getParameterValues(request, "availabledm");
        String[] selecteddm = ParamUtil.getParameterValues(request, "selecteddm");
        
        editBiobankAttributeLists(biobankDbId, availabledm, selecteddm);
         
	}
	
	
	private void editBiobankAttributeListsDatabase(ActionRequest request,
			ActionResponse response) throws SystemException {

		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
        String[] availabledb = ParamUtil.getParameterValues(request, "availabledb");
        String[] selecteddb = ParamUtil.getParameterValues(request, "selecteddb");
        
        editBiobankAttributeLists(biobankDbId, availabledb, selecteddb);
 		
	}
	
	
	private void editBiobankAttributeListsStorageFacility(
			ActionRequest request, ActionResponse response) throws SystemException{

		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		String[] availablesf = ParamUtil.getParameterValues(request, "availablesf");
        String[] selectedsf = ParamUtil.getParameterValues(request, "selectedsf");
        
        editBiobankAttributeLists(biobankDbId, availablesf, selectedsf);
        
	}
	
	
	private void editBiobankAttributeListsMonitoring(ActionRequest request,
			ActionResponse response) throws SystemException {
		
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		String[] availablem = ParamUtil.getParameterValues(request, "availablem");
        String[] selectedm = ParamUtil.getParameterValues(request, "selectedm");
        
        editBiobankAttributeLists(biobankDbId, availablem, selectedm);
		
	}
	
	
	private void editBiobankAttributeListsGeneticPlatform(
			ActionRequest request, ActionResponse response) throws SystemException {
		
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		String[] availablegp = ParamUtil.getParameterValues(request, "availablegp");
        String[] selectedgp = ParamUtil.getParameterValues(request, "selectedgp");
        
        editBiobankAttributeLists(biobankDbId, availablegp, selectedgp);
		
	}
	
	
	private void editBiobankAttributeListsProteomicsPlatform(
			ActionRequest request, ActionResponse response) throws SystemException {

		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		String[] availablepp = ParamUtil.getParameterValues(request, "availablepp");
        String[] selectedpp = ParamUtil.getParameterValues(request, "selectedpp");
        
        editBiobankAttributeLists(biobankDbId, availablepp, selectedpp);
		
	}
	
	
	private void editBiobankAttributeListsMetabolomicsPlatform(
			ActionRequest request, ActionResponse response) throws SystemException {
		
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		String[] availablemp = ParamUtil.getParameterValues(request, "availablemp");
        String[] selectedmp = ParamUtil.getParameterValues(request, "selectedmp");
        
        editBiobankAttributeLists(biobankDbId, availablemp, selectedmp);
		
	}
	
	
	private void editBiobankAttributeListsEpigenomicsPlatform(
			ActionRequest request, ActionResponse response) throws SystemException {
		
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		String[] availableep = ParamUtil.getParameterValues(request, "availableep");
        String[] selectedep = ParamUtil.getParameterValues(request, "selectedep");
        
        editBiobankAttributeLists(biobankDbId, availableep, selectedep);
		
	}
	
	
	private void editBiobankAttributeListsBioinformaticsDataAnalysisService(
			ActionRequest request, ActionResponse response) throws SystemException {
		
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		String[] availablebdas = ParamUtil.getParameterValues(request, "availablebdas");
        String[] selectedbdas = ParamUtil.getParameterValues(request, "selectedbdas");
        
        editBiobankAttributeLists(biobankDbId, availablebdas, selectedbdas);
		
	}
	
	
	private void editBiobankAttributeListsComplementaryServices(
			ActionRequest request, ActionResponse response) throws SystemException {
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		String[] availablecs = ParamUtil.getParameterValues(request, "availablecs");
        String[] selectedcs = ParamUtil.getParameterValues(request, "selectedcs");
        
        editBiobankAttributeLists(biobankDbId, availablecs, selectedcs);
		
	}
	
	
	private void editBiobankAttributeListsAutomationServices(
			ActionRequest request, ActionResponse response) throws SystemException {
		
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		String[] availableas = ParamUtil.getParameterValues(request, "availableas");
        String[] selectedas = ParamUtil.getParameterValues(request, "selectedas");
        
        editBiobankAttributeLists(biobankDbId, availableas, selectedas);
		
	}
	
	
	private void editBiobankAttributeListsAvailableDocuments(
			ActionRequest request, ActionResponse response) throws SystemException {
		
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		String[] availablead = ParamUtil.getParameterValues(request, "availablead");
        String[] selectedad = ParamUtil.getParameterValues(request, "selectedad");
        
        editBiobankAttributeLists(biobankDbId, availablead, selectedad);
		
	}
	
	private void editBiobankAttributeLists(long biobankDbId, String[] available, String[] selected) throws SystemException{
		
		/* Input-move-boxes add/update/delete logic for Biobank Attribute Lists */

		for(String str : available){
        	String attributeListName = str.split("_")[0];
        	String attributeListValue = str.split("_")[1];
        	
        	BiobankAttributeLists biobankAttributeLists = null;
        	biobankAttributeLists = BiobankAttributeListsLocalServiceUtil.
        			getBiobankAtrributeListsByBiobankDbId_AttributeListName_AttributeListValue(biobankDbId, attributeListName, attributeListValue);
        	
        	if(biobankAttributeLists != null){
        		BiobankAttributeListsLocalServiceUtil.deleteBiobankAttributeLists(biobankDbId, attributeListName, attributeListValue);
        	}
        	
        }
		
		for(String str : selected){
        	String attributeListName = str.split("_")[0];
        	String attributeListValue = str.split("_")[1];
        	
        	BiobankAttributeLists biobankAttributeLists = null;
        	biobankAttributeLists = BiobankAttributeListsLocalServiceUtil.
        			getBiobankAtrributeListsByBiobankDbId_AttributeListName_AttributeListValue(biobankDbId, attributeListName, attributeListValue);
        	
        	if(biobankAttributeLists != null){
        		continue;
        	}
        	else{
        		BiobankAttributeListsLocalServiceUtil.addBiobankAttributeLists(biobankDbId, attributeListName, attributeListValue);
        	}
        	
        }
	}
	
}
