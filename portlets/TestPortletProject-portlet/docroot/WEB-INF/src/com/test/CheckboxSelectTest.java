package com.test;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CheckboxSelectTest
 */
public class CheckboxSelectTest extends MVCPortlet {
	public void sendTest(ActionRequest request, ActionResponse response) throws Exception {
		System.out.println("Parameter1:" + ParamUtil.getBoolean(request,"testcheckbox1"));
		System.out.println("Parameter2:" + ParamUtil.getBoolean(request,"testcheckbox2"));
		System.out.println("Parameter3:" + ParamUtil.getBoolean(request,"testcheckbox3"));
		System.out.println("Parameter4:" + ParamUtil.getBoolean(request,"testcheckbox4"));
	}

}
