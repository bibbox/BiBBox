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

package at.meduni.graz.patho.haybaeck.model.impl;

import at.meduni.graz.patho.haybaeck.model.TMA;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TMA in entity cache.
 *
 * @author reihsr
 * @see TMA
 * @generated
 */
public class TMACacheModel implements CacheModel<TMA>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(225);

		sb.append("{tma_Id=");
		sb.append(tma_Id);
		sb.append(", sample_id=");
		sb.append(sample_id);
		sb.append(", tma_name=");
		sb.append(tma_name);
		sb.append(", tma_number=");
		sb.append(tma_number);
		sb.append(", tma_comment=");
		sb.append(tma_comment);
		sb.append(", cytoplasmic_stat_5_intensity=");
		sb.append(cytoplasmic_stat_5_intensity);
		sb.append(", cytoplasmic_stat_5_density=");
		sb.append(cytoplasmic_stat_5_density);
		sb.append(", nuclear_stat_5_intensity=");
		sb.append(nuclear_stat_5_intensity);
		sb.append(", nuclear_stat_5_density=");
		sb.append(nuclear_stat_5_density);
		sb.append(", cytoplasmic_cjun_intensity=");
		sb.append(cytoplasmic_cjun_intensity);
		sb.append(", cytoplasmic_cjun_density=");
		sb.append(cytoplasmic_cjun_density);
		sb.append(", nuclear_cjun_intensity=");
		sb.append(nuclear_cjun_intensity);
		sb.append(", nuclear_cjun_density=");
		sb.append(nuclear_cjun_density);
		sb.append(", cytoplasmic_pstat_3_intensity=");
		sb.append(cytoplasmic_pstat_3_intensity);
		sb.append(", cytoplasmic_pstat_3_density=");
		sb.append(cytoplasmic_pstat_3_density);
		sb.append(", nuclear_pstat_3_intensity=");
		sb.append(nuclear_pstat_3_intensity);
		sb.append(", nuclear_pstat_3_density=");
		sb.append(nuclear_pstat_3_density);
		sb.append(", cytoplasmic_pstat_5_intensity=");
		sb.append(cytoplasmic_pstat_5_intensity);
		sb.append(", cytoplasmic_pstat_5_density=");
		sb.append(cytoplasmic_pstat_5_density);
		sb.append(", nuclear_pstat_5_intensity=");
		sb.append(nuclear_pstat_5_intensity);
		sb.append(", nuclear_pstat_5_density=");
		sb.append(nuclear_pstat_5_density);
		sb.append(", cytoplasmic_pstat_1_intensity=");
		sb.append(cytoplasmic_pstat_1_intensity);
		sb.append(", cytoplasmic_pstat_1_density=");
		sb.append(cytoplasmic_pstat_1_density);
		sb.append(", nuclear_pstat_1_intensity=");
		sb.append(nuclear_pstat_1_intensity);
		sb.append(", cytoplasmic_il6r_intensity=");
		sb.append(cytoplasmic_il6r_intensity);
		sb.append(", cytoplasmic_il6r_density=");
		sb.append(cytoplasmic_il6r_density);
		sb.append(", nuclear_il6r_intensity=");
		sb.append(nuclear_il6r_intensity);
		sb.append(", nuclear_il6r_density=");
		sb.append(nuclear_il6r_density);
		sb.append(", cytoplasmic_socs1_intensity=");
		sb.append(cytoplasmic_socs1_intensity);
		sb.append(", cytoplasmic_socs1_density=");
		sb.append(cytoplasmic_socs1_density);
		sb.append(", nuclear_socs1_intensity=");
		sb.append(nuclear_socs1_intensity);
		sb.append(", nuclear_socs1_density=");
		sb.append(nuclear_socs1_density);
		sb.append(", cytoplasmic_socs3_intensity=");
		sb.append(cytoplasmic_socs3_intensity);
		sb.append(", cytoplasmic_socs3_density=");
		sb.append(cytoplasmic_socs3_density);
		sb.append(", nuclear_socs3_intensity=");
		sb.append(nuclear_socs3_intensity);
		sb.append(", nuclear_socs3_density=");
		sb.append(nuclear_socs3_density);
		sb.append(", cytoplasmic_junb_intensity=");
		sb.append(cytoplasmic_junb_intensity);
		sb.append(", cytoplasmic_junb_density=");
		sb.append(cytoplasmic_junb_density);
		sb.append(", nuclear_junb_intensity=");
		sb.append(nuclear_junb_intensity);
		sb.append(", nuclear_junb_density=");
		sb.append(nuclear_junb_density);
		sb.append(", cytoplasmic_stat_3_intensity=");
		sb.append(cytoplasmic_stat_3_intensity);
		sb.append(", cytoplasmic_stat_3_density=");
		sb.append(cytoplasmic_stat_3_density);
		sb.append(", nuclear_stat_3_intensity=");
		sb.append(nuclear_stat_3_intensity);
		sb.append(", nuclear_stat_3_density=");
		sb.append(nuclear_stat_3_density);
		sb.append(", cytoplasmic_stat_5a_intensity=");
		sb.append(cytoplasmic_stat_5a_intensity);
		sb.append(", cytoplasmic_stat_5a_density=");
		sb.append(cytoplasmic_stat_5a_density);
		sb.append(", nuclear_stat_5a_intensity=");
		sb.append(nuclear_stat_5a_intensity);
		sb.append(", nuclear_stat_5a_density=");
		sb.append(nuclear_stat_5a_density);
		sb.append(", cytoplasmic_stat_5b_intensity=");
		sb.append(cytoplasmic_stat_5b_intensity);
		sb.append(", cytoplasmic_stat_5b_density=");
		sb.append(cytoplasmic_stat_5b_density);
		sb.append(", nuclear_stat_5b_intensity=");
		sb.append(nuclear_stat_5b_intensity);
		sb.append(", nuclear_stat_5b_density=");
		sb.append(nuclear_stat_5b_density);
		sb.append(", cytoplasmic_eif3a_intensity=");
		sb.append(cytoplasmic_eif3a_intensity);
		sb.append(", cytoplasmic_eif3a_density=");
		sb.append(cytoplasmic_eif3a_density);
		sb.append(", cytoplasmic_eif3a_peter_intensity=");
		sb.append(cytoplasmic_eif3a_peter_intensity);
		sb.append(", cytoplasmic_eif3a_peter_density=");
		sb.append(cytoplasmic_eif3a_peter_density);
		sb.append(", cytoplasmic_itih_5_o1_intensity=");
		sb.append(cytoplasmic_itih_5_o1_intensity);
		sb.append(", cytoplasmic_itih_5_o1_density=");
		sb.append(cytoplasmic_itih_5_o1_density);
		sb.append(", nuclear_itih_5_o1_intensity=");
		sb.append(nuclear_itih_5_o1_intensity);
		sb.append(", nuclear_itih_5_o1_density=");
		sb.append(nuclear_itih_5_o1_density);
		sb.append(", cytoplasmic_itih_5_o2_intensity=");
		sb.append(cytoplasmic_itih_5_o2_intensity);
		sb.append(", cytoplasmic_itih_5_o2_density=");
		sb.append(cytoplasmic_itih_5_o2_density);
		sb.append(", nuclear_itih_5_o2_intensity=");
		sb.append(nuclear_itih_5_o2_intensity);
		sb.append(", nuclear_itih_5_o2_density=");
		sb.append(nuclear_itih_5_o2_density);
		sb.append(", cytoplasmic_imp2_2_intensity=");
		sb.append(cytoplasmic_imp2_2_intensity);
		sb.append(", cytoplasmic_imp2_2_density=");
		sb.append(cytoplasmic_imp2_2_density);
		sb.append(", cytoplasmic_stat_1_intensity=");
		sb.append(cytoplasmic_stat_1_intensity);
		sb.append(", cytoplasmic_stat_1_density=");
		sb.append(cytoplasmic_stat_1_density);
		sb.append(", nuclear_stat_1_intensity=");
		sb.append(nuclear_stat_1_intensity);
		sb.append(", nuclear_stat_1_density=");
		sb.append(nuclear_stat_1_density);
		sb.append(", cytoplasmic_nfkb1_intensity=");
		sb.append(cytoplasmic_nfkb1_intensity);
		sb.append(", cytoplasmic_nfkb1_density=");
		sb.append(cytoplasmic_nfkb1_density);
		sb.append(", nuclear_nfkb1_intensity=");
		sb.append(nuclear_nfkb1_intensity);
		sb.append(", nuclear_nfkb1_density=");
		sb.append(nuclear_nfkb1_density);
		sb.append(", cytoplasmic_nfkb2_intensity=");
		sb.append(cytoplasmic_nfkb2_intensity);
		sb.append(", cytoplasmic_nfkb2_density=");
		sb.append(cytoplasmic_nfkb2_density);
		sb.append(", nuclear_nfkb2_intensity=");
		sb.append(nuclear_nfkb2_intensity);
		sb.append(", nuclear_nfkb2_density=");
		sb.append(nuclear_nfkb2_density);
		sb.append(", cytoplasmic_pikb_intensity=");
		sb.append(cytoplasmic_pikb_intensity);
		sb.append(", cytoplasmic_pikb_density=");
		sb.append(cytoplasmic_pikb_density);
		sb.append(", cytoplasmic_phoshpo_pakt_o1_intensity=");
		sb.append(cytoplasmic_phoshpo_pakt_o1_intensity);
		sb.append(", cytoplasmic_phoshpo_pakt_o1_density=");
		sb.append(cytoplasmic_phoshpo_pakt_o1_density);
		sb.append(", nuclear_phoshpo_pakt_o1_intensity=");
		sb.append(nuclear_phoshpo_pakt_o1_intensity);
		sb.append(", nuclear_phoshpo_pakt_o1_density=");
		sb.append(nuclear_phoshpo_pakt_o1_density);
		sb.append(", cytoplasmic_phoshpo_pakt_o2_intensity=");
		sb.append(cytoplasmic_phoshpo_pakt_o2_intensity);
		sb.append(", cytoplasmic_phoshpo_pakt_o2_density=");
		sb.append(cytoplasmic_phoshpo_pakt_o2_density);
		sb.append(", nuclear_phoshpo_pakt_o2_intensity=");
		sb.append(nuclear_phoshpo_pakt_o2_intensity);
		sb.append(", nuclear_phoshpo_pakt_o2_density=");
		sb.append(nuclear_phoshpo_pakt_o2_density);
		sb.append(", cytoplasmic_phoshpo_pmtor_o1_intensity=");
		sb.append(cytoplasmic_phoshpo_pmtor_o1_intensity);
		sb.append(", cytoplasmic_phoshpo_pmtor_o1_density=");
		sb.append(cytoplasmic_phoshpo_pmtor_o1_density);
		sb.append(", nuclear_phoshpo_pmtor_o1_intensity=");
		sb.append(nuclear_phoshpo_pmtor_o1_intensity);
		sb.append(", nuclear_phoshpo_pmtor_o1_density=");
		sb.append(nuclear_phoshpo_pmtor_o1_density);
		sb.append(", cytoplasmic_phoshpo_pmtor_o2_intensity=");
		sb.append(cytoplasmic_phoshpo_pmtor_o2_intensity);
		sb.append(", cytoplasmic_phoshpo_pmtor_o2_density=");
		sb.append(cytoplasmic_phoshpo_pmtor_o2_density);
		sb.append(", nuclear_phoshpo_pmtor_o2_intensity=");
		sb.append(nuclear_phoshpo_pmtor_o2_intensity);
		sb.append(", nuclear_phoshpo_pmtor_o2_density=");
		sb.append(nuclear_phoshpo_pmtor_o2_density);
		sb.append(", cytoplasmic_phoshpo_pp70s6k_o1_density=");
		sb.append(cytoplasmic_phoshpo_pp70s6k_o1_density);
		sb.append(", nuclear_phoshpo_pp70s6k_o1_intensity=");
		sb.append(nuclear_phoshpo_pp70s6k_o1_intensity);
		sb.append(", nuclear_phoshpo_pp70s6k_o1_density=");
		sb.append(nuclear_phoshpo_pp70s6k_o1_density);
		sb.append(", cytoplasmic_phoshpo_pp70s6k_o2_intensity=");
		sb.append(cytoplasmic_phoshpo_pp70s6k_o2_intensity);
		sb.append(", cytoplasmic_phoshpo_pp70s6k_o2_density=");
		sb.append(cytoplasmic_phoshpo_pp70s6k_o2_density);
		sb.append(", nuclear_phoshpo_pp70s6k_o2_intensity=");
		sb.append(nuclear_phoshpo_pp70s6k_o2_intensity);
		sb.append(", nuclear_phoshpo_pp70s6k_o2_density=");
		sb.append(nuclear_phoshpo_pp70s6k_o2_density);
		sb.append(", cytoplasmic_phoshpo_pp70s6k_o1_intensity=");
		sb.append(cytoplasmic_phoshpo_pp70s6k_o1_intensity);
		sb.append(", cytoplasmic_phoshpo_pten_o1_intensity=");
		sb.append(cytoplasmic_phoshpo_pten_o1_intensity);
		sb.append(", cytoplasmic_phoshpo_pten_o1_density=");
		sb.append(cytoplasmic_phoshpo_pten_o1_density);
		sb.append(", nuclear_phoshpo_pten_o1_intensity=");
		sb.append(nuclear_phoshpo_pten_o1_intensity);
		sb.append(", nuclear_phoshpo_pten_o1_density=");
		sb.append(nuclear_phoshpo_pten_o1_density);
		sb.append(", cytoplasmic_phoshpo_pten_o2_intensity=");
		sb.append(cytoplasmic_phoshpo_pten_o2_intensity);
		sb.append(", cytoplasmic_phoshpo_pten_o2_density=");
		sb.append(cytoplasmic_phoshpo_pten_o2_density);
		sb.append(", nuclear_phoshpo_pten_o2_intensity=");
		sb.append(nuclear_phoshpo_pten_o2_intensity);
		sb.append(", nuclear_phoshpo_pten_o2_density=");
		sb.append(nuclear_phoshpo_pten_o2_density);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TMA toEntityModel() {
		TMAImpl tmaImpl = new TMAImpl();

		tmaImpl.setTma_Id(tma_Id);
		tmaImpl.setSample_id(sample_id);

		if (tma_name == null) {
			tmaImpl.setTma_name(StringPool.BLANK);
		}
		else {
			tmaImpl.setTma_name(tma_name);
		}

		if (tma_number == null) {
			tmaImpl.setTma_number(StringPool.BLANK);
		}
		else {
			tmaImpl.setTma_number(tma_number);
		}

		if (tma_comment == null) {
			tmaImpl.setTma_comment(StringPool.BLANK);
		}
		else {
			tmaImpl.setTma_comment(tma_comment);
		}

		tmaImpl.setCytoplasmic_stat_5_intensity(cytoplasmic_stat_5_intensity);
		tmaImpl.setCytoplasmic_stat_5_density(cytoplasmic_stat_5_density);
		tmaImpl.setNuclear_stat_5_intensity(nuclear_stat_5_intensity);
		tmaImpl.setNuclear_stat_5_density(nuclear_stat_5_density);
		tmaImpl.setCytoplasmic_cjun_intensity(cytoplasmic_cjun_intensity);
		tmaImpl.setCytoplasmic_cjun_density(cytoplasmic_cjun_density);
		tmaImpl.setNuclear_cjun_intensity(nuclear_cjun_intensity);
		tmaImpl.setNuclear_cjun_density(nuclear_cjun_density);
		tmaImpl.setCytoplasmic_pstat_3_intensity(cytoplasmic_pstat_3_intensity);
		tmaImpl.setCytoplasmic_pstat_3_density(cytoplasmic_pstat_3_density);
		tmaImpl.setNuclear_pstat_3_intensity(nuclear_pstat_3_intensity);
		tmaImpl.setNuclear_pstat_3_density(nuclear_pstat_3_density);
		tmaImpl.setCytoplasmic_pstat_5_intensity(cytoplasmic_pstat_5_intensity);
		tmaImpl.setCytoplasmic_pstat_5_density(cytoplasmic_pstat_5_density);
		tmaImpl.setNuclear_pstat_5_intensity(nuclear_pstat_5_intensity);
		tmaImpl.setNuclear_pstat_5_density(nuclear_pstat_5_density);
		tmaImpl.setCytoplasmic_pstat_1_intensity(cytoplasmic_pstat_1_intensity);
		tmaImpl.setCytoplasmic_pstat_1_density(cytoplasmic_pstat_1_density);
		tmaImpl.setNuclear_pstat_1_intensity(nuclear_pstat_1_intensity);
		tmaImpl.setCytoplasmic_il6r_intensity(cytoplasmic_il6r_intensity);
		tmaImpl.setCytoplasmic_il6r_density(cytoplasmic_il6r_density);
		tmaImpl.setNuclear_il6r_intensity(nuclear_il6r_intensity);
		tmaImpl.setNuclear_il6r_density(nuclear_il6r_density);
		tmaImpl.setCytoplasmic_socs1_intensity(cytoplasmic_socs1_intensity);
		tmaImpl.setCytoplasmic_socs1_density(cytoplasmic_socs1_density);
		tmaImpl.setNuclear_socs1_intensity(nuclear_socs1_intensity);
		tmaImpl.setNuclear_socs1_density(nuclear_socs1_density);
		tmaImpl.setCytoplasmic_socs3_intensity(cytoplasmic_socs3_intensity);
		tmaImpl.setCytoplasmic_socs3_density(cytoplasmic_socs3_density);
		tmaImpl.setNuclear_socs3_intensity(nuclear_socs3_intensity);
		tmaImpl.setNuclear_socs3_density(nuclear_socs3_density);
		tmaImpl.setCytoplasmic_junb_intensity(cytoplasmic_junb_intensity);
		tmaImpl.setCytoplasmic_junb_density(cytoplasmic_junb_density);
		tmaImpl.setNuclear_junb_intensity(nuclear_junb_intensity);
		tmaImpl.setNuclear_junb_density(nuclear_junb_density);
		tmaImpl.setCytoplasmic_stat_3_intensity(cytoplasmic_stat_3_intensity);
		tmaImpl.setCytoplasmic_stat_3_density(cytoplasmic_stat_3_density);
		tmaImpl.setNuclear_stat_3_intensity(nuclear_stat_3_intensity);
		tmaImpl.setNuclear_stat_3_density(nuclear_stat_3_density);
		tmaImpl.setCytoplasmic_stat_5a_intensity(cytoplasmic_stat_5a_intensity);
		tmaImpl.setCytoplasmic_stat_5a_density(cytoplasmic_stat_5a_density);
		tmaImpl.setNuclear_stat_5a_intensity(nuclear_stat_5a_intensity);
		tmaImpl.setNuclear_stat_5a_density(nuclear_stat_5a_density);
		tmaImpl.setCytoplasmic_stat_5b_intensity(cytoplasmic_stat_5b_intensity);
		tmaImpl.setCytoplasmic_stat_5b_density(cytoplasmic_stat_5b_density);
		tmaImpl.setNuclear_stat_5b_intensity(nuclear_stat_5b_intensity);
		tmaImpl.setNuclear_stat_5b_density(nuclear_stat_5b_density);
		tmaImpl.setCytoplasmic_eif3a_intensity(cytoplasmic_eif3a_intensity);
		tmaImpl.setCytoplasmic_eif3a_density(cytoplasmic_eif3a_density);
		tmaImpl.setCytoplasmic_eif3a_peter_intensity(cytoplasmic_eif3a_peter_intensity);
		tmaImpl.setCytoplasmic_eif3a_peter_density(cytoplasmic_eif3a_peter_density);
		tmaImpl.setCytoplasmic_itih_5_o1_intensity(cytoplasmic_itih_5_o1_intensity);
		tmaImpl.setCytoplasmic_itih_5_o1_density(cytoplasmic_itih_5_o1_density);
		tmaImpl.setNuclear_itih_5_o1_intensity(nuclear_itih_5_o1_intensity);
		tmaImpl.setNuclear_itih_5_o1_density(nuclear_itih_5_o1_density);
		tmaImpl.setCytoplasmic_itih_5_o2_intensity(cytoplasmic_itih_5_o2_intensity);
		tmaImpl.setCytoplasmic_itih_5_o2_density(cytoplasmic_itih_5_o2_density);
		tmaImpl.setNuclear_itih_5_o2_intensity(nuclear_itih_5_o2_intensity);
		tmaImpl.setNuclear_itih_5_o2_density(nuclear_itih_5_o2_density);
		tmaImpl.setCytoplasmic_imp2_2_intensity(cytoplasmic_imp2_2_intensity);
		tmaImpl.setCytoplasmic_imp2_2_density(cytoplasmic_imp2_2_density);
		tmaImpl.setCytoplasmic_stat_1_intensity(cytoplasmic_stat_1_intensity);
		tmaImpl.setCytoplasmic_stat_1_density(cytoplasmic_stat_1_density);
		tmaImpl.setNuclear_stat_1_intensity(nuclear_stat_1_intensity);
		tmaImpl.setNuclear_stat_1_density(nuclear_stat_1_density);
		tmaImpl.setCytoplasmic_nfkb1_intensity(cytoplasmic_nfkb1_intensity);
		tmaImpl.setCytoplasmic_nfkb1_density(cytoplasmic_nfkb1_density);
		tmaImpl.setNuclear_nfkb1_intensity(nuclear_nfkb1_intensity);
		tmaImpl.setNuclear_nfkb1_density(nuclear_nfkb1_density);
		tmaImpl.setCytoplasmic_nfkb2_intensity(cytoplasmic_nfkb2_intensity);
		tmaImpl.setCytoplasmic_nfkb2_density(cytoplasmic_nfkb2_density);
		tmaImpl.setNuclear_nfkb2_intensity(nuclear_nfkb2_intensity);
		tmaImpl.setNuclear_nfkb2_density(nuclear_nfkb2_density);
		tmaImpl.setCytoplasmic_pikb_intensity(cytoplasmic_pikb_intensity);
		tmaImpl.setCytoplasmic_pikb_density(cytoplasmic_pikb_density);
		tmaImpl.setCytoplasmic_phoshpo_pakt_o1_intensity(cytoplasmic_phoshpo_pakt_o1_intensity);
		tmaImpl.setCytoplasmic_phoshpo_pakt_o1_density(cytoplasmic_phoshpo_pakt_o1_density);
		tmaImpl.setNuclear_phoshpo_pakt_o1_intensity(nuclear_phoshpo_pakt_o1_intensity);
		tmaImpl.setNuclear_phoshpo_pakt_o1_density(nuclear_phoshpo_pakt_o1_density);
		tmaImpl.setCytoplasmic_phoshpo_pakt_o2_intensity(cytoplasmic_phoshpo_pakt_o2_intensity);
		tmaImpl.setCytoplasmic_phoshpo_pakt_o2_density(cytoplasmic_phoshpo_pakt_o2_density);
		tmaImpl.setNuclear_phoshpo_pakt_o2_intensity(nuclear_phoshpo_pakt_o2_intensity);
		tmaImpl.setNuclear_phoshpo_pakt_o2_density(nuclear_phoshpo_pakt_o2_density);
		tmaImpl.setCytoplasmic_phoshpo_pmtor_o1_intensity(cytoplasmic_phoshpo_pmtor_o1_intensity);
		tmaImpl.setCytoplasmic_phoshpo_pmtor_o1_density(cytoplasmic_phoshpo_pmtor_o1_density);
		tmaImpl.setNuclear_phoshpo_pmtor_o1_intensity(nuclear_phoshpo_pmtor_o1_intensity);
		tmaImpl.setNuclear_phoshpo_pmtor_o1_density(nuclear_phoshpo_pmtor_o1_density);
		tmaImpl.setCytoplasmic_phoshpo_pmtor_o2_intensity(cytoplasmic_phoshpo_pmtor_o2_intensity);
		tmaImpl.setCytoplasmic_phoshpo_pmtor_o2_density(cytoplasmic_phoshpo_pmtor_o2_density);
		tmaImpl.setNuclear_phoshpo_pmtor_o2_intensity(nuclear_phoshpo_pmtor_o2_intensity);
		tmaImpl.setNuclear_phoshpo_pmtor_o2_density(nuclear_phoshpo_pmtor_o2_density);
		tmaImpl.setCytoplasmic_phoshpo_pp70s6k_o1_density(cytoplasmic_phoshpo_pp70s6k_o1_density);
		tmaImpl.setNuclear_phoshpo_pp70s6k_o1_intensity(nuclear_phoshpo_pp70s6k_o1_intensity);
		tmaImpl.setNuclear_phoshpo_pp70s6k_o1_density(nuclear_phoshpo_pp70s6k_o1_density);
		tmaImpl.setCytoplasmic_phoshpo_pp70s6k_o2_intensity(cytoplasmic_phoshpo_pp70s6k_o2_intensity);
		tmaImpl.setCytoplasmic_phoshpo_pp70s6k_o2_density(cytoplasmic_phoshpo_pp70s6k_o2_density);
		tmaImpl.setNuclear_phoshpo_pp70s6k_o2_intensity(nuclear_phoshpo_pp70s6k_o2_intensity);
		tmaImpl.setNuclear_phoshpo_pp70s6k_o2_density(nuclear_phoshpo_pp70s6k_o2_density);
		tmaImpl.setCytoplasmic_phoshpo_pp70s6k_o1_intensity(cytoplasmic_phoshpo_pp70s6k_o1_intensity);
		tmaImpl.setCytoplasmic_phoshpo_pten_o1_intensity(cytoplasmic_phoshpo_pten_o1_intensity);
		tmaImpl.setCytoplasmic_phoshpo_pten_o1_density(cytoplasmic_phoshpo_pten_o1_density);
		tmaImpl.setNuclear_phoshpo_pten_o1_intensity(nuclear_phoshpo_pten_o1_intensity);
		tmaImpl.setNuclear_phoshpo_pten_o1_density(nuclear_phoshpo_pten_o1_density);
		tmaImpl.setCytoplasmic_phoshpo_pten_o2_intensity(cytoplasmic_phoshpo_pten_o2_intensity);
		tmaImpl.setCytoplasmic_phoshpo_pten_o2_density(cytoplasmic_phoshpo_pten_o2_density);
		tmaImpl.setNuclear_phoshpo_pten_o2_intensity(nuclear_phoshpo_pten_o2_intensity);
		tmaImpl.setNuclear_phoshpo_pten_o2_density(nuclear_phoshpo_pten_o2_density);

		tmaImpl.resetOriginalValues();

		return tmaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tma_Id = objectInput.readLong();
		sample_id = objectInput.readLong();
		tma_name = objectInput.readUTF();
		tma_number = objectInput.readUTF();
		tma_comment = objectInput.readUTF();
		cytoplasmic_stat_5_intensity = objectInput.readLong();
		cytoplasmic_stat_5_density = objectInput.readLong();
		nuclear_stat_5_intensity = objectInput.readLong();
		nuclear_stat_5_density = objectInput.readLong();
		cytoplasmic_cjun_intensity = objectInput.readLong();
		cytoplasmic_cjun_density = objectInput.readLong();
		nuclear_cjun_intensity = objectInput.readLong();
		nuclear_cjun_density = objectInput.readLong();
		cytoplasmic_pstat_3_intensity = objectInput.readLong();
		cytoplasmic_pstat_3_density = objectInput.readLong();
		nuclear_pstat_3_intensity = objectInput.readLong();
		nuclear_pstat_3_density = objectInput.readLong();
		cytoplasmic_pstat_5_intensity = objectInput.readLong();
		cytoplasmic_pstat_5_density = objectInput.readLong();
		nuclear_pstat_5_intensity = objectInput.readLong();
		nuclear_pstat_5_density = objectInput.readLong();
		cytoplasmic_pstat_1_intensity = objectInput.readLong();
		cytoplasmic_pstat_1_density = objectInput.readLong();
		nuclear_pstat_1_intensity = objectInput.readLong();
		cytoplasmic_il6r_intensity = objectInput.readLong();
		cytoplasmic_il6r_density = objectInput.readLong();
		nuclear_il6r_intensity = objectInput.readLong();
		nuclear_il6r_density = objectInput.readLong();
		cytoplasmic_socs1_intensity = objectInput.readLong();
		cytoplasmic_socs1_density = objectInput.readLong();
		nuclear_socs1_intensity = objectInput.readLong();
		nuclear_socs1_density = objectInput.readLong();
		cytoplasmic_socs3_intensity = objectInput.readLong();
		cytoplasmic_socs3_density = objectInput.readLong();
		nuclear_socs3_intensity = objectInput.readLong();
		nuclear_socs3_density = objectInput.readLong();
		cytoplasmic_junb_intensity = objectInput.readLong();
		cytoplasmic_junb_density = objectInput.readLong();
		nuclear_junb_intensity = objectInput.readLong();
		nuclear_junb_density = objectInput.readLong();
		cytoplasmic_stat_3_intensity = objectInput.readLong();
		cytoplasmic_stat_3_density = objectInput.readLong();
		nuclear_stat_3_intensity = objectInput.readLong();
		nuclear_stat_3_density = objectInput.readLong();
		cytoplasmic_stat_5a_intensity = objectInput.readLong();
		cytoplasmic_stat_5a_density = objectInput.readLong();
		nuclear_stat_5a_intensity = objectInput.readLong();
		nuclear_stat_5a_density = objectInput.readLong();
		cytoplasmic_stat_5b_intensity = objectInput.readLong();
		cytoplasmic_stat_5b_density = objectInput.readLong();
		nuclear_stat_5b_intensity = objectInput.readLong();
		nuclear_stat_5b_density = objectInput.readLong();
		cytoplasmic_eif3a_intensity = objectInput.readLong();
		cytoplasmic_eif3a_density = objectInput.readLong();
		cytoplasmic_eif3a_peter_intensity = objectInput.readLong();
		cytoplasmic_eif3a_peter_density = objectInput.readLong();
		cytoplasmic_itih_5_o1_intensity = objectInput.readLong();
		cytoplasmic_itih_5_o1_density = objectInput.readLong();
		nuclear_itih_5_o1_intensity = objectInput.readLong();
		nuclear_itih_5_o1_density = objectInput.readLong();
		cytoplasmic_itih_5_o2_intensity = objectInput.readLong();
		cytoplasmic_itih_5_o2_density = objectInput.readLong();
		nuclear_itih_5_o2_intensity = objectInput.readLong();
		nuclear_itih_5_o2_density = objectInput.readLong();
		cytoplasmic_imp2_2_intensity = objectInput.readLong();
		cytoplasmic_imp2_2_density = objectInput.readLong();
		cytoplasmic_stat_1_intensity = objectInput.readLong();
		cytoplasmic_stat_1_density = objectInput.readLong();
		nuclear_stat_1_intensity = objectInput.readLong();
		nuclear_stat_1_density = objectInput.readLong();
		cytoplasmic_nfkb1_intensity = objectInput.readLong();
		cytoplasmic_nfkb1_density = objectInput.readLong();
		nuclear_nfkb1_intensity = objectInput.readLong();
		nuclear_nfkb1_density = objectInput.readLong();
		cytoplasmic_nfkb2_intensity = objectInput.readLong();
		cytoplasmic_nfkb2_density = objectInput.readLong();
		nuclear_nfkb2_intensity = objectInput.readLong();
		nuclear_nfkb2_density = objectInput.readLong();
		cytoplasmic_pikb_intensity = objectInput.readLong();
		cytoplasmic_pikb_density = objectInput.readLong();
		cytoplasmic_phoshpo_pakt_o1_intensity = objectInput.readLong();
		cytoplasmic_phoshpo_pakt_o1_density = objectInput.readLong();
		nuclear_phoshpo_pakt_o1_intensity = objectInput.readLong();
		nuclear_phoshpo_pakt_o1_density = objectInput.readLong();
		cytoplasmic_phoshpo_pakt_o2_intensity = objectInput.readLong();
		cytoplasmic_phoshpo_pakt_o2_density = objectInput.readLong();
		nuclear_phoshpo_pakt_o2_intensity = objectInput.readLong();
		nuclear_phoshpo_pakt_o2_density = objectInput.readLong();
		cytoplasmic_phoshpo_pmtor_o1_intensity = objectInput.readLong();
		cytoplasmic_phoshpo_pmtor_o1_density = objectInput.readLong();
		nuclear_phoshpo_pmtor_o1_intensity = objectInput.readLong();
		nuclear_phoshpo_pmtor_o1_density = objectInput.readLong();
		cytoplasmic_phoshpo_pmtor_o2_intensity = objectInput.readLong();
		cytoplasmic_phoshpo_pmtor_o2_density = objectInput.readLong();
		nuclear_phoshpo_pmtor_o2_intensity = objectInput.readLong();
		nuclear_phoshpo_pmtor_o2_density = objectInput.readLong();
		cytoplasmic_phoshpo_pp70s6k_o1_density = objectInput.readLong();
		nuclear_phoshpo_pp70s6k_o1_intensity = objectInput.readLong();
		nuclear_phoshpo_pp70s6k_o1_density = objectInput.readLong();
		cytoplasmic_phoshpo_pp70s6k_o2_intensity = objectInput.readLong();
		cytoplasmic_phoshpo_pp70s6k_o2_density = objectInput.readLong();
		nuclear_phoshpo_pp70s6k_o2_intensity = objectInput.readLong();
		nuclear_phoshpo_pp70s6k_o2_density = objectInput.readLong();
		cytoplasmic_phoshpo_pp70s6k_o1_intensity = objectInput.readLong();
		cytoplasmic_phoshpo_pten_o1_intensity = objectInput.readLong();
		cytoplasmic_phoshpo_pten_o1_density = objectInput.readLong();
		nuclear_phoshpo_pten_o1_intensity = objectInput.readLong();
		nuclear_phoshpo_pten_o1_density = objectInput.readLong();
		cytoplasmic_phoshpo_pten_o2_intensity = objectInput.readLong();
		cytoplasmic_phoshpo_pten_o2_density = objectInput.readLong();
		nuclear_phoshpo_pten_o2_intensity = objectInput.readLong();
		nuclear_phoshpo_pten_o2_density = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tma_Id);
		objectOutput.writeLong(sample_id);

		if (tma_name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tma_name);
		}

		if (tma_number == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tma_number);
		}

		if (tma_comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tma_comment);
		}

		objectOutput.writeLong(cytoplasmic_stat_5_intensity);
		objectOutput.writeLong(cytoplasmic_stat_5_density);
		objectOutput.writeLong(nuclear_stat_5_intensity);
		objectOutput.writeLong(nuclear_stat_5_density);
		objectOutput.writeLong(cytoplasmic_cjun_intensity);
		objectOutput.writeLong(cytoplasmic_cjun_density);
		objectOutput.writeLong(nuclear_cjun_intensity);
		objectOutput.writeLong(nuclear_cjun_density);
		objectOutput.writeLong(cytoplasmic_pstat_3_intensity);
		objectOutput.writeLong(cytoplasmic_pstat_3_density);
		objectOutput.writeLong(nuclear_pstat_3_intensity);
		objectOutput.writeLong(nuclear_pstat_3_density);
		objectOutput.writeLong(cytoplasmic_pstat_5_intensity);
		objectOutput.writeLong(cytoplasmic_pstat_5_density);
		objectOutput.writeLong(nuclear_pstat_5_intensity);
		objectOutput.writeLong(nuclear_pstat_5_density);
		objectOutput.writeLong(cytoplasmic_pstat_1_intensity);
		objectOutput.writeLong(cytoplasmic_pstat_1_density);
		objectOutput.writeLong(nuclear_pstat_1_intensity);
		objectOutput.writeLong(cytoplasmic_il6r_intensity);
		objectOutput.writeLong(cytoplasmic_il6r_density);
		objectOutput.writeLong(nuclear_il6r_intensity);
		objectOutput.writeLong(nuclear_il6r_density);
		objectOutput.writeLong(cytoplasmic_socs1_intensity);
		objectOutput.writeLong(cytoplasmic_socs1_density);
		objectOutput.writeLong(nuclear_socs1_intensity);
		objectOutput.writeLong(nuclear_socs1_density);
		objectOutput.writeLong(cytoplasmic_socs3_intensity);
		objectOutput.writeLong(cytoplasmic_socs3_density);
		objectOutput.writeLong(nuclear_socs3_intensity);
		objectOutput.writeLong(nuclear_socs3_density);
		objectOutput.writeLong(cytoplasmic_junb_intensity);
		objectOutput.writeLong(cytoplasmic_junb_density);
		objectOutput.writeLong(nuclear_junb_intensity);
		objectOutput.writeLong(nuclear_junb_density);
		objectOutput.writeLong(cytoplasmic_stat_3_intensity);
		objectOutput.writeLong(cytoplasmic_stat_3_density);
		objectOutput.writeLong(nuclear_stat_3_intensity);
		objectOutput.writeLong(nuclear_stat_3_density);
		objectOutput.writeLong(cytoplasmic_stat_5a_intensity);
		objectOutput.writeLong(cytoplasmic_stat_5a_density);
		objectOutput.writeLong(nuclear_stat_5a_intensity);
		objectOutput.writeLong(nuclear_stat_5a_density);
		objectOutput.writeLong(cytoplasmic_stat_5b_intensity);
		objectOutput.writeLong(cytoplasmic_stat_5b_density);
		objectOutput.writeLong(nuclear_stat_5b_intensity);
		objectOutput.writeLong(nuclear_stat_5b_density);
		objectOutput.writeLong(cytoplasmic_eif3a_intensity);
		objectOutput.writeLong(cytoplasmic_eif3a_density);
		objectOutput.writeLong(cytoplasmic_eif3a_peter_intensity);
		objectOutput.writeLong(cytoplasmic_eif3a_peter_density);
		objectOutput.writeLong(cytoplasmic_itih_5_o1_intensity);
		objectOutput.writeLong(cytoplasmic_itih_5_o1_density);
		objectOutput.writeLong(nuclear_itih_5_o1_intensity);
		objectOutput.writeLong(nuclear_itih_5_o1_density);
		objectOutput.writeLong(cytoplasmic_itih_5_o2_intensity);
		objectOutput.writeLong(cytoplasmic_itih_5_o2_density);
		objectOutput.writeLong(nuclear_itih_5_o2_intensity);
		objectOutput.writeLong(nuclear_itih_5_o2_density);
		objectOutput.writeLong(cytoplasmic_imp2_2_intensity);
		objectOutput.writeLong(cytoplasmic_imp2_2_density);
		objectOutput.writeLong(cytoplasmic_stat_1_intensity);
		objectOutput.writeLong(cytoplasmic_stat_1_density);
		objectOutput.writeLong(nuclear_stat_1_intensity);
		objectOutput.writeLong(nuclear_stat_1_density);
		objectOutput.writeLong(cytoplasmic_nfkb1_intensity);
		objectOutput.writeLong(cytoplasmic_nfkb1_density);
		objectOutput.writeLong(nuclear_nfkb1_intensity);
		objectOutput.writeLong(nuclear_nfkb1_density);
		objectOutput.writeLong(cytoplasmic_nfkb2_intensity);
		objectOutput.writeLong(cytoplasmic_nfkb2_density);
		objectOutput.writeLong(nuclear_nfkb2_intensity);
		objectOutput.writeLong(nuclear_nfkb2_density);
		objectOutput.writeLong(cytoplasmic_pikb_intensity);
		objectOutput.writeLong(cytoplasmic_pikb_density);
		objectOutput.writeLong(cytoplasmic_phoshpo_pakt_o1_intensity);
		objectOutput.writeLong(cytoplasmic_phoshpo_pakt_o1_density);
		objectOutput.writeLong(nuclear_phoshpo_pakt_o1_intensity);
		objectOutput.writeLong(nuclear_phoshpo_pakt_o1_density);
		objectOutput.writeLong(cytoplasmic_phoshpo_pakt_o2_intensity);
		objectOutput.writeLong(cytoplasmic_phoshpo_pakt_o2_density);
		objectOutput.writeLong(nuclear_phoshpo_pakt_o2_intensity);
		objectOutput.writeLong(nuclear_phoshpo_pakt_o2_density);
		objectOutput.writeLong(cytoplasmic_phoshpo_pmtor_o1_intensity);
		objectOutput.writeLong(cytoplasmic_phoshpo_pmtor_o1_density);
		objectOutput.writeLong(nuclear_phoshpo_pmtor_o1_intensity);
		objectOutput.writeLong(nuclear_phoshpo_pmtor_o1_density);
		objectOutput.writeLong(cytoplasmic_phoshpo_pmtor_o2_intensity);
		objectOutput.writeLong(cytoplasmic_phoshpo_pmtor_o2_density);
		objectOutput.writeLong(nuclear_phoshpo_pmtor_o2_intensity);
		objectOutput.writeLong(nuclear_phoshpo_pmtor_o2_density);
		objectOutput.writeLong(cytoplasmic_phoshpo_pp70s6k_o1_density);
		objectOutput.writeLong(nuclear_phoshpo_pp70s6k_o1_intensity);
		objectOutput.writeLong(nuclear_phoshpo_pp70s6k_o1_density);
		objectOutput.writeLong(cytoplasmic_phoshpo_pp70s6k_o2_intensity);
		objectOutput.writeLong(cytoplasmic_phoshpo_pp70s6k_o2_density);
		objectOutput.writeLong(nuclear_phoshpo_pp70s6k_o2_intensity);
		objectOutput.writeLong(nuclear_phoshpo_pp70s6k_o2_density);
		objectOutput.writeLong(cytoplasmic_phoshpo_pp70s6k_o1_intensity);
		objectOutput.writeLong(cytoplasmic_phoshpo_pten_o1_intensity);
		objectOutput.writeLong(cytoplasmic_phoshpo_pten_o1_density);
		objectOutput.writeLong(nuclear_phoshpo_pten_o1_intensity);
		objectOutput.writeLong(nuclear_phoshpo_pten_o1_density);
		objectOutput.writeLong(cytoplasmic_phoshpo_pten_o2_intensity);
		objectOutput.writeLong(cytoplasmic_phoshpo_pten_o2_density);
		objectOutput.writeLong(nuclear_phoshpo_pten_o2_intensity);
		objectOutput.writeLong(nuclear_phoshpo_pten_o2_density);
	}

	public long tma_Id;
	public long sample_id;
	public String tma_name;
	public String tma_number;
	public String tma_comment;
	public long cytoplasmic_stat_5_intensity;
	public long cytoplasmic_stat_5_density;
	public long nuclear_stat_5_intensity;
	public long nuclear_stat_5_density;
	public long cytoplasmic_cjun_intensity;
	public long cytoplasmic_cjun_density;
	public long nuclear_cjun_intensity;
	public long nuclear_cjun_density;
	public long cytoplasmic_pstat_3_intensity;
	public long cytoplasmic_pstat_3_density;
	public long nuclear_pstat_3_intensity;
	public long nuclear_pstat_3_density;
	public long cytoplasmic_pstat_5_intensity;
	public long cytoplasmic_pstat_5_density;
	public long nuclear_pstat_5_intensity;
	public long nuclear_pstat_5_density;
	public long cytoplasmic_pstat_1_intensity;
	public long cytoplasmic_pstat_1_density;
	public long nuclear_pstat_1_intensity;
	public long cytoplasmic_il6r_intensity;
	public long cytoplasmic_il6r_density;
	public long nuclear_il6r_intensity;
	public long nuclear_il6r_density;
	public long cytoplasmic_socs1_intensity;
	public long cytoplasmic_socs1_density;
	public long nuclear_socs1_intensity;
	public long nuclear_socs1_density;
	public long cytoplasmic_socs3_intensity;
	public long cytoplasmic_socs3_density;
	public long nuclear_socs3_intensity;
	public long nuclear_socs3_density;
	public long cytoplasmic_junb_intensity;
	public long cytoplasmic_junb_density;
	public long nuclear_junb_intensity;
	public long nuclear_junb_density;
	public long cytoplasmic_stat_3_intensity;
	public long cytoplasmic_stat_3_density;
	public long nuclear_stat_3_intensity;
	public long nuclear_stat_3_density;
	public long cytoplasmic_stat_5a_intensity;
	public long cytoplasmic_stat_5a_density;
	public long nuclear_stat_5a_intensity;
	public long nuclear_stat_5a_density;
	public long cytoplasmic_stat_5b_intensity;
	public long cytoplasmic_stat_5b_density;
	public long nuclear_stat_5b_intensity;
	public long nuclear_stat_5b_density;
	public long cytoplasmic_eif3a_intensity;
	public long cytoplasmic_eif3a_density;
	public long cytoplasmic_eif3a_peter_intensity;
	public long cytoplasmic_eif3a_peter_density;
	public long cytoplasmic_itih_5_o1_intensity;
	public long cytoplasmic_itih_5_o1_density;
	public long nuclear_itih_5_o1_intensity;
	public long nuclear_itih_5_o1_density;
	public long cytoplasmic_itih_5_o2_intensity;
	public long cytoplasmic_itih_5_o2_density;
	public long nuclear_itih_5_o2_intensity;
	public long nuclear_itih_5_o2_density;
	public long cytoplasmic_imp2_2_intensity;
	public long cytoplasmic_imp2_2_density;
	public long cytoplasmic_stat_1_intensity;
	public long cytoplasmic_stat_1_density;
	public long nuclear_stat_1_intensity;
	public long nuclear_stat_1_density;
	public long cytoplasmic_nfkb1_intensity;
	public long cytoplasmic_nfkb1_density;
	public long nuclear_nfkb1_intensity;
	public long nuclear_nfkb1_density;
	public long cytoplasmic_nfkb2_intensity;
	public long cytoplasmic_nfkb2_density;
	public long nuclear_nfkb2_intensity;
	public long nuclear_nfkb2_density;
	public long cytoplasmic_pikb_intensity;
	public long cytoplasmic_pikb_density;
	public long cytoplasmic_phoshpo_pakt_o1_intensity;
	public long cytoplasmic_phoshpo_pakt_o1_density;
	public long nuclear_phoshpo_pakt_o1_intensity;
	public long nuclear_phoshpo_pakt_o1_density;
	public long cytoplasmic_phoshpo_pakt_o2_intensity;
	public long cytoplasmic_phoshpo_pakt_o2_density;
	public long nuclear_phoshpo_pakt_o2_intensity;
	public long nuclear_phoshpo_pakt_o2_density;
	public long cytoplasmic_phoshpo_pmtor_o1_intensity;
	public long cytoplasmic_phoshpo_pmtor_o1_density;
	public long nuclear_phoshpo_pmtor_o1_intensity;
	public long nuclear_phoshpo_pmtor_o1_density;
	public long cytoplasmic_phoshpo_pmtor_o2_intensity;
	public long cytoplasmic_phoshpo_pmtor_o2_density;
	public long nuclear_phoshpo_pmtor_o2_intensity;
	public long nuclear_phoshpo_pmtor_o2_density;
	public long cytoplasmic_phoshpo_pp70s6k_o1_density;
	public long nuclear_phoshpo_pp70s6k_o1_intensity;
	public long nuclear_phoshpo_pp70s6k_o1_density;
	public long cytoplasmic_phoshpo_pp70s6k_o2_intensity;
	public long cytoplasmic_phoshpo_pp70s6k_o2_density;
	public long nuclear_phoshpo_pp70s6k_o2_intensity;
	public long nuclear_phoshpo_pp70s6k_o2_density;
	public long cytoplasmic_phoshpo_pp70s6k_o1_intensity;
	public long cytoplasmic_phoshpo_pten_o1_intensity;
	public long cytoplasmic_phoshpo_pten_o1_density;
	public long nuclear_phoshpo_pten_o1_intensity;
	public long nuclear_phoshpo_pten_o1_density;
	public long cytoplasmic_phoshpo_pten_o2_intensity;
	public long cytoplasmic_phoshpo_pten_o2_density;
	public long nuclear_phoshpo_pten_o2_intensity;
	public long nuclear_phoshpo_pten_o2_density;
}