package dto;

public class ConcertEvent {
	
	int event_id;
	String language;
	float ticket_cost;
	String username;
	int concert_id;
	String artist; 
	String type;
	int hosted_id;
	String hosted_date;
	int venue_id;
	String start_time;
	String end_time;
	
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public float getTicket_cost() {
		return ticket_cost;
	}
	public void setTicket_cost(float ticket_cost) {
		this.ticket_cost = ticket_cost;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getConcert_id() {
		return concert_id;
	}
	public void setConcert_id(int concert_id) {
		this.concert_id = concert_id;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHosted_id() {
		return hosted_id;
	}
	public void setHosted_id(int hosted_id) {
		this.hosted_id = hosted_id;
	}
	public String getHosted_date() {
		return hosted_date;
	}
	public void setHosted_date(String hosted_date) {
		this.hosted_date = hosted_date;
	}
	public int getVenue_id() {
		return venue_id;
	}
	public void setVenue_id(int venue_id) {
		this.venue_id = venue_id;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
}
