package co.grandcircus.WeatherAPIProxy;

import java.util.List;

public class ProxyResopnse {

	private List<ProxyPeriod> periods;
	private Stats stats;
	
	public List<ProxyPeriod> getPeriods() {
		return periods;
	}
	public void setPeriods(List<ProxyPeriod> periods) {
		this.periods = periods;
	}
	public Stats getStats() {
		return stats;
	}
	public void setStats(Stats stats) {
		this.stats = stats;
	}
	public ProxyResopnse(List<ProxyPeriod> periods, Stats stats) {
		this.periods = periods;
		this.stats = stats;
	}

	
}
