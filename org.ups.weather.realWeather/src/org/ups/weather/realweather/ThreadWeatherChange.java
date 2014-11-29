package org.ups.weather.realweather;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import org.ups.weather.service.ILocation;
import org.ups.weather.service.IWeatherListener;
import org.ups.weather.service.WeatherType;

public class ThreadWeatherChange extends Thread {

	private int timeSleepMS = 3000;

	public void run() {
		
		while(true){
			try {
				
				System.out.println("Mise à jour météo");

				for (Entry<IWeatherListener, List<ILocation>> entry : IWeatherServiceImpl.map
						.entrySet()) {
					Iterator<ILocation> itILocation = entry.getValue().iterator();
					while(itILocation.hasNext()){
						WeatherType newWeatherType = getWeather(itILocation.next());
						entry.getKey().weatherChanged(newWeatherType);
					}
				}

				Thread.sleep(timeSleepMS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	private WeatherType getWeather(ILocation location) {
		WeatherType weatherType;
		Webservices ws = new Webservices();
		String jsonRes = ws.get_weather(location);
		
		System.out.println(jsonRes);
		ParserJson parser = new ParserJson();
		String weather = parser.getWeather(jsonRes).toLowerCase();
		
		switch (weather) {
		case "clear":
			weatherType = WeatherType.SHINY;
			break;
		case "clouds":
			weatherType = WeatherType.CLOUDY;
			break;
		case "rain":
			weatherType = WeatherType.RAINY;
			break;
		case "snow":
			weatherType = WeatherType.SNOW;
			break;
		case "extreme":
			weatherType = WeatherType.SHOWERS;
			break;
		default:
			weatherType = WeatherType.UNKNOWN;
			break;
		}
		
		return weatherType;
	}

}
