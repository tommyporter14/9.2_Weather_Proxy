package co.grandcircus.WeatherAPIProxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

	private RestTemplate rt = new RestTemplate();
	
	public List<Period> getPeriod(String lat, String lon){
		String urlgp = "https://api.weather.gov/points/" + lat + "," + lon;
		GridPropertiesResponse gpr = rt.getForObject(urlgp, GridPropertiesResponse.class);
		
		String urlf = gpr.getProperties().getForecast();
		ForecastResponse fr = rt.getForObject(urlf, ForecastResponse.class);
		
		return fr.getProperties().getPeriods();
	}
	
	public List<ProxyPeriod> getPlusPeriod(String lat, String lon){
		String urlgp = "https://api.weather.gov/points/" + lat + "," + lon;
		GridPropertiesResponse gpr = rt.getForObject(urlgp, GridPropertiesResponse.class);
		
		String urlf = gpr.getProperties().getForecast();
		ProxyForecast pf = rt.getForObject(urlf, ProxyForecast.class);
		
		List<ProxyPeriod> periods = pf.getProperties().getPeriods();
		
		return periods;
		
	}
}
