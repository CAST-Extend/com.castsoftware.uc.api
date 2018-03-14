package com.castsoftware.profiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class ConnectionProfilesHelper 
{
	private static final Logger logger = Logger.getLogger(ConnectionProfilesHelper.class);

	public static String listConnectionProfiles(String castMsClient) throws IOException, InterruptedException 
	{
		logger.info(String.format("List Connection Profiles (ConnectionProfilesHelper)"));
		List<ConnectionProfile> cpList = new ArrayList<ConnectionProfile>();

		Process p;
		List<String> params = new ArrayList<String>();
		params.add(castMsClient);
		params.add("showConfig");
		ProcessBuilder pb = new ProcessBuilder(params);
		pb.redirectErrorStream(true);
		p = pb.start();
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ( (line = br.readLine()) != null) 
			{
				if ((line.length() > 29) && (line.substring(1, 29).equals("Connection profiles FilePath")))
				{
					logger.info(line);
				}

				if ((line.length() > 23) && (line.substring(0, 23).equals("Connection profile Name")))
					cpList.add(new ConnectionProfile(line.substring(25, line.length() - 1)));
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}
		} finally
		{
			if (br!= null)
				br.close();
		}

		p.waitFor();

		//Sort List
		Collections.sort(cpList);

		Gson gson = new Gson();		

		return gson.toJson(cpList);
	}
}
