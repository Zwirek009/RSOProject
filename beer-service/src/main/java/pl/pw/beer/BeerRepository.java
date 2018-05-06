package pl.pw.beer;

import org.springframework.data.repository.CrudRepository;
import pl.pw.region.Region;

import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, Long> {

	List<Beer> findByUserId(long userId);

	List<Beer> findByStyle(String style);

	List<Beer> findByRegion_RegionId(long regionId);

}
