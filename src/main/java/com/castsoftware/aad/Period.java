package com.castsoftware.aad;

import java.util.List;

import com.castsoftware.util.CastUtil;

public class Period implements CastJson {
	private boolean shift;
	private List<PeriodDetails> periods;
	
	public Period(boolean shift, List<PeriodDetails> periods) {
		super();
		this.shift = shift;
		this.periods = periods;
	}

	public boolean getShift() {
		return shift;
	}

	public List<PeriodDetails> getPeriods() {
		return periods;
	}

	public int getMaxId() {
		int Id = 0;
		for (CastJson a : periods)
			Id = Math.max(Id, a.getMaxId());
		return Id;
	}

	public String toJsonString(int level) {
		Boolean previousElement = false;
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{\n", CastUtil.jsonIndentation(level)));
		
		if (previousElement) jsonString.append(",\n");
		jsonString.append(String.format("%s\"shift\": %b", CastUtil.jsonIndentation(level+1), shift));
		previousElement = true;
		
		if (periods != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"periods\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s[\n", CastUtil.jsonIndentation(level+1)));
			previousElement = false;
			for (CastJson a : periods)
			{
				if (previousElement) jsonString.append(",\n");
				jsonString.append(String.format("%s", a.toJsonString(level+2)));
				previousElement = true;
			}
			jsonString.append(String.format("%s]", CastUtil.jsonIndentation(level+1)));
			previousElement = true;
		}
	
		if (previousElement) jsonString.append("\n");
		jsonString.append(String.format("%s}", CastUtil.jsonIndentation(level+1)));
		return jsonString.toString();
	}
}
