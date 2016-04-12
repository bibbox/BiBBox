package at.graz.meduni.liferay.portlet.bibbox;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import at.graz.meduni.liferay.portlet.bibbox.util.DockerCMD;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DockerDashboard
 */
public class DockerDashboard extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException {
		String cmd = request.getParameter(Constants.CMD);
		System.out.println("CMD: " + cmd);
		if(cmd.equals("docker_reload")) {
			DockerCMD docker = new DockerCMD();
			String result = docker.dockerPs(true);
			response.getPortletOutputStream().write(result.getBytes());
		}
	}

}
