package dev.ktom.mm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MultiMediaService {
	
	@Autowired
	private MultiMediaRepository multiMediaRepository;

	
	public List<Cd> getAllCds() {
		return multiMediaRepository.findAll();
	}
	
	public Cd getCd(String title) {
		return multiMediaRepository.findCdByTitleIgnoreCase(title);
	}
	
	public List<Cd> getAllCdsByArtist(String artist) {
		return multiMediaRepository.findAllCdsByArtistIgnoreCase(artist);
	}
	
	public List<Cd> getAllCdsByYear(String year) {
		return multiMediaRepository.findAllCdsByYearIgnoreCase(year);
	}
	
	public void addCd(Cd cd) {
		multiMediaRepository.insert(cd);
	}
	
	public void updateCd(Cd cd) {
		multiMediaRepository.insert(cd);
	}
	
	public void deleteCd(String artist, String title) {
		multiMediaRepository.deleteCdByArtistAndTitleIgnoreCase(artist, title);
	}
}
