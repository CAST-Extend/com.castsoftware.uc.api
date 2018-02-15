package com.castsoftware.aad;

import com.castsoftware.util.CastUtil;

public class PeriodDetails implements CastJson {
	private Integer diff;
	private String units;
	private boolean selected;
	
	public PeriodDetails(Integer diff, String units, boolean selected) {
		super();
		this.diff = diff;
		this.units = units;
		this.selected = selected;
	}

	public Integer getDiff() {
		return diff;
	}

	public String getUnits() {
		return units;
	}

	public boolean getSelected() {
		return selected;
	}

	public int getMaxId() {
		return 0;
	}

	public String toJsonString(int level) {
		Boolean previousElement = false;
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{\n", CastUtil.jsonIndentation(level)));
		if (diff != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"diff\": %d", CastUtil.jsonIndentation(level+1), diff));
			previousElement = true;
		}
		if (units != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"units\": \"%s\"", CastUtil.jsonIndentation(level+1), units));
			previousElement = true;
		}
		
		if (previousElement) jsonString.append(",\n");
		jsonString.append(String.format("%s\"selected\": %b", CastUtil.jsonIndentation(level+1), selected));
		previousElement = true;
		
		if (previousElement) jsonString.append("\n");
		jsonString.append(String.format("%s}", CastUtil.jsonIndentation(level+1)));
		return jsonString.toString();
	}
}
