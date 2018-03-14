package com.castsoftware.aedmodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AEDSnapshot {
	private String name;
	private int number;
	private String href;
	

}
