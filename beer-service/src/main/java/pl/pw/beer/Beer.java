package pl.pw.beer;

import pl.pw.region.Region;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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
	private String style;

	private int abv;

	private int blg;

	private int ibu;

	private LocalDate date;

	private int left;

	private int price;

	@NotNull
	private String desc;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "regionId")
	private Region region;

	public Beer() {
	}

	public Beer(long userId, @NotNull String name, @NotNull String style, int abv, int blg, int ibu, LocalDate date, int left, int price, @NotNull String desc, @NotNull Region region) {
		this.userId = userId;
		this.name = name;
		this.style = style;
		this.abv = abv;
		this.blg = blg;
		this.ibu = ibu;
		this.date = date;
		this.left = left;
		this.price = price;
		this.desc = desc;
		this.region = region;
	}

	public long getBeerId() {
		return beerId;
	}

	public void setBeerId(long beerId) {
		this.beerId = beerId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int getAbv() {
		return abv;
	}

	public void setAbv(int abv) {
		this.abv = abv;
	}

	public int getBlg() {
		return blg;
	}

	public void setBlg(int blg) {
		this.blg = blg;
	}

	public int getIbu() {
		return ibu;
	}

	public void setIbu(int ibu) {
		this.ibu = ibu;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}
