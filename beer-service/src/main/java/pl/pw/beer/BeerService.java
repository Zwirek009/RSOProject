package pl.pw.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.region.Region;
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

	public void addBeer(long userId, String name, String beerType, String desc, String city, String district) {
		Region region = new Region(city, district);
		regionRepository.save(region);
		beerRepository.save(new Beer(userId, name, beerType, desc, region));
	}

	public Optional<Beer> getBeer(long id) {
		return beerRepository.findById(id);
	}

	public List<Beer> getBeers(long userId) {
		return beerRepository.findByUserId(userId);
	}
}
