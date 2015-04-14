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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing KdssmpRules in entity cache.
 *
 * @author reihsr
 * @see KdssmpRules
 * @generated
 */
public class KdssmpRulesCacheModel implements CacheModel<KdssmpRules>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{ruleId=");
		sb.append(ruleId);
		sb.append(", rule=");
		sb.append(rule);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KdssmpRules toEntityModel() {
		KdssmpRulesImpl kdssmpRulesImpl = new KdssmpRulesImpl();

		kdssmpRulesImpl.setRuleId(ruleId);

		if (rule == null) {
			kdssmpRulesImpl.setRule(StringPool.BLANK);
		}
		else {
			kdssmpRulesImpl.setRule(rule);
		}

		kdssmpRulesImpl.resetOriginalValues();

		return kdssmpRulesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ruleId = objectInput.readLong();
		rule = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ruleId);

		if (rule == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rule);
		}
	}

	public long ruleId;
	public String rule;
}