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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class KdssmpRulesSoap implements Serializable {
	public static KdssmpRulesSoap toSoapModel(KdssmpRules model) {
		KdssmpRulesSoap soapModel = new KdssmpRulesSoap();

		soapModel.setRuleId(model.getRuleId());
		soapModel.setRule(model.getRule());

		return soapModel;
	}

	public static KdssmpRulesSoap[] toSoapModels(KdssmpRules[] models) {
		KdssmpRulesSoap[] soapModels = new KdssmpRulesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KdssmpRulesSoap[][] toSoapModels(KdssmpRules[][] models) {
		KdssmpRulesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KdssmpRulesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KdssmpRulesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KdssmpRulesSoap[] toSoapModels(List<KdssmpRules> models) {
		List<KdssmpRulesSoap> soapModels = new ArrayList<KdssmpRulesSoap>(models.size());

		for (KdssmpRules model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KdssmpRulesSoap[soapModels.size()]);
	}

	public KdssmpRulesSoap() {
	}

	public long getPrimaryKey() {
		return _ruleId;
	}

	public void setPrimaryKey(long pk) {
		setRuleId(pk);
	}

	public long getRuleId() {
		return _ruleId;
	}

	public void setRuleId(long ruleId) {
		_ruleId = ruleId;
	}

	public String getRule() {
		return _rule;
	}

	public void setRule(String rule) {
		_rule = rule;
	}

	private long _ruleId;
	private String _rule;
}