package com.castsoftware.aad;

import java.util.List;

import com.castsoftware.util.CastUtil;

public class App implements CastJson {
	private String title;
	private QualityIndicatorResults QualityIndicatorResults;
	private List<Area> areas;
	
	public App(String title, QualityIndicatorResults QualityIndicatorResults, List<Area> areas)
	{
		super();
		this.title = title;
		this.QualityIndicatorResults = QualityIndicatorResults;
		this.areas = areas;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public QualityIndicatorResults getQualityIndicatorResults()
	{
		return QualityIndicatorResults;
	}
	
	public List<Area> getAreas()
	{
		return areas;
	}
	
	public int getMaxId() {
		int Id = QualityIndicatorResults == null ? 0 : QualityIndicatorResults.getMaxId();
		for (CastJson a : areas)
			Id = Math.max(Id, a.getMaxId());
		return Id;
	}
	
	public Area addArea(Integer id, String title)
	{
		Area area = new Area(id, title, null);
		areas.add(area);
		return area;
	}
	
	public String toJsonString()
	{
		return toJsonString(0);
	}
	
	public String toJsonString(int level)
	{
		Boolean previousElement = false;
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{\n", CastUtil.jsonIndentation(level)));
		if (title != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"title\": \"%s\"", CastUtil.jsonIndentation(level+1), title));
			previousElement = true;
		}
		if (QualityIndicatorResults != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"QualityIndicatorResults\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s", QualityIndicatorResults.toJsonString(level+2)));
			previousElement = true;
		}
		if (areas != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"areas\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s[\n", CastUtil.jsonIndentation(level+1)));
			previousElement = false;
			for (CastJson a : areas)
			{
				if (previousElement) jsonString.append(",\n");
				jsonString.append(String.format("%s", a.toJsonString(level+2)));
				previousElement = true;
			}
			jsonString.append(String.format("%s]", CastUtil.jsonIndentation(level+1)));
			previousElement = true;
		}
		
		if (previousElement) jsonString.append("\n");
		jsonString.append(String.format("%s}", CastUtil.jsonIndentation(level)));
		return jsonString.toString();
	}

}
