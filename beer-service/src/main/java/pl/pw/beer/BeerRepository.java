package pl.pw.beer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, Long> {

	// =================================================================================================================
	//  BASIC
	// =================================================================================================================

	List<Beer> findByUserId(long userId);

	List<Beer> findByStyle(String style);

	List<Beer> findByRegion_RegionId(long regionId);

	List<Beer> findByDateIsGreaterThanEqual(long dateLowLimit);

	List<Beer> findByDateIsLessThanEqual(long dateHighLimit);

	// =================================================================================================================
	//  COMPLEX
	// =================================================================================================================

	List<Beer> findByUserIdAndDateBetween(long userId, long dateFrom, long dateTo);

	List<Beer> findByRegion_RegionIdAndDateBetween(long regionId, long dateFrom, long dateTo);

	List<Beer> findByStyleAndDateBetween(String style, long dateFrom, long dateTo);

	List<Beer> findByDateBetween(long dateFrom, long dateTo);



	List<Beer> findByUserIdAndStyleAndDateBetween(long userId, String style, long dateFrom, long dateTo);

	List<Beer> findByUserIdAndRegion_RegionIdAndDateBetween(long userId, long regionId, long dateFrom, long dateTo);



//	List<Beer> findByStyleAndRegion_RegionIdAndDateBetween(String style, long regionId, long dateFrom, long dateTo);
	List<Beer> findByRegion_regionIdAndStyleAndDateBetween(long regionId, String style, long dateFrom, long dateTo);



	List<Beer> findByUserIdAndStyleAndRegion_RegionIdAndDateBetween(long userId, String style, long regionId, long dateFrom, long dateTo);

//	List<Beer> findByUserIdBetweenAndRegion_RegionIdBetweenAndDateBetween(long userIdFrom, long userIdTo,
//	                                                                      long regionIdLow, long regionIdTo,
//	                                                                      long dateFrom, long dateTo);
//
//	List<Beer> findByUserIdBetweenAndStyleAndRegion_RegionIdBetweenAndDateBetween(long userIdFrom, long userIdTo,
//	                                                                      String style,
//	                                                                      long regionIdLow, long regionIdTo,
//	                                                                      long dateFrom, long dateTo);

}
