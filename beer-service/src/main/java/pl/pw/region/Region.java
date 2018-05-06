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

	@NotNull
	private String district;

	public Region() {
	}

	public Region(@NotNull String city, @NotNull String district) {
		this.city = city;
		this.district = district;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
}
