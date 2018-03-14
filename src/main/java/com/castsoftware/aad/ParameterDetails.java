package com.castsoftware.aad;

import com.castsoftware.util.CastUtil;

public class ParameterDetails implements CastJson {
	private String id;
	private String format;
	private String tooltipFormat;
	private String description;
	
	public ParameterDetails(String id, String format, String tooltipFormat,
			String description) {
		super();
		this.id = id;
		this.format = format;
		this.tooltipFormat = tooltipFormat;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getFormat() {
		return format;
	}

	public String getTooltipFormat() {
		return tooltipFormat;
	}

	public String getDescription() {
		return description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setTooltipFormat(String tooltipFormat) {
		this.tooltipFormat = tooltipFormat;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxId() {
		//not a numeric id in this case
		return 0;
	}

	public String toJsonString(int level) {
		Boolean previousElement = false;
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{\n", CastUtil.jsonIndentation(level)));
		if (id != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"id\": \"%s\"", CastUtil.jsonIndentation(level+1), id));
			previousElement = true;
		}
		if (format != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"format\": \"%s\"", CastUtil.jsonIndentation(level+1), format));
			previousElement = true;
		}
		if (tooltipFormat != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"tooltipFormat\": \"%s\"", CastUtil.jsonIndentation(level+1), tooltipFormat));
			previousElement = true;
		}
		if (description != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"description\": \"%s\"", CastUtil.jsonIndentation(level+1), description));
			previousElement = true;
		}
		
		if (previousElement) jsonString.append("\n");
		jsonString.append(String.format("%s}", CastUtil.jsonIndentation(level+1)));
		return jsonString.toString();
	}
}
