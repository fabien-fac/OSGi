package org.ups.weather.randomweather;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import org.ups.weather.service.ILocation;
import org.ups.weather.service.IWeatherListener;
import org.ups.weather.service.WeatherType;

public class ThreadWeatherChange extends Thread {

	private int timeSleepMS = 2000;

	public void run() {
		
		while(true){
			try {
				
				System.out.println("Mise à jour météo random");

				for (Entry<IWeatherListener, List<ILocation>> entry : IWeatherServiceImpl.map
						.entrySet()) {
					entry.getKey().weatherChanged(getRandomWeather());
				}

				Thread.sleep(timeSleepMS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	private WeatherType getRandomWeather(){
		List<WeatherType> values = Collections.unmodifiableList(Arrays.asList(WeatherType.values()));
		Random rand = new Random();
		
		return values.get(rand.nextInt(values.size()));
	}

}
