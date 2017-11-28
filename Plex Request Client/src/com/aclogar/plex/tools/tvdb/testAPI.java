package com.aclogar.plex.tools.tvdb;

import java.util.Iterator;
import java.util.List;

import com.aclogar.plex.tools.couchpotato.Movie;

public class testAPI {

	public testAPI() {

	}

	public static void main(String[] args) {
//		List<Series> series = Lookup.getSeries("doctor who");
//		for (Series s : series) {
//			System.out.println(s);
//		}
		System.out.println(com.aclogar.plex.tools.couchpotato.API.addMovie("tt1396484"));
		
		
//		List<Movie> movies = com.aclogar.plex.tools.couchpotato.API.searchMovies("anchorman");
//		for (Movie movie : movies) {
//			System.out.println(movie);
//		}
	}
	
}
