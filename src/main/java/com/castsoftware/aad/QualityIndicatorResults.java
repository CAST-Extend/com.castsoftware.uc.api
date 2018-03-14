package com.castsoftware.aad;

import java.util.List;

import com.castsoftware.util.CastUtil;

public class QualityIndicatorResults implements CastJson {
	private String groupBy;
	private List<Double> ranges;
	private Color colors;
	
	public QualityIndicatorResults(String groupBy, List<Double> ranges,
			Color colors) {
		super();
		this.groupBy = groupBy;
		this.ranges = ranges;
		this.colors = colors;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public List<Double> getRanges() {
		return ranges;
	}

	public Color getColors() {
		return colors;
	}

	public int getMaxId() {
		return colors == null ? 0 : colors.getMaxId();
	}

	public String toJsonString(int level) {
		Boolean previousElement = false;
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{\n", CastUtil.jsonIndentation(level)));
		if (groupBy != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"groupBy\": \"%s\"", CastUtil.jsonIndentation(level+1), groupBy));
			previousElement = true;
		}

		//single line
		if (ranges != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"ranges\": [", CastUtil.jsonIndentation(level+1)));
			previousElement = false;
			for (Double d : ranges)
			{
				if (previousElement) jsonString.append(",");
				jsonString.append(String.format("%.2f", d));
				previousElement = true;
			}
			jsonString.append(String.format("]"));
			previousElement = true;
		}
				
		if (colors != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"colors\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s", colors.toJsonString(level+2)));
			previousElement = true;
		}
		
		if (previousElement) jsonString.append("\n");
		jsonString.append(String.format("%s}", CastUtil.jsonIndentation(level)));
		return jsonString.toString();
	}
}
