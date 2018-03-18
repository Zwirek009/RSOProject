package pl.pw.models;

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

	public Region(@NotNull long regionId, @NotNull String city, @NotNull String district) {
		this.regionId = regionId;
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
