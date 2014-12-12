package webServices;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.ProjectManager;

import com.google.gson.Gson;

import dto.BookingTransaction;
import dto.Bookings;
import dto.ConcertEvent;
import dto.Event_Organizer;
import dto.GameEvent;
import dto.Hosted;
import dto.MovieEvent;
import dto.Transactions;
import dto.User;
import dto.Venue;

@Path("/BookingService")
public class BookingService {

	//Service 2
	@GET
	@Path("/GetMovies")
	@Produces("application/json")
	public String getMovies(){
		String movies = null;
		try{
			ProjectManager projectManager= new ProjectManager();
			ArrayList<MovieEvent> movie = projectManager.getMovies();
			Gson gson = new Gson();
			movies = gson.toJson(movie);
			System.out.println("Movies = "+movies);
			return movies;
		}
		catch(Exception e){
			e.printStackTrace();
			return movies;
		}
	}
	
	//Service 3
	@GET
	@Path("/GetConcerts")
	@Produces("application/json")
	public String getConcerts(){
		String concerts = null;
		try{
			ProjectManager projectManager= new ProjectManager();
			ArrayList<ConcertEvent> concert = projectManager.getConcerts();
			Gson gson = new Gson();
			concerts = gson.toJson(concert);
			System.out.println("Concerts = "+concert);
			return concerts;
		}
		catch(Exception e){
			e.printStackTrace();
			return concerts;
		}
	}
	
	//Service 4
	@GET
	@Path("/GetGames")
	@Produces("application/json")
	public String getGames(){
		String games = null;
		try{
			ProjectManager projectManager= new ProjectManager();
			ArrayList<GameEvent> game = projectManager.getGames();
			Gson gson = new Gson();
			games = gson.toJson(game);
			System.out.println("Games = "+games);
			return games;
		}
		catch(Exception e){
			e.printStackTrace();
			return games;
		}
	}
	
	//Service 20
	@GET
	@Path("/GetVenues")
	@Produces("application/json")
	public String getVenues(){
		String venues = null;
		try{
			ProjectManager projectManager= new ProjectManager();
			ArrayList<Venue> venue = projectManager.getVenues();
			Gson gson = new Gson();
			venues = gson.toJson(venue);
			System.out.println("Venues = "+venues);
			return venues;
		}
		catch(Exception e){
			e.printStackTrace();
			return venues;
		}
	}
	
	//Service 15
	@GET
    @Path("/updateConcert/{event_id}/{concert_id}/{artist}/{ticket_cost}/{username}/{type}/{language}")
    @Produces("application/json")
    public void updateConcert(@PathParam("event_id") int event_id,
            @PathParam("concert_id") int concert_id,
            @PathParam("artist") String artist,
            @PathParam("ticket_cost") float ticket_cost, 
            @PathParam("username") String username,
            @PathParam("type") String type,
            @PathParam("language") String language)
    {
        System.out.println("updating Movie");
    
        try 
        {
        	ConcertEvent concertEvent = new ConcertEvent();
        	concertEvent.setEvent_id(event_id);
        	concertEvent.setConcert_id(concert_id);
        	concertEvent.setLanguage(language);
        	concertEvent.setArtist(artist);
            concertEvent.setTicket_cost(ticket_cost);
            concertEvent.setUsername(username);
            concertEvent.setType(type);

            System.out.println("Language: " + language);
            System.out.println("ticket_cost: " + ticket_cost);
            System.out.println("username: " + username);
            System.out.println("artist: " + artist);
            System.out.println("type: " + type);
            System.out.println("event_id: " + event_id);
            System.out.println("concert_id: " + concert_id);
            ProjectManager projectManager= new ProjectManager();
            projectManager.updateConcert(concertEvent);
        }
        
        catch (Exception e) {
            System.out.println("Exception Error"+e); //Console 
        }
    }
	
	// Service 11a
	@GET
	@Path("/getMovieEvents/{userId}")
	@Produces("application/json")
	public String getMovieEvents(@PathParam("userId") String userId)
	{
		System.out.println("Get Events");
		String movieEventsString = null;
		try 
		{
			System.out.println("UserId: " + userId);
			ArrayList<MovieEvent> movieEvents = null;
			ProjectManager projectManager= new ProjectManager();
			movieEvents = projectManager.getMovieEvents(userId);
			Gson gson = new Gson();
			System.out.println("Converted to JSON");
			movieEventsString = gson.toJson(movieEvents);
			System.out.println(movieEventsString);
		}
		
		catch (Exception e)
		{
			System.out.println("Exception Error"+e); //Console 
		}
		return movieEventsString;
	}
	
	// Service 11b
	@GET
	@Path("/getConcertEvents/{userId}")
	@Produces("application/json")
	public String getConcertEvents(@PathParam("userId") String userId)
	{
		System.out.println("Get Events");
		String concertEventsString = null;
		try 
		{
			System.out.println("UserId: " + userId);
			ArrayList<ConcertEvent> concertEvents = null;
			ProjectManager projectManager= new ProjectManager();
			concertEvents = projectManager.getConcertEvents(userId);
			Gson gson = new Gson();
			System.out.println("Converted to JSON");
			concertEventsString = gson.toJson(concertEvents);
			System.out.println(concertEventsString);
		}
		
		catch (Exception e)
		{
			System.out.println("Exception Error"+e); //Console 
		}
		return concertEventsString;
	}
	
	
	// Service 11c
	@GET
	@Path("/getGameEvents/{userId}")
	@Produces("application/json")
	public String getGameEvents(@PathParam("userId") String userId)
	{
		System.out.println("Get Events");
		String gameEventsString = null;
		try 
		{
			System.out.println("UserId: " + userId);
			ArrayList<GameEvent> gameEvents = null;
			ProjectManager projectManager= new ProjectManager();
			gameEvents = projectManager.getGameEvents(userId);
			Gson gson = new Gson();
			System.out.println("Converted to JSON");
			gameEventsString = gson.toJson(gameEvents);
			System.out.println(gameEventsString);
		}
		
		catch (Exception e)
		{
			System.out.println("Exception Error"+e); //Console 
		}
		return gameEventsString;
	}
	
	// Service 8
	@GET
	@Path("/createMovie/{language}/{ticket_cost}/{username}/{movie_name}/{cast}/{release_date}/{rating}/{hosted_date}/{venue_id}/{start_time}/{end_time}")
	@Produces("application/json")
	public void createMovie(@PathParam("language") String language,
			@PathParam("ticket_cost") float ticket_cost, 
			@PathParam("username") String username,
			@PathParam("movie_name") String movie_name,
			@PathParam("cast") String cast, 
			@PathParam("release_date") String release_date,
			@PathParam("rating") int rating,
			@PathParam("hosted_date") String hosted_date,
			@PathParam("venue_id") int venue_id, 
			@PathParam("start_time") String start_time,
			@PathParam("end_time") String end_time) {
		System.out.println("Create Movie");
		try 
		{
			MovieEvent movieEvent = new MovieEvent();
			movieEvent.setLanguage(language);
			movieEvent.setMovie_name(movie_name);
			movieEvent.setRating(rating);
			movieEvent.setRelease_date(release_date);
			movieEvent.setTicket_cost(ticket_cost);
			movieEvent.setUsername(username);
			movieEvent.setCast(cast);
			
			// ADD THIS
			Hosted hostedMovieEvent = new Hosted();
			hostedMovieEvent.setHosted_date(hosted_date);
			hostedMovieEvent.setVenue_id(venue_id);
			hostedMovieEvent.setStart_time(start_time);
			hostedMovieEvent.setEnd_time(end_time);
			
			System.out.println("Language: " + language);
			System.out.println("ticket_cost: " + ticket_cost);
			System.out.println("username: " + username);
			System.out.println("movie_name: " + movie_name);
			System.out.println("cast: " + cast);
			System.out.println("release_date: " + release_date);
			System.out.println("rating: " + rating);
			
			//ADD THIS
			System.out.println("hosted_date: " + hosted_date);
			System.out.println("venue_id: " + venue_id);
			System.out.println("start_time: " + start_time);
			System.out.println("end_time: " + end_time);
			
			ProjectManager projectManager= new ProjectManager();
			
			// CHANGE THIS
			projectManager.createMovie(movieEvent, hostedMovieEvent);
		}
		
		catch (Exception e) {
			System.out.println("Exception Error"+e); //Console 
		}
	}
	
	// Service 9
	@GET
	@Path("/createConcert/{language}/{ticket_cost}/{username}/{artist}/{type}/{hosted_date}/{venue_id}/{start_time}/{end_time}")
	@Produces("application/json")
	public void createConcert(@PathParam("language") String language,
			@PathParam("ticket_cost") float ticket_cost, 
			@PathParam("username") String username,
			@PathParam("artist") String artist,
			@PathParam("type") String type,
			@PathParam("hosted_date") String hosted_date,
			@PathParam("venue_id") int venue_id, 
			@PathParam("start_time") String start_time,
			@PathParam("end_time") String end_time) {
		System.out.println("Create Concert");
		try {
			ConcertEvent concertEvent = new ConcertEvent();
			concertEvent.setLanguage(language);
			concertEvent.setArtist(artist);
			concertEvent.setType(type);
			concertEvent.setTicket_cost(ticket_cost);
			concertEvent.setUsername(username);
			
			// ADD THIS
			Hosted hostedMovieEvent = new Hosted();
			hostedMovieEvent.setHosted_date(hosted_date);
			hostedMovieEvent.setVenue_id(venue_id);
			hostedMovieEvent.setStart_time(start_time);
			hostedMovieEvent.setEnd_time(end_time);
			
			System.out.println("Language: " + language);
			System.out.println("ticket_cost: " + ticket_cost);
			System.out.println("username: " + username);
			System.out.println("artist: " + artist);
			System.out.println("type: " + type);
			ProjectManager projectManager= new ProjectManager();
			projectManager.createConcert(concertEvent, hostedMovieEvent);
		}
		
		catch (Exception e) {
			System.out.println("Exception Error"+e); //Console 
		}
	}
	
	// Service 10
	@GET
	@Path("/createGame/{language}/{ticket_cost}/{username}/{game_name}/{teams}/{hosted_date}/{venue_id}/{start_time}/{end_time}")
	@Produces("application/json")
	public void createGame(@PathParam("language") String language,
			@PathParam("ticket_cost") float ticket_cost, 
			@PathParam("username") String username,
			@PathParam("game_name") String game_name,
			@PathParam("teams") String teams,
			@PathParam("hosted_date") String hosted_date,
			@PathParam("venue_id") int venue_id, 
			@PathParam("start_time") String start_time,
			@PathParam("end_time") String end_time) {
		System.out.println("Create Game");
		try {
			GameEvent gameEvent = new GameEvent();
			gameEvent.setLanguage(language);
			gameEvent.setGame_name(game_name);
			gameEvent.setTeams(teams);
			gameEvent.setTicket_cost(ticket_cost);
			gameEvent.setUsername(username);
			
			// ADD THIS
			Hosted hostedMovieEvent = new Hosted();
			hostedMovieEvent.setHosted_date(hosted_date);
			hostedMovieEvent.setVenue_id(venue_id);
			hostedMovieEvent.setStart_time(start_time);
			hostedMovieEvent.setEnd_time(end_time);
			
			
			System.out.println("Language: " + language);
			System.out.println("ticket_cost: " + ticket_cost);
			System.out.println("username: " + username);
			System.out.println("game_name: " + game_name);
			System.out.println("teams: " + teams);
			//ADD THIS
			System.out.println("hosted_date: " + hosted_date);
			System.out.println("venue_id: " + venue_id);
			System.out.println("start_time: " + start_time);
			System.out.println("end_time: " + end_time);
			ProjectManager projectManager= new ProjectManager();
			projectManager.createGame(gameEvent, hostedMovieEvent);
		}
		
		catch (Exception e) {
			System.out.println("Exception Error"+e); //Console 
		}
	}
	
	@GET
	@Path("/createOrganizer/{username}/{password}/{name}/{email_id}/{company_name}/{created_by}")
	@Produces("application/json")
	public void createOrganizer(@PathParam("username") String username,
			@PathParam("password") String password, 
			@PathParam("name") String name,
			@PathParam("email_id") String email_id,
			@PathParam("company_name") String company_name,
			@PathParam("created_by") String created_by) {
		System.out.println("Create Organizer");
		try {
			Event_Organizer eventOrganizer = new Event_Organizer();
			eventOrganizer.setUsername(username);
			eventOrganizer.setPassword(password);
			eventOrganizer.setName(name);
			eventOrganizer.setEmail_id(email_id);
			eventOrganizer.setCompany_name(company_name);
			eventOrganizer.setCreated_by(created_by);
			
			System.out.println("username: " + username);
			System.out.println("password: " + password);
			System.out.println("name: " + name);
			System.out.println("email_id: " + email_id);
			System.out.println("company_name: " + company_name);
			System.out.println("created_by: " + created_by);
			
			ProjectManager projectManager= new ProjectManager();
			projectManager.createOrganizer(eventOrganizer);
		}
		
		catch (Exception e) {
			System.out.println("Exception Error"+e); //Console 
		}
	}
		
		@GET
		@Path("/GetTransactions")
		@Produces("application/json")
		public String GetTransactions()
		{
			System.out.println("first");
			String feeds = null;
			try 
			{
				ArrayList<Transactions> transactionsData = null;
				ProjectManager projectManager= new ProjectManager();
				transactionsData = projectManager.GetTransactions();
				Gson gson = new Gson();
				System.out.println("Checking");
				System.out.println(gson.toJson(transactionsData));
				feeds = gson.toJson(transactionsData);
			}
			
			catch (Exception e)
			{
				System.out.println("Exception Error"+e); //Console 
			}
			return feeds;
		}

		@GET
		@Path("/DeleteEvent/{event_id}")
		@Produces("application/json")
		public void DeleteEvent(@PathParam("event_id") int event_id) 
		{
			System.out.println(" In Delete Event");
			System.out.println("Event id:"+event_id);
			try 
			{
				ProjectManager projectManager = new ProjectManager();
				projectManager.DeleteEvent(event_id);
			}
			catch (Exception e)
			{
				System.out.println("Exception Error"+e); //Console 
			}
		}
		
		@GET
		@Path("/DeleteBookings/{booking_id}")
		@Produces("application/json")
		public void DeleteBookings(@PathParam("booking_id") int booking_id) 
		{
			System.out.println(" In Delete Bookings");
			System.out.println("booking_id:"+booking_id);
			try 
			{
				ProjectManager projectManager = new ProjectManager();
				projectManager.DeleteBookings(booking_id);
			}
			catch (Exception e)
			{
				System.out.println("Exception Error"+e); //Console 
			}
		}

		@GET
		@Path("/createBookings/{from_account}/{from_bank}/{to_account}/"
				+ "{to_bank}/{amount}/{no_of_tickets}/{username}/{event_id}")
		@Produces("application/json")
		public void createBookings(@PathParam("from_account") int from_account,
				@PathParam("from_bank") String from_bank, 
				@PathParam("to_account") int to_account,
				@PathParam("to_bank") String to_bank,
				@PathParam("amount") float amount, 
				@PathParam("no_of_tickets") int no_of_tickets,
				@PathParam("username") String username,
				@PathParam("event_id") int event_id) {
			System.out.println("Create Booking");
			try {
				BookingTransaction bookingTransaction = new BookingTransaction();
				Bookings bookings = new Bookings();
				bookings.setNo_of_tickets(no_of_tickets);
				bookings.setUsername(username);
				bookings.setEvent_id(event_id);
				Transactions transactions = new Transactions();
				transactions.setFrom_account(from_account);
				transactions.setFrom_bank(from_bank);
				transactions.setTo_account(to_account);
				transactions.setTo_bank(to_bank);
				transactions.setAmount(amount);
				bookingTransaction.setBookings(bookings);
				bookingTransaction.setTransactions(transactions);
				
				ProjectManager projectManager = new ProjectManager();
				projectManager.createBookings(bookingTransaction);
			}
			catch (Exception e) {
				System.out.println("Exception Error"+e); //Console 
			}
		}
		
		@GET
		@Path("/multipleParamTest/{name}/{age}/{gender}")
		@Produces("application/json")
		public String multipleParamTest(@PathParam("name") String name,
				@PathParam("age") int age, 
				@PathParam("gender") String gender)
		{
			System.out.println("Multiple Attempt");
			String feeds = null;
			try 
			{
				System.out.println("Name: " + name);
				System.out.println("Age: " + age);
				System.out.println("Gender: " + gender);
			}
			
			catch (Exception e)
			{
				System.out.println("Exception Error"+e); //Console 
			}
			return feeds;
		}
	    
		//1
	    @GET
	    @Path("/login/{username}/{password}")
	    @Produces("application/json")
	    public String authenticateUser(@PathParam("username") String username,
	                                    @PathParam("password") String password)
	    {
	        String jsonString = null;
	        User user = new User();
	        try
	        {
	            System.out.println("User Name sent: " + username);
	            System.out.println("password sent: " + password);
	            
				ProjectManager projectManager= new ProjectManager();
				user = projectManager.authenticateUser(username, password);
				Gson gson = new Gson();
				jsonString = gson.toJson(user);
				System.out.println(jsonString);
				
				if(user!=null)
				{
					System.out.println("found user: " + user.getUsername() + " of type: " + user.getUserType());
				}
				else
					System.out.println("no user found");

	        }
	        
	        catch (Exception e)
	        {
	            System.out.println("Exception "+e); //Console 
	        }
	        return jsonString;
	    }
	    
	    //5
	    @GET
	    @Path("/bookings/{username}")
	    @Produces("application/json")
	    public String getBookings(@PathParam("username") String username)
	    {
	        String jsonString = null;
	        try
	        {
	            System.out.println("User Name sent: " + username);
				ProjectManager projectManager= new ProjectManager();
							
				HashMap<String, ArrayList> bookingsList = new HashMap<String, ArrayList>();
				bookingsList = projectManager.getBookings(username);
				Gson gson = new Gson();
				jsonString = gson.toJson(bookingsList);
				System.out.println(jsonString);
	        }
	        
	        catch (Exception e)
	        {
	            System.out.println("Exception "+e); //Console 
	        }
	        
	        return jsonString;
	    }
	    
	    //19
	    @GET
	    @Path("/allBookings")
	    @Produces("application/json")
	    public String getAllBookings()
	    {
	        String jsonString = null;
	        try
	        {
				ProjectManager projectManager= new ProjectManager();						
				HashMap<String, ArrayList> bookingsList = new HashMap<String, ArrayList>();
				bookingsList = projectManager.getAllBookings();
				Gson gson = new Gson();
				jsonString = gson.toJson(bookingsList);
				System.out.println(jsonString);
	        }
	        
	        catch (Exception e)
	        {
	            System.out.println("Exception "+e);  
	        }
	        
	        return jsonString;
	    }
	    
	    @GET
		@Path("/updateMovie/{event_id}/{movie_id}/{language}/{ticket_cost}/{username}/{movie_name}/{cast}/{release_date}/{rating}")
		@Produces("application/json")
		public void updateMovie(@PathParam("event_id") int event_id,
				@PathParam("movie_id") int movie_id,
				@PathParam("language") String language,
				@PathParam("ticket_cost") float ticket_cost, 
				@PathParam("username") String username,
				@PathParam("movie_name") String movie_name,
				@PathParam("cast") String cast, 
				@PathParam("release_date") String release_date,
				@PathParam("rating") int rating) 
	    {
			System.out.println("updating Movie");
		
			try 
			{
				MovieEvent movieEvent = new MovieEvent();
				movieEvent.setEvent_id(event_id);
				movieEvent.setMovie_id(movie_id);
				movieEvent.setLanguage(language);
				movieEvent.setMovie_name(movie_name);
				movieEvent.setRating(rating);
				movieEvent.setRelease_date(release_date);
				movieEvent.setTicket_cost(ticket_cost);
				movieEvent.setUsername(username);
				movieEvent.setCast(cast);

				System.out.println("Language: " + language);
				System.out.println("ticket_cost: " + ticket_cost);
				System.out.println("username: " + username);
				System.out.println("movie_name: " + movie_name);
				System.out.println("cast: " + cast);
				System.out.println("release_date: " + release_date);
				System.out.println("rating: " + rating);
				ProjectManager projectManager= new ProjectManager();
				projectManager.updateMovie(movieEvent);
			}
			
			catch (Exception e) {
				System.out.println("Exception Error"+e); //Console 
			}
		}
	    
	    @GET
		@Path("/updateGame/{event_id}/{game_id}/{language}/{ticket_cost}/{username}/{game_name}/{teams}")
		@Produces("application/json")
		public void updateGame(@PathParam("event_id") int event_id,
				@PathParam("game_id") int game_id,
				@PathParam("language") String language,
				@PathParam("ticket_cost") float ticket_cost, 
				@PathParam("username") String username,
				@PathParam("game_name") String game_name,
				@PathParam("teams") String teams) 
	    {
			System.out.println("updating Game");
		
			try 
			{
				GameEvent gameEvent = new GameEvent();
				gameEvent.setEvent_id(event_id);
				gameEvent.setGame_id(game_id);
				gameEvent.setLanguage(language);
				gameEvent.setGame_name(game_name);
				gameEvent.setTeams(teams);
				gameEvent.setTicket_cost(ticket_cost);
				gameEvent.setUsername(username);
				
				System.out.println("Language: " + language);
				System.out.println("ticket_cost: " + ticket_cost);
				System.out.println("username: " + username);
				System.out.println("game_name: " + game_name);
				System.out.println("teams: " + teams);
				
				ProjectManager projectManager= new ProjectManager();
				projectManager.updateGame(gameEvent);
			}
			
			catch (Exception e) {
				System.out.println("Exception Error"+e); //Console 
			}
		}

}
