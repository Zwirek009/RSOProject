package pl.pw.beer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, Long> {

//	List<Beer> findBeersByUserIdIn()

}
