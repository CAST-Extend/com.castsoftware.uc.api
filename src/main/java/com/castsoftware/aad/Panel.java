package com.castsoftware.aad;

import com.castsoftware.util.CastUtil;

public class Panel implements CastJson {
	private Integer id;
	private String plugin;
	private String color;
	private String size;
	private Parameters parameters;
	
	public Panel(Integer id, String plugin, String color, String size,
			Parameters parameters) {
		super();
		this.id = id;
		this.plugin = plugin;
		this.color = color;
		this.size = size;
		this.parameters = parameters;
	}

	public Integer getId() {
		return id;
	}

	public String getPlugin() {
		return plugin;
	}

	public String getColor() {
		return color;
	}

	public String getSize() {
		return size;
	}

	public Parameters getParameters() {
		return parameters;
	}

	public int getMaxId() {
		int Id = id;
		return Math.max(Id, parameters == null ? 0 : parameters.getMaxId());
	}
	
	public void initializeParameters(){
		if (parameters == null)
			parameters = new Parameters();
	}

	public String toJsonString(int level) {
		Boolean previousElement = false;
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{\n", CastUtil.jsonIndentation(level)));
		if (id != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"id\": %d", CastUtil.jsonIndentation(level+1), id));
			previousElement = true;
		}
		if (plugin != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"plugin\": \"%s\"", CastUtil.jsonIndentation(level+1), plugin));
			previousElement = true;
		}
		if (color != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"color\": \"%s\"", CastUtil.jsonIndentation(level+1), color));
			previousElement = true;
		}
		if (size != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"size\": \"%s\"", CastUtil.jsonIndentation(level+1), size));
			previousElement = true;
		}

		if (parameters != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"parameters\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s", parameters.toJsonString(level+2)));
			previousElement = true;
		}
		
		if (previousElement) jsonString.append("\n");
		jsonString.append(String.format("%s}", CastUtil.jsonIndentation(level+1)));
		return jsonString.toString();
	}
}
