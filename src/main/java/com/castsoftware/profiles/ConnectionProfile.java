package com.castsoftware.profiles;

public class ConnectionProfile implements Comparable<ConnectionProfile> {
	private String name;

	public ConnectionProfile()
	{
		
	}
	
	public ConnectionProfile(String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}

	public int compareTo(ConnectionProfile arg0) {
		return name.compareTo(arg0.getName());
	}

}
