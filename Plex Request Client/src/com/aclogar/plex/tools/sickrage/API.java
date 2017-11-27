package com.aclogar.plex.tools.sickrage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class API {

	private String APIKey = "82bd9908894e119ac77dbe4b3800a38a";

	public API () {
		
	}
	private String callSickRage(String command, String APIKey, List<Properties> properties) {
		String url = "http://localhost:8090/api/" + APIKey + "?cmd="+command;
		for (Properties p : properties) {
			url += p;
		}
		System.out.println("Calling sick rage: " + url);
		JSONObject jsonObject = null;
		try {
			InputStream is = new URL(url).openStream();
			JSONParser jsonParser = new JSONParser();
			
			jsonObject = (JSONObject)jsonParser.parse(
			      new InputStreamReader(is, "UTF-8"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(jsonObject.toJSONString());
		return jsonObject.toJSONString();
	}
	
	public String addNewShow(String tvdbid, String status, boolean anime) {
		List<Properties> props = new ArrayList<Properties>();
		props.add(new Properties(tvdbid, "tvdbid"));
		props.add(new Properties(status, "status"));
		
		if(anime == true) {
			props.add(new Properties("\\\\wdmycloudmirror\\TV", "location"));
		} else {
			props.add(new Properties("\\\\wdmycloudmirror\\English_TV", "location"));
		}
		return callSickRage("show.addnew", APIKey, props);
	}

}
