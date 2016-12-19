package at.graz.meduni.liferay.portlet.bibbox.rdconnect;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder;
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.util.Molgenis;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
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
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * Adds a new DiseaseMatrix to the database
	 * 
	 */
	public void addDiseaseMatrix(ActionRequest request, ActionResponse response) throws Exception {

		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrix = DiseaseMatrixLocalServiceUtil.diseaseMatrixFromRequest(request);
		DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix);
		
		long organizationId = ParamUtil.getLong(request, "organizationId");
		if(organizationId != 0) {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
			// Update Modified date
			organization.setModifiedDate(new Date());
			OrganizationLocalServiceUtil.updateOrganization(organization);
		}

		sendRedirect(request, response);
	}

	/**
	 * Updates the database record of an existing DiseaseMatrix.
	 * 
	 */
	public void updateDiseaseMatrix(ActionRequest request, ActionResponse response) throws Exception {
		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrix = DiseaseMatrixLocalServiceUtil.diseaseMatrixFromRequest(request);
		DiseaseMatrixLocalServiceUtil.updateDiseaseMatrix(diseasematrix);
		
		long organizationId = ParamUtil.getLong(request, "organizationId");
		if(organizationId != 0) {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
			// Update Modified date
			organization.setModifiedDate(new Date());
			OrganizationLocalServiceUtil.updateOrganization(organization);
		}
		
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
	 * 
	 * Function for downloading the created excel files for the disease matrix
	 */
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = request.getParameter(Constants.CMD);
		long organizationId = Long.valueOf(request.getParameter("RDCOrganisationId"));
		System.out.println(cmd);
		if(cmd.equals("load_federated_data")) {
			Molgenis molgens = Molgenis.getInstance();
			String result = "[" + molgens.getAgregatedJsonFromMolgenis(String.valueOf(organizationId)) + "]";
			response.getPortletOutputStream().write(result.getBytes());
		} else if(cmd.equals("load_diseasname")) {
			try {
				loadDiseasname(request, response);
			} catch (PortletException e) {
				System.err.println("- ERROR: serveResource Disease Matrix");
				e.printStackTrace();
			}
		} else {
			
			String fileName = "RDConnect_DeaseasMatrix.";
			OutputStream out = response.getPortletOutputStream();
			byte[] bytes;
			if(cmd.equals("export_xls")) {
				fileName += "xls";
			} else if(cmd.equals("export_xlsx")) {
				fileName += "xlsx";
			}
			response.setContentType("application/vnd.ms-excel");
			response.addProperty("Content-disposition", "atachment; filename=" + fileName);
			Workbook wb;
			try {
				if(cmd.equals("export_xls")) {
					wb = writeXLSFile(organizationId);
				} else  {
					wb = writeXLSXFile(organizationId);
				}
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
	}
	
	/**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	private void loadDiseasname(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		System.out.println(new Date());
		JSONArray disordersJSONArray = JSONFactoryUtil.createJSONArray();
		JSONObject disorderJSON=null;
		try {
			List<OrphanetDisorder> orphanetdisorders = OrphanetDisorderLocalServiceUtil.getOrphanetDisorders(-1, -1);
			System.out.println("Orphanetdisorder Count: " + orphanetdisorders.size());
			for(OrphanetDisorder orphanetdisorder : orphanetdisorders) {
				disorderJSON=JSONFactoryUtil.createJSONObject();
				disorderJSON.put("diseasename", orphanetdisorder.getDiseasename());
				disorderJSON.put("orphanumber", "ORPHA" + orphanetdisorder.getOrphanumber());
				disordersJSONArray.put(disorderJSON);
			}
		} catch (Exception e) {
		}
		PrintWriter out=resourceResponse.getWriter();
		out.println(disordersJSONArray.toString());
		System.out.println(new Date());
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
		cell = row.createCell(4);
		cell.setCellValue("orpha");
		cell = row.createCell(3);
		cell.setCellValue("gene");
		cell = row.createCell(5);
		cell.setCellValue("icd10");
		cell = row.createCell(6);
		cell.setCellValue("omim");
		cell = row.createCell(7);
		cell.setCellValue("synonym");

		for (at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrix : diseasematrixlist) {
			row = sheet.createRow(rownum++);
			cell = row.createCell(0);
			cell.setCellValue(diseasematrix.getDiseasematrixId());
			cell = row.createCell(1);
			cell.setCellValue(diseasematrix.getDiseasename());
			cell = row.createCell(2);
			cell.setCellValue(diseasematrix.getPatientcount());
			cell = row.createCell(4);
			cell.setCellValue(diseasematrix.getOrphanumber());
			cell = row.createCell(3);
			cell.setCellValue(diseasematrix.getGene());
			cell = row.createCell(5);
			cell.setCellValue(diseasematrix.getIcd10());
			cell = row.createCell(6);
			cell.setCellValue(diseasematrix.getOmim());
			cell = row.createCell(7);
			cell.setCellValue(diseasematrix.getSynonym());
		}
		return workbook;
	}
	
	/**
	 * XLSX creator
	 * 
	 * @param organizationId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private Workbook writeXLSXFile(long organizationId) throws PortalException, SystemException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Disease Matrix");

		Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
		List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> diseasematrixlist = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organizationId, -1, -1);
		int rownum = 0;

		XSSFRow row = sheet.createRow(rownum++);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("diseasematrixId");
		cell = row.createCell(1);
		cell.setCellValue("diseasename");
		cell = row.createCell(2);
		cell.setCellValue("patientcount");
		cell = row.createCell(4);
		cell.setCellValue("orpha");
		cell = row.createCell(3);
		cell.setCellValue("gene");
		cell = row.createCell(5);
		cell.setCellValue("icd10");
		cell = row.createCell(6);
		cell.setCellValue("omim");
		cell = row.createCell(7);
		cell.setCellValue("synonym");

		for (at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrix : diseasematrixlist) {
			row = sheet.createRow(rownum++);
			cell = row.createCell(0);
			cell.setCellValue(diseasematrix.getDiseasematrixId());
			cell = row.createCell(1);
			cell.setCellValue(diseasematrix.getDiseasename());
			cell = row.createCell(2);
			cell.setCellValue(diseasematrix.getPatientcount());
			cell = row.createCell(4);
			cell.setCellValue(diseasematrix.getOrphanumber());
			cell = row.createCell(3);
			cell.setCellValue(diseasematrix.getGene());
			cell = row.createCell(5);
			cell.setCellValue(diseasematrix.getIcd10());
			cell = row.createCell(6);
			cell.setCellValue(diseasematrix.getOmim());
			cell = row.createCell(7);
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
			
			if(organisation_id != 0) {
				Organization organization = OrganizationLocalServiceUtil.getOrganization(organisation_id);
				// Update Modified date
				organization.setModifiedDate(new Date());
				OrganizationLocalServiceUtil.updateOrganization(organization);
			}
			
			if(upreq.getFile("fileupload").toString().endsWith("xls")) {
				readXLSFile(inputStream, organisation_id, request);
			} else if(upreq.getFile("fileupload").toString().endsWith("xlsx")) {
				readXLSXFile(inputStream, organisation_id, request);
			} else {
				SessionErrors.add(request, "file-upload-wrong-type");
				response.setRenderParameter("success", "false");
			}
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
	private void readXLSFile(InputStream file, long organizationId, ActionRequest request) throws IOException, PortalException, SystemException {
		Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
		// Update Modified date
		organization.setModifiedDate(new Date());
		OrganizationLocalServiceUtil.updateOrganization(organization);

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
		if(sheet == null) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.rdconnect.DiseaseMatrix::readXLSXFile] No Sheet exists with the name Disease Matrix.");
			if(workbook.getNumberOfSheets() == 1) {
				sheet = workbook.getSheetAt(0);
			} else {
				for(int i = 0; i < workbook.getNumberOfSheets(); i++) {
					if(workbook.getSheetName(i).contains("disease") || workbook.getSheetName(i).contains("Disease")) {
						sheet = workbook.getSheetAt(i);
					}
				}
				if(sheet == null) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.rdconnect.DiseaseMatrix::readXLSXFile] No possible Sheet found that could contain Disease Matrix.");
					SessionErrors.add(request, "no-correct-sheer-found");
					return;
				}
			}
		}
		// Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		boolean header = true;
		int rowcount = 1;
		String rowerrors = "";
		int diseasematrixid_column = -1;
		int diseasename_column = -1;
		int numberofdoners_column = -1;
		int gene_column = -1;
		int orphacode_column = -1;
		int icd10_column = -1;
		int omim_column = -1;
		int synonym_column = -1;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			int cellcounter = 0;
			if (header) {
				Iterator<Cell> cellIterator = row.cellIterator();
				String column_missing = "";
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if(cell.getStringCellValue().trim().equalsIgnoreCase("diseasematrixId")) {
						diseasematrixid_column = cellcounter;
					} else if(cell.getStringCellValue().trim().equalsIgnoreCase("Disease Name")) {
			       		diseasename_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("diseasename")) {
			       		diseasename_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("Number of Patients, Donors")) {
						numberofdoners_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("Number of Patients")) {
						numberofdoners_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("patientcount")) {
						numberofdoners_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("Gene")) {
						gene_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("gene")) {
						gene_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("ORPHA Code")) {
						orphacode_column = cellcounter;
			       	} else if(cell.getStringCellValue().trim().equalsIgnoreCase("orpha")) {
						orphacode_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("ORPHA")) {
						orphacode_column = cellcounter;
			       	} else if(cell.getStringCellValue().trim().equalsIgnoreCase("ICD10")) {
						icd10_column = cellcounter;
			       	} else if(cell.getStringCellValue().trim().equalsIgnoreCase("icd10")) {
						icd10_column = cellcounter;
			       	} else if(cell.getStringCellValue().trim().equalsIgnoreCase("OMIM")) {
						omim_column = cellcounter;
			       	} else if(cell.getStringCellValue().trim().equalsIgnoreCase("omim")) {
						omim_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("Synonym(s)")) {
						synonym_column = cellcounter;
			       	} else if(cell.getStringCellValue().trim().equalsIgnoreCase("synonym")) {
						synonym_column = cellcounter;
			       	} else {
			       		if(!column_missing.equalsIgnoreCase("")) {
				        	column_missing += ";";
				        }
			       		column_missing += cell.getStringCellValue().trim();
			       		System.err.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.rdconnect.DiseaseMatrix::readXLSXFile] The field " + cell.getStringCellValue().trim() + " could not be mapped for header.");
			       	}
					System.out.println("Header: " + cellcounter + ":" + cell.getStringCellValue());
					cellcounter++;
				}
				request.setAttribute("xls-header-not-defined-column_missing", column_missing);
				SessionMessages.add(request, "xls-header-not-defined");
				header = false;
			} else {
				rowcount ++;
				try {
					Cell cell_id = null;
					if(diseasematrixid_column != -1) {
						cell_id = row.getCell(diseasematrixid_column);
					}
					Fields fields;
					long record_id = 0;
					if (cell_id == null) {
						//System.out.println("Cellid is null");
						DiseaseMatrixImpl diseasematrix_new = new DiseaseMatrixImpl();
						diseasematrix_new.setDiseasematrixId(0);
						diseasematrix_new.setOrganizationId(organizationId);
						diseasematrix_new.setDiseasename(stringFromCell(row.getCell(diseasename_column), true));
						diseasematrix_new.setPatientcount(stringFromCell(row.getCell(numberofdoners_column)));
						diseasematrix_new.setOrphanumber(stringFromCell(row.getCell(orphacode_column)));
						diseasematrix_new.setGene(stringFromCell(row.getCell(gene_column)));
						diseasematrix_new.setIcd10(stringFromCell(row.getCell(icd10_column)));
						diseasematrix_new.setOmim(stringFromCell(row.getCell(omim_column)));
						diseasematrix_new.setSynonym(stringFromCell(row.getCell(synonym_column), true));
						diseasematrix_new.setModifieddate(new Date());
						DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix_new);
					} else if (cell_id.getCellType() != Cell.CELL_TYPE_NUMERIC) {
						//System.out.println("Cellid is not a number");
						DiseaseMatrixImpl diseasematrix_new = new DiseaseMatrixImpl();
						diseasematrix_new.setDiseasematrixId(0);
						diseasematrix_new.setOrganizationId(organizationId);
						diseasematrix_new.setDiseasename(stringFromCell(row.getCell(diseasename_column), true));
						diseasematrix_new.setPatientcount(stringFromCell(row.getCell(numberofdoners_column)));
						diseasematrix_new.setOrphanumber(stringFromCell(row.getCell(orphacode_column)));
						diseasematrix_new.setGene(stringFromCell(row.getCell(gene_column)));
						diseasematrix_new.setIcd10(stringFromCell(row.getCell(icd10_column)));
						diseasematrix_new.setOmim(stringFromCell(row.getCell(omim_column)));
						diseasematrix_new.setSynonym(stringFromCell(row.getCell(synonym_column), true));
						diseasematrix_new.setModifieddate(new Date());
						DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix_new);
					} else {
						//System.out.println("Cellid is a number: " + cell_id.getNumericCellValue());
						at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrix = null;
						long diseasematrix_in_table = (long) cell_id.getNumericCellValue();
						try {
							diseasematrix = DiseaseMatrixLocalServiceUtil.getDiseaseMatrix(diseasematrix_in_table);
						} catch (Exception ex) {
							DiseaseMatrixImpl diseasematrix_new = new DiseaseMatrixImpl();
							diseasematrix_new.setDiseasematrixId(0);
							diseasematrix_new.setOrganizationId(organizationId);
							diseasematrix_new.setDiseasename(stringFromCell(row.getCell(diseasename_column), true));
							diseasematrix_new.setPatientcount(stringFromCell(row.getCell(numberofdoners_column)));
							diseasematrix_new.setOrphanumber(stringFromCell(row.getCell(orphacode_column)));
							diseasematrix_new.setGene(stringFromCell(row.getCell(gene_column)));
							diseasematrix_new.setIcd10(stringFromCell(row.getCell(icd10_column)));
							diseasematrix_new.setOmim(stringFromCell(row.getCell(omim_column)));
							diseasematrix_new.setSynonym(stringFromCell(row.getCell(synonym_column), true));
							diseasematrix_new.setModifieddate(new Date());
							DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix_new);
						}
						deletelist.remove(diseasematrix);
						if(diseasematrix.getOrganizationId() == organizationId) {
							if(!diseasematrix.getDiseasename().equals(stringFromCell(row.getCell(diseasename_column), true)) ||
									!diseasematrix.getPatientcount().equals(stringFromCell(row.getCell(numberofdoners_column))) ||
									!diseasematrix.getOrphanumber().equals(stringFromCell(row.getCell(orphacode_column))) ||
									!diseasematrix.getGene().equals(stringFromCell(row.getCell(gene_column))) ||
									!diseasematrix.getIcd10().equals(stringFromCell(row.getCell(icd10_column))) ||
									!diseasematrix.getOmim().equals(stringFromCell(row.getCell(omim_column))) ||
									!diseasematrix.getSynonym().equals(stringFromCell(row.getCell(synonym_column), true))) {
								//System.out.println("Update for existing entry");
								diseasematrix.setDiseasename(stringFromCell(row.getCell(diseasename_column), true));
								diseasematrix.setPatientcount(stringFromCell(row.getCell(numberofdoners_column)));
								diseasematrix.setOrphanumber(stringFromCell(row.getCell(orphacode_column)));
								diseasematrix.setGene(stringFromCell(row.getCell(gene_column)));
								diseasematrix.setIcd10(stringFromCell(row.getCell(icd10_column)));
								diseasematrix.setOmim(stringFromCell(row.getCell(omim_column)));
								diseasematrix.setSynonym(stringFromCell(row.getCell(synonym_column), true));
								diseasematrix.setModifieddate(new Date());
								DiseaseMatrixLocalServiceUtil.updateDiseaseMatrix(diseasematrix);
							}						
						} else {
							//System.out.println("Not Matching IDs for Organization");
							DiseaseMatrixImpl diseasematrix_new = new DiseaseMatrixImpl();
							diseasematrix_new.setDiseasematrixId(0);
							diseasematrix_new.setOrganizationId(organizationId);
							diseasematrix_new.setDiseasename(stringFromCell(row.getCell(diseasename_column), true));
							diseasematrix_new.setPatientcount(stringFromCell(row.getCell(numberofdoners_column)));
							diseasematrix_new.setOrphanumber(stringFromCell(row.getCell(orphacode_column)));
							diseasematrix_new.setGene(stringFromCell(row.getCell(gene_column)));
							diseasematrix_new.setIcd10(stringFromCell(row.getCell(icd10_column)));
							diseasematrix_new.setOmim(stringFromCell(row.getCell(omim_column)));
							diseasematrix_new.setSynonym(stringFromCell(row.getCell(synonym_column), true));
							diseasematrix_new.setModifieddate(new Date());
							DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix_new);
						}
					}
				} catch (Exception ex) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.rdconnect.DiseaseMatrix::readXLSXFile] Problem adding row " + rowcount + " to the DiseaseMatrix .");
					ex.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += ";";
					}
					rowerrors += rowcount;
				}
			}
		}
		if(!rowerrors.equalsIgnoreCase("")) {
			request.setAttribute("xls-row-import-errors", rowerrors);
			SessionMessages.add(request, "xls-row-import-errors");
		}
		for(at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrixlistentry : deletelist) {
			DiseaseMatrixLocalServiceUtil.deleteDiseaseMatrix(diseasematrixlistentry);
		}
	}
	
	/**
	 * readXLSXFile read
	 * 
	 * @param file
	 * @param organizationId
	 * @throws IOException
	 * @throws PortalException
	 * @throws SystemException
	 */
	private void readXLSXFile(InputStream file, long organizationId, ActionRequest request) throws IOException, PortalException, SystemException {
		Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
		// Update Modified date
		organization.setModifiedDate(new Date());
		OrganizationLocalServiceUtil.updateOrganization(organization);
		
		List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> diseasematrixlist = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organizationId, -1, -1);
		HashSet<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> deletelist = new HashSet<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix>();
		for(at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrixlistentry : diseasematrixlist) {
			deletelist.add(diseasematrixlistentry);
		}
		// Read xls entrys
		// Get the workbook instance for XLS file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		// Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("Disease Matrix");
		if(sheet == null) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.rdconnect.DiseaseMatrix::readXLSXFile] No Sheet exists with the name Disease Matrix.");
			if(workbook.getNumberOfSheets() == 1) {
				sheet = workbook.getSheetAt(0);
			} else {
				for(int i = 0; i < workbook.getNumberOfSheets(); i++) {
					if(workbook.getSheetName(i).contains("disease") || workbook.getSheetName(i).contains("Disease")) {
						sheet = workbook.getSheetAt(i);
					}
				}
				if(sheet == null) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.rdconnect.DiseaseMatrix::readXLSXFile] No possible Sheet found that could contain Disease Matrix.");
					SessionErrors.add(request, "no-correct-sheer-found");
					return;
				}
			}
		}
		// Get iterator to all the rows in current sheet
		Iterator rowIterator = sheet.rowIterator();
		boolean header = true;
		int rowcount = 1;
		String rowerrors = "";
		int diseasematrixid_column = -1;
		int diseasename_column = -1;
		int numberofdoners_column = -1;
		int gene_column = -1;
		int orphacode_column = -1;
		int icd10_column = -1;
		int omim_column = -1;
		int synonym_column = -1;
		while (rowIterator.hasNext()) {
			XSSFRow row = (XSSFRow) rowIterator.next();
			int cellcounter = 0;
			if (header) {
				Iterator cellIterator = row.cellIterator();
				String column_missing = "";
				while (cellIterator.hasNext()) {
					XSSFCell cell = (XSSFCell)cellIterator.next();
					if(cell.getStringCellValue().trim().equalsIgnoreCase("diseasematrixId")) {
						diseasematrixid_column = cellcounter;
					} else if(cell.getStringCellValue().trim().equalsIgnoreCase("Disease Name")) {
			       		diseasename_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("diseasename")) {
			       		diseasename_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("Number of Patients, Donors")) {
						numberofdoners_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("Number of Patients")) {
						numberofdoners_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("patientcount")) {
						numberofdoners_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("Gene")) {
						gene_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("gene")) {
						gene_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("ORPHA Code")) {
						orphacode_column = cellcounter;
			       	} else if(cell.getStringCellValue().trim().equalsIgnoreCase("orpha")) {
						orphacode_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("ORPHA")) {
						orphacode_column = cellcounter;
			       	} else if(cell.getStringCellValue().trim().equalsIgnoreCase("ICD10")) {
						icd10_column = cellcounter;
			       	} else if(cell.getStringCellValue().trim().equalsIgnoreCase("icd10")) {
						icd10_column = cellcounter;
			       	} else if(cell.getStringCellValue().trim().equalsIgnoreCase("OMIM")) {
						omim_column = cellcounter;
			       	} else if(cell.getStringCellValue().trim().equalsIgnoreCase("omim")) {
						omim_column = cellcounter;
			        } else if(cell.getStringCellValue().trim().equalsIgnoreCase("Synonym(s)")) {
						synonym_column = cellcounter;
			       	} else if(cell.getStringCellValue().trim().equalsIgnoreCase("synonym")) {
						synonym_column = cellcounter;
			       	} else {
			       		if(!column_missing.equalsIgnoreCase("")) {
				        	column_missing += ";";
				        }
			       		column_missing += cell.getStringCellValue().trim();
			       		System.err.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.rdconnect.DiseaseMatrix::readXLSXFile] The field " + cell.getStringCellValue().trim() + " could not be mapped for header.");
			       	}
					System.out.println("Header: " + cellcounter + ":" + cell.getStringCellValue());
					cellcounter++;
				}
				request.setAttribute("xls-header-not-defined-column_missing", column_missing);
				SessionMessages.add(request, "xls-header-not-defined");
				header = false;
			} else {
				rowcount ++;
				try {
					XSSFCell cell_id = null;
					if(diseasematrixid_column != -1) {
						cell_id = row.getCell(diseasematrixid_column);
					}
					Fields fields;
					long record_id = 0;
					if (cell_id == null) {
						//System.out.println("Cellid is null");
						DiseaseMatrixImpl diseasematrix_new = new DiseaseMatrixImpl();
						diseasematrix_new.setDiseasematrixId(0);
						diseasematrix_new.setOrganizationId(organizationId);
						diseasematrix_new.setDiseasename(stringFromCell(row.getCell(diseasename_column), true));
						diseasematrix_new.setPatientcount(stringFromCell(row.getCell(numberofdoners_column)));
						diseasematrix_new.setOrphanumber(stringFromCell(row.getCell(orphacode_column)));
						diseasematrix_new.setGene(stringFromCell(row.getCell(gene_column)));
						diseasematrix_new.setIcd10(stringFromCell(row.getCell(icd10_column)));
						diseasematrix_new.setOmim(stringFromCell(row.getCell(omim_column)));
						diseasematrix_new.setSynonym(stringFromCell(row.getCell(synonym_column), true));
						diseasematrix_new.setModifieddate(new Date());
						DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix_new);
					} else if (cell_id.getCellType() != Cell.CELL_TYPE_NUMERIC) {
						//System.out.println("Cellid is not a number");
						DiseaseMatrixImpl diseasematrix_new = new DiseaseMatrixImpl();
						diseasematrix_new.setDiseasematrixId(0);
						diseasematrix_new.setOrganizationId(organizationId);
						diseasematrix_new.setDiseasename(stringFromCell(row.getCell(diseasename_column), true));
						diseasematrix_new.setPatientcount(stringFromCell(row.getCell(numberofdoners_column)));
						diseasematrix_new.setOrphanumber(stringFromCell(row.getCell(orphacode_column)));
						diseasematrix_new.setGene(stringFromCell(row.getCell(gene_column)));
						diseasematrix_new.setIcd10(stringFromCell(row.getCell(icd10_column)));
						diseasematrix_new.setOmim(stringFromCell(row.getCell(omim_column)));
						diseasematrix_new.setSynonym(stringFromCell(row.getCell(synonym_column), true));
						diseasematrix_new.setModifieddate(new Date());
						DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix_new);
					} else {
						//System.out.println("Cellid is a number: " + cell_id.getNumericCellValue());
						long diseasematrix_in_table = (long) cell_id.getNumericCellValue();
						at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrix = DiseaseMatrixLocalServiceUtil.getDiseaseMatrix(diseasematrix_in_table);
						deletelist.remove(diseasematrix);
						if(diseasematrix.getOrganizationId() == organizationId) {
							if(!diseasematrix.getDiseasename().equals(stringFromCell(row.getCell(diseasename_column), true)) ||
									!diseasematrix.getPatientcount().equals(stringFromCell(row.getCell(numberofdoners_column))) ||
									!diseasematrix.getOrphanumber().equals(stringFromCell(row.getCell(orphacode_column))) ||
									!diseasematrix.getGene().equals(stringFromCell(row.getCell(gene_column))) ||
									!diseasematrix.getIcd10().equals(stringFromCell(row.getCell(icd10_column))) ||
									!diseasematrix.getOmim().equals(stringFromCell(row.getCell(omim_column))) ||
									!diseasematrix.getSynonym().equals(stringFromCell(row.getCell(synonym_column), true))) {
								//System.out.println("Update for existing entry");
								diseasematrix.setDiseasename(stringFromCell(row.getCell(diseasename_column), true));
								diseasematrix.setPatientcount(stringFromCell(row.getCell(numberofdoners_column)));
								diseasematrix.setOrphanumber(stringFromCell(row.getCell(orphacode_column)));
								diseasematrix.setGene(stringFromCell(row.getCell(gene_column)));
								diseasematrix.setIcd10(stringFromCell(row.getCell(icd10_column)));
								diseasematrix.setOmim(stringFromCell(row.getCell(omim_column)));
								diseasematrix.setSynonym(stringFromCell(row.getCell(synonym_column), true));
								diseasematrix.setModifieddate(new Date());
								DiseaseMatrixLocalServiceUtil.updateDiseaseMatrix(diseasematrix);
							}						
						} else {
							//System.out.println("Not Matching IDs for Organization");
							DiseaseMatrixImpl diseasematrix_new = new DiseaseMatrixImpl();
							diseasematrix_new.setDiseasematrixId(0);
							diseasematrix_new.setOrganizationId(organizationId);
							diseasematrix_new.setDiseasename(stringFromCell(row.getCell(diseasename_column), true));
							diseasematrix_new.setPatientcount(stringFromCell(row.getCell(numberofdoners_column)));
							diseasematrix_new.setOrphanumber(stringFromCell(row.getCell(orphacode_column)));
							diseasematrix_new.setGene(stringFromCell(row.getCell(gene_column)));
							diseasematrix_new.setIcd10(stringFromCell(row.getCell(icd10_column)));
							diseasematrix_new.setOmim(stringFromCell(row.getCell(omim_column)));
							diseasematrix_new.setSynonym(stringFromCell(row.getCell(synonym_column), true));
							diseasematrix_new.setModifieddate(new Date());
							DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(diseasematrix_new);
						}
					}
				} catch (Exception ex) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.rdconnect.DiseaseMatrix::readXLSXFile] Problem adding row " + rowcount + " to the DiseaseMatrix .");
					ex.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += ";";
					}
					rowerrors += rowcount;
				}
			}
		}
		if(!rowerrors.equalsIgnoreCase("")) {
			request.setAttribute("xls-row-import-errors", rowerrors);
			SessionMessages.add(request, "xls-row-import-errors");
		}
		for(at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasematrixlistentry : deletelist) {
			DiseaseMatrixLocalServiceUtil.deleteDiseaseMatrix(diseasematrixlistentry);
		}
	}
	
	/**
	 * Convert Cell to string
	 * 
	 * Parameter freetext is false, this relates in  a replacing whitespace
	 * 
	 * @param cell
	 * @return
	 */
	private String stringFromCell(Cell cell) { 
		return stringFromCell(cell, false);
	}
	
	/**
	 * Convert Cell to string
	 * @param cell
	 * @param freetext
	 * @return
	 */
	private String stringFromCell(Cell cell, boolean freetext) {
		if(cell == null) {
			return "";
		}
		String returnvalue = "";
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				returnvalue = String.valueOf((long) cell.getNumericCellValue()).trim();
				break;
			case Cell.CELL_TYPE_STRING:
				returnvalue = cell.getStringCellValue().trim();
				break;
			default:
				returnvalue = cell.getStringCellValue().trim();
				break;
		}
		if(freetext) {
			returnvalue = returnvalue.replaceAll("  ", ";").replaceAll(";;", ";"); 
		}
		return returnvalue;
	}
}
