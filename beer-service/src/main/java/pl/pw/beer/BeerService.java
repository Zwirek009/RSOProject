package pl.pw.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.region.RegionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BeerService {

	private final BeerRepository beerRepository;
	private final RegionRepository regionRepository;

	@Autowired
	public BeerService(BeerRepository beerRepository, RegionRepository regionRepository) {
		this.beerRepository = beerRepository;
		this.regionRepository = regionRepository;
	}

	public void addBeer(long userId,
	                    String name,
	                    String style,
	                    int abv,
	                    int blg,
	                    int ibu,
	                    long date,
	                    int left,
	                    int price,
	                    String desc,
	                    long regionId) {
		regionRepository.findById(regionId).ifPresent(region -> beerRepository.save(new Beer(userId, name, style, abv, blg, ibu, date, left, price, desc, region)));
	}

	public Beer getBeer(long id) {
		Optional<Beer> beer = beerRepository.findById(id);
		return beer.orElse(null);
	}

	public List<Beer> getBeers(long userId) {
		return beerRepository.findByUserId(userId);
	}

	public List<Beer> getBeersByStyle(String style) {
		return beerRepository.findByStyle(style);
	}

	public List<Beer> getBeersByRegion(long regionId) {
		return beerRepository.findByRegion_RegionId(regionId);
	}
}
