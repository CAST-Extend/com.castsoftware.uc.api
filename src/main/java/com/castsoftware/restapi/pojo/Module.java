package com.castsoftware.restapi.pojo;

import java.util.List;

public class Module {
    private String href;
    private String name;
    private List<String> technologies;
    private SimpleReference applications;
    private SimpleReference snapshots;
    private SimpleReference results;
    
	public Module() {
		super();
	}

	public Module(String href, String name, List<String> technologies,
			SimpleReference applications, SimpleReference snapshots,
			SimpleReference results) {
		super();
		this.href = href;
		this.name = name;
		this.technologies = technologies;
		this.applications = applications;
		this.snapshots = snapshots;
		this.results = results;
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
	public SimpleReference getApplications() {
		return applications;
	}
	public SimpleReference getSnapshots() {
		return snapshots;
	}
	public SimpleReference getResults() {
		return results;
	}
}
