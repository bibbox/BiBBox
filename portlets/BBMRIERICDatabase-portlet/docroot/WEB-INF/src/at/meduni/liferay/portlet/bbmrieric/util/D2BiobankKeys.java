package at.meduni.liferay.portlet.bbmrieric.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.DiseaseDiscriptionLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

public class D2BiobankKeys {
	/**
	 * Error Format for date
	 */
	static String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	static SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	static String classpath_ = "BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.util.D2BiobankKeys";
	
	public static final String[] getMaterialTypes() {
		String[] return_value = {"Plasma","Serum","Urine","Saliva","Faeces","RNA","Blood","Tissue Frozen","Tissue FFPE","Immortalized Cell Lines","Isolated Pathogen"};
		try {
			DynamicQuery dynamicQuery = D2CollectionLocalServiceUtil.dynamicQuery();
			ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
			projectionList.add(ProjectionFactoryUtil.groupProperty("materialStoredOther"));
		    dynamicQuery.setProjection(projectionList);
		    List<Object> results = D2CollectionLocalServiceUtil.dynamicQuery(dynamicQuery);
		    String[] searchresult = results.toArray(new String[results.size()]);
		    List<String> both = new ArrayList<String>(return_value.length + searchresult.length);
		    Collections.addAll(both, return_value);
		    Collections.addAll(both, searchresult);
		    return both.toArray(new String[both.size()]);
		} catch(Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::getMaterialTypes] Error creating Material Type List.");
			ex.printStackTrace();
		}
		return return_value;
	}
	
	public static final String[] getCountries() {
		try {
			DynamicQuery dynamicQuery = D2BiobankLocalServiceUtil.dynamicQuery();
			ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
			projectionList.add(ProjectionFactoryUtil.groupProperty("biobankCountry"));
		    dynamicQuery.setProjection(projectionList);
		    dynamicQuery.addOrder(OrderFactoryUtil.asc("biobankCountry"));
		    List<Object> results = D2BiobankLocalServiceUtil.dynamicQuery(dynamicQuery);
		    return results.toArray(new String[results.size()]);
		} catch(Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::getMaterialTypes] Error creating Material Type List.");
			ex.printStackTrace();
		}
		return new String[] {};
	}
	
	public static final String[] getTypeOfBiobank() {
		String[] return_value = {"Clinical","Population","Research Study","Non Human","Standalone Collection"};
		return return_value;
	}
	
	public static final String[] getTypeOfCollection() {
		String[] return_value = {"Case Control","Cohort","Cross Sectional","Longitudinal","Twin Study","Quality Control","Population Based","Disease Specific","Birth Cohort"};
		try {
			DynamicQuery dynamicQuery = D2CollectionLocalServiceUtil.dynamicQuery();
			ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
			projectionList.add(ProjectionFactoryUtil.groupProperty("collectionTypeOther"));
		    dynamicQuery.setProjection(projectionList);
		    List<Object> results = D2CollectionLocalServiceUtil.dynamicQuery(dynamicQuery);
		    String[] searchresult = results.toArray(new String[results.size()]);
		    List<String> both = new ArrayList<String>(return_value.length + searchresult.length);
		    Collections.addAll(both, return_value);
		    Collections.addAll(both, searchresult);
		    return both.toArray(new String[both.size()]);
		} catch(Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::getMaterialTypes] Error creating Material Type List.");
			ex.printStackTrace();
		}
		return return_value;
	}
	
	public static final String[] getBiobankSize() {
		return new String[] {"< 10 Samples",
		"10 - 100 Samples",
		"100 - 1.000 Samples",
		"1.000 - 10.000 Samples",
		"10.000 - 100.000 Samples",
		"100.000 - 1.000.000 Samples",
		"1.000.000 - 10.000.000 Samples",
		"10.000.000 - 100.000.000 Samples",
		"100.000.000 - 1.000.000.000 Samples"};	
	}
	
	public static final long getBiobankSizeFromSelect(String size) {
		long sizeresult = 0;
		if (size.equals("< 10 Samples")) {
			sizeresult = 0;
		}
		if (size.equals("10 - 100 Samples")) {
			sizeresult = 1;
		}
		if (size.equals("100 - 1.000 Samples")) {
			sizeresult = 2;
		}
		if (size.equals("1.000 - 10.000 Samples")) {
			sizeresult = 3;
		}
		if (size.equals("10.000 - 100.000 Samples")) {
			sizeresult = 4;
		}
		if (size.equals("100.000 - 1.000.000 Samples")) {
			sizeresult = 5;
		}
		if (size.equals("1.000.000 - 10.000.000 Samples")) {
			sizeresult = 6;
		}
		if (size.equals("10.000.000 - 100.000.000 Samples")) {
			sizeresult = 7;
		}
		if (size.equals("100.000.000 - 1.000.000.000 Samples")) {
			sizeresult = 8;
		}
		return sizeresult;
	}
	
	public static final String[] getDiagnosisAvailable() {
		try {
			LinkedHashSet<String> resultcleand = new LinkedHashSet<String>();
			List<DiseaseDiscription> diseasediscriptions = DiseaseDiscriptionLocalServiceUtil.getRootEntrys();
			for(DiseaseDiscription diseasediscription : diseasediscriptions) {
				resultcleand.add(diseasediscription.getDiseasecode() + " (" + diseasediscription.getDiseasediscription() + ")");
				for(DiseaseDiscription diseasediscription_sub : DiseaseDiscriptionLocalServiceUtil.getDiseaseDiscriptionByGroup(diseasediscription.getDiseasecode())) {
					resultcleand.add("- " + diseasediscription_sub.getDiseasecode() + " (" + diseasediscription_sub.getDiseasediscription() + ")");
					for(DiseaseDiscription diseasediscription_sub_sub : DiseaseDiscriptionLocalServiceUtil.getDiseaseDiscriptionByGroup(diseasediscription_sub.getDiseasecode())) {
						resultcleand.add("-- " + diseasediscription_sub_sub.getDiseasecode() + " (" + diseasediscription_sub_sub.getDiseasediscription() + ")");
					}
				}
			}
		    return resultcleand.toArray(new String[resultcleand.size()]);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return new String[] {};
	}
}
