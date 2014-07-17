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

package at.meduni.graz.patho.haybaeck.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class TMASoap implements Serializable {
	public static TMASoap toSoapModel(TMA model) {
		TMASoap soapModel = new TMASoap();

		soapModel.setTma_Id(model.getTma_Id());
		soapModel.setSample_id(model.getSample_id());
		soapModel.setTma_name(model.getTma_name());
		soapModel.setTma_number(model.getTma_number());
		soapModel.setTma_comment(model.getTma_comment());
		soapModel.setCytoplasmic_stat_5_intensity(model.getCytoplasmic_stat_5_intensity());
		soapModel.setCytoplasmic_stat_5_density(model.getCytoplasmic_stat_5_density());
		soapModel.setNuclear_stat_5_intensity(model.getNuclear_stat_5_intensity());
		soapModel.setNuclear_stat_5_density(model.getNuclear_stat_5_density());
		soapModel.setCytoplasmic_cjun_intensity(model.getCytoplasmic_cjun_intensity());
		soapModel.setCytoplasmic_cjun_density(model.getCytoplasmic_cjun_density());
		soapModel.setNuclear_cjun_intensity(model.getNuclear_cjun_intensity());
		soapModel.setNuclear_cjun_density(model.getNuclear_cjun_density());
		soapModel.setCytoplasmic_pstat_3_intensity(model.getCytoplasmic_pstat_3_intensity());
		soapModel.setCytoplasmic_pstat_3_density(model.getCytoplasmic_pstat_3_density());
		soapModel.setNuclear_pstat_3_intensity(model.getNuclear_pstat_3_intensity());
		soapModel.setNuclear_pstat_3_density(model.getNuclear_pstat_3_density());
		soapModel.setCytoplasmic_pstat_5_intensity(model.getCytoplasmic_pstat_5_intensity());
		soapModel.setCytoplasmic_pstat_5_density(model.getCytoplasmic_pstat_5_density());
		soapModel.setNuclear_pstat_5_intensity(model.getNuclear_pstat_5_intensity());
		soapModel.setNuclear_pstat_5_density(model.getNuclear_pstat_5_density());
		soapModel.setCytoplasmic_pstat_1_intensity(model.getCytoplasmic_pstat_1_intensity());
		soapModel.setCytoplasmic_pstat_1_density(model.getCytoplasmic_pstat_1_density());
		soapModel.setNuclear_pstat_1_intensity(model.getNuclear_pstat_1_intensity());
		soapModel.setCytoplasmic_il6r_intensity(model.getCytoplasmic_il6r_intensity());
		soapModel.setCytoplasmic_il6r_density(model.getCytoplasmic_il6r_density());
		soapModel.setNuclear_il6r_intensity(model.getNuclear_il6r_intensity());
		soapModel.setNuclear_il6r_density(model.getNuclear_il6r_density());
		soapModel.setCytoplasmic_socs1_intensity(model.getCytoplasmic_socs1_intensity());
		soapModel.setCytoplasmic_socs1_density(model.getCytoplasmic_socs1_density());
		soapModel.setNuclear_socs1_intensity(model.getNuclear_socs1_intensity());
		soapModel.setNuclear_socs1_density(model.getNuclear_socs1_density());
		soapModel.setCytoplasmic_socs3_intensity(model.getCytoplasmic_socs3_intensity());
		soapModel.setCytoplasmic_socs3_density(model.getCytoplasmic_socs3_density());
		soapModel.setNuclear_socs3_intensity(model.getNuclear_socs3_intensity());
		soapModel.setNuclear_socs3_density(model.getNuclear_socs3_density());
		soapModel.setCytoplasmic_junb_intensity(model.getCytoplasmic_junb_intensity());
		soapModel.setCytoplasmic_junb_density(model.getCytoplasmic_junb_density());
		soapModel.setNuclear_junb_intensity(model.getNuclear_junb_intensity());
		soapModel.setNuclear_junb_density(model.getNuclear_junb_density());
		soapModel.setCytoplasmic_stat_3_intensity(model.getCytoplasmic_stat_3_intensity());
		soapModel.setCytoplasmic_stat_3_density(model.getCytoplasmic_stat_3_density());
		soapModel.setNuclear_stat_3_intensity(model.getNuclear_stat_3_intensity());
		soapModel.setNuclear_stat_3_density(model.getNuclear_stat_3_density());
		soapModel.setCytoplasmic_stat_5a_intensity(model.getCytoplasmic_stat_5a_intensity());
		soapModel.setCytoplasmic_stat_5a_density(model.getCytoplasmic_stat_5a_density());
		soapModel.setNuclear_stat_5a_intensity(model.getNuclear_stat_5a_intensity());
		soapModel.setNuclear_stat_5a_density(model.getNuclear_stat_5a_density());
		soapModel.setCytoplasmic_stat_5b_intensity(model.getCytoplasmic_stat_5b_intensity());
		soapModel.setCytoplasmic_stat_5b_density(model.getCytoplasmic_stat_5b_density());
		soapModel.setNuclear_stat_5b_intensity(model.getNuclear_stat_5b_intensity());
		soapModel.setNuclear_stat_5b_density(model.getNuclear_stat_5b_density());
		soapModel.setCytoplasmic_eif3a_intensity(model.getCytoplasmic_eif3a_intensity());
		soapModel.setCytoplasmic_eif3a_density(model.getCytoplasmic_eif3a_density());
		soapModel.setCytoplasmic_eif3a_peter_intensity(model.getCytoplasmic_eif3a_peter_intensity());
		soapModel.setCytoplasmic_eif3a_peter_density(model.getCytoplasmic_eif3a_peter_density());
		soapModel.setCytoplasmic_itih_5_o1_intensity(model.getCytoplasmic_itih_5_o1_intensity());
		soapModel.setCytoplasmic_itih_5_o1_density(model.getCytoplasmic_itih_5_o1_density());
		soapModel.setNuclear_itih_5_o1_intensity(model.getNuclear_itih_5_o1_intensity());
		soapModel.setNuclear_itih_5_o1_density(model.getNuclear_itih_5_o1_density());
		soapModel.setCytoplasmic_itih_5_o2_intensity(model.getCytoplasmic_itih_5_o2_intensity());
		soapModel.setCytoplasmic_itih_5_o2_density(model.getCytoplasmic_itih_5_o2_density());
		soapModel.setNuclear_itih_5_o2_intensity(model.getNuclear_itih_5_o2_intensity());
		soapModel.setNuclear_itih_5_o2_density(model.getNuclear_itih_5_o2_density());
		soapModel.setCytoplasmic_imp2_2_intensity(model.getCytoplasmic_imp2_2_intensity());
		soapModel.setCytoplasmic_imp2_2_density(model.getCytoplasmic_imp2_2_density());
		soapModel.setCytoplasmic_stat_1_intensity(model.getCytoplasmic_stat_1_intensity());
		soapModel.setCytoplasmic_stat_1_density(model.getCytoplasmic_stat_1_density());
		soapModel.setNuclear_stat_1_intensity(model.getNuclear_stat_1_intensity());
		soapModel.setNuclear_stat_1_density(model.getNuclear_stat_1_density());
		soapModel.setCytoplasmic_nfkb1_intensity(model.getCytoplasmic_nfkb1_intensity());
		soapModel.setCytoplasmic_nfkb1_density(model.getCytoplasmic_nfkb1_density());
		soapModel.setNuclear_nfkb1_intensity(model.getNuclear_nfkb1_intensity());
		soapModel.setNuclear_nfkb1_density(model.getNuclear_nfkb1_density());
		soapModel.setCytoplasmic_nfkb2_intensity(model.getCytoplasmic_nfkb2_intensity());
		soapModel.setCytoplasmic_nfkb2_density(model.getCytoplasmic_nfkb2_density());
		soapModel.setNuclear_nfkb2_intensity(model.getNuclear_nfkb2_intensity());
		soapModel.setNuclear_nfkb2_density(model.getNuclear_nfkb2_density());
		soapModel.setCytoplasmic_pikb_intensity(model.getCytoplasmic_pikb_intensity());
		soapModel.setCytoplasmic_pikb_density(model.getCytoplasmic_pikb_density());
		soapModel.setCytoplasmic_phoshpo_pakt_o1_intensity(model.getCytoplasmic_phoshpo_pakt_o1_intensity());
		soapModel.setCytoplasmic_phoshpo_pakt_o1_density(model.getCytoplasmic_phoshpo_pakt_o1_density());
		soapModel.setNuclear_phoshpo_pakt_o1_intensity(model.getNuclear_phoshpo_pakt_o1_intensity());
		soapModel.setNuclear_phoshpo_pakt_o1_density(model.getNuclear_phoshpo_pakt_o1_density());
		soapModel.setCytoplasmic_phoshpo_pakt_o2_intensity(model.getCytoplasmic_phoshpo_pakt_o2_intensity());
		soapModel.setCytoplasmic_phoshpo_pakt_o2_density(model.getCytoplasmic_phoshpo_pakt_o2_density());
		soapModel.setNuclear_phoshpo_pakt_o2_intensity(model.getNuclear_phoshpo_pakt_o2_intensity());
		soapModel.setNuclear_phoshpo_pakt_o2_density(model.getNuclear_phoshpo_pakt_o2_density());
		soapModel.setCytoplasmic_phoshpo_pmtor_o1_intensity(model.getCytoplasmic_phoshpo_pmtor_o1_intensity());
		soapModel.setCytoplasmic_phoshpo_pmtor_o1_density(model.getCytoplasmic_phoshpo_pmtor_o1_density());
		soapModel.setNuclear_phoshpo_pmtor_o1_intensity(model.getNuclear_phoshpo_pmtor_o1_intensity());
		soapModel.setNuclear_phoshpo_pmtor_o1_density(model.getNuclear_phoshpo_pmtor_o1_density());
		soapModel.setCytoplasmic_phoshpo_pmtor_o2_intensity(model.getCytoplasmic_phoshpo_pmtor_o2_intensity());
		soapModel.setCytoplasmic_phoshpo_pmtor_o2_density(model.getCytoplasmic_phoshpo_pmtor_o2_density());
		soapModel.setNuclear_phoshpo_pmtor_o2_intensity(model.getNuclear_phoshpo_pmtor_o2_intensity());
		soapModel.setNuclear_phoshpo_pmtor_o2_density(model.getNuclear_phoshpo_pmtor_o2_density());
		soapModel.setCytoplasmic_phoshpo_pp70s6k_o1_density(model.getCytoplasmic_phoshpo_pp70s6k_o1_density());
		soapModel.setNuclear_phoshpo_pp70s6k_o1_intensity(model.getNuclear_phoshpo_pp70s6k_o1_intensity());
		soapModel.setNuclear_phoshpo_pp70s6k_o1_density(model.getNuclear_phoshpo_pp70s6k_o1_density());
		soapModel.setCytoplasmic_phoshpo_pp70s6k_o2_intensity(model.getCytoplasmic_phoshpo_pp70s6k_o2_intensity());
		soapModel.setCytoplasmic_phoshpo_pp70s6k_o2_density(model.getCytoplasmic_phoshpo_pp70s6k_o2_density());
		soapModel.setNuclear_phoshpo_pp70s6k_o2_intensity(model.getNuclear_phoshpo_pp70s6k_o2_intensity());
		soapModel.setNuclear_phoshpo_pp70s6k_o2_density(model.getNuclear_phoshpo_pp70s6k_o2_density());
		soapModel.setCytoplasmic_phoshpo_pp70s6k_o1_intensity(model.getCytoplasmic_phoshpo_pp70s6k_o1_intensity());
		soapModel.setCytoplasmic_phoshpo_pten_o1_intensity(model.getCytoplasmic_phoshpo_pten_o1_intensity());
		soapModel.setCytoplasmic_phoshpo_pten_o1_density(model.getCytoplasmic_phoshpo_pten_o1_density());
		soapModel.setNuclear_phoshpo_pten_o1_intensity(model.getNuclear_phoshpo_pten_o1_intensity());
		soapModel.setNuclear_phoshpo_pten_o1_density(model.getNuclear_phoshpo_pten_o1_density());
		soapModel.setCytoplasmic_phoshpo_pten_o2_intensity(model.getCytoplasmic_phoshpo_pten_o2_intensity());
		soapModel.setCytoplasmic_phoshpo_pten_o2_density(model.getCytoplasmic_phoshpo_pten_o2_density());
		soapModel.setNuclear_phoshpo_pten_o2_intensity(model.getNuclear_phoshpo_pten_o2_intensity());
		soapModel.setNuclear_phoshpo_pten_o2_density(model.getNuclear_phoshpo_pten_o2_density());

		return soapModel;
	}

	public static TMASoap[] toSoapModels(TMA[] models) {
		TMASoap[] soapModels = new TMASoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TMASoap[][] toSoapModels(TMA[][] models) {
		TMASoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TMASoap[models.length][models[0].length];
		}
		else {
			soapModels = new TMASoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TMASoap[] toSoapModels(List<TMA> models) {
		List<TMASoap> soapModels = new ArrayList<TMASoap>(models.size());

		for (TMA model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TMASoap[soapModels.size()]);
	}

	public TMASoap() {
	}

	public long getPrimaryKey() {
		return _tma_Id;
	}

	public void setPrimaryKey(long pk) {
		setTma_Id(pk);
	}

	public long getTma_Id() {
		return _tma_Id;
	}

	public void setTma_Id(long tma_Id) {
		_tma_Id = tma_Id;
	}

	public long getSample_id() {
		return _sample_id;
	}

	public void setSample_id(long sample_id) {
		_sample_id = sample_id;
	}

	public String getTma_name() {
		return _tma_name;
	}

	public void setTma_name(String tma_name) {
		_tma_name = tma_name;
	}

	public String getTma_number() {
		return _tma_number;
	}

	public void setTma_number(String tma_number) {
		_tma_number = tma_number;
	}

	public String getTma_comment() {
		return _tma_comment;
	}

	public void setTma_comment(String tma_comment) {
		_tma_comment = tma_comment;
	}

	public long getCytoplasmic_stat_5_intensity() {
		return _cytoplasmic_stat_5_intensity;
	}

	public void setCytoplasmic_stat_5_intensity(
		long cytoplasmic_stat_5_intensity) {
		_cytoplasmic_stat_5_intensity = cytoplasmic_stat_5_intensity;
	}

	public long getCytoplasmic_stat_5_density() {
		return _cytoplasmic_stat_5_density;
	}

	public void setCytoplasmic_stat_5_density(long cytoplasmic_stat_5_density) {
		_cytoplasmic_stat_5_density = cytoplasmic_stat_5_density;
	}

	public long getNuclear_stat_5_intensity() {
		return _nuclear_stat_5_intensity;
	}

	public void setNuclear_stat_5_intensity(long nuclear_stat_5_intensity) {
		_nuclear_stat_5_intensity = nuclear_stat_5_intensity;
	}

	public long getNuclear_stat_5_density() {
		return _nuclear_stat_5_density;
	}

	public void setNuclear_stat_5_density(long nuclear_stat_5_density) {
		_nuclear_stat_5_density = nuclear_stat_5_density;
	}

	public long getCytoplasmic_cjun_intensity() {
		return _cytoplasmic_cjun_intensity;
	}

	public void setCytoplasmic_cjun_intensity(long cytoplasmic_cjun_intensity) {
		_cytoplasmic_cjun_intensity = cytoplasmic_cjun_intensity;
	}

	public long getCytoplasmic_cjun_density() {
		return _cytoplasmic_cjun_density;
	}

	public void setCytoplasmic_cjun_density(long cytoplasmic_cjun_density) {
		_cytoplasmic_cjun_density = cytoplasmic_cjun_density;
	}

	public long getNuclear_cjun_intensity() {
		return _nuclear_cjun_intensity;
	}

	public void setNuclear_cjun_intensity(long nuclear_cjun_intensity) {
		_nuclear_cjun_intensity = nuclear_cjun_intensity;
	}

	public long getNuclear_cjun_density() {
		return _nuclear_cjun_density;
	}

	public void setNuclear_cjun_density(long nuclear_cjun_density) {
		_nuclear_cjun_density = nuclear_cjun_density;
	}

	public long getCytoplasmic_pstat_3_intensity() {
		return _cytoplasmic_pstat_3_intensity;
	}

	public void setCytoplasmic_pstat_3_intensity(
		long cytoplasmic_pstat_3_intensity) {
		_cytoplasmic_pstat_3_intensity = cytoplasmic_pstat_3_intensity;
	}

	public long getCytoplasmic_pstat_3_density() {
		return _cytoplasmic_pstat_3_density;
	}

	public void setCytoplasmic_pstat_3_density(long cytoplasmic_pstat_3_density) {
		_cytoplasmic_pstat_3_density = cytoplasmic_pstat_3_density;
	}

	public long getNuclear_pstat_3_intensity() {
		return _nuclear_pstat_3_intensity;
	}

	public void setNuclear_pstat_3_intensity(long nuclear_pstat_3_intensity) {
		_nuclear_pstat_3_intensity = nuclear_pstat_3_intensity;
	}

	public long getNuclear_pstat_3_density() {
		return _nuclear_pstat_3_density;
	}

	public void setNuclear_pstat_3_density(long nuclear_pstat_3_density) {
		_nuclear_pstat_3_density = nuclear_pstat_3_density;
	}

	public long getCytoplasmic_pstat_5_intensity() {
		return _cytoplasmic_pstat_5_intensity;
	}

	public void setCytoplasmic_pstat_5_intensity(
		long cytoplasmic_pstat_5_intensity) {
		_cytoplasmic_pstat_5_intensity = cytoplasmic_pstat_5_intensity;
	}

	public long getCytoplasmic_pstat_5_density() {
		return _cytoplasmic_pstat_5_density;
	}

	public void setCytoplasmic_pstat_5_density(long cytoplasmic_pstat_5_density) {
		_cytoplasmic_pstat_5_density = cytoplasmic_pstat_5_density;
	}

	public long getNuclear_pstat_5_intensity() {
		return _nuclear_pstat_5_intensity;
	}

	public void setNuclear_pstat_5_intensity(long nuclear_pstat_5_intensity) {
		_nuclear_pstat_5_intensity = nuclear_pstat_5_intensity;
	}

	public long getNuclear_pstat_5_density() {
		return _nuclear_pstat_5_density;
	}

	public void setNuclear_pstat_5_density(long nuclear_pstat_5_density) {
		_nuclear_pstat_5_density = nuclear_pstat_5_density;
	}

	public long getCytoplasmic_pstat_1_intensity() {
		return _cytoplasmic_pstat_1_intensity;
	}

	public void setCytoplasmic_pstat_1_intensity(
		long cytoplasmic_pstat_1_intensity) {
		_cytoplasmic_pstat_1_intensity = cytoplasmic_pstat_1_intensity;
	}

	public long getCytoplasmic_pstat_1_density() {
		return _cytoplasmic_pstat_1_density;
	}

	public void setCytoplasmic_pstat_1_density(long cytoplasmic_pstat_1_density) {
		_cytoplasmic_pstat_1_density = cytoplasmic_pstat_1_density;
	}

	public long getNuclear_pstat_1_intensity() {
		return _nuclear_pstat_1_intensity;
	}

	public void setNuclear_pstat_1_intensity(long nuclear_pstat_1_intensity) {
		_nuclear_pstat_1_intensity = nuclear_pstat_1_intensity;
	}

	public long getCytoplasmic_il6r_intensity() {
		return _cytoplasmic_il6r_intensity;
	}

	public void setCytoplasmic_il6r_intensity(long cytoplasmic_il6r_intensity) {
		_cytoplasmic_il6r_intensity = cytoplasmic_il6r_intensity;
	}

	public long getCytoplasmic_il6r_density() {
		return _cytoplasmic_il6r_density;
	}

	public void setCytoplasmic_il6r_density(long cytoplasmic_il6r_density) {
		_cytoplasmic_il6r_density = cytoplasmic_il6r_density;
	}

	public long getNuclear_il6r_intensity() {
		return _nuclear_il6r_intensity;
	}

	public void setNuclear_il6r_intensity(long nuclear_il6r_intensity) {
		_nuclear_il6r_intensity = nuclear_il6r_intensity;
	}

	public long getNuclear_il6r_density() {
		return _nuclear_il6r_density;
	}

	public void setNuclear_il6r_density(long nuclear_il6r_density) {
		_nuclear_il6r_density = nuclear_il6r_density;
	}

	public long getCytoplasmic_socs1_intensity() {
		return _cytoplasmic_socs1_intensity;
	}

	public void setCytoplasmic_socs1_intensity(long cytoplasmic_socs1_intensity) {
		_cytoplasmic_socs1_intensity = cytoplasmic_socs1_intensity;
	}

	public long getCytoplasmic_socs1_density() {
		return _cytoplasmic_socs1_density;
	}

	public void setCytoplasmic_socs1_density(long cytoplasmic_socs1_density) {
		_cytoplasmic_socs1_density = cytoplasmic_socs1_density;
	}

	public long getNuclear_socs1_intensity() {
		return _nuclear_socs1_intensity;
	}

	public void setNuclear_socs1_intensity(long nuclear_socs1_intensity) {
		_nuclear_socs1_intensity = nuclear_socs1_intensity;
	}

	public long getNuclear_socs1_density() {
		return _nuclear_socs1_density;
	}

	public void setNuclear_socs1_density(long nuclear_socs1_density) {
		_nuclear_socs1_density = nuclear_socs1_density;
	}

	public long getCytoplasmic_socs3_intensity() {
		return _cytoplasmic_socs3_intensity;
	}

	public void setCytoplasmic_socs3_intensity(long cytoplasmic_socs3_intensity) {
		_cytoplasmic_socs3_intensity = cytoplasmic_socs3_intensity;
	}

	public long getCytoplasmic_socs3_density() {
		return _cytoplasmic_socs3_density;
	}

	public void setCytoplasmic_socs3_density(long cytoplasmic_socs3_density) {
		_cytoplasmic_socs3_density = cytoplasmic_socs3_density;
	}

	public long getNuclear_socs3_intensity() {
		return _nuclear_socs3_intensity;
	}

	public void setNuclear_socs3_intensity(long nuclear_socs3_intensity) {
		_nuclear_socs3_intensity = nuclear_socs3_intensity;
	}

	public long getNuclear_socs3_density() {
		return _nuclear_socs3_density;
	}

	public void setNuclear_socs3_density(long nuclear_socs3_density) {
		_nuclear_socs3_density = nuclear_socs3_density;
	}

	public long getCytoplasmic_junb_intensity() {
		return _cytoplasmic_junb_intensity;
	}

	public void setCytoplasmic_junb_intensity(long cytoplasmic_junb_intensity) {
		_cytoplasmic_junb_intensity = cytoplasmic_junb_intensity;
	}

	public long getCytoplasmic_junb_density() {
		return _cytoplasmic_junb_density;
	}

	public void setCytoplasmic_junb_density(long cytoplasmic_junb_density) {
		_cytoplasmic_junb_density = cytoplasmic_junb_density;
	}

	public long getNuclear_junb_intensity() {
		return _nuclear_junb_intensity;
	}

	public void setNuclear_junb_intensity(long nuclear_junb_intensity) {
		_nuclear_junb_intensity = nuclear_junb_intensity;
	}

	public long getNuclear_junb_density() {
		return _nuclear_junb_density;
	}

	public void setNuclear_junb_density(long nuclear_junb_density) {
		_nuclear_junb_density = nuclear_junb_density;
	}

	public long getCytoplasmic_stat_3_intensity() {
		return _cytoplasmic_stat_3_intensity;
	}

	public void setCytoplasmic_stat_3_intensity(
		long cytoplasmic_stat_3_intensity) {
		_cytoplasmic_stat_3_intensity = cytoplasmic_stat_3_intensity;
	}

	public long getCytoplasmic_stat_3_density() {
		return _cytoplasmic_stat_3_density;
	}

	public void setCytoplasmic_stat_3_density(long cytoplasmic_stat_3_density) {
		_cytoplasmic_stat_3_density = cytoplasmic_stat_3_density;
	}

	public long getNuclear_stat_3_intensity() {
		return _nuclear_stat_3_intensity;
	}

	public void setNuclear_stat_3_intensity(long nuclear_stat_3_intensity) {
		_nuclear_stat_3_intensity = nuclear_stat_3_intensity;
	}

	public long getNuclear_stat_3_density() {
		return _nuclear_stat_3_density;
	}

	public void setNuclear_stat_3_density(long nuclear_stat_3_density) {
		_nuclear_stat_3_density = nuclear_stat_3_density;
	}

	public long getCytoplasmic_stat_5a_intensity() {
		return _cytoplasmic_stat_5a_intensity;
	}

	public void setCytoplasmic_stat_5a_intensity(
		long cytoplasmic_stat_5a_intensity) {
		_cytoplasmic_stat_5a_intensity = cytoplasmic_stat_5a_intensity;
	}

	public long getCytoplasmic_stat_5a_density() {
		return _cytoplasmic_stat_5a_density;
	}

	public void setCytoplasmic_stat_5a_density(long cytoplasmic_stat_5a_density) {
		_cytoplasmic_stat_5a_density = cytoplasmic_stat_5a_density;
	}

	public long getNuclear_stat_5a_intensity() {
		return _nuclear_stat_5a_intensity;
	}

	public void setNuclear_stat_5a_intensity(long nuclear_stat_5a_intensity) {
		_nuclear_stat_5a_intensity = nuclear_stat_5a_intensity;
	}

	public long getNuclear_stat_5a_density() {
		return _nuclear_stat_5a_density;
	}

	public void setNuclear_stat_5a_density(long nuclear_stat_5a_density) {
		_nuclear_stat_5a_density = nuclear_stat_5a_density;
	}

	public long getCytoplasmic_stat_5b_intensity() {
		return _cytoplasmic_stat_5b_intensity;
	}

	public void setCytoplasmic_stat_5b_intensity(
		long cytoplasmic_stat_5b_intensity) {
		_cytoplasmic_stat_5b_intensity = cytoplasmic_stat_5b_intensity;
	}

	public long getCytoplasmic_stat_5b_density() {
		return _cytoplasmic_stat_5b_density;
	}

	public void setCytoplasmic_stat_5b_density(long cytoplasmic_stat_5b_density) {
		_cytoplasmic_stat_5b_density = cytoplasmic_stat_5b_density;
	}

	public long getNuclear_stat_5b_intensity() {
		return _nuclear_stat_5b_intensity;
	}

	public void setNuclear_stat_5b_intensity(long nuclear_stat_5b_intensity) {
		_nuclear_stat_5b_intensity = nuclear_stat_5b_intensity;
	}

	public long getNuclear_stat_5b_density() {
		return _nuclear_stat_5b_density;
	}

	public void setNuclear_stat_5b_density(long nuclear_stat_5b_density) {
		_nuclear_stat_5b_density = nuclear_stat_5b_density;
	}

	public long getCytoplasmic_eif3a_intensity() {
		return _cytoplasmic_eif3a_intensity;
	}

	public void setCytoplasmic_eif3a_intensity(long cytoplasmic_eif3a_intensity) {
		_cytoplasmic_eif3a_intensity = cytoplasmic_eif3a_intensity;
	}

	public long getCytoplasmic_eif3a_density() {
		return _cytoplasmic_eif3a_density;
	}

	public void setCytoplasmic_eif3a_density(long cytoplasmic_eif3a_density) {
		_cytoplasmic_eif3a_density = cytoplasmic_eif3a_density;
	}

	public long getCytoplasmic_eif3a_peter_intensity() {
		return _cytoplasmic_eif3a_peter_intensity;
	}

	public void setCytoplasmic_eif3a_peter_intensity(
		long cytoplasmic_eif3a_peter_intensity) {
		_cytoplasmic_eif3a_peter_intensity = cytoplasmic_eif3a_peter_intensity;
	}

	public long getCytoplasmic_eif3a_peter_density() {
		return _cytoplasmic_eif3a_peter_density;
	}

	public void setCytoplasmic_eif3a_peter_density(
		long cytoplasmic_eif3a_peter_density) {
		_cytoplasmic_eif3a_peter_density = cytoplasmic_eif3a_peter_density;
	}

	public long getCytoplasmic_itih_5_o1_intensity() {
		return _cytoplasmic_itih_5_o1_intensity;
	}

	public void setCytoplasmic_itih_5_o1_intensity(
		long cytoplasmic_itih_5_o1_intensity) {
		_cytoplasmic_itih_5_o1_intensity = cytoplasmic_itih_5_o1_intensity;
	}

	public long getCytoplasmic_itih_5_o1_density() {
		return _cytoplasmic_itih_5_o1_density;
	}

	public void setCytoplasmic_itih_5_o1_density(
		long cytoplasmic_itih_5_o1_density) {
		_cytoplasmic_itih_5_o1_density = cytoplasmic_itih_5_o1_density;
	}

	public long getNuclear_itih_5_o1_intensity() {
		return _nuclear_itih_5_o1_intensity;
	}

	public void setNuclear_itih_5_o1_intensity(long nuclear_itih_5_o1_intensity) {
		_nuclear_itih_5_o1_intensity = nuclear_itih_5_o1_intensity;
	}

	public long getNuclear_itih_5_o1_density() {
		return _nuclear_itih_5_o1_density;
	}

	public void setNuclear_itih_5_o1_density(long nuclear_itih_5_o1_density) {
		_nuclear_itih_5_o1_density = nuclear_itih_5_o1_density;
	}

	public long getCytoplasmic_itih_5_o2_intensity() {
		return _cytoplasmic_itih_5_o2_intensity;
	}

	public void setCytoplasmic_itih_5_o2_intensity(
		long cytoplasmic_itih_5_o2_intensity) {
		_cytoplasmic_itih_5_o2_intensity = cytoplasmic_itih_5_o2_intensity;
	}

	public long getCytoplasmic_itih_5_o2_density() {
		return _cytoplasmic_itih_5_o2_density;
	}

	public void setCytoplasmic_itih_5_o2_density(
		long cytoplasmic_itih_5_o2_density) {
		_cytoplasmic_itih_5_o2_density = cytoplasmic_itih_5_o2_density;
	}

	public long getNuclear_itih_5_o2_intensity() {
		return _nuclear_itih_5_o2_intensity;
	}

	public void setNuclear_itih_5_o2_intensity(long nuclear_itih_5_o2_intensity) {
		_nuclear_itih_5_o2_intensity = nuclear_itih_5_o2_intensity;
	}

	public long getNuclear_itih_5_o2_density() {
		return _nuclear_itih_5_o2_density;
	}

	public void setNuclear_itih_5_o2_density(long nuclear_itih_5_o2_density) {
		_nuclear_itih_5_o2_density = nuclear_itih_5_o2_density;
	}

	public long getCytoplasmic_imp2_2_intensity() {
		return _cytoplasmic_imp2_2_intensity;
	}

	public void setCytoplasmic_imp2_2_intensity(
		long cytoplasmic_imp2_2_intensity) {
		_cytoplasmic_imp2_2_intensity = cytoplasmic_imp2_2_intensity;
	}

	public long getCytoplasmic_imp2_2_density() {
		return _cytoplasmic_imp2_2_density;
	}

	public void setCytoplasmic_imp2_2_density(long cytoplasmic_imp2_2_density) {
		_cytoplasmic_imp2_2_density = cytoplasmic_imp2_2_density;
	}

	public long getCytoplasmic_stat_1_intensity() {
		return _cytoplasmic_stat_1_intensity;
	}

	public void setCytoplasmic_stat_1_intensity(
		long cytoplasmic_stat_1_intensity) {
		_cytoplasmic_stat_1_intensity = cytoplasmic_stat_1_intensity;
	}

	public long getCytoplasmic_stat_1_density() {
		return _cytoplasmic_stat_1_density;
	}

	public void setCytoplasmic_stat_1_density(long cytoplasmic_stat_1_density) {
		_cytoplasmic_stat_1_density = cytoplasmic_stat_1_density;
	}

	public long getNuclear_stat_1_intensity() {
		return _nuclear_stat_1_intensity;
	}

	public void setNuclear_stat_1_intensity(long nuclear_stat_1_intensity) {
		_nuclear_stat_1_intensity = nuclear_stat_1_intensity;
	}

	public long getNuclear_stat_1_density() {
		return _nuclear_stat_1_density;
	}

	public void setNuclear_stat_1_density(long nuclear_stat_1_density) {
		_nuclear_stat_1_density = nuclear_stat_1_density;
	}

	public long getCytoplasmic_nfkb1_intensity() {
		return _cytoplasmic_nfkb1_intensity;
	}

	public void setCytoplasmic_nfkb1_intensity(long cytoplasmic_nfkb1_intensity) {
		_cytoplasmic_nfkb1_intensity = cytoplasmic_nfkb1_intensity;
	}

	public long getCytoplasmic_nfkb1_density() {
		return _cytoplasmic_nfkb1_density;
	}

	public void setCytoplasmic_nfkb1_density(long cytoplasmic_nfkb1_density) {
		_cytoplasmic_nfkb1_density = cytoplasmic_nfkb1_density;
	}

	public long getNuclear_nfkb1_intensity() {
		return _nuclear_nfkb1_intensity;
	}

	public void setNuclear_nfkb1_intensity(long nuclear_nfkb1_intensity) {
		_nuclear_nfkb1_intensity = nuclear_nfkb1_intensity;
	}

	public long getNuclear_nfkb1_density() {
		return _nuclear_nfkb1_density;
	}

	public void setNuclear_nfkb1_density(long nuclear_nfkb1_density) {
		_nuclear_nfkb1_density = nuclear_nfkb1_density;
	}

	public long getCytoplasmic_nfkb2_intensity() {
		return _cytoplasmic_nfkb2_intensity;
	}

	public void setCytoplasmic_nfkb2_intensity(long cytoplasmic_nfkb2_intensity) {
		_cytoplasmic_nfkb2_intensity = cytoplasmic_nfkb2_intensity;
	}

	public long getCytoplasmic_nfkb2_density() {
		return _cytoplasmic_nfkb2_density;
	}

	public void setCytoplasmic_nfkb2_density(long cytoplasmic_nfkb2_density) {
		_cytoplasmic_nfkb2_density = cytoplasmic_nfkb2_density;
	}

	public long getNuclear_nfkb2_intensity() {
		return _nuclear_nfkb2_intensity;
	}

	public void setNuclear_nfkb2_intensity(long nuclear_nfkb2_intensity) {
		_nuclear_nfkb2_intensity = nuclear_nfkb2_intensity;
	}

	public long getNuclear_nfkb2_density() {
		return _nuclear_nfkb2_density;
	}

	public void setNuclear_nfkb2_density(long nuclear_nfkb2_density) {
		_nuclear_nfkb2_density = nuclear_nfkb2_density;
	}

	public long getCytoplasmic_pikb_intensity() {
		return _cytoplasmic_pikb_intensity;
	}

	public void setCytoplasmic_pikb_intensity(long cytoplasmic_pikb_intensity) {
		_cytoplasmic_pikb_intensity = cytoplasmic_pikb_intensity;
	}

	public long getCytoplasmic_pikb_density() {
		return _cytoplasmic_pikb_density;
	}

	public void setCytoplasmic_pikb_density(long cytoplasmic_pikb_density) {
		_cytoplasmic_pikb_density = cytoplasmic_pikb_density;
	}

	public long getCytoplasmic_phoshpo_pakt_o1_intensity() {
		return _cytoplasmic_phoshpo_pakt_o1_intensity;
	}

	public void setCytoplasmic_phoshpo_pakt_o1_intensity(
		long cytoplasmic_phoshpo_pakt_o1_intensity) {
		_cytoplasmic_phoshpo_pakt_o1_intensity = cytoplasmic_phoshpo_pakt_o1_intensity;
	}

	public long getCytoplasmic_phoshpo_pakt_o1_density() {
		return _cytoplasmic_phoshpo_pakt_o1_density;
	}

	public void setCytoplasmic_phoshpo_pakt_o1_density(
		long cytoplasmic_phoshpo_pakt_o1_density) {
		_cytoplasmic_phoshpo_pakt_o1_density = cytoplasmic_phoshpo_pakt_o1_density;
	}

	public long getNuclear_phoshpo_pakt_o1_intensity() {
		return _nuclear_phoshpo_pakt_o1_intensity;
	}

	public void setNuclear_phoshpo_pakt_o1_intensity(
		long nuclear_phoshpo_pakt_o1_intensity) {
		_nuclear_phoshpo_pakt_o1_intensity = nuclear_phoshpo_pakt_o1_intensity;
	}

	public long getNuclear_phoshpo_pakt_o1_density() {
		return _nuclear_phoshpo_pakt_o1_density;
	}

	public void setNuclear_phoshpo_pakt_o1_density(
		long nuclear_phoshpo_pakt_o1_density) {
		_nuclear_phoshpo_pakt_o1_density = nuclear_phoshpo_pakt_o1_density;
	}

	public long getCytoplasmic_phoshpo_pakt_o2_intensity() {
		return _cytoplasmic_phoshpo_pakt_o2_intensity;
	}

	public void setCytoplasmic_phoshpo_pakt_o2_intensity(
		long cytoplasmic_phoshpo_pakt_o2_intensity) {
		_cytoplasmic_phoshpo_pakt_o2_intensity = cytoplasmic_phoshpo_pakt_o2_intensity;
	}

	public long getCytoplasmic_phoshpo_pakt_o2_density() {
		return _cytoplasmic_phoshpo_pakt_o2_density;
	}

	public void setCytoplasmic_phoshpo_pakt_o2_density(
		long cytoplasmic_phoshpo_pakt_o2_density) {
		_cytoplasmic_phoshpo_pakt_o2_density = cytoplasmic_phoshpo_pakt_o2_density;
	}

	public long getNuclear_phoshpo_pakt_o2_intensity() {
		return _nuclear_phoshpo_pakt_o2_intensity;
	}

	public void setNuclear_phoshpo_pakt_o2_intensity(
		long nuclear_phoshpo_pakt_o2_intensity) {
		_nuclear_phoshpo_pakt_o2_intensity = nuclear_phoshpo_pakt_o2_intensity;
	}

	public long getNuclear_phoshpo_pakt_o2_density() {
		return _nuclear_phoshpo_pakt_o2_density;
	}

	public void setNuclear_phoshpo_pakt_o2_density(
		long nuclear_phoshpo_pakt_o2_density) {
		_nuclear_phoshpo_pakt_o2_density = nuclear_phoshpo_pakt_o2_density;
	}

	public long getCytoplasmic_phoshpo_pmtor_o1_intensity() {
		return _cytoplasmic_phoshpo_pmtor_o1_intensity;
	}

	public void setCytoplasmic_phoshpo_pmtor_o1_intensity(
		long cytoplasmic_phoshpo_pmtor_o1_intensity) {
		_cytoplasmic_phoshpo_pmtor_o1_intensity = cytoplasmic_phoshpo_pmtor_o1_intensity;
	}

	public long getCytoplasmic_phoshpo_pmtor_o1_density() {
		return _cytoplasmic_phoshpo_pmtor_o1_density;
	}

	public void setCytoplasmic_phoshpo_pmtor_o1_density(
		long cytoplasmic_phoshpo_pmtor_o1_density) {
		_cytoplasmic_phoshpo_pmtor_o1_density = cytoplasmic_phoshpo_pmtor_o1_density;
	}

	public long getNuclear_phoshpo_pmtor_o1_intensity() {
		return _nuclear_phoshpo_pmtor_o1_intensity;
	}

	public void setNuclear_phoshpo_pmtor_o1_intensity(
		long nuclear_phoshpo_pmtor_o1_intensity) {
		_nuclear_phoshpo_pmtor_o1_intensity = nuclear_phoshpo_pmtor_o1_intensity;
	}

	public long getNuclear_phoshpo_pmtor_o1_density() {
		return _nuclear_phoshpo_pmtor_o1_density;
	}

	public void setNuclear_phoshpo_pmtor_o1_density(
		long nuclear_phoshpo_pmtor_o1_density) {
		_nuclear_phoshpo_pmtor_o1_density = nuclear_phoshpo_pmtor_o1_density;
	}

	public long getCytoplasmic_phoshpo_pmtor_o2_intensity() {
		return _cytoplasmic_phoshpo_pmtor_o2_intensity;
	}

	public void setCytoplasmic_phoshpo_pmtor_o2_intensity(
		long cytoplasmic_phoshpo_pmtor_o2_intensity) {
		_cytoplasmic_phoshpo_pmtor_o2_intensity = cytoplasmic_phoshpo_pmtor_o2_intensity;
	}

	public long getCytoplasmic_phoshpo_pmtor_o2_density() {
		return _cytoplasmic_phoshpo_pmtor_o2_density;
	}

	public void setCytoplasmic_phoshpo_pmtor_o2_density(
		long cytoplasmic_phoshpo_pmtor_o2_density) {
		_cytoplasmic_phoshpo_pmtor_o2_density = cytoplasmic_phoshpo_pmtor_o2_density;
	}

	public long getNuclear_phoshpo_pmtor_o2_intensity() {
		return _nuclear_phoshpo_pmtor_o2_intensity;
	}

	public void setNuclear_phoshpo_pmtor_o2_intensity(
		long nuclear_phoshpo_pmtor_o2_intensity) {
		_nuclear_phoshpo_pmtor_o2_intensity = nuclear_phoshpo_pmtor_o2_intensity;
	}

	public long getNuclear_phoshpo_pmtor_o2_density() {
		return _nuclear_phoshpo_pmtor_o2_density;
	}

	public void setNuclear_phoshpo_pmtor_o2_density(
		long nuclear_phoshpo_pmtor_o2_density) {
		_nuclear_phoshpo_pmtor_o2_density = nuclear_phoshpo_pmtor_o2_density;
	}

	public long getCytoplasmic_phoshpo_pp70s6k_o1_density() {
		return _cytoplasmic_phoshpo_pp70s6k_o1_density;
	}

	public void setCytoplasmic_phoshpo_pp70s6k_o1_density(
		long cytoplasmic_phoshpo_pp70s6k_o1_density) {
		_cytoplasmic_phoshpo_pp70s6k_o1_density = cytoplasmic_phoshpo_pp70s6k_o1_density;
	}

	public long getNuclear_phoshpo_pp70s6k_o1_intensity() {
		return _nuclear_phoshpo_pp70s6k_o1_intensity;
	}

	public void setNuclear_phoshpo_pp70s6k_o1_intensity(
		long nuclear_phoshpo_pp70s6k_o1_intensity) {
		_nuclear_phoshpo_pp70s6k_o1_intensity = nuclear_phoshpo_pp70s6k_o1_intensity;
	}

	public long getNuclear_phoshpo_pp70s6k_o1_density() {
		return _nuclear_phoshpo_pp70s6k_o1_density;
	}

	public void setNuclear_phoshpo_pp70s6k_o1_density(
		long nuclear_phoshpo_pp70s6k_o1_density) {
		_nuclear_phoshpo_pp70s6k_o1_density = nuclear_phoshpo_pp70s6k_o1_density;
	}

	public long getCytoplasmic_phoshpo_pp70s6k_o2_intensity() {
		return _cytoplasmic_phoshpo_pp70s6k_o2_intensity;
	}

	public void setCytoplasmic_phoshpo_pp70s6k_o2_intensity(
		long cytoplasmic_phoshpo_pp70s6k_o2_intensity) {
		_cytoplasmic_phoshpo_pp70s6k_o2_intensity = cytoplasmic_phoshpo_pp70s6k_o2_intensity;
	}

	public long getCytoplasmic_phoshpo_pp70s6k_o2_density() {
		return _cytoplasmic_phoshpo_pp70s6k_o2_density;
	}

	public void setCytoplasmic_phoshpo_pp70s6k_o2_density(
		long cytoplasmic_phoshpo_pp70s6k_o2_density) {
		_cytoplasmic_phoshpo_pp70s6k_o2_density = cytoplasmic_phoshpo_pp70s6k_o2_density;
	}

	public long getNuclear_phoshpo_pp70s6k_o2_intensity() {
		return _nuclear_phoshpo_pp70s6k_o2_intensity;
	}

	public void setNuclear_phoshpo_pp70s6k_o2_intensity(
		long nuclear_phoshpo_pp70s6k_o2_intensity) {
		_nuclear_phoshpo_pp70s6k_o2_intensity = nuclear_phoshpo_pp70s6k_o2_intensity;
	}

	public long getNuclear_phoshpo_pp70s6k_o2_density() {
		return _nuclear_phoshpo_pp70s6k_o2_density;
	}

	public void setNuclear_phoshpo_pp70s6k_o2_density(
		long nuclear_phoshpo_pp70s6k_o2_density) {
		_nuclear_phoshpo_pp70s6k_o2_density = nuclear_phoshpo_pp70s6k_o2_density;
	}

	public long getCytoplasmic_phoshpo_pp70s6k_o1_intensity() {
		return _cytoplasmic_phoshpo_pp70s6k_o1_intensity;
	}

	public void setCytoplasmic_phoshpo_pp70s6k_o1_intensity(
		long cytoplasmic_phoshpo_pp70s6k_o1_intensity) {
		_cytoplasmic_phoshpo_pp70s6k_o1_intensity = cytoplasmic_phoshpo_pp70s6k_o1_intensity;
	}

	public long getCytoplasmic_phoshpo_pten_o1_intensity() {
		return _cytoplasmic_phoshpo_pten_o1_intensity;
	}

	public void setCytoplasmic_phoshpo_pten_o1_intensity(
		long cytoplasmic_phoshpo_pten_o1_intensity) {
		_cytoplasmic_phoshpo_pten_o1_intensity = cytoplasmic_phoshpo_pten_o1_intensity;
	}

	public long getCytoplasmic_phoshpo_pten_o1_density() {
		return _cytoplasmic_phoshpo_pten_o1_density;
	}

	public void setCytoplasmic_phoshpo_pten_o1_density(
		long cytoplasmic_phoshpo_pten_o1_density) {
		_cytoplasmic_phoshpo_pten_o1_density = cytoplasmic_phoshpo_pten_o1_density;
	}

	public long getNuclear_phoshpo_pten_o1_intensity() {
		return _nuclear_phoshpo_pten_o1_intensity;
	}

	public void setNuclear_phoshpo_pten_o1_intensity(
		long nuclear_phoshpo_pten_o1_intensity) {
		_nuclear_phoshpo_pten_o1_intensity = nuclear_phoshpo_pten_o1_intensity;
	}

	public long getNuclear_phoshpo_pten_o1_density() {
		return _nuclear_phoshpo_pten_o1_density;
	}

	public void setNuclear_phoshpo_pten_o1_density(
		long nuclear_phoshpo_pten_o1_density) {
		_nuclear_phoshpo_pten_o1_density = nuclear_phoshpo_pten_o1_density;
	}

	public long getCytoplasmic_phoshpo_pten_o2_intensity() {
		return _cytoplasmic_phoshpo_pten_o2_intensity;
	}

	public void setCytoplasmic_phoshpo_pten_o2_intensity(
		long cytoplasmic_phoshpo_pten_o2_intensity) {
		_cytoplasmic_phoshpo_pten_o2_intensity = cytoplasmic_phoshpo_pten_o2_intensity;
	}

	public long getCytoplasmic_phoshpo_pten_o2_density() {
		return _cytoplasmic_phoshpo_pten_o2_density;
	}

	public void setCytoplasmic_phoshpo_pten_o2_density(
		long cytoplasmic_phoshpo_pten_o2_density) {
		_cytoplasmic_phoshpo_pten_o2_density = cytoplasmic_phoshpo_pten_o2_density;
	}

	public long getNuclear_phoshpo_pten_o2_intensity() {
		return _nuclear_phoshpo_pten_o2_intensity;
	}

	public void setNuclear_phoshpo_pten_o2_intensity(
		long nuclear_phoshpo_pten_o2_intensity) {
		_nuclear_phoshpo_pten_o2_intensity = nuclear_phoshpo_pten_o2_intensity;
	}

	public long getNuclear_phoshpo_pten_o2_density() {
		return _nuclear_phoshpo_pten_o2_density;
	}

	public void setNuclear_phoshpo_pten_o2_density(
		long nuclear_phoshpo_pten_o2_density) {
		_nuclear_phoshpo_pten_o2_density = nuclear_phoshpo_pten_o2_density;
	}

	private long _tma_Id;
	private long _sample_id;
	private String _tma_name;
	private String _tma_number;
	private String _tma_comment;
	private long _cytoplasmic_stat_5_intensity;
	private long _cytoplasmic_stat_5_density;
	private long _nuclear_stat_5_intensity;
	private long _nuclear_stat_5_density;
	private long _cytoplasmic_cjun_intensity;
	private long _cytoplasmic_cjun_density;
	private long _nuclear_cjun_intensity;
	private long _nuclear_cjun_density;
	private long _cytoplasmic_pstat_3_intensity;
	private long _cytoplasmic_pstat_3_density;
	private long _nuclear_pstat_3_intensity;
	private long _nuclear_pstat_3_density;
	private long _cytoplasmic_pstat_5_intensity;
	private long _cytoplasmic_pstat_5_density;
	private long _nuclear_pstat_5_intensity;
	private long _nuclear_pstat_5_density;
	private long _cytoplasmic_pstat_1_intensity;
	private long _cytoplasmic_pstat_1_density;
	private long _nuclear_pstat_1_intensity;
	private long _cytoplasmic_il6r_intensity;
	private long _cytoplasmic_il6r_density;
	private long _nuclear_il6r_intensity;
	private long _nuclear_il6r_density;
	private long _cytoplasmic_socs1_intensity;
	private long _cytoplasmic_socs1_density;
	private long _nuclear_socs1_intensity;
	private long _nuclear_socs1_density;
	private long _cytoplasmic_socs3_intensity;
	private long _cytoplasmic_socs3_density;
	private long _nuclear_socs3_intensity;
	private long _nuclear_socs3_density;
	private long _cytoplasmic_junb_intensity;
	private long _cytoplasmic_junb_density;
	private long _nuclear_junb_intensity;
	private long _nuclear_junb_density;
	private long _cytoplasmic_stat_3_intensity;
	private long _cytoplasmic_stat_3_density;
	private long _nuclear_stat_3_intensity;
	private long _nuclear_stat_3_density;
	private long _cytoplasmic_stat_5a_intensity;
	private long _cytoplasmic_stat_5a_density;
	private long _nuclear_stat_5a_intensity;
	private long _nuclear_stat_5a_density;
	private long _cytoplasmic_stat_5b_intensity;
	private long _cytoplasmic_stat_5b_density;
	private long _nuclear_stat_5b_intensity;
	private long _nuclear_stat_5b_density;
	private long _cytoplasmic_eif3a_intensity;
	private long _cytoplasmic_eif3a_density;
	private long _cytoplasmic_eif3a_peter_intensity;
	private long _cytoplasmic_eif3a_peter_density;
	private long _cytoplasmic_itih_5_o1_intensity;
	private long _cytoplasmic_itih_5_o1_density;
	private long _nuclear_itih_5_o1_intensity;
	private long _nuclear_itih_5_o1_density;
	private long _cytoplasmic_itih_5_o2_intensity;
	private long _cytoplasmic_itih_5_o2_density;
	private long _nuclear_itih_5_o2_intensity;
	private long _nuclear_itih_5_o2_density;
	private long _cytoplasmic_imp2_2_intensity;
	private long _cytoplasmic_imp2_2_density;
	private long _cytoplasmic_stat_1_intensity;
	private long _cytoplasmic_stat_1_density;
	private long _nuclear_stat_1_intensity;
	private long _nuclear_stat_1_density;
	private long _cytoplasmic_nfkb1_intensity;
	private long _cytoplasmic_nfkb1_density;
	private long _nuclear_nfkb1_intensity;
	private long _nuclear_nfkb1_density;
	private long _cytoplasmic_nfkb2_intensity;
	private long _cytoplasmic_nfkb2_density;
	private long _nuclear_nfkb2_intensity;
	private long _nuclear_nfkb2_density;
	private long _cytoplasmic_pikb_intensity;
	private long _cytoplasmic_pikb_density;
	private long _cytoplasmic_phoshpo_pakt_o1_intensity;
	private long _cytoplasmic_phoshpo_pakt_o1_density;
	private long _nuclear_phoshpo_pakt_o1_intensity;
	private long _nuclear_phoshpo_pakt_o1_density;
	private long _cytoplasmic_phoshpo_pakt_o2_intensity;
	private long _cytoplasmic_phoshpo_pakt_o2_density;
	private long _nuclear_phoshpo_pakt_o2_intensity;
	private long _nuclear_phoshpo_pakt_o2_density;
	private long _cytoplasmic_phoshpo_pmtor_o1_intensity;
	private long _cytoplasmic_phoshpo_pmtor_o1_density;
	private long _nuclear_phoshpo_pmtor_o1_intensity;
	private long _nuclear_phoshpo_pmtor_o1_density;
	private long _cytoplasmic_phoshpo_pmtor_o2_intensity;
	private long _cytoplasmic_phoshpo_pmtor_o2_density;
	private long _nuclear_phoshpo_pmtor_o2_intensity;
	private long _nuclear_phoshpo_pmtor_o2_density;
	private long _cytoplasmic_phoshpo_pp70s6k_o1_density;
	private long _nuclear_phoshpo_pp70s6k_o1_intensity;
	private long _nuclear_phoshpo_pp70s6k_o1_density;
	private long _cytoplasmic_phoshpo_pp70s6k_o2_intensity;
	private long _cytoplasmic_phoshpo_pp70s6k_o2_density;
	private long _nuclear_phoshpo_pp70s6k_o2_intensity;
	private long _nuclear_phoshpo_pp70s6k_o2_density;
	private long _cytoplasmic_phoshpo_pp70s6k_o1_intensity;
	private long _cytoplasmic_phoshpo_pten_o1_intensity;
	private long _cytoplasmic_phoshpo_pten_o1_density;
	private long _nuclear_phoshpo_pten_o1_intensity;
	private long _nuclear_phoshpo_pten_o1_density;
	private long _cytoplasmic_phoshpo_pten_o2_intensity;
	private long _cytoplasmic_phoshpo_pten_o2_density;
	private long _nuclear_phoshpo_pten_o2_intensity;
	private long _nuclear_phoshpo_pten_o2_density;
}