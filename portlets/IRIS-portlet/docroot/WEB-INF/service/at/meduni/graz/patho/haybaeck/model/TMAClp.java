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

import at.meduni.graz.patho.haybaeck.service.ClpSerializer;
import at.meduni.graz.patho.haybaeck.service.TMALocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class TMAClp extends BaseModelImpl<TMA> implements TMA {
	public TMAClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TMA.class;
	}

	@Override
	public String getModelClassName() {
		return TMA.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tma_Id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTma_Id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tma_Id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tma_Id", getTma_Id());
		attributes.put("sample_id", getSample_id());
		attributes.put("tma_name", getTma_name());
		attributes.put("tma_number", getTma_number());
		attributes.put("tma_comment", getTma_comment());
		attributes.put("cytoplasmic_stat_5_intensity",
			getCytoplasmic_stat_5_intensity());
		attributes.put("cytoplasmic_stat_5_density",
			getCytoplasmic_stat_5_density());
		attributes.put("nuclear_stat_5_intensity", getNuclear_stat_5_intensity());
		attributes.put("nuclear_stat_5_density", getNuclear_stat_5_density());
		attributes.put("cytoplasmic_cjun_intensity",
			getCytoplasmic_cjun_intensity());
		attributes.put("cytoplasmic_cjun_density", getCytoplasmic_cjun_density());
		attributes.put("nuclear_cjun_intensity", getNuclear_cjun_intensity());
		attributes.put("nuclear_cjun_density", getNuclear_cjun_density());
		attributes.put("cytoplasmic_pstat_3_intensity",
			getCytoplasmic_pstat_3_intensity());
		attributes.put("cytoplasmic_pstat_3_density",
			getCytoplasmic_pstat_3_density());
		attributes.put("nuclear_pstat_3_intensity",
			getNuclear_pstat_3_intensity());
		attributes.put("nuclear_pstat_3_density", getNuclear_pstat_3_density());
		attributes.put("cytoplasmic_pstat_5_intensity",
			getCytoplasmic_pstat_5_intensity());
		attributes.put("cytoplasmic_pstat_5_density",
			getCytoplasmic_pstat_5_density());
		attributes.put("nuclear_pstat_5_intensity",
			getNuclear_pstat_5_intensity());
		attributes.put("nuclear_pstat_5_density", getNuclear_pstat_5_density());
		attributes.put("cytoplasmic_pstat_1_intensity",
			getCytoplasmic_pstat_1_intensity());
		attributes.put("cytoplasmic_pstat_1_density",
			getCytoplasmic_pstat_1_density());
		attributes.put("nuclear_pstat_1_intensity",
			getNuclear_pstat_1_intensity());
		attributes.put("cytoplasmic_il6r_intensity",
			getCytoplasmic_il6r_intensity());
		attributes.put("cytoplasmic_il6r_density", getCytoplasmic_il6r_density());
		attributes.put("nuclear_il6r_intensity", getNuclear_il6r_intensity());
		attributes.put("nuclear_il6r_density", getNuclear_il6r_density());
		attributes.put("cytoplasmic_socs1_intensity",
			getCytoplasmic_socs1_intensity());
		attributes.put("cytoplasmic_socs1_density",
			getCytoplasmic_socs1_density());
		attributes.put("nuclear_socs1_intensity", getNuclear_socs1_intensity());
		attributes.put("nuclear_socs1_density", getNuclear_socs1_density());
		attributes.put("cytoplasmic_socs3_intensity",
			getCytoplasmic_socs3_intensity());
		attributes.put("cytoplasmic_socs3_density",
			getCytoplasmic_socs3_density());
		attributes.put("nuclear_socs3_intensity", getNuclear_socs3_intensity());
		attributes.put("nuclear_socs3_density", getNuclear_socs3_density());
		attributes.put("cytoplasmic_junb_intensity",
			getCytoplasmic_junb_intensity());
		attributes.put("cytoplasmic_junb_density", getCytoplasmic_junb_density());
		attributes.put("nuclear_junb_intensity", getNuclear_junb_intensity());
		attributes.put("nuclear_junb_density", getNuclear_junb_density());
		attributes.put("cytoplasmic_stat_3_intensity",
			getCytoplasmic_stat_3_intensity());
		attributes.put("cytoplasmic_stat_3_density",
			getCytoplasmic_stat_3_density());
		attributes.put("nuclear_stat_3_intensity", getNuclear_stat_3_intensity());
		attributes.put("nuclear_stat_3_density", getNuclear_stat_3_density());
		attributes.put("cytoplasmic_stat_5a_intensity",
			getCytoplasmic_stat_5a_intensity());
		attributes.put("cytoplasmic_stat_5a_density",
			getCytoplasmic_stat_5a_density());
		attributes.put("nuclear_stat_5a_intensity",
			getNuclear_stat_5a_intensity());
		attributes.put("nuclear_stat_5a_density", getNuclear_stat_5a_density());
		attributes.put("cytoplasmic_stat_5b_intensity",
			getCytoplasmic_stat_5b_intensity());
		attributes.put("cytoplasmic_stat_5b_density",
			getCytoplasmic_stat_5b_density());
		attributes.put("nuclear_stat_5b_intensity",
			getNuclear_stat_5b_intensity());
		attributes.put("nuclear_stat_5b_density", getNuclear_stat_5b_density());
		attributes.put("cytoplasmic_eif3a_intensity",
			getCytoplasmic_eif3a_intensity());
		attributes.put("cytoplasmic_eif3a_density",
			getCytoplasmic_eif3a_density());
		attributes.put("cytoplasmic_eif3a_peter_intensity",
			getCytoplasmic_eif3a_peter_intensity());
		attributes.put("cytoplasmic_eif3a_peter_density",
			getCytoplasmic_eif3a_peter_density());
		attributes.put("cytoplasmic_itih_5_o1_intensity",
			getCytoplasmic_itih_5_o1_intensity());
		attributes.put("cytoplasmic_itih_5_o1_density",
			getCytoplasmic_itih_5_o1_density());
		attributes.put("nuclear_itih_5_o1_intensity",
			getNuclear_itih_5_o1_intensity());
		attributes.put("nuclear_itih_5_o1_density",
			getNuclear_itih_5_o1_density());
		attributes.put("cytoplasmic_itih_5_o2_intensity",
			getCytoplasmic_itih_5_o2_intensity());
		attributes.put("cytoplasmic_itih_5_o2_density",
			getCytoplasmic_itih_5_o2_density());
		attributes.put("nuclear_itih_5_o2_intensity",
			getNuclear_itih_5_o2_intensity());
		attributes.put("nuclear_itih_5_o2_density",
			getNuclear_itih_5_o2_density());
		attributes.put("cytoplasmic_imp2_2_intensity",
			getCytoplasmic_imp2_2_intensity());
		attributes.put("cytoplasmic_imp2_2_density",
			getCytoplasmic_imp2_2_density());
		attributes.put("cytoplasmic_stat_1_intensity",
			getCytoplasmic_stat_1_intensity());
		attributes.put("cytoplasmic_stat_1_density",
			getCytoplasmic_stat_1_density());
		attributes.put("nuclear_stat_1_intensity", getNuclear_stat_1_intensity());
		attributes.put("nuclear_stat_1_density", getNuclear_stat_1_density());
		attributes.put("cytoplasmic_nfkb1_intensity",
			getCytoplasmic_nfkb1_intensity());
		attributes.put("cytoplasmic_nfkb1_density",
			getCytoplasmic_nfkb1_density());
		attributes.put("nuclear_nfkb1_intensity", getNuclear_nfkb1_intensity());
		attributes.put("nuclear_nfkb1_density", getNuclear_nfkb1_density());
		attributes.put("cytoplasmic_nfkb2_intensity",
			getCytoplasmic_nfkb2_intensity());
		attributes.put("cytoplasmic_nfkb2_density",
			getCytoplasmic_nfkb2_density());
		attributes.put("nuclear_nfkb2_intensity", getNuclear_nfkb2_intensity());
		attributes.put("nuclear_nfkb2_density", getNuclear_nfkb2_density());
		attributes.put("cytoplasmic_pikb_intensity",
			getCytoplasmic_pikb_intensity());
		attributes.put("cytoplasmic_pikb_density", getCytoplasmic_pikb_density());
		attributes.put("cytoplasmic_phoshpo_pakt_o1_intensity",
			getCytoplasmic_phoshpo_pakt_o1_intensity());
		attributes.put("cytoplasmic_phoshpo_pakt_o1_density",
			getCytoplasmic_phoshpo_pakt_o1_density());
		attributes.put("nuclear_phoshpo_pakt_o1_intensity",
			getNuclear_phoshpo_pakt_o1_intensity());
		attributes.put("nuclear_phoshpo_pakt_o1_density",
			getNuclear_phoshpo_pakt_o1_density());
		attributes.put("cytoplasmic_phoshpo_pakt_o2_intensity",
			getCytoplasmic_phoshpo_pakt_o2_intensity());
		attributes.put("cytoplasmic_phoshpo_pakt_o2_density",
			getCytoplasmic_phoshpo_pakt_o2_density());
		attributes.put("nuclear_phoshpo_pakt_o2_intensity",
			getNuclear_phoshpo_pakt_o2_intensity());
		attributes.put("nuclear_phoshpo_pakt_o2_density",
			getNuclear_phoshpo_pakt_o2_density());
		attributes.put("cytoplasmic_phoshpo_pmtor_o1_intensity",
			getCytoplasmic_phoshpo_pmtor_o1_intensity());
		attributes.put("cytoplasmic_phoshpo_pmtor_o1_density",
			getCytoplasmic_phoshpo_pmtor_o1_density());
		attributes.put("nuclear_phoshpo_pmtor_o1_intensity",
			getNuclear_phoshpo_pmtor_o1_intensity());
		attributes.put("nuclear_phoshpo_pmtor_o1_density",
			getNuclear_phoshpo_pmtor_o1_density());
		attributes.put("cytoplasmic_phoshpo_pmtor_o2_intensity",
			getCytoplasmic_phoshpo_pmtor_o2_intensity());
		attributes.put("cytoplasmic_phoshpo_pmtor_o2_density",
			getCytoplasmic_phoshpo_pmtor_o2_density());
		attributes.put("nuclear_phoshpo_pmtor_o2_intensity",
			getNuclear_phoshpo_pmtor_o2_intensity());
		attributes.put("nuclear_phoshpo_pmtor_o2_density",
			getNuclear_phoshpo_pmtor_o2_density());
		attributes.put("cytoplasmic_phoshpo_pp70s6k_o1_density",
			getCytoplasmic_phoshpo_pp70s6k_o1_density());
		attributes.put("nuclear_phoshpo_pp70s6k_o1_intensity",
			getNuclear_phoshpo_pp70s6k_o1_intensity());
		attributes.put("nuclear_phoshpo_pp70s6k_o1_density",
			getNuclear_phoshpo_pp70s6k_o1_density());
		attributes.put("cytoplasmic_phoshpo_pp70s6k_o2_intensity",
			getCytoplasmic_phoshpo_pp70s6k_o2_intensity());
		attributes.put("cytoplasmic_phoshpo_pp70s6k_o2_density",
			getCytoplasmic_phoshpo_pp70s6k_o2_density());
		attributes.put("nuclear_phoshpo_pp70s6k_o2_intensity",
			getNuclear_phoshpo_pp70s6k_o2_intensity());
		attributes.put("nuclear_phoshpo_pp70s6k_o2_density",
			getNuclear_phoshpo_pp70s6k_o2_density());
		attributes.put("cytoplasmic_phoshpo_pp70s6k_o1_intensity",
			getCytoplasmic_phoshpo_pp70s6k_o1_intensity());
		attributes.put("cytoplasmic_phoshpo_pten_o1_intensity",
			getCytoplasmic_phoshpo_pten_o1_intensity());
		attributes.put("cytoplasmic_phoshpo_pten_o1_density",
			getCytoplasmic_phoshpo_pten_o1_density());
		attributes.put("nuclear_phoshpo_pten_o1_intensity",
			getNuclear_phoshpo_pten_o1_intensity());
		attributes.put("nuclear_phoshpo_pten_o1_density",
			getNuclear_phoshpo_pten_o1_density());
		attributes.put("cytoplasmic_phoshpo_pten_o2_intensity",
			getCytoplasmic_phoshpo_pten_o2_intensity());
		attributes.put("cytoplasmic_phoshpo_pten_o2_density",
			getCytoplasmic_phoshpo_pten_o2_density());
		attributes.put("nuclear_phoshpo_pten_o2_intensity",
			getNuclear_phoshpo_pten_o2_intensity());
		attributes.put("nuclear_phoshpo_pten_o2_density",
			getNuclear_phoshpo_pten_o2_density());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tma_Id = (Long)attributes.get("tma_Id");

		if (tma_Id != null) {
			setTma_Id(tma_Id);
		}

		Long sample_id = (Long)attributes.get("sample_id");

		if (sample_id != null) {
			setSample_id(sample_id);
		}

		String tma_name = (String)attributes.get("tma_name");

		if (tma_name != null) {
			setTma_name(tma_name);
		}

		String tma_number = (String)attributes.get("tma_number");

		if (tma_number != null) {
			setTma_number(tma_number);
		}

		String tma_comment = (String)attributes.get("tma_comment");

		if (tma_comment != null) {
			setTma_comment(tma_comment);
		}

		Long cytoplasmic_stat_5_intensity = (Long)attributes.get(
				"cytoplasmic_stat_5_intensity");

		if (cytoplasmic_stat_5_intensity != null) {
			setCytoplasmic_stat_5_intensity(cytoplasmic_stat_5_intensity);
		}

		Long cytoplasmic_stat_5_density = (Long)attributes.get(
				"cytoplasmic_stat_5_density");

		if (cytoplasmic_stat_5_density != null) {
			setCytoplasmic_stat_5_density(cytoplasmic_stat_5_density);
		}

		Long nuclear_stat_5_intensity = (Long)attributes.get(
				"nuclear_stat_5_intensity");

		if (nuclear_stat_5_intensity != null) {
			setNuclear_stat_5_intensity(nuclear_stat_5_intensity);
		}

		Long nuclear_stat_5_density = (Long)attributes.get(
				"nuclear_stat_5_density");

		if (nuclear_stat_5_density != null) {
			setNuclear_stat_5_density(nuclear_stat_5_density);
		}

		Long cytoplasmic_cjun_intensity = (Long)attributes.get(
				"cytoplasmic_cjun_intensity");

		if (cytoplasmic_cjun_intensity != null) {
			setCytoplasmic_cjun_intensity(cytoplasmic_cjun_intensity);
		}

		Long cytoplasmic_cjun_density = (Long)attributes.get(
				"cytoplasmic_cjun_density");

		if (cytoplasmic_cjun_density != null) {
			setCytoplasmic_cjun_density(cytoplasmic_cjun_density);
		}

		Long nuclear_cjun_intensity = (Long)attributes.get(
				"nuclear_cjun_intensity");

		if (nuclear_cjun_intensity != null) {
			setNuclear_cjun_intensity(nuclear_cjun_intensity);
		}

		Long nuclear_cjun_density = (Long)attributes.get("nuclear_cjun_density");

		if (nuclear_cjun_density != null) {
			setNuclear_cjun_density(nuclear_cjun_density);
		}

		Long cytoplasmic_pstat_3_intensity = (Long)attributes.get(
				"cytoplasmic_pstat_3_intensity");

		if (cytoplasmic_pstat_3_intensity != null) {
			setCytoplasmic_pstat_3_intensity(cytoplasmic_pstat_3_intensity);
		}

		Long cytoplasmic_pstat_3_density = (Long)attributes.get(
				"cytoplasmic_pstat_3_density");

		if (cytoplasmic_pstat_3_density != null) {
			setCytoplasmic_pstat_3_density(cytoplasmic_pstat_3_density);
		}

		Long nuclear_pstat_3_intensity = (Long)attributes.get(
				"nuclear_pstat_3_intensity");

		if (nuclear_pstat_3_intensity != null) {
			setNuclear_pstat_3_intensity(nuclear_pstat_3_intensity);
		}

		Long nuclear_pstat_3_density = (Long)attributes.get(
				"nuclear_pstat_3_density");

		if (nuclear_pstat_3_density != null) {
			setNuclear_pstat_3_density(nuclear_pstat_3_density);
		}

		Long cytoplasmic_pstat_5_intensity = (Long)attributes.get(
				"cytoplasmic_pstat_5_intensity");

		if (cytoplasmic_pstat_5_intensity != null) {
			setCytoplasmic_pstat_5_intensity(cytoplasmic_pstat_5_intensity);
		}

		Long cytoplasmic_pstat_5_density = (Long)attributes.get(
				"cytoplasmic_pstat_5_density");

		if (cytoplasmic_pstat_5_density != null) {
			setCytoplasmic_pstat_5_density(cytoplasmic_pstat_5_density);
		}

		Long nuclear_pstat_5_intensity = (Long)attributes.get(
				"nuclear_pstat_5_intensity");

		if (nuclear_pstat_5_intensity != null) {
			setNuclear_pstat_5_intensity(nuclear_pstat_5_intensity);
		}

		Long nuclear_pstat_5_density = (Long)attributes.get(
				"nuclear_pstat_5_density");

		if (nuclear_pstat_5_density != null) {
			setNuclear_pstat_5_density(nuclear_pstat_5_density);
		}

		Long cytoplasmic_pstat_1_intensity = (Long)attributes.get(
				"cytoplasmic_pstat_1_intensity");

		if (cytoplasmic_pstat_1_intensity != null) {
			setCytoplasmic_pstat_1_intensity(cytoplasmic_pstat_1_intensity);
		}

		Long cytoplasmic_pstat_1_density = (Long)attributes.get(
				"cytoplasmic_pstat_1_density");

		if (cytoplasmic_pstat_1_density != null) {
			setCytoplasmic_pstat_1_density(cytoplasmic_pstat_1_density);
		}

		Long nuclear_pstat_1_intensity = (Long)attributes.get(
				"nuclear_pstat_1_intensity");

		if (nuclear_pstat_1_intensity != null) {
			setNuclear_pstat_1_intensity(nuclear_pstat_1_intensity);
		}

		Long cytoplasmic_il6r_intensity = (Long)attributes.get(
				"cytoplasmic_il6r_intensity");

		if (cytoplasmic_il6r_intensity != null) {
			setCytoplasmic_il6r_intensity(cytoplasmic_il6r_intensity);
		}

		Long cytoplasmic_il6r_density = (Long)attributes.get(
				"cytoplasmic_il6r_density");

		if (cytoplasmic_il6r_density != null) {
			setCytoplasmic_il6r_density(cytoplasmic_il6r_density);
		}

		Long nuclear_il6r_intensity = (Long)attributes.get(
				"nuclear_il6r_intensity");

		if (nuclear_il6r_intensity != null) {
			setNuclear_il6r_intensity(nuclear_il6r_intensity);
		}

		Long nuclear_il6r_density = (Long)attributes.get("nuclear_il6r_density");

		if (nuclear_il6r_density != null) {
			setNuclear_il6r_density(nuclear_il6r_density);
		}

		Long cytoplasmic_socs1_intensity = (Long)attributes.get(
				"cytoplasmic_socs1_intensity");

		if (cytoplasmic_socs1_intensity != null) {
			setCytoplasmic_socs1_intensity(cytoplasmic_socs1_intensity);
		}

		Long cytoplasmic_socs1_density = (Long)attributes.get(
				"cytoplasmic_socs1_density");

		if (cytoplasmic_socs1_density != null) {
			setCytoplasmic_socs1_density(cytoplasmic_socs1_density);
		}

		Long nuclear_socs1_intensity = (Long)attributes.get(
				"nuclear_socs1_intensity");

		if (nuclear_socs1_intensity != null) {
			setNuclear_socs1_intensity(nuclear_socs1_intensity);
		}

		Long nuclear_socs1_density = (Long)attributes.get(
				"nuclear_socs1_density");

		if (nuclear_socs1_density != null) {
			setNuclear_socs1_density(nuclear_socs1_density);
		}

		Long cytoplasmic_socs3_intensity = (Long)attributes.get(
				"cytoplasmic_socs3_intensity");

		if (cytoplasmic_socs3_intensity != null) {
			setCytoplasmic_socs3_intensity(cytoplasmic_socs3_intensity);
		}

		Long cytoplasmic_socs3_density = (Long)attributes.get(
				"cytoplasmic_socs3_density");

		if (cytoplasmic_socs3_density != null) {
			setCytoplasmic_socs3_density(cytoplasmic_socs3_density);
		}

		Long nuclear_socs3_intensity = (Long)attributes.get(
				"nuclear_socs3_intensity");

		if (nuclear_socs3_intensity != null) {
			setNuclear_socs3_intensity(nuclear_socs3_intensity);
		}

		Long nuclear_socs3_density = (Long)attributes.get(
				"nuclear_socs3_density");

		if (nuclear_socs3_density != null) {
			setNuclear_socs3_density(nuclear_socs3_density);
		}

		Long cytoplasmic_junb_intensity = (Long)attributes.get(
				"cytoplasmic_junb_intensity");

		if (cytoplasmic_junb_intensity != null) {
			setCytoplasmic_junb_intensity(cytoplasmic_junb_intensity);
		}

		Long cytoplasmic_junb_density = (Long)attributes.get(
				"cytoplasmic_junb_density");

		if (cytoplasmic_junb_density != null) {
			setCytoplasmic_junb_density(cytoplasmic_junb_density);
		}

		Long nuclear_junb_intensity = (Long)attributes.get(
				"nuclear_junb_intensity");

		if (nuclear_junb_intensity != null) {
			setNuclear_junb_intensity(nuclear_junb_intensity);
		}

		Long nuclear_junb_density = (Long)attributes.get("nuclear_junb_density");

		if (nuclear_junb_density != null) {
			setNuclear_junb_density(nuclear_junb_density);
		}

		Long cytoplasmic_stat_3_intensity = (Long)attributes.get(
				"cytoplasmic_stat_3_intensity");

		if (cytoplasmic_stat_3_intensity != null) {
			setCytoplasmic_stat_3_intensity(cytoplasmic_stat_3_intensity);
		}

		Long cytoplasmic_stat_3_density = (Long)attributes.get(
				"cytoplasmic_stat_3_density");

		if (cytoplasmic_stat_3_density != null) {
			setCytoplasmic_stat_3_density(cytoplasmic_stat_3_density);
		}

		Long nuclear_stat_3_intensity = (Long)attributes.get(
				"nuclear_stat_3_intensity");

		if (nuclear_stat_3_intensity != null) {
			setNuclear_stat_3_intensity(nuclear_stat_3_intensity);
		}

		Long nuclear_stat_3_density = (Long)attributes.get(
				"nuclear_stat_3_density");

		if (nuclear_stat_3_density != null) {
			setNuclear_stat_3_density(nuclear_stat_3_density);
		}

		Long cytoplasmic_stat_5a_intensity = (Long)attributes.get(
				"cytoplasmic_stat_5a_intensity");

		if (cytoplasmic_stat_5a_intensity != null) {
			setCytoplasmic_stat_5a_intensity(cytoplasmic_stat_5a_intensity);
		}

		Long cytoplasmic_stat_5a_density = (Long)attributes.get(
				"cytoplasmic_stat_5a_density");

		if (cytoplasmic_stat_5a_density != null) {
			setCytoplasmic_stat_5a_density(cytoplasmic_stat_5a_density);
		}

		Long nuclear_stat_5a_intensity = (Long)attributes.get(
				"nuclear_stat_5a_intensity");

		if (nuclear_stat_5a_intensity != null) {
			setNuclear_stat_5a_intensity(nuclear_stat_5a_intensity);
		}

		Long nuclear_stat_5a_density = (Long)attributes.get(
				"nuclear_stat_5a_density");

		if (nuclear_stat_5a_density != null) {
			setNuclear_stat_5a_density(nuclear_stat_5a_density);
		}

		Long cytoplasmic_stat_5b_intensity = (Long)attributes.get(
				"cytoplasmic_stat_5b_intensity");

		if (cytoplasmic_stat_5b_intensity != null) {
			setCytoplasmic_stat_5b_intensity(cytoplasmic_stat_5b_intensity);
		}

		Long cytoplasmic_stat_5b_density = (Long)attributes.get(
				"cytoplasmic_stat_5b_density");

		if (cytoplasmic_stat_5b_density != null) {
			setCytoplasmic_stat_5b_density(cytoplasmic_stat_5b_density);
		}

		Long nuclear_stat_5b_intensity = (Long)attributes.get(
				"nuclear_stat_5b_intensity");

		if (nuclear_stat_5b_intensity != null) {
			setNuclear_stat_5b_intensity(nuclear_stat_5b_intensity);
		}

		Long nuclear_stat_5b_density = (Long)attributes.get(
				"nuclear_stat_5b_density");

		if (nuclear_stat_5b_density != null) {
			setNuclear_stat_5b_density(nuclear_stat_5b_density);
		}

		Long cytoplasmic_eif3a_intensity = (Long)attributes.get(
				"cytoplasmic_eif3a_intensity");

		if (cytoplasmic_eif3a_intensity != null) {
			setCytoplasmic_eif3a_intensity(cytoplasmic_eif3a_intensity);
		}

		Long cytoplasmic_eif3a_density = (Long)attributes.get(
				"cytoplasmic_eif3a_density");

		if (cytoplasmic_eif3a_density != null) {
			setCytoplasmic_eif3a_density(cytoplasmic_eif3a_density);
		}

		Long cytoplasmic_eif3a_peter_intensity = (Long)attributes.get(
				"cytoplasmic_eif3a_peter_intensity");

		if (cytoplasmic_eif3a_peter_intensity != null) {
			setCytoplasmic_eif3a_peter_intensity(cytoplasmic_eif3a_peter_intensity);
		}

		Long cytoplasmic_eif3a_peter_density = (Long)attributes.get(
				"cytoplasmic_eif3a_peter_density");

		if (cytoplasmic_eif3a_peter_density != null) {
			setCytoplasmic_eif3a_peter_density(cytoplasmic_eif3a_peter_density);
		}

		Long cytoplasmic_itih_5_o1_intensity = (Long)attributes.get(
				"cytoplasmic_itih_5_o1_intensity");

		if (cytoplasmic_itih_5_o1_intensity != null) {
			setCytoplasmic_itih_5_o1_intensity(cytoplasmic_itih_5_o1_intensity);
		}

		Long cytoplasmic_itih_5_o1_density = (Long)attributes.get(
				"cytoplasmic_itih_5_o1_density");

		if (cytoplasmic_itih_5_o1_density != null) {
			setCytoplasmic_itih_5_o1_density(cytoplasmic_itih_5_o1_density);
		}

		Long nuclear_itih_5_o1_intensity = (Long)attributes.get(
				"nuclear_itih_5_o1_intensity");

		if (nuclear_itih_5_o1_intensity != null) {
			setNuclear_itih_5_o1_intensity(nuclear_itih_5_o1_intensity);
		}

		Long nuclear_itih_5_o1_density = (Long)attributes.get(
				"nuclear_itih_5_o1_density");

		if (nuclear_itih_5_o1_density != null) {
			setNuclear_itih_5_o1_density(nuclear_itih_5_o1_density);
		}

		Long cytoplasmic_itih_5_o2_intensity = (Long)attributes.get(
				"cytoplasmic_itih_5_o2_intensity");

		if (cytoplasmic_itih_5_o2_intensity != null) {
			setCytoplasmic_itih_5_o2_intensity(cytoplasmic_itih_5_o2_intensity);
		}

		Long cytoplasmic_itih_5_o2_density = (Long)attributes.get(
				"cytoplasmic_itih_5_o2_density");

		if (cytoplasmic_itih_5_o2_density != null) {
			setCytoplasmic_itih_5_o2_density(cytoplasmic_itih_5_o2_density);
		}

		Long nuclear_itih_5_o2_intensity = (Long)attributes.get(
				"nuclear_itih_5_o2_intensity");

		if (nuclear_itih_5_o2_intensity != null) {
			setNuclear_itih_5_o2_intensity(nuclear_itih_5_o2_intensity);
		}

		Long nuclear_itih_5_o2_density = (Long)attributes.get(
				"nuclear_itih_5_o2_density");

		if (nuclear_itih_5_o2_density != null) {
			setNuclear_itih_5_o2_density(nuclear_itih_5_o2_density);
		}

		Long cytoplasmic_imp2_2_intensity = (Long)attributes.get(
				"cytoplasmic_imp2_2_intensity");

		if (cytoplasmic_imp2_2_intensity != null) {
			setCytoplasmic_imp2_2_intensity(cytoplasmic_imp2_2_intensity);
		}

		Long cytoplasmic_imp2_2_density = (Long)attributes.get(
				"cytoplasmic_imp2_2_density");

		if (cytoplasmic_imp2_2_density != null) {
			setCytoplasmic_imp2_2_density(cytoplasmic_imp2_2_density);
		}

		Long cytoplasmic_stat_1_intensity = (Long)attributes.get(
				"cytoplasmic_stat_1_intensity");

		if (cytoplasmic_stat_1_intensity != null) {
			setCytoplasmic_stat_1_intensity(cytoplasmic_stat_1_intensity);
		}

		Long cytoplasmic_stat_1_density = (Long)attributes.get(
				"cytoplasmic_stat_1_density");

		if (cytoplasmic_stat_1_density != null) {
			setCytoplasmic_stat_1_density(cytoplasmic_stat_1_density);
		}

		Long nuclear_stat_1_intensity = (Long)attributes.get(
				"nuclear_stat_1_intensity");

		if (nuclear_stat_1_intensity != null) {
			setNuclear_stat_1_intensity(nuclear_stat_1_intensity);
		}

		Long nuclear_stat_1_density = (Long)attributes.get(
				"nuclear_stat_1_density");

		if (nuclear_stat_1_density != null) {
			setNuclear_stat_1_density(nuclear_stat_1_density);
		}

		Long cytoplasmic_nfkb1_intensity = (Long)attributes.get(
				"cytoplasmic_nfkb1_intensity");

		if (cytoplasmic_nfkb1_intensity != null) {
			setCytoplasmic_nfkb1_intensity(cytoplasmic_nfkb1_intensity);
		}

		Long cytoplasmic_nfkb1_density = (Long)attributes.get(
				"cytoplasmic_nfkb1_density");

		if (cytoplasmic_nfkb1_density != null) {
			setCytoplasmic_nfkb1_density(cytoplasmic_nfkb1_density);
		}

		Long nuclear_nfkb1_intensity = (Long)attributes.get(
				"nuclear_nfkb1_intensity");

		if (nuclear_nfkb1_intensity != null) {
			setNuclear_nfkb1_intensity(nuclear_nfkb1_intensity);
		}

		Long nuclear_nfkb1_density = (Long)attributes.get(
				"nuclear_nfkb1_density");

		if (nuclear_nfkb1_density != null) {
			setNuclear_nfkb1_density(nuclear_nfkb1_density);
		}

		Long cytoplasmic_nfkb2_intensity = (Long)attributes.get(
				"cytoplasmic_nfkb2_intensity");

		if (cytoplasmic_nfkb2_intensity != null) {
			setCytoplasmic_nfkb2_intensity(cytoplasmic_nfkb2_intensity);
		}

		Long cytoplasmic_nfkb2_density = (Long)attributes.get(
				"cytoplasmic_nfkb2_density");

		if (cytoplasmic_nfkb2_density != null) {
			setCytoplasmic_nfkb2_density(cytoplasmic_nfkb2_density);
		}

		Long nuclear_nfkb2_intensity = (Long)attributes.get(
				"nuclear_nfkb2_intensity");

		if (nuclear_nfkb2_intensity != null) {
			setNuclear_nfkb2_intensity(nuclear_nfkb2_intensity);
		}

		Long nuclear_nfkb2_density = (Long)attributes.get(
				"nuclear_nfkb2_density");

		if (nuclear_nfkb2_density != null) {
			setNuclear_nfkb2_density(nuclear_nfkb2_density);
		}

		Long cytoplasmic_pikb_intensity = (Long)attributes.get(
				"cytoplasmic_pikb_intensity");

		if (cytoplasmic_pikb_intensity != null) {
			setCytoplasmic_pikb_intensity(cytoplasmic_pikb_intensity);
		}

		Long cytoplasmic_pikb_density = (Long)attributes.get(
				"cytoplasmic_pikb_density");

		if (cytoplasmic_pikb_density != null) {
			setCytoplasmic_pikb_density(cytoplasmic_pikb_density);
		}

		Long cytoplasmic_phoshpo_pakt_o1_intensity = (Long)attributes.get(
				"cytoplasmic_phoshpo_pakt_o1_intensity");

		if (cytoplasmic_phoshpo_pakt_o1_intensity != null) {
			setCytoplasmic_phoshpo_pakt_o1_intensity(cytoplasmic_phoshpo_pakt_o1_intensity);
		}

		Long cytoplasmic_phoshpo_pakt_o1_density = (Long)attributes.get(
				"cytoplasmic_phoshpo_pakt_o1_density");

		if (cytoplasmic_phoshpo_pakt_o1_density != null) {
			setCytoplasmic_phoshpo_pakt_o1_density(cytoplasmic_phoshpo_pakt_o1_density);
		}

		Long nuclear_phoshpo_pakt_o1_intensity = (Long)attributes.get(
				"nuclear_phoshpo_pakt_o1_intensity");

		if (nuclear_phoshpo_pakt_o1_intensity != null) {
			setNuclear_phoshpo_pakt_o1_intensity(nuclear_phoshpo_pakt_o1_intensity);
		}

		Long nuclear_phoshpo_pakt_o1_density = (Long)attributes.get(
				"nuclear_phoshpo_pakt_o1_density");

		if (nuclear_phoshpo_pakt_o1_density != null) {
			setNuclear_phoshpo_pakt_o1_density(nuclear_phoshpo_pakt_o1_density);
		}

		Long cytoplasmic_phoshpo_pakt_o2_intensity = (Long)attributes.get(
				"cytoplasmic_phoshpo_pakt_o2_intensity");

		if (cytoplasmic_phoshpo_pakt_o2_intensity != null) {
			setCytoplasmic_phoshpo_pakt_o2_intensity(cytoplasmic_phoshpo_pakt_o2_intensity);
		}

		Long cytoplasmic_phoshpo_pakt_o2_density = (Long)attributes.get(
				"cytoplasmic_phoshpo_pakt_o2_density");

		if (cytoplasmic_phoshpo_pakt_o2_density != null) {
			setCytoplasmic_phoshpo_pakt_o2_density(cytoplasmic_phoshpo_pakt_o2_density);
		}

		Long nuclear_phoshpo_pakt_o2_intensity = (Long)attributes.get(
				"nuclear_phoshpo_pakt_o2_intensity");

		if (nuclear_phoshpo_pakt_o2_intensity != null) {
			setNuclear_phoshpo_pakt_o2_intensity(nuclear_phoshpo_pakt_o2_intensity);
		}

		Long nuclear_phoshpo_pakt_o2_density = (Long)attributes.get(
				"nuclear_phoshpo_pakt_o2_density");

		if (nuclear_phoshpo_pakt_o2_density != null) {
			setNuclear_phoshpo_pakt_o2_density(nuclear_phoshpo_pakt_o2_density);
		}

		Long cytoplasmic_phoshpo_pmtor_o1_intensity = (Long)attributes.get(
				"cytoplasmic_phoshpo_pmtor_o1_intensity");

		if (cytoplasmic_phoshpo_pmtor_o1_intensity != null) {
			setCytoplasmic_phoshpo_pmtor_o1_intensity(cytoplasmic_phoshpo_pmtor_o1_intensity);
		}

		Long cytoplasmic_phoshpo_pmtor_o1_density = (Long)attributes.get(
				"cytoplasmic_phoshpo_pmtor_o1_density");

		if (cytoplasmic_phoshpo_pmtor_o1_density != null) {
			setCytoplasmic_phoshpo_pmtor_o1_density(cytoplasmic_phoshpo_pmtor_o1_density);
		}

		Long nuclear_phoshpo_pmtor_o1_intensity = (Long)attributes.get(
				"nuclear_phoshpo_pmtor_o1_intensity");

		if (nuclear_phoshpo_pmtor_o1_intensity != null) {
			setNuclear_phoshpo_pmtor_o1_intensity(nuclear_phoshpo_pmtor_o1_intensity);
		}

		Long nuclear_phoshpo_pmtor_o1_density = (Long)attributes.get(
				"nuclear_phoshpo_pmtor_o1_density");

		if (nuclear_phoshpo_pmtor_o1_density != null) {
			setNuclear_phoshpo_pmtor_o1_density(nuclear_phoshpo_pmtor_o1_density);
		}

		Long cytoplasmic_phoshpo_pmtor_o2_intensity = (Long)attributes.get(
				"cytoplasmic_phoshpo_pmtor_o2_intensity");

		if (cytoplasmic_phoshpo_pmtor_o2_intensity != null) {
			setCytoplasmic_phoshpo_pmtor_o2_intensity(cytoplasmic_phoshpo_pmtor_o2_intensity);
		}

		Long cytoplasmic_phoshpo_pmtor_o2_density = (Long)attributes.get(
				"cytoplasmic_phoshpo_pmtor_o2_density");

		if (cytoplasmic_phoshpo_pmtor_o2_density != null) {
			setCytoplasmic_phoshpo_pmtor_o2_density(cytoplasmic_phoshpo_pmtor_o2_density);
		}

		Long nuclear_phoshpo_pmtor_o2_intensity = (Long)attributes.get(
				"nuclear_phoshpo_pmtor_o2_intensity");

		if (nuclear_phoshpo_pmtor_o2_intensity != null) {
			setNuclear_phoshpo_pmtor_o2_intensity(nuclear_phoshpo_pmtor_o2_intensity);
		}

		Long nuclear_phoshpo_pmtor_o2_density = (Long)attributes.get(
				"nuclear_phoshpo_pmtor_o2_density");

		if (nuclear_phoshpo_pmtor_o2_density != null) {
			setNuclear_phoshpo_pmtor_o2_density(nuclear_phoshpo_pmtor_o2_density);
		}

		Long cytoplasmic_phoshpo_pp70s6k_o1_density = (Long)attributes.get(
				"cytoplasmic_phoshpo_pp70s6k_o1_density");

		if (cytoplasmic_phoshpo_pp70s6k_o1_density != null) {
			setCytoplasmic_phoshpo_pp70s6k_o1_density(cytoplasmic_phoshpo_pp70s6k_o1_density);
		}

		Long nuclear_phoshpo_pp70s6k_o1_intensity = (Long)attributes.get(
				"nuclear_phoshpo_pp70s6k_o1_intensity");

		if (nuclear_phoshpo_pp70s6k_o1_intensity != null) {
			setNuclear_phoshpo_pp70s6k_o1_intensity(nuclear_phoshpo_pp70s6k_o1_intensity);
		}

		Long nuclear_phoshpo_pp70s6k_o1_density = (Long)attributes.get(
				"nuclear_phoshpo_pp70s6k_o1_density");

		if (nuclear_phoshpo_pp70s6k_o1_density != null) {
			setNuclear_phoshpo_pp70s6k_o1_density(nuclear_phoshpo_pp70s6k_o1_density);
		}

		Long cytoplasmic_phoshpo_pp70s6k_o2_intensity = (Long)attributes.get(
				"cytoplasmic_phoshpo_pp70s6k_o2_intensity");

		if (cytoplasmic_phoshpo_pp70s6k_o2_intensity != null) {
			setCytoplasmic_phoshpo_pp70s6k_o2_intensity(cytoplasmic_phoshpo_pp70s6k_o2_intensity);
		}

		Long cytoplasmic_phoshpo_pp70s6k_o2_density = (Long)attributes.get(
				"cytoplasmic_phoshpo_pp70s6k_o2_density");

		if (cytoplasmic_phoshpo_pp70s6k_o2_density != null) {
			setCytoplasmic_phoshpo_pp70s6k_o2_density(cytoplasmic_phoshpo_pp70s6k_o2_density);
		}

		Long nuclear_phoshpo_pp70s6k_o2_intensity = (Long)attributes.get(
				"nuclear_phoshpo_pp70s6k_o2_intensity");

		if (nuclear_phoshpo_pp70s6k_o2_intensity != null) {
			setNuclear_phoshpo_pp70s6k_o2_intensity(nuclear_phoshpo_pp70s6k_o2_intensity);
		}

		Long nuclear_phoshpo_pp70s6k_o2_density = (Long)attributes.get(
				"nuclear_phoshpo_pp70s6k_o2_density");

		if (nuclear_phoshpo_pp70s6k_o2_density != null) {
			setNuclear_phoshpo_pp70s6k_o2_density(nuclear_phoshpo_pp70s6k_o2_density);
		}

		Long cytoplasmic_phoshpo_pp70s6k_o1_intensity = (Long)attributes.get(
				"cytoplasmic_phoshpo_pp70s6k_o1_intensity");

		if (cytoplasmic_phoshpo_pp70s6k_o1_intensity != null) {
			setCytoplasmic_phoshpo_pp70s6k_o1_intensity(cytoplasmic_phoshpo_pp70s6k_o1_intensity);
		}

		Long cytoplasmic_phoshpo_pten_o1_intensity = (Long)attributes.get(
				"cytoplasmic_phoshpo_pten_o1_intensity");

		if (cytoplasmic_phoshpo_pten_o1_intensity != null) {
			setCytoplasmic_phoshpo_pten_o1_intensity(cytoplasmic_phoshpo_pten_o1_intensity);
		}

		Long cytoplasmic_phoshpo_pten_o1_density = (Long)attributes.get(
				"cytoplasmic_phoshpo_pten_o1_density");

		if (cytoplasmic_phoshpo_pten_o1_density != null) {
			setCytoplasmic_phoshpo_pten_o1_density(cytoplasmic_phoshpo_pten_o1_density);
		}

		Long nuclear_phoshpo_pten_o1_intensity = (Long)attributes.get(
				"nuclear_phoshpo_pten_o1_intensity");

		if (nuclear_phoshpo_pten_o1_intensity != null) {
			setNuclear_phoshpo_pten_o1_intensity(nuclear_phoshpo_pten_o1_intensity);
		}

		Long nuclear_phoshpo_pten_o1_density = (Long)attributes.get(
				"nuclear_phoshpo_pten_o1_density");

		if (nuclear_phoshpo_pten_o1_density != null) {
			setNuclear_phoshpo_pten_o1_density(nuclear_phoshpo_pten_o1_density);
		}

		Long cytoplasmic_phoshpo_pten_o2_intensity = (Long)attributes.get(
				"cytoplasmic_phoshpo_pten_o2_intensity");

		if (cytoplasmic_phoshpo_pten_o2_intensity != null) {
			setCytoplasmic_phoshpo_pten_o2_intensity(cytoplasmic_phoshpo_pten_o2_intensity);
		}

		Long cytoplasmic_phoshpo_pten_o2_density = (Long)attributes.get(
				"cytoplasmic_phoshpo_pten_o2_density");

		if (cytoplasmic_phoshpo_pten_o2_density != null) {
			setCytoplasmic_phoshpo_pten_o2_density(cytoplasmic_phoshpo_pten_o2_density);
		}

		Long nuclear_phoshpo_pten_o2_intensity = (Long)attributes.get(
				"nuclear_phoshpo_pten_o2_intensity");

		if (nuclear_phoshpo_pten_o2_intensity != null) {
			setNuclear_phoshpo_pten_o2_intensity(nuclear_phoshpo_pten_o2_intensity);
		}

		Long nuclear_phoshpo_pten_o2_density = (Long)attributes.get(
				"nuclear_phoshpo_pten_o2_density");

		if (nuclear_phoshpo_pten_o2_density != null) {
			setNuclear_phoshpo_pten_o2_density(nuclear_phoshpo_pten_o2_density);
		}
	}

	@Override
	public long getTma_Id() {
		return _tma_Id;
	}

	@Override
	public void setTma_Id(long tma_Id) {
		_tma_Id = tma_Id;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setTma_Id", long.class);

				method.invoke(_tmaRemoteModel, tma_Id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSample_id() {
		return _sample_id;
	}

	@Override
	public void setSample_id(long sample_id) {
		_sample_id = sample_id;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setSample_id", long.class);

				method.invoke(_tmaRemoteModel, sample_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTma_name() {
		return _tma_name;
	}

	@Override
	public void setTma_name(String tma_name) {
		_tma_name = tma_name;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setTma_name", String.class);

				method.invoke(_tmaRemoteModel, tma_name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTma_number() {
		return _tma_number;
	}

	@Override
	public void setTma_number(String tma_number) {
		_tma_number = tma_number;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setTma_number", String.class);

				method.invoke(_tmaRemoteModel, tma_number);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTma_comment() {
		return _tma_comment;
	}

	@Override
	public void setTma_comment(String tma_comment) {
		_tma_comment = tma_comment;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setTma_comment", String.class);

				method.invoke(_tmaRemoteModel, tma_comment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_stat_5_intensity() {
		return _cytoplasmic_stat_5_intensity;
	}

	@Override
	public void setCytoplasmic_stat_5_intensity(
		long cytoplasmic_stat_5_intensity) {
		_cytoplasmic_stat_5_intensity = cytoplasmic_stat_5_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_stat_5_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_stat_5_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_stat_5_density() {
		return _cytoplasmic_stat_5_density;
	}

	@Override
	public void setCytoplasmic_stat_5_density(long cytoplasmic_stat_5_density) {
		_cytoplasmic_stat_5_density = cytoplasmic_stat_5_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_stat_5_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_stat_5_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_stat_5_intensity() {
		return _nuclear_stat_5_intensity;
	}

	@Override
	public void setNuclear_stat_5_intensity(long nuclear_stat_5_intensity) {
		_nuclear_stat_5_intensity = nuclear_stat_5_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_stat_5_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_stat_5_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_stat_5_density() {
		return _nuclear_stat_5_density;
	}

	@Override
	public void setNuclear_stat_5_density(long nuclear_stat_5_density) {
		_nuclear_stat_5_density = nuclear_stat_5_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_stat_5_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_stat_5_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_cjun_intensity() {
		return _cytoplasmic_cjun_intensity;
	}

	@Override
	public void setCytoplasmic_cjun_intensity(long cytoplasmic_cjun_intensity) {
		_cytoplasmic_cjun_intensity = cytoplasmic_cjun_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_cjun_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_cjun_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_cjun_density() {
		return _cytoplasmic_cjun_density;
	}

	@Override
	public void setCytoplasmic_cjun_density(long cytoplasmic_cjun_density) {
		_cytoplasmic_cjun_density = cytoplasmic_cjun_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_cjun_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_cjun_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_cjun_intensity() {
		return _nuclear_cjun_intensity;
	}

	@Override
	public void setNuclear_cjun_intensity(long nuclear_cjun_intensity) {
		_nuclear_cjun_intensity = nuclear_cjun_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_cjun_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_cjun_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_cjun_density() {
		return _nuclear_cjun_density;
	}

	@Override
	public void setNuclear_cjun_density(long nuclear_cjun_density) {
		_nuclear_cjun_density = nuclear_cjun_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_cjun_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_cjun_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_pstat_3_intensity() {
		return _cytoplasmic_pstat_3_intensity;
	}

	@Override
	public void setCytoplasmic_pstat_3_intensity(
		long cytoplasmic_pstat_3_intensity) {
		_cytoplasmic_pstat_3_intensity = cytoplasmic_pstat_3_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_pstat_3_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_pstat_3_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_pstat_3_density() {
		return _cytoplasmic_pstat_3_density;
	}

	@Override
	public void setCytoplasmic_pstat_3_density(long cytoplasmic_pstat_3_density) {
		_cytoplasmic_pstat_3_density = cytoplasmic_pstat_3_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_pstat_3_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_pstat_3_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_pstat_3_intensity() {
		return _nuclear_pstat_3_intensity;
	}

	@Override
	public void setNuclear_pstat_3_intensity(long nuclear_pstat_3_intensity) {
		_nuclear_pstat_3_intensity = nuclear_pstat_3_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_pstat_3_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_pstat_3_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_pstat_3_density() {
		return _nuclear_pstat_3_density;
	}

	@Override
	public void setNuclear_pstat_3_density(long nuclear_pstat_3_density) {
		_nuclear_pstat_3_density = nuclear_pstat_3_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_pstat_3_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_pstat_3_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_pstat_5_intensity() {
		return _cytoplasmic_pstat_5_intensity;
	}

	@Override
	public void setCytoplasmic_pstat_5_intensity(
		long cytoplasmic_pstat_5_intensity) {
		_cytoplasmic_pstat_5_intensity = cytoplasmic_pstat_5_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_pstat_5_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_pstat_5_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_pstat_5_density() {
		return _cytoplasmic_pstat_5_density;
	}

	@Override
	public void setCytoplasmic_pstat_5_density(long cytoplasmic_pstat_5_density) {
		_cytoplasmic_pstat_5_density = cytoplasmic_pstat_5_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_pstat_5_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_pstat_5_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_pstat_5_intensity() {
		return _nuclear_pstat_5_intensity;
	}

	@Override
	public void setNuclear_pstat_5_intensity(long nuclear_pstat_5_intensity) {
		_nuclear_pstat_5_intensity = nuclear_pstat_5_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_pstat_5_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_pstat_5_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_pstat_5_density() {
		return _nuclear_pstat_5_density;
	}

	@Override
	public void setNuclear_pstat_5_density(long nuclear_pstat_5_density) {
		_nuclear_pstat_5_density = nuclear_pstat_5_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_pstat_5_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_pstat_5_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_pstat_1_intensity() {
		return _cytoplasmic_pstat_1_intensity;
	}

	@Override
	public void setCytoplasmic_pstat_1_intensity(
		long cytoplasmic_pstat_1_intensity) {
		_cytoplasmic_pstat_1_intensity = cytoplasmic_pstat_1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_pstat_1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_pstat_1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_pstat_1_density() {
		return _cytoplasmic_pstat_1_density;
	}

	@Override
	public void setCytoplasmic_pstat_1_density(long cytoplasmic_pstat_1_density) {
		_cytoplasmic_pstat_1_density = cytoplasmic_pstat_1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_pstat_1_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_pstat_1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_pstat_1_intensity() {
		return _nuclear_pstat_1_intensity;
	}

	@Override
	public void setNuclear_pstat_1_intensity(long nuclear_pstat_1_intensity) {
		_nuclear_pstat_1_intensity = nuclear_pstat_1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_pstat_1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_pstat_1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_il6r_intensity() {
		return _cytoplasmic_il6r_intensity;
	}

	@Override
	public void setCytoplasmic_il6r_intensity(long cytoplasmic_il6r_intensity) {
		_cytoplasmic_il6r_intensity = cytoplasmic_il6r_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_il6r_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_il6r_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_il6r_density() {
		return _cytoplasmic_il6r_density;
	}

	@Override
	public void setCytoplasmic_il6r_density(long cytoplasmic_il6r_density) {
		_cytoplasmic_il6r_density = cytoplasmic_il6r_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_il6r_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_il6r_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_il6r_intensity() {
		return _nuclear_il6r_intensity;
	}

	@Override
	public void setNuclear_il6r_intensity(long nuclear_il6r_intensity) {
		_nuclear_il6r_intensity = nuclear_il6r_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_il6r_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_il6r_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_il6r_density() {
		return _nuclear_il6r_density;
	}

	@Override
	public void setNuclear_il6r_density(long nuclear_il6r_density) {
		_nuclear_il6r_density = nuclear_il6r_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_il6r_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_il6r_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_socs1_intensity() {
		return _cytoplasmic_socs1_intensity;
	}

	@Override
	public void setCytoplasmic_socs1_intensity(long cytoplasmic_socs1_intensity) {
		_cytoplasmic_socs1_intensity = cytoplasmic_socs1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_socs1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_socs1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_socs1_density() {
		return _cytoplasmic_socs1_density;
	}

	@Override
	public void setCytoplasmic_socs1_density(long cytoplasmic_socs1_density) {
		_cytoplasmic_socs1_density = cytoplasmic_socs1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_socs1_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_socs1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_socs1_intensity() {
		return _nuclear_socs1_intensity;
	}

	@Override
	public void setNuclear_socs1_intensity(long nuclear_socs1_intensity) {
		_nuclear_socs1_intensity = nuclear_socs1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_socs1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_socs1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_socs1_density() {
		return _nuclear_socs1_density;
	}

	@Override
	public void setNuclear_socs1_density(long nuclear_socs1_density) {
		_nuclear_socs1_density = nuclear_socs1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_socs1_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_socs1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_socs3_intensity() {
		return _cytoplasmic_socs3_intensity;
	}

	@Override
	public void setCytoplasmic_socs3_intensity(long cytoplasmic_socs3_intensity) {
		_cytoplasmic_socs3_intensity = cytoplasmic_socs3_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_socs3_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_socs3_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_socs3_density() {
		return _cytoplasmic_socs3_density;
	}

	@Override
	public void setCytoplasmic_socs3_density(long cytoplasmic_socs3_density) {
		_cytoplasmic_socs3_density = cytoplasmic_socs3_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_socs3_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_socs3_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_socs3_intensity() {
		return _nuclear_socs3_intensity;
	}

	@Override
	public void setNuclear_socs3_intensity(long nuclear_socs3_intensity) {
		_nuclear_socs3_intensity = nuclear_socs3_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_socs3_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_socs3_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_socs3_density() {
		return _nuclear_socs3_density;
	}

	@Override
	public void setNuclear_socs3_density(long nuclear_socs3_density) {
		_nuclear_socs3_density = nuclear_socs3_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_socs3_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_socs3_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_junb_intensity() {
		return _cytoplasmic_junb_intensity;
	}

	@Override
	public void setCytoplasmic_junb_intensity(long cytoplasmic_junb_intensity) {
		_cytoplasmic_junb_intensity = cytoplasmic_junb_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_junb_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_junb_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_junb_density() {
		return _cytoplasmic_junb_density;
	}

	@Override
	public void setCytoplasmic_junb_density(long cytoplasmic_junb_density) {
		_cytoplasmic_junb_density = cytoplasmic_junb_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_junb_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_junb_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_junb_intensity() {
		return _nuclear_junb_intensity;
	}

	@Override
	public void setNuclear_junb_intensity(long nuclear_junb_intensity) {
		_nuclear_junb_intensity = nuclear_junb_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_junb_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_junb_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_junb_density() {
		return _nuclear_junb_density;
	}

	@Override
	public void setNuclear_junb_density(long nuclear_junb_density) {
		_nuclear_junb_density = nuclear_junb_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_junb_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_junb_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_stat_3_intensity() {
		return _cytoplasmic_stat_3_intensity;
	}

	@Override
	public void setCytoplasmic_stat_3_intensity(
		long cytoplasmic_stat_3_intensity) {
		_cytoplasmic_stat_3_intensity = cytoplasmic_stat_3_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_stat_3_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_stat_3_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_stat_3_density() {
		return _cytoplasmic_stat_3_density;
	}

	@Override
	public void setCytoplasmic_stat_3_density(long cytoplasmic_stat_3_density) {
		_cytoplasmic_stat_3_density = cytoplasmic_stat_3_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_stat_3_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_stat_3_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_stat_3_intensity() {
		return _nuclear_stat_3_intensity;
	}

	@Override
	public void setNuclear_stat_3_intensity(long nuclear_stat_3_intensity) {
		_nuclear_stat_3_intensity = nuclear_stat_3_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_stat_3_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_stat_3_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_stat_3_density() {
		return _nuclear_stat_3_density;
	}

	@Override
	public void setNuclear_stat_3_density(long nuclear_stat_3_density) {
		_nuclear_stat_3_density = nuclear_stat_3_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_stat_3_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_stat_3_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_stat_5a_intensity() {
		return _cytoplasmic_stat_5a_intensity;
	}

	@Override
	public void setCytoplasmic_stat_5a_intensity(
		long cytoplasmic_stat_5a_intensity) {
		_cytoplasmic_stat_5a_intensity = cytoplasmic_stat_5a_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_stat_5a_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_stat_5a_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_stat_5a_density() {
		return _cytoplasmic_stat_5a_density;
	}

	@Override
	public void setCytoplasmic_stat_5a_density(long cytoplasmic_stat_5a_density) {
		_cytoplasmic_stat_5a_density = cytoplasmic_stat_5a_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_stat_5a_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_stat_5a_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_stat_5a_intensity() {
		return _nuclear_stat_5a_intensity;
	}

	@Override
	public void setNuclear_stat_5a_intensity(long nuclear_stat_5a_intensity) {
		_nuclear_stat_5a_intensity = nuclear_stat_5a_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_stat_5a_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_stat_5a_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_stat_5a_density() {
		return _nuclear_stat_5a_density;
	}

	@Override
	public void setNuclear_stat_5a_density(long nuclear_stat_5a_density) {
		_nuclear_stat_5a_density = nuclear_stat_5a_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_stat_5a_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_stat_5a_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_stat_5b_intensity() {
		return _cytoplasmic_stat_5b_intensity;
	}

	@Override
	public void setCytoplasmic_stat_5b_intensity(
		long cytoplasmic_stat_5b_intensity) {
		_cytoplasmic_stat_5b_intensity = cytoplasmic_stat_5b_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_stat_5b_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_stat_5b_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_stat_5b_density() {
		return _cytoplasmic_stat_5b_density;
	}

	@Override
	public void setCytoplasmic_stat_5b_density(long cytoplasmic_stat_5b_density) {
		_cytoplasmic_stat_5b_density = cytoplasmic_stat_5b_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_stat_5b_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_stat_5b_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_stat_5b_intensity() {
		return _nuclear_stat_5b_intensity;
	}

	@Override
	public void setNuclear_stat_5b_intensity(long nuclear_stat_5b_intensity) {
		_nuclear_stat_5b_intensity = nuclear_stat_5b_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_stat_5b_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_stat_5b_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_stat_5b_density() {
		return _nuclear_stat_5b_density;
	}

	@Override
	public void setNuclear_stat_5b_density(long nuclear_stat_5b_density) {
		_nuclear_stat_5b_density = nuclear_stat_5b_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_stat_5b_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_stat_5b_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_eif3a_intensity() {
		return _cytoplasmic_eif3a_intensity;
	}

	@Override
	public void setCytoplasmic_eif3a_intensity(long cytoplasmic_eif3a_intensity) {
		_cytoplasmic_eif3a_intensity = cytoplasmic_eif3a_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_eif3a_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_eif3a_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_eif3a_density() {
		return _cytoplasmic_eif3a_density;
	}

	@Override
	public void setCytoplasmic_eif3a_density(long cytoplasmic_eif3a_density) {
		_cytoplasmic_eif3a_density = cytoplasmic_eif3a_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_eif3a_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_eif3a_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_eif3a_peter_intensity() {
		return _cytoplasmic_eif3a_peter_intensity;
	}

	@Override
	public void setCytoplasmic_eif3a_peter_intensity(
		long cytoplasmic_eif3a_peter_intensity) {
		_cytoplasmic_eif3a_peter_intensity = cytoplasmic_eif3a_peter_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_eif3a_peter_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_eif3a_peter_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_eif3a_peter_density() {
		return _cytoplasmic_eif3a_peter_density;
	}

	@Override
	public void setCytoplasmic_eif3a_peter_density(
		long cytoplasmic_eif3a_peter_density) {
		_cytoplasmic_eif3a_peter_density = cytoplasmic_eif3a_peter_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_eif3a_peter_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_eif3a_peter_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_itih_5_o1_intensity() {
		return _cytoplasmic_itih_5_o1_intensity;
	}

	@Override
	public void setCytoplasmic_itih_5_o1_intensity(
		long cytoplasmic_itih_5_o1_intensity) {
		_cytoplasmic_itih_5_o1_intensity = cytoplasmic_itih_5_o1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_itih_5_o1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_itih_5_o1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_itih_5_o1_density() {
		return _cytoplasmic_itih_5_o1_density;
	}

	@Override
	public void setCytoplasmic_itih_5_o1_density(
		long cytoplasmic_itih_5_o1_density) {
		_cytoplasmic_itih_5_o1_density = cytoplasmic_itih_5_o1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_itih_5_o1_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_itih_5_o1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_itih_5_o1_intensity() {
		return _nuclear_itih_5_o1_intensity;
	}

	@Override
	public void setNuclear_itih_5_o1_intensity(long nuclear_itih_5_o1_intensity) {
		_nuclear_itih_5_o1_intensity = nuclear_itih_5_o1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_itih_5_o1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_itih_5_o1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_itih_5_o1_density() {
		return _nuclear_itih_5_o1_density;
	}

	@Override
	public void setNuclear_itih_5_o1_density(long nuclear_itih_5_o1_density) {
		_nuclear_itih_5_o1_density = nuclear_itih_5_o1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_itih_5_o1_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_itih_5_o1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_itih_5_o2_intensity() {
		return _cytoplasmic_itih_5_o2_intensity;
	}

	@Override
	public void setCytoplasmic_itih_5_o2_intensity(
		long cytoplasmic_itih_5_o2_intensity) {
		_cytoplasmic_itih_5_o2_intensity = cytoplasmic_itih_5_o2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_itih_5_o2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_itih_5_o2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_itih_5_o2_density() {
		return _cytoplasmic_itih_5_o2_density;
	}

	@Override
	public void setCytoplasmic_itih_5_o2_density(
		long cytoplasmic_itih_5_o2_density) {
		_cytoplasmic_itih_5_o2_density = cytoplasmic_itih_5_o2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_itih_5_o2_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_itih_5_o2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_itih_5_o2_intensity() {
		return _nuclear_itih_5_o2_intensity;
	}

	@Override
	public void setNuclear_itih_5_o2_intensity(long nuclear_itih_5_o2_intensity) {
		_nuclear_itih_5_o2_intensity = nuclear_itih_5_o2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_itih_5_o2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_itih_5_o2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_itih_5_o2_density() {
		return _nuclear_itih_5_o2_density;
	}

	@Override
	public void setNuclear_itih_5_o2_density(long nuclear_itih_5_o2_density) {
		_nuclear_itih_5_o2_density = nuclear_itih_5_o2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_itih_5_o2_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_itih_5_o2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_imp2_2_intensity() {
		return _cytoplasmic_imp2_2_intensity;
	}

	@Override
	public void setCytoplasmic_imp2_2_intensity(
		long cytoplasmic_imp2_2_intensity) {
		_cytoplasmic_imp2_2_intensity = cytoplasmic_imp2_2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_imp2_2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_imp2_2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_imp2_2_density() {
		return _cytoplasmic_imp2_2_density;
	}

	@Override
	public void setCytoplasmic_imp2_2_density(long cytoplasmic_imp2_2_density) {
		_cytoplasmic_imp2_2_density = cytoplasmic_imp2_2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_imp2_2_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_imp2_2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_stat_1_intensity() {
		return _cytoplasmic_stat_1_intensity;
	}

	@Override
	public void setCytoplasmic_stat_1_intensity(
		long cytoplasmic_stat_1_intensity) {
		_cytoplasmic_stat_1_intensity = cytoplasmic_stat_1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_stat_1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_stat_1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_stat_1_density() {
		return _cytoplasmic_stat_1_density;
	}

	@Override
	public void setCytoplasmic_stat_1_density(long cytoplasmic_stat_1_density) {
		_cytoplasmic_stat_1_density = cytoplasmic_stat_1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_stat_1_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_stat_1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_stat_1_intensity() {
		return _nuclear_stat_1_intensity;
	}

	@Override
	public void setNuclear_stat_1_intensity(long nuclear_stat_1_intensity) {
		_nuclear_stat_1_intensity = nuclear_stat_1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_stat_1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_stat_1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_stat_1_density() {
		return _nuclear_stat_1_density;
	}

	@Override
	public void setNuclear_stat_1_density(long nuclear_stat_1_density) {
		_nuclear_stat_1_density = nuclear_stat_1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_stat_1_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_stat_1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_nfkb1_intensity() {
		return _cytoplasmic_nfkb1_intensity;
	}

	@Override
	public void setCytoplasmic_nfkb1_intensity(long cytoplasmic_nfkb1_intensity) {
		_cytoplasmic_nfkb1_intensity = cytoplasmic_nfkb1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_nfkb1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_nfkb1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_nfkb1_density() {
		return _cytoplasmic_nfkb1_density;
	}

	@Override
	public void setCytoplasmic_nfkb1_density(long cytoplasmic_nfkb1_density) {
		_cytoplasmic_nfkb1_density = cytoplasmic_nfkb1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_nfkb1_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_nfkb1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_nfkb1_intensity() {
		return _nuclear_nfkb1_intensity;
	}

	@Override
	public void setNuclear_nfkb1_intensity(long nuclear_nfkb1_intensity) {
		_nuclear_nfkb1_intensity = nuclear_nfkb1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_nfkb1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_nfkb1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_nfkb1_density() {
		return _nuclear_nfkb1_density;
	}

	@Override
	public void setNuclear_nfkb1_density(long nuclear_nfkb1_density) {
		_nuclear_nfkb1_density = nuclear_nfkb1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_nfkb1_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_nfkb1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_nfkb2_intensity() {
		return _cytoplasmic_nfkb2_intensity;
	}

	@Override
	public void setCytoplasmic_nfkb2_intensity(long cytoplasmic_nfkb2_intensity) {
		_cytoplasmic_nfkb2_intensity = cytoplasmic_nfkb2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_nfkb2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_nfkb2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_nfkb2_density() {
		return _cytoplasmic_nfkb2_density;
	}

	@Override
	public void setCytoplasmic_nfkb2_density(long cytoplasmic_nfkb2_density) {
		_cytoplasmic_nfkb2_density = cytoplasmic_nfkb2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_nfkb2_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_nfkb2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_nfkb2_intensity() {
		return _nuclear_nfkb2_intensity;
	}

	@Override
	public void setNuclear_nfkb2_intensity(long nuclear_nfkb2_intensity) {
		_nuclear_nfkb2_intensity = nuclear_nfkb2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_nfkb2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_nfkb2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_nfkb2_density() {
		return _nuclear_nfkb2_density;
	}

	@Override
	public void setNuclear_nfkb2_density(long nuclear_nfkb2_density) {
		_nuclear_nfkb2_density = nuclear_nfkb2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_nfkb2_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_nfkb2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_pikb_intensity() {
		return _cytoplasmic_pikb_intensity;
	}

	@Override
	public void setCytoplasmic_pikb_intensity(long cytoplasmic_pikb_intensity) {
		_cytoplasmic_pikb_intensity = cytoplasmic_pikb_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_pikb_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_pikb_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_pikb_density() {
		return _cytoplasmic_pikb_density;
	}

	@Override
	public void setCytoplasmic_pikb_density(long cytoplasmic_pikb_density) {
		_cytoplasmic_pikb_density = cytoplasmic_pikb_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_pikb_density",
						long.class);

				method.invoke(_tmaRemoteModel, cytoplasmic_pikb_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pakt_o1_intensity() {
		return _cytoplasmic_phoshpo_pakt_o1_intensity;
	}

	@Override
	public void setCytoplasmic_phoshpo_pakt_o1_intensity(
		long cytoplasmic_phoshpo_pakt_o1_intensity) {
		_cytoplasmic_phoshpo_pakt_o1_intensity = cytoplasmic_phoshpo_pakt_o1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pakt_o1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pakt_o1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pakt_o1_density() {
		return _cytoplasmic_phoshpo_pakt_o1_density;
	}

	@Override
	public void setCytoplasmic_phoshpo_pakt_o1_density(
		long cytoplasmic_phoshpo_pakt_o1_density) {
		_cytoplasmic_phoshpo_pakt_o1_density = cytoplasmic_phoshpo_pakt_o1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pakt_o1_density",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pakt_o1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pakt_o1_intensity() {
		return _nuclear_phoshpo_pakt_o1_intensity;
	}

	@Override
	public void setNuclear_phoshpo_pakt_o1_intensity(
		long nuclear_phoshpo_pakt_o1_intensity) {
		_nuclear_phoshpo_pakt_o1_intensity = nuclear_phoshpo_pakt_o1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pakt_o1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_phoshpo_pakt_o1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pakt_o1_density() {
		return _nuclear_phoshpo_pakt_o1_density;
	}

	@Override
	public void setNuclear_phoshpo_pakt_o1_density(
		long nuclear_phoshpo_pakt_o1_density) {
		_nuclear_phoshpo_pakt_o1_density = nuclear_phoshpo_pakt_o1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pakt_o1_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_phoshpo_pakt_o1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pakt_o2_intensity() {
		return _cytoplasmic_phoshpo_pakt_o2_intensity;
	}

	@Override
	public void setCytoplasmic_phoshpo_pakt_o2_intensity(
		long cytoplasmic_phoshpo_pakt_o2_intensity) {
		_cytoplasmic_phoshpo_pakt_o2_intensity = cytoplasmic_phoshpo_pakt_o2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pakt_o2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pakt_o2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pakt_o2_density() {
		return _cytoplasmic_phoshpo_pakt_o2_density;
	}

	@Override
	public void setCytoplasmic_phoshpo_pakt_o2_density(
		long cytoplasmic_phoshpo_pakt_o2_density) {
		_cytoplasmic_phoshpo_pakt_o2_density = cytoplasmic_phoshpo_pakt_o2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pakt_o2_density",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pakt_o2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pakt_o2_intensity() {
		return _nuclear_phoshpo_pakt_o2_intensity;
	}

	@Override
	public void setNuclear_phoshpo_pakt_o2_intensity(
		long nuclear_phoshpo_pakt_o2_intensity) {
		_nuclear_phoshpo_pakt_o2_intensity = nuclear_phoshpo_pakt_o2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pakt_o2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_phoshpo_pakt_o2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pakt_o2_density() {
		return _nuclear_phoshpo_pakt_o2_density;
	}

	@Override
	public void setNuclear_phoshpo_pakt_o2_density(
		long nuclear_phoshpo_pakt_o2_density) {
		_nuclear_phoshpo_pakt_o2_density = nuclear_phoshpo_pakt_o2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pakt_o2_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_phoshpo_pakt_o2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pmtor_o1_intensity() {
		return _cytoplasmic_phoshpo_pmtor_o1_intensity;
	}

	@Override
	public void setCytoplasmic_phoshpo_pmtor_o1_intensity(
		long cytoplasmic_phoshpo_pmtor_o1_intensity) {
		_cytoplasmic_phoshpo_pmtor_o1_intensity = cytoplasmic_phoshpo_pmtor_o1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pmtor_o1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pmtor_o1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pmtor_o1_density() {
		return _cytoplasmic_phoshpo_pmtor_o1_density;
	}

	@Override
	public void setCytoplasmic_phoshpo_pmtor_o1_density(
		long cytoplasmic_phoshpo_pmtor_o1_density) {
		_cytoplasmic_phoshpo_pmtor_o1_density = cytoplasmic_phoshpo_pmtor_o1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pmtor_o1_density",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pmtor_o1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pmtor_o1_intensity() {
		return _nuclear_phoshpo_pmtor_o1_intensity;
	}

	@Override
	public void setNuclear_phoshpo_pmtor_o1_intensity(
		long nuclear_phoshpo_pmtor_o1_intensity) {
		_nuclear_phoshpo_pmtor_o1_intensity = nuclear_phoshpo_pmtor_o1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pmtor_o1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel,
					nuclear_phoshpo_pmtor_o1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pmtor_o1_density() {
		return _nuclear_phoshpo_pmtor_o1_density;
	}

	@Override
	public void setNuclear_phoshpo_pmtor_o1_density(
		long nuclear_phoshpo_pmtor_o1_density) {
		_nuclear_phoshpo_pmtor_o1_density = nuclear_phoshpo_pmtor_o1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pmtor_o1_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_phoshpo_pmtor_o1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pmtor_o2_intensity() {
		return _cytoplasmic_phoshpo_pmtor_o2_intensity;
	}

	@Override
	public void setCytoplasmic_phoshpo_pmtor_o2_intensity(
		long cytoplasmic_phoshpo_pmtor_o2_intensity) {
		_cytoplasmic_phoshpo_pmtor_o2_intensity = cytoplasmic_phoshpo_pmtor_o2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pmtor_o2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pmtor_o2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pmtor_o2_density() {
		return _cytoplasmic_phoshpo_pmtor_o2_density;
	}

	@Override
	public void setCytoplasmic_phoshpo_pmtor_o2_density(
		long cytoplasmic_phoshpo_pmtor_o2_density) {
		_cytoplasmic_phoshpo_pmtor_o2_density = cytoplasmic_phoshpo_pmtor_o2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pmtor_o2_density",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pmtor_o2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pmtor_o2_intensity() {
		return _nuclear_phoshpo_pmtor_o2_intensity;
	}

	@Override
	public void setNuclear_phoshpo_pmtor_o2_intensity(
		long nuclear_phoshpo_pmtor_o2_intensity) {
		_nuclear_phoshpo_pmtor_o2_intensity = nuclear_phoshpo_pmtor_o2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pmtor_o2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel,
					nuclear_phoshpo_pmtor_o2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pmtor_o2_density() {
		return _nuclear_phoshpo_pmtor_o2_density;
	}

	@Override
	public void setNuclear_phoshpo_pmtor_o2_density(
		long nuclear_phoshpo_pmtor_o2_density) {
		_nuclear_phoshpo_pmtor_o2_density = nuclear_phoshpo_pmtor_o2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pmtor_o2_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_phoshpo_pmtor_o2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pp70s6k_o1_density() {
		return _cytoplasmic_phoshpo_pp70s6k_o1_density;
	}

	@Override
	public void setCytoplasmic_phoshpo_pp70s6k_o1_density(
		long cytoplasmic_phoshpo_pp70s6k_o1_density) {
		_cytoplasmic_phoshpo_pp70s6k_o1_density = cytoplasmic_phoshpo_pp70s6k_o1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pp70s6k_o1_density",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pp70s6k_o1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pp70s6k_o1_intensity() {
		return _nuclear_phoshpo_pp70s6k_o1_intensity;
	}

	@Override
	public void setNuclear_phoshpo_pp70s6k_o1_intensity(
		long nuclear_phoshpo_pp70s6k_o1_intensity) {
		_nuclear_phoshpo_pp70s6k_o1_intensity = nuclear_phoshpo_pp70s6k_o1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pp70s6k_o1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel,
					nuclear_phoshpo_pp70s6k_o1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pp70s6k_o1_density() {
		return _nuclear_phoshpo_pp70s6k_o1_density;
	}

	@Override
	public void setNuclear_phoshpo_pp70s6k_o1_density(
		long nuclear_phoshpo_pp70s6k_o1_density) {
		_nuclear_phoshpo_pp70s6k_o1_density = nuclear_phoshpo_pp70s6k_o1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pp70s6k_o1_density",
						long.class);

				method.invoke(_tmaRemoteModel,
					nuclear_phoshpo_pp70s6k_o1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pp70s6k_o2_intensity() {
		return _cytoplasmic_phoshpo_pp70s6k_o2_intensity;
	}

	@Override
	public void setCytoplasmic_phoshpo_pp70s6k_o2_intensity(
		long cytoplasmic_phoshpo_pp70s6k_o2_intensity) {
		_cytoplasmic_phoshpo_pp70s6k_o2_intensity = cytoplasmic_phoshpo_pp70s6k_o2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pp70s6k_o2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pp70s6k_o2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pp70s6k_o2_density() {
		return _cytoplasmic_phoshpo_pp70s6k_o2_density;
	}

	@Override
	public void setCytoplasmic_phoshpo_pp70s6k_o2_density(
		long cytoplasmic_phoshpo_pp70s6k_o2_density) {
		_cytoplasmic_phoshpo_pp70s6k_o2_density = cytoplasmic_phoshpo_pp70s6k_o2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pp70s6k_o2_density",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pp70s6k_o2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pp70s6k_o2_intensity() {
		return _nuclear_phoshpo_pp70s6k_o2_intensity;
	}

	@Override
	public void setNuclear_phoshpo_pp70s6k_o2_intensity(
		long nuclear_phoshpo_pp70s6k_o2_intensity) {
		_nuclear_phoshpo_pp70s6k_o2_intensity = nuclear_phoshpo_pp70s6k_o2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pp70s6k_o2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel,
					nuclear_phoshpo_pp70s6k_o2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pp70s6k_o2_density() {
		return _nuclear_phoshpo_pp70s6k_o2_density;
	}

	@Override
	public void setNuclear_phoshpo_pp70s6k_o2_density(
		long nuclear_phoshpo_pp70s6k_o2_density) {
		_nuclear_phoshpo_pp70s6k_o2_density = nuclear_phoshpo_pp70s6k_o2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pp70s6k_o2_density",
						long.class);

				method.invoke(_tmaRemoteModel,
					nuclear_phoshpo_pp70s6k_o2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pp70s6k_o1_intensity() {
		return _cytoplasmic_phoshpo_pp70s6k_o1_intensity;
	}

	@Override
	public void setCytoplasmic_phoshpo_pp70s6k_o1_intensity(
		long cytoplasmic_phoshpo_pp70s6k_o1_intensity) {
		_cytoplasmic_phoshpo_pp70s6k_o1_intensity = cytoplasmic_phoshpo_pp70s6k_o1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pp70s6k_o1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pp70s6k_o1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pten_o1_intensity() {
		return _cytoplasmic_phoshpo_pten_o1_intensity;
	}

	@Override
	public void setCytoplasmic_phoshpo_pten_o1_intensity(
		long cytoplasmic_phoshpo_pten_o1_intensity) {
		_cytoplasmic_phoshpo_pten_o1_intensity = cytoplasmic_phoshpo_pten_o1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pten_o1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pten_o1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pten_o1_density() {
		return _cytoplasmic_phoshpo_pten_o1_density;
	}

	@Override
	public void setCytoplasmic_phoshpo_pten_o1_density(
		long cytoplasmic_phoshpo_pten_o1_density) {
		_cytoplasmic_phoshpo_pten_o1_density = cytoplasmic_phoshpo_pten_o1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pten_o1_density",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pten_o1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pten_o1_intensity() {
		return _nuclear_phoshpo_pten_o1_intensity;
	}

	@Override
	public void setNuclear_phoshpo_pten_o1_intensity(
		long nuclear_phoshpo_pten_o1_intensity) {
		_nuclear_phoshpo_pten_o1_intensity = nuclear_phoshpo_pten_o1_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pten_o1_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_phoshpo_pten_o1_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pten_o1_density() {
		return _nuclear_phoshpo_pten_o1_density;
	}

	@Override
	public void setNuclear_phoshpo_pten_o1_density(
		long nuclear_phoshpo_pten_o1_density) {
		_nuclear_phoshpo_pten_o1_density = nuclear_phoshpo_pten_o1_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pten_o1_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_phoshpo_pten_o1_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pten_o2_intensity() {
		return _cytoplasmic_phoshpo_pten_o2_intensity;
	}

	@Override
	public void setCytoplasmic_phoshpo_pten_o2_intensity(
		long cytoplasmic_phoshpo_pten_o2_intensity) {
		_cytoplasmic_phoshpo_pten_o2_intensity = cytoplasmic_phoshpo_pten_o2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pten_o2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pten_o2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCytoplasmic_phoshpo_pten_o2_density() {
		return _cytoplasmic_phoshpo_pten_o2_density;
	}

	@Override
	public void setCytoplasmic_phoshpo_pten_o2_density(
		long cytoplasmic_phoshpo_pten_o2_density) {
		_cytoplasmic_phoshpo_pten_o2_density = cytoplasmic_phoshpo_pten_o2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setCytoplasmic_phoshpo_pten_o2_density",
						long.class);

				method.invoke(_tmaRemoteModel,
					cytoplasmic_phoshpo_pten_o2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pten_o2_intensity() {
		return _nuclear_phoshpo_pten_o2_intensity;
	}

	@Override
	public void setNuclear_phoshpo_pten_o2_intensity(
		long nuclear_phoshpo_pten_o2_intensity) {
		_nuclear_phoshpo_pten_o2_intensity = nuclear_phoshpo_pten_o2_intensity;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pten_o2_intensity",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_phoshpo_pten_o2_intensity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNuclear_phoshpo_pten_o2_density() {
		return _nuclear_phoshpo_pten_o2_density;
	}

	@Override
	public void setNuclear_phoshpo_pten_o2_density(
		long nuclear_phoshpo_pten_o2_density) {
		_nuclear_phoshpo_pten_o2_density = nuclear_phoshpo_pten_o2_density;

		if (_tmaRemoteModel != null) {
			try {
				Class<?> clazz = _tmaRemoteModel.getClass();

				Method method = clazz.getMethod("setNuclear_phoshpo_pten_o2_density",
						long.class);

				method.invoke(_tmaRemoteModel, nuclear_phoshpo_pten_o2_density);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTMARemoteModel() {
		return _tmaRemoteModel;
	}

	public void setTMARemoteModel(BaseModel<?> tmaRemoteModel) {
		_tmaRemoteModel = tmaRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _tmaRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_tmaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TMALocalServiceUtil.addTMA(this);
		}
		else {
			TMALocalServiceUtil.updateTMA(this);
		}
	}

	@Override
	public TMA toEscapedModel() {
		return (TMA)ProxyUtil.newProxyInstance(TMA.class.getClassLoader(),
			new Class[] { TMA.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TMAClp clone = new TMAClp();

		clone.setTma_Id(getTma_Id());
		clone.setSample_id(getSample_id());
		clone.setTma_name(getTma_name());
		clone.setTma_number(getTma_number());
		clone.setTma_comment(getTma_comment());
		clone.setCytoplasmic_stat_5_intensity(getCytoplasmic_stat_5_intensity());
		clone.setCytoplasmic_stat_5_density(getCytoplasmic_stat_5_density());
		clone.setNuclear_stat_5_intensity(getNuclear_stat_5_intensity());
		clone.setNuclear_stat_5_density(getNuclear_stat_5_density());
		clone.setCytoplasmic_cjun_intensity(getCytoplasmic_cjun_intensity());
		clone.setCytoplasmic_cjun_density(getCytoplasmic_cjun_density());
		clone.setNuclear_cjun_intensity(getNuclear_cjun_intensity());
		clone.setNuclear_cjun_density(getNuclear_cjun_density());
		clone.setCytoplasmic_pstat_3_intensity(getCytoplasmic_pstat_3_intensity());
		clone.setCytoplasmic_pstat_3_density(getCytoplasmic_pstat_3_density());
		clone.setNuclear_pstat_3_intensity(getNuclear_pstat_3_intensity());
		clone.setNuclear_pstat_3_density(getNuclear_pstat_3_density());
		clone.setCytoplasmic_pstat_5_intensity(getCytoplasmic_pstat_5_intensity());
		clone.setCytoplasmic_pstat_5_density(getCytoplasmic_pstat_5_density());
		clone.setNuclear_pstat_5_intensity(getNuclear_pstat_5_intensity());
		clone.setNuclear_pstat_5_density(getNuclear_pstat_5_density());
		clone.setCytoplasmic_pstat_1_intensity(getCytoplasmic_pstat_1_intensity());
		clone.setCytoplasmic_pstat_1_density(getCytoplasmic_pstat_1_density());
		clone.setNuclear_pstat_1_intensity(getNuclear_pstat_1_intensity());
		clone.setCytoplasmic_il6r_intensity(getCytoplasmic_il6r_intensity());
		clone.setCytoplasmic_il6r_density(getCytoplasmic_il6r_density());
		clone.setNuclear_il6r_intensity(getNuclear_il6r_intensity());
		clone.setNuclear_il6r_density(getNuclear_il6r_density());
		clone.setCytoplasmic_socs1_intensity(getCytoplasmic_socs1_intensity());
		clone.setCytoplasmic_socs1_density(getCytoplasmic_socs1_density());
		clone.setNuclear_socs1_intensity(getNuclear_socs1_intensity());
		clone.setNuclear_socs1_density(getNuclear_socs1_density());
		clone.setCytoplasmic_socs3_intensity(getCytoplasmic_socs3_intensity());
		clone.setCytoplasmic_socs3_density(getCytoplasmic_socs3_density());
		clone.setNuclear_socs3_intensity(getNuclear_socs3_intensity());
		clone.setNuclear_socs3_density(getNuclear_socs3_density());
		clone.setCytoplasmic_junb_intensity(getCytoplasmic_junb_intensity());
		clone.setCytoplasmic_junb_density(getCytoplasmic_junb_density());
		clone.setNuclear_junb_intensity(getNuclear_junb_intensity());
		clone.setNuclear_junb_density(getNuclear_junb_density());
		clone.setCytoplasmic_stat_3_intensity(getCytoplasmic_stat_3_intensity());
		clone.setCytoplasmic_stat_3_density(getCytoplasmic_stat_3_density());
		clone.setNuclear_stat_3_intensity(getNuclear_stat_3_intensity());
		clone.setNuclear_stat_3_density(getNuclear_stat_3_density());
		clone.setCytoplasmic_stat_5a_intensity(getCytoplasmic_stat_5a_intensity());
		clone.setCytoplasmic_stat_5a_density(getCytoplasmic_stat_5a_density());
		clone.setNuclear_stat_5a_intensity(getNuclear_stat_5a_intensity());
		clone.setNuclear_stat_5a_density(getNuclear_stat_5a_density());
		clone.setCytoplasmic_stat_5b_intensity(getCytoplasmic_stat_5b_intensity());
		clone.setCytoplasmic_stat_5b_density(getCytoplasmic_stat_5b_density());
		clone.setNuclear_stat_5b_intensity(getNuclear_stat_5b_intensity());
		clone.setNuclear_stat_5b_density(getNuclear_stat_5b_density());
		clone.setCytoplasmic_eif3a_intensity(getCytoplasmic_eif3a_intensity());
		clone.setCytoplasmic_eif3a_density(getCytoplasmic_eif3a_density());
		clone.setCytoplasmic_eif3a_peter_intensity(getCytoplasmic_eif3a_peter_intensity());
		clone.setCytoplasmic_eif3a_peter_density(getCytoplasmic_eif3a_peter_density());
		clone.setCytoplasmic_itih_5_o1_intensity(getCytoplasmic_itih_5_o1_intensity());
		clone.setCytoplasmic_itih_5_o1_density(getCytoplasmic_itih_5_o1_density());
		clone.setNuclear_itih_5_o1_intensity(getNuclear_itih_5_o1_intensity());
		clone.setNuclear_itih_5_o1_density(getNuclear_itih_5_o1_density());
		clone.setCytoplasmic_itih_5_o2_intensity(getCytoplasmic_itih_5_o2_intensity());
		clone.setCytoplasmic_itih_5_o2_density(getCytoplasmic_itih_5_o2_density());
		clone.setNuclear_itih_5_o2_intensity(getNuclear_itih_5_o2_intensity());
		clone.setNuclear_itih_5_o2_density(getNuclear_itih_5_o2_density());
		clone.setCytoplasmic_imp2_2_intensity(getCytoplasmic_imp2_2_intensity());
		clone.setCytoplasmic_imp2_2_density(getCytoplasmic_imp2_2_density());
		clone.setCytoplasmic_stat_1_intensity(getCytoplasmic_stat_1_intensity());
		clone.setCytoplasmic_stat_1_density(getCytoplasmic_stat_1_density());
		clone.setNuclear_stat_1_intensity(getNuclear_stat_1_intensity());
		clone.setNuclear_stat_1_density(getNuclear_stat_1_density());
		clone.setCytoplasmic_nfkb1_intensity(getCytoplasmic_nfkb1_intensity());
		clone.setCytoplasmic_nfkb1_density(getCytoplasmic_nfkb1_density());
		clone.setNuclear_nfkb1_intensity(getNuclear_nfkb1_intensity());
		clone.setNuclear_nfkb1_density(getNuclear_nfkb1_density());
		clone.setCytoplasmic_nfkb2_intensity(getCytoplasmic_nfkb2_intensity());
		clone.setCytoplasmic_nfkb2_density(getCytoplasmic_nfkb2_density());
		clone.setNuclear_nfkb2_intensity(getNuclear_nfkb2_intensity());
		clone.setNuclear_nfkb2_density(getNuclear_nfkb2_density());
		clone.setCytoplasmic_pikb_intensity(getCytoplasmic_pikb_intensity());
		clone.setCytoplasmic_pikb_density(getCytoplasmic_pikb_density());
		clone.setCytoplasmic_phoshpo_pakt_o1_intensity(getCytoplasmic_phoshpo_pakt_o1_intensity());
		clone.setCytoplasmic_phoshpo_pakt_o1_density(getCytoplasmic_phoshpo_pakt_o1_density());
		clone.setNuclear_phoshpo_pakt_o1_intensity(getNuclear_phoshpo_pakt_o1_intensity());
		clone.setNuclear_phoshpo_pakt_o1_density(getNuclear_phoshpo_pakt_o1_density());
		clone.setCytoplasmic_phoshpo_pakt_o2_intensity(getCytoplasmic_phoshpo_pakt_o2_intensity());
		clone.setCytoplasmic_phoshpo_pakt_o2_density(getCytoplasmic_phoshpo_pakt_o2_density());
		clone.setNuclear_phoshpo_pakt_o2_intensity(getNuclear_phoshpo_pakt_o2_intensity());
		clone.setNuclear_phoshpo_pakt_o2_density(getNuclear_phoshpo_pakt_o2_density());
		clone.setCytoplasmic_phoshpo_pmtor_o1_intensity(getCytoplasmic_phoshpo_pmtor_o1_intensity());
		clone.setCytoplasmic_phoshpo_pmtor_o1_density(getCytoplasmic_phoshpo_pmtor_o1_density());
		clone.setNuclear_phoshpo_pmtor_o1_intensity(getNuclear_phoshpo_pmtor_o1_intensity());
		clone.setNuclear_phoshpo_pmtor_o1_density(getNuclear_phoshpo_pmtor_o1_density());
		clone.setCytoplasmic_phoshpo_pmtor_o2_intensity(getCytoplasmic_phoshpo_pmtor_o2_intensity());
		clone.setCytoplasmic_phoshpo_pmtor_o2_density(getCytoplasmic_phoshpo_pmtor_o2_density());
		clone.setNuclear_phoshpo_pmtor_o2_intensity(getNuclear_phoshpo_pmtor_o2_intensity());
		clone.setNuclear_phoshpo_pmtor_o2_density(getNuclear_phoshpo_pmtor_o2_density());
		clone.setCytoplasmic_phoshpo_pp70s6k_o1_density(getCytoplasmic_phoshpo_pp70s6k_o1_density());
		clone.setNuclear_phoshpo_pp70s6k_o1_intensity(getNuclear_phoshpo_pp70s6k_o1_intensity());
		clone.setNuclear_phoshpo_pp70s6k_o1_density(getNuclear_phoshpo_pp70s6k_o1_density());
		clone.setCytoplasmic_phoshpo_pp70s6k_o2_intensity(getCytoplasmic_phoshpo_pp70s6k_o2_intensity());
		clone.setCytoplasmic_phoshpo_pp70s6k_o2_density(getCytoplasmic_phoshpo_pp70s6k_o2_density());
		clone.setNuclear_phoshpo_pp70s6k_o2_intensity(getNuclear_phoshpo_pp70s6k_o2_intensity());
		clone.setNuclear_phoshpo_pp70s6k_o2_density(getNuclear_phoshpo_pp70s6k_o2_density());
		clone.setCytoplasmic_phoshpo_pp70s6k_o1_intensity(getCytoplasmic_phoshpo_pp70s6k_o1_intensity());
		clone.setCytoplasmic_phoshpo_pten_o1_intensity(getCytoplasmic_phoshpo_pten_o1_intensity());
		clone.setCytoplasmic_phoshpo_pten_o1_density(getCytoplasmic_phoshpo_pten_o1_density());
		clone.setNuclear_phoshpo_pten_o1_intensity(getNuclear_phoshpo_pten_o1_intensity());
		clone.setNuclear_phoshpo_pten_o1_density(getNuclear_phoshpo_pten_o1_density());
		clone.setCytoplasmic_phoshpo_pten_o2_intensity(getCytoplasmic_phoshpo_pten_o2_intensity());
		clone.setCytoplasmic_phoshpo_pten_o2_density(getCytoplasmic_phoshpo_pten_o2_density());
		clone.setNuclear_phoshpo_pten_o2_intensity(getNuclear_phoshpo_pten_o2_intensity());
		clone.setNuclear_phoshpo_pten_o2_density(getNuclear_phoshpo_pten_o2_density());

		return clone;
	}

	@Override
	public int compareTo(TMA tma) {
		long primaryKey = tma.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TMAClp)) {
			return false;
		}

		TMAClp tma = (TMAClp)obj;

		long primaryKey = tma.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(225);

		sb.append("{tma_Id=");
		sb.append(getTma_Id());
		sb.append(", sample_id=");
		sb.append(getSample_id());
		sb.append(", tma_name=");
		sb.append(getTma_name());
		sb.append(", tma_number=");
		sb.append(getTma_number());
		sb.append(", tma_comment=");
		sb.append(getTma_comment());
		sb.append(", cytoplasmic_stat_5_intensity=");
		sb.append(getCytoplasmic_stat_5_intensity());
		sb.append(", cytoplasmic_stat_5_density=");
		sb.append(getCytoplasmic_stat_5_density());
		sb.append(", nuclear_stat_5_intensity=");
		sb.append(getNuclear_stat_5_intensity());
		sb.append(", nuclear_stat_5_density=");
		sb.append(getNuclear_stat_5_density());
		sb.append(", cytoplasmic_cjun_intensity=");
		sb.append(getCytoplasmic_cjun_intensity());
		sb.append(", cytoplasmic_cjun_density=");
		sb.append(getCytoplasmic_cjun_density());
		sb.append(", nuclear_cjun_intensity=");
		sb.append(getNuclear_cjun_intensity());
		sb.append(", nuclear_cjun_density=");
		sb.append(getNuclear_cjun_density());
		sb.append(", cytoplasmic_pstat_3_intensity=");
		sb.append(getCytoplasmic_pstat_3_intensity());
		sb.append(", cytoplasmic_pstat_3_density=");
		sb.append(getCytoplasmic_pstat_3_density());
		sb.append(", nuclear_pstat_3_intensity=");
		sb.append(getNuclear_pstat_3_intensity());
		sb.append(", nuclear_pstat_3_density=");
		sb.append(getNuclear_pstat_3_density());
		sb.append(", cytoplasmic_pstat_5_intensity=");
		sb.append(getCytoplasmic_pstat_5_intensity());
		sb.append(", cytoplasmic_pstat_5_density=");
		sb.append(getCytoplasmic_pstat_5_density());
		sb.append(", nuclear_pstat_5_intensity=");
		sb.append(getNuclear_pstat_5_intensity());
		sb.append(", nuclear_pstat_5_density=");
		sb.append(getNuclear_pstat_5_density());
		sb.append(", cytoplasmic_pstat_1_intensity=");
		sb.append(getCytoplasmic_pstat_1_intensity());
		sb.append(", cytoplasmic_pstat_1_density=");
		sb.append(getCytoplasmic_pstat_1_density());
		sb.append(", nuclear_pstat_1_intensity=");
		sb.append(getNuclear_pstat_1_intensity());
		sb.append(", cytoplasmic_il6r_intensity=");
		sb.append(getCytoplasmic_il6r_intensity());
		sb.append(", cytoplasmic_il6r_density=");
		sb.append(getCytoplasmic_il6r_density());
		sb.append(", nuclear_il6r_intensity=");
		sb.append(getNuclear_il6r_intensity());
		sb.append(", nuclear_il6r_density=");
		sb.append(getNuclear_il6r_density());
		sb.append(", cytoplasmic_socs1_intensity=");
		sb.append(getCytoplasmic_socs1_intensity());
		sb.append(", cytoplasmic_socs1_density=");
		sb.append(getCytoplasmic_socs1_density());
		sb.append(", nuclear_socs1_intensity=");
		sb.append(getNuclear_socs1_intensity());
		sb.append(", nuclear_socs1_density=");
		sb.append(getNuclear_socs1_density());
		sb.append(", cytoplasmic_socs3_intensity=");
		sb.append(getCytoplasmic_socs3_intensity());
		sb.append(", cytoplasmic_socs3_density=");
		sb.append(getCytoplasmic_socs3_density());
		sb.append(", nuclear_socs3_intensity=");
		sb.append(getNuclear_socs3_intensity());
		sb.append(", nuclear_socs3_density=");
		sb.append(getNuclear_socs3_density());
		sb.append(", cytoplasmic_junb_intensity=");
		sb.append(getCytoplasmic_junb_intensity());
		sb.append(", cytoplasmic_junb_density=");
		sb.append(getCytoplasmic_junb_density());
		sb.append(", nuclear_junb_intensity=");
		sb.append(getNuclear_junb_intensity());
		sb.append(", nuclear_junb_density=");
		sb.append(getNuclear_junb_density());
		sb.append(", cytoplasmic_stat_3_intensity=");
		sb.append(getCytoplasmic_stat_3_intensity());
		sb.append(", cytoplasmic_stat_3_density=");
		sb.append(getCytoplasmic_stat_3_density());
		sb.append(", nuclear_stat_3_intensity=");
		sb.append(getNuclear_stat_3_intensity());
		sb.append(", nuclear_stat_3_density=");
		sb.append(getNuclear_stat_3_density());
		sb.append(", cytoplasmic_stat_5a_intensity=");
		sb.append(getCytoplasmic_stat_5a_intensity());
		sb.append(", cytoplasmic_stat_5a_density=");
		sb.append(getCytoplasmic_stat_5a_density());
		sb.append(", nuclear_stat_5a_intensity=");
		sb.append(getNuclear_stat_5a_intensity());
		sb.append(", nuclear_stat_5a_density=");
		sb.append(getNuclear_stat_5a_density());
		sb.append(", cytoplasmic_stat_5b_intensity=");
		sb.append(getCytoplasmic_stat_5b_intensity());
		sb.append(", cytoplasmic_stat_5b_density=");
		sb.append(getCytoplasmic_stat_5b_density());
		sb.append(", nuclear_stat_5b_intensity=");
		sb.append(getNuclear_stat_5b_intensity());
		sb.append(", nuclear_stat_5b_density=");
		sb.append(getNuclear_stat_5b_density());
		sb.append(", cytoplasmic_eif3a_intensity=");
		sb.append(getCytoplasmic_eif3a_intensity());
		sb.append(", cytoplasmic_eif3a_density=");
		sb.append(getCytoplasmic_eif3a_density());
		sb.append(", cytoplasmic_eif3a_peter_intensity=");
		sb.append(getCytoplasmic_eif3a_peter_intensity());
		sb.append(", cytoplasmic_eif3a_peter_density=");
		sb.append(getCytoplasmic_eif3a_peter_density());
		sb.append(", cytoplasmic_itih_5_o1_intensity=");
		sb.append(getCytoplasmic_itih_5_o1_intensity());
		sb.append(", cytoplasmic_itih_5_o1_density=");
		sb.append(getCytoplasmic_itih_5_o1_density());
		sb.append(", nuclear_itih_5_o1_intensity=");
		sb.append(getNuclear_itih_5_o1_intensity());
		sb.append(", nuclear_itih_5_o1_density=");
		sb.append(getNuclear_itih_5_o1_density());
		sb.append(", cytoplasmic_itih_5_o2_intensity=");
		sb.append(getCytoplasmic_itih_5_o2_intensity());
		sb.append(", cytoplasmic_itih_5_o2_density=");
		sb.append(getCytoplasmic_itih_5_o2_density());
		sb.append(", nuclear_itih_5_o2_intensity=");
		sb.append(getNuclear_itih_5_o2_intensity());
		sb.append(", nuclear_itih_5_o2_density=");
		sb.append(getNuclear_itih_5_o2_density());
		sb.append(", cytoplasmic_imp2_2_intensity=");
		sb.append(getCytoplasmic_imp2_2_intensity());
		sb.append(", cytoplasmic_imp2_2_density=");
		sb.append(getCytoplasmic_imp2_2_density());
		sb.append(", cytoplasmic_stat_1_intensity=");
		sb.append(getCytoplasmic_stat_1_intensity());
		sb.append(", cytoplasmic_stat_1_density=");
		sb.append(getCytoplasmic_stat_1_density());
		sb.append(", nuclear_stat_1_intensity=");
		sb.append(getNuclear_stat_1_intensity());
		sb.append(", nuclear_stat_1_density=");
		sb.append(getNuclear_stat_1_density());
		sb.append(", cytoplasmic_nfkb1_intensity=");
		sb.append(getCytoplasmic_nfkb1_intensity());
		sb.append(", cytoplasmic_nfkb1_density=");
		sb.append(getCytoplasmic_nfkb1_density());
		sb.append(", nuclear_nfkb1_intensity=");
		sb.append(getNuclear_nfkb1_intensity());
		sb.append(", nuclear_nfkb1_density=");
		sb.append(getNuclear_nfkb1_density());
		sb.append(", cytoplasmic_nfkb2_intensity=");
		sb.append(getCytoplasmic_nfkb2_intensity());
		sb.append(", cytoplasmic_nfkb2_density=");
		sb.append(getCytoplasmic_nfkb2_density());
		sb.append(", nuclear_nfkb2_intensity=");
		sb.append(getNuclear_nfkb2_intensity());
		sb.append(", nuclear_nfkb2_density=");
		sb.append(getNuclear_nfkb2_density());
		sb.append(", cytoplasmic_pikb_intensity=");
		sb.append(getCytoplasmic_pikb_intensity());
		sb.append(", cytoplasmic_pikb_density=");
		sb.append(getCytoplasmic_pikb_density());
		sb.append(", cytoplasmic_phoshpo_pakt_o1_intensity=");
		sb.append(getCytoplasmic_phoshpo_pakt_o1_intensity());
		sb.append(", cytoplasmic_phoshpo_pakt_o1_density=");
		sb.append(getCytoplasmic_phoshpo_pakt_o1_density());
		sb.append(", nuclear_phoshpo_pakt_o1_intensity=");
		sb.append(getNuclear_phoshpo_pakt_o1_intensity());
		sb.append(", nuclear_phoshpo_pakt_o1_density=");
		sb.append(getNuclear_phoshpo_pakt_o1_density());
		sb.append(", cytoplasmic_phoshpo_pakt_o2_intensity=");
		sb.append(getCytoplasmic_phoshpo_pakt_o2_intensity());
		sb.append(", cytoplasmic_phoshpo_pakt_o2_density=");
		sb.append(getCytoplasmic_phoshpo_pakt_o2_density());
		sb.append(", nuclear_phoshpo_pakt_o2_intensity=");
		sb.append(getNuclear_phoshpo_pakt_o2_intensity());
		sb.append(", nuclear_phoshpo_pakt_o2_density=");
		sb.append(getNuclear_phoshpo_pakt_o2_density());
		sb.append(", cytoplasmic_phoshpo_pmtor_o1_intensity=");
		sb.append(getCytoplasmic_phoshpo_pmtor_o1_intensity());
		sb.append(", cytoplasmic_phoshpo_pmtor_o1_density=");
		sb.append(getCytoplasmic_phoshpo_pmtor_o1_density());
		sb.append(", nuclear_phoshpo_pmtor_o1_intensity=");
		sb.append(getNuclear_phoshpo_pmtor_o1_intensity());
		sb.append(", nuclear_phoshpo_pmtor_o1_density=");
		sb.append(getNuclear_phoshpo_pmtor_o1_density());
		sb.append(", cytoplasmic_phoshpo_pmtor_o2_intensity=");
		sb.append(getCytoplasmic_phoshpo_pmtor_o2_intensity());
		sb.append(", cytoplasmic_phoshpo_pmtor_o2_density=");
		sb.append(getCytoplasmic_phoshpo_pmtor_o2_density());
		sb.append(", nuclear_phoshpo_pmtor_o2_intensity=");
		sb.append(getNuclear_phoshpo_pmtor_o2_intensity());
		sb.append(", nuclear_phoshpo_pmtor_o2_density=");
		sb.append(getNuclear_phoshpo_pmtor_o2_density());
		sb.append(", cytoplasmic_phoshpo_pp70s6k_o1_density=");
		sb.append(getCytoplasmic_phoshpo_pp70s6k_o1_density());
		sb.append(", nuclear_phoshpo_pp70s6k_o1_intensity=");
		sb.append(getNuclear_phoshpo_pp70s6k_o1_intensity());
		sb.append(", nuclear_phoshpo_pp70s6k_o1_density=");
		sb.append(getNuclear_phoshpo_pp70s6k_o1_density());
		sb.append(", cytoplasmic_phoshpo_pp70s6k_o2_intensity=");
		sb.append(getCytoplasmic_phoshpo_pp70s6k_o2_intensity());
		sb.append(", cytoplasmic_phoshpo_pp70s6k_o2_density=");
		sb.append(getCytoplasmic_phoshpo_pp70s6k_o2_density());
		sb.append(", nuclear_phoshpo_pp70s6k_o2_intensity=");
		sb.append(getNuclear_phoshpo_pp70s6k_o2_intensity());
		sb.append(", nuclear_phoshpo_pp70s6k_o2_density=");
		sb.append(getNuclear_phoshpo_pp70s6k_o2_density());
		sb.append(", cytoplasmic_phoshpo_pp70s6k_o1_intensity=");
		sb.append(getCytoplasmic_phoshpo_pp70s6k_o1_intensity());
		sb.append(", cytoplasmic_phoshpo_pten_o1_intensity=");
		sb.append(getCytoplasmic_phoshpo_pten_o1_intensity());
		sb.append(", cytoplasmic_phoshpo_pten_o1_density=");
		sb.append(getCytoplasmic_phoshpo_pten_o1_density());
		sb.append(", nuclear_phoshpo_pten_o1_intensity=");
		sb.append(getNuclear_phoshpo_pten_o1_intensity());
		sb.append(", nuclear_phoshpo_pten_o1_density=");
		sb.append(getNuclear_phoshpo_pten_o1_density());
		sb.append(", cytoplasmic_phoshpo_pten_o2_intensity=");
		sb.append(getCytoplasmic_phoshpo_pten_o2_intensity());
		sb.append(", cytoplasmic_phoshpo_pten_o2_density=");
		sb.append(getCytoplasmic_phoshpo_pten_o2_density());
		sb.append(", nuclear_phoshpo_pten_o2_intensity=");
		sb.append(getNuclear_phoshpo_pten_o2_intensity());
		sb.append(", nuclear_phoshpo_pten_o2_density=");
		sb.append(getNuclear_phoshpo_pten_o2_density());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(340);

		sb.append("<model><model-name>");
		sb.append("at.meduni.graz.patho.haybaeck.model.TMA");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tma_Id</column-name><column-value><![CDATA[");
		sb.append(getTma_Id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sample_id</column-name><column-value><![CDATA[");
		sb.append(getSample_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tma_name</column-name><column-value><![CDATA[");
		sb.append(getTma_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tma_number</column-name><column-value><![CDATA[");
		sb.append(getTma_number());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tma_comment</column-name><column-value><![CDATA[");
		sb.append(getTma_comment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_stat_5_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_stat_5_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_stat_5_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_stat_5_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_stat_5_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_stat_5_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_stat_5_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_stat_5_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_cjun_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_cjun_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_cjun_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_cjun_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_cjun_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_cjun_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_cjun_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_cjun_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_pstat_3_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_pstat_3_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_pstat_3_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_pstat_3_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_pstat_3_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_pstat_3_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_pstat_3_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_pstat_3_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_pstat_5_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_pstat_5_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_pstat_5_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_pstat_5_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_pstat_5_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_pstat_5_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_pstat_5_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_pstat_5_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_pstat_1_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_pstat_1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_pstat_1_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_pstat_1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_pstat_1_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_pstat_1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_il6r_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_il6r_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_il6r_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_il6r_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_il6r_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_il6r_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_il6r_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_il6r_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_socs1_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_socs1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_socs1_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_socs1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_socs1_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_socs1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_socs1_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_socs1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_socs3_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_socs3_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_socs3_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_socs3_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_socs3_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_socs3_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_socs3_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_socs3_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_junb_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_junb_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_junb_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_junb_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_junb_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_junb_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_junb_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_junb_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_stat_3_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_stat_3_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_stat_3_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_stat_3_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_stat_3_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_stat_3_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_stat_3_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_stat_3_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_stat_5a_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_stat_5a_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_stat_5a_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_stat_5a_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_stat_5a_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_stat_5a_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_stat_5a_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_stat_5a_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_stat_5b_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_stat_5b_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_stat_5b_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_stat_5b_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_stat_5b_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_stat_5b_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_stat_5b_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_stat_5b_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_eif3a_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_eif3a_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_eif3a_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_eif3a_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_eif3a_peter_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_eif3a_peter_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_eif3a_peter_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_eif3a_peter_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_itih_5_o1_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_itih_5_o1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_itih_5_o1_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_itih_5_o1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_itih_5_o1_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_itih_5_o1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_itih_5_o1_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_itih_5_o1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_itih_5_o2_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_itih_5_o2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_itih_5_o2_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_itih_5_o2_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_itih_5_o2_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_itih_5_o2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_itih_5_o2_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_itih_5_o2_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_imp2_2_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_imp2_2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_imp2_2_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_imp2_2_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_stat_1_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_stat_1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_stat_1_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_stat_1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_stat_1_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_stat_1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_stat_1_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_stat_1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_nfkb1_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_nfkb1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_nfkb1_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_nfkb1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_nfkb1_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_nfkb1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_nfkb1_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_nfkb1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_nfkb2_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_nfkb2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_nfkb2_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_nfkb2_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_nfkb2_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_nfkb2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_nfkb2_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_nfkb2_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_pikb_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_pikb_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_pikb_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_pikb_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pakt_o1_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pakt_o1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pakt_o1_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pakt_o1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pakt_o1_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pakt_o1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pakt_o1_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pakt_o1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pakt_o2_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pakt_o2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pakt_o2_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pakt_o2_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pakt_o2_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pakt_o2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pakt_o2_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pakt_o2_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pmtor_o1_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pmtor_o1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pmtor_o1_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pmtor_o1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pmtor_o1_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pmtor_o1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pmtor_o1_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pmtor_o1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pmtor_o2_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pmtor_o2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pmtor_o2_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pmtor_o2_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pmtor_o2_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pmtor_o2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pmtor_o2_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pmtor_o2_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pp70s6k_o1_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pp70s6k_o1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pp70s6k_o1_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pp70s6k_o1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pp70s6k_o1_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pp70s6k_o1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pp70s6k_o2_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pp70s6k_o2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pp70s6k_o2_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pp70s6k_o2_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pp70s6k_o2_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pp70s6k_o2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pp70s6k_o2_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pp70s6k_o2_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pp70s6k_o1_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pp70s6k_o1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pten_o1_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pten_o1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pten_o1_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pten_o1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pten_o1_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pten_o1_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pten_o1_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pten_o1_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pten_o2_intensity</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pten_o2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cytoplasmic_phoshpo_pten_o2_density</column-name><column-value><![CDATA[");
		sb.append(getCytoplasmic_phoshpo_pten_o2_density());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pten_o2_intensity</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pten_o2_intensity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuclear_phoshpo_pten_o2_density</column-name><column-value><![CDATA[");
		sb.append(getNuclear_phoshpo_pten_o2_density());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _tmaRemoteModel;
}