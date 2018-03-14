package com.castsoftware.aad;

import com.castsoftware.util.CastUtil;

public class Filtering implements CastJson {
	private boolean filterTags;

	public Filtering(boolean filterTags) {
		super();
		this.filterTags = filterTags;
	}

	public boolean getFilterTags() {
		return filterTags;
	}

	public int getMaxId() {
		return 0;
	}

	public String toJsonString(int level) {
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{ ", CastUtil.jsonIndentation(level)));
		
		jsonString.append(String.format("\"filterTags\": %b", filterTags));
	
		jsonString.append(String.format(" }\n"));
		return jsonString.toString();
	}
}
