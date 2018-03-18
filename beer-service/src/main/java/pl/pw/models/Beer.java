package pl.pw.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="beer")
public class Beer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long beerid;

	@NotNull
	private String name;

	@NotNull
	private BeerType beerType;

	@NotNull
	private String desc;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "regionId")
	private Region region;

	public Beer(@NotNull long beerid, @NotNull String name, @NotNull BeerType beerType, @NotNull String desc, @NotNull Region region) {
		this.beerid = beerid;
		this.name = name;
		this.beerType = beerType;
		this.desc = desc;
		this.region = region;
	}

	public long getBeerid() {
		return beerid;
	}

	public void setBeerid(long beerid) {
		this.beerid = beerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public BeerType getBeerType() {
		return beerType;
	}

	public void setBeerType(BeerType beerType) {
		this.beerType = beerType;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}
