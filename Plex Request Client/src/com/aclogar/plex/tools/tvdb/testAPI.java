package com.aclogar.plex.tools.tvdb;

import java.util.List;

public class testAPI {

	public testAPI() {

	}

	public static void main(String[] args) {
//		List<Series> series = Lookup.getSeries("doctor who");
//		for (Series s : series) {
//			System.out.println(s);
//		}
		
		com.aclogar.plex.tools.couchpotato.API.searchMovies("anchorman");
	}
	
}
