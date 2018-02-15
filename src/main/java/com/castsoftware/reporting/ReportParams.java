package com.castsoftware.reporting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.castsoftware.exception.ReportException;

public class ReportParams {
  private ReportType reportType;
  private String template;
  private String castMSConnectionProfile; //EMP
  private String application;
  private String snapshotTo;
  private String snapshotFrom;
  private String efpModeTechnicalFilter; //EMP
  private String efpModeDisplayModArt; //EMP
  private String byMetricParam; //EMP
  private String webService; //RG
  private String username; //RG
  private String password; //RG
  
  private static final List<String> parameters = new ArrayList<String>(Arrays.asList(
		  "Application", "SnapshotFrom", "SnapshotTo", "Snapshot", "EFP_MODE_TECHNICAL_FILTER", "EFP_MODE_DISPLAY_MOD_ART", "BY_METRIC_PARAM"));
  
  private static final List<String> empowermentParameters = new ArrayList<String>(Arrays.asList(
		  "Application", "SnapshotFrom", "SnapshotTo", "Snapshot", "EFP_MODE_TECHNICAL_FILTER", "EFP_MODE_DISPLAY_MOD_ART", "BY_METRIC_PARAM"));
  
  private static final List<String> reportGeneratorParameters = new ArrayList<String>(Arrays.asList(
		  "-application", "-snapshot_prev", "-snapshot_cur", "", "", "", ""));
  
  	/*public ReportParams(String castMSConnectionProfile, String application, String snapshotTo,
  			String snapshotFrom, String efpModeTechnicalFilter, String efpModeDisplayModArt,
  			String byMetricParam)
  	{
  		this.castMSConnectionProfile = castMSConnectionProfile;
  		this.application = application;
  		this.snapshotTo = snapshotTo;
  		this.snapshotFrom = snapshotFrom;
  		this.efpModeTechnicalFilter = efpModeTechnicalFilter;
  		this.efpModeDisplayModArt = efpModeDisplayModArt;
  		this.byMetricParam = byMetricParam;
  	}*/
  
  	public static List<String> formatParameters(ReportParams paramValues, List<String> paramTypes) throws ReportException
  	{
  		List<String> list = new ArrayList<String>();
  		
  		//Specific Parameters
  		switch (paramValues.getReportType())
		{
			case Empowerment:
				//TODO
				break;
			case ReportGenerator:
				//webService, username, password
				list.add("-webservice");
				list.add(paramValues.getWebService());
				list.add("-username");
				list.add(paramValues.getUsername());
				list.add("-password");
				list.add(paramValues.getPassword());
				break;
			default:
				throw new ReportException("Unknow Report Type");
		}
  		
  		//Common Parameters
  		for(String param : paramTypes)
  		{
			list.add(getParameter(paramValues.getReportType(), param));				 
  			switch(param)
  			{
  				case "Application":
  					list.add(paramValues.getApplication());
  					break;
  				case "SnapshotFrom":
  					if (paramValues.getReportType() == ReportType.ReportGenerator)
  						list.add(String.format("%s - %s", paramValues.getApplication(), paramValues.getSnapshotFrom()));
  					else
  						list.add(paramValues.getSnapshotFrom());
  					break;
  				case "SnapshotTo":
 					if (paramValues.getReportType() == ReportType.ReportGenerator)
  						list.add(String.format("%s - %s", paramValues.getApplication(), paramValues.getSnapshotTo()));
  					else
  						list.add(paramValues.getSnapshotTo());
  					break;
  				case "Snapshot":
  					list.add(paramValues.getSnapshotTo());
  					break;
  				case "EFP_MODE_TECHNICAL_FILTER":
  					list.add(paramValues.getEfpModeTechnicalFilter());
  					break;
  				case "EFP_MODE_DISPLAY_MOD_ART":
  					list.add(paramValues.getEfpModeDisplayModArt());
  					break;
  				case "BY_METRIC_PARAM":
  					list.add(paramValues.getByMetricParam());
  					break;
  			}
  		}
  		
  		return list;
  	}
  	
  	public static String getParameter(ReportType reportType, String paramName) throws ReportException
  	{
  		int index = parameters.indexOf(paramName); 		
  		switch (reportType)
		{
			case Empowerment:
				return empowermentParameters.get(index);
		case ReportGenerator:
				return reportGeneratorParameters.get(index);
		default:
				throw new ReportException("Unknow Report Type");
		}
  	}
  
  	public String formattedToString(String linePrefix)
  	{
  		String returnValue = "";
  		
  		//Specific Parameters
  		switch (reportType)
		{
			case Empowerment:
				returnValue += String.format("%sEmpowerment Report\n", linePrefix);
				//TODO
				break;
			case ReportGenerator:
				//webService, username, password
				returnValue += String.format("%sReport Generator\n", linePrefix);
				returnValue += String.format("%swebservice: %s\n", linePrefix, webService);
				returnValue += String.format("%susername: %s\n", linePrefix, username);
				returnValue += String.format("%spassword: %s\n", linePrefix, "********");
				break;
			default:
				return "Unknow Report Type";
		}
  		
  		returnValue += String.format("%sapplication: %s\n", linePrefix, application);
  		returnValue += String.format("%ssnapshotTo: %s\n", linePrefix, snapshotTo);
  		returnValue += String.format("%ssnapshotFrom: %s", linePrefix, snapshotFrom);
  		
  		return returnValue;
  	}
  
	public String getCastMSConnectionProfile() 
	{
		return castMSConnectionProfile;
	}
	
	public void setCastMSConnectionProfile(String castMSConnectionProfile) 
	{
		this.castMSConnectionProfile = castMSConnectionProfile;
	}
	
	public String getApplication() 
	{
		return application;
	}
	
	public void setApplication(String application) 
	{
		this.application = application;
	}
	
	public String getSnapshotTo() 
	{
		return snapshotTo;
	}
	
	public void setSnapshotTo(String snapshotTo) 
	{
		this.snapshotTo = snapshotTo;
	}
	
	public String getSnapshotFrom() 
	{
		return snapshotFrom;
	}
	
	public void setSnapshotFrom(String snapshotFrom) 
	{
		this.snapshotFrom = snapshotFrom;
	}
	
	public String getEfpModeTechnicalFilter() 
	{
		return efpModeTechnicalFilter;
	}
	
	public void setEfpModeTechnicalFilter(String efpModeTechnicalFilter) 
	{
		this.efpModeTechnicalFilter = efpModeTechnicalFilter;
	}
	
	public String getEfpModeDisplayModArt() 
	{
		return efpModeDisplayModArt;
	}
	
	public void setEfpModeDisplayModArt(String efpModeDisplayModArt) 
	{
		this.efpModeDisplayModArt = efpModeDisplayModArt;
	}
	
	public String getByMetricParam() 
	{
		return byMetricParam;
	}
	
	public void setByMetricParam(String byMetricParam) 
	{
		this.byMetricParam = byMetricParam;
	}

	public ReportType getReportType() 
	{
		return reportType;
	}

	public void setReportType(ReportType reportType) 
	{
		this.reportType = reportType;
	}

	public String getTemplate() 
	{
		return template;
	}

	public void setTemplate(String template) 
	{
		this.template = template;
	}

	public String getWebService() 
	{
		return webService;
	}

	public void setWebService(String webService) 
	{
		this.webService = webService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

}
