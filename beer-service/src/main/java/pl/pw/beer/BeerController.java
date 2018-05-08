package pl.pw.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/beer")
class BeerController {

	private final BeerService beerService;

	@Autowired
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	@RequestMapping(value = "/get/{beerId}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public Beer getBeer(@PathVariable("beerId") long beerId) throws IllegalArgumentException {
		Beer beer = beerService.getBeer(beerId);
		if (beer != null) {
			return beer;
		}
		throw new IllegalArgumentException("error.beer");
	}

	//curl -v -X GET 'http://localhost:8082/beer/get_by_user/1'
	@RequestMapping(value = "/get_by_user/{userId}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public List<Beer> getUserBeers(@PathVariable(value = "userId") long userId) {
		return beerService.getBeers(userId);
	}

	//curl -v -X GET 'http://localhost:8082/beer/get_by_style/style1'
	@RequestMapping(value = "/get_by_style/{style}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public List<Beer> getStyleBeers(@PathVariable("style") String style) {
		return beerService.getBeersByStyle(style);
	}

	//curl -v -X GET 'http://localhost:8082/beer/get_by_region/1'
	@RequestMapping(value = "/get_by_region/{regionId}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public List<Beer> getRegionBeers(@PathVariable("regionId") long regionId) {
		return beerService.getBeersByRegion(regionId);
	}

	//curl -v -X POST 'http://localhost:8082/beer/add' -d 'userId=1&name=name1&style=style1&abv=1&blg=2&ibu=3&date=4&left=5&price=6&desc=desc1&regionId=1'
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public void addBeer(@RequestParam long userId,
	                    @RequestParam String name,
	                    @RequestParam String style,
	                    @RequestParam int abv,
	                    @RequestParam int blg,
	                    @RequestParam int ibu,
	                    @RequestParam long date,
	                    @RequestParam int left,
	                    @RequestParam int price,
	                    @RequestParam String desc,
	                    @RequestParam long regionId) {
		beerService.addBeer(userId, name, style, abv, blg, ibu, date, left, price, desc, regionId);
	}

	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
}
