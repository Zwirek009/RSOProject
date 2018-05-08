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

	protected long date;

	protected int left;

	protected int price;

	@NotNull
	protected String desc;

	protected long regionId;
}
