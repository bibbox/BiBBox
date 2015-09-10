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

package at.graz.hmmc.liferay.portlet.puch.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

import at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException;
import at.graz.hmmc.liferay.portlet.puch.model.Configuration;
import at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration;
import at.graz.hmmc.liferay.portlet.puch.model.Transaktion;
import at.graz.hmmc.liferay.portlet.puch.model.TransaktionData;
import at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionImpl;
import at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.TransaktionDataLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.base.TransaktionLocalServiceBaseImpl;

/**
 * The implementation of the transaktion local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.hmmc.liferay.portlet.puch.service.base.TransaktionLocalServiceBaseImpl
 * @see at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalServiceUtil
 */
public class TransaktionLocalServiceImpl extends TransaktionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalServiceUtil} to access the transaktion local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 */
	public Transaktion getLastTransactionOfType(long puchmuseumsobjectId, String transactiontype) {
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Transaktion.class);
			Criterion criterion = RestrictionsFactoryUtil.eq("puchmuseumsobjectId", puchmuseumsobjectId);
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("typ", transactiontype));
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.isNull("endDate"));
			dynamicQuery.add(criterion);
			Order order = OrderFactoryUtil.desc("startDate");
			dynamicQuery.addOrder(order);
			List<Transaktion> transactions = TransaktionLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(transactions != null) {
				if(transactions.size() != 0) {
					return transactions.get(0);
				}
			}
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.TransaktionLocalServiceImpl::getLastTransactionOfType] Error getting Transaktion.");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param puchmuseumsobjectId
	 * @param transactiontype
	 * @return
	 */
	public List<Transaktion> getTransactionOfType(long puchmuseumsobjectId, String transactiontype) {
		try {
			return transaktionPersistence.findByTypAndObject(transactiontype, puchmuseumsobjectId);
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.TransaktionLocalServiceImpl::getTransactionOfType] Error getting Transaktions.");
			ex.printStackTrace();
		}
		return null;
	}
	
	public String getTransactionTableOfType(long puchmuseumsobjectId, String transactiontype, String baseurl) {
		String returnstring = "";
		try {
			// javascript template part
			returnstring += "AUI().use('aui-datatable','aui-datatype','datatable-sort',function(Y) {var remoteData = [§§DATAROW§§];var nestedCols = [§§COLS§§];var dataTable = new Y.DataTable({columns: nestedCols,data: remoteData}).render('#tableof" + transactiontype + "');dataTable.get('boundingBox').unselectable();});";
			// add all colums for summery
			HashMap<String, String> fields = new HashMap<String, String>();
			List<Configuration> configurations = ConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", transactiontype);
			for(Configuration configuration : configurations) {
				ParameterConfiguration parameterconfig = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(Long.parseLong(configuration.getOptionvalue()));
				if(parameterconfig.getSummery()) {
					String col = "{key: '" + parameterconfig.getDisplaynameshort() + "',sortable: true},§§COLS§§";
					returnstring = returnstring.replaceAll("§§COLS§§", col);
					fields.put(String.valueOf(parameterconfig.getParameterconfigurationId()), parameterconfig.getDisplaynameshort());
				}
			}
			returnstring = returnstring.replaceAll(",§§COLS§§", ",{key: 'Edit',allowHTML: true}");
			returnstring = returnstring.replaceAll("§§COLS§§", "");
			// add Data
			List<Transaktion> transaktions = transaktionPersistence.findByTypAndObject(transactiontype, puchmuseumsobjectId);
			for(Transaktion transaktion : transaktions) {
				String data = "{";
				for(String key : fields.keySet()) {
					TransaktionData transaktiondata = TransaktionDataLocalServiceUtil.getTransaktionDataForObject(transaktion.getTransaktionId(), key);
					String value = "";
					if(transaktiondata != null) {
						value = transaktiondata.formatValueHTML();
					}
					data += "'" + fields.get(key) + "':'" + value + "',";
				}
				data += "'Edit':'<i id=\"createtransaction\" tag=\"" + transactiontype + "\" tagurl=\"" + baseurl + transaktion.getPuchmuseumsobjectId() + "/" + transaktion.getTransaktionId() + "\" style=\"cursor: pointer;float: right;\" class=\"fa fa-file-text-o\"></i>'";
				data += "},§§DATAROW§§";
				returnstring = returnstring.replaceAll("§§DATAROW§§", data);
			}
			returnstring = returnstring.replaceAll(",§§DATAROW§§", "");
			returnstring = returnstring.replaceAll("§§DATAROW§§", "");
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.TransaktionLocalServiceImpl::getTransactionTableOfType] Error getting Transaktions Table.");
			ex.printStackTrace();
		}
		return returnstring;
	}
	
	/**
	 * 
	 */
	public Transaktion addTransaction(long puchmuseumsobjectId, String transactiontype, Date startdate, Date enddate, long userId) {
		try {
			TransaktionImpl transaktion = new TransaktionImpl();
			transaktion.setTransaktionId(CounterLocalServiceUtil.increment(Transaktion.class.getName()));
			transaktion.setPuchmuseumsobjectId(puchmuseumsobjectId);
			transaktion.setTyp(transactiontype);
			transaktion.setStartDate(startdate);
			transaktion.setEndDate(enddate);
			
			transaktion.setCreateDate(new Date());
			transaktion.setModifiedDate(new Date());
			transaktion.setModifiedUserId(userId);
			transaktion.setCreaterUserId(userId);
			return transaktion;
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.service.impl.TransaktionLocalServiceImpl::addTransaction] Error creating new Transaktion (" + puchmuseumsobjectId + ", " + transactiontype + ", " + startdate + ", " + enddate + ", " + userId + ").");
			ex.printStackTrace();
		}
		return null;
	}
}