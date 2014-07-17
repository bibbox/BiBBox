package at.meduni.graz.patho.haybaeck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class TMA
 */
public class TMA extends MVCPortlet {
	private String sheet_ = "Auswertung Immunhisto";
	
	public void uploadFile(ActionRequest request, ActionResponse response)
			throws Exception {
		UploadPortletRequest upreq = PortalUtil
				.getUploadPortletRequest(request);
		String filename = upreq.getFileName("fileupload");
		System.out.println(filename);
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(upreq.getFile("fileupload"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error on Reading File " + filename + " "
					+ e.getMessage());
		}
		if (upreq.getFileName("fileupload").endsWith(".xls")) {
			readXLSFile(inputStream);
		} else if (upreq.getFileName("fileupload").endsWith(".xlsx")) {
			readXLSXFile(inputStream);
		}
		inputStream.close();
	}

	private void readXLSXFile(InputStream file) throws IOException {
		//Get the workbook instance for XLSX file 
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		//Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheet(sheet_);
		//Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		//Common for XLS and XLSX
		readRowContent(rowIterator);
	}

	private void readXLSFile(InputStream file) throws IOException {
		// Get the workbook instance for XLS file
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		// Get first sheet from the workbook
		HSSFSheet sheet = workbook.getSheet(sheet_);
		// Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		//Common for XLS and XLSX
		readRowContent(rowIterator);
	}

	private void readRowContent(Iterator<Row> rowIterator) {
		boolean header = true;
		Map<Integer, String> headers = new HashMap<Integer, String>();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next(); 
			Iterator<Cell> cellIterator = row.cellIterator();
			int cellcounter = 0;
			if (header) {
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					headers.put(cellcounter, cell.getStringCellValue());
					System.out.println("Header: " + cellcounter + ":" + cell.getStringCellValue());
					cellcounter++;
				}
				header = false;
			} else {
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
		}
	}

}
