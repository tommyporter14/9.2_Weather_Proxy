package co.grandcircus.WeatherAPIProxy;

public class ProxyPeriod extends Period{

	private int temperatureCelcius;

	public int getTemperatureCelcius() {
		return temperatureCelcius;
	}

	public void setTemperatureCelcius(int temperatureCelcius) {
		this.temperatureCelcius = temperatureCelcius;
	}
	
	public ProxyPeriod(Period period){
		super();
		this.number = number;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isDayTime = isDayTime;
		this.temperature = temperature;
		this.temperateUnit = temperateUnit;
		this.temperatureTrend = temperatureTrend;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.icon = icon;
		this.shortForecast = shortForecast;
		this.detailedForecast = detailedForecast;
		
		this.temperatureCelcius = ((period.temperature - 32) * 5 / 9);
	}
	
	
}
