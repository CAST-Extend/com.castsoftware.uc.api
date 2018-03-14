package com.castsoftware.restapi.pojo;

public class SimpleReference {
	private String href;
	private String name;
	
	public SimpleReference()
	{
		super();
	}
	
	public SimpleReference(String href, String name) {
		super();
		this.href = href;
		this.name = name;
	}
	
	public String getHref() {
		return href;
	}
	public String getName() {
		return name;
	}
}
