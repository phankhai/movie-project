package com.examplespringboot.demo.Entity;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.core.annotation.Order;

@Entity(name = "cinemas")
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Tên Không Để Trống")
	private String name;
	@NotBlank(message = "Địa Chỉ Không Để Trống")
	private String address;
	
	@Column(length = 20)
	private String phone;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "cineplex_id")
	private int cineplexId;
	
	private String image;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cineplex_id", insertable = false, updatable = false)
	private Cineplex cineplex;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "idcinema")
	@JsonIgnore
	private Set<Cinema_Movie> cinemaMovies;

	public Cinema() {
	}
	
	public Cinema(int id, String name, String address, String phone, String description, int cineplexId, String image) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.description = description;
		this.cineplexId = cineplexId;
		this.image = image;
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

	public int getCineplexId() {
		return cineplexId;
	}

	public void setCineplexId(int cinemaId) {
		this.cineplexId = cinemaId;
	}

	public Cineplex getCineplex() {
		return cineplex;
	}

	public void setCineplex(Cineplex cineplex) {
		this.cineplex = cineplex;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Cinema_Movie> getCinemaMovies() {
		return cinemaMovies;
	}

	public void setCinemaMovies(Set<Cinema_Movie> cinemaMovies) {
		this.cinemaMovies = cinemaMovies;
	}
}
