package pl.pw.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {

	private final RegionRepository regionRepository;

	@Autowired
	public RegionService(RegionRepository regionRepository) {
		this.regionRepository = regionRepository;
	}

	public Iterable<Region> getRegions() {
		return regionRepository.findAll();
	}
}
