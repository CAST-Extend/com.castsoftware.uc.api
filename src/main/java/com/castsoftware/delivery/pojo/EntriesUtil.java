package com.castsoftware.delivery.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EntriesUtil {
	private EntriesUtil() {} // Avoid instantiation of the class
	
	
	public static String getEntryValue(String key, List<Entry> entries)
	{
		for(Entry e : entries)
			if (e.getKey().equals(key))
				return e.getValue();
		return null;
	}
	
	public static Integer getEntryValueAsInteger(String key, List<Entry> entries)
	{	
		try
		{
			for(Entry e : entries)
				if (e.getKey().equals(key))
					return Integer.parseInt(e.getValue());
			return null;
		}
		catch (NumberFormatException e)
		{
			return null;		
		}
	}

	public static Date getEntryValueAsLongDate(String key, List<Entry> entries)
	{
		try
		{
			for(Entry e : entries)
				if (e.getKey().equals(key))
					return new Date(Long.parseLong(e.getValue()));
			return null;
		}
		catch (NumberFormatException e)
		{
			return null;		
		}
	}
	
	public static Date getEntryValueAsDate(String key, List<Entry> entries)
	{
		try 
		{
			for(Entry e : entries)
				if (e.getKey().equals(key))
					return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(e.getValue());
			return null;
		} catch (ParseException e) {
			return null;
		}
	}
}
