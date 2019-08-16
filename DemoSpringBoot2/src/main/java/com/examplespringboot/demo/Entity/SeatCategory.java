package com.examplespringboot.demo.Entity;

import java.util.Set;

import javax.persistence.*;

@Entity(name = "seat_categories")
public class SeatCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idseat")
	private Set<Seat> seats;
	
	public SeatCategory() {
	}

	public SeatCategory(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}
}
