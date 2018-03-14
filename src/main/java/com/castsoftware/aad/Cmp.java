package com.castsoftware.aad;

import java.util.List;

import com.castsoftware.util.CastUtil;

public class Cmp implements CastJson {
	private String title;
	private String language;
	private boolean horizontalScroll;
	private boolean confirmLogout;
	private Filtering filtering;
	private Period period;
	private Evolutions Evolutions;
	private QualityIndicatorResults QualityIndicatorResults;
	private List<Area> areas;
	
	public Cmp(String title, String language, boolean horizontalScroll, boolean confirmLogout, 
			Filtering filtering, Period period, Evolutions Evolutions, QualityIndicatorResults QualityIndicatorResults,
			List<Area> areas)
	{
		super();
		this.title = title;
		this.language = language;
		this.horizontalScroll = horizontalScroll;
		this.confirmLogout = confirmLogout;
		this.filtering = filtering;
		this.period = period;
		this.Evolutions = Evolutions;
		this.QualityIndicatorResults = QualityIndicatorResults;
		this.areas = areas;
	}
		
	public String getTitle(){
		return title;
	}
	
	public String getLanguage() {
		return language;
	}

	public boolean isHorizontalScroll() {
		return horizontalScroll;
	}

	public boolean isConfirmLogout() {
		return confirmLogout;
	}

	public Filtering getFiltering() {
		return filtering;
	}

	public Period getPeriod() {
		return period;
	}

	public Evolutions getEvolutions() {
		return Evolutions;
	}

	public QualityIndicatorResults getQualityIndicatorResults() {
		return QualityIndicatorResults;
	}

	public List<Area> getAreas() {
		return areas;
	}
	
	public int getMaxId() {
		int Id = filtering == null ? 0 : filtering.getMaxId();
		Id = Math.max(Id, period == null ? 0 : period.getMaxId());
		Id = Math.max(Id, Evolutions == null ? 0 : Evolutions.getMaxId());
		Id = Math.max(Id, QualityIndicatorResults == null ? 0 : QualityIndicatorResults.getMaxId());
		for (CastJson a : areas)
			Id = Math.max(Id, a.getMaxId());
		return Id;
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
		if (language != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"language\": \"%s\"", CastUtil.jsonIndentation(level+1), language));
			previousElement = true;
		}
		
		if (previousElement) jsonString.append(",\n");
		jsonString.append(String.format("%s\"horizontalScroll\": %b,\n", CastUtil.jsonIndentation(level+1), horizontalScroll));
		jsonString.append(String.format("%s\"confirmLogout\": %b", CastUtil.jsonIndentation(level+1), confirmLogout));
		previousElement = true;

		
		if (filtering != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"filtering\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s", filtering.toJsonString(level+2)));
			previousElement = true;
		}
		if (period != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"period\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s", period.toJsonString(level+2)));
			previousElement = true;
		}
		if (Evolutions != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"Evolutions\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s", Evolutions.toJsonString(level+2)));
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
	
	public Area addArea(Integer id, String title)
	{
		Area area = new Area(id, title, null);
		areas.add(area);
		return area;
	}
}
