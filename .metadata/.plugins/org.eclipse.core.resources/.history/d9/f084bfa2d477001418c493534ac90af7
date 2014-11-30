package org.ups.weather.realweather;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ParserJson {
	
	public String getWeather(String json){
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject jobject = jelement.getAsJsonObject();
		
		jobject = jobject.getAsJsonObject("weather");
		System.out.println("json : " + jobject.getAsString());
		
		return "";
	}

}
