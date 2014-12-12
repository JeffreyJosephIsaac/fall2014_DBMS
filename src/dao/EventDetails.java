package dao;

import dto.Concert;
import dto.Event;
import dto.Game;
import dto.Hosted;
import dto.Movie;
import dto.Venue;

public class EventDetails {

	Event event;
	Movie movie;
	Concert concert;
	Game game;
	Hosted hosted;
	Venue venue;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Concert getConcert() {
		return concert;
	}

	public void setConcert(Concert concert) {
		this.concert = concert;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Hosted getHosted() {
		return hosted;
	}

	public void setHosted(Hosted hosted) {
		this.hosted = hosted;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	
}
