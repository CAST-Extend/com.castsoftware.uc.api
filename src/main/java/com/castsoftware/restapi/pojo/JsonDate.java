package com.castsoftware.restapi.pojo;

import java.util.Date;

public class JsonDate {
    private long time;
    
    public JsonDate() {
		super();
	}

	public JsonDate(long time) {
		super();
		this.time = time;
	}

	public long getTime() {
		return time;
	}

	public Date getAsDate() {return new Date(time);}
}
