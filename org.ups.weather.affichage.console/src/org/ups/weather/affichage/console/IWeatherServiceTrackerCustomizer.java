package org.ups.weather.affichage.console;

import java.util.Iterator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.ups.weather.affichage.service.impl.IWeatherListenerImpl;
import org.ups.weather.service.ILocation;
import org.ups.weather.service.IWeatherListener;
import org.ups.weather.service.IWeatherService;

public class IWeatherServiceTrackerCustomizer implements ServiceTrackerCustomizer<IWeatherService, IWeatherService> {
    private BundleContext bundleContext;

public IWeatherServiceTrackerCustomizer(BundleContext _bundleContext) {
    bundleContext = _bundleContext;
}

@Override
public IWeatherService addingService(ServiceReference<IWeatherService> reference) {
	IWeatherService myService = (IWeatherService) bundleContext.getService(reference);
	Iterator<ILocation> itLocation = myService.getListAvailableLocation().iterator();
	while(itLocation.hasNext()){
		ILocation location = itLocation.next();
		myService.addWeatherListener(new IWeatherListenerImpl(location), location);
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