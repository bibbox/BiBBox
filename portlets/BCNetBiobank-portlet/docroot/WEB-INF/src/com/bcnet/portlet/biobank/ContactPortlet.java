package com.bcnet.portlet.biobank;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.model.Contact;
import com.bcnet.portlet.biobank.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ContactPortlet
 */
public class ContactPortlet extends MVCPortlet {
 
	public void addContact(ActionRequest request, ActionResponse response) throws IOException, SystemException, PortalException{

		_updateContact(request);

		sendRedirect(request, response);
	}

	public void updateContact(ActionRequest request, ActionResponse response) throws SystemException, PortalException, IOException{

		_updateContact(request);

		sendRedirect(request, response);
	}
	
	public void deleteContact(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		
		long contactId = ParamUtil.getLong(request, "contactId");
		
		ContactLocalServiceUtil.deleteContact(contactId);
		
		sendRedirect(request, response);
	}

	private Contact _updateContact(ActionRequest request) throws SystemException, PortalException{

		long contactId = ParamUtil.getLong(request, "contactId");
		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request, "lastName");
		String phone = ParamUtil.getString(request, "phone");
		String email = ParamUtil.getString(request, "email");
		String address = ParamUtil.getString(request, "address");
		String zip = ParamUtil.getString(request, "zip");
		String city = ParamUtil.getString(request, "city");
		String countryCode = ParamUtil.getString(request, "countryCode");
		long juristicPersonId = ParamUtil.getLong(request, "juristicPersonId");
		String department = ParamUtil.getString(request, "department");
		String orcId = ParamUtil.getString(request, "orcId");
		
		Contact contact = null;

		if(contactId <= 0){
			contact = ContactLocalServiceUtil.addContact(firstName, lastName, phone, email,
					address, zip, city, countryCode, juristicPersonId, department, orcId);
		}
		else{
			contact = ContactLocalServiceUtil.updateContact(contactId, firstName, lastName, 
					phone, email, address, zip, city, countryCode, juristicPersonId, department, orcId);
		}

		return contact;

	}
}
