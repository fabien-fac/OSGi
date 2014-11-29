package org.ups.weather.affichage.console;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.ups.weather.service.IWeatherService;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Lancement bundle console");
		
		ServiceTrackerCustomizer<IWeatherService, IWeatherService> serviceLocation = new IWeatherServiceTrackerCustomizer(
				context);
		ServiceTracker<IWeatherService, IWeatherService> locationTracker = new ServiceTracker<IWeatherService, IWeatherService>(
				context, IWeatherService.class.getName(), serviceLocation);

		locationTracker.open();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}

}
