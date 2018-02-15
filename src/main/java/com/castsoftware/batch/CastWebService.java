/**
 * CastWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.castsoftware.batch;

import java.util.Calendar;

public interface CastWebService extends java.rmi.Remote {
    public int consolidateSnapshot(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2) throws java.rmi.RemoteException;
    public java.lang.String getApplicationUUID(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listApplicationNames() throws java.rmi.RemoteException;
    public java.lang.String listConnectionProfiles() throws java.rmi.RemoteException;
    public int deleteSnapshot(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public int automateDeliveryJNLP(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4) throws java.rmi.RemoteException;
    public java.lang.String getErrorMessage(int arg0) throws java.rmi.RemoteException;
    public java.lang.String getTaskFullOutput(int arg0) throws java.rmi.RemoteException;
    public int getTaskExitValue(int arg0) throws java.rmi.RemoteException;
    public java.lang.String getServerVersion() throws java.rmi.RemoteException;
    public int automateDeliveryCharmJNLP(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public int deliveryManagerTool(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4) throws java.rmi.RemoteException;
    public int deliveryReport(java.lang.String appId, java.lang.String appName, java.lang.String versionName,java.lang.String referenceVersion, java.util.Calendar cal) throws java.rmi.RemoteException;
    public int acceptDeliveryDMT(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3) throws java.rmi.RemoteException;
    public int rejectDeliveryDMT(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public int acceptDelivery(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3) throws java.rmi.RemoteException;
    public int setAsCurrentVersion(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3) throws java.rmi.RemoteException;
    public int archiveDelivery(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String ping() throws java.rmi.RemoteException;
    public boolean isTaskRunning(int arg0) throws java.rmi.RemoteException;
    public java.lang.String getTaskOutput(int arg0, int arg1) throws java.rmi.RemoteException;
    public int runAnalysis(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3) throws java.rmi.RemoteException;
    public int runSnapshot(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String consolidateMeasures, java.lang.String rescanType) throws java.rmi.RemoteException;
    public java.lang.String listVersions(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listReports(com.castsoftware.batch.ReportType arg0) throws java.rmi.RemoteException;
    public int runReport(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public java.lang.String listBatches() throws java.rmi.RemoteException;
    public int runBatch(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public String getValidationProbURL() throws java.rmi.RemoteException;
	public int runPublishSnapshot(String aadSchemaName, String centralSchemaName, String appName, String versionName,Calendar cal) throws java.rmi.RemoteException;
	public int runBackup(String schemaName, String appName, String versionName, Calendar cal) throws java.rmi.RemoteException;
	public int runOptimization(String schemaName, String appName, String versionName, Calendar cal) throws java.rmi.RemoteException;
	public String getDmtDeliveryList(String findApp) throws java.rmi.RemoteException;
	public String getSnapshotList(String centralDbName, String appName)  throws java.rmi.RemoteException;
	public String sendAnalysisLogs(String mngtDbName, String appName, String castDate)  throws java.rmi.RemoteException; 
	public String getDMTDeliveryFolder() throws java.rmi.RemoteException;
	public String getPrevDmtVersion(String arg0, String arg1, String arg2)  throws java.rmi.RemoteException;
	public String getQAScanFlag() throws java.rmi.RemoteException;
	public String getValidationStopFlag() throws java.rmi.RemoteException;
	public int DMTLogs(java.lang.String appId, java.lang.String appName, java.lang.String versionName,java.lang.String referenceVersion, java.util.Calendar cal) throws java.rmi.RemoteException;
}
