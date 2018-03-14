package com.castsoftware.restapi.pojo;

public class ActionPlan {
	private SimpleReference issues;//TODO: check type
	private SimpleReference summary;	
	
	public ActionPlan() {
		super();
	}

	public ActionPlan(SimpleReference issues, SimpleReference summary) {
		super();
		this.issues = issues;
		this.summary = summary;
	}
	
	public SimpleReference getIssues() {
		return issues;
	}
	public SimpleReference getSummary() {
		return summary;
	}	
}
