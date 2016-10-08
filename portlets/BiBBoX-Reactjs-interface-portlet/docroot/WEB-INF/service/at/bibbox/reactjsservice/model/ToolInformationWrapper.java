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

package at.bibbox.reactjsservice.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ToolInformation}.
 * </p>
 *
 * @author reihsr
 * @see ToolInformation
 * @generated
 */
public class ToolInformationWrapper implements ToolInformation,
	ModelWrapper<ToolInformation> {
	public ToolInformationWrapper(ToolInformation toolInformation) {
		_toolInformation = toolInformation;
	}

	@Override
	public Class<?> getModelClass() {
		return ToolInformation.class;
	}

	@Override
	public String getModelClassName() {
		return ToolInformation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("toolInformationId", getToolInformationId());
		attributes.put("gitUUID", getGitUUID());
		attributes.put("logourl", getLogourl());
		attributes.put("name", getName());
		attributes.put("category", getCategory());
		attributes.put("company", getCompany());
		attributes.put("demourl", getDemourl());
		attributes.put("downloadurl", getDownloadurl());
		attributes.put("toolId", getToolId());
		attributes.put("platform", getPlatform());
		attributes.put("license", getLicense());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long toolInformationId = (Long)attributes.get("toolInformationId");

		if (toolInformationId != null) {
			setToolInformationId(toolInformationId);
		}

		String gitUUID = (String)attributes.get("gitUUID");

		if (gitUUID != null) {
			setGitUUID(gitUUID);
		}

		String logourl = (String)attributes.get("logourl");

		if (logourl != null) {
			setLogourl(logourl);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String demourl = (String)attributes.get("demourl");

		if (demourl != null) {
			setDemourl(demourl);
		}

		String downloadurl = (String)attributes.get("downloadurl");

		if (downloadurl != null) {
			setDownloadurl(downloadurl);
		}

		String toolId = (String)attributes.get("toolId");

		if (toolId != null) {
			setToolId(toolId);
		}

		String platform = (String)attributes.get("platform");

		if (platform != null) {
			setPlatform(platform);
		}

		String license = (String)attributes.get("license");

		if (license != null) {
			setLicense(license);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this tool information.
	*
	* @return the primary key of this tool information
	*/
	@Override
	public long getPrimaryKey() {
		return _toolInformation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tool information.
	*
	* @param primaryKey the primary key of this tool information
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_toolInformation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tool information ID of this tool information.
	*
	* @return the tool information ID of this tool information
	*/
	@Override
	public long getToolInformationId() {
		return _toolInformation.getToolInformationId();
	}

	/**
	* Sets the tool information ID of this tool information.
	*
	* @param toolInformationId the tool information ID of this tool information
	*/
	@Override
	public void setToolInformationId(long toolInformationId) {
		_toolInformation.setToolInformationId(toolInformationId);
	}

	/**
	* Returns the git u u i d of this tool information.
	*
	* @return the git u u i d of this tool information
	*/
	@Override
	public java.lang.String getGitUUID() {
		return _toolInformation.getGitUUID();
	}

	/**
	* Sets the git u u i d of this tool information.
	*
	* @param gitUUID the git u u i d of this tool information
	*/
	@Override
	public void setGitUUID(java.lang.String gitUUID) {
		_toolInformation.setGitUUID(gitUUID);
	}

	/**
	* Returns the logourl of this tool information.
	*
	* @return the logourl of this tool information
	*/
	@Override
	public java.lang.String getLogourl() {
		return _toolInformation.getLogourl();
	}

	/**
	* Sets the logourl of this tool information.
	*
	* @param logourl the logourl of this tool information
	*/
	@Override
	public void setLogourl(java.lang.String logourl) {
		_toolInformation.setLogourl(logourl);
	}

	/**
	* Returns the name of this tool information.
	*
	* @return the name of this tool information
	*/
	@Override
	public java.lang.String getName() {
		return _toolInformation.getName();
	}

	/**
	* Sets the name of this tool information.
	*
	* @param name the name of this tool information
	*/
	@Override
	public void setName(java.lang.String name) {
		_toolInformation.setName(name);
	}

	/**
	* Returns the category of this tool information.
	*
	* @return the category of this tool information
	*/
	@Override
	public java.lang.String getCategory() {
		return _toolInformation.getCategory();
	}

	/**
	* Sets the category of this tool information.
	*
	* @param category the category of this tool information
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_toolInformation.setCategory(category);
	}

	/**
	* Returns the company of this tool information.
	*
	* @return the company of this tool information
	*/
	@Override
	public java.lang.String getCompany() {
		return _toolInformation.getCompany();
	}

	/**
	* Sets the company of this tool information.
	*
	* @param company the company of this tool information
	*/
	@Override
	public void setCompany(java.lang.String company) {
		_toolInformation.setCompany(company);
	}

	/**
	* Returns the demourl of this tool information.
	*
	* @return the demourl of this tool information
	*/
	@Override
	public java.lang.String getDemourl() {
		return _toolInformation.getDemourl();
	}

	/**
	* Sets the demourl of this tool information.
	*
	* @param demourl the demourl of this tool information
	*/
	@Override
	public void setDemourl(java.lang.String demourl) {
		_toolInformation.setDemourl(demourl);
	}

	/**
	* Returns the downloadurl of this tool information.
	*
	* @return the downloadurl of this tool information
	*/
	@Override
	public java.lang.String getDownloadurl() {
		return _toolInformation.getDownloadurl();
	}

	/**
	* Sets the downloadurl of this tool information.
	*
	* @param downloadurl the downloadurl of this tool information
	*/
	@Override
	public void setDownloadurl(java.lang.String downloadurl) {
		_toolInformation.setDownloadurl(downloadurl);
	}

	/**
	* Returns the tool ID of this tool information.
	*
	* @return the tool ID of this tool information
	*/
	@Override
	public java.lang.String getToolId() {
		return _toolInformation.getToolId();
	}

	/**
	* Sets the tool ID of this tool information.
	*
	* @param toolId the tool ID of this tool information
	*/
	@Override
	public void setToolId(java.lang.String toolId) {
		_toolInformation.setToolId(toolId);
	}

	/**
	* Returns the platform of this tool information.
	*
	* @return the platform of this tool information
	*/
	@Override
	public java.lang.String getPlatform() {
		return _toolInformation.getPlatform();
	}

	/**
	* Sets the platform of this tool information.
	*
	* @param platform the platform of this tool information
	*/
	@Override
	public void setPlatform(java.lang.String platform) {
		_toolInformation.setPlatform(platform);
	}

	/**
	* Returns the license of this tool information.
	*
	* @return the license of this tool information
	*/
	@Override
	public java.lang.String getLicense() {
		return _toolInformation.getLicense();
	}

	/**
	* Sets the license of this tool information.
	*
	* @param license the license of this tool information
	*/
	@Override
	public void setLicense(java.lang.String license) {
		_toolInformation.setLicense(license);
	}

	/**
	* Returns the description of this tool information.
	*
	* @return the description of this tool information
	*/
	@Override
	public java.lang.String getDescription() {
		return _toolInformation.getDescription();
	}

	/**
	* Sets the description of this tool information.
	*
	* @param description the description of this tool information
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_toolInformation.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _toolInformation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_toolInformation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _toolInformation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_toolInformation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _toolInformation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _toolInformation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_toolInformation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _toolInformation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_toolInformation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_toolInformation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_toolInformation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ToolInformationWrapper((ToolInformation)_toolInformation.clone());
	}

	@Override
	public int compareTo(ToolInformation toolInformation) {
		return _toolInformation.compareTo(toolInformation);
	}

	@Override
	public int hashCode() {
		return _toolInformation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ToolInformation> toCacheModel() {
		return _toolInformation.toCacheModel();
	}

	@Override
	public ToolInformation toEscapedModel() {
		return new ToolInformationWrapper(_toolInformation.toEscapedModel());
	}

	@Override
	public ToolInformation toUnescapedModel() {
		return new ToolInformationWrapper(_toolInformation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _toolInformation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _toolInformation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_toolInformation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ToolInformationWrapper)) {
			return false;
		}

		ToolInformationWrapper toolInformationWrapper = (ToolInformationWrapper)obj;

		if (Validator.equals(_toolInformation,
					toolInformationWrapper._toolInformation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ToolInformation getWrappedToolInformation() {
		return _toolInformation;
	}

	@Override
	public ToolInformation getWrappedModel() {
		return _toolInformation;
	}

	@Override
	public void resetOriginalValues() {
		_toolInformation.resetOriginalValues();
	}

	private ToolInformation _toolInformation;
}