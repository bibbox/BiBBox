package at.meduni.liferay.portlet.rdconnect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/*import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import au.com.bytecode.opencsv.CSVReader;*/

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FileToDDLToFile
 */
public class FileToDDLToFile extends MVCPortlet {
	/*public void uploadFile(ActionRequest request, ActionResponse response) throws Exception {
	try {
		UploadPortletRequest upreq = PortalUtil.getUploadPortletRequest(request);
		System.out.println(upreq.getFileName("fileupload"));
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(upreq.getFile("fileupload"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error on Reading File"+e.getMessage());
		}
		
		System.out.println(upreq.getContentType("fileupload"));
		
		if(upreq.getFileName("fileupload").endsWith(".csv")) {
			BufferedReader file = new BufferedReader(new InputStreamReader(inputStream));
			//readCsvFile(file);
		} else if(upreq.getFileName("fileupload").endsWith(".xls")) {
			readXLSFile(inputStream);
		} else if(upreq.getFileName("fileupload").endsWith(".xlsx")) {
			readXLSXFile(inputStream);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

private void readXLSFile(InputStream file) throws IOException {
	//Get the workbook instance for XLS file 
	HSSFWorkbook workbook = new HSSFWorkbook(file);
	 
	//Get first sheet from the workbook
	HSSFSheet sheet = workbook.getSheetAt(0);
	 
	//Get iterator to all the rows in current sheet
	Iterator<Row> rowIterator = sheet.iterator();
	 
	while(rowIterator.hasNext()) {
        Row row = rowIterator.next();
         
        //For each row, iterate through each columns
        Iterator<Cell> cellIterator = row.cellIterator();
        while(cellIterator.hasNext()) {
             
            Cell cell = cellIterator.next();
             
            switch(cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    System.out.print(cell.getBooleanCellValue() + "\t\t");
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(cell.getNumericCellValue() + "\t\t");
                    break;
                case Cell.CELL_TYPE_STRING:
                    System.out.print(cell.getStringCellValue() + "\t\t");
                    break;
            }
        }
        System.out.println("");
    }
    file.close();
}

private void createDiseasMatrixRows() {
	
}

private Workbook writeXLSFile(long organizationId) throws PortalException, SystemException {
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("Disease Matrix");
	
	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
	int rownum = 0;
  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
  		if(rdc_rsname.equals("Disease Matrix")) {
  			Set<String> fieldnames = rdc_rs.getDDMStructure().getFieldNames();
  			Row row = sheet.createRow(rownum++);
  			int cellnum = 0;
  			for(String fieldname : fieldnames) {
  				Cell cell = row.createCell(cellnum++);
  				cell.setCellValue(fieldname);
  			}
  			
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				row = sheet.createRow(rownum++);
  				for(String fieldname : fieldnames) {
  					String fieldvalue = record.getFieldValue(fieldname).toString();
  					Cell cell = row.createCell(cellnum++);
	  				cell.setCellValue(fieldvalue);
  				}
  			}
  		}
  	}*/
	/* 
	Map<String, Object[]> data = new HashMap<String, Object[]>();
	data.put("1", new Object[] {"Emp No.", "Name", "Salary"});
	data.put("2", new Object[] {1d, "John", 1500000d});
	data.put("3", new Object[] {2d, "Sam", 800000d});
	data.put("4", new Object[] {3d, "Dean", 700000d});
	 
	Set<String> keyset = data.keySet();
	int rownum = 0;
	for (String key : keyset) {
	    Row row = sheet.createRow(rownum++);
	    Object [] objArr = data.get(key);
	    int cellnum = 0;
	    for (Object obj : objArr) {
	        Cell cell = row.createCell(cellnum++);
	        if(obj instanceof Date) 
	            cell.setCellValue((Date)obj);
	        else if(obj instanceof Boolean)
	            cell.setCellValue((Boolean)obj);
	        else if(obj instanceof String)
	            cell.setCellValue((String)obj);
	        else if(obj instanceof Double)
	            cell.setCellValue((Double)obj);
	    }
	}*/
	/*return workbook;
}

private void readXLSXFile(InputStream file) throws IOException {
	//Get the workbook instance for XLS file 
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	//Get first sheet from the workbook
	XSSFSheet sheet = workbook.getSheetAt(0);
	//Get iterator to all the rows in current sheet
	Iterator<Row> rowIterator = sheet.iterator();
	while(rowIterator.hasNext()) {
        Row row = rowIterator.next();     
        //For each row, iterate through each columns
        Iterator<Cell> cellIterator = row.cellIterator();
        while(cellIterator.hasNext()) {       
            Cell cell = cellIterator.next();             
            switch(cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    System.out.print(cell.getBooleanCellValue() + "\t\t");
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(cell.getNumericCellValue() + "\t\t");
                    break;
                case Cell.CELL_TYPE_STRING:
                    System.out.print(cell.getStringCellValue() + "\t\t");
                    break;
            }
        }
        System.out.println("");
    }
    file.close();
}

private Workbook writeXLSXFile() {
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Sample sheet");
	 
	Map<String, Object[]> data = new HashMap<String, Object[]>();
	data.put("1", new Object[] {"Emp No.", "Name", "Salary"});
	data.put("2", new Object[] {1d, "John", 1500000d});
	data.put("3", new Object[] {2d, "Sam", 800000d});
	data.put("4", new Object[] {3d, "Dean", 700000d});
	 
	Set<String> keyset = data.keySet();
	int rownum = 0;
	for (String key : keyset) {
	    Row row = sheet.createRow(rownum++);
	    Object [] objArr = data.get(key);
	    int cellnum = 0;
	    for (Object obj : objArr) {
	        Cell cell = row.createCell(cellnum++);
	        if(obj instanceof Date) 
	            cell.setCellValue((Date)obj);
	        else if(obj instanceof Boolean)
	            cell.setCellValue((Boolean)obj);
	        else if(obj instanceof String)
	            cell.setCellValue((String)obj);
	        else if(obj instanceof Double)
	            cell.setCellValue((Double)obj);
	    }
	}
	return workbook;
}

private void readCsvFile(BufferedReader file) throws IOException {
	CSVReader csv = new CSVReader(file);
	String [] nextLine;
    while ((nextLine = csv.readNext()) != null) {
        // nextLine[] is an array of values from the line
        System.out.println(nextLine[0] + nextLine[1] + "etc...");
    }
}

@Override
public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException {
	String cmd = request.getParameter(Constants.CMD);
	long organizationId = Long.valueOf(request.getParameter("RDCOrganisationId"));
	System.out.println(cmd);
	
	String fileName = "RDConnect_DeaseasMatrix.";
	OutputStream out = response.getPortletOutputStream();
	byte[] bytes;
	
	
	if(cmd.equalsIgnoreCase("export_csv")) {
		fileName += "csv";
		response.setContentType("application/vnd.ms-excel");
		response.addProperty("Content-disposition", "atachment; filename="+fileName);
		// Convert String to bytes 
		String sampleContent ="Spring MVC portlet : File upload and download example";
		bytes = sampleContent.getBytes();
		out.write(bytes);
	} else if(cmd.equalsIgnoreCase("export_xls")) {
		fileName += "xls";
		response.setContentType("application/vnd.ms-excel");
		response.addProperty("Content-disposition", "atachment; filename="+fileName);
		Workbook wb;
		try {
			wb = writeXLSFile(organizationId);
			wb.write(out);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	} else if(cmd.equalsIgnoreCase("export_xlsx")) {
		fileName += "xlsx";
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.addProperty("Content-disposition", "atachment; filename="+fileName);
		Workbook wb = writeXLSXFile();
		wb.write(out);
	}
	out.flush();
	out.close();
}*/

}
