package com.examplespringboot.demo.Entity;

import java.util.Set;

import javax.persistence.*;

@Entity(name = "seats")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;

	@OneToOne
	@JoinColumn(name = "idseat")
	SeatCategory seatCategory;

	@OneToOne
	@JoinColumn(name = "idshowtime")
	Showtime showtime;

	public Seat() {
	}

	public Seat(int id, String name, String description, int roomId, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
