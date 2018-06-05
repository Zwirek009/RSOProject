package pl.pw.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.region.RegionRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class BeerService {

	private final BeerRepository beerRepository;
	private final RegionRepository regionRepository;

	private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
	private static final String MAX_DATE = "3000-12-31";
	private static final String MIN_DATE = "1970-01-01";

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
	                    String date,
	                    int left,
	                    int price,
	                    String desc,
	                    long regionId) {
		LocalDate localDate = LocalDate.parse(date, formatter);
		regionRepository.findById(regionId).ifPresent(region -> beerRepository.save(new Beer(userId, name, style, abv, blg, ibu, localDate, left, price, desc, region)));
	}

	public Beer getBeer(long id) throws IllegalArgumentException {
		Optional<Beer> beer = beerRepository.findById(id);
		if(beer.isPresent()) {
			return beer.get();
		} else {
			throw new IllegalArgumentException("no beer with given id " + id);
		}
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

	public List<Beer> getBeers(Long userId, Long regionId, String style, String dateFrom, String dateTo) {
		LocalDate from, to;

		if (dateFrom != null) {
			from = LocalDate.parse(dateFrom, formatter);
		} else {
			from = LocalDate.parse(MIN_DATE, formatter);
		}

		if(dateTo != null) {
			to = LocalDate.parse(dateTo, formatter);
		} else {
			to = LocalDate.parse(MAX_DATE, formatter);
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

	public void remove(long beerId) throws IllegalArgumentException {
		if(beerRepository.existsById(beerId)) {
			beerRepository.deleteById(beerId);
		} else {
			throw new IllegalArgumentException("no beer with given id " + beerId);
		}
	}

}
