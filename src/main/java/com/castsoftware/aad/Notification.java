package com.castsoftware.aad;

import com.castsoftware.util.CastUtil;

public class Notification implements CastJson {
	private String type;
	private Double threshold;
	private String trend;
	private ParameterDetails qualityIndicator;	
	
	public Notification(String type, Double threshold, String trend,
			ParameterDetails qualityIndicator, ParameterDetails sizingMeasure) {
		super();
		this.type = type;
		this.threshold = threshold;
		this.trend = trend;
		this.qualityIndicator = qualityIndicator;
		this.sizingMeasure = sizingMeasure;
	}

	public String getType() {
		return type;
	}

	public Double getThreshold() {
		return threshold;
	}

	public String getTrend() {
		return trend;
	}

	public ParameterDetails getQualityIndicator() {
		return qualityIndicator;
	}

	public ParameterDetails getSizingMeasure() {
		return sizingMeasure;
	}

	private ParameterDetails sizingMeasure;
	
	public int getMaxId() {
		int Id = qualityIndicator == null ? 0 : qualityIndicator.getMaxId();
		Id = Math.max(Id, sizingMeasure == null ? 0 : sizingMeasure.getMaxId());
		return Id;
	}

	public String toJsonString(int level) {
		Boolean previousElement = false;
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{\n", CastUtil.jsonIndentation(level)));
		if (type != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"type\": \"%s\"", CastUtil.jsonIndentation(level+1), type));
			previousElement = true;
		}
		if (threshold != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"threshold\": %.2f", CastUtil.jsonIndentation(level+1), threshold));
			previousElement = true;
		}
		if (trend != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"trend\": \"%s\"", CastUtil.jsonIndentation(level+1), trend));
			previousElement = true;
		}
		
		if (qualityIndicator != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"qualityIndicator\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s", qualityIndicator.toJsonString(level+2)));
			previousElement = true;
		}
		if (sizingMeasure != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"sizingMeasure\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s", sizingMeasure.toJsonString(level+2)));
			previousElement = true;
		}
	
		if (previousElement) jsonString.append("\n");
		jsonString.append(String.format("%s}", CastUtil.jsonIndentation(level+1)));
		return jsonString.toString();
	}

}
