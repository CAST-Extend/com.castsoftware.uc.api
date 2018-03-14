package com.castsoftware.delivery;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.castsoftware.delivery.pojo.EntriesUtil;
import com.castsoftware.delivery.pojo.Entry;

public class DeliveredSources implements Comparable<DeliveredSources> {
	private String name;
	private String uuid;
	private String type;
	private Date date;
	private String serverStatus;
	private Integer syncId;
	
	private String DmtDelivery_checksum;
	private Date DmtDelivery_lastModified;
	private Integer DmtDelivery_length;
	private Integer DmtDelivery_syncId;
	
	private String xml_checksum;
	private Date xml_lastModified;
	private Integer xml_length;
	private Integer xml_syncId;
	
	public Boolean isReadyForAnalysis()
	{
		return serverStatus == null ? false : serverStatus.equals("delivery.StatusAwaitingValidation");
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public String getName()
	{
		return name;
	}
	 
	public DeliveredSources(String uuid, List<Entry> entries)
	{
		this.uuid = uuid;
		name = EntriesUtil.getEntryValue(String.format("%s_name", uuid), entries);
		type = EntriesUtil.getEntryValue(String.format("%s_type", uuid), entries);
		date = EntriesUtil.getEntryValueAsDate(String.format("%s_date", uuid), entries);
		serverStatus = EntriesUtil.getEntryValue(String.format("%s_serverStatus", uuid), entries);
		syncId = EntriesUtil.getEntryValueAsInteger(String.format("%s_syncId", uuid), entries);
		
		DmtDelivery_checksum = EntriesUtil.getEntryValue(String.format("%s_config.DmtDelivery_checksum", uuid), entries);
		DmtDelivery_lastModified = EntriesUtil.getEntryValueAsLongDate(String.format("%s_config.DmtDelivery_lastModified", uuid), entries);
		DmtDelivery_length = EntriesUtil.getEntryValueAsInteger(String.format("%s_config.DmtDelivery_length", uuid), entries);
		DmtDelivery_syncId = EntriesUtil.getEntryValueAsInteger(String.format("%s_config.DmtDelivery_syncId", uuid), entries);
		
		xml_checksum = EntriesUtil.getEntryValue(String.format("%1$s_%1$s.entity.xml_checksum", uuid), entries);
		xml_lastModified = EntriesUtil.getEntryValueAsLongDate(String.format("%1$s_%1$s.entity.xml_lastModified", uuid), entries);
		xml_length = EntriesUtil.getEntryValueAsInteger(String.format("%1$s_%1$s.entity.xml_length", uuid), entries);
		xml_syncId = EntriesUtil.getEntryValueAsInteger(String.format("%1$s_%1$s.entity.xml_syncId", uuid), entries);

	}	

	public String summary()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
		return String.format("name: %s\ndate: %s\nserverStatus: %s", 
				name == null ? "" : name, 
				date == null ? "" : dateFormat.format(date), 
				serverStatus == null ? "" : serverStatus);
	}
	
	@Override
	public String toString()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
		return String.format("uuid: %s\nname: %s\ntype: %s\ndate: %s\nmserverStatus: %s\nsyncId: %s\nDmtDelivery_checksum: %s\nDmtDelivery_lastModified: %s\nDmtDelivery_length: %s\nDmtDelivery_syncId: %s\nxml_checksum: %s\nxml_lastModified: %s\nxml_length: %s\nxml_syncId: %s", 
				uuid == null ? "" : uuid, 
				name == null ? "" : name, 
				type == null ? "" : type, 
				date == null ? "" : dateFormat.format(date), 
				serverStatus == null ? "" : serverStatus, 
				syncId == null ? "" : syncId.toString(), 
				
				DmtDelivery_checksum == null ? "" : DmtDelivery_checksum, 
				DmtDelivery_lastModified == null ? "" : dateFormat.format(DmtDelivery_lastModified), 
				DmtDelivery_length == null ? "" : DmtDelivery_length.toString(),
				DmtDelivery_syncId == null ? "" : DmtDelivery_syncId.toString(),
						
				xml_checksum == null ? "" : xml_checksum, 
				xml_lastModified == null ? "" : dateFormat.format(xml_lastModified), 
				xml_length == null ? "" : xml_length.toString(),
				xml_syncId == null ? "" : xml_syncId.toString());
	}

	public int compareTo(DeliveredSources ds) {
		return date.compareTo(ds.date);
	}
}
