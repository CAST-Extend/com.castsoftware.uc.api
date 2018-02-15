package com.castsoftware.restapi.pojo;

import java.util.List;

public class Snapshot implements Comparable<Snapshot>{
	private String href;
	private String name;
	private String number;
	
	private List<String> technologies;
	private Annotation annotation;
	private SimpleReference configurationSnapshot;
	private SimpleReference systems;
	private Application application;
	private SimpleReference moduleSnapshots;
	private SimpleReference results;
	private ActionPlan actionPlan;
	private SimpleReference components;
	private SimpleReference transactions;	

	public Snapshot() {
		super();
	}

	public Snapshot(String href, String name, String number,
			List<String> technologies, Annotation annotation,
			SimpleReference configurationSnapshot, SimpleReference systems,
			Application application, SimpleReference moduleSnapshots,
			SimpleReference results, ActionPlan actionPlan,
			SimpleReference components, SimpleReference transactions) {
		super();
		this.href = href;
		this.name = name;
		this.number = number;
		this.technologies = technologies;
		this.annotation = annotation;
		this.configurationSnapshot = configurationSnapshot;
		this.systems = systems;
		this.application = application;
		this.moduleSnapshots = moduleSnapshots;
		this.results = results;
		this.actionPlan = actionPlan;
		this.components = components;
		this.transactions = transactions;
	}

	public String getHref() {
		return href;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public List<String> getTechnologies() {
		return technologies;
	}

	public Annotation getAnnotation() {
		return annotation;
	}

	public SimpleReference getConfigurationSnapshot() {
		return configurationSnapshot;
	}

	public SimpleReference getSystems() {
		return systems;
	}

	public Application getApplication() {
		return application;
	}

	public SimpleReference getModuleSnapshots() {
		return moduleSnapshots;
	}

	public SimpleReference getResults() {
		return results;
	}

	public ActionPlan getActionPlan() {
		return actionPlan;
	}

	public SimpleReference getComponents() {
		return components;
	}

	public SimpleReference getTransactions() {
		return transactions;
	}

	public int compareTo(Snapshot o) {
		return o.annotation.getDate().getAsDate().compareTo(annotation.getDate().getAsDate());
	}	
}
