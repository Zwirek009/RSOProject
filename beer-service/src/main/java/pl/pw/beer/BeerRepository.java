package pl.pw.beer;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, Long> {

	// =================================================================================================================
	//  BASIC
	// =================================================================================================================

	List<Beer> findByUserId(long userId);

	List<Beer> findByStyle(String style);

	List<Beer> findByRegion_RegionId(long regionId);

	// =================================================================================================================
	//  COMPLEX
	// =================================================================================================================

	List<Beer> findByUserIdAndDateBetween(long userId, LocalDate dateFrom, LocalDate dateTo);

	List<Beer> findByRegion_RegionIdAndDateBetween(long regionId, LocalDate dateFrom, LocalDate dateTo);

	List<Beer> findByStyleAndDateBetween(String style, LocalDate dateFrom, LocalDate dateTo);

	List<Beer> findByDateBetween(LocalDate dateFrom, LocalDate dateTo);



	List<Beer> findByUserIdAndStyleAndDateBetween(long userId, String style, LocalDate dateFrom, LocalDate dateTo);

	List<Beer> findByUserIdAndRegion_RegionIdAndDateBetween(long userId, long regionId, LocalDate dateFrom, LocalDate dateTo);



	List<Beer> findByRegion_regionIdAndStyleAndDateBetween(long regionId, String style, LocalDate dateFrom, LocalDate dateTo);



	List<Beer> findByUserIdAndStyleAndRegion_RegionIdAndDateBetween(long userId, String style, long regionId, LocalDate dateFrom, LocalDate dateTo);

}
