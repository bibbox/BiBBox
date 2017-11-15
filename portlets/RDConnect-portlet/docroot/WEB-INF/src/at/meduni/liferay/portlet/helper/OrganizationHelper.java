package at.meduni.liferay.portlet.helper;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

public class OrganizationHelper {
	
	public static String getBiomaterialcollectedinbiobankFormated(String biobankids) {
		System.out.print(biobankids);
		if(biobankids != null) {
			if(biobankids.equals("")) {
				return "";
			} else {
				return formatBiomaterialCollectedInBiobank(biobankids);
			}
		} else {
			return "";
		}
	}
	
	private static String formatBiomaterialCollectedInBiobank(String biobankids) {
		String return_string = "";
		List<Organization> organizations = getOrganizationList(biobankids);
		for(Organization organization : organizations) {
			return_string += createOrganizationIcon(organization);
		}
		return return_string;
	}
	
	private static List<Organization> getOrganizationList(String organizationIds) {
		List<Organization> organizations = new ArrayList<Organization>();
		for(String id : organizationIds.split(";")) {
			try {
				long organizationId = Long.valueOf(id);
				organizations.add(OrganizationLocalServiceUtil.getOrganization(organizationId));
			} catch(Exception ex) {
				System.err.println("Error reading Organization with id: " + id);
				ex.printStackTrace();
			}
		}
		return organizations;
	}
	
	private static String createOrganizationIcon(Organization organization) {
		
		String imgPath = "/image/layout_set_logo?img_id="+organization.getLogoId();
		String orgPath = "/web"+organization.getGroup().getFriendlyURL();
		String organizationtype = organization.getExpandoBridge().getAttribute("Organization Type").toString();
		if(organizationtype.equalsIgnoreCase("Biobank")) {
			if(organization.getLogoId() == 0) {
				imgPath = "/BiBBoxCommonServices-portlet/images/Biobank.png";
			}
			orgPath = orgPath + "/bb_home";	
		} else {
			if(organization.getLogoId() == 0) {
				imgPath = "/BiBBoxCommonServices-portlet/images/Registry.png";
			}
			orgPath = orgPath + "/reg_home";
		}
		// Table 590 breite
		String table = "<table style=\"width:590px\"><tr><td>";
		table += "<td width=\"80px\"><a href=\"" + orgPath + "\"><img alt=\"logo\" src=\"" + imgPath + "\" width=\"60px\" /></a></td>";
		table += "<td width=\"500px\"><a href=\"" + orgPath + "\">" + organization.getName() + "</a></td></tr></table>";
		System.out.println("Table:" + table);
		return table;
	}
}
