package org.ups.weather.service;

import java.util.List;

public interface IWeatherService {

	public void addWeatherListener(IWeatherListener weatherListener, ILocation location);
	
	public List<ILocation> getListAvailableLocation();
}
