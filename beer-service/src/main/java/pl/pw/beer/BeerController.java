package pl.pw.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	// =================================================================================================================
	//  GET
	// =================================================================================================================

	@RequestMapping(value = "/get/{beerId}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Beer> getBeer(@PathVariable("beerId") long beerId) throws IllegalArgumentException {
		return ResponseEntity.ok(beerService.getBeer(beerId));
	}

	//curl -v -X GET 'http://localhost:8082/beer/get_by_user/1'
	@RequestMapping(value = "/get_by_user/{userId}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Beer>> getUserBeers(@PathVariable(value = "userId") long userId) {
		return ResponseEntity.ok(beerService.getBeers(userId));
	}

	//curl -v -X GET 'http://localhost:8082/beer/get_by_style/style1'
	@RequestMapping(value = "/get_by_style/{style}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Beer>> getStyleBeers(@PathVariable("style") String style) {
		return ResponseEntity.ok(beerService.getBeersByStyle(style));
	}

	//curl -v -X GET 'http://localhost:8082/beer/get_by_region/1'
	@RequestMapping(value = "/get_by_region/{regionId}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Beer>> getRegionBeers(@PathVariable("regionId") long regionId) {
		return ResponseEntity.ok(beerService.getBeersByRegion(regionId));
	}

	// =================================================================================================================
	//  FIND
	// =================================================================================================================

	// curl -v -X GET 'http://localhost:8082/beer/find?userId=1&style=style1'
	@RequestMapping(value = "/find", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Beer>> findAll(@RequestParam(value = "userId", required = false) Long userId,
	                                      @RequestParam(value = "regionId", required = false) Long regionId,
	                                      @RequestParam(value = "style", required = false) String style,
	                                      @RequestParam(value = "dateFrom", required = false) String dateFrom,
	                                      @RequestParam(value = "dateTo", required = false) String dateTo) {
		return ResponseEntity.ok(beerService.findAllBeers(userId, regionId, style, dateFrom, dateTo));
	}

	// =================================================================================================================
	//  UPDATE
	// =================================================================================================================

	// curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST 'http://localhost:8082/beer/add' -d '{"userId": 1, "name": "name1", "style": "style1", "abv": 1, "blg": 2, "ibu": 3, "date": "2017-12-24", "left": 5, "price": 6, "desc": "desc1", "regionId": 1}’'
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity addBeer(@RequestBody BeerDto beerDto) {
		beerService.addBeer(beerDto.userId, beerDto.name, beerDto.style, beerDto.abv, beerDto.blg, beerDto.ibu, beerDto.date, beerDto.left, beerDto.price, beerDto.desc, beerDto.regionId);
		return ResponseEntity.ok().build();
	}

	// curl -v -X DELETE 'http://localhost:8082/beer/remove/1'
	@RequestMapping(value = "/remove/{beerId}", method = RequestMethod.DELETE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity removeBeer(@PathVariable("beerId") long beerId) throws IllegalArgumentException {
		beerService.remove(beerId);
		return ResponseEntity.ok().build();
	}

	// =================================================================================================================
	//  UTILS
	// =================================================================================================================

	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
}
