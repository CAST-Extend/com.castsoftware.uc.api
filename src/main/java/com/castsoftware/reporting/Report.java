package com.castsoftware.reporting;

import java.util.ArrayList;
import java.util.List;

import com.castsoftware.exception.ReportException;

public class Report implements Comparable<Report> {	
	private String name;
	private String category;
	private String template;
	private List<String> params;
	private ReportType reportType;
	
	public static Report newReportGeneratorReport(String name)
	{
		Report report = new Report();
		report.name = name.replaceAll("\\.[A-Za-z]$", ""); //remove extensions
		report.category = "";
		report.template = name;
		report.reportType = ReportType.ReportGenerator;
		List<String> params = new ArrayList<String>();
		params.add("Application");
		params.add("SnapshotFrom");
		params.add("SnapshotTo");
		report.params = params;
		return report;
	}
	
	public static List<String> formatParameters(Report report) throws ReportException
	{
		List<String> list = new ArrayList<String>();
		
		switch (report.getReportType())
		{
			case Empowerment:
				//TODO
				break;
			case ReportGenerator:
				//template
				list.add("-template");
				list.add(report.getTemplate());
				break;
			default:
				throw new ReportException("Unknow Report Type");
		}
		
		return list;
	}
	
	public int compareTo(Report report)
	{
		return String.format("%s %s", category, name).compareTo(String.format("%s %s", report.getCategory(), report.getName()));
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getCategory() 
	{
		return category;
	}
	
	public void setCategory(String category) 
	{
		this.category = category;
	}
	
	public String getTemplate() 
	{
		return template;
	}
	
	public void setTemplate(String template) 
	{
		this.template = template;
	}
	
	public List<String> getParams() 
	{
		return params;
	}
	
	public void setParams(List<String> params) 
	{
		this.params = params;
	}

	public ReportType getReportType() 
	{
		return reportType;
	}

	public void setReportType(ReportType reportType) 
	{
		this.reportType = reportType;
	}
}
