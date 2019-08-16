package com.examplespringboot.demo.Entity;

import org.hibernate.annotations.OrderBy;
import org.springframework.data.annotation.Transient;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "rooms")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	@NotBlank(message = "Tên phòng không để trống")
	private String name;

//	@Column(name = "seat_count")
//	@NotNull(message = "Số lượng không để trống")
//	@DecimalMin(value = "20", message = "Điểm không hợp lệ")
//	@DecimalMax(value = "400", message = "Số lượng không hợp lệ")
//	private int seatCount;

	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name = "idroom")
	Set<CinemaMovie_Room> cinemaMovie_rooms;

	public Room() {
	}

	public Room(int id, String name, int seatCount, int cinemaId) {
		super();
		this.id = id;
		this.name = name;
	}

	public Set<CinemaMovie_Room> getCinemaMovie_rooms() {
		return cinemaMovie_rooms;
	}

	public void setCinemaMovie_rooms(Set<CinemaMovie_Room> cinemaMovie_rooms) {
		this.cinemaMovie_rooms = cinemaMovie_rooms;
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

}
