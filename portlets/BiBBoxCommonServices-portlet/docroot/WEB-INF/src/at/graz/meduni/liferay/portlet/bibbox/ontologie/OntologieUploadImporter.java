package at.graz.meduni.liferay.portlet.bibbox.ontologie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder;
import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference;
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class OntologieUploadImporter
 */
public class OntologieUploadImporter extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void uploadFile(ActionRequest request, ActionResponse response) throws Exception {
		UploadPortletRequest upreq = PortalUtil.getUploadPortletRequest(request);
		System.out.println(upreq.getFileName("fileupload"));
		InputStream inputStream = null;
		String selectedimporttype = ParamUtil.getString(request, "selectedimporttype");
		try {
			inputStream = new FileInputStream(upreq.getFile("fileupload"));
		} catch (FileNotFoundException e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.ontologie.OntologieUploadImporter::uploadFile] Error reading uploaded file.");
			e.printStackTrace();
		}
		if(upreq.getFile("fileupload").toString().endsWith("xml") && selectedimporttype.equals("orphanetdisorder")) {
			importOrpahnetDisorders(inputStream);
		}
	}
	
	private void importOrpahnetDisorders(InputStream inputStream) {
		try {
			//Get the DOM Builder Factory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//Get the DOM Builder
			DocumentBuilder builder = factory.newDocumentBuilder();
			//Load and Parse the XML document
			//document contains the complete XML as a Tree.
			Document document = builder.parse(inputStream);
			//Iterating through the nodes and extracting the data.
			NodeList disorderNodeList = document.getDocumentElement().getChildNodes();
			System.out.println("NodeList: " + disorderNodeList.getLength());
			for (int i = 0; i < disorderNodeList.getLength(); i++) {
				Node disorderNode = disorderNodeList.item(i);
				if (disorderNode instanceof Element) {
					System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.ontologie.OntologieUploadImporter::importOrpahnetDisorders] Info Reading XML file: " + ((Element) disorderNode).getTagName() + ": Nodecount: " + disorderNode.getAttributes().getNamedItem("count").getNodeValue() + " .");
					NodeList disorderNodeInformationNodes = disorderNode.getChildNodes();
					System.out.println("childNodes Size: " + disorderNodeInformationNodes.getLength());
					for (int j = 0; j < disorderNodeInformationNodes.getLength(); j++) {
						Node disorderNodeInformationNode = disorderNodeInformationNodes.item(j);
						if (disorderNodeInformationNode instanceof Element) {
							// Create Disorder 
							long orphanetdisorderId = Long.parseLong(disorderNodeInformationNode.getAttributes().getNamedItem("id").getNodeValue());
							OrphanetDisorder orphanetdisorder = OrphanetDisorderLocalServiceUtil.createOrphanetDisorder(orphanetdisorderId);
							//System.out.println(((Element) disorderNodeInformationNode).getTagName() + " - " + disorderNodeInformationNode.getAttributes().getNamedItem("id").getNodeValue());
							NodeList childchildNodes = disorderNodeInformationNode.getChildNodes();
							//System.out.println("childchildNodes Size: " + childchildNodes.getLength());
							for (int y = 0; y < childchildNodes.getLength(); y++) {
								Node ccNode = childchildNodes.item(y);
								if (ccNode instanceof Element) {
									if(((Element) ccNode).getTagName().equalsIgnoreCase("OrphaNumber")) {
										orphanetdisorder.setOrphanumber(Long.parseLong(ccNode.getTextContent()));
										//System.out.println(((Element) ccNode).getTagName() + " - " + ccNode.getTextContent());
									}
									if(((Element) ccNode).getTagName().equalsIgnoreCase("ExpertLink")) {
										orphanetdisorder.setOrpahnetlink(ccNode.getTextContent().replaceAll("&amp;", "&"));
										//System.out.println(((Element) ccNode).getTagName() + " - " + ccNode.getTextContent());
									}
									if(((Element) ccNode).getTagName().equalsIgnoreCase("Name")) {
										orphanetdisorder.setDiseasename(ccNode.getTextContent());
										//System.out.println(((Element) ccNode).getTagName() + " - " + ccNode.getTextContent());
									}
									if(((Element) ccNode).getTagName().equalsIgnoreCase("DisorderFlagList")) {
										System.out.println(((Element) ccNode).getTagName() + " - " + ccNode.getTextContent());
									}
									if(((Element) ccNode).getTagName().equalsIgnoreCase("SynonymList")) {
										NodeList synonyms = ccNode.getChildNodes();
										for (int synonym_count = 0; synonym_count < synonyms.getLength(); synonym_count++) {
											Node synonym = synonyms.item(synonym_count);
											if (synonym instanceof Element) {
												OrphanetSynonymLocalServiceUtil.createOrphanetSynonym(synonym.getTextContent(), orphanetdisorder.getOrphanetdisorderId());
												//System.out.println("Synonym: " + ((Element) synonym).getTagName() + " - " + synonym.getTextContent());
											}
										}
									}
									if(((Element) ccNode).getTagName().equalsIgnoreCase("ExternalReferenceList")) {
										NodeList externalreferencelist = ccNode.getChildNodes();
										for (int externalreferencelist_count = 0; externalreferencelist_count < externalreferencelist.getLength(); externalreferencelist_count++) {
											Node externalreference = externalreferencelist.item(externalreferencelist_count);
											if (externalreference instanceof Element) {
												// Create External reference
												long externalreferenceid = Long.parseLong(externalreference.getAttributes().getNamedItem("id").getNodeValue());
												OrphanetReference orphanetreference = OrphanetReferenceLocalServiceUtil.createOrphanetReference(externalreferenceid, orphanetdisorderId);
												NodeList externalreferenceinfolist = externalreference.getChildNodes();
												for (int externalreferenceinfolist_count = 0; externalreferenceinfolist_count < externalreferenceinfolist.getLength(); externalreferenceinfolist_count++) {
													Node externalreferenceinfo = externalreferenceinfolist.item(externalreferenceinfolist_count);
													if (externalreferenceinfo instanceof Element) {
														if(((Element) externalreferenceinfo).getTagName().equalsIgnoreCase("Source")) {
															orphanetreference.setSource(externalreferenceinfo.getTextContent());
														}
														if(((Element) externalreferenceinfo).getTagName().equalsIgnoreCase("Reference")) {
															orphanetreference.setReference(externalreferenceinfo.getTextContent());
														}
														if(((Element) externalreferenceinfo).getTagName().equalsIgnoreCase("Reference")) {
															orphanetreference.setReference(externalreferenceinfo.getTextContent());
														}
													}
												}
												try {
													OrphanetReferenceLocalServiceUtil.updateOrphanetReference(orphanetreference);
												} catch (SystemException e) {
													System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.ontologie.OntologieUploadImporter::importOrpahnetDisorders] Error updating OrphanetReference.");
													e.printStackTrace();
												}
											}
										}
									}
								}
							}
							try {
								OrphanetDisorderLocalServiceUtil.updateOrphanetDisorder(orphanetdisorder);
							} catch (SystemException e) {
								System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.ontologie.OntologieUploadImporter::importOrpahnetDisorders] Error updating OrphanetDisorder.");
								e.printStackTrace();
							}
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
