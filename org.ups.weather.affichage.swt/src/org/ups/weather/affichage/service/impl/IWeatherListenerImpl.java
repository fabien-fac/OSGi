package org.ups.weather.affichage.service.impl;

import org.ups.weather.affichage.swt.LocationDisplay;
import org.ups.weather.affichage.swt.WeatherWindow;
import org.ups.weather.service.ILocation;
import org.ups.weather.service.IWeatherListener;
import org.ups.weather.service.LocationImpl;
import org.ups.weather.service.WeatherType;

public class IWeatherListenerImpl implements IWeatherListener{
	private ILocation location;
	private int locationDisplayId = -1;

	public IWeatherListenerImpl(ILocation location) {
		this.location = location;
	}
	
	@Override
	public void weatherChanged(WeatherType wheather) {
		WeatherWindow ww = WeatherWindow.getInstance();
		String locationData = "";
		while(!ww.isWindowReady()){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(this.locationDisplayId == -1){
			this.locationDisplayId = ww.getLocationDisplayId();
		}
		
		LocationDisplay ld;
		do{
			ld = ww.getLocationDisplayFromId(locationDisplayId);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(ld == null);
		
		if(location instanceof LocationImpl && ((LocationImpl) location).getCity() != null){
			locationData = ((LocationImpl) location).getCity();
		}
		else{
			locationData = ("lon: "+location.getLongitude()+", lat : "+location.getLatitude());
		}
		
		ld.setData(locationData,wheather);
		
	}
}
