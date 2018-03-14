package com.castsoftware.aad;

import java.util.List;

import com.castsoftware.util.CastUtil;

public class TreemapColors implements CastJson {
	private List<Integer> ranges;
	private List<String> colors;
	
	public TreemapColors(List<Integer> ranges, List<String> colors) {
		super();
		this.ranges = ranges;
		this.colors = colors;
	}

	public List<Integer> getRanges() {
		return ranges;
	}

	public List<String> getColors() {
		return colors;
	}

	public int getMaxId() {
		return 0;
	}

	public String toJsonString(int level) {
		Boolean previousElement = false;
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{\n", CastUtil.jsonIndentation(level)));

		//single line
		if (ranges != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"ranges\": [", CastUtil.jsonIndentation(level+1)));
			previousElement = false;
			for (Integer a : ranges)
			{
				if (previousElement) jsonString.append(",");
				jsonString.append(String.format("%d", a));
				previousElement = true;
			}
			jsonString.append(String.format("]"));
			previousElement = true;
		}
		//single line
		if (colors != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"colors\": [", CastUtil.jsonIndentation(level+1)));
			previousElement = false;
			for (String s : colors)
			{
				if (previousElement) jsonString.append(",");
				jsonString.append(String.format("\"%s\"", s));
				previousElement = true;
			}
			jsonString.append(String.format("]"));
			previousElement = true;
		}
		
		if (previousElement) jsonString.append("\n");
		jsonString.append(String.format("%s}", CastUtil.jsonIndentation(level)));
		return jsonString.toString();
	}
}
