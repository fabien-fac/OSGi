package org.ups.weather.realweather;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.ups.weather.service.ILocation;

public class Webservices {

	private InputStream sendRequest(URL url) throws IOException {
		
		// Ouverture de la connexion
		HttpURLConnection urlConnection = (HttpURLConnection) url
				.openConnection();
		
		// Connexion à l'url
		urlConnection.connect();
		
		// Si le serveur nous répond avec un code OK
		if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			return urlConnection.getInputStream();
		}
		
		return null;
	}

	public String get_weather(ILocation location) {
		
		String url = "http://api.openweathermap.org/data/2.5/weather?lat="
				+ location.getLatitude() + "&lon=" + location.getLongitude();
		
		try {
			// Envoie de la requête
			InputStream inputStream = sendRequest(new URL(url));
			// Vérification de l'inputStream
			if (inputStream != null) {
				java.util.Scanner s = new java.util.Scanner(inputStream)
						.useDelimiter("\\A");
				return s.hasNext() ? s.next() : "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}