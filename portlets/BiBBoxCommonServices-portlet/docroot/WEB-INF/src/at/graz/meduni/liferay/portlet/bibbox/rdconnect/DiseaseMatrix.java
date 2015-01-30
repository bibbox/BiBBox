package at.graz.meduni.liferay.portlet.bibbox.rdconnect;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
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
					/*fields = DDMUtil.getFields(rdc_rs.getDDMStructureId(), serviceContext);
					DDLRecord record = DDLRecordLocalServiceUtil.addRecord(serviceContext.getUserId(), serviceContext.getScopeGroupId(), rdc_rs.getRecordSetId(),
							DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, serviceContext);
					record_id = record.getRecordId();
					System.out.println("0. Create Record with id:" + record.getRecordId());*/
				} else if (cell_id.getCellType() != Cell.CELL_TYPE_NUMERIC) {
					System.out.println("Cellid is not a number");
					/*fields = DDMUtil.getFields(rdc_rs.getDDMStructureId(), serviceContext);
					DDLRecord record = DDLRecordLocalServiceUtil.addRecord(serviceContext.getUserId(), serviceContext.getScopeGroupId(), rdc_rs.getRecordSetId(),
							DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, serviceContext);
					record_id = record.getRecordId();
					System.out.println("1. Create Record with id:" + record.getRecordId());*/
				} else {
					System.out.println("Cellid is a number: " + cell_id.getNumericCellValue());
					/*long record_id_in_table = (long) cell_id.getNumericCellValue();
					if (record_id_list.contains(record_id_in_table)) {
						record_id_list.remove(record_id_in_table);
						fields = DDLRecordLocalServiceUtil.getRecord(record_id_in_table).getFields();
						record_id = record_id_in_table;
						System.out.println("3. Record exists with id:" + record_id);
					} else {
						fields = DDMUtil.getFields(rdc_rs.getDDMStructureId(), serviceContext);
						DDLRecord record = DDLRecordLocalServiceUtil.addRecord(serviceContext.getUserId(), serviceContext.getScopeGroupId(), rdc_rs.getRecordSetId(),
								DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, serviceContext);
						record_id = record.getRecordId();
						System.out.println("2. Create Record with id:" + record.getRecordId());
					}*/
				}
			}
		}

		/*
		List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
		List<Long> record_id_list = new ArrayList<Long>();

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		Group group = organization.getGroup();
		serviceContext.setScopeGroupId(group.getGroupId());
		serviceContext.setUserId(organization.getUserId());

		for (DDLRecordSet rdc_rs : rdc_recordlist) {
			String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
			if (rdc_rsname.equals("Disease Matrix")) {
				// ------
				// Get all Record Ids
				List<DDLRecord> records = rdc_rs.getRecords();
				for (DDLRecord record : records) {
					record_id_list.add(record.getRecordId());
				}
				// ------
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
						continue;
					}
					// Create Fields or Load Fields
					System.out.println("Create Fields or Load Fields");
					Cell cell_id = row.getCell(0);
					Fields fields;
					long record_id = 0;
					if (cell_id == null) {
						fields = DDMUtil.getFields(rdc_rs.getDDMStructureId(), serviceContext);
						DDLRecord record = DDLRecordLocalServiceUtil.addRecord(serviceContext.getUserId(), serviceContext.getScopeGroupId(), rdc_rs.getRecordSetId(),
								DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, serviceContext);
						record_id = record.getRecordId();
						System.out.println("0. Create Record with id:" + record.getRecordId());
					} else if (cell_id.getCellType() != Cell.CELL_TYPE_NUMERIC) {
						fields = DDMUtil.getFields(rdc_rs.getDDMStructureId(), serviceContext);
						DDLRecord record = DDLRecordLocalServiceUtil.addRecord(serviceContext.getUserId(), serviceContext.getScopeGroupId(), rdc_rs.getRecordSetId(),
								DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, serviceContext);
						record_id = record.getRecordId();
						System.out.println("1. Create Record with id:" + record.getRecordId());
					} else {
						long record_id_in_table = (long) cell_id.getNumericCellValue();
						if (record_id_list.contains(record_id_in_table)) {
							record_id_list.remove(record_id_in_table);
							fields = DDLRecordLocalServiceUtil.getRecord(record_id_in_table).getFields();
							record_id = record_id_in_table;
							System.out.println("3. Record exists with id:" + record_id);
						} else {
							fields = DDMUtil.getFields(rdc_rs.getDDMStructureId(), serviceContext);
							DDLRecord record = DDLRecordLocalServiceUtil.addRecord(serviceContext.getUserId(), serviceContext.getScopeGroupId(), rdc_rs.getRecordSetId(),
									DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, serviceContext);
							record_id = record.getRecordId();
							System.out.println("2. Create Record with id:" + record.getRecordId());
						}
					}
					// For each row, iterate through each columns
					System.out.println("For each row, iterate through each columns");
					for (cellcounter = 1; cellcounter < headers.size(); cellcounter++) {

						Field tmp_field = null;
						Cell cell = row.getCell(cellcounter);
						if (cell == null) {
							continue;
						}
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							tmp_field = new Field(headers.get(cellcounter), (long) cell.getNumericCellValue());
							System.out.println("Fieldname: " + headers.get(cellcounter) + ", Value: " + cell.getNumericCellValue());
							break;
						case Cell.CELL_TYPE_STRING:
							tmp_field = new Field(headers.get(cellcounter), cell.getStringCellValue());
							System.out.println("Fieldname: " + headers.get(cellcounter) + ", Value: " + cell.getStringCellValue());
							break;
						default:
							tmp_field = new Field(headers.get(cellcounter), cell.getStringCellValue());
							System.out.println("Fieldname: " + headers.get(cellcounter) + ", Value: " + cell.getStringCellValue());
							break;
						}
						fields.put(tmp_field);
					}
					DDLRecordLocalServiceUtil.updateRecord(serviceContext.getUserId(), record_id, true, DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, false, serviceContext);
				}
				file.close();
				// Delete Records
				System.out.println("Delete Records");
				for (long record_id_remove : record_id_list) {
					DDLRecordLocalServiceUtil.deleteRecord(record_id_remove);
				}
			}
		}*/

	}
}
