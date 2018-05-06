package pl.pw.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/beer")
class BeerController {

	private final BeerService beerService;

	@Autowired
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	@RequestMapping(value = "/get_beer", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public Beer getBeer(@RequestParam long id) throws IllegalArgumentException {
		Optional<Beer> beer = beerService.getBeer(id);
		if (!beer.isPresent()) {
			throw new IllegalArgumentException("error.beer");
		}
		return beer.get();
	}

 	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public List<Beer> getUserBeers(@RequestParam long userId) {
		return beerService.getBeers(userId);
	}

	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public void addBeer(@RequestParam long userId, @RequestParam String name, @RequestParam String beerType, @RequestParam String desc, @RequestParam String city, @RequestParam String district) {
		beerService.addBeer(userId, name , beerType, desc, city, district);
	}
}
