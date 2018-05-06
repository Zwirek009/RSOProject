//package pl.pw.user;
//
//import pl.pw.beer.Beer;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//
//@Entity
//@Table(name="user")
//public class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long userId;
//
//	@NotNull
//	private String username;
//
//	private List<Beer> beers;
//
//	public User(@NotNull String username) {
//		this.username = username;
//	}
//
//	public long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(long userId) {
//		this.userId = userId;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public List<Beer> getBeers() {
//		return beers;
//	}
//
//	public void setBeers(List<Beer> beers) {
//		this.beers = beers;
//	}
//
//	public void addBeer(Beer beer) {
//		beers.add(beer);
//	}
//}
