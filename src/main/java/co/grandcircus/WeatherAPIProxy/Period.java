package co.grandcircus.WeatherAPIProxy;

public class Period {

	protected int number;
	protected String name;
	protected String startTime;
	protected String endTime;
	protected boolean isDayTime;
	protected int temperature;
	protected String temperateUnit;
	protected  Object temperatureTrend;
	protected String windSpeed;
	protected String windDirection;
	protected String icon;
	protected String shortForecast;
	protected String detailedForecast;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public boolean isDayTime() {
		return isDayTime;
	}
	public void setDayTime(boolean isDayTime) {
		this.isDayTime = isDayTime;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public String getTemperateUnit() {
		return temperateUnit;
	}
	public void setTemperateUnit(String temperateUnit) {
		this.temperateUnit = temperateUnit;
	}
	public Object getTemperatureTrend() {
		return temperatureTrend;
	}
	public void setTemperatureTrend(Object temperatureTrend) {
		this.temperatureTrend = temperatureTrend;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getShortForecast() {
		return shortForecast;
	}
	public void setShortForecast(String shortForecast) {
		this.shortForecast = shortForecast;
	}
	public String getDetailedForecast() {
		return detailedForecast;
	}
	public void setDetailedForecast(String detailedForecast) {
		this.detailedForecast = detailedForecast;
	}
	
	
}
