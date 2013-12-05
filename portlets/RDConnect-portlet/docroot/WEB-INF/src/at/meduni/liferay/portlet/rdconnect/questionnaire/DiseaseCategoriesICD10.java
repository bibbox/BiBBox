package at.meduni.liferay.portlet.rdconnect.questionnaire;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.bookmarks.util.comparator.EntryModifiedDateComparator;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.util.comparator.DDLRecordVersionVersionComparator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DiseaseCategoriesICD10
 */
public class DiseaseCategoriesICD10 extends MVCPortlet {
	public static void getAllDDDLRecorsForDiseaseCategories() {
		System.out.println("Bingo");
		try {
			System.out.println("getCompanyRecordsCount " + DDLRecordLocalServiceUtil.getCompanyRecordsCount((long)14503, -1, -1));
			List<DDLRecord> ddlrecords = DDLRecordLocalServiceUtil.getRecords((long) 14503) ;//.getRecords((long)14503,-1,-1,50, new DDLRecordVersionVersionComparator());
			System.out.println("Count of ddlRecords" + ddlrecords.size());
			List<DDLRecord> ddlrecords2 = DDLRecordLocalServiceUtil.getRecords((long) 10154) ;//.getRecords((long)14503,-1,-1,50, new DDLRecordVersionVersionComparator());
			System.out.println("Count of ddlRecords" + ddlrecords2.size());
			List<DDLRecord> ddlrecords3 = DDLRecordLocalServiceUtil.getRecords((long) 10194) ;//.getRecords((long)14503,-1,-1,50, new DDLRecordVersionVersionComparator());
			System.out.println("Count of ddlRecords" + ddlrecords3.size());
			List<DDLRecord> ddlrecords4 = DDLRecordLocalServiceUtil.getRecords((long) 14502) ;//.getRecords((long)14503,-1,-1,50, new DDLRecordVersionVersionComparator());
			System.out.println("Count of ddlRecords" + ddlrecords4.size());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
