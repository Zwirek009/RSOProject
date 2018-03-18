package pl.pw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.models.Beer;
import pl.pw.repositories.BeerRepository;

import java.util.Optional;

@Service
public class BeerService {

	private final BeerRepository beerRepository;

	@Autowired
	public BeerService(BeerRepository beerRepository) {
		this.beerRepository = beerRepository;
	}

	public void addBeer(Beer beer) {
		beerRepository.save(beer);
	}

	public Optional<Beer> getBeer(long id) {
		return beerRepository.findById(id);
	}

}
