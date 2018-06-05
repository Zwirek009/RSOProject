package pl.pw.beer;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.time.LocalDate;
import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, Long>, QueryByExampleExecutor<Beer> {

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

	// =================================================================================================================
	//  DATE FROM
	// =================================================================================================================

	List<Beer> findByUserIdAndDateAfter(long userId, LocalDate dateFrom);

	List<Beer> findByRegion_RegionIdAndDateAfter(long regionId, LocalDate dateFrom);

	List<Beer> findByStyleAndDateAfter(String style, LocalDate dateFrom);

	List<Beer> findByDateAfter(LocalDate dateFrom);

	List<Beer> findByUserIdAndStyleAndDateAfter(long userId, String style, LocalDate dateFrom);

	List<Beer> findByUserIdAndRegion_RegionIdAndDateAfter(long userId, long regionId, LocalDate dateFrom);

	List<Beer> findByRegion_regionIdAndStyleAndDateAfter(long regionId, String style, LocalDate dateFrom);

	List<Beer> findByUserIdAndStyleAndRegion_RegionIdAndDateAfter(long userId, String style, long regionId, LocalDate dateFrom);

	// =================================================================================================================
	//  DATE TO
	// =================================================================================================================

	List<Beer> findByUserIdAndDateBefore(long userId, LocalDate dateTo);

	List<Beer> findByRegion_RegionIdAndDateBefore(long regionId, LocalDate dateTo);

	List<Beer> findByStyleAndDateBefore(String style, LocalDate dateTo);

	List<Beer> findByDateBefore(LocalDate dateTo);

	List<Beer> findByUserIdAndStyleAndDateBefore(long userId, String style, LocalDate dateTo);

	List<Beer> findByUserIdAndRegion_RegionIdAndDateBefore(long userId, long regionId, LocalDate dateTo);

	List<Beer> findByRegion_regionIdAndStyleAndDateBefore(long regionId, String style, LocalDate dateTo);

	List<Beer> findByUserIdAndStyleAndRegion_RegionIdAndDateBefore(long userId, String style, long regionId, LocalDate dateTo);

}
