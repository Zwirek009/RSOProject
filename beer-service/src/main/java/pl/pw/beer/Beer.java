package pl.pw.beer;

import pl.pw.region.Region;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="beer")
public class Beer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long beerId;

	private long userId;

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

	public Beer() {
	}

	public Beer(long userId, @NotNull String name, @NotNull String beerType, @NotNull String desc, @NotNull Region region) {
		this.userId = userId;
		this.name = name;
		this.beerType = BeerType.valueOf(beerType);
		this.desc = desc;
		this.region = region;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getBeerId() {
		return beerId;
	}

	public void setBeerId(long beerId) {
		this.beerId = beerId;
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
