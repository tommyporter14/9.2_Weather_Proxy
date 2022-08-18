package co.grandcircus.WeatherAPIProxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private WeatherService ws;
	
	@GetMapping("/forecast")
	public List<Period> getForecast(@RequestParam Double lat, @RequestParam Double lon) {
		String url = ws.getForecastURL(lat, lon);
		WeatherPeriodResponse gridResponse = ws.getPeriodResponse(url);
		return gridResponse.getProperties().getPeriods();
	}
	@GetMapping("/forecast/plus")
	public ProxyResopnse getForecastPlus(@RequestParam Double lat, @RequestParam Double lon) {
		return ws.getProxyResponse(lat, lon);
	}
}
