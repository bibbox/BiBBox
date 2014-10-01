package at.graz.meduni.liferay.portlet.bibbox.organisation;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class OrganisationLister
 */
public class OrganisationLister extends MVCPortlet {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.
	 * ResourceRequest, javax.portlet.ResourceResponse)
	 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			long organizationId = ParamUtil.getLong(resourceRequest, "organizationId");
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json = new OrganizationAggregater().aggregateOrganizationDataForOrganizationlist(json, organizationId);
			
			resourceResponse.getPortletOutputStream().write(json.toString().getBytes());
		} catch (IOException e) {
			System.out.println("-----------------------------------------");
			System.out.println("BiBBox Exception in People::serveResource");
			System.out.println("IOException");
			e.printStackTrace();
		}
	}

	public void deleteOrganization(ActionRequest request, ActionResponse response) throws Exception {
		try {
			long organizationid = ParamUtil.getLong(request, "bibbox_cs_organisationid");
			long deleteto = ParamUtil.getLong(request, "bibbox_cs_deleteto");
			if(deleteto == 0) {
				deleteOrganization(organizationid);
			} else {
				try {
					Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationid);
					organization.setParentOrganizationId(deleteto);
					OrganizationLocalServiceUtil.updateOrganization(organization);
				} catch(Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			System.out.println("------------------------------------------------------");
			System.out.println("BiBBox Exception in People::deleteUserFromOrganisation");
			System.out.println("Exception");
			e.printStackTrace();
		}
	}

	private void deleteOrganization(long organizationid) {
		try {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationid);
			for(Organization suborganizations : organization.getSuborganizations()) {
				deleteOrganization(suborganizations.getOrganizationId());
			}
			List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
			for(User u : userlist) {
				OrganizationLocalServiceUtil.deleteUserOrganization(u.getUserId(), organization);
			}
			OrganizationLocalServiceUtil.deleteOrganization(organization);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
