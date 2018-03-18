package pl.pw.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pw.models.Beer;

public interface BeerRepository extends CrudRepository<Beer, Long> {
}
