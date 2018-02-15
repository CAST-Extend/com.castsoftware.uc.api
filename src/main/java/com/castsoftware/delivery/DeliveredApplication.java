package com.castsoftware.delivery;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.castsoftware.delivery.pojo.EntriesUtil;
import com.castsoftware.delivery.pojo.Entry;
import com.castsoftware.delivery.pojo.Properties;
import com.castsoftware.util.XmlUtil;

public class DeliveredApplication {
	private static final Logger logger = Logger.getLogger(DeliveryManager.class);
	
	private String name;
	private String uuid;
	private String type;
	private String owner;
	private String manager;
	private Integer syncId;
	private Integer mngtId;
	private String xml_checksum;
	private Date xml_lastModified;
	private Integer xml_length;
	
	private List<DeliveredSources> sources = new ArrayList<DeliveredSources>();
	
	public List<DeliveredSources> getDeliveredSourcesReadyForAnalysis()
	{
		List<DeliveredSources> list = new ArrayList<DeliveredSources>();
		for(DeliveredSources ds : sources)
		{
			if (ds.isReadyForAnalysis())
				list.add(ds);
		}
		//Sort by Date
		Collections.sort(list);		
		return list;
	}
	
	public ArrayList<String> listVersions()
	{
		List<DeliveredSources> tmpList = new ArrayList<DeliveredSources>();
		for(DeliveredSources ds : sources)
		{
			if (ds.getName() != null)
				tmpList.add(ds);
		}
		//Sort by Date
		Collections.sort(tmpList);

		ArrayList<String> list = new ArrayList<String>();
		for(DeliveredSources ds : tmpList)
		{			
			list.add(ds.getName());
		}
		return list;
	}
	
	public String getUUID()
	{
		return uuid;
	}
	
	public String getName()
	{
		return name;
	}
	
	public DeliveredApplication(String uuid, List<Entry> entries)
	{
		logger.debug("DeliveredApplication - Getting properties from entries");
		this.uuid = uuid;
		logger.debug(String.format("%s: %s", String.format("%s_name", uuid), EntriesUtil.getEntryValue(String.format("%s_name", uuid), entries)));
		name = EntriesUtil.getEntryValue(String.format("%s_name", uuid), entries);
		logger.debug(String.format("%s: %s", String.format("%s_type", uuid), EntriesUtil.getEntryValue(String.format("%s_type", uuid), entries)));
		type = EntriesUtil.getEntryValue(String.format("%s_type", uuid), entries);
		logger.debug(String.format("%s: %s", String.format("%s_owner", uuid), EntriesUtil.getEntryValue(String.format("%s_owner", uuid), entries)));
		owner = EntriesUtil.getEntryValue(String.format("%s_owner", uuid), entries);
		logger.debug(String.format("%s: %s", String.format("%s_manager", uuid), EntriesUtil.getEntryValue(String.format("%s_manager", uuid), entries)));
		manager = EntriesUtil.getEntryValue(String.format("%s_manager", uuid), entries);
		logger.debug(String.format("%s: %s", String.format("%s_syncId", uuid), EntriesUtil.getEntryValue(String.format("%s_syncId", uuid), entries)));
		syncId = EntriesUtil.getEntryValueAsInteger(String.format("%s_syncId", uuid), entries);
		logger.debug(String.format("%s: %s", String.format("%s_mngtId", uuid), EntriesUtil.getEntryValue(String.format("%s_mngtId", uuid), entries)));
		mngtId = EntriesUtil.getEntryValueAsInteger(String.format("%s_mngtId", uuid), entries);
		logger.debug(String.format("%s: %s", String.format("%1$s_%1$s.entity.xml_checksum", uuid), EntriesUtil.getEntryValue(String.format("%1$s_%1$s.entity.xml_checksum", uuid), entries)));
		xml_checksum = EntriesUtil.getEntryValue(String.format("%1$s_%1$s.entity.xml_checksum", uuid), entries);
		logger.debug(String.format("%s: %s", String.format("%1$s_%1$s.entity.xml_lastModified", uuid), EntriesUtil.getEntryValue(String.format("%1$s_%1$s.entity.xml_lastModified", uuid), entries)));
		xml_lastModified = EntriesUtil.getEntryValueAsLongDate(String.format("%1$s_%1$s.entity.xml_lastModified", uuid), entries);
		logger.debug(String.format("%s: %s", String.format("%1$s_%1$s.entity.xml_length", uuid), EntriesUtil.getEntryValue(String.format("%1$s_%1$s.entity.xml_length", uuid), entries)));
		xml_length = EntriesUtil.getEntryValueAsInteger(String.format("%1$s_%1$s.entity.xml_length", uuid), entries);
	}
	
	public static boolean loadApplicationDetails(String deliveryPath, DeliveredApplication app) 
	{
		try {
			Properties p = new Properties(); 
			logger.debug("Loading " + String.format("%s/data/{%s}/index.xml", deliveryPath, app.uuid));
			p = (Properties)XmlUtil.convertfromXml(String.format("%s/data/{%s}/index.xml", deliveryPath, app.uuid), p, Properties.class);
			logger.debug(String.format("%s - Number of keys: %d", app.name, p.countKeys()));
			logger.debug(String.format("Creating Versions for %s...", app.name));
			for(String s :p.getUUIDs())
				app.sources.add(new DeliveredSources(s, p.getEntries(s)));
			logger.debug(String.format("%s - %d version(s)", app.name, app.sources.size()));
		} catch (JAXBException | SAXException
				| ParserConfigurationException | IOException e) {
			logger.error(e);
			return false;
		}
		return true;
	}
	public String summary()
	{		
		String sourcesAsString = "";
		for(DeliveredSources ds : sources)
			sourcesAsString += ds.summary() + "\n\n";
		return String.format("Application\nuuid: %s\nname: %s\nDeliveries:\n%s\n\n", 
				uuid == null ? "" : uuid, 
				name == null ? "" : name, 
				sourcesAsString);
	}
	
	@Override
	public String toString()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
		String sourcesAsString = "";
		for(DeliveredSources ds : sources)
			sourcesAsString += ds.toString() + "\n";
		return String.format("uuid: %s\nname: %s\ntype: %s\nowner: %s\nmanager: %s\nsyncId: %s\nmngtId: %s\nxml_checksum: %s\nxml_lastModified: %s\nxml_length: %s\nSources:\n%s\n", 
				uuid == null ? "" : uuid, 
				name == null ? "" : name, 
				type == null ? "" : type, 
				owner == null ? "" : owner, 
				manager == null ? "" : manager, 
				syncId == null ? "" : syncId.toString(), 
				mngtId == null ? "" : mngtId.toString(), 
				xml_checksum == null ? "" : xml_checksum, 
				xml_lastModified == null ? "" : dateFormat.format(xml_lastModified), 
				xml_length == null ? "" : xml_length.toString(),
				sourcesAsString);
	}

	
}
