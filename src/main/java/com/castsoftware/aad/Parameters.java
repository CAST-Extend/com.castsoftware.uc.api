package com.castsoftware.aad;

import java.util.List;

import com.castsoftware.util.CastUtil;

public class Parameters implements CastJson {
	private String title;
	private String widget;
	private String mode;
	private String type;
	private Integer count;
	private String format;
	private String order;
	private String scattering;
	private String url;
	private String aggregation;
	private TreemapColors treemapColors;
	private ParameterDetails qualityIndicator;
	private ParameterDetails sizingMeasure;
	private ParameterDetails functionalWeightMeasure;
	private ParameterDetails backgroundFact;
	private List<Notification> notifications;
	
	public Parameters()
	{
		super();
	}
	
	public Parameters(String title, String widget, String mode, String type,
			Integer count, String format, String order, String scattering,
			String url, String aggregation, TreemapColors treemapColors,
			ParameterDetails qualityIndicator, ParameterDetails sizingMeasure,
			ParameterDetails functionalWeightMeasure,
			ParameterDetails backgroundFact, List<Notification> notifications) {
		super();
		this.title = title;
		this.widget = widget;
		this.mode = mode;
		this.type = type;
		this.count = count;
		this.format = format;
		this.order = order;
		this.scattering = scattering;
		this.url = url;
		this.aggregation = aggregation;
		this.treemapColors = treemapColors;
		this.qualityIndicator = qualityIndicator;
		this.sizingMeasure = sizingMeasure;
		this.functionalWeightMeasure = functionalWeightMeasure;
		this.backgroundFact = backgroundFact;
		this.notifications = notifications;
	}

	public String getTitle() {
		return title;
	}

	public String getWidget() {
		return widget;
	}

	public String getMode() {
		return mode;
	}

	public String getType() {
		return type;
	}

	public Integer getCount() {
		return count;
	}

	public String getFormat() {
		return format;
	}

	public String getOrder() {
		return order;
	}

	public String getScattering() {
		return scattering;
	}

	public String getUrl() {
		return url;
	}

	public String getAggregation() {
		return aggregation;
	}

	public TreemapColors getTreemapColors() {
		return treemapColors;
	}

	public ParameterDetails getQualityIndicator() {
		return qualityIndicator;
	}

	public ParameterDetails getSizingMeasure() {
		return sizingMeasure;
	}

	public ParameterDetails getFunctionalWeightMeasure() {
		return functionalWeightMeasure;
	}

	public ParameterDetails getBackgroundFact() {
		return backgroundFact;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWidget(String widget) {
		this.widget = widget;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public void setScattering(String scattering) {
		this.scattering = scattering;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setAggregation(String aggregation) {
		this.aggregation = aggregation;
	}

	public void setTreemapColors(TreemapColors treemapColors) {
		this.treemapColors = treemapColors;
	}

	public void setQualityIndicator(ParameterDetails qualityIndicator) {
		this.qualityIndicator = qualityIndicator;
	}

	public void setSizingMeasure(ParameterDetails sizingMeasure) {
		this.sizingMeasure = sizingMeasure;
	}

	public void setFunctionalWeightMeasure(ParameterDetails functionalWeightMeasure) {
		this.functionalWeightMeasure = functionalWeightMeasure;
	}

	public void setBackgroundFact(ParameterDetails backgroundFact) {
		this.backgroundFact = backgroundFact;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public int getMaxId() {
		int Id = treemapColors == null ? 0 : treemapColors.getMaxId();
		Id = Math.max(Id, qualityIndicator == null ? 0 : qualityIndicator.getMaxId());
		Id = Math.max(Id, sizingMeasure == null ? 0 : sizingMeasure.getMaxId());
		Id = Math.max(Id, functionalWeightMeasure == null ? 0 : functionalWeightMeasure.getMaxId());
		if (notifications != null)
			for (CastJson a : notifications)
				Id = Math.max(Id, a.getMaxId());
		return Id;
	}
	
	public void initializeBackgroundFact(){
		if (backgroundFact == null)
			backgroundFact = new ParameterDetails(null, null, null, null);
	}

	public String toJsonString(int level) {
		Boolean previousElement = false;
		StringBuilder jsonString = new StringBuilder();
		jsonString.append(String.format("%s{\n", CastUtil.jsonIndentation(level)));
		if (title != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"title\": \"%s\"", CastUtil.jsonIndentation(level+1), title));
			previousElement = true;
		}
		if (widget != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"widget\": \"%s\"", CastUtil.jsonIndentation(level+1), widget));
			previousElement = true;
		}
		if (mode != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"mode\": \"%s\"", CastUtil.jsonIndentation(level+1), mode));
			previousElement = true;
		}
		if (type != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"type\": \"%s\"", CastUtil.jsonIndentation(level+1), type));
			previousElement = true;
		}
		if (count != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"count\": %d", CastUtil.jsonIndentation(level+1), count));
			previousElement = true;
		}
		if (format != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"format\": \"%s\"", CastUtil.jsonIndentation(level+1), format));
			previousElement = true;
		}
		if (order != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"order\": \"%s\"", CastUtil.jsonIndentation(level+1), order));
			previousElement = true;
		}
		if (scattering != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"scattering\": \"%s\"", CastUtil.jsonIndentation(level+1), scattering));
			previousElement = true;
		}
		if (url != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"url\": \"%s\"", CastUtil.jsonIndentation(level+1), url));
			previousElement = true;
		}
		if (aggregation != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"aggregation\": \"%s\"", CastUtil.jsonIndentation(level+1), aggregation));
			previousElement = true;
		}
		
		if (treemapColors != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"treemapColors\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s", treemapColors.toJsonString(level+2)));
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
		if (functionalWeightMeasure != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"functionalWeightMeasure\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s", functionalWeightMeasure.toJsonString(level+2)));
			previousElement = true;
		}
		if (backgroundFact != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"backgroundFact\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s", backgroundFact.toJsonString(level+2)));
			previousElement = true;
		}
		
		if (notifications != null) 
		{
			if (previousElement) jsonString.append(",\n");
			jsonString.append(String.format("%s\"notifications\":\n", CastUtil.jsonIndentation(level+1)));
			jsonString.append(String.format("%s[\n", CastUtil.jsonIndentation(level+1)));
			previousElement = false;
			for (CastJson a : notifications)
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
