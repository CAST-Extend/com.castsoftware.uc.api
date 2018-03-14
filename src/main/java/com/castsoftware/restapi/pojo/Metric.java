package com.castsoftware.restapi.pojo;

import java.util.List;

public class Metric {
	private int number;
	private JsonDate date;
	private Application application;
	private SimpleReference applicationSnapshot;
	private List<ApplicationResult> applicationResults;
	
	public Metric() {
		super();
	}

	public Metric(int number, JsonDate date, Application application,
			SimpleReference applicationSnapshot,
			List<ApplicationResult> applicationResults) {
		super();
		this.number = number;
		this.date = date;
		this.application = application;
		this.applicationSnapshot = applicationSnapshot;
		this.applicationResults = applicationResults;
	}
	
	public int getNumber() {
		return number;
	}
	public JsonDate getDate() {
		return date;
	}
	public Application getApplication() {
		return application;
	}
	public SimpleReference getApplicationSnapshot() {
		return applicationSnapshot;
	}
	public List<ApplicationResult> getApplicationResults() {
		return applicationResults;
	}
}
