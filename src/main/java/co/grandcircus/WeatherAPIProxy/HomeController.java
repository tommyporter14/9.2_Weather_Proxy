package co.grandcircus.WeatherAPIProxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	WeatherService ws;
	
	@GetMapping("/forecast")
	public List<Period> getPeriods(@RequestParam String lat, @RequestParam String lon){
		return ws.getPeriod(lat, lon);
	}
	
	@GetMapping("/forecast/plus")
	public ProxyResponse getPlusPeriods(@RequestParam String lat, @RequestParam String lon) {
		ProxyResponse pr = new ProxyResponse();
		Stats stats = new Stats ();
		pr.setPeriods(ws.getPlusPeriod(lat, lon));
		
		double totalTemp = 0;
		ProxyPeriod hottest = pr.getPeriods().get(0);
		ProxyPeriod coldest = pr.getPeriods().get(0);
		
		for(ProxyPeriod p : pr.getPeriods()) {
			totalTemp += p.getTemperature();
			
			if(p.getTemperature() > hottest.getTemperature()) {
				hottest = p;
			}
			if(p.getTemperature() < coldest.getTemperature()) {
				coldest = p;
			}
			
			double temp = p.getTemperature();
			temp = (temp -32) * (5.0/9.0);
			temp = Math.round(temp);
			p.setTemperatureCelcius((int) temp);
		}
	
		double average = Math.round(totalTemp/pr.getPeriods().size());
		stats.setAverageTemperature((int)average);
		stats.setColdestPeriod(coldest);
		stats.setHottestPeriod(hottest);
		
		pr.setStats(stats);
		
		return pr;
	
	}
}
