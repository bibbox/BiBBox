package com.bcnet.portlet.biobank.service.persistence;

import java.math.BigInteger;
import java.util.List;

import com.bcnet.portlet.biobank.model.Biobank;
import com.bcnet.portlet.biobank.model.impl.BiobankImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class BiobankFinderImpl extends BasePersistenceImpl<Biobank> implements BiobankFinder {
	
	private static final String FIND_BY_CODE_ACRONYM_NAME_COUNTRY = "com.bcnet.portlet.biobank.service.persistence.BiobankFinder.findByCodeAcronymNameCountry";
	private static final String COUNT_BY_CODE_ACRONYM_NAME_COUNTRY = "com.bcnet.portlet.biobank.service.persistence.BiobankFinder.countByCodeAcronymNameCountry";
	
	public List<Biobank> findByCodeAcronymNameCountry(String code, String acronym, String name, String countryCode, int begin, int end){
		
		Session session = null;
	    try {
	        session = openSession();
	        System.out.print("----Queryparams: " + code +"," + acronym + ", " + name + ", " + countryCode );
	        String sql = CustomSQLUtil.get(FIND_BY_CODE_ACRONYM_NAME_COUNTRY);
	        sql = CustomSQLUtil.replaceAndOperator(sql, true);
	        System.out.println("+++++++++++++++++Query: "  + sql);
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("biobank", BiobankImpl.class);

	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add("%" + code + "%");
	        qPos.add(code);
	        qPos.add("%" + acronym + "%");
	        qPos.add(acronym);
	        qPos.add("%" + name + "%");
	        qPos.add(name);
	        qPos.add(countryCode);
	        qPos.add(countryCode);

	        return (List<Biobank>) QueryUtil.list(q, getDialect(), begin, end);
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
	
	
	
	public int countByCodeAcronymNameCountry(String code, String acronym, String name, String countryCode){
		
		Session session = null;
	    try {
	        session = openSession();
	        System.out.print("----Queryparams: " + code +"," + acronym + ", " + name + ", " + countryCode );
	        String sql = CustomSQLUtil.get(COUNT_BY_CODE_ACRONYM_NAME_COUNTRY);
	        sql = CustomSQLUtil.replaceAndOperator(sql, true);
	        System.out.println("+++++++++++++++++Query: "  + sql);
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        

	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add("%" + code + "%");
	        qPos.add(code);
	        qPos.add("%" + acronym + "%");
	        qPos.add(acronym);
	        qPos.add("%" + name + "%");
	        qPos.add(name);
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
}
