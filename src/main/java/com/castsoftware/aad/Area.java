package com.castsoftware.aad;

import java.util.LinkedList;
import java.util.List;

import com.castsoftware.util.CastUtil;

public class Area implements CastJson {
	private Integer id;
	private String title;
	private List<Panel> panels;
	
	public Area(Integer id, String title, List<Panel> panels)
	{
		super();
		this.id = id;
		this.title = title;
		this.panels = panels;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public List<Panel> getPanels()
	{
		return panels;
	}
	
	public int getMaxId() {
		int Id = id;
		for (CastJson a : panels)
			Id = Math.max(Id, a.getMaxId());
		return Id;
	}
	
	public Panel addPanel(Integer id, String plugin, String color)
	{
		Panel panel = new Panel(id, plugin, color, null, null);
		if (panels == null)
			panels = new LinkedList<Panel>();		
		panels.add(panel);
		return panel;
	}

	public String toJsonString(int level) {
		Boolean previousElement = false;
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{\n", CastUtil.jsonIndentation(level)));
		if (id != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"id\": %d", CastUtil.jsonIndentation(level+1), id));
			previousElement = true;
		}
		if (title != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"title\": \"%s\"", CastUtil.jsonIndentation(level+1), title));
			previousElement = true;
		}

		if (panels != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"panels\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s[\n", CastUtil.jsonIndentation(level+1)));
			previousElement = false;
			for (CastJson a : panels)
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
