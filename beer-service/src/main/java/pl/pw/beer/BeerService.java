package pl.pw.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.region.RegionRepository;

import java.util.Calendar;
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

	public void addBeer(long userId,
	                    String name,
	                    String style,
	                    int abv,
	                    int blg,
	                    int ibu,
	                    long date,
	                    int left,
	                    int price,
	                    String desc,
	                    long regionId) {
		regionRepository.findById(regionId).ifPresent(region -> beerRepository.save(new Beer(userId, name, style, abv, blg, ibu, date, left, price, desc, region)));
	}

	public Beer getBeer(long id) {
		Optional<Beer> beer = beerRepository.findById(id);
		return beer.orElse(null);
	}

	public List<Beer> getBeers(long userId) {
		return beerRepository.findByUserId(userId);
	}

	public List<Beer> getBeersByStyle(String style) {
		return beerRepository.findByStyle(style);
	}

	public List<Beer> getBeersByRegion(long regionId) {
		return beerRepository.findByRegion_RegionId(regionId);
	}

	public List<Beer> getYoungerBeers(long dateLowLimit) {
		return beerRepository.findByDateIsGreaterThanEqual(dateLowLimit);
	}

	public List<Beer> getOlderBeers(long dateHighLimit) {
		return beerRepository.findByDateIsLessThanEqual(dateHighLimit);
	}

	public List<Beer> getBeers(Long userId, Long regionId, String style, Long dateFrom, Long dateTo) {
		long from, to;

		if (dateFrom != null) {
			from = dateFrom;
		} else {
			from = 0L;
		}

		if(dateTo != null) {
			to = dateTo;
		} else {
			to = Calendar.getInstance().getTimeInMillis();
		}

		if(userId != null) {

			if(regionId != null) {

				if(style != null) {
					return beerRepository.findByUserIdAndStyleAndRegion_RegionIdAndDateBetween(userId, style, regionId, from, to);
				} else {
					return beerRepository.findByUserIdAndRegion_RegionIdAndDateBetween(userId, regionId, from, to);
				}

			} else {

				if(style!= null) {
					return beerRepository.findByUserIdAndStyleAndDateBetween(userId, style, from, to);
				} else {
					return beerRepository.findByUserIdAndDateBetween(userId, from, to);
				}

			}

		} else if (regionId!= null) {

			if(style!= null) {
				return beerRepository.findByRegion_regionIdAndStyleAndDateBetween(regionId, style, from, to);
			} else {
				return beerRepository.findByRegion_RegionIdAndDateBetween(regionId, from, to);
			}

		} else if(style!= null) {
			return beerRepository.findByStyleAndDateBetween(style, from, to);
		} else {
			return beerRepository.findByDateBetween(from, to);
		}
	}

//	public List<Beer> getBeers(Optional<Long> userId, Optional<Long> regionId, Optional<String> style, Optional<Long> dateFrom, Optional<Long> dateTo) {
//
//		long from, to;
//
//		if (dateFrom.isPresent()) {
//			from = dateFrom.get();
//		} else {
//			from = 0L;
//		}
//
//		if(dateTo.isPresent()) {
//			to = dateTo.get();
//		} else {
//			to = Calendar.getInstance().getTimeInMillis();
//		}
//
//		if(userId.isPresent()) {
//
//			if(regionId.isPresent()) {
//
//				if(style.isPresent()) {
//					return beerRepository.findByUserIdAndStyleAndRegion_RegionIdAndDateBetween(userId.get(), style.get(), regionId.get(), from, to);
//				} else {
//					return beerRepository.findByUserIdAndRegion_RegionIdAndDateBetween(userId.get(), regionId.get(), from, to);
//				}
//
//			} else {
//
//				if(style.isPresent()) {
//					return beerRepository.findByUserIdAndStyleAndDateBetween(userId.get(), style.get(), from, to);
//				} else {
//					return beerRepository.findByUserIdAndDateBetween(userId.get(), from, to);
//				}
//
//			}
//
//		} else if (regionId.isPresent()) {
//
//			if(style.isPresent()) {
//				return beerRepository.findByRegion_regionIdAndStyleAndDateBetween(regionId.get(), style.get(), from, to);
//			} else {
//				return beerRepository.findByRegion_RegionIdAndDateBetween(regionId.get(), from, to);
//			}
//
//		} else if(style.isPresent()) {
//			return beerRepository.findByStyleAndDateBetween(style.get(), from, to);
//		} else {
//			return beerRepository.findByDateBetween(from, to);
//		}
//	}

}
