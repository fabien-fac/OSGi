package org.ups.weather.affichage.service.impl;

import org.ups.weather.service.ILocation;
import org.ups.weather.service.IWeatherListener;
import org.ups.weather.service.LocationImpl;
import org.ups.weather.service.WeatherType;

public class IWeatherListenerImpl implements IWeatherListener{
	
	private ILocation location;

	public IWeatherListenerImpl(ILocation location) {
		this.location = location;
	}

	@Override
	public void weatherChanged(WeatherType wheather) {
		StringBuilder sb = new StringBuilder();
		sb.append("[console] : ");
		if(location instanceof LocationImpl && ((LocationImpl) location).getCity() != null){
			sb.append(((LocationImpl) location).getCity() + " : ");
		}
		else{
			sb.append("latitude : " + location.getLatitude() + ", longitude : " + location.getLongitude());
		}
		sb.append(" ");
		sb.append(wheather);

		System.out.println(sb.toString());
	}

}
