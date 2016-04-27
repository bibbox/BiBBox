package at.graz.meduni.liferay.portlet.saat.database;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SAATDatabase
 */
public class SAATDatabase extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern_ = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error_ = new SimpleDateFormat(date_format_apache_error_pattern_);
	String class_error_ = "SAATDatabase-portlet::at.graz.meduni.liferay.portlet.saat.database.SAATDatabase";
	
	/**
	 * uploadFile excel file
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void importData(ActionRequest request, ActionResponse response) throws Exception {
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			String table = ParamUtil.getString(uploadRequest, "table");
			System.out.println("Uploaded file for " + table + " - " + uploadRequest.getFileName("fileupload"));
			InputStream inputStream = null;
			BufferedReader reader = null;
			String jsonstring = "";
			try {
				inputStream = new FileInputStream(uploadRequest.getFile("fileupload"));
				reader = new BufferedReader(new InputStreamReader(inputStream));
	         
	            String line = reader.readLine();
	            while(line != null){
	            	jsonstring += line;
	                line = reader.readLine();
	            }    
			} catch (FileNotFoundException e) {
				System.err.println("[" + date_format_apache_error_.format(new Date()) + "] [error] [" + class_error_ + "::importData] Error loading file.");
				e.printStackTrace();
			}
			
			System.out.println("{\"dataarray\":" + jsonstring + "}");
			
			JSONObject jsonobject = JSONFactoryUtil.createJSONObject("{\"dataarray\":" + jsonstring + "}");
			System.out.println(jsonobject.length());
			System.out.println(jsonobject.getJSONArray("dataarray").length());
		} catch (Exception e) {
			System.err.println("[" + date_format_apache_error_.format(new Date()) + "] [error] [" + class_error_ + "::importData] Error processing import file.");
			e.printStackTrace();
		}
	}

}
