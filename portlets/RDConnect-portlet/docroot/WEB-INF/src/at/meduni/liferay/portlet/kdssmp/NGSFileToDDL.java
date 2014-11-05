package at.meduni.liferay.portlet.kdssmp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
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
 * Portlet implementation class NGSFileToDDL
 */
public class NGSFileToDDL extends MVCPortlet {
	private ThemeDisplay themeDisplay = null;

	public void uploadFile(ActionRequest request, ActionResponse response) throws Exception {
		try {
			long organisation_id = ParamUtil.getLong(request, "rdc_organisation");
			//String ddlname = ParamUtil.getString(request, "rdc_ddlname");
			UploadPortletRequest upreq = PortalUtil.getUploadPortletRequest(request);
			System.out.println(upreq.getFileName("fileupload"));
			System.out.println(organisation_id);
			InputStream inputStream = null;
			try {
				inputStream = new FileInputStream(upreq.getFile("fileupload"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("Error on Reading File" + e.getMessage());
			}

			// System.out.println(upreq.getContentType("fileupload"));

			if (upreq.getFileName("fileupload").endsWith(".xls")) {
				HashSet<String> ddlnames = new HashSet<String>();
				ddlnames.add("CaseVCFReport");
				ddlnames.add("CaseVCFSilentNoncodingReport");
				//for(String ddlname : ddlnames) {
				readXLSFile(inputStream, organisation_id, ddlnames);
				//}
			} 
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 
	 */
	private void readXLSFile(InputStream file, long organizationId, HashSet<String> ddlnames) throws IOException, PortalException, SystemException {
		Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
		List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
		// Get the workbook instance for XLS file
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		for(String ddlname : ddlnames) {
			List<Long> record_id_list = new ArrayList<Long>();
	
			ServiceContext serviceContext = new ServiceContext();
	
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			Group group = organization.getGroup();
			serviceContext.setScopeGroupId(group.getGroupId());
			serviceContext.setUserId(organization.getUserId());
	
			for (DDLRecordSet rdc_rs : rdc_recordlist) {
				String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
				if (rdc_rsname.equals(ddlname)) {
					// ------
					// Get all Record Ids
					List<DDLRecord> records = rdc_rs.getRecords();
					for (DDLRecord record : records) {
						record_id_list.add(record.getRecordId());
					}
					// ------
					// Read xls entrys
					// Get first sheet from the workbook
					HSSFSheet sheet = workbook.getSheet(ddlname);
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
							case Cell.CELL_TYPE_BOOLEAN:
								tmp_field = new Field(headers.get(cellcounter), String.valueOf(cell.getBooleanCellValue()));
								System.out.println("Fieldname: " + headers.get(cellcounter) + ", Value: " + String.valueOf(cell.getBooleanCellValue()));
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
					
					// Delete Records
					System.out.println("Delete Records");
					for (long record_id_remove : record_id_list) {
						DDLRecordLocalServiceUtil.deleteRecord(record_id_remove);
					}
				}
			}
			System.out.println("DDL Finished.");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.
	 * ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException {
		themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = request.getParameter(Constants.CMD);
		long organizationId = Long.valueOf(request.getParameter("RDCOrganisationId"));
		String ddlname = request.getParameter("RDCDDLName");
		System.out.println(cmd);

		String fileName = "kDSSMP_VCFReport.";
		OutputStream out = response.getPortletOutputStream();
		byte[] bytes;

		if (cmd.equalsIgnoreCase("export_xls")) {
			fileName += "xls";
			response.setContentType("application/vnd.ms-excel");
			response.addProperty("Content-disposition", "atachment; filename=" + fileName);
			Workbook wb;
			try {
				HashSet<String> ddlnames = new HashSet<String>();
				ddlnames.add("CaseVCFReport");
				ddlnames.add("CaseVCFSilentNoncodingReport");
				wb = writeXLSFile(organizationId, ddlnames);
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

	/*
	 * 
	 */
	private Workbook writeXLSFile(long organizationId, HashSet<String> ddlnames) throws PortalException, SystemException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		for(String ddlname : ddlnames) {
			HSSFSheet sheet = workbook.createSheet(ddlname);
	
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
			List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
			int rownum = 0;
			for (DDLRecordSet rdc_rs : rdc_recordlist) {
				String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
				if (rdc_rsname.equals(ddlname)) {
					Set<String> fieldnames = rdc_rs.getDDMStructure().getFieldNames();
					Row row = sheet.createRow(rownum++);
					int cellnum = 0;
					// Create id field
					Cell cell_id_field = row.createCell(cellnum++);
					cell_id_field.setCellValue(ddlname + " Id");
					for (String fieldname : fieldnames) {
						if (!fieldname.equalsIgnoreCase("_fieldsDisplay")) {
							Cell cell = row.createCell(cellnum++);
							cell.setCellValue(fieldname);
						}
					}
	
					List<DDLRecord> records = rdc_rs.getRecords();
					for (DDLRecord record : records) {
						cellnum = 0;
						row = sheet.createRow(rownum++);
						cell_id_field = row.createCell(cellnum++);
						cell_id_field.setCellValue(record.getRecordId());
						for (String fieldname : fieldnames) {
							if (!fieldname.equalsIgnoreCase("_fieldsDisplay")) {
								String fieldvalue = "";
								if (record.getFieldValue(fieldname) != null) {
									fieldvalue = record.getFieldValue(fieldname).toString();
								}
								Cell cell = row.createCell(cellnum++);
								cell.setCellValue(fieldvalue);
							}
						}
					}
				}
			}
		}
		return workbook;
	}

}
