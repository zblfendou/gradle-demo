import java.io.Serializable;

/**
 * Created by Administrator on 2016.5.4.
 */
public class City implements Serializable{
	private String cityName;

	public City (String cityName) {
		this.cityName = cityName;
	}

	public String getCityName () {
		return cityName;
	}

	public void setCityName (String cityName) {
		this.cityName = cityName;
	}
}
