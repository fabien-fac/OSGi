package org.ups.weather.affichage.swt;

public class WidowThread extends Thread{
	
	private WeatherWindow weatherWindow;

	@Override
	public void run() {
		weatherWindow = WeatherWindow.getInstance();
		weatherWindow.open();
	}
}
