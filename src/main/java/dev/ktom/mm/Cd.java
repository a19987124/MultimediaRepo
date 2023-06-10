package dev.ktom.mm;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="cds")
public class Cd {

	private String artist;
	private String title;
	private String year;
	private String genre;
	private List<String> tracks;

	
	public Cd(String artist, String title, String year, String genre, List<String> tracks) {
		super();
		this.artist = artist;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.tracks = tracks;
	}

	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public List<String> getTracks() {
		return tracks;
	}
	
	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}
}
