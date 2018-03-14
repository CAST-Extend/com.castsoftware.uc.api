package com.castsoftware.reporting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.castsoftware.reporting.Report;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class ReportHelper {
	private ReportHelper() {} // Avoid instantiation of the class
	
	public static String getEmpowermentReportListAsJson(String fileName) throws IOException
	{
		File file = new File(fileName);
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(file);
			byte[] data = new byte[(int)file.length()];
			fis.read(data);
		    fis.close();
			//
		    String jsonString = new String(data, "UTF-8");
		    return jsonString;
		} finally
		{
			if (fis != null)
				fis.close();
		}
	}
	
	public static ArrayList<Report> getEmpowermentReportList(String fileName) throws JsonParseException, IOException
	{
		Gson gson = new Gson();	
		
        Type collectionType = new TypeToken<Collection<Report>>(){}.getType();
        Collection<Report> tmp = gson.fromJson(getEmpowermentReportListAsJson(fileName), collectionType);
        
        ArrayList<Report> list = new ArrayList<Report>(tmp);
        
        Collections.sort(list);
        return list;
	}
	
	public static Report getEmpowermentReport(String fileName, String reportName) throws JsonParseException, IOException
	{
		ArrayList<Report> list = getEmpowermentReportList(fileName);
		for(Report r : list)
		{
			if (r.getName().equals(reportName))
				return r;
		}
		return null;
	}
	
	public static String getReportGeneratorReportListAsJson(String reportsPath) throws IOException
	{
		Gson gson = new Gson();	
		
		return gson.toJson(getReportGeneratorReportList(reportsPath));
	}
	
	public static ArrayList<Report> getReportGeneratorReportList(String reportsPath) throws IOException
	{
		ArrayList<Report> list = new ArrayList<Report>();		

		DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(reportsPath));
	    for (Path file: stream) 
	    {
	    	list.add(Report.newReportGeneratorReport(file.getFileName().toString()));
	    }
        return list;
	}
	
	public static Report getReportGeneratorReport(String reportsPath, String reportName) throws IOException
	{
		ArrayList<Report> list = getReportGeneratorReportList(reportsPath);
		for(Report r : list)
		{
			if (r.getName().equals(reportName))
				return r;
		}
		return null;
	}

}
