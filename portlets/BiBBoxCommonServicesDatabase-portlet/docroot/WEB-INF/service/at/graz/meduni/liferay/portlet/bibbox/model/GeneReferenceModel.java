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

package at.graz.meduni.liferay.portlet.bibbox.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the GeneReference service. Represents a row in the &quot;ontologies.genereference&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneReferenceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneReferenceImpl}.
 * </p>
 *
 * @author reihsr
 * @see GeneReference
 * @see at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneReferenceImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneReferenceModelImpl
 * @generated
 */
public interface GeneReferenceModel extends BaseModel<GeneReference> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a gene reference model instance should use the {@link GeneReference} interface instead.
	 */

	/**
	 * Returns the primary key of this gene reference.
	 *
	 * @return the primary key of this gene reference
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this gene reference.
	 *
	 * @param primaryKey the primary key of this gene reference
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the genereference ID of this gene reference.
	 *
	 * @return the genereference ID of this gene reference
	 */
	public long getGenereferenceId();

	/**
	 * Sets the genereference ID of this gene reference.
	 *
	 * @param genereferenceId the genereference ID of this gene reference
	 */
	public void setGenereferenceId(long genereferenceId);

	/**
	 * Returns the gene ID of this gene reference.
	 *
	 * @return the gene ID of this gene reference
	 */
	public long getGeneId();

	/**
	 * Sets the gene ID of this gene reference.
	 *
	 * @param geneId the gene ID of this gene reference
	 */
	public void setGeneId(long geneId);

	/**
	 * Returns the source of this gene reference.
	 *
	 * @return the source of this gene reference
	 */
	@AutoEscape
	public String getSource();

	/**
	 * Sets the source of this gene reference.
	 *
	 * @param source the source of this gene reference
	 */
	public void setSource(String source);

	/**
	 * Returns the reference of this gene reference.
	 *
	 * @return the reference of this gene reference
	 */
	@AutoEscape
	public String getReference();

	/**
	 * Sets the reference of this gene reference.
	 *
	 * @param reference the reference of this gene reference
	 */
	public void setReference(String reference);

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
	public int compareTo(GeneReference geneReference);

	@Override
	public int hashCode();

	@Override
	public CacheModel<GeneReference> toCacheModel();

	@Override
	public GeneReference toEscapedModel();

	@Override
	public GeneReference toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}