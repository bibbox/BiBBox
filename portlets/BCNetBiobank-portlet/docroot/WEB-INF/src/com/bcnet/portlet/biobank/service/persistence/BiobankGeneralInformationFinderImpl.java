package com.bcnet.portlet.biobank.service.persistence;

import java.math.BigInteger;
import java.util.List;

import com.bcnet.portlet.biobank.model.BiobankGeneralInformation;
import com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsImpl;
import com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class BiobankGeneralInformationFinderImpl extends BasePersistenceImpl<BiobankGeneralInformation> implements BiobankGeneralInformationFinder{

	private static final String FIND_BY_ID_ACRONYM_NAME_COUNTRY = "com.bcnet.portlet.biobank.service.persistence.BiobankGeneralInformationFinder.findByIdAcronymNameCountry";
	private static final String COUNT_BY_ID_ACRONYM_NAME_COUNTRY = "com.bcnet.portlet.biobank.service.persistence.BiobankGeneralInformationFinder.countByIdAcronymNameCountry";
	private static final String FIND_BIOBANKS_BY_KEYWORD_COUNTRY = "com.bcnet.portlet.biobank.service.persistence.BiobankGeneralInformationFinder.findBiobanksByKeywordsCountry";

	
	public List<BiobankGeneralInformation> findByIdAcronymNameCountry(String code, String acronym, String name, String countryCode, int begin, int end){
		
		Session session = null;
	    try {
	        session = openSession();
	        System.out.print("----Queryparams: " + code +"," + acronym + ", " + name + ", " + countryCode );
	        String sql = CustomSQLUtil.get(FIND_BY_ID_ACRONYM_NAME_COUNTRY);
	        sql = CustomSQLUtil.replaceAndOperator(sql, true);
	        System.out.println("+++++++++++++++++Query: "  + sql);
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("biobankGeneralInformation", BiobankGeneralInformationImpl.class);

	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add("%" + code + "%");
	        qPos.add(code);
	        qPos.add("%" + acronym + "%");
	        qPos.add(acronym);
	        //qPos.add("%" + name + "%");
	        //qPos.add(name);
	        qPos.add(countryCode);
	        qPos.add(countryCode);

	        return (List<BiobankGeneralInformation>) QueryUtil.list(q, getDialect(), begin, end);
	    } catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        } catch (SystemException se) {
	            se.printStackTrace();
	        }
	    } finally {
	        closeSession(session);
	    }

	    return null;
	}
	
	
	
	public int countByIdAcronymNameCountry(String code, String acronym, String name, String countryCode){
		
		Session session = null;
	    try {
	        session = openSession();
	        System.out.print("----Queryparams: " + code +"," + acronym + ", " + name + ", " + countryCode );
	        String sql = CustomSQLUtil.get(COUNT_BY_ID_ACRONYM_NAME_COUNTRY);
	        sql = CustomSQLUtil.replaceAndOperator(sql, true);
	        System.out.println("+++++++++++++++++Query: "  + sql);
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        

	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add("%" + code + "%");
	        qPos.add(code);
	        qPos.add("%" + acronym + "%");
	        qPos.add(acronym);
	        //qPos.add("%" + name + "%");
	        //qPos.add(name);
	        qPos.add(countryCode);
	        qPos.add(countryCode);

	        BigInteger count = (BigInteger)q.uniqueResult();
            return count.intValue();
	    } catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        } catch (SystemException se) {
	            se.printStackTrace();
	        }
	    } finally {
	        closeSession(session);
	    }
		return 0;
	}

	
	
	public List<BiobankGeneralInformation> findBiobanksByKeywordsCountry(String[] partskeywords, String countryCode, int begin, int end){
		
		Session session = null;
	    try {
	        session = openSession();
	        System.out.print("----Queryparams: ");
	        for(String str:partskeywords){
	        	System.out.print(str+", ");
	        }
	        System.out.println(countryCode);
	        
	        System.out.println(partskeywords.length);
	        
	        String sql = CustomSQLUtil.get(FIND_BIOBANKS_BY_KEYWORD_COUNTRY);
	        
	        sql = CustomSQLUtil.replaceAndOperator(sql, true);
	        
	        String nameConcatStr = "";
	        String biobankIdConcatStr = "";
	        String acronymConcatStr = "";
	        String attributeListNameConcatStr = "";
	        String attributeListValueConcatStr = "";
	        
	        for(String str:partskeywords){
	        	nameConcatStr += "organization_.name LIKE ? OR ";
	        	biobankIdConcatStr += "biobank.biobankId LIKE ? OR ";
	        	acronymConcatStr += "biobank.acronym LIKE ? OR ";
	        	attributeListNameConcatStr += "biobankattributelists.attributeListName LIKE ? OR ";
	        	attributeListValueConcatStr += "biobankattributelists.attributeListValue LIKE ? OR ";
	        	
	        }
	        
	        
	        sql = StringUtil.replace(sql, "(organization_.name LIKE ? OR ? IS NULL) AND", "("+nameConcatStr+"? IS NULL) OR");
	        sql = StringUtil.replace(sql, "(biobank.biobankId LIKE ? OR ? IS NULL) AND", "("+biobankIdConcatStr+"? IS NULL) OR");
	        sql = StringUtil.replace(sql, "(biobank.acronym LIKE ? OR ? IS NULL) AND", "("+acronymConcatStr+"? IS NULL) OR");
	        sql = StringUtil.replace(sql, "(biobankattributelists.attributeListName LIKE ? OR ? IS NULL) AND", "("+attributeListNameConcatStr+"? IS NULL) OR");
	        sql = StringUtil.replace(sql, "(biobankattributelists.attributeListValue LIKE ? OR ? IS NULL)) AND", "("+attributeListValueConcatStr+"? IS NULL)) AND");
	        
	        System.out.println("+++++++++++++++++Query: "  + sql);
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("BiobankGeneralInformation", BiobankGeneralInformationImpl.class);
	        //q.addEntity("Organization_", PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portal.model.impl.OrganizationImpl"));
	        //q.addEntity("BiobankAttributeLists", BiobankAttributeListsImpl.class);

	        QueryPos qPos = QueryPos.getInstance(q);
	        
	        //Adding query parameters for organization_.name
	        for(int i=0; i<partskeywords.length; i++){
	        	qPos.add("%" + partskeywords[i] + "%");
	        	if(i==partskeywords.length-1){
	        		qPos.add(partskeywords[i]);
	        	}
	        }
	        
	        //Adding query parameters for biobank.biobankId
	        for(int i=0; i<partskeywords.length; i++){
	        	qPos.add("%" + partskeywords[i] + "%");
	        	if(i==partskeywords.length-1){
	        		qPos.add(partskeywords[i]);
	        	}
	        }
	        
	        //Adding query parameters for biobank.acronym
	        for(int i=0; i<partskeywords.length; i++){
	        	qPos.add("%" + partskeywords[i] + "%");
	        	if(i==partskeywords.length-1){
	        		qPos.add(partskeywords[i]);
	        	}
	        }
	        
	        //Adding query parameters for biobankattributelists.attributeListName
	        for(int i=0; i<partskeywords.length; i++){
	        	qPos.add("%" + partskeywords[i] + "%");
	        	if(i==partskeywords.length-1){
	        		qPos.add(partskeywords[i]);
	        	}
	        }
	        
	        
	        //Adding query parameters for biobankattributelists.attributeListValue
	        for(int i=0; i<partskeywords.length; i++){
	        	qPos.add("%" + partskeywords[i] + "%");
	        	if(i==partskeywords.length-1){
	        		qPos.add(partskeywords[i]);
	        	}
	        }
	        
	        //Adding query parameters for biobank.countryCode
	        qPos.add(countryCode);
	        qPos.add(countryCode);

	        return (List<BiobankGeneralInformation>) QueryUtil.list(q, getDialect(), begin, end);
	    } catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        } catch (SystemException se) {
	            se.printStackTrace();
	        }
	    } finally {
	        closeSession(session);
	    }

	    return null;
	}
}
