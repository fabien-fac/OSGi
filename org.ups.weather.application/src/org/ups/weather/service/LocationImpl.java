package org.ups.weather.service;


public class LocationImpl implements ILocation{
	
	private Float latitude;
	private Float longitude;
	
	public LocationImpl(Float latitude, Float longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public Float getLatitude() {
		return latitude;
	}

	@Override
	public Float getLongitude() {
		return longitude;
	}
	
	

}
