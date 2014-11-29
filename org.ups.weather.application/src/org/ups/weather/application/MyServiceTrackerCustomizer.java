package org.ups.weather.application;

import java.util.Iterator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.ups.weather.service.ILocation;
import org.ups.weather.service.IWeatherListener;
import org.ups.weather.service.IWeatherService;

public class MyServiceTrackerCustomizer implements ServiceTrackerCustomizer<IWeatherService, IWeatherService> {
    private BundleContext bundleContext;

public MyServiceTrackerCustomizer(BundleContext _bundleContext) {
    bundleContext = _bundleContext;
}

@Override
public IWeatherService addingService(ServiceReference<IWeatherService> reference) {
	IWeatherService myService = (IWeatherService) bundleContext.getService(reference);
	Iterator<IWeatherListener> it = ConsoleTrackerCustomizer.listListener.iterator();
	while(it.hasNext()){
		Iterator<ILocation> itLocation = myService.getListAvailableLocation().iterator();
		while(itLocation.hasNext()){
			myService.addWeatherListener(it.next(), itLocation.next());
		}
	}
	
    return myService;
}

@Override
public void modifiedService(ServiceReference<IWeatherService> reference, IWeatherService service) {
	// TODO Auto-generated method stub
	
}

@Override
public void removedService(ServiceReference<IWeatherService> reference, IWeatherService service) {
		// TODO Auto-generated method stub

	}
}