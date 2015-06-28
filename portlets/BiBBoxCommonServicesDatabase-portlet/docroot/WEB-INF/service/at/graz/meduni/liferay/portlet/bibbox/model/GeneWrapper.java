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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Gene}.
 * </p>
 *
 * @author reihsr
 * @see Gene
 * @generated
 */
public class GeneWrapper implements Gene, ModelWrapper<Gene> {
	public GeneWrapper(Gene gene) {
		_gene = gene;
	}

	@Override
	public Class<?> getModelClass() {
		return Gene.class;
	}

	@Override
	public String getModelClassName() {
		return Gene.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("geneId", getGeneId());
		attributes.put("orphanetdisorderId", getOrphanetdisorderId());
		attributes.put("symbol", getSymbol());
		attributes.put("description", getDescription());
		attributes.put("geneorphanumber", getGeneorphanumber());
		attributes.put("genetype", getGenetype());
		attributes.put("genetypeorphanumber", getGenetypeorphanumber());
		attributes.put("genetypename", getGenetypename());
		attributes.put("disordergeneassociationtype",
			getDisordergeneassociationtype());
		attributes.put("disordergeneassociationtypename",
			getDisordergeneassociationtypename());
		attributes.put("disordergeneassociationstatus",
			getDisordergeneassociationstatus());
		attributes.put("disordergeneassociationstatusname",
			getDisordergeneassociationstatusname());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long geneId = (Long)attributes.get("geneId");

		if (geneId != null) {
			setGeneId(geneId);
		}

		Long orphanetdisorderId = (Long)attributes.get("orphanetdisorderId");

		if (orphanetdisorderId != null) {
			setOrphanetdisorderId(orphanetdisorderId);
		}

		String symbol = (String)attributes.get("symbol");

		if (symbol != null) {
			setSymbol(symbol);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long geneorphanumber = (Long)attributes.get("geneorphanumber");

		if (geneorphanumber != null) {
			setGeneorphanumber(geneorphanumber);
		}

		Long genetype = (Long)attributes.get("genetype");

		if (genetype != null) {
			setGenetype(genetype);
		}

		Long genetypeorphanumber = (Long)attributes.get("genetypeorphanumber");

		if (genetypeorphanumber != null) {
			setGenetypeorphanumber(genetypeorphanumber);
		}

		String genetypename = (String)attributes.get("genetypename");

		if (genetypename != null) {
			setGenetypename(genetypename);
		}

		Long disordergeneassociationtype = (Long)attributes.get(
				"disordergeneassociationtype");

		if (disordergeneassociationtype != null) {
			setDisordergeneassociationtype(disordergeneassociationtype);
		}

		String disordergeneassociationtypename = (String)attributes.get(
				"disordergeneassociationtypename");

		if (disordergeneassociationtypename != null) {
			setDisordergeneassociationtypename(disordergeneassociationtypename);
		}

		Long disordergeneassociationstatus = (Long)attributes.get(
				"disordergeneassociationstatus");

		if (disordergeneassociationstatus != null) {
			setDisordergeneassociationstatus(disordergeneassociationstatus);
		}

		String disordergeneassociationstatusname = (String)attributes.get(
				"disordergeneassociationstatusname");

		if (disordergeneassociationstatusname != null) {
			setDisordergeneassociationstatusname(disordergeneassociationstatusname);
		}
	}

	/**
	* Returns the primary key of this gene.
	*
	* @return the primary key of this gene
	*/
	@Override
	public long getPrimaryKey() {
		return _gene.getPrimaryKey();
	}

	/**
	* Sets the primary key of this gene.
	*
	* @param primaryKey the primary key of this gene
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gene.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the gene ID of this gene.
	*
	* @return the gene ID of this gene
	*/
	@Override
	public long getGeneId() {
		return _gene.getGeneId();
	}

	/**
	* Sets the gene ID of this gene.
	*
	* @param geneId the gene ID of this gene
	*/
	@Override
	public void setGeneId(long geneId) {
		_gene.setGeneId(geneId);
	}

	/**
	* Returns the orphanetdisorder ID of this gene.
	*
	* @return the orphanetdisorder ID of this gene
	*/
	@Override
	public long getOrphanetdisorderId() {
		return _gene.getOrphanetdisorderId();
	}

	/**
	* Sets the orphanetdisorder ID of this gene.
	*
	* @param orphanetdisorderId the orphanetdisorder ID of this gene
	*/
	@Override
	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_gene.setOrphanetdisorderId(orphanetdisorderId);
	}

	/**
	* Returns the symbol of this gene.
	*
	* @return the symbol of this gene
	*/
	@Override
	public java.lang.String getSymbol() {
		return _gene.getSymbol();
	}

	/**
	* Sets the symbol of this gene.
	*
	* @param symbol the symbol of this gene
	*/
	@Override
	public void setSymbol(java.lang.String symbol) {
		_gene.setSymbol(symbol);
	}

	/**
	* Returns the description of this gene.
	*
	* @return the description of this gene
	*/
	@Override
	public java.lang.String getDescription() {
		return _gene.getDescription();
	}

	/**
	* Sets the description of this gene.
	*
	* @param description the description of this gene
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_gene.setDescription(description);
	}

	/**
	* Returns the geneorphanumber of this gene.
	*
	* @return the geneorphanumber of this gene
	*/
	@Override
	public long getGeneorphanumber() {
		return _gene.getGeneorphanumber();
	}

	/**
	* Sets the geneorphanumber of this gene.
	*
	* @param geneorphanumber the geneorphanumber of this gene
	*/
	@Override
	public void setGeneorphanumber(long geneorphanumber) {
		_gene.setGeneorphanumber(geneorphanumber);
	}

	/**
	* Returns the genetype of this gene.
	*
	* @return the genetype of this gene
	*/
	@Override
	public long getGenetype() {
		return _gene.getGenetype();
	}

	/**
	* Sets the genetype of this gene.
	*
	* @param genetype the genetype of this gene
	*/
	@Override
	public void setGenetype(long genetype) {
		_gene.setGenetype(genetype);
	}

	/**
	* Returns the genetypeorphanumber of this gene.
	*
	* @return the genetypeorphanumber of this gene
	*/
	@Override
	public long getGenetypeorphanumber() {
		return _gene.getGenetypeorphanumber();
	}

	/**
	* Sets the genetypeorphanumber of this gene.
	*
	* @param genetypeorphanumber the genetypeorphanumber of this gene
	*/
	@Override
	public void setGenetypeorphanumber(long genetypeorphanumber) {
		_gene.setGenetypeorphanumber(genetypeorphanumber);
	}

	/**
	* Returns the genetypename of this gene.
	*
	* @return the genetypename of this gene
	*/
	@Override
	public java.lang.String getGenetypename() {
		return _gene.getGenetypename();
	}

	/**
	* Sets the genetypename of this gene.
	*
	* @param genetypename the genetypename of this gene
	*/
	@Override
	public void setGenetypename(java.lang.String genetypename) {
		_gene.setGenetypename(genetypename);
	}

	/**
	* Returns the disordergeneassociationtype of this gene.
	*
	* @return the disordergeneassociationtype of this gene
	*/
	@Override
	public long getDisordergeneassociationtype() {
		return _gene.getDisordergeneassociationtype();
	}

	/**
	* Sets the disordergeneassociationtype of this gene.
	*
	* @param disordergeneassociationtype the disordergeneassociationtype of this gene
	*/
	@Override
	public void setDisordergeneassociationtype(long disordergeneassociationtype) {
		_gene.setDisordergeneassociationtype(disordergeneassociationtype);
	}

	/**
	* Returns the disordergeneassociationtypename of this gene.
	*
	* @return the disordergeneassociationtypename of this gene
	*/
	@Override
	public java.lang.String getDisordergeneassociationtypename() {
		return _gene.getDisordergeneassociationtypename();
	}

	/**
	* Sets the disordergeneassociationtypename of this gene.
	*
	* @param disordergeneassociationtypename the disordergeneassociationtypename of this gene
	*/
	@Override
	public void setDisordergeneassociationtypename(
		java.lang.String disordergeneassociationtypename) {
		_gene.setDisordergeneassociationtypename(disordergeneassociationtypename);
	}

	/**
	* Returns the disordergeneassociationstatus of this gene.
	*
	* @return the disordergeneassociationstatus of this gene
	*/
	@Override
	public long getDisordergeneassociationstatus() {
		return _gene.getDisordergeneassociationstatus();
	}

	/**
	* Sets the disordergeneassociationstatus of this gene.
	*
	* @param disordergeneassociationstatus the disordergeneassociationstatus of this gene
	*/
	@Override
	public void setDisordergeneassociationstatus(
		long disordergeneassociationstatus) {
		_gene.setDisordergeneassociationstatus(disordergeneassociationstatus);
	}

	/**
	* Returns the disordergeneassociationstatusname of this gene.
	*
	* @return the disordergeneassociationstatusname of this gene
	*/
	@Override
	public java.lang.String getDisordergeneassociationstatusname() {
		return _gene.getDisordergeneassociationstatusname();
	}

	/**
	* Sets the disordergeneassociationstatusname of this gene.
	*
	* @param disordergeneassociationstatusname the disordergeneassociationstatusname of this gene
	*/
	@Override
	public void setDisordergeneassociationstatusname(
		java.lang.String disordergeneassociationstatusname) {
		_gene.setDisordergeneassociationstatusname(disordergeneassociationstatusname);
	}

	@Override
	public boolean isNew() {
		return _gene.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gene.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gene.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gene.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gene.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gene.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gene.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gene.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gene.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gene.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gene.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GeneWrapper((Gene)_gene.clone());
	}

	@Override
	public int compareTo(at.graz.meduni.liferay.portlet.bibbox.model.Gene gene) {
		return _gene.compareTo(gene);
	}

	@Override
	public int hashCode() {
		return _gene.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.Gene> toCacheModel() {
		return _gene.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.Gene toEscapedModel() {
		return new GeneWrapper(_gene.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.Gene toUnescapedModel() {
		return new GeneWrapper(_gene.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gene.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gene.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gene.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeneWrapper)) {
			return false;
		}

		GeneWrapper geneWrapper = (GeneWrapper)obj;

		if (Validator.equals(_gene, geneWrapper._gene)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Gene getWrappedGene() {
		return _gene;
	}

	@Override
	public Gene getWrappedModel() {
		return _gene;
	}

	@Override
	public void resetOriginalValues() {
		_gene.resetOriginalValues();
	}

	private Gene _gene;
}