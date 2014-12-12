package model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import dao.Database;
import dao.Project;
import dto.BookingTransaction;
import dto.ConcertEvent;
import dto.Event_Organizer;
import dto.FeedObjects;
import dto.GameEvent;
import dto.Hosted;
import dto.MovieEvent;
import dto.Transactions;
import dto.User;
import dto.Venue;

public class ProjectManager {
	
	private static Connection dbConnection;
	
	private static Connection getDBConnection() throws Exception {
		try {
			Database database= new Database();
			if(dbConnection == null)
				dbConnection = database.Get_Connection();
			
			return dbConnection;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public ArrayList<FeedObjects> GetFeeds() throws Exception {
		ArrayList<FeedObjects> feeds = null;
		try {
			Project project = new Project();
			feeds = project.GetFeeds(getDBConnection());
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
	
	public ArrayList<MovieEvent> getMovies(){
		ArrayList<MovieEvent> movies = null;
		try {
			movies = Project.getMovies(getDBConnection());
			return movies;
		} catch (Exception e) {
			e.printStackTrace();
			return movies;
		}
	}
	
	public ArrayList<ConcertEvent> getConcerts(){
		ArrayList<ConcertEvent> concerts = null;
		try {
			concerts = Project.getConcerts(getDBConnection());
			return concerts;
		} catch (Exception e) {
			e.printStackTrace();
			return concerts;
		}
	}
	
	public ArrayList<GameEvent> getGames(){
		ArrayList<GameEvent> games = null;
		try {
			games = Project.getGames(getDBConnection());
			return games;
		} catch (Exception e) {
			e.printStackTrace();
			return games;
		}
	}
	
	public ArrayList<Venue> getVenues(){
		ArrayList<Venue> venues = null;
		try {
			venues = Project.getVenues(getDBConnection());
			return venues;
		} catch (Exception e) {
			e.printStackTrace();
			return venues;
		}
	}
	
	public void updateConcert(ConcertEvent concertEvent) {

		try {
			Connection connection = getDBConnection();
			Project project = new Project();
			// movieEventCreated = project.createMovie(connection, movieEvent);
			project.updateConcert(connection, concertEvent);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public ArrayList<MovieEvent> getMovieEvents(String userId) throws Exception {
		ArrayList<MovieEvent> movieEvents = null;
		
		try {
			Connection connection = getDBConnection();
			Project project= new Project();
			movieEvents = project.getMovieEvents(connection, userId);
		}
		catch (Exception e) {
			throw e;
		}
		return movieEvents;
	}
	
	public ArrayList<ConcertEvent> getConcertEvents(String userId) throws Exception {
		ArrayList<ConcertEvent> concertEvents = null;
		
		try {
			Connection connection = getDBConnection();
			Project project= new Project();
			concertEvents = project.getConcertEvents(connection, userId);
		}
		catch (Exception e) {
			throw e;
		}
		return concertEvents;
	}
	
	public ArrayList<GameEvent> getGameEvents(String userId) throws Exception {
		ArrayList<GameEvent> gameEvents = null;
		
		try {
			Connection connection = getDBConnection();
			Project project= new Project();
			gameEvents = project.getGameEvents(connection, userId);
		}
		catch (Exception e) {
			throw e;
		}
		return gameEvents;
	}
	
	public MovieEvent createMovie(MovieEvent movieEvent, Hosted hostedMovieEvent) throws Exception {
		MovieEvent movieEventCreated = null;
		
		try {
			Connection connection = getDBConnection();
			Project project= new Project();
			//movieEventCreated = project.createMovie(connection, movieEvent);
			project.createMovie(connection, movieEvent, hostedMovieEvent);
		}
		catch (Exception e) {
			throw e;
		}
		return movieEventCreated;
	}
	
	public ConcertEvent createConcert(ConcertEvent concertEvent, Hosted hostedMovieEvent) throws Exception {
		ConcertEvent concertEventCreated = null;
		
		try {
			Connection connection = getDBConnection();
			Project project= new Project();
			//concertEventCreated = project.createConcert(connection, concertEvent);
			project.createConcert(connection, concertEvent, hostedMovieEvent);
		}
		catch (Exception e) {
			throw e;
		}
		return concertEventCreated;
	}
	
	public GameEvent createGame(GameEvent gameEvent, Hosted hostedMovieEvent) throws Exception {
		GameEvent gameEventCreated = null;
		
		try {
			Connection connection = getDBConnection();
			Project project= new Project();
			//gameEventCreated = project.createGame(connection, gameEvent);
			project.createGame(connection, gameEvent, hostedMovieEvent);
		}
		catch (Exception e) {
			throw e;
		}
		return gameEventCreated;
	}
	
	public void createOrganizer(Event_Organizer eventOrganizer) throws Exception {
		
		try {
			Connection connection = getDBConnection();
			Project project= new Project();
			project.createOrganizer(connection, eventOrganizer);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Transactions> GetTransactions()throws Exception {
		ArrayList<Transactions> transactions = null;
		try {
		Project project = new Project();
		transactions = project.GetTransactions(getDBConnection());
		}
		catch (Exception e) {
		throw e;
		}
		return transactions;
	}
	
	public int DeleteEvent(int event_id)throws Exception {
		System.out.println("In Project Manager Delete Event");
		int result = 0;
		try {
		Project project = new Project();
		result = project.deleteEvent(getDBConnection(),event_id);
		}
		catch (Exception e) {
		throw e;
		}
		return result;
	}
	
	public int DeleteBookings(int booking_id)throws Exception {
		System.out.println(" In Project Manager Delete Booking");
		int result = 0;
		try {
		Project project = new Project();
		result = project.deleteBookings(getDBConnection(),booking_id);
		}
		catch (Exception e) {
		throw e;
		}
		return result;
	}
	
	public int createBookings(BookingTransaction bookingTransaction) throws Exception {
		System.out.println(" In Project Manager CREATE Booking");
		int result = 0;
		try {
		Project project = new Project();
		result = project.createBookings(getDBConnection(),bookingTransaction);
		}
		catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	public User authenticateUser(String username, String pwd) throws Exception {
		User user = new User();
		try {
			Project project = new Project();
			user = project.authenticateUser(getDBConnection(), username, pwd);
		} catch (Exception e) {
			throw e;
		}

		return user;
	}

	public HashMap<String, ArrayList> getBookings(String username)
			throws Exception {
		HashMap<String, ArrayList> bookingsList = null;

		try {
			Project project = new Project();
			bookingsList = project.getBookings(getDBConnection(), username);
		} catch (Exception e) {
			throw e;
		}

		return bookingsList;
	}

	public HashMap<String, ArrayList> getAllBookings() throws Exception {
		HashMap<String, ArrayList> bookingsList = null;

		try {
			Project project = new Project();
			bookingsList = project.getAllBookings(getDBConnection());
		} catch (Exception e) {
			throw e;
		}

		return bookingsList;
	}

	public void updateMovie(MovieEvent movieEvent) throws Exception {

		try {
			Connection connection = getDBConnection();
			Project project = new Project();
			// movieEventCreated = project.createMovie(connection, movieEvent);
			project.updateMovie(connection, movieEvent);
		} catch (Exception e) {
			throw e;
		}
	}

	public void updateGame(GameEvent gameEvent) throws Exception {

		try {
			Connection connection = getDBConnection();
			Project project = new Project();
			// movieEventCreated = project.createMovie(connection, movieEvent);
			project.updateGame(connection, gameEvent);
		} catch (Exception e) {
			throw e;
		}
	}

}
