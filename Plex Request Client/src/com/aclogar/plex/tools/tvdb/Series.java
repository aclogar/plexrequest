package com.aclogar.plex.tools.tvdb;

public class Series {

	

	private String title;
	private String firstAir;
	private String seriesid;

	public Series(String series, String firstAir, String id) {
		super();
		this.title = series;
		this.firstAir = firstAir;
		this.seriesid = id;
	}
	
	public String getSeries() {
		return title;
	}

	public String getFirstAir() {
		return firstAir;
	}

	public String getId() {
		return seriesid;
	}

	@Override
	public String toString() {
		return title + " (" + firstAir + ") -- id=" + seriesid;
	}

}
