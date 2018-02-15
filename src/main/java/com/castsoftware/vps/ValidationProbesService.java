package com.castsoftware.vps;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.castsoftware.vps.vo.Application;
import com.castsoftware.vps.vo.ValidationResults;

public class ValidationProbesService
{
	private static final Logger logger = Logger.getLogger(ValidationProbesService.class);

	// URL connection;
	MessageFactory messageFactory;
	SOAPConnectionFactory soapConnectionFactory;
	SOAPConnection soapConnection;

	String url;

	public ValidationProbesService(String connection) throws UnsupportedOperationException, SOAPException
	{
		soapConnectionFactory = SOAPConnectionFactory.newInstance();
		soapConnection = soapConnectionFactory.createConnection();
		messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);

		url = connection;
	}

	public List<Application> getApplicationList() throws SOAPFaultException
	{
		logger.debug("Enter getApplicationList");
		List<Application> rslt = new ArrayList<Application>();
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", "GetRescanConsoleApplicationList");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			printSoapMsg(soapResponse);

			body = soapResponse.getSOAPBody();
			if (body.hasFault()) {
				throw new SOAPFaultException(body.getFault());
			} else {
				Iterator<SOAPBodyElement> iterator = body.getChildElements(new QName("http://tempuri.org/",
						"GetRescanConsoleApplicationListResponse"));
				if (iterator.hasNext()) {
					bodyElement = (SOAPBodyElement) iterator.next();
					Iterator<SOAPBodyElement> childElements = bodyElement.getChildElements();
					if (childElements.hasNext()) {
						bodyElement = (SOAPBodyElement) childElements.next();
						if (bodyElement.getNodeName().equals("GetRescanConsoleApplicationListResult")) {
							String appList = bodyElement.getValue();
							JSONArray jsonarray = new JSONArray(appList);
							for (int ii = 0; ii < jsonarray.length(); ii++) {
							    JSONObject jobj = jsonarray.getJSONObject(ii);
								rslt.add(new Application(jobj.getString("appname"),jobj.getString("appversion")));
							}
						}
					}
				}
			}
		} catch (SOAPException | IOException e) {
			logger.error("Error retrieving application List", e);
		}
		logger.debug("Exit getApplicationList");
		return rslt;
	}

	public void UpdateRescanStatus(String appName, String version, String castDate, String status, String stepIdentifier)
	{
		logger.debug(String.format(
				"Enter UpdateRescanStatus for application %s, version %s, castDate %s and status %s ", appName,
				version, castDate, status));
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", "UpdateStatusRescan");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strApplicationName")).addTextNode(appName);
			bodyElement.addChildElement(new QName("strVersion")).addTextNode(version);
			bodyElement.addChildElement(new QName("stepIdentifier")).addTextNode(stepIdentifier);
			bodyElement.addChildElement(new QName("status_to")).addTextNode(status);
			bodyElement.addChildElement(new QName("StartAt"));
			bodyElement.addChildElement(new QName("CastDate")).addTextNode(castDate);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			if (body.hasFault()) {
				SOAPFaultException e = new SOAPFaultException(body.getFault());
				logger.error("Error retrieving application List", e);
				throw e;
			}
			printSoapMsg(soapResponse);

		} catch (SOAPException | IOException e) {
			logger.error(String.format(
					"Error updating rescan status for application %s, version %s, castDate %s and status %s ", appName,
					version, castDate, status), e);
		}
		logger.debug("Exit UpdateRescanStatus");
	}

	public void sendDeliveryReport(String appName, String castDate, String dmtRpt)
	{
		logger.debug(String.format(
				"Enter SendDeliveryReport for application %s, castDate %s", appName, castDate));
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", "ApplicationDeliveryReport");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strApplicationName")).addTextNode(appName);
			bodyElement.addChildElement(new QName("strCastDate")).addTextNode(castDate);
			bodyElement.addChildElement(new QName("Json")).addTextNode(dmtRpt);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			if (body.hasFault()) {
				SOAPFaultException e = new SOAPFaultException(body.getFault());
				logger.error("Error retrieving application List", e);
				throw e;
			}
			printSoapMsg(soapResponse);

		} catch (SOAPException | IOException e) {
			logger.error(String.format(
					"Error sending Delivery Report for application %s, castDate %s ", appName, castDate), e);
		}
		logger.debug("Exit UpdateRescanStatus");
	}

	public void sendAnalysisLogs(String appName, String castDate, String analysisLogs)
	{
		logger.debug(String.format(
				"Enter sendAnalysisLogs for application %s, castDate %s", appName, castDate));
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", "AnalysisUnits");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strApplicationName")).addTextNode(appName);
			bodyElement.addChildElement(new QName("strCastDate")).addTextNode(castDate);
			bodyElement.addChildElement(new QName("Json")).addTextNode(analysisLogs);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			if (body.hasFault()) {
				SOAPFaultException e = new SOAPFaultException(body.getFault());
				logger.error("Error retrieving application List", e);
				throw e;
			}
			printSoapMsg(soapResponse);

		} catch (SOAPException | IOException e) {
			logger.error(String.format(
					"Error sending Delivery Logs for application %s, castDate %s ", appName, castDate), e);
		}
		logger.debug("Exit SendDeliveryLogs");
	}
	
	public void sendDeliveryLogs(String appName, String castDate, String dmtLogs)
	{
		logger.debug(String.format(
				"Enter SendDeliveryLogs for application %s, castDate %s", appName, castDate));
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", "DMTLogs");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strApplicationName")).addTextNode(appName);
			bodyElement.addChildElement(new QName("strCastDate")).addTextNode(castDate);
			bodyElement.addChildElement(new QName("Json")).addTextNode(dmtLogs);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			if (body.hasFault()) {
				SOAPFaultException e = new SOAPFaultException(body.getFault());
				logger.error("Error retrieving application List", e);
				throw e;
			}
			printSoapMsg(soapResponse);

		} catch (SOAPException | IOException e) {
			logger.error(String.format(
					"Error sending Delivery Logs for application %s, castDate %s ", appName, castDate), e);
		}
		logger.debug("Exit SendDeliveryLogs");
	}

	public void sendJenkinsConsolInfo(String appName, String castDate, String ConsoleURL)
	{
		logger.debug(String.format(
				"Enter SendJenkinsConsolInfo for application %s, castDate %s", appName, castDate));
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", "JenkinsConsoleURL");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strApplicationName")).addTextNode(appName);
			bodyElement.addChildElement(new QName("strCastDate")).addTextNode(castDate);
			bodyElement.addChildElement(new QName("URL")).addTextNode(ConsoleURL);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			if (body.hasFault()) {
				SOAPFaultException e = new SOAPFaultException(body.getFault());
				logger.error("Error retrieving application List", e);
				throw e;
			}
			printSoapMsg(soapResponse);

		} catch (SOAPException | IOException e) {
			logger.error(String.format(
					"Error sending Delivery Logs for application %s, castDate %s ", appName, castDate), e);
		}
		logger.debug("Exit SendJenkinsConsolInfo");
	}

	public void updateCurrentRescanTypeAOP(String appName, String rescanType)
	{
		logger.debug(String.format(
				"Enter rescanType for application %s, rescan type %s", appName, rescanType));
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", "UpdateCurrentRunRescanType");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strApplicationName")).addTextNode(appName);
			bodyElement.addChildElement(new QName("strRescanType")).addTextNode(rescanType);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			if (body.hasFault()) {
				SOAPFaultException e = new SOAPFaultException(body.getFault());
				logger.error("Error retrieving application List", e);
				throw e;
			}
			printSoapMsg(soapResponse);

		} catch (SOAPException | IOException e) {
			logger.error(String.format(
					"Error sending rescan type for application %s, rescan type %s ", appName, rescanType), e);
		}
		logger.debug("Exit SendJenkinsConsolInfo");
	}
	
	public void setCurrentPID_IN_AOP(String appName, String PID)
	{
		logger.debug(String.format(
				"Enter PID name for application %s, PID %s", appName, PID));
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", "setCurrentProcessID_InAOP");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strApplicationName")).addTextNode(appName);
			bodyElement.addChildElement(new QName("PID")).addTextNode(PID);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			if (body.hasFault()) {
				SOAPFaultException e = new SOAPFaultException(body.getFault());
				logger.error("Error sending {ID", e);
				throw e;
			}
			printSoapMsg(soapResponse);

		} catch (SOAPException | IOException e) {
			logger.error(String.format(
					"Error sending PID for application %s, PID %s", appName, PID), e);
		}
		logger.debug("Exit setCurrentPID_IN_AOP");
	}
	
	public void setSchemaNamesInAOP(String appName, String schemaPrefix)
	{
		logger.debug(String.format(
				"Enter schema name for application %s, schema prefix %s", appName, schemaPrefix));
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", "setSchemaNamesInAOP");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strApplicationName")).addTextNode(appName);
			bodyElement.addChildElement(new QName("strSchemaPrefix")).addTextNode(schemaPrefix);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			if (body.hasFault()) {
				SOAPFaultException e = new SOAPFaultException(body.getFault());
				logger.error("Error retrieving application List", e);
				throw e;
			}
			printSoapMsg(soapResponse);

		} catch (SOAPException | IOException e) {
			logger.error(String.format(
					"Error sending rescan type for application %s, schema prefix %s", appName, schemaPrefix), e);
		}
		logger.debug("Exit setSchemaNamesInAOP");
	}

	
	public void runAllValidationChecks(String appName, String version)
	{
		logger.debug(String.format("Enter runAllValidationChecks for application %s, version %s", appName, version));
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", "RunAllChecks");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strApplicationName")).addTextNode(appName);
			bodyElement.addChildElement(new QName("strVersion")).addTextNode(version);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			if (body.hasFault()) {
				SOAPFaultException e = new SOAPFaultException(body.getFault());
				logger.error(String.format("Error performing runAllValidationChecks for application %s, version %s",
						appName, version), e);
				throw e;
			}
			printSoapMsg(soapResponse);

		} catch (SOAPException | IOException e) {
			logger.error(String.format("Error runint all validation checks for application %s, version %s", appName,
					version), e);
		}
	}

	public void runAppCompare(String appName, String version)
	{
		logger.debug(String.format("Enter runAppCompareResponse for application %s, version %s", appName, version));
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", "RunAppCompare");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strAppName")).addTextNode(appName);
			bodyElement.addChildElement(new QName("strVersion")).addTextNode(version);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			printSoapMsg(soapResponse);
			if (body.hasFault()) {
				SOAPFaultException e = new SOAPFaultException(body.getFault());
				logger.error(String.format("Error performing runAppCompareResponse for application %s, version %s",
						appName, version), e);
				throw e;
			} else {

			}

		} catch (SOAPException | IOException e) {
			logger.error(String.format("Error runing the application compare check for application %s, version %s",
					appName, version), e);
		}
	}

	private ValidationResults runValidation(String appName, String version, String testName)
	{
		logger.debug(String.format("Enter %s for application %s, version %s", testName, appName, version));
		ValidationResults rslt = null;
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", testName);
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strAppName")).addTextNode(appName);
			bodyElement.addChildElement(new QName("strVersion")).addTextNode(version);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			printSoapMsg(soapResponse);
			if (body.hasFault()) {
				SOAPFaultException e = new SOAPFaultException(body.getFault());
				logger.error(String.format("Error performing runAppCompareResponse for application %s, version %s",
						appName, version), e);
				throw e;
			} else {
				body = soapResponse.getSOAPBody();
				Iterator<SOAPBodyElement> iterator = body.getChildElements(new QName("http://tempuri.org/", testName
						+ "Response"));
				if (iterator.hasNext()) {
					bodyElement = (SOAPBodyElement) iterator.next();
					Iterator<SOAPBodyElement> childElements = bodyElement.getChildElements();
					if (childElements.hasNext()) {
						bodyElement = (SOAPBodyElement) childElements.next();
						if (bodyElement.getNodeName().equals(testName + "Result")) {
							rslt = new ValidationResults(new JSONObject(bodyElement.getTextContent()));
						}
					}
				}
			}
		} catch (SOAPException | IOException e) {
			logger.error(String.format("Error runing the dynamic link check for application %s, version %s", appName,
					version), e);
		}
		return rslt;

	}

	public List <ValidationResults> runAllChecks(String appName, String version)
	{
		String testName="RunAllChecks";
		logger.debug(String.format("Enter %s for application %s, version %s", testName, appName, version));
		List <ValidationResults> rslts = new ArrayList();
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", testName);
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strApplicationName")).addTextNode(appName);
			bodyElement.addChildElement(new QName("strVersion")).addTextNode(version);
			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);

			printSoapMsg(soapResponse);
			if (body.hasFault()) {
				SOAPFaultException e = new SOAPFaultException(body.getFault());
				logger.error(String.format("Error performing runAppCompareResponse for application %s, version %s",
						appName, version), e);
				throw e;
			} else {
				body = soapResponse.getSOAPBody();
				Iterator<SOAPBodyElement> iterator = body.getChildElements(new QName("http://tempuri.org/", testName
						+ "Response"));
				if (iterator.hasNext()) {
					bodyElement = (SOAPBodyElement) iterator.next();
					Iterator<SOAPBodyElement> childElements = bodyElement.getChildElements();
					if (childElements.hasNext()) {
						bodyElement = (SOAPBodyElement) childElements.next();
						if (bodyElement.getNodeName().equals(testName + "Result")) {
							String testResults = bodyElement.getTextContent();
							JSONArray jsonarray = new JSONArray(testResults);
							for (int i = 0; i < jsonarray.length(); i++) {
							    JSONObject jsonobject = jsonarray.getJSONObject(i);
							    rslts.add(new ValidationResults(jsonobject));
							}
						}
					}
				}
			}
		} catch (SOAPException | IOException e) {
			logger.error(String.format("Error runing the dynamic link check for application %s, version %s", appName,
					version), e);
		}
		return rslts;
	}

	public ValidationResults runCheck1DynamicLinks(String appName, String version)
	{
		return runValidation(appName, version, "RunCheck1DynamicLinks");
	}

	public ValidationResults runCheck2DelvVSActual(String appName, String version)
	{
		return runValidation(appName, version, "RunCheck2DelvVSActual");
	}

	public ValidationResults runCheck3AnalysisVSDashboard(String appName, String version)
	{
		return runValidation(appName, version, "RunCheck3AnalysisVSDashboard");
	}

	public ValidationResults runCheck4CurrentDelvVSPreviousDelv(String appName, String version)
	{
		return runValidation(appName, version, "RunCheck4CurrentDelvVSPreviousDelv");
	}

	public ValidationResults runCheck5DBServerNameChange(String appName, String version)
	{
		return runValidation(appName, version, "RunCheck5DBServerNameChange");
	}

	public ValidationResults runCheck6AddedDeletedObjects(String appName, String version)
	{
		return runValidation(appName, version, "RunCheck6AddedDeletedObjects");
	}

	public ValidationResults runCheck7DiagnosticsStability(String appName, String version)
	{
		return runValidation(appName, version, "RunCheck7DiagnosticsStability");
	}

	public void getBackAppNamePassed(String appName)
	{
		try {
			SOAPMessage soapMessage = createSoapMessage();

			// SOAP Body
			SOAPBody body = soapMessage.getSOAPBody();
			body.setPrefix("soap12");
			QName bodyName = new QName("http://tempuri.org/", "GetBackTheAppNamePassed");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			bodyElement.addChildElement(new QName("strApp")).addTextNode(appName);

			printSoapMsg(soapMessage);
			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			printSoapMsg(soapResponse);

		} catch (SOAPException | IOException e) {
			e.printStackTrace();
		}

	}
	


	

	private SOAPMessage createSoapMessage() throws SOAPException
	{
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
		envelope.setPrefix("soap");

		// SOAP Header
		SOAPHeader header = envelope.getHeader();
		header.detachNode();

		return soapMessage;
	}

	static public void printSoapMsg(SOAPMessage soapMessage) throws SOAPException, IOException
	{
		/* Print the request message */
		// Set the output for the transformation
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		soapMessage.writeTo(os);
		logger.debug(new String(os.toByteArray(), "UTF-8"));
	}

	public static void main(String args[]) throws Exception
	{
		ValidationProbesService vps = new ValidationProbesService("http://gaicvmportal:92/ValidationProbesService.asmx");

		for (Application appl : vps.getApplicationList()) {
			System.out.println(appl);
		}
		
		String appName="heal2";
		String version = "V3.0";
		
		// vps.UpdateRescanStatus("heal2", "V3.0", 1,"2016/05/20 08:59:25","Delivery Complete");
		List <ValidationResults>allChecks = vps.runAllChecks(appName, version);
		boolean pass = true;
		for (ValidationResults result: allChecks)
		{
			System.out.println(result);
			if (result.getAdvice().equals("NO GO"))
			{
				pass=false;
			}
		}
		System.out.println(String.format("This application has %s", (pass?"passed":"failed")));
		
		
		
		
//		System.out.println(vps.runCheck1DynamicLinks(appName, version));
//		System.out.println(vps.runCheck2DelvVSActual(appName, version));
//		System.out.println(vps.runCheck3AnalysisVSDashboard(appName, version));
//		System.out.println(vps.runCheck4CurrentDelvVSPreviousDelv(appName, version));
//		System.out.println(vps.runCheck5DBServerNameChange(appName, version));
//		System.out.println(vps.runCheck6AddedDeletedObjects(appName, version));
//		System.out.println(vps.runCheck7DiagnosticsStability(appName, version));
	}

	
	
}
