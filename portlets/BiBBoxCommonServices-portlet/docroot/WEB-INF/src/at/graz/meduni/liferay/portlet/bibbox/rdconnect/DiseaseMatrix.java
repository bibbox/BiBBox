package at.graz.meduni.liferay.portlet.bibbox.rdconnect;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
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
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DiseaseMatrix
 */
public class DiseaseMatrix extends MVCPortlet {
	/**
	 * Adds a new DiseaseMatrix to the database
	 * 
	 */
	public void addDiseaseMatrix(ActionRequest request, ActionResponse response) throws Exception {

		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrix = DiseaseMatrixLocalServiceUtil.diseaseMatrixFromRequest(request);
		DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix);

		sendRedirect(request, response);
	}

	/**
	 * Updates the database record of an existing DiseaseMatrix.
	 * 
	 */
	public void updateDiseaseMatrix(ActionRequest request, ActionResponse response) throws Exception {

		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrix = DiseaseMatrixLocalServiceUtil.diseaseMatrixFromRequest(request);
		DiseaseMatrixLocalServiceUtil.updateDiseaseMatrix(diseasematrix);
		sendRedirect(request, response);
	}

	/**
	 * Deletes a DiseaseMatrix from the database.
	 * 
	 */
	public void deleteDiseaseMatrix(ActionRequest request, ActionResponse response) throws Exception {

		long diseasematrixId = ParamUtil.getLong(request, "diseasematrixId");
		DiseaseMatrixLocalServiceUtil.deleteDiseaseMatrix(diseasematrixId);
		sendRedirect(request, response);
	}

	/**
	 * serveResource for Downloading
	 */
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = request.getParameter(Constants.CMD);
		long organizationId = Long.valueOf(request.getParameter("RDCOrganisationId"));
		String fileName = "RDConnect_DeaseasMatrix.";
		OutputStream out = response.getPortletOutputStream();
		byte[] bytes;
		fileName += "xls";
		response.setContentType("application/vnd.ms-excel");
		response.addProperty("Content-disposition", "atachment; filename=" + fileName);
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
		out.flush();
		out.close();
	}

	/**
	 * XLS creator
	 * 
	 * @param organizationId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private Workbook writeXLSFile(long organizationId) throws PortalException, SystemException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Disease Matrix");

		Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
		List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> diseasematrixlist = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organizationId, -1, -1);
		int rownum = 0;

		Row row = sheet.createRow(rownum++);
		Cell cell = row.createCell(0);
		cell.setCellValue("diseasematrixId");
		cell = row.createCell(1);
		cell.setCellValue("diseasename");
		cell = row.createCell(2);
		cell.setCellValue("patientcount");
		cell = row.createCell(3);
		cell.setCellValue("gene");
		cell = row.createCell(4);
		cell.setCellValue("icd10");
		cell = row.createCell(5);
		cell.setCellValue("omim");
		cell = row.createCell(6);
		cell.setCellValue("synonym");

		for (at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrix : diseasematrixlist) {
			row = sheet.createRow(rownum++);
			cell = row.createCell(0);
			cell.setCellValue(diseasematrix.getDiseasematrixId());
			cell = row.createCell(1);
			cell.setCellValue(diseasematrix.getDiseasename());
			cell = row.createCell(2);
			cell.setCellValue(diseasematrix.getPatientcount());
			cell = row.createCell(3);
			cell.setCellValue(diseasematrix.getGene());
			cell = row.createCell(4);
			cell.setCellValue(diseasematrix.getIcd10());
			cell = row.createCell(5);
			cell.setCellValue(diseasematrix.getOmim());
			cell = row.createCell(6);
			cell.setCellValue(diseasematrix.getSynonym());
		}
		return workbook;
	}

	/**
	 * uploadFile excel file
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void uploadFile(ActionRequest request, ActionResponse response) throws Exception {
		try {
			long organisation_id = ParamUtil.getLong(request, "rdc_organisation");
			UploadPortletRequest upreq = PortalUtil.getUploadPortletRequest(request);
			System.out.println(upreq.getFileName("fileupload"));
			InputStream inputStream = null;
			try {
				inputStream = new FileInputStream(upreq.getFile("fileupload"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("Error on Reading File" + e.getMessage());
			}

			readXLSFile(inputStream, organisation_id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * readXLSFile read
	 * 
	 * @param file
	 * @param organizationId
	 * @throws IOException
	 * @throws PortalException
	 * @throws SystemException
	 */
	private void readXLSFile(InputStream file, long organizationId) throws IOException, PortalException, SystemException {
		Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);

		List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> diseasematrixlist = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organizationId, -1, -1);
		HashSet<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> deletelist = new HashSet<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix>();
		for(at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrixlistentry : diseasematrixlist) {
			deletelist.add(diseasematrixlistentry);
		}
		// Read xls entrys
		// Get the workbook instance for XLS file
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		// Get first sheet from the workbook
		HSSFSheet sheet = workbook.getSheet("Disease Matrix");
		// Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		boolean header = true;
		Map<Integer, String> headers = new HashMap<Integer, String>();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			int cellcounter = 0;
			if (header) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					headers.put(cellcounter, cell.getStringCellValue());
					System.out.println("Header: " + cellcounter + ":" + cell.getStringCellValue());
					cellcounter++;
				}
				header = false;
			} else {
				Cell cell_id = row.getCell(0);
				Fields fields;
				long record_id = 0;
				if (cell_id == null) {
					System.out.println("Cellid is null");
					DiseaseMatrixImpl diseasematrix_new = new DiseaseMatrixImpl();
					diseasematrix_new.setDiseasematrixId(0);
					diseasematrix_new.setOrganizationId(organizationId);
					diseasematrix_new.setDiseasename(stringFromCell(row.getCell(1)));
					diseasematrix_new.setPatientcount(stringFromCell(row.getCell(2)));
					diseasematrix_new.setGene(stringFromCell(row.getCell(3)));
					diseasematrix_new.setIcd10(stringFromCell(row.getCell(4)));
					diseasematrix_new.setOmim(stringFromCell(row.getCell(5)));
					diseasematrix_new.setSynonym(stringFromCell(row.getCell(6)));
					diseasematrix_new.setModifieddate(new Date());
					DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix_new);
				} else if (cell_id.getCellType() != Cell.CELL_TYPE_NUMERIC) {
					System.out.println("Cellid is not a number");
					DiseaseMatrixImpl diseasematrix_new = new DiseaseMatrixImpl();
					diseasematrix_new.setDiseasematrixId(0);
					diseasematrix_new.setOrganizationId(organizationId);
					diseasematrix_new.setDiseasename(stringFromCell(row.getCell(1)));
					diseasematrix_new.setPatientcount(stringFromCell(row.getCell(2)));
					diseasematrix_new.setGene(stringFromCell(row.getCell(3)));
					diseasematrix_new.setIcd10(stringFromCell(row.getCell(4)));
					diseasematrix_new.setOmim(stringFromCell(row.getCell(5)));
					diseasematrix_new.setSynonym(stringFromCell(row.getCell(6)));
					diseasematrix_new.setModifieddate(new Date());
					DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix_new);
				} else {
					System.out.println("Cellid is a number: " + cell_id.getNumericCellValue());
					long diseasematrix_in_table = (long) cell_id.getNumericCellValue();
					at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrix = DiseaseMatrixLocalServiceUtil.getDiseaseMatrix(diseasematrix_in_table);
					deletelist.remove(diseasematrix);
					if(diseasematrix.getOrganizationId() == organizationId) {
						if(!diseasematrix.getDiseasename().equals(stringFromCell(row.getCell(1))) ||
								!diseasematrix.getPatientcount().equals(stringFromCell(row.getCell(2))) ||
								!diseasematrix.getGene().equals(stringFromCell(row.getCell(3))) ||
								!diseasematrix.getIcd10().equals(stringFromCell(row.getCell(4))) ||
								!diseasematrix.getOmim().equals(stringFromCell(row.getCell(5))) ||
								!diseasematrix.getSynonym().equals(stringFromCell(row.getCell(6)))) {
							System.out.println("Update for existing entry");
							diseasematrix.setDiseasename(stringFromCell(row.getCell(1)));
							diseasematrix.setPatientcount(stringFromCell(row.getCell(2)));
							diseasematrix.setGene(stringFromCell(row.getCell(3)));
							diseasematrix.setIcd10(stringFromCell(row.getCell(4)));
							diseasematrix.setOmim(stringFromCell(row.getCell(5)));
							diseasematrix.setSynonym(stringFromCell(row.getCell(6)));
							diseasematrix.setModifieddate(new Date());
							DiseaseMatrixLocalServiceUtil.updateDiseaseMatrix(diseasematrix);
						}						
					} else {
						System.out.println("Not Matching IDs for Organization");
						DiseaseMatrixImpl diseasematrix_new = new DiseaseMatrixImpl();
						diseasematrix_new.setDiseasematrixId(0);
						diseasematrix_new.setOrganizationId(organizationId);
						diseasematrix_new.setDiseasename(stringFromCell(row.getCell(1)));
						diseasematrix_new.setPatientcount(stringFromCell(row.getCell(2)));
						diseasematrix_new.setGene(stringFromCell(row.getCell(3)));
						diseasematrix_new.setIcd10(stringFromCell(row.getCell(4)));
						diseasematrix_new.setOmim(stringFromCell(row.getCell(5)));
						diseasematrix_new.setSynonym(stringFromCell(row.getCell(6)));
						diseasematrix_new.setModifieddate(new Date());
						DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix_new);
					}
				}
			}
		}
		for(at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrixlistentry : deletelist) {
			DiseaseMatrixLocalServiceUtil.deleteDiseaseMatrix(diseasematrixlistentry);
		}
	}
	
	private String stringFromCell(Cell cell) {
		if(cell == null) {
			return "";
		}
		String returnvalue = "";
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				returnvalue = String.valueOf((long) cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				returnvalue = cell.getStringCellValue();
				break;
			default:
				returnvalue = cell.getStringCellValue();
				break;
		}
		return returnvalue;
	}
}
