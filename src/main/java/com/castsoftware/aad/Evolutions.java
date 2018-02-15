package com.castsoftware.aad;

import com.castsoftware.util.CastUtil;

public class Evolutions implements CastJson {
	private Integer selectedApplicationCount;	
	
	public Evolutions(Integer selectedApplicationCount) {
		super();
		this.selectedApplicationCount = selectedApplicationCount;
	}

	public Integer getSelectedApplicationCount() {
		return selectedApplicationCount;
	}	

	public int getMaxId() {
		return 0;
	}

	public String toJsonString(int level) {
		Boolean previousElement = false;
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{\n", CastUtil.jsonIndentation(level)));
		
		if (selectedApplicationCount != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"selectedApplicationCount\": %d", CastUtil.jsonIndentation(level+1), selectedApplicationCount));
			previousElement = true;
		}
			
		if (previousElement) jsonString.append("\n");
		jsonString.append(String.format("%s}", CastUtil.jsonIndentation(level+1)));
		return jsonString.toString();
	}
}
