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

package at.graz.hmmc.liferay.portlet.puch.model.impl;

import at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ParameterConfiguration in entity cache.
 *
 * @author reihsr
 * @see ParameterConfiguration
 * @generated
 */
public class ParameterConfigurationCacheModel implements CacheModel<ParameterConfiguration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{parameterconfigurationId=");
		sb.append(parameterconfigurationId);
		sb.append(", displaynameshort=");
		sb.append(displaynameshort);
		sb.append(", displaynamelong=");
		sb.append(displaynamelong);
		sb.append(", datatype=");
		sb.append(datatype);
		sb.append(", group=");
		sb.append(group);
		sb.append(", tab=");
		sb.append(tab);
		sb.append(", summery=");
		sb.append(summery);
		sb.append(", viewscript=");
		sb.append(viewscript);
		sb.append(", viewvisible=");
		sb.append(viewvisible);
		sb.append(", viewtip=");
		sb.append(viewtip);
		sb.append(", viewtitlecss=");
		sb.append(viewtitlecss);
		sb.append(", viewvaluecss=");
		sb.append(viewvaluecss);
		sb.append(", viewcss=");
		sb.append(viewcss);
		sb.append(", editscript=");
		sb.append(editscript);
		sb.append(", editvisible=");
		sb.append(editvisible);
		sb.append(", edittip=");
		sb.append(edittip);
		sb.append(", edittitlecss=");
		sb.append(edittitlecss);
		sb.append(", editvaluecss=");
		sb.append(editvaluecss);
		sb.append(", editcss=");
		sb.append(editcss);
		sb.append(", editcolumnwidth=");
		sb.append(editcolumnwidth);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ParameterConfiguration toEntityModel() {
		ParameterConfigurationImpl parameterConfigurationImpl = new ParameterConfigurationImpl();

		parameterConfigurationImpl.setParameterconfigurationId(parameterconfigurationId);

		if (displaynameshort == null) {
			parameterConfigurationImpl.setDisplaynameshort(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setDisplaynameshort(displaynameshort);
		}

		if (displaynamelong == null) {
			parameterConfigurationImpl.setDisplaynamelong(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setDisplaynamelong(displaynamelong);
		}

		if (datatype == null) {
			parameterConfigurationImpl.setDatatype(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setDatatype(datatype);
		}

		if (group == null) {
			parameterConfigurationImpl.setGroup(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setGroup(group);
		}

		if (tab == null) {
			parameterConfigurationImpl.setTab(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setTab(tab);
		}

		parameterConfigurationImpl.setSummery(summery);

		if (viewscript == null) {
			parameterConfigurationImpl.setViewscript(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setViewscript(viewscript);
		}

		parameterConfigurationImpl.setViewvisible(viewvisible);

		if (viewtip == null) {
			parameterConfigurationImpl.setViewtip(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setViewtip(viewtip);
		}

		if (viewtitlecss == null) {
			parameterConfigurationImpl.setViewtitlecss(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setViewtitlecss(viewtitlecss);
		}

		if (viewvaluecss == null) {
			parameterConfigurationImpl.setViewvaluecss(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setViewvaluecss(viewvaluecss);
		}

		if (viewcss == null) {
			parameterConfigurationImpl.setViewcss(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setViewcss(viewcss);
		}

		if (editscript == null) {
			parameterConfigurationImpl.setEditscript(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setEditscript(editscript);
		}

		parameterConfigurationImpl.setEditvisible(editvisible);

		if (edittip == null) {
			parameterConfigurationImpl.setEdittip(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setEdittip(edittip);
		}

		if (edittitlecss == null) {
			parameterConfigurationImpl.setEdittitlecss(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setEdittitlecss(edittitlecss);
		}

		if (editvaluecss == null) {
			parameterConfigurationImpl.setEditvaluecss(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setEditvaluecss(editvaluecss);
		}

		if (editcss == null) {
			parameterConfigurationImpl.setEditcss(StringPool.BLANK);
		}
		else {
			parameterConfigurationImpl.setEditcss(editcss);
		}

		parameterConfigurationImpl.setEditcolumnwidth(editcolumnwidth);

		parameterConfigurationImpl.resetOriginalValues();

		return parameterConfigurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		parameterconfigurationId = objectInput.readLong();
		displaynameshort = objectInput.readUTF();
		displaynamelong = objectInput.readUTF();
		datatype = objectInput.readUTF();
		group = objectInput.readUTF();
		tab = objectInput.readUTF();
		summery = objectInput.readBoolean();
		viewscript = objectInput.readUTF();
		viewvisible = objectInput.readBoolean();
		viewtip = objectInput.readUTF();
		viewtitlecss = objectInput.readUTF();
		viewvaluecss = objectInput.readUTF();
		viewcss = objectInput.readUTF();
		editscript = objectInput.readUTF();
		editvisible = objectInput.readBoolean();
		edittip = objectInput.readUTF();
		edittitlecss = objectInput.readUTF();
		editvaluecss = objectInput.readUTF();
		editcss = objectInput.readUTF();
		editcolumnwidth = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(parameterconfigurationId);

		if (displaynameshort == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(displaynameshort);
		}

		if (displaynamelong == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(displaynamelong);
		}

		if (datatype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(datatype);
		}

		if (group == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(group);
		}

		if (tab == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tab);
		}

		objectOutput.writeBoolean(summery);

		if (viewscript == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(viewscript);
		}

		objectOutput.writeBoolean(viewvisible);

		if (viewtip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(viewtip);
		}

		if (viewtitlecss == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(viewtitlecss);
		}

		if (viewvaluecss == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(viewvaluecss);
		}

		if (viewcss == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(viewcss);
		}

		if (editscript == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(editscript);
		}

		objectOutput.writeBoolean(editvisible);

		if (edittip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(edittip);
		}

		if (edittitlecss == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(edittitlecss);
		}

		if (editvaluecss == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(editvaluecss);
		}

		if (editcss == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(editcss);
		}

		objectOutput.writeLong(editcolumnwidth);
	}

	public long parameterconfigurationId;
	public String displaynameshort;
	public String displaynamelong;
	public String datatype;
	public String group;
	public String tab;
	public boolean summery;
	public String viewscript;
	public boolean viewvisible;
	public String viewtip;
	public String viewtitlecss;
	public String viewvaluecss;
	public String viewcss;
	public String editscript;
	public boolean editvisible;
	public String edittip;
	public String edittitlecss;
	public String editvaluecss;
	public String editcss;
	public long editcolumnwidth;
}