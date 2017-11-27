package com.aclogar.plex.tools.sickrage;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Properties {

	public Properties(String value, String id) {
		super();
		this.value = value;
		this.id = id;
	}

	private String value;
	private String id;

	public String getValue() {
		return value;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		try {
			return "&" + id + "=" + URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "&" + id + "=" + value;
		}
	}

}
