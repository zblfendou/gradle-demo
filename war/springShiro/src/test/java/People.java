import java.io.Serializable;

/**
 * Created by Administrator on 2016.5.4.
 */
public class People implements Serializable{
	private String name;
	private String lastName;
	private City city;

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getLastName () {
		return lastName;
	}

	public void setLastName (String lastName) {
		this.lastName = lastName;
	}

	public City getCity () {
		return city;
	}

	public void setCity (City city) {
		this.city = city;
	}

	public People () {

	}

	public People (String name, String lastName, City city) {

		this.name = name;
		this.lastName = lastName;
		this.city = city;
	}
}
