package pl.pw.region;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "region")
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long regionId;

	@NotNull
	private String city;

	public Region() {
	}

	public Region(@NotNull String city) {
		this.city = city;
	}

	public long getRegionId() {
		return regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
