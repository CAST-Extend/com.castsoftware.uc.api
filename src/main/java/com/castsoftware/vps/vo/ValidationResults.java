package com.castsoftware.vps.vo;

import org.json.JSONObject;

public class ValidationResults
{
	public static final String CHECK_RESULTS ="Check Results";
	public static final String CHECK_DESCRIPTION = "Check Description";
	public static final String CHECK_NUMBER = "Check Number";
	public static final String CHECK_ADVICE = "Advice";
	public static final String CHECK_URL = "URL";

	String checkResults;
	String testDescription;
	String checkNumber;
	String Advice;
	String url;
	
	String runStatus;
	String color;
	String resultDescription;
	
	public ValidationResults(JSONObject jsonobject)
	{
		checkResults = jsonobject.getString(CHECK_RESULTS);
		testDescription = jsonobject.getString(CHECK_DESCRIPTION);
		checkNumber = jsonobject.getString(CHECK_NUMBER);
		Advice = jsonobject.getString(CHECK_ADVICE);
		url = jsonobject.getString(CHECK_URL);
		
		String [] details = getCheckResultsNoTags().split(";");
		if (details.length >0)
		{
			runStatus=details[0];
		} 
		if (details.length >2)
		{
			color=details[2];
		} 
		if (details.length >3)
		{
			resultDescription=details[3];
		} 
		
	}
	
	
	public String getCheckResults()
	{
		return checkResults;
	}
	public String getCheckResultsNoTags()
	{
		return checkResults.replaceAll("\\<[^>]*>","");
	}


	public void setCheckResults(String checkResults)
	{
		this.checkResults = checkResults;
	}


	public String getTestDescription()
	{
		return testDescription;
	}


	public void setTestDescription(String testDescription)
	{
		this.testDescription = testDescription;
	}


	public String getCheckNumber()
	{
		return checkNumber;
	}


	public void setCheckNumber(String checkNumber)
	{
		this.checkNumber = checkNumber;
	}


	public String getAdvice()
	{
		return Advice;
	}


	public void setAdvice(String advice)
	{
		Advice = advice;
	}


	public String getUrl()
	{
		return url;
	}


	public void setUrl(String url)
	{
		this.url = url;
	}


	public String getRunStatus()
	{
		return runStatus;
	}


	public void setRunStatus(String runStatus)
	{
		this.runStatus = runStatus;
	}


	public String getColor()
	{
		return color;
	}


	public void setColor(String color)
	{
		this.color = color;
	}


	public String getResultDescription()
	{
		return resultDescription;
	}


	public void setResultDescription(String resultDescription)
	{
		this.resultDescription = resultDescription;
	}


	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ValidationResults [checkResults=");
		builder.append(getCheckResultsNoTags());
		builder.append(", testDescription=");
		builder.append(testDescription);
		builder.append(", checkNumber=");
		builder.append(checkNumber);
		builder.append(", Advice=");
		builder.append(Advice);
		builder.append(", url=");
		builder.append(url);
		builder.append("]");
		return builder.toString();
	}


}
