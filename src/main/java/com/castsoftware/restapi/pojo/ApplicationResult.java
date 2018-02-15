package com.castsoftware.restapi.pojo;

import java.util.List;

public class ApplicationResult {
	private String type;
	private Reference reference;
	private Result result;
	private List<String> technologyResults;
	private List<String> moduleResults;
    
	public ApplicationResult() {
		super();
	}

	public ApplicationResult(String type, Reference reference, Result result,
			List<String> technologyResults, List<String> moduleResults) {
		super();
		this.type = type;
		this.reference = reference;
		this.result = result;
		this.technologyResults = technologyResults;
		this.moduleResults = moduleResults;
	}
	
	public String getType() {
		return type;
	}
	public Reference getReference() {
		return reference;
	}
	public Result getResult() {
		return result;
	}
	public List<String> getTechnologyResults() {
		return technologyResults;
	}
	public List<String> getModuleResults() {
		return moduleResults;
	}    
}
