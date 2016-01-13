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

package at.meduni.liferay.portlet.bbmrieric.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the D2Biobank service. Represents a row in the &quot;bbmrieric.d2biobank&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankImpl}.
 * </p>
 *
 * @author reihsr
 * @see D2Biobank
 * @see at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankImpl
 * @see at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankModelImpl
 * @generated
 */
public interface D2BiobankModel extends BaseModel<D2Biobank>, StagedGroupedModel,
	WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a d2 biobank model instance should use the {@link D2Biobank} interface instead.
	 */

	/**
	 * Returns the primary key of this d2 biobank.
	 *
	 * @return the primary key of this d2 biobank
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this d2 biobank.
	 *
	 * @param primaryKey the primary key of this d2 biobank
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this d2 biobank.
	 *
	 * @return the uuid of this d2 biobank
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this d2 biobank.
	 *
	 * @param uuid the uuid of this d2 biobank
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the biobank ID of this d2 biobank.
	 *
	 * @return the biobank ID of this d2 biobank
	 */
	public long getBiobankId();

	/**
	 * Sets the biobank ID of this d2 biobank.
	 *
	 * @param biobankId the biobank ID of this d2 biobank
	 */
	public void setBiobankId(long biobankId);

	/**
	 * Returns the status of this d2 biobank.
	 *
	 * @return the status of this d2 biobank
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this d2 biobank.
	 *
	 * @param status the status of this d2 biobank
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this d2 biobank.
	 *
	 * @return the status by user ID of this d2 biobank
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this d2 biobank.
	 *
	 * @param statusByUserId the status by user ID of this d2 biobank
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this d2 biobank.
	 *
	 * @return the status by user uuid of this d2 biobank
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this d2 biobank.
	 *
	 * @param statusByUserUuid the status by user uuid of this d2 biobank
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this d2 biobank.
	 *
	 * @return the status by user name of this d2 biobank
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this d2 biobank.
	 *
	 * @param statusByUserName the status by user name of this d2 biobank
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this d2 biobank.
	 *
	 * @return the status date of this d2 biobank
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this d2 biobank.
	 *
	 * @param statusDate the status date of this d2 biobank
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the company ID of this d2 biobank.
	 *
	 * @return the company ID of this d2 biobank
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this d2 biobank.
	 *
	 * @param companyId the company ID of this d2 biobank
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this d2 biobank.
	 *
	 * @return the group ID of this d2 biobank
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this d2 biobank.
	 *
	 * @param groupId the group ID of this d2 biobank
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this d2 biobank.
	 *
	 * @return the user ID of this d2 biobank
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this d2 biobank.
	 *
	 * @param userId the user ID of this d2 biobank
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this d2 biobank.
	 *
	 * @return the user uuid of this d2 biobank
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this d2 biobank.
	 *
	 * @param userUuid the user uuid of this d2 biobank
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this d2 biobank.
	 *
	 * @return the user name of this d2 biobank
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this d2 biobank.
	 *
	 * @param userName the user name of this d2 biobank
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this d2 biobank.
	 *
	 * @return the create date of this d2 biobank
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this d2 biobank.
	 *
	 * @param createDate the create date of this d2 biobank
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this d2 biobank.
	 *
	 * @return the modified date of this d2 biobank
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this d2 biobank.
	 *
	 * @param modifiedDate the modified date of this d2 biobank
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the updateuuid of this d2 biobank.
	 *
	 * @return the updateuuid of this d2 biobank
	 */
	@AutoEscape
	public String getUpdateuuid();

	/**
	 * Sets the updateuuid of this d2 biobank.
	 *
	 * @param updateuuid the updateuuid of this d2 biobank
	 */
	public void setUpdateuuid(String updateuuid);

	/**
	 * Returns the contact i d ref of this d2 biobank.
	 *
	 * @return the contact i d ref of this d2 biobank
	 */
	@AutoEscape
	public String getContactIDRef();

	/**
	 * Sets the contact i d ref of this d2 biobank.
	 *
	 * @param contactIDRef the contact i d ref of this d2 biobank
	 */
	public void setContactIDRef(String contactIDRef);

	/**
	 * Returns the contact priority of this d2 biobank.
	 *
	 * @return the contact priority of this d2 biobank
	 */
	public long getContactPriority();

	/**
	 * Sets the contact priority of this d2 biobank.
	 *
	 * @param contactPriority the contact priority of this d2 biobank
	 */
	public void setContactPriority(long contactPriority);

	/**
	 * Returns the bbmribiobank i d of this d2 biobank.
	 *
	 * @return the bbmribiobank i d of this d2 biobank
	 */
	@AutoEscape
	public String getBbmribiobankID();

	/**
	 * Sets the bbmribiobank i d of this d2 biobank.
	 *
	 * @param bbmribiobankID the bbmribiobank i d of this d2 biobank
	 */
	public void setBbmribiobankID(String bbmribiobankID);

	/**
	 * Returns the biobank name of this d2 biobank.
	 *
	 * @return the biobank name of this d2 biobank
	 */
	@AutoEscape
	public String getBiobankName();

	/**
	 * Sets the biobank name of this d2 biobank.
	 *
	 * @param biobankName the biobank name of this d2 biobank
	 */
	public void setBiobankName(String biobankName);

	/**
	 * Returns the biobank jurisdical person of this d2 biobank.
	 *
	 * @return the biobank jurisdical person of this d2 biobank
	 */
	@AutoEscape
	public String getBiobankJurisdicalPerson();

	/**
	 * Sets the biobank jurisdical person of this d2 biobank.
	 *
	 * @param biobankJurisdicalPerson the biobank jurisdical person of this d2 biobank
	 */
	public void setBiobankJurisdicalPerson(String biobankJurisdicalPerson);

	/**
	 * Returns the biobank country of this d2 biobank.
	 *
	 * @return the biobank country of this d2 biobank
	 */
	@AutoEscape
	public String getBiobankCountry();

	/**
	 * Sets the biobank country of this d2 biobank.
	 *
	 * @param biobankCountry the biobank country of this d2 biobank
	 */
	public void setBiobankCountry(String biobankCountry);

	/**
	 * Returns the biobank partner charter signed of this d2 biobank.
	 *
	 * @return the biobank partner charter signed of this d2 biobank
	 */
	public boolean getBiobankPartnerCharterSigned();

	/**
	 * Returns <code>true</code> if this d2 biobank is biobank partner charter signed.
	 *
	 * @return <code>true</code> if this d2 biobank is biobank partner charter signed; <code>false</code> otherwise
	 */
	public boolean isBiobankPartnerCharterSigned();

	/**
	 * Sets whether this d2 biobank is biobank partner charter signed.
	 *
	 * @param biobankPartnerCharterSigned the biobank partner charter signed of this d2 biobank
	 */
	public void setBiobankPartnerCharterSigned(
		boolean biobankPartnerCharterSigned);

	/**
	 * Returns the bioresource reference of this d2 biobank.
	 *
	 * @return the bioresource reference of this d2 biobank
	 */
	@AutoEscape
	public String getBioresourceReference();

	/**
	 * Sets the bioresource reference of this d2 biobank.
	 *
	 * @param bioresourceReference the bioresource reference of this d2 biobank
	 */
	public void setBioresourceReference(String bioresourceReference);

	/**
	 * Returns the biobank network i d ref of this d2 biobank.
	 *
	 * @return the biobank network i d ref of this d2 biobank
	 */
	@AutoEscape
	public String getBiobankNetworkIDRef();

	/**
	 * Sets the biobank network i d ref of this d2 biobank.
	 *
	 * @param biobankNetworkIDRef the biobank network i d ref of this d2 biobank
	 */
	public void setBiobankNetworkIDRef(String biobankNetworkIDRef);

	/**
	 * Returns the geo latitude of this d2 biobank.
	 *
	 * @return the geo latitude of this d2 biobank
	 */
	@AutoEscape
	public String getGeoLatitude();

	/**
	 * Sets the geo latitude of this d2 biobank.
	 *
	 * @param geoLatitude the geo latitude of this d2 biobank
	 */
	public void setGeoLatitude(String geoLatitude);

	/**
	 * Returns the geo longitude of this d2 biobank.
	 *
	 * @return the geo longitude of this d2 biobank
	 */
	@AutoEscape
	public String getGeoLongitude();

	/**
	 * Sets the geo longitude of this d2 biobank.
	 *
	 * @param geoLongitude the geo longitude of this d2 biobank
	 */
	public void setGeoLongitude(String geoLongitude);

	/**
	 * Returns the collaboration partners commercial of this d2 biobank.
	 *
	 * @return the collaboration partners commercial of this d2 biobank
	 */
	public boolean getCollaborationPartnersCommercial();

	/**
	 * Returns <code>true</code> if this d2 biobank is collaboration partners commercial.
	 *
	 * @return <code>true</code> if this d2 biobank is collaboration partners commercial; <code>false</code> otherwise
	 */
	public boolean isCollaborationPartnersCommercial();

	/**
	 * Sets whether this d2 biobank is collaboration partners commercial.
	 *
	 * @param collaborationPartnersCommercial the collaboration partners commercial of this d2 biobank
	 */
	public void setCollaborationPartnersCommercial(
		boolean collaborationPartnersCommercial);

	/**
	 * Returns the collaboration partners nonforprofit of this d2 biobank.
	 *
	 * @return the collaboration partners nonforprofit of this d2 biobank
	 */
	public boolean getCollaborationPartnersNonforprofit();

	/**
	 * Returns <code>true</code> if this d2 biobank is collaboration partners nonforprofit.
	 *
	 * @return <code>true</code> if this d2 biobank is collaboration partners nonforprofit; <code>false</code> otherwise
	 */
	public boolean isCollaborationPartnersNonforprofit();

	/**
	 * Sets whether this d2 biobank is collaboration partners nonforprofit.
	 *
	 * @param collaborationPartnersNonforprofit the collaboration partners nonforprofit of this d2 biobank
	 */
	public void setCollaborationPartnersNonforprofit(
		boolean collaborationPartnersNonforprofit);

	/**
	 * Returns the biobank i t support available of this d2 biobank.
	 *
	 * @return the biobank i t support available of this d2 biobank
	 */
	public boolean getBiobankITSupportAvailable();

	/**
	 * Returns <code>true</code> if this d2 biobank is biobank i t support available.
	 *
	 * @return <code>true</code> if this d2 biobank is biobank i t support available; <code>false</code> otherwise
	 */
	public boolean isBiobankITSupportAvailable();

	/**
	 * Sets whether this d2 biobank is biobank i t support available.
	 *
	 * @param biobankITSupportAvailable the biobank i t support available of this d2 biobank
	 */
	public void setBiobankITSupportAvailable(boolean biobankITSupportAvailable);

	/**
	 * Returns the biobank i t staff size of this d2 biobank.
	 *
	 * @return the biobank i t staff size of this d2 biobank
	 */
	public long getBiobankITStaffSize();

	/**
	 * Sets the biobank i t staff size of this d2 biobank.
	 *
	 * @param biobankITStaffSize the biobank i t staff size of this d2 biobank
	 */
	public void setBiobankITStaffSize(long biobankITStaffSize);

	/**
	 * Returns the biobank i s available of this d2 biobank.
	 *
	 * @return the biobank i s available of this d2 biobank
	 */
	public boolean getBiobankISAvailable();

	/**
	 * Returns <code>true</code> if this d2 biobank is biobank i s available.
	 *
	 * @return <code>true</code> if this d2 biobank is biobank i s available; <code>false</code> otherwise
	 */
	public boolean isBiobankISAvailable();

	/**
	 * Sets whether this d2 biobank is biobank i s available.
	 *
	 * @param biobankISAvailable the biobank i s available of this d2 biobank
	 */
	public void setBiobankISAvailable(boolean biobankISAvailable);

	/**
	 * Returns the biobank h i s available of this d2 biobank.
	 *
	 * @return the biobank h i s available of this d2 biobank
	 */
	public boolean getBiobankHISAvailable();

	/**
	 * Returns <code>true</code> if this d2 biobank is biobank h i s available.
	 *
	 * @return <code>true</code> if this d2 biobank is biobank h i s available; <code>false</code> otherwise
	 */
	public boolean isBiobankHISAvailable();

	/**
	 * Sets whether this d2 biobank is biobank h i s available.
	 *
	 * @param biobankHISAvailable the biobank h i s available of this d2 biobank
	 */
	public void setBiobankHISAvailable(boolean biobankHISAvailable);

	/**
	 * Returns the biobank acronym of this d2 biobank.
	 *
	 * @return the biobank acronym of this d2 biobank
	 */
	@AutoEscape
	public String getBiobankAcronym();

	/**
	 * Sets the biobank acronym of this d2 biobank.
	 *
	 * @param biobankAcronym the biobank acronym of this d2 biobank
	 */
	public void setBiobankAcronym(String biobankAcronym);

	/**
	 * Returns the biobank description of this d2 biobank.
	 *
	 * @return the biobank description of this d2 biobank
	 */
	@AutoEscape
	public String getBiobankDescription();

	/**
	 * Sets the biobank description of this d2 biobank.
	 *
	 * @param biobankDescription the biobank description of this d2 biobank
	 */
	public void setBiobankDescription(String biobankDescription);

	/**
	 * Returns the biobank u r l of this d2 biobank.
	 *
	 * @return the biobank u r l of this d2 biobank
	 */
	@AutoEscape
	public String getBiobankURL();

	/**
	 * Sets the biobank u r l of this d2 biobank.
	 *
	 * @param biobankURL the biobank u r l of this d2 biobank
	 */
	public void setBiobankURL(String biobankURL);

	/**
	 * Returns the biobank head first name of this d2 biobank.
	 *
	 * @return the biobank head first name of this d2 biobank
	 */
	@AutoEscape
	public String getBiobankHeadFirstName();

	/**
	 * Sets the biobank head first name of this d2 biobank.
	 *
	 * @param biobankHeadFirstName the biobank head first name of this d2 biobank
	 */
	public void setBiobankHeadFirstName(String biobankHeadFirstName);

	/**
	 * Returns the biobank head last name of this d2 biobank.
	 *
	 * @return the biobank head last name of this d2 biobank
	 */
	@AutoEscape
	public String getBiobankHeadLastName();

	/**
	 * Sets the biobank head last name of this d2 biobank.
	 *
	 * @param biobankHeadLastName the biobank head last name of this d2 biobank
	 */
	public void setBiobankHeadLastName(String biobankHeadLastName);

	/**
	 * Returns the biobank head role of this d2 biobank.
	 *
	 * @return the biobank head role of this d2 biobank
	 */
	@AutoEscape
	public String getBiobankHeadRole();

	/**
	 * Sets the biobank head role of this d2 biobank.
	 *
	 * @param biobankHeadRole the biobank head role of this d2 biobank
	 */
	public void setBiobankHeadRole(String biobankHeadRole);

	/**
	 * Returns the biobank clinical of this d2 biobank.
	 *
	 * @return the biobank clinical of this d2 biobank
	 */
	public boolean getBiobankClinical();

	/**
	 * Returns <code>true</code> if this d2 biobank is biobank clinical.
	 *
	 * @return <code>true</code> if this d2 biobank is biobank clinical; <code>false</code> otherwise
	 */
	public boolean isBiobankClinical();

	/**
	 * Sets whether this d2 biobank is biobank clinical.
	 *
	 * @param biobankClinical the biobank clinical of this d2 biobank
	 */
	public void setBiobankClinical(boolean biobankClinical);

	/**
	 * Returns the biobank population of this d2 biobank.
	 *
	 * @return the biobank population of this d2 biobank
	 */
	public boolean getBiobankPopulation();

	/**
	 * Returns <code>true</code> if this d2 biobank is biobank population.
	 *
	 * @return <code>true</code> if this d2 biobank is biobank population; <code>false</code> otherwise
	 */
	public boolean isBiobankPopulation();

	/**
	 * Sets whether this d2 biobank is biobank population.
	 *
	 * @param biobankPopulation the biobank population of this d2 biobank
	 */
	public void setBiobankPopulation(boolean biobankPopulation);

	/**
	 * Returns the biobank research study of this d2 biobank.
	 *
	 * @return the biobank research study of this d2 biobank
	 */
	public boolean getBiobankResearchStudy();

	/**
	 * Returns <code>true</code> if this d2 biobank is biobank research study.
	 *
	 * @return <code>true</code> if this d2 biobank is biobank research study; <code>false</code> otherwise
	 */
	public boolean isBiobankResearchStudy();

	/**
	 * Sets whether this d2 biobank is biobank research study.
	 *
	 * @param biobankResearchStudy the biobank research study of this d2 biobank
	 */
	public void setBiobankResearchStudy(boolean biobankResearchStudy);

	/**
	 * Returns the biobank non human of this d2 biobank.
	 *
	 * @return the biobank non human of this d2 biobank
	 */
	public boolean getBiobankNonHuman();

	/**
	 * Returns <code>true</code> if this d2 biobank is biobank non human.
	 *
	 * @return <code>true</code> if this d2 biobank is biobank non human; <code>false</code> otherwise
	 */
	public boolean isBiobankNonHuman();

	/**
	 * Sets whether this d2 biobank is biobank non human.
	 *
	 * @param biobankNonHuman the biobank non human of this d2 biobank
	 */
	public void setBiobankNonHuman(boolean biobankNonHuman);

	/**
	 * Returns the biobank collection of this d2 biobank.
	 *
	 * @return the biobank collection of this d2 biobank
	 */
	public boolean getBiobankCollection();

	/**
	 * Returns <code>true</code> if this d2 biobank is biobank collection.
	 *
	 * @return <code>true</code> if this d2 biobank is biobank collection; <code>false</code> otherwise
	 */
	public boolean isBiobankCollection();

	/**
	 * Sets whether this d2 biobank is biobank collection.
	 *
	 * @param biobankCollection the biobank collection of this d2 biobank
	 */
	public void setBiobankCollection(boolean biobankCollection);

	/**
	 * Returns the biobank type of this d2 biobank.
	 *
	 * @return the biobank type of this d2 biobank
	 */
	@AutoEscape
	public String getBiobankType();

	/**
	 * Sets the biobank type of this d2 biobank.
	 *
	 * @param biobankType the biobank type of this d2 biobank
	 */
	public void setBiobankType(String biobankType);

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	 */
	@Override
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this d2 biobank is approved.
	 *
	 * @return <code>true</code> if this d2 biobank is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this d2 biobank is denied.
	 *
	 * @return <code>true</code> if this d2 biobank is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this d2 biobank is a draft.
	 *
	 * @return <code>true</code> if this d2 biobank is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this d2 biobank is expired.
	 *
	 * @return <code>true</code> if this d2 biobank is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this d2 biobank is inactive.
	 *
	 * @return <code>true</code> if this d2 biobank is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this d2 biobank is incomplete.
	 *
	 * @return <code>true</code> if this d2 biobank is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this d2 biobank is pending.
	 *
	 * @return <code>true</code> if this d2 biobank is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this d2 biobank is scheduled.
	 *
	 * @return <code>true</code> if this d2 biobank is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(D2Biobank d2Biobank);

	@Override
	public int hashCode();

	@Override
	public CacheModel<D2Biobank> toCacheModel();

	@Override
	public D2Biobank toEscapedModel();

	@Override
	public D2Biobank toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}