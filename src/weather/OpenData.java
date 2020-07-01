package weather;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;


/**City description and weather information using OpenData with Jackson JSON processor.
 * @since 29-2-2020
 * @version 1.0
 * @author John Violos
 *
 *
 * Edited by Stathis Valavanis it21808
 * */
public class OpenData{

	/**Retrieves weather information for a given city.
	 * @param city The Wikipedia article and OpenWeatherMap city.
	 * @param country The country initials (i.e. gr, it, de).
	 * @param appid Your API key of the OpenWeatherMap.*/


	private static String appid = "607e63a2b55db98312d5a2aa99e1b974";


	public static void RetrieveData(ArrayList<String> Cities, ArrayList<String> CitiesID, ArrayList<Integer>[] WeatherData, String appid) throws IOException, InterruptedException {
		ObjectMapper mapper = new ObjectMapper();
		weatherDataMethod(mapper,Cities,CitiesID,appid,WeatherData);
	}

	//For each city OpenWeatherMap gives me it's pressure and humidity
	public static void weatherDataMethod(ObjectMapper mapper, ArrayList<String> Cities, ArrayList<String> CitiesID, String appid,ArrayList<Integer>[]  WeatherData) throws IOException
	{
		for(int i = 0; i < Cities.size(); i++ ) {
			OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q=" + Cities.get(i) + "," + CitiesID.get(i) + "&APPID=" + appid + ""), OpenWeatherMap.class);

			WeatherData[0].add(weather_obj.getMain().getPressure());
			WeatherData[1].add(weather_obj.getMain().getHumidity());
		}
	}

	public OpenData(ArrayList<String> Cities, ArrayList<String> CitiesID, ArrayList<Integer>[]  WeatherData) throws IOException, InterruptedException {

		RetrieveData(Cities,CitiesID,WeatherData,appid);
	}

}