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

package at.pw.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import at.pw.model.Inventory;
import at.pw.model.impl.InventoryImpl;
import at.pw.service.InventoryLocalServiceUtil;
import at.pw.service.base.InventoryLocalServiceBaseImpl;

/**
 * The implementation of the inventory local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.pw.service.InventoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.pw.service.base.InventoryLocalServiceBaseImpl
 * @see at.pw.service.InventoryLocalServiceUtil
 */
public class InventoryLocalServiceImpl extends InventoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.pw.service.InventoryLocalServiceUtil} to access the inventory local service.
	 */
	public Inventory addInventoryWithAutoincrement() {
		try {	
			InventoryImpl inventory = new InventoryImpl();
			inventory.setInventoryId(CounterLocalServiceUtil.increment());
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Inventory.class);
			dynamicQuery.setProjection(ProjectionFactoryUtil.max("inventarnummer"));
			List results = InventoryLocalServiceUtil.dynamicQuery(dynamicQuery);
			long id = 0;
			for (Object obj: results) {
				try {
					id = Long.parseLong(obj.toString());
				} catch(Exception ex) {
					
				}
		    }
			inventory.setInventarnummer(id + 1);
			return InventoryLocalServiceUtil.addInventory(inventory);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}