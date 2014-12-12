package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.mysql.jdbc.Statement;

import dto.BookingTransaction;
import dto.Concert;
import dto.ConcertBookings;
import dto.ConcertEvent;
import dto.Event;
import dto.Event_Organizer;
import dto.FeedObjects;
import dto.Game;
import dto.GameBookings;
import dto.GameEvent;
import dto.Hosted;
import dto.Movie;
import dto.MovieBookings;
import dto.MovieEvent;
import dto.Transactions;
import dto.User;
import dto.Venue;

public class Project {
	
	public ArrayList<FeedObjects> GetFeeds(Connection connection) throws Exception
	{
		ArrayList<FeedObjects> feedData = new ArrayList<FeedObjects>();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM website ORDER BY id DESC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FeedObjects feedObject = new FeedObjects();
				feedObject.setId(rs.getInt("id"));
				feedObject.setTitle(rs.getString("title"));
				feedObject.setDescription(rs.getString("description"));
				feedObject.setUrl(rs.getString("url"));
				feedData.add(feedObject);
			}
			return feedData;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static ArrayList<MovieEvent> getMovies(Connection connection){
		//ArrayList<EventDetails> eventDetails = new ArrayList<EventDetails>();
		ArrayList<MovieEvent> movieEvents = new ArrayList<MovieEvent>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM movie M, event E, hosted H, venue V WHERE "
					 + "M.event_id = E.event_id AND E.event_id = H.event_id AND H.venue_id = V.venue_id ORDER BY M.movie_id DESC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				/*Movie movie = new Movie();
				movie.setMovie_id(rs.getInt("M.movie_id"));
				movie.setMovie_name(rs.getString("M.movie_name"));
				movie.setCast(rs.getString("M.cast"));
				movie.setRelease_date(rs.getString("M.release_date"));
				movie.setRating(rs.getInt("M.rating"));
				movie.setEvent_id(rs.getInt("M.event_id"));
				
				Event event = new Event();
				event.setEvent_id(rs.getInt("E.event_id"));
				event.setLanguage(rs.getString("E.language"));
				event.setTicket_cost(rs.getFloat("E.ticket_cost"));
				event.setUsername(rs.getString("E.username"));
				
				Hosted hosted = new Hosted();
				hosted.setHosted_id(rs.getInt("H.hosted_id"));
				hosted.setHosted_date(rs.getString("H.hosted_date"));
				hosted.setStart_time(rs.getString("H.start_time"));
				hosted.setEnd_time(rs.getString("H.end_time"));
				hosted.setVenue_id(rs.getInt("H.venue_id"));
				hosted.setEvent_id(rs.getInt("H.event_id"));
				
				Venue venue = new Venue();
				venue.setVenue_id(rs.getInt("V.venue_id"));
				venue.setSeating_capacity(rs.getInt("V.seating_capacity"));
				venue.setContact_number(rs.getLong("V.contact_number"));
				venue.setAddress(rs.getString("V.address"));
				venue.setName(rs.getString("V.name"));
				
				EventDetails eventDetail = new EventDetails();
				eventDetail.setMovie(movie);
				eventDetail.setEvent(event);
				eventDetail.setHosted(hosted);
				eventDetail.setVenue(venue);
				
				eventDetails.add(eventDetail);*/
				
				MovieEvent event = new MovieEvent();
				event.setEvent_id(rs.getInt("E.event_id"));
				event.setLanguage(rs.getString("E.language"));
				event.setTicket_cost(rs.getFloat("E.ticket_cost"));
				event.setUsername(rs.getString("E.username"));
				event.setMovie_id(rs.getInt("M.movie_id"));
				event.setMovie_name(rs.getString("M.movie_name"));
				event.setCast(rs.getString("M.cast"));
				event.setRelease_date(rs.getString("M.release_date"));
				event.setRating(rs.getInt("M.rating"));
				event.setHosted_id(rs.getInt("H.hosted_id"));
				event.setHosted_date(rs.getString("H.hosted_date"));
				event.setVenue_id(rs.getInt("V.venue_id"));
				event.setStart_time(rs.getString("H.start_time"));
				event.setEnd_time(rs.getString("H.end_time"));
				
				movieEvents.add(event);
			}
			return movieEvents;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return movieEvents;
		}
	}
	
	public static ArrayList<ConcertEvent> getConcerts(Connection connection){
		ArrayList<ConcertEvent> concertEvents = new ArrayList<ConcertEvent>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM concert C, event E, hosted H, venue V WHERE "
					 + "C.event_id = E.event_id AND E.event_id = H.event_id AND H.venue_id = V.venue_id ORDER BY C.concert_id DESC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				/*Concert concert = new Concert();
				concert.setConcert_id(rs.getInt("C.concert_id"));
				concert.setArtist(rs.getString("C.artist"));
				concert.setType(rs.getString("C.type"));
				concert.setEvent_id(rs.getInt("C.event_id"));
				
				Event event = new Event();
				event.setEvent_id(rs.getInt("E.event_id"));
				event.setLanguage(rs.getString("E.language"));
				event.setTicket_cost(rs.getFloat("E.ticket_cost"));
				event.setUsername(rs.getString("E.username"));
				
				Hosted hosted = new Hosted();
				hosted.setHosted_id(rs.getInt("H.hosted_id"));
				hosted.setHosted_date(rs.getString("H.hosted_date"));
				hosted.setStart_time(rs.getString("H.start_time"));
				hosted.setEnd_time(rs.getString("H.end_time"));
				hosted.setVenue_id(rs.getInt("H.venue_id"));
				hosted.setEvent_id(rs.getInt("H.event_id"));
				
				Venue venue = new Venue();
				venue.setVenue_id(rs.getInt("V.venue_id"));
				venue.setSeating_capacity(rs.getInt("V.seating_capacity"));
				venue.setContact_number(rs.getLong("V.contact_number"));
				venue.setAddress(rs.getString("V.address"));
				venue.setName(rs.getString("V.name"));
				
				EventDetails eventDetail = new EventDetails();
				eventDetail.setConcert(concert);
				eventDetail.setEvent(event);
				eventDetail.setHosted(hosted);
				eventDetail.setVenue(venue);
				
				eventDetails.add(eventDetail);*/
				
				ConcertEvent event = new ConcertEvent();
				event.setEvent_id(rs.getInt("E.event_id"));
				event.setLanguage(rs.getString("E.language"));
				event.setTicket_cost(rs.getFloat("E.ticket_cost"));
				event.setUsername(rs.getString("E.username"));
				event.setConcert_id(rs.getInt("C.concert_id"));
				event.setArtist(rs.getString("C.artist"));
				event.setType(rs.getString("C.type"));
				event.setHosted_id(rs.getInt("H.hosted_id"));
				event.setHosted_date(rs.getString("H.hosted_date"));
				event.setVenue_id(rs.getInt("V.venue_id"));
				event.setStart_time(rs.getString("H.start_time"));
				event.setEnd_time(rs.getString("H.end_time"));
				
				concertEvents.add(event);
			}
			return concertEvents;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return concertEvents;
		}
	}
	
	public static ArrayList<GameEvent> getGames(Connection connection){
		ArrayList<GameEvent> gameEvents = new ArrayList<GameEvent>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM game G, event E, hosted H, venue V WHERE "
					 + "G.event_id = E.event_id AND E.event_id = H.event_id AND H.venue_id = V.venue_id ORDER BY G.game_id DESC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				/*Game game = new Game();
				game.setGame_id(rs.getInt("G.game_id"));
				game.setGame_name(rs.getString("G.game_name"));
				game.setTeams(rs.getString("G.teams"));
				game.setEvent_id(rs.getInt("G.event_id"));
				
				Event event = new Event();
				event.setEvent_id(rs.getInt("E.event_id"));
				event.setLanguage(rs.getString("E.language"));
				event.setTicket_cost(rs.getFloat("E.ticket_cost"));
				event.setUsername(rs.getString("E.username"));
				
				Hosted hosted = new Hosted();
				hosted.setHosted_id(rs.getInt("H.hosted_id"));
				hosted.setHosted_date(rs.getString("H.hosted_date"));
				hosted.setStart_time(rs.getString("H.start_time"));
				hosted.setEnd_time(rs.getString("H.end_time"));
				hosted.setVenue_id(rs.getInt("H.venue_id"));
				hosted.setEvent_id(rs.getInt("H.event_id"));
				
				Venue venue = new Venue();
				venue.setVenue_id(rs.getInt("V.venue_id"));
				venue.setSeating_capacity(rs.getInt("V.seating_capacity"));
				venue.setContact_number(rs.getLong("V.contact_number"));
				venue.setAddress(rs.getString("V.address"));
				venue.setName(rs.getString("V.name"));
				
				EventDetails eventDetail = new EventDetails();
				eventDetail.setGame(game);
				eventDetail.setEvent(event);
				eventDetail.setHosted(hosted);
				eventDetail.setVenue(venue);
				
				eventDetails.add(eventDetail);*/
				
				GameEvent event = new GameEvent();
				event.setEvent_id(rs.getInt("E.event_id"));
				event.setLanguage(rs.getString("E.language"));
				event.setTicket_cost(rs.getFloat("E.ticket_cost"));
				event.setUsername(rs.getString("E.username"));
				event.setGame_id(rs.getInt("G.game_id"));
				event.setGame_name(rs.getString("G.game_name"));
				event.setTeams(rs.getString("G.teams"));
				event.setHosted_id(rs.getInt("H.hosted_id"));
				event.setHosted_date(rs.getString("H.hosted_date"));
				event.setVenue_id(rs.getInt("V.venue_id"));
				event.setStart_time(rs.getString("H.start_time"));
				event.setEnd_time(rs.getString("H.end_time"));
				
				gameEvents.add(event);
			}
			return gameEvents;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return gameEvents;
		}
	}
	
	public static ArrayList<Venue> getVenues(Connection connection){
		ArrayList<Venue> venues = new ArrayList<Venue>();
		try{
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM venue");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Venue venue = new Venue();
				venue.setVenue_id(rs.getInt("venue_id"));
				venue.setName(rs.getString("name"));
				venue.setAddress(rs.getString("address"));
				venue.setSeating_capacity(rs.getInt("seating_capacity"));
				venue.setContact_number(rs.getLong("contact_number"));
				
				venues.add(venue);
			}
			return venues;
		}
		catch(Exception e){
			e.printStackTrace();
			return venues;
		}
	}
	
	public void updateConcert(Connection connection, ConcertEvent concertEvent) {

		try {

			String query = "UPDATE event SET language='"
					+ concertEvent.getLanguage() + "' , ticket_cost="
					+ concertEvent.getTicket_cost() + " WHERE event_id="
					+ concertEvent.getEvent_id();
			PreparedStatement ps1 = connection.prepareStatement(query);
			System.out.println("query fired = " + ps1.toString());

			int affectedRows1 = ps1.executeUpdate();

			if (affectedRows1 == 0) {
				throw new SQLException("Update Event failed, no rows affected.");
			}

			String query2 = "UPDATE concert SET artist='"
					+ concertEvent.getArtist() + "' , type='"
					+ concertEvent.getType() + "' WHERE concert_id="
					+ concertEvent.getConcert_id();
			PreparedStatement ps2 = connection.prepareStatement(query2);
			System.out.println("query fired = " + ps2.toString());

			int affectedRows2 = ps2.executeUpdate();

			if (affectedRows2 == 0) {
				throw new SQLException("Update Concert failed, no rows affected.");
			}

		} catch (Exception e) {
			e.printStackTrace();;
		}
	}
	
	public ArrayList<MovieEvent> getMovieEvents(Connection connection, String userId) throws Exception
	{
		ArrayList<MovieEvent> movieEvents = new ArrayList<MovieEvent>();
		try {
			String query = "SELECT E.event_id, language, ticket_cost, movie_id, movie_name, cast, release_date, rating, hosted_id, hosted_date, venue_id, start_time, end_time FROM event E JOIN movie M ON E.event_id=M.event_id JOIN hosted H ON E.event_id=H.event_id WHERE E.username='" + userId + "'";
			//String query = "SELECT E.event_id, language, ticket_cost, movie_id, movie_name, cast, release_date, rating FROM event E JOIN movie M ON E.event_id=M.event_id WHERE E.username='" + userId + "'";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MovieEvent movieEvent = new MovieEvent();
				movieEvent.setEvent_id(rs.getInt("event_id"));
				movieEvent.setLanguage(rs.getString("language"));
				movieEvent.setTicket_cost(rs.getFloat("ticket_cost"));
				movieEvent.setMovie_id(rs.getInt("movie_id"));
				movieEvent.setMovie_name(rs.getString("movie_name"));
				movieEvent.setCast(rs.getString("cast"));
				movieEvent.setRelease_date(rs.getString("release_date"));
				movieEvent.setRating(rs.getInt("rating"));
				movieEvent.setHosted_id(rs.getInt("hosted_id"));
				movieEvent.setHosted_date(rs.getString("hosted_date"));
				movieEvent.setVenue_id(rs.getInt("venue_id"));
				movieEvent.setStart_time(rs.getString("start_time"));
				movieEvent.setEnd_time(rs.getString("end_time"));
				System.out.println("Hostedid: " + rs.getInt("hosted_id"));
				System.out.println("hosted_date: " + rs.getInt("hosted_date"));
				System.out.println("venue_id: " + rs.getInt("venue_id"));
				System.out.println("start_time: " + rs.getInt("start_time"));
				System.out.println("end_time: " + rs.getInt("end_time"));
				
				
				movieEvents.add(movieEvent);
			}
			
			return movieEvents;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public ArrayList<ConcertEvent> getConcertEvents(Connection connection, String userId) throws Exception
	{
		ArrayList<ConcertEvent> concertEvents = new ArrayList<ConcertEvent>();
		try {
			//String query = "SELECT E.event_id, language, ticket_cost, movie_id, movie_name, cast, release_date, rating FROM event E JOIN movie M ON E.event_id=M.event_id";
			String query = "SELECT E.event_id, language, ticket_cost, concert_id, artist, type, hosted_id, hosted_date, venue_id, start_time, end_time FROM event E JOIN concert C ON E.event_id=C.event_id JOIN hosted H ON E.event_id=H.event_id WHERE E.username='" + userId + "'";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ConcertEvent concertEvent = new ConcertEvent();
				concertEvent.setEvent_id(rs.getInt("event_id"));
				concertEvent.setLanguage(rs.getString("language"));
				concertEvent.setTicket_cost(rs.getFloat("ticket_cost"));
				concertEvent.setConcert_id(rs.getInt("concert_id"));
				concertEvent.setArtist(rs.getString("artist"));
				concertEvent.setType(rs.getString("type"));
				concertEvent.setHosted_id(rs.getInt("hosted_id"));
				concertEvent.setHosted_date(rs.getString("hosted_date"));
				concertEvent.setVenue_id(rs.getInt("venue_id"));
				concertEvent.setStart_time(rs.getString("start_time"));
				concertEvent.setEnd_time(rs.getString("end_time"));
				concertEvents.add(concertEvent);
			}
			
			return concertEvents;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public ArrayList<GameEvent> getGameEvents(Connection connection, String userId) throws Exception
	{
		ArrayList<GameEvent> gameEvents = new ArrayList<GameEvent>();
		try {
			//String query = "SELECT E.event_id, language, ticket_cost, movie_id, movie_name, cast, release_date, rating FROM event E JOIN movie M ON E.event_id=M.event_id";
			String query = "SELECT E.event_id, language, ticket_cost, game_id, game_name, teams, hosted_id, hosted_date, venue_id, start_time, end_time FROM event E JOIN game G ON E.event_id=G.event_id JOIN hosted H ON E.event_id=H.event_id WHERE E.username='" + userId + "'";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				GameEvent gameEvent = new GameEvent();
				gameEvent.setEvent_id(rs.getInt("event_id"));
				gameEvent.setLanguage(rs.getString("language"));
				gameEvent.setTicket_cost(rs.getFloat("ticket_cost"));
				gameEvent.setGame_id(rs.getInt("game_id"));
				gameEvent.setGame_name(rs.getString("game_name"));
				gameEvent.setTeams(rs.getString("teams"));
				gameEvent.setHosted_id(rs.getInt("hosted_id"));
				gameEvent.setHosted_date(rs.getString("hosted_date"));
				gameEvent.setVenue_id(rs.getInt("venue_id"));
				gameEvent.setStart_time(rs.getString("start_time"));
				gameEvent.setEnd_time(rs.getString("end_time"));
				
				gameEvents.add(gameEvent);
			}
			
			return gameEvents;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void createMovie(Connection connection, MovieEvent movieEvent, Hosted hostedMovieEvent) throws Exception {
		
	    try {
	    	String query = "INSERT INTO event (language, ticket_cost, username) VALUES ('" + movieEvent.getLanguage() + "', " + movieEvent.getTicket_cost() + ", '" + movieEvent.getUsername() + "')";
	        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        int affectedRows = statement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating Movie failed, no rows affected.");
	        }

	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        try {
	            if (generatedKeys.next()) {
	            	System.out.println("Event Key generated: " + generatedKeys.getInt(1));
	            	String query2 = "INSERT INTO movie (movie_name, cast, release_date, rating, event_id) VALUES ('" + movieEvent.getMovie_name() + "', '" + movieEvent.getCast() + "', '" + movieEvent.getRelease_date() + "', " + movieEvent.getRating() + ", " + generatedKeys.getInt(1) + ")";
	    	        PreparedStatement statement2 = connection.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
	    	        statement2.executeUpdate();
	    	        
	    	        // ADD THIS
	    	        String query3 = "INSERT INTO hosted (hosted_date, venue_id, event_id, start_time, end_time) VALUES ('" + hostedMovieEvent.getHosted_date() + "'," + hostedMovieEvent.getVenue_id() + ", " + generatedKeys.getInt(1) + ", '" + hostedMovieEvent.getStart_time() + "', '" + hostedMovieEvent.getEnd_time() + "')";
	    	        PreparedStatement statement3 = connection.prepareStatement(query3, Statement.RETURN_GENERATED_KEYS);
	    	        statement3.executeUpdate();
	    	        
	    	        
	            }
	            else {
	                throw new SQLException("Creating Movie failed, no ID obtained.");
	            }
	        }
	        finally{
	        	
	        }
	    } 
	    catch(Exception e) {
			throw e;
	    }
    }
	
	public void createConcert(Connection connection, ConcertEvent concertEvent, Hosted hostedMovieEvent) throws Exception {
		
	    try {
	    	String query = "INSERT INTO event (language, ticket_cost, username) VALUES ('" + concertEvent.getLanguage() + "', " + concertEvent.getTicket_cost() + ", '" + concertEvent.getUsername() + "')";
	        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        int affectedRows = statement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating Concert failed, no rows affected.");
	        }

	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        try {
	            if (generatedKeys.next()) {
	            	System.out.println("Event Key generated: " + generatedKeys.getInt(1));
	            	String query2 = "INSERT INTO concert (artist, type, event_id) VALUES ('" + concertEvent.getArtist() + "', '" + concertEvent.getType() + "', " + generatedKeys.getInt(1) + ")";
	    	        PreparedStatement statement2 = connection.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
	    	        
	    	        statement2.executeUpdate();
	    	        
	    	     // ADD THIS
    	        String query3 = "INSERT INTO hosted (hosted_date, venue_id, event_id, start_time, end_time) VALUES ('" + hostedMovieEvent.getHosted_date() + "'," + hostedMovieEvent.getVenue_id() + ", " + generatedKeys.getInt(1) + ", '" + hostedMovieEvent.getStart_time() + "', '" + hostedMovieEvent.getEnd_time() + "')";
    	        PreparedStatement statement3 = connection.prepareStatement(query3, Statement.RETURN_GENERATED_KEYS);
    	        statement3.executeUpdate();
	            }
	            else {
	                throw new SQLException("Creating Concert failed, no ID obtained.");
	            }
	        }
	        finally{
	        	
	        }
	    } 
	    catch(Exception e) {
			throw e;
	    }
    }
	
	public void createGame(Connection connection, GameEvent gameEvent, Hosted hostedMovieEvent) throws Exception {
		
	    try {
	    	String query = "INSERT INTO event (language, ticket_cost, username) VALUES ('" + gameEvent.getLanguage() + "', " + gameEvent.getTicket_cost() + ", '" + gameEvent.getUsername() + "')";
	        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        int affectedRows = statement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating Game failed, no rows affected.");
	        }
	        
	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        try {
	        	
	            if (generatedKeys.next()) {
	            	System.out.println("Event Key generated: " + generatedKeys.getInt(1));
	            	String query2 = "INSERT INTO game (game_name, teams, event_id) VALUES ('" + gameEvent.getGame_name() + "', '" + gameEvent.getTeams() + "', " + generatedKeys.getInt(1) + ")";
	    	        PreparedStatement statement2 = connection.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
	    	        
	    	        statement2.executeUpdate();
	    	        
	    	     // ADD THIS
    	        String query3 = "INSERT INTO hosted (hosted_date, venue_id, event_id, start_time, end_time) VALUES ('" + hostedMovieEvent.getHosted_date() + "'," + hostedMovieEvent.getVenue_id() + ", " + generatedKeys.getInt(1) + ", '" + hostedMovieEvent.getStart_time() + "', '" + hostedMovieEvent.getEnd_time() + "')";
    	        PreparedStatement statement3 = connection.prepareStatement(query3, Statement.RETURN_GENERATED_KEYS);
    	        statement3.executeUpdate();
	            }
	            else {
	                throw new SQLException("Creating Game failed, no ID obtained.");
	            }
	        }
	        finally {
	        	generatedKeys.close();
	        }
	    } 
	    catch(Exception e) {
			throw e;
	    }
    }
	
public void createOrganizer(Connection connection, Event_Organizer eventOrganizer) throws Exception {
		
	    try {
	    	String query = "INSERT INTO event_organizer (username, password, name, email_id, company_name, created_by) VALUES ('" + eventOrganizer.getUsername() + "', '" + eventOrganizer.getPassword() + "', '" + eventOrganizer.getName() +"', '" + eventOrganizer.getEmail_id() + "', '" + eventOrganizer.getCompany_name() + "', '" + eventOrganizer.getCreated_by() + "')";
	        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        int affectedRows = statement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating Event Organizer failed, no rows affected.");
	        }

	    } 
	    catch(Exception e) {
			throw e;
	    }
    }

	public ArrayList<Transactions> GetTransactions(Connection connection) throws Exception
	{
		ArrayList<Transactions> transactionsData = new ArrayList<Transactions>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM transactions");
			ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Transactions transactions = new Transactions();
			transactions.setTransaction_id(rs.getInt("transaction_id"));
			transactions.setFrom_account(rs.getInt("from_account"));
			transactions.setFrom_bank(rs.getString("from_bank"));
			transactions.setTo_account(rs.getInt("to_account"));
			transactions.setTo_bank(rs.getString("to_bank"));
			transactions.setAmount(rs.getFloat("amount"));
			transactionsData.add(transactions);
		}
			return transactionsData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public int deleteEvent(Connection connection, int event_id) throws Exception {
		System.out.println(" In Project Delete Event");
		try
		{
			PreparedStatement ps = connection.prepareStatement("DELETE FROM event where event_id="+event_id);
			int result = ps.executeUpdate();
			return result;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public int deleteBookings(Connection connection, int booking_id) throws Exception {
		System.out.println(" In Project Delete Bookings");
		try
		{
			PreparedStatement ps = connection.prepareStatement("DELETE FROM bookings where booking_id="+booking_id);
			int result = ps.executeUpdate();
			System.out.println("Bookings entry Deleted Result:"+result);
			return result;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public int createBookings(Connection connection,
			BookingTransaction bookingTransaction) throws Exception {
		try {
			
			String query = "INSERT INTO transactions "
					+ "(from_account, from_bank, to_account, to_bank, amount) "
					+ "VALUES"
					+ "(" + bookingTransaction.getTransactions().getFrom_account() + ",'"
					+ bookingTransaction.getTransactions().getFrom_bank() + "',"
					+ bookingTransaction.getTransactions().getTo_account() + ",'"
					+ bookingTransaction.getTransactions().getTo_bank() + "',"
					+ bookingTransaction.getTransactions().getAmount() + ")";
					
			PreparedStatement statement = connection.prepareStatement(
					query, Statement.RETURN_GENERATED_KEYS);
			
	        int affectedRows = statement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating Transactions failed, no rows affected.");
	        }

	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        try {
	            if (generatedKeys.next()) {
	            	
	            	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	            	Date date = new Date();
	            	
	            	System.out.println("Transaction id generated: " + generatedKeys.getInt(1));
	            	String query2 = "INSERT INTO bookings"
	            			+ "(booking_datetime, no_of_tickets, username, transaction_id, event_id)"
	            			+ "VALUES ('" 
	            			+ dateFormat.format(date) + "',"
	            			+ bookingTransaction.getBookings().getNo_of_tickets() + ",'"
	            			+ bookingTransaction.getBookings().getUsername() + "',"
	            			+ generatedKeys.getInt(1) + ","
	            			+ bookingTransaction.getBookings().getEvent_id() + ")";
	            	
	    	        PreparedStatement statement2 = connection.prepareStatement(
	    	        		query2, Statement.RETURN_GENERATED_KEYS);
	    	        
	    	        int result = statement2.executeUpdate();
	    	        return result;
	            }
	            else {
	                throw new SQLException("Creating Bookings failed, no ID obtained.");
	            }
	        }
	        finally{
	        	
	        }
	    } 
	    catch(Exception e) {
			throw e;
	    }
	}
	
	public User authenticateUser(Connection connection, String username,
			String pwd) throws Exception {
		User user = new User();
		boolean isAuthenticUser = false;

		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM attendee where username = '"
							+ username + "' AND password = '" + pwd + "'");
			System.out.println("query fired = " + ps.toString());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				isAuthenticUser = true;
				user.setUsername(rs.getString("username"));
				user.setUserType("attendee");
			}

			ps = connection
					.prepareStatement("SELECT * FROM event_organizer where username = '"
							+ username + "' AND password = '" + pwd + "'");
			rs = ps.executeQuery();

			while (rs.next()) {
				isAuthenticUser = true;
				user.setUsername(rs.getString("username"));
				user.setUserType("event_organizer");
			}

			ps = connection
					.prepareStatement("SELECT * FROM system_admin where username = '"
							+ username + "' AND password = '" + pwd + "'");
			rs = ps.executeQuery();

			while (rs.next()) {
				isAuthenticUser = true;
				user.setUsername(rs.getString("username"));
				user.setUserType("system_admin");
			}
		} catch (Exception e) {
			throw e;
		}

		if (isAuthenticUser)
			return user;
		else
			return null;

	}

	public HashMap<String, ArrayList> getBookings(Connection connection, String username) throws SQLException
	{
		ArrayList<MovieBookings> movieBookingsList = new ArrayList<MovieBookings>();
		ArrayList<ConcertBookings> concertBookingsList = new ArrayList<ConcertBookings>();
		ArrayList<GameBookings> gameBookingsList = new ArrayList<GameBookings>();
		
		HashMap<String, ArrayList> bookingsLists = new HashMap<String, ArrayList>();

		try
		{
			PreparedStatement ps = connection.prepareStatement("select * from bookings B, event E, movie M, hosted H where B.event_id=E.event_id and E.event_id=M.event_id and E.event_id=H.event_id and B.username = '" + username + "'");
			System.out.println("query fired = " + ps.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				MovieBookings booking = new MovieBookings();
				booking.setBooking_id(rs.getInt("booking_id"));
				booking.setBooking_datetime(rs.getString("booking_datetime"));
				booking.setNo_of_tickets(rs.getInt("no_of_tickets"));
				booking.setUsername(username);
				booking.setTransaction_id(rs.getInt("transaction_id"));
				booking.setEvent_id(rs.getInt("event_id"));
				booking.setMovie_name(rs.getString("movie_name"));
								
				movieBookingsList.add(booking);
			}
			
			ps = connection.prepareStatement("select * from bookings B, event E, concert M, hosted H where B.event_id=E.event_id and E.event_id=M.event_id and E.event_id=H.event_id and B.username = '" + username + "'");
			System.out.println("query fired = " + ps.toString());
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				ConcertBookings booking = new ConcertBookings();
				booking.setBooking_id(rs.getInt("booking_id"));
				booking.setBooking_datetime(rs.getString("booking_datetime"));
				booking.setNo_of_tickets(rs.getInt("no_of_tickets"));
				booking.setUsername(username);
				booking.setTransaction_id(rs.getInt("transaction_id"));
				booking.setEvent_id(rs.getInt("event_id"));
				
				booking.setType(rs.getString("type"));
				booking.setArtist(rs.getString("artist"));
				
				concertBookingsList.add(booking);
			}
			
			ps = connection.prepareStatement("select * from bookings B, event E, game M, hosted H where B.event_id=E.event_id and E.event_id=M.event_id and E.event_id=H.event_id and B.username = '" + username + "'");
			System.out.println("query fired = " + ps.toString());
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				GameBookings booking = new GameBookings();
				booking.setBooking_id(rs.getInt("booking_id"));
				booking.setBooking_datetime(rs.getString("booking_datetime"));
				booking.setNo_of_tickets(rs.getInt("no_of_tickets"));
				booking.setUsername(username);
				booking.setTransaction_id(rs.getInt("transaction_id"));
				booking.setEvent_id(rs.getInt("event_id"));
				
				booking.setGame_name(rs.getString("game_name"));
				booking.setTeams(rs.getString("teams"));

				gameBookingsList.add(booking);
			}
			
			bookingsLists.put("Movies", movieBookingsList);
			bookingsLists.put("Concerts", concertBookingsList);
			bookingsLists.put("Games", gameBookingsList);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return bookingsLists;
		
	}
	
	public HashMap<String, ArrayList> getAllBookings(Connection connection) throws SQLException
	{
		ArrayList<MovieBookings> movieBookingsList = new ArrayList<MovieBookings>();
		ArrayList<ConcertBookings> concertBookingsList = new ArrayList<ConcertBookings>();
		ArrayList<GameBookings> gameBookingsList = new ArrayList<GameBookings>();
		
		HashMap<String, ArrayList> bookingsLists = new HashMap<String, ArrayList>();

		try
		{
			PreparedStatement ps = connection.prepareStatement("select * from bookings B, event E, movie M, hosted H where B.event_id=E.event_id and E.event_id=M.event_id and E.event_id=H.event_id");
			System.out.println("query fired = " + ps.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				MovieBookings booking = new MovieBookings();
				booking.setBooking_id(rs.getInt("booking_id"));
				booking.setBooking_datetime(rs.getString("booking_datetime"));
				booking.setNo_of_tickets(rs.getInt("no_of_tickets"));
				booking.setUsername(rs.getString("username"));
				booking.setTransaction_id(rs.getInt("transaction_id"));
				booking.setEvent_id(rs.getInt("event_id"));
				
				booking.setMovie_name(rs.getString("movie_name"));
								
				movieBookingsList.add(booking);
			}
			
			ps = connection.prepareStatement("select * from bookings B, event E, concert M, hosted H where B.event_id=E.event_id and E.event_id=M.event_id and E.event_id=H.event_id");
			System.out.println("query fired = " + ps.toString());
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				ConcertBookings booking = new ConcertBookings();
				booking.setBooking_id(rs.getInt("booking_id"));
				booking.setBooking_datetime(rs.getString("booking_datetime"));
				booking.setNo_of_tickets(rs.getInt("no_of_tickets"));
				booking.setUsername(rs.getString("username"));
				booking.setTransaction_id(rs.getInt("transaction_id"));
				booking.setEvent_id(rs.getInt("event_id"));
				
				booking.setType(rs.getString("type"));
				booking.setArtist(rs.getString("artist"));
				
				concertBookingsList.add(booking);
			}
			
			ps = connection.prepareStatement("select * from bookings B, event E, game M, hosted H where B.event_id=E.event_id and E.event_id=M.event_id and E.event_id=H.event_id");
			System.out.println("query fired = " + ps.toString());
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				GameBookings booking = new GameBookings();
				booking.setBooking_id(rs.getInt("booking_id"));
				booking.setBooking_datetime(rs.getString("booking_datetime"));
				booking.setNo_of_tickets(rs.getInt("no_of_tickets"));
				booking.setUsername(rs.getString("username"));
				booking.setTransaction_id(rs.getInt("transaction_id"));
				booking.setEvent_id(rs.getInt("event_id"));
				
				booking.setGame_name(rs.getString("game_name"));
				booking.setTeams(rs.getString("teams"));

				gameBookingsList.add(booking);
			}
			
			bookingsLists.put("Movies", movieBookingsList);
			bookingsLists.put("Concerts", concertBookingsList);
			bookingsLists.put("Games", gameBookingsList);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return bookingsLists;
		
	}

	public void updateMovie(Connection connection, MovieEvent movieEvent)
			throws Exception {

		try {
			String query = "UPDATE event SET language='"
					+ movieEvent.getLanguage() + "' , ticket_cost="
					+ movieEvent.getTicket_cost() + " WHERE event_id="
					+ movieEvent.getEvent_id();
			PreparedStatement ps1 = connection.prepareStatement(query);
			System.out.println("query fired = " + ps1.toString());

			int affectedRows1 = ps1.executeUpdate();

			if (affectedRows1 == 0) {
				throw new SQLException("Update Event failed, no rows affected.");
			}

			String query2 = "UPDATE movie SET movie_name='"
					+ movieEvent.getMovie_name() + "' , cast='"
					+ movieEvent.getCast() + "' , release_date='"
					+ movieEvent.getRelease_date() + "' , rating="
					+ movieEvent.getRating() + " WHERE movie_id="
					+ movieEvent.getMovie_id();
			PreparedStatement ps2 = connection.prepareStatement(query2);
			System.out.println("query fired = " + ps2.toString());

			int affectedRows2 = ps2.executeUpdate();

			if (affectedRows2 == 0) {
				throw new SQLException("Update Movie failed, no rows affected.");
			}

		} catch (Exception e) {
			throw e;
		}

	}

	public void updateGame(Connection connection, GameEvent gameEvent)
			throws Exception {

		try {
			String query = "UPDATE event SET language=? , ticket_cost=? WHERE event_id=?";
			PreparedStatement ps1 = connection.prepareStatement(query);
			ps1.setString(1, gameEvent.getLanguage());
			ps1.setFloat(2, gameEvent.getTicket_cost());
			ps1.setInt(3, gameEvent.getEvent_id());

			System.out.println("query fired = " + ps1.toString());

			int affectedRows1 = ps1.executeUpdate();

			if (affectedRows1 == 0) {
				throw new SQLException("Update Event failed, no rows affected.");
			}

			String query2 = "UPDATE game SET game_name=? , teams=? WHERE game_id=?";
			PreparedStatement ps2 = connection.prepareStatement(query2);
			ps2.setString(1, gameEvent.getGame_name());
			ps2.setString(2, gameEvent.getTeams());
			ps2.setInt(3, gameEvent.getGame_id());

			System.out.println("query fired = " + ps2.toString());

			int affectedRows2 = ps2.executeUpdate();

			if (affectedRows2 == 0) {
				throw new SQLException("Update Game failed, no rows affected.");
			}

		} catch (Exception e) {
			throw e;
		}

	}

}
