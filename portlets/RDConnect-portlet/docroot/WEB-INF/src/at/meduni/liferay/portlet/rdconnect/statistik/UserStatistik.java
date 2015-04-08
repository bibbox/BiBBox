package at.meduni.liferay.portlet.rdconnect.statistik;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class UserStatistik
 */
public class UserStatistik extends MVCPortlet {
	/*
	 * (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("firstName", "Teststring");
			resourceResponse.getPortletOutputStream().write("?(\"# ----------------------------------------\\n# highcharts.com\\n# Audience Overview\\n# 20130309-20130408\\n# ----------------------------------------\\nDay,Visits,Unique Visitors\\n3/9/13,5691,4346\\n3/10/13,5403,4112\\n3/11/13,15574,11356\\n3/12/13,16211,11876\\n3/13/13,16427,11966\\n3/14/13,16486,12086\\n3/15/13,14737,10916\\n3/16/13,5838,4507\\n3/17/13,5542,4202\\n3/18/13,15560,11523\\n3/19/13,18940,14431\\n3/20/13,16970,12599\\n3/21/13,17580,13094\\n3/22/13,17511,13234\\n3/23/13,6601,5213\\n3/24/13,6158,4806\\n3/25/13,17353,12639\\n3/26/13,17660,12768\\n3/27/13,16921,12389\\n3/28/13,15964,11686\\n3/29/13,12028,8891\\n3/30/13,5835,4513\\n3/31/13,4799,3661\\n4/1/13,13037,9503\\n4/2/13,16976,12666\\n4/3/13,17100,12635\\n4/4/13,15701,11394\\n4/5/13,14378,10530\\n4/6/13,5889,4521\\n4/7/13,6779,5109\\n4/8/13,16068,11599\\n\");".getBytes());
		} catch (Exception e) {
			System.out.println("-----------------------------------------");
			System.out.println("BiBBox Exception in People::serveResource");
			System.out.println("Exception");
			e.printStackTrace();
		}
	}

}
