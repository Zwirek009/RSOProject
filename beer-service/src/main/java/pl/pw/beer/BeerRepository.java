package pl.pw.beer;

import org.springframework.data.repository.CrudRepository;
import pl.pw.region.Region;

import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, Long> {

	List<Beer> findByUserId(long userId);

//	List<Beer> findByBeerType(BeerType beerType);
//
//	List<Beer> findByRegionContaining(long regionId);

}
