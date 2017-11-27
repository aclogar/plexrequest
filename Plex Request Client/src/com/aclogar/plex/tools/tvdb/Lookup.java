package com.aclogar.plex.tools.tvdb;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Lookup {

	private static String mirror = "https://www.thetvdb.com";

	public static List<Series> getSeries(String seriesTitle) {
		// or if you prefer DOM:
		List<Series> returnSeries = new ArrayList<Series>();
		try {
			String url = mirror + "/api/GetSeries.php?seriesname=" + URLEncoder.encode(seriesTitle, "UTF-8");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			System.out.println("Calling url of " + url);
			Document doc = db.parse(new URL(url).openStream());

			NodeList series = doc.getDocumentElement().getElementsByTagName("Series");

			for (int i = 0; i < series.getLength(); i++) {
				Node current = series.item(i);
				returnSeries.add(new Series(getTextValue(current, "SeriesName"), getTextValue(current, "FirstAired"),
						getTextValue(current, "seriesid")));
			}

		} catch (SAXException | IOException e) {
			System.err.println("There was an error with the url.");
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return returnSeries;
	}

	private static String getTextValue(Node parent, String nodeName) {
		try {
			if (parent.getNodeType() == Node.ELEMENT_NODE) {
				Element parentElement = (Element) parent;
				Node dataNode = parentElement.getElementsByTagName(nodeName).item(0);
				String data = dataNode.getTextContent();
				return data != null ? data : "";
			} else {
				return parent.getNodeValue();
			}
		} catch (NullPointerException e) {
		}
		return "";
	}

}
