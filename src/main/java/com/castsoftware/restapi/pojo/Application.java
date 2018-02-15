package com.castsoftware.restapi.pojo;

import java.util.List;

public class Application {
	private String href;
	private String name;
	private List<String> technologies;
	private SimpleReference systems;
	private SimpleReference modules;
	private SimpleReference snapshots;
	private SimpleReference results;
	private String origin;
	private String adgDatabase;
	private String adgWebSite;
	private String adgLocalId;
	private String adgVersion;    
    
	public Application() {
		super();
	}

	public Application(String href, String name, List<String> technologies,
			SimpleReference systems, SimpleReference modules,
			SimpleReference snapshots, SimpleReference results, String origin,
			String adgDatabase, String adgWebSite, String adgLocalId,
			String adgVersion) {
		super();
		this.href = href;
		this.name = name;
		this.technologies = technologies;
		this.systems = systems;
		this.modules = modules;
		this.snapshots = snapshots;
		this.results = results;
		this.origin = origin;
		this.adgDatabase = adgDatabase;
		this.adgWebSite = adgWebSite;
		this.adgLocalId = adgLocalId;
		this.adgVersion = adgVersion;
	}
	
	public String getHref() {
		return href;
	}
	public String getName() {
		return name;
	}
	public List<String> getTechnologies() {
		return technologies;
	}
	public SimpleReference getSystems() {
		return systems;
	}
	public SimpleReference getModules() {
		return modules;
	}
	public SimpleReference getSnapshots() {
		return snapshots;
	}
	public SimpleReference getResults() {
		return results;
	}
	public String getOrigin() {
		return origin;
	}
	public String getAdgDatabase() {
		return adgDatabase;
	}
	public String getAdgWebSite() {
		return adgWebSite;
	}
	public String getAdgLocalId() {
		return adgLocalId;
	}
	public String getAdgVersion() {
		return adgVersion;
	}
}
