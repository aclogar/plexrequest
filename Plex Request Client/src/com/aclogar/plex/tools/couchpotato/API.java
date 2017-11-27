package com.aclogar.plex.tools.couchpotato;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class API {

	private static String APIKey = "2a25a79e565246b68f2ca6c35351fe10";

	public API () {
		
	}
	private static JSONObject callCouchPotato(String command, String APIKey, List<Properties> properties) {
		String url = "http://localhost:5050/api/" + APIKey + "?"+command;
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
		return jsonObject;
	}
	
	public static List<Movie> searchMovies(String query) {
		List<Properties> props = new ArrayList<Properties>();
		props.add(new Properties(query, "q"));
		JSONObject jsonObject = callCouchPotato("search", APIKey, props);
	
		Map movies = (Map) jsonObject.get("movies");
		
		
		
		return null;
	}
	
	public String addMovie(String querey) {
		List<Properties> props = new ArrayList<Properties>();
		props.add(new Properties(querey, "tmdb_id"));
		
	
		return callCouchPotato("search", APIKey, props).toJSONString();
	}

}
