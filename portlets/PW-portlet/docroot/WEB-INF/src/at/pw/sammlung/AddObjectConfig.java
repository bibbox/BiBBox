package at.pw.sammlung;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

public class AddObjectConfig extends DefaultConfigurationAction {
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		long numberofstructures = ParamUtil.getLong(actionRequest, "numberofstructures");
		System.out.println("numberofstructures: " + numberofstructures);
		String structuretemplate = "";
		String splitter = "";
		for(int i=0; i<numberofstructures; i++) {
			System.out.println("structuretemplateId_" + i + ": " + ParamUtil.getString(actionRequest, "structuretemplateId_" + i));
			structuretemplate += splitter + ParamUtil.getString(actionRequest, "structuretemplateId_" + i);		
			splitter  = ";";
		}
		System.out.println("articalTemplate: " + structuretemplate);
		super.setPreference(actionRequest, "articalTemplate", structuretemplate);
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
}
