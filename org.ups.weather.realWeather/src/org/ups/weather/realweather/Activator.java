package org.ups.weather.realweather;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.ups.weather.service.IWeatherService;

public class Activator implements BundleActivator {

	private ThreadWeatherChange thread;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Bundle IWeatherService real start");
		
		IWeatherServiceImpl impl = new IWeatherServiceImpl();
		
		context.registerService(IWeatherService.class.getName(), impl, null);
		
		thread = new ThreadWeatherChange();
		thread.start();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Bundle IWeatherService random stop");
		thread.stopThread();
	}

}
