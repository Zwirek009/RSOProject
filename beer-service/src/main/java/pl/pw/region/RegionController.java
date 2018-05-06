package pl.pw.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/region")
public class RegionController {

	private final RegionService regionService;

	@Autowired
	public RegionController(RegionService regionService) {
		this.regionService = regionService;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public Iterable<Region> getRegions() {
		return regionService.getRegions();
	}
}
