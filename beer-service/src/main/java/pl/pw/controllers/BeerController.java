package pl.pw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.pw.models.Beer;
import pl.pw.services.BeerService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public Beer getBeer(@RequestParam Long id) throws IllegalAccessException {
		Optional<Beer> beer = beerService.getBeer(id);
		if (!beer.isPresent()) {
			throw new IllegalAccessException("error.beer");
		}
		return beer.get();
	}

	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public void addBeer(@RequestParam Beer beer) {
		beerService.addBeer(beer);
	}
}
