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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TMA}.
 * </p>
 *
 * @author reihsr
 * @see TMA
 * @generated
 */
public class TMAWrapper implements TMA, ModelWrapper<TMA> {
	public TMAWrapper(TMA tma) {
		_tma = tma;
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

	/**
	* Returns the primary key of this t m a.
	*
	* @return the primary key of this t m a
	*/
	@Override
	public long getPrimaryKey() {
		return _tma.getPrimaryKey();
	}

	/**
	* Sets the primary key of this t m a.
	*
	* @param primaryKey the primary key of this t m a
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tma.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tma_ ID of this t m a.
	*
	* @return the tma_ ID of this t m a
	*/
	@Override
	public long getTma_Id() {
		return _tma.getTma_Id();
	}

	/**
	* Sets the tma_ ID of this t m a.
	*
	* @param tma_Id the tma_ ID of this t m a
	*/
	@Override
	public void setTma_Id(long tma_Id) {
		_tma.setTma_Id(tma_Id);
	}

	/**
	* Returns the sample_id of this t m a.
	*
	* @return the sample_id of this t m a
	*/
	@Override
	public long getSample_id() {
		return _tma.getSample_id();
	}

	/**
	* Sets the sample_id of this t m a.
	*
	* @param sample_id the sample_id of this t m a
	*/
	@Override
	public void setSample_id(long sample_id) {
		_tma.setSample_id(sample_id);
	}

	/**
	* Returns the tma_name of this t m a.
	*
	* @return the tma_name of this t m a
	*/
	@Override
	public java.lang.String getTma_name() {
		return _tma.getTma_name();
	}

	/**
	* Sets the tma_name of this t m a.
	*
	* @param tma_name the tma_name of this t m a
	*/
	@Override
	public void setTma_name(java.lang.String tma_name) {
		_tma.setTma_name(tma_name);
	}

	/**
	* Returns the tma_number of this t m a.
	*
	* @return the tma_number of this t m a
	*/
	@Override
	public java.lang.String getTma_number() {
		return _tma.getTma_number();
	}

	/**
	* Sets the tma_number of this t m a.
	*
	* @param tma_number the tma_number of this t m a
	*/
	@Override
	public void setTma_number(java.lang.String tma_number) {
		_tma.setTma_number(tma_number);
	}

	/**
	* Returns the tma_comment of this t m a.
	*
	* @return the tma_comment of this t m a
	*/
	@Override
	public java.lang.String getTma_comment() {
		return _tma.getTma_comment();
	}

	/**
	* Sets the tma_comment of this t m a.
	*
	* @param tma_comment the tma_comment of this t m a
	*/
	@Override
	public void setTma_comment(java.lang.String tma_comment) {
		_tma.setTma_comment(tma_comment);
	}

	/**
	* Returns the cytoplasmic_stat_5_intensity of this t m a.
	*
	* @return the cytoplasmic_stat_5_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_stat_5_intensity() {
		return _tma.getCytoplasmic_stat_5_intensity();
	}

	/**
	* Sets the cytoplasmic_stat_5_intensity of this t m a.
	*
	* @param cytoplasmic_stat_5_intensity the cytoplasmic_stat_5_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_stat_5_intensity(
		long cytoplasmic_stat_5_intensity) {
		_tma.setCytoplasmic_stat_5_intensity(cytoplasmic_stat_5_intensity);
	}

	/**
	* Returns the cytoplasmic_stat_5_density of this t m a.
	*
	* @return the cytoplasmic_stat_5_density of this t m a
	*/
	@Override
	public long getCytoplasmic_stat_5_density() {
		return _tma.getCytoplasmic_stat_5_density();
	}

	/**
	* Sets the cytoplasmic_stat_5_density of this t m a.
	*
	* @param cytoplasmic_stat_5_density the cytoplasmic_stat_5_density of this t m a
	*/
	@Override
	public void setCytoplasmic_stat_5_density(long cytoplasmic_stat_5_density) {
		_tma.setCytoplasmic_stat_5_density(cytoplasmic_stat_5_density);
	}

	/**
	* Returns the nuclear_stat_5_intensity of this t m a.
	*
	* @return the nuclear_stat_5_intensity of this t m a
	*/
	@Override
	public long getNuclear_stat_5_intensity() {
		return _tma.getNuclear_stat_5_intensity();
	}

	/**
	* Sets the nuclear_stat_5_intensity of this t m a.
	*
	* @param nuclear_stat_5_intensity the nuclear_stat_5_intensity of this t m a
	*/
	@Override
	public void setNuclear_stat_5_intensity(long nuclear_stat_5_intensity) {
		_tma.setNuclear_stat_5_intensity(nuclear_stat_5_intensity);
	}

	/**
	* Returns the nuclear_stat_5_density of this t m a.
	*
	* @return the nuclear_stat_5_density of this t m a
	*/
	@Override
	public long getNuclear_stat_5_density() {
		return _tma.getNuclear_stat_5_density();
	}

	/**
	* Sets the nuclear_stat_5_density of this t m a.
	*
	* @param nuclear_stat_5_density the nuclear_stat_5_density of this t m a
	*/
	@Override
	public void setNuclear_stat_5_density(long nuclear_stat_5_density) {
		_tma.setNuclear_stat_5_density(nuclear_stat_5_density);
	}

	/**
	* Returns the cytoplasmic_cjun_intensity of this t m a.
	*
	* @return the cytoplasmic_cjun_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_cjun_intensity() {
		return _tma.getCytoplasmic_cjun_intensity();
	}

	/**
	* Sets the cytoplasmic_cjun_intensity of this t m a.
	*
	* @param cytoplasmic_cjun_intensity the cytoplasmic_cjun_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_cjun_intensity(long cytoplasmic_cjun_intensity) {
		_tma.setCytoplasmic_cjun_intensity(cytoplasmic_cjun_intensity);
	}

	/**
	* Returns the cytoplasmic_cjun_density of this t m a.
	*
	* @return the cytoplasmic_cjun_density of this t m a
	*/
	@Override
	public long getCytoplasmic_cjun_density() {
		return _tma.getCytoplasmic_cjun_density();
	}

	/**
	* Sets the cytoplasmic_cjun_density of this t m a.
	*
	* @param cytoplasmic_cjun_density the cytoplasmic_cjun_density of this t m a
	*/
	@Override
	public void setCytoplasmic_cjun_density(long cytoplasmic_cjun_density) {
		_tma.setCytoplasmic_cjun_density(cytoplasmic_cjun_density);
	}

	/**
	* Returns the nuclear_cjun_intensity of this t m a.
	*
	* @return the nuclear_cjun_intensity of this t m a
	*/
	@Override
	public long getNuclear_cjun_intensity() {
		return _tma.getNuclear_cjun_intensity();
	}

	/**
	* Sets the nuclear_cjun_intensity of this t m a.
	*
	* @param nuclear_cjun_intensity the nuclear_cjun_intensity of this t m a
	*/
	@Override
	public void setNuclear_cjun_intensity(long nuclear_cjun_intensity) {
		_tma.setNuclear_cjun_intensity(nuclear_cjun_intensity);
	}

	/**
	* Returns the nuclear_cjun_density of this t m a.
	*
	* @return the nuclear_cjun_density of this t m a
	*/
	@Override
	public long getNuclear_cjun_density() {
		return _tma.getNuclear_cjun_density();
	}

	/**
	* Sets the nuclear_cjun_density of this t m a.
	*
	* @param nuclear_cjun_density the nuclear_cjun_density of this t m a
	*/
	@Override
	public void setNuclear_cjun_density(long nuclear_cjun_density) {
		_tma.setNuclear_cjun_density(nuclear_cjun_density);
	}

	/**
	* Returns the cytoplasmic_pstat_3_intensity of this t m a.
	*
	* @return the cytoplasmic_pstat_3_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_pstat_3_intensity() {
		return _tma.getCytoplasmic_pstat_3_intensity();
	}

	/**
	* Sets the cytoplasmic_pstat_3_intensity of this t m a.
	*
	* @param cytoplasmic_pstat_3_intensity the cytoplasmic_pstat_3_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_pstat_3_intensity(
		long cytoplasmic_pstat_3_intensity) {
		_tma.setCytoplasmic_pstat_3_intensity(cytoplasmic_pstat_3_intensity);
	}

	/**
	* Returns the cytoplasmic_pstat_3_density of this t m a.
	*
	* @return the cytoplasmic_pstat_3_density of this t m a
	*/
	@Override
	public long getCytoplasmic_pstat_3_density() {
		return _tma.getCytoplasmic_pstat_3_density();
	}

	/**
	* Sets the cytoplasmic_pstat_3_density of this t m a.
	*
	* @param cytoplasmic_pstat_3_density the cytoplasmic_pstat_3_density of this t m a
	*/
	@Override
	public void setCytoplasmic_pstat_3_density(long cytoplasmic_pstat_3_density) {
		_tma.setCytoplasmic_pstat_3_density(cytoplasmic_pstat_3_density);
	}

	/**
	* Returns the nuclear_pstat_3_intensity of this t m a.
	*
	* @return the nuclear_pstat_3_intensity of this t m a
	*/
	@Override
	public long getNuclear_pstat_3_intensity() {
		return _tma.getNuclear_pstat_3_intensity();
	}

	/**
	* Sets the nuclear_pstat_3_intensity of this t m a.
	*
	* @param nuclear_pstat_3_intensity the nuclear_pstat_3_intensity of this t m a
	*/
	@Override
	public void setNuclear_pstat_3_intensity(long nuclear_pstat_3_intensity) {
		_tma.setNuclear_pstat_3_intensity(nuclear_pstat_3_intensity);
	}

	/**
	* Returns the nuclear_pstat_3_density of this t m a.
	*
	* @return the nuclear_pstat_3_density of this t m a
	*/
	@Override
	public long getNuclear_pstat_3_density() {
		return _tma.getNuclear_pstat_3_density();
	}

	/**
	* Sets the nuclear_pstat_3_density of this t m a.
	*
	* @param nuclear_pstat_3_density the nuclear_pstat_3_density of this t m a
	*/
	@Override
	public void setNuclear_pstat_3_density(long nuclear_pstat_3_density) {
		_tma.setNuclear_pstat_3_density(nuclear_pstat_3_density);
	}

	/**
	* Returns the cytoplasmic_pstat_5_intensity of this t m a.
	*
	* @return the cytoplasmic_pstat_5_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_pstat_5_intensity() {
		return _tma.getCytoplasmic_pstat_5_intensity();
	}

	/**
	* Sets the cytoplasmic_pstat_5_intensity of this t m a.
	*
	* @param cytoplasmic_pstat_5_intensity the cytoplasmic_pstat_5_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_pstat_5_intensity(
		long cytoplasmic_pstat_5_intensity) {
		_tma.setCytoplasmic_pstat_5_intensity(cytoplasmic_pstat_5_intensity);
	}

	/**
	* Returns the cytoplasmic_pstat_5_density of this t m a.
	*
	* @return the cytoplasmic_pstat_5_density of this t m a
	*/
	@Override
	public long getCytoplasmic_pstat_5_density() {
		return _tma.getCytoplasmic_pstat_5_density();
	}

	/**
	* Sets the cytoplasmic_pstat_5_density of this t m a.
	*
	* @param cytoplasmic_pstat_5_density the cytoplasmic_pstat_5_density of this t m a
	*/
	@Override
	public void setCytoplasmic_pstat_5_density(long cytoplasmic_pstat_5_density) {
		_tma.setCytoplasmic_pstat_5_density(cytoplasmic_pstat_5_density);
	}

	/**
	* Returns the nuclear_pstat_5_intensity of this t m a.
	*
	* @return the nuclear_pstat_5_intensity of this t m a
	*/
	@Override
	public long getNuclear_pstat_5_intensity() {
		return _tma.getNuclear_pstat_5_intensity();
	}

	/**
	* Sets the nuclear_pstat_5_intensity of this t m a.
	*
	* @param nuclear_pstat_5_intensity the nuclear_pstat_5_intensity of this t m a
	*/
	@Override
	public void setNuclear_pstat_5_intensity(long nuclear_pstat_5_intensity) {
		_tma.setNuclear_pstat_5_intensity(nuclear_pstat_5_intensity);
	}

	/**
	* Returns the nuclear_pstat_5_density of this t m a.
	*
	* @return the nuclear_pstat_5_density of this t m a
	*/
	@Override
	public long getNuclear_pstat_5_density() {
		return _tma.getNuclear_pstat_5_density();
	}

	/**
	* Sets the nuclear_pstat_5_density of this t m a.
	*
	* @param nuclear_pstat_5_density the nuclear_pstat_5_density of this t m a
	*/
	@Override
	public void setNuclear_pstat_5_density(long nuclear_pstat_5_density) {
		_tma.setNuclear_pstat_5_density(nuclear_pstat_5_density);
	}

	/**
	* Returns the cytoplasmic_pstat_1_intensity of this t m a.
	*
	* @return the cytoplasmic_pstat_1_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_pstat_1_intensity() {
		return _tma.getCytoplasmic_pstat_1_intensity();
	}

	/**
	* Sets the cytoplasmic_pstat_1_intensity of this t m a.
	*
	* @param cytoplasmic_pstat_1_intensity the cytoplasmic_pstat_1_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_pstat_1_intensity(
		long cytoplasmic_pstat_1_intensity) {
		_tma.setCytoplasmic_pstat_1_intensity(cytoplasmic_pstat_1_intensity);
	}

	/**
	* Returns the cytoplasmic_pstat_1_density of this t m a.
	*
	* @return the cytoplasmic_pstat_1_density of this t m a
	*/
	@Override
	public long getCytoplasmic_pstat_1_density() {
		return _tma.getCytoplasmic_pstat_1_density();
	}

	/**
	* Sets the cytoplasmic_pstat_1_density of this t m a.
	*
	* @param cytoplasmic_pstat_1_density the cytoplasmic_pstat_1_density of this t m a
	*/
	@Override
	public void setCytoplasmic_pstat_1_density(long cytoplasmic_pstat_1_density) {
		_tma.setCytoplasmic_pstat_1_density(cytoplasmic_pstat_1_density);
	}

	/**
	* Returns the nuclear_pstat_1_intensity of this t m a.
	*
	* @return the nuclear_pstat_1_intensity of this t m a
	*/
	@Override
	public long getNuclear_pstat_1_intensity() {
		return _tma.getNuclear_pstat_1_intensity();
	}

	/**
	* Sets the nuclear_pstat_1_intensity of this t m a.
	*
	* @param nuclear_pstat_1_intensity the nuclear_pstat_1_intensity of this t m a
	*/
	@Override
	public void setNuclear_pstat_1_intensity(long nuclear_pstat_1_intensity) {
		_tma.setNuclear_pstat_1_intensity(nuclear_pstat_1_intensity);
	}

	/**
	* Returns the cytoplasmic_il6r_intensity of this t m a.
	*
	* @return the cytoplasmic_il6r_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_il6r_intensity() {
		return _tma.getCytoplasmic_il6r_intensity();
	}

	/**
	* Sets the cytoplasmic_il6r_intensity of this t m a.
	*
	* @param cytoplasmic_il6r_intensity the cytoplasmic_il6r_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_il6r_intensity(long cytoplasmic_il6r_intensity) {
		_tma.setCytoplasmic_il6r_intensity(cytoplasmic_il6r_intensity);
	}

	/**
	* Returns the cytoplasmic_il6r_density of this t m a.
	*
	* @return the cytoplasmic_il6r_density of this t m a
	*/
	@Override
	public long getCytoplasmic_il6r_density() {
		return _tma.getCytoplasmic_il6r_density();
	}

	/**
	* Sets the cytoplasmic_il6r_density of this t m a.
	*
	* @param cytoplasmic_il6r_density the cytoplasmic_il6r_density of this t m a
	*/
	@Override
	public void setCytoplasmic_il6r_density(long cytoplasmic_il6r_density) {
		_tma.setCytoplasmic_il6r_density(cytoplasmic_il6r_density);
	}

	/**
	* Returns the nuclear_il6r_intensity of this t m a.
	*
	* @return the nuclear_il6r_intensity of this t m a
	*/
	@Override
	public long getNuclear_il6r_intensity() {
		return _tma.getNuclear_il6r_intensity();
	}

	/**
	* Sets the nuclear_il6r_intensity of this t m a.
	*
	* @param nuclear_il6r_intensity the nuclear_il6r_intensity of this t m a
	*/
	@Override
	public void setNuclear_il6r_intensity(long nuclear_il6r_intensity) {
		_tma.setNuclear_il6r_intensity(nuclear_il6r_intensity);
	}

	/**
	* Returns the nuclear_il6r_density of this t m a.
	*
	* @return the nuclear_il6r_density of this t m a
	*/
	@Override
	public long getNuclear_il6r_density() {
		return _tma.getNuclear_il6r_density();
	}

	/**
	* Sets the nuclear_il6r_density of this t m a.
	*
	* @param nuclear_il6r_density the nuclear_il6r_density of this t m a
	*/
	@Override
	public void setNuclear_il6r_density(long nuclear_il6r_density) {
		_tma.setNuclear_il6r_density(nuclear_il6r_density);
	}

	/**
	* Returns the cytoplasmic_socs1_intensity of this t m a.
	*
	* @return the cytoplasmic_socs1_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_socs1_intensity() {
		return _tma.getCytoplasmic_socs1_intensity();
	}

	/**
	* Sets the cytoplasmic_socs1_intensity of this t m a.
	*
	* @param cytoplasmic_socs1_intensity the cytoplasmic_socs1_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_socs1_intensity(long cytoplasmic_socs1_intensity) {
		_tma.setCytoplasmic_socs1_intensity(cytoplasmic_socs1_intensity);
	}

	/**
	* Returns the cytoplasmic_socs1_density of this t m a.
	*
	* @return the cytoplasmic_socs1_density of this t m a
	*/
	@Override
	public long getCytoplasmic_socs1_density() {
		return _tma.getCytoplasmic_socs1_density();
	}

	/**
	* Sets the cytoplasmic_socs1_density of this t m a.
	*
	* @param cytoplasmic_socs1_density the cytoplasmic_socs1_density of this t m a
	*/
	@Override
	public void setCytoplasmic_socs1_density(long cytoplasmic_socs1_density) {
		_tma.setCytoplasmic_socs1_density(cytoplasmic_socs1_density);
	}

	/**
	* Returns the nuclear_socs1_intensity of this t m a.
	*
	* @return the nuclear_socs1_intensity of this t m a
	*/
	@Override
	public long getNuclear_socs1_intensity() {
		return _tma.getNuclear_socs1_intensity();
	}

	/**
	* Sets the nuclear_socs1_intensity of this t m a.
	*
	* @param nuclear_socs1_intensity the nuclear_socs1_intensity of this t m a
	*/
	@Override
	public void setNuclear_socs1_intensity(long nuclear_socs1_intensity) {
		_tma.setNuclear_socs1_intensity(nuclear_socs1_intensity);
	}

	/**
	* Returns the nuclear_socs1_density of this t m a.
	*
	* @return the nuclear_socs1_density of this t m a
	*/
	@Override
	public long getNuclear_socs1_density() {
		return _tma.getNuclear_socs1_density();
	}

	/**
	* Sets the nuclear_socs1_density of this t m a.
	*
	* @param nuclear_socs1_density the nuclear_socs1_density of this t m a
	*/
	@Override
	public void setNuclear_socs1_density(long nuclear_socs1_density) {
		_tma.setNuclear_socs1_density(nuclear_socs1_density);
	}

	/**
	* Returns the cytoplasmic_socs3_intensity of this t m a.
	*
	* @return the cytoplasmic_socs3_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_socs3_intensity() {
		return _tma.getCytoplasmic_socs3_intensity();
	}

	/**
	* Sets the cytoplasmic_socs3_intensity of this t m a.
	*
	* @param cytoplasmic_socs3_intensity the cytoplasmic_socs3_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_socs3_intensity(long cytoplasmic_socs3_intensity) {
		_tma.setCytoplasmic_socs3_intensity(cytoplasmic_socs3_intensity);
	}

	/**
	* Returns the cytoplasmic_socs3_density of this t m a.
	*
	* @return the cytoplasmic_socs3_density of this t m a
	*/
	@Override
	public long getCytoplasmic_socs3_density() {
		return _tma.getCytoplasmic_socs3_density();
	}

	/**
	* Sets the cytoplasmic_socs3_density of this t m a.
	*
	* @param cytoplasmic_socs3_density the cytoplasmic_socs3_density of this t m a
	*/
	@Override
	public void setCytoplasmic_socs3_density(long cytoplasmic_socs3_density) {
		_tma.setCytoplasmic_socs3_density(cytoplasmic_socs3_density);
	}

	/**
	* Returns the nuclear_socs3_intensity of this t m a.
	*
	* @return the nuclear_socs3_intensity of this t m a
	*/
	@Override
	public long getNuclear_socs3_intensity() {
		return _tma.getNuclear_socs3_intensity();
	}

	/**
	* Sets the nuclear_socs3_intensity of this t m a.
	*
	* @param nuclear_socs3_intensity the nuclear_socs3_intensity of this t m a
	*/
	@Override
	public void setNuclear_socs3_intensity(long nuclear_socs3_intensity) {
		_tma.setNuclear_socs3_intensity(nuclear_socs3_intensity);
	}

	/**
	* Returns the nuclear_socs3_density of this t m a.
	*
	* @return the nuclear_socs3_density of this t m a
	*/
	@Override
	public long getNuclear_socs3_density() {
		return _tma.getNuclear_socs3_density();
	}

	/**
	* Sets the nuclear_socs3_density of this t m a.
	*
	* @param nuclear_socs3_density the nuclear_socs3_density of this t m a
	*/
	@Override
	public void setNuclear_socs3_density(long nuclear_socs3_density) {
		_tma.setNuclear_socs3_density(nuclear_socs3_density);
	}

	/**
	* Returns the cytoplasmic_junb_intensity of this t m a.
	*
	* @return the cytoplasmic_junb_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_junb_intensity() {
		return _tma.getCytoplasmic_junb_intensity();
	}

	/**
	* Sets the cytoplasmic_junb_intensity of this t m a.
	*
	* @param cytoplasmic_junb_intensity the cytoplasmic_junb_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_junb_intensity(long cytoplasmic_junb_intensity) {
		_tma.setCytoplasmic_junb_intensity(cytoplasmic_junb_intensity);
	}

	/**
	* Returns the cytoplasmic_junb_density of this t m a.
	*
	* @return the cytoplasmic_junb_density of this t m a
	*/
	@Override
	public long getCytoplasmic_junb_density() {
		return _tma.getCytoplasmic_junb_density();
	}

	/**
	* Sets the cytoplasmic_junb_density of this t m a.
	*
	* @param cytoplasmic_junb_density the cytoplasmic_junb_density of this t m a
	*/
	@Override
	public void setCytoplasmic_junb_density(long cytoplasmic_junb_density) {
		_tma.setCytoplasmic_junb_density(cytoplasmic_junb_density);
	}

	/**
	* Returns the nuclear_junb_intensity of this t m a.
	*
	* @return the nuclear_junb_intensity of this t m a
	*/
	@Override
	public long getNuclear_junb_intensity() {
		return _tma.getNuclear_junb_intensity();
	}

	/**
	* Sets the nuclear_junb_intensity of this t m a.
	*
	* @param nuclear_junb_intensity the nuclear_junb_intensity of this t m a
	*/
	@Override
	public void setNuclear_junb_intensity(long nuclear_junb_intensity) {
		_tma.setNuclear_junb_intensity(nuclear_junb_intensity);
	}

	/**
	* Returns the nuclear_junb_density of this t m a.
	*
	* @return the nuclear_junb_density of this t m a
	*/
	@Override
	public long getNuclear_junb_density() {
		return _tma.getNuclear_junb_density();
	}

	/**
	* Sets the nuclear_junb_density of this t m a.
	*
	* @param nuclear_junb_density the nuclear_junb_density of this t m a
	*/
	@Override
	public void setNuclear_junb_density(long nuclear_junb_density) {
		_tma.setNuclear_junb_density(nuclear_junb_density);
	}

	/**
	* Returns the cytoplasmic_stat_3_intensity of this t m a.
	*
	* @return the cytoplasmic_stat_3_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_stat_3_intensity() {
		return _tma.getCytoplasmic_stat_3_intensity();
	}

	/**
	* Sets the cytoplasmic_stat_3_intensity of this t m a.
	*
	* @param cytoplasmic_stat_3_intensity the cytoplasmic_stat_3_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_stat_3_intensity(
		long cytoplasmic_stat_3_intensity) {
		_tma.setCytoplasmic_stat_3_intensity(cytoplasmic_stat_3_intensity);
	}

	/**
	* Returns the cytoplasmic_stat_3_density of this t m a.
	*
	* @return the cytoplasmic_stat_3_density of this t m a
	*/
	@Override
	public long getCytoplasmic_stat_3_density() {
		return _tma.getCytoplasmic_stat_3_density();
	}

	/**
	* Sets the cytoplasmic_stat_3_density of this t m a.
	*
	* @param cytoplasmic_stat_3_density the cytoplasmic_stat_3_density of this t m a
	*/
	@Override
	public void setCytoplasmic_stat_3_density(long cytoplasmic_stat_3_density) {
		_tma.setCytoplasmic_stat_3_density(cytoplasmic_stat_3_density);
	}

	/**
	* Returns the nuclear_stat_3_intensity of this t m a.
	*
	* @return the nuclear_stat_3_intensity of this t m a
	*/
	@Override
	public long getNuclear_stat_3_intensity() {
		return _tma.getNuclear_stat_3_intensity();
	}

	/**
	* Sets the nuclear_stat_3_intensity of this t m a.
	*
	* @param nuclear_stat_3_intensity the nuclear_stat_3_intensity of this t m a
	*/
	@Override
	public void setNuclear_stat_3_intensity(long nuclear_stat_3_intensity) {
		_tma.setNuclear_stat_3_intensity(nuclear_stat_3_intensity);
	}

	/**
	* Returns the nuclear_stat_3_density of this t m a.
	*
	* @return the nuclear_stat_3_density of this t m a
	*/
	@Override
	public long getNuclear_stat_3_density() {
		return _tma.getNuclear_stat_3_density();
	}

	/**
	* Sets the nuclear_stat_3_density of this t m a.
	*
	* @param nuclear_stat_3_density the nuclear_stat_3_density of this t m a
	*/
	@Override
	public void setNuclear_stat_3_density(long nuclear_stat_3_density) {
		_tma.setNuclear_stat_3_density(nuclear_stat_3_density);
	}

	/**
	* Returns the cytoplasmic_stat_5a_intensity of this t m a.
	*
	* @return the cytoplasmic_stat_5a_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_stat_5a_intensity() {
		return _tma.getCytoplasmic_stat_5a_intensity();
	}

	/**
	* Sets the cytoplasmic_stat_5a_intensity of this t m a.
	*
	* @param cytoplasmic_stat_5a_intensity the cytoplasmic_stat_5a_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_stat_5a_intensity(
		long cytoplasmic_stat_5a_intensity) {
		_tma.setCytoplasmic_stat_5a_intensity(cytoplasmic_stat_5a_intensity);
	}

	/**
	* Returns the cytoplasmic_stat_5a_density of this t m a.
	*
	* @return the cytoplasmic_stat_5a_density of this t m a
	*/
	@Override
	public long getCytoplasmic_stat_5a_density() {
		return _tma.getCytoplasmic_stat_5a_density();
	}

	/**
	* Sets the cytoplasmic_stat_5a_density of this t m a.
	*
	* @param cytoplasmic_stat_5a_density the cytoplasmic_stat_5a_density of this t m a
	*/
	@Override
	public void setCytoplasmic_stat_5a_density(long cytoplasmic_stat_5a_density) {
		_tma.setCytoplasmic_stat_5a_density(cytoplasmic_stat_5a_density);
	}

	/**
	* Returns the nuclear_stat_5a_intensity of this t m a.
	*
	* @return the nuclear_stat_5a_intensity of this t m a
	*/
	@Override
	public long getNuclear_stat_5a_intensity() {
		return _tma.getNuclear_stat_5a_intensity();
	}

	/**
	* Sets the nuclear_stat_5a_intensity of this t m a.
	*
	* @param nuclear_stat_5a_intensity the nuclear_stat_5a_intensity of this t m a
	*/
	@Override
	public void setNuclear_stat_5a_intensity(long nuclear_stat_5a_intensity) {
		_tma.setNuclear_stat_5a_intensity(nuclear_stat_5a_intensity);
	}

	/**
	* Returns the nuclear_stat_5a_density of this t m a.
	*
	* @return the nuclear_stat_5a_density of this t m a
	*/
	@Override
	public long getNuclear_stat_5a_density() {
		return _tma.getNuclear_stat_5a_density();
	}

	/**
	* Sets the nuclear_stat_5a_density of this t m a.
	*
	* @param nuclear_stat_5a_density the nuclear_stat_5a_density of this t m a
	*/
	@Override
	public void setNuclear_stat_5a_density(long nuclear_stat_5a_density) {
		_tma.setNuclear_stat_5a_density(nuclear_stat_5a_density);
	}

	/**
	* Returns the cytoplasmic_stat_5b_intensity of this t m a.
	*
	* @return the cytoplasmic_stat_5b_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_stat_5b_intensity() {
		return _tma.getCytoplasmic_stat_5b_intensity();
	}

	/**
	* Sets the cytoplasmic_stat_5b_intensity of this t m a.
	*
	* @param cytoplasmic_stat_5b_intensity the cytoplasmic_stat_5b_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_stat_5b_intensity(
		long cytoplasmic_stat_5b_intensity) {
		_tma.setCytoplasmic_stat_5b_intensity(cytoplasmic_stat_5b_intensity);
	}

	/**
	* Returns the cytoplasmic_stat_5b_density of this t m a.
	*
	* @return the cytoplasmic_stat_5b_density of this t m a
	*/
	@Override
	public long getCytoplasmic_stat_5b_density() {
		return _tma.getCytoplasmic_stat_5b_density();
	}

	/**
	* Sets the cytoplasmic_stat_5b_density of this t m a.
	*
	* @param cytoplasmic_stat_5b_density the cytoplasmic_stat_5b_density of this t m a
	*/
	@Override
	public void setCytoplasmic_stat_5b_density(long cytoplasmic_stat_5b_density) {
		_tma.setCytoplasmic_stat_5b_density(cytoplasmic_stat_5b_density);
	}

	/**
	* Returns the nuclear_stat_5b_intensity of this t m a.
	*
	* @return the nuclear_stat_5b_intensity of this t m a
	*/
	@Override
	public long getNuclear_stat_5b_intensity() {
		return _tma.getNuclear_stat_5b_intensity();
	}

	/**
	* Sets the nuclear_stat_5b_intensity of this t m a.
	*
	* @param nuclear_stat_5b_intensity the nuclear_stat_5b_intensity of this t m a
	*/
	@Override
	public void setNuclear_stat_5b_intensity(long nuclear_stat_5b_intensity) {
		_tma.setNuclear_stat_5b_intensity(nuclear_stat_5b_intensity);
	}

	/**
	* Returns the nuclear_stat_5b_density of this t m a.
	*
	* @return the nuclear_stat_5b_density of this t m a
	*/
	@Override
	public long getNuclear_stat_5b_density() {
		return _tma.getNuclear_stat_5b_density();
	}

	/**
	* Sets the nuclear_stat_5b_density of this t m a.
	*
	* @param nuclear_stat_5b_density the nuclear_stat_5b_density of this t m a
	*/
	@Override
	public void setNuclear_stat_5b_density(long nuclear_stat_5b_density) {
		_tma.setNuclear_stat_5b_density(nuclear_stat_5b_density);
	}

	/**
	* Returns the cytoplasmic_eif3a_intensity of this t m a.
	*
	* @return the cytoplasmic_eif3a_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_eif3a_intensity() {
		return _tma.getCytoplasmic_eif3a_intensity();
	}

	/**
	* Sets the cytoplasmic_eif3a_intensity of this t m a.
	*
	* @param cytoplasmic_eif3a_intensity the cytoplasmic_eif3a_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_eif3a_intensity(long cytoplasmic_eif3a_intensity) {
		_tma.setCytoplasmic_eif3a_intensity(cytoplasmic_eif3a_intensity);
	}

	/**
	* Returns the cytoplasmic_eif3a_density of this t m a.
	*
	* @return the cytoplasmic_eif3a_density of this t m a
	*/
	@Override
	public long getCytoplasmic_eif3a_density() {
		return _tma.getCytoplasmic_eif3a_density();
	}

	/**
	* Sets the cytoplasmic_eif3a_density of this t m a.
	*
	* @param cytoplasmic_eif3a_density the cytoplasmic_eif3a_density of this t m a
	*/
	@Override
	public void setCytoplasmic_eif3a_density(long cytoplasmic_eif3a_density) {
		_tma.setCytoplasmic_eif3a_density(cytoplasmic_eif3a_density);
	}

	/**
	* Returns the cytoplasmic_eif3a_peter_intensity of this t m a.
	*
	* @return the cytoplasmic_eif3a_peter_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_eif3a_peter_intensity() {
		return _tma.getCytoplasmic_eif3a_peter_intensity();
	}

	/**
	* Sets the cytoplasmic_eif3a_peter_intensity of this t m a.
	*
	* @param cytoplasmic_eif3a_peter_intensity the cytoplasmic_eif3a_peter_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_eif3a_peter_intensity(
		long cytoplasmic_eif3a_peter_intensity) {
		_tma.setCytoplasmic_eif3a_peter_intensity(cytoplasmic_eif3a_peter_intensity);
	}

	/**
	* Returns the cytoplasmic_eif3a_peter_density of this t m a.
	*
	* @return the cytoplasmic_eif3a_peter_density of this t m a
	*/
	@Override
	public long getCytoplasmic_eif3a_peter_density() {
		return _tma.getCytoplasmic_eif3a_peter_density();
	}

	/**
	* Sets the cytoplasmic_eif3a_peter_density of this t m a.
	*
	* @param cytoplasmic_eif3a_peter_density the cytoplasmic_eif3a_peter_density of this t m a
	*/
	@Override
	public void setCytoplasmic_eif3a_peter_density(
		long cytoplasmic_eif3a_peter_density) {
		_tma.setCytoplasmic_eif3a_peter_density(cytoplasmic_eif3a_peter_density);
	}

	/**
	* Returns the cytoplasmic_itih_5_o1_intensity of this t m a.
	*
	* @return the cytoplasmic_itih_5_o1_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_itih_5_o1_intensity() {
		return _tma.getCytoplasmic_itih_5_o1_intensity();
	}

	/**
	* Sets the cytoplasmic_itih_5_o1_intensity of this t m a.
	*
	* @param cytoplasmic_itih_5_o1_intensity the cytoplasmic_itih_5_o1_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_itih_5_o1_intensity(
		long cytoplasmic_itih_5_o1_intensity) {
		_tma.setCytoplasmic_itih_5_o1_intensity(cytoplasmic_itih_5_o1_intensity);
	}

	/**
	* Returns the cytoplasmic_itih_5_o1_density of this t m a.
	*
	* @return the cytoplasmic_itih_5_o1_density of this t m a
	*/
	@Override
	public long getCytoplasmic_itih_5_o1_density() {
		return _tma.getCytoplasmic_itih_5_o1_density();
	}

	/**
	* Sets the cytoplasmic_itih_5_o1_density of this t m a.
	*
	* @param cytoplasmic_itih_5_o1_density the cytoplasmic_itih_5_o1_density of this t m a
	*/
	@Override
	public void setCytoplasmic_itih_5_o1_density(
		long cytoplasmic_itih_5_o1_density) {
		_tma.setCytoplasmic_itih_5_o1_density(cytoplasmic_itih_5_o1_density);
	}

	/**
	* Returns the nuclear_itih_5_o1_intensity of this t m a.
	*
	* @return the nuclear_itih_5_o1_intensity of this t m a
	*/
	@Override
	public long getNuclear_itih_5_o1_intensity() {
		return _tma.getNuclear_itih_5_o1_intensity();
	}

	/**
	* Sets the nuclear_itih_5_o1_intensity of this t m a.
	*
	* @param nuclear_itih_5_o1_intensity the nuclear_itih_5_o1_intensity of this t m a
	*/
	@Override
	public void setNuclear_itih_5_o1_intensity(long nuclear_itih_5_o1_intensity) {
		_tma.setNuclear_itih_5_o1_intensity(nuclear_itih_5_o1_intensity);
	}

	/**
	* Returns the nuclear_itih_5_o1_density of this t m a.
	*
	* @return the nuclear_itih_5_o1_density of this t m a
	*/
	@Override
	public long getNuclear_itih_5_o1_density() {
		return _tma.getNuclear_itih_5_o1_density();
	}

	/**
	* Sets the nuclear_itih_5_o1_density of this t m a.
	*
	* @param nuclear_itih_5_o1_density the nuclear_itih_5_o1_density of this t m a
	*/
	@Override
	public void setNuclear_itih_5_o1_density(long nuclear_itih_5_o1_density) {
		_tma.setNuclear_itih_5_o1_density(nuclear_itih_5_o1_density);
	}

	/**
	* Returns the cytoplasmic_itih_5_o2_intensity of this t m a.
	*
	* @return the cytoplasmic_itih_5_o2_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_itih_5_o2_intensity() {
		return _tma.getCytoplasmic_itih_5_o2_intensity();
	}

	/**
	* Sets the cytoplasmic_itih_5_o2_intensity of this t m a.
	*
	* @param cytoplasmic_itih_5_o2_intensity the cytoplasmic_itih_5_o2_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_itih_5_o2_intensity(
		long cytoplasmic_itih_5_o2_intensity) {
		_tma.setCytoplasmic_itih_5_o2_intensity(cytoplasmic_itih_5_o2_intensity);
	}

	/**
	* Returns the cytoplasmic_itih_5_o2_density of this t m a.
	*
	* @return the cytoplasmic_itih_5_o2_density of this t m a
	*/
	@Override
	public long getCytoplasmic_itih_5_o2_density() {
		return _tma.getCytoplasmic_itih_5_o2_density();
	}

	/**
	* Sets the cytoplasmic_itih_5_o2_density of this t m a.
	*
	* @param cytoplasmic_itih_5_o2_density the cytoplasmic_itih_5_o2_density of this t m a
	*/
	@Override
	public void setCytoplasmic_itih_5_o2_density(
		long cytoplasmic_itih_5_o2_density) {
		_tma.setCytoplasmic_itih_5_o2_density(cytoplasmic_itih_5_o2_density);
	}

	/**
	* Returns the nuclear_itih_5_o2_intensity of this t m a.
	*
	* @return the nuclear_itih_5_o2_intensity of this t m a
	*/
	@Override
	public long getNuclear_itih_5_o2_intensity() {
		return _tma.getNuclear_itih_5_o2_intensity();
	}

	/**
	* Sets the nuclear_itih_5_o2_intensity of this t m a.
	*
	* @param nuclear_itih_5_o2_intensity the nuclear_itih_5_o2_intensity of this t m a
	*/
	@Override
	public void setNuclear_itih_5_o2_intensity(long nuclear_itih_5_o2_intensity) {
		_tma.setNuclear_itih_5_o2_intensity(nuclear_itih_5_o2_intensity);
	}

	/**
	* Returns the nuclear_itih_5_o2_density of this t m a.
	*
	* @return the nuclear_itih_5_o2_density of this t m a
	*/
	@Override
	public long getNuclear_itih_5_o2_density() {
		return _tma.getNuclear_itih_5_o2_density();
	}

	/**
	* Sets the nuclear_itih_5_o2_density of this t m a.
	*
	* @param nuclear_itih_5_o2_density the nuclear_itih_5_o2_density of this t m a
	*/
	@Override
	public void setNuclear_itih_5_o2_density(long nuclear_itih_5_o2_density) {
		_tma.setNuclear_itih_5_o2_density(nuclear_itih_5_o2_density);
	}

	/**
	* Returns the cytoplasmic_imp2_2_intensity of this t m a.
	*
	* @return the cytoplasmic_imp2_2_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_imp2_2_intensity() {
		return _tma.getCytoplasmic_imp2_2_intensity();
	}

	/**
	* Sets the cytoplasmic_imp2_2_intensity of this t m a.
	*
	* @param cytoplasmic_imp2_2_intensity the cytoplasmic_imp2_2_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_imp2_2_intensity(
		long cytoplasmic_imp2_2_intensity) {
		_tma.setCytoplasmic_imp2_2_intensity(cytoplasmic_imp2_2_intensity);
	}

	/**
	* Returns the cytoplasmic_imp2_2_density of this t m a.
	*
	* @return the cytoplasmic_imp2_2_density of this t m a
	*/
	@Override
	public long getCytoplasmic_imp2_2_density() {
		return _tma.getCytoplasmic_imp2_2_density();
	}

	/**
	* Sets the cytoplasmic_imp2_2_density of this t m a.
	*
	* @param cytoplasmic_imp2_2_density the cytoplasmic_imp2_2_density of this t m a
	*/
	@Override
	public void setCytoplasmic_imp2_2_density(long cytoplasmic_imp2_2_density) {
		_tma.setCytoplasmic_imp2_2_density(cytoplasmic_imp2_2_density);
	}

	/**
	* Returns the cytoplasmic_stat_1_intensity of this t m a.
	*
	* @return the cytoplasmic_stat_1_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_stat_1_intensity() {
		return _tma.getCytoplasmic_stat_1_intensity();
	}

	/**
	* Sets the cytoplasmic_stat_1_intensity of this t m a.
	*
	* @param cytoplasmic_stat_1_intensity the cytoplasmic_stat_1_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_stat_1_intensity(
		long cytoplasmic_stat_1_intensity) {
		_tma.setCytoplasmic_stat_1_intensity(cytoplasmic_stat_1_intensity);
	}

	/**
	* Returns the cytoplasmic_stat_1_density of this t m a.
	*
	* @return the cytoplasmic_stat_1_density of this t m a
	*/
	@Override
	public long getCytoplasmic_stat_1_density() {
		return _tma.getCytoplasmic_stat_1_density();
	}

	/**
	* Sets the cytoplasmic_stat_1_density of this t m a.
	*
	* @param cytoplasmic_stat_1_density the cytoplasmic_stat_1_density of this t m a
	*/
	@Override
	public void setCytoplasmic_stat_1_density(long cytoplasmic_stat_1_density) {
		_tma.setCytoplasmic_stat_1_density(cytoplasmic_stat_1_density);
	}

	/**
	* Returns the nuclear_stat_1_intensity of this t m a.
	*
	* @return the nuclear_stat_1_intensity of this t m a
	*/
	@Override
	public long getNuclear_stat_1_intensity() {
		return _tma.getNuclear_stat_1_intensity();
	}

	/**
	* Sets the nuclear_stat_1_intensity of this t m a.
	*
	* @param nuclear_stat_1_intensity the nuclear_stat_1_intensity of this t m a
	*/
	@Override
	public void setNuclear_stat_1_intensity(long nuclear_stat_1_intensity) {
		_tma.setNuclear_stat_1_intensity(nuclear_stat_1_intensity);
	}

	/**
	* Returns the nuclear_stat_1_density of this t m a.
	*
	* @return the nuclear_stat_1_density of this t m a
	*/
	@Override
	public long getNuclear_stat_1_density() {
		return _tma.getNuclear_stat_1_density();
	}

	/**
	* Sets the nuclear_stat_1_density of this t m a.
	*
	* @param nuclear_stat_1_density the nuclear_stat_1_density of this t m a
	*/
	@Override
	public void setNuclear_stat_1_density(long nuclear_stat_1_density) {
		_tma.setNuclear_stat_1_density(nuclear_stat_1_density);
	}

	/**
	* Returns the cytoplasmic_nfkb1_intensity of this t m a.
	*
	* @return the cytoplasmic_nfkb1_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_nfkb1_intensity() {
		return _tma.getCytoplasmic_nfkb1_intensity();
	}

	/**
	* Sets the cytoplasmic_nfkb1_intensity of this t m a.
	*
	* @param cytoplasmic_nfkb1_intensity the cytoplasmic_nfkb1_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_nfkb1_intensity(long cytoplasmic_nfkb1_intensity) {
		_tma.setCytoplasmic_nfkb1_intensity(cytoplasmic_nfkb1_intensity);
	}

	/**
	* Returns the cytoplasmic_nfkb1_density of this t m a.
	*
	* @return the cytoplasmic_nfkb1_density of this t m a
	*/
	@Override
	public long getCytoplasmic_nfkb1_density() {
		return _tma.getCytoplasmic_nfkb1_density();
	}

	/**
	* Sets the cytoplasmic_nfkb1_density of this t m a.
	*
	* @param cytoplasmic_nfkb1_density the cytoplasmic_nfkb1_density of this t m a
	*/
	@Override
	public void setCytoplasmic_nfkb1_density(long cytoplasmic_nfkb1_density) {
		_tma.setCytoplasmic_nfkb1_density(cytoplasmic_nfkb1_density);
	}

	/**
	* Returns the nuclear_nfkb1_intensity of this t m a.
	*
	* @return the nuclear_nfkb1_intensity of this t m a
	*/
	@Override
	public long getNuclear_nfkb1_intensity() {
		return _tma.getNuclear_nfkb1_intensity();
	}

	/**
	* Sets the nuclear_nfkb1_intensity of this t m a.
	*
	* @param nuclear_nfkb1_intensity the nuclear_nfkb1_intensity of this t m a
	*/
	@Override
	public void setNuclear_nfkb1_intensity(long nuclear_nfkb1_intensity) {
		_tma.setNuclear_nfkb1_intensity(nuclear_nfkb1_intensity);
	}

	/**
	* Returns the nuclear_nfkb1_density of this t m a.
	*
	* @return the nuclear_nfkb1_density of this t m a
	*/
	@Override
	public long getNuclear_nfkb1_density() {
		return _tma.getNuclear_nfkb1_density();
	}

	/**
	* Sets the nuclear_nfkb1_density of this t m a.
	*
	* @param nuclear_nfkb1_density the nuclear_nfkb1_density of this t m a
	*/
	@Override
	public void setNuclear_nfkb1_density(long nuclear_nfkb1_density) {
		_tma.setNuclear_nfkb1_density(nuclear_nfkb1_density);
	}

	/**
	* Returns the cytoplasmic_nfkb2_intensity of this t m a.
	*
	* @return the cytoplasmic_nfkb2_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_nfkb2_intensity() {
		return _tma.getCytoplasmic_nfkb2_intensity();
	}

	/**
	* Sets the cytoplasmic_nfkb2_intensity of this t m a.
	*
	* @param cytoplasmic_nfkb2_intensity the cytoplasmic_nfkb2_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_nfkb2_intensity(long cytoplasmic_nfkb2_intensity) {
		_tma.setCytoplasmic_nfkb2_intensity(cytoplasmic_nfkb2_intensity);
	}

	/**
	* Returns the cytoplasmic_nfkb2_density of this t m a.
	*
	* @return the cytoplasmic_nfkb2_density of this t m a
	*/
	@Override
	public long getCytoplasmic_nfkb2_density() {
		return _tma.getCytoplasmic_nfkb2_density();
	}

	/**
	* Sets the cytoplasmic_nfkb2_density of this t m a.
	*
	* @param cytoplasmic_nfkb2_density the cytoplasmic_nfkb2_density of this t m a
	*/
	@Override
	public void setCytoplasmic_nfkb2_density(long cytoplasmic_nfkb2_density) {
		_tma.setCytoplasmic_nfkb2_density(cytoplasmic_nfkb2_density);
	}

	/**
	* Returns the nuclear_nfkb2_intensity of this t m a.
	*
	* @return the nuclear_nfkb2_intensity of this t m a
	*/
	@Override
	public long getNuclear_nfkb2_intensity() {
		return _tma.getNuclear_nfkb2_intensity();
	}

	/**
	* Sets the nuclear_nfkb2_intensity of this t m a.
	*
	* @param nuclear_nfkb2_intensity the nuclear_nfkb2_intensity of this t m a
	*/
	@Override
	public void setNuclear_nfkb2_intensity(long nuclear_nfkb2_intensity) {
		_tma.setNuclear_nfkb2_intensity(nuclear_nfkb2_intensity);
	}

	/**
	* Returns the nuclear_nfkb2_density of this t m a.
	*
	* @return the nuclear_nfkb2_density of this t m a
	*/
	@Override
	public long getNuclear_nfkb2_density() {
		return _tma.getNuclear_nfkb2_density();
	}

	/**
	* Sets the nuclear_nfkb2_density of this t m a.
	*
	* @param nuclear_nfkb2_density the nuclear_nfkb2_density of this t m a
	*/
	@Override
	public void setNuclear_nfkb2_density(long nuclear_nfkb2_density) {
		_tma.setNuclear_nfkb2_density(nuclear_nfkb2_density);
	}

	/**
	* Returns the cytoplasmic_pikb_intensity of this t m a.
	*
	* @return the cytoplasmic_pikb_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_pikb_intensity() {
		return _tma.getCytoplasmic_pikb_intensity();
	}

	/**
	* Sets the cytoplasmic_pikb_intensity of this t m a.
	*
	* @param cytoplasmic_pikb_intensity the cytoplasmic_pikb_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_pikb_intensity(long cytoplasmic_pikb_intensity) {
		_tma.setCytoplasmic_pikb_intensity(cytoplasmic_pikb_intensity);
	}

	/**
	* Returns the cytoplasmic_pikb_density of this t m a.
	*
	* @return the cytoplasmic_pikb_density of this t m a
	*/
	@Override
	public long getCytoplasmic_pikb_density() {
		return _tma.getCytoplasmic_pikb_density();
	}

	/**
	* Sets the cytoplasmic_pikb_density of this t m a.
	*
	* @param cytoplasmic_pikb_density the cytoplasmic_pikb_density of this t m a
	*/
	@Override
	public void setCytoplasmic_pikb_density(long cytoplasmic_pikb_density) {
		_tma.setCytoplasmic_pikb_density(cytoplasmic_pikb_density);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pakt_o1_intensity of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pakt_o1_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pakt_o1_intensity() {
		return _tma.getCytoplasmic_phoshpo_pakt_o1_intensity();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pakt_o1_intensity of this t m a.
	*
	* @param cytoplasmic_phoshpo_pakt_o1_intensity the cytoplasmic_phoshpo_pakt_o1_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pakt_o1_intensity(
		long cytoplasmic_phoshpo_pakt_o1_intensity) {
		_tma.setCytoplasmic_phoshpo_pakt_o1_intensity(cytoplasmic_phoshpo_pakt_o1_intensity);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pakt_o1_density of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pakt_o1_density of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pakt_o1_density() {
		return _tma.getCytoplasmic_phoshpo_pakt_o1_density();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pakt_o1_density of this t m a.
	*
	* @param cytoplasmic_phoshpo_pakt_o1_density the cytoplasmic_phoshpo_pakt_o1_density of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pakt_o1_density(
		long cytoplasmic_phoshpo_pakt_o1_density) {
		_tma.setCytoplasmic_phoshpo_pakt_o1_density(cytoplasmic_phoshpo_pakt_o1_density);
	}

	/**
	* Returns the nuclear_phoshpo_pakt_o1_intensity of this t m a.
	*
	* @return the nuclear_phoshpo_pakt_o1_intensity of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pakt_o1_intensity() {
		return _tma.getNuclear_phoshpo_pakt_o1_intensity();
	}

	/**
	* Sets the nuclear_phoshpo_pakt_o1_intensity of this t m a.
	*
	* @param nuclear_phoshpo_pakt_o1_intensity the nuclear_phoshpo_pakt_o1_intensity of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pakt_o1_intensity(
		long nuclear_phoshpo_pakt_o1_intensity) {
		_tma.setNuclear_phoshpo_pakt_o1_intensity(nuclear_phoshpo_pakt_o1_intensity);
	}

	/**
	* Returns the nuclear_phoshpo_pakt_o1_density of this t m a.
	*
	* @return the nuclear_phoshpo_pakt_o1_density of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pakt_o1_density() {
		return _tma.getNuclear_phoshpo_pakt_o1_density();
	}

	/**
	* Sets the nuclear_phoshpo_pakt_o1_density of this t m a.
	*
	* @param nuclear_phoshpo_pakt_o1_density the nuclear_phoshpo_pakt_o1_density of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pakt_o1_density(
		long nuclear_phoshpo_pakt_o1_density) {
		_tma.setNuclear_phoshpo_pakt_o1_density(nuclear_phoshpo_pakt_o1_density);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pakt_o2_intensity of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pakt_o2_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pakt_o2_intensity() {
		return _tma.getCytoplasmic_phoshpo_pakt_o2_intensity();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pakt_o2_intensity of this t m a.
	*
	* @param cytoplasmic_phoshpo_pakt_o2_intensity the cytoplasmic_phoshpo_pakt_o2_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pakt_o2_intensity(
		long cytoplasmic_phoshpo_pakt_o2_intensity) {
		_tma.setCytoplasmic_phoshpo_pakt_o2_intensity(cytoplasmic_phoshpo_pakt_o2_intensity);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pakt_o2_density of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pakt_o2_density of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pakt_o2_density() {
		return _tma.getCytoplasmic_phoshpo_pakt_o2_density();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pakt_o2_density of this t m a.
	*
	* @param cytoplasmic_phoshpo_pakt_o2_density the cytoplasmic_phoshpo_pakt_o2_density of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pakt_o2_density(
		long cytoplasmic_phoshpo_pakt_o2_density) {
		_tma.setCytoplasmic_phoshpo_pakt_o2_density(cytoplasmic_phoshpo_pakt_o2_density);
	}

	/**
	* Returns the nuclear_phoshpo_pakt_o2_intensity of this t m a.
	*
	* @return the nuclear_phoshpo_pakt_o2_intensity of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pakt_o2_intensity() {
		return _tma.getNuclear_phoshpo_pakt_o2_intensity();
	}

	/**
	* Sets the nuclear_phoshpo_pakt_o2_intensity of this t m a.
	*
	* @param nuclear_phoshpo_pakt_o2_intensity the nuclear_phoshpo_pakt_o2_intensity of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pakt_o2_intensity(
		long nuclear_phoshpo_pakt_o2_intensity) {
		_tma.setNuclear_phoshpo_pakt_o2_intensity(nuclear_phoshpo_pakt_o2_intensity);
	}

	/**
	* Returns the nuclear_phoshpo_pakt_o2_density of this t m a.
	*
	* @return the nuclear_phoshpo_pakt_o2_density of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pakt_o2_density() {
		return _tma.getNuclear_phoshpo_pakt_o2_density();
	}

	/**
	* Sets the nuclear_phoshpo_pakt_o2_density of this t m a.
	*
	* @param nuclear_phoshpo_pakt_o2_density the nuclear_phoshpo_pakt_o2_density of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pakt_o2_density(
		long nuclear_phoshpo_pakt_o2_density) {
		_tma.setNuclear_phoshpo_pakt_o2_density(nuclear_phoshpo_pakt_o2_density);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pmtor_o1_intensity of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pmtor_o1_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pmtor_o1_intensity() {
		return _tma.getCytoplasmic_phoshpo_pmtor_o1_intensity();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pmtor_o1_intensity of this t m a.
	*
	* @param cytoplasmic_phoshpo_pmtor_o1_intensity the cytoplasmic_phoshpo_pmtor_o1_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pmtor_o1_intensity(
		long cytoplasmic_phoshpo_pmtor_o1_intensity) {
		_tma.setCytoplasmic_phoshpo_pmtor_o1_intensity(cytoplasmic_phoshpo_pmtor_o1_intensity);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pmtor_o1_density of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pmtor_o1_density of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pmtor_o1_density() {
		return _tma.getCytoplasmic_phoshpo_pmtor_o1_density();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pmtor_o1_density of this t m a.
	*
	* @param cytoplasmic_phoshpo_pmtor_o1_density the cytoplasmic_phoshpo_pmtor_o1_density of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pmtor_o1_density(
		long cytoplasmic_phoshpo_pmtor_o1_density) {
		_tma.setCytoplasmic_phoshpo_pmtor_o1_density(cytoplasmic_phoshpo_pmtor_o1_density);
	}

	/**
	* Returns the nuclear_phoshpo_pmtor_o1_intensity of this t m a.
	*
	* @return the nuclear_phoshpo_pmtor_o1_intensity of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pmtor_o1_intensity() {
		return _tma.getNuclear_phoshpo_pmtor_o1_intensity();
	}

	/**
	* Sets the nuclear_phoshpo_pmtor_o1_intensity of this t m a.
	*
	* @param nuclear_phoshpo_pmtor_o1_intensity the nuclear_phoshpo_pmtor_o1_intensity of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pmtor_o1_intensity(
		long nuclear_phoshpo_pmtor_o1_intensity) {
		_tma.setNuclear_phoshpo_pmtor_o1_intensity(nuclear_phoshpo_pmtor_o1_intensity);
	}

	/**
	* Returns the nuclear_phoshpo_pmtor_o1_density of this t m a.
	*
	* @return the nuclear_phoshpo_pmtor_o1_density of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pmtor_o1_density() {
		return _tma.getNuclear_phoshpo_pmtor_o1_density();
	}

	/**
	* Sets the nuclear_phoshpo_pmtor_o1_density of this t m a.
	*
	* @param nuclear_phoshpo_pmtor_o1_density the nuclear_phoshpo_pmtor_o1_density of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pmtor_o1_density(
		long nuclear_phoshpo_pmtor_o1_density) {
		_tma.setNuclear_phoshpo_pmtor_o1_density(nuclear_phoshpo_pmtor_o1_density);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pmtor_o2_intensity of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pmtor_o2_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pmtor_o2_intensity() {
		return _tma.getCytoplasmic_phoshpo_pmtor_o2_intensity();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pmtor_o2_intensity of this t m a.
	*
	* @param cytoplasmic_phoshpo_pmtor_o2_intensity the cytoplasmic_phoshpo_pmtor_o2_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pmtor_o2_intensity(
		long cytoplasmic_phoshpo_pmtor_o2_intensity) {
		_tma.setCytoplasmic_phoshpo_pmtor_o2_intensity(cytoplasmic_phoshpo_pmtor_o2_intensity);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pmtor_o2_density of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pmtor_o2_density of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pmtor_o2_density() {
		return _tma.getCytoplasmic_phoshpo_pmtor_o2_density();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pmtor_o2_density of this t m a.
	*
	* @param cytoplasmic_phoshpo_pmtor_o2_density the cytoplasmic_phoshpo_pmtor_o2_density of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pmtor_o2_density(
		long cytoplasmic_phoshpo_pmtor_o2_density) {
		_tma.setCytoplasmic_phoshpo_pmtor_o2_density(cytoplasmic_phoshpo_pmtor_o2_density);
	}

	/**
	* Returns the nuclear_phoshpo_pmtor_o2_intensity of this t m a.
	*
	* @return the nuclear_phoshpo_pmtor_o2_intensity of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pmtor_o2_intensity() {
		return _tma.getNuclear_phoshpo_pmtor_o2_intensity();
	}

	/**
	* Sets the nuclear_phoshpo_pmtor_o2_intensity of this t m a.
	*
	* @param nuclear_phoshpo_pmtor_o2_intensity the nuclear_phoshpo_pmtor_o2_intensity of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pmtor_o2_intensity(
		long nuclear_phoshpo_pmtor_o2_intensity) {
		_tma.setNuclear_phoshpo_pmtor_o2_intensity(nuclear_phoshpo_pmtor_o2_intensity);
	}

	/**
	* Returns the nuclear_phoshpo_pmtor_o2_density of this t m a.
	*
	* @return the nuclear_phoshpo_pmtor_o2_density of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pmtor_o2_density() {
		return _tma.getNuclear_phoshpo_pmtor_o2_density();
	}

	/**
	* Sets the nuclear_phoshpo_pmtor_o2_density of this t m a.
	*
	* @param nuclear_phoshpo_pmtor_o2_density the nuclear_phoshpo_pmtor_o2_density of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pmtor_o2_density(
		long nuclear_phoshpo_pmtor_o2_density) {
		_tma.setNuclear_phoshpo_pmtor_o2_density(nuclear_phoshpo_pmtor_o2_density);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pp70s6k_o1_density of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pp70s6k_o1_density of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pp70s6k_o1_density() {
		return _tma.getCytoplasmic_phoshpo_pp70s6k_o1_density();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pp70s6k_o1_density of this t m a.
	*
	* @param cytoplasmic_phoshpo_pp70s6k_o1_density the cytoplasmic_phoshpo_pp70s6k_o1_density of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pp70s6k_o1_density(
		long cytoplasmic_phoshpo_pp70s6k_o1_density) {
		_tma.setCytoplasmic_phoshpo_pp70s6k_o1_density(cytoplasmic_phoshpo_pp70s6k_o1_density);
	}

	/**
	* Returns the nuclear_phoshpo_pp70s6k_o1_intensity of this t m a.
	*
	* @return the nuclear_phoshpo_pp70s6k_o1_intensity of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pp70s6k_o1_intensity() {
		return _tma.getNuclear_phoshpo_pp70s6k_o1_intensity();
	}

	/**
	* Sets the nuclear_phoshpo_pp70s6k_o1_intensity of this t m a.
	*
	* @param nuclear_phoshpo_pp70s6k_o1_intensity the nuclear_phoshpo_pp70s6k_o1_intensity of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pp70s6k_o1_intensity(
		long nuclear_phoshpo_pp70s6k_o1_intensity) {
		_tma.setNuclear_phoshpo_pp70s6k_o1_intensity(nuclear_phoshpo_pp70s6k_o1_intensity);
	}

	/**
	* Returns the nuclear_phoshpo_pp70s6k_o1_density of this t m a.
	*
	* @return the nuclear_phoshpo_pp70s6k_o1_density of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pp70s6k_o1_density() {
		return _tma.getNuclear_phoshpo_pp70s6k_o1_density();
	}

	/**
	* Sets the nuclear_phoshpo_pp70s6k_o1_density of this t m a.
	*
	* @param nuclear_phoshpo_pp70s6k_o1_density the nuclear_phoshpo_pp70s6k_o1_density of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pp70s6k_o1_density(
		long nuclear_phoshpo_pp70s6k_o1_density) {
		_tma.setNuclear_phoshpo_pp70s6k_o1_density(nuclear_phoshpo_pp70s6k_o1_density);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pp70s6k_o2_intensity of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pp70s6k_o2_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pp70s6k_o2_intensity() {
		return _tma.getCytoplasmic_phoshpo_pp70s6k_o2_intensity();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pp70s6k_o2_intensity of this t m a.
	*
	* @param cytoplasmic_phoshpo_pp70s6k_o2_intensity the cytoplasmic_phoshpo_pp70s6k_o2_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pp70s6k_o2_intensity(
		long cytoplasmic_phoshpo_pp70s6k_o2_intensity) {
		_tma.setCytoplasmic_phoshpo_pp70s6k_o2_intensity(cytoplasmic_phoshpo_pp70s6k_o2_intensity);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pp70s6k_o2_density of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pp70s6k_o2_density of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pp70s6k_o2_density() {
		return _tma.getCytoplasmic_phoshpo_pp70s6k_o2_density();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pp70s6k_o2_density of this t m a.
	*
	* @param cytoplasmic_phoshpo_pp70s6k_o2_density the cytoplasmic_phoshpo_pp70s6k_o2_density of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pp70s6k_o2_density(
		long cytoplasmic_phoshpo_pp70s6k_o2_density) {
		_tma.setCytoplasmic_phoshpo_pp70s6k_o2_density(cytoplasmic_phoshpo_pp70s6k_o2_density);
	}

	/**
	* Returns the nuclear_phoshpo_pp70s6k_o2_intensity of this t m a.
	*
	* @return the nuclear_phoshpo_pp70s6k_o2_intensity of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pp70s6k_o2_intensity() {
		return _tma.getNuclear_phoshpo_pp70s6k_o2_intensity();
	}

	/**
	* Sets the nuclear_phoshpo_pp70s6k_o2_intensity of this t m a.
	*
	* @param nuclear_phoshpo_pp70s6k_o2_intensity the nuclear_phoshpo_pp70s6k_o2_intensity of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pp70s6k_o2_intensity(
		long nuclear_phoshpo_pp70s6k_o2_intensity) {
		_tma.setNuclear_phoshpo_pp70s6k_o2_intensity(nuclear_phoshpo_pp70s6k_o2_intensity);
	}

	/**
	* Returns the nuclear_phoshpo_pp70s6k_o2_density of this t m a.
	*
	* @return the nuclear_phoshpo_pp70s6k_o2_density of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pp70s6k_o2_density() {
		return _tma.getNuclear_phoshpo_pp70s6k_o2_density();
	}

	/**
	* Sets the nuclear_phoshpo_pp70s6k_o2_density of this t m a.
	*
	* @param nuclear_phoshpo_pp70s6k_o2_density the nuclear_phoshpo_pp70s6k_o2_density of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pp70s6k_o2_density(
		long nuclear_phoshpo_pp70s6k_o2_density) {
		_tma.setNuclear_phoshpo_pp70s6k_o2_density(nuclear_phoshpo_pp70s6k_o2_density);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pp70s6k_o1_intensity of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pp70s6k_o1_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pp70s6k_o1_intensity() {
		return _tma.getCytoplasmic_phoshpo_pp70s6k_o1_intensity();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pp70s6k_o1_intensity of this t m a.
	*
	* @param cytoplasmic_phoshpo_pp70s6k_o1_intensity the cytoplasmic_phoshpo_pp70s6k_o1_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pp70s6k_o1_intensity(
		long cytoplasmic_phoshpo_pp70s6k_o1_intensity) {
		_tma.setCytoplasmic_phoshpo_pp70s6k_o1_intensity(cytoplasmic_phoshpo_pp70s6k_o1_intensity);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pten_o1_intensity of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pten_o1_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pten_o1_intensity() {
		return _tma.getCytoplasmic_phoshpo_pten_o1_intensity();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pten_o1_intensity of this t m a.
	*
	* @param cytoplasmic_phoshpo_pten_o1_intensity the cytoplasmic_phoshpo_pten_o1_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pten_o1_intensity(
		long cytoplasmic_phoshpo_pten_o1_intensity) {
		_tma.setCytoplasmic_phoshpo_pten_o1_intensity(cytoplasmic_phoshpo_pten_o1_intensity);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pten_o1_density of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pten_o1_density of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pten_o1_density() {
		return _tma.getCytoplasmic_phoshpo_pten_o1_density();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pten_o1_density of this t m a.
	*
	* @param cytoplasmic_phoshpo_pten_o1_density the cytoplasmic_phoshpo_pten_o1_density of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pten_o1_density(
		long cytoplasmic_phoshpo_pten_o1_density) {
		_tma.setCytoplasmic_phoshpo_pten_o1_density(cytoplasmic_phoshpo_pten_o1_density);
	}

	/**
	* Returns the nuclear_phoshpo_pten_o1_intensity of this t m a.
	*
	* @return the nuclear_phoshpo_pten_o1_intensity of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pten_o1_intensity() {
		return _tma.getNuclear_phoshpo_pten_o1_intensity();
	}

	/**
	* Sets the nuclear_phoshpo_pten_o1_intensity of this t m a.
	*
	* @param nuclear_phoshpo_pten_o1_intensity the nuclear_phoshpo_pten_o1_intensity of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pten_o1_intensity(
		long nuclear_phoshpo_pten_o1_intensity) {
		_tma.setNuclear_phoshpo_pten_o1_intensity(nuclear_phoshpo_pten_o1_intensity);
	}

	/**
	* Returns the nuclear_phoshpo_pten_o1_density of this t m a.
	*
	* @return the nuclear_phoshpo_pten_o1_density of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pten_o1_density() {
		return _tma.getNuclear_phoshpo_pten_o1_density();
	}

	/**
	* Sets the nuclear_phoshpo_pten_o1_density of this t m a.
	*
	* @param nuclear_phoshpo_pten_o1_density the nuclear_phoshpo_pten_o1_density of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pten_o1_density(
		long nuclear_phoshpo_pten_o1_density) {
		_tma.setNuclear_phoshpo_pten_o1_density(nuclear_phoshpo_pten_o1_density);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pten_o2_intensity of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pten_o2_intensity of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pten_o2_intensity() {
		return _tma.getCytoplasmic_phoshpo_pten_o2_intensity();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pten_o2_intensity of this t m a.
	*
	* @param cytoplasmic_phoshpo_pten_o2_intensity the cytoplasmic_phoshpo_pten_o2_intensity of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pten_o2_intensity(
		long cytoplasmic_phoshpo_pten_o2_intensity) {
		_tma.setCytoplasmic_phoshpo_pten_o2_intensity(cytoplasmic_phoshpo_pten_o2_intensity);
	}

	/**
	* Returns the cytoplasmic_phoshpo_pten_o2_density of this t m a.
	*
	* @return the cytoplasmic_phoshpo_pten_o2_density of this t m a
	*/
	@Override
	public long getCytoplasmic_phoshpo_pten_o2_density() {
		return _tma.getCytoplasmic_phoshpo_pten_o2_density();
	}

	/**
	* Sets the cytoplasmic_phoshpo_pten_o2_density of this t m a.
	*
	* @param cytoplasmic_phoshpo_pten_o2_density the cytoplasmic_phoshpo_pten_o2_density of this t m a
	*/
	@Override
	public void setCytoplasmic_phoshpo_pten_o2_density(
		long cytoplasmic_phoshpo_pten_o2_density) {
		_tma.setCytoplasmic_phoshpo_pten_o2_density(cytoplasmic_phoshpo_pten_o2_density);
	}

	/**
	* Returns the nuclear_phoshpo_pten_o2_intensity of this t m a.
	*
	* @return the nuclear_phoshpo_pten_o2_intensity of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pten_o2_intensity() {
		return _tma.getNuclear_phoshpo_pten_o2_intensity();
	}

	/**
	* Sets the nuclear_phoshpo_pten_o2_intensity of this t m a.
	*
	* @param nuclear_phoshpo_pten_o2_intensity the nuclear_phoshpo_pten_o2_intensity of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pten_o2_intensity(
		long nuclear_phoshpo_pten_o2_intensity) {
		_tma.setNuclear_phoshpo_pten_o2_intensity(nuclear_phoshpo_pten_o2_intensity);
	}

	/**
	* Returns the nuclear_phoshpo_pten_o2_density of this t m a.
	*
	* @return the nuclear_phoshpo_pten_o2_density of this t m a
	*/
	@Override
	public long getNuclear_phoshpo_pten_o2_density() {
		return _tma.getNuclear_phoshpo_pten_o2_density();
	}

	/**
	* Sets the nuclear_phoshpo_pten_o2_density of this t m a.
	*
	* @param nuclear_phoshpo_pten_o2_density the nuclear_phoshpo_pten_o2_density of this t m a
	*/
	@Override
	public void setNuclear_phoshpo_pten_o2_density(
		long nuclear_phoshpo_pten_o2_density) {
		_tma.setNuclear_phoshpo_pten_o2_density(nuclear_phoshpo_pten_o2_density);
	}

	@Override
	public boolean isNew() {
		return _tma.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tma.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tma.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tma.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tma.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tma.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tma.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tma.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tma.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tma.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tma.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TMAWrapper((TMA)_tma.clone());
	}

	@Override
	public int compareTo(at.meduni.graz.patho.haybaeck.model.TMA tma) {
		return _tma.compareTo(tma);
	}

	@Override
	public int hashCode() {
		return _tma.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.graz.patho.haybaeck.model.TMA> toCacheModel() {
		return _tma.toCacheModel();
	}

	@Override
	public at.meduni.graz.patho.haybaeck.model.TMA toEscapedModel() {
		return new TMAWrapper(_tma.toEscapedModel());
	}

	@Override
	public at.meduni.graz.patho.haybaeck.model.TMA toUnescapedModel() {
		return new TMAWrapper(_tma.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tma.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tma.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tma.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TMAWrapper)) {
			return false;
		}

		TMAWrapper tmaWrapper = (TMAWrapper)obj;

		if (Validator.equals(_tma, tmaWrapper._tma)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TMA getWrappedTMA() {
		return _tma;
	}

	@Override
	public TMA getWrappedModel() {
		return _tma;
	}

	@Override
	public void resetOriginalValues() {
		_tma.resetOriginalValues();
	}

	private TMA _tma;
}