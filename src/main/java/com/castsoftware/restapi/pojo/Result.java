package com.castsoftware.restapi.pojo;

public class Result {
	private Double value;
	private Double grade;
	private String evolutionSummary;
	private String boundaries;
	
	public Result() {
		super();
	}

	public Result(Double value, Double grade, String evolutionSummary,
			String boundaries) {
		super();
		this.value = value;
		this.grade = grade;
		this.evolutionSummary = evolutionSummary;
		this.boundaries = boundaries;
	}
	
	public Double getValue() {
		return value;
	}
	public Double getGrade() {
		return grade;
	}
	public String getEvolutionSummary() {
		return evolutionSummary;
	}
	public String getBoundaries() {
		return boundaries;
	}
}
