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

package at.pw.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InventoryService}.
 *
 * @author reihsr
 * @see InventoryService
 * @generated
 */
public class InventoryServiceWrapper implements InventoryService,
	ServiceWrapper<InventoryService> {
	public InventoryServiceWrapper(InventoryService inventoryService) {
		_inventoryService = inventoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _inventoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_inventoryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _inventoryService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public InventoryService getWrappedInventoryService() {
		return _inventoryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedInventoryService(InventoryService inventoryService) {
		_inventoryService = inventoryService;
	}

	@Override
	public InventoryService getWrappedService() {
		return _inventoryService;
	}

	@Override
	public void setWrappedService(InventoryService inventoryService) {
		_inventoryService = inventoryService;
	}

	private InventoryService _inventoryService;
}