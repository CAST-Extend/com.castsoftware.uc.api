package com.castsoftware.restapi.pojo;

public class Annotation {
	private String version;
	private JsonDate date;
	private String descriptions;
	private String name;	
	
	public Annotation() {
		super();
	}

	public Annotation(String version, JsonDate date, String descriptions,
			String name) {
		super();
		this.version = version;
		this.date = date;
		this.descriptions = descriptions;
		this.name = name;
	}
	
	public String getVersion() {
		return version;
	}
	public JsonDate getDate() {
		return date;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public String getName() {
		return name;
	}	
}
