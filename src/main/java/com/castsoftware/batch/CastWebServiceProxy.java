package com.castsoftware.batch;

import java.util.ArrayList;
import java.util.List;

import com.castsoftware.vps.vo.ValidationResults;

public class CastWebServiceProxy implements com.castsoftware.batch.CastWebService
{
	private String _endpoint = null;
	private com.castsoftware.batch.CastWebService castWebService = null;

	public CastWebServiceProxy()
	{
		_initCastWebServiceProxy();
	}

	public CastWebServiceProxy(String endpoint)
	{
		_endpoint = endpoint;
		_initCastWebServiceProxy();
	}

	private void _initCastWebServiceProxy()
	{
		try {
			castWebService = (new com.castsoftware.batch.CastWebServiceServiceLocator()).getCastWebServicePort();
			if (castWebService != null) {
				if (_endpoint != null) ((javax.xml.rpc.Stub) castWebService)._setProperty(
						"javax.xml.rpc.service.endpoint.address", _endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) castWebService)
							._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint()
	{
		return _endpoint;
	}

	public void setEndpoint(String endpoint)
	{
		_endpoint = endpoint;
		if (castWebService != null)
			((javax.xml.rpc.Stub) castWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.castsoftware.batch.CastWebService getCastWebService()
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService;
	}

	public java.lang.String ping() throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.ping();
	}

	public boolean isTaskRunning(int arg0) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.isTaskRunning(arg0);
	}

	public java.lang.String getTaskOutput(int arg0, int arg1) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getTaskOutput(arg0, arg1);
	}

	public int runAnalysis(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.runAnalysis(arg0, arg1, arg2, arg3);
	}

	public int runSnapshot(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3,
			java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.runSnapshot(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	public java.lang.String listVersions(java.lang.String arg0) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.listVersions(arg0);
	}

	public java.lang.String listReports(com.castsoftware.batch.ReportType arg0) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.listReports(arg0);
	}

	public int runReport(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.runReport(arg0, arg1, arg2);
	}

	public java.lang.String listApplicationNames() throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.listApplicationNames();
	}

	public java.lang.String listConnectionProfiles() throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.listConnectionProfiles();
	}

	public java.lang.String listBatches() throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.listBatches();
	}

	public int runBatch(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.runBatch(arg0, arg1);
	}

	public java.lang.String getErrorMessage(int arg0) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getErrorMessage(arg0);
	}

	public java.lang.String getTaskFullOutput(int arg0) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getTaskFullOutput(arg0);
	}

	public int getTaskExitValue(int arg0) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getTaskExitValue(arg0);
	}

	public java.lang.String getServerVersion() throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getServerVersion();
	}

	public int deliveryManagerTool(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.lang.String arg3, java.util.Calendar arg4) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.deliveryManagerTool(arg0, arg1, arg2, arg3, arg4);
	}
	
	public int UpdateRescanStatus(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.UpdateRescanStatus(arg0, arg1, arg2, arg3, arg4);
	}

	public int deliveryReport(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,  java.lang.String arg3,java.util.Calendar arg4)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.deliveryReport(arg0, arg1, arg2, arg3, arg4);
	}

	public int DMTLogs(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,  java.lang.String arg3,java.util.Calendar arg4)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.DMTLogs(arg0, arg1, arg2, arg3, arg4);
	}
	
	

	public int acceptDeliveryDMT(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.util.Calendar arg3) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.acceptDeliveryDMT(arg0, arg1, arg2, arg3);
	}

	public int acceptDelivery(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.util.Calendar arg3) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.acceptDelivery(arg0, arg1, arg2, arg3);
	}

	public int setAsCurrentVersion(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.util.Calendar arg3) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.setAsCurrentVersion(arg0, arg1, arg2, arg3);
	}

	public int archiveDelivery(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.archiveDelivery(arg0, arg1);
	}
	
	
	public int setCurrentScanType(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.setCurrentScanType(arg0, arg1);
	}
	public int setSchemaNamesInAOP(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.setSchemaNamesInAOP(arg0, arg1);
	}
	public int sendJenkinsConsolURL(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.sendJenkinsConsolURL(arg0, arg1, arg2);
	}
	
	public String runAllChecks(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.runAllChecks(arg0, arg1);
	}
	
	public int addAppl() throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.addAppl();
	}

	public int deleteAppl() throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.deleteAppl();
	}

	public int getApplCount() throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getApplCount();
	}
	
	/*
	public String getLowestAppRunCmsAnalServer(java.lang.String cms_anal1, java.lang.String cms_anal2, java.lang.String cms_anal3, java.lang.String cms_anal4, java.lang.String cms_anal5) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getLowestAppRunCmsAnalServer(cms_anal1, cms_anal2, cms_anal3, cms_anal4, cms_anal5);
	}	
	*/

	public int deleteSnapshot(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2,
			java.lang.String arg3) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.deleteSnapshot(arg0, arg1, arg2, arg3);
	}

	public int consolidateSnapshot(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.consolidateSnapshot(arg0, arg1, arg2);
	}

	public java.lang.String getApplicationUUID(java.lang.String arg0) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getApplicationUUID(arg0);
	}

	public int automateDeliveryJNLP(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.lang.String arg3, java.util.Calendar arg4) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.automateDeliveryJNLP(arg0, arg1, arg2, arg3, arg4);
	}

	public int automateDeliveryCharmJNLP(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.lang.String arg3) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.automateDeliveryCharmJNLP(arg0, arg1, arg2, arg3);
	}

	public int rejectDeliveryDMT(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.rejectDeliveryDMT(arg0, arg1, arg2);
	}

	public String getValidationProbURL() throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getValidationProbURL();
	}

	public String getDMTDeliveryFolder() throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getDMTDeliveryFolder();
	}

	public String getQAScanFlag() throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getQAScanFlag();
	}

	public String getValidationStopFlag() throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getValidationStopFlag();
	}

	public int runPublishSnapshot(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.lang.String arg3, java.util.Calendar arg4) throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.runPublishSnapshot(arg0, arg1, arg2, arg3, arg4);
	}

	public int runBackup(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.runBackup(arg0, arg1, arg2, arg3);
	}

	public int runOptimization(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.runOptimization(arg0, arg1, arg2, arg3);
	}
	
	public String getDmtDeliveryList(java.lang.String arg0)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getDmtDeliveryList(arg0);
	}

	public String getSnapshotList(java.lang.String arg0, java.lang.String arg1)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getSnapshotList(arg0, arg1);
	}
	
	public String sendAnalysisLogs(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.sendAnalysisLogs(arg0, arg1, arg2);
	}


	
	public String getPrevDmtVersion(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.sendAnalysisLogs(arg0, arg1, arg2);
	}
	
	public String getlatestDmtVersion(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2)
			throws java.rmi.RemoteException
	{
		if (castWebService == null) _initCastWebServiceProxy();
		return castWebService.getlatestDmtVersion(arg0, arg1, arg2);
	}
 

}