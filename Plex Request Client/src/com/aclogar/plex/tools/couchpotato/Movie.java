package com.aclogar.plex.tools.couchpotato;

public class Movie {


	private String tmdbid;
	private String original_title;
	private String mpaa;
	private String alt_title;
	private String year;
	private String imdb;

	public Movie(String tmdbid, String original_title, String mpaa, String year, String imdb) {
		super();
		this.tmdbid = tmdbid;
		this.original_title = original_title;
		this.mpaa = mpaa;
		this.year = year;
		this.imdb = imdb;
	}	
	
	public String getTmdbid() {
		return tmdbid;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public String getMpaa() {
		return mpaa;
	}

	public String getYear() {
		return year;
	}

	public String getImdb() {
		return imdb;
	}

	public void setAlt_title(String alt_title) {
		this.alt_title = alt_title;
	}

	@Override
	public String toString() {
		return "Movie [tmdbid=" + tmdbid + ", original_title=" + original_title + ", mpaa=" + mpaa + ", year=" + year
				+ ", imdb=" + imdb + "]";
	}

	
	
}
