package com.castsoftware.vps.vo;

public class Application
{
	String ApplicationName;
	String ApplicationVersion;
	
	public Application(String applicationName, String applicationVersion)
	{
		this.ApplicationName = applicationName;
		this.ApplicationVersion = applicationVersion;
	}

	public String getApplicationName()
	{
		return ApplicationName;
	}

	public void setApplicationName(String applicationName)
	{
		ApplicationName = applicationName;
	}

	public String getApplicationVersion()
	{
		return ApplicationVersion;
	}

	public void setApplicationVersion(String applicationVersion)
	{
		ApplicationVersion = applicationVersion;
	}

	@Override
	public String toString()
	{
		return "Application [ApplicationName=" + ApplicationName + ", ApplicationVersion=" + ApplicationVersion + "]";
	}
	
	
}
