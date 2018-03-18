package pl.pw.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pw.models.Region;

public interface RegionRepository extends CrudRepository<Region, Long> {
}
