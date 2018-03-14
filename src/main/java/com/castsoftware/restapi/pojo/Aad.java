package com.castsoftware.restapi.pojo;

public class Aad {
	private String href;
	private String name;
	private String dbType;
	private String version;
	private String dbmsVersion;
	private SimpleReference systems;
	private SimpleReference applications;
	private SimpleReference configurations;
	private SimpleReference results;
	private SimpleReference commonCategories;
	private SimpleReference tags;	
	
	public Aad()
	{
		super();
	}
	
	public Aad(String href, String name, String dbType, String version,
			String dbmsVersion, SimpleReference systems,
			SimpleReference applications, SimpleReference configurations,
			SimpleReference results, SimpleReference commonCategories,
			SimpleReference tags) {
		super();
		this.href = href;
		this.name = name;
		this.dbType = dbType;
		this.version = version;
		this.dbmsVersion = dbmsVersion;
		this.systems = systems;
		this.applications = applications;
		this.configurations = configurations;
		this.results = results;
		this.commonCategories = commonCategories;
		this.tags = tags;
	}
	
	public String getHref() {
		return href;
	}
	public String getName() {
		return name;
	}
	public String getDbType() {
		return dbType;
	}
	public String getVersion() {
		return version;
	}
	public String getDbmsVersion() {
		return dbmsVersion;
	}
	public SimpleReference getSystems() {
		return systems;
	}
	public SimpleReference getApplications() {
		return applications;
	}
	public SimpleReference getConfigurations() {
		return configurations;
	}
	public SimpleReference getResults() {
		return results;
	}
	public SimpleReference getCommonCategories() {
		return commonCategories;
	}
	public SimpleReference getTags() {
		return tags;
	}	
}
