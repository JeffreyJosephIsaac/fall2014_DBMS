package dto;

public class BookingTransaction {
	
	Bookings bookings;
	Transactions transactions;
	
	public Bookings getBookings() {
		return bookings;
	}
	public void setBookings(Bookings bookings) {
		this.bookings = bookings;
	}
	public Transactions getTransactions() {
		return transactions;
	}
	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}
}
