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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link KdssmpRules}.
 * </p>
 *
 * @author reihsr
 * @see KdssmpRules
 * @generated
 */
public class KdssmpRulesWrapper implements KdssmpRules,
	ModelWrapper<KdssmpRules> {
	public KdssmpRulesWrapper(KdssmpRules kdssmpRules) {
		_kdssmpRules = kdssmpRules;
	}

	@Override
	public Class<?> getModelClass() {
		return KdssmpRules.class;
	}

	@Override
	public String getModelClassName() {
		return KdssmpRules.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ruleId", getRuleId());
		attributes.put("rule", getRule());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
		}

		String rule = (String)attributes.get("rule");

		if (rule != null) {
			setRule(rule);
		}
	}

	/**
	* Returns the primary key of this kdssmp rules.
	*
	* @return the primary key of this kdssmp rules
	*/
	@Override
	public long getPrimaryKey() {
		return _kdssmpRules.getPrimaryKey();
	}

	/**
	* Sets the primary key of this kdssmp rules.
	*
	* @param primaryKey the primary key of this kdssmp rules
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kdssmpRules.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the rule ID of this kdssmp rules.
	*
	* @return the rule ID of this kdssmp rules
	*/
	@Override
	public long getRuleId() {
		return _kdssmpRules.getRuleId();
	}

	/**
	* Sets the rule ID of this kdssmp rules.
	*
	* @param ruleId the rule ID of this kdssmp rules
	*/
	@Override
	public void setRuleId(long ruleId) {
		_kdssmpRules.setRuleId(ruleId);
	}

	/**
	* Returns the rule of this kdssmp rules.
	*
	* @return the rule of this kdssmp rules
	*/
	@Override
	public java.lang.String getRule() {
		return _kdssmpRules.getRule();
	}

	/**
	* Sets the rule of this kdssmp rules.
	*
	* @param rule the rule of this kdssmp rules
	*/
	@Override
	public void setRule(java.lang.String rule) {
		_kdssmpRules.setRule(rule);
	}

	@Override
	public boolean isNew() {
		return _kdssmpRules.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_kdssmpRules.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _kdssmpRules.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kdssmpRules.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _kdssmpRules.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _kdssmpRules.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_kdssmpRules.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kdssmpRules.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_kdssmpRules.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_kdssmpRules.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kdssmpRules.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new KdssmpRulesWrapper((KdssmpRules)_kdssmpRules.clone());
	}

	@Override
	public int compareTo(KdssmpRules kdssmpRules) {
		return _kdssmpRules.compareTo(kdssmpRules);
	}

	@Override
	public int hashCode() {
		return _kdssmpRules.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<KdssmpRules> toCacheModel() {
		return _kdssmpRules.toCacheModel();
	}

	@Override
	public KdssmpRules toEscapedModel() {
		return new KdssmpRulesWrapper(_kdssmpRules.toEscapedModel());
	}

	@Override
	public KdssmpRules toUnescapedModel() {
		return new KdssmpRulesWrapper(_kdssmpRules.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _kdssmpRules.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kdssmpRules.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_kdssmpRules.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KdssmpRulesWrapper)) {
			return false;
		}

		KdssmpRulesWrapper kdssmpRulesWrapper = (KdssmpRulesWrapper)obj;

		if (Validator.equals(_kdssmpRules, kdssmpRulesWrapper._kdssmpRules)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public KdssmpRules getWrappedKdssmpRules() {
		return _kdssmpRules;
	}

	@Override
	public KdssmpRules getWrappedModel() {
		return _kdssmpRules;
	}

	@Override
	public void resetOriginalValues() {
		_kdssmpRules.resetOriginalValues();
	}

	private KdssmpRules _kdssmpRules;
}