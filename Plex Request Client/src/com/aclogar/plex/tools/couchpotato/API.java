package com.aclogar.plex.tools.couchpotato;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class API {

	private static String APIKey = "2a25a79e565246b68f2ca6c35351fe10";

	public API() {

	}

	private static JSONObject callCouchPotato(String command, String APIKey, List<Properties> properties) {
		String url = "http://localhost:5050/api/" + APIKey + "/" + command + "?";
		for (Properties p : properties) {
			url += url.endsWith("?") ? p.toString().substring(1) : p;
		}
		System.out.println("Calling sick rage: " + url);
		JSONObject jsonObject = null;
		try {
			InputStream is = new URL(url).openStream();
			JSONParser jsonParser = new JSONParser();

			jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(is, "UTF-8"));
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
		List<Movie> returnMovies = new ArrayList<Movie>();
		JSONArray movies = (JSONArray) jsonObject.get("movies");
		for (int i = 0; i < movies.size(); i++) {

			JSONObject movie = (JSONObject) movies.get(i);
			System.out.println(movie.get("tmdb_id"));
			returnMovies.add(new Movie(getText(movie, "tmdb_id"), getText(movie, "original_title"),
					getText(movie, "mpaa"), getText(movie, "year"), getText(movie, "imdb")));
		}

		return returnMovies;
	}

	public static String addMovie(String id) {
		List<Properties> props = new ArrayList<Properties>();
		props.add(new Properties(id, "identifier"));

		return callCouchPotato("movie.add", APIKey, props).toJSONString();
	}

	private static String getText(JSONObject obj, String key) {
		Object value = obj.get(key);

		return value == null ? "" : value.toString();
	}

}
