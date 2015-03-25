/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package at.meduni.liferay.portlet.bbmrieric.services.service.impl;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import at.meduni.liferay.portlet.bbmrieric.services.service.base.LDAPlogLocalServiceBaseImpl;

/**
 * The implementation of the l d a plog local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.services.service.LDAPlogLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.meduni.liferay.portlet.bbmrieric.services.service.base.LDAPlogLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.services.service.LDAPlogLocalServiceUtil
 */
public class LDAPlogLocalServiceImpl extends LDAPlogLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.bbmrieric.services.service.LDAPlogLocalServiceUtil} to access the l d a plog local service.
	 */
	public String getCountrylist() {
		System.out.println("Connection to Ldap2");
		Hashtable<String, String> environment = new Hashtable<String, String>();
		environment.put(LdapContext.CONTROL_FACTORIES, "com.sun.jndi.ldap.ControlFactory");
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.PROVIDER_URL, "ldap://directory.bbmri-eric.eu:389");
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.REFERRAL, "follow");
		
		// connect to LDAP
		try {
			DirContext ctx = new InitialDirContext(environment);
			
			/*Attributes matchAttrs = new BasicAttributes(true); // ignore attribute name case
			matchAttrs.put(new BasicAttribute("biobankID"));
			matchAttrs.   SearchControls.SUBTREE_SCOPE*/
			
			String[] attrIDs = { };

			SearchControls ctls = new SearchControls();
			ctls.setReturningAttributes(attrIDs);
			ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			
			// Search for objects using filter and controls
			NamingEnumeration answer = ctx.search("dc=directory,dc=bbmri-eric,dc=eu", "(objectclass=*)", ctls);
			//NamingEnumeration answer = ctx.search("dc=directory,dc=bbmri-eric,dc=eu", matchAttrs);
			while (answer.hasMore()) {
				if(answer == null) {
					System.out.println("answer == null");
				}
				SearchResult sr = (SearchResult) answer.next();
				Attributes attrs = sr.getAttributes();
				System.out.println("attrs: " + attrs.get("biobankID").toString());
			}
		} catch (NamingException e) {
			System.err.println("ERROR: LDAPlogLocalServiceImpl::getCountrylist()");
			e.printStackTrace();
		}
		System.out.println("Ldap done");
		return "";
	}
}