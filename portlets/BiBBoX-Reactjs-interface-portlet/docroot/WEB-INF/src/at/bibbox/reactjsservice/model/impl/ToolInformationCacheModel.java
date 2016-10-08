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

package at.bibbox.reactjsservice.model.impl;

import at.bibbox.reactjsservice.model.ToolInformation;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ToolInformation in entity cache.
 *
 * @author reihsr
 * @see ToolInformation
 * @generated
 */
public class ToolInformationCacheModel implements CacheModel<ToolInformation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{toolInformationId=");
		sb.append(toolInformationId);
		sb.append(", gitUUID=");
		sb.append(gitUUID);
		sb.append(", logourl=");
		sb.append(logourl);
		sb.append(", name=");
		sb.append(name);
		sb.append(", category=");
		sb.append(category);
		sb.append(", company=");
		sb.append(company);
		sb.append(", demourl=");
		sb.append(demourl);
		sb.append(", downloadurl=");
		sb.append(downloadurl);
		sb.append(", toolId=");
		sb.append(toolId);
		sb.append(", platform=");
		sb.append(platform);
		sb.append(", license=");
		sb.append(license);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ToolInformation toEntityModel() {
		ToolInformationImpl toolInformationImpl = new ToolInformationImpl();

		toolInformationImpl.setToolInformationId(toolInformationId);

		if (gitUUID == null) {
			toolInformationImpl.setGitUUID(StringPool.BLANK);
		}
		else {
			toolInformationImpl.setGitUUID(gitUUID);
		}

		if (logourl == null) {
			toolInformationImpl.setLogourl(StringPool.BLANK);
		}
		else {
			toolInformationImpl.setLogourl(logourl);
		}

		if (name == null) {
			toolInformationImpl.setName(StringPool.BLANK);
		}
		else {
			toolInformationImpl.setName(name);
		}

		if (category == null) {
			toolInformationImpl.setCategory(StringPool.BLANK);
		}
		else {
			toolInformationImpl.setCategory(category);
		}

		if (company == null) {
			toolInformationImpl.setCompany(StringPool.BLANK);
		}
		else {
			toolInformationImpl.setCompany(company);
		}

		if (demourl == null) {
			toolInformationImpl.setDemourl(StringPool.BLANK);
		}
		else {
			toolInformationImpl.setDemourl(demourl);
		}

		if (downloadurl == null) {
			toolInformationImpl.setDownloadurl(StringPool.BLANK);
		}
		else {
			toolInformationImpl.setDownloadurl(downloadurl);
		}

		if (toolId == null) {
			toolInformationImpl.setToolId(StringPool.BLANK);
		}
		else {
			toolInformationImpl.setToolId(toolId);
		}

		if (platform == null) {
			toolInformationImpl.setPlatform(StringPool.BLANK);
		}
		else {
			toolInformationImpl.setPlatform(platform);
		}

		if (license == null) {
			toolInformationImpl.setLicense(StringPool.BLANK);
		}
		else {
			toolInformationImpl.setLicense(license);
		}

		if (description == null) {
			toolInformationImpl.setDescription(StringPool.BLANK);
		}
		else {
			toolInformationImpl.setDescription(description);
		}

		toolInformationImpl.resetOriginalValues();

		return toolInformationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		toolInformationId = objectInput.readLong();
		gitUUID = objectInput.readUTF();
		logourl = objectInput.readUTF();
		name = objectInput.readUTF();
		category = objectInput.readUTF();
		company = objectInput.readUTF();
		demourl = objectInput.readUTF();
		downloadurl = objectInput.readUTF();
		toolId = objectInput.readUTF();
		platform = objectInput.readUTF();
		license = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(toolInformationId);

		if (gitUUID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gitUUID);
		}

		if (logourl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(logourl);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (company == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (demourl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(demourl);
		}

		if (downloadurl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(downloadurl);
		}

		if (toolId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(toolId);
		}

		if (platform == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(platform);
		}

		if (license == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(license);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long toolInformationId;
	public String gitUUID;
	public String logourl;
	public String name;
	public String category;
	public String company;
	public String demourl;
	public String downloadurl;
	public String toolId;
	public String platform;
	public String license;
	public String description;
}