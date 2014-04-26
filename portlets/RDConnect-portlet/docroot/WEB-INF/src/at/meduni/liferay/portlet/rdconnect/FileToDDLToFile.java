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
import java.util.ArrayList;
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

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import au.com.bytecode.opencsv.CSVReader;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.EmailAddress;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordConstants;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FileToDDLToFile
 */
public class FileToDDLToFile extends MVCPortlet {
	private ThemeDisplay themeDisplay = null;
	
	public void uploadFile(ActionRequest request, ActionResponse response) throws Exception {
	try {
		long organisation_id = ParamUtil.getLong(request, "rdc_organisation_id");
		System.out.println("Organisation_id: " + organisation_id);
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
			readXLSFile(inputStream, organisation_id);
		} else if(upreq.getFileName("fileupload").endsWith(".xlsx")) {
			readXLSXFile(inputStream);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

private void readXLSFile(InputStream file, long organizationId) throws IOException, PortalException, SystemException {
	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
	List<Long> record_id_list =  new ArrayList<Long>();
	
	ServiceContext serviceContext = new ServiceContext();

    serviceContext.setAddGroupPermissions(true);
    serviceContext.setAddGuestPermissions(true);
    Group group = organization.getGroup();
    serviceContext.setScopeGroupId(group.getGroupId());
    serviceContext.setUserId(organization.getUserId());
	
	for(DDLRecordSet rdc_rs : rdc_recordlist) {
		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		if(rdc_rsname.equals("Disease Matrix")) {
			// ------
			// Get all Record Ids
			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				record_id_list.add(record.getRecordId());
  			}
  			// ------
  			// Read xls entrys
  			//Get the workbook instance for XLS file 
  			HSSFWorkbook workbook = new HSSFWorkbook(file);
  			//Get first sheet from the workbook
  			HSSFSheet sheet = workbook.getSheet("Disease Matrix");
  			//Get iterator to all the rows in current sheet
  			Iterator<Row> rowIterator = sheet.iterator();	
  			boolean header = true;
  			Map<Integer, String> headers = new HashMap<Integer, String>();
  			while(rowIterator.hasNext()) {
  		        Row row = rowIterator.next();
  		        int cellcounter = 0;
  		        if(header) {
  		        	Iterator<Cell> cellIterator = row.cellIterator();
  	  		        while(cellIterator.hasNext()) { 
  	  		            Cell cell = cellIterator.next();
  	  		            headers.put(cellcounter, cell.getStringCellValue());
  	  		            cellcounter++;
  	  		        }
  		        	header = false;
  		        	continue;
  		        }
  		        // Create Fields or Load Fields
  		        Cell cell_id = row.getCell(0);
  		        Fields fields;
  		        if(cell_id.getCellType() != Cell.CELL_TYPE_NUMERIC) {		
  					fields = DDMUtil.getFields(rdc_rs.getDDMStructureId(), serviceContext);
  					DDLRecordLocalServiceUtil.addRecord(
  							serviceContext.getUserId(),
  							serviceContext.getScopeGroupId(), rdc_rs.getRecordSetId(),
  							DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
  							serviceContext);
  		        } else {
  		        	long record_id_in_table = (long)cell_id.getNumericCellValue();
  		        	if(record_id_list.contains(record_id_in_table)) {
  		        		record_id_list.remove(record_id_in_table);
  		        		fields = DDLRecordLocalServiceUtil.getRecord(record_id_in_table).getFields();
  		        	} else {
  		        		fields = DDMUtil.getFields(rdc_rs.getDDMStructureId(), serviceContext);
  		        		DDLRecordLocalServiceUtil.addRecord(
  	  							serviceContext.getUserId(),
  	  							serviceContext.getScopeGroupId(), rdc_rs.getRecordSetId(),
  	  							DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
  	  							serviceContext);
  		        	}
  		        }
  		        //For each row, iterate through each columns
  		        Iterator<Cell> cellIterator = row.cellIterator();
  		        while(cellIterator.hasNext()) {
  		        	if(cellcounter == 0) {
  		        		cellcounter++;
  		        		continue;
  		        	}
  		        	Field tmp_field = null;
  		            Cell cell = cellIterator.next();   
  		            switch(cell.getCellType()) {
  		                case Cell.CELL_TYPE_NUMERIC:
  		                	tmp_field = new Field(headers.get(cellcounter), cell.getNumericCellValue());
  		                    break;
  		                case Cell.CELL_TYPE_STRING:
  		                	tmp_field = new Field(headers.get(cellcounter), cell.getStringCellValue());
  		                    break;
  		            }
  		            fields.put(tmp_field);
  		            cellcounter++;
  		        }
  		        DDLRecordLocalServiceUtil.updateRecord(serviceContext.getUserId(), rdc_rs.getRecordSetId(), true, DDLRecordConstants.DISPLAY_INDEX_DEFAULT, 
  		        		fields, false, serviceContext);
  		    }
  		    file.close();
  		    for(long record_id_remove : record_id_list) {
  		    	DDLRecordLocalServiceUtil.deleteRecord(record_id_remove);
  		    }
		}
	}
	
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
  			// Create id field
  			Cell cell_id_field = row.createCell(cellnum++);
  			cell_id_field.setCellValue("Disease Matrix Id");
  			for(String fieldname : fieldnames) {
  				if(!fieldname.equalsIgnoreCase("_fieldsDisplay")) {
	  				Cell cell = row.createCell(cellnum++);
	  				String local_filedname = rdc_rs.getDDMStructure().getFieldLabel(fieldname, themeDisplay.getLocale());
	  				cell.setCellValue(local_filedname);
  				}
  			}
  			
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				cellnum = 0;
  				row = sheet.createRow(rownum++);
  				cell_id_field = row.createCell(cellnum++);
  				cell_id_field.setCellValue(record.getRecordId());
  				for(String fieldname : fieldnames) {
  					if(!fieldname.equalsIgnoreCase("_fieldsDisplay")) {
	  					String fieldvalue = "";
	  					if(record.getFieldValue(fieldname) != null) {
	  						fieldvalue = record.getFieldValue(fieldname).toString();
	  					}
	  					Cell cell = row.createCell(cellnum++);
		  				cell.setCellValue(fieldvalue);
  					}
  				}
  			}
  		}
  	}
	return workbook;
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

private Workbook writeXLSXFile(long organizationId) throws PortalException, SystemException {
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Disease Matrix");
	
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
  				if(!fieldname.equalsIgnoreCase("_fieldsDisplay")) {
	  				Cell cell = row.createCell(cellnum++);
	  				String local_filedname = rdc_rs.getDDMStructure().getFieldLabel(fieldname, themeDisplay.getLocale());
	  				cell.setCellValue(local_filedname);
  				}
  			}
  			
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				cellnum = 0;
  				row = sheet.createRow(rownum++);
  				for(String fieldname : fieldnames) {
  					if(!fieldname.equalsIgnoreCase("_fieldsDisplay")) {
	  					String fieldvalue = "";
	  					if(record.getFieldValue(fieldname) != null) {
	  						fieldvalue = record.getFieldValue(fieldname).toString();
	  					}
	  					Cell cell = row.createCell(cellnum++);
		  				cell.setCellValue(fieldvalue);
  					}
  				}
  			}
  		}
  	}
	/*
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
	}*/
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
	themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
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
		Workbook wb;
		try {
			wb = writeXLSXFile(organizationId);
			wb.write(out);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	out.flush();
	out.close();
}

}
