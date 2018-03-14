package com.castsoftware.delivery;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.castsoftware.delivery.pojo.Properties;
import com.castsoftware.util.XmlUtil;

public class DeliveryManager {
	private static final Logger logger = Logger.getLogger(DeliveryManager.class);
	private List<DeliveredApplication> apps = new ArrayList<DeliveredApplication>();
	
	private String deliveryPath;
	
	public DeliveryManager(String deliveryPath)
	{
		this.deliveryPath = deliveryPath;
	}
	
	public List<DeliveredApplication> getApplications()
	{
		return apps;
	}
	
	public String getApplicationUUID(String applicationName)
	{
		for (DeliveredApplication da : apps)
		{
			if (da.getName().equals(applicationName))
				return da.getUUID();
		}
		return null;
	}
	
	public ArrayList<String> getVersions(String applicationName)
	{
		ArrayList<String> list = new ArrayList<String>();
		for (DeliveredApplication da : apps)
		{
			if (da.getName().equals(applicationName))
			{
				return da.listVersions();
			}
		}
		logger.debug(String.format("Application %s has %d version(s) in Delivery Folder", applicationName, list.size())); 
		return list;
	}	
	
	public ArrayList<String> getApplicationNames()
	{
		ArrayList<String> list = new ArrayList<String>();
		for (DeliveredApplication da : apps)
		{
			list.add(da.getName());
		}
		logger.debug(String.format("%d Application(s) in Delivery Folder", list.size())); 
		return list;
	}
	
	public void reload()
	{
		//remove previously loaded apps
		apps.clear();
		
		boolean loadedProperly = true;
		
		File f = new File(deliveryPath + "/data/index.xml");
        if (!f.exists())
        {
        	logger.error(String.format("Delivery Folder '%s/data/' does not exists!", deliveryPath));
        	return;
        }
		
		Properties p = new Properties(); 
		try {
			logger.debug("Loading " + deliveryPath + "/data/index.xml");
			p = (Properties)XmlUtil.convertfromXml(deliveryPath + "/data/index.xml", p, Properties.class);			
			logger.debug(String.format("Number of keys: %d", p.countKeys()));
			logger.debug(String.format("Creating Applications..."));
			for(String s : p.getUUIDs())
				apps.add(new DeliveredApplication(s, p.getEntries(s)));
			logger.debug(String.format("Loading Applications..."));
			for(DeliveredApplication app : apps)
			{
				loadedProperly = DeliveredApplication.loadApplicationDetails(deliveryPath, app) && loadedProperly;
				//logger.debug(app.summary());
			}
			if (!loadedProperly)
				logger.info(String.format("Some applications did not load properly! Check the log for more details."));
			else
				logger.debug(String.format("Delivery Folder loaded!"));
		} catch (JAXBException | SAXException | ParserConfigurationException | IOException e) {
			logger.error("Unable to load Delivery Folder!");
			logger.error(e);
		} 
	}
}
