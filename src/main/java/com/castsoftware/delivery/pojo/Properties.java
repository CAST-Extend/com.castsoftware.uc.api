package com.castsoftware.delivery.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "properties")
public class Properties {
	@XmlElement(name = "entry")
	private List<Entry> list = new ArrayList<Entry>();
	
	@XmlElement
	protected String Comment;
	
	public int countKeys()
	{
		return list.size();
	}
	
	public List<String> getUUIDs()
	{
		List<String> uuids = new ArrayList<String>();
		for(Entry e : list)
		{
			if (e.getKey().contains("_uuid"))
				uuids.add(e.getValue());
		}
		return uuids;
	}
	
	public List<Entry> getEntries(String uuid)
	{
		List<Entry> entries = new ArrayList<Entry>();
		for(Entry e : list)
		{
			if (e.getKey().contains(uuid))
				entries.add(e);
		}
		return entries;
	}
}
