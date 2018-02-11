package edu.txstate.internet.cyberflix.data.film;

import java.util.ArrayList;
import java.util.List;
import edu.txstate.internet.cyberflix.data.actor.Actor;

public class Film {
	public enum FilmRating {
		G, PG, PG_13, R, NC_17, X, UR
	}

	private int filmID;
	private String title;
	private String description;
	private String releaseYear;
	private String category;
	private int length;
	private FilmRating rating;
	private List<Actor> actors;
	private String poster;

	public Film(int filmID, String title, String description, String releaseYear, int length, FilmRating rating,
			String poster) { //
		super();
		this.filmID = filmID;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.length = length;
		this.rating = rating;
		this.category = category;
		this.actors = new ArrayList<Actor>();
		this.poster = poster;
	}

	public String getPoster() {
		return poster;
	}

	public void addActor(Actor anActor) {
		if (!actors.contains(anActor))
			actors.add(anActor);
	}

	public List<Actor> getActors() {
		return actors;
	}

	public String getDescription() {
		return description;
	}

	public int getFilmID() {
		return filmID;
	}

	public int getLength() {
		return length;
	}

	public FilmRating getRating() {
		return rating;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setRating(FilmRating rating) {
		this.rating = rating;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Film [filmID=" + filmID + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", length=" + length + ", rating=" + rating + ", category=" + category + "]";
	}
}
