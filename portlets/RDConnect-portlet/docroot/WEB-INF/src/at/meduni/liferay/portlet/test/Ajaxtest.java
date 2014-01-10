package at.meduni.liferay.portlet.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Ajaxtest
 */
public class Ajaxtest extends MVCPortlet {
	public void somethingHappensHere(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException { 
		System.out.println("ID: " + ParamUtil.getString(actionRequest, "id"));
		System.out.println("Name: " + ParamUtil.getString(actionRequest, "name"));
		System.out.println("Somthing has happend");
		
		//DDLRecordSet rs = DDLRecordSetLocalServiceUtil.getR;
		
		//DDLRecordSet rs = DDLRecordSetLocalServiceUtil.getRecordSet(14503);
		
		//rs.getNameCurrentValue()
	} 
}
