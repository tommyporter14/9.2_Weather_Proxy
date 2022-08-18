package co.grandcircus.WeatherAPIProxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

	private RestTemplate rt = new RestTemplate();
	
	public WeatherPointResponse getPointResponse(Double lat, Double lon) {
		String url = "https://api.weather.gov/points/{0},{1}";
		WeatherPointResponse response = rt.getForObject(url, WeatherPointResponse.class, lat, lon);
		return response;
	}
	
	public String getForecastURL(Double lat, Double lon) {
		return getPointResponse(lat, lon).getProperties().getForcast();
	}
	
	public WeatherPeriodResponse getPeriodResponse(String url) {
		WeatherPeriodResponse response = rt.getForObject(url, WeatherPeriodResponse.class);
		return response;
	}
	
	public ProxyResopnse getProxyResponse(Double lat, Double lon) {
		List<Period> periods = getPeriodResponse(getForecastURL(lat, lon)).getProperties().getPeriods();
		List<ProxyPeriod> proxyPeriods = new ArrayList<>();
		for (int i = 0; i < periods.size(); i++) {
			proxyPeriods.add(new ProxyPeriod(periods.get(i)));
		}
		Stats stats = new Stats(periods);
		return new ProxyResopnse(proxyPeriods, stats);
	}
}
