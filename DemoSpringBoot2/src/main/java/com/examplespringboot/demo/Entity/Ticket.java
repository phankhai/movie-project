package com.examplespringboot.demo.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "tickets")
public class Ticket {

	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY)
	private int id;
	private float total;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "booking_date")
	private Date bookingDate;
	
	@Column(name = "showtime_id")
	private int showtimeId;
	
	@Column(name = "seat_id")
	private int seatId;
	
	@Column(name = "user_id")
	private String userId;
	
	@ManyToOne
	@JoinColumn(name = "showtime_id", insertable = false, updatable = false)
	private Showtime showtime;
	
	@ManyToOne
	@JoinColumn(name = "seat_id", insertable = false, updatable = false)
	private Seat seat;
	
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	
	public Ticket() {}

	public Ticket(int id, float total, Date bookingDate, int showtimeId, int seatId, String userId) {
		super();
		this.id = id;
		this.total = total;
		this.bookingDate = bookingDate;
		this.showtimeId = showtimeId;
		this.seatId = seatId;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Showtime getShowtime() {
		return showtime;
	}

	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
