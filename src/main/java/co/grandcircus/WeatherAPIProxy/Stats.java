package co.grandcircus.WeatherAPIProxy;

import java.util.List;

public class Stats {
	private int averageTemperature;
	private Period hottestPeriod;
	private Period coldestPeriod;
	public int getAverageTemperature() {
		return averageTemperature;
	}
	public void setAverageTemperature(int averageTemperature) {
		this.averageTemperature = averageTemperature;
	}
	public Period getHottestPeriod() {
		return hottestPeriod;
	}
	public void setHottestPeriod(Period hottestPeriod) {
		this.hottestPeriod = hottestPeriod;
	}
	public Period getColdestPeriod() {
		return coldestPeriod;
	}
	public void setColdestPeriod(Period coldestPeriod) {
		this.coldestPeriod = coldestPeriod;
	}
	
	public Stats(List<Period> periods) {
		int totalTemp = 0;
		int maxTemp = -500;
		int minTemp = 500;
		Period hottest = new Period();
		Period coldest = new Period();
		
		for(Period period : periods) {
			totalTemp += period.getTemperature();
			if(period.getTemperature() > maxTemp) {
				maxTemp = period.getTemperature();
				hottest = period;
			} if(period.getTemperature() < minTemp) {
				minTemp = period.getTemperature();
				coldest = period;
			}
		}
		this.averageTemperature = totalTemp / periods.size();
		this.hottestPeriod = hottest;
		this.coldestPeriod = coldest;
	}
}
