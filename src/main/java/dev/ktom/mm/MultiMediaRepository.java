package dev.ktom.mm;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MultiMediaRepository extends MongoRepository<Cd, String>{

	public Cd findCdByTitleIgnoreCase(String title);
	public List<Cd> findAllCdsByArtistIgnoreCase(String artist);
	public List<Cd> findAllCdsByYearIgnoreCase(String year);
	public void deleteCdByArtistAndTitleIgnoreCase(String artist, String title);
}
