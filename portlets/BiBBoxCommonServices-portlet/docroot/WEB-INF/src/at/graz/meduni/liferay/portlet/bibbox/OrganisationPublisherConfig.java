/**
 * 
 */
package at.graz.meduni.liferay.portlet.bibbox;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

/**
 * @author reihsr
 *
 */
public class OrganisationPublisherConfig extends DefaultConfigurationAction {//ConfigurationAction {

	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		
		long numberofddls = ParamUtil.getLong(actionRequest, "bibbox_cs_numberofddls");
		String ddloption = "";
		for(int i=0; i<numberofddls; i++) {
			ddloption += ParamUtil.getString(actionRequest, "bibbox_cs_ddlstatus_" + i);
			ddloption += "\"" + ParamUtil.getString(actionRequest, "bibbox_cs_ddlname_" + i) + "\"_";		
		}
		super.setPreference(actionRequest, "optionsDDLGeneration", ddloption);
		super.processAction(portletConfig, actionRequest, actionResponse);

		PortletPreferences prefs = actionRequest.getPreferences();

        String optionsOrganisationName = prefs.getValue("optionsOrganisationName", "not set");

        System.out.println("optionsOrganisationName=" + optionsOrganisationName +" in ConfigurationActionImpl.processAction().");
	}

}
