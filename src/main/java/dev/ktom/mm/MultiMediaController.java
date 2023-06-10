package dev.ktom.mm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MultiMediaController {
	
	@Autowired
	private MultiMediaService multiMediaService;
	
	@RequestMapping("/cds")
	public List<Cd> getAllCds() {
		return multiMediaService.getAllCds();
	}
	
	@RequestMapping("/cds/{artist}/{title}")
	public Cd getCd(@PathVariable String title) {
		return multiMediaService.getCd(title);
	}
	
	@RequestMapping("/cds/{artist}")
	public List<Cd> getAllCdsByArtist(@PathVariable String artist) {
		return multiMediaService.getAllCdsByArtist(artist);
	}
	
	@RequestMapping("/cds/all/{year}")
	public List<Cd> getAllCdsByYear(@PathVariable String year) {
		return multiMediaService.getAllCdsByYear(year);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cds")
	public void addCd(@RequestBody Map<String, Object> payload) {
		
		String tracksAString = payload.get("tracks").toString();
		tracksAString = tracksAString.replaceAll("\\[|\\]", "");
		String[] arrayOfTracks = tracksAString.split(",");
		
		List<String> listOfTracks = Arrays.asList(arrayOfTracks);
		
		multiMediaService.addCd(new Cd(payload.get("artist").toString(), 
				                       payload.get("title").toString(),
				                       payload.get("year").toString(), 
				                       payload.get("genre").toString(),
				                       listOfTracks));
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/cds/{artist}/{title}")
	public void updateCd(@RequestBody Map<String, Object> payload) {
		
		String tracksAString = payload.get("tracks").toString();
		tracksAString = tracksAString.replaceAll("\\[|\\]", "");
		System.out.println(tracksAString);
		String[] arrayOfTracks = tracksAString.split(",");
		
		List<String> listOfTracks = Arrays.asList(arrayOfTracks);
		
		multiMediaService.updateCd(new Cd(payload.get("artist").toString(), 
				                       payload.get("title").toString(),
				                       payload.get("year").toString(), 
				                       payload.get("genre").toString(),
				                       listOfTracks));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/cds/{artist}/{title}")
	public void deleteCd(@PathVariable String artist, @PathVariable String title) {
		multiMediaService.deleteCd(artist, title);
	}

}
