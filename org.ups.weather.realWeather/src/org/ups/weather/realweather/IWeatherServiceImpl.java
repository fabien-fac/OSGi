package org.ups.weather.realweather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ups.weather.service.ILocation;
import org.ups.weather.service.IWeatherListener;
import org.ups.weather.service.IWeatherService;
import org.ups.weather.service.LocationImpl;

public class IWeatherServiceImpl implements IWeatherService{
	
	public static Map<IWeatherListener,List<ILocation>> map = new HashMap<IWeatherListener, List<ILocation>>();

	@Override
	public void addWeatherListener(IWeatherListener weatherListener,
			ILocation location) {
		List<ILocation> locations = new ArrayList<ILocation>();
		if(map.containsKey(weatherListener)){
			locations = map.remove(weatherListener);
		}
		locations.add(location);
		map.put(weatherListener, locations);
	}

	@Override
	public List<ILocation> getListAvailableLocation() {
		List<ILocation> list = new ArrayList<ILocation>();
		LocationImpl paris = new LocationImpl(48.853409f, 2.3488f);
		paris.setCity("Paris");
		list.add(paris);
		LocationImpl toulouse = new LocationImpl(43.6042600f, 1.4436700f);
		toulouse.setCity("Toulouse");
		list.add(toulouse);
		LocationImpl split = new LocationImpl(43.508911f, 16.43915f);
		split.setCity("Split");
		list.add(split);
		return list;
	}

}
