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

package at.pw.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Inventory}.
 * </p>
 *
 * @author reihsr
 * @see Inventory
 * @generated
 */
public class InventoryWrapper implements Inventory, ModelWrapper<Inventory> {
	public InventoryWrapper(Inventory inventory) {
		_inventory = inventory;
	}

	@Override
	public Class<?> getModelClass() {
		return Inventory.class;
	}

	@Override
	public String getModelClassName() {
		return Inventory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inventoryId", getInventoryId());
		attributes.put("createDate", getCreateDate());
		attributes.put("inventarnummer", getInventarnummer());
		attributes.put("webcontentId", getWebcontentId());
		attributes.put("folderId", getFolderId());
		attributes.put("structureId", getStructureId());
		attributes.put("structuretemplateId", getStructuretemplateId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long inventoryId = (Long)attributes.get("inventoryId");

		if (inventoryId != null) {
			setInventoryId(inventoryId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long inventarnummer = (Long)attributes.get("inventarnummer");

		if (inventarnummer != null) {
			setInventarnummer(inventarnummer);
		}

		Long webcontentId = (Long)attributes.get("webcontentId");

		if (webcontentId != null) {
			setWebcontentId(webcontentId);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		String structureId = (String)attributes.get("structureId");

		if (structureId != null) {
			setStructureId(structureId);
		}

		String structuretemplateId = (String)attributes.get(
				"structuretemplateId");

		if (structuretemplateId != null) {
			setStructuretemplateId(structuretemplateId);
		}
	}

	/**
	* Returns the primary key of this inventory.
	*
	* @return the primary key of this inventory
	*/
	@Override
	public long getPrimaryKey() {
		return _inventory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this inventory.
	*
	* @param primaryKey the primary key of this inventory
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_inventory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the inventory ID of this inventory.
	*
	* @return the inventory ID of this inventory
	*/
	@Override
	public long getInventoryId() {
		return _inventory.getInventoryId();
	}

	/**
	* Sets the inventory ID of this inventory.
	*
	* @param inventoryId the inventory ID of this inventory
	*/
	@Override
	public void setInventoryId(long inventoryId) {
		_inventory.setInventoryId(inventoryId);
	}

	/**
	* Returns the create date of this inventory.
	*
	* @return the create date of this inventory
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _inventory.getCreateDate();
	}

	/**
	* Sets the create date of this inventory.
	*
	* @param createDate the create date of this inventory
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_inventory.setCreateDate(createDate);
	}

	/**
	* Returns the inventarnummer of this inventory.
	*
	* @return the inventarnummer of this inventory
	*/
	@Override
	public long getInventarnummer() {
		return _inventory.getInventarnummer();
	}

	/**
	* Sets the inventarnummer of this inventory.
	*
	* @param inventarnummer the inventarnummer of this inventory
	*/
	@Override
	public void setInventarnummer(long inventarnummer) {
		_inventory.setInventarnummer(inventarnummer);
	}

	/**
	* Returns the webcontent ID of this inventory.
	*
	* @return the webcontent ID of this inventory
	*/
	@Override
	public long getWebcontentId() {
		return _inventory.getWebcontentId();
	}

	/**
	* Sets the webcontent ID of this inventory.
	*
	* @param webcontentId the webcontent ID of this inventory
	*/
	@Override
	public void setWebcontentId(long webcontentId) {
		_inventory.setWebcontentId(webcontentId);
	}

	/**
	* Returns the folder ID of this inventory.
	*
	* @return the folder ID of this inventory
	*/
	@Override
	public long getFolderId() {
		return _inventory.getFolderId();
	}

	/**
	* Sets the folder ID of this inventory.
	*
	* @param folderId the folder ID of this inventory
	*/
	@Override
	public void setFolderId(long folderId) {
		_inventory.setFolderId(folderId);
	}

	/**
	* Returns the structure ID of this inventory.
	*
	* @return the structure ID of this inventory
	*/
	@Override
	public java.lang.String getStructureId() {
		return _inventory.getStructureId();
	}

	/**
	* Sets the structure ID of this inventory.
	*
	* @param structureId the structure ID of this inventory
	*/
	@Override
	public void setStructureId(java.lang.String structureId) {
		_inventory.setStructureId(structureId);
	}

	/**
	* Returns the structuretemplate ID of this inventory.
	*
	* @return the structuretemplate ID of this inventory
	*/
	@Override
	public java.lang.String getStructuretemplateId() {
		return _inventory.getStructuretemplateId();
	}

	/**
	* Sets the structuretemplate ID of this inventory.
	*
	* @param structuretemplateId the structuretemplate ID of this inventory
	*/
	@Override
	public void setStructuretemplateId(java.lang.String structuretemplateId) {
		_inventory.setStructuretemplateId(structuretemplateId);
	}

	@Override
	public boolean isNew() {
		return _inventory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_inventory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _inventory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_inventory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _inventory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _inventory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_inventory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _inventory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_inventory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_inventory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_inventory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InventoryWrapper((Inventory)_inventory.clone());
	}

	@Override
	public int compareTo(at.pw.model.Inventory inventory) {
		return _inventory.compareTo(inventory);
	}

	@Override
	public int hashCode() {
		return _inventory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.pw.model.Inventory> toCacheModel() {
		return _inventory.toCacheModel();
	}

	@Override
	public at.pw.model.Inventory toEscapedModel() {
		return new InventoryWrapper(_inventory.toEscapedModel());
	}

	@Override
	public at.pw.model.Inventory toUnescapedModel() {
		return new InventoryWrapper(_inventory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _inventory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _inventory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_inventory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InventoryWrapper)) {
			return false;
		}

		InventoryWrapper inventoryWrapper = (InventoryWrapper)obj;

		if (Validator.equals(_inventory, inventoryWrapper._inventory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Inventory getWrappedInventory() {
		return _inventory;
	}

	@Override
	public Inventory getWrappedModel() {
		return _inventory;
	}

	@Override
	public void resetOriginalValues() {
		_inventory.resetOriginalValues();
	}

	private Inventory _inventory;
}