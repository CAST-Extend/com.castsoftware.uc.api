package com.castsoftware.restapi.pojo;

public class Reference {
	private String href;
	private String name;
	private String shortName;
	private String key;
	private String gradeAggregators;
	
	public Reference() {
		super();
	}

	public Reference(String href, String name, String shortName, String key,
			String gradeAggregators) {
		super();
		this.href = href;
		this.name = name;
		this.shortName = shortName;
		this.key = key;
		this.gradeAggregators = gradeAggregators;
	}
	
	public String getHref() {
		return href;
	}
	public String getName() {
		return name;
	}
	public String getShortName() {
		return shortName;
	}
	public String getKey() {
		return key;
	}
	public String getGradeAggregators() {
		return gradeAggregators;
	}
}
