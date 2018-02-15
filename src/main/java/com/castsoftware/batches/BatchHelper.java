package com.castsoftware.batches;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import com.castsoftware.batches.pojo.Batch;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class BatchHelper {
	private BatchHelper() {} // Avoid instantiation of the class
	
	public static String getBatchListAsJson(String fileName) throws IOException
	{
		File file = new File(fileName);
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(file);
			byte[] data = new byte[(int)file.length()];
			fis.read(data);
		    String jsonString = new String(data, "UTF-8");
		    return jsonString;
		} finally
		{
			if (fis!= null)
				fis.close();
		}
	}
	
	public static ArrayList<Batch> getBatchList(String fileName) throws JsonParseException, IOException
	{
		Gson gson = new Gson();	
		
        Type collectionType = new TypeToken<Collection<Batch>>(){}.getType();
        Collection<Batch> tmp = gson.fromJson(getBatchListAsJson(fileName), collectionType);
        
        ArrayList<Batch> list = new ArrayList<Batch>(tmp);
        
        Collections.sort(list);
        return list;
	}
	
	public static String getBatchFullPath(String fileName, String batchName) throws JsonParseException, IOException
	{
		ArrayList<Batch> list = getBatchList(fileName);
		//
	    for(Batch b : list)
	    {
	    	if (b.getName().equals(batchName))
	    		return b.getFullPath();
	    }
	    return "";
	}
}
