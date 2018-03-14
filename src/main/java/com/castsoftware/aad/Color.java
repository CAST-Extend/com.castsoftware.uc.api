package com.castsoftware.aad;

import com.castsoftware.util.CastUtil;

public class Color implements CastJson {
	private boolean useGradient;
	private String from;
	private String to;

	
	public Color(boolean useGradient, String from, String to) {
		super();
		this.useGradient = useGradient;
		this.from = from;
		this.to = to;
	}

	public boolean isUseGradient() {
		return useGradient;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}	
	
	public int getMaxId() {
		return 0;
	}

	public String toJsonString(int level) {
		Boolean previousElement = false;
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{\n", CastUtil.jsonIndentation(level)));
		
		if (previousElement) jsonString.append(",\n");
		jsonString.append(String.format("%s\"useGradient\": %b", CastUtil.jsonIndentation(level+1), useGradient));
		previousElement = true;

		if (to != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"to\": \"%s\"", CastUtil.jsonIndentation(level+1), to));
			previousElement = true;
		}
		if (from != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"from\": \"%s\"", CastUtil.jsonIndentation(level+1), from));
			previousElement = true;
		}
			
		if (previousElement) jsonString.append("\n");
		jsonString.append(String.format("%s}", CastUtil.jsonIndentation(level)));
		return jsonString.toString();
	}
}
