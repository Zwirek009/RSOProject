package pl.pw.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import pl.pw.region.RegionRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BeerService {

	private final BeerRepository beerRepository;
	private final RegionRepository regionRepository;

	private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
	private static final String MAX_DATE = "9999-12-31";
	private static final String MIN_DATE = "0001-01-01";

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
	                    long regionId) throws IllegalArgumentException {
		LocalDate localDate = unwrap(date);
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

	@Deprecated
	public Iterable<Beer> findAllBeers2(Long userId, Long regionId, String style, String dateFrom, String dateTo) {

		List<String> ignorePaths = new LinkedList<>();
		ignorePaths.add("beerId");
		ignorePaths.add("abv");
		ignorePaths.add("blg");
		ignorePaths.add("ibu");
		ignorePaths.add("price");
		ignorePaths.add("left");

		Beer beerExample = new Beer();

		if(userId != null) {
			beerExample.setUserId(userId);
		} else {
			ignorePaths.add("userId");
		}

		if(regionId != null) {
			beerExample.getRegion().setRegionId(regionId);
		} else {
			ignorePaths.add("region.regionId");
		}

		if(style != null) {
			beerExample.setStyle(style);
		}

		String[] ar = ignorePaths.toArray(new String[0]);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withIgnoreNullValues().withIgnorePaths(ar);
		Iterable<Beer> all = beerRepository.findAll(Example.of(beerExample, exampleMatcher));

		LocalDate to, from;
		boolean checkingFrom = true, checkingTo = true;
		if(dateTo != null) {
			to = LocalDate.parse(dateTo, formatter);
		} else {
			checkingTo = false;
			to = LocalDate.MIN;
		}

		if(dateFrom != null) {
			from = LocalDate.parse(dateFrom, formatter);
		} else {
			checkingFrom = false;
			from = LocalDate.MAX;

		}

		if(checkingFrom && checkingTo) {
			List<Beer> withDates = new LinkedList<>();
			for (Beer b : all) {
				if (b.getDate().isBefore(to) && b.getDate().isAfter(from)) {
					withDates.add(b);
				}
			}
			return withDates;
		} else {
			return all;
		}
	}

	public Iterable<Beer> findAllBeers(Long userId, Long regionId, String style, String dateFrom, String dateTo) throws IllegalArgumentException {
		if(dateFrom == null) {
			if(dateTo == null) {
				return withoutDates(userId, regionId, style);
			} else {
					return withDateTo(userId, style, regionId, unwrap(dateTo));
			}
		} else {
			if(dateTo == null) {
					return withDateFrom(userId, style, regionId, unwrap(dateFrom));
			} else {
				return withBothDates(userId, style, regionId, unwrap(dateFrom), unwrap(dateTo));
			}
		}
	}

	private List<Beer> withBothDates(Long userId, String style, Long regionId, LocalDate from, LocalDate to) {
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
		}
		return beerRepository.findByDateBetween(from, to);
	}

	private List<Beer> withDateFrom(Long userId, String style, Long regionId, LocalDate from) {
		if(userId != null) {
			if(regionId != null) {
				if(style != null) {
					return beerRepository.findByUserIdAndStyleAndRegion_RegionIdAndDateAfter(userId, style, regionId, from);
				} else {
					return beerRepository.findByUserIdAndRegion_RegionIdAndDateAfter(userId, regionId, from);
				}
			} else {
				if(style!= null) {
					return beerRepository.findByUserIdAndStyleAndDateAfter(userId, style, from);
				} else {
					return beerRepository.findByUserIdAndDateAfter(userId, from);
				}
			}
		} else if (regionId!= null) {
			if(style!= null) {
				return beerRepository.findByRegion_regionIdAndStyleAndDateAfter(regionId, style, from);
			} else {
				return beerRepository.findByRegion_RegionIdAndDateAfter(regionId, from);
			}
		} else if(style!= null) {
			return beerRepository.findByStyleAndDateAfter(style, from);
		}
		return beerRepository.findByDateAfter(from);
	}

	private List<Beer> withDateTo(Long userId, String style, Long regionId, LocalDate to) {
		if(userId != null) {
			if(regionId != null) {
				if(style != null) {
					return beerRepository.findByUserIdAndStyleAndRegion_RegionIdAndDateBefore(userId, style, regionId, to);
				} else {
					return beerRepository.findByUserIdAndRegion_RegionIdAndDateBefore(userId, regionId, to);
				}
			} else {
				if(style!= null) {
					return beerRepository.findByUserIdAndStyleAndDateBefore(userId, style, to);
				} else {
					return beerRepository.findByUserIdAndDateBefore(userId, to);
				}
			}
		} else if (regionId!= null) {
			if(style!= null) {
				return beerRepository.findByRegion_regionIdAndStyleAndDateBefore(regionId, style, to);
			} else {
				return beerRepository.findByRegion_RegionIdAndDateBefore(regionId, to);
			}
		} else if(style!= null) {
			return beerRepository.findByStyleAndDateBefore(style, to);
		}
		return beerRepository.findByDateBefore(to);
	}

	private Iterable<Beer> withoutDates(Long userId, Long regionId, String style) {
		List<String> ignorePaths = new LinkedList<>();
		ignorePaths.add("beerId");
		ignorePaths.add("abv");
		ignorePaths.add("blg");
		ignorePaths.add("ibu");
		ignorePaths.add("price");
		ignorePaths.add("left");

		Beer beerExample = new Beer();

		if(userId != null) {
			beerExample.setUserId(userId);
		} else {
			ignorePaths.add("userId");
		}

		if(regionId != null) {
			beerExample.getRegion().setRegionId(regionId);
		} else {
			ignorePaths.add("region.regionId");
		}

		if(style != null) {
			beerExample.setStyle(style);
		}

		String[] ar = ignorePaths.toArray(new String[0]);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withIgnoreNullValues().withIgnorePaths(ar);
		return beerRepository.findAll(Example.of(beerExample, exampleMatcher));
	}

	public void remove(long beerId) throws IllegalArgumentException {
		if(beerRepository.existsById(beerId)) {
			beerRepository.deleteById(beerId);
		} else {
			throw new IllegalArgumentException("no beer with given id " + beerId);
		}
	}

	// =================================================================================================================
	//  UTILS
	// =================================================================================================================

	private static LocalDate unwrap(String date) throws IllegalArgumentException {
		try {
			return LocalDate.parse(date, formatter);
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("Wrong format for beer production date");
		}
	}

}
