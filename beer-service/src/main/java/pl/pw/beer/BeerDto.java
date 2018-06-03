package pl.pw.beer;

import javax.validation.constraints.NotNull;

public class BeerDto {

	protected long userId;

	@NotNull
	protected String name;

	@NotNull
	protected String style;

	protected int abv;

	protected int blg;

	protected int ibu;

	protected String date;

	protected int left;

	protected int price;

	@NotNull
	protected String desc;

	protected long regionId;

	public BeerDto() {
	}

	public BeerDto(long userId, @NotNull String name, @NotNull String style, int abv, int blg, int ibu, @NotNull String date, int left, int price, @NotNull String desc, long regionId) {
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
		this.regionId = regionId;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	public long getRegionId() {
		return regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}
}
