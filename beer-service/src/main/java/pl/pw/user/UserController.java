//package pl.pw.user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import pl.pw.beer.Beer;
//
//import java.util.List;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//	private final UserService userService;
//
//	@Autowired
//	public UserController(UserService userService) {
//		this.userService = userService;
//	}
//
//	@RequestMapping(value = "/get_beers", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
//	public List<Beer> getBeers(@RequestParam Long id) {
//		return userService.getBeers(id);
//	}
//
//	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
//	public void createUser(@RequestParam User user) {
//		userService.createUser(user);
//	}
//
//	@RequestMapping(value = "/add_beer", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
//	public void addBeer(@RequestParam  Long id, @RequestParam Beer beer) {
//		userService.addBeer(id, beer);
//	}
//
//}
