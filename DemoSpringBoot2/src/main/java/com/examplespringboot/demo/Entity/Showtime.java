package com.examplespringboot.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity(name = "showtimes")
public class Showtime {
	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "open_date")
	@Temporal(TemporalType.DATE)
	private Date openDate;
	
	@Column(name = "open_hours")
	@Temporal(TemporalType.TIME)
	private Date openHours;
	
	private float price;

	@OneToOne
	@JoinColumn(name = "idcinemamovie_room")
	CinemaMovie_Room cinemaMovie_room;

	@OneToMany
	@JoinColumn(name = "idshowtime")
	@JsonIgnore
	Set<Seat> seats;

	public Showtime() {}

	public Showtime(int id, Date openDate, Date openHours, float price, int movieTime, int roomId, int movieId) {
		super();
		this.id = id;
		this.openDate = openDate;
		this.openHours = openHours;
		this.price = price;
	}

	public void setOpenHours(Date openHours) {
		this.openHours = openHours;
	}

	public CinemaMovie_Room getCinemaMovie_room() {
		return cinemaMovie_room;
	}

	public void setCinemaMovie_room(CinemaMovie_Room cinemaMovie_room) {
		this.cinemaMovie_room = cinemaMovie_room;
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getOpenHours() {
		return openHours;
	}

	public void setOpenHours(Time openHours) {
		this.openHours = openHours;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
