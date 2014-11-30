package org.ups.weather.realweather;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ParserJson {
	
	public String getWeather(String json){
		JsonObject root = new JsonParser().parse(json).getAsJsonObject();
		String result = root.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").toString();
		return result.replaceAll("\"", "");
	}

}
