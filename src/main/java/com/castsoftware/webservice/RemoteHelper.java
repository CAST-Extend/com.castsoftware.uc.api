package com.castsoftware.webservice;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.castsoftware.batch.CastWebService;
import com.castsoftware.batch.CastWebServiceServiceLocator;
import com.castsoftware.batch.ReportType;
import com.castsoftware.batches.pojo.Batch;
import com.castsoftware.exception.HelperException;
import com.castsoftware.profiles.ConnectionProfile;
import com.castsoftware.reporting.Report;
import com.castsoftware.util.VersionInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RemoteHelper {
	private RemoteHelper() {} // Avoid instantiation of the class
	
	public static Collection<ConnectionProfile> listConnectionProfiles(String webServiceAddress) throws HelperException
	{		
		String jsonString = "";
		try
		{
			CastWebServiceServiceLocator cbwsl = new CastWebServiceServiceLocator();
			cbwsl.setCastWebServicePortEndpointAddress(webServiceAddress);
			CastWebService cbws = cbwsl.getCastWebServicePort();
			jsonString = cbws.listConnectionProfiles();
			
			Gson gson = new Gson();	
			
	        Type collectionType = new TypeToken<Collection<ConnectionProfile>>(){}.getType();
	        Collection<ConnectionProfile> tmp = gson.fromJson(jsonString, collectionType);
	        return tmp;
		} catch (Exception e) {
			throw new HelperException(String.format("%s - %s", e.getMessage(), jsonString));
		}
	}
	
	public static List<String> listApplications(String webServiceAddress) throws HelperException
	{		
		String jsonString = "";
		try
		{		
			CastWebServiceServiceLocator cbwsl = new CastWebServiceServiceLocator();
			cbwsl.setCastWebServicePortEndpointAddress(webServiceAddress);
			CastWebService cbws = cbwsl.getCastWebServicePort();
			jsonString = cbws.listApplicationNames();
			
			Gson gson = new Gson();	
			
	        Type collectionType = new TypeToken<Collection<String>>(){}.getType();
	        Collection<String> tmp = gson.fromJson(jsonString, collectionType);
	        
	        List<String> appList = new ArrayList<String>(tmp);
	        
	        Collections.sort(appList);
	        return appList;
		} catch (Exception e) {
			throw new HelperException(String.format("%s - %s", e.getMessage(), jsonString == null ? "" : jsonString));
		}
	}
	
	public static List<String> listVersions(String webServiceAddress, String applicationName) throws HelperException
	{		
		String jsonString = "";
		try
		{		
			CastWebServiceServiceLocator cbwsl = new CastWebServiceServiceLocator();
			cbwsl.setCastWebServicePortEndpointAddress(webServiceAddress);
			CastWebService cbws = cbwsl.getCastWebServicePort();
			jsonString = cbws.listVersions(applicationName);
			
			Gson gson = new Gson();	
			
	        Type collectionType = new TypeToken<Collection<String>>(){}.getType();
	        Collection<String> tmp = gson.fromJson(jsonString, collectionType);
	        
	        List<String> appList = new ArrayList<String>(tmp);
	        
	        return appList;
		} catch (Exception e) {
			throw new HelperException(String.format("%s - %s", e.getMessage(), jsonString));
		}
	}
	
	public static List<Report> listReports(String webServiceAddress, ReportType reportType) throws HelperException
	{
		String jsonString = "";
		try
		{
			CastWebServiceServiceLocator cbwsl = new CastWebServiceServiceLocator();

			cbwsl.setCastWebServicePortEndpointAddress(webServiceAddress);
			CastWebService cbws = cbwsl.getCastWebServicePort();
			jsonString = cbws.listReports(reportType);
			
			Gson gson = new Gson();	
			
	        Type collectionType = new TypeToken<Collection<Report>>(){}.getType();
	        Collection<Report> tmp = gson.fromJson(jsonString, collectionType);
	        
	        List<Report> erList = new ArrayList<Report>(tmp);
	        
	        Collections.sort(erList);
	        
	        return erList;
		} catch (Exception e) {
			throw new HelperException(String.format("%s - %s", e.getMessage(), jsonString));
		}
	}
	
	public static List<Batch> listBatches(String webServiceAddress) throws HelperException
	{
		String jsonString = "";
		try
		{
			CastWebServiceServiceLocator cbwsl = new CastWebServiceServiceLocator();

			cbwsl.setCastWebServicePortEndpointAddress(webServiceAddress);
			CastWebService cbws = cbwsl.getCastWebServicePort();
			jsonString = cbws.listBatches();
			
			Gson gson = new Gson();	
			
	        Type collectionType = new TypeToken<Collection<Batch>>(){}.getType();
	        Collection<Batch> tmp = gson.fromJson(jsonString, collectionType);
	        
	        List<Batch> erList = new ArrayList<Batch>(tmp);
	        
	        Collections.sort(erList);
	        
	        return erList;
		} catch (Exception e) {
			throw new HelperException(String.format("%s - %s", e.getMessage(), jsonString));
		}
	}
	
	public static VersionInfo getVersionInfo(String webServiceAddress) throws HelperException
	{
		String jsonString = "";
		try
		{
			CastWebServiceServiceLocator cbwsl = new CastWebServiceServiceLocator();

			cbwsl.setCastWebServicePortEndpointAddress(webServiceAddress);
			CastWebService cbws = cbwsl.getCastWebServicePort();
			jsonString = cbws.getServerVersion();
			
			Gson gson = new Gson();	
	        VersionInfo tmp = gson.fromJson(jsonString, VersionInfo.class);
	      	        
	        return tmp;
		} catch (Exception e) {
			throw new HelperException(String.format("%s - %s", e.getMessage(), jsonString));
		}
	}
}
